package com.venticake.retrica.view.album;

import android.view.MotionEvent;
import javax.microedition.khronos.opengles.GL11;

public abstract class Layer
{
  float mHeight = 0.0F;
  boolean mHidden = false;
  float mWidth = 0.0F;
  float mX = 0.0F;
  float mY = 0.0F;
  
  public boolean containsPoint(float paramFloat1, float paramFloat2)
  {
    return true;
  }
  
  public abstract void generate(RenderView paramRenderView, RenderView.Lists paramLists);
  
  public final float getHeight()
  {
    return this.mHeight;
  }
  
  public final float getWidth()
  {
    return this.mWidth;
  }
  
  public final float getX()
  {
    return this.mX;
  }
  
  public final float getY()
  {
    return this.mY;
  }
  
  public boolean isHidden()
  {
    return this.mHidden;
  }
  
  protected void onHiddenChanged() {}
  
  protected void onSizeChanged() {}
  
  protected void onSurfaceCreated(RenderView paramRenderView, GL11 paramGL11) {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void renderBlended(RenderView paramRenderView, GL11 paramGL11) {}
  
  public void renderOpaque(RenderView paramRenderView, GL11 paramGL11) {}
  
  public void setHidden(boolean paramBoolean)
  {
    if (this.mHidden != paramBoolean)
    {
      this.mHidden = paramBoolean;
      onHiddenChanged();
    }
  }
  
  public final void setPosition(float paramFloat1, float paramFloat2)
  {
    this.mX = paramFloat1;
    this.mY = paramFloat2;
  }
  
  public final void setSize(float paramFloat1, float paramFloat2)
  {
    if ((this.mWidth != paramFloat1) || (this.mHeight != paramFloat2))
    {
      this.mWidth = paramFloat1;
      this.mHeight = paramFloat2;
      onSizeChanged();
    }
  }
  
  public boolean update(RenderView paramRenderView, float paramFloat)
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/Layer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */