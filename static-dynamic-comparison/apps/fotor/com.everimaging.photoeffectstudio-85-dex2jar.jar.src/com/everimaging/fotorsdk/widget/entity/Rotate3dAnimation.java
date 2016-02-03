package com.everimaging.fotorsdk.widget.entity;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class Rotate3dAnimation
        extends Animation {
    private Camera mCamera;
    private final float mCenterX;
    private final float mCenterY;
    private final float mDepthZ;
    private final float mFromDegrees;
    private final boolean mReverse;
    private final float mToDegrees;
    private final boolean mVertical;

    public Rotate3dAnimation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, boolean paramBoolean1, boolean paramBoolean2) {
        this.mFromDegrees = paramFloat1;
        this.mToDegrees = paramFloat2;
        this.mCenterX = paramFloat3;
        this.mCenterY = paramFloat4;
        this.mDepthZ = paramFloat5;
        this.mReverse = paramBoolean1;
        this.mVertical = paramBoolean2;
    }

    protected void applyTransformation(float paramFloat, Transformation paramTransformation) {
        float f1 = this.mFromDegrees;
        f1 += (this.mToDegrees - f1) * paramFloat;
        float f2 = this.mCenterX;
        float f3 = this.mCenterY;
        Camera localCamera = this.mCamera;
        paramTransformation = paramTransformation.getMatrix();
        localCamera.save();
        if (this.mReverse) {
            localCamera.translate(0.0F, 0.0F, this.mDepthZ * paramFloat);
            if (this.mVertical) {
                break label127;
            }
            localCamera.rotateY(f1);
        }
        for (; ; ) {
            localCamera.getMatrix(paramTransformation);
            localCamera.restore();
            paramTransformation.preTranslate(-f2, -f3);
            paramTransformation.postTranslate(f2, f3);
            return;
            localCamera.translate(0.0F, 0.0F, this.mDepthZ * (1.0F - paramFloat));
            break;
            label127:
            localCamera.rotateX(f1);
        }
    }

    public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
        this.mCamera = new Camera();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/entity/Rotate3dAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */