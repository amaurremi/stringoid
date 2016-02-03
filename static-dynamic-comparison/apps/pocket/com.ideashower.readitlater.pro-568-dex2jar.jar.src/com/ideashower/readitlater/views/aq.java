package com.ideashower.readitlater.views;

import android.text.Layout;
import android.widget.TextView;

class aq
  implements as
{
  public float a(TextView paramTextView, float paramFloat)
  {
    paramFloat = Math.max(0.0F, paramFloat - paramTextView.getTotalPaddingLeft());
    return Math.min(paramTextView.getWidth() - paramTextView.getTotalPaddingRight() - 1, paramFloat) + paramTextView.getScrollX();
  }
  
  public int a(TextView paramTextView, float paramFloat1, float paramFloat2)
  {
    if (paramTextView.getLayout() == null) {
      return -1;
    }
    return a(paramTextView, b(paramTextView, paramFloat2), paramFloat1);
  }
  
  public int a(TextView paramTextView, int paramInt, float paramFloat)
  {
    paramFloat = a(paramTextView, paramFloat);
    return paramTextView.getLayout().getOffsetForHorizontal(paramInt, paramFloat);
  }
  
  public int b(TextView paramTextView, float paramFloat)
  {
    paramFloat = Math.max(0.0F, paramFloat - paramTextView.getTotalPaddingTop());
    paramFloat = Math.min(paramTextView.getHeight() - paramTextView.getTotalPaddingBottom() - 1, paramFloat);
    float f = paramTextView.getScrollY();
    return paramTextView.getLayout().getLineForVertical((int)(paramFloat + f));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */