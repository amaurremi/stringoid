package com.quoord.tools.gallery;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public abstract class VersionedGestureDetector {
    static final String LOG_TAG = "VersionedGestureDetector";
    OnGestureListener mListener;

    public static VersionedGestureDetector newInstance(Context paramContext, OnGestureListener paramOnGestureListener) {
        int i = Build.VERSION.SDK_INT;
        if (i < 5) {
            paramContext = new CupcakeDetector(paramContext);
        }
        for (; ; ) {
            paramContext.mListener = paramOnGestureListener;
            return paramContext;
            if (i < 8) {
                paramContext = new EclairDetector(paramContext);
            } else {
                paramContext = new FroyoDetector(paramContext);
            }
        }
    }

    public abstract boolean isScaling();

    public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);

    private static class CupcakeDetector
            extends VersionedGestureDetector {
        private boolean mIsDragging;
        float mLastTouchX;
        float mLastTouchY;
        final float mMinimumVelocity;
        final float mTouchSlop;
        private VelocityTracker mVelocityTracker;

        public CupcakeDetector(Context paramContext) {
            paramContext = ViewConfiguration.get(paramContext);
            this.mMinimumVelocity = paramContext.getScaledMinimumFlingVelocity();
            this.mTouchSlop = paramContext.getScaledTouchSlop();
        }

        float getActiveX(MotionEvent paramMotionEvent) {
            return paramMotionEvent.getX();
        }

        float getActiveY(MotionEvent paramMotionEvent) {
            return paramMotionEvent.getY();
        }

        public boolean isScaling() {
            return false;
        }

        public boolean onTouchEvent(MotionEvent paramMotionEvent) {
            boolean bool = false;
            switch (paramMotionEvent.getAction()) {
            }
            do {
                float f1;
                float f2;
                do {
                    do {
                        float f3;
                        float f4;
                        do {
                            return true;
                            this.mVelocityTracker = VelocityTracker.obtain();
                            this.mVelocityTracker.addMovement(paramMotionEvent);
                            this.mLastTouchX = getActiveX(paramMotionEvent);
                            this.mLastTouchY = getActiveY(paramMotionEvent);
                            this.mIsDragging = false;
                            return true;
                            f1 = getActiveX(paramMotionEvent);
                            f2 = getActiveY(paramMotionEvent);
                            f3 = f1 - this.mLastTouchX;
                            f4 = f2 - this.mLastTouchY;
                            if (!this.mIsDragging) {
                                if (FloatMath.sqrt(f3 * f3 + f4 * f4) >= this.mTouchSlop) {
                                    bool = true;
                                }
                                this.mIsDragging = bool;
                            }
                        } while (!this.mIsDragging);
                        this.mListener.onDrag(f3, f4);
                        this.mLastTouchX = f1;
                        this.mLastTouchY = f2;
                    } while (this.mVelocityTracker == null);
                    this.mVelocityTracker.addMovement(paramMotionEvent);
                    return true;
                } while (this.mVelocityTracker == null);
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                return true;
                if ((this.mIsDragging) && (this.mVelocityTracker != null)) {
                    this.mLastTouchX = getActiveX(paramMotionEvent);
                    this.mLastTouchY = getActiveY(paramMotionEvent);
                    this.mVelocityTracker.addMovement(paramMotionEvent);
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    f1 = this.mVelocityTracker.getXVelocity();
                    f2 = this.mVelocityTracker.getYVelocity();
                    if (Math.max(Math.abs(f1), Math.abs(f2)) >= this.mMinimumVelocity) {
                        this.mListener.onFling(this.mLastTouchX, this.mLastTouchY, -f1, -f2);
                    }
                }
            } while (this.mVelocityTracker == null);
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            return true;
        }
    }

    @TargetApi(5)
    private static class EclairDetector
            extends VersionedGestureDetector.CupcakeDetector {
        private static final int INVALID_POINTER_ID = -1;
        private int mActivePointerId = -1;
        private int mActivePointerIndex = 0;

        public EclairDetector(Context paramContext) {
            super();
        }

        float getActiveX(MotionEvent paramMotionEvent) {
            try {
                float f = paramMotionEvent.getX(this.mActivePointerIndex);
                return f;
            } catch (Exception localException) {
            }
            return paramMotionEvent.getX();
        }

        float getActiveY(MotionEvent paramMotionEvent) {
            try {
                float f = paramMotionEvent.getY(this.mActivePointerIndex);
                return f;
            } catch (Exception localException) {
            }
            return paramMotionEvent.getY();
        }

        public boolean onTouchEvent(MotionEvent paramMotionEvent) {
            int j = 0;
            try {
                switch (paramMotionEvent.getAction() & 0xFF) {
                    case 2:
                    case 4:
                    case 5:
                    case 0:
                        for (; ; ) {
                            i = j;
                            if (this.mActivePointerId != -1) {
                                i = this.mActivePointerId;
                            }
                            this.mActivePointerIndex = paramMotionEvent.findPointerIndex(i);
                            return super.onTouchEvent(paramMotionEvent);
                            this.mActivePointerId = paramMotionEvent.getPointerId(0);
                        }
                }
            } catch (Exception localException) {
                for (; ; ) {
                    localException.printStackTrace();
                    continue;
                    this.mActivePointerId = -1;
                    continue;
                    int i = (paramMotionEvent.getAction() & 0xFF00) >> 8;
                    if (paramMotionEvent.getPointerId(i) == this.mActivePointerId) {
                        if (i == 0) {
                        }
                        for (i = 1; ; i = 0) {
                            this.mActivePointerId = paramMotionEvent.getPointerId(i);
                            this.mLastTouchX = paramMotionEvent.getX(i);
                            this.mLastTouchY = paramMotionEvent.getY(i);
                            break;
                        }
                    }
                }
            }
        }
    }

    @TargetApi(8)
    private static class FroyoDetector
            extends VersionedGestureDetector.EclairDetector {
        private final ScaleGestureDetector mDetector = new ScaleGestureDetector(paramContext, this.mScaleListener);
        private final ScaleGestureDetector.OnScaleGestureListener mScaleListener = new ScaleGestureDetector.OnScaleGestureListener() {
            public boolean onScale(ScaleGestureDetector paramAnonymousScaleGestureDetector) {
                VersionedGestureDetector.FroyoDetector.this.mListener.onScale(paramAnonymousScaleGestureDetector.getScaleFactor(), paramAnonymousScaleGestureDetector.getFocusX(), paramAnonymousScaleGestureDetector.getFocusY());
                return true;
            }

            public boolean onScaleBegin(ScaleGestureDetector paramAnonymousScaleGestureDetector) {
                return true;
            }

            public void onScaleEnd(ScaleGestureDetector paramAnonymousScaleGestureDetector) {
            }
        };

        public FroyoDetector(Context paramContext) {
            super();
        }

        public boolean isScaling() {
            return this.mDetector.isInProgress();
        }

        public boolean onTouchEvent(MotionEvent paramMotionEvent) {
            try {
                this.mDetector.onTouchEvent(paramMotionEvent);
                return super.onTouchEvent(paramMotionEvent);
            } catch (Exception localException) {
                for (; ; ) {
                    localException.printStackTrace();
                }
            }
        }
    }

    public static abstract interface OnGestureListener {
        public abstract void onDrag(float paramFloat1, float paramFloat2);

        public abstract void onFling(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);

        public abstract void onScale(float paramFloat1, float paramFloat2, float paramFloat3);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tools/gallery/VersionedGestureDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */