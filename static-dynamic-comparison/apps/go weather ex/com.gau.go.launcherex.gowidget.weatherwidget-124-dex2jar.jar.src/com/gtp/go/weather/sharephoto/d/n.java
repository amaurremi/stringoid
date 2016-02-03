package com.gtp.go.weather.sharephoto.d;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gtp.go.weather.sharephoto.a.g;
import java.util.ArrayList;
import java.util.Collections;

public class n
{
  private static Account a(AccountManager paramAccountManager)
  {
    paramAccountManager = paramAccountManager.getAccountsByType("com.google");
    if (paramAccountManager.length == 1) {
      return paramAccountManager[0];
    }
    return null;
  }
  
  public static ArrayList a(ArrayList paramArrayList)
  {
    Collections.sort(paramArrayList, new o());
    return paramArrayList;
  }
  
  public static boolean a(Context paramContext)
  {
    return !TextUtils.isEmpty(g.a(paramContext).b().a());
  }
  
  public static String b(Context paramContext)
  {
    paramContext = a(AccountManager.get(paramContext));
    if (paramContext == null) {
      return null;
    }
    return paramContext.name;
  }
  
  public static boolean c(Context paramContext)
  {
    paramContext = y.n(paramContext).toLowerCase();
    return (!TextUtils.isEmpty(paramContext)) && ((paramContext.equals("us")) || (paramContext.equals("ca")));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/d/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */