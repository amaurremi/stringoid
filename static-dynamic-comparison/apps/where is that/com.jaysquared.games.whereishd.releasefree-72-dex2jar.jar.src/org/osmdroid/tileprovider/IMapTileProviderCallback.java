package org.osmdroid.tileprovider;

import android.graphics.drawable.Drawable;

public abstract interface IMapTileProviderCallback
{
  public abstract void mapTileRequestCompleted(MapTileRequestState paramMapTileRequestState, Drawable paramDrawable);
  
  public abstract void mapTileRequestExpiredTile(MapTileRequestState paramMapTileRequestState, Drawable paramDrawable);
  
  public abstract void mapTileRequestFailed(MapTileRequestState paramMapTileRequestState);
  
  public abstract boolean useDataConnection();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/IMapTileProviderCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */