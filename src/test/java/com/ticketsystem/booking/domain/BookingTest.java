package com.ticketsystem.booking.domain;

import static com.ticketsystem.booking.domain.AppliedPromotionTestSamples.*;
import static com.ticketsystem.booking.domain.BookingTestSamples.*;
import static com.ticketsystem.booking.domain.InvoiceTestSamples.*;
import static com.ticketsystem.booking.domain.PaymentTransactionTestSamples.*;
import static com.ticketsystem.booking.domain.TicketTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ticketsystem.booking.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class BookingTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Booking.class);
        Booking booking1 = getBookingSample1();
        Booking booking2 = new Booking();
        assertThat(booking1).isNotEqualTo(booking2);

        booking2.setId(booking1.getId());
        assertThat(booking1).isEqualTo(booking2);

        booking2 = getBookingSample2();
        assertThat(booking1).isNotEqualTo(booking2);
    }

    @Test
    void invoiceTest() {
        Booking booking = getBookingRandomSampleGenerator();
        Invoice invoiceBack = getInvoiceRandomSampleGenerator();

        booking.setInvoice(invoiceBack);
        assertThat(booking.getInvoice()).isEqualTo(invoiceBack);

        booking.invoice(null);
        assertThat(booking.getInvoice()).isNull();
    }

    @Test
    void paymentTransactionTest() {
        Booking booking = getBookingRandomSampleGenerator();
        PaymentTransaction paymentTransactionBack = getPaymentTransactionRandomSampleGenerator();

        booking.setPaymentTransaction(paymentTransactionBack);
        assertThat(booking.getPaymentTransaction()).isEqualTo(paymentTransactionBack);

        booking.paymentTransaction(null);
        assertThat(booking.getPaymentTransaction()).isNull();
    }

    @Test
    void ticketsTest() {
        Booking booking = getBookingRandomSampleGenerator();
        Ticket ticketBack = getTicketRandomSampleGenerator();

        booking.addTickets(ticketBack);
        assertThat(booking.getTickets()).containsOnly(ticketBack);
        assertThat(ticketBack.getBooking()).isEqualTo(booking);

        booking.removeTickets(ticketBack);
        assertThat(booking.getTickets()).doesNotContain(ticketBack);
        assertThat(ticketBack.getBooking()).isNull();

        booking.tickets(new HashSet<>(Set.of(ticketBack)));
        assertThat(booking.getTickets()).containsOnly(ticketBack);
        assertThat(ticketBack.getBooking()).isEqualTo(booking);

        booking.setTickets(new HashSet<>());
        assertThat(booking.getTickets()).doesNotContain(ticketBack);
        assertThat(ticketBack.getBooking()).isNull();
    }

    @Test
    void appliedPromosTest() {
        Booking booking = getBookingRandomSampleGenerator();
        AppliedPromotion appliedPromotionBack = getAppliedPromotionRandomSampleGenerator();

        booking.addAppliedPromos(appliedPromotionBack);
        assertThat(booking.getAppliedPromos()).containsOnly(appliedPromotionBack);
        assertThat(appliedPromotionBack.getBooking()).isEqualTo(booking);

        booking.removeAppliedPromos(appliedPromotionBack);
        assertThat(booking.getAppliedPromos()).doesNotContain(appliedPromotionBack);
        assertThat(appliedPromotionBack.getBooking()).isNull();

        booking.appliedPromos(new HashSet<>(Set.of(appliedPromotionBack)));
        assertThat(booking.getAppliedPromos()).containsOnly(appliedPromotionBack);
        assertThat(appliedPromotionBack.getBooking()).isEqualTo(booking);

        booking.setAppliedPromos(new HashSet<>());
        assertThat(booking.getAppliedPromos()).doesNotContain(appliedPromotionBack);
        assertThat(appliedPromotionBack.getBooking()).isNull();
    }
}
