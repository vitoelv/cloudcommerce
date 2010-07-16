/**
 * every database moudule must implement its own translator
 * e.g. RDBMS -> SQL related language, ObjectiveDB -> private query object
 */
package com.jcommerce.core.persistence;

import com.jcommerce.core.service.Criteria;

/**
 * @author rioliu
 *
 */
public interface IQueryTranslator {

    public Object translate(Criteria c);
}
