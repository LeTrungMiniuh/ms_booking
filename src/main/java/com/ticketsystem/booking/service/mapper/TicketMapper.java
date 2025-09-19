package com.ticketsystem.booking.service.mapper;

import com.ticketsystem.booking.domain.Booking;
import com.ticketsystem.booking.domain.Ticket;
import com.ticketsystem.booking.service.dto.BookingDTO;
import com.ticketsystem.booking.service.dto.TicketDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Ticket} and its DTO {@link TicketDTO}.
 */
@Mapper(componentModel = "spring")
public interface TicketMapper extends EntityMapper<TicketDTO, Ticket> {
    @Mapping(target = "booking", source = "booking", qualifiedByName = "bookingId")
    TicketDTO toDto(Ticket s);

    @Named("bookingId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    BookingDTO toDtoBookingId(Booking booking);
}
