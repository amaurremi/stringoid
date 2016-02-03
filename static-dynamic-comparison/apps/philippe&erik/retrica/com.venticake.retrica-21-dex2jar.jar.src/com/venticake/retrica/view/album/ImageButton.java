package com.venticake.retrica.view.album;

import android.os.SystemClock;
import android.view.MotionEvent;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL11;

public final class ImageButton
  extends Layer
{
  private static final float TRACKING_MARGIN = 30.0F;
  private Runnable mAction = null;
  private int mCurrentImage = 0;
  private final FloatAnim mFade = new FloatAnim(1.0F);
  private int mImage = 0;
  private boolean mPressed = false;
  private int mPressedImage = 0;
  private int mPreviousImage = 0;
  private final int mTransparent = 2130837685;
  
  private boolean containsPoint(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mImage != 0)
    {
      float f8 = this.mX;
      float f7 = this.mY;
      float f6 = f8 + this.mWidth;
      float f5 = this.mHeight + f7;
      float f4 = f5;
      float f3 = f6;
      float f2 = f7;
      float f1 = f8;
      if (paramBoolean)
      {
        f1 = f8 - 30.0F;
        f2 = f7 - 30.0F;
        f3 = f6 + 30.0F;
        f4 = f5 + 30.0F;
      }
      bool1 = bool2;
      if (paramFloat1 >= f1)
      {
        bool1 = bool2;
        if (paramFloat2 >= f2)
        {
          bool1 = bool2;
          if (paramFloat1 < f3)
          {
            bool1 = bool2;
            if (paramFloat2 < f4) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private void setImage(int paramInt, boolean paramBoolean)
  {
    if (this.mCurrentImage != paramInt)
    {
      if (!paramBoolean) {
        break label47;
      }
      this.mFade.setValue(0.0F);
      this.mFade.animateValue(1.0F, 0.25F, SystemClock.uptimeMillis());
      this.mPreviousImage = this.mCurrentImage;
    }
    for (;;)
    {
      this.mCurrentImage = paramInt;
      return;
      label47:
      this.mFade.setValue(1.0F);
    }
  }
  
  public void generate(RenderView paramRenderView, RenderView.Lists paramLists)
  {
    paramLists.updateList.add(this);
    paramLists.blendedList.add(this);
    paramLists.hitTestList.add(this);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
      return true;
    case 0: 
    case 2: 
      boolean bool = containsPoint(paramMotionEvent.getX(), paramMotionEvent.getY(), true);
      this.mPressed = bool;
      if (bool)
      {
        setImage(this.mPressedImage, false);
        return true;
      }
      setImage(this.mImage, true);
      return true;
    case 1: 
      if ((this.mPressed) && (this.mAction != null)) {
        this.mAction.run();
      }
      break;
    }
    this.mPressed = false;
    setImage(this.mImage, true);
    return true;
  }
  
  public void renderBlended(RenderView paramRenderView, GL11 paramGL11)
  {
    float f = this.mFade.getValue(paramRenderView.getFrameTime());
    ResourceTexture localResourceTexture3 = paramRenderView.getResource(this.mCurrentImage);
    ResourceTexture localResourceTexture2 = paramRenderView.getResource(this.mPreviousImage);
    ResourceTexture localResourceTexture1 = paramRenderView.getResource(2130837685);
    paramGL11 = localResourceTexture3;
    if (localResourceTexture3 == null) {
      paramGL11 = localResourceTexture1;
    }
    if (localResourceTexture2 == null) {}
    for (;;)
    {
      if (f >= 0.99F)
      {
        paramRenderView.draw2D(paramGL11, this.mX, this.mY);
        return;
      }
      paramRenderView.drawMixed2D(localResourceTexture1, paramGL11, f, this.mX, this.mY, 0.0F, paramGL11.getWidth(), paramGL11.getHeight());
      return;
      localResourceTexture1 = localResourceTexture2;
    }
  }
  
  public final void setAction(Runnable paramRunnable)
  {
    this.mAction = paramRunnable;
  }
  
  public void setImages(int paramInt1, int paramInt2)
  {
    this.mImage = paramInt1;
    this.mPressedImage = paramInt2;
    if (!this.mPressed) {
      setImage(paramInt1, true);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/ImageButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */