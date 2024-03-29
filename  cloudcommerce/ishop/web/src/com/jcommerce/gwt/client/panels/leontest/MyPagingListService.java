package com.jcommerce.gwt.client.panels.leontest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.BaseListLoader;
import com.extjs.gxt.ui.client.data.DataReader;
import com.extjs.gxt.ui.client.data.ListLoadConfig;
import com.extjs.gxt.ui.client.data.ListLoadResult;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.jcommerce.gwt.client.IShopServiceAsync;
import com.jcommerce.gwt.client.ModelNames;
import com.jcommerce.gwt.client.model.BeanObject;
import com.jcommerce.gwt.client.service.Criteria;
import com.jcommerce.gwt.client.service.RemoteService;


public class MyPagingListService extends RemoteService {

    public BaseListLoader getLoader(final String model) {
        if (model == null) {
            throw new RuntimeException("model = null");
        }
        
        final IShopServiceAsync service = getService();
        MyProxy<ListLoadConfig, ListLoadResult> proxy = new MyProxy<ListLoadConfig, ListLoadResult>() {
            public void load(ListLoadConfig loadConfig, AsyncCallback<ListLoadResult> callback) {
                service.getMyPaymentMetaList(loadConfig, callback);
            }
            
        };
        
        // convert from ListLoadResult<Map<String, Object>> to ListLoadResult<BeanObject>
        DataReader<ListLoadConfig, ListLoadResult> reader = new DataReader<ListLoadConfig, ListLoadResult>() {

            public ListLoadResult<BeanObject> read(ListLoadConfig loadConfig, Object data) {
                System.out.println("my reader: "+data.getClass().getName());
                List<BeanObject> destdatas = new ArrayList<BeanObject>();
                ListLoadResult<Map<String, Object>> casteddata = (ListLoadResult)data;
                List<Map<String, Object>> origdatas = casteddata.getData();
                for(Map<String, Object> origdata:origdatas) {
                    destdatas.add(new BeanObject(ModelNames.PAYMENT_META, origdata));
                }
                
                ListLoadResult<BeanObject> res = new BaseListLoadResult<BeanObject>(destdatas);
                return res;
            }

            
        };
        // loader
        BaseListLoader loader = new BaseListLoader<ListLoadConfig, ListLoadResult>(proxy, reader);
        loader.setRemoteSort(true);

        return loader;
    }

//    public BasePagingLoader getLoader(final String model, final Criteria criteria) {
//        if (model == null) {
//            throw new RuntimeException("model = null");
//        }
//        
//        final IShopServiceAsync service = getService();
//        MyProxy proxy = new MyProxy() {
//            public void load(Object loadConfig, AsyncCallback callback) {
//                service.getPagingList(model, criteria, (PagingLoadConfig) loadConfig, callback);
//            }
//        };
//        proxy.setCriteria(criteria);
//        
//        // loader
//        BasePagingLoader loader = new BasePagingLoader<PagingLoadConfig, PagingLoadResult<BeanObject>>(proxy);
//        loader.setRemoteSort(true);
//
//        return loader;
//    }
    
    public abstract class MyProxy<C, D> extends RpcProxy<C, D> {
        Criteria criteria = null;
        public void setCriteria(Criteria criteria) {
            this.criteria = criteria;
        }
    }
    
    
}
