package com.badlogic.gdx.graphics;

import com.badlogic.gdx.graphics.glutils.f;
import com.badlogic.gdx.graphics.glutils.k;
import com.badlogic.gdx.graphics.glutils.l;
import com.badlogic.gdx.graphics.glutils.m;
import com.badlogic.gdx.graphics.glutils.n;
import com.badlogic.gdx.graphics.glutils.o;
import java.nio.ShortBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class h
  implements com.badlogic.gdx.utils.d
{
  static final Map<com.badlogic.gdx.a, com.badlogic.gdx.utils.a<h>> a = new HashMap();
  public static boolean b = false;
  final o c;
  final com.badlogic.gdx.graphics.glutils.h d;
  boolean e = true;
  final boolean f;
  private final com.badlogic.gdx.math.g g = new com.badlogic.gdx.math.g();
  
  public h(i parami, boolean paramBoolean, int paramInt1, int paramInt2, v... paramVarArgs)
  {
    if ((parami == i.b) || (b))
    {
      this.c = new m(paramBoolean, paramInt1, paramVarArgs);
      this.d = new f(paramBoolean, paramInt2);
      this.f = false;
    }
    for (;;)
    {
      a(com.badlogic.gdx.g.a, this);
      return;
      if (parami == i.c)
      {
        this.c = new n(paramBoolean, paramInt1, paramVarArgs);
        this.d = new com.badlogic.gdx.graphics.glutils.g(paramBoolean, paramInt2);
        this.f = false;
      }
      else
      {
        this.c = new l(paramInt1, paramVarArgs);
        this.d = new com.badlogic.gdx.graphics.glutils.e(paramInt2);
        this.f = true;
      }
    }
  }
  
  public static void a(com.badlogic.gdx.a parama)
  {
    parama = (com.badlogic.gdx.utils.a)a.get(parama);
    if (parama == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < parama.b)
      {
        if ((((h)parama.a(i)).c instanceof m)) {
          ((m)((h)parama.a(i)).c).d();
        }
        ((h)parama.a(i)).d.f();
        i += 1;
      }
    }
  }
  
  private static void a(com.badlogic.gdx.a parama, h paramh)
  {
    com.badlogic.gdx.utils.a locala2 = (com.badlogic.gdx.utils.a)a.get(parama);
    com.badlogic.gdx.utils.a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new com.badlogic.gdx.utils.a();
    }
    locala1.a(paramh);
    a.put(parama, locala1);
  }
  
  public static void b(com.badlogic.gdx.a parama)
  {
    a.remove(parama);
  }
  
  public static String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Managed meshes/app: { ");
    Iterator localIterator = a.keySet().iterator();
    while (localIterator.hasNext())
    {
      com.badlogic.gdx.a locala = (com.badlogic.gdx.a)localIterator.next();
      localStringBuilder.append(((com.badlogic.gdx.utils.a)a.get(locala)).b);
      localStringBuilder.append(" ");
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public h a(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    this.c.a(paramArrayOfFloat, paramInt1, paramInt2);
    return this;
  }
  
  public h a(short[] paramArrayOfShort)
  {
    this.d.a(paramArrayOfShort, 0, paramArrayOfShort.length);
    return this;
  }
  
  public void a()
  {
    if (com.badlogic.gdx.g.b.a()) {
      throw new IllegalStateException("can't use this render method with OpenGL ES 2.0");
    }
    this.c.a();
    if ((!this.f) && (this.d.a() > 0)) {
      this.d.d();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramInt2, paramInt3, this.e);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (com.badlogic.gdx.g.b.a()) {
      throw new IllegalStateException("can't use this render method with OpenGL ES 2.0");
    }
    if (paramInt3 == 0) {}
    for (;;)
    {
      return;
      if (paramBoolean) {
        a();
      }
      if (this.f) {
        if (this.d.a() > 0)
        {
          ShortBuffer localShortBuffer = this.d.b();
          int i = localShortBuffer.position();
          int j = localShortBuffer.limit();
          localShortBuffer.position(paramInt2);
          localShortBuffer.limit(paramInt2 + paramInt3);
          com.badlogic.gdx.g.h.glDrawElements(paramInt1, paramInt3, 5123, localShortBuffer);
          localShortBuffer.position(i);
          localShortBuffer.limit(j);
        }
      }
      while (paramBoolean)
      {
        b();
        return;
        com.badlogic.gdx.g.h.glDrawArrays(paramInt1, paramInt2, paramInt3);
        continue;
        if (this.d.a() > 0) {
          com.badlogic.gdx.g.i.d(paramInt1, paramInt3, 5123, paramInt2 * 2);
        } else {
          com.badlogic.gdx.g.i.glDrawArrays(paramInt1, paramInt2, paramInt3);
        }
      }
    }
  }
  
  public void a(k paramk)
  {
    a(paramk, null);
  }
  
  public void a(k paramk, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramk, paramInt1, paramInt2, paramInt3, this.e);
  }
  
  public void a(k paramk, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (!com.badlogic.gdx.g.b.a()) {
      throw new IllegalStateException("can't use this render method with OpenGL ES 1.x");
    }
    if (paramInt3 == 0) {}
    for (;;)
    {
      return;
      if (paramBoolean) {
        a(paramk);
      }
      if (this.f) {
        if (this.d.a() > 0)
        {
          ShortBuffer localShortBuffer = this.d.b();
          int i = localShortBuffer.position();
          int j = localShortBuffer.limit();
          localShortBuffer.position(paramInt2);
          localShortBuffer.limit(paramInt2 + paramInt3);
          com.badlogic.gdx.g.j.glDrawElements(paramInt1, paramInt3, 5123, localShortBuffer);
          localShortBuffer.position(i);
          localShortBuffer.limit(j);
        }
      }
      while (paramBoolean)
      {
        b(paramk);
        return;
        com.badlogic.gdx.g.j.glDrawArrays(paramInt1, paramInt2, paramInt3);
        continue;
        if (this.d.a() > 0) {
          com.badlogic.gdx.g.j.glDrawElements(paramInt1, paramInt3, 5123, paramInt2 * 2);
        } else {
          com.badlogic.gdx.g.j.glDrawArrays(paramInt1, paramInt2, paramInt3);
        }
      }
    }
  }
  
  public void a(k paramk, int[] paramArrayOfInt)
  {
    if (!com.badlogic.gdx.g.b.a()) {
      throw new IllegalStateException("can't use this render method with OpenGL ES 1.x");
    }
    this.c.a(paramk, paramArrayOfInt);
    if (this.d.a() > 0) {
      this.d.d();
    }
  }
  
  public void b()
  {
    if (com.badlogic.gdx.g.b.a()) {
      throw new IllegalStateException("can't use this render method with OpenGL ES 2.0");
    }
    this.c.b();
    if ((!this.f) && (this.d.a() > 0)) {
      this.d.e();
    }
  }
  
  public void b(k paramk)
  {
    b(paramk, null);
  }
  
  public void b(k paramk, int[] paramArrayOfInt)
  {
    if (!com.badlogic.gdx.g.b.a()) {
      throw new IllegalStateException("can't use this render method with OpenGL ES 1.x");
    }
    this.c.b(paramk, paramArrayOfInt);
    if (this.d.a() > 0) {
      this.d.e();
    }
  }
  
  public void c()
  {
    if (a.get(com.badlogic.gdx.g.a) != null) {
      ((com.badlogic.gdx.utils.a)a.get(com.badlogic.gdx.g.a)).b(this, true);
    }
    this.c.c();
    this.d.c();
  }
  
  public ShortBuffer d()
  {
    return this.d.b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/graphics/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */