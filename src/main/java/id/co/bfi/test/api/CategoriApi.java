package id.co.bfi.test.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
import id.co.bfi.test.api.server.response.base.JsonBasePage;
import id.co.bfi.test.api.server.response.base.JsonBaseResponse;
import id.co.bfi.test.command.service.CategoriCommandService;
import id.co.bfi.test.entity.Categori;
import id.co.bfi.test.query.service.CategoriQueryService;
import id.co.bfi.test.repository.CategoriRepository;
import id.co.bfi.test.util.JsonBaseUtil;

@RestController
@RequestMapping("/api/categori")
public class CategoriApi {

	@Autowired
	private CategoriCommandService commandService;

	@Autowired
	private CategoriQueryService queryService;

	@Autowired
	private CategoriRepository repository;

	@PostMapping(value = { "",
			"/" }, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String create(@RequestBody(required = true) CategoriRequest request) {
		var saved = commandService.create(request.toEntity());

		return "Saved as ID " + saved.getCategoryId();
	}

	@GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonBaseResponse<JsonBasePage<Categori>> findAll(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {
		var startTime = System.currentTimeMillis();

		var pageRequest = PageRequest.of(page, size);
		var fromSpring = queryService.findAll(pageRequest);
		var body = JsonBaseUtil.toJsonBasePage(fromSpring);

		return new JsonBaseResponse<>(startTime, body);
	}

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
	public Optional<Categori> findById(@PathVariable(required = true, name = "id") int id) {
		return repository.findById(id);
	}
}