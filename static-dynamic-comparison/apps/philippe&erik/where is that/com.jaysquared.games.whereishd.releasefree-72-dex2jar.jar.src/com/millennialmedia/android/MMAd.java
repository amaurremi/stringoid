package com.millennialmedia.android;

public abstract interface MMAd
{
  public abstract String getApid();
  
  public abstract boolean getIgnoresDensityScaling();
  
  public abstract RequestListener getListener();
  
  public abstract MMRequest getMMRequest();
  
  public abstract void setApid(String paramString);
  
  public abstract void setIgnoresDensityScaling(boolean paramBoolean);
  
  public abstract void setListener(RequestListener paramRequestListener);
  
  public abstract void setMMRequest(MMRequest paramMMRequest);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/millennialmedia/android/MMAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */