package com.jiubang.core.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.gtp.a.a.b.c;

public class y
  extends l
  implements SensorEventListener
{
  private d A;
  private SensorManager B;
  private Context C;
  private z D;
  private boolean E = false;
  private float F = 0.1F;
  private boolean G = true;
  private Rect H = new Rect();
  private RectF I = new RectF();
  private Matrix w;
  private Matrix x;
  private float y;
  private float z;
  
  public y(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Bitmap paramBitmap)
  {
    super(paramContext, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBitmap);
    this.C = paramContext;
    this.j = paramBitmap;
    this.w = new Matrix();
    this.x = new Matrix();
    this.A = new d();
    v();
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    int i = 0;
    if ((Math.abs(paramFloat1) > 1.0F) || (Math.abs(paramFloat2) > 1.0F)) {
      throw new IllegalArgumentException("Parallax effect cannot translate more than 100% of its off-screen size");
    }
    if (Math.abs(paramFloat1) >= 1.0F)
    {
      i = 1;
      if (!this.E) {
        break label385;
      }
      this.y += this.F;
      label63:
      paramFloat1 = this.D.g() * paramFloat2;
      if ((this.z <= Math.abs(this.D.g())) && (this.z >= -Math.abs(this.D.g())))
      {
        if ((paramFloat2 > 0.0F) && (this.z > paramFloat1)) {
          this.z -= c(Math.abs(this.z - paramFloat1));
        }
        if ((paramFloat2 < 0.0F) && (this.z < paramFloat1))
        {
          paramFloat2 = this.z;
          this.z = (c(Math.abs(this.z - paramFloat1)) + paramFloat2);
        }
      }
      if (this.z > Math.abs(this.D.g())) {
        this.z = Math.abs(this.D.g());
      }
      if (this.z < -Math.abs(this.D.g())) {
        this.z = (-Math.abs(this.D.g()));
      }
      if (this.y > Math.abs(this.D.f())) {
        this.y = Math.abs(this.D.f());
      }
      if (this.y < -Math.abs(this.D.f())) {
        this.y = (-Math.abs(this.D.f()));
      }
      if ((i != 0) && (Math.abs(this.D.f()) - Math.abs(this.y) <= 5.0F))
      {
        this.E = true;
        if (this.y >= 0.0F) {
          break label509;
        }
      }
    }
    label385:
    label509:
    for (this.F = Math.abs(this.F);; this.F = (-Math.abs(this.F)))
    {
      x();
      return;
      this.E = false;
      break;
      float f = this.D.f() * paramFloat1;
      if ((this.y > Math.abs(this.D.f())) || (this.y < -Math.abs(this.D.f()))) {
        break label63;
      }
      if ((paramFloat1 < 0.0F) && (this.y < f)) {
        this.y += c(Math.abs(this.y - f));
      }
      if ((paramFloat1 <= 0.0F) || (this.y <= f)) {
        break label63;
      }
      this.y -= c(Math.abs(this.y - f));
      break label63;
    }
  }
  
  private float c(float paramFloat)
  {
    float f = paramFloat / 55.0F;
    paramFloat = f;
    if (f > 1.5D) {
      paramFloat = 1.5F;
    }
    return paramFloat;
  }
  
  private void v()
  {
    this.D = new z(this);
    x();
  }
  
  private void w()
  {
    if (z.a(this.D)) {
      return;
    }
    this.x.setScale(this.D.e(), this.D.e());
    this.x.postTranslate(this.D.f(), this.D.g());
  }
  
  private void x()
  {
    if (z.a(this.D)) {
      return;
    }
    this.w.setScale(this.D.e(), this.D.e());
    this.w.postTranslate(this.D.f() + this.y, this.D.g() + this.z);
    n();
  }
  
  protected void a(Canvas paramCanvas, float paramFloat, int paramInt1, int paramInt2)
  {
    this.G = true;
    if (this.p)
    {
      paramInt1 = paramCanvas.save();
      paramCanvas.concat(this.w);
    }
    for (;;)
    {
      if (this.j != null)
      {
        if ((this.q != null) && (paramInt2 != 255))
        {
          this.H.set(0, 0, this.q.getWidth(), this.q.getHeight());
          this.I.set(0.0F, 0.0F, this.j.getWidth(), this.j.getHeight());
          paramCanvas.drawBitmap(this.q, this.H, this.I, this.i);
        }
        int i = this.i.getAlpha();
        this.i.setAlpha(paramInt2);
        if (paramInt2 != 0) {
          paramCanvas.drawBitmap(this.j, 0.0F, 0.0F, this.i);
        }
        this.i.setAlpha(i);
      }
      if (paramInt1 != -1) {
        paramCanvas.restoreToCount(paramInt1);
      }
      return;
      w();
      paramInt1 = paramCanvas.save();
      paramCanvas.concat(this.x);
    }
  }
  
  protected void e()
  {
    super.e();
    t();
  }
  
  public void h()
  {
    try
    {
      if ((this.j != null) && (!this.j.isRecycled()))
      {
        this.j.recycle();
        this.j = null;
      }
      if ((this.q != null) && (!this.q.isRecycled()))
      {
        this.q.recycle();
        this.q = null;
      }
      u();
      return;
    }
    finally {}
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    paramSensorEvent = this.A.a(this.C, paramSensorEvent);
    if (paramSensorEvent == null) {}
    while (!this.G) {
      return;
    }
    a(paramSensorEvent[2], paramSensorEvent[1]);
    this.G = false;
  }
  
  public void p()
  {
    try
    {
      super.p();
      u();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void q()
  {
    try
    {
      super.q();
      t();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean s()
  {
    return r() != null;
  }
  
  public void t()
  {
    if (this.B == null)
    {
      this.B = ((SensorManager)this.C.getSystemService("sensor"));
      if (this.B != null) {}
    }
    else
    {
      return;
    }
    c.a("XSensorComponent", "registerSensorManager");
    this.B.registerListener(this, this.B.getDefaultSensor(3), 0);
  }
  
  public void u()
  {
    if (this.B != null)
    {
      this.B.unregisterListener(this);
      c.a("XSensorComponent", "unregisterSensorManager");
      this.B = null;
      a(0.0F, 0.0F);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/a/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */