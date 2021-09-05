package com.m3832.skipicker.domain.skistyle;

import com.m3832.skipicker.domain.LengthConstraints;

public class ClassicSkiStyleConstraints implements SkiStyleConstraints {

    public static final int MAX_LENGTH = 207;
    public static final int LENGTH_ADDITION = 20;

    @Override
    public LengthConstraints getLengthConstraints(int height) {
        final LengthConstraints lengthConstraints = new LengthConstraints();
        final int recommendedLength = Math.min(height + LENGTH_ADDITION, MAX_LENGTH);

        lengthConstraints.setAbsoluteMaxLength(MAX_LENGTH);
        lengthConstraints.setRecommendedMinLength(recommendedLength);
        lengthConstraints.setRecommendedMaxLength(recommendedLength);

        return lengthConstraints;
    }
}
