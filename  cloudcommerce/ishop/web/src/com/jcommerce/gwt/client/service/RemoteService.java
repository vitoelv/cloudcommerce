/**
* Author: Bob Chen
*/

package com.jcommerce.gwt.client.service;

import com.extjs.gxt.ui.client.Registry;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.jcommerce.gwt.client.IShopService;
import com.jcommerce.gwt.client.IShopServiceAsync;

public class RemoteService {
    public final static String SERVICE = "service";
    
    public static void init() {
        IShopServiceAsync service = (IShopServiceAsync) GWT.create(IShopService.class);
        String moduleRelativeURL = GWT.getModuleBaseURL() + "ishopService";
        ((ServiceDefTarget)service).setServiceEntryPoint(moduleRelativeURL);
        Registry.register(SERVICE, service);        
    }
    
    protected IShopServiceAsync getService() {
        return (IShopServiceAsync)Registry.get(SERVICE);
    }
}
