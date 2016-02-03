package com.pocket.i.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.ideashower.readitlater.h.m;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;

public class o
  extends Drawable
{
  private final Resources a;
  private final Matrix b = new Matrix();
  private final StyledToolbar c;
  private Bitmap d;
  private boolean e = false;
  
  public o(Resources paramResources, StyledToolbar paramStyledToolbar)
  {
    this.c = paramStyledToolbar;
    this.a = paramResources;
    setState(paramStyledToolbar.getDrawableState());
    a();
  }
  
  private void a()
  {
    Resources localResources = this.a;
    if (this.e) {}
    for (int i = 2130837604;; i = 2130837603)
    {
      this.d = BitmapFactory.decodeResource(localResources, i);
      b();
      return;
    }
  }
  
  private void b()
  {
    Object localObject = getBounds();
    if ((((Rect)localObject).width() == 0) || (((Rect)localObject).height() == 0)) {
      return;
    }
    float f2 = ((Rect)localObject).width() / this.d.getWidth();
    localObject = this.b;
    if (this.c.c()) {}
    for (float f1 = -1.0F;; f1 = 1.0F)
    {
      ((Matrix)localObject).setScale(f2, f1);
      if (!this.c.c()) {
        break;
      }
      this.b.postTranslate(0.0F, this.d.getHeight());
      return;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if ((getBounds().isEmpty()) || (this.c.f())) {
      return;
    }
    paramCanvas.drawBitmap(this.d, this.b, null);
  }
  
  public int getIntrinsicHeight()
  {
    if (this.d != null) {
      return this.d.getHeight();
    }
    return 0;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    b();
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool1 = super.onStateChange(paramArrayOfInt);
    boolean bool2 = m.b(paramArrayOfInt);
    if (this.e != bool2)
    {
      this.e = bool2;
      a();
      bool1 = true;
    }
    return bool1;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/i/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */