package mdaros.labs.spring.cloud.sleuthsampleupstreamservice2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mdaros.labs.spring.cloud.sleuthsampleupstreamservice2.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {

	public List<Address> findByCustomerId ( String customerId );
}