/**
 * @author KingZhao 
 * @time 2009.02.02
 */
package com.jcommerce.gwt.client.panels;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.PagingToolBar;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.CheckBoxSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.jcommerce.gwt.client.ContentWidget;
import com.jcommerce.gwt.client.ModelNames;
import com.jcommerce.gwt.client.iShop;
import com.jcommerce.gwt.client.model.BeanObject;
import com.jcommerce.gwt.client.model.IUser;
import com.jcommerce.gwt.client.panels.leontest.PageState;
import com.jcommerce.gwt.client.resources.Resources;
import com.jcommerce.gwt.client.service.Condition;
import com.jcommerce.gwt.client.service.Criteria;
import com.jcommerce.gwt.client.service.DeleteService;
import com.jcommerce.gwt.client.service.PagingListService;
import com.jcommerce.gwt.client.service.ReadService;
import com.jcommerce.gwt.client.service.UpdateService;
import com.jcommerce.gwt.client.service.WaitService;
import com.jcommerce.gwt.client.widgets.ActionCellRenderer;
import com.jcommerce.gwt.client.widgets.ColumnPanel;


public class MemberList extends ContentWidget {	

	ColumnPanel contentPanel = new ColumnPanel();	
	TextBox commentContent = new TextBox();		
	Button btnFind = new Button(Resources.constants.GoodsList_search());	
	ListBox lstAction = new ListBox();
	ListBox rankList = new ListBox();
	Button btnAct = new Button(Resources.constants.GoodsList_action_OK());
	Criteria criteria = new Criteria();
    int deleteSize = 1;
	PagingToolBar toolBar;
	
	public static class State extends PageState {
		public String getPageClassName() {
			return MemberList.class.getName();
		}
		public String getMenuDisplayName() {
			return "会员列表";
		}
	}
	private State curState = new State();
	public State getCurState() {
		return curState;
	}
	public void setCurState(State curState) {
		this.curState = curState;
	}

	public MemberList() {
		add(contentPanel);
		initJS(this);
	}

	public String getDescription() {
		return "cwBasicTextDescription";
	}

	public String getName() {
		return "会员列表";
	}

	protected void onRender(Element parent, int index) {
		super.onRender(parent, index);
//		Condition cond = new Condition();
//		cond.setField(IComment.PARENT);
//		cond.setOperator(Condition.EQUALS);
//		cond.setValue(null);
//		criteria.addCondition(cond);
		BasePagingLoader loader = new PagingListService().getLoader(ModelNames.USER, criteria);
		loader.load(0, 10);

		final ListStore<BeanObject> store = new ListStore<BeanObject>(loader);
		
		toolBar = new PagingToolBar(10);
		toolBar.bind(loader);

		List<ColumnConfig> columns = new ArrayList<ColumnConfig>();
		final CheckBoxSelectionModel<BeanObject> smRowSelection = new CheckBoxSelectionModel<BeanObject>();
		columns.add(smRowSelection.getColumn());
		columns.add(new ColumnConfig(IUser.ID, "编号", 70));
		columns.add(new ColumnConfig(IUser.NAME, "会员名称", 90));	
		columns.add(new ColumnConfig(IUser.EMAIL, "邮件地址", 180));
		columns.add(new ColumnConfig(IUser.REGISTERTIME,"注册时间",150));		
		
		ColumnConfig actcol = new ColumnConfig("Action", Resources.constants.GoodsList_action(), 120);
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
		act.setAction("checkMemberAction($id)");
		act.setTooltip("编辑");
		render.addAction(act);
		act = new ActionCellRenderer.ActionInfo();		
		act.setImage("book_open.gif");
		act.setAction("memberAddressAction($id)");
		act.setTooltip("收货地址");
		render.addAction(act);
		act = new ActionCellRenderer.ActionInfo();		
		act.setImage("icon_view.gif");
		act.setAction("memberOrderAction($id)");
		act.setTooltip("查看订单");
		render.addAction(act);
		act = new ActionCellRenderer.ActionInfo();		
		act.setImage("icon_account.gif");
		act.setAction("memberAccountAction($id)");
		act.setTooltip("查看账目明细");
		render.addAction(act);		
		act = new ActionCellRenderer.ActionInfo();		
		act.setImage("icon_trash.gif");
		act.setAction("deleteMemberAction($id)");
		act.setTooltip("删除");
		render.addAction(act);

		actcol.setRenderer(render);
		
	
		
		HorizontalPanel header = new HorizontalPanel();
		header.add(Resources.images.icon_search().createImage());
		header.add(new Label("会员等级"));
		header.add(rankList);		
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

		add(panel);
		//添加下面一行的操作BUTTON 及 listener  包括  删除评论 允许显示 禁止显示
		lstAction.addItem("请选择...", "---");
		lstAction.addItem("删除会员", "delete");				
		btnAct.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				int index = lstAction.getSelectedIndex();
				if (index == 0) {
					// it is prompt
					return;
				}

				String sel = lstAction.getValue(index);
				final List<BeanObject> items = smRowSelection
						.getSelectedItems();
				executeAction(items, sel);
			}
		});

		HorizontalPanel footer = new HorizontalPanel();
		footer.add(lstAction);
		footer.add(btnAct);
		add(footer);
	}

	private void updateComment(BeanObject members, UpdateService.Listener listener) {
		new UpdateService().updateBean(members.getString(IUser.ID), members,
				listener);
	}
	
	private void search() {
		criteria.removeAllConditions();		
		if (commentContent.getText().length() != 0) {
			String content = commentContent.getText();
			Condition cond = new Condition();
			cond.setField(IUser.RANK);
			cond.setOperator(Condition.EQUALS);
			cond.setValue(content.trim());
			criteria.addCondition(cond);
		}	
		else{
			System.out.println("Input nothing!");
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
				deleteComment(item.getString(IUser.ID), listener);
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

	private native void initJS(MemberList me) /*-{
	   $wnd.deleteMemberAction = function (id) {
	       me.@com.jcommerce.gwt.client.panels.MemberList::deleteMemberAndRefrsh(Ljava/lang/String;)(id);
	   };
	   $wnd.checkMemberAction = function (id) {
	       me.@com.jcommerce.gwt.client.panels.MemberList::checkMember(Ljava/lang/String;)(id);
	   };
	   $wnd.memberAddressAction = function (id) {
	       me.@com.jcommerce.gwt.client.panels.MemberList::checkMemberAddress(Ljava/lang/String;)(id);
	   };
	   
	   }-*/;

	private void deleteComment(String id, DeleteService.Listener listener) {
		new DeleteService().deleteBean(ModelNames.USER, id, listener);
	}

	private void deleteMemberAndRefrsh(final String id) {
		new DeleteService().deleteBean(ModelNames.USER, id,
				new DeleteService.Listener() {
					public void onSuccess(Boolean success) {
						iShop.getInstance().displayUserComments();
					}
				});		
	}
	private void checkMember(String id) {
		new ReadService().getBean(ModelNames.USER, id,
				new ReadService.Listener() {
					public void onSuccess(BeanObject bean) {
						iShop.getInstance().displayMemberInfo(bean);
					}
				});
	}
	private void checkMemberAddress(String id) {		
		iShop.getInstance().displayMemberAddresses(id);		
	}

	public void refresh(){
    	toolBar.refresh();
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
