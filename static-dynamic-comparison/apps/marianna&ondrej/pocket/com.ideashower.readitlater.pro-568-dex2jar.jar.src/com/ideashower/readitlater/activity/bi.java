package com.ideashower.readitlater.activity;

import android.support.v4.app.f;
import android.view.View;
import com.ideashower.readitlater.a.a.d;
import com.ideashower.readitlater.a.a.e;
import com.ideashower.readitlater.util.j;
import com.pocket.p.k;
import com.pocket.p.l;
import com.pocket.q.a.b;
import com.pocket.q.a.p;
import com.pocket.q.a.q;
import java.util.ArrayList;
import java.util.Iterator;

public class bi
  extends h
{
  public static void a(f paramf)
  {
    if (ab() == l.a)
    {
      k.a(ac(), paramf);
      return;
    }
    SubscriptionsActivity.d(paramf);
  }
  
  public static l ab()
  {
    if (j.g()) {
      return l.a;
    }
    return l.b;
  }
  
  public static bi ac()
  {
    return new bi();
  }
  
  public String K()
  {
    return "subscription_list";
  }
  
  protected int Y()
  {
    return 2131493708;
  }
  
  protected View Z()
  {
    return null;
  }
  
  protected void a(ArrayList paramArrayList)
  {
    paramArrayList.add(p.a(this, 2131493672));
    Iterator localIterator = com.ideashower.readitlater.a.a.a.c().a().iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      final String str = locale.b();
      paramArrayList.add(p.b(this, org.apache.a.c.f.a.a(locale.a())).a(new b()
      {
        public void a()
        {
          be.a(bi.this.m(), str);
        }
      }).a());
    }
    paramArrayList.add(p.a(this, 2131493670));
    paramArrayList.add(p.b(this, 2131493676).a(new b()
    {
      public void a()
      {
        bb.a(bi.this.m());
      }
    }).a());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */