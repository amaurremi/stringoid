package com.gtp.nextlauncher.widget.weatherwidget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Handler;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import com.go.gl.graphics.BitmapGLDrawable;
import com.go.gl.graphics.GLCanvas;
import com.go.gl.graphics.GLDrawable;
import com.go.gl.graphics.NinePatchGLDrawable;
import com.go.gl.view.GLLinearLayout;
import com.go.gl.view.GLView;
import com.go.gl.widget.GLImageView;

public class GLDigitalClock
  extends GLLinearLayout
{
  private Rect A = new Rect();
  private Rect B = new Rect();
  private boolean C = false;
  private boolean D = false;
  private boolean E = false;
  private GLImageView F;
  private GLImageView G;
  private GLImageView H;
  private GLImageView I;
  private GLImageView J;
  private GLImageView K;
  private GLImageView L;
  private GLImageView M;
  private GLImageView N;
  private long O;
  private int P = 500;
  private boolean Q = false;
  private boolean R = false;
  private boolean S = false;
  private Handler T = new k(this);
  private float U;
  private int V;
  private int W;
  private int X = 0;
  private int Y = 0;
  private int Z = 0;
  private int a;
  private boolean aa = true;
  private int ab;
  private boolean ac = false;
  private float ad = 0.6F;
  private int b;
  private GLLinearLayout c = null;
  private GLLinearLayout d = null;
  private GLLinearLayout e = null;
  private GLLinearLayout f = null;
  private GLLinearLayout g = null;
  private GLImageView h = null;
  private z i;
  private int j;
  private int k;
  private int l;
  private int m;
  private float n = 0.0F;
  private int o;
  private int p = 0;
  private float q = 8.0F;
  private float r = 8.0F;
  private int s;
  private GLDrawable[] t = new GLDrawable[10];
  private GLDrawable u;
  private GLDrawable v;
  private Rect w = new Rect();
  private Rect x = new Rect();
  private Rect y = new Rect();
  private Rect z = new Rect();
  
  public GLDigitalClock(Context paramContext)
  {
    super(paramContext);
  }
  
  public GLDigitalClock(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private GLDrawable a(int paramInt)
  {
    Drawable localDrawable = getResources().getDrawable(paramInt);
    if ((localDrawable instanceof BitmapDrawable)) {
      return new BitmapGLDrawable((BitmapDrawable)localDrawable);
    }
    if ((localDrawable instanceof NinePatchDrawable)) {
      return new NinePatchGLDrawable((NinePatchDrawable)localDrawable);
    }
    return null;
  }
  
  private void a()
  {
    this.S = true;
    this.T.removeMessages(0);
    this.T.sendEmptyMessageDelayed(0, 500L);
  }
  
  private boolean b()
  {
    return DateFormat.is24HourFormat(getContext());
  }
  
  public void cleanup()
  {
    int i1 = 0;
    while (i1 < 10)
    {
      this.t[i1].clear();
      i1 += 1;
    }
    this.u.clear();
    this.v.clear();
    super.cleanup();
  }
  
  protected void dispatchDraw(GLCanvas paramGLCanvas)
  {
    if (this.O == -1L) {
      this.O = getDrawingTime();
    }
    if (this.Q)
    {
      float f1 = Math.max(0.0F, Math.min((float)(getDrawingTime() - this.O) / this.P, 1.0F));
      if (this.R) {
        onTimeAnimation(f1);
      }
    }
    int i1 = paramGLCanvas.save();
    if (this.aa) {
      paramGLCanvas.translate(this.N.getWidth(), 0.0F, 0.0F);
    }
    int i2 = paramGLCanvas.save();
    paramGLCanvas.translate(this.y.left, this.y.top);
    paramGLCanvas.clipRect(0.0F, 0.0F, this.c.getWidth(), this.c.getHeight());
    paramGLCanvas.translate(0.0F, -this.o + this.n + this.l + this.X);
    if (this.d.getVisibility() == 0) {
      this.d.draw(paramGLCanvas);
    }
    paramGLCanvas.translate(0.0F, this.o);
    if (this.c.getVisibility() == 0) {
      this.c.draw(paramGLCanvas);
    }
    paramGLCanvas.restoreToCount(i2);
    i2 = paramGLCanvas.save();
    paramGLCanvas.translate(0.0F, this.X);
    paramGLCanvas.translate(this.A.left, this.A.top);
    this.h.draw(paramGLCanvas);
    paramGLCanvas.restoreToCount(i2);
    i2 = paramGLCanvas.save();
    paramGLCanvas.translate(this.z.left, this.z.top);
    paramGLCanvas.clipRect(0.0F, 0.0F, this.e.getWidth(), this.e.getHeight());
    paramGLCanvas.translate(0.0F, -this.o + this.m + this.X);
    if (this.f.getVisibility() == 0) {
      this.f.draw(paramGLCanvas);
    }
    paramGLCanvas.translate(0.0F, this.o);
    if (this.e.getVisibility() == 0) {
      this.e.draw(paramGLCanvas);
    }
    paramGLCanvas.restoreToCount(i2);
    paramGLCanvas.save();
    if (!this.aa)
    {
      paramGLCanvas.translate(this.x.left, this.x.top);
      this.N.draw(paramGLCanvas);
    }
    paramGLCanvas.restoreToCount(i1);
  }
  
  public void initDigitalClock(z paramz)
  {
    this.i = paramz;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.N = ((GLImageView)findViewById(2131231293));
    this.N.setIsClearForUpdate(false);
    this.g = ((GLLinearLayout)findViewById(2131231277));
    this.c = ((GLLinearLayout)findViewById(2131231279));
    this.d = ((GLLinearLayout)findViewById(2131231282));
    this.F = ((GLImageView)findViewById(2131231280));
    this.F.setIsClearForUpdate(false);
    this.G = ((GLImageView)findViewById(2131231281));
    this.G.setIsClearForUpdate(false);
    this.H = ((GLImageView)findViewById(2131231283));
    this.H.setIsClearForUpdate(false);
    this.I = ((GLImageView)findViewById(2131231284));
    this.I.setIsClearForUpdate(false);
    this.e = ((GLLinearLayout)findViewById(2131231287));
    this.f = ((GLLinearLayout)findViewById(2131231290));
    this.J = ((GLImageView)findViewById(2131231288));
    this.J.setIsClearForUpdate(false);
    this.K = ((GLImageView)findViewById(2131231289));
    this.K.setIsClearForUpdate(false);
    this.L = ((GLImageView)findViewById(2131231291));
    this.L.setIsClearForUpdate(false);
    this.M = ((GLImageView)findViewById(2131231292));
    this.M.setIsClearForUpdate(false);
    int i1 = 0;
    while (i1 < 10)
    {
      this.t[i1] = a(new int[] { 2130838315, 2130838316, 2130838317, 2130838318, 2130838319, 2130838320, 2130838321, 2130838322, 2130838323, 2130838324 }[i1]);
      i1 += 1;
    }
    this.u = a(2130838290);
    this.v = a(2130838326);
    this.h = ((GLImageView)findViewById(2131231285));
    this.U = (this.t[0].getIntrinsicWidth() / this.t[0].getIntrinsicHeight());
    this.aa = b();
    invalidate();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = (int)((int)((paramInt3 - paramInt1) / 11.0D) / this.U);
    this.W = paramInt1;
    this.V = (paramInt1 / 2);
    this.Y = paramInt1;
    getWidth();
    getHeight();
    this.w.left = this.g.getLeft();
    this.w.top = this.g.getTop();
    this.w.right = this.g.getRight();
    this.w.bottom = this.g.getBottom();
    GLView localGLView = findViewById(2131231278);
    this.y.left = (this.c.getLeft() + localGLView.getLeft());
    Rect localRect = this.y;
    paramInt1 = this.c.getTop();
    localRect.top = (localGLView.getTop() + paramInt1);
    this.y.right = (this.y.left + this.c.getWidth());
    this.y.bottom = (this.y.top + this.c.getHeight());
    this.A.left = this.h.getLeft();
    this.A.right = this.h.getRight();
    this.A.top = this.h.getTop();
    this.A.bottom = this.h.getBottom();
    localGLView = findViewById(2131231286);
    this.z.left = (this.e.getLeft() + localGLView.getLeft());
    this.z.right = (this.z.left + this.e.getWidth());
    localRect = this.z;
    paramInt1 = this.e.getTop();
    localRect.top = (localGLView.getTop() + paramInt1);
    this.z.bottom = (this.z.top + this.e.getHeight());
    this.x.left = this.N.getLeft();
    this.x.right = this.N.getRight();
    this.x.top = this.N.getTop();
    this.x.bottom = this.N.getBottom();
    this.o = this.g.getHeight();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onTimeAnimation(float paramFloat)
  {
    if (this.C)
    {
      if (this.j != this.a) {
        this.l = ((int)(this.o * paramFloat));
      }
    }
    else if (this.D) {
      if (this.k == this.b) {
        break label83;
      }
    }
    label83:
    for (this.m = ((int)(this.o * paramFloat));; this.m = 0)
    {
      if (paramFloat == 1.0F) {
        onTimeAnimationEnd();
      }
      invalidate();
      return;
      this.l = 0;
      break;
    }
  }
  
  public void onTimeAnimationEnd()
  {
    this.l = 0;
    this.a = this.j;
    this.F.setImageDrawable(this.t[(this.a / 10)]);
    this.G.setImageDrawable(this.t[(this.a % 10)]);
    this.d.setVisibility(8);
    if (!this.aa)
    {
      this.N.setVisibility(0);
      if (this.ab > 11)
      {
        this.N.setImageDrawable(this.v);
        if (this.ab <= 11) {
          break label215;
        }
        this.N.setImageDrawable(this.v);
      }
    }
    for (;;)
    {
      this.m = 0;
      this.b = this.k;
      this.J.setImageDrawable(this.t[(this.b / 10)]);
      this.K.setImageDrawable(this.t[(this.b % 10)]);
      this.f.setVisibility(8);
      this.R = false;
      this.Q = false;
      invalidate();
      return;
      this.N.setImageDrawable(this.u);
      break;
      this.N.setVisibility(4);
      break;
      label215:
      this.N.setImageDrawable(this.u);
    }
  }
  
  public void onZoneAnimation(float paramFloat)
  {
    this.n = (this.o * this.s * paramFloat - this.p * this.o);
    if ((this.n >= this.o) || (paramFloat == 0.0F))
    {
      if (paramFloat != 0.0F) {
        this.p += 1;
      }
      if (this.j > this.a)
      {
        this.F.setImageDrawable(this.t[(this.a / 10)]);
        this.G.setImageDrawable(this.t[(this.a % 10)]);
        this.H.setImageDrawable(this.t[((this.a + 1) / 10)]);
        this.I.setImageDrawable(this.t[((this.a + 1) % 10)]);
        for (this.a += 1; this.a >= 24; this.a -= 24) {}
        while (this.a < 0) {
          this.a += 24;
        }
      }
      if (this.j < this.a)
      {
        this.F.setImageDrawable(this.t[(this.a / 10)]);
        this.G.setImageDrawable(this.t[(this.a % 10)]);
        this.H.setImageDrawable(this.t[((this.a - 1) / 10)]);
        this.I.setImageDrawable(this.t[((this.a - 1 + 24) % 24 % 10)]);
        this.a -= 1;
        if (this.a < 24) {
          break label456;
        }
        this.a -= 24;
      }
    }
    while ((this.k != this.b) && (paramFloat >= this.ad)) {
      if (!this.ac)
      {
        this.ac = true;
        this.f.setVisibility(0);
        this.J.setImageDrawable(this.t[(this.b / 10)]);
        this.K.setImageDrawable(this.t[(this.b % 10)]);
        this.L.setImageDrawable(this.t[(this.k / 10)]);
        this.M.setImageDrawable(this.t[(this.k % 10)]);
        this.m = 0;
        return;
        label456:
        if (this.a < 0) {
          this.a += 24;
        }
      }
      else
      {
        this.m = ((int)(Math.min(1.0F, Math.max(0.0F, (paramFloat - this.ad) / (1.0F - this.ad))) * this.o));
        return;
      }
    }
    this.m = 0;
  }
  
  public void onZoneChangeAnimationEnd()
  {
    this.a = this.j;
    this.b = this.k;
    this.r = this.q;
    this.n = 0.0F;
    this.m = 0;
    this.F.setImageDrawable(this.t[(this.a / 10)]);
    this.G.setImageDrawable(this.t[(this.a % 10)]);
    this.J.setImageDrawable(this.t[(this.b / 10)]);
    this.K.setImageDrawable(this.t[(this.b % 10)]);
    this.d.setVisibility(8);
    this.f.setVisibility(8);
    if (this.i.a() > 11) {
      this.N.setImageDrawable(this.v);
    }
    for (;;)
    {
      invalidate();
      return;
      this.N.setImageDrawable(this.u);
    }
  }
  
  public void setTimeDirectly(int paramInt1, int paramInt2)
  {
    this.aa = b();
    int i1;
    if (!this.aa)
    {
      this.N.setVisibility(0);
      if (paramInt1 > 11)
      {
        this.N.setImageDrawable(this.v);
        if (paramInt1 != 0) {
          break label152;
        }
        i1 = 12;
      }
    }
    for (;;)
    {
      this.a = i1;
      this.b = paramInt2;
      this.F.setImageDrawable(this.t[(this.a / 10)]);
      this.G.setImageDrawable(this.t[(this.a % 10)]);
      this.J.setImageDrawable(this.t[(this.b / 10)]);
      this.K.setImageDrawable(this.t[(this.b % 10)]);
      invalidate();
      return;
      this.N.setImageDrawable(this.u);
      break;
      label152:
      i1 = paramInt1;
      if (paramInt1 > 12)
      {
        i1 = paramInt1 % 12;
        continue;
        this.N.setVisibility(4);
        i1 = paramInt1;
      }
    }
  }
  
  public void startTimeChangeAnimation(int paramInt1, int paramInt2)
  {
    if ((!this.R) && (!this.S))
    {
      this.R = true;
      this.O = -1L;
    }
    this.a = this.j;
    this.b = this.k;
    boolean bool = b();
    this.ab = paramInt1;
    int i1 = paramInt1;
    if (!this.aa)
    {
      if (paramInt1 == 0) {
        i1 = 12;
      }
    }
    else
    {
      if (i1 == this.a)
      {
        if (this.aa) {
          break label317;
        }
        this.N.setVisibility(0);
        if (this.ab <= 11) {
          break label303;
        }
        this.N.setImageDrawable(this.v);
      }
      label112:
      this.C = false;
      this.D = false;
      if (this.aa != bool) {
        this.C = true;
      }
      if (((i1 >= 0) && (i1 != this.a)) || (bool != this.aa))
      {
        this.j = i1;
        if (!this.S) {
          break label328;
        }
        this.F.setImageDrawable(this.t[(i1 / 10)]);
        this.G.setImageDrawable(this.t[(i1 % 10)]);
        label201:
        this.l = 0;
      }
      if ((paramInt2 >= 0) && (paramInt2 != this.b))
      {
        this.k = paramInt2;
        if (!this.S) {
          break label420;
        }
        this.J.setImageDrawable(this.t[(paramInt2 / 10)]);
        this.K.setImageDrawable(this.t[(paramInt2 % 10)]);
      }
    }
    for (;;)
    {
      this.m = 0;
      this.Q = true;
      this.aa = bool;
      a();
      invalidate();
      return;
      i1 = paramInt1;
      if (paramInt1 <= 12) {
        break;
      }
      i1 = paramInt1 % 12;
      break;
      label303:
      this.N.setImageDrawable(this.u);
      break label112;
      label317:
      this.N.setVisibility(4);
      break label112;
      label328:
      this.C = true;
      this.d.setVisibility(0);
      this.F.setImageDrawable(this.t[(this.a / 10)]);
      this.G.setImageDrawable(this.t[(this.a % 10)]);
      this.H.setImageDrawable(this.t[(this.j / 10)]);
      this.I.setImageDrawable(this.t[(this.j % 10)]);
      break label201;
      label420:
      this.D = true;
      this.f.setVisibility(0);
      this.J.setImageDrawable(this.t[(this.b / 10)]);
      this.K.setImageDrawable(this.t[(this.b % 10)]);
      this.L.setImageDrawable(this.t[(this.k / 10)]);
      this.M.setImageDrawable(this.t[(this.k % 10)]);
    }
  }
  
  public int startZoneChangeAnimation(float paramFloat, z paramz)
  {
    int i1 = 0;
    if ((paramz == null) && (this.i == null))
    {
      i1 = -1;
      return i1;
    }
    if (paramz != null) {
      this.i = paramz;
    }
    this.j = this.i.a();
    if (!this.aa)
    {
      if (this.j != 0) {
        break label146;
      }
      this.j = 12;
    }
    for (;;)
    {
      this.k = this.i.b();
      if (paramFloat == this.r) {
        break;
      }
      this.q = paramFloat;
      this.s = Math.abs(this.j - this.a);
      this.d.setVisibility(0);
      if (this.k != this.b) {
        this.m = 0;
      }
      this.p = 0;
      this.n = 0.0F;
      this.ac = false;
      return this.s;
      label146:
      if (this.j > 12) {
        this.j %= 12;
      }
    }
  }
  
  public void updateCurrentZone(float paramFloat)
  {
    this.r = paramFloat;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/weatherwidget/GLDigitalClock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */