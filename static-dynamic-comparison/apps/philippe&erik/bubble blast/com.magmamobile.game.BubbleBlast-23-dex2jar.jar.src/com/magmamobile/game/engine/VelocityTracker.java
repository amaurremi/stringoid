package com.magmamobile.game.engine;

import android.os.SystemClock;

public final class VelocityTracker
{
  private static final int LONGEST_PAST_TIME = 200;
  private static final int NUM_PAST = 10;
  private static final VelocityTracker[] mPool = new VelocityTracker[1];
  private final long[] mPastTime = new long[10];
  private final float[] mPastX = new float[10];
  private final float[] mPastY = new float[10];
  private float mXVelocity;
  private float mYVelocity;
  
  private void addPoint(float paramFloat1, float paramFloat2, long paramLong)
  {
    int j = -1;
    long[] arrayOfLong = this.mPastTime;
    int i = 0;
    for (;;)
    {
      if (i >= 10) {}
      while (arrayOfLong[i] == 0L)
      {
        int k = j;
        if (i == 10)
        {
          k = j;
          if (j < 0) {
            k = 0;
          }
        }
        j = k;
        if (k == i) {
          j = k - 1;
        }
        float[] arrayOfFloat1 = this.mPastX;
        float[] arrayOfFloat2 = this.mPastY;
        k = i;
        if (j >= 0)
        {
          k = j + 1;
          int m = 10 - j - 1;
          System.arraycopy(arrayOfFloat1, k, arrayOfFloat1, 0, m);
          System.arraycopy(arrayOfFloat2, k, arrayOfFloat2, 0, m);
          System.arraycopy(arrayOfLong, k, arrayOfLong, 0, m);
          k = i - (j + 1);
        }
        arrayOfFloat1[k] = paramFloat1;
        arrayOfFloat2[k] = paramFloat2;
        arrayOfLong[k] = paramLong;
        i = k + 1;
        if (i < 10) {
          arrayOfLong[i] = 0L;
        }
        return;
      }
      if (arrayOfLong[i] < paramLong - 200L) {
        j = i;
      }
      i += 1;
    }
  }
  
  public static VelocityTracker obtain()
  {
    synchronized (mPool)
    {
      VelocityTracker localVelocityTracker = mPool[0];
      if (localVelocityTracker != null)
      {
        localVelocityTracker.clear();
        return localVelocityTracker;
      }
      localVelocityTracker = new VelocityTracker();
      return localVelocityTracker;
    }
  }
  
  public void addMovement(int paramInt1, int paramInt2)
  {
    addPoint(paramInt1, paramInt2, SystemClock.elapsedRealtime());
  }
  
  public void clear()
  {
    this.mPastTime[0] = 0L;
  }
  
  public void computeCurrentVelocity(int paramInt)
  {
    float[] arrayOfFloat1 = this.mPastX;
    float[] arrayOfFloat2 = this.mPastY;
    long[] arrayOfLong = this.mPastTime;
    float f4 = arrayOfFloat1[0];
    float f5 = arrayOfFloat2[0];
    long l = arrayOfLong[0];
    float f3 = 0.0F;
    float f2 = 0.0F;
    int i = 0;
    for (;;)
    {
      if (i >= 10) {}
      while (arrayOfLong[i] == 0L)
      {
        int j = i;
        if (i > 3) {
          j = i - 1;
        }
        i = 1;
        if (i < j) {
          break;
        }
        this.mXVelocity = f3;
        this.mYVelocity = f2;
        return;
      }
      i += 1;
    }
    int k = (int)(arrayOfLong[i] - l);
    float f1;
    if (k == 0) {
      f1 = f2;
    }
    for (;;)
    {
      i += 1;
      f2 = f1;
      break;
      f1 = (arrayOfFloat1[i] - f4) / k * paramInt;
      if (f3 == 0.0F) {}
      for (;;)
      {
        f3 = (arrayOfFloat2[i] - f5) / k * paramInt;
        if (f2 != 0.0F) {
          break label205;
        }
        f2 = f3;
        f3 = f1;
        f1 = f2;
        break;
        f1 = (f3 + f1) * 0.5F;
      }
      label205:
      f2 = (f2 + f3) * 0.5F;
      f3 = f1;
      f1 = f2;
    }
  }
  
  public float getXVelocity()
  {
    return this.mXVelocity;
  }
  
  public float getYVelocity()
  {
    return this.mYVelocity;
  }
  
  public void recycle()
  {
    synchronized (mPool)
    {
      mPool[0] = this;
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/VelocityTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */