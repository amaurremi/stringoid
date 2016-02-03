package com.ideashower.readitlater.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.j;

public class PremiumPurchaseFlowActivity
  extends a
{
  private al z;
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    a(paramContext, paramInt, paramString, false);
  }
  
  public static void a(Context paramContext, int paramInt, String paramString, boolean paramBoolean)
  {
    paramContext.startActivity(b(paramContext, paramInt, paramString, paramBoolean));
  }
  
  public static Intent b(Context paramContext, int paramInt, String paramString, boolean paramBoolean)
  {
    paramContext = new Intent(paramContext, PremiumPurchaseFlowActivity.class);
    paramContext.putExtra("stage", paramInt);
    paramContext.putExtra("source", paramString);
    paramContext.putExtra("is_renew", paramBoolean);
    return paramContext;
  }
  
  protected void c(boolean paramBoolean) {}
  
  public String f()
  {
    if (this.z != null) {
      return this.z.K();
    }
    return "upgrade";
  }
  
  protected b l()
  {
    return b.d;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle == null)
    {
      this.z = al.a(getIntent().getIntExtra("stage", -1), getIntent().getStringExtra("source"), getIntent().getBooleanExtra("is_renew", false));
      a(this.z, "main", al.Y());
      return;
    }
    this.z = ((al)e().a("main"));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/PremiumPurchaseFlowActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */