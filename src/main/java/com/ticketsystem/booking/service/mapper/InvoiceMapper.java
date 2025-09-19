package com.ticketsystem.booking.service.mapper;

import com.ticketsystem.booking.domain.Invoice;
import com.ticketsystem.booking.service.dto.InvoiceDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Invoice} and its DTO {@link InvoiceDTO}.
 */
@Mapper(componentModel = "spring")
public interface InvoiceMapper extends EntityMapper<InvoiceDTO, Invoice> {}
