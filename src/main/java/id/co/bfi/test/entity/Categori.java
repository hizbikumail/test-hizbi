package id.co.bfi.test.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	@JsonIgnoreProperties("categori")
	private List<Product> product;

}
