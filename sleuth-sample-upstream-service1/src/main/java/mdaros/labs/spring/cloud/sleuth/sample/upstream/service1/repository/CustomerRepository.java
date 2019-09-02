package mdaros.labs.spring.cloud.sleuth.sample.upstream.service1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mdaros.labs.spring.cloud.sleuth.sample.upstream.service1.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}