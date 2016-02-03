package org.osmdroid.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import java.lang.reflect.Field;
import org.osmdroid.DefaultResourceProxyImpl;
import org.osmdroid.ResourceProxy.bitmap;
import org.osmdroid.ResourceProxy.string;

public class ResourceProxyImpl
  extends DefaultResourceProxyImpl
{
  private final String mResourceNameBase;
  private final Resources mResources;
  
  public ResourceProxyImpl(Context paramContext)
  {
    super(paramContext);
    this.mResources = paramContext.getResources();
    this.mResourceNameBase = (paramContext.getPackageName() + ".R$");
  }
  
  private int getId(String paramString1, String paramString2)
  {
    try
    {
      int i = Class.forName(this.mResourceNameBase + paramString1).getDeclaredField(paramString2).getInt(null);
      return i;
    }
    catch (Exception paramString1) {}
    return 0;
  }
  
  public Bitmap getBitmap(ResourceProxy.bitmap parambitmap)
  {
    int i = getId("drawable", parambitmap.name());
    if (i != 0) {
      return BitmapFactory.decodeResource(this.mResources, i);
    }
    return super.getBitmap(parambitmap);
  }
  
  public Drawable getDrawable(ResourceProxy.bitmap parambitmap)
  {
    int i = getId("drawable", parambitmap.name());
    if (i != 0) {
      return this.mResources.getDrawable(i);
    }
    return super.getDrawable(parambitmap);
  }
  
  public String getString(ResourceProxy.string paramstring)
  {
    int i = getId("string", paramstring.name());
    if (i != 0) {
      return this.mResources.getString(i);
    }
    return super.getString(paramstring);
  }
  
  public String getString(ResourceProxy.string paramstring, Object... paramVarArgs)
  {
    int i = getId("string", paramstring.name());
    if (i != 0) {
      return this.mResources.getString(i, paramVarArgs);
    }
    return super.getString(paramstring, paramVarArgs);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/util/ResourceProxyImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */