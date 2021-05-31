package id.co.bfi.test.query.action;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import id.co.bfi.test.entity.Categori;
import id.co.bfi.test.repository.CategoriRepository;

@Component
public class CategoriQueryAction {

	@Autowired
	private CategoriRepository categoriesRepo;

	public Page<Categori> findAll(Pageable pageable) {
		return categoriesRepo.findAll(pageable);
	}

	public Optional<Categori> findById(int id) {
		return categoriesRepo.findById(id);
	}
}
