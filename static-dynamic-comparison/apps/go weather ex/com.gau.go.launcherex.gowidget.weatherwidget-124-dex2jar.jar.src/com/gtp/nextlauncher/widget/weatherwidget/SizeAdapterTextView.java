package com.gtp.nextlauncher.widget.weatherwidget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.go.gl.widget.GLTextViewWrapper;

public class SizeAdapterTextView
  extends GLTextViewWrapper
{
  private Context a;
  private int b = -1;
  
  public SizeAdapterTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = this.a.getResources().getDisplayMetrics().density;
    float f2 = paramInt2 / f1 - 5.0F;
    f1 = f2;
    if (this.b > 0) {
      f1 = Math.min(f2, this.b);
    }
    setTextSize(f1);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setMaxTextSize(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/weatherwidget/SizeAdapterTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */