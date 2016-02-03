package com.venticake.retrica.view.album;

import android.view.MotionEvent;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL11;

public final class PathBarLayer
  extends Layer
{
  private static final int CAP = 2130837658;
  private static final int FILL = 2130837657;
  private static final int JOIN = 2130837659;
  private static final StringTexture.Config sPathFormat = new StringTexture.Config();
  private final ArrayList<PathBarLayer.Component> mComponents = new ArrayList();
  private PathBarLayer.Component mTouchItem = null;
  
  static
  {
    sPathFormat.fontSize = (18.0F * Gallery.PIXEL_DENSITY);
  }
  
  private PathBarLayer.Component hitTestItems(float paramFloat1, float paramFloat2)
  {
    int j;
    int i;
    if ((paramFloat2 >= this.mY) && (paramFloat2 < this.mY + this.mHeight))
    {
      j = this.mComponents.size();
      i = 0;
    }
    for (;;)
    {
      Object localObject;
      if (i >= j) {
        localObject = null;
      }
      PathBarLayer.Component localComponent;
      do
      {
        return (PathBarLayer.Component)localObject;
        localComponent = (PathBarLayer.Component)this.mComponents.get(i);
        paramFloat2 = localComponent.x;
        if (paramFloat1 < paramFloat2) {
          break;
        }
        localObject = localComponent;
      } while (paramFloat1 < paramFloat2 + localComponent.width);
      i += 1;
    }
  }
  
  private void layout()
  {
    int j = this.mComponents.size();
    int i = 0;
    if (i >= j) {
      return;
    }
    PathBarLayer.Component localComponent = (PathBarLayer.Component)this.mComponents.get(i);
    label41:
    float f2;
    if (localComponent.icon == 0)
    {
      f1 = 0.0F;
      f2 = f1;
      if (f1 == 0.0F) {
        f2 = 8.0F * Gallery.PIXEL_DENSITY;
      }
      f1 = 5.0F * Gallery.PIXEL_DENSITY;
      if (i == j - 1) {
        break label97;
      }
    }
    label97:
    for (float f1 = f2 + f1;; f1 = f2 + localComponent.texture.computeTextWidth() + f1)
    {
      localComponent.width = f1;
      i += 1;
      break;
      f1 = localComponent.getIconWidth();
      break label41;
    }
  }
  
  public void changeLabel(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    PathBarLayer.Component localComponent;
    do
    {
      return;
      localComponent = popLabel();
    } while (localComponent == null);
    pushLabel(localComponent.icon, paramString, localComponent.action);
  }
  
  public void clear()
  {
    this.mComponents.clear();
  }
  
  public void generate(RenderView paramRenderView, RenderView.Lists paramLists)
  {
    paramLists.blendedList.add(this);
    paramLists.hitTestList.add(this);
    paramLists.updateList.add(this);
  }
  
  public String getCurrentLabel()
  {
    ArrayList localArrayList = this.mComponents;
    int i = localArrayList.size() - 1;
    if (i < 0) {
      return "";
    }
    return ((PathBarLayer.Component)localArrayList.get(i)).origString;
  }
  
  public int getNumLevels()
  {
    return this.mComponents.size();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.mTouchItem = hitTestItems(f1, f2);
      continue;
      if (this.mTouchItem != null) {
        this.mTouchItem.action.run();
      }
      this.mTouchItem = null;
    }
  }
  
  public PathBarLayer.Component popLabel()
  {
    ArrayList localArrayList = this.mComponents;
    int i = localArrayList.size() - 1;
    if (i < 0) {
      return null;
    }
    PathBarLayer.Component localComponent = (PathBarLayer.Component)localArrayList.get(i);
    localArrayList.remove(i);
    return localComponent;
  }
  
  public void pushLabel(int paramInt, String paramString, Runnable paramRunnable)
  {
    this.mComponents.add(new PathBarLayer.Component(paramInt, paramString, paramRunnable, 0.0F));
    recomputeComponents();
  }
  
  public void recomputeComponents()
  {
    float f1 = this.mWidth;
    float f2 = Gallery.PIXEL_DENSITY;
    int j = this.mComponents.size();
    f1 -= f2 * 20.0F;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      PathBarLayer.Component localComponent = (PathBarLayer.Component)this.mComponents.get(i);
      f1 -= localComponent.getIconWidth() + Gallery.PIXEL_DENSITY * 20.0F;
      localComponent.computeLabel(f1);
      i += 1;
    }
  }
  
  public void renderBlended(RenderView paramRenderView, GL11 paramGL11)
  {
    paramGL11 = paramRenderView.getResource(2130837657);
    ResourceTexture localResourceTexture1 = paramRenderView.getResource(2130837659);
    ResourceTexture localResourceTexture2 = paramRenderView.getResource(2130837658);
    float f3 = this.mY + 3.0F;
    int i = (int)(3.0F * Gallery.PIXEL_DENSITY);
    float f4 = this.mHeight;
    int m = this.mComponents.size();
    int j = 0;
    if (j >= m) {
      return;
    }
    PathBarLayer.Component localComponent = (PathBarLayer.Component)this.mComponents.get(j);
    localComponent.x = i;
    int n = (int)localComponent.animWidth;
    label142:
    float f1;
    Object localObject;
    if (j != 0)
    {
      paramRenderView.draw2D(localResourceTexture1, i - localResourceTexture1.getWidth(), f3);
      if (paramRenderView.bind(paramGL11)) {
        paramRenderView.draw2D(i, f3, 0.0F, n, f4);
      }
      if (j == m - 1) {
        paramRenderView.draw2D(localResourceTexture2, i + n, f3);
      }
      f1 = Gallery.PIXEL_DENSITY;
      localObject = localComponent.animatedIcons;
      if ((localObject == null) || (localObject.length <= 0)) {
        break label382;
      }
    }
    label382:
    for (int k = localObject[((int)(localComponent.timeElapsed * 20.0F) % localObject.length)];; k = localComponent.icon)
    {
      localObject = paramRenderView.getResource(k);
      if (localObject != null)
      {
        paramRenderView.loadTexture((Texture)localObject);
        paramRenderView.draw2D((Texture)localObject, f1 * 5.0F + i, f3 - 2.0F * Gallery.PIXEL_DENSITY);
      }
      if (j == m - 1)
      {
        localObject = localComponent.texture;
        paramRenderView.loadTexture((Texture)localObject);
        float f2 = localComponent.getIconWidth();
        if (((StringTexture)localObject).computeTextWidth() <= n - f2)
        {
          f1 = f2;
          if (f2 == 0.0F) {
            f1 = 8.0F * Gallery.PIXEL_DENSITY;
          }
          paramRenderView.draw2D((Texture)localObject, f1 + i, 5.0F + f3);
        }
      }
      k = (int)(n + (21.0F * Gallery.PIXEL_DENSITY + 0.5F));
      j += 1;
      i += k;
      break;
      if (!paramRenderView.bind(paramGL11)) {
        break label142;
      }
      paramRenderView.draw2D(0.0F, f3, 0.0F, i + n, f4);
      break label142;
    }
  }
  
  public void setAnimatedIcons(int[] paramArrayOfInt)
  {
    int j = this.mComponents.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      PathBarLayer.Component localComponent = (PathBarLayer.Component)this.mComponents.get(i);
      if (localComponent != null)
      {
        if (localComponent.animatedIcons != null) {
          localComponent.animatedIcons = null;
        }
        if (i == j - 1) {
          localComponent.animatedIcons = paramArrayOfInt;
        }
      }
      i += 1;
    }
  }
  
  public boolean update(RenderView paramRenderView, float paramFloat)
  {
    layout();
    int j = this.mComponents.size();
    int i = 0;
    boolean bool = false;
    for (;;)
    {
      if (i >= j) {
        return bool;
      }
      bool |= ((PathBarLayer.Component)this.mComponents.get(i)).update(paramFloat);
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/PathBarLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */