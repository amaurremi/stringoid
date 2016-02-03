package com.ideashower.readitlater.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.pocket.billing.PremiumStatus;

public class PremiumSettingsActivity
  extends a
{
  public static void a(Context paramContext, PremiumStatus paramPremiumStatus)
  {
    paramContext.startActivity(b(paramContext, paramPremiumStatus));
  }
  
  public static Intent b(Context paramContext, PremiumStatus paramPremiumStatus)
  {
    paramContext = new Intent(paramContext, PremiumSettingsActivity.class);
    paramContext.putExtra("info", paramPremiumStatus);
    return paramContext;
  }
  
  public String f()
  {
    return "premium_settings";
  }
  
  protected b l()
  {
    return b.a;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle == null) {
      b(an.a((PremiumStatus)getIntent().getParcelableExtra("info")));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/PremiumSettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */