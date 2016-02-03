package com.pocket.i.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.pocket.p.e;

public class n
  extends Drawable
{
  private final Paint a = new Paint();
  private final ColorStateList b;
  private final StyledToolbar c;
  private boolean d = true;
  
  public n(Resources paramResources, StyledToolbar paramStyledToolbar)
  {
    this.c = paramStyledToolbar;
    this.b = paramResources.getColorStateList(2131165843);
    this.a.setDither(true);
  }
  
  private void a()
  {
    this.d = true;
  }
  
  private void b()
  {
    if (this.d)
    {
      c();
      this.d = false;
    }
  }
  
  private void c()
  {
    Rect localRect = getBounds();
    if ((localRect.width() == 0) || (localRect.height() == 0)) {
      return;
    }
    int j = this.b.getColorForState(getState(), 0);
    int i = e.b(0.16F, j);
    j = e.b(0, j);
    if (!this.c.c()) {}
    for (;;)
    {
      this.a.setShader(new LinearGradient(0.0F, localRect.top, 0.0F, localRect.bottom, j, i, Shader.TileMode.CLAMP));
      return;
      int k = j;
      j = i;
      i = k;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    b();
    Rect localRect = getBounds();
    if ((localRect.isEmpty()) || (this.c.f())) {
      return;
    }
    paramCanvas.drawRect(localRect, this.a);
  }
  
  public int getIntrinsicHeight()
  {
    return StyledToolbar.o;
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
    a();
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    super.onStateChange(paramArrayOfInt);
    a();
    return true;
  }
  
  public void setAlpha(int paramInt)
  {
    this.a.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.a.setColorFilter(paramColorFilter);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/i/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */