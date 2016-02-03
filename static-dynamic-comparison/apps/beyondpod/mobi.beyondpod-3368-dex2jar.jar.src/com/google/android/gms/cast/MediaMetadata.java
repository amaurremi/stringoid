package com.google.android.gms.cast;

import android.os.Bundle;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.internal.dp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaMetadata
{
  public static final String KEY_ALBUM_ARTIST = "com.google.android.gms.cast.metadata.ALBUM_ARTIST";
  public static final String KEY_ALBUM_TITLE = "com.google.android.gms.cast.metadata.ALBUM_TITLE";
  public static final String KEY_ARTIST = "com.google.android.gms.cast.metadata.ARTIST";
  public static final String KEY_BROADCAST_DATE = "com.google.android.gms.cast.metadata.BROADCAST_DATE";
  public static final String KEY_COMPOSER = "com.google.android.gms.cast.metadata.COMPOSER";
  public static final String KEY_CREATION_DATE = "com.google.android.gms.cast.metadata.CREATION_DATE";
  public static final String KEY_DISC_NUMBER = "com.google.android.gms.cast.metadata.DISC_NUMBER";
  public static final String KEY_EPISODE_NUMBER = "com.google.android.gms.cast.metadata.EPISODE_NUMBER";
  public static final String KEY_HEIGHT = "com.google.android.gms.cast.metadata.HEIGHT";
  public static final String KEY_LOCATION_LATITUDE = "com.google.android.gms.cast.metadata.LOCATION_LATITUDE";
  public static final String KEY_LOCATION_LONGITUDE = "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE";
  public static final String KEY_LOCATION_NAME = "com.google.android.gms.cast.metadata.LOCATION_NAME";
  public static final String KEY_RELEASE_DATE = "com.google.android.gms.cast.metadata.RELEASE_DATE";
  public static final String KEY_SEASON_NUMBER = "com.google.android.gms.cast.metadata.SEASON_NUMBER";
  public static final String KEY_SERIES_TITLE = "com.google.android.gms.cast.metadata.SERIES_TITLE";
  public static final String KEY_STUDIO = "com.google.android.gms.cast.metadata.STUDIO";
  public static final String KEY_SUBTITLE = "com.google.android.gms.cast.metadata.SUBTITLE";
  public static final String KEY_TITLE = "com.google.android.gms.cast.metadata.TITLE";
  public static final String KEY_TRACK_NUMBER = "com.google.android.gms.cast.metadata.TRACK_NUMBER";
  public static final String KEY_WIDTH = "com.google.android.gms.cast.metadata.WIDTH";
  public static final int MEDIA_TYPE_GENERIC = 0;
  public static final int MEDIA_TYPE_MOVIE = 1;
  public static final int MEDIA_TYPE_MUSIC_TRACK = 3;
  public static final int MEDIA_TYPE_PHOTO = 4;
  public static final int MEDIA_TYPE_TV_SHOW = 2;
  public static final int MEDIA_TYPE_USER = 100;
  private static final String[] kO = { null, "String", "int", "double", "ISO-8601 date String" };
  private static final a kP = new a().a("com.google.android.gms.cast.metadata.CREATION_DATE", "creationDateTime", 4).a("com.google.android.gms.cast.metadata.RELEASE_DATE", "releaseDate", 4).a("com.google.android.gms.cast.metadata.BROADCAST_DATE", "originalAirdate", 4).a("com.google.android.gms.cast.metadata.TITLE", "title", 1).a("com.google.android.gms.cast.metadata.SUBTITLE", "subtitle", 1).a("com.google.android.gms.cast.metadata.ARTIST", "artist", 1).a("com.google.android.gms.cast.metadata.ALBUM_ARTIST", "albumArtist", 1).a("com.google.android.gms.cast.metadata.ALBUM_TITLE", "albumName", 1).a("com.google.android.gms.cast.metadata.COMPOSER", "composer", 1).a("com.google.android.gms.cast.metadata.DISC_NUMBER", "discNumber", 2).a("com.google.android.gms.cast.metadata.TRACK_NUMBER", "trackNumber", 2).a("com.google.android.gms.cast.metadata.SEASON_NUMBER", "season", 2).a("com.google.android.gms.cast.metadata.EPISODE_NUMBER", "episode", 2).a("com.google.android.gms.cast.metadata.SERIES_TITLE", "seriesTitle", 1).a("com.google.android.gms.cast.metadata.STUDIO", "studio", 1).a("com.google.android.gms.cast.metadata.WIDTH", "width", 2).a("com.google.android.gms.cast.metadata.HEIGHT", "height", 2).a("com.google.android.gms.cast.metadata.LOCATION_NAME", "location", 1).a("com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "latitude", 3).a("com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "longitude", 3);
  private final Bundle kQ = new Bundle();
  private int kR;
  private final List<WebImage> ki = new ArrayList();
  
  public MediaMetadata()
  {
    this(0);
  }
  
  public MediaMetadata(int paramInt)
  {
    this.kR = paramInt;
  }
  
  private void a(String paramString, int paramInt)
    throws IllegalArgumentException
  {
    int i = kP.A(paramString);
    if ((i != paramInt) && (i != 0)) {
      throw new IllegalArgumentException("Value for " + paramString + " must be a " + kO[paramInt]);
    }
  }
  
  private void a(JSONObject paramJSONObject, String... paramVarArgs)
  {
    try
    {
      int j = paramVarArgs.length;
      int i = 0;
      String str;
      if (i < j)
      {
        str = paramVarArgs[i];
        if (!this.kQ.containsKey(str)) {}
      }
      else
      {
        switch (kP.A(str))
        {
        case 1: 
        case 4: 
          paramJSONObject.put(kP.y(str), this.kQ.getString(str));
          break;
        case 2: 
          paramJSONObject.put(kP.y(str), this.kQ.getInt(str));
          break;
        case 3: 
          paramJSONObject.put(kP.y(str), this.kQ.getDouble(str));
          break;
          paramVarArgs = this.kQ.keySet().iterator();
          while (paramVarArgs.hasNext())
          {
            str = (String)paramVarArgs.next();
            if (!str.startsWith("com.google."))
            {
              Object localObject = this.kQ.get(str);
              if ((localObject instanceof String)) {
                paramJSONObject.put(str, localObject);
              } else if ((localObject instanceof Integer)) {
                paramJSONObject.put(str, localObject);
              } else if ((localObject instanceof Double)) {
                paramJSONObject.put(str, localObject);
              }
            }
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
      }
      return;
    }
    catch (JSONException paramJSONObject) {}
  }
  
  private boolean a(Bundle paramBundle1, Bundle paramBundle2)
  {
    if (paramBundle1.size() != paramBundle2.size()) {
      return false;
    }
    Iterator localIterator = paramBundle1.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject1 = paramBundle1.get(str);
      Object localObject2 = paramBundle2.get(str);
      if (((localObject1 instanceof Bundle)) && ((localObject2 instanceof Bundle)) && (!a((Bundle)localObject1, (Bundle)localObject2))) {
        return false;
      }
      if (localObject1 == null)
      {
        if ((localObject2 != null) || (!paramBundle2.containsKey(str))) {
          return false;
        }
      }
      else if (!localObject1.equals(localObject2)) {
        return false;
      }
    }
    return true;
  }
  
  private void b(JSONObject paramJSONObject, String... paramVarArgs)
  {
    paramVarArgs = new HashSet(Arrays.asList(paramVarArgs));
    try
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        String str = kP.z((String)localObject);
        if (str != null)
        {
          boolean bool = paramVarArgs.contains(str);
          if (!bool) {}
        }
        else
        {
          try
          {
            localObject = paramJSONObject.get((String)localObject);
            if (localObject != null) {
              switch (kP.A(str))
              {
              case 1: 
                if ((localObject instanceof String)) {
                  this.kQ.putString(str, (String)localObject);
                }
                break;
              case 4: 
                if (((localObject instanceof String)) && (dp.G((String)localObject) != null)) {
                  this.kQ.putString(str, (String)localObject);
                }
                break;
              case 2: 
                if ((localObject instanceof Integer)) {
                  this.kQ.putInt(str, ((Integer)localObject).intValue());
                }
                break;
              case 3: 
                if ((localObject instanceof Double))
                {
                  this.kQ.putDouble(str, ((Double)localObject).doubleValue());
                  continue;
                  localObject = paramJSONObject.get((String)localObject);
                  if ((localObject instanceof String)) {
                    this.kQ.putString(str, (String)localObject);
                  } else if ((localObject instanceof Integer)) {
                    this.kQ.putInt(str, ((Integer)localObject).intValue());
                  } else if ((localObject instanceof Double)) {
                    this.kQ.putDouble(str, ((Double)localObject).doubleValue());
                  }
                }
                break;
              }
            }
          }
          catch (JSONException localJSONException) {}
        }
      }
      return;
    }
    catch (JSONException paramJSONObject) {}
  }
  
  public JSONObject aP()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("metadataType", this.kR);
      dp.a(localJSONObject, this.ki);
      switch (this.kR)
      {
      }
      for (;;)
      {
        a(localJSONObject, new String[0]);
        return localJSONObject;
        a(localJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE" });
        return localJSONObject;
        a(localJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.STUDIO", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE" });
        return localJSONObject;
        a(localJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.SERIES_TITLE", "com.google.android.gms.cast.metadata.SEASON_NUMBER", "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "com.google.android.gms.cast.metadata.BROADCAST_DATE" });
        return localJSONObject;
        a(localJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.ALBUM_TITLE", "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "com.google.android.gms.cast.metadata.COMPOSER", "com.google.android.gms.cast.metadata.TRACK_NUMBER", "com.google.android.gms.cast.metadata.DISC_NUMBER", "com.google.android.gms.cast.metadata.RELEASE_DATE" });
        return localJSONObject;
        a(localJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.LOCATION_NAME", "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "com.google.android.gms.cast.metadata.WIDTH", "com.google.android.gms.cast.metadata.HEIGHT", "com.google.android.gms.cast.metadata.CREATION_DATE" });
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
  }
  
  public void addImage(WebImage paramWebImage)
  {
    this.ki.add(paramWebImage);
  }
  
  public void b(JSONObject paramJSONObject)
  {
    clear();
    this.kR = 0;
    try
    {
      this.kR = paramJSONObject.getInt("metadataType");
      dp.a(this.ki, paramJSONObject);
      switch (this.kR)
      {
      }
      for (;;)
      {
        b(paramJSONObject, new String[0]);
        return;
        b(paramJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE" });
        return;
        b(paramJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.STUDIO", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE" });
        return;
        b(paramJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.SERIES_TITLE", "com.google.android.gms.cast.metadata.SEASON_NUMBER", "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "com.google.android.gms.cast.metadata.BROADCAST_DATE" });
        return;
        b(paramJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ALBUM_TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "com.google.android.gms.cast.metadata.COMPOSER", "com.google.android.gms.cast.metadata.TRACK_NUMBER", "com.google.android.gms.cast.metadata.DISC_NUMBER", "com.google.android.gms.cast.metadata.RELEASE_DATE" });
        return;
        b(paramJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.LOCATION_NAME", "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "com.google.android.gms.cast.metadata.WIDTH", "com.google.android.gms.cast.metadata.HEIGHT", "com.google.android.gms.cast.metadata.CREATION_DATE" });
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
  }
  
  public void clear()
  {
    this.kQ.clear();
    this.ki.clear();
  }
  
  public void clearImages()
  {
    this.ki.clear();
  }
  
  public boolean containsKey(String paramString)
  {
    return this.kQ.containsKey(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof MediaMetadata)) {
        return false;
      }
      paramObject = (MediaMetadata)paramObject;
    } while ((a(this.kQ, ((MediaMetadata)paramObject).kQ)) && (this.ki.equals(((MediaMetadata)paramObject).ki)));
    return false;
  }
  
  public Calendar getDate(String paramString)
  {
    a(paramString, 4);
    paramString = this.kQ.getString(paramString);
    if (paramString != null) {
      return dp.G(paramString);
    }
    return null;
  }
  
  public String getDateAsString(String paramString)
  {
    a(paramString, 4);
    return this.kQ.getString(paramString);
  }
  
  public double getDouble(String paramString)
  {
    a(paramString, 3);
    return this.kQ.getDouble(paramString);
  }
  
  public List<WebImage> getImages()
  {
    return this.ki;
  }
  
  public int getInt(String paramString)
  {
    a(paramString, 2);
    return this.kQ.getInt(paramString);
  }
  
  public int getMediaType()
  {
    return this.kR;
  }
  
  public String getString(String paramString)
  {
    a(paramString, 1);
    return this.kQ.getString(paramString);
  }
  
  public boolean hasImages()
  {
    return (this.ki != null) && (!this.ki.isEmpty());
  }
  
  public int hashCode()
  {
    Iterator localIterator = this.kQ.keySet().iterator();
    String str;
    for (int i = 17; localIterator.hasNext(); i = this.kQ.get(str).hashCode() + i * 31) {
      str = (String)localIterator.next();
    }
    return i * 31 + this.ki.hashCode();
  }
  
  public Set<String> keySet()
  {
    return this.kQ.keySet();
  }
  
  public void putDate(String paramString, Calendar paramCalendar)
  {
    a(paramString, 4);
    this.kQ.putString(paramString, dp.a(paramCalendar));
  }
  
  public void putDouble(String paramString, double paramDouble)
  {
    a(paramString, 3);
    this.kQ.putDouble(paramString, paramDouble);
  }
  
  public void putInt(String paramString, int paramInt)
  {
    a(paramString, 2);
    this.kQ.putInt(paramString, paramInt);
  }
  
  public void putString(String paramString1, String paramString2)
  {
    a(paramString1, 1);
    this.kQ.putString(paramString1, paramString2);
  }
  
  private static class a
  {
    private final Map<String, String> kS = new HashMap();
    private final Map<String, String> kT = new HashMap();
    private final Map<String, Integer> kU = new HashMap();
    
    public int A(String paramString)
    {
      paramString = (Integer)this.kU.get(paramString);
      if (paramString != null) {
        return paramString.intValue();
      }
      return 0;
    }
    
    public a a(String paramString1, String paramString2, int paramInt)
    {
      this.kS.put(paramString1, paramString2);
      this.kT.put(paramString2, paramString1);
      this.kU.put(paramString1, Integer.valueOf(paramInt));
      return this;
    }
    
    public String y(String paramString)
    {
      return (String)this.kS.get(paramString);
    }
    
    public String z(String paramString)
    {
      return (String)this.kT.get(paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/cast/MediaMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */