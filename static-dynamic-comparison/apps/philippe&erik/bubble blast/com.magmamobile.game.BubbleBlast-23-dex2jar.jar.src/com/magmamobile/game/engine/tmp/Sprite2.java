package com.magmamobile.game.engine.tmp;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.magmamobile.game.engine.Game;

public class Sprite2
{
  private int _angle;
  private boolean _autoSize = true;
  private Bitmap _bitmap;
  private boolean _enabled;
  private float _factorHeight;
  private float _factorWidth;
  private int _height;
  private int _innerHeight;
  private int _innerWidth;
  private float _left;
  private Matrix _matrix = new Matrix();
  private int _midHeight;
  private int _midWidth;
  private Paint _paint = new Paint();
  private float _top;
  private boolean _visible;
  private int _width;
  
  public Sprite2()
  {
    setVisible(true);
    setEnabled(true);
    setAntialias(true);
  }
  
  public Sprite2(int paramInt)
  {
    this(Game.getBitmap(paramInt));
  }
  
  public Sprite2(Bitmap paramBitmap)
  {
    this();
    setBitmap(paramBitmap);
  }
  
  protected void doAction() {}
  
  protected void doRender()
  {
    this._matrix.reset();
    if (this._angle != 0) {
      this._matrix.postRotate(this._angle);
    }
    if ((this._innerWidth != this._width) || (this._innerHeight != this._height)) {
      this._matrix.postScale(this._factorWidth, this._factorHeight);
    }
    this._matrix.preTranslate(-this._midWidth, -this._midHeight);
    this._matrix.postTranslate(this._left, this._top);
    Game.drawBitmap(this._bitmap, this._matrix, this._paint);
  }
  
  public int getAlpha()
  {
    return this._paint.getAlpha();
  }
  
  public int getAngle()
  {
    return this._angle;
  }
  
  public Bitmap getBitmap()
  {
    return this._bitmap;
  }
  
  public float getFactorHeight()
  {
    return this._factorHeight;
  }
  
  public float getFactorWidth()
  {
    return this._factorWidth;
  }
  
  public int getHeight()
  {
    return this._height;
  }
  
  public int getInnerHeight()
  {
    return this._innerHeight;
  }
  
  public int getInnerWidth()
  {
    return this._innerWidth;
  }
  
  public float getLeft()
  {
    return this._left;
  }
  
  public float getMidHeight()
  {
    return this._midHeight;
  }
  
  public float getMidWidth()
  {
    return this._midWidth;
  }
  
  public Paint getPaint()
  {
    return this._paint;
  }
  
  public float getTop()
  {
    return this._top;
  }
  
  public int getWidth()
  {
    return this._width;
  }
  
  public boolean isAntialias()
  {
    return this._paint.isAntiAlias();
  }
  
  public boolean isEnabled()
  {
    return this._enabled;
  }
  
  public boolean isVisible()
  {
    return this._visible;
  }
  
  public void onAction()
  {
    if (!this._enabled) {
      return;
    }
    doAction();
  }
  
  public void onRender()
  {
    if (!this._visible) {
      return;
    }
    doRender();
  }
  
  public boolean ptInBox(int paramInt1, int paramInt2)
  {
    return (paramInt1 >= this._left - this._midWidth) && (paramInt1 <= this._left + this._midWidth) && (paramInt2 >= this._top - this._midHeight) && (paramInt2 <= this._top + this._midHeight);
  }
  
  public void scale(float paramFloat)
  {
    setWidth((int)(this._innerWidth * paramFloat));
    setHeight((int)(this._innerHeight * paramFloat));
  }
  
  public void setAlpha(int paramInt)
  {
    this._paint.setAlpha(paramInt);
  }
  
  public void setAngle(int paramInt)
  {
    this._angle = paramInt;
  }
  
  public void setAntialias(boolean paramBoolean)
  {
    this._paint.setAntiAlias(paramBoolean);
    this._paint.setFilterBitmap(paramBoolean);
  }
  
  public void setBitmap(int paramInt)
  {
    setBitmap(Game.getBitmap(paramInt));
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this._bitmap = paramBitmap;
    if (this._bitmap != null) {
      this._innerWidth = this._bitmap.getWidth();
    }
    for (this._innerHeight = this._bitmap.getHeight();; this._innerHeight = 0)
    {
      this._midWidth = (this._innerWidth >> 1);
      this._midHeight = (this._innerHeight >> 1);
      if (this._autoSize)
      {
        this._width = this._innerWidth;
        this._height = this._innerHeight;
      }
      if (this._innerWidth != 0) {
        this._factorWidth = (this._width / this._innerWidth);
      }
      if (this._innerWidth != 0) {
        this._factorHeight = (this._height / this._innerHeight);
      }
      return;
      this._innerWidth = 0;
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    this._enabled = paramBoolean;
  }
  
  public void setHeight(int paramInt)
  {
    this._height = paramInt;
    this._autoSize = false;
    if (this._innerHeight != 0)
    {
      this._factorHeight = (this._height / this._innerHeight);
      return;
    }
    this._factorHeight = 0.0F;
  }
  
  public void setLeft(float paramFloat)
  {
    this._left = paramFloat;
  }
  
  public void setTop(float paramFloat)
  {
    this._top = paramFloat;
  }
  
  public void setVisible(boolean paramBoolean)
  {
    this._visible = paramBoolean;
  }
  
  public void setWidth(int paramInt)
  {
    this._width = paramInt;
    this._autoSize = false;
    if (this._innerWidth != 0)
    {
      this._factorWidth = (this._width / this._innerWidth);
      return;
    }
    this._factorWidth = 0.0F;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/tmp/Sprite2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */