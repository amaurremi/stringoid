package com.vungle.publisher;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class m
  extends a
{
  private static ThreadLocal<a> b = new ThreadLocal();
  private static final ThreadLocal<ArrayList<m>> k = new ThreadLocal() {};
  private static final ThreadLocal<ArrayList<m>> l = new ThreadLocal() {};
  private static final ThreadLocal<ArrayList<m>> m = new ThreadLocal() {};
  private static final ThreadLocal<ArrayList<m>> n = new ThreadLocal() {};
  private static final ThreadLocal<ArrayList<m>> o = new ThreadLocal() {};
  private static final Interpolator p = new AccelerateDecelerateInterpolator();
  private static final l q = new e();
  private static final l r = new c();
  private static long z = 10L;
  private int A = 0;
  private int B = 1;
  private Interpolator C = p;
  private ArrayList D = null;
  long c;
  long d = -1L;
  public float e = 0.0F;
  int f = 0;
  public boolean g = false;
  public long h = 300L;
  public k[] i;
  HashMap<String, k> j;
  private boolean s = false;
  private int t = 0;
  private boolean u = false;
  private long v;
  private boolean w = false;
  private boolean x = false;
  private long y = 0L;
  
  private void m()
  {
    ((ArrayList)k.get()).remove(this);
    ((ArrayList)l.get()).remove(this);
    ((ArrayList)m.get()).remove(this);
    this.f = 0;
    if ((this.w) && (this.a != null))
    {
      ArrayList localArrayList = (ArrayList)this.a.clone();
      int i2 = localArrayList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        localArrayList.get(i1);
        i1 += 1;
      }
    }
    this.w = false;
    this.x = false;
  }
  
  public void a()
  {
    if (Looper.myLooper() == null) {
      throw new AndroidRuntimeException("Animators may only be run on Looper threads");
    }
    this.s = false;
    this.t = 0;
    this.f = 0;
    this.x = true;
    this.u = false;
    ((ArrayList)l.get()).add(this);
    if (this.y == 0L)
    {
      if ((!this.g) || (this.f == 0)) {}
      for (long l1 = 0L;; l1 = AnimationUtils.currentAnimationTimeMillis() - this.c)
      {
        c(l1);
        this.f = 0;
        this.w = true;
        if (this.a == null) {
          break;
        }
        localObject = (ArrayList)this.a.clone();
        int i2 = ((ArrayList)localObject).size();
        int i1 = 0;
        while (i1 < i2)
        {
          ((ArrayList)localObject).get(i1);
          i1 += 1;
        }
      }
    }
    a locala = (a)b.get();
    Object localObject = locala;
    if (locala == null)
    {
      localObject = new a((byte)0);
      b.set(localObject);
    }
    ((a)localObject).sendEmptyMessage(0);
  }
  
  void a(float paramFloat)
  {
    int i2 = 0;
    paramFloat = this.C.getInterpolation(paramFloat);
    this.e = paramFloat;
    int i3 = this.i.length;
    int i1 = 0;
    while (i1 < i3)
    {
      this.i[i1].a(paramFloat);
      i1 += 1;
    }
    if (this.D != null)
    {
      i3 = this.D.size();
      i1 = i2;
      while (i1 < i3)
      {
        this.D.get(i1);
        i1 += 1;
      }
    }
  }
  
  public void a(float... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return;
    }
    if ((this.i == null) || (this.i.length == 0)) {
      a(new k[] { k.a("", paramVarArgs) });
    }
    for (;;)
    {
      this.g = false;
      return;
      this.i[0].a(paramVarArgs);
    }
  }
  
  public void a(int... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return;
    }
    if ((this.i == null) || (this.i.length == 0)) {
      a(new k[] { k.a("", paramVarArgs) });
    }
    for (;;)
    {
      this.g = false;
      return;
      this.i[0].a(paramVarArgs);
    }
  }
  
  public final void a(k... paramVarArgs)
  {
    this.i = paramVarArgs;
    this.j = new HashMap(1);
    int i1 = 0;
    while (i1 <= 0)
    {
      k localk = paramVarArgs[0];
      this.j.put(localk.a, localk);
      i1 += 1;
    }
    this.g = false;
  }
  
  public m b(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("Animators cannot have negative duration: " + paramLong);
    }
    this.h = paramLong;
    return this;
  }
  
  public final void b()
  {
    if ((this.f != 0) || (((ArrayList)l.get()).contains(this)) || (((ArrayList)m.get()).contains(this)))
    {
      if ((this.w) && (this.a != null))
      {
        Iterator localIterator = ((ArrayList)this.a.clone()).iterator();
        while (localIterator.hasNext()) {
          localIterator.next();
        }
      }
      m();
    }
  }
  
  public final void c(long paramLong)
  {
    d();
    long l1 = AnimationUtils.currentAnimationTimeMillis();
    if (this.f != 1)
    {
      this.d = paramLong;
      this.f = 2;
    }
    this.c = (l1 - paramLong);
    d(l1);
  }
  
  void d()
  {
    if (!this.g)
    {
      int i2 = this.i.length;
      int i1 = 0;
      if (i1 < i2)
      {
        k localk = this.i[i1];
        l locall;
        if (localk.j == null)
        {
          if (localk.d != Integer.class) {
            break label85;
          }
          locall = k.f;
        }
        for (;;)
        {
          localk.j = locall;
          if (localk.j != null) {
            localk.e.f = localk.j;
          }
          i1 += 1;
          break;
          label85:
          if (localk.d == Float.class) {
            locall = k.g;
          } else {
            locall = null;
          }
        }
      }
      this.g = true;
    }
  }
  
  final boolean d(long paramLong)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (this.f == 0)
    {
      this.f = 1;
      if (this.d >= 0L) {
        break label62;
      }
      this.c = paramLong;
    }
    for (;;)
    {
      switch (this.f)
      {
      default: 
        return false;
        label62:
        this.c = (paramLong - this.d);
        this.d = -1L;
      }
    }
    float f1;
    if (this.h > 0L) {
      f1 = (float)(paramLong - this.c) / (float)this.h;
    }
    for (;;)
    {
      if (f1 >= 1.0F) {
        if ((this.t < this.A) || (this.A == -1))
        {
          if (this.a != null)
          {
            int i2 = this.a.size();
            int i1 = 0;
            for (;;)
            {
              if (i1 < i2)
              {
                this.a.get(i1);
                i1 += 1;
                continue;
                f1 = 1.0F;
                break;
              }
            }
          }
          if (this.B == 2)
          {
            if (this.s) {
              bool1 = false;
            }
            this.s = bool1;
          }
          this.t += (int)f1;
          f1 %= 1.0F;
          this.c += this.h;
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      float f2 = f1;
      if (this.s) {
        f2 = 1.0F - f1;
      }
      a(f2);
      return bool1;
      f1 = Math.min(f1, 1.0F);
      bool1 = true;
      continue;
      bool1 = bool2;
    }
  }
  
  public m e()
  {
    int i2 = 0;
    m localm = (m)super.c();
    int i3;
    int i1;
    if (this.D != null)
    {
      localObject = this.D;
      localm.D = new ArrayList();
      i3 = ((ArrayList)localObject).size();
      i1 = 0;
      while (i1 < i3)
      {
        localm.D.add(((ArrayList)localObject).get(i1));
        i1 += 1;
      }
    }
    localm.d = -1L;
    localm.s = false;
    localm.t = 0;
    localm.g = false;
    localm.f = 0;
    localm.u = false;
    Object localObject = this.i;
    if (localObject != null)
    {
      i3 = localObject.length;
      localm.i = new k[i3];
      localm.j = new HashMap(i3);
      i1 = i2;
      while (i1 < i3)
      {
        k localk = localObject[i1].a();
        localm.i[i1] = localk;
        localm.j.put(localk.a, localk);
        i1 += 1;
      }
    }
    return localm;
  }
  
  public final boolean f()
  {
    return (this.f == 1) || (this.w);
  }
  
  public String toString()
  {
    String str1 = "ValueAnimator@" + Integer.toHexString(hashCode());
    String str2 = str1;
    if (this.i != null)
    {
      int i1 = 0;
      for (;;)
      {
        str2 = str1;
        if (i1 >= this.i.length) {
          break;
        }
        str1 = str1 + "\n    " + this.i[i1].toString();
        i1 += 1;
      }
    }
    return str2;
  }
  
  static final class a
    extends Handler
  {
    public final void handleMessage(Message paramMessage)
    {
      ArrayList localArrayList1 = (ArrayList)m.g().get();
      ArrayList localArrayList2 = (ArrayList)m.h().get();
      int i;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        paramMessage = (ArrayList)m.i().get();
        if ((localArrayList1.size() > 0) || (localArrayList2.size() > 0)) {
          i = 0;
        }
        break;
      }
      for (;;)
      {
        int j = i;
        Object localObject;
        int k;
        m localm;
        if (paramMessage.size() > 0)
        {
          localObject = (ArrayList)paramMessage.clone();
          paramMessage.clear();
          k = ((ArrayList)localObject).size();
          j = 0;
          if (j < k)
          {
            localm = (m)((ArrayList)localObject).get(j);
            if (m.a(localm) == 0L) {
              m.b(localm);
            }
            for (;;)
            {
              j += 1;
              break;
              localArrayList2.add(localm);
            }
            j = 1;
          }
        }
        else
        {
          long l = AnimationUtils.currentAnimationTimeMillis();
          localObject = (ArrayList)m.j().get();
          paramMessage = (ArrayList)m.k().get();
          k = localArrayList2.size();
          i = 0;
          while (i < k)
          {
            localm = (m)localArrayList2.get(i);
            if (m.a(localm, l)) {
              ((ArrayList)localObject).add(localm);
            }
            i += 1;
          }
          k = ((ArrayList)localObject).size();
          if (k > 0)
          {
            i = 0;
            while (i < k)
            {
              localm = (m)((ArrayList)localObject).get(i);
              m.b(localm);
              m.c(localm);
              localArrayList2.remove(localm);
              i += 1;
            }
            ((ArrayList)localObject).clear();
          }
          k = localArrayList1.size();
          i = 0;
          while (i < k)
          {
            localObject = (m)localArrayList1.get(i);
            if (((m)localObject).d(l)) {
              paramMessage.add(localObject);
            }
            if (localArrayList1.size() == k)
            {
              i += 1;
            }
            else
            {
              k -= 1;
              paramMessage.remove(localObject);
            }
          }
          if (paramMessage.size() > 0)
          {
            i = 0;
            while (i < paramMessage.size())
            {
              m.d((m)paramMessage.get(i));
              i += 1;
            }
            paramMessage.clear();
          }
          if ((j == 0) || ((localArrayList1.isEmpty()) && (localArrayList2.isEmpty()))) {
            break;
          }
          sendEmptyMessageDelayed(1, Math.max(0L, m.l() - (AnimationUtils.currentAnimationTimeMillis() - l)));
          return;
          i = 1;
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */