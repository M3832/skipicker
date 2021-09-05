package com.m3832.skipicker.domain.skistyle;

import com.m3832.skipicker.domain.LengthConstraints;

public class FreestyleSkiStyleConstraints implements SkiStyleConstraints {

    public static final int MIN_RECOMMENDED_LENGTH_ADDITION = 10;
    public static final int MAX_RECOMMENDED_LENGTH_ADDITION = 15;
    public static final int MIN_LENGTH_SUBTRACTION = 10;

    @Override
    public LengthConstraints getLengthConstraints(int height) {
        final LengthConstraints lengthConstraints = new LengthConstraints();

        lengthConstraints.setRecommendedMinLength(height + MIN_RECOMMENDED_LENGTH_ADDITION);
        lengthConstraints.setRecommendedMaxLength(height + MAX_RECOMMENDED_LENGTH_ADDITION);
        lengthConstraints.setAbsoluteMinLength(height - MIN_LENGTH_SUBTRACTION);

        return lengthConstraints;
    }
}
