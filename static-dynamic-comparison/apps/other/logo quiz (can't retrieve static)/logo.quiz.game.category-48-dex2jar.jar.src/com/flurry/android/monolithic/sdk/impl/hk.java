package com.flurry.android.monolithic.sdk.impl;

import java.util.Vector;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class hk
{
  protected String a = "";
  protected String b = "";
  protected Vector<NameValuePair> c = new Vector();
  hl d = hl.c;
  private int e = 31;
  
  public hk(String paramString)
  {
    this.a = paramString;
    this.d = hl.b;
  }
  
  public hk(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.d = hl.a;
  }
  
  public Vector<NameValuePair> a()
  {
    return this.c;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.c.add(new BasicNameValuePair(paramString1, paramString2));
  }
  
  public void a(Vector<NameValuePair> paramVector)
  {
    this.c = paramVector;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.a;
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
      paramObject = (hm)paramObject;
    } while ((((hm)paramObject).a.equals(this.a)) && (((hm)paramObject).b.equals(this.b)) && (((hm)paramObject).c.equals(this.c)));
    return false;
  }
  
  public int hashCode()
  {
    return ((this.e * this.e + this.a.hashCode()) * this.e + this.b.hashCode()) * this.e + this.c.hashCode();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/hk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */