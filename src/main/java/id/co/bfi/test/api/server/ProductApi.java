package id.co.bfi.test.api.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.co.bfi.test.api.server.response.ProductResponse;
import id.co.bfi.test.api.server.response.base.JsonBasePage;
import id.co.bfi.test.api.server.response.base.JsonBaseResponse;
import id.co.bfi.test.query.service.ProductQueryService;

@RestController
@RequestMapping("api/product")
public class ProductApi {

	@Autowired
	private ProductQueryService queryService;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonBaseResponse<List<ProductResponse>> findById(@PathVariable(name = "id") int id) {
		var startTime = System.currentTimeMillis();
		var responseService = queryService.getProductByproductId(id);

		return new JsonBaseResponse<>(startTime, responseService);
	}

	@GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonBaseResponse<JsonBasePage<ProductResponse>> getProductPaging(
			@RequestParam(name = "limit", required = true, defaultValue = "10") int limit,
			@RequestParam(name = "offset", required = true, defaultValue = "0") int offset) {

		return queryService.getProductPaging(limit, offset);
	}

	@GetMapping(value = "/findbynative/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonBaseResponse<List<ProductResponse>> findByIdProduct(@PathVariable(name = "id") int id) {
		var startTime = System.currentTimeMillis();
		var responseService = queryService.findByIdProduct(id);

		return new JsonBaseResponse<>(startTime, responseService);
	}

	@GetMapping(value = "/findbynativename/{name}")
	public JsonBaseResponse<List<ProductResponse>> findByNameProduct(@PathVariable(name = "name") String name) {
		var startTime = System.currentTimeMillis();
		var responseService = queryService.findByNameProduct(name);

		return new JsonBaseResponse<>(startTime, responseService);
	}
}
