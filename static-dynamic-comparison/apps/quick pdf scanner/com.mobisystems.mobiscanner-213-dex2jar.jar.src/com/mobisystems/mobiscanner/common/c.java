package com.mobisystems.mobiscanner.common;

import android.util.Log;

public class c
{
  private static int avz = 4;
  private String avA;
  private String mTag;
  
  public c()
  {
    String str = Thread.currentThread().getStackTrace()[3].getClassName();
    int i = str.lastIndexOf('.');
    if ((i >= 0) && (i < str.length()))
    {
      this.mTag = str.substring(i + 1);
      return;
    }
    this.mTag = str;
  }
  
  public c(Object paramObject)
  {
    this.mTag = paramObject.getClass().getSimpleName();
    this.avA = d.ay(paramObject);
  }
  
  public void A(String paramString)
  {
    if (avz <= 6)
    {
      String str2 = this.mTag;
      String str1 = paramString;
      if (this.avA != null) {
        str1 = "[" + this.avA + "]: " + paramString;
      }
      Log.e(str2, str1);
    }
  }
  
  public void D(String paramString)
  {
    if (avz <= 5)
    {
      String str2 = this.mTag;
      String str1 = paramString;
      if (this.avA != null) {
        str1 = "[" + this.avA + "]: " + paramString;
      }
      Log.w(str2, str1);
    }
  }
  
  public void dl(String paramString)
  {
    if (avz <= 3)
    {
      String str2 = this.mTag;
      String str1 = paramString;
      if (this.avA != null) {
        str1 = "[" + this.avA + "]: " + paramString;
      }
      Log.d(str2, str1);
    }
  }
  
  public void g(String paramString, Throwable paramThrowable)
  {
    if (avz <= 6)
    {
      String str2 = this.mTag;
      String str1 = paramString;
      if (this.avA != null) {
        str1 = "[" + this.avA + "]: " + paramString;
      }
      Log.e(str2, str1, paramThrowable);
    }
  }
  
  public void h(String paramString, Throwable paramThrowable)
  {
    if (avz <= 3)
    {
      String str2 = this.mTag;
      String str1 = paramString;
      if (this.avA != null) {
        str1 = "[" + this.avA + "]: " + paramString;
      }
      Log.d(str2, str1, paramThrowable);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/common/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */