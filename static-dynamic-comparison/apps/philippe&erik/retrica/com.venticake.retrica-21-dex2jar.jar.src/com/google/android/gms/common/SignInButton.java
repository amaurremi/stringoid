package com.google.android.gms.common;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.g.a;
import com.google.android.gms.internal.hm;
import com.google.android.gms.internal.hn;
import com.google.android.gms.internal.ho;

public final class SignInButton
  extends FrameLayout
  implements View.OnClickListener
{
  public static final int COLOR_DARK = 0;
  public static final int COLOR_LIGHT = 1;
  public static final int SIZE_ICON_ONLY = 2;
  public static final int SIZE_STANDARD = 0;
  public static final int SIZE_WIDE = 1;
  private int Dj;
  private View Dk;
  private View.OnClickListener Dl = null;
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
  
  private void C(Context paramContext)
  {
    if (this.Dk != null) {
      removeView(this.Dk);
    }
    try
    {
      this.Dk = hn.b(paramContext, this.mSize, this.Dj);
      addView(this.Dk);
      this.Dk.setEnabled(isEnabled());
      this.Dk.setOnClickListener(this);
      return;
    }
    catch (g.a locala)
    {
      for (;;)
      {
        Log.w("SignInButton", "Sign in button not found, using placeholder instead");
        this.Dk = a(paramContext, this.mSize, this.Dj);
      }
    }
  }
  
  private static Button a(Context paramContext, int paramInt1, int paramInt2)
  {
    ho localho = new ho(paramContext);
    localho.a(paramContext.getResources(), paramInt1, paramInt2);
    return localho;
  }
  
  public void onClick(View paramView)
  {
    if ((this.Dl != null) && (paramView == this.Dk)) {
      this.Dl.onClick(this);
    }
  }
  
  public void setColorScheme(int paramInt)
  {
    setStyle(this.mSize, paramInt);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.Dk.setEnabled(paramBoolean);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.Dl = paramOnClickListener;
    if (this.Dk != null) {
      this.Dk.setOnClickListener(this);
    }
  }
  
  public void setSize(int paramInt)
  {
    setStyle(paramInt, this.Dj);
  }
  
  public void setStyle(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt1 < 3))
    {
      bool = true;
      hm.a(bool, "Unknown button size %d", new Object[] { Integer.valueOf(paramInt1) });
      if ((paramInt2 < 0) || (paramInt2 >= 2)) {
        break label80;
      }
    }
    label80:
    for (boolean bool = true;; bool = false)
    {
      hm.a(bool, "Unknown color scheme %s", new Object[] { Integer.valueOf(paramInt2) });
      this.mSize = paramInt1;
      this.Dj = paramInt2;
      C(getContext());
      return;
      bool = false;
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/common/SignInButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */