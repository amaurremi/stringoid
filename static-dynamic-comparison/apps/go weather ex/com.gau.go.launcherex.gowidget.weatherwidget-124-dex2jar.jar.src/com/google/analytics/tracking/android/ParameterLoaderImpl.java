package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;

class ParameterLoaderImpl
  implements ParameterLoader
{
  private final Context ctx;
  
  public ParameterLoaderImpl(Context paramContext)
  {
    if (paramContext == null) {
      throw new NullPointerException("Context cannot be null");
    }
    this.ctx = paramContext.getApplicationContext();
  }
  
  private int getResourceIdForType(String paramString1, String paramString2)
  {
    if (this.ctx == null) {
      return 0;
    }
    return this.ctx.getResources().getIdentifier(paramString1, paramString2, this.ctx.getPackageName());
  }
  
  public boolean getBoolean(String paramString)
  {
    int i = getResourceIdForType(paramString, "bool");
    if (i == 0) {
      return false;
    }
    return "true".equalsIgnoreCase(this.ctx.getString(i));
  }
  
  public Double getDoubleFromString(String paramString)
  {
    paramString = getString(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      double d = Double.parseDouble(paramString);
      return Double.valueOf(d);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      Log.w("NumberFormatException parsing " + paramString);
    }
    return null;
  }
  
  public int getInt(String paramString, int paramInt)
  {
    int i = getResourceIdForType(paramString, "integer");
    if (i == 0) {
      return paramInt;
    }
    try
    {
      int j = Integer.parseInt(this.ctx.getString(i));
      return j;
    }
    catch (NumberFormatException paramString)
    {
      Log.w("NumberFormatException parsing " + this.ctx.getString(i));
    }
    return paramInt;
  }
  
  public String getString(String paramString)
  {
    int i = getResourceIdForType(paramString, "string");
    if (i == 0) {
      return null;
    }
    return this.ctx.getString(i);
  }
  
  public boolean isBooleanKeyPresent(String paramString)
  {
    return getResourceIdForType(paramString, "bool") != 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/analytics/tracking/android/ParameterLoaderImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */