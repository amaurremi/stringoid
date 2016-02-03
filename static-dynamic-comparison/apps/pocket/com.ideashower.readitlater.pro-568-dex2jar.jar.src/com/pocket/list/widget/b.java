package com.pocket.list.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.util.q;
import com.ideashower.readitlater.util.z;
import com.ideashower.readitlater.views.ThemedListView;
import com.pocket.list.adapter.f;
import com.pocket.widget.m;

public class b
  extends ThemedListView
  implements AbsListView.OnScrollListener, f
{
  public static final int[] b = { 2130772021 };
  private final int c;
  private final Point d;
  private final int e;
  private final Point f;
  private final Point g;
  private final com.pocket.list.adapter.a.a h;
  private com.ideashower.readitlater.objects.i i;
  private com.ideashower.readitlater.objects.i j;
  private com.ideashower.readitlater.objects.i k;
  private com.ideashower.readitlater.objects.i l;
  private c m;
  private boolean n;
  private com.pocket.list.adapter.a o;
  private final PointF p;
  private boolean q;
  private boolean r;
  private int s;
  private View t;
  private LinearLayout u;
  private LinearLayout v;
  
  public b(Context paramContext)
  {
    super(paramContext);
    if (j.c()) {}
    for (int i1 = 6;; i1 = 3)
    {
      this.c = i1;
      this.d = new Point(j.a(this.c), j.a(this.c));
      this.e = this.d.x;
      this.f = new Point(this.e, this.e);
      this.g = new Point(this.e, this.e);
      this.h = new com.pocket.list.adapter.a.a(this);
      this.p = new PointF();
      b();
      return;
    }
  }
  
  private int a(com.ideashower.readitlater.objects.i parami)
  {
    if (this.n) {
      return parami.a;
    }
    return parami.b;
  }
  
  private com.ideashower.readitlater.objects.i a(float paramFloat, int paramInt)
  {
    com.ideashower.readitlater.objects.i locali = new com.ideashower.readitlater.objects.i();
    locali.a = ((int)Math.floor((paramFloat - this.e * 2 - this.d.x * 2 * paramInt) / paramInt));
    locali.b = (locali.a * 2 + this.d.x * 2);
    return locali;
  }
  
  private void a(Point paramPoint, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = paramInt3 - (this.d.x * 2 + paramInt1) * paramInt2;
    paramInt1 = paramInt2 % 2;
    paramInt2 = (paramInt2 - paramInt1) / 2;
    paramPoint.x = paramInt2;
    paramPoint.y = (paramInt2 + paramInt1);
  }
  
  private void b()
  {
    int i2 = 3;
    setBackgroundResource(2130837780);
    setCacheColorHint(0);
    setVerticalFadingEdgeEnabled(false);
    setSelector(new ColorDrawable(0));
    Object localObject = q.b((Activity)getContext());
    this.i = new com.ideashower.readitlater.objects.i(((q)localObject).a(false), ((q)localObject).b(false));
    int i1;
    if (j.d())
    {
      i1 = 3;
      if (!j.d()) {
        break label438;
      }
    }
    for (;;)
    {
      this.j = new com.ideashower.readitlater.objects.i(i1, i2);
      com.ideashower.readitlater.objects.i locali1 = a(this.i.b, this.j.b);
      com.ideashower.readitlater.objects.i locali2 = a(this.i.a, this.j.a);
      this.k = new com.ideashower.readitlater.objects.i(locali2.a, locali1.a);
      this.l = new com.ideashower.readitlater.objects.i(locali2.b, locali1.b);
      a(this.f, this.k.a, this.j.a, ((q)localObject).a(false));
      a(this.g, this.k.b, this.j.b, ((q)localObject).b(false));
      this.m = new c(getContext());
      setVerticalScrollBarEnabled(false);
      setDivider(new com.pocket.i.a.a(getContext(), 2131165765));
      super.setOnScrollListener(this);
      this.s = ViewConfiguration.get(getContext()).getScaledTouchSlop();
      this.o = new com.pocket.list.adapter.a(this);
      this.u = new LinearLayout(getContext());
      this.u.setOrientation(1);
      this.u.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      this.v = new LinearLayout(getContext());
      this.v.setOrientation(1);
      this.v.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      localObject = new com.a.a.a.a();
      ((com.a.a.a.a)localObject).a(this.u);
      ((com.a.a.a.a)localObject).a(this.o);
      ((com.a.a.a.a)localObject).a(this.v);
      setAdapter((ListAdapter)localObject);
      c();
      e();
      d();
      this.o.a(this);
      return;
      i1 = 2;
      break;
      label438:
      i2 = 4;
    }
  }
  
  private void c()
  {
    m localm = new m(getContext(), this);
    addHeaderView(localm);
    this.o.a(localm);
  }
  
  private void d()
  {
    final View localView = LayoutInflater.from(getContext()).inflate(2130903152, this, false);
    addFooterView(localView);
    z.c(localView, false);
    this.o.a(new com.pocket.list.adapter.i()
    {
      public void a(boolean paramAnonymousBoolean)
      {
        z.c(localView, paramAnonymousBoolean);
      }
    });
  }
  
  private void e()
  {
    final View localView = new View(getContext());
    addFooterView(localView);
    this.o.a(new f()
    {
      public void a(com.pocket.list.adapter.a paramAnonymousa)
      {
        View localView = localView;
        if (!paramAnonymousa.e()) {}
        for (boolean bool = true;; bool = false)
        {
          z.c(localView, bool);
          return;
        }
      }
    });
  }
  
  public void a(com.pocket.list.adapter.a parama)
  {
    if (parama.e()) {
      setDividerHeight(0);
    }
    for (;;)
    {
      refreshDrawableState();
      invalidate();
      return;
      setDividerHeight(1);
    }
  }
  
  public final void addFooterView(View paramView)
  {
    this.v.addView(paramView);
  }
  
  public final void addHeaderView(View paramView)
  {
    this.u.addView(paramView);
  }
  
  protected int computeVerticalScrollRange()
  {
    if (this.o != null) {
      return (int)(super.computeVerticalScrollRange() * this.o.i());
    }
    return super.computeVerticalScrollRange();
  }
  
  public com.pocket.list.adapter.a.a getCellLayouts()
  {
    return this.h;
  }
  
  public int getDoubleSpaceWidth()
  {
    return a(this.l);
  }
  
  public int getDoubleTileWidthMax()
  {
    return this.l.b;
  }
  
  public int getDoubleTileWidthMin()
  {
    return this.l.a;
  }
  
  public c getDrawCache()
  {
    return this.m;
  }
  
  public int getGutterLeft()
  {
    if (!this.o.e()) {
      return 0;
    }
    return getTiledGutterLeft();
  }
  
  public int getGutterRight()
  {
    if (!this.o.e()) {
      return 0;
    }
    return getTiledGutterRight();
  }
  
  public int getNumHeaderRows()
  {
    return 1;
  }
  
  public com.pocket.list.adapter.a getPocketAdapter()
  {
    return this.o;
  }
  
  public int getRowHeight()
  {
    if (j.c()) {
      return j.a(286.0F);
    }
    return j.a(176.0F);
  }
  
  public int getRowWidth()
  {
    return a(this.i);
  }
  
  public int getSingleSpaceWidth()
  {
    return a(this.k);
  }
  
  public int getSingleTileWidthMax()
  {
    return this.k.b;
  }
  
  public int getSingleTileWidthMin()
  {
    return this.k.a;
  }
  
  public int getSpacesPerRow()
  {
    return a(this.j);
  }
  
  public Point getTileSpacing()
  {
    return this.d;
  }
  
  public int getTileSpacingX()
  {
    return this.d.x;
  }
  
  public int getTileSpacingY()
  {
    return this.d.y;
  }
  
  public int getTiledGutterLeft()
  {
    if (this.n) {
      return this.f.x;
    }
    return this.g.x;
  }
  
  public int getTiledGutterRight()
  {
    if (this.n) {
      return this.f.y;
    }
    return this.g.y;
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if ((this.o != null) && (this.o.e())) {
      mergeDrawableStates(arrayOfInt, b);
    }
    return arrayOfInt;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    switch (paramMotionEvent.getAction())
    {
    }
    while (this.r)
    {
      return false;
      if (z.b(this, paramMotionEvent.getRawX(), paramMotionEvent.getRawY()) == this.t) {}
      for (;;)
      {
        this.q = bool;
        this.r = false;
        if (!this.q) {
          break;
        }
        this.p.x = paramMotionEvent.getX();
        this.p.y = paramMotionEvent.getY();
        break;
        bool = false;
      }
      if ((this.q) && (!this.r))
      {
        float f1 = Math.abs(this.p.x - paramMotionEvent.getX());
        float f2 = Math.abs(this.p.y - paramMotionEvent.getY());
        if ((f1 >= this.s) && (f1 > f2))
        {
          this.r = true;
          continue;
          this.r = false;
          this.q = false;
          return false;
        }
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.o != null) {
      this.o.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0) {
      com.pocket.list.widget.b.a.c.b();
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 == this.i.a) {}
    for (boolean bool = true;; bool = false)
    {
      this.n = bool;
      if (paramInt1 != paramInt3) {
        this.h.a();
      }
      if (this.o != null) {
        this.o.g();
      }
      return;
    }
  }
  
  public void refreshDrawableState()
  {
    super.refreshDrawableState();
    if (this.o != null) {
      this.o.f();
    }
  }
  
  public void setCarousel(View paramView)
  {
    this.t = paramView;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/widget/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */