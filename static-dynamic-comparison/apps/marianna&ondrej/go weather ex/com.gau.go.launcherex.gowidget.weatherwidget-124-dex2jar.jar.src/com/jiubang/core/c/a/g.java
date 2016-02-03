package com.jiubang.core.c.a;

import android.content.Context;
import android.text.TextUtils;
import com.gtp.go.weather.sharephoto.d.m;
import java.util.ArrayList;
import java.util.HashMap;

public class g
{
  private static g a;
  private Context b;
  private int c = 0;
  private HashMap d;
  private ArrayList e;
  
  private g(Context paramContext)
  {
    this.b = paramContext;
    this.c = 0;
    this.d = new HashMap();
  }
  
  public static g a(Context paramContext)
  {
    if (a == null) {
      a = new g(paramContext);
    }
    return a;
  }
  
  public static String a(String paramString)
  {
    String str = m.a(paramString);
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    return Integer.toString(paramString.hashCode());
  }
  
  private void a()
  {
    int j = this.c;
    int i = j;
    if (this.e != null) {
      i = j + this.e.size();
    }
    if (i == 0) {
      b();
    }
    while ((this.e == null) || (this.e.size() <= 0) || (this.c >= 2)) {
      return;
    }
    a locala = (a)this.e.remove(0);
    this.c += 1;
    new i(this, null).execute(new a[] { locala });
  }
  
  private void b()
  {
    a = null;
    this.d.clear();
  }
  
  public void a(a parama)
  {
    if (!this.d.containsKey(parama.a))
    {
      this.d.put(parama.a, parama);
      if (this.c < 2)
      {
        this.c += 1;
        new i(this, null).execute(new a[] { parama });
      }
    }
    else
    {
      return;
    }
    if (this.e == null) {
      this.e = new ArrayList();
    }
    this.e.add(parama);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/c/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */