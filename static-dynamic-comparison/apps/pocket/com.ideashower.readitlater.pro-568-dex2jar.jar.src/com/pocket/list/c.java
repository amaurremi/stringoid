package com.pocket.list;

import android.content.Context;
import android.content.res.Resources;
import com.ideashower.readitlater.objects.ErrorReport;
import com.ideashower.readitlater.util.e;
import com.ideashower.readitlater.views.k;
import com.ideashower.readitlater.views.l;
import com.pocket.list.adapter.data.ItemQuery;

public class c
  implements l
{
  private final com.pocket.list.adapter.a a;
  private final Context b;
  private final Resources c;
  
  public c(Context paramContext, com.pocket.list.adapter.a parama)
  {
    this.b = paramContext;
    this.c = paramContext.getResources();
    this.a = parama;
  }
  
  private String a(ItemQuery paramItemQuery, boolean paramBoolean)
  {
    int i;
    if ((paramItemQuery.v()) && (paramItemQuery.w()))
    {
      i = 2131493389;
      paramBoolean = true;
    }
    while (paramBoolean)
    {
      return org.apache.a.c.f.a.b(this.b.getString(i));
      if ((paramItemQuery.f()) && (paramItemQuery.e().intValue() == 1))
      {
        i = 2131493387;
        paramBoolean = true;
      }
      else
      {
        i = 2131493392;
      }
    }
    return this.b.getString(i).toLowerCase();
  }
  
  private void a(k paramk, ItemQuery paramItemQuery, Resources paramResources)
  {
    paramk.a(paramResources.getString(2131493385, new Object[] { org.apache.a.c.f.a.b(paramResources.getString(2131493387)) }), paramResources.getString(2131493378), 2130837853);
  }
  
  private String b(ItemQuery paramItemQuery, boolean paramBoolean)
  {
    int i = 0;
    switch (paramItemQuery.E())
    {
    }
    while (paramBoolean)
    {
      return org.apache.a.c.f.a.b(this.b.getString(i));
      i = 2131493391;
      continue;
      i = 2131493388;
      continue;
      i = 2131493390;
      continue;
      i = 2131493393;
    }
    return this.c.getString(i).toLowerCase();
  }
  
  private void b(k paramk, ItemQuery paramItemQuery, Resources paramResources)
  {
    paramk.a(paramResources.getString(2131493385, new Object[] { org.apache.a.c.f.a.b(paramResources.getString(2131493389)) }), paramResources.getString(2131493384), 2130837858);
  }
  
  private void c(k paramk, ItemQuery paramItemQuery, Resources paramResources)
  {
    paramk.a(paramResources.getString(2131493397), paramResources.getString(2131493413), 2130837725);
  }
  
  private void d(k paramk, ItemQuery paramItemQuery, Resources paramResources)
  {
    paramk.a(paramResources.getString(2131493407), null, 0);
  }
  
  private void e(k paramk, ItemQuery paramItemQuery, Resources paramResources)
  {
    int i;
    switch (paramItemQuery.E())
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      paramk.a(paramResources.getString(2131493383, new Object[] { b(paramItemQuery, true) }), paramResources.getString(2131493382, new Object[] { b(paramItemQuery, false), a(paramItemQuery, false) }), i);
      return;
      i = 2130837868;
      continue;
      i = 2130837854;
      continue;
      i = 2130837867;
      continue;
      i = 2130837878;
    }
  }
  
  private void f(k paramk, ItemQuery paramItemQuery, Resources paramResources)
  {
    paramk.a(paramResources.getString(2131493404), paramResources.getString(2131493403, new Object[] { a(paramItemQuery, false) }), 2130837724);
  }
  
  private void g(k paramk, ItemQuery paramItemQuery, Resources paramResources)
  {
    String str;
    if (paramItemQuery.A().equals("_untagged_"))
    {
      str = paramResources.getString(2131493409);
      paramItemQuery = paramResources.getString(2131493408, new Object[] { a(paramItemQuery, false) });
    }
    for (paramResources = str;; paramResources = str)
    {
      paramk.a(paramResources, paramItemQuery, 2130837877);
      return;
      str = paramResources.getString(2131493406);
      paramItemQuery = paramResources.getString(2131493405, new Object[] { paramItemQuery.A(), a(paramItemQuery, false) });
    }
  }
  
  private void h(k paramk, ItemQuery paramItemQuery, Resources paramResources)
  {
    paramk.a(paramResources.getString(2131493402), paramResources.getString(2131493396), 0);
  }
  
  public void a(k paramk)
  {
    ItemQuery localItemQuery = this.a.c();
    Resources localResources = this.c;
    if (localItemQuery.y())
    {
      h(paramk, localItemQuery, localResources);
      return;
    }
    if (localItemQuery.B())
    {
      g(paramk, localItemQuery, localResources);
      return;
    }
    if (localItemQuery.h())
    {
      f(paramk, localItemQuery, localResources);
      return;
    }
    if (localItemQuery.D())
    {
      e(paramk, localItemQuery, localResources);
      return;
    }
    if (localItemQuery.n() != 0)
    {
      d(paramk, localItemQuery, localResources);
      return;
    }
    if (localItemQuery.J())
    {
      c(paramk, localItemQuery, localResources);
      return;
    }
    if ((localItemQuery.v()) && (localItemQuery.w()))
    {
      b(paramk, localItemQuery, localResources);
      return;
    }
    if (!localItemQuery.f())
    {
      c(paramk, localItemQuery, localResources);
      return;
    }
    if (localItemQuery.e().intValue() == 1)
    {
      a(paramk, localItemQuery, localResources);
      return;
    }
    e.a("unexpected query " + localItemQuery, true);
    h(paramk, localItemQuery, localResources);
  }
  
  public void a(k paramk, boolean paramBoolean, ErrorReport paramErrorReport)
  {
    String str = this.c.getString(2131493381);
    if (!this.a.c().f()) {}
    for (paramErrorReport = this.c.getString(2131493379);; paramErrorReport = this.c.getString(2131493380))
    {
      paramk.a(str, paramErrorReport, 0);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */