package org.osmdroid;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import org.osmdroid.views.util.constants.MapViewConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultResourceProxyImpl
  implements ResourceProxy, MapViewConstants
{
  private static final Logger logger = LoggerFactory.getLogger(DefaultResourceProxyImpl.class);
  private DisplayMetrics mDisplayMetrics;
  private Resources mResources;
  
  public DefaultResourceProxyImpl(Context paramContext)
  {
    if (paramContext != null)
    {
      this.mResources = paramContext.getResources();
      this.mDisplayMetrics = this.mResources.getDisplayMetrics();
    }
  }
  
  private BitmapFactory.Options getBitmapOptions()
  {
    try
    {
      Field localField1 = DisplayMetrics.class.getDeclaredField("DENSITY_DEFAULT");
      Field localField2 = BitmapFactory.Options.class.getDeclaredField("inDensity");
      Field localField3 = BitmapFactory.Options.class.getDeclaredField("inTargetDensity");
      Field localField4 = DisplayMetrics.class.getDeclaredField("densityDpi");
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localField2.setInt(localOptions, localField1.getInt(null));
      localField3.setInt(localOptions, localField4.getInt(this.mDisplayMetrics));
      return localOptions;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      return null;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;) {}
    }
  }
  
  public Bitmap getBitmap(ResourceProxy.bitmap parambitmap)
  {
    Object localObject3 = null;
    InputStream localInputStream = null;
    Object localObject2 = localInputStream;
    Object localObject1 = localObject3;
    try
    {
      String str = parambitmap.name() + ".png";
      localObject2 = localInputStream;
      localObject1 = localObject3;
      localInputStream = ResourceProxy.class.getResourceAsStream(str);
      if (localInputStream == null)
      {
        localObject2 = localInputStream;
        localObject1 = localInputStream;
        throw new IllegalArgumentException("Resource not found: " + str);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localObject1 = localObject2;
      logger.error("OutOfMemoryError getting bitmap resource: " + parambitmap);
      localObject1 = localObject2;
      System.gc();
      localObject1 = localObject2;
      throw localOutOfMemoryError;
    }
    finally
    {
      if (localObject1 == null) {}
    }
    try
    {
      ((InputStream)localObject1).close();
      throw parambitmap;
      localObject3 = null;
      localObject2 = localOutOfMemoryError;
      localObject1 = localOutOfMemoryError;
      if (this.mDisplayMetrics != null)
      {
        localObject2 = localOutOfMemoryError;
        localObject1 = localOutOfMemoryError;
        localObject3 = getBitmapOptions();
      }
      localObject2 = localOutOfMemoryError;
      localObject1 = localOutOfMemoryError;
      localObject3 = BitmapFactory.decodeStream(localOutOfMemoryError, null, (BitmapFactory.Options)localObject3);
      if (localOutOfMemoryError != null) {}
      try
      {
        localOutOfMemoryError.close();
        return (Bitmap)localObject3;
      }
      catch (IOException parambitmap)
      {
        return (Bitmap)localObject3;
      }
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  public float getDisplayMetricsDensity()
  {
    return this.mDisplayMetrics.density;
  }
  
  public Drawable getDrawable(ResourceProxy.bitmap parambitmap)
  {
    if (this.mResources != null) {
      return new BitmapDrawable(this.mResources, getBitmap(parambitmap));
    }
    return new BitmapDrawable(getBitmap(parambitmap));
  }
  
  public String getString(ResourceProxy.string paramstring)
  {
    switch (paramstring)
    {
    default: 
      throw new IllegalArgumentException();
    case ???: 
      return "Mapnik";
    case ???: 
      return "Cycle Map";
    case ???: 
      return "Public transport";
    case ???: 
      return "OSM base layer";
    case ???: 
      return "Topographic";
    case ???: 
      return "Hills";
    case ???: 
      return "CloudMade (Standard tiles)";
    case ???: 
      return "CloudMade (small tiles)";
    case ???: 
      return "Mapquest";
    case ???: 
      return "Mapquest Aerial";
    case ???: 
      return "Bing";
    case ???: 
      return "MapBox";
    case ???: 
      return "OpenFietsKaart overlay";
    case ???: 
      return "Netherlands base overlay";
    case ???: 
      return "Netherlands roads overlay";
    case ???: 
      return "Unknown";
    case ???: 
      return "%s m";
    case ???: 
      return "%s km";
    case ???: 
      return "%s mi";
    case ???: 
      return "%s nm";
    case ???: 
      return "%s ft";
    case ???: 
      return "Online mode";
    case ???: 
      return "Offline mode";
    case ???: 
      return "My location";
    case ???: 
      return "Compass";
    }
    return "Map mode";
  }
  
  public String getString(ResourceProxy.string paramstring, Object... paramVarArgs)
  {
    return String.format(getString(paramstring), paramVarArgs);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/DefaultResourceProxyImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */