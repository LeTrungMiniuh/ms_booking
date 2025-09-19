package com.ticketsystem.booking.service.mapper;

import com.ticketsystem.booking.domain.AppliedPromotion;
import com.ticketsystem.booking.domain.Booking;
import com.ticketsystem.booking.service.dto.AppliedPromotionDTO;
import com.ticketsystem.booking.service.dto.BookingDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link AppliedPromotion} and its DTO {@link AppliedPromotionDTO}.
 */
@Mapper(componentModel = "spring")
public interface AppliedPromotionMapper extends EntityMapper<AppliedPromotionDTO, AppliedPromotion> {
    @Mapping(target = "booking", source = "booking", qualifiedByName = "bookingId")
    AppliedPromotionDTO toDto(AppliedPromotion s);

    @Named("bookingId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    BookingDTO toDtoBookingId(Booking booking);
}
