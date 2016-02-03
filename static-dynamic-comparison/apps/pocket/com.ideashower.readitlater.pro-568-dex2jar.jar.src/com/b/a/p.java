package com.b.a;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class p
  extends a
{
  private static ThreadLocal h = new ThreadLocal();
  private static final ThreadLocal i = new ThreadLocal()
  {
    protected ArrayList a()
    {
      return new ArrayList();
    }
  };
  private static final ThreadLocal j = new ThreadLocal()
  {
    protected ArrayList a()
    {
      return new ArrayList();
    }
  };
  private static final ThreadLocal k = new ThreadLocal()
  {
    protected ArrayList a()
    {
      return new ArrayList();
    }
  };
  private static final ThreadLocal l = new ThreadLocal()
  {
    protected ArrayList a()
    {
      return new ArrayList();
    }
  };
  private static final ThreadLocal m = new ThreadLocal()
  {
    protected ArrayList a()
    {
      return new ArrayList();
    }
  };
  private static final Interpolator n = new AccelerateDecelerateInterpolator();
  private static final o o = new f();
  private static final o p = new d();
  private static long z = 10L;
  private int A = 0;
  private int B = 1;
  private Interpolator C = n;
  private ArrayList D = null;
  long b;
  long c = -1L;
  int d = 0;
  boolean e = false;
  l[] f;
  HashMap g;
  private boolean q = false;
  private int r = 0;
  private float s = 0.0F;
  private boolean t = false;
  private long u;
  private boolean v = false;
  private boolean w = false;
  private long x = 300L;
  private long y = 0L;
  
  public static p a(float... paramVarArgs)
  {
    p localp = new p();
    localp.b(paramVarArgs);
    return localp;
  }
  
  public static p a(int... paramVarArgs)
  {
    p localp = new p();
    localp.b(paramVarArgs);
    return localp;
  }
  
  private void a(boolean paramBoolean)
  {
    if (Looper.myLooper() == null) {
      throw new AndroidRuntimeException("Animators may only be run on Looper threads");
    }
    this.q = paramBoolean;
    this.r = 0;
    this.d = 0;
    this.w = true;
    this.t = false;
    ((ArrayList)j.get()).add(this);
    if (this.y == 0L)
    {
      b(e());
      this.d = 0;
      this.v = true;
      if (this.a != null)
      {
        localObject = (ArrayList)this.a.clone();
        int i2 = ((ArrayList)localObject).size();
        int i1 = 0;
        while (i1 < i2)
        {
          ((b)((ArrayList)localObject).get(i1)).b(this);
          i1 += 1;
        }
      }
    }
    q localq = (q)h.get();
    Object localObject = localq;
    if (localq == null)
    {
      localObject = new q(null);
      h.set(localObject);
    }
    ((q)localObject).sendEmptyMessage(0);
  }
  
  private boolean e(long paramLong)
  {
    if (!this.t)
    {
      this.t = true;
      this.u = paramLong;
    }
    long l1;
    do
    {
      return false;
      l1 = paramLong - this.u;
    } while (l1 <= this.y);
    this.b = (paramLong - (l1 - this.y));
    this.d = 1;
    return true;
  }
  
  private void p()
  {
    ((ArrayList)i.get()).remove(this);
    ((ArrayList)j.get()).remove(this);
    ((ArrayList)k.get()).remove(this);
    this.d = 0;
    if ((this.v) && (this.a != null))
    {
      ArrayList localArrayList = (ArrayList)this.a.clone();
      int i2 = localArrayList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        ((b)localArrayList.get(i1)).a(this);
        i1 += 1;
      }
    }
    this.v = false;
    this.w = false;
  }
  
  private void q()
  {
    d();
    ((ArrayList)i.get()).add(this);
    if ((this.y > 0L) && (this.a != null))
    {
      ArrayList localArrayList = (ArrayList)this.a.clone();
      int i2 = localArrayList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        ((b)localArrayList.get(i1)).b(this);
        i1 += 1;
      }
    }
  }
  
  public p a(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("Animators cannot have negative duration: " + paramLong);
    }
    this.x = paramLong;
    return this;
  }
  
  public void a()
  {
    a(false);
  }
  
  void a(float paramFloat)
  {
    paramFloat = this.C.getInterpolation(paramFloat);
    this.s = paramFloat;
    int i2 = this.f.length;
    int i1 = 0;
    while (i1 < i2)
    {
      this.f[i1].a(paramFloat);
      i1 += 1;
    }
    if (this.D != null)
    {
      i2 = this.D.size();
      i1 = 0;
      while (i1 < i2)
      {
        ((r)this.D.get(i1)).a(this);
        i1 += 1;
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.A = paramInt;
  }
  
  public void a(Interpolator paramInterpolator)
  {
    if (paramInterpolator != null)
    {
      this.C = paramInterpolator;
      return;
    }
    this.C = new LinearInterpolator();
  }
  
  public void a(r paramr)
  {
    if (this.D == null) {
      this.D = new ArrayList();
    }
    this.D.add(paramr);
  }
  
  public void a(l... paramVarArgs)
  {
    int i2 = paramVarArgs.length;
    this.f = paramVarArgs;
    this.g = new HashMap(i2);
    int i1 = 0;
    while (i1 < i2)
    {
      l locall = paramVarArgs[i1];
      this.g.put(locall.c(), locall);
      i1 += 1;
    }
    this.e = false;
  }
  
  public void b()
  {
    if ((this.d != 0) || (((ArrayList)j.get()).contains(this)) || (((ArrayList)k.get()).contains(this)))
    {
      if ((this.v) && (this.a != null))
      {
        Iterator localIterator = ((ArrayList)this.a.clone()).iterator();
        while (localIterator.hasNext()) {
          ((b)localIterator.next()).d(this);
        }
      }
      p();
    }
  }
  
  public void b(int paramInt)
  {
    this.B = paramInt;
  }
  
  public void b(long paramLong)
  {
    d();
    long l1 = AnimationUtils.currentAnimationTimeMillis();
    if (this.d != 1)
    {
      this.c = paramLong;
      this.d = 2;
    }
    this.b = (l1 - paramLong);
    d(l1);
  }
  
  public void b(float... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return;
    }
    if ((this.f == null) || (this.f.length == 0)) {
      a(new l[] { l.a("", paramVarArgs) });
    }
    for (;;)
    {
      this.e = false;
      return;
      this.f[0].a(paramVarArgs);
    }
  }
  
  public void b(int... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return;
    }
    if ((this.f == null) || (this.f.length == 0)) {
      a(new l[] { l.a("", paramVarArgs) });
    }
    for (;;)
    {
      this.e = false;
      return;
      this.f[0].a(paramVarArgs);
    }
  }
  
  public void c(long paramLong)
  {
    this.y = paramLong;
  }
  
  void d()
  {
    if (!this.e)
    {
      int i2 = this.f.length;
      int i1 = 0;
      while (i1 < i2)
      {
        this.f[i1].b();
        i1 += 1;
      }
      this.e = true;
    }
  }
  
  boolean d(long paramLong)
  {
    boolean bool2 = false;
    if (this.d == 0)
    {
      this.d = 1;
      if (this.c >= 0L) {
        break label58;
      }
      this.b = paramLong;
    }
    for (;;)
    {
      switch (this.d)
      {
      default: 
        return false;
        label58:
        this.b = (paramLong - this.c);
        this.c = -1L;
      }
    }
    float f1;
    if (this.x > 0L) {
      f1 = (float)(paramLong - this.b) / (float)this.x;
    }
    boolean bool1;
    for (;;)
    {
      if (f1 >= 1.0F) {
        if ((this.r < this.A) || (this.A == -1))
        {
          if (this.a != null)
          {
            int i2 = this.a.size();
            int i1 = 0;
            for (;;)
            {
              if (i1 < i2)
              {
                ((b)this.a.get(i1)).c(this);
                i1 += 1;
                continue;
                f1 = 1.0F;
                break;
              }
            }
          }
          if (this.B == 2)
          {
            if (this.q)
            {
              bool1 = false;
              this.q = bool1;
            }
          }
          else
          {
            this.r += (int)f1;
            f1 %= 1.0F;
            this.b += this.x;
            bool1 = bool2;
          }
        }
      }
    }
    for (;;)
    {
      float f2 = f1;
      if (this.q) {
        f2 = 1.0F - f1;
      }
      a(f2);
      return bool1;
      bool1 = true;
      break;
      f1 = Math.min(f1, 1.0F);
      bool1 = true;
      continue;
      bool1 = bool2;
    }
  }
  
  public long e()
  {
    if ((!this.e) || (this.d == 0)) {
      return 0L;
    }
    return AnimationUtils.currentAnimationTimeMillis() - this.b;
  }
  
  public Object f()
  {
    if ((this.f != null) && (this.f.length > 0)) {
      return this.f[0].d();
    }
    return null;
  }
  
  public void g()
  {
    if (this.D == null) {
      return;
    }
    this.D.clear();
    this.D = null;
  }
  
  public float h()
  {
    return this.s;
  }
  
  public p i()
  {
    int i2 = 0;
    p localp = (p)super.c();
    int i3;
    int i1;
    if (this.D != null)
    {
      localObject = this.D;
      localp.D = new ArrayList();
      i3 = ((ArrayList)localObject).size();
      i1 = 0;
      while (i1 < i3)
      {
        localp.D.add(((ArrayList)localObject).get(i1));
        i1 += 1;
      }
    }
    localp.c = -1L;
    localp.q = false;
    localp.r = 0;
    localp.e = false;
    localp.d = 0;
    localp.t = false;
    Object localObject = this.f;
    if (localObject != null)
    {
      i3 = localObject.length;
      localp.f = new l[i3];
      localp.g = new HashMap(i3);
      i1 = i2;
      while (i1 < i3)
      {
        l locall = localObject[i1].a();
        localp.f[i1] = locall;
        localp.g.put(locall.c(), locall);
        i1 += 1;
      }
    }
    return localp;
  }
  
  public String toString()
  {
    String str1 = "ValueAnimator@" + Integer.toHexString(hashCode());
    String str2 = str1;
    if (this.f != null)
    {
      int i1 = 0;
      for (;;)
      {
        str2 = str1;
        if (i1 >= this.f.length) {
          break;
        }
        str1 = str1 + "\n    " + this.f[i1].toString();
        i1 += 1;
      }
    }
    return str2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/b/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */