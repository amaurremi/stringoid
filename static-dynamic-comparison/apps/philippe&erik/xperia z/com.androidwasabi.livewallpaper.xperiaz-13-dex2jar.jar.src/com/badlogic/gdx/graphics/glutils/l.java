package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.g;
import com.badlogic.gdx.graphics.c;
import com.badlogic.gdx.graphics.e;
import com.badlogic.gdx.graphics.v;
import com.badlogic.gdx.graphics.w;
import com.badlogic.gdx.utils.BufferUtils;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class l
  implements o
{
  final w a;
  final FloatBuffer b;
  final ByteBuffer c;
  boolean d = false;
  
  public l(int paramInt, w paramw)
  {
    this.a = paramw;
    this.c = BufferUtils.d(this.a.a * paramInt);
    this.b = this.c.asFloatBuffer();
    this.b.flip();
    this.c.flip();
  }
  
  public l(int paramInt, v... paramVarArgs)
  {
    this(paramInt, new w(paramVarArgs));
  }
  
  public void a()
  {
    c localc = g.h;
    int m = this.a.a();
    this.c.limit(this.b.limit() * 4);
    int j = 0;
    int i = 0;
    v localv;
    if (j < m)
    {
      localv = this.a.a(j);
      switch (localv.a)
      {
      default: 
      case 1: 
        for (;;)
        {
          j += 1;
          break;
          this.c.position(localv.c);
          localc.c(32884);
          localc.c(localv.b, 5126, this.a.a, this.c);
        }
      case 2: 
      case 4: 
        if (localv.a != 4) {
          break;
        }
      }
    }
    for (int k = 5121;; k = 5126)
    {
      this.c.position(localv.c);
      localc.c(32886);
      localc.a(localv.b, k, this.a.a, this.c);
      break;
      this.c.position(localv.c);
      localc.c(32885);
      localc.a(5126, this.a.a, this.c);
      break;
      localc.a(33984 + i);
      localc.c(32888);
      this.c.position(localv.c);
      localc.b(localv.b, 5126, this.a.a, this.c);
      i += 1;
      break;
      this.d = true;
      return;
    }
  }
  
  public void a(k paramk, int[] paramArrayOfInt)
  {
    Object localObject = g.j;
    int j = this.a.a();
    this.c.limit(this.b.limit() * 4);
    int i;
    int k;
    if (paramArrayOfInt == null)
    {
      i = 0;
      if (i < j)
      {
        paramArrayOfInt = this.a.a(i);
        k = paramk.b(paramArrayOfInt.d);
        if (k < 0) {}
        for (;;)
        {
          i += 1;
          break;
          paramk.b(k);
          this.c.position(paramArrayOfInt.c);
          if (paramArrayOfInt.a == 4) {
            paramk.a(k, paramArrayOfInt.b, 5121, true, this.a.a, this.c);
          } else {
            paramk.a(k, paramArrayOfInt.b, 5126, false, this.a.a, this.c);
          }
        }
      }
    }
    else
    {
      i = 0;
      if (i < j)
      {
        localObject = this.a.a(i);
        k = paramArrayOfInt[i];
        if (k < 0) {}
        for (;;)
        {
          i += 1;
          break;
          paramk.b(k);
          this.c.position(((v)localObject).c);
          if (((v)localObject).a == 4) {
            paramk.a(k, ((v)localObject).b, 5121, true, this.a.a, this.c);
          } else {
            paramk.a(k, ((v)localObject).b, 5126, false, this.a.a, this.c);
          }
        }
      }
    }
    this.d = true;
  }
  
  public void a(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    BufferUtils.a(paramArrayOfFloat, this.c, paramInt2, paramInt1);
    this.b.position(0);
    this.b.limit(paramInt2);
  }
  
  public void b()
  {
    c localc = g.h;
    int m = this.a.a();
    int i = 0;
    int j = 0;
    if (i < m)
    {
      int k = j;
      switch (this.a.a(i).a)
      {
      default: 
        k = j;
      }
      for (;;)
      {
        i += 1;
        j = k;
        break;
        localc.b(32886);
        k = j;
        continue;
        localc.b(32885);
        k = j;
        continue;
        localc.a(33984 + j);
        localc.b(32888);
        k = j + 1;
      }
    }
    this.c.position(0);
    this.d = false;
  }
  
  public void b(k paramk, int[] paramArrayOfInt)
  {
    e locale = g.j;
    int j = this.a.a();
    if (paramArrayOfInt == null)
    {
      i = 0;
      while (i < j)
      {
        paramk.a(this.a.a(i).d);
        i += 1;
      }
    }
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      if (k >= 0) {
        paramk.a(k);
      }
      i += 1;
    }
    this.d = false;
  }
  
  public void c()
  {
    BufferUtils.a(this.c);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/graphics/glutils/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */