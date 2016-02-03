package android.support.v4.view.a;

import android.os.Build.VERSION;

public class h
{
  private static final c cW = new e();
  private final Object cX;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      cW = new d();
      return;
    }
    if (Build.VERSION.SDK_INT >= 15)
    {
      cW = new b();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      cW = new a();
      return;
    }
  }
  
  public h(Object paramObject)
  {
    this.cX = paramObject;
  }
  
  public static h R()
  {
    return new h(cW.S());
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
        paramObject = (h)paramObject;
        if (this.cX != null) {
          break;
        }
      } while (((h)paramObject).cX == null);
      return false;
    } while (this.cX.equals(((h)paramObject).cX));
    return false;
  }
  
  public int hashCode()
  {
    if (this.cX == null) {
      return 0;
    }
    return this.cX.hashCode();
  }
  
  public void setFromIndex(int paramInt)
  {
    cW.c(this.cX, paramInt);
  }
  
  public void setItemCount(int paramInt)
  {
    cW.d(this.cX, paramInt);
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    cW.f(this.cX, paramBoolean);
  }
  
  public void setToIndex(int paramInt)
  {
    cW.e(this.cX, paramInt);
  }
  
  static class a
    extends h.e
  {
    public Object S()
    {
      return i.S();
    }
    
    public void c(Object paramObject, int paramInt)
    {
      i.c(paramObject, paramInt);
    }
    
    public void d(Object paramObject, int paramInt)
    {
      i.d(paramObject, paramInt);
    }
    
    public void e(Object paramObject, int paramInt)
    {
      i.e(paramObject, paramInt);
    }
    
    public void f(Object paramObject, boolean paramBoolean)
    {
      i.f(paramObject, paramBoolean);
    }
  }
  
  static class b
    extends h.a
  {}
  
  static abstract interface c
  {
    public abstract Object S();
    
    public abstract void c(Object paramObject, int paramInt);
    
    public abstract void d(Object paramObject, int paramInt);
    
    public abstract void e(Object paramObject, int paramInt);
    
    public abstract void f(Object paramObject, boolean paramBoolean);
  }
  
  static class d
    extends h.b
  {}
  
  static class e
    implements h.c
  {
    public Object S()
    {
      return null;
    }
    
    public void c(Object paramObject, int paramInt) {}
    
    public void d(Object paramObject, int paramInt) {}
    
    public void e(Object paramObject, int paramInt) {}
    
    public void f(Object paramObject, boolean paramBoolean) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/view/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */