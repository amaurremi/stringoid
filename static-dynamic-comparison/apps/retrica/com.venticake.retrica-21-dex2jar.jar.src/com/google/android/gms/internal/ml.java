package com.google.android.gms.internal;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;

final class ml
{
  public final int a;
  public final ViewGroup.LayoutParams b;
  public final ViewGroup c;
  
  public ml(ex paramex)
  {
    this.b = paramex.getLayoutParams();
    ViewParent localViewParent = paramex.getParent();
    if ((localViewParent instanceof ViewGroup))
    {
      this.c = ((ViewGroup)localViewParent);
      this.a = this.c.indexOfChild(paramex);
      this.c.removeView(paramex);
      paramex.q(true);
      return;
    }
    throw new mj("Could not get the parent of the WebView for an overlay.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ml.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */