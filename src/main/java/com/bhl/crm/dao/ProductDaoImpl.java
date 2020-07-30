package com.bhl.crm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bhl.crm.entities.Product;

@Repository
@Transactional("transactionManagerForEntities")
public class ProductDaoImpl implements IProductDao {

	@Autowired
	@Qualifier("sessionFactoryBeanForEntities")
	private SessionFactory factory;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Override
	public List<Product> getAllProducts() {
		Session session = factory.getCurrentSession();
		Query<Product> query = session.createQuery("from Product", Product.class);
		List<Product> list = query.getResultList();
		logger.info("===========>operation getAllProducts est executé");
		return list;
	}

	@Override
	public List<Product> getAllProductsByMc(String mc) {
		Session session = factory.getCurrentSession();
		Query<Product> query = session.createQuery("from Product p where p.designation like : mc", Product.class);
		query.setParameter("mc", "%"+mc+"%");
		List<Product> list = query.getResultList();
		logger.info("===========>operation getAllProductsByMc est executé");
		return list;
	}

	@Override
	public Product getProductById(Long id) {
		Session session = factory.getCurrentSession();
		Product p = session.get(Product.class, id);
		logger.info("===========>operation getProductById est executé");
		return p;
	}

	@Override
	public Product saveProd(Product product) {
		Session session= factory.getCurrentSession();
		session.save(product);
		logger.info("===========>operation SaveProduct est executé");
		return product;
	}

	@Override
	public Product updateProd(Product product) {
		Session session= factory.getCurrentSession();
		session.update(product);
		logger.info("===========>operation updateProduct est executé");
		return product;
	}

	@Override
	public void deleteProd(Long id) {
		Session session= factory.getCurrentSession();
		session.delete(session.get(Product.class, id));
		logger.info("===========>operation deleteProduct est executé");
	}

}
