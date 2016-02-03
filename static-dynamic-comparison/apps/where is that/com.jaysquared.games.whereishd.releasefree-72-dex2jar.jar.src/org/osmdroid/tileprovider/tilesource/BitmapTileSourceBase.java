package org.osmdroid.tileprovider.tilesource;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import java.io.File;
import java.io.InputStream;
import java.util.Random;
import org.osmdroid.ResourceProxy;
import org.osmdroid.ResourceProxy.string;
import org.osmdroid.tileprovider.BitmapPool;
import org.osmdroid.tileprovider.MapTile;
import org.osmdroid.tileprovider.ReusableBitmapDrawable;
import org.osmdroid.tileprovider.constants.OpenStreetMapTileProviderConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BitmapTileSourceBase
  implements ITileSource, OpenStreetMapTileProviderConstants
{
  private static int globalOrdinal = 0;
  private static final Logger logger = LoggerFactory.getLogger(BitmapTileSourceBase.class);
  protected final String mImageFilenameEnding;
  private final int mMaximumZoomLevel;
  private final int mMinimumZoomLevel;
  protected final String mName;
  private final int mOrdinal;
  private final ResourceProxy.string mResourceId;
  private final int mTileSizePixels;
  protected final Random random = new Random();
  
  public BitmapTileSourceBase(String paramString1, ResourceProxy.string paramstring, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    this.mResourceId = paramstring;
    int i = globalOrdinal;
    globalOrdinal = i + 1;
    this.mOrdinal = i;
    this.mName = paramString1;
    this.mMinimumZoomLevel = paramInt1;
    this.mMaximumZoomLevel = paramInt2;
    this.mTileSizePixels = paramInt3;
    this.mImageFilenameEnding = paramString2;
  }
  
  public Drawable getDrawable(InputStream paramInputStream)
    throws BitmapTileSourceBase.LowMemoryException
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = new BitmapFactory.Options();
      BitmapPool.getInstance().applyReusableOptions((BitmapFactory.Options)localObject2);
      localObject2 = BitmapFactory.decodeStream(paramInputStream, null, (BitmapFactory.Options)localObject2);
      paramInputStream = (InputStream)localObject1;
      if (localObject2 != null) {
        paramInputStream = new ReusableBitmapDrawable((Bitmap)localObject2);
      }
      return paramInputStream;
    }
    catch (OutOfMemoryError paramInputStream)
    {
      logger.error("OutOfMemoryError loading bitmap");
      System.gc();
      throw new LowMemoryException(paramInputStream);
    }
  }
  
  public Drawable getDrawable(String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject = new BitmapFactory.Options();
        BitmapPool.getInstance().applyReusableOptions((BitmapFactory.Options)localObject);
        localObject = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        if (localObject != null)
        {
          localObject = new ReusableBitmapDrawable((Bitmap)localObject);
          return (Drawable)localObject;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        logger.error("OutOfMemoryError loading bitmap: " + paramString);
        System.gc();
        continue;
      }
      try
      {
        new File(paramString).delete();
        return null;
      }
      catch (Throwable localThrowable)
      {
        logger.error("Error deleting invalid file: " + paramString, localThrowable);
      }
    }
  }
  
  public int getMaximumZoomLevel()
  {
    return this.mMaximumZoomLevel;
  }
  
  public int getMinimumZoomLevel()
  {
    return this.mMinimumZoomLevel;
  }
  
  public String getTileRelativeFilenameString(MapTile paramMapTile)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(pathBase());
    localStringBuilder.append('/');
    localStringBuilder.append(paramMapTile.getZoomLevel());
    localStringBuilder.append('/');
    localStringBuilder.append(paramMapTile.getX());
    localStringBuilder.append('/');
    localStringBuilder.append(paramMapTile.getY());
    localStringBuilder.append(imageFilenameEnding());
    return localStringBuilder.toString();
  }
  
  public int getTileSizePixels()
  {
    return this.mTileSizePixels;
  }
  
  public String imageFilenameEnding()
  {
    return this.mImageFilenameEnding;
  }
  
  public String localizedName(ResourceProxy paramResourceProxy)
  {
    return paramResourceProxy.getString(this.mResourceId);
  }
  
  public String name()
  {
    return this.mName;
  }
  
  public int ordinal()
  {
    return this.mOrdinal;
  }
  
  public String pathBase()
  {
    return this.mName;
  }
  
  public final class LowMemoryException
    extends Exception
  {
    private static final long serialVersionUID = 146526524087765134L;
    
    public LowMemoryException(String paramString)
    {
      super();
    }
    
    public LowMemoryException(Throwable paramThrowable)
    {
      super();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/tilesource/BitmapTileSourceBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */