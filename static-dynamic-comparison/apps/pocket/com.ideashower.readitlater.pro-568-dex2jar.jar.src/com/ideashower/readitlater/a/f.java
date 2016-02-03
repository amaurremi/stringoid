package com.ideashower.readitlater.a;

import com.ideashower.readitlater.h.i;

public abstract class f
{
  public static boolean a()
  {
    boolean bool = true;
    if (i.g()) {
      bool = i.a(com.ideashower.readitlater.h.a.cp);
    }
    String str;
    do
    {
      return bool;
      str = a.b("upsell_suggestedtags_v1", true, false);
    } while (str.equals("get_suggested_tags"));
    if (str.equals("control")) {
      return false;
    }
    a.a(str);
    return false;
  }
  
  public static boolean b()
  {
    boolean bool = true;
    if (i.g()) {
      bool = i.a(com.ideashower.readitlater.h.a.cq);
    }
    String str;
    do
    {
      return bool;
      str = a.b("upsell_powersearch_v1", true, false);
    } while (str.equals("upgrade_your_search"));
    if (str.equals("control")) {
      return false;
    }
    a.a(str);
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */