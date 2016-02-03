package com.flurry.android.monolithic.sdk.impl;

import java.util.Iterator;
import java.util.LinkedList;

public class qw
  extends oz
{
  protected LinkedList<qx> b;
  
  public qw(String paramString)
  {
    super(paramString);
  }
  
  public qw(String paramString, ot paramot)
  {
    super(paramString, paramot);
  }
  
  public qw(String paramString, ot paramot, Throwable paramThrowable)
  {
    super(paramString, paramot, paramThrowable);
  }
  
  public qw(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public static qw a(ow paramow, String paramString)
  {
    return new qw(paramString, paramow.h());
  }
  
  public static qw a(ow paramow, String paramString, Throwable paramThrowable)
  {
    return new qw(paramString, paramow.h(), paramThrowable);
  }
  
  public static qw a(Throwable paramThrowable, qx paramqx)
  {
    if ((paramThrowable instanceof qw)) {}
    String str1;
    for (paramThrowable = (qw)paramThrowable;; paramThrowable = new qw(str1, null, paramThrowable))
    {
      paramThrowable.a(paramqx);
      return paramThrowable;
      String str2 = paramThrowable.getMessage();
      if (str2 != null)
      {
        str1 = str2;
        if (str2.length() != 0) {}
      }
      else
      {
        str1 = "(was " + paramThrowable.getClass().getName() + ")";
      }
    }
  }
  
  public static qw a(Throwable paramThrowable, Object paramObject, int paramInt)
  {
    return a(paramThrowable, new qx(paramObject, paramInt));
  }
  
  public static qw a(Throwable paramThrowable, Object paramObject, String paramString)
  {
    return a(paramThrowable, new qx(paramObject, paramString));
  }
  
  public void a(qx paramqx)
  {
    if (this.b == null) {
      this.b = new LinkedList();
    }
    if (this.b.size() < 1000) {
      this.b.addFirst(paramqx);
    }
  }
  
  public void a(Object paramObject, String paramString)
  {
    a(new qx(paramObject, paramString));
  }
  
  protected void a(StringBuilder paramStringBuilder)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      paramStringBuilder.append(((qx)localIterator.next()).toString());
      if (localIterator.hasNext()) {
        paramStringBuilder.append("->");
      }
    }
  }
  
  public String getMessage()
  {
    Object localObject = super.getMessage();
    if (this.b == null) {
      return (String)localObject;
    }
    if (localObject == null) {}
    for (localObject = new StringBuilder();; localObject = new StringBuilder((String)localObject))
    {
      ((StringBuilder)localObject).append(" (through reference chain: ");
      a((StringBuilder)localObject);
      ((StringBuilder)localObject).append(')');
      return ((StringBuilder)localObject).toString();
    }
  }
  
  public String toString()
  {
    return getClass().getName() + ": " + getMessage();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/qw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */