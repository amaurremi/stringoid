package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

class ka
{
  private final String a;
  private final String b;
  private final String c;
  
  public ka(String paramString1, String paramString2)
  {
    if (paramString1 == null)
    {
      this.c = null;
      this.b = null;
      this.a = null;
      return;
    }
    int i = paramString1.lastIndexOf('.');
    if (i < 0)
    {
      this.b = paramString2;
      this.a = ji.g(paramString1);
      if (this.b != null) {
        break label97;
      }
    }
    label97:
    for (paramString1 = this.a;; paramString1 = this.b + "." + this.a)
    {
      this.c = paramString1;
      return;
      this.b = paramString1.substring(0, i);
      this.a = ji.g(paramString1.substring(i + 1, paramString1.length()));
      break;
    }
  }
  
  public String a(String paramString)
  {
    if ((this.b == null) || (this.b.equals(paramString))) {
      return this.a;
    }
    return this.c;
  }
  
  public void a(kc paramkc, or paramor)
    throws IOException
  {
    if (this.a != null) {
      paramor.a("name", this.a);
    }
    if (this.b != null)
    {
      if (!this.b.equals(paramkc.a())) {
        paramor.a("namespace", this.b);
      }
      if (paramkc.a() == null) {
        paramkc.a(this.b);
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof ka)) {
        return false;
      }
      paramObject = (ka)paramObject;
      if (this.c != null) {
        break;
      }
    } while (((ka)paramObject).c == null);
    return false;
    return this.c.equals(((ka)paramObject).c);
  }
  
  public int hashCode()
  {
    if (this.c == null) {
      return 0;
    }
    return this.c.hashCode();
  }
  
  public String toString()
  {
    return this.c;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ka.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */