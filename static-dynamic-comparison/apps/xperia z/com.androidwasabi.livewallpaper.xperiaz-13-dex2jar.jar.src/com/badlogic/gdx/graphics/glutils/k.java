package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.g;
import com.badlogic.gdx.graphics.e;
import com.badlogic.gdx.h;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.d;
import com.badlogic.gdx.utils.j;
import com.badlogic.gdx.utils.n;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Iterator;

public class k
  implements d
{
  public static boolean a = true;
  static final IntBuffer b = BufferUtils.c(1);
  private static final com.badlogic.gdx.utils.k<com.badlogic.gdx.a, com.badlogic.gdx.utils.a<k>> e = new com.badlogic.gdx.utils.k();
  IntBuffer c = BufferUtils.c(1);
  IntBuffer d = BufferUtils.c(1);
  private String f = "";
  private boolean g;
  private final j<String> h = new j();
  private final j<String> i = new j();
  private final j<String> j = new j();
  private String[] k;
  private final j<String> l = new j();
  private final j<String> m = new j();
  private final j<String> n = new j();
  private String[] o;
  private int p;
  private int q;
  private int r;
  private final FloatBuffer s;
  private final String t;
  private final String u;
  private boolean v;
  private ByteBuffer w = null;
  private FloatBuffer x = null;
  private IntBuffer y = null;
  private int z = 0;
  
  public k(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("vertex shader must not be null");
    }
    if (paramString2 == null) {
      throw new IllegalArgumentException("fragment shader must not be null");
    }
    this.t = paramString1;
    this.u = paramString2;
    this.s = BufferUtils.a(16);
    a(paramString1, paramString2);
    if (b())
    {
      j();
      i();
      a(g.a, this);
    }
  }
  
  private int a(int paramInt, String paramString)
  {
    e locale = g.b.d();
    IntBuffer localIntBuffer = BufferUtils.c(1);
    paramInt = locale.glCreateShader(paramInt);
    if (paramInt == 0) {
      return -1;
    }
    locale.glShaderSource(paramInt, paramString);
    locale.glCompileShader(paramInt);
    locale.glGetShaderiv(paramInt, 35713, localIntBuffer);
    if (localIntBuffer.get(0) == 0)
    {
      paramString = locale.glGetShaderInfoLog(paramInt);
      this.f += paramString;
      return -1;
    }
    return paramInt;
  }
  
  public static void a(com.badlogic.gdx.a parama)
  {
    if (g.b.d() == null) {}
    for (;;)
    {
      return;
      parama = (com.badlogic.gdx.utils.a)e.a(parama);
      if (parama != null)
      {
        int i1 = 0;
        while (i1 < parama.b)
        {
          ((k)parama.a(i1)).v = true;
          ((k)parama.a(i1)).h();
          i1 += 1;
        }
      }
    }
  }
  
  private void a(com.badlogic.gdx.a parama, k paramk)
  {
    com.badlogic.gdx.utils.a locala2 = (com.badlogic.gdx.utils.a)e.a(parama);
    com.badlogic.gdx.utils.a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new com.badlogic.gdx.utils.a();
    }
    locala1.a(paramk);
    e.a(parama, locala1);
  }
  
  private void a(String paramString1, String paramString2)
  {
    this.q = a(35633, paramString1);
    this.r = a(35632, paramString2);
    if ((this.q == -1) || (this.r == -1))
    {
      this.g = false;
      return;
    }
    this.p = g();
    if (this.p == -1)
    {
      this.g = false;
      return;
    }
    this.g = true;
  }
  
  public static void b(com.badlogic.gdx.a parama)
  {
    e.b(parama);
  }
  
  private int c(String paramString)
  {
    e locale = g.b.d();
    int i2 = this.l.b(paramString, -2);
    int i1 = i2;
    if (i2 == -2)
    {
      i1 = locale.glGetAttribLocation(this.p, paramString);
      this.l.a(paramString, i1);
    }
    return i1;
  }
  
  private int d(String paramString)
  {
    return a(paramString, a);
  }
  
  public static String f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Managed shaders/app: { ");
    Iterator localIterator = e.c().iterator();
    while (localIterator.hasNext())
    {
      com.badlogic.gdx.a locala = (com.badlogic.gdx.a)localIterator.next();
      localStringBuilder.append(((com.badlogic.gdx.utils.a)e.a(locala)).b);
      localStringBuilder.append(" ");
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  private int g()
  {
    e locale = g.b.d();
    int i1 = locale.glCreateProgram();
    if (i1 == 0) {
      return -1;
    }
    locale.glAttachShader(i1, this.q);
    locale.glAttachShader(i1, this.r);
    locale.glLinkProgram(i1);
    Object localObject = ByteBuffer.allocateDirect(4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asIntBuffer();
    locale.glGetProgramiv(i1, 35714, (IntBuffer)localObject);
    if (((IntBuffer)localObject).get(0) == 0)
    {
      this.f = g.j.glGetProgramInfoLog(i1);
      return -1;
    }
    return i1;
  }
  
  private void h()
  {
    if (this.v)
    {
      a(this.t, this.u);
      this.v = false;
    }
  }
  
  private void i()
  {
    this.c.clear();
    g.j.glGetProgramiv(this.p, 35718, this.c);
    int i2 = this.c.get(0);
    this.k = new String[i2];
    int i1 = 0;
    while (i1 < i2)
    {
      this.c.clear();
      this.c.put(0, 1);
      this.d.clear();
      String str = g.j.glGetActiveUniform(this.p, i1, this.c, this.d);
      int i3 = g.j.glGetUniformLocation(this.p, str);
      this.h.a(str, i3);
      this.i.a(str, this.d.get(0));
      this.j.a(str, this.c.get(0));
      this.k[i1] = str;
      i1 += 1;
    }
  }
  
  private void j()
  {
    this.c.clear();
    g.j.glGetProgramiv(this.p, 35721, this.c);
    int i2 = this.c.get(0);
    this.o = new String[i2];
    int i1 = 0;
    while (i1 < i2)
    {
      this.c.clear();
      this.c.put(0, 1);
      this.d.clear();
      String str = g.j.glGetActiveAttrib(this.p, i1, this.c, this.d);
      int i3 = g.j.glGetAttribLocation(this.p, str);
      this.l.a(str, i3);
      this.m.a(str, this.d.get(0));
      this.n.a(str, this.c.get(0));
      this.o[i1] = str;
      i1 += 1;
    }
  }
  
  public int a(String paramString, boolean paramBoolean)
  {
    e locale = g.b.d();
    int i2 = this.h.b(paramString, -2);
    int i1 = i2;
    if (i2 == -2)
    {
      i1 = locale.glGetUniformLocation(this.p, paramString);
      if ((i1 == -1) && (paramBoolean)) {
        throw new IllegalArgumentException("no uniform with name '" + paramString + "' in shader");
      }
      this.h.a(paramString, i1);
    }
    return i1;
  }
  
  public String a()
  {
    if (this.g)
    {
      this.f = g.j.glGetProgramInfoLog(this.p);
      return this.f;
    }
    return this.f;
  }
  
  public void a(int paramInt)
  {
    e locale = g.b.d();
    h();
    locale.glDisableVertexAttribArray(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5)
  {
    e locale = g.b.d();
    h();
    locale.glVertexAttribPointer(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramInt5);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, Buffer paramBuffer)
  {
    e locale = g.b.d();
    h();
    locale.glVertexAttribPointer(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramBuffer);
  }
  
  public void a(String paramString)
  {
    e locale = g.b.d();
    h();
    int i1 = c(paramString);
    if (i1 == -1) {
      return;
    }
    locale.glDisableVertexAttribArray(i1);
  }
  
  public void a(String paramString, int paramInt)
  {
    e locale = g.b.d();
    h();
    locale.glUniform1i(d(paramString), paramInt);
  }
  
  public void a(String paramString, Matrix4 paramMatrix4)
  {
    a(paramString, paramMatrix4, false);
  }
  
  public void a(String paramString, Matrix4 paramMatrix4, boolean paramBoolean)
  {
    e locale = g.b.d();
    h();
    int i1 = d(paramString);
    this.s.clear();
    BufferUtils.a(paramMatrix4.b, this.s, paramMatrix4.b.length, 0);
    locale.glUniformMatrix4fv(i1, 1, paramBoolean, this.s);
  }
  
  public int b(String paramString)
  {
    return this.l.b(paramString, -1);
  }
  
  public void b(int paramInt)
  {
    e locale = g.b.d();
    h();
    locale.glEnableVertexAttribArray(paramInt);
  }
  
  public boolean b()
  {
    return this.g;
  }
  
  public void c()
  {
    e locale = g.b.d();
    locale.glUseProgram(0);
    locale.glDeleteShader(this.q);
    locale.glDeleteShader(this.r);
    locale.glDeleteProgram(this.p);
    if (e.a(g.a) != null) {
      ((com.badlogic.gdx.utils.a)e.a(g.a)).b(this, true);
    }
  }
  
  public void d()
  {
    e locale = g.b.d();
    h();
    locale.glUseProgram(this.p);
  }
  
  public void e()
  {
    g.b.d().glUseProgram(0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/graphics/glutils/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */