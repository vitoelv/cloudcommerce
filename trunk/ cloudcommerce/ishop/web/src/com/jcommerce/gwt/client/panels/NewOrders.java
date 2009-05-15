/**
 * @author KingZhao
 */

package com.jcommerce.gwt.client.panels;

import com.extjs.gxt.ui.client.Events;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.CardLayout;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.jcommerce.gwt.client.ContentWidget;
import com.jcommerce.gwt.client.ModelNames;
import com.jcommerce.gwt.client.iShop;
import com.jcommerce.gwt.client.model.BeanObject;
import com.jcommerce.gwt.client.model.IUser;
import com.jcommerce.gwt.client.panels.leontest.PageState;
import com.jcommerce.gwt.client.widgets.ColumnPanel;
import com.jcommerce.gwt.client.widgets.ValueSelector;


public class NewOrders extends ContentWidget {

	ColumnPanel contentPanel = new ColumnPanel();
	ColumnPanel contentPanelData = new ColumnPanel();

	//ListBox o_list = new ListBox();
	//Button btnNew = new Button();
	//Button btnDelete = new Button();
	//Button btnUpdate = new Button();
	//Button btnCancel = new Button();
	//HashMap<String, BeanObject> orders = new HashMap<String, BeanObject>();
	BasePagingLoader loader;
	ListStore<BeanObject> store;
	Grid<BeanObject> grid;	
	
	public static class State extends PageState {
		public String getPageClassName() {
			return NewOrders.class.getName();
		}
		
		public String getMenuDisplayName() {
			return "添加订单";
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
		return "添加订单";
	}

	/**
	 * Initialize this example.
	 */
	public NewOrders() {
		add(contentPanel);
		final ContentPanel cardPanel = new ContentPanel();
		cardPanel.setHeading("添加订单向导");
		cardPanel.setWidth(780);
		final CardLayout cardLayout = new CardLayout();
		cardPanel.setLayout(cardLayout);
		//选择用户页面
		final ColumnPanel userPanel = new ColumnPanel();
		//userPanel.setLayout(new FillLayout());
		userPanel.setTitle("请您选择要为哪个会员下订单");
		VerticalPanel searchUserPanel = new VerticalPanel();		
		RadioButton noUser = new RadioButton(IUser.NAME, "匿名用户");	
		RadioButton searchUser = new RadioButton(IUser.NAME, "按会员编号或会员名搜索");				
		noUser.setChecked(true);
		searchUserPanel.add(noUser);
		searchUserPanel.add(searchUser);
		userPanel.createPanel(IUser.NAME,"",searchUserPanel);
		ValueSelector userselect = new ValueSelector();
		userselect.setBean(ModelNames.USER);
		userselect.setCaption("Select User");
		userselect.setMessage("Select User");
		userPanel.createPanel(IUser.NAME, "", userselect);
		userPanel.add(new Label("注意：搜索结果只显示前20条记录，如果没有找到相应会员，请更精确地查找。"));
		cardPanel.add(userPanel);
		cardLayout.setActiveItem(userPanel);
		//选择商品页面
		final ContentPanel goodsPanel = new ContentPanel();
		goodsPanel.setHeading("选择商品");
		goodsPanel.add(new Label("select goods"));
		cardPanel.add(goodsPanel);
		//设置收货人页面
		final ContentPanel consigneePanel = new ContentPanel();
		consigneePanel.setHeading("设置收货人信息");
		consigneePanel.add(new Label("set consignee"));
		cardPanel.add(consigneePanel);
		//选择配送方式
		final ContentPanel shippingPanel = new ContentPanel();
		shippingPanel.setHeading("选择配送方式");
		shippingPanel.add(new Label("select shipping"));
		cardPanel.add(shippingPanel);
		//选择支付方式
		final ContentPanel payPanel = new ContentPanel();
		payPanel.setHeading("选择支付方式");
		payPanel.add(new Label("select pay"));
		cardPanel.add(payPanel);
		//设置其他信息
		final ContentPanel otherPanel = new ContentPanel();
		otherPanel.setHeading("设置其他信息");
		otherPanel.add(new Label("select other"));
		cardPanel.add(otherPanel);
		//设置费用
		
		

		contentPanel.add(cardPanel, new BorderLayoutData(LayoutRegion.CENTER,
				.35f, 50, 100));

		ButtonBar buttonBar = new ButtonBar();

		final Button swapButton = new Button("下一步");
		swapButton.addListener(Events.OnClick, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				if (cardLayout.getActiveItem() == userPanel)
					cardLayout.setActiveItem(goodsPanel);
				else if (cardLayout.getActiveItem() == goodsPanel) {
					cardLayout.setActiveItem(consigneePanel);
					
				} 
				else if(cardLayout.getActiveItem() == consigneePanel){
					cardLayout.setActiveItem(shippingPanel);
				}
				else if(cardLayout.getActiveItem() == shippingPanel){
					cardLayout.setActiveItem(payPanel);
					
				}
				else if(cardLayout.getActiveItem() == payPanel){
					cardLayout.setActiveItem(otherPanel);
					swapButton.setText("完成");
				}
				else if(cardLayout.getActiveItem() == otherPanel){
					Info.display("恭喜", "完成添加订单.");
					swapButton.setText("下一步");
				    cardLayout.setActiveItem(userPanel);
				}
				cardPanel.layout();
			}
		});
		buttonBar.add(swapButton);

		Button addButton = new Button("取消");
		addButton.addListener(Events.OnClick, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				iShop.getInstance().displayOrderList();
			}
		});
		buttonBar.add(addButton);

		contentPanel.add(buttonBar, new BorderLayoutData(LayoutRegion.SOUTH,
				.25f, 50, 100));
		contentPanel.layout();
	}
}
