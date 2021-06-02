package id.co.bfi.test.query.action;

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
import id.co.bfi.test.repository.ProductRepository;

@Component
public class ProductQueryAction {

	@Autowired
	private ProductRepository repository;

	public Page<Product> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public List<Product> getByproductId(int id) {
		var response = repository.getProductByproductId(id).orElseThrow();
		return response;
	}

	public JsonBaseResponse<JsonBasePage<ProductResponse>> findProduct(int Limit, int offset) {
		var productParam = repository.findAll();
		var ListProductResponse = new ArrayList<ProductResponse>();

		var count = productParam.size();
		for (var i = 0; i < count; i++) {
			var productResponse = new ProductResponse();
			productResponse.setProductId(productParam.get(i).getProductId());
			productResponse.setProductName(productParam.get(i).getProductName());
			productResponse.setUnitPrice(productParam.get(i).getUnitPrice());
			productResponse.setCategori(productParam.get(i).getCategori());
			ListProductResponse.add(i, productResponse);
		}

		var response = new JsonBasePage<ProductResponse>();
		response.setData(ListProductResponse);
		response.setTotalRecords((long) count + (long) offset);
		var startTime = System.currentTimeMillis();
		return new JsonBaseResponse<>(startTime, response);
	}

	public List<ProductResponse> findByIdProduct(int id) {
		var productParam = repository.findByIdProduct(id);
		var productParamResponse = new ArrayList<ProductResponse>();
		productParam.forEach(s -> productParamResponse.add(s.toResponse()));
		return productParamResponse;
	}

	public List<ProductResponse> findByNameProduct(String name) {
		var productParam = repository.findByNameProduct(name);
		var productParamResponse = new ArrayList<ProductResponse>();
		productParam.forEach(s -> productParamResponse.add(s.toResponse()));
		return productParamResponse;
	}

}
