package com.pocket.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.objects.a;
import com.ideashower.readitlater.objects.b;

public class aa
  extends f
{
  private int a;
  
  public aa(int paramInt)
  {
    super(2);
    this.a = paramInt;
  }
  
  protected a k()
  {
    String str = null;
    switch (this.a)
    {
    }
    for (;;)
    {
      str = a.d(str);
      a locala = new a("https://getpocket.com/v3/listinfoupdate", true);
      locala.a("list_data", str);
      locala.a("list_type", this.a);
      return locala;
      str = g.c().getApplicationInfo().sourceDir;
      continue;
      str = "list_info";
    }
  }
  
  protected b l()
  {
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/c/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */