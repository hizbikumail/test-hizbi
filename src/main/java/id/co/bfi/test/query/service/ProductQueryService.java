package id.co.bfi.test.query.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import id.co.bfi.test.api.server.response.ProductResponse;
import id.co.bfi.test.api.server.response.base.JsonBasePage;
import id.co.bfi.test.api.server.response.base.JsonBaseResponse;
import id.co.bfi.test.entity.Product;
import id.co.bfi.test.query.action.ProductQueryAction;

@Component
public class ProductQueryService {

	@Autowired
	private ProductQueryAction queryAction;

	public Page<Product> findAll(Pageable pageable) {
		return queryAction.findAll(pageable);
	}

	public List<ProductResponse> getProductByproductId(int id) {
		var productParam = queryAction.getByproductId(id);
		var productParamResponse = new ArrayList<ProductResponse>();
		productParam.forEach(s -> productParamResponse.add(s.toResponse()));
		return productParamResponse;
	}

	public JsonBaseResponse<JsonBasePage<ProductResponse>> getProductPaging(int limit, int offset) {
		return queryAction.findProduct(limit, offset);
	}

	public List<ProductResponse> findByIdProduct(int id) {
		return queryAction.findByIdProduct(id);
	}

	public List<ProductResponse> findByNameProduct(String name) {
		return queryAction.findByNameProduct(name);
	}
}
