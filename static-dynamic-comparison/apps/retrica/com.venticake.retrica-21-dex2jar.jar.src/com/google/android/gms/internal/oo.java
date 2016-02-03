package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class oo
  extends Drawable.ConstantState
{
  int a;
  int b;
  
  oo(oo paramoo)
  {
    if (paramoo != null)
    {
      this.a = paramoo.a;
      this.b = paramoo.b;
    }
  }
  
  public int getChangingConfigurations()
  {
    return this.a;
  }
  
  public Drawable newDrawable()
  {
    return new gt(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/oo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */