package com.magmamobile.game.engine;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;

public class Sprite
  extends GameObject
{
  private int _alpha = 255;
  private int _angle = 0;
  private boolean _antialias = false;
  private Bitmap _bitmap = null;
  private boolean _dirty = false;
  private Paint _paint = new Paint();
  private float _zoom = 1.0F;
  
  public Sprite() {}
  
  public Sprite(int paramInt)
  {
    this();
    this._bitmap = Game.getBitmap(paramInt);
    show();
  }
  
  private Paint getInnerPaint()
  {
    if ((this._antialias) || (this._alpha != 255)) {
      return this._paint;
    }
    return null;
  }
  
  private void update()
  {
    this._paint.setAlpha(this._alpha);
    this.w = this._bitmap.getWidth();
    this.h = this._bitmap.getHeight();
    this.w = ((int)(this.w * this._zoom));
    this.h = ((int)(this.h * this._zoom));
    this.cw = (this.w >> 1);
    this.ch = (this.h >> 1);
    this._dirty = false;
  }
  
  public int getAlpha()
  {
    return this._alpha;
  }
  
  public int getAngle()
  {
    return this._angle;
  }
  
  public boolean getAntiAlias()
  {
    return this._antialias;
  }
  
  public Bitmap getBitmap()
  {
    return this._bitmap;
  }
  
  public Paint getPaint()
  {
    return this._paint;
  }
  
  public Rect getRect()
  {
    return new Rect((int)(this.x - this.cw), (int)(this.y - this.ch), (int)(this.x + this.cw), (int)(this.y + this.ch));
  }
  
  public float getX()
  {
    return this.x;
  }
  
  public float getY()
  {
    return this.y;
  }
  
  public float getZoom()
  {
    return this._zoom;
  }
  
  public boolean hit(int paramInt1, int paramInt2)
  {
    if ((!this.visible) || (!this.enabled)) {
      return false;
    }
    return MathUtils.PtInRect((int)this.x - this.cw, (int)this.y - this.ch, (int)this.x + this.cw, (int)this.y + this.ch, paramInt1, paramInt2);
  }
  
  public void invalidate()
  {
    this._dirty = true;
  }
  
  public void moveBackward(float paramFloat)
  {
    float f = this._angle * 0.017453292F;
    this.x = ((float)(this.x - Math.cos(f) * paramFloat));
    this.y = ((float)(this.y - Math.sin(f) * paramFloat));
  }
  
  public void moveForward(float paramFloat)
  {
    float f = this._angle * 0.017453292F;
    this.x = ((float)(this.x + Math.cos(f) * paramFloat));
    this.y = ((float)(this.y + Math.sin(f) * paramFloat));
  }
  
  public void onAction()
  {
    if (this._dirty) {
      update();
    }
    if (!this.enabled) {}
  }
  
  public void onRender()
  {
    if ((!this.visible) || (!this.enabled)) {
      return;
    }
    if (this._dirty) {
      update();
    }
    if ((this._angle != 0) || (this._zoom != 1.0F))
    {
      Game.drawBitmap(this._bitmap, (int)this.x, (int)this.y, this._angle, this._zoom, getInnerPaint());
      return;
    }
    Game.drawBitmap(this._bitmap, (int)this.x - this.cw, (int)this.y - this.ch, getInnerPaint());
  }
  
  public void setAlpha(int paramInt)
  {
    this._alpha = paramInt;
    this._dirty = true;
  }
  
  public void setAngle(int paramInt)
  {
    this._angle = paramInt;
    this._dirty = true;
  }
  
  public void setAntiAlias(boolean paramBoolean)
  {
    if (paramBoolean != this._antialias)
    {
      this._antialias = paramBoolean;
      this._paint.setAntiAlias(this._antialias);
      this._paint.setFilterBitmap(this._antialias);
    }
  }
  
  public void setBitmap(int paramInt)
  {
    setBitmap(Game.getBitmap(paramInt));
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this._bitmap = paramBitmap;
    this._dirty = true;
  }
  
  public void setX(float paramFloat)
  {
    this.x = paramFloat;
  }
  
  public void setY(float paramFloat)
  {
    this.y = paramFloat;
  }
  
  public void setZoom(float paramFloat)
  {
    this._zoom = paramFloat;
    this._dirty = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/Sprite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */