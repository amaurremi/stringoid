package com.pocket.user;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class d
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private int f;
  private boolean g;
  private boolean h;
  private int i;
  private int j;
  private ArrayList k = new ArrayList();
  
  public d() {}
  
  public d(UserMeta paramUserMeta)
  {
    this.a = paramUserMeta.a();
    this.b = paramUserMeta.g();
    this.c = paramUserMeta.h();
    this.d = paramUserMeta.i();
    this.e = paramUserMeta.j();
    this.f = paramUserMeta.k();
    this.k = paramUserMeta.f();
    this.g = paramUserMeta.b();
    this.h = paramUserMeta.c();
    this.i = paramUserMeta.d();
    this.j = paramUserMeta.e();
  }
  
  public UserMeta a()
  {
    return new UserMeta(this, null);
  }
  
  public d a(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public d a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public d a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      throw new InvalidParameterException("email cannot be null");
    }
    this.k.add(new e(paramString, paramBoolean, null));
    return this;
  }
  
  public d a(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
  }
  
  public d b(int paramInt)
  {
    this.i = paramInt;
    return this;
  }
  
  public d b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public d b(boolean paramBoolean)
  {
    this.h = paramBoolean;
    return this;
  }
  
  public d c(int paramInt)
  {
    this.j = paramInt;
    return this;
  }
  
  public d c(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public d d(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public d e(String paramString)
  {
    this.e = paramString;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/user/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */