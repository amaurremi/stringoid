package com.b.c;

import android.view.View;
import android.view.animation.Interpolator;
import com.b.a.b;
import com.b.a.p;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class i
  extends c
{
  ArrayList a = new ArrayList();
  private final com.b.c.a.a b;
  private final WeakReference c;
  private long d;
  private boolean e = false;
  private long f = 0L;
  private boolean g = false;
  private Interpolator h;
  private boolean i = false;
  private b j = null;
  private j k = new j(this, null);
  private Runnable l = new Runnable()
  {
    public void run()
    {
      i.a(i.this);
    }
  };
  private HashMap m = new HashMap();
  
  i(View paramView)
  {
    this.c = new WeakReference(paramView);
    this.b = com.b.c.a.a.a(paramView);
  }
  
  private float a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0.0F;
    case 1: 
      return this.b.g();
    case 2: 
      return this.b.h();
    case 16: 
      return this.b.b();
    case 32: 
      return this.b.c();
    case 64: 
      return this.b.d();
    case 4: 
      return this.b.e();
    case 8: 
      return this.b.f();
    case 128: 
      return this.b.i();
    case 256: 
      return this.b.j();
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
      l locall;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (com.b.a.a)localIterator.next();
        locall = (l)this.m.get(localObject);
      } while ((!locall.a(paramInt)) || (locall.a != 0));
    }
    for (;;)
    {
      if (localObject != null) {
        ((com.b.a.a)localObject).b();
      }
      localObject = new k(paramInt, paramFloat1, paramFloat2);
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
    p localp = p.a(new float[] { 1.0F });
    ArrayList localArrayList = (ArrayList)this.a.clone();
    this.a.clear();
    int i2 = localArrayList.size();
    int n = 0;
    int i1 = 0;
    while (n < i2)
    {
      i1 |= ((k)localArrayList.get(n)).a;
      n += 1;
    }
    this.m.put(localp, new l(i1, localArrayList));
    localp.a(this.k);
    localp.a(this.k);
    if (this.g) {
      localp.c(this.f);
    }
    if (this.e) {
      localp.a(this.d);
    }
    if (this.i) {
      localp.a(this.h);
    }
    localp.a();
  }
  
  private void b(int paramInt, float paramFloat)
  {
    a(paramInt, a(paramInt), paramFloat);
  }
  
  private void c(int paramInt, float paramFloat)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.b.g(paramFloat);
      return;
    case 2: 
      this.b.h(paramFloat);
      return;
    case 16: 
      this.b.b(paramFloat);
      return;
    case 32: 
      this.b.c(paramFloat);
      return;
    case 64: 
      this.b.d(paramFloat);
      return;
    case 4: 
      this.b.e(paramFloat);
      return;
    case 8: 
      this.b.f(paramFloat);
      return;
    case 128: 
      this.b.i(paramFloat);
      return;
    case 256: 
      this.b.j(paramFloat);
      return;
    }
    this.b.a(paramFloat);
  }
  
  public c a(float paramFloat)
  {
    a(128, paramFloat);
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
  
  public c a(Interpolator paramInterpolator)
  {
    this.i = true;
    this.h = paramInterpolator;
    return this;
  }
  
  public c a(b paramb)
  {
    this.j = paramb;
    return this;
  }
  
  public void a()
  {
    if (this.m.size() > 0)
    {
      localObject = ((HashMap)this.m.clone()).keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.b.a.a)((Iterator)localObject).next()).b();
      }
    }
    this.a.clear();
    Object localObject = (View)this.c.get();
    if (localObject != null) {
      ((View)localObject).removeCallbacks(this.l);
    }
  }
  
  public c b(float paramFloat)
  {
    b(128, paramFloat);
    return this;
  }
  
  public c b(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("Animators cannot have negative duration: " + paramLong);
    }
    this.g = true;
    this.f = paramLong;
    return this;
  }
  
  public c c(float paramFloat)
  {
    a(256, paramFloat);
    return this;
  }
  
  public c d(float paramFloat)
  {
    b(256, paramFloat);
    return this;
  }
  
  public c e(float paramFloat)
  {
    a(1, paramFloat);
    return this;
  }
  
  public c f(float paramFloat)
  {
    a(2, paramFloat);
    return this;
  }
  
  public c g(float paramFloat)
  {
    a(4, paramFloat);
    return this;
  }
  
  public c h(float paramFloat)
  {
    b(4, paramFloat);
    return this;
  }
  
  public c i(float paramFloat)
  {
    a(8, paramFloat);
    return this;
  }
  
  public c j(float paramFloat)
  {
    b(8, paramFloat);
    return this;
  }
  
  public c k(float paramFloat)
  {
    a(512, paramFloat);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/b/c/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */