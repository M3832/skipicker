package com.m3832.skipicker.service;

import com.m3832.skipicker.domain.Age;
import com.m3832.skipicker.domain.LengthConstraints;
import com.m3832.skipicker.domain.skistyle.SkiStyle;
import org.springframework.stereotype.Component;

@Component
public class CalculateSkiLengthService {

    public SkiLengthsDto calculateSkiLengths(int inputHeight, int inputAge, String inputSkiStyle) {
        final Age age = new Age(inputAge);
        final SkiStyle skiStyle = SkiStyle.valueOf(inputSkiStyle);

        final LengthConstraints lengthConstraints = skiStyle.getLengthConstraintsFromUserHeight(inputHeight);
        final LengthConstraints lengthConstraintsFromAge = age.getLengthConstraints(inputHeight);
        lengthConstraints.combineWith(lengthConstraintsFromAge);

        return new SkiLengthsDto(
                lengthConstraints.getAbsoluteMinLength(),
                lengthConstraints.getAbsoluteMaxLength(),
                lengthConstraints.getRecommendedMinLength(),
                lengthConstraints.getRecommendedMaxLength()
        );
    }
}
