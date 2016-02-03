package com.android.a;

import android.content.Intent;

public class a
  extends aa
{
  private Intent b;
  
  public a() {}
  
  public a(m paramm)
  {
    super(paramm);
  }
  
  public String getMessage()
  {
    if (this.b != null) {
      return "User needs to (re)enter credentials.";
    }
    return super.getMessage();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/android/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */