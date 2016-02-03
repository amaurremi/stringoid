package com.bluebird.mobile.tools.font;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import java.util.Hashtable;

public class FontLoader
{
  private static final String TAG = "Typefaces";
  private static final Hashtable<String, Typeface> cache = new Hashtable();
  
  public static Typeface get(Context paramContext, String paramString)
  {
    synchronized (cache)
    {
      boolean bool = cache.containsKey(paramString);
      if (!bool) {}
      try
      {
        paramContext = Typeface.createFromAsset(paramContext.getAssets(), paramString);
        cache.put(paramString, paramContext);
        paramContext = (Typeface)cache.get(paramString);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        Log.e("Typefaces", "Could not get typeface '" + paramString + "' because " + paramContext.getMessage());
        return null;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/font/FontLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */