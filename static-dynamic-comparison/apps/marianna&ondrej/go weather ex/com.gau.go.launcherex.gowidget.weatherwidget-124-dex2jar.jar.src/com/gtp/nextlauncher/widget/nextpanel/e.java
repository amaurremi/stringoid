package com.gtp.nextlauncher.widget.nextpanel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.go.gl.graphics.GLDrawable;
import com.go.gl.view.GLContentView;
import com.go.gl.view.GLView;
import java.lang.ref.SoftReference;

public class e
{
  private static e a;
  private final int A = 6;
  private GLDrawable[] B = new GLDrawable[6];
  private GLDrawable C;
  private GLDrawable D;
  private GLDrawable E;
  private GLDrawable F;
  private GLDrawable G;
  private final int H = 8;
  private GLDrawable[] I = new GLDrawable[8];
  private GLDrawable[] J = new GLDrawable[8];
  private GLDrawable K;
  private GLDrawable L;
  private GLDrawable M;
  private GLDrawable N;
  private GLDrawable O;
  private GLDrawable P;
  private GLDrawable Q;
  private GLDrawable R;
  private GLDrawable S;
  private GLDrawable T;
  private GLDrawable b;
  private GLDrawable c;
  private GLDrawable d;
  private GLDrawable e;
  private GLDrawable f;
  private GLDrawable g;
  private GLDrawable h;
  private GLDrawable i;
  private GLDrawable j;
  private GLDrawable k;
  private GLDrawable l;
  private GLDrawable m;
  private GLDrawable n;
  private GLDrawable o;
  private SoftReference p;
  private SoftReference q;
  private SoftReference r;
  private GLDrawable s;
  private GLDrawable t;
  private GLDrawable u;
  private GLDrawable v;
  private GLDrawable w;
  private GLDrawable x;
  private GLDrawable y;
  private GLDrawable z;
  
  public static e a()
  {
    if (a == null) {
      a = new e();
    }
    return a;
  }
  
  public static void a(GLView paramGLView, GLDrawable paramGLDrawable, int paramInt1, int paramInt2, float paramFloat1, float[] paramArrayOfFloat1, float paramFloat2, float paramFloat3, float[] paramArrayOfFloat2)
  {
    if ((paramGLDrawable == null) || (paramGLView == null)) {}
    do
    {
      return;
      paramGLView = paramGLView.getGLRootView();
    } while (paramGLView == null);
    int i2 = 1;
    int i1 = i2;
    if (-1.0F == paramArrayOfFloat1[0])
    {
      i1 = i2;
      if (paramArrayOfFloat1[1] != -1.0F) {
        i1 = 0;
      }
    }
    float f3 = paramFloat1;
    if (paramFloat1 == -1.0F) {
      f3 = 1.0F;
    }
    float f1 = paramFloat2;
    if (paramFloat2 == -1.0F) {
      f1 = 0.5F;
    }
    float f2 = paramFloat3;
    if (paramFloat3 == -1.0F) {
      f2 = 0.5F;
    }
    paramFloat3 = paramGLView.getDepthForProjectScale(f3);
    i2 = paramGLDrawable.getIntrinsicWidth();
    int i3 = paramGLDrawable.getIntrinsicHeight();
    if ((paramArrayOfFloat1[0] == -1.0F) && (paramArrayOfFloat1[1] == -1.0F))
    {
      paramFloat2 = i2;
      paramFloat1 = i3;
    }
    for (;;)
    {
      paramInt1 = (int)(paramInt1 * f1 - paramFloat2 / 2.0F);
      i1 = (int)(paramFloat2 + paramInt1);
      paramInt2 = (int)(-paramInt2 * f2 + paramFloat1 / 2.0F);
      i2 = (int)(paramInt2 - paramFloat1);
      paramGLDrawable.setBounds3D(new float[] { paramInt1, paramInt2, paramFloat3, paramInt1, i2, paramFloat3, i1, paramInt2, paramFloat3 }, 0, 3, 6, false, false);
      if ((paramArrayOfFloat2 == null) || (paramArrayOfFloat2.length <= 1)) {
        break;
      }
      paramArrayOfFloat2[0] = ((paramInt1 + i1) / 2);
      paramArrayOfFloat2[1] = ((paramInt2 + i2) / 2);
      if (paramArrayOfFloat2.length <= 2) {
        break;
      }
      paramArrayOfFloat2[2] = paramFloat3;
      return;
      if (i1 != 0)
      {
        paramFloat2 = paramInt1 * paramArrayOfFloat1[0] / f3;
        paramFloat1 = (int)(paramFloat2 / i2 * i3);
      }
      else
      {
        paramFloat1 = paramInt2 * paramArrayOfFloat1[1] / f3;
        paramFloat2 = paramFloat1 / i3 * i2;
      }
    }
  }
  
  private boolean a(GLDrawable paramGLDrawable)
  {
    return (paramGLDrawable != null) && (!paramGLDrawable.isBitmapRecycled()) && (paramGLDrawable.getBitmap() != null);
  }
  
  private boolean a(SoftReference paramSoftReference)
  {
    return (paramSoftReference != null) && (paramSoftReference.get() != null) && (!((GLDrawable)paramSoftReference.get()).isBitmapRecycled()) && (((GLDrawable)paramSoftReference.get()).getBitmap() != null);
  }
  
  public GLDrawable A(Context paramContext)
  {
    if (!a(this.R))
    {
      try
      {
        Drawable localDrawable = a.a().a("panel_weather_full_cloud2", paramContext);
        if (localDrawable != null) {
          this.R = GLDrawable.getDrawable(localDrawable);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
        }
      }
      if (this.R == null) {
        this.R = L(paramContext);
      }
    }
    for (;;)
    {
      return this.R;
      this.R.duplicate();
    }
  }
  
  public GLDrawable B(Context paramContext)
  {
    if (!a(this.i))
    {
      try
      {
        Drawable localDrawable = a.a().a("panel_weather_cloud1", paramContext);
        if (localDrawable != null) {
          this.i = GLDrawable.getDrawable(localDrawable);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
        }
      }
      if (this.i == null) {
        this.i = L(paramContext);
      }
    }
    for (;;)
    {
      return this.i;
      this.i.duplicate();
    }
  }
  
  public GLDrawable C(Context paramContext)
  {
    if (!a(this.j))
    {
      try
      {
        Drawable localDrawable = a.a().a("panel_weather_full_cloud2", paramContext);
        if (localDrawable != null) {
          this.j = GLDrawable.getDrawable(localDrawable);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
        }
      }
      if (this.j == null) {
        this.j = L(paramContext);
      }
    }
    for (;;)
    {
      return this.j;
      this.j.duplicate();
    }
  }
  
  public GLDrawable D(Context paramContext)
  {
    if (!a(this.t))
    {
      Drawable localDrawable = a.a().a("panel_weather_snow", paramContext);
      if (localDrawable != null) {
        this.t = GLDrawable.getDrawable(localDrawable);
      }
      if (this.t == null) {
        this.t = L(paramContext);
      }
    }
    for (;;)
    {
      return this.t;
      this.t.duplicate();
    }
  }
  
  public GLDrawable E(Context paramContext)
  {
    if (!a(this.u))
    {
      Drawable localDrawable = a.a().a("panel_weather_snow", paramContext);
      if (localDrawable != null) {
        this.u = GLDrawable.getDrawable(localDrawable);
      }
      if (this.u == null) {
        this.u = L(paramContext);
      }
    }
    for (;;)
    {
      return this.u;
      this.u.duplicate();
    }
  }
  
  public GLDrawable F(Context paramContext)
  {
    if (!a(this.v))
    {
      Drawable localDrawable = a.a().a("panel_weather_snow", paramContext);
      if (localDrawable != null) {
        this.v = GLDrawable.getDrawable(localDrawable);
      }
      if (this.v == null) {
        this.v = L(paramContext);
      }
    }
    for (;;)
    {
      return this.v;
      this.v.duplicate();
    }
  }
  
  public GLDrawable G(Context paramContext)
  {
    if (!a(this.w))
    {
      Drawable localDrawable = a.a().a("panel_weather_rain", paramContext);
      if (localDrawable != null) {
        this.w = GLDrawable.getDrawable(localDrawable);
      }
      if (this.w == null) {
        this.w = L(paramContext);
      }
    }
    for (;;)
    {
      return this.w;
      this.w.duplicate();
    }
  }
  
  public GLDrawable H(Context paramContext)
  {
    if (!a(this.x))
    {
      Drawable localDrawable = a.a().a("panel_weather_rain", paramContext);
      if (localDrawable != null) {
        this.x = GLDrawable.getDrawable(localDrawable);
      }
      if (this.x == null) {
        this.x = L(paramContext);
      }
    }
    for (;;)
    {
      return this.x;
      this.x.duplicate();
    }
  }
  
  public GLDrawable I(Context paramContext)
  {
    if (!a(this.y))
    {
      Drawable localDrawable = a.a().a("panel_weather_rain", paramContext);
      if (localDrawable != null) {
        this.y = GLDrawable.getDrawable(localDrawable);
      }
      if (this.y == null) {
        this.y = L(paramContext);
      }
    }
    for (;;)
    {
      return this.y;
      this.y.duplicate();
    }
  }
  
  public GLDrawable J(Context paramContext)
  {
    if (!a(this.z))
    {
      try
      {
        Drawable localDrawable = a.a().a("panel_weather_water", paramContext);
        if (localDrawable != null) {
          this.z = GLDrawable.getDrawable(localDrawable);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
        }
      }
      if (this.z == null) {
        this.z = L(paramContext);
      }
    }
    for (;;)
    {
      return this.z;
      this.z.duplicate();
    }
  }
  
  public GLDrawable[] K(Context paramContext)
  {
    int i1 = 0;
    if (this.B == null) {
      this.B = new GLDrawable[6];
    }
    if (i1 < 6)
    {
      if (!a(this.B[i1]))
      {
        Drawable localDrawable = a.a().a(new String[] { "panel_weather_thunder1", "panel_weather_thunder2", "panel_weather_thunder3", "panel_weather_thunder4", "panel_weather_thunder5", "panel_weather_thunder6" }[i1], paramContext);
        if (localDrawable != null) {
          this.B[i1] = GLDrawable.getDrawable(localDrawable);
        }
        if (this.B[i1] == null) {
          this.B[i1] = L(paramContext);
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        this.B[i1].duplicate();
      }
    }
    return this.B;
  }
  
  public GLDrawable L(Context paramContext)
  {
    if (!a(this.S)) {
      this.S = GLDrawable.getDrawable(paramContext.getResources(), 2130839064);
    }
    for (;;)
    {
      return this.S;
      this.S.duplicate();
    }
  }
  
  public GLDrawable M(Context paramContext)
  {
    if (!a(this.T))
    {
      Drawable localDrawable = a.a().a("panel_weather_n_a", paramContext);
      if (localDrawable != null) {
        this.T = GLDrawable.getDrawable(localDrawable);
      }
      if (this.T == null) {
        this.T = L(paramContext);
      }
    }
    for (;;)
    {
      return this.T;
      this.T.duplicate();
    }
  }
  
  public GLDrawable a(Context paramContext)
  {
    if (!a(this.K))
    {
      try
      {
        Drawable localDrawable = a.a().a("panel_weather_to_left", paramContext);
        if (localDrawable != null) {
          this.K = GLDrawable.getDrawable(localDrawable);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
        }
      }
      if (this.K == null) {
        this.K = L(paramContext);
      }
    }
    for (;;)
    {
      return this.K;
      this.K.duplicate();
    }
  }
  
  public GLDrawable b(Context paramContext)
  {
    if (!a(this.L))
    {
      try
      {
        Drawable localDrawable = a.a().a("panel_weather_to_right", paramContext);
        if (localDrawable != null) {
          this.L = GLDrawable.getDrawable(localDrawable);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
        }
      }
      if (this.L == null) {
        this.L = L(paramContext);
      }
    }
    for (;;)
    {
      return this.L;
      this.L.duplicate();
    }
  }
  
  public void b()
  {
    if (this.b != null)
    {
      this.b.clear();
      this.b = null;
    }
    if (this.g != null)
    {
      this.g.clear();
      this.g = null;
    }
    if (this.c != null)
    {
      this.c.clear();
      this.c = null;
    }
    if (this.O != null)
    {
      this.O.clear();
      this.O = null;
    }
    if (this.d != null)
    {
      this.d.clear();
      this.d = null;
    }
    if (this.e != null)
    {
      this.e.clear();
      this.e = null;
    }
    if (this.f != null)
    {
      this.f.clear();
      this.f = null;
    }
    if (this.h != null)
    {
      this.h.clear();
      this.h = null;
    }
    if (this.i != null)
    {
      this.i.clear();
      this.i = null;
    }
    if (this.j != null)
    {
      this.j.clear();
      this.j = null;
    }
    if (this.k != null)
    {
      this.k.clear();
      this.k = null;
    }
    if (this.l != null)
    {
      this.l.clear();
      this.l = null;
    }
    if (this.m != null)
    {
      this.m.clear();
      this.m = null;
    }
    if (this.n != null)
    {
      this.n.clear();
      this.n = null;
    }
    if (this.o != null)
    {
      this.o.clear();
      this.o = null;
    }
    GLDrawable localGLDrawable;
    if (this.p != null)
    {
      localGLDrawable = (GLDrawable)this.p.get();
      if (localGLDrawable != null) {
        localGLDrawable.clear();
      }
      this.p.clear();
      this.p = null;
    }
    if (this.q != null)
    {
      localGLDrawable = (GLDrawable)this.q.get();
      if (localGLDrawable != null) {
        localGLDrawable.clear();
      }
      this.q.clear();
      this.q = null;
    }
    if (this.r != null)
    {
      localGLDrawable = (GLDrawable)this.r.get();
      if (localGLDrawable != null) {
        localGLDrawable.clear();
      }
      this.r.clear();
      this.r = null;
    }
    if (this.s != null)
    {
      this.s.clear();
      this.s = null;
    }
    if (this.t != null)
    {
      this.t.clear();
      this.t = null;
    }
    if (this.u != null)
    {
      this.u.clear();
      this.u = null;
    }
    if (this.v != null)
    {
      this.v.clear();
      this.v = null;
    }
    if (this.w != null)
    {
      this.w.clear();
      this.w = null;
    }
    if (this.x != null)
    {
      this.x.clear();
      this.x = null;
    }
    if (this.y != null)
    {
      this.y.clear();
      this.y = null;
    }
    if (this.z != null)
    {
      this.z.clear();
      this.z = null;
    }
    if (this.C != null)
    {
      this.C.clear();
      this.C = null;
    }
    if (this.D != null)
    {
      this.D.clear();
      this.D = null;
    }
    if (this.B != null)
    {
      i1 = 0;
      while (i1 < 6)
      {
        if (this.B[i1] != null)
        {
          this.B[i1].clear();
          this.B[i1] = null;
        }
        i1 += 1;
      }
      this.B = null;
    }
    if (this.E != null)
    {
      this.E.clear();
      this.E = null;
    }
    if (this.F != null)
    {
      this.F.clear();
      this.F = null;
    }
    if (this.G != null)
    {
      this.G.clear();
      this.G = null;
    }
    int i1 = 0;
    while (i1 < 8)
    {
      if (this.J != null)
      {
        if (this.J[i1] != null)
        {
          this.J[i1].clear();
          this.J[i1] = null;
        }
        this.J = null;
      }
      if (this.I != null)
      {
        if (this.I[i1] != null)
        {
          this.I[i1].clear();
          this.I[i1] = null;
        }
        this.I = null;
      }
      i1 += 1;
    }
    if (this.M != null)
    {
      this.M.clear();
      this.M = null;
    }
    if (this.K != null)
    {
      this.K.clear();
      this.K = null;
    }
    if (this.L != null)
    {
      this.L.clear();
      this.L = null;
    }
    if (this.S != null)
    {
      this.S.clear();
      this.S = null;
    }
    if (this.T != null)
    {
      this.T.clear();
      this.T = null;
    }
  }
  
  public GLDrawable c(Context paramContext)
  {
    if (!a(this.M))
    {
      try
      {
        Drawable localDrawable = a.a().a("panel_weather_to_fore", paramContext);
        if (localDrawable != null) {
          this.M = GLDrawable.getDrawable(localDrawable);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
        }
      }
      if (this.M == null) {
        this.M = L(paramContext);
      }
    }
    for (;;)
    {
      return this.M;
      this.M.duplicate();
    }
  }
  
  public GLDrawable d(Context paramContext)
  {
    if (!a(this.N))
    {
      try
      {
        Drawable localDrawable = a.a().a("panel_weather_from_fore", paramContext);
        if (localDrawable != null) {
          this.N = GLDrawable.getDrawable(localDrawable);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
        }
      }
      if (this.N == null) {
        this.N = L(paramContext);
      }
    }
    for (;;)
    {
      return this.N;
      this.N.duplicate();
    }
  }
  
  public GLDrawable[] e(Context paramContext)
  {
    if (this.I == null) {
      this.I = new GLDrawable[8];
    }
    int i1 = 0;
    if (i1 < 8)
    {
      if (!a(this.I[i1])) {}
      for (;;)
      {
        try
        {
          this.I[i1] = GLDrawable.getDrawable(paramContext.getResources(), new int[] { 2130838176, 2130838170, 2130838156, 2130838160, 2130838168, 2130838162, 2130838166, 2130838174 }[i1]);
          i1 += 1;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localOutOfMemoryError.printStackTrace();
          continue;
        }
        this.I[i1].duplicate();
      }
    }
    return this.I;
  }
  
  public GLDrawable[] f(Context paramContext)
  {
    if (this.J == null) {
      this.J = new GLDrawable[8];
    }
    int i1 = 0;
    if (i1 < 8)
    {
      if (!a(this.J[i1])) {}
      for (;;)
      {
        try
        {
          this.J[i1] = GLDrawable.getDrawable(paramContext.getResources(), new int[] { 2130838177, 2130838171, 2130838157, 2130838161, 2130838169, 2130838163, 2130838167, 2130838175 }[i1]);
          i1 += 1;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localOutOfMemoryError.printStackTrace();
          continue;
        }
        this.J[i1].duplicate();
      }
    }
    return this.J;
  }
  
  public GLDrawable g(Context paramContext)
  {
    if (!a(this.s))
    {
      try
      {
        Drawable localDrawable = a.a().a("panel_weather_rainy_wall", paramContext);
        if (localDrawable != null) {
          this.s = GLDrawable.getDrawable(localDrawable);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
        }
      }
      if (this.s == null) {
        this.s = L(paramContext);
      }
    }
    for (;;)
    {
      return this.s;
      this.s.duplicate();
    }
  }
  
  public GLDrawable h(Context paramContext)
  {
    if (!a(this.p)) {
      try
      {
        paramContext = a.a().a("panel_weather_fog_c1", paramContext);
        if (paramContext != null) {
          this.p = new SoftReference(GLDrawable.getDrawable(paramContext));
        }
        paramContext = (GLDrawable)this.p.get();
        return paramContext;
      }
      catch (OutOfMemoryError paramContext)
      {
        paramContext.printStackTrace();
        return null;
      }
    }
    ((GLDrawable)this.p.get()).duplicate();
    return (GLDrawable)this.p.get();
  }
  
  public GLDrawable i(Context paramContext)
  {
    if (!a(this.q)) {
      try
      {
        paramContext = a.a().a("panel_weather_fog_c2", paramContext);
        if (paramContext != null) {
          this.q = new SoftReference(GLDrawable.getDrawable(paramContext));
        }
        paramContext = (GLDrawable)this.q.get();
        return paramContext;
      }
      catch (OutOfMemoryError paramContext)
      {
        paramContext.printStackTrace();
        return null;
      }
    }
    ((GLDrawable)this.q.get()).duplicate();
    return (GLDrawable)this.q.get();
  }
  
  public GLDrawable j(Context paramContext)
  {
    if (!a(this.r)) {
      try
      {
        paramContext = a.a().a("panel_weather_fog_c2", paramContext);
        if (paramContext != null) {
          this.r = new SoftReference(GLDrawable.getDrawable(paramContext));
        }
        paramContext = (GLDrawable)this.r.get();
        return paramContext;
      }
      catch (OutOfMemoryError paramContext)
      {
        paramContext.printStackTrace();
        return null;
      }
    }
    ((GLDrawable)this.r.get()).duplicate();
    return (GLDrawable)this.r.get();
  }
  
  public GLDrawable k(Context paramContext)
  {
    if (!a(this.l))
    {
      try
      {
        Drawable localDrawable = a.a().a("panel_weather_night_sky", paramContext);
        if (localDrawable != null) {
          this.l = GLDrawable.getDrawable(localDrawable);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
        }
      }
      if (this.l == null) {
        this.l = L(paramContext);
      }
    }
    for (;;)
    {
      return this.l;
      this.l.duplicate();
    }
  }
  
  public GLDrawable l(Context paramContext)
  {
    if (!a(this.m))
    {
      try
      {
        Drawable localDrawable = a.a().a("panel_weather_full_start", paramContext);
        if (localDrawable != null) {
          this.m = GLDrawable.getDrawable(localDrawable);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
        }
      }
      if (this.m == null) {
        this.m = L(paramContext);
      }
    }
    for (;;)
    {
      return this.m;
      this.m.duplicate();
    }
  }
  
  public GLDrawable m(Context paramContext)
  {
    if (!a(this.n))
    {
      try
      {
        Drawable localDrawable = a.a().a("panel_weather_full_start", paramContext);
        if (localDrawable != null) {
          this.n = GLDrawable.getDrawable(localDrawable);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
        }
      }
      if (this.n == null) {
        this.n = L(paramContext);
      }
    }
    for (;;)
    {
      return this.n;
      this.n.duplicate();
    }
  }
  
  public GLDrawable n(Context paramContext)
  {
    if (!a(this.o))
    {
      try
      {
        Drawable localDrawable = a.a().a("panel_weather_full_start", paramContext);
        if (localDrawable != null) {
          this.o = GLDrawable.getDrawable(localDrawable);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
        }
      }
      if (this.o == null) {
        this.o = L(paramContext);
      }
    }
    for (;;)
    {
      return this.o;
      this.o.duplicate();
    }
  }
  
  public GLDrawable o(Context paramContext)
  {
    if (!a(this.c))
    {
      try
      {
        Drawable localDrawable = a.a().a("panel_weather_light1", paramContext);
        if (localDrawable != null) {
          this.c = GLDrawable.getDrawable(localDrawable);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
        }
      }
      if (this.c == null) {
        this.c = L(paramContext);
      }
    }
    for (;;)
    {
      return this.c;
      this.c.duplicate();
    }
  }
  
  public GLDrawable p(Context paramContext)
  {
    if (!a(this.d))
    {
      try
      {
        Drawable localDrawable = a.a().a("panel_weather_light2", paramContext);
        if (localDrawable != null) {
          this.d = GLDrawable.getDrawable(localDrawable);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
        }
      }
      if (this.d == null) {
        this.d = L(paramContext);
      }
    }
    for (;;)
    {
      return this.d;
      this.d.duplicate();
    }
  }
  
  public GLDrawable q(Context paramContext)
  {
    if (!a(this.e))
    {
      try
      {
        Drawable localDrawable = a.a().a("panel_weather_light3", paramContext);
        if (localDrawable != null) {
          this.e = GLDrawable.getDrawable(localDrawable);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
        }
      }
      if (this.e == null) {
        this.e = L(paramContext);
      }
    }
    for (;;)
    {
      return this.e;
      this.e.duplicate();
    }
  }
  
  public GLDrawable r(Context paramContext)
  {
    if (!a(this.f))
    {
      try
      {
        Drawable localDrawable = a.a().a("panel_weather_light4", paramContext);
        if (localDrawable != null) {
          this.f = GLDrawable.getDrawable(localDrawable);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
        }
      }
      if (this.f == null) {
        this.f = L(paramContext);
      }
    }
    for (;;)
    {
      return this.f;
      this.f.duplicate();
    }
  }
  
  public GLDrawable s(Context paramContext)
  {
    if (!a(this.b))
    {
      try
      {
        Drawable localDrawable = a.a().a("panel_weather_sun", paramContext);
        if (localDrawable != null) {
          this.b = GLDrawable.getDrawable(localDrawable);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
        }
      }
      if (this.b == null) {
        this.b = L(paramContext);
      }
    }
    for (;;)
    {
      return this.b;
      this.b.duplicate();
    }
  }
  
  public GLDrawable t(Context paramContext)
  {
    if (!a(this.k))
    {
      try
      {
        Drawable localDrawable = a.a().a("panel_weather_wall", paramContext);
        if (localDrawable != null) {
          this.k = GLDrawable.getDrawable(localDrawable);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
        }
      }
      if (this.k == null) {
        this.k = L(paramContext);
      }
    }
    for (;;)
    {
      return this.k;
      this.k.duplicate();
    }
  }
  
  public GLDrawable u(Context paramContext)
  {
    if (!a(this.g))
    {
      try
      {
        Drawable localDrawable = a.a().a("panel_weather_full_moon", paramContext);
        if (localDrawable != null) {
          this.g = GLDrawable.getDrawable(localDrawable);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
        }
      }
      if (this.g == null) {
        this.g = L(paramContext);
      }
    }
    for (;;)
    {
      return this.g;
      this.g.duplicate();
    }
  }
  
  public GLDrawable v(Context paramContext)
  {
    if (!a(this.D))
    {
      try
      {
        Drawable localDrawable = a.a().a("panel_weather_rain_cloud", paramContext);
        if (localDrawable != null) {
          this.D = GLDrawable.getDrawable(localDrawable);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
        }
      }
      if (this.D == null) {
        this.D = L(paramContext);
      }
    }
    for (;;)
    {
      return this.D;
      this.D.duplicate();
    }
  }
  
  public GLDrawable w(Context paramContext)
  {
    if (!a(this.O))
    {
      try
      {
        Drawable localDrawable = a.a().a("panel_weather_full_cloud0", paramContext);
        if (localDrawable != null) {
          this.O = GLDrawable.getDrawable(localDrawable);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
        }
      }
      if (this.O == null) {
        this.O = L(paramContext);
      }
    }
    for (;;)
    {
      return this.O;
      this.O.duplicate();
    }
  }
  
  public GLDrawable x(Context paramContext)
  {
    if (!a(this.h))
    {
      try
      {
        Drawable localDrawable = a.a().a("panel_weather_full_cloud0", paramContext);
        if (localDrawable != null) {
          this.h = GLDrawable.getDrawable(localDrawable);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
        }
      }
      if (this.h == null) {
        this.h = L(paramContext);
      }
    }
    for (;;)
    {
      return this.h;
      this.h.duplicate();
    }
  }
  
  public GLDrawable y(Context paramContext)
  {
    if (!a(this.P))
    {
      try
      {
        Drawable localDrawable = a.a().a("panel_weather_full_cloud0", paramContext);
        if (localDrawable != null) {
          this.P = GLDrawable.getDrawable(localDrawable);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
        }
      }
      if (this.P == null) {
        this.P = L(paramContext);
      }
    }
    for (;;)
    {
      return this.P;
      this.P.duplicate();
    }
  }
  
  public GLDrawable z(Context paramContext)
  {
    if (!a(this.Q))
    {
      try
      {
        Drawable localDrawable = a.a().a("panel_weather_cloud1", paramContext);
        if (localDrawable != null) {
          this.Q = GLDrawable.getDrawable(localDrawable);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
        }
      }
      if (this.Q == null) {
        this.Q = L(paramContext);
      }
    }
    for (;;)
    {
      return this.Q;
      this.Q.duplicate();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/nextpanel/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */