/**
 * Author: Bob Chen
 */

package com.jcommerce.core.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.jcommerce.core.model.Attribute;
import com.jcommerce.core.model.BonusType;
import com.jcommerce.core.model.Brand;
import com.jcommerce.core.model.Category;
import com.jcommerce.core.model.Gallery;
import com.jcommerce.core.model.Goods;
import com.jcommerce.core.model.GoodsAttribute;
import com.jcommerce.core.model.GoodsType;

public class TestBrand {
    private Configuration getConfiguration() {
        Configuration conf = new Configuration();
        
        Properties props = new Properties();
        InputStream is = this.getClass().getResourceAsStream("/hibernate.properties");
        try {
            props.load(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return conf;
    }
    
    private void initTables() throws Exception {
        Configuration conf = getConfiguration();
        
//        conf.addClass(Brand.class);
        conf.addClass(Category.class);
//        conf.addClass(BonusType.class);
//        conf.addClass(Goods.class);
//        conf.addClass(Attribute.class);
//        conf.addClass(GoodsType.class);
//        conf.addClass(Gallery.class);

        SchemaExport dbExport = new SchemaExport(conf);
        dbExport.create(true, true);
    }
    
    private void insertData() throws Exception {
        Configuration conf = getConfiguration();
        conf.addClass(Brand.class);
        conf.addClass(Category.class);
        conf.addClass(BonusType.class);
        conf.addClass(Goods.class);
        conf.addClass(Attribute.class);
        conf.addClass(GoodsType.class);
        conf.addClass(Gallery.class);

        SessionFactory sessionFactory = conf.buildSessionFactory();
        Session s = sessionFactory.openSession();

        Transaction t = s.beginTransaction();

        Brand p1 = new Brand();
        p1.setName("NOKIA");
        p1.setDescription("NOKIA Mobile");

        s.save(p1);
//
//        Brand p2 = new Brand();
//        p2.setName("LENOVA");
//        p2.setDescription("LENOVA Computer");
//
//        s.save(p2);
//
        Category c1 = new Category();
        c1.setName("æ‰‹æœº");
        
        Category c2 = new Category();
        c2.setName("å›½å¤–å“�ç‰Œ");
        Category c3 = new Category();
        c3.setName("å›½å†…å“�ç‰Œ");
        c2.setParent(c1);
        c3.setParent(c1);

        s.save(c1);
        s.save(c2);
        s.save(c3);
//        
        Goods n72 = new Goods();
        n72.setBrand(p1);
//        n72.setCategory(c2);
        n72.setName("N72");
        
        s.save(n72);
        
        t.commit();

        s.close();
    }     
    
    private void listData() throws Exception {
        Configuration conf = getConfiguration();
        conf.addClass(Brand.class);
        conf.addClass(Category.class);
        conf.addClass(BonusType.class);
        conf.addClass(Goods.class);
        conf.addClass(Attribute.class);
        conf.addClass(GoodsType.class);
        conf.addClass(Gallery.class);

        SessionFactory sessionFactory = conf.buildSessionFactory();
        Session s = sessionFactory.openSession();

//        Query q = s.createQuery("from Brand as p where p.id<10");
//        List persons = q.list();
//        for (Iterator it = persons.iterator(); it.hasNext();) {
//            Brand p = (Brand) it.next();
//            System.out.println(p.getId()+" "+p.getName()+" "+p.getDescription());             
//        }
//        
        Query q = s.createQuery("from Category as p");
        List cs = q.list();
        for (Iterator it = cs.iterator(); it.hasNext();) {
            Category c = (Category) it.next();
            System.out.println(c.getId()+" "+c.getName());
            c = c.getParent();
            if (c != null) {
                System.out.println(" " + c.getId()+" "+c.getName());
            }
        }

        q = s.createQuery("from Goods as p"); 
        cs = q.list();
        for (Iterator it = cs.iterator(); it.hasNext();) {
            Goods g = (Goods) it.next();
            System.out.println(g.getId()+" "+g.getName());
//            Category c = g.getCategory();
//            if (c != null) {
//                System.out.println(" " + c.getId()+" "+c.getName());
//            }
            Brand b = g.getBrand();
            if (b != null) {
                System.out.println(" " + b.getId()+" "+b.getName());
            }
        }
        
        s.close();
    }     
    
    private void updateData() throws Exception {
        Configuration conf = getConfiguration();
        conf.addClass(Brand.class);
        conf.addClass(Category.class);
        conf.addClass(BonusType.class);
        conf.addClass(Goods.class);
        conf.addClass(Attribute.class);
        conf.addClass(GoodsType.class);
        conf.addClass(Gallery.class);

        SessionFactory sessionFactory = conf.buildSessionFactory();
        Session s = sessionFactory.openSession();

        Transaction t = s.beginTransaction();
        Query q = s.createQuery("from Person as p where p.id=1");
        Brand p = (Brand) q.list().get(0);
        System.out.println(p.getName());
        p.setName(p.getName()+"c");
        t.commit(); 
        
        s.close();
    }     
    
    private void deleteData() throws Exception {
        Configuration conf = getConfiguration();
        conf.addClass(Brand.class);
        conf.addClass(Category.class);
        conf.addClass(BonusType.class);
        conf.addClass(Goods.class);
        conf.addClass(Attribute.class);
        conf.addClass(GoodsType.class);
        conf.addClass(Gallery.class);

        SessionFactory sessionFactory = conf.buildSessionFactory();
        Session s = sessionFactory.openSession();

        Transaction t = s.beginTransaction();
        Query q = s.createQuery("from Brand as p where p.id=2");
        Brand p = (Brand) q.list().get(0);
        s.delete(p);
        t.commit(); 
        
        s.close();
    }     
    
    private void queryData() throws Exception {
        Configuration conf = getConfiguration();
        conf.addClass(Brand.class);
        conf.addClass(Category.class);
        conf.addClass(BonusType.class);
        conf.addClass(Goods.class);
        conf.addClass(GoodsAttribute.class);
        conf.addClass(Attribute.class);
        conf.addClass(GoodsType.class);
        conf.addClass(Gallery.class);

        SessionFactory sessionFactory = conf.buildSessionFactory();
        Session s = sessionFactory.openSession();

        Transaction t = s.beginTransaction();
        Query q = s.createQuery("from Goods where brand = 1 AND 3 member of categories AND bestSold = true");
        q.list();
        
        t.commit(); 
                
        s.close();
    }
    
    public static void main(String[] args) throws Exception {
//        new TestBrand().initTables();
//        new TestBrand().insertData();
//        new TestBrand().deleteData();
//        new TestPersonModel().updateData();
        new TestBrand().queryData(); 
    }
}