package org.kuzdowicz.repoapps.tutorials.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<PK extends Serializable, T> {

	@Autowired
	private SessionFactory sessionFactory;

	private Class<T> persistenceClass;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.persistenceClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];

	}

	protected Session getSession() {

		return sessionFactory.getCurrentSession();

	}

	@SuppressWarnings("unchecked")
	protected List<T> findAll() {

		return getSession().createCriteria(persistenceClass).list();

	}

	@SuppressWarnings("unchecked")
	protected T findOneByCriteria(Criterion criterion) {

		return (T) getSession().createCriteria(persistenceClass).add(criterion).uniqueResult();

	}

	protected T findOne(PK pk) {

		return getSession().get(persistenceClass, pk);

	}

	protected void delete(T object) {

		getSession().delete(object);

	}

	protected void saveOrUpdate(T object) {

		getSession().saveOrUpdate(object);

	}

}
