package uk.co.senab.photoview;

import android.graphics.Matrix;
import android.view.animation.Interpolator;
import android.widget.ImageView;

class e
  implements Runnable
{
  private final float b;
  private final float c;
  private final long d;
  private final float e;
  private final float f;
  
  public e(b paramb, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.b = paramFloat3;
    this.c = paramFloat4;
    this.d = System.currentTimeMillis();
    this.e = paramFloat1;
    this.f = paramFloat2;
  }
  
  private float a()
  {
    float f1 = Math.min(1.0F, (float)(System.currentTimeMillis() - this.d) * 1.0F / 200.0F);
    return b.a.getInterpolation(f1);
  }
  
  public void run()
  {
    ImageView localImageView = this.a.c();
    if (localImageView == null) {}
    float f1;
    do
    {
      return;
      f1 = a();
      float f2 = (this.e + (this.f - this.e) * f1) / this.a.d();
      b.b(this.a).postScale(f2, f2, this.b, this.c);
      b.c(this.a);
    } while (f1 >= 1.0F);
    a.a(localImageView, this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/uk/co/senab/photoview/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */