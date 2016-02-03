package com.ideashower.readitlater.a;

import com.ideashower.readitlater.h.a;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.h.l;
import com.ideashower.readitlater.util.o;
import com.pocket.oauth.d;
import com.pocket.stats.h;
import java.util.Random;

public abstract class b
{
  public static boolean a()
  {
    boolean bool;
    if (!i.a(a.ch))
    {
      if (o.a().nextFloat() > 0.9F) {
        break label63;
      }
      bool = true;
      i.b().a(a.ch, bool).a();
      if (!bool) {
        break label68;
      }
    }
    label63:
    label68:
    for (String str = "google_signin";; str = "control")
    {
      h.a("mobile_sso_v1", str);
      if (!i.g()) {
        break label74;
      }
      return i.a(a.cn);
      bool = false;
      break;
    }
    label74:
    return i.a(a.ch);
  }
  
  public static boolean b()
  {
    boolean bool;
    if (!i.a(a.ci))
    {
      if (o.a().nextFloat() > 0.9F) {
        break label73;
      }
      bool = true;
      i.b().a(a.ci, bool).a();
      if (d.a(g.c(), true)) {
        if (!bool) {
          break label78;
        }
      }
    }
    label73:
    label78:
    for (String str = "control";; str = "no_learn_more")
    {
      h.a("mobile_learn_more_v1", str);
      if (!i.g()) {
        break label84;
      }
      return i.a(a.co);
      bool = false;
      break;
    }
    label84:
    return i.a(a.ci);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */