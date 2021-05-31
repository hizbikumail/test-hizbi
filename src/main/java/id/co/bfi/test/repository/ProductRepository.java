package id.co.bfi.test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import id.co.bfi.test.entity.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

}
