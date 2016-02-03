package com.pocket.i.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import com.ideashower.readitlater.util.o;
import java.util.Random;

public class c
  extends Drawable
{
  private final Paint a = new Paint();
  private final Paint b = new Paint();
  private d c;
  private boolean d;
  
  public c()
  {
    this(d());
  }
  
  public c(d paramd)
  {
    this.c = paramd;
    this.b.setColor(com.pocket.p.e.a(0.35F, 0));
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
    int i;
    int j;
    switch (1.a[this.c.ordinal()])
    {
    default: 
      com.ideashower.readitlater.util.e.a("unknown type " + this.c);
      i = i.a;
      j = i.b;
    }
    for (;;)
    {
      this.a.setShader(new LinearGradient(0.0F, localRect.top, 0.0F, localRect.bottom, i, j, Shader.TileMode.CLAMP));
      return;
      i = i.a;
      j = i.b;
      continue;
      i = i.d;
      j = i.c;
    }
  }
  
  private static d d()
  {
    if (o.a().nextInt(2) == 1) {
      return d.a;
    }
    return d.b;
  }
  
  public void draw(Canvas paramCanvas)
  {
    b();
    Rect localRect = getBounds();
    if ((localRect.isEmpty()) || (this.c == null)) {
      return;
    }
    paramCanvas.drawRect(localRect, this.a);
    paramCanvas.drawRect(localRect, this.b);
  }
  
  public int getOpacity()
  {
    return -1;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    a();
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/i/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */