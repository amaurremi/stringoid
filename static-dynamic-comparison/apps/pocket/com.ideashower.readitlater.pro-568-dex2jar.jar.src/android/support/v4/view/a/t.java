package android.support.v4.view.a;

import android.os.Build.VERSION;

public class t
{
  private static final w a = new y();
  private final Object b;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      a = new x();
      return;
    }
    if (Build.VERSION.SDK_INT >= 15)
    {
      a = new v();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      a = new u();
      return;
    }
  }
  
  public t(Object paramObject)
  {
    this.b = paramObject;
  }
  
  public static t a()
  {
    return new t(a.a());
  }
  
  public void a(int paramInt)
  {
    a.b(this.b, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    a.a(this.b, paramBoolean);
  }
  
  public void b(int paramInt)
  {
    a.a(this.b, paramInt);
  }
  
  public void c(int paramInt)
  {
    a.c(this.b, paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (t)paramObject;
        if (this.b != null) {
          break;
        }
      } while (((t)paramObject).b == null);
      return false;
    } while (this.b.equals(((t)paramObject).b));
    return false;
  }
  
  public int hashCode()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.hashCode();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/view/a/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */