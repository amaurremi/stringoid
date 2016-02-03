package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;

class y
  implements x
{
  private String le;
  private final Context mContext;
  
  public y(Context paramContext)
  {
    if (paramContext == null) {
      throw new NullPointerException("Context cannot be null");
    }
    this.mContext = paramContext.getApplicationContext();
  }
  
  private int b(String paramString1, String paramString2)
  {
    if (this.mContext == null) {
      return 0;
    }
    if (this.le != null) {}
    for (String str = this.le;; str = this.mContext.getPackageName()) {
      return this.mContext.getResources().getIdentifier(paramString1, paramString2, str);
    }
  }
  
  public Double F(String paramString)
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
      v.D("NumberFormatException parsing " + paramString);
    }
    return null;
  }
  
  public void G(String paramString)
  {
    this.le = paramString;
  }
  
  public boolean getBoolean(String paramString)
  {
    int i = b(paramString, "bool");
    if (i == 0) {
      return false;
    }
    return "true".equalsIgnoreCase(this.mContext.getString(i));
  }
  
  public int getInt(String paramString, int paramInt)
  {
    int i = b(paramString, "integer");
    if (i == 0) {
      return paramInt;
    }
    try
    {
      int j = Integer.parseInt(this.mContext.getString(i));
      return j;
    }
    catch (NumberFormatException paramString)
    {
      v.D("NumberFormatException parsing " + this.mContext.getString(i));
    }
    return paramInt;
  }
  
  public String getString(String paramString)
  {
    int i = b(paramString, "string");
    if (i == 0) {
      return null;
    }
    return this.mContext.getString(i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/analytics/tracking/android/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */