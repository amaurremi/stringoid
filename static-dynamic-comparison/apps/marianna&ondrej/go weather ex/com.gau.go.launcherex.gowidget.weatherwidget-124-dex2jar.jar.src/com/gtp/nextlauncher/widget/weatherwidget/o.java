package com.gtp.nextlauncher.widget.weatherwidget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;

public class o
{
  private static float a = 1.0F;
  private static float b = 60.0F * a;
  private static float c = 30.0F * a;
  private static float d = 24.0F * a;
  private static Paint e;
  private static Paint f;
  
  public static Bitmap a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    paramContext = new Canvas();
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_4444);
    paramContext.setBitmap(localBitmap);
    if (e == null) {
      e = a(Color.parseColor("#86530D"));
    }
    a(paramContext, e, paramInt2 / 1.5F, paramString, paramInt1);
    return localBitmap;
  }
  
  private static Paint a(int paramInt)
  {
    Paint localPaint = new Paint(1);
    localPaint.setColor(paramInt);
    localPaint.setTextSize(d);
    localPaint.setLinearText(true);
    localPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    localPaint.setStrokeCap(Paint.Cap.ROUND);
    localPaint.setStrokeWidth(0.6F);
    return localPaint;
  }
  
  private static void a(Canvas paramCanvas, Paint paramPaint, float paramFloat, String paramString, int paramInt)
  {
    for (float f1 = paramPaint.measureText(paramString); f1 >= paramInt + 2; f1 = paramPaint.measureText(paramString)) {
      paramPaint.setTextSize(paramPaint.getTextSize() - 1.0F);
    }
    paramCanvas.drawText(paramString, (paramInt - f1) / 2.0F, paramFloat, paramPaint);
  }
  
  public static Bitmap b(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    paramContext = new Canvas();
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_4444);
    paramContext.setBitmap(localBitmap);
    if (f == null) {
      f = a(Color.parseColor("#18629A"));
    }
    a(paramContext, f, paramInt2 / 1.5F, paramString, paramInt1);
    return localBitmap;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/weatherwidget/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */