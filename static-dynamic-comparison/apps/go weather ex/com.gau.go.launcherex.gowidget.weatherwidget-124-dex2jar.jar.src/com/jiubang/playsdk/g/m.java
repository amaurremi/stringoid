package com.jiubang.playsdk.g;

import android.content.Context;
import com.jiubang.playsdk.a.aa;
import java.util.Random;

public class m
{
  public static final Random a = new Random(System.currentTimeMillis());
  
  public static String a(Context paramContext)
  {
    return e(paramContext) + "/recommendedapp/common.do?funid=23&rd=" + a.nextLong();
  }
  
  public static String b(Context paramContext)
  {
    return e(paramContext) + "/recommendedapp/getconfig.do?&rd=" + a.nextLong();
  }
  
  public static String c(Context paramContext)
  {
    return e(paramContext) + "/recommendedapp/common.do?funid=2&rd=" + a.nextLong();
  }
  
  public static String d(Context paramContext)
  {
    return e(paramContext) + "/recommendedapp/manage/managegood.action?rd=" + a.nextLong() + "&cid=" + aa.a().e();
  }
  
  private static String e(Context paramContext)
  {
    String str = b.a;
    if (!e.a(paramContext)) {
      str = b.c;
    }
    return str;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/g/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */