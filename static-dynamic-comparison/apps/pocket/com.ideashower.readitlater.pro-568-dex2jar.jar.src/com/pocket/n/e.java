package com.pocket.n;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ideashower.readitlater.views.p;
import com.pocket.list.adapter.data.ItemQuery;
import com.pocket.list.adapter.data.l;
import org.apache.a.c.k;

public class e
{
  private final String a;
  private final String b;
  
  private e(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = k.a(paramString2);
  }
  
  private int a(f paramf)
  {
    switch (1.a[paramf.ordinal()])
    {
    default: 
      return 2130903127;
    case 1: 
      return 2130903128;
    }
    return 2130903176;
  }
  
  public static e a(ItemQuery paramItemQuery)
  {
    if (paramItemQuery == null) {}
    do
    {
      do
      {
        return null;
        if (paramItemQuery.B()) {
          return a("tag", paramItemQuery.A());
        }
        if (paramItemQuery.w()) {
          return a("in", "favorites");
        }
        if (paramItemQuery.i() == 1) {
          return a("in", "shared");
        }
      } while (!paramItemQuery.D());
      if (paramItemQuery.E() == 1) {
        return a("in", "article");
      }
      if (paramItemQuery.E() == 2) {
        return a("in", "video");
      }
    } while (paramItemQuery.E() != 3);
    return a("in", "image");
  }
  
  public static e a(String paramString1, String paramString2)
  {
    if (k.c(paramString1)) {
      return null;
    }
    if (k.c(paramString2))
    {
      com.ideashower.readitlater.util.e.a("has key but missing value");
      return null;
    }
    return new e(paramString1, paramString2);
  }
  
  private CharSequence a(Context paramContext)
  {
    String str3 = this.a;
    String str2 = this.b;
    String str1;
    if ("tag".equals(str3)) {
      if (str2.equals("_untagged_")) {
        str1 = paramContext.getString(2131493367);
      }
    }
    do
    {
      do
      {
        return str1;
        return this.b;
        str1 = str2;
      } while (!"in".equals(str3));
      if ("favorites".equals(str2)) {
        return paramContext.getString(2131493458);
      }
      if ("shared".equals(str2)) {
        return paramContext.getString(2131493477);
      }
      if ("article".equals(str2)) {
        return paramContext.getString(2131493451);
      }
      if ("video".equals(str2)) {
        return paramContext.getString(2131493489);
      }
      str1 = str2;
    } while (!"image".equals(str2));
    return paramContext.getString(2131493461);
  }
  
  private int c()
  {
    int j = 0;
    String str1 = this.a;
    String str2 = this.b;
    int i;
    if ("tag".equals(str1)) {
      i = 2130837649;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (!"in".equals(str1));
      i = j;
    } while (!"favorites".equals(str2));
    return 2130837647;
  }
  
  public View a(Context paramContext, ViewGroup paramViewGroup, f paramf)
  {
    paramViewGroup = LayoutInflater.from(paramContext).inflate(a(paramf), paramViewGroup, false);
    paramf = (TextView)paramViewGroup.findViewById(2131230994);
    paramf.setText(a(paramContext));
    int i = c();
    if (i != 0)
    {
      paramf.setCompoundDrawablesWithIntrinsicBounds(new p(i, paramContext, paramf.getTextColors()), null, null, null);
      return paramViewGroup;
    }
    paramf.setCompoundDrawables(null, null, null, null);
    return paramViewGroup;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(l paraml)
  {
    String str1 = a();
    String str2 = b();
    if ("tag".equals(str1)) {}
    do
    {
      paraml.c(null);
      do
      {
        return;
      } while (!"in".equals(str1));
      if ("favorites".equals(str2))
      {
        paraml.a(null);
        return;
      }
      if ("shared".equals(str2))
      {
        paraml.b(null);
        return;
      }
      if ("article".equals(str2))
      {
        paraml.e(null);
        return;
      }
      if ("video".equals(str2))
      {
        paraml.e(null);
        return;
      }
    } while (!"image".equals(str2));
    paraml.e(null);
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String toString()
  {
    return a() + ":" + b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/n/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */