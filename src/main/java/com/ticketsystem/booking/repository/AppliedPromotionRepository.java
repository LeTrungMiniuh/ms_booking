package com.ticketsystem.booking.repository;

import com.ticketsystem.booking.domain.AppliedPromotion;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the AppliedPromotion entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AppliedPromotionRepository extends JpaRepository<AppliedPromotion, Long>, JpaSpecificationExecutor<AppliedPromotion> {}
