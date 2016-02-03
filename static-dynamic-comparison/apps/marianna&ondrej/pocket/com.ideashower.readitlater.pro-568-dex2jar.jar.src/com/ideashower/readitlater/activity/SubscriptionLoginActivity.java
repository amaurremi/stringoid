package com.ideashower.readitlater.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class SubscriptionLoginActivity
  extends a
{
  public static Intent a(Context paramContext, String paramString)
  {
    paramContext = new Intent(paramContext, SubscriptionLoginActivity.class);
    paramContext.putExtra("SubscriptionLoginActivity.Host", paramString);
    return paramContext;
  }
  
  public static void b(Context paramContext, String paramString)
  {
    paramContext.startActivity(a(paramContext, paramString));
  }
  
  public String f()
  {
    return "subscription_login";
  }
  
  protected b l()
  {
    return b.a;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle == null) {
      b(be.a(getIntent().getStringExtra("SubscriptionLoginActivity.Host")));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/SubscriptionLoginActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */