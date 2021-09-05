package com.m3832.skipicker.domain;

public class LengthConstraints {

    public static final int UNSET = -1;

    private int absoluteMinLength;
    private int absoluteMaxLength;
    private int recommendedMinLength;
    private int recommendedMaxLength;

    public LengthConstraints() {
        absoluteMinLength = LengthConstraints.UNSET;
        absoluteMaxLength = LengthConstraints.UNSET;
        recommendedMinLength = LengthConstraints.UNSET;
        recommendedMaxLength = LengthConstraints.UNSET;
    }

    public void combineWith(LengthConstraints other) {
        if(other.getAbsoluteMinLength() > this.absoluteMinLength
                && other.getAbsoluteMinLength() != LengthConstraints.UNSET) {
            this.absoluteMinLength = other.getAbsoluteMinLength();
        }

        if(other.getAbsoluteMaxLength() < this.absoluteMaxLength
            && other.getAbsoluteMaxLength() != LengthConstraints.UNSET) {
            this.absoluteMaxLength = other.getAbsoluteMaxLength();
        }

        if(other.getRecommendedMaxLength() != LengthConstraints.UNSET) {
            recommendedMaxLength = Math.max(recommendedMaxLength, other.getRecommendedMaxLength());

            if(absoluteMaxLength != LengthConstraints.UNSET) {
                recommendedMaxLength = Math.min(recommendedMaxLength, absoluteMaxLength);
            }
        }

        if(other.getRecommendedMinLength() != LengthConstraints.UNSET) {
            recommendedMinLength = Math.min(recommendedMinLength, other.getRecommendedMinLength());

            if(absoluteMinLength != LengthConstraints.UNSET) {
                recommendedMinLength = Math.max(recommendedMinLength, absoluteMinLength);
            }
        }
    }

    public int getAbsoluteMinLength() {
        return absoluteMinLength;
    }

    public void setAbsoluteMinLength(int absoluteMinLength) {
        this.absoluteMinLength = absoluteMinLength;
    }

    public int getAbsoluteMaxLength() {
        return absoluteMaxLength;
    }

    public void setAbsoluteMaxLength(int absoluteMaxLength) {
        this.absoluteMaxLength = absoluteMaxLength;
    }

    public int getRecommendedMinLength() {
        return recommendedMinLength;
    }

    public void setRecommendedMinLength(int recommendedMinLength) {
        this.recommendedMinLength = recommendedMinLength;
    }

    public int getRecommendedMaxLength() {
        return recommendedMaxLength;
    }

    public void setRecommendedMaxLength(int recommendedMaxLength) {
        this.recommendedMaxLength = recommendedMaxLength;
    }
}
