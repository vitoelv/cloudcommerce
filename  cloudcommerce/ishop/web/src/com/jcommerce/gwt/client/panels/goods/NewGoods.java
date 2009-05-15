/*
 * Copyright 2008 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.jcommerce.gwt.client.panels.goods;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.jcommerce.gwt.client.ContentWidget;
import com.jcommerce.gwt.client.ModelNames;
import com.jcommerce.gwt.client.iShop;
import com.jcommerce.gwt.client.model.BeanObject;
import com.jcommerce.gwt.client.model.IBrand;
import com.jcommerce.gwt.client.model.ICategory;
import com.jcommerce.gwt.client.model.IGoods;
import com.jcommerce.gwt.client.model.IGoodsType;
import com.jcommerce.gwt.client.panels.BrandInfo;
import com.jcommerce.gwt.client.panels.BrandInfo.State;
import com.jcommerce.gwt.client.panels.leontest.PageState;
import com.jcommerce.gwt.client.resources.Resources;
import com.jcommerce.gwt.client.service.CreateService;
import com.jcommerce.gwt.client.service.ListService;
import com.jcommerce.gwt.client.service.UpdateService;
import com.jcommerce.gwt.client.service.WaitService;
import com.jcommerce.gwt.client.widgets.ColumnPanel;
import com.jcommerce.gwt.client.widgets.FileUploader;
import com.jcommerce.gwt.client.widgets.MultiValueSelector;
import com.jcommerce.gwt.client.widgets.richTextBox.RichTextToolbar;

public class NewGoods extends ContentWidget {
    
    public static interface Constants {
        String NewGoods_title();
        String NewGoods_create();
        String NewGoods_cancel();
        String NewGoods_tabGeneral();
        String NewGoods_tabDetail();
        String NewGoods_tabOther();
        String NewGoods_tabProperty();
        String NewGoods_tabGallery();
        String NewGoods_tabLink();
        String NewGoods_tabAccessories();
        String NewGoods_tabArticle();
    }
    
	private ColumnPanel contentPanelGeneral = new ColumnPanel();
    private ColumnPanel contentPanelOther = new ColumnPanel();
    private AttributePanel attrPanel = new AttributePanel();
    private GalleryPanel galleryPanel = new GalleryPanel();
	 
    private ListBox g_list = new ListBox();
    private Button btnOK = new Button();
    private Button btnCancel = new Button();

    private String goodsId = null; 
   // private HashMap<String, BeanObject> mapGoods = new HashMap<String, BeanObject>();
    
    private boolean editting = false;
    private BeanObject goods = null;
    
    
    // leon to integrate with history-based page navigation mechnism. 
    // State should contain all info needed to render this page.
    // This is a minimum skeleton, more fields may be added, see leontest.Attribute
	public static class State extends PageState {
		public String getPageClassName() {
			return NewGoods.class.getName();
		}
		public String getMenuDisplayName() {
			return Resources.constants.NewGoods_title();
		}
	}
	private State curState = new State();
	public State getCurState() {
		return curState;
	}
	public void setCurState(State curState) {
		this.curState = curState;
	}
    
    /**
     * Initialize this example.
     */
    public NewGoods() {       
    }
    
    public String getDescription() {
        return "cwBasicTextDescription";
    }

    public String getName() {
    	if(!editting)            
    		return Resources.constants.NewGoods_title();
        else
        	return "编辑商品信息";
    }

    public void setGoods(BeanObject goods) {
        this.goods = goods;
        this.goodsId = goods != null ? goods.getString(IGoods.ID) : null;
        editting = goods != null;
    }
    
    protected void onRender(Element parent, int index) {
        super.onRender(parent, index);
       
    	contentPanelGeneral.createPanel(IGoods.NAME, Resources.constants.Goods_name(), new TextBox());
    	contentPanelGeneral.createPanel(IGoods.SN, Resources.constants.Goods_SN(), new TextBox());
        
    	contentPanelGeneral.createPanel(IGoods.BRAND, Resources.constants.Goods_brand(), g_list);
        
        MultiValueSelector mselector = new MultiValueSelector();
        mselector.setBean(ModelNames.CATEGORY);
        mselector.setCaption("Select Category");
        mselector.setMessage("Select Category");
        contentPanelGeneral.createPanel(IGoods.CATEGORIES, Resources.constants.Goods_category(), mselector);
        contentPanelGeneral.createPanel(IGoods.SHOPPRICE, Resources.constants.Goods_shopPrice(), new TextBox());
        contentPanelGeneral.createPanel(IGoods.MARKETPRICE, Resources.constants.Goods_marketPrice(), new TextBox());
        contentPanelGeneral.createPanel(IGoods.GIVEINTEGRAL, Resources.constants.Goods_giveIntegral(), new TextBox());
        contentPanelGeneral.createPanel(IGoods.INTEGRAL, Resources.constants.Goods_integral(), new TextBox());
        
        contentPanelGeneral.createPanel(IGoods.PROMOTEPRICE, Resources.constants.Goods_promotePrice(), new TextBox());
        final FileUploader imageUpload = new FileUploader();
        imageUpload.addAllowedTypes(new String[]{".jpg", ".gif"});
        contentPanelGeneral.createPanel(IGoods.IMAGE, Resources.constants.Goods_image(), imageUpload);
        final FileUploader thumbUpload = new FileUploader();
        thumbUpload.addAllowedTypes(new String[]{".jpg", ".gif"});
        contentPanelGeneral.createPanel(IGoods.THUMB, Resources.constants.Goods_thumb(), thumbUpload);
        
        contentPanelOther.createPanel(IGoods.WEIGHT, Resources.constants.Goods_weight(), new TextBox());
        contentPanelOther.createPanel(IGoods.NUMBER, Resources.constants.Goods_number(), new TextBox());
        contentPanelOther.createPanel(IGoods.WARNNUMBER, Resources.constants.Goods_warnNumber(), new TextBox());                
        contentPanelOther.createPanel(IGoods.HOTSOLD, Resources.constants.Goods_hotsold(), new CheckBox());
        contentPanelOther.createPanel(IGoods.NEWADDED, Resources.constants.Goods_newAdded(), new CheckBox());
        contentPanelOther.createPanel(IGoods.BESTSOLD, Resources.constants.Goods_bestSold(), new CheckBox());        
        contentPanelOther.createPanel(IGoods.BRIEF, Resources.constants.Goods_brief(), new TextArea());
        contentPanelOther.createPanel(IGoods.SELLERNOTE, Resources.constants.Goods_sellerNote(), new TextArea());
                
        HorizontalPanel panel = new HorizontalPanel();
        panel.setSpacing(10);
        btnOK.setText("确定");
        btnCancel.setText("重置");
        panel.add(btnOK);
        panel.add(btnCancel);    
        
        // Create a tab panel
        DecoratedTabPanel tabPanel = new DecoratedTabPanel();
        tabPanel.setWidth("100%");        
        tabPanel.setAnimationEnabled(true);
        
        
        // Add a home tab      
       
        tabPanel.add(contentPanelGeneral, Resources.constants.NewGoods_tabGeneral());

        // Create the text area and toolbar
        RichTextArea area = new RichTextArea();       
        area.setSize("100%", "14em");
        RichTextToolbar toolbar = new RichTextToolbar(area);        
        toolbar.setWidth("100%");

        //Add the components to a panel
        Grid grid = new Grid(2, 1);
        grid.setStyleName("cw-RichText");
        grid.setWidget(0, 0, toolbar);
        grid.setWidget(1, 0, area);

        // Add a detail tab   
        HTML properties2 = new HTML("properites");
        tabPanel.add( grid, Resources.constants.NewGoods_tabDetail());

        // Add a other tab        
        tabPanel.add(contentPanelOther, Resources.constants.NewGoods_tabOther());

        // Add a Properties tab
        tabPanel.add(attrPanel, Resources.constants.NewGoods_tabProperty());
        
        // Add a Pictures tab
        tabPanel.add(galleryPanel, Resources.constants.NewGoods_tabGallery());
        
        // Add a Connet other goods tab
        HTML conngoods = new HTML("connect goods");
        tabPanel.add(conngoods, Resources.constants.NewGoods_tabLink());
        
        // Add a Accessories tab
        HTML accessories = new HTML("accessories");
        tabPanel.add(accessories, Resources.constants.NewGoods_tabAccessories());
        
        // Add a Connet articles tab
        HTML articles = new HTML("articles");
        tabPanel.add(articles, Resources.constants.NewGoods_tabArticle());
        
        // Return the content
        tabPanel.selectTab(0);
        tabPanel.ensureDebugId("cwTabPanel");        
        add(tabPanel);
    	add(panel);        
        createList();        
        btnOK.addClickListener(new ClickListener() {
            public void onClick(Widget sender) {
                if (!imageUpload.submit()) {
                    return;
                }
                if (!thumbUpload.submit()) {
                    return;
                }
               
                new WaitService(new WaitService.Job() {
                    public boolean isReady() {
                        return imageUpload.isFinish() && thumbUpload.isFinish();
                    }

                    public void run() {
                    	Date currentTime = new Date();
                    	Timestamp nowTime = new Timestamp(currentTime.getTime());
                    	Map<String, Object> argsLeft = contentPanelGeneral.getValues();
                        Map<String, Object> argsRight = contentPanelOther.getValues();
                        Map<String, Object> argsAttrs = attrPanel.getValues();

                        argsLeft.putAll(argsRight);
                        argsLeft.putAll(argsAttrs);
                        argsLeft.put("addTime", nowTime);//addTime information
                        if(editting){                        	
                        	new UpdateService().updateBean(goodsId, new BeanObject(ModelNames.GOODS, argsLeft), null);
                            editting = false;
                            iShop.getInstance().displayGoodsList();
                            Info.display("恭喜", "完成修改商品信息.");
                        }
                        else{
                        	new CreateService().createBean(new BeanObject(ModelNames.GOODS, argsLeft), null);
                        	iShop.getInstance().displayGoodsList();
                            Info.display("恭喜", "完成添加新商品.");
                        }
                    }
                });
            }            
        });
        
        btnCancel.addClickListener(new ClickListener() {
            public void onClick(Widget sender) {
            	contentPanelGeneral.clearValues(); 
            	contentPanelOther.clearValues();
            	attrPanel.updateValues(null);
            }
        });  
    }
    
    private void createList() {
        new ListService().listBeans(ModelNames.BRAND, new ListService.Listener() {
            public void onSuccess(List<BeanObject> beans) {
                for (Iterator<BeanObject> it = beans.iterator(); it.hasNext();) {
                    BeanObject brand = it.next();
                    g_list.addItem(brand.getString(IBrand.NAME), brand.getString(IBrand.ID));                  
                }
                
            }
        });
    }
 
    public void refresh() {    	
        if (this.goods!=null&&this.goods.getString(ICategory.ID) != null) {
            contentPanelGeneral.updateValues(goods.getProperties());
            contentPanelOther.updateValues(goods.getProperties());
            attrPanel.updateValues(goods);
            this.goods = null;
        }
        else{       	
        	contentPanelGeneral.clearValues(); 
        	contentPanelOther.clearValues();
        	attrPanel.updateValues(null);
        	editting = false;
        }
    }
}
