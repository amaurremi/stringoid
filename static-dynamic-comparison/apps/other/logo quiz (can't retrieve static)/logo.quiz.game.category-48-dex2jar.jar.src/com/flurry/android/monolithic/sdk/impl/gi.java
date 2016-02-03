package com.flurry.android.monolithic.sdk.impl;

public class gi
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e = null;
  
  public gi(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (gi)paramObject;
    } while ((((gi)paramObject).a.equals(this.a)) && (((gi)paramObject).c.equals(this.c)));
    return false;
  }
  
  public int hashCode()
  {
    return 36 * (this.a.hashCode() + 1296) + this.c.hashCode();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/gi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */