package com.adfonic.android.ormma;

public abstract interface OrmmaView
{
  public abstract void expand(String paramString);
  
  public abstract int getDefaultHeight();
  
  public abstract int getDefaultWidth();
  
  public abstract int getDefaultX();
  
  public abstract int getDefaultY();
  
  public abstract ExpandProperties getExpandProperties();
  
  public abstract int getHeight();
  
  public abstract int getMaxHeight();
  
  public abstract int getMaxWidth();
  
  public abstract String getPlacementType();
  
  public abstract int getWidth();
  
  public abstract void hide();
  
  public abstract void injectJavaScript(String paramString);
  
  public abstract boolean isViewable();
  
  public abstract void open(String paramString);
  
  public abstract void resize(int paramInt1, int paramInt2);
  
  public abstract void setExpandProperties(ExpandProperties paramExpandProperties);
  
  public abstract void showDefaultSize();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adfonic/android/ormma/OrmmaView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */