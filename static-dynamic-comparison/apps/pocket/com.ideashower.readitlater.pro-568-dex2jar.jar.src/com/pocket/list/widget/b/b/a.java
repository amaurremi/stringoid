package com.pocket.list.widget.b.b;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.objects.k;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.d;
import com.pocket.list.widget.c;

public abstract class a
{
  protected final com.pocket.list.widget.b a;
  protected c b;
  protected final Rect c;
  private int d;
  private int e;
  private final Rect f;
  private final Rect g;
  private final Rect h;
  private final Rect i;
  private final RectF j;
  private final Rect k;
  private final b l;
  private final b m;
  private final b n;
  private final b o;
  
  public a(Resources paramResources, com.pocket.list.widget.b paramb)
  {
    this.a = paramb;
    if (paramb != null) {
      this.b = paramb.getDrawCache();
    }
    this.f = new Rect();
    this.g = new Rect();
    this.c = new Rect();
    this.h = new Rect();
    this.i = new Rect();
    this.j = new RectF();
    this.k = new Rect();
    if (J())
    {
      paramb = new b(this, x(), 1, C(), D(), q(), r(), R(), l(), paramResources);
      this.l = paramb;
      if (!K()) {
        break label299;
      }
      paramb = new b(this, y(), 1, E(), F(), s(), t(), S(), m(), paramResources);
      label195:
      this.m = paramb;
      if (!L()) {
        break label304;
      }
      paramb = new b(this, z(), 1, G(), H(), u(), v(), 1.0F, n(), paramResources);
      label243:
      this.n = paramb;
      if (!N()) {
        break label309;
      }
    }
    label299:
    label304:
    label309:
    for (paramResources = new b(this, B(), A(), I(), 0, w(), 0, 1.0F, p(), paramResources);; paramResources = null)
    {
      this.o = paramResources;
      return;
      paramb = null;
      break;
      paramb = null;
      break label195;
      paramb = null;
      break label243;
    }
  }
  
  private Rect a(Rect paramRect, boolean paramBoolean)
  {
    paramRect.left += this.c.left;
    paramRect.right += this.c.left;
    if (!a())
    {
      paramRect.top += this.c.top;
      paramRect.bottom += this.c.top;
    }
    if (!a()) {}
    return paramRect;
  }
  
  protected static void a(Rect paramRect, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int i1;
    int i2;
    label24:
    int i3;
    if (paramFloat1 > 0.0F)
    {
      i1 = j.a(paramFloat1);
      if (paramFloat2 <= 0.0F) {
        break label70;
      }
      i2 = j.a(paramFloat2);
      if (paramFloat3 <= 0.0F) {
        break label77;
      }
      i3 = j.a(paramFloat3);
      label36:
      if (paramFloat4 <= 0.0F) {
        break label84;
      }
    }
    label70:
    label77:
    label84:
    for (int i4 = j.a(paramFloat4);; i4 = (int)paramFloat4)
    {
      paramRect.set(i1, i2, i3, i4);
      return;
      i1 = (int)paramFloat1;
      break;
      i2 = (int)paramFloat2;
      break label24;
      i3 = (int)paramFloat3;
      break label36;
    }
  }
  
  protected static void a(RectF paramRectF, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (paramFloat1 > 0.0F)
    {
      paramFloat1 = j.a(paramFloat1);
      if (paramFloat2 <= 0.0F) {
        break label68;
      }
      paramFloat2 = j.a(paramFloat2);
      label24:
      if (paramFloat3 <= 0.0F) {
        break label75;
      }
      paramFloat3 = j.a(paramFloat3);
      label36:
      if (paramFloat4 <= 0.0F) {
        break label82;
      }
    }
    label68:
    label75:
    label82:
    for (paramFloat4 = j.a(paramFloat4);; paramFloat4 = (int)paramFloat4)
    {
      paramRectF.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
      return;
      paramFloat1 = (int)paramFloat1;
      break;
      paramFloat2 = (int)paramFloat2;
      break label24;
      paramFloat3 = (int)paramFloat3;
      break label36;
    }
  }
  
  protected abstract int A();
  
  protected abstract float B();
  
  protected abstract int C();
  
  protected abstract int D();
  
  protected abstract int E();
  
  protected abstract int F();
  
  protected abstract int G();
  
  protected abstract int H();
  
  protected abstract int I();
  
  public boolean J()
  {
    return true;
  }
  
  public boolean K()
  {
    return false;
  }
  
  public boolean L()
  {
    return true;
  }
  
  public boolean M()
  {
    return false;
  }
  
  public boolean N()
  {
    return false;
  }
  
  public boolean O()
  {
    return false;
  }
  
  public boolean P()
  {
    return false;
  }
  
  public boolean Q()
  {
    return false;
  }
  
  protected float R()
  {
    return 1.0F;
  }
  
  protected float S()
  {
    return 1.0F;
  }
  
  public int T()
  {
    return 1;
  }
  
  public Rect U()
  {
    return this.g;
  }
  
  public Rect V()
  {
    return this.f;
  }
  
  public Rect W()
  {
    return this.c;
  }
  
  public int X()
  {
    Rect localRect = W();
    return localRect.right - localRect.left;
  }
  
  public int Y()
  {
    return (int)j.a(X());
  }
  
  public int Z()
  {
    Rect localRect = W();
    return localRect.bottom - localRect.top;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    this.e = paramInt1;
    this.d = paramInt2;
    a(this.f);
    b(this.g);
    c(this.c);
    if (O()) {
      d(this.h);
    }
    if (Q()) {
      e(this.i);
    }
    Rect localRect;
    if (J())
    {
      f(this.l.b);
      localRect = this.l.b;
      if (this.l.e == 1)
      {
        bool1 = true;
        a(localRect, bool1);
      }
    }
    else
    {
      if (K())
      {
        g(this.m.b);
        localRect = this.m.b;
        if (this.m.e != 1) {
          break label313;
        }
        bool1 = true;
        label155:
        a(localRect, bool1);
      }
      if (L())
      {
        h(this.n.b);
        localRect = this.n.b;
        if (this.n.e != 1) {
          break label318;
        }
        bool1 = true;
        label203:
        a(localRect, bool1);
      }
      if (M())
      {
        i(this.k);
        localRect = this.k;
        if (o() != 1) {
          break label323;
        }
        bool1 = true;
        label242:
        a(localRect, bool1);
      }
      if (N())
      {
        j(this.o.b);
        localRect = this.o.b;
        if (this.o.e != 1) {
          break label328;
        }
      }
    }
    label313:
    label318:
    label323:
    label328:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      a(localRect, bool1);
      a(this.j);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label155;
      bool1 = false;
      break label203;
      bool1 = false;
      break label242;
    }
  }
  
  public void a(Canvas paramCanvas, com.pocket.list.widget.b.a parama, o paramo)
  {
    int i2;
    int i1;
    int i3;
    if ((O()) && (paramo.L()))
    {
      Bitmap localBitmap = this.b.a;
      i2 = (int)((this.h.right - this.h.left - localBitmap.getWidth()) / 2.0F);
      if (this.h.bottom == -1)
      {
        i1 = parama.getHeight();
        i3 = (int)((i1 - localBitmap.getHeight()) / 2.0F);
        float f1 = this.h.left + i2;
        if (this.h.top != -1) {
          break label244;
        }
        i1 = 0;
        label108:
        paramCanvas.drawBitmap(localBitmap, f1, i1 + i3, null);
      }
    }
    else if (paramo.ae())
    {
      paramo = ab();
      paramo.setState(parama.getDrawableState());
      paramo = paramo.getBounds();
      i1 = paramo.right - paramo.left;
      i2 = paramo.bottom;
      i3 = paramo.top;
      i2 = parama.getHeight() - (i2 - i3);
      paramCanvas.save();
      if (!ac()) {
        break label256;
      }
      paramCanvas.translate(parama.getWidth() - i1, i2);
    }
    for (;;)
    {
      ab().draw(paramCanvas);
      paramCanvas.restore();
      return;
      i1 = this.h.bottom - this.h.top;
      break;
      label244:
      i1 = this.h.top;
      break label108;
      label256:
      paramCanvas.scale(-1.0F, 1.0F);
      paramCanvas.translate(-i1, i2);
    }
  }
  
  protected void a(Rect paramRect)
  {
    paramRect.set(0, 0, this.e, this.d);
  }
  
  protected abstract void a(RectF paramRectF);
  
  public void a(d paramd)
  {
    int i4;
    int i3;
    int i2;
    if (j.f())
    {
      i4 = j.a(8.0F);
      i3 = j.a(14.0F);
      i2 = j.a(7.0F);
    }
    for (int i1 = j.a(34.0F);; i1 = j.a(34.0F))
    {
      paramd.a(i4, i3, i2, false);
      paramd.setBounds(this.f.left, this.f.top, this.f.right, i1 + this.f.top);
      return;
      i4 = j.a(13.5F);
      i3 = j.a(14.0F);
      i2 = j.a(7.0F);
    }
  }
  
  public void a(com.pocket.list.widget.b paramb)
  {
    if (a())
    {
      a(paramb.getRowWidth(), -1);
      return;
    }
    if (T() > 1) {}
    for (int i1 = paramb.getDoubleSpaceWidth();; i1 = paramb.getSingleSpaceWidth())
    {
      this.e = i1;
      int i2 = paramb.getRowHeight();
      this.d = i2;
      a(i1, i2);
      return;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(com.ideashower.readitlater.e.a parama, k paramk, boolean paramBoolean)
  {
    int i3 = parama.e();
    int i4 = parama.f();
    int i5 = ai();
    int i6 = aj();
    int i1;
    int i7;
    int i2;
    if ((paramBoolean) || (ak()))
    {
      i1 = 1;
      i7 = ah();
      if (i3 < i4) {
        break label117;
      }
      i2 = 1;
      label54:
      if ((i1 == 0) || (i2 == 0) || (i5 * i4 / i3 >= i7)) {
        break label123;
      }
      paramk.a = -1;
      paramk.b = i7;
      label88:
      if ((i2 != 0) || (i1 == 0)) {
        break label132;
      }
      paramk.b = i7;
      label104:
      if (i1 == 0) {
        break label147;
      }
    }
    for (;;)
    {
      return true;
      i1 = 0;
      break;
      label117:
      i2 = 0;
      break label54;
      label123:
      paramk.a = i6;
      break label88;
      label132:
      paramk.b = (i6 * i7 / i5);
      break label104;
      label147:
      if ((i5 * (1.0F - 0.5F) > i3) || (i7 * (1.0F - 0.5F) > i4)) {}
      for (i1 = 1; i1 != 0; i1 = 0)
      {
        paramk.a = 0;
        paramk.b = 0;
        return false;
      }
    }
  }
  
  public int aa()
  {
    return (int)j.a(Z());
  }
  
  protected Drawable ab()
  {
    return this.b.b;
  }
  
  protected boolean ac()
  {
    return true;
  }
  
  protected int ad()
  {
    return this.d;
  }
  
  protected float ae()
  {
    return j.a(this.d);
  }
  
  protected int af()
  {
    return this.e;
  }
  
  protected float ag()
  {
    return j.a(af());
  }
  
  protected int ah()
  {
    return this.h.bottom - this.h.top;
  }
  
  protected int ai()
  {
    if (T() > 1) {
      return this.a.getDoubleTileWidthMin();
    }
    return this.a.getSingleTileWidthMin();
  }
  
  protected int aj()
  {
    if (T() > 1) {
      return this.a.getDoubleTileWidthMax();
    }
    return this.a.getSingleTileWidthMax();
  }
  
  protected boolean ak()
  {
    return true;
  }
  
  public abstract int al();
  
  public boolean am()
  {
    return false;
  }
  
  public boolean an()
  {
    return false;
  }
  
  public com.pocket.list.widget.a.b ao()
  {
    return null;
  }
  
  public boolean ap()
  {
    return false;
  }
  
  protected void b(Rect paramRect)
  {
    paramRect.set(0, 0, 0, 0);
  }
  
  public boolean b()
  {
    return false;
  }
  
  public b c()
  {
    return this.l;
  }
  
  protected void c(Rect paramRect)
  {
    int i1 = -1;
    Rect localRect1 = V();
    Rect localRect2 = U();
    int i2 = localRect1.left;
    int i3 = localRect2.left;
    int i4 = localRect1.top;
    int i5 = localRect2.top;
    int i6 = localRect1.right;
    int i7 = localRect2.right;
    if (localRect1.bottom == -1) {}
    for (;;)
    {
      paramRect.set(i2 + i3, i4 + i5, i6 - i7, i1);
      return;
      i1 = localRect1.bottom - localRect2.bottom;
    }
  }
  
  public b d()
  {
    return this.m;
  }
  
  protected abstract void d(Rect paramRect);
  
  public b e()
  {
    return this.n;
  }
  
  protected abstract void e(Rect paramRect);
  
  public b f()
  {
    return this.o;
  }
  
  protected abstract void f(Rect paramRect);
  
  public Rect g()
  {
    return this.h;
  }
  
  protected abstract void g(Rect paramRect);
  
  public Rect h()
  {
    return this.i;
  }
  
  protected abstract void h(Rect paramRect);
  
  public RectF i()
  {
    return this.j;
  }
  
  protected abstract void i(Rect paramRect);
  
  public Rect j()
  {
    return this.k;
  }
  
  protected abstract void j(Rect paramRect);
  
  public boolean k()
  {
    return false;
  }
  
  protected int l()
  {
    return 1;
  }
  
  protected int m()
  {
    return 1;
  }
  
  protected int n()
  {
    return 1;
  }
  
  protected int o()
  {
    return 1;
  }
  
  protected int p()
  {
    return 1;
  }
  
  protected abstract int q();
  
  protected abstract int r();
  
  protected abstract int s();
  
  protected abstract int t();
  
  protected abstract int u();
  
  protected abstract int v();
  
  protected abstract int w();
  
  protected abstract float x();
  
  protected abstract float y();
  
  protected abstract float z();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/widget/b/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */