package com.m3832.skipicker.service;

import com.m3832.skipicker.domain.LengthConstraints;
import com.m3832.skipicker.domain.skistyle.ClassicSkiStyleConstraints;
import com.m3832.skipicker.domain.skistyle.FreestyleSkiStyleConstraints;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateSkiLengthServiceTest {

    private CalculateSkiLengthService calculateSkiLengthService;

    private final int HEIGHT = 100;
    private final int AGE = 10;

    @BeforeEach
    void setup() {
        calculateSkiLengthService = new CalculateSkiLengthService();
    }

    @Test
    void calculateSkiLengths_classic() {
        final SkiLengthsDto result =
                calculateSkiLengthService.calculateSkiLengths(HEIGHT, AGE, "CLASSIC");

        assertEquals(HEIGHT + ClassicSkiStyleConstraints.LENGTH_ADDITION, result.getRecommendedMaxLength());
        assertEquals(HEIGHT + ClassicSkiStyleConstraints.LENGTH_ADDITION, result.getRecommendedMinLength());
        assertEquals(ClassicSkiStyleConstraints.MAX_LENGTH, result.getAbsoluteMaxLength());
        assertEquals(LengthConstraints.UNSET, result.getAbsoluteMinLength());
    }

    @Test
    void calculateSkiLengths_freestyle() {
        final SkiLengthsDto result =
                calculateSkiLengthService.calculateSkiLengths(HEIGHT, AGE, "FREESTYLE");

        assertEquals(HEIGHT + FreestyleSkiStyleConstraints.MAX_RECOMMENDED_LENGTH_ADDITION, result.getRecommendedMaxLength());
        assertEquals(HEIGHT + FreestyleSkiStyleConstraints.MIN_RECOMMENDED_LENGTH_ADDITION, result.getRecommendedMinLength());
        assertEquals(LengthConstraints.UNSET, result.getAbsoluteMaxLength());
        assertEquals(HEIGHT - FreestyleSkiStyleConstraints.MIN_LENGTH_SUBTRACTION, result.getAbsoluteMinLength());
    }
}