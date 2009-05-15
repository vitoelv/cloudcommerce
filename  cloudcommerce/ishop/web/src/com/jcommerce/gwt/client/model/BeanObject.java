package com.jcommerce.gwt.client.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.jcommerce.gwt.client.ValidationException;


public class BeanObject extends BaseTreeModel<BeanObject> implements
        Serializable {
    private String modelName;
    
    
    public BeanObject() {
    }

    public BeanObject(String modelName) {
        this.modelName = modelName;
    }

    public BeanObject(String modelName, Map<String, Object> values) {
        this.modelName = modelName;
        setValues(values);
    }

    protected void validate() throws ValidationException{
    	
    }
    
    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setValues(Map<String, Object> values) {
        for (Iterator it = values.keySet().iterator(); it.hasNext();) {
            String name = (String) it.next();
            Object value = values.get(name);
            set(name, value);
        }
    }
    
    public String[] getIDs(String name) {
        Object value = get(name);
        if (!(value instanceof String)) {
            throw new RuntimeException("Invalid value:"+value+" name:"+name);
        }
        
        return ((String)value).split(",");
    }
    
    public String getString(String name) {
        Object value = get(name);
        if (value == null) {
            return null;
        }
        
        return value.toString();
    }
}
