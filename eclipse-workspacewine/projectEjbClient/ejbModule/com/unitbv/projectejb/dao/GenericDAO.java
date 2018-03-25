package com.unitbv.projectejb.dao;

public interface GenericDAO<T> {
	void insert(T entity);
	void delete(T entity);
	void update(T entity);
	T findById(int id);
}
