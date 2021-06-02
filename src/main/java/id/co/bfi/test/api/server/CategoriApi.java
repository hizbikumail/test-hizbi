package id.co.bfi.test.api.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.co.bfi.test.api.server.request.CategoriRequest;
import id.co.bfi.test.api.server.response.CategoriResponse;
import id.co.bfi.test.api.server.response.base.JsonBasePage;
import id.co.bfi.test.api.server.response.base.JsonBaseResponse;
import id.co.bfi.test.command.service.CategoriCommandService;
import id.co.bfi.test.query.service.CategoriQueryService;

@RestController
@RequestMapping("/api/categori")
public class CategoriApi {

	@Autowired
	private CategoriCommandService commandService;

	@Autowired
	private CategoriQueryService queryService;

	@PostMapping(value = { "",
			"/" }, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String create(@RequestBody(required = true) CategoriRequest request) {
		var saved = commandService.create(request.toEntity());

		return "Saved as ID " + saved.getCategoryId();
	}

//	@GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
//	public JsonBaseResponse<JsonBasePage<Categori>> findAll(@RequestParam(name = "page", defaultValue = "0") int page,
//			@RequestParam(name = "size", defaultValue = "10") int size) {
//		var startTime = System.currentTimeMillis();
//
//		var pageRequest = PageRequest.of(page, size);
//		var fromSpring = queryService.findAll(pageRequest);
//		var body = JsonBaseUtil.toJsonBasePage(fromSpring);
//
//		return new JsonBaseResponse<>(startTime, body);
//	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateCategories(@PathVariable(required = true, name = "id") int id,
			@RequestBody(required = true) CategoriRequest request) {
		commandService.updateCategories(request.getCategoryId(), request.toEntity());

		return Integer.toString(id);
	}

	@DeleteMapping(value = "/delete/{id}")
	public String deleteCategoriesById(@PathVariable(required = true, name = "id") int id) {
		commandService.deleteById(id);
		return "Delete as ID " + id;
	}

	@GetMapping(value = "/findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonBaseResponse<List<CategoriResponse>> findById(@PathVariable(name = "id") int id) {
		var startTime = System.currentTimeMillis();
		var responseService = queryService.getCategoriById(id);

		return new JsonBaseResponse<>(startTime, responseService);
	}

	@GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonBaseResponse<JsonBasePage<CategoriResponse>> getCategoriPaging(
			@RequestParam(name = "limit", required = true, defaultValue = "10") int limit,
			@RequestParam(name = "offset", required = true, defaultValue = "0") int offset) {

		return queryService.getCategoriPaging(limit, offset);
	}

	@GetMapping(value = "/findBynative/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonBaseResponse<List<CategoriResponse>> findByNativeId(@PathVariable(name = "id") int id) {
		var startTime = System.currentTimeMillis();
		var responseService = queryService.findByIdCategori(id);

		return new JsonBaseResponse<>(startTime, responseService);
	}

	@GetMapping(value = "/findbynativename/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonBaseResponse<List<CategoriResponse>> findByNativeName(@PathVariable(name = "name") String name) {
		var startTime = System.currentTimeMillis();
		var responseService = queryService.findByNameCategori(name);

		return new JsonBaseResponse<>(startTime, responseService);
	}
}