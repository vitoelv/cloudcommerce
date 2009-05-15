package com.jcommerce.gwt.client.panels;

import java.util.Map;

import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.jcommerce.gwt.client.ContentWidget;
import com.jcommerce.gwt.client.ModelNames;
import com.jcommerce.gwt.client.iShop;
import com.jcommerce.gwt.client.model.BeanObject;
import com.jcommerce.gwt.client.model.IGoodsType;
import com.jcommerce.gwt.client.service.CreateService;
import com.jcommerce.gwt.client.service.UpdateService;
import com.jcommerce.gwt.client.widgets.ColumnPanel;

/**
 * Example file.
 */
public class NewGoodsType extends ContentWidget {
    private Button btnNew = new Button();    
    private Button btnCancel = new Button();    
    private ColumnPanel contentPanel = new ColumnPanel();   

    private boolean editting = false;
    private BeanObject goodsType = null;
    
    /**
     * Initialize this example.
     */
    public NewGoodsType() {
    }
    
    public String getDescription() {
        return "cwBasicTextDescription";
    }

    public String getName() {
        if(!editting)
    	return "新建商品类型";
        else
        	return "编辑商品类型";
    }
    
    public void setGoodsType(BeanObject goodsType) {
        this.goodsType = goodsType;
        editting = goodsType != null;
    }
    
    protected void onRender(Element parent, int index) {
        super.onRender(parent, index);
        System.out.println("----------NewGoodsType");
        add(contentPanel);
       
        contentPanel.createPanel(IGoodsType.NAME, "商品类型名称:", new TextBox());
        contentPanel.add(new Label("注：每行一个商品属性组。排序也将按照自然顺序排序。")); 
        TextArea attributeGroup = new TextArea();
        attributeGroup.setSize("200", "100");
        contentPanel.createPanel(IGoodsType.ATTRIBUTEGROUP, "属性分组:", attributeGroup);       
        contentPanel.createPanel(IGoodsType.ENABLED, "是否启用：", new CheckBox());        
        HorizontalPanel panel = new HorizontalPanel();
        panel.setSpacing(10);
        btnNew.setText("确定");        
        btnCancel.setText("重置");
        panel.add(btnNew);        
        panel.add(btnCancel);
        contentPanel.createPanel(null, null, panel);      
        
        btnNew.addClickListener(new ClickListener() {
            public void onClick(Widget sender) {
                String id = goodsType != null ? goodsType.getString(IGoodsType.ID) : null;
                goodsType = new BeanObject(ModelNames.GOODSTYPE, contentPanel.getValues());
                if (editting) {
                    new UpdateService().updateBean(id, goodsType, null);
                    iShop.getInstance().displayGoodsTypeInfo();
                    Info.display("恭喜", "完成修改商品类型.");
                } else {
                    new CreateService().createBean(goodsType, new CreateService.Listener() {
                        public synchronized void onSuccess(String id) { 
                            iShop.getInstance().displayGoodsTypeInfo();
                            Info.display("恭喜", "完成添加商品类型.");
                        }
                    });
                }
                
            }
        });

        btnCancel.addClickListener(new ClickListener() {
            public void onClick(Widget sender) {
                contentPanel.clearValues();
            }            
        });        
    }   
    
    public void refresh() {
        if (this.goodsType!=null&&this.goodsType.getString(IGoodsType.ID) != null) {
        	
            Map<String, Object> mapGoodsType = goodsType.getProperties();
            contentPanel.updateValues(mapGoodsType);
        }
        else{
        	contentPanel.clearValues();
            editting = false;
            }
    }
}
