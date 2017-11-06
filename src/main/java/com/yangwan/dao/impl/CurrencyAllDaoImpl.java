//package com.yangwan.dao.impl;
//
//import java.io.Serializable;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceUnit;
//
//import java.lang.reflect.ParameterizedType;
//import java.lang.reflect.Type;
//
//import com.yangwan.dao.CurrencyAllDao;
//
//public abstract class CurrencyAllDaoImpl<E extends Serializable, PK extends Serializable> 
//						implements CurrencyAllDao<E, PK>{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -7571075441323659734L;
//
//	@PersistenceUnit(name = "persistenceUnit")
//	private EntityManager entityManager;
//	
//	public EntityManager getEntityManager(){
//		return this.entityManager;
//	}
//	
//	private Class<E> entityClass;
//	
//	@SuppressWarnings("unchecked")
//	public CurrencyAllDaoImpl(){
//		entityClass = null;
//		Type type = getClass().getGenericSuperclass();
//		if(type instanceof ParameterizedType){
//			entityClass = (Class<E>) ((ParameterizedType)type).getActualTypeArguments()[0];
//		}
//		if(entityClass == null){
//			throw new NullPointerException("CurrencyAllDaoImpl类初始化失败, entityClass==null");
//		}
//	}
//	
//	@Override
//	public E findByKey(PK key) {
//		return entityManager.find(entityClass, key);
//	}
//	
//}
