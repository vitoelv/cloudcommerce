/**
 * 
 */
package com.jcommerce.ws.agent.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.jcommerce.core.action.BeanConfig;
import com.jcommerce.core.action.DeleteAction;
import com.jcommerce.core.action.PropertyBeanConfig;
import com.jcommerce.core.action.WSCreateAction;
import com.jcommerce.core.action.WSListAction;
import com.jcommerce.core.action.WSReadAction;
import com.jcommerce.core.action.WSUpdateAction;
import com.jcommerce.core.model.ModelObject;
import com.jcommerce.core.service.Criteria;
import com.jcommerce.ws.agent.DBAccess;

/**
 * @author dell
 * 
 */
public class DBAccessImpl implements DBAccess {
	
    private DeleteAction deleteAction;
    private WSReadAction readAction;
    private WSCreateAction createAction;
    private WSListAction listAction;
    private WSUpdateAction updateAction;

	/**
	 * 读的是axis2\WEB-INF\classes下的applicationContext.xml
	 */
	public DBAccessImpl() {
		String[] paths = { "applicationContext.xml" };
		System.out.println(">>>>>>>>>>> classloader:" + getClass().getClassLoader().getClass());
		ApplicationContext ctx = new ClassPathXmlApplicationContext(paths);
		DriverManagerDataSource dataSource2 = (DriverManagerDataSource) ctx.getBean("dataSource");
		System.out.println(dataSource2.getDriverClassName());
		System.out.println(dataSource2.getUrl());
		System.out.println(dataSource2.getUsername());

		Properties beanProps = new Properties();
		InputStream is = getClass().getResourceAsStream("beans.properties");
		try {
			beanProps.load(is);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        BeanConfig config = new PropertyBeanConfig(beanProps);
        deleteAction = new DeleteAction(ctx, config);
        readAction = new WSReadAction(ctx, config);
        createAction = new WSCreateAction(ctx, config);
        listAction = new WSListAction(ctx, config);
        updateAction = new WSUpdateAction(ctx, config);
	}

	public boolean deleteObject(String modelName, String id) {
		System.out.println("deleteObject("+modelName+"), id = "+id);
		return deleteAction.delete(modelName, id);
	}


	public ModelObject getBean0(String modelName, String id) {
		return readAction.getBean(modelName, id);
	}



	public int getTotalCount(String modelName) {
		System.out.println("getTotalNumber of (" + modelName + ")");
		return listAction.getTotalCount(modelName);
		
	}

	/**
	 * no tested.
	 * @param modelName
	 * @param criteria
	 * @return
	 */
	public int getTotalCount(String modelName, Criteria criteria) {
		System.out.println("getTotalCount of (" + modelName + ")");
		return listAction.getTotalCount(modelName,criteria);
	}
	
	public List<ModelObject> getListObj(String modelName, String id, int count, int begin, Criteria criteria) {
		System.out.println("getListObj of (" + modelName + ")");
		return listAction.getListObj(modelName, id, count, begin, criteria);
	}

	public List<ModelObject> getListObj(String modelName, String id, int count, int begin) {
		System.out.println("getListObj of (" + modelName + ")");
		return listAction.getListObj(modelName, id, count, begin);
	}

	public List<ModelObject> getListObj(String modelName, Criteria criteria) {
		System.out.println("getListObj of (" + modelName + ")");
		return listAction.getListObj(modelName, criteria);
	}

	public boolean updateObject(String modelName, ModelObject model) {
		System.out.println("updateObject(" + modelName + ")");
		return updateAction.updateObject(modelName, model);
	}

	public String newObject(String modelName, ModelObject model) {
		return createAction.newObject(modelName, model);
	}

	/**
	 * Require all ModelObject have a getId() or getID() method
	 */
	public String getId(ModelObject obj) {
		return readAction.getId(obj);
	}

}
