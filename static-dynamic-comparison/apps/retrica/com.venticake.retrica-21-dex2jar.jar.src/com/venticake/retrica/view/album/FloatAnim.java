package com.venticake.retrica.view.album;

import android.util.FloatMath;

public final class FloatAnim
{
  private float mDelta;
  private float mDuration;
  private long mStartTime;
  private float mValue;
  
  public FloatAnim(float paramFloat)
  {
    this.mValue = paramFloat;
    this.mStartTime = 0L;
  }
  
  private float getInterpolatedValue(long paramLong)
  {
    float f1 = (float)(paramLong - this.mStartTime) * 0.001F / this.mDuration;
    if (f1 >= 1.0F)
    {
      this.mStartTime = 0L;
      return this.mValue;
    }
    f1 = FloatMath.cos(f1 * 3.1415927F);
    float f2 = this.mValue;
    return (1.0F - (0.5F - f1 * 0.5F)) * this.mDelta + f2;
  }
  
  public void animateValue(float paramFloat1, float paramFloat2, long paramLong)
  {
    this.mDelta = (getValue(paramLong) - paramFloat1);
    this.mValue = paramFloat1;
    this.mDuration = paramFloat2;
    this.mStartTime = paramLong;
  }
  
  public float getTimeRemaining(long paramLong)
  {
    float f = (float)(paramLong - this.mStartTime) * 0.001F;
    if (this.mDuration > f) {
      return this.mDuration - f;
    }
    return 0.0F;
  }
  
  public float getValue(long paramLong)
  {
    if (this.mStartTime == 0L) {
      return this.mValue;
    }
    return getInterpolatedValue(paramLong);
  }
  
  public boolean isAnimating()
  {
    return this.mStartTime != 0L;
  }
  
  public void setValue(float paramFloat)
  {
    this.mValue = paramFloat;
    this.mStartTime = 0L;
  }
  
  public void skip()
  {
    this.mStartTime = 0L;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/FloatAnim.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */