package id.co.bfi.test.api.server.response;

import java.util.List;

import id.co.bfi.test.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoriResponse {

	private int categoriId;
	private String categoriName;
	private List<Product> product;
}
