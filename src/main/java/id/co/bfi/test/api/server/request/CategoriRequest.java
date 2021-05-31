package id.co.bfi.test.api.server.request;

import id.co.bfi.test.entity.Categori;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriRequest {

	public int categoryId;

	public String categoryName;

	public String description;

	public Categori toEntity() {
		return Categori.builder().categoryId(categoryId).categoryName(categoryName).description(description).build();
	}
}
