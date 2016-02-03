package com.vungle.publisher;

import android.view.animation.Interpolator;

public abstract class g
  implements Cloneable
{
  float a;
  Class b;
  Interpolator c = null;
  boolean d = false;
  
  public static g a(float paramFloat1, float paramFloat2)
  {
    return new a(paramFloat1, paramFloat2);
  }
  
  public static g a(float paramFloat, int paramInt)
  {
    return new b(paramFloat, paramInt);
  }
  
  public abstract Object a();
  
  public abstract void a(Object paramObject);
  
  public abstract g b();
  
  static final class a
    extends g
  {
    float e;
    
    a()
    {
      this.a = 0.0F;
      this.b = Float.TYPE;
    }
    
    a(float paramFloat1, float paramFloat2)
    {
      this.a = paramFloat1;
      this.e = paramFloat2;
      this.b = Float.TYPE;
      this.d = true;
    }
    
    private a c()
    {
      a locala = new a(this.a, this.e);
      locala.c = this.c;
      return locala;
    }
    
    public final Object a()
    {
      return Float.valueOf(this.e);
    }
    
    public final void a(Object paramObject)
    {
      if ((paramObject != null) && (paramObject.getClass() == Float.class))
      {
        this.e = ((Float)paramObject).floatValue();
        this.d = true;
      }
    }
  }
  
  static final class b
    extends g
  {
    int e;
    
    b()
    {
      this.a = 0.0F;
      this.b = Integer.TYPE;
    }
    
    b(float paramFloat, int paramInt)
    {
      this.a = paramFloat;
      this.e = paramInt;
      this.b = Integer.TYPE;
      this.d = true;
    }
    
    private b c()
    {
      b localb = new b(this.a, this.e);
      localb.c = this.c;
      return localb;
    }
    
    public final Object a()
    {
      return Integer.valueOf(this.e);
    }
    
    public final void a(Object paramObject)
    {
      if ((paramObject != null) && (paramObject.getClass() == Integer.class))
      {
        this.e = ((Integer)paramObject).intValue();
        this.d = true;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */