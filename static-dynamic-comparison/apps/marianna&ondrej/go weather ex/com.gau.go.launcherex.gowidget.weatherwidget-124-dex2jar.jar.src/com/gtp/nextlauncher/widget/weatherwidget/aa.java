package com.gtp.nextlauncher.widget.weatherwidget;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.animation.AnimationUtils;
import com.go.gl.graphics.BitmapGLDrawable;
import com.go.gl.graphics.BitmapTexture;
import com.go.gl.graphics.GLCanvas;
import com.go.gl.graphics.GLDrawable;
import com.go.gl.graphics.RenderContext;
import com.go.gl.graphics.Renderable;
import com.go.gl.graphics.Texture;
import com.go.gl.graphics.TextureShader;
import com.go.gl.view.GLView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aa
{
  private boolean A;
  private long B;
  private boolean C;
  private int D;
  private long E = 400L;
  private float F = 0.0F;
  private float G = 0.0F;
  private int H = -1;
  private int I = -1;
  private boolean J;
  private long K;
  private int L;
  private int M;
  private boolean N;
  private Renderable O = new ab(this);
  protected ArrayList a = new ArrayList();
  private GLView b;
  private Bitmap c;
  private Texture d;
  private TextureShader e;
  private List f;
  private l[] g = new l[6];
  private float h;
  private float i;
  private float j;
  private int k;
  private int l;
  private FloatBuffer m;
  private FloatBuffer n;
  private ShortBuffer o;
  private float p = 0.0F;
  private BitmapGLDrawable q;
  private GLDrawable r;
  private GLDrawable s;
  private float t;
  private float u;
  private int v = 60;
  private int w = 48;
  private float x;
  private float y;
  private int z;
  
  public aa(GLView paramGLView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, boolean paramBoolean, float paramFloat6, float paramFloat7)
  {
    this.b = paramGLView;
    this.e = TextureShader.getShader(16);
    this.f = new ArrayList();
    this.h = (paramFloat1 / 2.0F);
    this.i = paramFloat2;
    this.j = paramFloat3;
    this.t = paramFloat4;
    this.u = paramFloat5;
    this.F = paramFloat6;
    this.G = paramFloat7;
    f();
    c();
  }
  
  private void f()
  {
    m localm1 = a(this.h, this.i + this.F, 0.0F);
    m localm2 = a(-this.h, this.i + this.F, 0.0F);
    m localm3 = a(-this.h, this.F + 0.0F, 0.0F);
    m localm4 = a(this.h, this.F + 0.0F, 0.0F);
    localm1.a(1.0F, 0.0F);
    localm2.a(0.0F, 0.0F);
    localm3.a(0.0F, 1.0F);
    localm4.a(1.0F, 1.0F);
    this.g[0] = new l(localm1, localm2, localm3, localm4);
    localm1 = a(this.h, this.i + this.G, -this.j);
    localm2 = a(-this.h, this.i + this.G, -this.j);
    localm3 = a(-this.h, this.i + this.F, 0.0F);
    localm4 = a(this.h, this.i + this.F, 0.0F);
    localm1.a(1.0F, 0.0F);
    localm2.a(0.0F, 0.0F);
    localm3.a(0.0F, 1.0F);
    localm4.a(1.0F, 1.0F);
    this.g[1] = new l(localm1, localm2, localm3, localm4);
    localm1 = a(this.h, this.G + 0.0F, -this.j);
    localm2 = a(-this.h, this.G + 0.0F, -this.j);
    localm3 = a(-this.h, this.i + this.G, -this.j);
    localm4 = a(this.h, this.i + this.G, -this.j);
    localm1.a(1.0F, 0.0F);
    localm2.a(0.0F, 0.0F);
    localm3.a(0.0F, 1.0F);
    localm4.a(1.0F, 1.0F);
    this.g[2] = new l(localm1, localm2, localm3, localm4);
    localm1 = a(this.h, this.F + 0.0F, 0.0F);
    localm2 = a(-this.h, this.F + 0.0F, 0.0F);
    localm3 = a(-this.h, this.G + 0.0F, -this.j);
    localm4 = a(this.h, this.G + 0.0F, -this.j);
    localm1.a(1.0F, 0.0F);
    localm2.a(0.0F, 0.0F);
    localm3.a(0.0F, 1.0F);
    localm4.a(1.0F, 1.0F);
    this.g[3] = new l(localm1, localm2, localm3, localm4);
    localm1 = a(-this.h, this.i + this.F, 0.0F);
    localm2 = a(-this.h, this.i + this.G, -this.j);
    localm3 = a(-this.h, this.G + 0.0F, -this.j);
    localm4 = a(-this.h, this.F + 0.0F, 0.0F);
    localm1.a(1.0F, 0.0F);
    localm2.a(0.0F, 0.0F);
    localm3.a(0.0F, 1.0F);
    localm4.a(1.0F, 1.0F);
    this.g[4] = new l(localm1, localm2, localm3, localm4);
    localm1 = a(this.h, this.i + this.G, -this.j);
    localm2 = a(this.h, this.i + this.F, 0.0F);
    localm3 = a(this.h, this.F + 0.0F, 0.0F);
    localm4 = a(this.h, this.G + 0.0F, -this.j);
    localm1.a(1.0F, 0.0F);
    localm2.a(0.0F, 0.0F);
    localm3.a(0.0F, 1.0F);
    localm4.a(1.0F, 1.0F);
    this.g[5] = new l(localm1, localm2, localm3, localm4);
  }
  
  private void g()
  {
    float f1 = Math.max(0.0F, Math.min((float)(AnimationUtils.currentAnimationTimeMillis() - this.K) * 1.0F / (float)this.E, 1.0F));
    if ((this.N) && (f1 >= 0.5F)) {
      this.N = false;
    }
    Object localObject;
    if (f1 == 1.0F) {
      if (this.H != this.I)
      {
        this.H = this.I;
        this.I = -1;
        localObject = this.r.getBitmap();
        if (this.s == null) {
          this.s = new BitmapGLDrawable(this.b.getResources(), (Bitmap)localObject);
        }
      }
      else
      {
        this.J = false;
      }
    }
    for (;;)
    {
      this.b.invalidate();
      return;
      localObject = BitmapTexture.createSharedTexture((Bitmap)localObject);
      this.s.setTexture((Texture)localObject);
      break;
      this.L = ((int)((1.0F - f1) * 255.0F));
      this.M = ((int)(f1 * 255.0F));
    }
  }
  
  private void h()
  {
    float f1 = Math.max(0.0F, Math.min((float)(AnimationUtils.currentAnimationTimeMillis() - this.B) * 1.0F / (float)this.E, 1.0F));
    if (f1 == 1.0F) {
      this.A = false;
    }
    float f2;
    if (this.C)
    {
      f2 = b(f1);
      float f3 = this.x;
      this.p = (f2 * (this.y - this.x) + f3);
      f2 = c(f1);
      f3 = this.x;
      this.D = (-(int)((f2 * (this.y - this.x) + f3) * this.i) - 5);
      this.z = ((int)(f1 * 255.0F));
    }
    for (;;)
    {
      this.b.invalidate();
      return;
      f2 = this.x;
      this.p = (f1 * (this.y - this.x) + f2);
      this.D = (-(int)(this.i * this.p) - 5);
    }
  }
  
  public m a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    m localm = new m(paramFloat1, paramFloat2, paramFloat3, this.f.size());
    this.f.add(localm);
    return localm;
  }
  
  public void a()
  {
    this.p = 0.0F;
    this.D = (-(int)(this.i * this.p) - 5);
    this.z = 0;
  }
  
  public void a(float paramFloat)
  {
    this.p = paramFloat;
    this.D = (-(int)(this.i * this.p) - 5);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    this.h = (paramFloat1 / 2.0F);
    this.i = paramFloat2;
    this.j = paramFloat3;
    this.t = paramFloat4;
    this.u = paramFloat5;
    this.D = (-(int)(this.i * this.p) - 5);
    this.g[0].a.a(this.h, this.i, 0.0F);
    this.g[0].b.a(-this.h, this.i, 0.0F);
    this.g[0].c.a(-this.h, 0.0F, 0.0F);
    this.g[0].d.a(this.h, 0.0F, 0.0F);
    this.g[1].a.a(this.h, this.i, -this.j);
    this.g[1].b.a(-this.h, this.i, -this.j);
    this.g[1].c.a(-this.h, this.i, 0.0F);
    this.g[1].d.a(this.h, this.i, 0.0F);
    this.g[2].a.a(this.h, 0.0F, -this.j);
    this.g[2].b.a(-this.h, 0.0F, -this.j);
    this.g[2].c.a(-this.h, this.i, -this.j);
    this.g[2].d.a(this.h, this.i, -this.j);
    this.g[3].a.a(this.h, 0.0F, 0.0F);
    this.g[3].b.a(-this.h, 0.0F, 0.0F);
    this.g[3].c.a(-this.h, 0.0F, -this.j);
    this.g[3].d.a(this.h, 0.0F, -this.j);
    this.g[4].a.a(-this.h, this.i, 0.0F);
    this.g[4].b.a(-this.h, this.i, -this.j);
    this.g[4].c.a(-this.h, 0.0F, -this.j);
    this.g[4].d.a(-this.h, 0.0F, 0.0F);
    this.g[5].a.a(this.h, this.i, -this.j);
    this.g[5].b.a(this.h, this.i, 0.0F);
    this.g[5].c.a(this.h, 0.0F, 0.0F);
    this.g[5].d.a(this.h, 0.0F, -this.j);
    try
    {
      this.m.position(0);
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext()) {
        ((m)localIterator.next()).a(this.m);
      }
    }
    finally {}
  }
  
  public void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this.A = true;
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.C = paramBoolean;
    if (paramBoolean) {}
    for (this.E = 800L;; this.E = 400L)
    {
      this.B = AnimationUtils.currentAnimationTimeMillis();
      this.b.invalidate();
      return;
    }
  }
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    this.A = true;
    this.x = this.p;
    this.y = paramFloat;
    this.C = paramBoolean;
    if (paramBoolean) {}
    for (this.E = 800L;; this.E = 400L)
    {
      this.B = AnimationUtils.currentAnimationTimeMillis();
      this.b.invalidate();
      return;
    }
  }
  
  public void a(int paramInt)
  {
    this.c = BitmapFactory.decodeResource(this.b.getResources(), paramInt);
    this.d = new BitmapTexture(this.c);
    this.d.register();
  }
  
  public void a(GLCanvas paramGLCanvas)
  {
    float f1 = 1.0F;
    paramGLCanvas.setDepthEnable(true);
    if (this.A) {
      h();
    }
    paramGLCanvas.save();
    paramGLCanvas.scale(1.0F, this.p);
    int i1 = paramGLCanvas.getAlpha();
    if (i1 < 255) {
      f1 = i1 * 0.003921569F;
    }
    RenderContext localRenderContext = RenderContext.acquire();
    localRenderContext.shader = this.e;
    localRenderContext.texture = this.d;
    localRenderContext.alpha = f1;
    paramGLCanvas.getFinalMatrix(localRenderContext);
    paramGLCanvas.addRenderable(this.O, localRenderContext);
    paramGLCanvas.restore();
    paramGLCanvas.setDepthEnable(false);
    int i2 = (int)-this.h;
    int i3 = -(int)(this.i * this.p);
    int i4 = (int)(i2 + this.h * 2.0F);
    int i5 = (int)(i3 + this.h * 2.0F * 0.8D);
    if ((this.q != null) && (i5 <= 10))
    {
      this.q.setBounds(i2, i3, i4, i5);
      this.q.draw(paramGLCanvas);
    }
    if (this.J)
    {
      g();
      i3 = this.D;
      i4 = (int)(i3 - this.u);
      i2 = (int)(i2 + (this.h - this.t / 2.0F));
      i5 = (int)(i2 + this.t);
      if (this.s != null)
      {
        paramGLCanvas.setAlpha(this.L);
        this.s.setBounds(i2, i4, i5, i3);
        this.s.draw(paramGLCanvas);
      }
      if (this.r != null)
      {
        paramGLCanvas.setAlpha(this.M);
        this.r.setBounds(i2, i4, i5, i3);
        this.r.draw(paramGLCanvas);
      }
      paramGLCanvas.setAlpha(i1);
    }
    while (this.s == null) {
      return;
    }
    if (this.A) {
      paramGLCanvas.setAlpha(this.z);
    }
    i3 = this.D;
    i4 = (int)(i3 - this.u);
    i2 = (int)(i2 + (this.h - this.t / 2.0F));
    i5 = (int)(i2 + this.t);
    this.s.setBounds(i2, i4, i5, i3);
    this.s.draw(paramGLCanvas);
    paramGLCanvas.setAlpha(i1);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramString = o.a(this.b.getContext(), paramString, this.v, this.w); this.q == null; paramString = o.b(this.b.getContext(), paramString, this.v, this.w))
    {
      this.q = new BitmapGLDrawable(this.b.getResources(), paramString);
      return;
    }
    paramString = BitmapTexture.createSharedTexture(paramString);
    this.q.setTexture(paramString);
  }
  
  public void a(ShortBuffer paramShortBuffer)
  {
    l[] arrayOfl = this.g;
    int i2 = arrayOfl.length;
    int i1 = 0;
    while (i1 < i2)
    {
      l locall = arrayOfl[i1];
      if (locall != null) {
        locall.a(paramShortBuffer);
      }
      i1 += 1;
    }
  }
  
  public float b(float paramFloat)
  {
    if (paramFloat <= 0.25F) {
      return (float)Math.pow(paramFloat / 0.25F, 2.0D);
    }
    paramFloat = (paramFloat - 0.25F) / 0.75F;
    return (float)((float)Math.sin(3.0F * paramFloat * 6.283185307179586D) * Math.pow(2.0D, paramFloat * -5.0F) * 0.6000000238418579D + 1.0D);
  }
  
  public int b()
  {
    int i2 = 0;
    l[] arrayOfl = this.g;
    int i4 = arrayOfl.length;
    int i1 = 0;
    while (i1 < i4)
    {
      l locall = arrayOfl[i1];
      int i3 = i2;
      if (locall != null) {
        i3 = i2 + locall.a();
      }
      i1 += 1;
      i2 = i3;
    }
    return i2;
  }
  
  public void b(int paramInt)
  {
    this.I = paramInt;
    if (this.r == null)
    {
      this.r = new BitmapGLDrawable((BitmapDrawable)this.b.getResources().getDrawable(paramInt));
      return;
    }
    BitmapTexture localBitmapTexture = BitmapTexture.createSharedTexture(BitmapFactory.decodeResource(this.b.getResources(), paramInt));
    this.r.setTexture(localBitmapTexture);
  }
  
  public float c(float paramFloat)
  {
    if (paramFloat <= 0.36F) {
      return (float)Math.pow(paramFloat / 0.36F, 2.0D);
    }
    paramFloat = (paramFloat - 0.36F) / 0.64F;
    return (float)((float)Math.sin(3.0F * paramFloat * 6.283185307179586D) * Math.pow(2.0D, paramFloat * -5.0F) * 0.6000000238418579D + 1.0D);
  }
  
  public void c()
  {
    this.k = this.f.size();
    this.l = b();
    Object localObject = ByteBuffer.allocateDirect(this.k * 4 * 3);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    this.m = ((ByteBuffer)localObject).asFloatBuffer();
    localObject = ByteBuffer.allocateDirect(this.k * 4 * 2);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    this.n = ((ByteBuffer)localObject).asFloatBuffer();
    localObject = ByteBuffer.allocateDirect(this.l * 2);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    this.o = ((ByteBuffer)localObject).asShortBuffer();
    localObject = this.f.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((m)((Iterator)localObject).next()).a(this.m, this.n);
    }
    a(this.o);
  }
  
  public void c(int paramInt)
  {
    Object localObject = BitmapFactory.decodeResource(this.b.getResources(), paramInt);
    if (this.s == null)
    {
      this.s = new BitmapGLDrawable(this.b.getResources(), (Bitmap)localObject);
      return;
    }
    localObject = BitmapTexture.createSharedTexture((Bitmap)localObject);
    this.s.setTexture((Texture)localObject);
  }
  
  public void d()
  {
    if (this.I == this.H) {
      return;
    }
    this.J = true;
    this.N = true;
    this.K = AnimationUtils.currentAnimationTimeMillis();
    this.b.invalidate();
  }
  
  public void e()
  {
    if (this.d != null)
    {
      this.d.unregister();
      this.d.clear();
    }
    if (this.q != null)
    {
      this.q.clear();
      this.q = null;
    }
    if (this.s != null)
    {
      this.s.clear();
      this.s = null;
    }
    if (this.r != null)
    {
      this.r.clear();
      this.r = null;
    }
    if ((this.c != null) && (!this.c.isRecycled()))
    {
      this.c.recycle();
      this.c = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/weatherwidget/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */