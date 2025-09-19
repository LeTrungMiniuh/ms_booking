package com.ticketsystem.booking.service.impl;

import com.ticketsystem.booking.domain.AppliedPromotion;
import com.ticketsystem.booking.repository.AppliedPromotionRepository;
import com.ticketsystem.booking.service.AppliedPromotionService;
import com.ticketsystem.booking.service.dto.AppliedPromotionDTO;
import com.ticketsystem.booking.service.mapper.AppliedPromotionMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.ticketsystem.booking.domain.AppliedPromotion}.
 */
@Service
@Transactional
public class AppliedPromotionServiceImpl implements AppliedPromotionService {

    private static final Logger LOG = LoggerFactory.getLogger(AppliedPromotionServiceImpl.class);

    private final AppliedPromotionRepository appliedPromotionRepository;

    private final AppliedPromotionMapper appliedPromotionMapper;

    public AppliedPromotionServiceImpl(
        AppliedPromotionRepository appliedPromotionRepository,
        AppliedPromotionMapper appliedPromotionMapper
    ) {
        this.appliedPromotionRepository = appliedPromotionRepository;
        this.appliedPromotionMapper = appliedPromotionMapper;
    }

    @Override
    public AppliedPromotionDTO save(AppliedPromotionDTO appliedPromotionDTO) {
        LOG.debug("Request to save AppliedPromotion : {}", appliedPromotionDTO);
        AppliedPromotion appliedPromotion = appliedPromotionMapper.toEntity(appliedPromotionDTO);
        appliedPromotion = appliedPromotionRepository.save(appliedPromotion);
        return appliedPromotionMapper.toDto(appliedPromotion);
    }

    @Override
    public AppliedPromotionDTO update(AppliedPromotionDTO appliedPromotionDTO) {
        LOG.debug("Request to update AppliedPromotion : {}", appliedPromotionDTO);
        AppliedPromotion appliedPromotion = appliedPromotionMapper.toEntity(appliedPromotionDTO);
        appliedPromotion = appliedPromotionRepository.save(appliedPromotion);
        return appliedPromotionMapper.toDto(appliedPromotion);
    }

    @Override
    public Optional<AppliedPromotionDTO> partialUpdate(AppliedPromotionDTO appliedPromotionDTO) {
        LOG.debug("Request to partially update AppliedPromotion : {}", appliedPromotionDTO);

        return appliedPromotionRepository
            .findById(appliedPromotionDTO.getId())
            .map(existingAppliedPromotion -> {
                appliedPromotionMapper.partialUpdate(existingAppliedPromotion, appliedPromotionDTO);

                return existingAppliedPromotion;
            })
            .map(appliedPromotionRepository::save)
            .map(appliedPromotionMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AppliedPromotionDTO> findOne(Long id) {
        LOG.debug("Request to get AppliedPromotion : {}", id);
        return appliedPromotionRepository.findById(id).map(appliedPromotionMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete AppliedPromotion : {}", id);
        appliedPromotionRepository.deleteById(id);
    }
}
