package com.ideashower.readitlater.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.util.j;
import com.pocket.p.l;
import com.pocket.q.a.b;
import com.pocket.q.a.n;
import com.pocket.q.a.p;
import com.pocket.q.a.q;
import java.util.ArrayList;
import java.util.Locale;

public class x
  extends h
{
  private n a(final int paramInt, final String paramString)
  {
    final String str = a(paramInt);
    p.b(this, paramInt).a(new b()
    {
      public void a()
      {
        HelpPageFragment.a(x.this.m(), paramInt, paramString);
        com.pocket.stats.f.a("help", str, "open", "1");
      }
    }).a();
  }
  
  private n a(int paramInt, final String paramString, final boolean paramBoolean)
  {
    p.b(this, paramInt).a(new b()
    {
      public void a()
      {
        if (paramBoolean)
        {
          Intent localIntent = new Intent(x.this.m(), FramedWebViewActivity.class);
          localIntent.putExtra("pathToLoad", paramString);
          x.this.m().startActivity(localIntent);
          return;
        }
        g.a(x.this.m(), paramString);
      }
    }).a();
  }
  
  public static void a(android.support.v4.app.f paramf)
  {
    if (ab() == l.a)
    {
      com.pocket.p.k.a(ac(), paramf);
      return;
    }
    HelpListActivity.c(paramf);
  }
  
  public static l ab()
  {
    if (j.g()) {
      return l.a;
    }
    return l.b;
  }
  
  public static x ac()
  {
    return new x();
  }
  
  private void ad()
  {
    String str2 = com.ideashower.readitlater.util.k.a();
    if (as.m()) {}
    for (String str1 = "";; str1 = n().getString(2131493234))
    {
      com.ideashower.readitlater.util.k.a(m(), str2, str1, null, true, null, null);
      return;
    }
  }
  
  public String K()
  {
    return "help_list";
  }
  
  protected int Y()
  {
    return 2131493459;
  }
  
  protected View Z()
  {
    return null;
  }
  
  protected void a(ArrayList paramArrayList)
  {
    paramArrayList.add(p.a(this, 2131493230));
    paramArrayList.add(p.b(this, 2131493232).a(new b()
    {
      public void a()
      {
        w.a(x.this.m());
        com.pocket.stats.f.a("help", x.this.a(2131493232), "open", "1");
      }
    }).a());
    paramArrayList.add(p.a(this, 2131493231));
    paramArrayList.add(a(2131493225, "help-pocket-basics.html"));
    paramArrayList.add(a(2131493235, "help-read-watch-view.html"));
    paramArrayList.add(a(2131493238, "help-sharing.html"));
    paramArrayList.add(a(2131493228, "help-get-organized.html"));
    paramArrayList.add(a(2131493240, "help-tags.html"));
    paramArrayList.add(a(2131493239, "help-offline-access.html"));
    paramArrayList.add(a(2131493226, "help-data-usage.html"));
    paramArrayList.add(a(2131493233, "help-tts.html"));
    paramArrayList.add(p.a(this, a(2131493241)));
    paramArrayList.add(a(2131493236, "http://help.getpocket.com/", false));
    q localq = p.b(this, 2131493227).a(new b()
    {
      public void a()
      {
        x.a(x.this);
      }
    });
    if (!n().getConfiguration().locale.getLanguage().equalsIgnoreCase("en")) {
      localq.a(2131493224);
    }
    paramArrayList.add(localq.a());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */