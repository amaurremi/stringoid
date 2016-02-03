package com.pocket.list.adapter.data;

public class n
{
  public static final ItemQuery.ReadOnlyItemQuery a = k.a().c();
  private final ItemQuery b;
  
  public n(ItemQuery paramItemQuery)
  {
    this.b = paramItemQuery;
  }
  
  private l f(boolean paramBoolean)
  {
    l locall = this.b.a().a(a);
    if (paramBoolean) {
      locall.b(false).a(Integer.valueOf(1));
    }
    return locall;
  }
  
  public void a()
  {
    f(true).a();
  }
  
  public void a(int paramInt)
  {
    f(false).b(paramInt).a();
  }
  
  public void a(String paramString)
  {
    f(false).c(paramString).a();
  }
  
  public void a(boolean paramBoolean)
  {
    f(false).a();
  }
  
  public void b()
  {
    f(false).b(false).a(null).a(Boolean.valueOf(true)).a();
  }
  
  public void b(boolean paramBoolean)
  {
    f(paramBoolean).e(Integer.valueOf(1)).a();
  }
  
  public void c()
  {
    f(false).c("_untagged_").a();
  }
  
  public void c(boolean paramBoolean)
  {
    f(paramBoolean).e(Integer.valueOf(3)).a();
  }
  
  public void d()
  {
    this.b.a().a(Integer.valueOf(1)).b(false).a();
  }
  
  public void d(boolean paramBoolean)
  {
    f(paramBoolean).e(Integer.valueOf(2)).a();
  }
  
  public void e()
  {
    this.b.a().a(Integer.valueOf(0)).b().a();
  }
  
  public void e(boolean paramBoolean)
  {
    f(paramBoolean).b(Integer.valueOf(1)).a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/adapter/data/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */