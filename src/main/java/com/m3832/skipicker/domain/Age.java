package com.m3832.skipicker.domain;

public class Age {

    private final int value;

    public Age(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public LengthConstraints getLengthConstraints(int height) {
        final LengthConstraints lengthConstraints = new LengthConstraints();

        if(value >= 5 && value <= 8) {
            lengthConstraints.setRecommendedMinLength(height + 10);
            lengthConstraints.setRecommendedMaxLength(height + 20);
        }

        return lengthConstraints;
    }
}
