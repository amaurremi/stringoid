package com.ideashower.readitlater.db.operation;

public abstract class b
  extends j
{
  private Throwable e;
  
  protected void b(boolean paramBoolean, Throwable paramThrowable)
  {
    super.b(paramBoolean, paramThrowable);
    this.e = paramThrowable;
  }
  
  public int d()
  {
    int i = super.d();
    if (this.e != null) {
      throw new RuntimeException("processing crashed", this.e);
    }
    return i;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */