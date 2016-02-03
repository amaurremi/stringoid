package com.ideashower.readitlater.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import org.apache.a.c.k;

public class WalkthroughActivity
  extends a
{
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    paramContext.startActivity(b(paramContext, paramString1, paramInt, paramString2));
  }
  
  private static Intent b(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    paramContext = new Intent(paramContext, WalkthroughActivity.class);
    paramContext.putExtra("WalkthroughActivity.name", paramString1);
    paramContext.putExtra("WalkthroughActivity.path", paramInt);
    paramContext.putExtra("WalkthroughActivity.page", paramString2);
    return paramContext;
  }
  
  public String f()
  {
    return "walkthrough" + k.c(getIntent().getStringExtra("WalkthroughActivity.name"));
  }
  
  protected b l()
  {
    return b.a;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle == null)
    {
      paramBundle = getIntent();
      b(bl.a(paramBundle.getStringExtra("WalkthroughActivity.name"), paramBundle.getIntExtra("WalkthroughActivity.path", 0), paramBundle.getStringExtra("WalkthroughActivity.page")));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/WalkthroughActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */