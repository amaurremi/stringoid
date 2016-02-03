package com.google.android.gms.common;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.e.a;
import com.google.android.gms.internal.eg;
import com.google.android.gms.internal.eh;
import com.google.android.gms.internal.ei;

public final class SignInButton
  extends FrameLayout
  implements View.OnClickListener
{
  public static final int COLOR_DARK = 0;
  public static final int COLOR_LIGHT = 1;
  public static final int SIZE_ICON_ONLY = 2;
  public static final int SIZE_STANDARD = 0;
  public static final int SIZE_WIDE = 1;
  private int mP;
  private View mQ;
  private View.OnClickListener mR = null;
  private int mSize;
  
  public SignInButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SignInButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SignInButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setStyle(0, 0);
  }
  
  private static Button c(Context paramContext, int paramInt1, int paramInt2)
  {
    ei localei = new ei(paramContext);
    localei.a(paramContext.getResources(), paramInt1, paramInt2);
    return localei;
  }
  
  private void p(Context paramContext)
  {
    if (this.mQ != null) {
      removeView(this.mQ);
    }
    try
    {
      this.mQ = eh.d(paramContext, this.mSize, this.mP);
      addView(this.mQ);
      this.mQ.setEnabled(isEnabled());
      this.mQ.setOnClickListener(this);
      return;
    }
    catch (e.a locala)
    {
      for (;;)
      {
        Log.w("SignInButton", "Sign in button not found, using placeholder instead");
        this.mQ = c(paramContext, this.mSize, this.mP);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if ((this.mR != null) && (paramView == this.mQ)) {
      this.mR.onClick(this);
    }
  }
  
  public void setColorScheme(int paramInt)
  {
    setStyle(this.mSize, paramInt);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.mQ.setEnabled(paramBoolean);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mR = paramOnClickListener;
    if (this.mQ != null) {
      this.mQ.setOnClickListener(this);
    }
  }
  
  public void setSize(int paramInt)
  {
    setStyle(paramInt, this.mP);
  }
  
  public void setStyle(int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    if ((paramInt1 >= 0) && (paramInt1 < 3))
    {
      bool1 = true;
      eg.a(bool1, "Unknown button size " + paramInt1);
      if ((paramInt2 < 0) || (paramInt2 >= 2)) {
        break label96;
      }
    }
    label96:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      eg.a(bool1, "Unknown color scheme " + paramInt2);
      this.mSize = paramInt1;
      this.mP = paramInt2;
      p(getContext());
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/common/SignInButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */