package com.ideashower.readitlater.a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.ideashower.readitlater.h.a;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.util.o;
import com.pocket.stats.f;
import java.util.Locale;
import java.util.Random;
import org.apache.a.c.k;

public abstract class e
{
  public static boolean a()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (!i.a(a.ck)) {
      if (k.b("en", g.c().getResources().getConfiguration().locale.getLanguage()))
      {
        bool1 = bool2;
        if (o.a().nextFloat() <= 0.6F) {
          bool1 = true;
        }
        if (!bool1) {
          break label80;
        }
      }
    }
    label80:
    for (String str = "control";; str = "learn_more")
    {
      f.a("upsell_updated_button_v1", str, true);
      i.a(a.ck, bool1);
      return i.a(a.ck);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */