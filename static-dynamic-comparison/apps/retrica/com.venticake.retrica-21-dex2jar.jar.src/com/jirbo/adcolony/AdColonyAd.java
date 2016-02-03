package com.jirbo.adcolony;

import java.io.Serializable;

public abstract class AdColonyAd
  implements Serializable
{
  static final int a = 0;
  static final int b = 1;
  static final int c = 2;
  static final int d = 3;
  static final int e = 4;
  int f = 0;
  String g;
  n.y h;
  n.a i;
  String j = "";
  String k = "";
  String l = "";
  double m = 0.0D;
  double n = 0.0D;
  int o;
  boolean p;
  boolean q;
  boolean r;
  
  abstract void a();
  
  abstract boolean a(boolean paramBoolean);
  
  abstract boolean b();
  
  boolean b(boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.f == 4) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        if (isReady()) {
          break;
        }
        bool1 = bool2;
      } while (!paramBoolean);
      if (a(true)) {
        break;
      }
      bool1 = bool2;
    } while (paramBoolean);
    this.h = a.l.h(this.g);
    n.a locala;
    if (paramBoolean)
    {
      locala = this.h.j();
      this.i = locala;
      if (this.i == null) {
        break label97;
      }
    }
    label97:
    for (paramBoolean = true;; paramBoolean = false)
    {
      return paramBoolean;
      locala = this.h.i();
      break;
    }
  }
  
  boolean c()
  {
    return b(false);
  }
  
  public boolean canceled()
  {
    return this.f == 1;
  }
  
  public int getAvailableViews()
  {
    if (!isReady()) {}
    while (!c()) {
      return 0;
    }
    return this.h.d();
  }
  
  abstract boolean isReady();
  
  public boolean noFill()
  {
    return this.f == 2;
  }
  
  public boolean notShown()
  {
    return this.f != 4;
  }
  
  public boolean shown()
  {
    return this.f == 4;
  }
  
  public boolean skipped()
  {
    return this.f == 3;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/AdColonyAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */