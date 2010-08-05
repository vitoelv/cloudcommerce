/**
 * 
 */
package com.jcommerce.core.persistence;

import com.jcommerce.core.util.SpringUtil;


/**
 * @author rioliu
 *
 */
public class DAOFactory {
    
   
   public static IDAO getDAO() {
       
       if(DBType.isMongo()) return (IDAO)SpringUtil.getBean("mongoDAO");
       if(DBType.isHibernate()) return null;
       
       throw new IllegalStateException("cannot find corresponding dao impl ");
   }

}
