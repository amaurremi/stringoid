package com.c.a;

import android.view.View;

public final class a
{
  public static float ag(View paramView)
  {
    if (com.c.a.a.a.NEEDS_PROXY) {
      return com.c.a.a.a.ao(paramView).getAlpha();
    }
    return a.ag(paramView);
  }
  
  public static float ah(View paramView)
  {
    if (com.c.a.a.a.NEEDS_PROXY) {
      return com.c.a.a.a.ao(paramView).getRotation();
    }
    return a.ah(paramView);
  }
  
  public static float ai(View paramView)
  {
    if (com.c.a.a.a.NEEDS_PROXY) {
      return com.c.a.a.a.ao(paramView).getRotationX();
    }
    return a.ai(paramView);
  }
  
  public static float aj(View paramView)
  {
    if (com.c.a.a.a.NEEDS_PROXY) {
      return com.c.a.a.a.ao(paramView).getRotationY();
    }
    return a.aj(paramView);
  }
  
  public static float ak(View paramView)
  {
    if (com.c.a.a.a.NEEDS_PROXY) {
      return com.c.a.a.a.ao(paramView).getScaleX();
    }
    return a.ak(paramView);
  }
  
  public static float al(View paramView)
  {
    if (com.c.a.a.a.NEEDS_PROXY) {
      return com.c.a.a.a.ao(paramView).getScaleY();
    }
    return a.al(paramView);
  }
  
  public static float am(View paramView)
  {
    if (com.c.a.a.a.NEEDS_PROXY) {
      return com.c.a.a.a.ao(paramView).getTranslationX();
    }
    return a.am(paramView);
  }
  
  public static float an(View paramView)
  {
    if (com.c.a.a.a.NEEDS_PROXY) {
      return com.c.a.a.a.ao(paramView).getTranslationY();
    }
    return a.an(paramView);
  }
  
  public static void f(View paramView, float paramFloat)
  {
    if (com.c.a.a.a.NEEDS_PROXY)
    {
      com.c.a.a.a.ao(paramView).setAlpha(paramFloat);
      return;
    }
    a.f(paramView, paramFloat);
  }
  
  public static void g(View paramView, float paramFloat)
  {
    if (com.c.a.a.a.NEEDS_PROXY)
    {
      com.c.a.a.a.ao(paramView).setPivotX(paramFloat);
      return;
    }
    a.g(paramView, paramFloat);
  }
  
  public static void h(View paramView, float paramFloat)
  {
    if (com.c.a.a.a.NEEDS_PROXY)
    {
      com.c.a.a.a.ao(paramView).setPivotY(paramFloat);
      return;
    }
    a.h(paramView, paramFloat);
  }
  
  public static void i(View paramView, float paramFloat)
  {
    if (com.c.a.a.a.NEEDS_PROXY)
    {
      com.c.a.a.a.ao(paramView).setRotation(paramFloat);
      return;
    }
    a.i(paramView, paramFloat);
  }
  
  public static void j(View paramView, float paramFloat)
  {
    if (com.c.a.a.a.NEEDS_PROXY)
    {
      com.c.a.a.a.ao(paramView).setRotationX(paramFloat);
      return;
    }
    a.j(paramView, paramFloat);
  }
  
  public static void k(View paramView, float paramFloat)
  {
    if (com.c.a.a.a.NEEDS_PROXY)
    {
      com.c.a.a.a.ao(paramView).setRotationY(paramFloat);
      return;
    }
    a.k(paramView, paramFloat);
  }
  
  public static void l(View paramView, float paramFloat)
  {
    if (com.c.a.a.a.NEEDS_PROXY)
    {
      com.c.a.a.a.ao(paramView).setScaleX(paramFloat);
      return;
    }
    a.l(paramView, paramFloat);
  }
  
  public static void m(View paramView, float paramFloat)
  {
    if (com.c.a.a.a.NEEDS_PROXY)
    {
      com.c.a.a.a.ao(paramView).setScaleY(paramFloat);
      return;
    }
    a.m(paramView, paramFloat);
  }
  
  public static void n(View paramView, float paramFloat)
  {
    if (com.c.a.a.a.NEEDS_PROXY)
    {
      com.c.a.a.a.ao(paramView).setTranslationX(paramFloat);
      return;
    }
    a.n(paramView, paramFloat);
  }
  
  public static void o(View paramView, float paramFloat)
  {
    if (com.c.a.a.a.NEEDS_PROXY)
    {
      com.c.a.a.a.ao(paramView).setTranslationY(paramFloat);
      return;
    }
    a.o(paramView, paramFloat);
  }
  
  private static final class a
  {
    static float ag(View paramView)
    {
      return paramView.getAlpha();
    }
    
    static float ah(View paramView)
    {
      return paramView.getRotation();
    }
    
    static float ai(View paramView)
    {
      return paramView.getRotationX();
    }
    
    static float aj(View paramView)
    {
      return paramView.getRotationY();
    }
    
    static float ak(View paramView)
    {
      return paramView.getScaleX();
    }
    
    static float al(View paramView)
    {
      return paramView.getScaleY();
    }
    
    static float am(View paramView)
    {
      return paramView.getTranslationX();
    }
    
    static float an(View paramView)
    {
      return paramView.getTranslationY();
    }
    
    static void f(View paramView, float paramFloat)
    {
      paramView.setAlpha(paramFloat);
    }
    
    static void g(View paramView, float paramFloat)
    {
      paramView.setPivotX(paramFloat);
    }
    
    static void h(View paramView, float paramFloat)
    {
      paramView.setPivotY(paramFloat);
    }
    
    static void i(View paramView, float paramFloat)
    {
      paramView.setRotation(paramFloat);
    }
    
    static void j(View paramView, float paramFloat)
    {
      paramView.setRotationX(paramFloat);
    }
    
    static void k(View paramView, float paramFloat)
    {
      paramView.setRotationY(paramFloat);
    }
    
    static void l(View paramView, float paramFloat)
    {
      paramView.setScaleX(paramFloat);
    }
    
    static void m(View paramView, float paramFloat)
    {
      paramView.setScaleY(paramFloat);
    }
    
    static void n(View paramView, float paramFloat)
    {
      paramView.setTranslationX(paramFloat);
    }
    
    static void o(View paramView, float paramFloat)
    {
      paramView.setTranslationY(paramFloat);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/c/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */