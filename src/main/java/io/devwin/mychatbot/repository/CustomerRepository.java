package io.devwin.mychatbot.repository;

import java.util.List;

import org.springframework.data.solr.repository.SolrCrudRepository;

import io.devwin.mychatbot.model.Customer;

public interface CustomerRepository extends SolrCrudRepository<Customer, String> {
	List<Customer> findByNameEndsWith(String name);
}
