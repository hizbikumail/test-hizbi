package id.co.bfi.test.query.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import id.co.bfi.test.entity.Categori;
import id.co.bfi.test.query.action.CategoriQueryAction;

@Component
public class CategoriQueryService {

	@Autowired
	private CategoriQueryAction action;

	public Page<Categori> findAll(Pageable pageable) {
		return action.findAll(pageable);
	}

	public Optional<Categori> findById(int id) {
		return action.findById(id);
	}
}
