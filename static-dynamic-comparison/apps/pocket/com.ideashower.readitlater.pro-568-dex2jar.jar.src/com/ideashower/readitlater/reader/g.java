package com.ideashower.readitlater.reader;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import com.ideashower.readitlater.activity.ReaderActivity;
import com.ideashower.readitlater.activity.ReaderFragment;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.e.x;
import com.ideashower.readitlater.e.y;
import com.ideashower.readitlater.h.m;
import com.ideashower.readitlater.util.e;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.ideashower.readitlater.views.v;
import com.pocket.p.p;
import com.pocket.widget.ThemedView;
import com.pocket.widget.n;
import java.util.ArrayList;
import java.util.Iterator;

public class g
  extends n
{
  private final ReaderFragment f;
  private final ListView g;
  private final h h;
  private o i;
  private com.ideashower.readitlater.views.c j;
  private int k;
  private ThemedView l;
  private View.OnClickListener m;
  private boolean n;
  private final ArrayList o = new ArrayList();
  private l p;
  private int q;
  
  public g(ReaderFragment paramReaderFragment)
  {
    super(paramReaderFragment.m(), new k(paramReaderFragment.m()), a(paramReaderFragment.m()), com.ideashower.readitlater.util.j.a(44.0F));
    this.f = paramReaderFragment;
    this.g = ((ListView)getContent());
    ((k)this.g).setDrawer(this);
    this.g.setCacheColorHint(0);
    this.g.setVerticalFadingEdgeEnabled(false);
    paramReaderFragment = new ViewGroup.LayoutParams(-1, -2);
    this.g.setLayoutParams(paramReaderFragment);
    this.h = new h(this);
    this.g.setAdapter(this.h);
    q();
  }
  
  private static int a(Activity paramActivity)
  {
    if (com.ideashower.readitlater.util.j.d()) {
      return com.ideashower.readitlater.util.j.a(333.0F);
    }
    if (com.ideashower.readitlater.util.j.e()) {
      return com.ideashower.readitlater.util.j.a(275.0F);
    }
    return com.ideashower.readitlater.util.j.a(165.0F);
  }
  
  private void a(final ArrayList paramArrayList, o paramo)
  {
    if (paramo == null) {}
    for (;;)
    {
      return;
      ArrayList localArrayList = paramo.ag();
      if (!p.a(localArrayList))
      {
        long l1 = ((y)localArrayList.get(0)).b();
        if (this.f.at().k() == l1)
        {
          if (!p.a(this.o))
          {
            paramo = localArrayList.iterator();
            while (paramo.hasNext()) {
              paramArrayList.add((y)paramo.next());
            }
          }
        }
        else
        {
          Iterator localIterator = localArrayList.iterator();
          while (localIterator.hasNext())
          {
            y localy = (y)localIterator.next();
            if (localy.n())
            {
              this.o.add(localy);
              paramArrayList.add(localy);
              this.h.b(new j(this, paramArrayList, null));
            }
            else
            {
              try
              {
                com.pocket.m.a.a(localArrayList, paramo.f(), getContext(), new com.ideashower.readitlater.g.l()
                {
                  public void a() {}
                  
                  public void a(com.ideashower.readitlater.g.k paramAnonymousk, boolean paramAnonymousBoolean)
                  {
                    y localy = ((com.pocket.m.b.k)paramAnonymousk).l();
                    if ((!paramAnonymousBoolean) || (localy == null) || (g.d(g.this) == null) || (g.d(g.this).e() != ((com.pocket.m.b.k)paramAnonymousk).m())) {
                      return;
                    }
                    paramArrayList.add(localy);
                    g.e(g.this).b(new j(g.this, paramArrayList, null));
                    g.f(g.this).add(localy);
                    g.g(g.this);
                  }
                });
                this.f.at().a(l1);
              }
              catch (NumberFormatException localNumberFormatException)
              {
                e.a(localNumberFormatException);
              }
              catch (Exception localException)
              {
                e.a(localException);
              }
            }
          }
        }
      }
    }
  }
  
  private void q()
  {
    this.g.setBackgroundResource(2130837506);
    this.j = new com.ideashower.readitlater.views.c(getResources());
    this.g.setBackgroundDrawable(new v(getResources()));
    this.g.setDividerHeight(0);
    this.m = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (g.a(g.this)) {}
        while ((g.this.g()) && ((g.b(g.this) > g.this.getDrawerTop() + g.this.getCollapsedHeight()) || (!g.c(g.this)))) {
          return;
        }
        g.this.k();
      }
    };
  }
  
  private void r()
  {
    setVisibility(0);
    setExpandable(this.h.a());
    if ((!this.n) && (!g()))
    {
      if (((!this.i.D()) && (!this.i.L())) || (this.i.aq())) {
        this.k = 2;
      }
    }
    else {
      return;
    }
    this.k = 1;
  }
  
  private boolean s()
  {
    o localo = this.i;
    if ((localo != null) && (localo.h(false))) {}
    for (ArrayList localArrayList = new ArrayList(localo.T());; localArrayList = new ArrayList())
    {
      a(localArrayList, localo);
      this.h.b(new j(this, localArrayList, null));
      if (p.a(localArrayList)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private void setExpandable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      f();
      return;
    }
    e();
  }
  
  private void t()
  {
    setVisibility(0);
    this.n = true;
    if (this.l == null)
    {
      this.l = new ThemedView(getContext());
      this.l.setBackgroundResource(2130837506);
      localObject = new RelativeLayout.LayoutParams(-1, com.ideashower.readitlater.util.j.a(25.0F));
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      this.l.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.f.aw();
      ((ViewGroup)localObject).addView(this.l, ((ViewGroup)localObject).indexOfChild(this) - 1);
    }
    this.l.setVisibility(0);
    Object localObject = new OvershootInterpolator(1.0F);
    if ((this.h.a()) && (this.k == 2)) {}
    for (boolean bool = true;; bool = false)
    {
      a(true, 1000L, (Interpolator)localObject, bool);
      this.k = 0;
      return;
    }
  }
  
  protected void a()
  {
    if (!this.f.av()) {}
    do
    {
      return;
      localObject = (ReaderActivity)this.f.m();
    } while ((((ReaderActivity)localObject).C() != 2) && (((ReaderActivity)localObject).C() != 3));
    Object localObject = h.a(this.h);
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          com.ideashower.readitlater.e.c localc = (com.ideashower.readitlater.e.c)((Iterator)localObject).next();
          if (!(localc instanceof x)) {
            break;
          }
          if (((x)localc).g() == 0) {
            return;
          }
        }
      }
    }
    this.f.P();
  }
  
  public boolean b()
  {
    return getVisibility() != 8;
  }
  
  protected void c()
  {
    if (this.l != null) {
      this.l.setVisibility(8);
    }
    super.c();
  }
  
  protected void d()
  {
    if (this.l != null) {
      this.l.setVisibility(8);
    }
    super.d();
  }
  
  protected int getBottomLocation()
  {
    return super.getBottomLocation() - this.q;
  }
  
  public int getCollapsedHeight()
  {
    return getHeight() - getBottomLocation();
  }
  
  protected int getDrawerTop()
  {
    return super.getDrawerTop() - this.q;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 2);
    mergeDrawableStates(arrayOfInt, m.b(this));
    StyledToolbar.a(this, arrayOfInt);
    return arrayOfInt;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((com.ideashower.readitlater.util.a.d()) && ((getVisibility() != 0) || (j()))) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.k != 0) && (!this.h.isEmpty()) && (this.g.getHeight() > 0) && (this.g.getChildCount() > 0) && (this.g.getChildAt(0).getMeasuredHeight() > 0)) {
      t();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((com.ideashower.readitlater.util.a.d()) && ((getVisibility() != 0) || (j()))) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBottomSystemWindowInset(int paramInt)
  {
    this.q = paramInt;
    requestLayout();
    invalidate();
  }
  
  public void setItem(o paramo)
  {
    this.i = paramo;
    int i1 = 0;
    if (s()) {
      i1 = 1;
    }
    if (i1 != 0)
    {
      r();
      return;
    }
    setVisibility(8);
  }
  
  public void setOnVisibilityChangedListener(l paraml)
  {
    this.p = paraml;
  }
  
  public void setVisibility(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if (getVisibility() == 0)
    {
      bool1 = true;
      if (this.h.isEmpty()) {
        paramInt = 8;
      }
      super.setVisibility(paramInt);
      if (getVisibility() != 0) {
        break label65;
      }
    }
    for (;;)
    {
      if ((this.p != null) && (bool2 != bool1)) {
        this.p.a(this, bool2);
      }
      return;
      bool1 = false;
      break;
      label65:
      bool2 = false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/reader/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */