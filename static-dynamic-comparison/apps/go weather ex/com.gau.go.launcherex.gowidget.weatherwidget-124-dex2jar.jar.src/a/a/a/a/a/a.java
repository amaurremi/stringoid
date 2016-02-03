package a.a.a.a.a;

public class a
{
  private final String a;
  private final b b;
  private final a.a.a.a.a.a.b c;
  
  public a(String paramString, a.a.a.a.a.a.b paramb)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Name may not be null");
    }
    if (paramb == null) {
      throw new IllegalArgumentException("Body may not be null");
    }
    this.a = paramString;
    this.c = paramb;
    this.b = new b();
    a(paramb);
    b(paramb);
    c(paramb);
  }
  
  public String a()
  {
    return this.a;
  }
  
  protected void a(a.a.a.a.a.a.b paramb)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("form-data; name=\"");
    localStringBuilder.append(a());
    localStringBuilder.append("\"");
    if (paramb.b() != null)
    {
      localStringBuilder.append("; filename=\"");
      localStringBuilder.append(paramb.b());
      localStringBuilder.append("\"");
    }
    a("Content-Disposition", localStringBuilder.toString());
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("Field name may not be null");
    }
    this.b.a(new g(paramString1, paramString2));
  }
  
  public a.a.a.a.a.a.b b()
  {
    return this.c;
  }
  
  protected void b(a.a.a.a.a.a.b paramb)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramb.a());
    if (paramb.c() != null)
    {
      localStringBuilder.append("; charset=");
      localStringBuilder.append(paramb.c());
    }
    a("Content-Type", localStringBuilder.toString());
  }
  
  public b c()
  {
    return this.b;
  }
  
  protected void c(a.a.a.a.a.a.b paramb)
  {
    a("Content-Transfer-Encoding", paramb.d());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/a/a/a/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */