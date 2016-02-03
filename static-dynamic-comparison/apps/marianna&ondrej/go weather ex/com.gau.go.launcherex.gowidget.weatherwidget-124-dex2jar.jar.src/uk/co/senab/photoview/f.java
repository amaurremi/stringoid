package uk.co.senab.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.widget.ImageView;
import uk.co.senab.photoview.b.d;

class f
  implements Runnable
{
  private final d b;
  private int c;
  private int d;
  
  public f(b paramb, Context paramContext)
  {
    this.b = d.a(paramContext);
  }
  
  public void a()
  {
    this.b.a(true);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RectF localRectF = this.a.b();
    if (localRectF == null) {
      return;
    }
    int i = Math.round(-localRectF.left);
    int j;
    label52:
    int k;
    int m;
    if (paramInt1 < localRectF.width())
    {
      j = Math.round(localRectF.width() - paramInt1);
      paramInt1 = 0;
      k = Math.round(-localRectF.top);
      if (paramInt2 >= localRectF.height()) {
        break label148;
      }
      m = Math.round(localRectF.height() - paramInt2);
    }
    for (paramInt2 = 0;; paramInt2 = k)
    {
      this.c = i;
      this.d = k;
      if ((i == j) && (k == m)) {
        break;
      }
      this.b.a(i, k, paramInt3, paramInt4, paramInt1, j, paramInt2, m, 0, 0);
      return;
      j = i;
      paramInt1 = i;
      break label52;
      label148:
      m = k;
    }
  }
  
  public void run()
  {
    if (this.b.b()) {}
    ImageView localImageView;
    do
    {
      return;
      localImageView = this.a.c();
    } while ((localImageView == null) || (!this.b.a()));
    int i = this.b.c();
    int j = this.b.d();
    b.b(this.a).postTranslate(this.c - i, this.d - j);
    b.a(this.a, this.a.g());
    this.c = i;
    this.d = j;
    a.a(localImageView, this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/uk/co/senab/photoview/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */