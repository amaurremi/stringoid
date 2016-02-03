package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.b;
import com.badlogic.gdx.g;
import com.badlogic.gdx.graphics.e;
import com.badlogic.gdx.graphics.m;
import com.badlogic.gdx.graphics.p;
import com.badlogic.gdx.graphics.r;
import com.badlogic.gdx.graphics.s;
import com.badlogic.gdx.h;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.f;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class d
  implements com.badlogic.gdx.utils.d
{
  private static final Map<com.badlogic.gdx.a, com.badlogic.gdx.utils.a<d>> f = new HashMap();
  private static int g;
  private static boolean h = false;
  protected p a;
  protected final int b;
  protected final int c;
  protected final boolean d;
  protected final m e;
  private int i;
  private int j;
  
  public static StringBuilder a(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("Managed buffers/app: { ");
    Iterator localIterator = f.keySet().iterator();
    while (localIterator.hasNext())
    {
      com.badlogic.gdx.a locala = (com.badlogic.gdx.a)localIterator.next();
      paramStringBuilder.append(((com.badlogic.gdx.utils.a)f.get(locala)).b);
      paramStringBuilder.append(" ");
    }
    paramStringBuilder.append("}");
    return paramStringBuilder;
  }
  
  public static void a(com.badlogic.gdx.a parama)
  {
    if (g.b.d() == null) {}
    for (;;)
    {
      return;
      parama = (com.badlogic.gdx.utils.a)f.get(parama);
      if (parama != null)
      {
        int k = 0;
        while (k < parama.b)
        {
          ((d)parama.a(k)).d();
          k += 1;
        }
      }
    }
  }
  
  public static String b()
  {
    return a(new StringBuilder()).toString();
  }
  
  public static void b(com.badlogic.gdx.a parama)
  {
    f.remove(parama);
  }
  
  private void d()
  {
    if (!g.b.a()) {
      throw new f("GL2 is required.");
    }
    e locale = g.b.d();
    IntBuffer localIntBuffer;
    if (!h)
    {
      h = true;
      if (g.a.b() != b.e) {
        break label392;
      }
      localIntBuffer = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asIntBuffer();
      locale.glGetIntegerv(36006, localIntBuffer);
    }
    int k;
    label392:
    for (g = localIntBuffer.get(0);; g = 0)
    {
      a();
      localIntBuffer = BufferUtils.c(1);
      locale.glGenFramebuffers(1, localIntBuffer);
      this.i = localIntBuffer.get(0);
      if (this.d)
      {
        localIntBuffer.clear();
        locale.glGenRenderbuffers(1, localIntBuffer);
        this.j = localIntBuffer.get(0);
      }
      locale.glBindTexture(3553, this.a.g());
      if (this.d)
      {
        locale.glBindRenderbuffer(36161, this.j);
        locale.glRenderbufferStorage(36161, 33189, this.a.k(), this.a.l());
      }
      locale.glBindFramebuffer(36160, this.i);
      locale.glFramebufferTexture2D(36160, 36064, 3553, this.a.g(), 0);
      if (this.d) {
        locale.glFramebufferRenderbuffer(36160, 36096, 36161, this.j);
      }
      k = locale.glCheckFramebufferStatus(36160);
      locale.glBindRenderbuffer(36161, 0);
      locale.glBindTexture(3553, 0);
      locale.glBindFramebuffer(36160, g);
      if (k == 36053) {
        return;
      }
      this.a.c();
      if (this.d)
      {
        localIntBuffer.clear();
        localIntBuffer.put(this.j);
        localIntBuffer.flip();
        locale.glDeleteRenderbuffers(1, localIntBuffer);
      }
      this.a.c();
      localIntBuffer.clear();
      localIntBuffer.put(this.i);
      localIntBuffer.flip();
      locale.glDeleteFramebuffers(1, localIntBuffer);
      if (k != 36054) {
        break;
      }
      throw new IllegalStateException("frame buffer couldn't be constructed: incomplete attachment");
    }
    if (k == 36057) {
      throw new IllegalStateException("frame buffer couldn't be constructed: incomplete dimensions");
    }
    if (k == 36055) {
      throw new IllegalStateException("frame buffer couldn't be constructed: missing attachment");
    }
    if (k == 36061) {
      throw new IllegalStateException("frame buffer couldn't be constructed: unsupported combination of formats");
    }
    throw new IllegalStateException("frame buffer couldn't be constructed: unknown error " + k);
  }
  
  protected void a()
  {
    this.a = new p(this.b, this.c, this.e);
    this.a.a(r.b, r.b);
    this.a.a(s.b, s.b);
  }
  
  public void c()
  {
    e locale = g.b.d();
    IntBuffer localIntBuffer = BufferUtils.c(1);
    this.a.c();
    if (this.d)
    {
      localIntBuffer.put(this.j);
      localIntBuffer.flip();
      locale.glDeleteRenderbuffers(1, localIntBuffer);
    }
    localIntBuffer.clear();
    localIntBuffer.put(this.i);
    localIntBuffer.flip();
    locale.glDeleteFramebuffers(1, localIntBuffer);
    if (f.get(g.a) != null) {
      ((com.badlogic.gdx.utils.a)f.get(g.a)).b(this, true);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/graphics/glutils/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */