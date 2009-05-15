package com.jcommerce.ws.agent;

import java.util.HashMap;
import java.util.List;

import com.jcommerce.core.model.ModelObject;

public interface DBAccess {
    
    public String newObject(String modelName, ModelObject model);
    
    public boolean updateObject(String modelName, ModelObject model);
    
    public boolean deleteObject(String bean, String id);
    
   
}
