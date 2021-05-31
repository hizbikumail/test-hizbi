package id.co.bfi.test.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.co.bfi.test.api.server.response.base.JsonBasePage;
import id.co.bfi.test.api.server.response.base.JsonBaseResponse;
import id.co.bfi.test.entity.Product;
import id.co.bfi.test.query.service.ProductQueryService;
import id.co.bfi.test.repository.ProductRepository;
import id.co.bfi.test.util.JsonBaseUtil;

@RestController
@RequestMapping("api/product")
public class ProductApi {

	@Autowired
	private ProductQueryService queryService;

	@Autowired
	private ProductRepository repository;

	@GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonBaseResponse<JsonBasePage<Product>> findAll(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {
		var startTime = System.currentTimeMillis();

		var pageRequest = PageRequest.of(page, size);
		var fromSpring = queryService.findAll(pageRequest);

		var body = JsonBaseUtil.toJsonBasePage(fromSpring);

		return new JsonBaseResponse<>(startTime, body);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Product> findById(@PathVariable(required = true, name = "id") int id) {
		return repository.findById(id);
	}
}
