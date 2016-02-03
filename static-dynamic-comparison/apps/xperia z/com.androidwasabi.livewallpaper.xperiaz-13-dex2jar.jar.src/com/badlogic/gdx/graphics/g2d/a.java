package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.g;
import com.badlogic.gdx.graphics.c;
import com.badlogic.gdx.graphics.f;
import com.badlogic.gdx.graphics.glutils.k;
import com.badlogic.gdx.graphics.p;
import com.badlogic.gdx.graphics.v;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.d;
import java.nio.ShortBuffer;

public class a
  implements d
{
  float a = com.badlogic.gdx.graphics.b.b.b();
  public int b = 0;
  public int c = 0;
  public int d = 0;
  private com.badlogic.gdx.graphics.h e;
  private com.badlogic.gdx.graphics.h[] f;
  private int g = 0;
  private final float[] h;
  private int i = 0;
  private p j = null;
  private float k = 0.0F;
  private float l = 0.0F;
  private boolean m = false;
  private final Matrix4 n = new Matrix4();
  private final Matrix4 o = new Matrix4();
  private final Matrix4 p = new Matrix4();
  private boolean q = false;
  private int r = 770;
  private int s = 771;
  private final k t;
  private k u = null;
  private boolean v;
  private com.badlogic.gdx.graphics.b w = new com.badlogic.gdx.graphics.b(1.0F, 1.0F, 1.0F, 1.0F);
  
  public a()
  {
    this(1000, 1, null);
  }
  
  public a(int paramInt1, int paramInt2, k paramk)
  {
    if (paramInt1 > 5460) {
      throw new IllegalArgumentException("Can't have more than 5460 sprites per batch: " + paramInt1);
    }
    this.f = new com.badlogic.gdx.graphics.h[paramInt2];
    int i1 = 0;
    while (i1 < paramInt2)
    {
      this.f[i1] = new com.badlogic.gdx.graphics.h(com.badlogic.gdx.graphics.i.a, false, paramInt1 * 4, paramInt1 * 6, new v[] { new v(1, 2, "a_position"), new v(4, 4, "a_color"), new v(16, 2, "a_texCoord0") });
      i1 += 1;
    }
    this.o.a(0.0F, 0.0F, g.b.e(), g.b.f());
    this.h = new float[paramInt1 * 20];
    int i2 = paramInt1 * 6;
    short[] arrayOfShort = new short[i2];
    paramInt1 = 0;
    i1 = 0;
    while (i1 < i2)
    {
      arrayOfShort[(i1 + 0)] = ((short)(paramInt1 + 0));
      arrayOfShort[(i1 + 1)] = ((short)(paramInt1 + 1));
      arrayOfShort[(i1 + 2)] = ((short)(paramInt1 + 2));
      arrayOfShort[(i1 + 3)] = ((short)(paramInt1 + 2));
      arrayOfShort[(i1 + 4)] = ((short)(paramInt1 + 3));
      arrayOfShort[(i1 + 5)] = ((short)(paramInt1 + 0));
      i1 += 6;
      paramInt1 = (short)(paramInt1 + 4);
    }
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      this.f[paramInt1].a(arrayOfShort);
      paramInt1 += 1;
    }
    this.e = this.f[0];
    if ((g.b.a()) && (paramk == null))
    {
      this.t = a();
      this.v = true;
      return;
    }
    this.t = paramk;
  }
  
  public static k a()
  {
    k localk = new k("attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\nuniform mat4 u_projTrans;\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main()\n{\n   v_color = a_color;\n   v_texCoords = a_texCoord0;\n   gl_Position =  u_projTrans * a_position;\n}\n", "#ifdef GL_ES\n#define LOWP lowp\nprecision mediump float;\n#else\n#define LOWP \n#endif\nvarying LOWP vec4 v_color;\nvarying vec2 v_texCoords;\nuniform sampler2D u_texture;\nvoid main()\n{\n  gl_FragColor = v_color * texture2D(u_texture, v_texCoords);\n}");
    if (!localk.b()) {
      throw new IllegalArgumentException("Error compiling shader: " + localk.a());
    }
    return localk;
  }
  
  private void a(p paramp)
  {
    e();
    this.j = paramp;
    this.k = (1.0F / paramp.k());
    this.l = (1.0F / paramp.l());
  }
  
  private void i()
  {
    if (!g.b.a())
    {
      c localc = g.h;
      localc.d(5889);
      localc.a(this.o.b, 0);
      localc.d(5888);
      localc.a(this.n.b, 0);
      return;
    }
    this.p.a(this.o).b(this.n);
    if (this.u != null)
    {
      this.u.a("u_projTrans", this.p);
      this.u.a("u_texture", 0);
      return;
    }
    this.t.a("u_projTrans", this.p);
    this.t.a("u_texture", 0);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = com.badlogic.gdx.utils.i.a((int)(255.0F * paramFloat4) << 24 | (int)(255.0F * paramFloat3) << 16 | (int)(255.0F * paramFloat2) << 8 | (int)(255.0F * paramFloat1));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.r == paramInt1) && (this.s == paramInt2)) {
      return;
    }
    e();
    this.r = paramInt1;
    this.s = paramInt2;
  }
  
  public void a(b paramb, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (!this.m) {
      throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
    }
    float[] arrayOfFloat = this.h;
    p localp = paramb.a;
    if (localp != this.j) {
      a(localp);
    }
    for (;;)
    {
      paramFloat3 = paramFloat1 + paramFloat3;
      paramFloat4 = paramFloat2 + paramFloat4;
      float f1 = paramb.b;
      float f2 = paramb.e;
      float f3 = paramb.d;
      float f4 = paramb.c;
      float f5 = this.a;
      int i2 = this.i;
      int i1 = i2 + 1;
      arrayOfFloat[i2] = paramFloat1;
      i2 = i1 + 1;
      arrayOfFloat[i1] = paramFloat2;
      i1 = i2 + 1;
      arrayOfFloat[i2] = f5;
      i2 = i1 + 1;
      arrayOfFloat[i1] = f1;
      i1 = i2 + 1;
      arrayOfFloat[i2] = f2;
      i2 = i1 + 1;
      arrayOfFloat[i1] = paramFloat1;
      i1 = i2 + 1;
      arrayOfFloat[i2] = paramFloat4;
      i2 = i1 + 1;
      arrayOfFloat[i1] = f5;
      i1 = i2 + 1;
      arrayOfFloat[i2] = f1;
      i2 = i1 + 1;
      arrayOfFloat[i1] = f4;
      i1 = i2 + 1;
      arrayOfFloat[i2] = paramFloat3;
      i2 = i1 + 1;
      arrayOfFloat[i1] = paramFloat4;
      i1 = i2 + 1;
      arrayOfFloat[i2] = f5;
      i2 = i1 + 1;
      arrayOfFloat[i1] = f3;
      i1 = i2 + 1;
      arrayOfFloat[i2] = f4;
      i2 = i1 + 1;
      arrayOfFloat[i1] = paramFloat3;
      i1 = i2 + 1;
      arrayOfFloat[i2] = paramFloat2;
      i2 = i1 + 1;
      arrayOfFloat[i1] = f5;
      i1 = i2 + 1;
      arrayOfFloat[i2] = f3;
      arrayOfFloat[i1] = f2;
      this.i = (i1 + 1);
      return;
      if (this.i == arrayOfFloat.length) {
        e();
      }
    }
  }
  
  public void a(Matrix4 paramMatrix4)
  {
    if (this.m) {
      e();
    }
    this.o.a(paramMatrix4);
    if (this.m) {
      i();
    }
  }
  
  public void b()
  {
    if (this.m) {
      throw new IllegalStateException("SpriteBatch.end must be called before begin.");
    }
    this.b = 0;
    g.g.glDepthMask(false);
    if (g.b.a()) {
      if (this.u != null) {
        this.u.d();
      }
    }
    for (;;)
    {
      i();
      this.m = true;
      return;
      this.t.d();
      continue;
      g.g.glEnable(3553);
    }
  }
  
  public void c()
  {
    int i1 = 0;
    while (i1 < this.f.length)
    {
      this.f[i1].c();
      i1 += 1;
    }
    if ((this.v) && (this.t != null)) {
      this.t.c();
    }
  }
  
  public void d()
  {
    if (!this.m) {
      throw new IllegalStateException("SpriteBatch.begin must be called before end.");
    }
    if (this.i > 0) {
      e();
    }
    this.j = null;
    this.m = false;
    f localf = g.g;
    localf.glDepthMask(true);
    if (h()) {
      localf.glDisable(3042);
    }
    if (g.b.a())
    {
      if (this.u != null)
      {
        this.u.e();
        return;
      }
      this.t.e();
      return;
    }
    localf.glDisable(3553);
  }
  
  public void e()
  {
    if (this.i == 0) {
      return;
    }
    this.b += 1;
    this.c += 1;
    int i1 = this.i / 20;
    if (i1 > this.d) {
      this.d = i1;
    }
    i1 *= 6;
    this.j.a();
    com.badlogic.gdx.graphics.h localh = this.e;
    localh.a(this.h, 0, this.i);
    localh.d().position(0);
    localh.d().limit(i1);
    k localk;
    if (this.q)
    {
      g.g.glDisable(3042);
      if (!g.b.a()) {
        break label239;
      }
      if (this.u == null) {
        break label231;
      }
      localk = this.u;
      label139:
      localh.a(localk, 4, 0, i1);
    }
    for (;;)
    {
      this.i = 0;
      this.g += 1;
      if (this.g == this.f.length) {
        this.g = 0;
      }
      this.e = this.f[this.g];
      return;
      g.g.glEnable(3042);
      if (this.r == -1) {
        break;
      }
      g.g.glBlendFunc(this.r, this.s);
      break;
      label231:
      localk = this.t;
      break label139;
      label239:
      localh.a(4, 0, i1);
    }
  }
  
  public void f()
  {
    if (this.q) {
      return;
    }
    e();
    this.q = true;
  }
  
  public void g()
  {
    if (!this.q) {
      return;
    }
    e();
    this.q = false;
  }
  
  public boolean h()
  {
    return !this.q;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/graphics/g2d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */