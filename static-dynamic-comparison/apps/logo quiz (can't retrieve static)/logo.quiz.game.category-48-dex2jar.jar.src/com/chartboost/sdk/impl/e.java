package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.widget.Button;

public final class e
  extends Button
{
  private Path a;
  private Path b;
  private Path c;
  private RectF d;
  private Paint e;
  private Paint f;
  private Shader g;
  private Shader h;
  private int i;
  
  public e(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a()
  {
    int j = getHeight();
    if (j == this.i) {
      return;
    }
    this.i = j;
    float f1 = getHeight();
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    this.g = new LinearGradient(0.0F, 0.0F, 0.0F, f1, new int[] { -81366, -89600, -97280 }, null, localTileMode);
    f1 = getHeight();
    localTileMode = Shader.TileMode.CLAMP;
    this.h = new LinearGradient(0.0F, 0.0F, 0.0F, f1, new int[] { -97280, -89600, -81366 }, null, localTileMode);
  }
  
  private void a(Context paramContext)
  {
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    setTextSize(2, 13.0F);
    setShadowLayer(1.0F * f1, 1.0F * f1, 1.0F * f1, -16757901);
    setTypeface(null, 1);
    setTextColor(-1);
    setClickable(true);
    setGravity(17);
    setPadding(Math.round(12.0F * f1), Math.round(5.0F * f1), Math.round(12.0F * f1), Math.round(f1 * 5.0F));
    this.a = new Path();
    this.b = new Path();
    this.c = new Path();
    this.d = new RectF();
    this.e = new Paint();
    this.e.setStyle(Paint.Style.STROKE);
    this.e.setColor(-4496384);
    this.e.setAntiAlias(true);
    this.i = -1;
    this.f = new Paint();
    this.f.setStyle(Paint.Style.FILL);
    this.f.setAntiAlias(true);
    setBackgroundDrawable(new Drawable()
    {
      boolean a = false;
      
      public void draw(Canvas paramAnonymousCanvas)
      {
        int i = 0;
        float f2 = e.this.getContext().getResources().getDisplayMetrics().density;
        Object localObject = getState();
        int j = 0;
        while (i < localObject.length)
        {
          if (localObject[i] == 16842919) {
            j = 1;
          }
          i += 1;
        }
        float f1 = 6.0F * f2;
        e.a(e.this).reset();
        e.b(e.this).set(getBounds());
        e.a(e.this).addRoundRect(e.b(e.this), f1, f1, Path.Direction.CW);
        e.c(e.this);
        Paint localPaint = e.f(e.this);
        if (j != 0) {}
        for (localObject = e.d(e.this);; localObject = e.e(e.this))
        {
          localPaint.setShader((Shader)localObject);
          paramAnonymousCanvas.drawPath(e.a(e.this), e.f(e.this));
          f2 = 1.0F * f2;
          e.g(e.this).reset();
          e.b(e.this).inset(f2 / 2.0F, f2 / 2.0F);
          e.g(e.this).addRoundRect(e.b(e.this), f1, f1, Path.Direction.CW);
          e.h(e.this).reset();
          e.b(e.this).offset(0.0F, f2 / 2.0F);
          e.h(e.this).addRoundRect(e.b(e.this), f1, f1, Path.Direction.CW);
          if (j == 0)
          {
            e.i(e.this).setColor(-1);
            paramAnonymousCanvas.drawPath(e.h(e.this), e.i(e.this));
          }
          e.i(e.this).setColor(-4496384);
          paramAnonymousCanvas.drawPath(e.g(e.this), e.i(e.this));
          return;
        }
      }
      
      public int getOpacity()
      {
        return 1;
      }
      
      public boolean isStateful()
      {
        return true;
      }
      
      protected boolean onStateChange(int[] paramAnonymousArrayOfInt)
      {
        int i = 0;
        boolean bool = false;
        while (i < paramAnonymousArrayOfInt.length)
        {
          if (paramAnonymousArrayOfInt[i] == 16842919) {
            bool = true;
          }
          i += 1;
        }
        if (this.a != bool)
        {
          this.a = bool;
          invalidateSelf();
          return true;
        }
        return false;
      }
      
      public void setAlpha(int paramAnonymousInt)
      {
        e.i(e.this).setAlpha(paramAnonymousInt);
        e.f(e.this).setAlpha(paramAnonymousInt);
      }
      
      public void setColorFilter(ColorFilter paramAnonymousColorFilter)
      {
        e.i(e.this).setColorFilter(paramAnonymousColorFilter);
        e.f(e.this).setColorFilter(paramAnonymousColorFilter);
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */