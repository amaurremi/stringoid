package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.g;
import com.badlogic.gdx.graphics.d;
import com.badlogic.gdx.graphics.e;
import com.badlogic.gdx.graphics.v;
import com.badlogic.gdx.graphics.w;
import com.badlogic.gdx.utils.BufferUtils;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class m
  implements o
{
  static final IntBuffer a = BufferUtils.c(1);
  final w b;
  final FloatBuffer c;
  final ByteBuffer d;
  int e;
  final boolean f;
  final int g;
  boolean h = false;
  boolean i = false;
  
  public m(boolean paramBoolean, int paramInt, w paramw)
  {
    this.f = paramBoolean;
    this.b = paramw;
    this.d = BufferUtils.d(this.b.a * paramInt);
    this.c = this.d.asFloatBuffer();
    this.c.flip();
    this.d.flip();
    this.e = e();
    if (paramBoolean) {}
    for (paramInt = 35044;; paramInt = 35048)
    {
      this.g = paramInt;
      return;
    }
  }
  
  public m(boolean paramBoolean, int paramInt, v... paramVarArgs)
  {
    this(paramBoolean, paramInt, new w(paramVarArgs));
  }
  
  private int e()
  {
    if (g.j != null) {
      g.j.glGenBuffers(1, a);
    }
    for (;;)
    {
      return a.get(0);
      g.i.b(1, a);
    }
  }
  
  public void a()
  {
    d locald = g.i;
    locald.a(34962, this.e);
    if (this.h)
    {
      this.d.limit(this.c.limit() * 4);
      locald.a(34962, this.d.limit(), this.d, this.g);
      this.h = false;
    }
    int n = this.b.a();
    int k = 0;
    int j = 0;
    v localv;
    if (k < n)
    {
      localv = this.b.a(k);
      switch (localv.a)
      {
      default: 
      case 1: 
        for (;;)
        {
          k += 1;
          break;
          locald.c(32884);
          locald.c(localv.b, 5126, this.b.a, localv.c);
        }
      case 2: 
      case 4: 
        if (localv.a != 4) {
          break;
        }
      }
    }
    for (int m = 5121;; m = 5126)
    {
      locald.c(32886);
      locald.a(localv.b, m, this.b.a, localv.c);
      break;
      locald.c(32885);
      locald.a(5126, this.b.a, localv.c);
      break;
      locald.a(33984 + j);
      locald.c(32888);
      locald.b(localv.b, 5126, this.b.a, localv.c);
      j += 1;
      break;
      this.i = true;
      return;
    }
  }
  
  public void a(k paramk, int[] paramArrayOfInt)
  {
    Object localObject = g.j;
    ((e)localObject).glBindBuffer(34962, this.e);
    if (this.h)
    {
      this.d.limit(this.c.limit() * 4);
      ((e)localObject).glBufferData(34962, this.d.limit(), this.d, this.g);
      this.h = false;
    }
    int k = this.b.a();
    int j;
    int m;
    if (paramArrayOfInt == null)
    {
      j = 0;
      if (j < k)
      {
        paramArrayOfInt = this.b.a(j);
        m = paramk.b(paramArrayOfInt.d);
        if (m < 0) {}
        for (;;)
        {
          j += 1;
          break;
          paramk.b(m);
          if (paramArrayOfInt.a == 4) {
            paramk.a(m, paramArrayOfInt.b, 5121, true, this.b.a, paramArrayOfInt.c);
          } else {
            paramk.a(m, paramArrayOfInt.b, 5126, false, this.b.a, paramArrayOfInt.c);
          }
        }
      }
    }
    else
    {
      j = 0;
      if (j < k)
      {
        localObject = this.b.a(j);
        m = paramArrayOfInt[j];
        if (m < 0) {}
        for (;;)
        {
          j += 1;
          break;
          paramk.b(m);
          if (((v)localObject).a == 4) {
            paramk.a(m, ((v)localObject).b, 5121, true, this.b.a, ((v)localObject).c);
          } else {
            paramk.a(m, ((v)localObject).b, 5126, false, this.b.a, ((v)localObject).c);
          }
        }
      }
    }
    this.i = true;
  }
  
  public void a(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    this.h = true;
    BufferUtils.a(paramArrayOfFloat, this.d, paramInt2, paramInt1);
    this.c.position(0);
    this.c.limit(paramInt2);
    if (this.i)
    {
      if (g.j == null) {
        break label77;
      }
      g.j.glBufferData(34962, this.d.limit(), this.d, this.g);
    }
    for (;;)
    {
      this.h = false;
      return;
      label77:
      g.i.a(34962, this.d.limit(), this.d, this.g);
    }
  }
  
  public void b()
  {
    d locald = g.i;
    int n = this.b.a();
    int j = 0;
    int k = 0;
    if (j < n)
    {
      int m = k;
      switch (this.b.a(j).a)
      {
      default: 
        m = k;
      }
      for (;;)
      {
        j += 1;
        k = m;
        break;
        locald.b(32886);
        m = k;
        continue;
        locald.b(32885);
        m = k;
        continue;
        locald.a(33984 + k);
        locald.b(32888);
        m = k + 1;
      }
    }
    locald.a(34962, 0);
    this.i = false;
  }
  
  public void b(k paramk, int[] paramArrayOfInt)
  {
    e locale = g.j;
    int k = this.b.a();
    if (paramArrayOfInt == null)
    {
      j = 0;
      while (j < k)
      {
        paramk.a(this.b.a(j).d);
        j += 1;
      }
    }
    int j = 0;
    while (j < k)
    {
      int m = paramArrayOfInt[j];
      if (m >= 0) {
        paramk.a(m);
      }
      j += 1;
    }
    locale.glBindBuffer(34962, 0);
    this.i = false;
  }
  
  public void c()
  {
    Object localObject;
    if (g.j != null)
    {
      a.clear();
      a.put(this.e);
      a.flip();
      localObject = g.j;
      ((e)localObject).glBindBuffer(34962, 0);
      ((e)localObject).glDeleteBuffers(1, a);
    }
    for (this.e = 0;; this.e = 0)
    {
      BufferUtils.a(this.d);
      return;
      a.clear();
      a.put(this.e);
      a.flip();
      localObject = g.i;
      ((d)localObject).a(34962, 0);
      ((d)localObject).a(1, a);
    }
  }
  
  public void d()
  {
    this.e = e();
    this.h = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/graphics/glutils/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */