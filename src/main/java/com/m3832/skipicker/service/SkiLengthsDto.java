package com.m3832.skipicker.service;

public class SkiLengthsDto {

    private final int absoluteMinLength;
    private final int absoluteMaxLength;
    private final int recommendedMinLength;
    private final int recommendedMaxLength;

    public SkiLengthsDto(int absoluteMinLength, int absoluteMaxLength, int recommendedMinLength, int recommendedMaxLength) {
        this.absoluteMinLength = absoluteMinLength;
        this.absoluteMaxLength = absoluteMaxLength;
        this.recommendedMinLength = recommendedMinLength;
        this.recommendedMaxLength = recommendedMaxLength;
    }

    public int getAbsoluteMinLength() {
        return absoluteMinLength;
    }

    public int getAbsoluteMaxLength() {
        return absoluteMaxLength;
    }

    public int getRecommendedMinLength() {
        return recommendedMinLength;
    }

    public int getRecommendedMaxLength() {
        return recommendedMaxLength;
    }
}
