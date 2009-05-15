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
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.PagingToolBar;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.CheckBoxSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.CheckColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.jcommerce.core.model.Order;
import com.jcommerce.gwt.client.ContentWidget;
import com.jcommerce.gwt.client.ModelNames;
import com.jcommerce.gwt.client.iShop;
import com.jcommerce.gwt.client.model.BeanObject;
import com.jcommerce.gwt.client.model.IAttribute;
import com.jcommerce.gwt.client.model.IBrand;
import com.jcommerce.gwt.client.model.ICategory;
import com.jcommerce.gwt.client.model.IGoods;
import com.jcommerce.gwt.client.model.IGoodsType;
import com.jcommerce.gwt.client.model.IOrder;
import com.jcommerce.gwt.client.model.IOrderGoods;
import com.jcommerce.gwt.client.panels.GoodsTypeInfo.State;
import com.jcommerce.gwt.client.panels.leontest.PageState;
import com.jcommerce.gwt.client.resources.Resources;
import com.jcommerce.gwt.client.service.Condition;
import com.jcommerce.gwt.client.service.CreateService;
import com.jcommerce.gwt.client.service.Criteria;
import com.jcommerce.gwt.client.service.DeleteService;
import com.jcommerce.gwt.client.service.ListService;
import com.jcommerce.gwt.client.service.PagingListService;
import com.jcommerce.gwt.client.service.ReadService;
import com.jcommerce.gwt.client.service.UpdateService;
import com.jcommerce.gwt.client.service.WaitService;
import com.jcommerce.gwt.client.widgets.ActionCellRenderer;
import com.jcommerce.gwt.client.widgets.ColumnPanel;

public class OrderList extends ContentWidget {	

	ColumnPanel contentPanel = new ColumnPanel();
	ListBox b_list = new ListBox();	
	TextBox orderNumber = new TextBox();	
	TextBox consignee = new TextBox();
	ListBox orderState = new ListBox();	
	Button btnFind = new Button(Resources.constants.GoodsList_search());	
	Button btnAct = new Button("确认");

	Criteria criteria = new Criteria();
    int deleteSize = 1;
	PagingToolBar toolBar;

	public OrderList() {
		add(contentPanel);
		initJS(this);

	}
	
	public static class State extends PageState {
		public String getPageClassName() {
			return OrderList.class.getName();
		}
		public String getMenuDisplayName() {
			return Resources.constants.OrderList_title();
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
		return Resources.constants.OrderList_title();
	}

	protected void onRender(Element parent, int index) {
		super.onRender(parent, index);

		BasePagingLoader loader = new PagingListService().getLoader(ModelNames.ORDER, criteria);
		loader.load(0, 10);

		final ListStore<BeanObject> store = new ListStore<BeanObject>(loader);
		
		toolBar = new PagingToolBar(10);
		toolBar.bind(loader);

		List<ColumnConfig> columns = new ArrayList<ColumnConfig>();
		final CheckBoxSelectionModel<BeanObject> smRowSelection = new CheckBoxSelectionModel<BeanObject>();
		columns.add(smRowSelection.getColumn());
		columns.add(new ColumnConfig(IOrder.SN, Resources.constants.OrderList_orderSN(), 75));
		columns.add(new ColumnConfig(IOrder.ADDTIME, Resources.constants.OrderList_addTime(), 104));
		columns.add(new ColumnConfig(IOrder.USER, "下单用户", 60));
		columns.add(new ColumnConfig(IOrder.CONSIGNEE, Resources.constants.OrderList_consignee(), 50));
		columns.add(new ColumnConfig(IOrder.ADDRESS, "收货地址", 120));		
		columns.add(new ColumnConfig(IOrder.GOODSAMOUNT,Resources.constants.OrderList_totalAmount(), 50));		
		columns.add(new ColumnConfig(IOrder.ORDERAMOUNT,Resources.constants.OrderList_shouldPay(), 60));		
		columns.add(new ColumnConfig(IOrder.STATUS,Resources.constants.OrderList_state(), 60));		
		columns.add(new ColumnConfig(IOrder.SHIPPINGSTATUS,"配送状态", 60));		
		columns.add(new ColumnConfig(IOrder.PAYSTATUS,"付款状态", 60));	
		ColumnConfig actcol = new ColumnConfig("Action", Resources.constants.GoodsList_action(), 65);
		columns.add(actcol);

		ColumnModel cm = new ColumnModel(columns);

		Grid<BeanObject> grid = new EditorGrid<BeanObject>(store, cm);
		grid.setLoadMask(true);
		grid.setBorders(true);
		grid.setSelectionModel(smRowSelection);
		//   grid.setAutoExpandColumn("forum");
		

		ActionCellRenderer render = new ActionCellRenderer(grid);
		ActionCellRenderer.ActionInfo act = new ActionCellRenderer.ActionInfo();
		act.setImage("icon_edit.gif");
		act.setAction("checkOrder($id)");
		act.setTooltip("查看");
		render.addAction(act);
		act = new ActionCellRenderer.ActionInfo();		
		act.setImage("icon_trash.gif");
		act.setAction("deleteOrder($id)");
		act.setTooltip("删除");
		render.addAction(act);

		actcol.setRenderer(render);
		
		orderState.addItem("请选择...", "choice");
		orderState.addItem("待确认", "unconfirmed");
		orderState.addItem("待付款", "unpayed");		
		orderState.addItem("待发货", "unshipped");
		orderState.addItem("已完成","finished");
		orderState.addItem("取消","canceled");
		orderState.addItem("无效","invalid");
		orderState.addItem("退货","returned");
		orderState.setSelectedIndex(0);
		
		HorizontalPanel header = new HorizontalPanel();
		header.add(Resources.images.icon_search().createImage());
		header.add(new Label("订单号"));
		header.add(orderNumber);
		header.add(new Label("收货人"));
		header.add(consignee);
		header.add(new Label("订单状态"));
		header.add(orderState);		
		header.add(btnFind);
		add(header);

		btnFind.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				search();
			}
		});

		ContentPanel panel = new ContentPanel();
		panel.setFrame(true);
		panel.setCollapsible(true);
		panel.setAnimCollapse(false);
		panel.setButtonAlign(HorizontalAlignment.CENTER);
		panel.setIconStyle("icon-table");
		//        panel.setHeading("Paging Grid");
		panel.setLayout(new FitLayout());
		panel.add(grid);
		panel.setSize(800, 350);
		panel.setBottomComponent(toolBar);

		panel.setButtonAlign(HorizontalAlignment.CENTER);
		

		//添加下面一行的操作BUTTON 及 listener  包括  确认  取消  移除  打印订单

		add(panel);
		
	}

	private void updateGoods(BeanObject goods, UpdateService.Listener listener) {
		new UpdateService().updateBean(goods.getString(IGoods.ID), goods,
				listener);
	}
	
	private void search() {
		criteria.removeAllConditions();
		if (consignee.getText().length() != 0) {
			String consign = consignee.getText();
			Condition cond = new Condition();
			cond.setField(IOrder.CONSIGNEE);
			cond.setOperator(Condition.EQUALS);
			cond.setValue(consign.trim());
			criteria.addCondition(cond);
		}
		if (orderNumber.getText().length() != 0) {
			String SN = orderNumber.getText();
			Condition cond = new Condition();
			cond.setField(IOrder.SN);
			cond.setOperator(Condition.CONTAINS);
			cond.setValue(SN.trim());
			criteria.addCondition(cond);
		}
		String state = orderState.getValue(orderState.getSelectedIndex());
		if ("unconfirmed".equals(state)) {
			Condition cond = new Condition();
			cond.setField(IOrder.STATUS);
			cond.setOperator(Condition.EQUALS);
			cond.setValue("0");
			criteria.addCondition(cond);
		} else if ("unpayed".equals(state)) {
			Condition cond = new Condition();
			cond.setField(IOrder.PAYSTATUS);
			cond.setOperator(Condition.EQUALS);
			cond.setValue("0");
			criteria.addCondition(cond);
		} else if ("unshipped".equals(state)) {
			Condition cond = new Condition();
			cond.setField(IOrder.SHIPPINGSTATUS);
			cond.setOperator(Condition.EQUALS);
			cond.setValue("0");
			criteria.addCondition(cond);
		} else if ("finished".equals(state)) {
			Condition cond = new Condition();
			cond.setField(IOrder.PAYSTATUS);
			cond.setOperator(Condition.EQUALS);
			cond.setValue("2");
			criteria.addCondition(cond);
		} else if ("canceled".equals(state)) {
			Condition cond = new Condition();
			cond.setField(IOrder.STATUS);
			cond.setOperator(Condition.EQUALS);
			cond.setValue("2");
			criteria.addCondition(cond);
		} else if ("invalid".equals(state)) {
			Condition cond = new Condition();
			cond.setField(IOrder.STATUS);
			cond.setOperator(Condition.EQUALS);
			cond.setValue("3");
		criteria.addCondition(cond);
		} else if ("returned".equals(state)) {
			Condition cond = new Condition();
			cond.setField(IOrder.STATUS);
			cond.setOperator(Condition.EQUALS);
			cond.setValue("4");
			criteria.addCondition(cond);
		} else{
			System.out.println("not select anything!");
		}

		toolBar.refresh();
	}

	private void executeAction(final List<BeanObject> items, String action) {
		if (items == null) {
			return;
		}

		final List listeners = new ArrayList();

		for (BeanObject item : items) {
			if ("delete".equals(action)) {
				DeleteListener listener = new DeleteListener();
				listeners.add(listener);
				deleteGoods(item.getString(IGoods.ID), listener);
			} else if ("new".equals(action)) {
				if (!Boolean.TRUE.equals(item.get(IGoods.NEWADDED))) {
					item.set(IGoods.NEWADDED, Boolean.TRUE);
					UpdateListener listener = new UpdateListener();
					listeners.add(listener);
					updateGoods(item, listener);
				}
			} else if ("notnew".equals(action)) {
				if (!Boolean.FALSE.equals(item.get(IGoods.NEWADDED))) {
					item.set(IGoods.NEWADDED, Boolean.FALSE);
					UpdateListener listener = new UpdateListener();
					listeners.add(listener);
					updateGoods(item, listener);
				}
			} else if ("hot".equals(action)) {
				if (!Boolean.TRUE.equals(item.get(IGoods.HOTSOLD))) {
					item.set(IGoods.HOTSOLD, Boolean.TRUE);
					UpdateListener listener = new UpdateListener();
					listeners.add(listener);
					updateGoods(item, listener);
				}
			} else if ("nothot".equals(action)) {
				if (!Boolean.FALSE.equals(item.get(IGoods.HOTSOLD))) {
					item.set(IGoods.HOTSOLD, Boolean.FALSE);
					UpdateListener listener = new UpdateListener();
					listeners.add(listener);
					updateGoods(item, listener);
				}
			} else if ("best".equals(action)) {
				if (!Boolean.TRUE.equals(item.get(IGoods.BESTSOLD))) {
					item.set(IGoods.BESTSOLD, Boolean.TRUE);
					UpdateListener listener = new UpdateListener();
					listeners.add(listener);
					updateGoods(item, listener);
				}
			} else if ("notbest".equals(action)) {
				if (!Boolean.FALSE.equals(item.get(IGoods.BESTSOLD))) {
					item.set(IGoods.BESTSOLD, Boolean.FALSE);
					UpdateListener listener = new UpdateListener();
					listeners.add(listener);
					updateGoods(item, listener);
				}
			}
		}

		new WaitService(new WaitService.Job() {
			public boolean isReady() {
				if (listeners.size() != items.size()) {
					return false;
				}
				for (int i = 0; i < listeners.size(); i++) {
					if (listeners.get(i) instanceof DeleteListener) {
						if (!((DeleteListener) listeners.get(i)).isFinished()) {
							return false;
						}
					} else if (listeners.get(i) instanceof UpdateListener) {
						if (!((UpdateListener) listeners.get(i)).isFinished()) {
							return false;
						}
					} else {
						throw new RuntimeException("Unknown listener type:"
								+ listeners.get(i));
					}
				}
				return false;
			}

			public void run() {
				toolBar.refresh();
			}
		});
	}

	private native void initJS(OrderList me) /*-{
	   $wnd.deleteOrder = function (id) {
	       me.@com.jcommerce.gwt.client.panels.OrderList::deleteOrderAndRefrsh(Ljava/lang/String;)(id);
	   };
	   $wnd.checkOrder = function (id) {
	       me.@com.jcommerce.gwt.client.panels.OrderList::checkOrder(Ljava/lang/String;)(id);
	   };
	   }-*/;

	private void deleteGoods(String id, DeleteService.Listener listener) {
		new DeleteService().deleteBean(ModelNames.ORDER, id, listener);
	}

	private void deleteOrderAndRefrsh(final String id) {		
		new WaitService(new WaitService.Job() {			
            public boolean isReady() {
            	Condition cond = new Condition();
        		cond.setField(IOrderGoods.ORDER);
        		cond.setOperator(Condition.EQUALS);		
        		cond.setValue(id);
        		Criteria cri = new Criteria();
        		cri.addCondition(cond);
        		
            	new ListService().listBeans(ModelNames.ORDERGOODS, cri, new ListService.Listener() {									
        			public synchronized void onSuccess(List<BeanObject> result) {        				
        				
        				for (Iterator<BeanObject> it = result.iterator(); it.hasNext();) {
        					deleteSize = result.size();
        					BeanObject orderGoods = it.next();
        					new DeleteService().deleteBean(ModelNames.ORDERGOODS, orderGoods.getString(IOrderGoods.ID),
        							new DeleteService.Listener() {
        								public void onSuccess(Boolean success) {        									
        									deleteSize--;
        								}
        							});         					
        				}         				
        			}        			
        		});
            	if(deleteSize != 0){            		
            		return false;
            	}
            	else{            		
            		return true;
            	}
            }
            public void run() {
            	new DeleteService().deleteBean(ModelNames.ORDER, id,
        				new DeleteService.Listener() {
        					public void onSuccess(Boolean success) {
        						toolBar.refresh();
        					}
        				});
            }
        });	
	}
	private void checkOrder(String id) {
		new ReadService().getBean(ModelNames.ORDER, id,
				new ReadService.Listener() {
					public void onSuccess(BeanObject bean) {
						iShop.getInstance().displayOrderInfo(bean);
					}
				});
	}

	class DeleteListener extends DeleteService.Listener {
		private boolean finished = false;

		public void onSuccess(Boolean sucess) {
			finished = true;
		}

		public void onFailure(Throwable caught) {
			finished = true;
		}

		boolean isFinished() {
			return finished;
		}
	}

	class UpdateListener extends UpdateService.Listener {
		private boolean finished = false;

		public void onSuccess(Boolean sucess) {
			finished = true;
		}

		public void onFailure(Throwable caught) {
			finished = true;
		}

		boolean isFinished() {
			return finished;
		}
	}
}
