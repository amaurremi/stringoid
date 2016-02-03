package com.pocket.list.widget.b.b;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.util.i;
import com.ideashower.readitlater.util.j;
import com.pocket.list.widget.c;

public class h
  extends a
{
  private final ColorStateList d;
  private final Paint e;
  
  public h(Resources paramResources, com.pocket.list.widget.b paramb)
  {
    super(paramResources, paramb);
    this.d = paramResources.getColorStateList(2131165822);
    this.e = new Paint();
  }
  
  protected int A()
  {
    return 5;
  }
  
  protected float B()
  {
    return 2.1F;
  }
  
  protected int C()
  {
    return i.a;
  }
  
  protected int D()
  {
    return i.e;
  }
  
  protected int E()
  {
    return i.h;
  }
  
  protected int F()
  {
    return 0;
  }
  
  protected int G()
  {
    return i.h;
  }
  
  protected int H()
  {
    return 0;
  }
  
  protected int I()
  {
    return i.a;
  }
  
  public boolean K()
  {
    return true;
  }
  
  public boolean M()
  {
    return false;
  }
  
  public boolean O()
  {
    return false;
  }
  
  public boolean Q()
  {
    return true;
  }
  
  protected float R()
  {
    return 0.82F;
  }
  
  protected float S()
  {
    return 1.2F;
  }
  
  public void a(Canvas paramCanvas, com.pocket.list.widget.b.a parama, o paramo)
  {
    super.a(paramCanvas, parama, paramo);
    this.e.setColor(this.d.getColorForState(parama.getDrawableState(), 0));
    paramCanvas.drawRect(0.0F, parama.getHeight() - j.a(1.0F), parama.getWidth(), parama.getHeight(), this.e);
  }
  
  protected void a(RectF paramRectF) {}
  
  protected Drawable ab()
  {
    return this.b.c;
  }
  
  public int al()
  {
    return 2;
  }
  
  public com.pocket.list.widget.a.b ao()
  {
    return com.pocket.list.widget.a.b.b;
  }
  
  protected void b(Rect paramRect)
  {
    a(paramRect, 10.0F, 10.0F, 10.0F, 4.0F);
  }
  
  protected void d(Rect paramRect) {}
  
  protected void e(Rect paramRect)
  {
    float f1 = j.a(W().left) + 1.0F;
    float f2 = ae() - 26.0F;
    a(paramRect, f1, f2, 16 + f1, 16 + f2);
  }
  
  protected void f(Rect paramRect)
  {
    a(paramRect, 0.0F, 0.0F, Y(), 75.0F);
  }
  
  protected void g(Rect paramRect)
  {
    a(paramRect, 0.0F, 92.0F, Y(), 235.0F);
  }
  
  protected void h(Rect paramRect)
  {
    a(paramRect, 27.5F, aa() - 16 - 1, Y(), aa());
  }
  
  protected void i(Rect paramRect) {}
  
  protected void j(Rect paramRect)
  {
    a(paramRect, 30.5F, 6.0F, Y(), 16.0F + 6.0F);
  }
  
  protected int q()
  {
    return 2131165797;
  }
  
  protected int r()
  {
    return 2131165762;
  }
  
  protected int s()
  {
    return 2131165795;
  }
  
  protected int t()
  {
    return r();
  }
  
  protected int u()
  {
    return 2131165796;
  }
  
  protected int v()
  {
    return r();
  }
  
  protected int w()
  {
    return 2131165735;
  }
  
  protected float x()
  {
    return 25.0F;
  }
  
  protected float y()
  {
    return 16.0F;
  }
  
  protected float z()
  {
    return 13.0F;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/widget/b/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */