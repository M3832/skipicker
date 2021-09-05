package com.m3832.skipicker.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class AgeTest {

    private final int HEIGHT = 100;
    private final int LOW_ADDITION = 10;
    private final int HIGH_ADDITION = 20;

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    void getLengthConstraints_ageUnderFiveShouldNotAddToRecommendedLength(int inputAge) {
        final Age age = new Age(inputAge);

        final LengthConstraints lengthConstraints = age.getLengthConstraints(HEIGHT);

        assertEquals(LengthConstraints.UNSET, lengthConstraints.getRecommendedMinLength());
        assertEquals(LengthConstraints.UNSET, lengthConstraints.getRecommendedMaxLength());
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 6, 7, 8})
    void getLengthConstraints_ageBetweenFiveAndEightShouldAddToRecommendedLength(int inputAge) {
        final Age age = new Age(inputAge);

        final LengthConstraints lengthConstraints = age.getLengthConstraints(HEIGHT);

        assertEquals(HEIGHT + LOW_ADDITION, lengthConstraints.getRecommendedMinLength());
        assertEquals(HEIGHT + HIGH_ADDITION, lengthConstraints.getRecommendedMaxLength());
    }

    @ParameterizedTest
    @ValueSource(ints = {9, 10, 11, 12, 13})
    void getLengthConstraints_ageAboveEightShouldNotAddToRecommendedLength(int inputAge) {
        final Age age = new Age(inputAge);

        final LengthConstraints lengthConstraints = age.getLengthConstraints(HEIGHT);

        assertEquals(LengthConstraints.UNSET, lengthConstraints.getRecommendedMinLength());
        assertEquals(LengthConstraints.UNSET, lengthConstraints.getRecommendedMaxLength());
    }
}