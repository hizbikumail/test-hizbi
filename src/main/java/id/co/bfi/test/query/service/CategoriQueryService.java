package id.co.bfi.test.query.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import id.co.bfi.test.api.server.response.CategoriResponse;
import id.co.bfi.test.api.server.response.base.JsonBasePage;
import id.co.bfi.test.api.server.response.base.JsonBaseResponse;
import id.co.bfi.test.entity.Categori;
import id.co.bfi.test.query.action.CategoriQueryAction;

@Component
public class CategoriQueryService {

	@Autowired
	private CategoriQueryAction action;

	public Page<Categori> findAll(Pageable pageable) {
		return action.findAll(pageable);
	}

	public List<CategoriResponse> getCategoriById(int id) {
		var categoriParam = action.getCategoriById(id);
		var categoriParamResponse = new ArrayList<CategoriResponse>();
		categoriParam.forEach(s -> categoriParamResponse.add(s.toResponse()));
		return categoriParamResponse;
	}

	public JsonBaseResponse<JsonBasePage<CategoriResponse>> getCategoriPaging(int limit, int offset) {
		return action.findCategori(limit, offset);
	}

	public List<CategoriResponse> findByIdCategori(int id) {
		return action.findByIdCategori(id);
	}

	public List<CategoriResponse> findByNameCategori(String name) {
		return action.findByNameCategori(name);
	}
}
