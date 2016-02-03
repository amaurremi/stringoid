package com.a.c;

import android.view.View;
import android.view.animation.Interpolator;
import com.a.a.a;
import com.a.a.an;
import com.a.a.b;
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
  private f j = new f(this, null);
  private Runnable k = new e(this);
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
      h localh;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (a)localIterator.next();
        localh = (h)this.l.get(localObject);
      } while ((!localh.a(paramInt)) || (localh.a != 0));
    }
    for (;;)
    {
      if (localObject != null) {
        ((a)localObject).b();
      }
      localObject = new g(paramInt, paramFloat1, paramFloat2);
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
    an localan = an.b(new float[] { 1.0F });
    ArrayList localArrayList = (ArrayList)this.a.clone();
    this.a.clear();
    int i1 = localArrayList.size();
    int m = 0;
    int n = 0;
    while (m < i1)
    {
      n |= ((g)localArrayList.get(m)).a;
      m += 1;
    }
    this.l.put(localan, new h(n, localArrayList));
    localan.a(this.j);
    localan.a(this.j);
    if (this.f) {
      localan.e(this.e);
    }
    if (this.d) {
      localan.c(this.c);
    }
    if (this.h) {
      localan.a(this.g);
    }
    localan.a();
  }
  
  private void b(int paramInt, float paramFloat)
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
    a(4, paramFloat);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/a/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */