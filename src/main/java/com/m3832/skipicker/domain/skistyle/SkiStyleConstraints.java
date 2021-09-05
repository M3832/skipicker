package com.m3832.skipicker.domain.skistyle;

import com.m3832.skipicker.domain.LengthConstraints;

public interface SkiStyleConstraints {
    LengthConstraints getLengthConstraintsFromUserHeight(int userHeight);
}
