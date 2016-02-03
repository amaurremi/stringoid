package com.google.tagmanager;

abstract class ServiceManager
{
  abstract void dispatch();
  
  abstract void onRadioPowered();
  
  abstract void setDispatchPeriod(int paramInt);
  
  abstract void updateConnectivityStatus(boolean paramBoolean);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/ServiceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */