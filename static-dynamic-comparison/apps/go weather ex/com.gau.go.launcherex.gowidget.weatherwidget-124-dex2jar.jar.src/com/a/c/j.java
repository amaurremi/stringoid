package com.a.c;

import android.view.View;
import android.view.animation.Interpolator;
import com.a.a.an;
import com.a.a.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class j
  extends c
{
  ArrayList a = new ArrayList();
  private final com.a.c.a.a b;
  private final WeakReference c;
  private long d;
  private boolean e = false;
  private long f = 0L;
  private boolean g = false;
  private Interpolator h;
  private boolean i = false;
  private b j = null;
  private l k = new l(this, null);
  private Runnable l = new k(this);
  private HashMap m = new HashMap();
  
  j(View paramView)
  {
    this.c = new WeakReference(paramView);
    this.b = com.a.c.a.a.a(paramView);
  }
  
  private float a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0.0F;
    case 1: 
      return this.b.k();
    case 2: 
      return this.b.l();
    case 16: 
      return this.b.d();
    case 32: 
      return this.b.e();
    case 64: 
      return this.b.f();
    case 4: 
      return this.b.g();
    case 8: 
      return this.b.h();
    case 128: 
      return this.b.m();
    case 256: 
      return this.b.n();
    }
    return this.b.a();
  }
  
  private void a(int paramInt, float paramFloat)
  {
    float f1 = a(paramInt);
    a(paramInt, f1, paramFloat - f1);
  }
  
  private void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    Object localObject;
    if (this.m.size() > 0)
    {
      Iterator localIterator = this.m.keySet().iterator();
      n localn;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (com.a.a.a)localIterator.next();
        localn = (n)this.m.get(localObject);
      } while ((!localn.a(paramInt)) || (localn.a != 0));
    }
    for (;;)
    {
      if (localObject != null) {
        ((com.a.a.a)localObject).b();
      }
      localObject = new m(paramInt, paramFloat1, paramFloat2);
      this.a.add(localObject);
      localObject = (View)this.c.get();
      if (localObject != null)
      {
        ((View)localObject).removeCallbacks(this.l);
        ((View)localObject).post(this.l);
      }
      return;
      localObject = null;
    }
  }
  
  private void b()
  {
    an localan = an.b(new float[] { 1.0F });
    ArrayList localArrayList = (ArrayList)this.a.clone();
    this.a.clear();
    int i2 = localArrayList.size();
    int n = 0;
    int i1 = 0;
    while (n < i2)
    {
      i1 |= ((m)localArrayList.get(n)).a;
      n += 1;
    }
    this.m.put(localan, new n(i1, localArrayList));
    localan.a(this.k);
    localan.a(this.k);
    if (this.g) {
      localan.e(this.f);
    }
    if (this.e) {
      localan.c(this.d);
    }
    if (this.i) {
      localan.a(this.h);
    }
    localan.a();
  }
  
  private void b(int paramInt, float paramFloat)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.b.i(paramFloat);
      return;
    case 2: 
      this.b.j(paramFloat);
      return;
    case 16: 
      this.b.d(paramFloat);
      return;
    case 32: 
      this.b.e(paramFloat);
      return;
    case 64: 
      this.b.f(paramFloat);
      return;
    case 4: 
      this.b.g(paramFloat);
      return;
    case 8: 
      this.b.h(paramFloat);
      return;
    case 128: 
      this.b.k(paramFloat);
      return;
    case 256: 
      this.b.l(paramFloat);
      return;
    }
    this.b.a(paramFloat);
  }
  
  public c a(float paramFloat)
  {
    a(4, paramFloat);
    return this;
  }
  
  public c a(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("Animators cannot have negative duration: " + paramLong);
    }
    this.e = true;
    this.d = paramLong;
    return this;
  }
  
  public void a()
  {
    b();
  }
  
  public c b(float paramFloat)
  {
    a(8, paramFloat);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/a/c/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */