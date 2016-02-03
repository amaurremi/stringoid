package com.pocket.user;

import org.apache.a.c.k;

public abstract class a
{
  protected String a;
  private UserMeta b;
  
  public a(String paramString, UserMeta paramUserMeta)
  {
    this.a = paramString;
    this.b = paramUserMeta;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    if (this.b != null) {
      return this.b.j();
    }
    return null;
  }
  
  public String c()
  {
    if (this.b != null) {
      return this.b.g();
    }
    return null;
  }
  
  public String d()
  {
    if (this.b != null) {
      return this.b.h();
    }
    return null;
  }
  
  public int e()
  {
    if (this.b != null) {
      return this.b.k();
    }
    return 0;
  }
  
  public String f()
  {
    if (this.b != null) {
      return this.b.a();
    }
    return null;
  }
  
  public boolean g()
  {
    return (this.a != null) && (this.a.length() > 0);
  }
  
  public UserMeta h()
  {
    return this.b;
  }
  
  public boolean i()
  {
    if (this.b != null) {
      return this.b.m();
    }
    return false;
  }
  
  public String j()
  {
    String str2 = k.c(c());
    String str3 = k.c(d());
    String str1 = str2;
    if (str2.length() > 0) {
      str1 = str2 + " ";
    }
    return str1 + str3;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/user/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */