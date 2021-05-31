package id.co.bfi.test.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import id.co.bfi.test.entity.Categori;

public interface CategoriRepository extends PagingAndSortingRepository<Categori, Integer> {

	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "update categories "
			+ " set categoryName = :categoryName, description = :description," + " picture = :picture")
	int update(@Param("categoryName") String categoryName, @Param("description") String description,
			@Param("picture") byte picture);
}
