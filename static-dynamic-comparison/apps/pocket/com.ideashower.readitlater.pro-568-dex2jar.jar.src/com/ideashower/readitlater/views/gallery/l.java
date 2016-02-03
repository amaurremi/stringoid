package com.ideashower.readitlater.views.gallery;

import android.view.MotionEvent;

public class l
{
  protected MotionEvent a;
  
  protected l(MotionEvent paramMotionEvent)
  {
    this.a = paramMotionEvent;
  }
  
  public static l a(MotionEvent paramMotionEvent)
  {
    try
    {
      b localb = new b(paramMotionEvent);
      return localb;
    }
    catch (VerifyError localVerifyError) {}
    return new l(paramMotionEvent);
  }
  
  private void c(int paramInt)
  {
    if (paramInt > 0) {
      throw new IllegalArgumentException("Invalid pointer index for Donut/Cupcake");
    }
  }
  
  public float a(int paramInt)
  {
    c(paramInt);
    return b();
  }
  
  public int a()
  {
    return this.a.getAction();
  }
  
  public float b()
  {
    return this.a.getX();
  }
  
  public float b(int paramInt)
  {
    c(paramInt);
    return c();
  }
  
  public float c()
  {
    return this.a.getY();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/gallery/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */