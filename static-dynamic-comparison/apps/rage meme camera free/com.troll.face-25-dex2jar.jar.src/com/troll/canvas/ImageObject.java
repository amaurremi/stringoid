package com.troll.canvas;

import android.graphics.Bitmap;

public class ImageObject
{
  private float angle = 0.0F;
  private Bitmap bitmap;
  private float db = 0.0F;
  private float dg = 0.0F;
  private float dr = 0.0F;
  private Integer drawableImageId;
  private int flipFlag = 3;
  private int flipVerticalFlag = 3;
  private int height;
  private float scale = 1.0F;
  private int width;
  private int x = 0;
  private int y = 0;
  
  public float getAngle()
  {
    return this.angle;
  }
  
  public Bitmap getBitmap()
  {
    return this.bitmap;
  }
  
  public float getDb()
  {
    return this.db;
  }
  
  public float getDg()
  {
    return this.dg;
  }
  
  public float getDr()
  {
    return this.dr;
  }
  
  public Integer getDrawableImageId()
  {
    return this.drawableImageId;
  }
  
  public int getFlipFlag()
  {
    return this.flipFlag;
  }
  
  public int getFlipVerticalFlag()
  {
    return this.flipVerticalFlag;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public float getScale()
  {
    return this.scale;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public int getX()
  {
    return this.x;
  }
  
  public int getY()
  {
    return this.y;
  }
  
  public void setAngle(float paramFloat)
  {
    this.angle = paramFloat;
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this.bitmap = paramBitmap;
  }
  
  public void setDb(float paramFloat)
  {
    this.db = paramFloat;
  }
  
  public void setDg(float paramFloat)
  {
    this.dg = paramFloat;
  }
  
  public void setDr(float paramFloat)
  {
    this.dr = paramFloat;
  }
  
  public void setDrawableImageId(Integer paramInteger)
  {
    this.drawableImageId = paramInteger;
  }
  
  public void setFlipFlag(int paramInt)
  {
    this.flipFlag = paramInt;
  }
  
  public void setFlipVerticalFlag(int paramInt)
  {
    this.flipVerticalFlag = paramInt;
  }
  
  public void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public void setScale(float paramFloat)
  {
    this.scale = paramFloat;
  }
  
  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
  
  public void setX(int paramInt)
  {
    this.x = paramInt;
  }
  
  public void setY(int paramInt)
  {
    this.y = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/troll/canvas/ImageObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */