package id.co.bfi.test.command.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.bfi.test.command.action.CategoriCommandAction;
import id.co.bfi.test.entity.Categori;
import id.co.bfi.test.query.action.CategoriQueryAction;

@Service
public class CategoriCommandService {
	@Autowired
	private CategoriCommandAction commandAction;

	@Autowired
	private CategoriQueryAction queryAction;

	public Categori create(Categori categories) {
		return commandAction.save(categories);
	}

	public Categori updateCategories(int id, Categori categories) {
		var categ = queryAction.findById(id).orElseThrow();
		categ.setCategoryName(categories.getCategoryName());
		categ.setDescription(categories.getDescription());

		return commandAction.save(categ);
	}

	public void deleteById(int id) {
		commandAction.deleteById(id);
	}
}
