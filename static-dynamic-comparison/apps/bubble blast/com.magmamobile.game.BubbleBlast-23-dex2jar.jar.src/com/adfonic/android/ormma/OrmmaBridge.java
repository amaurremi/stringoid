package com.adfonic.android.ormma;

public abstract interface OrmmaBridge
{
  public abstract void error(String paramString1, String paramString2);
  
  public abstract void onKeyboardChange(boolean paramBoolean);
  
  public abstract void onSizeChange(int paramInt1, int paramInt2);
  
  public abstract void ready();
  
  public abstract void reset();
  
  public abstract void viewableChange(boolean paramBoolean);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adfonic/android/ormma/OrmmaBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */