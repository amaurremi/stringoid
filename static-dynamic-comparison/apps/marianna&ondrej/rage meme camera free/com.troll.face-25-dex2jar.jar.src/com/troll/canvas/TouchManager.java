package com.troll.canvas;

import android.view.MotionEvent;

public class TouchManager
{
  private final int maxNumberOfTouchPoints;
  private final Vector2D[] points;
  private final Vector2D[] previousPoints;
  
  public TouchManager(int paramInt)
  {
    this.maxNumberOfTouchPoints = paramInt;
    this.points = new Vector2D[paramInt];
    this.previousPoints = new Vector2D[paramInt];
  }
  
  private static Vector2D getVector(Vector2D paramVector2D1, Vector2D paramVector2D2)
  {
    if ((paramVector2D1 == null) || (paramVector2D2 == null)) {
      throw new RuntimeException("can't do this on nulls");
    }
    return Vector2D.subtract(paramVector2D2, paramVector2D1);
  }
  
  public Vector2D getPoint(int paramInt)
  {
    if (this.points[paramInt] != null) {
      return this.points[paramInt];
    }
    return new Vector2D();
  }
  
  public int getPressCount()
  {
    int j = 0;
    Vector2D[] arrayOfVector2D = this.points;
    int m = arrayOfVector2D.length;
    int i = 0;
    for (;;)
    {
      if (i >= m) {
        return j;
      }
      int k = j;
      if (arrayOfVector2D[i] != null) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
  }
  
  public Vector2D getPreviousPoint(int paramInt)
  {
    if (this.previousPoints[paramInt] != null) {
      return this.previousPoints[paramInt];
    }
    return new Vector2D();
  }
  
  public Vector2D getPreviousVector(int paramInt1, int paramInt2)
  {
    if ((this.previousPoints[paramInt1] == null) || (this.previousPoints[paramInt2] == null)) {
      return getVector(this.points[paramInt1], this.points[paramInt2]);
    }
    return getVector(this.previousPoints[paramInt1], this.previousPoints[paramInt2]);
  }
  
  public Vector2D getVector(int paramInt1, int paramInt2)
  {
    return getVector(this.points[paramInt1], this.points[paramInt2]);
  }
  
  public boolean isPressed(int paramInt)
  {
    return this.points[paramInt] != null;
  }
  
  public Vector2D moveDelta(int paramInt)
  {
    if (isPressed(paramInt))
    {
      if (this.previousPoints[paramInt] != null) {}
      for (Vector2D localVector2D = this.previousPoints[paramInt];; localVector2D = this.points[paramInt]) {
        return Vector2D.subtract(this.points[paramInt], localVector2D);
      }
    }
    return new Vector2D();
  }
  
  public void update(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if ((i == 6) || (i == 1))
    {
      i = paramMotionEvent.getAction() >> 8;
      paramMotionEvent = this.previousPoints;
      this.points[i] = null;
      paramMotionEvent[i] = null;
      return;
    }
    i = 0;
    label47:
    int j;
    Object localObject;
    if (i < this.maxNumberOfTouchPoints)
    {
      if (i >= paramMotionEvent.getPointerCount()) {
        break label190;
      }
      j = paramMotionEvent.getPointerId(i);
      localObject = new Vector2D(paramMotionEvent.getX(i), paramMotionEvent.getY(i));
      if (this.points[j] != null) {
        break label112;
      }
      this.points[j] = localObject;
    }
    for (;;)
    {
      i += 1;
      break label47;
      break;
      label112:
      if (this.previousPoints[j] != null) {
        this.previousPoints[j].set(this.points[j]);
      }
      for (;;)
      {
        if (Vector2D.subtract(this.points[j], (Vector2D)localObject).getLength() >= 64.0F) {
          break label188;
        }
        this.points[j].set((Vector2D)localObject);
        break;
        this.previousPoints[j] = new Vector2D((Vector2D)localObject);
      }
      label188:
      continue;
      label190:
      localObject = this.previousPoints;
      this.points[i] = null;
      localObject[i] = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/troll/canvas/TouchManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */