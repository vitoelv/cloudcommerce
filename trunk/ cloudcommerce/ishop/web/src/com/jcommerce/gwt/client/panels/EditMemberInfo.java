/**
 * @author KingZhao 
 * @time 2009.02.02
 */
package com.jcommerce.gwt.client.panels;

import java.util.Map;

import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.jcommerce.gwt.client.ContentWidget;
import com.jcommerce.gwt.client.ModelNames;
import com.jcommerce.gwt.client.model.BeanObject;
import com.jcommerce.gwt.client.model.IBrand;
import com.jcommerce.gwt.client.model.IUser;
import com.jcommerce.gwt.client.panels.leontest.PageState;
import com.jcommerce.gwt.client.service.CreateService;
import com.jcommerce.gwt.client.widgets.ColumnPanel;
import com.jcommerce.gwt.client.widgets.DateWidget;
import com.jcommerce.gwt.client.widgets.ValueSelector;

/**
 * Example file.
 */
public class EditMemberInfo extends ContentWidget {

	ColumnPanel contentPanel = new ColumnPanel();
	Button btnOK = new Button();
	Button btnCancel = new Button();
	private BeanObject memberInfo = null;
	public static class State extends PageState {
		
		public String getPageClassName() {
			return EditMemberInfo.class.getName();
		}
		
		public String getMenuDisplayName() {
			return "添加会员";
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
		return "添加会员";
	}

	public void setMemberInfo(BeanObject memberInfo) {
        this.memberInfo = memberInfo;
    }
	/**
	 * Initialize this example.
	 */
	public EditMemberInfo() {
		add(contentPanel);
		TextBox userName = new TextBox();
		userName.setReadOnly(true);
		contentPanel.createPanel(IUser.NAME, "会员名称:", userName);		
		contentPanel.createPanel(IUser.MONEY, "可用资金:", new TextBox());
		//加入一个链入明细的链接。。。
		contentPanel.createPanel(null, "[查看明细]", null);
		
		contentPanel.createPanel(IUser.FROZENMONEY, "冻结资金:", new TextBox());
		contentPanel.createPanel(IUser.RANKPOINTS, "等级积分:", new TextBox());
		contentPanel.createPanel(IUser.PAYPOINTS, "消费积分:", new TextBox());
		contentPanel.createPanel(IUser.EMAIL, "邮件地址:", new TextBox());		
		ValueSelector selector = new ValueSelector();
		selector.setBean(ModelNames.USERRANK);
		selector.setCaption("Select RANK");
		selector.setMessage("Select RANK");
		contentPanel.createPanel(IUser.RANK, "会员等级:", selector);
		ListBox listsex = new ListBox();
		listsex.addItem("保密", "0");
		listsex.addItem("男", "1");
		listsex.addItem("女", "2");
		contentPanel.createPanel(IUser.SEX,"性别:",listsex);
		contentPanel.createPanel(IUser.BIRTHDAY, "出生日期:", new DateWidget());
		contentPanel.createPanel(IUser.CREDITLINE, "信用额度:", new TextBox());
		contentPanel.createPanel(IUser.MSN, "MSN:", new TextBox());
		contentPanel.createPanel(IUser.QQ, "QQ:", new TextBox());
		contentPanel.createPanel(IUser.OFFICEPHONE, "办公电话:", new TextBox());
		contentPanel.createPanel(IUser.HOMEPHONE, "家庭电话:", new TextBox());
		contentPanel.createPanel(IUser.MOBILEPHONE, "手机:", new TextBox());

		HorizontalPanel panel = new HorizontalPanel();
		panel.setSpacing(10);
		btnOK.setText("确定");
		btnCancel.setText("重置");
		panel.add(btnOK);
		panel.add(btnCancel);
		contentPanel.createPanel(null, null, panel);

		btnOK.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				Map<String, Object> args = contentPanel.getValues();
				new CreateService().createBean(new BeanObject(ModelNames.USER, args), null);
			}
		});

		btnCancel.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				contentPanel.clearValues();
			}
		});
	}
	
	public void refresh() {	
		contentPanel.clearValues();
        if (this.memberInfo!=null&&this.memberInfo.getString(IUser.ID) != null) {
        	Map<String, Object> mapMember = memberInfo.getProperties();
            System.out.println("wo hun mi :"+mapMember);
        	contentPanel.updateValues(mapMember);
        }
        else{        	
        	Info.display("Sorry", "抱歉没有找到相关信息.");
          }
    }
}
