package com.ideashower.readitlater.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import org.apache.a.c.k;

public class HelpPageActivity
  extends a
{
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    paramContext.startActivity(b(paramContext, paramInt, paramString));
  }
  
  public static Intent b(Context paramContext, int paramInt, String paramString)
  {
    paramContext = new Intent(paramContext, HelpPageActivity.class);
    paramContext.putExtra("title", paramInt);
    paramContext.putExtra("path", paramString);
    return paramContext;
  }
  
  public String f()
  {
    return "help_" + k.c(getIntent().getStringExtra("title"));
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
      b(HelpPageFragment.a(paramBundle.getIntExtra("title", 0), paramBundle.getStringExtra("path")));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/HelpPageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */