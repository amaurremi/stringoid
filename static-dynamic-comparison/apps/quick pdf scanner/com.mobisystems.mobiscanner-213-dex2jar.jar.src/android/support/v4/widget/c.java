package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

public class c
{
  private static final c dJ = new a();
  private Object dI;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      dJ = new b();
      return;
    }
  }
  
  public c(Context paramContext)
  {
    this.dI = dJ.c(paramContext);
  }
  
  public boolean ad()
  {
    return dJ.A(this.dI);
  }
  
  public boolean d(float paramFloat)
  {
    return dJ.a(this.dI, paramFloat);
  }
  
  public boolean draw(Canvas paramCanvas)
  {
    return dJ.a(this.dI, paramCanvas);
  }
  
  public void finish()
  {
    dJ.z(this.dI);
  }
  
  public boolean isFinished()
  {
    return dJ.y(this.dI);
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    dJ.a(this.dI, paramInt1, paramInt2);
  }
  
  static class a
    implements c.c
  {
    public boolean A(Object paramObject)
    {
      return false;
    }
    
    public void a(Object paramObject, int paramInt1, int paramInt2) {}
    
    public boolean a(Object paramObject, float paramFloat)
    {
      return false;
    }
    
    public boolean a(Object paramObject, Canvas paramCanvas)
    {
      return false;
    }
    
    public Object c(Context paramContext)
    {
      return null;
    }
    
    public boolean y(Object paramObject)
    {
      return true;
    }
    
    public void z(Object paramObject) {}
  }
  
  static class b
    implements c.c
  {
    public boolean A(Object paramObject)
    {
      return d.A(paramObject);
    }
    
    public void a(Object paramObject, int paramInt1, int paramInt2)
    {
      d.a(paramObject, paramInt1, paramInt2);
    }
    
    public boolean a(Object paramObject, float paramFloat)
    {
      return d.a(paramObject, paramFloat);
    }
    
    public boolean a(Object paramObject, Canvas paramCanvas)
    {
      return d.a(paramObject, paramCanvas);
    }
    
    public Object c(Context paramContext)
    {
      return d.c(paramContext);
    }
    
    public boolean y(Object paramObject)
    {
      return d.y(paramObject);
    }
    
    public void z(Object paramObject)
    {
      d.z(paramObject);
    }
  }
  
  static abstract interface c
  {
    public abstract boolean A(Object paramObject);
    
    public abstract void a(Object paramObject, int paramInt1, int paramInt2);
    
    public abstract boolean a(Object paramObject, float paramFloat);
    
    public abstract boolean a(Object paramObject, Canvas paramCanvas);
    
    public abstract Object c(Context paramContext);
    
    public abstract boolean y(Object paramObject);
    
    public abstract void z(Object paramObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/widget/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */