package com.m3832.skipicker.domain.skistyle;

import com.m3832.skipicker.domain.LengthConstraints;

public enum SkiStyle {
    CLASSIC(new ClassicSkiStyleConstraints()),
    FREESTYLE(new FreestyleSkiStyleConstraints());

    private final SkiStyleConstraints skiStyleConstraints;

    SkiStyle(SkiStyleConstraints skiStyleConstraints) {
        this.skiStyleConstraints = skiStyleConstraints;
    }

    public LengthConstraints getLengthConstraints(int userHeight) {
        return skiStyleConstraints.getLengthConstraints(userHeight);
    }
}
