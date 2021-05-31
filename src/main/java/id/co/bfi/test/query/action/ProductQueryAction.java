package id.co.bfi.test.query.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import id.co.bfi.test.entity.Product;
import id.co.bfi.test.repository.ProductRepository;

@Component
public class ProductQueryAction {

	@Autowired
	private ProductRepository repository;

	public Page<Product> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

}
