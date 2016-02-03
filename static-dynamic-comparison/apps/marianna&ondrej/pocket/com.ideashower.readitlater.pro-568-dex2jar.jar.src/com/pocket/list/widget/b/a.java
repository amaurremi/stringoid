package com.pocket.list.widget.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.text.StaticLayout;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.ideashower.readitlater.e.g;
import com.ideashower.readitlater.e.u;
import com.ideashower.readitlater.e.x;
import com.ideashower.readitlater.h.m;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.AvatarView;
import com.pocket.list.widget.b.b.n;
import com.pocket.m.a.k;
import com.pocket.widget.ThemedView;
import java.util.ArrayList;
import java.util.Random;

public class a
  extends ThemedView
  implements View.OnClickListener, View.OnLongClickListener
{
  private static final int d = j.a(14.0F);
  private final Paint A;
  private final Paint B;
  private final Paint C;
  private com.pocket.list.widget.b.a.c D;
  private final b E;
  private boolean F;
  private u G;
  protected com.ideashower.readitlater.util.a.b a;
  protected com.ideashower.readitlater.util.a.b b;
  protected com.ideashower.readitlater.util.a.b c;
  private final c e = new c(this, null);
  private final c f = new c(this, null);
  private final c g = new c(this, null);
  private final c h = new c(this, null);
  private final Rect i = new Rect();
  private Rect j;
  private final RectF k = new RectF();
  private final com.ideashower.readitlater.f.h l;
  private final com.ideashower.readitlater.f.h m;
  private final com.ideashower.readitlater.f.h n;
  private final com.pocket.i.a.a o;
  private final com.pocket.d.h p;
  private com.ideashower.readitlater.views.d q;
  private final Rect r = new Rect();
  private final com.pocket.list.widget.b.c.a s;
  private final Rect t = new Rect();
  private final com.pocket.list.widget.a.a u;
  private final com.pocket.i.a.c v = new com.pocket.i.a.c(com.pocket.i.a.d.a);
  private final com.pocket.i.a.c w = new com.pocket.i.a.c(com.pocket.i.a.d.b);
  private com.pocket.i.a.c x;
  private com.ideashower.readitlater.e.o y;
  private com.pocket.list.widget.b.b.a z;
  
  public a(Context paramContext, b paramb)
  {
    super(paramContext);
    this.E = paramb;
    this.s = new com.pocket.list.widget.b.c.a(paramContext);
    this.o = new com.pocket.i.a.a(paramContext, 2131165779);
    this.u = new com.pocket.list.widget.a.a(paramContext);
    setBackgroundResource(2130837800);
    this.B = new Paint();
    this.C = new Paint();
    this.C.setAntiAlias(true);
    this.p = new com.pocket.d.h(com.ideashower.readitlater.db.operation.f.f(), getResources());
    this.l = new com.ideashower.readitlater.f.h()
    {
      protected void a(com.ideashower.readitlater.util.a.b paramAnonymousb)
      {
        a.a(a.this, paramAnonymousb);
      }
    };
    this.A = new Paint();
    int i1;
    switch (com.ideashower.readitlater.util.o.a().nextInt(3))
    {
    default: 
      i1 = 2131165280;
    }
    for (;;)
    {
      this.A.setColor(getResources().getColor(i1));
      this.m = new com.ideashower.readitlater.f.h()
      {
        protected void a(com.ideashower.readitlater.util.a.b paramAnonymousb)
        {
          a.b(a.this, paramAnonymousb);
        }
      };
      this.n = new com.ideashower.readitlater.f.h()
      {
        protected void a(com.ideashower.readitlater.util.a.b paramAnonymousb)
        {
          a.c(a.this, paramAnonymousb);
        }
      };
      if (this.E == null) {
        break;
      }
      setOnClickListener(this);
      setOnLongClickListener(this);
      return;
      i1 = 2131165278;
      continue;
      i1 = 2131165277;
    }
    setClickable(false);
  }
  
  private int a(int paramInt)
  {
    return View.MeasureSpec.getSize(paramInt);
  }
  
  private static int a(c paramc)
  {
    return c.a(paramc).b().getWidth() + c.a(paramc).a;
  }
  
  private int a(boolean paramBoolean)
  {
    if ((isPressed()) || (isSelected()) || (!b())) {
      return 179;
    }
    if ((m.a(getDrawableState())) && (!paramBoolean)) {
      return 191;
    }
    return 255;
  }
  
  private void a(int paramInt, Rect paramRect)
  {
    paramRect.top += paramInt;
    if (paramRect.bottom >= 0) {
      paramRect.bottom += paramRect.top;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    c.a(this.h, null);
    setAvatar(null);
    Object localObject;
    if ((this.z.N()) && (this.y.h(true)))
    {
      this.h.a(this.z.f());
      localObject = this.y.U();
      if (!this.z.am()) {
        break label383;
      }
      this.h.a(new com.pocket.list.widget.b.c.d((ArrayList)localObject, c.b(this.h), c.c(this.h), c.d(this.h).d, this.t.width(), this.z.an()));
      if (paramBoolean1) {
        this.t.left = a(this.h);
      }
      this.n.a();
      this.k.set(this.z.i());
      if (this.z.k())
      {
        float f1 = this.k.left;
        this.k.left = (c.b(this.h).left - this.k.right);
        this.k.top = (c.b(this.h).top - this.k.bottom);
        this.k.right = (this.k.left + f1);
        this.k.bottom = (f1 + this.k.top);
      }
    }
    try
    {
      com.pocket.k.d locald = new com.pocket.k.d(this.k.width(), this.k.height());
      localObject = com.ideashower.readitlater.f.f.a(com.ideashower.readitlater.a.o.c().a((x)((ArrayList)localObject).get(0)).e(), locald, com.pocket.m.a.d.b()).a(1).a(true, k.a).a(this.n, true, true).a();
      this.n.b((com.ideashower.readitlater.f.e)localObject);
      paramInt = a(false);
      this.C.setAlpha(paramInt);
      this.p.setAlpha(paramInt);
      this.p.a(this.k);
      return;
    }
    catch (Throwable localThrowable)
    {
      label383:
      int i1;
      com.ideashower.readitlater.util.e.a(localThrowable);
    }
    if (paramBoolean2)
    {
      if (!paramBoolean1) {
        break label435;
      }
      i1 = c.a(this.e).a();
    }
    for (;;)
    {
      a(i1, c.b(this.h));
      if (!paramBoolean1) {
        break;
      }
      c.b(this.h).offset(0, paramInt);
      break;
      label435:
      if (c.a(this.f) != null) {
        i1 = c.a(this.f).a();
      } else {
        i1 = c.a(this.g).a();
      }
    }
  }
  
  private int b(int paramInt)
  {
    int i1 = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i1 == 1073741824) {
      return paramInt;
    }
    int i2 = getRowBottom();
    if (i1 == Integer.MIN_VALUE) {
      return Math.min(i2, paramInt);
    }
    return i2;
  }
  
  private boolean b()
  {
    if (this.E == null) {}
    while ((this.E.a()) || ((this.y != null) && (this.y.S()))) {
      return true;
    }
    return false;
  }
  
  private CharSequence getDisplayExcerpt()
  {
    if ((this.G != null) && (this.G.e() != null)) {
      return this.G.e();
    }
    return this.y.r();
  }
  
  private CharSequence getDisplayHost()
  {
    if ((this.G != null) && (this.G.a(this.y) != null)) {
      return this.G.a(this.y);
    }
    return this.y.o();
  }
  
  private CharSequence getDisplayTitle()
  {
    if ((this.G != null) && (this.G.d() != null)) {
      return this.G.d();
    }
    return this.y.t();
  }
  
  private int getRowBottom()
  {
    if (this.s.d() > 0) {
      return this.s.c() + this.z.U().bottom;
    }
    if (c.a(this.h) != null) {
      return c.a(this.h).a() + this.z.U().bottom;
    }
    if (c.a(this.f) != null) {
      return c.a(this.f).a() + this.z.U().bottom;
    }
    return c.a(this.g).a() + this.z.U().bottom;
  }
  
  private void setAvatar(com.ideashower.readitlater.util.a.b paramb)
  {
    if (this.c != null) {
      this.c.b(false);
    }
    com.ideashower.readitlater.util.a.b localb = paramb;
    if (paramb != null)
    {
      localb = paramb;
      if (!paramb.c()) {
        localb = null;
      }
    }
    if (localb != null) {
      this.C.setShader(new BitmapShader(localb.b(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
    }
    for (;;)
    {
      this.c = localb;
      invalidate();
      return;
      this.C.setShader(null);
    }
  }
  
  private void setFavicon(com.ideashower.readitlater.util.a.b paramb)
  {
    if (this.b != null) {
      this.b.b(false);
    }
    com.ideashower.readitlater.util.a.b localb = paramb;
    if (paramb != null)
    {
      localb = paramb;
      if (!paramb.c()) {
        localb = null;
      }
    }
    this.b = localb;
    invalidate();
  }
  
  private void setImage(com.ideashower.readitlater.util.a.b paramb)
  {
    if (this.a != null) {
      this.a.b(false);
    }
    com.ideashower.readitlater.util.a.b localb = paramb;
    if (paramb != null)
    {
      localb = paramb;
      if (!paramb.c()) {
        localb = null;
      }
    }
    this.a = localb;
    invalidate();
  }
  
  protected void a()
  {
    if (this.z == null) {
      return;
    }
    this.x = null;
    g localg;
    if (this.F) {
      localg = this.y.z();
    }
    for (;;)
    {
      Object localObject = this.y.X();
      int i2;
      label65:
      boolean bool1;
      float f1;
      label163:
      int i1;
      if ((this.z.O()) && ((localObject != null) || (this.z.P())))
      {
        i2 = 1;
        if (this.z.am())
        {
          if (this.q == null) {
            this.q = new com.ideashower.readitlater.views.d(getContext());
          }
          this.q.setState(getDrawableState());
          this.z.a(this.q);
        }
        bool1 = this.z.a();
        boolean bool2 = this.z.b();
        if ((!this.z.N()) || (!this.y.h(true))) {
          break label1297;
        }
        f1 = 16.5F;
        i1 = j.a(f1);
        if (!bool2) {
          break label1304;
        }
        this.t.set(this.z.W());
        label187:
        c.a(this.e, null);
        if (this.z.J())
        {
          this.e.a(this.z.c());
          this.e.a(new com.pocket.list.widget.b.c.c(getDisplayTitle(), c.b(this.e), c.c(this.e), c.d(this.e).d, 0));
        }
        if (bool2) {
          a(bool2, bool1, i1);
        }
        c.a(this.g, null);
        if (this.z.L())
        {
          this.g.a(this.z.e());
          if (bool1) {
            a(c.a(this.e).a(), c.b(this.g));
          }
          if (bool2)
          {
            if (c.a(this.h) != null)
            {
              localObject = this.t;
              ((Rect)localObject).left += d * 2;
            }
            c.b(this.g).offset(0, i1);
            c.b(this.g).left = this.t.left;
          }
          this.g.a(new com.pocket.list.widget.b.c.c(getDisplayHost(), c.b(this.g), c.c(this.g), c.d(this.g).d, this.t.width()));
          if (bool2) {
            this.t.left = a(this.g);
          }
        }
        c.a(this.f, null);
        if ((this.z.K()) && (this.y.s()))
        {
          this.f.a(this.z.d());
          if (!bool1) {
            break label1314;
          }
          a(c.a(this.g).a(), c.b(this.f));
          label539:
          this.f.a(new com.pocket.list.widget.b.c.c(getDisplayExcerpt(), c.b(this.f), c.c(this.f), c.d(this.f).d, this.t.width()));
        }
        if (!bool2) {
          a(bool2, bool1, i1);
        }
        if ((!this.z.M()) || ((!this.y.x()) && (localg == null))) {
          break label1454;
        }
        this.r.set(this.z.j());
        if (!bool2) {
          break label1372;
        }
        if ((c.a(this.g) != null) || (c.a(this.h) != null))
        {
          localObject = this.t;
          ((Rect)localObject).left += d;
        }
        a(c.a(this.e).a(), this.r);
        this.r.left = this.t.left;
        this.r.offset(0, i1);
        label727:
        this.s.setBounds(this.r);
        if (bool2)
        {
          localObject = this.t;
          ((Rect)localObject).left += this.s.a();
        }
        this.s.a(localg);
        com.pocket.list.widget.b.c.a locala = this.s;
        if (!this.y.x()) {
          break label1448;
        }
        localObject = this.y.w();
        label801:
        locala.a((ArrayList)localObject, this.G);
        label812:
        this.i.setEmpty();
        setImage(null);
        this.l.a();
        if (i2 != 0)
        {
          this.i.set(this.z.g());
          if ((this.z.ap()) && (c.a(this.e) != null)) {
            this.i.top = (c.a(this.e).a() + j.a(6.0F));
          }
          if (this.i.bottom == -1) {
            this.i.bottom = getRowBottom();
          }
          this.o.setBounds(this.i);
          this.o.setState(getDrawableState());
          if (!this.y.e(false)) {
            break label1506;
          }
        }
      }
      try
      {
        i1 = this.i.width();
        i2 = this.i.height();
        if (i1 != 0) {
          break label1474;
        }
        localObject = new com.pocket.k.e(true, i2);
        label980:
        localObject = com.ideashower.readitlater.f.f.a(this.y.ab(), (com.pocket.k.a)localObject, this.y.ad()).a(1).a(true, k.a).a(this.l, true, true).a();
        this.l.b((com.ideashower.readitlater.f.e)localObject);
      }
      catch (Throwable localThrowable2)
      {
        label1033:
        for (;;) {}
      }
      this.B.setAlpha(a(false));
      this.b = null;
      this.m.a();
      if (this.z.Q()) {
        this.j = this.z.h();
      }
      try
      {
        localObject = new com.pocket.k.d(this.j.right - this.j.left, this.j.bottom - this.j.top);
        localObject = com.ideashower.readitlater.f.f.a(this.y.ac(), (com.pocket.k.a)localObject, this.y.ad()).a(1).a(true, k.a).a(this.m, true, true).a();
        this.m.b((com.ideashower.readitlater.f.e)localObject);
        if ((localg != null) && (this.z.ao() != null) && (!this.z.M()))
        {
          this.u.a(localg);
          this.u.a(this.z.ao());
          if (!this.i.isEmpty())
          {
            i2 = this.i.top + j.a(9.5F);
            i1 = i2;
            if (c.a(this.e) == null)
            {
              i1 = i2;
              if (c.a(this.h) != null) {
                i1 = i2 + j.a(5.0F);
              }
            }
            this.u.a(0, i1);
            return;
            localg = null;
            continue;
            i2 = 0;
            break label65;
            label1297:
            f1 = 10.5F;
            break label163;
            label1304:
            this.t.setEmpty();
            break label187;
            label1314:
            if ((localg == null) || (i2 != 0)) {
              break label539;
            }
            int i3 = c.a(this.e).a() + j.a(50.0F);
            if (c.b(this.f).top >= i3) {
              break label539;
            }
            c.b(this.f).top = i3;
            break label539;
            label1372:
            if (!bool1) {
              break label727;
            }
            if (c.a(this.h) != null) {
              i1 = c.a(this.h).a();
            }
            for (;;)
            {
              a(i1, this.r);
              break;
              if (c.a(this.f) != null) {
                i1 = c.a(this.f).a();
              } else {
                i1 = c.a(this.g).a();
              }
            }
            label1448:
            localObject = null;
            break label801;
            label1454:
            this.s.a(null, null);
            this.s.a(null);
            break label812;
            label1474:
            if (i2 == 0)
            {
              localObject = new com.pocket.k.f(true, i1);
              break label980;
            }
            localObject = new com.pocket.k.d(i1, i2);
            break label980;
            label1506:
            if ((!this.y.L()) && (!(this.z instanceof n))) {
              break label1033;
            }
            if (this.y.i().length() % 2 != 0) {}
            for (this.x = this.v;; this.x = this.w)
            {
              this.x.setBounds(this.i);
              break;
            }
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          com.ideashower.readitlater.util.e.a(localThrowable1);
          continue;
          i1 = c.a(this.e).a() + j.a(14.0F);
        }
        this.u.a(null);
        return;
      }
    }
  }
  
  public void a(com.ideashower.readitlater.e.o paramo)
  {
    a(paramo, this.z, this.F, this.G);
  }
  
  public void a(com.ideashower.readitlater.e.o paramo, com.pocket.list.widget.b.b.a parama, boolean paramBoolean, u paramu)
  {
    this.y = paramo;
    this.z = parama;
    this.F = paramBoolean;
    if ((paramu != null) && (paramu.c())) {}
    for (;;)
    {
      this.G = paramu;
      a();
      requestLayout();
      invalidate();
      return;
      paramu = null;
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int i2 = a(false);
    Object localObject = getDrawableState();
    this.e.a((int[])localObject);
    this.f.a((int[])localObject);
    this.g.a((int[])localObject);
    this.h.a((int[])localObject);
    this.s.setState((int[])localObject);
    this.o.setState((int[])localObject);
    if ((this.z != null) && (this.z.am()) && (this.q != null))
    {
      this.q.setState((int[])localObject);
      localObject = this.q;
      if ((!isPressed()) && (!isSelected())) {
        break label166;
      }
    }
    label166:
    for (int i1 = 121;; i1 = 255)
    {
      ((com.ideashower.readitlater.views.d)localObject).setAlpha(i1);
      this.B.setAlpha(i2);
      this.C.setAlpha(i2);
      this.p.setAlpha(i2);
      this.o.setAlpha(a(true));
      invalidate();
      return;
    }
  }
  
  public com.ideashower.readitlater.e.o getItem()
  {
    return this.y;
  }
  
  public b getListener()
  {
    return this.E;
  }
  
  public void onClick(View paramView)
  {
    if (this.D != null)
    {
      this.D.a();
      return;
    }
    this.E.a(this, this.y, isSelected());
  }
  
  @SuppressLint({"WrongCall"})
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!this.i.isEmpty())
    {
      if (this.a != null) {
        paramCanvas.drawBitmap(this.a.b(), this.i.left, this.i.top, this.B);
      }
    }
    else
    {
      if (c.a(this.e) != null) {
        c.a(this.e).a(paramCanvas);
      }
      if (c.a(this.f) != null) {
        c.a(this.f).a(paramCanvas);
      }
      if (c.a(this.g) != null)
      {
        c.a(this.g).a(paramCanvas);
        if ((c.a(this.h) != null) && (this.z.b()))
        {
          com.pocket.list.widget.b.c.c localc = c.a(this.h);
          float f1 = j.a(3.25F);
          paramCanvas.drawCircle(a(this.h) + d, localc.b + localc.b().getHeight() / 2 - f1 + j.a(0.5F), f1, localc.b().getPaint());
        }
      }
      if (this.z != null) {
        this.z.a(paramCanvas, this, this.y);
      }
      if (c.a(this.h) != null)
      {
        if (this.z.am()) {
          this.q.draw(paramCanvas);
        }
        c.a(this.h).a(paramCanvas);
        if (this.C.getShader() == null) {
          break label373;
        }
        AvatarView.a(this.k, paramCanvas, this.C);
      }
      label282:
      if (this.z.Q())
      {
        if (this.b == null) {
          break label384;
        }
        paramCanvas.drawBitmap(this.b.b(), this.j.left, this.j.top, null);
      }
    }
    for (;;)
    {
      this.u.draw(paramCanvas);
      this.s.draw(paramCanvas);
      return;
      if (this.x != null)
      {
        this.x.draw(paramCanvas);
        break;
      }
      this.o.draw(paramCanvas);
      break;
      label373:
      this.p.draw(paramCanvas);
      break label282;
      label384:
      paramCanvas.drawRect(this.j, this.A);
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.D != null) {
      this.D.a();
    }
    for (;;)
    {
      return true;
      this.E.a(this, this.y, this.z);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.z == null) || (!this.z.a()))
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    setMeasuredDimension(a(paramInt1), b(paramInt2));
  }
  
  public void refreshDrawableState()
  {
    super.refreshDrawableState();
    if (this.D != null) {
      this.D.refreshDrawableState();
    }
  }
  
  public void setIsOpen(com.pocket.list.widget.b.a.c paramc)
  {
    this.D = paramc;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/widget/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */