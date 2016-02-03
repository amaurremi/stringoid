package com.go.weatherex.managegood.a;

import android.content.Context;
import android.content.Intent;
import com.go.weatherex.managegood.b.a;
import com.go.weatherex.managegood.view.ManageGoodPaymentActivity;
import com.jiubang.playsdk.main.j;

public class n
{
  private static volatile n a = null;
  private j b = null;
  
  public static n a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new n();
      }
      return a;
    }
    finally {}
  }
  
  public void a(Context paramContext, a parama)
  {
    Intent localIntent = new Intent(paramContext, ManageGoodPaymentActivity.class);
    localIntent.putExtra("extra_manage_good_payment_info", parama);
    paramContext.startActivity(localIntent);
  }
  
  public void a(j paramj)
  {
    this.b = paramj;
  }
  
  public j b()
  {
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/managegood/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */