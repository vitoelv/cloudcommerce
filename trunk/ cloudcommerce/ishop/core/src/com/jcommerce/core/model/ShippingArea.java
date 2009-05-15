/**
 * Author: Bob Chen
 */

package com.jcommerce.core.model;

import java.util.HashSet;
import java.util.Set;

public class ShippingArea extends ModelObject {
    
	private int id;
	private String name;
	private Shipping shipping;
	private String config;
    Set<Region> regions = new HashSet<Region>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public Set<Region> getRegions() {
        return regions;
    }

    public void setRegions(Set<Region> regions) {
        if (regions == null) {
            this.regions.clear();
        } else {
            this.regions = regions;
        }
    }
    
    public void addRegion(Region region) {
        if (!regions.contains(region)) {
            this.regions.add(region);
            region.addArea(this);
        }
    }
    
    public void removeRegion(Region region) {
        if (regions.contains(region)) {
            this.regions.remove(region);
            region.removeArea(this);
        }
    }
}
