package com.gau.go.launcherex.gowidget.weather.d;

import com.gau.go.launcherex.gowidget.googleplay.IabException;
import com.gau.go.launcherex.gowidget.googleplay.IabHelper;
import com.gau.go.launcherex.gowidget.googleplay.Inventory;
import com.jiubang.core.c.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class q
  extends a
{
  q(p paramp) {}
  
  protected ArrayList a(IabHelper... paramVarArgs)
  {
    p.a(this.a).logDebug("IAB AsyncPurchaseTask!: ");
    IabHelper localIabHelper = paramVarArgs[0];
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add("com.gau.go.launcherex.gowidget.weatherwidge.billingpay1");
    ((ArrayList)localObject).add("go_weather_ex_premium_pack_promotions");
    ((ArrayList)localObject).add("go_weather_ex_premium_pack_theme_vip");
    ((ArrayList)localObject).add("go_weather_ex_premium_pack_theme_vip_promo");
    ((ArrayList)localObject).add("go_weather_ex_premium_pack_vip");
    ((ArrayList)localObject).add("go_weather_ex_premium_pack_vip_promo");
    paramVarArgs = new ArrayList();
    try
    {
      if (!localIabHelper.isDisposed())
      {
        Inventory localInventory = localIabHelper.queryInventory(true, (List)localObject);
        p.a(this.a).logDebug("QueryInventory finish");
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          p.a(this.a).logDebug("itemSku : " + str);
          if (localInventory.getPurchase(str) != null)
          {
            localIabHelper.logDebug(str + " is Pay");
            paramVarArgs.add(str);
          }
        }
      }
      return null;
    }
    catch (IabException paramVarArgs)
    {
      paramVarArgs.printStackTrace();
      localIabHelper.logDebug("queryInventory：" + paramVarArgs.getResult());
      return null;
      for (;;)
      {
        return paramVarArgs;
        paramVarArgs = null;
      }
    }
    catch (IllegalStateException paramVarArgs)
    {
      paramVarArgs.printStackTrace();
      localIabHelper.logDebug("queryInventory：IllegalStateException");
    }
  }
  
  protected void a(ArrayList paramArrayList)
  {
    super.a(paramArrayList);
    if (p.a(this.a) != null)
    {
      p.a(this.a).dispose();
      if (paramArrayList != null)
      {
        p.a(this.a, paramArrayList);
        p.b(this.a, paramArrayList);
        p.c(this.a, paramArrayList);
      }
    }
    p.a(this.a, false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/d/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */