package com.ideashower.readitlater.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class SubscriptionCustomActivity
  extends a
{
  public static Intent c(Context paramContext)
  {
    return new Intent(paramContext, SubscriptionCustomActivity.class);
  }
  
  public static void d(Context paramContext)
  {
    paramContext.startActivity(c(paramContext));
  }
  
  public String f()
  {
    return "subscription_custom_login";
  }
  
  protected b l()
  {
    return b.a;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle == null) {
      b(bb.ai());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/SubscriptionCustomActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */