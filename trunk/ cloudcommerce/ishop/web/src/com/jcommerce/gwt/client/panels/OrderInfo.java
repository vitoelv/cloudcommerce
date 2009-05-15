package com.jcommerce.gwt.client.panels;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.jcommerce.gwt.client.ContentWidget;
import com.jcommerce.gwt.client.ModelNames;
import com.jcommerce.gwt.client.model.BeanObject;
import com.jcommerce.gwt.client.model.IGoods;
import com.jcommerce.gwt.client.model.IOrder;
import com.jcommerce.gwt.client.model.IOrderGoods;
import com.jcommerce.gwt.client.service.Condition;
import com.jcommerce.gwt.client.service.Criteria;
import com.jcommerce.gwt.client.service.ListService;
import com.jcommerce.gwt.client.service.ReadService;
import com.jcommerce.gwt.client.service.WaitService;
import com.jcommerce.gwt.client.widgets.ColumnPanel;


/**
 * Example file.
 */
public class OrderInfo extends ContentWidget {    	
    
    private Button btnNext = new Button();    
    private Button btnLast = new Button();
    private Button btnPrint = new Button();
    
    private ColumnPanel basicInfoLeftPanel = new ColumnPanel();        
    private ColumnPanel basicInfoRightPanel = new ColumnPanel();
    private ColumnPanel otherInfoLeftPanel = new ColumnPanel();
    private ColumnPanel otherInfoRightPanel = new ColumnPanel();
    private ColumnPanel consigneeInfoLeftPanel = new ColumnPanel();
    private ColumnPanel consigneeInfoRightPanel = new ColumnPanel();
    List<BeanObject> orderGoodsList= new ArrayList<BeanObject>();
    FlexTable goodsInfoGrid = new FlexTable(); 
    VerticalPanel orderGoodsInfo = new VerticalPanel();
    VerticalPanel costsInfo = new VerticalPanel();
    VerticalPanel actionInfo = new VerticalPanel();
    
    //double goodsWeight;   
    private BeanObject order = null;
    
    public OrderInfo() {
    }
    
    public String getDescription() {
        return "cwBasicTextDescription";
    }

    public String getName() {
    	return "订单信息"; 
    	
    }
    
    public void setOrder(BeanObject order) {
    	this.order = order;        
    }
    
    protected void onRender(Element parent, int index) {
        super.onRender(parent, index);        
        System.out.println("----------OrderInfo"); 
       
        HorizontalPanel panel = new HorizontalPanel();
        panel.setSpacing(10);
        btnLast.setText("前一个订单");
        btnNext.setText("后一个订单");
        btnPrint.setText("打印订单");
        panel.add(btnLast);        
        panel.add(btnNext);
        panel.add(btnPrint);
        add(panel);

        VerticalPanel checkOrder = new VerticalPanel();        
        checkOrder.setWidth("800px");
        checkOrder.getElement().getStyle().setProperty("textAlign", "center");
        //checkOrder.setStyleName("is-DockPanel");        
        //DockPanel dock = new DockPanel();
        //dock.setStyleName("is-DockPanel");
        //dock.setSpacing(4);
        //dock.setHorizontalAlignment(DockPanel.ALIGN_CENTER);
        
        // Add text all around    
                
        basicInfoLeftPanel.createPanel(IOrder.SN, "订单号：", new Label());
        basicInfoLeftPanel.createPanel(IOrder.USER, "购货人：", new Label());
        basicInfoLeftPanel.createPanel(IOrder.PAYMENT, "支付方式：", new Label());
        basicInfoLeftPanel.createPanel(IOrder.SHIPPING, "配送方式：", new Label());
        basicInfoLeftPanel.createPanel(IOrder.INVOICENO, "发货单号：", new Label());
        basicInfoRightPanel.createPanel(IOrder.STATUS, "订单状态：", new Label());
        basicInfoRightPanel.createPanel(IOrder.ADDTIME, "下单时间：", new Label());
        basicInfoRightPanel.createPanel(IOrder.PAYTIME, "付款时间：", new Label());
        basicInfoRightPanel.createPanel(IOrder.SHIPPINGTIME, "发货时间：", new Label());
        basicInfoRightPanel.createPanel(IOrder.REFERER, "订单来源：", new Label());
        HorizontalPanel basicInfo = new HorizontalPanel();
        VerticalPanel basicInfotitle = new VerticalPanel();       
        basicInfotitle.add(new HTML("基本信息"));
        basicInfo.add(basicInfoLeftPanel);
        basicInfo.add(basicInfoRightPanel);
        basicInfotitle.add(basicInfo);
//        dock.add(new HTML("基本信息"), DockPanel.NORTH);
//        dock.add(basicInfo, DockPanel.NORTH);
//        dock.add(new HTML("其他信息"), DockPanel.NORTH);
//        dock.add(new HTML("收货人信息"), DockPanel.NORTH);
//        dock.add(new HTML("商品信息"), DockPanel.NORTH);
//        dock.add(new HTML("费用信息"), DockPanel.NORTH);
//        dock.add(new HTML("操作信息"), DockPanel.NORTH);
        checkOrder.add(basicInfotitle);
        VerticalPanel otherInfotitle = new VerticalPanel();
        otherInfotitle.add(new HTML("其他信息"));
        otherInfoLeftPanel.createPanel(IOrder.INVOCETYPE, "发票类型：", new Label());
        otherInfoLeftPanel.createPanel(IOrder.INVOICECONTENT, "发票内容：", new Label());
        otherInfoLeftPanel.createPanel(IOrder.POSTSCRIPT, "客户给商家的留言：", new Label());
        otherInfoLeftPanel.createPanel(IOrder.HOWOSS, "缺货处理：", new Label());
        otherInfoLeftPanel.createPanel(IOrder.PACKNAME, "包装：", new Label());
        otherInfoLeftPanel.createPanel(IOrder.CARDNAME, "贺卡：", new Label());
        otherInfoLeftPanel.createPanel(IOrder.CARDMESSAGE, "贺卡祝福语：", new Label());
        otherInfoLeftPanel.createPanel(IOrder.TOBUYER, "商家给客户的留言：", new Label());        
        otherInfoRightPanel.createPanel(IOrder.INVOICEPAYEE, "发票抬头：", new Label());
        HorizontalPanel otherInfo = new HorizontalPanel();
        otherInfo.add(otherInfoLeftPanel);
        otherInfo.add(otherInfoRightPanel);
        otherInfotitle.add(otherInfo);
        checkOrder.add(otherInfotitle);  
        
        VerticalPanel consigneeInfotitle = new VerticalPanel();
        consigneeInfotitle.add(new HTML("收货人信息"));
        consigneeInfoLeftPanel.createPanel(IOrder.CONSIGNEE, "收货人：", new Label());        
        consigneeInfoLeftPanel.createPanel(IOrder.ADDRESS, "地址：", new Label());        
        consigneeInfoLeftPanel.createPanel(IOrder.PHONE, "电话：", new Label());        
        consigneeInfoLeftPanel.createPanel(IOrder.SIGNBUILDING, "标志性建筑：", new Label());        
        consigneeInfoRightPanel.createPanel(IOrder.EMAIL, "电子邮件：", new Label());
        consigneeInfoRightPanel.createPanel(IOrder.ZIP, "邮编：", new Label());
        consigneeInfoRightPanel.createPanel(IOrder.MOBILE, "手机：", new Label());
        consigneeInfoRightPanel.createPanel(IOrder.BESTTIME, "最佳送货时间：", new Label());
        HorizontalPanel consigneeInfo = new HorizontalPanel();
        consigneeInfo.add(consigneeInfoLeftPanel);
        consigneeInfo.add(consigneeInfoRightPanel);        
        consigneeInfotitle.add(consigneeInfo);
        checkOrder.add(consigneeInfotitle);
        
     // Create a vertical panel to layout the contents
        
        new WaitService(new WaitService.Job() {			
            public boolean isReady() {
            	Condition cond = new Condition();
        		cond.setField(IOrderGoods.ORDER);
        		cond.setOperator(Condition.EQUALS);		
        		cond.setValue(order.getString("id"));
        		Criteria cri = new Criteria();
        		cri.addCondition(cond);		 
            	new ListService().listBeans(ModelNames.ORDERGOODS, cri, new ListService.Listener() {									
        			public synchronized void onSuccess(List<BeanObject> result) {        				
        			 orderGoodsList = result;
        			}			
            	});
            	if(orderGoodsList.isEmpty()){            		
            		return false;
            	}
            	else{                		
            		return true;
            	}
            }
            public void run() {
            	fillGoodsGrid();
            }
        });        

        //VerticalPanel costsInfotitle = new VerticalPanel();
        orderGoodsInfo.setTitle("商品信息");
        checkOrder.add(orderGoodsInfo);
        costsInfo.setTitle("费用信息");
        checkOrder.add(costsInfo);
        actionInfo.setTitle("操作信息");
        checkOrder.add(actionInfo);     
  
        add(checkOrder);
        btnLast.addClickListener(new ClickListener() {
            public void onClick(Widget sender) {                                   
                  
             
            }
        });

        btnNext.addClickListener(new ClickListener() {
            public void onClick(Widget sender) {
              
            }            
        }); 
        
        btnPrint.addClickListener(new ClickListener() {
        	public void onClick(Widget sender) {
        		
        	}            
        });          
        
    }  
    
    public void refresh() {
    	costsInfo.clear();
    	basicInfoLeftPanel.clearValues();
    	basicInfoRightPanel.clearValues();
        if (this.order!=null&&this.order.getString(IOrder.ID) != null) {            
            Map<String, Object> mapOrder = order.getProperties();            
            basicInfoLeftPanel.updateValues(mapOrder);
            basicInfoRightPanel.updateValues(mapOrder);
            otherInfoLeftPanel.updateValues(mapOrder);
            otherInfoRightPanel.updateValues(mapOrder);            
            consigneeInfoLeftPanel.updateValues(mapOrder);
            consigneeInfoRightPanel.updateValues(mapOrder);
            new WaitService(new WaitService.Job() {			
                public boolean isReady() {
                	Condition cond = new Condition();
            		cond.setField(IOrderGoods.ORDER);
            		cond.setOperator(Condition.EQUALS);		
            		cond.setValue(order.getString("id"));
            		Criteria cri = new Criteria();
            		cri.addCondition(cond);		 
                	new ListService().listBeans(ModelNames.ORDERGOODS, cri, new ListService.Listener() {									
            			public synchronized void onSuccess(List<BeanObject> result) {        				
            			 orderGoodsList = result;
            			}			
                	});
                	if(orderGoodsList.isEmpty()){            		
                		return false;
                	}
                	else{                		
                		return true;
                	}
                }
                public void run() {
                	fillGoodsGrid();
                }
            });
            double totalamount = 0;
            totalamount =Double.parseDouble(order.getString(IOrder.GOODSAMOUNT))-Double.parseDouble(order.getString(IOrder.DISCOUNT))+Double.parseDouble(order.getString(IOrder.SHIPPINGFEE))+Double.parseDouble(order.getString(IOrder.INSUREFEE))+Double.parseDouble(order.getString(IOrder.PAYFEE));
            costsInfo.add(new HTML("<br><font textAlign = 'right'>商品总金额：￥"+order.getString(IOrder.GOODSAMOUNT)+"元-折扣：￥"+order.getString(IOrder.DISCOUNT)+"元+配送费用：￥"+order.getString(IOrder.SHIPPINGFEE)+"元+保价费用：￥"+order.getString(IOrder.INSUREFEE)+"元+支付费用：￥"+order.getString(IOrder.PAYFEE)+"元 </font>"));
            costsInfo.add(new HTML("<br><font textAlign = 'right'>=订单总金额：￥"+totalamount+"元 </font>"));
            costsInfo.add(new HTML("<br><font textAlign = 'right'>-已付款金额：￥"+order.getString(IOrder.MONEYPAID)+"元-使用余额：￥"+order.getString(IOrder.SURPLUS)+"元-使用积分：￥"+order.getString(IOrder.INTEGRALMONEY)+"元-使用红包：￥"+order.getString(IOrder.BONUSMONEY)+"元 </font>"));
            costsInfo.add(new HTML("<br><font textAlign = 'right'>=应付款金额：￥"+order.getString(IOrder.ORDERAMOUNT)+"元 </font>"));
        }
        
    }
    
    public void fillGoodsGrid(){
    	goodsInfoGrid.clear();    	
        goodsInfoGrid.setHTML(0, 0, "商品名称");
        goodsInfoGrid.setHTML(0, 1, "货号");
        goodsInfoGrid.setHTML(0, 2, "价格");        
        goodsInfoGrid.setHTML(0, 3, "数量");
        goodsInfoGrid.setHTML(0, 4, "属性");
        goodsInfoGrid.setHTML(0, 5, "库存");
        goodsInfoGrid.setHTML(0, 6, "小计"); 
        int goodsCount = 0;
        final BeanObject[] goodsList = new BeanObject[orderGoodsList.size()];
        for (final BeanObject key : orderGoodsList) {
        	final int _count = goodsCount;
        	new ReadService().getBean(ModelNames.GOODS, key.getString(IOrderGoods.GOODS), new ReadService.Listener(){
          	  public synchronized void onSuccess(BeanObject result){
          		  goodsList[_count] = result;
          	  }
            });  
        	goodsCount++;        	
        }        
        new WaitService(new WaitService.Job() {
			public boolean isReady() {
				System.out.println("ordergoodsList size is : "+orderGoodsList.size());
				System.out.println("goodsList item is : "+goodsList[orderGoodsList.size()-1].getString(IGoods.ID));
				if(goodsList[orderGoodsList.size()-1].getString(IGoods.ID).length()==0){
					System.out.println("--------------------false");
					return false;
			    }
				else
					return true;
			}

			public void run() {
				double totalPrice = 0;
				int columnCount = 1;
				double goodsWeight = 0;
				for (final BeanObject key : orderGoodsList) {					
		        	goodsInfoGrid.setHTML(columnCount, 0, key.getString(IOrderGoods.GOODSNAME));
		        	goodsInfoGrid.setHTML(columnCount, 1, key.getString(IOrderGoods.GOODSSN));
		        	goodsInfoGrid.setHTML(columnCount, 2, "￥"+key.getString(IOrderGoods.GOODSPRICE)+"元");
		        	goodsInfoGrid.setHTML(columnCount, 3, key.getString(IOrderGoods.GOODSNUMBER));
		        	goodsInfoGrid.setHTML(columnCount, 4, key.getString(IOrderGoods.GOODSATTRIBUTE));
		        	goodsInfoGrid.setHTML(columnCount, 6, "￥"+key.getString(IOrderGoods.GOODSPRICE)+"元");
		        	totalPrice += Double.parseDouble(key.getString(IOrderGoods.GOODSPRICE));
		            goodsWeight += Double.parseDouble(goodsList[columnCount-1].getString(IGoods.WEIGHT)); 
		            goodsInfoGrid.setHTML(columnCount, 5, goodsList[columnCount-1].getString(IGoods.NUMBER)); 
		            columnCount++;
		        }
				goodsInfoGrid.setStyleName("ishop-OrderGoods-dataRow");  
		        goodsInfoGrid.getRowFormatter().setStyleName(0, "ishop-OrderGoods-headerRow");
		        orderGoodsInfo.clear();
		        orderGoodsInfo.add(goodsInfoGrid);        
		        orderGoodsInfo.add(new HTML("<br><font textAlign = 'right'>商品总重量：￥"+goodsWeight+"克 合计：￥"+totalPrice+"元 </font>"));    
		    }        	
        });
     }   
    
}
