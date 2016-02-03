package com.pocket.widget;

public abstract class as
  implements av
{
  private ValidatedEditText a;
  private int b;
  private int c;
  private final at d = new at()
  {
    public boolean a(aw paramAnonymousaw)
    {
      if (as.b(as.this) != as.c(as.this)) {
        return false;
      }
      as.d(as.this).setValidity(paramAnonymousaw);
      return true;
    }
  };
  
  private void a()
  {
    this.b += 1;
  }
  
  public aw a(ValidatedEditText paramValidatedEditText, String paramString, boolean paramBoolean)
  {
    int i = this.b + 1;
    this.b = i;
    this.c = i;
    a(paramValidatedEditText, paramString, this.d);
    return aw.c;
  }
  
  public abstract void a(ValidatedEditText paramValidatedEditText, String paramString, at paramat);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */