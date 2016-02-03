package com.flurry.android.monolithic.sdk.impl;

public class oa
{
  private final String a;
  private final ob b;
  private final oj c;
  
  public oa(String paramString, oj paramoj)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Name may not be null");
    }
    if (paramoj == null) {
      throw new IllegalArgumentException("Body may not be null");
    }
    this.a = paramString;
    this.c = paramoj;
    this.b = new ob();
    a(paramoj);
    b(paramoj);
    c(paramoj);
  }
  
  public String a()
  {
    return this.a;
  }
  
  protected void a(oj paramoj)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("form-data; name=\"");
    localStringBuilder.append(a());
    localStringBuilder.append("\"");
    if (paramoj.b() != null)
    {
      localStringBuilder.append("; filename=\"");
      localStringBuilder.append(paramoj.b());
      localStringBuilder.append("\"");
    }
    a("Content-Disposition", localStringBuilder.toString());
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("Field name may not be null");
    }
    this.b.a(new og(paramString1, paramString2));
  }
  
  public oj b()
  {
    return this.c;
  }
  
  protected void b(oj paramoj)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramoj.a());
    if (paramoj.c() != null)
    {
      localStringBuilder.append("; charset=");
      localStringBuilder.append(paramoj.c());
    }
    a("Content-Type", localStringBuilder.toString());
  }
  
  public ob c()
  {
    return this.b;
  }
  
  protected void c(oj paramoj)
  {
    a("Content-Transfer-Encoding", paramoj.d());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/oa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */