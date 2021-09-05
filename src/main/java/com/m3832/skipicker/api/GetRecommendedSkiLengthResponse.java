package com.m3832.skipicker.api;

public class GetRecommendedSkiLengthResponse {

    private final int minimumLength;
    private final int maximumLength;
    private final int recommendedMinimumLength;
    private final int recommendedMaximumLength;

    public GetRecommendedSkiLengthResponse(int minimumLength, int maximumLength, int recommendedMinimumLength, int recommendedMaximumLength) {
        this.minimumLength = minimumLength;
        this.maximumLength = maximumLength;
        this.recommendedMinimumLength = recommendedMinimumLength;
        this.recommendedMaximumLength = recommendedMaximumLength;
    }

    public int getMinimumLength() {
        return minimumLength;
    }

    public int getMaximumLength() {
        return maximumLength;
    }

    public int getRecommendedMinimumLength() {
        return recommendedMinimumLength;
    }

    public int getRecommendedMaximumLength() {
        return recommendedMaximumLength;
    }
}
