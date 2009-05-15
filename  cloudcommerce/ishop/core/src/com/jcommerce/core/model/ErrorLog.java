/**
 * Author: Bob Chen
 */

package com.jcommerce.core.model;

import java.sql.Timestamp;

public class ErrorLog extends ModelObject {
    
	private int id;
	private String info;
	private String file;
	private Timestamp time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

}
