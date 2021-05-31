package id.co.bfi.test.command.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import id.co.bfi.test.entity.Categori;
import id.co.bfi.test.repository.CategoriRepository;

@Component
public class CategoriCommandAction {
	@Autowired
	private CategoriRepository categoriesRepo;

	public id.co.bfi.test.entity.Categori save(Categori categories) {
		return categoriesRepo.save(categories);
	}

	public int update(String categoryName, String description, byte picture) {
		return categoriesRepo.update(categoryName, description, picture);
	}

	public void deleteById(int id) {
		categoriesRepo.deleteById(id);
	}
}
