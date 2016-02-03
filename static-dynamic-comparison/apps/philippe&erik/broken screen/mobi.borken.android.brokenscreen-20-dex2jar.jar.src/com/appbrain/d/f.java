package com.appbrain.d;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

public final class f
{
  private static final int[] a = { -16842908, 16842913, -16842919 };
  private static final int[] b = { 16842919 };
  
  public static Drawable a(Drawable paramDrawable, Resources paramResources)
  {
    paramDrawable = paramDrawable.getConstantState().newDrawable(paramResources);
    try
    {
      paramDrawable.mutate();
      return paramDrawable;
    }
    catch (NullPointerException paramResources) {}
    return paramDrawable;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/d/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */