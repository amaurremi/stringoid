package org.osmdroid.tileprovider.modules;

public abstract interface INetworkAvailablityCheck
{
  public abstract boolean getCellularDataNetworkAvailable();
  
  public abstract boolean getNetworkAvailable();
  
  public abstract boolean getRouteToPathExists(int paramInt);
  
  public abstract boolean getWiFiNetworkAvailable();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/modules/INetworkAvailablityCheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */