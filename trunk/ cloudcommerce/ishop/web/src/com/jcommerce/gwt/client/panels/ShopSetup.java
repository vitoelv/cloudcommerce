package com.jcommerce.gwt.client.panels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ChangeListener;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.jcommerce.gwt.client.ContentWidget;
import com.jcommerce.gwt.client.IShopServiceAsync;
import com.jcommerce.gwt.client.ModelNames;
import com.jcommerce.gwt.client.model.BeanObject;
import com.jcommerce.gwt.client.model.IRegion;
import com.jcommerce.gwt.client.model.IShopConfig;
import com.jcommerce.gwt.client.panels.leontest.PageState;
import com.jcommerce.gwt.client.resources.Resources;
import com.jcommerce.gwt.client.service.ListService;
import com.jcommerce.gwt.client.service.UpdateService;
import com.jcommerce.gwt.client.widgets.ChoicePanel;
import com.jcommerce.gwt.client.widgets.ColumnPanel;
import com.jcommerce.gwt.client.widgets.FileUploader;

public class ShopSetup extends ContentWidget {

	private String SHOPNAME = "shop_name";//商店名称
	private String SHOPTITLE = "shop_title";//商店标题
	private String SHOPDESC = "shop_desc";//商店描述
	private String SHOPKEYWORDS = "shop_keywords";//商店关键字
	private String SHOPCOUNTRY = "shop_country";//所在国家
	private String SHOPPROVINCE = "shop_province";//所在省份
	private String SHOPCITY = "shop_city";//所在城市
	private String SHOPADDRESS = "shop_address";//详细地址
	private String QQ = "qq";//客服QQ号码
	private String WW = "ww";//淘宝旺旺
	private String SKYPE = "skype";//Skype
	private String YM = "ym";//Yahoo Messenger
	private String MSN = "msn";//MSN Messenger
	private String SERVICEEMAIL = "service_email";//客服邮件地址
	private String SERVICEPHONE = "service_phone";//客服电话
	private String SHOPCLOSED = "shop_closed";//暂时关闭网站
	private String CLOSECOMMENT = "close_comment";//关闭网店的原因
	private String SHOPLOGO = "shop_logo";//商店 Logo
	private String LICENSED = "licensed";//是否显示 Licensed
	private String USERNOTICE = "user_notice";//用户中心公告
	private String SHOPNOTICE = "shop_notice";//商店公告
	
	private String SEARCHKEYWORDS = "search_keywords";//首页搜索的关键字
	private String DATAFORMAT = "date_format";//日期格式
	private String TIMEFORMAT = "time_format";//时间格式
	private String CURRENCYFORMAT = "currency_format";//货币格式
	private String THUMBWIDTH = "thumb_width";//缩略图宽度
	private String THUMBHEIGHT = "thumb_height";//缩略图高度
	private String IMAGEWIDTH = "image_width";//商品图片宽度
	private String IMAGEHEIGHT = "image_height";//商品图片高度
	private String TOPNUMBER = "top_number";//销量排行数量
	private String HISTORYNUMBER = "history_number";//浏览历史数量
	private String COMMENTSNUMBER = "comments_number";//评论数量
	private String BOUGHTGOODS = "bought_goods";//相关商品数量
	private String ARTICLENUMBER = "article_number";//最新文章显示数量
	private String GOODSNAMELENGTH = "goods_name_length";//商品名称的长度
	private String PRICEFORMAT = "price_format";//商品价格显示规则
	private String PAGESIZE = "page_size";//商品分类页列表的数量
	private String SORTORDERTYPE = "sort_order_type";//商品分类页默认排序类型
	private String SORTORDERMETHOD = "sort_order_method";//商品分类页默认排序方式
	private String SHOWORDERTYPE = "show_order_type";//商品分类页默认显示方式
	private String ATTRRELATEDNUMBER = "attr_related_number";//属性关联的商品数量
	private String GOODSGALLERYNUMBER = "goods_gallery_number";//商品详情页相册图片数量
	private String ARTICLETITLELENGTH = "article_title_length";//文章标题长度
	private String NAMEOFREGION1 = "name_of_region_1";//一级配送区域名称
	private String NAMEOFREGION2 = "name_of_region_2";//二级配送区域名称
	private String NAMEOFREGION3 = "name_of_region_3";//三级配送区域名称
	private String NAMEOFREGION4 = "name_of_region_4";//四级配送区域名称
	private String RELATEDGOODSNUMBER = "related_goods_number";//关联商品显示数量
	private String HELPOPEN = "help_open";//用户帮助是否打开
	
	private String SHOWGOODSSN = "show_goodssn";//是否显示货号
	private String SHOWBRAND = "show_brand";//是否显示品牌
	private String SHOWGOODSWEIGHT = "show_goodsweight";//是否显示重量
	private String SHOWGOODSNUMBER = "show_goodsnumber";//是否显示库存
	private String SHOWADDTIME = "show_addtime";//是否显示上架时间
	private String GOODSATTRSTYLE = "goodsattr_style";//商品属性显示样式
	private String SHOWMARKETPRICE = "show_marketprice";//是否显示市场价格
	
	
    private String COUNTRYID = "1";
	private Button btnOK = new Button();
	private Button btnReset = new Button();	
	private ColumnPanel contentPanelGeneral = new ColumnPanel();//网店信息
	private ColumnPanel contentPanelShow = new ColumnPanel();//显示设置
	private ColumnPanel contentPanelGoodsShow = new ColumnPanel();//商品显示设置
	
	private Map<String, Object> configs = new HashMap<String, Object>();
	private Map<String, Object> nameIDs = new HashMap<String, Object>();
	private Map<String, Object> update = new HashMap<String, Object>();
	private Map<String, Object> object = new HashMap<String, Object>();
	private List<String> name = new ArrayList<String>();
	
	private ListBox city = new ListBox();
	private ListBox province = new ListBox();

	public ShopSetup() {
	}
    // leon to integrate with history-based page navigation mechnism. 
    // State should contain all info needed to render this page.
    // This is a minimum skeleton, more fields may be added, see leontest.Attribute
	public static class State extends PageState {
		public String getPageClassName() {
			return ShopSetup.class.getName();
		}
		
		public String getMenuDisplayName() {
			return Resources.constants.Shop_setup();
		}
	}
	private State curState = new State();
	public State getCurState() {
		return curState;
	}
	public void setCurState(State curState) {
		this.curState = curState;
	}
	// end of block
	
	public String getDescription() {
		return "cwBasicTextDescription";
	}

	public String getName() {
		return Resources.constants.Shop_setup();
	}


	protected void onRender(Element parent, int index) {
		super.onRender(parent, index);

		contentPanelGeneral.createPanel(SHOPNAME, Resources.constants.Shop_name(), new TextBox());
		contentPanelGeneral.createPanel(SHOPTITLE, Resources.constants.Shop_title(), new TextBox());
		contentPanelGeneral.createPanel(SHOPDESC, Resources.constants.Shop_desc(), new TextBox());
		contentPanelGeneral.createPanel(SHOPKEYWORDS, Resources.constants.shop_keywords(), new TextBox());
		ListBox country = new ListBox();
		country.addItem(Resources.constants.select_notice(), null);
		country.addItem("中国", "1");
		country.setSelectedIndex(1);
		contentPanelGeneral.createPanel(SHOPCOUNTRY, Resources.constants.shop_country(), country);
		contentPanelGeneral.createPanel(SHOPPROVINCE, Resources.constants.shop_province(), province);
		contentPanelGeneral.createPanel(SHOPCITY, Resources.constants.shop_city(), city);
		contentPanelGeneral.createPanel(SHOPADDRESS, Resources.constants.shop_address(), new TextBox());
		contentPanelGeneral.createPanel(QQ, Resources.constants.qq(), new TextBox());
		contentPanelGeneral.createPanel(WW, Resources.constants.ww(), new TextBox());		
		contentPanelGeneral.createPanel(SKYPE, Resources.constants.skype(),	new TextBox());
		contentPanelGeneral.createPanel(YM, Resources.constants.ym(), new TextBox());
		contentPanelGeneral.createPanel(MSN, Resources.constants.msn(), new TextBox());
		contentPanelGeneral.createPanel(SERVICEEMAIL, Resources.constants.service_email(), new TextBox());
		contentPanelGeneral.createPanel(SERVICEPHONE, Resources.constants.service_phone(), new TextBox());

		ListBox closed = new ListBox();
		closed.addItem(Resources.constants.no(), "0");
		closed.addItem(Resources.constants.yes(), "1");
		closed.setSelectedIndex(0);		
		contentPanelGeneral.createPanel(SHOPCLOSED,Resources.constants.shop_closed(),closed);
		
		TextArea closeComment = new TextArea();
		closeComment.setSize("200", "100");
		contentPanelGeneral.createPanel(CLOSECOMMENT, Resources.constants.close_comment(), closeComment);
		contentPanelGeneral.createPanel(SHOPLOGO, Resources.constants.shop_logo(), new FileUploader());

		ListBox licensed = new ListBox();
		licensed.addItem(Resources.constants.no(), "0");
		licensed.addItem(Resources.constants.yes(), "1");
		licensed.setSelectedIndex(0);		
		contentPanelGeneral.createPanel(LICENSED,Resources.constants.licensed(),licensed);
		
		TextArea userNotice = new TextArea();
		userNotice.setSize("200", "100");
		contentPanelGeneral.createPanel(USERNOTICE, Resources.constants.user_notice(), userNotice);
		TextArea shopNotice = new TextArea();
		shopNotice.setSize("200", "100");
		contentPanelGeneral.createPanel(SHOPNOTICE, Resources.constants.shop_notice(), shopNotice);
		btnOK.setText(Resources.constants.GoodsList_action_OK());
		btnReset.setText(Resources.constants.GoodsList_reset());
		HorizontalPanel panel = new HorizontalPanel();
		panel.setSpacing(30);
		panel.add(btnOK);
		panel.add(btnReset);
		//refresh();
		// Create a tab panel
		DecoratedTabPanel tabPanel = new DecoratedTabPanel();
		tabPanel.setAnimationEnabled(true);

		// Add a Shop Info tab
		tabPanel.add(contentPanelGeneral, Resources.constants.ShopSetup_tabShopInfo());

		//Add a Basic Set tab		
		HTML basicSet = new HTML("basic Set");
		tabPanel.add(basicSet, Resources.constants.ShopSetup_tabBasicSet());

		//Add a View Set tab
		//contentPanelShow.createPanel(getName(), getDescription(), );
		contentPanelShow.createPanel(SEARCHKEYWORDS, Resources.constants.search_keywords(), new TextBox());
		contentPanelShow.createPanel(DATAFORMAT, Resources.constants.date_format(),new TextBox());
		contentPanelShow.createPanel(TIMEFORMAT, Resources.constants.time_format(),new TextBox());
		contentPanelShow.createPanel(CURRENCYFORMAT, Resources.constants.currency_format(),new TextBox());
		contentPanelShow.createPanel(THUMBWIDTH, Resources.constants.thumb_width(),new TextBox());
		contentPanelShow.createPanel(THUMBHEIGHT, Resources.constants.thumb_height(),new TextBox());
		contentPanelShow.createPanel(IMAGEWIDTH, Resources.constants.image_width(),new TextBox());
		contentPanelShow.createPanel(IMAGEHEIGHT, Resources.constants.image_height(),new TextBox());
		contentPanelShow.createPanel(TOPNUMBER, Resources.constants.top_number(),new TextBox());
		contentPanelShow.createPanel(HISTORYNUMBER, Resources.constants.history_number(),new TextBox());
		contentPanelShow.createPanel(COMMENTSNUMBER, Resources.constants.comments_number(),new TextBox());
		contentPanelShow.createPanel(BOUGHTGOODS, Resources.constants.bought_goods(),new TextBox());
		contentPanelShow.createPanel(ARTICLENUMBER, Resources.constants.article_number(),new TextBox());
		contentPanelShow.createPanel(GOODSNAMELENGTH, Resources.constants.goods_name_length(),new TextBox());
		ListBox priceFormat = new ListBox();
		priceFormat.addItem(Resources.constants.do_nothing(), "0");
		priceFormat.addItem(Resources.constants.reservations_effective_mantissa(), "1");
		priceFormat.addItem(Resources.constants.not_rounding_keep_1(), "2");
		priceFormat.addItem(Resources.constants.not_rounding_not_keep(), "3");
		priceFormat.addItem(Resources.constants.rounding_keep_1(), "4");
		priceFormat.addItem(Resources.constants.rounding_not_keep(), "5");
		priceFormat.setSelectedIndex(0);
		contentPanelShow.createPanel(PRICEFORMAT, Resources.constants.price_format(),priceFormat);
		contentPanelShow.createPanel(PAGESIZE, Resources.constants.page_size(),new TextBox());
		ListBox sortOrderType = new ListBox();
		sortOrderType.addItem(Resources.constants.sort_shelf_time(), "0");
		sortOrderType.addItem(Resources.constants.sort_goods_price(), "1");
		sortOrderType.addItem(Resources.constants.sort_last_update(), "2");
		sortOrderType.setSelectedIndex(0);
		contentPanelShow.createPanel(SORTORDERTYPE, Resources.constants.sort_order_type(),sortOrderType);
		ListBox sortOrderMethod = new ListBox();
		sortOrderMethod.addItem(Resources.constants.sort_DESC(), "0");
		sortOrderMethod.addItem(Resources.constants.sort_ASC(), "1");
		sortOrderType.setSelectedIndex(0);
		contentPanelShow.createPanel(SORTORDERMETHOD, Resources.constants.sort_order_method(),sortOrderMethod);
		ListBox showOrderType = new ListBox();
		showOrderType.addItem(Resources.constants.show_list(), "0");
		showOrderType.addItem(Resources.constants.show_grid(), "1");
		showOrderType.addItem(Resources.constants.show_text(), "2");
		showOrderType.setSelectedIndex(0);
		contentPanelShow.createPanel(SHOWORDERTYPE, Resources.constants.show_order_type(),showOrderType);
		contentPanelShow.createPanel(ATTRRELATEDNUMBER, Resources.constants.attr_related_number(),new TextBox());
		contentPanelShow.createPanel(GOODSGALLERYNUMBER, Resources.constants.goods_gallery_number(),new TextBox());
		contentPanelShow.createPanel(ARTICLETITLELENGTH, Resources.constants.article_title_length(),new TextBox());
		contentPanelShow.createPanel(NAMEOFREGION1, Resources.constants.name_of_region_1(),new TextBox());
		contentPanelShow.createPanel(NAMEOFREGION2, Resources.constants.name_of_region_2(),new TextBox());
		contentPanelShow.createPanel(NAMEOFREGION3, Resources.constants.name_of_region_3(),new TextBox());
		contentPanelShow.createPanel(NAMEOFREGION4, Resources.constants.name_of_region_4(),new TextBox());
		contentPanelShow.createPanel(RELATEDGOODSNUMBER, Resources.constants.related_goods_number(),new TextBox());
		ListBox helpOpen = new ListBox();
		helpOpen.addItem(Resources.constants.no(), "0");
		helpOpen.addItem(Resources.constants.yes(), "1");
		helpOpen.setSelectedIndex(0);
		contentPanelShow.createPanel(HELPOPEN, Resources.constants.help_open(),helpOpen);
		
		
		tabPanel.add(contentPanelShow, Resources.constants.ShopSetup_tabShowSet());

		//Add a Shopping Flow tab
		HTML shoppingFlow = new HTML("shopping Flow");
		tabPanel.add(shoppingFlow, Resources.constants.ShopSetup_tabBuyFlow());

		//Add a Goods show Set tab
		ListBox showGoodsSN = new ListBox();
		showGoodsSN.addItem(Resources.constants.yes(), "1");
		showGoodsSN.addItem(Resources.constants.no(), "0");
		showGoodsSN.setSelectedIndex(0);
		contentPanelGoodsShow.createPanel(SHOWGOODSSN, Resources.constants.show_goodssn(), showGoodsSN);
		
		List<ChoicePanel.Item> brandItems = new ArrayList<ChoicePanel.Item>();
		brandItems.add(new ChoicePanel.Item(Resources.constants.yes(), "1"));
		brandItems.add(new ChoicePanel.Item(Resources.constants.no(), "0"));		
		ChoicePanel showBrand = new ChoicePanel("0",brandItems); 
		contentPanelGoodsShow.createPanel(SHOWBRAND, Resources.constants.show_brand(), showBrand);
		
		List<ChoicePanel.Item> goodsWeightItems = new ArrayList<ChoicePanel.Item>();
		goodsWeightItems.add(new ChoicePanel.Item(Resources.constants.yes(), "1"));
		goodsWeightItems.add(new ChoicePanel.Item(Resources.constants.no(), "0"));		
		ChoicePanel showGoodsWeight = new ChoicePanel("0",goodsWeightItems); 
		contentPanelGoodsShow.createPanel(SHOWGOODSWEIGHT, Resources.constants.show_goodsweight(), showGoodsWeight);
		
		List<ChoicePanel.Item> goodsNumberItems = new ArrayList<ChoicePanel.Item>();
		goodsNumberItems.add(new ChoicePanel.Item(Resources.constants.yes(), "1"));
		goodsNumberItems.add(new ChoicePanel.Item(Resources.constants.no(), "0"));		
		ChoicePanel showGoodsNumber = new ChoicePanel("0",goodsNumberItems); 
		contentPanelGoodsShow.createPanel(SHOWGOODSNUMBER, Resources.constants.show_goodsnumber(), showGoodsNumber);
		
		List<ChoicePanel.Item> addTimeItems = new ArrayList<ChoicePanel.Item>();
		addTimeItems.add(new ChoicePanel.Item(Resources.constants.yes(), "1"));
		addTimeItems.add(new ChoicePanel.Item(Resources.constants.no(), "0"));		
		ChoicePanel showAddTime = new ChoicePanel("0",addTimeItems); 
		contentPanelGoodsShow.createPanel(SHOWADDTIME, Resources.constants.show_addtime(), showAddTime);
		
		List<ChoicePanel.Item> attrStyleItems = new ArrayList<ChoicePanel.Item>();
		attrStyleItems.add(new ChoicePanel.Item(Resources.constants.attr_Style_1(), "1"));
		attrStyleItems.add(new ChoicePanel.Item(Resources.constants.attr_Style_2(), "0"));		
		ChoicePanel goodsAttrStyle = new ChoicePanel("0",attrStyleItems); 
		contentPanelGoodsShow.createPanel(GOODSATTRSTYLE, Resources.constants.goodsattr_style(), goodsAttrStyle);
		
		List<ChoicePanel.Item> marketPriceItems = new ArrayList<ChoicePanel.Item>();
		marketPriceItems.add(new ChoicePanel.Item(Resources.constants.yes(), "1"));
		marketPriceItems.add(new ChoicePanel.Item(Resources.constants.no(), "0"));		
		ChoicePanel showMarketPrice = new ChoicePanel("0",marketPriceItems); 
		contentPanelGoodsShow.createPanel(SHOWMARKETPRICE, Resources.constants.show_marketprice(), showMarketPrice);
		
		tabPanel.add(contentPanelGoodsShow, Resources.constants.ShopSetup_tabGoodsShow());

		//Add a SMS Set tab
		HTML smsSet = new HTML("SMS Set");
		tabPanel.add(smsSet, Resources.constants.ShopSetup_tabSMS());

		//Add a WAP Set tab
		HTML wapSet = new HTML("WAP Set");
		tabPanel.add(wapSet, Resources.constants.ShopSetup_tabWAP());

		province.addChangeListener(new ChangeListener() {
			public void onChange(Widget sender) {
				showRegion(city, province.getSelectedIndex(),"0");
			}
		});
		btnReset.addClickListener(new ClickListener(){
			public void onClick(Widget sender){
				refresh();
			}
		});
		btnOK.addClickListener(new ClickListener(){
			public void onClick(Widget sender){
				//save information
				update = contentPanelGeneral.getValues();
				update.putAll(contentPanelShow.getValues());
				update.putAll(contentPanelGoodsShow.getValues());
				for(int index = 0;index<nameIDs.size();index++){
					object.put("value",update.get(name.get(index)));
					new UpdateService().updateBean((String)nameIDs.get(name.get(index)), new BeanObject(ModelNames.SHOPCONFIG,object), null);
					object.clear();
				}
			}
		});

		tabPanel.selectTab(0);
		tabPanel.ensureDebugId("cwTabPanel");
		add(tabPanel);
		add(panel);

	}

	/**
	 * fill right Items in cityListBox depend on which province you selected
	 * 
	 * @param listBox cityListBox
	 * @param provinceIndex the province you choose
	 * @param cityIndex the city you choose
	 */
	private void showRegion(final ListBox listBox, final int provinceIndex, final String cityIndex) {
		listBox.clear();
		listBox.addItem(Resources.constants.select_notice(), null);
		listBox.setSelectedIndex(0);
		if (provinceIndex != 0) {
			IShopServiceAsync service = getService();
			service.regionChildList(provinceIndex+1+"",new AsyncCallback<List<BeanObject>>() {
	            public synchronized void onSuccess(List<BeanObject> result) {
	            	for(Iterator<BeanObject> it = result.iterator(); it.hasNext();){
	    				BeanObject cityShow = it.next();
	    				listBox.addItem(cityShow.getString(IRegion.NAME), cityShow.getString(IRegion.ID));
	    		     }
	            	if(!cityIndex.equals("0")){	            		
	            		for(int select = 1;select<listBox.getItemCount();select++){	            			
	            			if(listBox.getValue(select).equals(cityIndex)){
	            				listBox.setSelectedIndex(select);
	            				break;
	            			}	
	            		}
	            	}
	            }
	            public synchronized void onFailure(Throwable caught) {
	                System.out.println("getList onFailure("+caught);	               
	            }
	        });			
		}
	}

	public void refresh() {		
		city.clear();
		province.clear();
		city.addItem(Resources.constants.select_notice(), null);
		city.setSelectedIndex(0);
		province.addItem(Resources.constants.select_notice(), null);
		province.setSelectedIndex(0);
		IShopServiceAsync service = getService();
		service.regionChildList(COUNTRYID,new AsyncCallback<List<BeanObject>>() {
            public synchronized void onSuccess(List<BeanObject> result) {
            	for(Iterator<BeanObject> it = result.iterator(); it.hasNext();){
    				BeanObject provinceShow = it.next();
    				province.addItem(provinceShow.getString(IRegion.NAME), provinceShow.getString(IRegion.ID));
    		     }
            }
            public synchronized void onFailure(Throwable caught) {
                System.out.println("getRegionList onFailure("+caught);
            }
        });  
		
		new ListService().listBeans(ModelNames.SHOPCONFIG,new ListService.Listener() {
					public synchronized void onSuccess(List<BeanObject> result) {
						for (Iterator<BeanObject> it = result.iterator(); it.hasNext();) {
							BeanObject config = it.next();							
							configs.put(config.getString(IShopConfig.CODE), config.getString(IShopConfig.VALUE));
						    nameIDs.put(config.getString(IShopConfig.CODE), config.getString(IShopConfig.ID));
						    name.add(config.getString(IShopConfig.CODE));
						}						
						contentPanelGeneral.updateValues(configs);
						contentPanelShow.updateValues(configs);
						contentPanelGoodsShow.updateValues(configs);
						if(!province.isItemSelected(0)){
							showRegion(city, province.getSelectedIndex(),(String)configs.get(SHOPCITY));
						}
					}
				});			
	}
}
