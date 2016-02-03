package com.flurry.android.monolithic.sdk.impl;

import java.io.Serializable;

public class qx
  implements Serializable
{
  protected Object a;
  protected String b;
  protected int c = -1;
  
  protected qx() {}
  
  public qx(Object paramObject, int paramInt)
  {
    this.a = paramObject;
    this.c = paramInt;
  }
  
  public qx(Object paramObject, String paramString)
  {
    this.a = paramObject;
    if (paramString == null) {
      throw new NullPointerException("Can not pass null fieldName");
    }
    this.b = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Class localClass;
    if ((this.a instanceof Class))
    {
      localClass = (Class)this.a;
      Package localPackage = localClass.getPackage();
      if (localPackage != null)
      {
        localStringBuilder.append(localPackage.getName());
        localStringBuilder.append('.');
      }
      localStringBuilder.append(localClass.getSimpleName());
      localStringBuilder.append('[');
      if (this.b == null) {
        break label120;
      }
      localStringBuilder.append('"');
      localStringBuilder.append(this.b);
      localStringBuilder.append('"');
    }
    for (;;)
    {
      localStringBuilder.append(']');
      return localStringBuilder.toString();
      localClass = this.a.getClass();
      break;
      label120:
      if (this.c >= 0) {
        localStringBuilder.append(this.c);
      } else {
        localStringBuilder.append('?');
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/qx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */