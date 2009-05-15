/**
* Author: Bob Chen
*/

package com.jcommerce.core.service.impl;

import java.lang.reflect.Field;
import java.util.List;

import com.jcommerce.core.dao.DAO;
import com.jcommerce.core.model.Goods;
import com.jcommerce.core.service.Condition;
import com.jcommerce.core.service.Criteria;
import com.jcommerce.core.service.Manager;
import com.jcommerce.core.service.Order;

public class ManagerImpl implements Manager {
    private DAO dao;
    
    protected void setDao(DAO dao) {
        this.dao = dao;
    }
    
    public List getList(int firstRow, int maxRow) {
        return getList(firstRow, maxRow, null);
    }
    
    public List getList(Criteria criteria) {
        return getList(-1, -1, criteria);
    }
    
    public List getList(int firstRow, int maxRow, Criteria criteria) {
        String hql = getHql(criteria);        
        List list = null;
        if (maxRow < 0) {
            list = dao.getList(hql);
        } else {
            list = dao.getList(hql, firstRow, maxRow);
        }
        return (List<Goods>)list;
    }
    
    public int getCount(Criteria criteria) {
        String hql = getHql(criteria);
        return dao.getCount(hql);
    }
    
    protected String getHql(Criteria criteria) {
    	String objName = getObjName();
        StringBuffer hql = new StringBuffer("from "+dao.getModelClass().getSimpleName() + 
        		" "+objName); // by liyong, this is a convention used in GoodsTypeDaoImpl
        hql.append(getWhereClause(criteria));
        return hql.toString();
    }
    protected String getObjName() {
    	return dao.getModelClass().getSimpleName().toLowerCase();
    	
    }
    protected String getWhereClause(Criteria criteria) {
    	String objName = getObjName();
    	StringBuffer hql = new StringBuffer();
        if (criteria != null && criteria.getConditions().size() > 0) {
            hql.append(" where ");
            
            boolean first = true;
            List<Condition> conds = criteria.getConditions();
            for (Condition cond : conds) {
                if (!first) {
                    hql.append(" and ");
                }
                first = false;
                addCondtion(hql, cond, objName);
            }
        }
        if (criteria != null && criteria.getOrders().size() > 0) {
            hql.append(" order by ");
            
            boolean first = true;
            List<Order> orders = criteria.getOrders();
            for (Order order : orders) {
                if (!first) {
                    hql.append(", ");
                }
                first = false;
                hql.append(objName).append("."+order.getField());
                if (order.isAscend()) {
                    hql.append(" asc");
                } else {
                    hql.append(" desc");
                }
            }
        }
        return hql.toString();
    }
    
    private void addCondtion(StringBuffer hql, Condition cond, String objName) {
        int op = cond.getOperator();
        if (op == Condition.LIKE) {
            hql.append(objName).append("."+cond.getField());
            hql.append(" LIKE '%").append(cond.getValue()).append("%'");
        } else if (op == Condition.CONTAINS) {
            hql.append(cond.getValue()).append(" member of ").append(objName).append("."+cond.getField());
        } else if (op == Condition.GREATERTHAN) {
            hql.append(objName).append("."+cond.getField());
            hql.append(" >= ").append(cond.getValue());
        } else if (op == Condition.LESSTHAN) {
            hql.append(objName).append("."+cond.getField());
            hql.append(" <= ").append(cond.getValue());
        } else if (op == Condition.EQUALS) {
            hql.append(objName).append("."+cond.getField());
            hql.append(" = ");
            Field fld = null;
            try {
                fld = dao.getModelClass().getDeclaredField(cond.getField());
            } catch (SecurityException e) {
                throw new RuntimeException(e.toString());
            } catch (NoSuchFieldException e) {
                throw new RuntimeException("No field found: " + cond.getField());
            }
            
            if (fld.getType() == String.class) {
                hql.append("'").append(cond.getValue()).append("'");
            } else {
                hql.append(cond.getValue());
            }
        } else {
            throw new RuntimeException("Unknown operator: " + op);
        }
    }
    
    public String getModelName() {
        return dao.getModelClass().getSimpleName();
    }

	public List getList(String hsql) {
		List list = null;
		list = dao.getList(hsql);
		return list;
	}   
}
