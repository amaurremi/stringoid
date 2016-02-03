package com.pocket.user;

@Deprecated
public class b
  extends a
{
  private String b;
  
  public b(String paramString1, String paramString2, UserMeta paramUserMeta)
  {
    super(paramString1, paramUserMeta);
    this.b = paramString2;
  }
  
  public boolean g()
  {
    return (super.g()) && (this.b != null);
  }
  
  public String k()
  {
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/user/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */