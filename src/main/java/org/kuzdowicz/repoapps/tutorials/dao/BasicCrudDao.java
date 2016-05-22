package org.kuzdowicz.repoapps.tutorials.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;

public interface BasicCrudDao<PK, T> {
	
	List<T> findAll();
	
	T findOneByCriteria(Criterion criterion);
	
	T findOne(PK pk);
	
	void delete(T object);
	
	void saveOrUpdate(T object);

}
