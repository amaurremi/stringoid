package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import com.chartboost.sdk.CBPreferences;
import com.chartboost.sdk.Libraries.CBOrientation.Difference;
import java.lang.reflect.Method;

public final class v
  extends View
{
  private Handler a;
  private float b;
  private long c;
  private Paint d;
  private Paint e;
  private Path f;
  private Path g;
  private RectF h;
  private RectF i;
  private Bitmap j = null;
  private Canvas k = null;
  private Runnable l = new Runnable()
  {
    public void run()
    {
      CBOrientation.Difference localDifference = CBPreferences.getInstance().getForcedOrientationDifference();
      float f2 = v.this.getContext().getResources().getDisplayMetrics().density;
      v.a(v.this, 1.0F * f2);
      if (localDifference.isOdd()) {}
      for (float f1 = v.this.getWidth();; f1 = v.this.getHeight())
      {
        f1 -= f2 * 9.0F;
        if (v.a(v.this) > f1) {
          v.b(v.this, f1 * 2.0F);
        }
        if (v.this.getWindowVisibility() == 0) {
          v.this.invalidate();
        }
        return;
      }
    }
  };
  
  public v(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    this.b = 0.0F;
    this.a = new Handler();
    this.c = ((System.nanoTime() / 1000000.0D));
    this.d = new Paint();
    this.d.setColor(-1);
    this.d.setStyle(Paint.Style.STROKE);
    this.d.setStrokeWidth(f1 * 3.0F);
    this.d.setAntiAlias(true);
    this.e = new Paint();
    this.e.setColor(-1);
    this.e.setStyle(Paint.Style.FILL);
    this.e.setAntiAlias(true);
    this.f = new Path();
    this.g = new Path();
    this.i = new RectF();
    this.h = new RectF();
    try
    {
      getClass().getMethod("setLayerType", new Class[] { Integer.TYPE, Paint.class }).invoke(this, new Object[] { Integer.valueOf(1), null });
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private boolean a(Canvas paramCanvas)
  {
    try
    {
      boolean bool = ((Boolean)Canvas.class.getMethod("isHardwareAccelerated", new Class[0]).invoke(paramCanvas, new Object[0])).booleanValue();
      return bool;
    }
    catch (Exception paramCanvas) {}
    return false;
  }
  
  protected void onAttachedToWindow()
  {
    this.a.removeCallbacks(this.l);
    this.a.post(this.l);
  }
  
  protected void onDetachedFromWindow()
  {
    this.a.removeCallbacks(this.l);
    if ((this.j != null) && (!this.j.isRecycled())) {
      this.j.recycle();
    }
    this.j = null;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f1 = getContext().getResources().getDisplayMetrics().density;
    boolean bool = a(paramCanvas);
    Canvas localCanvas2 = null;
    Canvas localCanvas1 = paramCanvas;
    if (bool) {
      if ((this.j == null) || (this.j.getWidth() != paramCanvas.getWidth()) || (this.j.getHeight() != paramCanvas.getHeight())) {
        if ((this.j != null) && (!this.j.isRecycled())) {
          this.j.recycle();
        }
      }
    }
    try
    {
      this.j = Bitmap.createBitmap(paramCanvas.getWidth(), paramCanvas.getHeight(), Bitmap.Config.ARGB_8888);
      this.k = new Canvas(this.j);
      this.j.eraseColor(0);
      localCanvas1 = this.k;
      localCanvas2 = paramCanvas;
      paramCanvas = CBPreferences.getInstance().getForcedOrientationDifference();
      localCanvas1.save();
      if (paramCanvas.isReverse()) {
        localCanvas1.rotate(180.0F, getWidth() / 2.0F, getHeight() / 2.0F);
      }
      this.h.set(0.0F, 0.0F, getWidth(), getHeight());
      this.h.inset(1.5F * f1, 1.5F * f1);
      int m;
      if (paramCanvas.isOdd()) {
        m = getWidth();
      }
      for (;;)
      {
        float f2 = m / 2.0F;
        localCanvas1.drawRoundRect(this.h, f2, f2, this.d);
        this.i.set(this.h);
        this.i.inset(3.0F * f1, f1 * 3.0F);
        if (paramCanvas.isOdd())
        {
          f1 = this.i.width();
          label293:
          f1 /= 2.0F;
          this.f.reset();
          this.f.addRoundRect(this.i, f1, f1, Path.Direction.CW);
          if (!paramCanvas.isOdd()) {
            break label547;
          }
          f1 = this.i.width();
          label335:
          this.g.reset();
          if (!paramCanvas.isOdd()) {
            break label558;
          }
          this.g.moveTo(f1, 0.0F);
          this.g.lineTo(f1, f1);
          this.g.lineTo(0.0F, f1 * 2.0F);
          this.g.lineTo(0.0F, f1);
          this.g.close();
          localCanvas1.save();
          m = 1;
        }
        try
        {
          localCanvas1.clipPath(this.f);
          if (m != 0)
          {
            f2 = -f1 + this.b;
            for (;;)
            {
              if (paramCanvas.isOdd())
              {
                f3 = this.i.height();
                if (f2 >= f3 + f1) {
                  break label648;
                }
                if (!paramCanvas.isOdd()) {
                  break label619;
                }
                f3 = this.i.top;
                f3 += f2;
                localCanvas1.save();
                if (!paramCanvas.isOdd()) {
                  break label631;
                }
                localCanvas1.translate(this.i.left, f3);
                localCanvas1.drawPath(this.g, this.e);
                localCanvas1.restore();
                f2 += 2.0F * f1;
                continue;
                m = getHeight();
                break;
                f1 = this.i.height();
                break label293;
                label547:
                f1 = this.i.height();
                break label335;
                label558:
                this.g.moveTo(0.0F, f1);
                this.g.lineTo(f1, f1);
                this.g.lineTo(f1 * 2.0F, 0.0F);
                this.g.lineTo(f1, 0.0F);
              }
            }
          }
        }
        catch (UnsupportedOperationException localUnsupportedOperationException)
        {
          for (;;)
          {
            m = 0;
            continue;
            float f3 = this.i.width();
            continue;
            label619:
            f3 = this.i.left;
            continue;
            label631:
            localCanvas1.translate(f3, this.i.top);
          }
          label648:
          localCanvas1.restore();
          localCanvas1.restore();
          if ((bool) && (localCanvas2 != null)) {
            localCanvas2.drawBitmap(this.j, 0.0F, 0.0F, null);
          }
          long l1 = Math.max(0L, 16L - ((System.nanoTime() / 1000000.0D) - this.c));
          this.a.removeCallbacks(this.l);
          this.a.postDelayed(this.l, l1);
          return;
        }
      }
      return;
    }
    catch (Throwable paramCanvas) {}
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    this.a.removeCallbacks(this.l);
    if (paramInt == 0) {
      this.a.post(this.l);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */