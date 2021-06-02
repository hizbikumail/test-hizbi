package id.co.bfi.test.api.server.response;

import id.co.bfi.test.entity.Categori;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {

	private int productId;
	private String productName;
	private float unitPrice;
	private Categori categori;

}
