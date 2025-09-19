package com.ticketsystem.booking.domain;

import static com.ticketsystem.booking.domain.AppliedPromotionTestSamples.*;
import static com.ticketsystem.booking.domain.BookingTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ticketsystem.booking.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class AppliedPromotionTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(AppliedPromotion.class);
        AppliedPromotion appliedPromotion1 = getAppliedPromotionSample1();
        AppliedPromotion appliedPromotion2 = new AppliedPromotion();
        assertThat(appliedPromotion1).isNotEqualTo(appliedPromotion2);

        appliedPromotion2.setId(appliedPromotion1.getId());
        assertThat(appliedPromotion1).isEqualTo(appliedPromotion2);

        appliedPromotion2 = getAppliedPromotionSample2();
        assertThat(appliedPromotion1).isNotEqualTo(appliedPromotion2);
    }

    @Test
    void bookingTest() {
        AppliedPromotion appliedPromotion = getAppliedPromotionRandomSampleGenerator();
        Booking bookingBack = getBookingRandomSampleGenerator();

        appliedPromotion.setBooking(bookingBack);
        assertThat(appliedPromotion.getBooking()).isEqualTo(bookingBack);

        appliedPromotion.booking(null);
        assertThat(appliedPromotion.getBooking()).isNull();
    }
}
