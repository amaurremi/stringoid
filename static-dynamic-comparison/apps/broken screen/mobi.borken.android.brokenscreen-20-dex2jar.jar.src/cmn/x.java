package cmn;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.view.View.MeasureSpec;
import android.widget.TextView;

public final class x
  extends TextView
{
  int a = -1;
  float b = -1.0F;
  String c = "";
  private int d;
  private float e;
  
  public x(Context paramContext)
  {
    super(paramContext);
    setMaxLines(1);
    this.e = getTextSize();
  }
  
  public static float a(String paramString, int paramInt1, int paramInt2, int paramInt3, float paramFloat, Paint paramPaint, Typeface paramTypeface)
  {
    Paint localPaint = new Paint();
    localPaint.set(paramPaint);
    paramPaint = new TextPaint(localPaint);
    paramPaint.setTypeface(paramTypeface);
    float f1;
    if (!a(paramFloat, paramPaint, paramString, paramInt1, paramInt2, paramInt3))
    {
      f1 = paramFloat;
      if (paramFloat >= 10.0F) {
        f1 = FloatMath.floor(paramFloat);
      }
      return f1;
    }
    for (;;)
    {
      float f2;
      if (f1 - paramFloat > 0.5F)
      {
        f2 = (f1 + paramFloat) / 2.0F;
        if (a(f2, paramPaint, paramString, paramInt1, paramInt2, paramInt3)) {
          f1 = f2;
        } else {
          paramFloat = f2;
        }
      }
      else
      {
        break;
        f2 = 2.0F;
        f1 = paramFloat;
        paramFloat = f2;
      }
    }
  }
  
  private static boolean a(float paramFloat, TextPaint paramTextPaint, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = false;
    paramTextPaint.setTextSize(paramFloat);
    paramTextPaint = new StaticLayout(paramString, paramTextPaint, paramInt1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    if ((paramTextPaint.getLineCount() > paramInt3) || (paramTextPaint.getHeight() > paramInt2)) {
      bool = true;
    }
    return bool;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    float f1 = this.e;
    int j = View.MeasureSpec.getSize(paramInt1);
    float f2 = getResources().getDisplayMetrics().density;
    String str;
    if (j > 0)
    {
      str = getText().toString();
      if ((j == this.a) && (str.equals(this.c))) {
        f1 = this.b;
      }
    }
    for (;;)
    {
      if (Math.abs(getTextSize() - f1) > 0.1F)
      {
        super.setTextSize(0, f1);
        super.onMeasure(paramInt1, paramInt2);
      }
      return;
      this.a = j;
      this.c = str;
      int k = View.MeasureSpec.getMode(paramInt2);
      int i = Integer.MAX_VALUE;
      if ((k == Integer.MIN_VALUE) || (k == 1073741824)) {
        i = View.MeasureSpec.getSize(paramInt2);
      }
      j -= getCompoundPaddingLeft() + getCompoundPaddingRight() + 1;
      k = getCompoundPaddingTop();
      int m = getCompoundPaddingBottom();
      if (j > 0) {
        f1 = a(getText().toString(), j, i - (k + m + 1), this.d, f2 * this.e, getPaint(), getTypeface());
      }
      for (;;)
      {
        this.b = f1;
        break;
      }
    }
  }
  
  public final void setMaxLines(int paramInt)
  {
    super.setMaxLines(paramInt);
    this.d = paramInt;
  }
  
  public final void setTextSize(float paramFloat)
  {
    super.setTextSize(paramFloat);
    this.e = paramFloat;
  }
  
  public final void setTextSize(int paramInt, float paramFloat)
  {
    super.setTextSize(paramInt, paramFloat);
    this.e = (getTextSize() / getResources().getDisplayMetrics().density);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/cmn/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */