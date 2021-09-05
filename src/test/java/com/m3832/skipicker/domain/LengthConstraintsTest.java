package com.m3832.skipicker.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthConstraintsTest {

    private final int LOW_LENGTH = 100;
    private final int MID_LENGTH = 105;
    private final int HIGH_LENGTH = 110;

    @Test
    void combineWith_recommendedMaximumLength_shouldUseHighest() {
        final LengthConstraints lengthConstraints = new LengthConstraints();
        lengthConstraints.setRecommendedMaxLength(LOW_LENGTH);
        final LengthConstraints otherLengthConstraints = new LengthConstraints();
        otherLengthConstraints.setRecommendedMaxLength(HIGH_LENGTH);

        lengthConstraints.combineWith(otherLengthConstraints);

        assertEquals(HIGH_LENGTH, lengthConstraints.getRecommendedMaxLength());
    }

    @Test
    void combineWith_recommendedMaximumLength_shouldBeRestrictedByAbsoluteMaximumLength() {
        final LengthConstraints lengthConstraints = new LengthConstraints();
        lengthConstraints.setRecommendedMaxLength(LOW_LENGTH);
        lengthConstraints.setAbsoluteMaxLength(MID_LENGTH);
        final LengthConstraints otherLengthConstraints = new LengthConstraints();
        otherLengthConstraints.setRecommendedMaxLength(HIGH_LENGTH);

        lengthConstraints.combineWith(otherLengthConstraints);

        assertEquals(MID_LENGTH, lengthConstraints.getRecommendedMaxLength());
    }

    @Test
    void combineWith_recommendedMinimumLength_shouldUseLowest() {
        final LengthConstraints lengthConstraints = new LengthConstraints();
        lengthConstraints.setRecommendedMinLength(LOW_LENGTH);
        final LengthConstraints otherLengthConstraints = new LengthConstraints();
        otherLengthConstraints.setRecommendedMinLength(HIGH_LENGTH);

        lengthConstraints.combineWith(otherLengthConstraints);

        assertEquals(LOW_LENGTH, lengthConstraints.getRecommendedMinLength());
    }

    @Test
    void combineWith_recommendedMinimumLength_shouldBeRestrictedByAbsoluteMinimumLength() {
        final LengthConstraints lengthConstraints = new LengthConstraints();
        lengthConstraints.setRecommendedMinLength(LOW_LENGTH);
        final LengthConstraints otherLengthConstraints = new LengthConstraints();
        otherLengthConstraints.setRecommendedMinLength(HIGH_LENGTH);
        otherLengthConstraints.setAbsoluteMinLength(MID_LENGTH);

        lengthConstraints.combineWith(otherLengthConstraints);

        assertEquals(MID_LENGTH, lengthConstraints.getRecommendedMinLength());
    }
}