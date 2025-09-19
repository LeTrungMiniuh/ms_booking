package com.ticketsystem.booking.service.mapper;

import com.ticketsystem.booking.domain.PaymentTransaction;
import com.ticketsystem.booking.service.dto.PaymentTransactionDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link PaymentTransaction} and its DTO {@link PaymentTransactionDTO}.
 */
@Mapper(componentModel = "spring")
public interface PaymentTransactionMapper extends EntityMapper<PaymentTransactionDTO, PaymentTransaction> {}
