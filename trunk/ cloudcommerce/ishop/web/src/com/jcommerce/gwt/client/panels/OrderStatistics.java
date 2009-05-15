package com.jcommerce.gwt.client.panels;

import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.jcommerce.gwt.client.ContentWidget;
import com.jcommerce.gwt.client.panels.leontest.PageState;
import com.jcommerce.gwt.client.widgets.ColumnPanel;

public class OrderStatistics extends ContentWidget {    	
    
    private Button btnNew = new Button();    
    private Button btnCancel = new Button();    
    private Button btnAllow = new Button();
    private ColumnPanel contentPanel = new ColumnPanel();   
    private VerticalPanel topStatistics = new VerticalPanel();//顶端统计信息显示
    private VerticalPanel searchconditions = new VerticalPanel();//统计搜索与显示
    
    private static OrderStatistics instance; 
    
    
    /**
     * Initialize this example.
     */
    public static OrderStatistics getInstance() {
    	if(instance==null) {
    		instance = new OrderStatistics();
    	}
    	return instance;
    }
    
    public OrderStatistics() {
    }
    
    // leon to integrate with history-based page navigation mechnism. 
    // State should contain all info needed to render this page.
    // This is a minimum skeleton, more fields may be added, see leontest.Attribute
	public static class State extends PageState {
		public String getPageClassName() {
			return OrderStatistics.class.getName();
		}
		
		public String getMenuDisplayName() {
			return "订单统计";
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
            return "订单统计"; 
    }
        
    protected void onRender(Element parent, int index) {
        super.onRender(parent, index);
        System.out.println("----------OrderStatistics");
        topStatistics.setWidth("100%");
        searchconditions.setWidth("100%");
        add(topStatistics);       
        add(searchconditions);
        searchconditions.setHorizontalAlignment(searchconditions.ALIGN_CENTER);        
        searchconditions.add(contentPanel);
        DecoratedTabPanel tabPanel = new DecoratedTabPanel();
        tabPanel.setWidth("100%");
        tabPanel.setAnimationEnabled(true);
        tabPanel.add(new HTML("No data to display."), "订单概况");
        searchconditions.add(tabPanel);
        //搜索框搜索按钮实现（搜索条件放入contentPanel中，getValue获取）
//        contentPanel.createPanel(IComment.USERNAME, "用户名:", userName);
//        contentPanel.createPanel(IComment.EMAIL, "Email:", email); 
//        final TextArea commentArea = new TextArea();
//        commentArea.setSize("350", "100");
//        contentPanel.createPanel(IComment.CONTENT, "回复内容:", commentArea);        
//        
//        HorizontalPanel panel = new HorizontalPanel();
//        panel.setSpacing(10);
//        btnNew.setText("确定"); 
//        btnCancel.setText("重置");
//        panel.add(btnNew);        
//        panel.add(btnCancel);
//        contentPanel.createPanel(null, null, panel);        

        //点击确定进行回复或更新回复
        btnNew.addClickListener(new ClickListener() {
            public void onClick(Widget sender) {}
		});

        //重置
        btnCancel.addClickListener(new ClickListener() {
            public void onClick(Widget sender) {
            	
            }
        });
        
        //允许显示或禁止显示
        btnAllow.addClickListener(new ClickListener() {
        	public void onClick(Widget sender) {}            
        });        
    }  
    
    public void refresh() {                  
        	topStatistics.clear();
        	//填充顶端统计信息
        	topStatistics.setHorizontalAlignment(topStatistics.ALIGN_CENTER);
        	topStatistics.add(new HTML("<div align=\"left\">有效订单总金额:  ￥3000.00元    总点击数:  128    每千点击订单数:  7.81    每千点击购物额:  ￥23437.50元 </div>"));
        	//填充搜索信息框日期（默认为当前日期与其前一个月）       	
           
//        	iShop.getInstance().displayUserComments();
//			Info.display("Error","Sorry系统错误！");      
        
    }
}
