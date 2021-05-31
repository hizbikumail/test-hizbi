package id.co.bfi.test.query.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import id.co.bfi.test.entity.Product;
import id.co.bfi.test.query.action.ProductQueryAction;

@Component
public class ProductQueryService {

	@Autowired
	private ProductQueryAction queryAction;

	public Page<Product> findAll(Pageable pageable) {
		return queryAction.findAll(pageable);
	}

	public Optional<Product> findById(int id) {
		return queryAction.findById(id);
	}

}
