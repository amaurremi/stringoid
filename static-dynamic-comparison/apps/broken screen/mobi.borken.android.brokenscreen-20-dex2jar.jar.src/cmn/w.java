package cmn;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.widget.Button;

public final class w
  extends Button
{
  private int a;
  private float b;
  
  public w(Context paramContext)
  {
    super(paramContext);
    setMaxLines(1);
    this.b = getTextSize();
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    float f = this.b;
    int j = View.MeasureSpec.getSize(paramInt1);
    if (j > 0)
    {
      int k = View.MeasureSpec.getMode(paramInt2);
      int i = Integer.MAX_VALUE;
      if ((k == Integer.MIN_VALUE) || (k == 1073741824)) {
        i = View.MeasureSpec.getSize(paramInt2);
      }
      k = getCompoundPaddingLeft();
      int m = getCompoundPaddingRight();
      int n = getCompoundPaddingTop();
      int i1 = getCompoundPaddingBottom();
      f = getResources().getDisplayMetrics().density;
      f = x.a(getText().toString(), j - (k + m + 1), i - (n + i1 + 1), this.a, this.b * f, getPaint(), getTypeface()) / f;
    }
    if (Math.abs(getTextSize() - f) > 0.1F) {
      setTextSize(2, f);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public final void setMaxLines(int paramInt)
  {
    super.setMaxLines(paramInt);
    this.a = paramInt;
  }
  
  public final void setTextSize(float paramFloat)
  {
    this.b = paramFloat;
    super.setTextSize(paramFloat);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/cmn/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */