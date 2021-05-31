package id.co.bfi.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products", schema = "public")
public class Product {

	@Id
	@Column(name = "product_id", nullable = true)
	private int productId;

	@Column(name = "product_name", nullable = true)
	private String productName;

	@Column(name = "supplier_id", nullable = false)
	private int supplierId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Categori categori;

	@Column(name = "quantity_per_unit", nullable = false)
	private String quantityPerUnit;

	@Column(name = "unit_price", nullable = false)
	private float unitPrice;

	@Column(name = "units_in_stock", nullable = false)
	private int unitsInStock;

	@Column(name = "units_on_order", nullable = false)
	private int unitOnOrder;

	@Column(name = "reorder_level", nullable = false)
	private int reorderLevel;

	@Column(name = "discontinued", nullable = true)
	private int discontinued;
}
