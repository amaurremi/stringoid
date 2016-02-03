package com.pocket.j;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.ideashower.readitlater.e.g;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.ImageRequestView;
import com.pocket.i.a.c;
import com.pocket.list.widget.a.b;
import com.pocket.m.a.d;
import com.pocket.p.e;

public class a
  extends ImageRequestView
{
  private static final int a = e.a(0.1F, 0);
  private static final int b = e.a(0.2F, 0);
  private static final int c = j.a(7.5F);
  private final com.pocket.list.widget.a.a d;
  private final Paint e;
  private final int f;
  private final int g;
  private boolean h;
  private final Paint i = new Paint();
  private c j;
  
  public a(Context paramContext)
  {
    super(paramContext);
    this.i.setColor(a);
    this.e = new Paint();
    this.e.setColor(b);
    Resources localResources = getResources();
    this.f = localResources.getDimensionPixelSize(2131296303);
    this.g = localResources.getDimensionPixelSize(2131296304);
    this.d = new com.pocket.list.widget.a.a(paramContext, b.a);
    this.d.setBounds(0, c, 0, 0);
    this.d.setCallback(new Drawable.Callback()
    {
      public void invalidateDrawable(Drawable paramAnonymousDrawable)
      {
        a.this.invalidate();
      }
      
      public void scheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable, long paramAnonymousLong) {}
      
      public void unscheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable) {}
    });
  }
  
  private void a()
  {
    if (this.j == null) {
      return;
    }
    this.j.setBounds(0, 0, getWidth(), getHeight());
  }
  
  public void a(g paramg, com.pocket.m.a.a parama, int paramInt, boolean paramBoolean)
  {
    this.d.a(paramg);
    this.h = paramBoolean;
    a(parama, d.a(paramInt));
    if (parama != null)
    {
      setDrawPlaceholder(true);
      this.j = null;
      return;
    }
    setDrawPlaceholder(false);
    if (this.j != null) {}
    for (paramg = this.j;; paramg = new c())
    {
      this.j = paramg;
      a();
      return;
    }
  }
  
  protected int getSuggestedMinimumHeight()
  {
    if (this.h) {
      return this.f;
    }
    return this.g;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.j != null) {
      this.j.draw(paramCanvas);
    }
    if (isPressed()) {
      paramCanvas.drawPaint(this.e);
    }
    for (;;)
    {
      this.d.draw(paramCanvas);
      return;
      paramCanvas.drawPaint(this.i);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean) {
      a();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(getMeasuredWidth(), getSuggestedMinimumHeight());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/j/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */