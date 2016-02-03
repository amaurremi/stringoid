package com.quoord.tools.gallery;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import java.lang.ref.WeakReference;

public class PhotoViewAttacher
        implements IPhotoView, View.OnTouchListener, VersionedGestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, ViewTreeObserver.OnGlobalLayoutListener {
    static final boolean DEBUG = Log.isLoggable("PhotoViewAttacher", 3);
    public static final float DEFAULT_MAX_SCALE = 3.0F;
    public static final float DEFAULT_MID_SCALE = 1.75F;
    public static final float DEFAULT_MIN_SCALE = 1.0F;
    static final int EDGE_BOTH = 2;
    static final int EDGE_LEFT = 0;
    static final int EDGE_NONE = -1;
    static final int EDGE_RIGHT = 1;
    static final String LOG_TAG = "PhotoViewAttacher";
    private boolean mAllowParentInterceptOnEdge = true;
    private final Matrix mBaseMatrix = new Matrix();
    private FlingRunnable mCurrentFlingRunnable;
    private final RectF mDisplayRect = new RectF();
    private final Matrix mDrawMatrix = new Matrix();
    private GestureDetector mGestureDetector;
    private WeakReference<ImageView> mImageView;
    private int mIvBottom;
    private int mIvLeft;
    private int mIvRight;
    private int mIvTop;
    private View.OnLongClickListener mLongClickListener;
    private OnMatrixChangedListener mMatrixChangeListener;
    private final float[] mMatrixValues = new float[9];
    private float mMaxScale = 3.0F;
    private float mMidScale = 1.75F;
    private float mMinScale = 1.0F;
    private OnPhotoTapListener mPhotoTapListener;
    private VersionedGestureDetector mScaleDragDetector;
    private ImageView.ScaleType mScaleType = ImageView.ScaleType.FIT_CENTER;
    private int mScrollEdge = 2;
    private final Matrix mSuppMatrix = new Matrix();
    private OnViewTapListener mViewTapListener;
    private ViewTreeObserver mViewTreeObserver;
    private boolean mZoomEnabled;

    public PhotoViewAttacher(ImageView paramImageView) {
        this.mImageView = new WeakReference(paramImageView);
        paramImageView.setOnTouchListener(this);
        this.mViewTreeObserver = paramImageView.getViewTreeObserver();
        this.mViewTreeObserver.addOnGlobalLayoutListener(this);
        setImageViewScaleTypeMatrix(paramImageView);
        if (!paramImageView.isInEditMode()) {
            this.mScaleDragDetector = VersionedGestureDetector.newInstance(paramImageView.getContext(), this);
            this.mGestureDetector = new GestureDetector(paramImageView.getContext(), new GestureDetector.SimpleOnGestureListener() {
                public void onLongPress(MotionEvent paramAnonymousMotionEvent) {
                    if (PhotoViewAttacher.this.mLongClickListener != null) {
                        PhotoViewAttacher.this.mLongClickListener.onLongClick((View) PhotoViewAttacher.this.mImageView.get());
                    }
                }
            });
            this.mGestureDetector.setOnDoubleTapListener(this);
            setZoomable(true);
        }
    }

    private void cancelFling() {
        if (this.mCurrentFlingRunnable != null) {
            this.mCurrentFlingRunnable.cancelFling();
            this.mCurrentFlingRunnable = null;
        }
    }

    private void checkAndDisplayMatrix() {
        checkMatrixBounds();
        setImageViewMatrix(getDisplayMatrix());
    }

    private void checkImageViewScaleType() {
        ImageView localImageView = getImageView();
        if ((localImageView != null) && (!(localImageView instanceof PhotoView)) && (localImageView.getScaleType() != ImageView.ScaleType.MATRIX)) {
            throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
        }
    }

    private void checkMatrixBounds() {
        ImageView localImageView = getImageView();
        if (localImageView == null) {
        }
        RectF localRectF;
        do {
            return;
            localRectF = getDisplayRect(getDisplayMatrix());
        } while (localRectF == null);
        float f4 = localRectF.height();
        float f3 = localRectF.width();
        float f2 = 0.0F;
        float f1 = 0.0F;
        int i = localImageView.getHeight();
        if (f4 <= i) {
            switch (this.mScaleType) {
                default:
                    f1 = (i - f4) / 2.0F - localRectF.top;
                    i = localImageView.getWidth();
                    if (f3 <= i) {
                        switch (this.mScaleType) {
                            default:
                                f2 = (i - f3) / 2.0F - localRectF.left;
                                label170:
                                this.mScrollEdge = 2;
                        }
                    }
                    break;
            }
        }
        for (; ; ) {
            this.mSuppMatrix.postTranslate(f2, f1);
            return;
            f1 = -localRectF.top;
            break;
            f1 = i - f4 - localRectF.top;
            break;
            if (localRectF.top > 0.0F) {
                f1 = -localRectF.top;
                break;
            }
            if (localRectF.bottom >= i) {
                break;
            }
            f1 = i - localRectF.bottom;
            break;
            f2 = -localRectF.left;
            break label170;
            f2 = i - f3 - localRectF.left;
            break label170;
            if (localRectF.left > 0.0F) {
                this.mScrollEdge = 0;
                f2 = -localRectF.left;
            } else if (localRectF.right < i) {
                f2 = i - localRectF.right;
                this.mScrollEdge = 1;
            } else {
                this.mScrollEdge = -1;
            }
        }
    }

    private static void checkZoomLevels(float paramFloat1, float paramFloat2, float paramFloat3) {
        if (paramFloat1 >= paramFloat2) {
            throw new IllegalArgumentException("MinZoom should be less than MidZoom");
        }
        if (paramFloat2 >= paramFloat3) {
            throw new IllegalArgumentException("MidZoom should be less than MaxZoom");
        }
    }

    private RectF getDisplayRect(Matrix paramMatrix) {
        Object localObject = getImageView();
        if (localObject != null) {
            localObject = ((ImageView) localObject).getDrawable();
            if (localObject != null) {
                this.mDisplayRect.set(0.0F, 0.0F, ((Drawable) localObject).getIntrinsicWidth(), ((Drawable) localObject).getIntrinsicHeight());
                paramMatrix.mapRect(this.mDisplayRect);
                return this.mDisplayRect;
            }
        }
        return null;
    }

    private float getValue(Matrix paramMatrix, int paramInt) {
        paramMatrix.getValues(this.mMatrixValues);
        return this.mMatrixValues[paramInt];
    }

    private static boolean hasDrawable(ImageView paramImageView) {
        return (paramImageView != null) && (paramImageView.getDrawable() != null);
    }

    private static boolean isSupportedScaleType(ImageView.ScaleType paramScaleType) {
        if (paramScaleType == null) {
            return false;
        }
        switch (paramScaleType) {
            default:
                return true;
        }
        throw new IllegalArgumentException(paramScaleType.name() + " is not supported in PhotoView");
    }

    private void resetMatrix() {
        this.mSuppMatrix.reset();
        setImageViewMatrix(getDisplayMatrix());
        checkMatrixBounds();
    }

    private void setImageViewMatrix(Matrix paramMatrix) {
        ImageView localImageView = getImageView();
        if (localImageView != null) {
            checkImageViewScaleType();
            localImageView.setImageMatrix(paramMatrix);
            if (this.mMatrixChangeListener != null) {
                paramMatrix = getDisplayRect(paramMatrix);
                if (paramMatrix != null) {
                    this.mMatrixChangeListener.onMatrixChanged(paramMatrix);
                }
            }
        }
    }

    private static void setImageViewScaleTypeMatrix(ImageView paramImageView) {
        if ((paramImageView != null) && (!(paramImageView instanceof PhotoView))) {
            paramImageView.setScaleType(ImageView.ScaleType.MATRIX);
        }
    }

    private void updateBaseMatrix(Drawable paramDrawable) {
        Object localObject = getImageView();
        if ((localObject == null) || (paramDrawable == null)) {
            return;
        }
        float f1 = ((ImageView) localObject).getWidth();
        float f2 = ((ImageView) localObject).getHeight();
        int i = paramDrawable.getIntrinsicWidth();
        int j = paramDrawable.getIntrinsicHeight();
        this.mBaseMatrix.reset();
        float f3 = f1 / i;
        float f4 = f2 / j;
        if (this.mScaleType == ImageView.ScaleType.CENTER) {
            this.mBaseMatrix.postTranslate((f1 - i) / 2.0F, (f2 - j) / 2.0F);
        }
        for (; ; ) {
            resetMatrix();
            return;
            if (this.mScaleType == ImageView.ScaleType.CENTER_CROP) {
                f3 = Math.max(f3, f4);
                this.mBaseMatrix.postScale(f3, f3);
                this.mBaseMatrix.postTranslate((f1 - i * f3) / 2.0F, (f2 - j * f3) / 2.0F);
            } else if (this.mScaleType == ImageView.ScaleType.CENTER_INSIDE) {
                f3 = Math.min(1.0F, Math.min(f3, f4));
                this.mBaseMatrix.postScale(f3, f3);
                this.mBaseMatrix.postTranslate((f1 - i * f3) / 2.0F, (f2 - j * f3) / 2.0F);
            } else {
                paramDrawable = new RectF(0.0F, 0.0F, i, j);
                localObject = new RectF(0.0F, 0.0F, f1, f2);
                switch (this.mScaleType) {
                    default:
                        break;
                    case FIT_CENTER:
                        this.mBaseMatrix.setRectToRect(paramDrawable, (RectF) localObject, Matrix.ScaleToFit.CENTER);
                        break;
                    case FIT_START:
                        this.mBaseMatrix.setRectToRect(paramDrawable, (RectF) localObject, Matrix.ScaleToFit.START);
                        break;
                    case FIT_END:
                        this.mBaseMatrix.setRectToRect(paramDrawable, (RectF) localObject, Matrix.ScaleToFit.END);
                        break;
                    case FIT_XY:
                        this.mBaseMatrix.setRectToRect(paramDrawable, (RectF) localObject, Matrix.ScaleToFit.FILL);
                }
            }
        }
    }

    public final boolean canZoom() {
        return this.mZoomEnabled;
    }

    public final void cleanup() {
        if (this.mImageView != null) {
            ((ImageView) this.mImageView.get()).getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
        this.mViewTreeObserver = null;
        this.mMatrixChangeListener = null;
        this.mPhotoTapListener = null;
        this.mViewTapListener = null;
        this.mImageView = null;
    }

    protected Matrix getDisplayMatrix() {
        this.mDrawMatrix.set(this.mBaseMatrix);
        this.mDrawMatrix.postConcat(this.mSuppMatrix);
        return this.mDrawMatrix;
    }

    public final RectF getDisplayRect() {
        checkMatrixBounds();
        return getDisplayRect(getDisplayMatrix());
    }

    public final ImageView getImageView() {
        ImageView localImageView = null;
        if (this.mImageView != null) {
            localImageView = (ImageView) this.mImageView.get();
        }
        if (localImageView == null) {
            cleanup();
            throw new IllegalStateException("ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
        }
        return localImageView;
    }

    public float getMaxScale() {
        return this.mMaxScale;
    }

    public float getMidScale() {
        return this.mMidScale;
    }

    public float getMinScale() {
        return this.mMinScale;
    }

    public final float getScale() {
        return getValue(this.mSuppMatrix, 0);
    }

    public final ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public final boolean onDoubleTap(MotionEvent paramMotionEvent) {
        try {
            float f1 = getScale();
            float f2 = paramMotionEvent.getX();
            float f3 = paramMotionEvent.getY();
            if (f1 < this.mMidScale) {
                zoomTo(this.mMidScale, f2, f3);
            } else if ((f1 >= this.mMidScale) && (f1 < this.mMaxScale)) {
                zoomTo(this.mMaxScale, f2, f3);
            } else {
                zoomTo(this.mMinScale, f2, f3);
            }
        } catch (ArrayIndexOutOfBoundsException paramMotionEvent) {
            for (; ; ) {
            }
        }
        return true;
    }

    public final boolean onDoubleTapEvent(MotionEvent paramMotionEvent) {
        return false;
    }

    public final void onDrag(float paramFloat1, float paramFloat2) {
        if (DEBUG) {
            Log.d("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", new Object[]{Float.valueOf(paramFloat1), Float.valueOf(paramFloat2)}));
        }
        ImageView localImageView = getImageView();
        if ((localImageView != null) && (hasDrawable(localImageView))) {
            this.mSuppMatrix.postTranslate(paramFloat1, paramFloat2);
            checkAndDisplayMatrix();
            if ((this.mAllowParentInterceptOnEdge) && (!this.mScaleDragDetector.isScaling()) && ((this.mScrollEdge == 2) || ((this.mScrollEdge == 0) && (paramFloat1 >= 1.0F)) || ((this.mScrollEdge == 1) && (paramFloat1 <= -1.0F)))) {
                localImageView.getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
    }

    public final void onFling(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
        if (DEBUG) {
            Log.d("PhotoViewAttacher", "onFling. sX: " + paramFloat1 + " sY: " + paramFloat2 + " Vx: " + paramFloat3 + " Vy: " + paramFloat4);
        }
        ImageView localImageView = getImageView();
        if (hasDrawable(localImageView)) {
            this.mCurrentFlingRunnable = new FlingRunnable(localImageView.getContext());
            this.mCurrentFlingRunnable.fling(localImageView.getWidth(), localImageView.getHeight(), (int) paramFloat3, (int) paramFloat4);
            localImageView.post(this.mCurrentFlingRunnable);
        }
    }

    public final void onGlobalLayout() {
        ImageView localImageView = getImageView();
        if ((localImageView != null) && (this.mZoomEnabled)) {
            int i = localImageView.getTop();
            int j = localImageView.getRight();
            int k = localImageView.getBottom();
            int m = localImageView.getLeft();
            if ((i != this.mIvTop) || (k != this.mIvBottom) || (m != this.mIvLeft) || (j != this.mIvRight)) {
                updateBaseMatrix(localImageView.getDrawable());
                this.mIvTop = i;
                this.mIvRight = j;
                this.mIvBottom = k;
                this.mIvLeft = m;
            }
        }
    }

    public final void onScale(float paramFloat1, float paramFloat2, float paramFloat3) {
        if (DEBUG) {
            Log.d("PhotoViewAttacher", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", new Object[]{Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3)}));
        }
        if ((hasDrawable(getImageView())) && ((getScale() < this.mMaxScale) || (paramFloat1 < 1.0F))) {
            this.mSuppMatrix.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
            checkAndDisplayMatrix();
        }
    }

    public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent) {
        ImageView localImageView = getImageView();
        if (localImageView != null) {
            if (this.mPhotoTapListener != null) {
                RectF localRectF = getDisplayRect();
                if (localRectF != null) {
                    float f2 = paramMotionEvent.getX();
                    float f1 = paramMotionEvent.getY();
                    if (localRectF.contains(f2, f1)) {
                        f2 = (f2 - localRectF.left) / localRectF.width();
                        f1 = (f1 - localRectF.top) / localRectF.height();
                        this.mPhotoTapListener.onPhotoTap(localImageView, f2, f1);
                        return true;
                    }
                }
            }
            if (this.mViewTapListener != null) {
                this.mViewTapListener.onViewTap(localImageView, paramMotionEvent.getX(), paramMotionEvent.getY());
            }
        }
        return false;
    }

    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
        boolean bool4 = false;
        boolean bool1 = false;
        boolean bool2 = false;
        boolean bool3 = bool4;
        for (; ; ) {
            try {
                if (!this.mZoomEnabled) {
                    break;
                }
                bool1 = bool2;
                bool3 = bool4;
                switch (paramMotionEvent.getAction()) {
                    case 2:
                        bool2 = bool1;
                        bool3 = bool1;
                        if (this.mGestureDetector != null) {
                            bool2 = bool1;
                            bool3 = bool1;
                            if (this.mGestureDetector.onTouchEvent(paramMotionEvent)) {
                                bool2 = true;
                            }
                        }
                        bool3 = bool2;
                        bool1 = bool2;
                        if (this.mScaleDragDetector == null) {
                            return bool1;
                        }
                        bool3 = bool2;
                        bool1 = bool2;
                        if (!this.mScaleDragDetector.onTouchEvent(paramMotionEvent)) {
                            return bool1;
                        }
                        return true;
                }
            } catch (Exception paramView) {
                paramView.printStackTrace();
                return bool3;
            }
            bool3 = bool4;
            paramView.getParent().requestDisallowInterceptTouchEvent(true);
            bool3 = bool4;
            cancelFling();
            bool1 = bool2;
            continue;
            bool1 = bool2;
            bool3 = bool4;
            if (getScale() < this.mMinScale) {
                bool3 = bool4;
                RectF localRectF = getDisplayRect();
                bool1 = bool2;
                if (localRectF != null) {
                    bool3 = bool4;
                    paramView.post(new AnimatedZoomRunnable(getScale(), this.mMinScale, localRectF.centerX(), localRectF.centerY()));
                    bool1 = true;
                    continue;
                    bool1 = bool2;
                }
            }
        }
        return bool1;
    }

    public void setAllowParentInterceptOnEdge(boolean paramBoolean) {
        this.mAllowParentInterceptOnEdge = paramBoolean;
    }

    public void setMaxScale(float paramFloat) {
        checkZoomLevels(this.mMinScale, this.mMidScale, paramFloat);
        this.mMaxScale = paramFloat;
    }

    public void setMidScale(float paramFloat) {
        checkZoomLevels(this.mMinScale, paramFloat, this.mMaxScale);
        this.mMidScale = paramFloat;
    }

    public void setMinScale(float paramFloat) {
        checkZoomLevels(paramFloat, this.mMidScale, this.mMaxScale);
        this.mMinScale = paramFloat;
    }

    public final void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener) {
        this.mLongClickListener = paramOnLongClickListener;
    }

    public final void setOnMatrixChangeListener(OnMatrixChangedListener paramOnMatrixChangedListener) {
        this.mMatrixChangeListener = paramOnMatrixChangedListener;
    }

    public final void setOnPhotoTapListener(OnPhotoTapListener paramOnPhotoTapListener) {
        this.mPhotoTapListener = paramOnPhotoTapListener;
    }

    public final void setOnViewTapListener(OnViewTapListener paramOnViewTapListener) {
        this.mViewTapListener = paramOnViewTapListener;
    }

    public final void setScaleType(ImageView.ScaleType paramScaleType) {
        if ((isSupportedScaleType(paramScaleType)) && (paramScaleType != this.mScaleType)) {
            this.mScaleType = paramScaleType;
            update();
        }
    }

    public final void setZoomable(boolean paramBoolean) {
        this.mZoomEnabled = paramBoolean;
        update();
    }

    public final void update() {
        ImageView localImageView = getImageView();
        if (localImageView != null) {
            if (this.mZoomEnabled) {
                setImageViewScaleTypeMatrix(localImageView);
                updateBaseMatrix(localImageView.getDrawable());
            }
        } else {
            return;
        }
        resetMatrix();
    }

    public final void zoomTo(float paramFloat1, float paramFloat2, float paramFloat3) {
        ImageView localImageView = getImageView();
        if (localImageView != null) {
            localImageView.post(new AnimatedZoomRunnable(getScale(), paramFloat1, paramFloat2, paramFloat3));
        }
    }

    private class AnimatedZoomRunnable
            implements Runnable {
        static final float ANIMATION_SCALE_PER_ITERATION_IN = 1.07F;
        static final float ANIMATION_SCALE_PER_ITERATION_OUT = 0.93F;
        private final float mDeltaScale;
        private final float mFocalX;
        private final float mFocalY;
        private final float mTargetZoom;

        public AnimatedZoomRunnable(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
            this.mTargetZoom = paramFloat2;
            this.mFocalX = paramFloat3;
            this.mFocalY = paramFloat4;
            if (paramFloat1 < paramFloat2) {
                this.mDeltaScale = 1.07F;
                return;
            }
            this.mDeltaScale = 0.93F;
        }

        public void run() {
            ImageView localImageView = PhotoViewAttacher.this.getImageView();
            if (localImageView != null) {
                PhotoViewAttacher.this.mSuppMatrix.postScale(this.mDeltaScale, this.mDeltaScale, this.mFocalX, this.mFocalY);
                PhotoViewAttacher.this.checkAndDisplayMatrix();
                f = PhotoViewAttacher.this.getScale();
                if (((this.mDeltaScale > 1.0F) && (f < this.mTargetZoom)) || ((this.mDeltaScale < 1.0F) && (this.mTargetZoom < f))) {
                    Compat.postOnAnimation(localImageView, this);
                }
            } else {
                return;
            }
            float f = this.mTargetZoom / f;
            PhotoViewAttacher.this.mSuppMatrix.postScale(f, f, this.mFocalX, this.mFocalY);
            PhotoViewAttacher.this.checkAndDisplayMatrix();
        }
    }

    private class FlingRunnable
            implements Runnable {
        private int mCurrentX;
        private int mCurrentY;
        private final ScrollerProxy mScroller;

        public FlingRunnable(Context paramContext) {
            this.mScroller = ScrollerProxy.getScroller(paramContext);
        }

        public void cancelFling() {
            if (PhotoViewAttacher.DEBUG) {
                Log.d("PhotoViewAttacher", "Cancel Fling");
            }
            this.mScroller.forceFinished(true);
        }

        public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
            RectF localRectF = PhotoViewAttacher.this.getDisplayRect();
            if (localRectF == null) {
                return;
            }
            int i = Math.round(-localRectF.left);
            int k;
            int j;
            label56:
            int n;
            int m;
            if (paramInt1 < localRectF.width()) {
                k = 0;
                j = Math.round(localRectF.width() - paramInt1);
                paramInt1 = k;
                k = Math.round(-localRectF.top);
                if (paramInt2 >= localRectF.height()) {
                    break label215;
                }
                n = 0;
                m = Math.round(localRectF.height() - paramInt2);
            }
            for (paramInt2 = n; ; paramInt2 = k) {
                this.mCurrentX = i;
                this.mCurrentY = k;
                if (PhotoViewAttacher.DEBUG) {
                    Log.d("PhotoViewAttacher", "fling. StartX:" + i + " StartY:" + k + " MaxX:" + j + " MaxY:" + m);
                }
                if ((i == j) && (k == m)) {
                    break;
                }
                this.mScroller.fling(i, k, paramInt3, paramInt4, paramInt1, j, paramInt2, m, 0, 0);
                return;
                j = i;
                paramInt1 = i;
                break label56;
                label215:
                m = k;
            }
        }

        public void run() {
            ImageView localImageView = PhotoViewAttacher.this.getImageView();
            if ((localImageView != null) && (this.mScroller.computeScrollOffset())) {
                int i = this.mScroller.getCurrX();
                int j = this.mScroller.getCurrY();
                if (PhotoViewAttacher.DEBUG) {
                    Log.d("PhotoViewAttacher", "fling run(). CurrentX:" + this.mCurrentX + " CurrentY:" + this.mCurrentY + " NewX:" + i + " NewY:" + j);
                }
                PhotoViewAttacher.this.mSuppMatrix.postTranslate(this.mCurrentX - i, this.mCurrentY - j);
                PhotoViewAttacher.this.setImageViewMatrix(PhotoViewAttacher.this.getDisplayMatrix());
                this.mCurrentX = i;
                this.mCurrentY = j;
                Compat.postOnAnimation(localImageView, this);
            }
        }
    }

    public static abstract interface OnMatrixChangedListener {
        public abstract void onMatrixChanged(RectF paramRectF);
    }

    public static abstract interface OnPhotoTapListener {
        public abstract void onPhotoTap(View paramView, float paramFloat1, float paramFloat2);
    }

    public static abstract interface OnViewTapListener {
        public abstract void onViewTap(View paramView, float paramFloat1, float paramFloat2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tools/gallery/PhotoViewAttacher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */