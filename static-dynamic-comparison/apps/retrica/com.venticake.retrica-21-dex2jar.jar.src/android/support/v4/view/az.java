package android.support.v4.view;

import android.graphics.Paint;
import android.view.View;

class az
  extends ay
{
  long a()
  {
    return bh.a();
  }
  
  public void a(View paramView, int paramInt, Paint paramPaint)
  {
    bh.a(paramView, paramInt, paramPaint);
  }
  
  public void a(View paramView, Paint paramPaint)
  {
    a(paramView, d(paramView), paramPaint);
    paramView.invalidate();
  }
  
  public int d(View paramView)
  {
    return bh.a(paramView);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v4/view/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */