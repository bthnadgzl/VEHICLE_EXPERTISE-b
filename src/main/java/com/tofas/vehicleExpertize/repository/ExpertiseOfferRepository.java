package com.tofas.vehicleExpertize.repository;

import com.tofas.vehicleExpertize.model.entity.ExpertiseOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertiseOfferRepository extends JpaRepository<ExpertiseOffer, Long> {
}
