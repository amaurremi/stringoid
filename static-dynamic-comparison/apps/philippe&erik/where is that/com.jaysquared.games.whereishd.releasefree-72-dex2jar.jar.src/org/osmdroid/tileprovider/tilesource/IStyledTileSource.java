package org.osmdroid.tileprovider.tilesource;

public abstract interface IStyledTileSource<T>
{
  public abstract T getStyle();
  
  public abstract void setStyle(T paramT);
  
  public abstract void setStyle(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/tilesource/IStyledTileSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */