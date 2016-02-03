package com.venticake.retrica;

import android.location.Location;

public class l
{
  private static l a = null;
  private Location b = null;
  
  public static l b()
  {
    if (a == null) {
      a = new l();
    }
    return a;
  }
  
  public static void b(Location paramLocation)
  {
    b().a(paramLocation);
  }
  
  public static Location c()
  {
    return b().a();
  }
  
  protected Location a()
  {
    return this.b;
  }
  
  protected void a(Location paramLocation)
  {
    this.b = paramLocation;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */