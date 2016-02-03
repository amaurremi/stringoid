package com.pocket.widget;

import android.content.Context;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.ideashower.readitlater.util.e;
import com.ideashower.readitlater.views.ThemedTextView;

public class MaxLineFixedTextView
  extends ThemedTextView
{
  private boolean a;
  private boolean b;
  private String c;
  private boolean d;
  
  public MaxLineFixedTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MaxLineFixedTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MaxLineFixedTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(int paramInt)
  {
    CharSequence localCharSequence = getText().subSequence(0, paramInt);
    this.d = true;
    setText(localCharSequence);
    requestLayout();
    invalidate();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (this.d)) {
      setTextSafe(this.c);
    }
  }
  
  public boolean onPreDraw()
  {
    boolean bool1;
    if (!this.b)
    {
      bool1 = super.onPreDraw();
      return bool1;
    }
    boolean bool2 = super.onPreDraw();
    boolean bool3 = this.a;
    this.a = false;
    Layout localLayout = getLayout();
    int j = getHeight() - getPaddingTop() - getPaddingBottom();
    int i;
    if ((localLayout != null) && (localLayout.getHeight() > j))
    {
      i = localLayout.getLineCount() - 1;
      label74:
      if (i < 0) {
        break label193;
      }
      if (localLayout.getLineBottom(i) > j) {}
    }
    for (;;)
    {
      a(localLayout.getLineEnd(i));
      return true;
      i -= 1;
      break label74;
      bool1 = bool2;
      if (TextUtils.isEmpty(getText())) {
        break;
      }
      bool1 = bool2;
      if (j <= 0) {
        break;
      }
      bool1 = bool2;
      if (getHeight() <= 0) {
        break;
      }
      bool1 = bool2;
      if (bool2) {
        break;
      }
      if (bool3)
      {
        e.a("Layout wasn't created during measure pass for text " + getText());
        return bool2;
      }
      this.a = true;
      requestLayout();
      invalidate();
      return true;
      label193:
      i = 0;
    }
  }
  
  public void setShadowLayer(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    if (paramFloat1 != 0.0F) {}
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      super.setShadowLayer(paramFloat1, paramFloat2, paramFloat3, paramInt);
      return;
    }
  }
  
  public void setTextSafe(String paramString)
  {
    this.c = paramString;
    this.d = false;
    setText(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/MaxLineFixedTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */