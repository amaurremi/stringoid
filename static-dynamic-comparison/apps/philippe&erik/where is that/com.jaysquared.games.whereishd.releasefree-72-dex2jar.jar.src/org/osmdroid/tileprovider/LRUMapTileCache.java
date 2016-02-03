package org.osmdroid.tileprovider;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import org.osmdroid.tileprovider.constants.OpenStreetMapTileProviderConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LRUMapTileCache
  extends LinkedHashMap<MapTile, Drawable>
  implements OpenStreetMapTileProviderConstants
{
  private static final Logger logger = LoggerFactory.getLogger(LRUMapTileCache.class);
  private static final long serialVersionUID = -541142277575493335L;
  private int mCapacity;
  private TileRemovedListener mTileRemovedListener;
  
  public LRUMapTileCache(int paramInt)
  {
    super(paramInt + 2, 0.1F, true);
    this.mCapacity = paramInt;
  }
  
  public void clear()
  {
    while (!isEmpty()) {
      remove(keySet().iterator().next());
    }
    super.clear();
  }
  
  public void ensureCapacity(int paramInt)
  {
    if (paramInt > this.mCapacity)
    {
      logger.info("Tile cache increased from " + this.mCapacity + " to " + paramInt);
      this.mCapacity = paramInt;
    }
  }
  
  public TileRemovedListener getTileRemovedListener()
  {
    return this.mTileRemovedListener;
  }
  
  public Drawable remove(Object paramObject)
  {
    Drawable localDrawable = (Drawable)super.remove(paramObject);
    if ((Build.VERSION.SDK_INT < 9) && ((localDrawable instanceof BitmapDrawable)))
    {
      Bitmap localBitmap = ((BitmapDrawable)localDrawable).getBitmap();
      if (localBitmap != null) {
        localBitmap.recycle();
      }
    }
    if ((getTileRemovedListener() != null) && ((paramObject instanceof MapTile))) {
      getTileRemovedListener().onTileRemoved((MapTile)paramObject);
    }
    if ((localDrawable instanceof ReusableBitmapDrawable)) {
      BitmapPool.getInstance().returnDrawableToPool((ReusableBitmapDrawable)localDrawable);
    }
    return localDrawable;
  }
  
  protected boolean removeEldestEntry(Map.Entry<MapTile, Drawable> paramEntry)
  {
    if (size() > this.mCapacity) {
      remove((MapTile)paramEntry.getKey());
    }
    return false;
  }
  
  public void setTileRemovedListener(TileRemovedListener paramTileRemovedListener)
  {
    this.mTileRemovedListener = paramTileRemovedListener;
  }
  
  public static abstract interface TileRemovedListener
  {
    public abstract void onTileRemoved(MapTile paramMapTile);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/LRUMapTileCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */