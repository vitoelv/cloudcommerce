package com.jcommerce.gwt.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.HeadElement;
import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.HistoryListener;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.jcommerce.gwt.client.Application.ApplicationListener;
import com.jcommerce.gwt.client.model.BeanObject;
import com.jcommerce.gwt.client.panels.AttributeInfo;
import com.jcommerce.gwt.client.panels.BrandInfo;
import com.jcommerce.gwt.client.panels.CategoryInfo;
import com.jcommerce.gwt.client.panels.CommentInfo;
import com.jcommerce.gwt.client.panels.EditMemberInfo;
import com.jcommerce.gwt.client.panels.GoodsList;
import com.jcommerce.gwt.client.panels.GoodsTypeInfo;
import com.jcommerce.gwt.client.panels.MemberAddresses;
import com.jcommerce.gwt.client.panels.MemberList;
import com.jcommerce.gwt.client.panels.NewAttribute;
import com.jcommerce.gwt.client.panels.NewBrand;
import com.jcommerce.gwt.client.panels.NewCategory;
import com.jcommerce.gwt.client.panels.NewGoodsType;
import com.jcommerce.gwt.client.panels.NewOrders;
import com.jcommerce.gwt.client.panels.NewUsers;
import com.jcommerce.gwt.client.panels.OrderInfo;
import com.jcommerce.gwt.client.panels.OrderList;
import com.jcommerce.gwt.client.panels.OrderStatistics;
import com.jcommerce.gwt.client.panels.ShopSetup;
import com.jcommerce.gwt.client.panels.Success;
import com.jcommerce.gwt.client.panels.UserComments;
import com.jcommerce.gwt.client.panels.goods.NewGoods;
import com.jcommerce.gwt.client.panels.leontest.AttributeListPanel;
import com.jcommerce.gwt.client.panels.leontest.AttributePanel;
import com.jcommerce.gwt.client.panels.leontest.GoodsTypeListPanel;
import com.jcommerce.gwt.client.panels.leontest.GoodsTypePanel;
import com.jcommerce.gwt.client.panels.leontest.GoodsTypePanel2;
import com.jcommerce.gwt.client.panels.leontest.PageState;
import com.jcommerce.gwt.client.panels.leontest.PaymentMetaList;
import com.jcommerce.gwt.client.panels.leontest.PaymentMetaPanel;
import com.jcommerce.gwt.client.resources.IShopConstants;
import com.jcommerce.gwt.client.resources.Resources;
import com.jcommerce.gwt.client.service.RemoteService;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class iShop implements EntryPoint {
    public static String CUR_THEME = IShopConstants.STYLE_THEMES[0];
    
    private static iShop me;
    
    /**
     * A special version of the ToggleButton that cannot be clicked if down. If
     * one theme button is pressed, all of the others are depressed.
     */
    private static class ThemeButton extends ToggleButton {
        private static List<ThemeButton> allButtons = null;

        private String theme;

        public ThemeButton(String theme) {
            super();
            this.theme = theme;
            addStyleName("sc-ThemeButton-" + theme);

            // Add this button to the static list
            if (allButtons == null) {
                allButtons = new ArrayList<ThemeButton>();
                setDown(true);
            }
            allButtons.add(this);
        }

        public String getTheme() {
            return theme;
        }

        @Override
        protected void onClick() {
            if (!isDown()) {
                // Raise all of the other buttons
                for (ThemeButton button : allButtons) {
                    if (button != this) {
                        button.setDown(false);
                    }
                }

                // Fire the click listeners
                super.onClick();
            }
        }
    }

    Button exitButton = new Button();
    
    /**
     * Get the URL of the page, without an hash of query string.
     * 
     * @return the location of the page
     */
    private static native String getHostPageLocation()
    /*-{
     var s = $doc.location.href;
     
     // Pull off any hash.
     var i = s.indexOf('#');
     if (i != -1)
     s = s.substring(0, i);
     
     // Pull off any query string.
     i = s.indexOf('?');
     if (i != -1)
     s = s.substring(0, i);
     
     // Ensure a final slash if non-empty.
     return s;
     }-*/;

    /**
     * The {@link Application}.
     */
    private Application app = new Application();

    /**
     * A mapping of history tokens to their associated menu items.
     */
    private Map<String, TreeItem> pageClassItems = new HashMap<String, TreeItem>();
    /**
     * A mapping of menu items to the widget display when the item is selected.
     */
   
    private Map<TreeItem, PageState> itemStates = new HashMap<TreeItem, PageState>();
  
    public Map<String, ContentWidget> pageRegistry = new HashMap<String, ContentWidget>();
    
    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
		me = this;
		GWT.setUncaughtExceptionHandler(new GWT.UncaughtExceptionHandler() {

			public void onUncaughtException(Throwable e) {
				Window.alert("error: " + e.getMessage());
			}

		});
		final HistoryListener hyperLinkHandler = new HistoryListener() {
			public void onHistoryChanged(String fullHistoryToken) {
				try {
					System.out.println("--- hyperLinkHandler");
					String[] parsed = PageState
							.parseFullHistoryToken(fullHistoryToken);
					String pageClassName = parsed[0];
					String stateStr = parsed[1];
					System.out.println("pageClassStr: " + pageClassName
							+ ", stateStr: " + stateStr);

					TreeItem item = pageClassItems.get(pageClassName);
					System.out.println("item: " + item);
					if (item != null) {
						app.getMainMenu().setSelectedItem(item, false);
						app.getMainMenu().ensureSelectedItemVisible();
					}

					ContentWidget page = getPage(pageClassName);

					if (page != null) {
						PageState state = page.getCurState();
						if (state != null) {
							state.fromHistoryToken(stateStr);
						}
						displayContentWidget(page);
					}

				} catch (Exception ex) {
					ex.printStackTrace();
					throw new RuntimeException(ex);
				}
			}
		};
		History.addHistoryListener(hyperLinkHandler);

		RemoteService.init();

		// Generate the source code and css for the examples
		// GWT.create(GeneratorInfo.class);

		// Swap out the style sheets for the RTL versions if needed.
		// updateStyleSheets();

		// Create the application
		setupTitlePanel();
		setupMainLinks();
		setupOptionsPanel();
		setupMainMenu();
		setupNavigationPanel();

		app.setListener(new ApplicationListener() {
			public void onMenuItemSelected(TreeItem item) {
				PageState state = itemStates.get(item);
				// && !content.equals(app.getContent())
				if (state != null) {
					state.execute();
				}
			}
		});
		// need add app first, to ensure the other widgets to be rendered when
		// added to app
		RootPanel.get().add(app);

		String initToken = History.getToken();
		if (initToken.length() > 0) {
			// historyListener.onHistoryChanged(initToken);
			History.newItem(initToken);
		} else {
			// Use the first token available
			TreeItem firstItem = app.getMainMenu().getItem(0).getChild(0);
			PageState state = itemStates.get(firstItem);
			if (state != null)
				state.execute();
		}
	}

	// ensure all instances be created and put in pageRegistry when first-time
	// accessed
	// and all following access will retrieve the cached instance in
	// pageRegistry
	public ContentWidget getPage(String pageClassName) {
		ContentWidget page = null;
		page = pageRegistry.get(pageClassName);
		if (page == null) {
			// TODO use GWT.create to allow plugin of different implementation?
			// what's the condition?
			// TODO have a generator to generate these codes based on all page
			// classes we have in project
			if (pageClassName.equals(NewGoods.class.getName())) {
				// page = (ContentWidget)GWT.create(GoodsTypeList.class);
				page = new NewGoods();
			} else if (pageClassName.equals(AttributePanel.class.getName())) {
				page = AttributePanel.getInstance();
			} else if (pageClassName.equals(AttributeListPanel.class.getName())) {
				page = AttributeListPanel.getInstance();
			} else if (pageClassName.equals(GoodsTypePanel.class.getName())) {
				page = GoodsTypePanel.getInstance();
			} else if (pageClassName.equals(GoodsTypePanel2.class.getName())) {
				page = new GoodsTypePanel2();				
			} else if (pageClassName.equals(GoodsTypeListPanel.class.getName())) {
				page = GoodsTypeListPanel.getInstance();
			} else if (pageClassName.equals(PaymentMetaList.class.getName())) {
				page = PaymentMetaList.getInstance();
			} else if (pageClassName.equals(PaymentMetaPanel.class.getName())) {
				page = PaymentMetaPanel.getInstance();
			} else if (pageClassName.equals(AttributeInfo.class.getName())) {
				page = new AttributeInfo();
			}

			else if (pageClassName.equals(BrandInfo.class.getName())) {
				page = new BrandInfo();
			} else if (pageClassName.equals(CategoryInfo.class.getName())) {
				page = new CategoryInfo();
			} else if (pageClassName.equals(CommentInfo.class.getName())) {
				page = new CommentInfo();
			} else if (pageClassName.equals(GoodsList.class.getName())) {
				page = new GoodsList();
			} else if (pageClassName.equals(GoodsTypeInfo.class.getName())) {
				page = new GoodsTypeInfo();
			} else if (pageClassName.equals(NewAttribute.class.getName())) {
				page = new NewAttribute();
			} else if (pageClassName.equals(NewBrand.class.getName())) {
				page = NewBrand.getInstance();
			}

			else if (pageClassName.equals(NewCategory.class.getName())) {
				page = NewCategory.getInstance();
			} else if (pageClassName.equals(NewGoodsType.class.getName())) {
				page = new NewGoodsType();
			} else if (pageClassName.equals(NewOrders.class.getName())) {
				page = new NewOrders();
			} else if (pageClassName.equals(NewUsers.class.getName())) {
				page = new NewUsers();
			} else if (pageClassName.equals(MemberList.class.getName())) {
				page = new MemberList();
			} else if (pageClassName.equals(EditMemberInfo.class.getName())) {
				page = new EditMemberInfo();
			} else if (pageClassName.equals(MemberAddresses.class.getName())) {
				page = new MemberAddresses();
			} else if (pageClassName.equals(OrderInfo.class.getName())) {
				page = new OrderInfo();
			} else if (pageClassName.equals(OrderList.class.getName())) {
				page = new OrderList();
			} else if (pageClassName.equals(OrderStatistics.class.getName())) {
				page = new OrderStatistics();
			} else if (pageClassName.equals(ShopSetup.class.getName())) {
				page = new ShopSetup();
			} else if (pageClassName.equals(Success.class.getName())) {
				page = Success.getInstance();
			} else if (pageClassName.equals(UserComments.class.getName())) {
				page = new UserComments();
			}

			if (page != null) {
				pageRegistry.put(pageClassName, page);
			} else {
				throw new RuntimeException(
						"cannot find page: "
								+ pageClassName
								+ ", a page has to be first registered in pageRegistry before being used ");
			}
		}

		return page;
	}
    
    public static iShop getInstance() {
        return me;
    }
    

// public void displaySuccessPanel(String message, String pageName,
// List<PageState> choices) {
// Success success = Success.getInstance();
// success.setMessage(message);
// success.setPageName(pageName);
// success.setChoices(choices);
// displayContentWidget(success);
// }
    
// public void displayAttributeListPanel(String selectedGoodsTypeId) {
// attributeListPanel.getCurState().setSelectedGoodsTypeID(selectedGoodsTypeId);
// displayContentWidget(attributeListPanel);
// }
    
    //显示会员收货地址
    public void displayMemberAddresses(String id){
    	MemberAddresses memberAddresses = (MemberAddresses)getPage(MemberAddresses.class.getName());
    	memberAddresses.setMember(id);
    	displayContentWidget(memberAddresses);
    }
    //显示会员列表
    public void displayMemberList(){
    	MemberList memberList = (MemberList)getPage(MemberList.class.getName());
    	displayContentWidget(memberList);
    }
    //显示会员信息
    public void displayMemberInfo(BeanObject memberInfo){
    	EditMemberInfo editMemberInfo = (EditMemberInfo)getPage(EditMemberInfo.class.getName());
    	editMemberInfo.setMemberInfo(memberInfo);
    	displayContentWidget(editMemberInfo);
    }
    
    // 显示评论详情
    public void displayCommentInfo(BeanObject comment){
    	CommentInfo commentInfo = (CommentInfo)getPage(CommentInfo.class.getName()); 
    	commentInfo.setComment(comment);
    	displayContentWidget(commentInfo);
    }
    
    // 显示新建货物或修改货物页
    public void displayGoodsPanel(BeanObject goods) {
    	NewGoods newGoods = (NewGoods)getPage(NewGoods.class.getName());
    	newGoods.setGoods(goods);
        displayContentWidget(newGoods);
    }
    
    // 显示新建属性或修改属性页
    public void displayAttribute(BeanObject attribute){    	
    	NewAttribute newAttribute = (NewAttribute)getPage(NewAttribute.class.getName()); 
    	newAttribute.setAttribute(attribute);
    	displayContentWidget(newAttribute);
    }
    
    //显示订单详细信息页
    public void displayOrderInfo(BeanObject order){    	
    	OrderInfo orderInfo = (OrderInfo)getPage(OrderInfo.class.getName());
    	orderInfo.setOrder(order);
    	displayContentWidget(orderInfo);
    }
    
    //显示新建品牌页
    public void displayNewBrand(){ 
    	NewBrand newBrand = (NewBrand)getPage(NewBrand.class.getName());
    	newBrand.setBrand(null);
    	displayContentWidget(newBrand);
    }
    
    //显示修改品牌页
    public void displayModifyBrand(BeanObject brand){    	
    	NewBrand newBrand = (NewBrand)getPage(NewBrand.class.getName());
    	newBrand.setBrand(brand);
    	displayContentWidget(newBrand);    	
    }
    
    //显示新建商品分类页
    public void displayNewCategory(){
    	NewCategory newCategory = (NewCategory)getPage(NewCategory.class.getName());
    	newCategory.setCategory(null);
    	displayContentWidget(newCategory);
    }
    
    //显示修改商品分类页
    public void displayModifyCategory(BeanObject category){    	
    	NewCategory newCategory = (NewCategory)getPage(NewCategory.class.getName());
    	newCategory.setCategory(category);
    	displayContentWidget(newCategory);    	
    }
    
    //显示新建商品类型页
    public void displayNewGoodsType(){
    	NewGoodsType newGoodsType = (NewGoodsType)getPage(NewGoodsType.class.getName());
    	newGoodsType.setGoodsType(null);
    	displayContentWidget(newGoodsType);
    }
    
    //显示修改商品类型页
    public void displayModifyGoodsType(BeanObject goodsType){    
    	NewGoodsType newGoodsType = (NewGoodsType)getPage(NewGoodsType.class.getName());
    	newGoodsType.setGoodsType(goodsType);
    	displayContentWidget(newGoodsType);    	
    } 
    
    //显示商品列表主页        
    public void displayGoodsList(){    	
    	GoodsList goodsList = (GoodsList)getPage(GoodsList.class.getName());
    	displayContentWidget(goodsList);
    }
    
    //显示属性列表主页
    public void displayAttrListPanel(String selectedGoodsTypeId) {
    	AttributeInfo attributeInfo = (AttributeInfo)getPage(AttributeInfo.class.getName());
    	attributeInfo.setSelectedGoodsTypeId(selectedGoodsTypeId);
    	displayContentWidget(attributeInfo);
    }
    
    //显示品牌列表主页
    public void displayBrandInfo(){    	
    	BrandInfo brandInfo = (BrandInfo)getPage(BrandInfo.class.getName());
    	displayContentWidget(brandInfo);
    	brandInfo.refresh();
    }
    
    //显示商品分类列表主页
    public void displayCategoryInfo(){    	
    	CategoryInfo categoryInfo = (CategoryInfo)getPage(CategoryInfo.class.getName());
    	displayContentWidget(categoryInfo);
    	categoryInfo.refresh();
    }
    
    //显示商品类型列表主页
    public void displayGoodsTypeInfo(){    	
    	GoodsTypeInfo goodsTypeInfo = (GoodsTypeInfo)getPage(GoodsTypeInfo.class.getName());
    	displayContentWidget(goodsTypeInfo);
    	goodsTypeInfo.refresh();
    }
    
    //显示订单列表主页
    public void displayOrderList(){    	
    	OrderList orderList = (OrderList)getPage(OrderList.class.getName());
    	displayContentWidget(orderList);
    	orderList.refresh();
    }
    
    //显示用户评论主页
    public void displayUserComments(){
    	UserComments userComments = (UserComments)getPage(UserComments.class.getName());
    	displayContentWidget(userComments);
    }
    
    /**
     * Set the content to the {@link ContentWidget}.
     * 
     * @param content
     *            the {@link ContentWidget} to display
     */
    private void displayContentWidget(ContentWidget content) {
        if (content != null) {
        	app.setContent(content);
            app.setContentTitle(new HTML(Resources.constants.mainTitle()+"-"+content.getName()));
            content.refresh();
        }        
    }

    /**
     * Get the token for a given content widget.
     * 
     * @return the content widget token.
     */
    public String getContentWidgetToken(ContentWidget content) {
        String className = content.getClass().getName();
//        className = className.substring(className.lastIndexOf('.') + 1);
        return className;
    }

    
    public String getURL(ContentWidget page, PageState state) {
    	return page.getClass().getName()+state.getHistoryToken();
    }
      
    
    /**
     * Get the style name of the reference element defined in the current GWT
     * theme style sheet.
     * 
     * @param prefix
     *            the prefix of the reference style name
     * @return the style name
     */
    private String getCurrentReferenceStyleName(String prefix) {
        String gwtRef = prefix + "-Reference-" + CUR_THEME;
        if (LocaleInfo.getCurrentLocale().isRTL()) {
            gwtRef += "-rtl";
        }
        return gwtRef;
    }

    /**
     * Create the main links at the top of the application.
     * 
     * @param constants
     *            the constants with text
     */
    private void setupMainLinks() {
        // Link to GWT Homepage
   	
    	app.addLink(new HTML("<a href=\"\" style=\"color: #ffffff;TEXT-DECORATION:none;\">"+ Resources.constants.mainLinkGuide() + "</a>"));		
		app.addLink(new HTML("<a href=\"\" style=\"color: #ffffff;TEXT-DECORATION:none;\">"+ Resources.constants.mainLinkNotepad() + "</a>"));
		app.addLink(new HTML("<a href=\"\" style=\"color: #ffffff;TEXT-DECORATION:none;\">"+ Resources.constants.mainLinkRefresh() + "</a>"));
		app.addLink(new HTML("<a href=\"\" style=\"color: #ffffff;TEXT-DECORATION:none;\">"+ Resources.constants.mainLinkPersonalSetting() + "</a>"));
		app.addLink(new HTML("<a href=\"\" style=\"color: #ffffff;TEXT-DECORATION:none;\">"+ Resources.constants.mainLinkComment() + "</a>"));
		app.addLink(new HTML("<a href=\"\" style=\"color: #ffffff;TEXT-DECORATION:none;\">"+ Resources.constants.mainLinkView() + "</a>"));
		app.addLink(new HTML("<a href=\"\" style=\"color: #ffffff;TEXT-DECORATION:none;\">"+ Resources.constants.mainLinkCalc() + "</a>"));
		app.addLink(new HTML("<a href=\"\" style=\"color: #ffffff;TEXT-DECORATION:none;\">"+ Resources.constants.mainLinkAbout() + "</a>"));

    }

    /**
     * Setup all of the options in the main menu.
     * 
     * @param constants
     *            the constant values to use
     */
    private void setupMainMenu() {
        Tree mainMenu = app.getMainMenu();      
        
      TreeItem catGoods = mainMenu.addItem(Resources.constants.categoryGoods());
      setupMainMenuOption(catGoods, new GoodsTypeListPanel.State(), Resources.images.catWidgets());
      setupMainMenuOption(catGoods, new GoodsList.State(), Resources.images.catWidgets());
      	setupMainMenuOption(catGoods, new BrandInfo.State(), Resources.images.catWidgets());
		setupMainMenuOption(catGoods, new NewGoods.State(), Resources.images.catWidgets());
		setupMainMenuOption(catGoods, new CategoryInfo.State(), Resources.images.catWidgets());
		setupMainMenuOption(catGoods, new UserComments.State(), Resources.images.catWidgets());		

		setupMainMenuOption(catGoods,new GoodsTypeInfo.State(),Resources.images.catWidgets());
        
		TreeItem orderForm = mainMenu.addItem(Resources.constants.categoryOrder());		
		setupMainMenuOption(orderForm, new OrderList.State(), Resources.images.catWidgets());
		setupMainMenuOption(orderForm, new NewOrders.State(), Resources.images.catWidgets());
        
		TreeItem statisticsForm = mainMenu.addItem(Resources.constants.categoryStatistics());
		setupMainMenuOption(statisticsForm,new OrderStatistics.State(),Resources.images.catWidgets());
        
		TreeItem user = mainMenu.addItem(Resources.constants.categoryMember());
		setupMainMenuOption(user, new MemberList.State(), Resources.images.catWidgets());
		setupMainMenuOption(user, new NewUsers.State(), Resources.images.catWidgets());
        
		TreeItem system = mainMenu.addItem(Resources.constants.categorySystem());
		setupMainMenuOption(system,new ShopSetup.State(),Resources.images.catWidgets());
		setupMainMenuOption(system, new PaymentMetaList.State(),Resources.images.catWidgets());        
        
        
        
//        TreeItem catGoods = mainMenu.addItem(Resources.constants.categoryGoods());
//        setupMainMenuOption(catGoods, new GoodsList(), Resources.images.catWidgets());
//        setupMainMenuOption(catGoods, new BrandInfo(), Resources.images.catWidgets());
//		setupMainMenuOption(catGoods, goodsPanel = new NewGoods(), Resources.images.catWidgets());
//		setupMainMenuOption(catGoods, new CategoryInfo(), Resources.images.catWidgets());
//		setupMainMenuOption(catGoods, new UserComments(), Resources.images.catWidgets());		
//		setupMainMenuOption(catGoods, GoodsTypeList.getInstance(), Resources.images.catWidgets());
//		setupMainMenuOption(catGoods,new GoodsTypeInfo(),Resources.images.catWidgets());
		

        
//		TreeItem orderForm = mainMenu.addItem(Resources.constants.categoryOrder());		
//		setupMainMenuOption(orderForm, new OrderList(), Resources.images.catWidgets());
//		setupMainMenuOption(orderForm, new NewOrders(), Resources.images.catWidgets());
//		TreeItem statisticsForm = mainMenu.addItem(Resources.constants.categoryStatistics());
//		setupMainMenuOption(statisticsForm,new OrderStatistics(),Resources.images.catWidgets());
//		TreeItem user = mainMenu.addItem(Resources.constants.categoryMember());
//		setupMainMenuOption(user, new NewUsers(), Resources.images.catWidgets());
//		TreeItem system = mainMenu.addItem(Resources.constants.categorySystem());
//		setupMainMenuOption(system,new ShopSetup(),Resources.images.catWidgets());
//      setupMainMenuOption(system,PaymentMetaList.getInstance(),Resources.images.catWidgets());
    }

    /**
     * Add an option to the main menu.
     * 
     * @param parent
     *            the {@link TreeItem} that is the option
     * @param content
     *            the {@link ContentWidget} to display when selected
     * @param image
     *            the icon to display next to the {@link TreeItem}
     */
//    private void setupMainMenuOption(TreeItem parent, ContentWidget content,
//            AbstractImagePrototype image) {
//        // Create the TreeItem
//        TreeItem option = parent.addItem(image.getHTML() + " "
//                + content.getName());
//
//        // Map the item to its history token and content widget
//        itemWidgets.put(option, content);
//        itemTokens.put(getContentWidgetToken(content), option);
//    }

    private void setupMainMenuOption(TreeItem parent, PageState state,
            AbstractImagePrototype image) {
        // Create the TreeItem
        TreeItem option = parent.addItem(image.getHTML() + " "
                + state.getMenuDisplayName());

        // Map the item to its history token and content widget
        itemStates.put(option, state);
        pageClassItems.put(state.getPageClassName(), option);
    }
    
    /**
     * Create the options that appear next to the title.
     */
    private void setupOptionsPanel() {
        VerticalPanel vPanel = new VerticalPanel();
        vPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
        if (LocaleInfo.getCurrentLocale().isRTL()) {
          vPanel.getElement().setAttribute("align", "left");
        } else {
          vPanel.getElement().setAttribute("align", "right");
        }
        app.setOptionsWidget(vPanel);

        // Add the option to change the locale
        final Button exitButton = new Button();       
        final Button clearButton = new Button();
        HorizontalPanel localeWrapper = new HorizontalPanel();  
        clearButton.setText(Resources.constants.mainCommandClearCache());
        clearButton.addStyleName("cl_button");
        exitButton.setText(Resources.constants.mainCommandExit());
        exitButton.addStyleName("ex_button");        
        localeWrapper.add(clearButton);
        localeWrapper.add(exitButton);
        vPanel.add(localeWrapper);
       
      }

    /**
     * Create the title bar at the top of the application.
     * 
     */
    private void setupTitlePanel() {         

        // Add the title and some images to the title bar
        HorizontalPanel titlePanel = new HorizontalPanel();
        titlePanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        titlePanel.add(Resources.images.gwtLogo().createImage());          
        app.setTitleWidget(titlePanel);
    }

    
    /**
     * Create the navigation bar at the top of the application.
     * 
     */private void setupNavigationPanel(){
    	HorizontalPanel naviPanel = new HorizontalPanel();
    	naviPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT); 
    	app.setNavigationWidget(naviPanel);
    	final Button home = new Button();    	
    	final Button setnavi = new Button();
    	final Button goodslist = new Button();
    	final Button orderlist = new Button();
    	final Button Comments = new Button();
    	final Button userList = new Button();
    	home.setText(Resources.constants.navHome());
    	setnavi.setText(Resources.constants.navSetting());
    	goodslist.setText(Resources.constants.navGoodsList());
    	orderlist.setText(Resources.constants.navOrderList());
    	Comments.setText(Resources.constants.navComment());
    	userList.setText(Resources.constants.navMemberList());
    	home.addStyleName("Nav_button");
    	setnavi.addStyleName("Nav_button");
    	goodslist.addStyleName("Nav_button");
    	orderlist.addStyleName("Nav_button");
    	Comments.addStyleName("Nav_button");
    	userList.addStyleName("Nav_button");
    	naviPanel.add(home);
    	naviPanel.add(setnavi);
    	naviPanel.add(goodslist);
    	naviPanel.add(orderlist);
    	naviPanel.add(Comments);
    	naviPanel.add(userList);    	
    }
    
    /**
     * Update the style sheets to reflect the current theme and direction.
     */
    private void updateStyleSheets() {
        // Generate the names of the style sheets to include
        String gwtStyleSheet = "gwt/" + CUR_THEME + "/" + CUR_THEME + ".css";
        String showcaseStyleSheet = CUR_THEME + "/Showcase.css";
        if (LocaleInfo.getCurrentLocale().isRTL()) {
            gwtStyleSheet = gwtStyleSheet.replace(".css", "_rtl.css");
            showcaseStyleSheet = showcaseStyleSheet.replace(".css", "_rtl.css");
        }

        // Find existing style sheets that need to be removed
        boolean styleSheetsFound = false;
        // final HeadElement headElem = StyleSheetLoader.getHeadElement();
        final HeadElement headElem = null;
        final List<Element> toRemove = new ArrayList<Element>();
        NodeList<Node> children = headElem.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.getItem(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = Element.as(node);
                if (elem.getTagName().equalsIgnoreCase("link")
                        && elem.getPropertyString("rel").equalsIgnoreCase(
                                "stylesheet")) {
                    styleSheetsFound = true;
                    String href = elem.getPropertyString("href");
                    // If the correct style sheets are already loaded, then we
                    // should have
                    // nothing to remove.
                    if (!href.contains(gwtStyleSheet)
                            && !href.contains(showcaseStyleSheet)) {
                        toRemove.add(elem);
                    }
                }
            }
        }

        // Return if we already have the correct style sheets
        if (styleSheetsFound && toRemove.size() == 0) {
            return;
        }

        // Detach the app while we manipulate the styles to avoid rendering
        // issues
        RootPanel.get().remove(app);

        // Remove the old style sheets
        for (Element elem : toRemove) {
            headElem.removeChild(elem);
        }

        // Load the GWT theme style sheet
        String modulePath = GWT.getModuleBaseURL();
        Command callback = new Command() {
            /**
             * The number of style sheets that have been loaded and executed
             * this command.
             */
            private int numStyleSheetsLoaded = 0;

            public void execute() {
                // Wait until all style sheets have loaded before re-attaching the app
                numStyleSheetsLoaded++;
                if (numStyleSheetsLoaded < 2) {
                    return;
                }

                // Different themes use different background colors for the body
                // element, but IE only changes the background of the visible content
                // on the page instead of changing the background color of the entire
                // page. By changing the display style on the body element, we force
                // IE to redraw the background correctly.
                RootPanel.getBodyElement().getStyle().setProperty("display",
                        "none");
                RootPanel.getBodyElement().getStyle()
                        .setProperty("display", "");
                RootPanel.get().add(app);
            }
        };
        //    StyleSheetLoader.loadStyleSheet(modulePath + gwtStyleSheet,
        //        getCurrentReferenceStyleName("gwt"), callback);

        // Load the showcase specific style sheet after the GWT theme style sheet so
        // that custom styles supercede the theme styles.
        //    StyleSheetLoader.loadStyleSheet(modulePath + showcaseStyleSheet,
        //        getCurrentReferenceStyleName("Application"), callback);
    }
}
