package id.co.bfi.test.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

	@OneToMany(mappedBy = "categori", cascade = CascadeType.ALL)
	private Set<Product> product;

}
