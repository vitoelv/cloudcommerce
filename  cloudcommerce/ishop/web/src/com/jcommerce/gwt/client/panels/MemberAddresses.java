/**
 *@author KingZhao
 *@time 2009.02.03
 */
package com.jcommerce.gwt.client.panels;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.PagingToolBar;
import com.extjs.gxt.ui.client.widget.grid.CheckColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.jcommerce.gwt.client.ContentWidget;
import com.jcommerce.gwt.client.IShopServiceAsync;
import com.jcommerce.gwt.client.ModelNames;
import com.jcommerce.gwt.client.iShop;
import com.jcommerce.gwt.client.model.BeanObject;
import com.jcommerce.gwt.client.model.IAttribute;
import com.jcommerce.gwt.client.model.IBrand;
import com.jcommerce.gwt.client.model.IComment;
import com.jcommerce.gwt.client.model.IUserAddress;
import com.jcommerce.gwt.client.panels.leontest.PageState;
import com.jcommerce.gwt.client.resources.Resources;
import com.jcommerce.gwt.client.service.Condition;
import com.jcommerce.gwt.client.service.Criteria;
import com.jcommerce.gwt.client.service.DeleteService;
import com.jcommerce.gwt.client.service.PagingListService;
import com.jcommerce.gwt.client.widgets.ActionCellRenderer;
import com.jcommerce.gwt.client.widgets.ColumnPanel;

/**
 * Example file.
 */
public class MemberAddresses extends ContentWidget {    
	
	
    ListBox b_list = new ListBox();    
    
    ListBox lstAction = new ListBox();
    BasePagingLoader loader;
    ListStore<BeanObject> store;
    Grid<BeanObject> grid;
    private String member = null;
    PagingToolBar toolBar;    
    
	public static class State extends PageState {
		public String getPageClassName() {
			return MemberAddresses.class.getName();
		}
		public String getMenuDisplayName() {
			return "收货地址";
		}
	}
	
	private State curState = new State();
	public State getCurState() {
		return curState;
	}
	public void setCurState(State curState) {
		this.curState = curState;
	}
	
    public String getDescription() {
        return "cwBasicTextDescription";
    }

    public String getName() {
        return "收货地址";
    }
    
    public void setMember(String id) {
        this.member = id;
    }
    /**
     * Initialize this example.
     */
    public MemberAddresses() {
        System.out.println("----------MemberAddresses");
    }
    
    protected void onRender(Element parent, int index) {
    	super.onRender(parent, index);
    	
		if(this.member != null && this.member.length() != 0){
			Criteria criteria = new Criteria();
			Condition cond = new Condition();
			cond.setField(IUserAddress.USER);
			cond.setOperator(Condition.EQUALS);
			cond.setValue(member);
			criteria.addCondition(cond);
			this.loader = new PagingListService().getLoader(ModelNames.USERADDRESS,criteria);			
		}
		else{
		    Info.display("Sorry", "系统出错！");
		    this.loader = new PagingListService().getLoader(ModelNames.USERADDRESS);
		}
        
        this.loader.load(0, 50);
  	
        this.store = new ListStore<BeanObject>(loader);           
        toolBar = new PagingToolBar(50);
        toolBar.bind(loader);

        List<ColumnConfig> columns = new ArrayList<ColumnConfig>();
        //CheckBoxSelectionModel<BeanObject> sm = new CheckBoxSelectionModel<BeanObject>();
        //columns.add(sm.getColumn());        
        columns.add(new ColumnConfig(IUserAddress.CONSIGNEE, "收货人", 80));
        columns.add(new ColumnConfig(IUserAddress.ADDRESS, "收货地址", 100));
        columns.add(new ColumnConfig(IUserAddress.EMAIL, "电子邮件", 80));
        columns.add(new ColumnConfig(IUserAddress.MOBILE, "手机号", 80));
        columns.add(new ColumnConfig(IUserAddress.REGION, "区域", 80));
        columns.add(new ColumnConfig(IUserAddress.ZIP, "邮编", 80));
        columns.add(new ColumnConfig(IUserAddress.SIGNBUILDING, "标志建筑", 80));
        columns.add(new ColumnConfig(IUserAddress.BESTTIME, "最佳送货时间", 110));
        
        ColumnModel cm = new ColumnModel(columns);
        
        grid = new Grid<BeanObject>(this.store, cm);
        grid.setLoadMask(true);
        grid.setBorders(true);
        //grid.setSelectionModel(sm);
        //grid.setAutoExpandColumn("forum");
        
        ContentPanel panel = new ContentPanel();
        panel.setFrame(true);
        panel.setCollapsible(true);
        panel.setAnimCollapse(false);
        panel.setButtonAlign(HorizontalAlignment.CENTER);
        panel.setIconStyle("icon-table");
        panel.setHeading("Paging Grid");
        panel.setLayout(new FitLayout());
        panel.add(grid);
        panel.setSize(750, 350);
        panel.setBottomComponent(toolBar);     
        
        panel.setButtonAlign(HorizontalAlignment.CENTER);
        panel.addButton(new com.extjs.gxt.ui.client.widget.button.Button("会员列表", new SelectionListener<ButtonEvent>() {
          public void componentSelected(ButtonEvent ce) {
              iShop.getInstance().displayMemberList();
          }
        }));
        
        add(panel);       
    }    

    public void refresh(){
    	if (this.member != null&& !this.member.equals("0")) {
				Criteria criteria = new Criteria();
				Condition cond = new Condition();
				cond.setField(IUserAddress.USER);
				cond.setOperator(Condition.EQUALS);
				cond.setValue(member);
				criteria.addCondition(cond);
				loader = new PagingListService().getLoader(ModelNames.USERADDRESS,criteria);
				loader.load(0, 50);
				this.store.removeAll();
				this.store = new ListStore<BeanObject>(loader);				
				toolBar.clear();
				toolBar = new PagingToolBar(50);
				toolBar.bind(loader);
				List<ColumnConfig> columns = new ArrayList<ColumnConfig>();		             
		        columns.add(new ColumnConfig(IUserAddress.CONSIGNEE, "收货人", 80));
		        columns.add(new ColumnConfig(IUserAddress.ADDRESS, "收货地址", 100));
		        columns.add(new ColumnConfig(IUserAddress.EMAIL, "电子邮件", 80));
		        columns.add(new ColumnConfig(IUserAddress.MOBILE, "手机号", 80));
		        columns.add(new ColumnConfig(IUserAddress.REGION, "区域", 80));
		        columns.add(new ColumnConfig(IUserAddress.ZIP, "邮编", 80));
		        columns.add(new ColumnConfig(IUserAddress.SIGNBUILDING, "标志建筑", 80));
		        columns.add(new ColumnConfig(IUserAddress.BESTTIME, "最佳送货时间", 110));		        
		        ColumnModel cm = new ColumnModel(columns);		        
		        grid.reconfigure(store, cm);
				grid.setLoadMask(true);
				grid.setBorders(true);				
		}    	
    	toolBar.refresh();
    }
}
