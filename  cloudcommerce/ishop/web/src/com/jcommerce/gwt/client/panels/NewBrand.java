package com.jcommerce.gwt.client.panels;

import java.util.HashMap;
import java.util.Map;

import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.jcommerce.gwt.client.ContentWidget;
import com.jcommerce.gwt.client.ModelNames;
import com.jcommerce.gwt.client.iShop;
import com.jcommerce.gwt.client.model.BeanObject;
import com.jcommerce.gwt.client.model.IBrand;
import com.jcommerce.gwt.client.service.CreateService;
import com.jcommerce.gwt.client.service.UpdateService;
import com.jcommerce.gwt.client.service.WaitService;
import com.jcommerce.gwt.client.widgets.ColumnPanel;
import com.jcommerce.gwt.client.widgets.FileUploader;

/**
 * Example file.
 */
public class NewBrand extends ContentWidget {    	
    
    private Button btnNew = new Button();    
    private Button btnCancel = new Button();    
    private ColumnPanel contentPanel = new ColumnPanel();
   
    private boolean editting = false;
    
    private BeanObject brand = null;
    
    /**
     * Initialize this example.
     */
    private static NewBrand instance; 
    
    public static NewBrand getInstance() {
    	if(instance==null) {
    		instance = new NewBrand();
    	}
    	return instance;
    }
    
    private NewBrand() {
    }
    
    public String getDescription() {
        return "cwBasicTextDescription";
    }

    public String getName() {
    	if(!editting)
        	return "添加品牌";
        else
            return "编辑品牌"; 
    	
    }
    
    public void setBrand(BeanObject brand) {
        this.brand = brand;
        editting = brand != null;
    }
    
    protected void onRender(Element parent, int index) {
        super.onRender(parent, index);
        
        System.out.println("----------NewBrand");
        add(contentPanel);
       
        contentPanel.createPanel(IBrand.NAME, "品牌名称:", new TextBox());
        contentPanel.createPanel(IBrand.SITE, "品牌网址:", new TextBox());
        final FileUploader logoUpload = new FileUploader();
        logoUpload.addAllowedTypes(new String[]{".jpg", ".gif"});
        contentPanel.createPanel(IBrand.LOGO, "品牌LOGO:", logoUpload);
        contentPanel.createPanel(IBrand.DESC, "品牌描述:", new TextArea());
        contentPanel.createPanel(IBrand.ORDER, "排序:", new TextBox());
        contentPanel.createPanel(IBrand.SHOW, "是否显示:", new CheckBox());
        
        HorizontalPanel panel = new HorizontalPanel();
        panel.setSpacing(10);
        btnNew.setText("确定");
        btnCancel.setText("重置");
        panel.add(btnNew);
        panel.add(btnCancel);
        contentPanel.createPanel(null, null, panel);        

        btnNew.addClickListener(new ClickListener() {
            public void onClick(Widget sender) {
                if (!logoUpload.submit()) {
                    return;
                }
               
                new WaitService(new WaitService.Job() {
                    public boolean isReady() {
                        return logoUpload.isFinish();
                    }

                    public void run() {
                        String id = brand != null ? brand.getString(IBrand.ID) : null;
                        brand = new BeanObject(ModelNames.BRAND, contentPanel.getValues());
                        if (editting) {
                            new UpdateService().updateBean(id, brand, null);
                            iShop.getInstance().displayBrandInfo();
                            Info.display("恭喜", "完成修改商品品牌.");
                        } else {
                            new CreateService().createBean(brand, new CreateService.Listener() {
                                public void onSuccess(String id) {
                                	iShop.getInstance().displayBrandInfo();
                                    Info.display("恭喜", "完成添加商品品牌.");                                    
                                }
                            });
                        }
                    }
                });
            }
        });

        btnCancel.addClickListener(new ClickListener() {
            public void onClick(Widget sender) {
                contentPanel.clearValues();
            }            
        });        
    }  
    
    public void refresh() {
        if (this.brand!=null&&this.brand.getString(IBrand.ID) != null) {            
            Map<String, Object> mapBrand = brand.getProperties();
            contentPanel.updateValues(mapBrand);
        }
        else{
          contentPanel.clearValues();
          editting = false;
          }
    }
}
