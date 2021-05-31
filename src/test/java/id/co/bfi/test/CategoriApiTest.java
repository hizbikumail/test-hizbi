package id.co.bfi.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import id.co.bfi.test.api.server.request.CategoriRequest;

class CategoriApiTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	public int categId = ThreadLocalRandom.current().nextInt(10, 50);
	public int temp = 0;

	@Test
	void testCreateCategories() throws Exception {
		var requestData = new CategoriRequest(categId, "UnitTest", "Kopi hitam, kopi manis");
		temp = categId;
		this.mockMvc
				.perform(post("/api/categori/").contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(requestData)))
				.andDo(print()).andExpect(status().is2xxSuccessful());
	}

	@Test
	void testFindAllCategories() throws Exception {
		var rb = MockMvcRequestBuilders.get("/api/categori/findAll");
		mockMvc.perform(rb).andDo(print()).andExpect(status().is2xxSuccessful());
	}

	@Test
	void testUpdateCategories() throws Exception {
		var requestData = new CategoriRequest(41, "UnitTestUp", "Kopi susu, Kopiko");
		var rb = MockMvcRequestBuilders.put("/api/categori/" + 22).content(objectMapper.writeValueAsString(requestData))
				.contentType(MediaType.APPLICATION_JSON);
		this.mockMvc.perform(rb).andDo(print()).andExpect(status().is2xxSuccessful());
	}

	@Test
	void testDeleteCategories() throws Exception {
		var rb = MockMvcRequestBuilders.delete("/api/categori/delete/" + 22)
				.contentType(MediaType.APPLICATION_JSON_VALUE);
		this.mockMvc.perform(rb).andDo(print()).andExpect(status().is2xxSuccessful());

	}

	@Test
	void testFindById() throws Exception {
		var rb = MockMvcRequestBuilders.get("api/categori/findById/" + 8);
		mockMvc.perform(rb).andDo(print()).andExpect(status().is2xxSuccessful());
	}

}
