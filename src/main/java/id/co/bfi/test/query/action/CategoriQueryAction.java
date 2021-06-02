package id.co.bfi.test.query.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import id.co.bfi.test.api.server.response.CategoriResponse;
import id.co.bfi.test.api.server.response.base.JsonBasePage;
import id.co.bfi.test.api.server.response.base.JsonBaseResponse;
import id.co.bfi.test.entity.Categori;
import id.co.bfi.test.repository.CategoriRepository;

@Component
public class CategoriQueryAction {

	@Autowired
	private CategoriRepository categoriRepo;

	public Page<Categori> findAll(Pageable pageable) {
		return categoriRepo.findAll(pageable);
	}

	public Optional<Categori> findById(int id) {
		return categoriRepo.findById(id);
	}

	public List<Categori> getCategoriById(int id) {
		var response = categoriRepo.getCategoriBycategoryId(id).orElseThrow();
		return response;
	}

	public List<CategoriResponse> findByIdCategori(int id) {
		var categoriParam = categoriRepo.findByIdCategori(id);
		var categoriParamResponse = new ArrayList<CategoriResponse>();
		categoriParam.forEach(s -> categoriParamResponse.add(s.toResponse()));
		return categoriParamResponse;
	}

	public List<CategoriResponse> findByNameCategori(String name) {
		var categoriParam = categoriRepo.findByNameCategori(name);
		var categoriParamResponse = new ArrayList<CategoriResponse>();
		categoriParam.forEach(s -> categoriParamResponse.add(s.toResponse()));
		return categoriParamResponse;
	}

	public JsonBaseResponse<JsonBasePage<CategoriResponse>> findCategori(int limit, int offset) {
		var categoribyid = categoriRepo.findAll();
		var listCategoriResponse = new ArrayList<CategoriResponse>();

		var count = categoribyid.size();

		for (var i = 0; i < count; i++) {
			var categoriResponse = new CategoriResponse();
			categoriResponse.setCategoriId(categoribyid.get(i).getCategoryId());
			categoriResponse.setCategoriName(categoribyid.get(i).getCategoryName());
			categoriResponse.setProduct(categoribyid.get(i).getProduct());
			listCategoriResponse.add(i, categoriResponse);
		}

		var response = new JsonBasePage<CategoriResponse>();
		response.setData(listCategoriResponse);
		response.setTotalRecords((long) count + (long) offset);
		var startTime = System.currentTimeMillis();
		return new JsonBaseResponse<>(startTime, response);
	}
}
