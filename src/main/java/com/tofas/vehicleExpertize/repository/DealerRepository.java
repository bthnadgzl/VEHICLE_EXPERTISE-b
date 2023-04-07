package com.tofas.vehicleExpertize.repository;


import com.tofas.vehicleExpertize.model.entity.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealerRepository extends JpaRepository<Dealer, Long> {
}
