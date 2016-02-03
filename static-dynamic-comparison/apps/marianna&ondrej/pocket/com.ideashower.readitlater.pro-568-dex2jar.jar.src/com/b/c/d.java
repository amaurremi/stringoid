package com.b.c;

import android.view.View;
import android.view.animation.Interpolator;
import com.b.a.a;
import com.b.a.b;
import com.b.a.p;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class d
  extends c
{
  ArrayList a = new ArrayList();
  private final WeakReference b;
  private long c;
  private boolean d = false;
  private long e = 0L;
  private boolean f = false;
  private Interpolator g;
  private boolean h = false;
  private b i = null;
  private e j = new e(this, null);
  private Runnable k = new Runnable()
  {
    public void run()
    {
      d.a(d.this);
    }
  };
  private HashMap l = new HashMap();
  
  d(View paramView)
  {
    this.b = new WeakReference(paramView);
  }
  
  private float a(int paramInt)
  {
    View localView = (View)this.b.get();
    if (localView != null) {}
    switch (paramInt)
    {
    default: 
      return 0.0F;
    case 1: 
      return localView.getTranslationX();
    case 2: 
      return localView.getTranslationY();
    case 16: 
      return localView.getRotation();
    case 32: 
      return localView.getRotationX();
    case 64: 
      return localView.getRotationY();
    case 4: 
      return localView.getScaleX();
    case 8: 
      return localView.getScaleY();
    case 128: 
      return localView.getX();
    case 256: 
      return localView.getY();
    }
    return localView.getAlpha();
  }
  
  private void a(int paramInt, float paramFloat)
  {
    float f1 = a(paramInt);
    a(paramInt, f1, paramFloat - f1);
  }
  
  private void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    Object localObject;
    if (this.l.size() > 0)
    {
      Iterator localIterator = this.l.keySet().iterator();
      g localg;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (a)localIterator.next();
        localg = (g)this.l.get(localObject);
      } while ((!localg.a(paramInt)) || (localg.a != 0));
    }
    for (;;)
    {
      if (localObject != null) {
        ((a)localObject).b();
      }
      localObject = new f(paramInt, paramFloat1, paramFloat2);
      this.a.add(localObject);
      localObject = (View)this.b.get();
      if (localObject != null)
      {
        ((View)localObject).removeCallbacks(this.k);
        ((View)localObject).post(this.k);
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
    int i1 = localArrayList.size();
    int m = 0;
    int n = 0;
    while (m < i1)
    {
      n |= ((f)localArrayList.get(m)).a;
      m += 1;
    }
    this.l.put(localp, new g(n, localArrayList));
    localp.a(this.j);
    localp.a(this.j);
    if (this.f) {
      localp.c(this.e);
    }
    if (this.d) {
      localp.a(this.c);
    }
    if (this.h) {
      localp.a(this.g);
    }
    localp.a();
  }
  
  private void b(int paramInt, float paramFloat)
  {
    a(paramInt, a(paramInt), paramFloat);
  }
  
  private void c(int paramInt, float paramFloat)
  {
    View localView = (View)this.b.get();
    if (localView != null) {}
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      localView.setTranslationX(paramFloat);
      return;
    case 2: 
      localView.setTranslationY(paramFloat);
      return;
    case 16: 
      localView.setRotation(paramFloat);
      return;
    case 32: 
      localView.setRotationX(paramFloat);
      return;
    case 64: 
      localView.setRotationY(paramFloat);
      return;
    case 4: 
      localView.setScaleX(paramFloat);
      return;
    case 8: 
      localView.setScaleY(paramFloat);
      return;
    case 128: 
      localView.setX(paramFloat);
      return;
    case 256: 
      localView.setY(paramFloat);
      return;
    }
    localView.setAlpha(paramFloat);
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
    this.d = true;
    this.c = paramLong;
    return this;
  }
  
  public c a(Interpolator paramInterpolator)
  {
    this.h = true;
    this.g = paramInterpolator;
    return this;
  }
  
  public c a(b paramb)
  {
    this.i = paramb;
    return this;
  }
  
  public void a()
  {
    if (this.l.size() > 0)
    {
      localObject = ((HashMap)this.l.clone()).keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((a)((Iterator)localObject).next()).b();
      }
    }
    this.a.clear();
    Object localObject = (View)this.b.get();
    if (localObject != null) {
      ((View)localObject).removeCallbacks(this.k);
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
    this.f = true;
    this.e = paramLong;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/b/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */