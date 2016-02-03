package com.ideashower.readitlater.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.widget.Toast;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.activity.HelpPageFragment;
import com.ideashower.readitlater.activity.x;
import com.ideashower.readitlater.objects.ErrorReport;
import com.pocket.c.b;
import com.pocket.p.o;

public class k
{
  public static String a()
  {
    String str1;
    StringBuilder localStringBuilder;
    if (as.m())
    {
      str1 = "premium";
      localStringBuilder = new StringBuilder().append("+");
      if (!j.c()) {
        break label70;
      }
    }
    label70:
    for (String str2 = "at";; str2 = "ap")
    {
      str2 = str2;
      return str1 + str2 + "@getpocket.com";
      str1 = "support";
      break;
    }
  }
  
  public static String a(String paramString)
  {
    Object localObject = g.b();
    paramString = paramString + "\n\n\n";
    if (as.f()) {}
    for (paramString = paramString + "Username: " + as.e() + "\n";; paramString = paramString + "User Id: " + as.e() + "\n")
    {
      paramString = paramString + "Version: " + ((com.pocket.g.a)localObject).i() + " (" + ((com.pocket.g.a)localObject).j() + ") \n";
      paramString = paramString + "Market: " + ((com.pocket.g.a)localObject).a(true) + "\n";
      paramString = paramString + "Device: " + Build.MANUFACTURER + " " + Build.MODEL + "\n";
      paramString = paramString + "Type: " + j.h() + "\n";
      paramString = paramString + "Android: " + Build.VERSION.RELEASE + "\n";
      localObject = paramString + "Language: " + g.c().getResources().getConfiguration().locale + "\n";
      paramString = (String)localObject;
      if (as.m()) {
        paramString = (String)localObject + "Premium: Yes \n";
      }
      return paramString;
    }
  }
  
  private static String a(String paramString, ErrorReport paramErrorReport)
  {
    if (paramErrorReport == null) {
      return paramString;
    }
    paramString = paramString + "\n";
    paramString = paramString + "Error Message: " + paramErrorReport.b() + "\n";
    paramString = paramString + "Details: " + paramErrorReport.a() + "\n";
    String str = paramString + "Screen: " + paramErrorReport.e() + "\n";
    paramString = str;
    if (paramErrorReport.d() != null) {
      paramString = str + "Error Details: " + paramErrorReport.d() + "\n";
    }
    str = paramString;
    if (paramErrorReport.f() != null) {
      str = paramString + "Error Details: " + paramErrorReport.f() + "\n";
    }
    return str;
  }
  
  public static void a(int paramInt, com.ideashower.readitlater.activity.a parama)
  {
    if (parama.isFinishing()) {
      return;
    }
    String str;
    switch (paramInt)
    {
    default: 
      x.a(parama);
      e.a("unknown id " + paramInt);
      return;
    case 3: 
      str = "help-offline-access";
      paramInt = 2131493243;
    }
    for (;;)
    {
      HelpPageFragment.a(parama, paramInt, str + ".html");
      return;
      str = "help-tts";
      paramInt = 2131493246;
      continue;
      str = "help-save-from-apps";
      paramInt = 2131493244;
    }
  }
  
  public static void a(int paramInt, ErrorReport paramErrorReport, Context paramContext)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "Android App Error";
    }
    for (;;)
    {
      a(paramContext, a(), str, "", true, paramErrorReport, null);
      return;
      str = "Android App - Need help syncing";
      continue;
      str = "Android App - Need help logging in";
      continue;
      str = "Android App - Database problem";
      continue;
      str = "Android App - Need help editing my account";
      continue;
      str = "Android App - Need help downloading my list";
      continue;
      str = "Android App - Package error";
      continue;
      str = "Android App - HTC Flyer & Evo View";
      continue;
      str = "Android App - Send Response Error";
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, ErrorReport paramErrorReport, String paramString4)
  {
    String str = org.apache.a.c.k.c(paramString3);
    paramString3 = str;
    if (paramBoolean) {
      paramString3 = a(str);
    }
    h.a(paramString1, paramString2, a(paramString3, paramErrorReport), paramString4, paramContext);
  }
  
  public static void a(b paramb, Activity paramActivity)
  {
    if (paramb == b.a) {}
    for (paramb = "http://help.getpocket.com/customer/portal/articles/504836";; paramb = "http://help.getpocket.com/customer/portal/articles/481720")
    {
      paramb = new Intent("android.intent.action.VIEW", Uri.parse(paramb));
      paramb.addFlags(524288);
      if (!o.a(paramActivity, paramb)) {
        break;
      }
      paramActivity.startActivity(paramb);
      return;
    }
    Toast.makeText(paramActivity, 2131493742, 1).show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/util/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */