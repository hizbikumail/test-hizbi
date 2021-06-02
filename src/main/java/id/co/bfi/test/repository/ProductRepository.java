package id.co.bfi.test.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import id.co.bfi.test.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Optional<List<Product>> getProductByproductId(int productId);

	@Query(nativeQuery = true)
	List<Product> findByIdProduct(@Param("id") int id);

	@Query(nativeQuery = true)
	List<Product> findByNameProduct(@Param("name") String name);
}
