package com.jcommerce.gwt.client.panels;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.jcommerce.gwt.client.ContentWidget;
import com.jcommerce.gwt.client.ModelNames;
import com.jcommerce.gwt.client.iShop;
import com.jcommerce.gwt.client.model.BeanObject;
import com.jcommerce.gwt.client.model.IBrand;
import com.jcommerce.gwt.client.model.ICategory;
import com.jcommerce.gwt.client.service.CreateService;
import com.jcommerce.gwt.client.service.ListService;
import com.jcommerce.gwt.client.service.UpdateService;
import com.jcommerce.gwt.client.widgets.ColumnPanel;

/**
 * Example file.
 */
public class NewCategory extends ContentWidget {    	
	private ListBox c_parent = new ListBox();
    private Button btnNew = new Button();    
    private Button btnCancel = new Button();    
    private ColumnPanel contentPanel = new ColumnPanel();
    
    private Map<String, BeanObject> categorys = new HashMap<String, BeanObject>();

    private boolean editting = false;
    private BeanObject category = null;
    
    /**
     * Initialize this example.
     */
    public static NewCategory getInstance() {
    	if(instance==null) {
    		instance = new NewCategory();
    	}
    	return instance;
    }
    private static NewCategory instance;
    private NewCategory() {
    }
    
    public String getDescription() {
        return "cwBasicTextDescription";
    }

    public String getName() {
    	if (!editting)
			return "添加分类";
		else
			return "编辑分类";    	
    }
    
    public void setCategory(BeanObject category) {
        this.category = category;
        editting = category != null;
    }
    
    protected void onRender(Element parent, int index) {
        super.onRender(parent, index);
        System.out.println("----------NewCategory");
        add(contentPanel);
       
        contentPanel.createPanel(ICategory.NAME, "分类名称:", new TextBox());                        
        contentPanel.createPanel(ICategory.PARENT, "上级分类:", c_parent);        
        contentPanel.createPanel(ICategory.MEASUREUNIT, "数量单位:", new TextBox());
        contentPanel.createPanel(ICategory.SORTORDER, "排序:", new TextBox());
        contentPanel.createPanel(ICategory.SHOW, "是否显示:", new CheckBox());
        contentPanel.createPanel(ICategory.SHOWINNAVIGATOR, "是否显示在导航栏:", new CheckBox());
        contentPanel.createPanel(ICategory.GRADE, "价格区间个数:", new TextBox());
        contentPanel.createPanel(ICategory.STYLE, "分类的样式表文件:", new TextBox());
        contentPanel.createPanel(ICategory.KEYWORDS, "关键字:", new TextBox());
        contentPanel.createPanel(ICategory.DESC, "分类描述:", new TextArea());
        
        HorizontalPanel panel = new HorizontalPanel();
        panel.setSpacing(10);
        btnNew.setText("确定");        
        btnCancel.setText("重置");
        panel.add(btnNew);        
        panel.add(btnCancel);
        contentPanel.createPanel(null, null, panel);      
        
        btnNew.addClickListener(new ClickListener() {
            public void onClick(Widget sender) {
                String id = category != null ? category.getString(ICategory.ID) : null;
                category = new BeanObject(ModelNames.CATEGORY, contentPanel.getValues());
                if (editting) {
                    new UpdateService().updateBean(id, category, null);
                    iShop.getInstance().displayCategoryInfo();
                    Info.display("恭喜", "完成修改商品分类.");
                } else {
                    new CreateService().createBean(category, new CreateService.Listener() {
                        public synchronized void onSuccess(String id) {
                        	iShop.getInstance().displayCategoryInfo();
                            Info.display("恭喜", "完成添加商品分类.");
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
    	c_parent.clear();
    	c_parent.addItem("",null);
        
        new ListService().listBeans(ModelNames.CATEGORY, new ListService.Listener() {            
            public synchronized void onSuccess(List<BeanObject> beans) {
                for (Iterator<BeanObject> it = beans.iterator(); it.hasNext();) {
                    BeanObject category = it.next();                    
                    c_parent.addItem(category.getString(ICategory.NAME), category.getString(ICategory.ID));
                }               
            }
        });
        
        if (this.category!=null&&this.category.getString(ICategory.ID) != null) {
            categorys.put(this.category.getString(ICategory.ID), this.category);
            Map<String, Object> mapCategory = category.getProperties();
            contentPanel.updateValues(mapCategory);
        }
        else{
        	contentPanel.clearValues();
            editting = false;
            }
    }
}
