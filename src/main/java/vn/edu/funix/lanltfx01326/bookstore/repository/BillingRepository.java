package vn.edu.funix.lanltfx01326.bookstore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vn.edu.funix.lanltfx01326.bookstore.model.Customer;

@Repository
public interface BillingRepository extends CrudRepository<Customer, Long> {

}
