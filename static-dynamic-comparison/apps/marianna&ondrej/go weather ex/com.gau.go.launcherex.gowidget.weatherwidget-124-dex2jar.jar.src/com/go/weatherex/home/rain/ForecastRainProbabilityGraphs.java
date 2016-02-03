package com.go.weatherex.home.rain;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.gau.go.launcherex.gowidget.weather.model.ForecastBean;
import java.util.ArrayList;

public class ForecastRainProbabilityGraphs
  extends View
{
  public static final int a = Build.VERSION.SDK_INT;
  private static final int[] r = { -268394262, -268394262, -268394262, -268394262, -268394262 };
  private static final int[] s = { 25, 50, 75, 100 };
  private PathEffect A;
  private Bitmap B;
  private Paint b;
  private Paint c;
  private Paint d;
  private float e;
  private float f = 0.9F;
  private float g = 2.0F;
  private float h;
  private int i;
  private int j;
  private int k;
  private float l;
  private float m = 10.0F;
  private float n = 1.5F;
  private float o = 0.25F;
  private int p = 6;
  private int q = 1;
  private ArrayList t;
  private SparseArray u;
  private e v;
  private boolean w = false;
  private boolean x = false;
  private int y = 0;
  private Path z;
  
  public ForecastRainProbabilityGraphs(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ForecastRainProbabilityGraphs(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ForecastRainProbabilityGraphs(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.e = getContext().getResources().getDisplayMetrics().density;
    this.f *= this.e;
    this.g *= this.e;
    this.h = getResources().getDimension(2131427654);
    this.u = new SparseArray();
    this.c = new Paint(3);
    this.c.setTextSize(this.h);
    this.c.setSubpixelText(true);
    this.c.setAntiAlias(true);
    this.b = new Paint(3);
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setTextAlign(Paint.Align.CENTER);
    this.b.setStrokeWidth(this.f);
    this.b.setColor(-2130706433);
    this.d = new Paint(3);
    this.d.setStyle(Paint.Style.FILL);
    this.z = new Path();
    float f1 = 4.0F * this.e;
    float f2 = 1.5F * this.e;
    this.A = new DashPathEffect(new float[] { f1, f2, f1, f2 }, 1.0F);
    this.b.setPathEffect(this.A);
  }
  
  private void a(RectF paramRectF, int paramInt1, int paramInt2)
  {
    float f1 = getPaddingLeft() + this.l / 2.0F + this.l * paramInt1 - this.i / 2 + this.k;
    float f2 = this.i;
    float f3 = (int)(getBottom() - getTop() - getPaddingTop() - this.g - this.h / 2.0F - 1.0F * this.e);
    float f4 = paramInt2;
    paramRectF.bottom = f3;
    paramRectF.top = (f3 - f4);
    paramRectF.left = f1;
    paramRectF.right = (f2 + f1);
  }
  
  private int c(int paramInt)
  {
    int i1 = r[0];
    if (paramInt < s[0]) {
      return r[0];
    }
    if (paramInt < s[1]) {
      return r[1];
    }
    if (paramInt < s[2]) {
      return r[2];
    }
    if (paramInt < s[3]) {
      return r[3];
    }
    return r[4];
  }
  
  private int d(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt == 55536) {
      i1 = 0;
    }
    return (getBottom() - getTop() - getPaddingBottom() - getPaddingTop()) * 8 / 9 * i1 / 100;
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
    this.i = ((int)(this.j * 0.4F));
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.x = paramBoolean3;
    this.w = paramBoolean2;
    this.t = paramArrayList;
    int i2;
    if ((this.t != null) && (this.t.size() > 0))
    {
      i2 = this.t.size();
      i1 = 0;
      float f2;
      for (float f1 = 0.0F; i1 < i2; f1 += f2)
      {
        ForecastBean localForecastBean = (ForecastBean)this.t.get(i1);
        f localf = (f)this.u.get(i1);
        paramArrayList = localf;
        if (localf == null)
        {
          paramArrayList = new f(this, null);
          this.u.put(i1, paramArrayList);
        }
        paramArrayList.a(c(localForecastBean.m()));
        paramArrayList.c(localForecastBean.m());
        paramArrayList.d(paramArrayList.d());
        paramArrayList.b(false);
        f2 = Math.max(paramArrayList.d(), 1.0F);
        i1 += 1;
      }
      if (f1 > 0.0F)
      {
        i1 = 0;
        f2 = 0.0F;
        if (i1 < i2)
        {
          paramArrayList = (f)this.u.get(i1);
          float f3 = Math.max(paramArrayList.d(), 1.0F) / f1;
          paramArrayList.c(f2);
          paramArrayList.b(0.0F);
          paramArrayList.a(true);
          if (paramBoolean1)
          {
            paramArrayList.a(0.0F);
            paramArrayList.e(this.p);
            label253:
            if (paramArrayList.d() <= 0) {
              break label295;
            }
            paramArrayList.d(f3);
          }
          for (;;)
          {
            f2 += f3;
            i1 += 1;
            break;
            paramArrayList.a(1.0F);
            paramArrayList.e(0);
            break label253;
            label295:
            paramArrayList.d(0.0F);
          }
        }
      }
      if ((!paramBoolean1) || (this.x) || (f1 <= 0.0F)) {
        break label461;
      }
      if (this.v == null)
      {
        i1 = (int)(f1 / i2);
        if (i1 <= 50) {
          break label409;
        }
        l1 = 1800L;
        this.v = new e(this, f1);
        this.v.setDuration(l1);
        this.v.setStartOffset(200L);
        this.v.setInterpolator(new LinearInterpolator());
      }
      clearAnimation();
      startAnimation(this.v);
    }
    label409:
    label461:
    while ((paramBoolean1) || (!this.x)) {
      for (;;)
      {
        long l1;
        return;
        if (i1 > 25) {
          l1 = 1600L;
        } else if (i1 > 10) {
          l1 = 900L;
        } else if (i1 > 5) {
          l1 = 600L;
        } else {
          l1 = 400L;
        }
      }
    }
    int i1 = 0;
    while (i1 < i2)
    {
      paramArrayList = (f)this.u.get(i1);
      if (paramArrayList != null)
      {
        paramArrayList.d(0);
        paramArrayList.a(0.0F);
      }
      i1 += 1;
    }
    invalidate();
  }
  
  public void b(int paramInt)
  {
    this.k = paramInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f1 = 4.0F * ((getBottom() - getTop() - getPaddingBottom() - getPaddingTop()) / 45.0F);
    int i3 = (int)(getBottom() - getTop() - getPaddingTop() - this.g - this.h / 2.0F);
    int i1 = (this.j - this.i) / 6 + this.k;
    int i2 = this.y;
    i2 = (int)(f1 / 4.0F - this.g - this.h / 2.0F);
    i2 = this.y + i1;
    getRight();
    getLeft();
    getPaddingRight();
    if (!this.w)
    {
      i1 = 11;
      int i4;
      while (i1 > 0)
      {
        i4 = (int)(i3 - (i1 - 1) * f1 - 1.0F * this.e);
        if ((this.B != null) && (!this.B.isRecycled())) {
          paramCanvas.drawBitmap(this.B, 0.0F, i4 - this.B.getHeight() / 2, this.d);
        }
        i1 -= 1;
      }
      this.c.setTextAlign(Paint.Align.CENTER);
      this.c.setColor(-14506519);
      if ((this.t != null) && (this.t.size() > 0) && (!this.x))
      {
        i3 = this.t.size();
        this.l = ((getWidth() - getPaddingLeft() - getPaddingRight()) / i3);
        i1 = 0;
        if (i1 < i3)
        {
          f localf = (f)this.u.get(i1);
          localf.b(d(localf.e()));
          a(localf.a(), i1, localf.c());
          String str;
          float f2;
          float f3;
          if (localf.d() != 55536)
          {
            str = localf.d() + "%";
            this.c.setTextSize(this.h);
            f1 = this.c.measureText(str);
            f2 = this.c.descent() - this.c.ascent();
            f3 = localf.a().left + this.i / 2;
            i4 = (int)(localf.a().top - f2 / 3.0F - 3.0F * this.e);
            this.c.setColor(-1);
            if (f3 - f1 / 2.0F < i2)
            {
              if (localf.f() == 1.0F)
              {
                this.c.setTextSize(this.h + localf.g());
                if (localf.g() > 0) {
                  localf.e(localf.g() - this.q);
                }
                paramCanvas.save();
                paramCanvas.clipRect(i2, i4 - f2, f1 + i2, f2 + i4);
                paramCanvas.drawText(str, f3, i4, this.c);
                paramCanvas.restore();
              }
              label581:
              if (localf.a().left < i2) {
                localf.a().left = i2;
              }
              if (localf.a().right > localf.a().left)
              {
                this.d.setColor(localf.b());
                paramCanvas.drawRect(localf.a(), this.d);
              }
            }
          }
          for (;;)
          {
            i1 += 1;
            break;
            if (localf.f() != 1.0F) {
              break label581;
            }
            this.c.setTextSize(this.h + localf.g());
            if (localf.g() > 0) {
              localf.e(localf.g() - this.q);
            }
            paramCanvas.drawText(str, f3, i4, this.c);
            break label581;
            this.c.setTextSize(this.h);
            f1 = this.c.measureText("N/A");
            f2 = this.c.descent() - this.c.ascent();
            f3 = localf.a().left + this.i / 2;
            i4 = (int)(localf.a().top - f2 / 3.0F);
            this.c.setTextSize(this.h + localf.g());
            if (localf.g() > 0) {
              localf.e(localf.g() - 1);
            }
            if (f3 - f1 / 2.0F < i2)
            {
              if (localf.f() == 1.0F)
              {
                this.c.setTextSize(this.h + localf.g());
                if (localf.g() > 0) {
                  localf.e(localf.g() - this.q);
                }
                paramCanvas.save();
                paramCanvas.clipRect(i2, i4 - f2, f1 + i2, f2 + i4);
                paramCanvas.drawText("N/A", f3, i4, this.c);
                paramCanvas.restore();
              }
            }
            else if (localf.f() == 1.0F)
            {
              this.c.setTextSize(this.h + localf.g());
              if (localf.g() > 0) {
                localf.e(localf.g() - this.q);
              }
              paramCanvas.drawText("N/A", f3, i4, this.c);
            }
          }
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt2 = getWidth();
    paramInt3 = getPaddingLeft();
    paramInt4 = getPaddingRight();
    if (this.t != null) {}
    for (paramInt1 = this.t.size();; paramInt1 = 1)
    {
      this.l = ((paramInt2 - paramInt3 - paramInt4) / Math.max(paramInt1, 1));
      if (this.B == null)
      {
        this.B = Bitmap.createBitmap(getWidth(), 4, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(this.B);
        this.z.moveTo(0.0F, 2.0F);
        this.z.lineTo(getWidth(), 2.0F);
        localCanvas.drawPath(this.z, this.b);
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/rain/ForecastRainProbabilityGraphs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */