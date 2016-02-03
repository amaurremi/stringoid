package com.pocket.i.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import com.ideashower.readitlater.util.j;

public class b
  extends l
{
  public static final float a = j.a(1.5F);
  public static final float b = j.a(4.0F);
  public static final float[] c = { j.a(8.0F), j.a(4.5F), j.a(8.0F), j.a(4.5F), j.a(4.0F), j.a(4.5F) };
  private final Path d = new Path();
  private final m e;
  private final float[] f = new float[6];
  private float g;
  
  public b(Context paramContext)
  {
    this.e = new m(paramContext, 2131165772);
    this.e.setStyle(Paint.Style.STROKE);
    a(a);
    b(b);
    a(c);
    a(this.e);
  }
  
  private void a()
  {
    this.d.rewind();
    Rect localRect = getBounds();
    float f2 = localRect.left + this.f[1];
    float f1 = localRect.bottom - this.f[5] - this.g;
    this.d.moveTo(f2, f1);
    f1 += this.g;
    this.d.lineTo(f2, f1);
    f2 = localRect.right - this.f[3];
    this.d.lineTo(f2, f1);
    float f3 = this.g;
    this.d.lineTo(f2, f1 - f3);
  }
  
  public void a(float paramFloat)
  {
    this.e.setStrokeWidth(paramFloat);
    invalidateSelf();
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.f[0] = paramFloat1;
    this.f[1] = paramFloat2;
    this.f[2] = paramFloat3;
    this.f[3] = paramFloat4;
    this.f[4] = paramFloat5;
    this.f[5] = paramFloat6;
    a();
    invalidateSelf();
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    a(paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2], paramArrayOfFloat[3], paramArrayOfFloat[4], paramArrayOfFloat[5]);
  }
  
  public void b(float paramFloat)
  {
    this.g = paramFloat;
    a();
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.drawPath(this.d, this.e);
  }
  
  public boolean getPadding(Rect paramRect)
  {
    paramRect.set((int)(this.f[0] + this.f[1]), 0, (int)(this.f[2] + this.f[3]), (int)(this.f[4] + this.f[5]));
    return true;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/i/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */