package android.support.v4.view;

import android.graphics.Paint;
import android.view.View;

class ak
  extends aj
{
  long a()
  {
    return as.a();
  }
  
  public void a(View paramView, int paramInt, Paint paramPaint)
  {
    as.a(paramView, paramInt, paramPaint);
  }
  
  public void a(View paramView, Paint paramPaint)
  {
    a(paramView, d(paramView), paramPaint);
    paramView.invalidate();
  }
  
  public int d(View paramView)
  {
    return as.a(paramView);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/view/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */