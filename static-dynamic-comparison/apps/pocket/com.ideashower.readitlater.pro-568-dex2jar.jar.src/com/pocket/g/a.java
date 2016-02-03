package com.pocket.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.ideashower.readitlater.a.an;
import com.ideashower.readitlater.a.ap;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.a.v;
import com.ideashower.readitlater.activity.GiftMessageActivity;
import com.ideashower.readitlater.activity.GsfActivity;
import com.ideashower.readitlater.activity.LoginPromptPasswordActivity;
import com.ideashower.readitlater.activity.PocketActivity;
import com.ideashower.readitlater.activity.SplashActivity;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.util.e;
import com.ideashower.readitlater.util.j;
import com.pocket.billing.PremiumGiftMessage;
import com.pocket.p.o;
import java.util.ArrayList;

public class a
{
  private final String a;
  private final String b;
  private String c;
  
  public a(String paramString)
  {
    this.a = paramString;
    this.b = a(paramString);
  }
  
  private static String a(String paramString)
  {
    if (paramString.equals("yandex")) {
      return "Yandex";
    }
    if (paramString.equals("play")) {
      return "Google";
    }
    if (paramString.equals("nokia")) {
      return "Nokia";
    }
    if (paramString.equals("wandoujia")) {
      return "Wandoujia";
    }
    if (paramString.equals("samsung")) {
      return "Samsung";
    }
    if (paramString.equals("amazon")) {
      return "Amazon";
    }
    return "Unknown";
  }
  
  private PackageInfo q()
  {
    Object localObject = g.c().getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo(g.c().getPackageName(), 0);
      return (PackageInfo)localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      e.a(localNameNotFoundException, true);
    }
    return null;
  }
  
  private String r()
  {
    ArrayList localArrayList = new ArrayList();
    Context localContext = g.c();
    if (o.a(localContext, "com.yandex.store")) {
      localArrayList.add("Yandex");
    }
    if (o.a(localContext, "com.wandoujia.phoenix2")) {
      localArrayList.add("Wandoujia");
    }
    if ((o.a(localContext, "com.amazon.venezia")) || (j.a(false))) {
      localArrayList.add("Amazon");
    }
    if (o.a(localContext, "me.onemobile.android")) {
      localArrayList.add("1Mobile");
    }
    if (o.a(localContext, "com.nokia.nstore")) {
      localArrayList.add("Nokia");
    }
    if (o.a(localContext, "com.sec.android.app.samsungapps")) {
      localArrayList.add("Samsung");
    }
    if (o.a(localContext, "com.android.vending")) {
      localArrayList.add("Google");
    }
    if (localArrayList.isEmpty()) {
      return "Unknown";
    }
    return (String)localArrayList.get(0);
  }
  
  public final String a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.b;
    }
    if (this.c == null) {
      this.c = r();
    }
    return this.c;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public String b()
  {
    return "e3f1e1d9145ac77ec2c61f04f343bd99";
  }
  
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (h().equals("amazon"))) {
      i.a(com.ideashower.readitlater.h.a.r, true);
    }
  }
  
  public String c()
  {
    if (i.a(com.ideashower.readitlater.h.a.r))
    {
      if (j.c()) {
        return "5516-245d8e9eb0168b6503a17ec9";
      }
      return "5515-0968af5ecbd93512d966b338";
    }
    if (j.c()) {
      return "5514-ca6ec859d6ca2f9eb15961bb";
    }
    return "5513-8646141fb5902c766272e74d";
  }
  
  public String d()
  {
    return "market://details?id=com.ideashower.readitlater.pro";
  }
  
  public boolean e()
  {
    return a();
  }
  
  public boolean f()
  {
    return !a();
  }
  
  public String g()
  {
    return "Free";
  }
  
  public String h()
  {
    return this.a;
  }
  
  public String i()
  {
    PackageInfo localPackageInfo = q();
    if (localPackageInfo != null) {
      return localPackageInfo.versionName;
    }
    return "";
  }
  
  public int j()
  {
    PackageInfo localPackageInfo = q();
    if (localPackageInfo != null) {
      return localPackageInfo.versionCode;
    }
    return -1;
  }
  
  public ap k()
  {
    if (an.a()) {
      return new an();
    }
    return null;
  }
  
  public Class l()
  {
    if (!as.l()) {
      return SplashActivity.class;
    }
    if (i.a(com.ideashower.readitlater.h.a.n)) {
      return LoginPromptPasswordActivity.class;
    }
    if (PremiumGiftMessage.a()) {
      return GiftMessageActivity.class;
    }
    if (v.j()) {
      return GsfActivity.class;
    }
    return PocketActivity.class;
  }
  
  public boolean m()
  {
    return true;
  }
  
  public String n()
  {
    return null;
  }
  
  public String o()
  {
    return null;
  }
  
  public String p()
  {
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/g/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */