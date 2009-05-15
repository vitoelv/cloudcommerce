/**
* Author: Bob Chen
*/

package com.jcommerce.core.dao;

import java.util.List;

import com.jcommerce.core.model.Gallery;

public interface GalleryDAO extends DAO {
    public List<Gallery> getGalleryList();

    public Gallery getGallery(int id);

    public void saveGallery(Gallery obj);

    public void removeGallery(int id);
}
