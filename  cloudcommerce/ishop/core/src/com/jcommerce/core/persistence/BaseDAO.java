/**
 * 
 */
package com.jcommerce.core.persistence;


/**
 * @author rioliu
 *
 */
abstract public class BaseDAO  {
    
    protected IQueryTranslator mTranslator;
    protected IDBObjectConvertor mConvertor;
    protected Class<?> modelClass;
    
    public BaseDAO() {
        initialize();
    }
    
    public BaseDAO(Class<?> clazz) {
        modelClass = clazz;
        initialize();
    }
    
    private void initialize() {
        mTranslator = QueryTranslatorFatory.getTranslator();
        mConvertor = DBObjectConvertorFactory.getObjectConvertor();
    }
    
    public void setModelClass(Class<?> clazz) {
        modelClass = clazz;
    }

}
