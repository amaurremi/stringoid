package com.ideashower.readitlater.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class FacebookAuthActivity
  extends a
{
  public static void c(Context paramContext)
  {
    paramContext.startActivity(d(paramContext));
  }
  
  public static Intent d(Context paramContext)
  {
    return new Intent(paramContext, FacebookAuthActivity.class);
  }
  
  public String f()
  {
    return "facebook_login";
  }
  
  protected b l()
  {
    return b.a;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle == null) {
      b(r.Y());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/FacebookAuthActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */