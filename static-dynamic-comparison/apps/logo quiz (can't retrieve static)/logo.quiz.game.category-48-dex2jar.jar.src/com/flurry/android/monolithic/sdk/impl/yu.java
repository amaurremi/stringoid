package com.flurry.android.monolithic.sdk.impl;

public class yu
  extends yt
{
  protected final String a;
  protected final String b;
  
  protected yu(afm paramafm, adk paramadk)
  {
    super(paramafm, paramadk);
    paramafm = paramafm.p().getName();
    int i = paramafm.lastIndexOf('.');
    if (i < 0)
    {
      this.a = "";
      this.b = ".";
      return;
    }
    this.b = paramafm.substring(0, i + 1);
    this.a = paramafm.substring(0, i);
  }
  
  public afm a(String paramString)
  {
    Object localObject = paramString;
    if (paramString.startsWith("."))
    {
      localObject = new StringBuilder(paramString.length() + this.a.length());
      if (this.a.length() != 0) {
        break label62;
      }
      ((StringBuilder)localObject).append(paramString.substring(1));
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      return super.a((String)localObject);
      label62:
      ((StringBuilder)localObject).append(this.a).append(paramString);
    }
  }
  
  public String a(Object paramObject)
  {
    String str = paramObject.getClass().getName();
    paramObject = str;
    if (str.startsWith(this.b)) {
      paramObject = str.substring(this.b.length() - 1);
    }
    return (String)paramObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/yu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */