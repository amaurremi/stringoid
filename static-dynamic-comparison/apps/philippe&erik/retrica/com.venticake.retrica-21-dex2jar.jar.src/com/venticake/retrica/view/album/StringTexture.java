package com.venticake.retrica.view.album;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.util.FloatMath;

public final class StringTexture
  extends Texture
{
  private static final Paint sPaint = new Paint();
  private int mBaselineHeight;
  private StringTexture.Config mConfig;
  private Paint mPaint;
  private String mString;
  
  public StringTexture(String paramString)
  {
    this.mString = paramString;
    this.mConfig = StringTexture.Config.DEFAULT_CONFIG_SCALED;
  }
  
  public StringTexture(String paramString, StringTexture.Config paramConfig)
  {
    this(paramString, paramConfig, paramConfig.width, paramConfig.height);
  }
  
  public StringTexture(String paramString, StringTexture.Config paramConfig, int paramInt1, int paramInt2)
  {
    this.mString = paramString;
    this.mConfig = paramConfig;
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
  
  public static int computeTextWidthForConfig(float paramFloat, Typeface paramTypeface, String paramString)
  {
    synchronized (sPaint)
    {
      ???.setAntiAlias(true);
      ???.setTypeface(paramTypeface);
      ???.setTextSize(paramFloat);
      int i = (int)(10.0F * Gallery.PIXEL_DENSITY);
      int j = (int)FloatMath.ceil(???.measureText(paramString));
      return i + j;
    }
  }
  
  public static int computeTextWidthForConfig(String paramString, StringTexture.Config paramConfig)
  {
    float f = paramConfig.fontSize;
    if (paramConfig.bold) {}
    for (paramConfig = Typeface.DEFAULT_BOLD;; paramConfig = Typeface.DEFAULT) {
      return computeTextWidthForConfig(f, paramConfig, paramString);
    }
  }
  
  public static int lengthToFit(float paramFloat1, float paramFloat2, Typeface paramTypeface, String paramString)
  {
    if (paramFloat2 <= 0.0F) {
      return 0;
    }
    Paint localPaint = sPaint;
    localPaint.setAntiAlias(true);
    localPaint.setTypeface(paramTypeface);
    localPaint.setTextSize(paramFloat1);
    int j = paramString.length();
    float f = localPaint.measureText(paramString);
    int i = j;
    paramFloat1 = f;
    if (f <= paramFloat2) {
      return j;
    }
    while (paramFloat1 > paramFloat2)
    {
      i -= 1;
      paramFloat1 = localPaint.measureText(paramString, 0, i - 1);
    }
    return i;
  }
  
  protected Paint computePaint()
  {
    if (this.mPaint != null) {
      return this.mPaint;
    }
    Paint localPaint = new Paint();
    this.mPaint = localPaint;
    localPaint.setAntiAlias(true);
    StringTexture.Config localConfig = this.mConfig;
    localPaint.setColor(Color.argb((int)(localConfig.a * 255.0F), (int)(localConfig.r * 255.0F), (int)(localConfig.g * 255.0F), (int)(localConfig.b * 255.0F)));
    localPaint.setShadowLayer(localConfig.shadowRadius, 0.0F, 0.0F, -16777216);
    localPaint.setUnderlineText(localConfig.underline);
    Object localObject;
    label145:
    label182:
    float f;
    if (localConfig.bold)
    {
      localObject = Typeface.DEFAULT_BOLD;
      localPaint.setTypeface((Typeface)localObject);
      localPaint.setStrikeThruText(localConfig.strikeThrough);
      if (localConfig.xalignment != 1) {
        break label210;
      }
      localPaint.setTextAlign(Paint.Align.LEFT);
      if (localConfig.italic) {
        localPaint.setTextSkewX(-0.25F);
      }
      localObject = this.mString;
      localPaint.setTextSize(localConfig.fontSize);
      if (localConfig.sizeMode == 1)
      {
        f = localPaint.getTextSize();
        if (localPaint.measureText((String)localObject) >= this.mWidth) {
          break label239;
        }
      }
    }
    for (;;)
    {
      return localPaint;
      localObject = Typeface.DEFAULT;
      break;
      label210:
      if (localConfig.xalignment == 2)
      {
        localPaint.setTextAlign(Paint.Align.RIGHT);
        break label145;
      }
      localPaint.setTextAlign(Paint.Align.CENTER);
      break label145;
      label239:
      localPaint.setTextSize(f - 1.0F);
      if (f > 6.0F) {
        break label182;
      }
    }
  }
  
  public float computeTextWidth()
  {
    float f2 = 0.0F;
    Paint localPaint = computePaint();
    float f1 = f2;
    if (localPaint != null)
    {
      f1 = f2;
      if (this.mString != null) {
        f1 = localPaint.measureText(this.mString);
      }
    }
    return f1;
  }
  
  public float getBaselineHeight()
  {
    return this.mBaselineHeight;
  }
  
  public boolean isCached()
  {
    return true;
  }
  
  protected Bitmap load(RenderView paramRenderView)
  {
    if (this.mString == null) {
      return null;
    }
    Object localObject1 = computePaint();
    Object localObject2 = this.mString;
    StringTexture.Config localConfig = this.mConfig;
    Object localObject3 = Bitmap.Config.ARGB_4444;
    paramRenderView = ((Paint)localObject1).getFontMetricsInt();
    int n = localConfig.shadowRadius + 1;
    int j = paramRenderView.ascent - n;
    int i1 = paramRenderView.descent + n;
    int m = this.mWidth;
    int k = this.mHeight;
    Object localObject4 = this.mString;
    Rect localRect = new Rect();
    ((Paint)localObject1).getTextBounds((String)localObject4, 0, ((String)localObject4).length(), localRect);
    int i;
    if (localConfig.sizeMode == 2)
    {
      i = localRect.width();
      k = i1 - j + n;
      m = n * 2 + i;
    }
    for (;;)
    {
      if ((m <= 0) || (k <= 0)) {
        return null;
      }
      localObject3 = Bitmap.createBitmap(m, k, (Bitmap.Config)localObject3);
      localObject4 = new Canvas((Bitmap)localObject3);
      if (localConfig.xalignment == 1)
      {
        i = n;
        if (localConfig.yalignment != 3) {
          break label361;
        }
        j = -paramRenderView.top + n;
      }
      for (;;)
      {
        ((Canvas)localObject4).drawText((String)localObject2, i, j, (Paint)localObject1);
        if ((localRect.width() > m) && (localConfig.overflowMode == 2))
        {
          float f = m - 30;
          localObject1 = new LinearGradient(f, 0.0F, m, 0.0F, -1, 16777215, Shader.TileMode.CLAMP);
          localObject2 = new Paint();
          ((Paint)localObject2).setShader((Shader)localObject1);
          ((Paint)localObject2).setDither(true);
          ((Paint)localObject2).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
          ((Canvas)localObject4).drawRect(f, 0.0F, m, k, (Paint)localObject2);
        }
        this.mBaselineHeight = (paramRenderView.bottom + n);
        return (Bitmap)localObject3;
        if (localConfig.xalignment == 2)
        {
          i = m - n;
          break;
        }
        i = m / 2;
        break;
        label361:
        if (localConfig.yalignment == 4) {
          j = k - i1;
        } else {
          j = (k - (i1 + j)) / 2;
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/StringTexture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */