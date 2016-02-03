package com.jiubang.playsdk.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class k
{
  private SharedPreferences a;
  private SharedPreferences.Editor b;
  
  public k(Context paramContext, String paramString)
  {
    this.a = paramContext.getSharedPreferences(paramString, 0);
    this.b = this.a.edit();
  }
  
  public String a(String paramString1, String paramString2)
  {
    return this.a.getString(paramString1, paramString2);
  }
  
  public void a()
  {
    this.b.commit();
  }
  
  public void a(String paramString, long paramLong)
  {
    this.b.putLong(paramString, paramLong);
  }
  
  public long b(String paramString, long paramLong)
  {
    return this.a.getLong(paramString, paramLong);
  }
  
  public void b(String paramString1, String paramString2)
  {
    this.b.putString(paramString1, paramString2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/g/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */