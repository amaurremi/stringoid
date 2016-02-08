package com.google.android.gms.common;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.dynamic.g.a;

public final class SignInButton
  extends FrameLayout
  implements View.OnClickListener
{
  public static final int COLOR_DARK = 0;
  public static final int COLOR_LIGHT = 1;
  public static final int SIZE_ICON_ONLY = 2;
  public static final int SIZE_STANDARD = 0;
  public static final int SIZE_WIDE = 1;
  private View Ih;
  private View.OnClickListener Ii = null;
  private int mColor;
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
  
  private void G(Context paramContext)
  {
    if (this.Ih != null) {
      removeView(this.Ih);
    }
    try
    {
      this.Ih = o.b(paramContext, this.mSize, this.mColor);
      addView(this.Ih);
      this.Ih.setEnabled(isEnabled());
      this.Ih.setOnClickListener(this);
      return;
    }
    catch (g.a locala)
    {
      for (;;)
      {
        Log.w("SignInButton", "Sign in button not found, using placeholder instead");
        this.Ih = a(paramContext, this.mSize, this.mColor);
      }
    }
  }
  
  private static Button a(Context paramContext, int paramInt1, int paramInt2)
  {
    p localp = new p(paramContext);
    localp.a(paramContext.getResources(), paramInt1, paramInt2);
    return localp;
  }
  
  public void onClick(View paramView)
  {
    if ((this.Ii != null) && (paramView == this.Ih)) {
      this.Ii.onClick(this);
    }
  }
  
  public void setColorScheme(int paramInt)
  {
    setStyle(this.mSize, paramInt);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.Ih.setEnabled(paramBoolean);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.Ii = paramOnClickListener;
    if (this.Ih != null) {
      this.Ih.setOnClickListener(this);
    }
  }
  
  public void setSize(int paramInt)
  {
    setStyle(paramInt, this.mColor);
  }
  
  public void setStyle(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt1 < 3))
    {
      bool = true;
      n.a(bool, "Unknown button size %d", new Object[] { Integer.valueOf(paramInt1) });
      if ((paramInt2 < 0) || (paramInt2 >= 2)) {
        break label80;
      }
    }
    label80:
    for (boolean bool = true;; bool = false)
    {
      n.a(bool, "Unknown color scheme %s", new Object[] { Integer.valueOf(paramInt2) });
      this.mSize = paramInt1;
      this.mColor = paramInt2;
      G(getContext());
      return;
      bool = false;
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/common/SignInButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */