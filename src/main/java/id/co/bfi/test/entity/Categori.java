package id.co.bfi.test.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import id.co.bfi.test.api.server.response.CategoriResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categories", schema = "public")
public class Categori {

	@Id
	@Column(name = "category_id", nullable = true)
	private int categoryId;

	@Column(name = "category_name", nullable = true)
	private String categoryName;

	@Column(name = "description", nullable = false)
	private String description;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "categori")
	@JsonIgnore
	private List<Product> product;

	public CategoriResponse toResponse() {
		return CategoriResponse.builder().categoriId(categoryId).categoriName(categoryName).product(getProduct())
				.build();
	}

}
