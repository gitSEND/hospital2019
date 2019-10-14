package com.salud.gestion.service;

import java.util.List;

public interface ICRUD<T> {

	T createAndUpdate(T entity);

	void delete(T entity);

	T findById(Long id);

	List<T> findAll();
}
