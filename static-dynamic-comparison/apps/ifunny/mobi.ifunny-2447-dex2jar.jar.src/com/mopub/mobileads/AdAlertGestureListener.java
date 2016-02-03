package com.mopub.mobileads;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

public class AdAlertGestureListener
        extends GestureDetector.SimpleOnGestureListener {
    private static final float MAXIMUM_THRESHOLD_X_IN_DIPS = 100.0F;
    private static final float MAXIMUM_THRESHOLD_Y_IN_DIPS = 50.0F;
    private static final int MINIMUM_NUMBER_OF_ZIGZAGS_TO_FLAG = 4;
    private AdAlertReporter mAdAlertReporter;
    private AdConfiguration mAdConfiguration;
    private float mCurrentThresholdInDips = 100.0F;
    private AdAlertGestureListener.ZigZagState mCurrentZigZagState = AdAlertGestureListener.ZigZagState.UNSET;
    private boolean mHasCrossedLeftThreshold;
    private boolean mHasCrossedRightThreshold;
    private int mNumberOfZigZags;
    private float mPivotPositionX;
    private float mPreviousPositionX;
    private View mView;

    AdAlertGestureListener(View paramView, AdConfiguration paramAdConfiguration) {
        if ((paramView != null) && (paramView.getWidth() > 0)) {
            this.mCurrentThresholdInDips = Math.min(100.0F, paramView.getWidth() / 3.0F);
        }
        this.mView = paramView;
        this.mAdConfiguration = paramAdConfiguration;
    }

    private void incrementNumberOfZigZags() {
        this.mNumberOfZigZags += 1;
        if (this.mNumberOfZigZags >= 4) {
            this.mCurrentZigZagState = AdAlertGestureListener.ZigZagState.FINISHED;
        }
    }

    private boolean isMovingLeft(float paramFloat) {
        return paramFloat < this.mPreviousPositionX;
    }

    private boolean isMovingRight(float paramFloat) {
        return paramFloat > this.mPreviousPositionX;
    }

    private boolean isTouchOutOfBoundsOnYAxis(float paramFloat1, float paramFloat2) {
        return Math.abs(paramFloat2 - paramFloat1) > 50.0F;
    }

    private boolean leftThresholdReached(float paramFloat) {
        if (this.mHasCrossedLeftThreshold) {
            return true;
        }
        if (paramFloat <= this.mPivotPositionX - this.mCurrentThresholdInDips) {
            this.mHasCrossedRightThreshold = false;
            this.mHasCrossedLeftThreshold = true;
            incrementNumberOfZigZags();
            return true;
        }
        return false;
    }

    private boolean rightThresholdReached(float paramFloat) {
        if (this.mHasCrossedRightThreshold) {
            return true;
        }
        if (paramFloat >= this.mPivotPositionX + this.mCurrentThresholdInDips) {
            this.mHasCrossedLeftThreshold = false;
            this.mHasCrossedRightThreshold = true;
            return true;
        }
        return false;
    }

    private void updateInitialState(float paramFloat) {
        if (paramFloat > this.mPivotPositionX) {
            this.mCurrentZigZagState = AdAlertGestureListener.ZigZagState.GOING_RIGHT;
        }
    }

    private void updateZag(float paramFloat) {
        if ((leftThresholdReached(paramFloat)) && (isMovingRight(paramFloat))) {
            this.mCurrentZigZagState = AdAlertGestureListener.ZigZagState.GOING_RIGHT;
            this.mPivotPositionX = paramFloat;
        }
    }

    private void updateZig(float paramFloat) {
        if ((rightThresholdReached(paramFloat)) && (isMovingLeft(paramFloat))) {
            this.mCurrentZigZagState = AdAlertGestureListener.ZigZagState.GOING_LEFT;
            this.mPivotPositionX = paramFloat;
        }
    }

    void finishGestureDetection() {
        AdAlertGestureListener.ZigZagState localZigZagState1 = this.mCurrentZigZagState;
        AdAlertGestureListener.ZigZagState localZigZagState2 = this.mCurrentZigZagState;
        if (localZigZagState1 == AdAlertGestureListener.ZigZagState.FINISHED) {
            this.mAdAlertReporter = new AdAlertReporter(this.mView.getContext(), this.mView, this.mAdConfiguration);
            this.mAdAlertReporter.send();
        }
        reset();
    }

    @Deprecated
    AdAlertReporter getAdAlertReporter() {
        return this.mAdAlertReporter;
    }

    @Deprecated
    AdAlertGestureListener.ZigZagState getCurrentZigZagState() {
        return this.mCurrentZigZagState;
    }

    @Deprecated
    float getMinimumDipsInZigZag() {
        return this.mCurrentThresholdInDips;
    }

    @Deprecated
    int getNumberOfZigzags() {
        return this.mNumberOfZigZags;
    }

    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2) {
        if (this.mCurrentZigZagState == AdAlertGestureListener.ZigZagState.FINISHED) {
            return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        }
        if (isTouchOutOfBoundsOnYAxis(paramMotionEvent1.getY(), paramMotionEvent2.getY())) {
            this.mCurrentZigZagState = AdAlertGestureListener.ZigZagState.FAILED;
            return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        }
        switch (AdAlertGestureListener
        .1.$SwitchMap$com$mopub$mobileads$AdAlertGestureListener$ZigZagState[this.mCurrentZigZagState.ordinal()])
        {
        }
        for (; ; ) {
            this.mPreviousPositionX = paramMotionEvent2.getX();
            return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
            this.mPivotPositionX = paramMotionEvent1.getX();
            updateInitialState(paramMotionEvent2.getX());
            continue;
            updateZig(paramMotionEvent2.getX());
            continue;
            updateZag(paramMotionEvent2.getX());
        }
    }

    void reset() {
        this.mNumberOfZigZags = 0;
        this.mCurrentZigZagState = AdAlertGestureListener.ZigZagState.UNSET;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/AdAlertGestureListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */