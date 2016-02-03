package com.pocket.gsf;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

public class a
  implements Comparable
{
  private static PackageManager a;
  private ApplicationInfo b;
  private String c;
  private GSFConfiguation d;
  private String e = "";
  
  public int a(a parama)
  {
    Object localObject2 = "";
    Object localObject1;
    String str;
    if (this.e.length() > 0)
    {
      localObject1 = this.e;
      str = "";
      localObject2 = str;
      if (parama != null)
      {
        if (parama.c().length() <= 0) {
          break label88;
        }
        localObject2 = parama.c();
      }
    }
    for (;;)
    {
      return ((String)localObject1).toLowerCase().compareTo(((String)localObject2).toLowerCase());
      localObject1 = localObject2;
      if (this.b == null) {
        break;
      }
      localObject1 = localObject2;
      if (this.b.name == null) {
        break;
      }
      localObject1 = this.b.name;
      break;
      label88:
      localObject2 = str;
      if (parama.b != null)
      {
        localObject2 = str;
        if (this.b.name != null) {
          localObject2 = parama.b.name;
        }
      }
    }
  }
  
  public Drawable a(Context paramContext)
  {
    if (a == null) {
      a = paramContext.getPackageManager();
    }
    return this.b.loadIcon(a);
  }
  
  public GSFConfiguation a()
  {
    return this.d;
  }
  
  public void a(ApplicationInfo paramApplicationInfo)
  {
    this.b = paramApplicationInfo;
  }
  
  public void a(GSFConfiguation paramGSFConfiguation)
  {
    this.d = paramGSFConfiguation;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public String b(Context paramContext)
  {
    if (this.e.length() <= 0)
    {
      if (a == null) {
        a = paramContext.getPackageManager();
      }
      paramContext = a.getApplicationLabel(this.b);
      if (paramContext != null)
      {
        this.e = paramContext.toString();
        return paramContext.toString();
      }
      return "";
    }
    return this.e;
  }
  
  public String c()
  {
    return this.e;
  }
  
  public String toString()
  {
    return "GSFApplication [appInfo=" + this.b + ", packageName=" + this.c + ", configuration=" + this.d + ", storedAppName=" + this.e + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/gsf/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */