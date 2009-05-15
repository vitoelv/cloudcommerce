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
package com.jcommerce.gwt.client.panels;

import java.util.Map;

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
import com.jcommerce.gwt.client.model.IUser;
import com.jcommerce.gwt.client.panels.leontest.PageState;
import com.jcommerce.gwt.client.service.CreateService;
import com.jcommerce.gwt.client.widgets.ColumnPanel;
import com.jcommerce.gwt.client.widgets.DateWidget;
import com.jcommerce.gwt.client.widgets.ValueSelector;

/**
 * Example file.
 */
public class NewUsers extends ContentWidget {

	ColumnPanel contentPanel = new ColumnPanel();	

	Button btnOK = new Button();
	Button btnCancel = new Button();

    // leon to integrate with history-based page navigation mechnism. 
    // State should contain all info needed to render this page.
    // This is a minimum skeleton, more fields may be added, see leontest.Attribute
	public static class State extends PageState {
		public String getPageClassName() {
			return NewUsers.class.getName();
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

	/**
	 * Initialize this example.
	 */
	public NewUsers() {
		add(contentPanel);
		contentPanel.createPanel(IUser.NAME, "会员名称:", new TextBox());
		//        createPanel(SN, "SN:", new TextBox());

		contentPanel.createPanel(IUser.EMAIL, "邮件地址:", new TextBox());
		contentPanel.createPanel(IUser.PASSWORD, "登陆密码:", new PasswordTextBox());
		contentPanel.createPanel(null, "确认密码:", new PasswordTextBox());
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
}
