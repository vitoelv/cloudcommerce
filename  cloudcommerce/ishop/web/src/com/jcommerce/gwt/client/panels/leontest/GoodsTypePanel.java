package com.jcommerce.gwt.client.panels.leontest;

import java.util.Map;

import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.jcommerce.gwt.client.ContentWidget;
import com.jcommerce.gwt.client.ModelNames;
import com.jcommerce.gwt.client.ValidationException;
import com.jcommerce.gwt.client.model.BeanObject;
import com.jcommerce.gwt.client.model.GoodsTypeForm;
import com.jcommerce.gwt.client.panels.Success;
import com.jcommerce.gwt.client.service.CreateService;
import com.jcommerce.gwt.client.service.ReadService;
import com.jcommerce.gwt.client.service.UpdateService;
import com.jcommerce.gwt.client.widgets.ColumnPanel;

public class GoodsTypePanel extends ContentWidget {
	public static interface Constants {
//		String GoodsType_Name();

	}
	
	
	public static class State extends PageState {
		public static final String ISEDIT = "isedit";
		public static final String GOODSTYPEID = "gtid";
		
		public String getPageClassName() {
			return GoodsTypePanel.class.getName();
		}
		
		public void setIsEdit(boolean isEdit){
			setValue(ISEDIT, String.valueOf(isEdit));
		}
		public boolean getIsEdit() {
			return Boolean.valueOf((String)getValue(ISEDIT)).booleanValue();
		}
		public void setGoodsTypeID(String gtid) {
			setValue(GOODSTYPEID, gtid);
		}
		public String getGoodsTypeID() {
			return (String)getValue(GOODSTYPEID);
		}
	}
	

	
	private ColumnPanel contentPanel = new ColumnPanel();
	private State curState = new State();
	
	private static GoodsTypePanel instance;
	private GoodsTypePanel() {
		
	}
	public static GoodsTypePanel getInstance(){
		if(instance == null) {
			instance = new GoodsTypePanel();
		}
		return instance;
	}
	
	@Override
	public String getDescription() {
        return "cwBasicTextDescription";
	}

	@Override
	public String getName() {
        return "商品类型-李咏版";
	}
	
    protected void onRender(Element parent, int index) {
    	super.onRender(parent, index);
        System.out.println("----------GoodsType");
        add(contentPanel);
        
        contentPanel.createPanel(GoodsTypeForm.NAME, "商品类型名称：", new TextBox());      
        TextArea valuesArea = new TextArea();
        valuesArea.setHeight("180px");
        valuesArea.setWidth("100px");
        contentPanel.createPanel(GoodsTypeForm.ATTRIBUTEGROUP, "属性分组：", valuesArea);       
        
        
        Button btnNew = new Button();    
        Button btnCancel = new Button();    
        HorizontalPanel panel = new HorizontalPanel();
        panel.setSpacing(10);
        btnNew.setText("确定");        
        btnCancel.setText("重置");
        panel.add(btnNew);        
        panel.add(btnCancel);
        contentPanel.createPanel(null, null, panel);      
        
        btnNew.addClickListener(new ClickListener() {
            public void onClick(Widget sender) {
                String id = getCurState().getGoodsTypeID();
                GoodsTypeForm goodsType = new GoodsTypeForm(ModelNames.GOODSTYPE, contentPanel.getValues());
                String name = goodsType.get(GoodsTypeForm.NAME);
                System.out.println("name: "+name);
                name = (String)contentPanel.getValue(GoodsTypeForm.NAME);
                System.out.println("name: "+name);
                try {
                	goodsType.validate();
                } catch (ValidationException ex){
                	// TODO leon need a common validation handling 
                	Window.alert(ex.getMessage());
                	return;
                }
                
                if (getCurState().getIsEdit()) {
                    new UpdateService().updateBean(id, goodsType, new UpdateService.Listener() {
                        public synchronized void onSuccess(Boolean success) {
                        	
                        	Success.State newState = new Success.State();
                        	newState.setMessage("编辑商品类型成功");
                        	
                        	GoodsTypeListPanel.State choice1 = new GoodsTypeListPanel.State();
                        	newState.addChoice(GoodsTypeListPanel.getInstance().getName(), choice1.getFullHistoryToken());
                        	
                        	newState.execute();
                        }
                    });
                    
                } else {
                    new CreateService().createBean(goodsType, new CreateService.Listener() {
                        public synchronized void onSuccess(String id) {
                            System.out.println("new onSuccess( "+id);                            
                            getCurState().setGoodsTypeID(id);
                            System.out.println("1 b_list.addItem("+id);
//                            attributes.put(id, attribute);
                            contentPanel.setValue(GoodsTypeForm.ID, id);
                            

                        	Success.State newState = new Success.State();
                        	newState.setMessage("编辑商品类型成功");
                        	
                        	GoodsTypeListPanel.State choice1 = new GoodsTypeListPanel.State();
                        	newState.addChoice(GoodsTypeListPanel.getInstance().getName(), choice1.getFullHistoryToken());
                        	
                        	newState.execute();
                            
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

	public State getCurState() {
		return curState;
	}

	public void setCurState(State curState) {
		this.curState = curState;
	}
	
    public void refresh() {
        contentPanel.clearValues();
        if(getCurState().getIsEdit()) {
        	new ReadService().getBean(ModelNames.GOODSTYPE, getCurState().getGoodsTypeID(),
				new ReadService.Listener() {
        		public void onSuccess(BeanObject bean) {
        			Map<String, Object> mapAttribute = bean.getProperties();
        			// NOTE by Leon
        			// this will not correctly set the selected value for lstGoodsType, 
        			// as the last async query for listGoodsType has not finished
        			contentPanel.updateValues(mapAttribute);
        		}
        	});
        }

    }
}
