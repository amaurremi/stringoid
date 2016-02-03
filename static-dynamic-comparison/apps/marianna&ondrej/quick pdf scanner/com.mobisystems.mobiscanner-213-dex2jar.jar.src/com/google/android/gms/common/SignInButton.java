package com.google.android.gms.common;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.e.a;
import com.google.android.gms.internal.dc;
import com.google.android.gms.internal.de;
import com.google.android.gms.internal.et;

public final class SignInButton
  extends FrameLayout
  implements View.OnClickListener
{
  private int U;
  private int qL;
  private View qM;
  private View.OnClickListener qN = null;
  
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
  
  private void A(Context paramContext)
  {
    if (this.qM != null) {
      removeView(this.qM);
    }
    try
    {
      this.qM = de.d(paramContext, this.U, this.qL);
      addView(this.qM);
      this.qM.setEnabled(isEnabled());
      this.qM.setOnClickListener(this);
      return;
    }
    catch (e.a locala)
    {
      for (;;)
      {
        Log.w("SignInButton", "Sign in button not found, using placeholder instead");
        this.qM = c(paramContext, this.U, this.qL);
      }
    }
  }
  
  private static Button c(Context paramContext, int paramInt1, int paramInt2)
  {
    et localet = new et(paramContext);
    localet.a(paramContext.getResources(), paramInt1, paramInt2);
    return localet;
  }
  
  public void onClick(View paramView)
  {
    if ((this.qN != null) && (paramView == this.qM)) {
      this.qN.onClick(this);
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.qM.setEnabled(paramBoolean);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.qN = paramOnClickListener;
    if (this.qM != null) {
      this.qM.setOnClickListener(this);
    }
  }
  
  public void setStyle(int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    if ((paramInt1 >= 0) && (paramInt1 < 3))
    {
      bool1 = true;
      dc.a(bool1, "Unknown button size " + paramInt1);
      if ((paramInt2 < 0) || (paramInt2 >= 2)) {
        break label96;
      }
    }
    label96:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      dc.a(bool1, "Unknown color scheme " + paramInt2);
      this.U = paramInt1;
      this.qL = paramInt2;
      A(getContext());
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/common/SignInButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */