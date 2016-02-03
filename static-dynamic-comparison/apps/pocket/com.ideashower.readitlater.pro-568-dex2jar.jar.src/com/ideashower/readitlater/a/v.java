package com.ideashower.readitlater.a;

import android.app.Activity;
import com.ideashower.readitlater.activity.SplashActivity;
import com.ideashower.readitlater.h.d;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.h.l;
import com.ideashower.readitlater.util.j;

public class v
{
  static
  {
    if (m()) {
      i.b().a(com.ideashower.readitlater.h.a.bD, true).a(com.ideashower.readitlater.h.a.bJ, true).a(com.ideashower.readitlater.h.a.bK).a(com.ideashower.readitlater.h.a.bT).a(com.ideashower.readitlater.h.a.bM).a(com.ideashower.readitlater.h.a.bL).a(com.ideashower.readitlater.h.a.bN).a();
    }
  }
  
  public static void a()
  {
    b("getstarted", "welcome", "open", 1);
  }
  
  public static void a(int paramInt)
  {
    g(paramInt);
    if (paramInt == 3) {}
    for (String str = "howtosave";; str = "list")
    {
      b(e(paramInt), str, "click_computer", c(paramInt, -1, 15, 26));
      return;
    }
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    String str2 = e(paramInt1);
    if (as.t()) {}
    for (String str1 = "1";; str1 = "2")
    {
      com.pocket.stats.f.a(str2, "apps", "open", str1, 8, 0, 0, paramInt2);
      return;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    b(e(paramInt1), f(paramInt1), "open", c(paramInt1, 3, 19, 29));
    if (paramInt1 == 1) {
      if (!as.t()) {
        break label54;
      }
    }
    label54:
    for (String str = "1";; str = "2")
    {
      com.pocket.stats.f.a("getstarted", "starter_apps", "open", str, 7, paramInt2, paramInt3, paramInt4);
      return;
    }
  }
  
  public static void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    String str;
    if (paramBoolean) {
      str = "saved_to_pocket";
    }
    for (int i = c(paramInt2, 6, 22, 32);; i = c(paramInt2, 11, 23, 33))
    {
      a(e(paramInt2), "demo", str, i, paramInt1);
      if ((paramBoolean) && (paramInt2 == 1))
      {
        q();
        i.b().a(com.ideashower.readitlater.h.a.bG, paramInt1).a();
      }
      return;
      str = "error";
    }
  }
  
  public static void a(SplashActivity paramSplashActivity)
  {
    boolean bool;
    if (m()) {
      bool = true;
    }
    for (;;)
    {
      i.b().a(com.ideashower.readitlater.h.a.bD, bool).a(com.ideashower.readitlater.h.a.y, bool).a(com.ideashower.readitlater.h.a.bE, bool).a();
      return;
      if (!a(paramSplashActivity)) {
        bool = false;
      } else {
        bool = c.a();
      }
    }
  }
  
  public static void a(String paramString)
  {
    a("getstarted", paramString, "view");
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    a(paramString1, paramString2, paramString3, 0);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (as.t()) {}
    for (String str = "1";; str = "2")
    {
      com.pocket.stats.f.a("getstarted", paramString2, paramString3, str, 6, 0, paramInt, b(paramString1, paramString2, paramString3));
      return;
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (as.t()) {}
    for (String str = "1";; str = "2")
    {
      com.pocket.stats.f.a(paramString1, paramString2, paramString3, str, 6, paramInt1, paramInt2, d(paramInt1));
      return;
    }
  }
  
  public static boolean a(Activity paramActivity)
  {
    if (!g.b().m()) {}
    while ((!com.pocket.tts.f.a(paramActivity)) || (j.a(false))) {
      return false;
    }
    return true;
  }
  
  private static int b(String paramString1, String paramString2, String paramString3)
  {
    return i.a((d)com.ideashower.readitlater.h.a.bI.a(paramString1 + paramString2 + paramString3), 1);
  }
  
  public static void b()
  {
    b("getstarted", "welcome", "click_save_first_item", 2);
  }
  
  public static void b(int paramInt)
  {
    if (paramInt == 3) {}
    for (String str = "howtosave";; str = "list")
    {
      b(e(paramInt), str, "click_apps", c(paramInt, -1, 18, 36));
      return;
    }
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    a(e(paramInt2), "demo", "open", c(paramInt2, 5, 21, 31), paramInt1);
  }
  
  public static void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(e(paramInt4), f(paramInt4), "click_app_" + paramInt2 + "_" + paramInt3, c(paramInt4, 4, 20, 30), paramInt1);
  }
  
  public static void b(String paramString)
  {
    a("getstarted", paramString, "help");
  }
  
  private static void b(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    a(paramString1, paramString2, paramString3, paramInt, 0);
  }
  
  private static int c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 == 1) {
      return paramInt2;
    }
    if (paramInt1 == 2) {
      return paramInt3;
    }
    if (paramInt1 == 3) {
      return paramInt4;
    }
    if (g.y()) {
      throw new RuntimeException("invalid start source " + paramInt1);
    }
    return -1;
  }
  
  public static void c()
  {
    q();
    b("getstarted", "save_first_item", "click_skip", 10);
  }
  
  public static void c(int paramInt)
  {
    String str2 = "saved_additional_" + paramInt;
    if (as.t()) {}
    for (String str1 = "1";; str1 = "2")
    {
      com.pocket.stats.f.a("getstarted", "list_first_open", str2, str1, 6, 0, i.a(com.ideashower.readitlater.h.a.bG), b("getstarted", "list_first_open", "saved_additional_"));
      return;
    }
  }
  
  public static void c(int paramInt1, int paramInt2)
  {
    a(e(paramInt2), "demo", "cancel_via_notification", c(paramInt2, 12, 24, 34), paramInt1);
  }
  
  public static void c(String paramString)
  {
    if (paramString.equals("list_tooltip_other_devices")) {}
    for (String str = "close";; str = "complete")
    {
      a("getstarted", paramString, str);
      return;
    }
  }
  
  private static int d(int paramInt)
  {
    int i = i.a((d)com.ideashower.readitlater.h.a.bI.b(paramInt)) + 1;
    i.b().a((d)com.ideashower.readitlater.h.a.bI.b(paramInt), i).a();
    return i;
  }
  
  public static void d()
  {
    i.b().a(com.ideashower.readitlater.h.a.bH, true).a();
    a("getstarted", "demo", "return_to_pocket", 7, i.a(com.ideashower.readitlater.h.a.bG));
  }
  
  public static void d(int paramInt1, int paramInt2)
  {
    a(e(paramInt2), "demo", "return_without_save", c(paramInt2, 13, 25, 35), paramInt1);
  }
  
  public static void d(String paramString)
  {
    a("getstarted", paramString, "view");
  }
  
  private static String e(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (g.y()) {
        throw new RuntimeException("invalid start source " + paramInt);
      }
      break;
    case 1: 
      return "getstarted";
    case 2: 
      return "howtosave_list";
    case 3: 
      return "howtosave_help";
    }
    return "unknown" + paramInt;
  }
  
  public static void e()
  {
    a("getstarted", "demo", "open_item", 9, i.a(com.ideashower.readitlater.h.a.bG));
  }
  
  public static void e(String paramString)
  {
    a("getstarted", paramString, "close");
  }
  
  private static String f(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (g.y()) {
        throw new RuntimeException("invalid start source " + paramInt);
      }
      break;
    case 1: 
      return "save_first_item";
    case 2: 
    case 3: 
      return "apps";
    }
    return "unknown" + paramInt;
  }
  
  public static void f()
  {
    int i = i.a(com.ideashower.readitlater.h.a.bF);
    if ((i != 3) && (i != 2)) {
      return;
    }
    b(e(i), "computer", "open", c(i, -1, 16, 27));
  }
  
  public static void g()
  {
    b("howtosave_list", "howtosave", "open", 38);
  }
  
  private static void g(int paramInt)
  {
    i.b().a(com.ideashower.readitlater.h.a.bF, paramInt).a();
  }
  
  public static void h()
  {
    b("howtosave_help", "howtosave", "click_email_instructions", 28);
  }
  
  public static void i()
  {
    if (i.a(com.ideashower.readitlater.h.a.bF) != 2) {
      return;
    }
    b("howtosave_list", "computer", "click_email_instructions", 17);
  }
  
  public static boolean j()
  {
    return i.a(com.ideashower.readitlater.h.a.bD);
  }
  
  public static void k()
  {
    i.b().a(com.ideashower.readitlater.h.a.bD, false).a(com.ideashower.readitlater.h.a.y, false).a();
  }
  
  public static void l()
  {
    i.b().a(com.ideashower.readitlater.h.a.bD, false).a(com.ideashower.readitlater.h.a.y, true).a();
  }
  
  public static boolean m()
  {
    return false;
  }
  
  public static boolean n()
  {
    return i.a(com.ideashower.readitlater.h.a.bJ);
  }
  
  public static void o()
  {
    i.b(com.ideashower.readitlater.h.a.bO);
    a("getstarted", "demo", "save_success_dismiss", i.a(com.ideashower.readitlater.h.a.bG));
  }
  
  public static void p()
  {
    a("getstarted", "list_tooltip_need_help", "click");
  }
  
  private static void q()
  {
    i.b().a(com.ideashower.readitlater.h.a.bD, false).a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */