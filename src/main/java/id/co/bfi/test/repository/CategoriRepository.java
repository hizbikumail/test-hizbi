package id.co.bfi.test.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.co.bfi.test.entity.Categori;

@Repository
public interface CategoriRepository extends JpaRepository<Categori, Integer> {
	Optional<List<Categori>> getCategoriBycategoryId(int categoryId);

	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "update categories "
			+ " set categoryName = :categoryName, description = :description," + " picture = :picture")
	int update(@Param("categoryName") String categoryName, @Param("description") String description,
			@Param("picture") byte picture);

//	@Query(nativeQuery = true)
//	List<Categori> findCategori(@Param("orderBy") String orderBy, @Param("Limit") int limit,
//			@Param("Offset") int offset);

	@Query(nativeQuery = true)
	List<Categori> findByIdCategori(@Param("id") int id);

	@Query(nativeQuery = true)
	List<Categori> findByNameCategori(@Param("name") String name);
}
