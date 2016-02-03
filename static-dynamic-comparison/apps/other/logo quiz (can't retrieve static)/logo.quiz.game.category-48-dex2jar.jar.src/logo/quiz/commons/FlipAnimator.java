package logo.quiz.commons;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class FlipAnimator
  extends Animation
{
  private Camera mCamera;
  private float mCenterX;
  private float mCenterY;
  private final float mFromDegrees;
  private final float mToDegrees;
  
  public FlipAnimator(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.mFromDegrees = paramFloat1;
    this.mToDegrees = paramFloat2;
    this.mCenterX = paramFloat3;
    this.mCenterY = paramFloat4;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = this.mFromDegrees;
    float f2 = this.mToDegrees;
    float f3 = this.mCenterX;
    float f4 = this.mCenterY;
    Camera localCamera = this.mCamera;
    paramTransformation = paramTransformation.getMatrix();
    localCamera.save();
    localCamera.rotateY(f1 + (f2 - f1) * paramFloat);
    localCamera.getMatrix(paramTransformation);
    localCamera.restore();
    paramTransformation.preTranslate(-f3, -f4);
    paramTransformation.postTranslate(f3, f4);
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mCamera = new Camera();
  }
  
  public void setmCenterX(float paramFloat)
  {
    this.mCenterX = paramFloat;
  }
  
  public void setmCenterY(float paramFloat)
  {
    this.mCenterY = paramFloat;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/FlipAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */