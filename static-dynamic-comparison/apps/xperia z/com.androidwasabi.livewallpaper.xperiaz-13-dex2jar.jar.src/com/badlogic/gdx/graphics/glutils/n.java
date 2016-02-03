package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.g;
import com.badlogic.gdx.graphics.d;
import com.badlogic.gdx.graphics.e;
import com.badlogic.gdx.graphics.v;
import com.badlogic.gdx.graphics.w;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.f;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class n
  implements o
{
  static final IntBuffer a = BufferUtils.c(1);
  final w b;
  final FloatBuffer c;
  final ByteBuffer d;
  int e;
  final boolean f;
  final boolean g;
  final int h;
  boolean i = false;
  boolean j = false;
  
  public n(boolean paramBoolean, int paramInt, v... paramVarArgs)
  {
    this.g = paramBoolean;
    this.b = new w(paramVarArgs);
    this.d = BufferUtils.b(this.b.a * paramInt);
    this.f = true;
    if (paramBoolean) {}
    for (paramInt = 35044;; paramInt = 35048)
    {
      this.h = paramInt;
      this.c = this.d.asFloatBuffer();
      this.e = d();
      this.c.flip();
      this.d.flip();
      return;
    }
  }
  
  private int d()
  {
    if (g.j != null)
    {
      g.j.glGenBuffers(1, a);
      g.j.glBindBuffer(34962, a.get(0));
      g.j.glBufferData(34962, this.d.capacity(), null, this.h);
      g.j.glBindBuffer(34962, 0);
    }
    for (;;)
    {
      return a.get(0);
      g.i.b(1, a);
      g.i.a(34962, a.get(0));
      g.i.a(34962, this.d.capacity(), null, this.h);
      g.i.a(34962, 0);
    }
  }
  
  public void a()
  {
    d locald = g.i;
    locald.a(34962, this.e);
    if (this.i)
    {
      this.d.limit(this.c.limit() * 4);
      locald.d(34962, 0, this.d.limit(), this.d);
      this.i = false;
    }
    int i1 = this.b.a();
    int m = 0;
    int k = 0;
    v localv;
    while (m < i1)
    {
      localv = this.b.a(m);
      switch (localv.a)
      {
      default: 
        throw new f("unkown vertex attribute type: " + localv.a);
      case 1: 
        locald.c(32884);
        locald.c(localv.b, 5126, this.b.a, localv.c);
        m += 1;
        break;
      case 2: 
      case 4: 
        if (localv.a != 4) {
          break label370;
        }
      }
    }
    label370:
    for (int n = 5121;; n = 5126)
    {
      locald.c(32886);
      locald.a(localv.b, n, this.b.a, localv.c);
      break;
      locald.c(32885);
      locald.a(5126, this.b.a, localv.c);
      break;
      locald.a(33984 + k);
      locald.c(32888);
      locald.b(localv.b, 5126, this.b.a, localv.c);
      k += 1;
      break;
      this.j = true;
      return;
    }
  }
  
  public void a(k paramk, int[] paramArrayOfInt)
  {
    Object localObject = g.j;
    ((e)localObject).glBindBuffer(34962, this.e);
    if (this.i)
    {
      this.d.limit(this.c.limit() * 4);
      ((e)localObject).glBufferData(34962, this.d.limit(), this.d, this.h);
      this.i = false;
    }
    int m = this.b.a();
    int k;
    int n;
    if (paramArrayOfInt == null)
    {
      k = 0;
      if (k < m)
      {
        paramArrayOfInt = this.b.a(k);
        n = paramk.b(paramArrayOfInt.d);
        if (n < 0) {}
        for (;;)
        {
          k += 1;
          break;
          paramk.b(n);
          if (paramArrayOfInt.a == 4) {
            paramk.a(n, paramArrayOfInt.b, 5121, true, this.b.a, paramArrayOfInt.c);
          } else {
            paramk.a(n, paramArrayOfInt.b, 5126, false, this.b.a, paramArrayOfInt.c);
          }
        }
      }
    }
    else
    {
      k = 0;
      if (k < m)
      {
        localObject = this.b.a(k);
        n = paramArrayOfInt[k];
        if (n < 0) {}
        for (;;)
        {
          k += 1;
          break;
          paramk.b(n);
          if (((v)localObject).a == 4) {
            paramk.a(n, ((v)localObject).b, 5121, true, this.b.a, ((v)localObject).c);
          } else {
            paramk.a(n, ((v)localObject).b, 5126, false, this.b.a, ((v)localObject).c);
          }
        }
      }
    }
    this.j = true;
  }
  
  public void a(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    this.i = true;
    if (this.f)
    {
      BufferUtils.a(paramArrayOfFloat, this.d, paramInt2, paramInt1);
      this.c.position(0);
      this.c.limit(paramInt2);
      if (this.j)
      {
        if (g.j == null) {
          break label137;
        }
        g.j.glBufferSubData(34962, 0, this.d.limit(), this.d);
      }
    }
    for (;;)
    {
      this.i = false;
      return;
      this.c.clear();
      this.c.put(paramArrayOfFloat, paramInt1, paramInt2);
      this.c.flip();
      this.d.position(0);
      this.d.limit(this.c.limit() << 2);
      break;
      label137:
      g.i.d(34962, 0, this.d.limit(), this.d);
    }
  }
  
  public void b()
  {
    d locald = g.i;
    int i1 = this.b.a();
    int k = 0;
    int m = 0;
    if (k < i1)
    {
      v localv = this.b.a(k);
      int n = m;
      switch (localv.a)
      {
      default: 
        throw new f("unkown vertex attribute type: " + localv.a);
      case 2: 
      case 4: 
        locald.b(32886);
        n = m;
      }
      for (;;)
      {
        k += 1;
        m = n;
        break;
        locald.b(32885);
        n = m;
        continue;
        locald.a(33984 + m);
        locald.b(32888);
        n = m + 1;
      }
    }
    locald.a(34962, 0);
    this.j = false;
  }
  
  public void b(k paramk, int[] paramArrayOfInt)
  {
    e locale = g.j;
    int m = this.b.a();
    if (paramArrayOfInt == null)
    {
      k = 0;
      while (k < m)
      {
        paramk.a(this.b.a(k).d);
        k += 1;
      }
    }
    int k = 0;
    while (k < m)
    {
      int n = paramArrayOfInt[k];
      if (n >= 0) {
        paramk.a(n);
      }
      k += 1;
    }
    locale.glBindBuffer(34962, 0);
    this.j = false;
  }
  
  public void c()
  {
    if (g.j != null)
    {
      a.clear();
      a.put(this.e);
      a.flip();
      localObject = g.j;
      ((e)localObject).glBindBuffer(34962, 0);
      ((e)localObject).glDeleteBuffers(1, a);
      this.e = 0;
      return;
    }
    a.clear();
    a.put(this.e);
    a.flip();
    Object localObject = g.i;
    ((d)localObject).a(34962, 0);
    ((d)localObject).a(1, a);
    this.e = 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/graphics/glutils/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */