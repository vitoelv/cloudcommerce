package com.jcommerce.gwt.client.resources;

import com.google.gwt.i18n.client.Constants;
import com.jcommerce.gwt.client.panels.AttributeInfo;
import com.jcommerce.gwt.client.panels.GoodsList;
import com.jcommerce.gwt.client.panels.goods.NewGoods;
import com.jcommerce.gwt.client.panels.leontest.GoodsTypeListPanel;
import com.jcommerce.gwt.client.panels.leontest.PaymentMetaList;



/**
 * Constants used throughout the showcase.
 */

public interface IShopConstants extends Constants, GoodsConstants, AttributeInfo.Constants, NewGoods.Constants, GoodsList.Constants, 
            ShopConfigConstants,OrderConstants, PaymentMetaList.Constants, GoodsTypeListPanel.Constants {

  /**
   * The available style themes that the user can select.
   */
  String[] STYLE_THEMES = {"standard", "chrome", "dark"};

  String mainMenuTitle();

  /**
   * @return the title of the application
   */
  String mainTitle();
  
  String categoryGoods();
  String categoryOrder();
  String categoryMember();
  String categorySystem();
  String categoryStatistics();
  
  String mainLinkHomepage();
  String mainLinkGuide();
  String mainLinkNotepad();
  String mainLinkRefresh();
  String mainLinkPersonalSetting();
  String mainLinkComment();
  String mainLinkView();
  String mainLinkCalc();
  String mainLinkAbout();

  String mainCommandClearCache();
  String mainCommandExit();

  String navHome();
  String navSetting();
  String navGoodsList();
  String navOrderList();
  String navComment();
  String navMemberList();
  
  String edit();
  String delete();
  String save();
  String add();
  String reset();
  String action();
  String ok();

  
}
