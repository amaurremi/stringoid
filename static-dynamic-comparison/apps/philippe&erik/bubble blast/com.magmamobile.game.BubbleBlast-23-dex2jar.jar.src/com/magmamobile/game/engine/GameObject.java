package com.magmamobile.game.engine;

import android.graphics.Bitmap;
import android.graphics.Rect;

public abstract class GameObject
  implements IGameEvents, Comparable<GameObject>
{
  public static final int CENTER_CONTENT = -9999;
  public static final int FILL_PARENT = -1;
  public static final int WRAP_CONTENT = -2;
  private Animation _animation;
  public float angle;
  public int ch;
  public int cw;
  public boolean enabled;
  public boolean focusClick;
  public int h;
  public boolean hasMoved;
  public int index;
  public boolean isResized;
  public boolean selected;
  private Object tag;
  public boolean visible;
  public float vx;
  public float vy;
  public int w;
  public float x;
  public float y;
  public float z;
  
  protected void applyAnimation()
  {
    if ((this._animation != null) && (!this._animation.hasFinish())) {
      this._animation.apply();
    }
  }
  
  public int compareTo(GameObject paramGameObject)
  {
    return 0;
  }
  
  public float distanceTo(float paramFloat1, float paramFloat2)
  {
    paramFloat1 -= this.x;
    paramFloat2 -= this.y;
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  public float distanceTo(GameObject paramGameObject)
  {
    float f1 = paramGameObject.x - this.x;
    float f2 = paramGameObject.y - this.y;
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  public Animation getAnimation()
  {
    return this._animation;
  }
  
  public Bitmap getBitmap(int paramInt)
  {
    return Game.getBitmap(paramInt);
  }
  
  public int getH()
  {
    return this.h;
  }
  
  public int getHeight()
  {
    return this.h;
  }
  
  public Rect getRect()
  {
    return new Rect((int)this.x, (int)this.y, (int)(this.x + this.w), (int)(this.y + this.h));
  }
  
  public Object getTag()
  {
    return this.tag;
  }
  
  public int getW()
  {
    return this.w;
  }
  
  public int getWidth()
  {
    return this.w;
  }
  
  public float getX()
  {
    return this.x;
  }
  
  public float getY()
  {
    return this.y;
  }
  
  public boolean hasAnimation()
  {
    return this._animation != null;
  }
  
  public void hide()
  {
    this.enabled = false;
    this.visible = false;
  }
  
  public boolean hit()
  {
    if (!TouchScreen.eventDown) {
      return false;
    }
    return intersectPoint(TouchScreen.x, TouchScreen.y);
  }
  
  public boolean intersectLine(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return MathUtils.SegmentInRect((int)this.x, (int)this.y, (int)this.x + this.w, (int)this.y + this.h, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean intersectMidPoint(int paramInt1, int paramInt2)
  {
    return MathUtils.PtInRect((int)this.x - this.cw, (int)this.y - this.ch, (int)this.x + this.cw, (int)this.y + this.ch, paramInt1, paramInt2);
  }
  
  public boolean intersectPoint(int paramInt1, int paramInt2)
  {
    return MathUtils.PtInRect((int)this.x, (int)this.y, (int)this.x + this.w, (int)this.y + this.h, paramInt1, paramInt2);
  }
  
  public boolean intersectRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return MathUtils.RectIntersect((int)this.x, (int)this.y, (int)this.x + this.w, (int)this.y + this.h, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean isEnabled()
  {
    return this.enabled;
  }
  
  public boolean isTouch()
  {
    return TouchScreen.isInRect((int)getX(), (int)getY(), getWidth(), getHeight());
  }
  
  public boolean isVisible()
  {
    return this.visible;
  }
  
  public void moveBy(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 == 0.0F) && (paramFloat2 == 0.0F)) {
      return;
    }
    this.hasMoved = true;
    this.x += paramFloat1;
    this.y += paramFloat2;
  }
  
  public void moveTo(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 == this.x) && (paramFloat2 == this.y)) {
      return;
    }
    this.hasMoved = true;
    this.x = paramFloat1;
    this.y = paramFloat2;
  }
  
  public void onPause() {}
  
  public void onReset() {}
  
  public void onResume() {}
  
  public void setAnimation(Animation paramAnimation)
  {
    this._animation = paramAnimation;
    this._animation.setParent(this);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    this.enabled = paramBoolean;
  }
  
  public void setH(int paramInt)
  {
    if (paramInt == this.h) {
      return;
    }
    this.isResized = true;
    this.h = paramInt;
    this.ch = (this.h >> 1);
  }
  
  public void setHeight(int paramInt)
  {
    if (this.h != paramInt)
    {
      this.h = paramInt;
      this.ch = (this.h / 2);
    }
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    this.w = paramInt1;
    this.h = paramInt2;
    this.cw = (this.w >> 1);
    this.ch = (this.h >> 1);
  }
  
  public void setTag(Object paramObject)
  {
    this.tag = paramObject;
  }
  
  public void setVisible(boolean paramBoolean)
  {
    this.visible = paramBoolean;
  }
  
  public void setW(int paramInt)
  {
    if (paramInt == this.w) {
      return;
    }
    this.isResized = true;
    this.w = paramInt;
    this.cw = (this.w >> 1);
  }
  
  public void setWidth(int paramInt)
  {
    if (this.w != paramInt)
    {
      this.w = paramInt;
      this.cw = (this.w / 2);
    }
  }
  
  public void setX(float paramFloat)
  {
    if (paramFloat == this.x) {
      return;
    }
    this.hasMoved = true;
    this.x = paramFloat;
  }
  
  public void setY(float paramFloat)
  {
    if (paramFloat == this.y) {
      return;
    }
    this.hasMoved = true;
    this.y = paramFloat;
  }
  
  public void show()
  {
    this.enabled = true;
    this.visible = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/GameObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */