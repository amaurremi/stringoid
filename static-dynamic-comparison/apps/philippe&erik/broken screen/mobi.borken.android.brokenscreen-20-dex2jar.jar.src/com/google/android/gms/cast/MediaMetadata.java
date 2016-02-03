package com.google.android.gms.cast;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.internal.gt;
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
  private static final a AA = new a().a("com.google.android.gms.cast.metadata.CREATION_DATE", "creationDateTime", 4).a("com.google.android.gms.cast.metadata.RELEASE_DATE", "releaseDate", 4).a("com.google.android.gms.cast.metadata.BROADCAST_DATE", "originalAirdate", 4).a("com.google.android.gms.cast.metadata.TITLE", "title", 1).a("com.google.android.gms.cast.metadata.SUBTITLE", "subtitle", 1).a("com.google.android.gms.cast.metadata.ARTIST", "artist", 1).a("com.google.android.gms.cast.metadata.ALBUM_ARTIST", "albumArtist", 1).a("com.google.android.gms.cast.metadata.ALBUM_TITLE", "albumName", 1).a("com.google.android.gms.cast.metadata.COMPOSER", "composer", 1).a("com.google.android.gms.cast.metadata.DISC_NUMBER", "discNumber", 2).a("com.google.android.gms.cast.metadata.TRACK_NUMBER", "trackNumber", 2).a("com.google.android.gms.cast.metadata.SEASON_NUMBER", "season", 2).a("com.google.android.gms.cast.metadata.EPISODE_NUMBER", "episode", 2).a("com.google.android.gms.cast.metadata.SERIES_TITLE", "seriesTitle", 1).a("com.google.android.gms.cast.metadata.STUDIO", "studio", 1).a("com.google.android.gms.cast.metadata.WIDTH", "width", 2).a("com.google.android.gms.cast.metadata.HEIGHT", "height", 2).a("com.google.android.gms.cast.metadata.LOCATION_NAME", "location", 1).a("com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "latitude", 3).a("com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "longitude", 3);
  private static final String[] Az = { null, "String", "int", "double", "ISO-8601 date String" };
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
  private final Bundle AB = new Bundle();
  private int AC;
  private final List<WebImage> zN = new ArrayList();
  
  public MediaMetadata()
  {
    this(0);
  }
  
  public MediaMetadata(int paramInt)
  {
    this.AC = paramInt;
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
        if (!this.AB.containsKey(str)) {}
      }
      else
      {
        switch (AA.ag(str))
        {
        case 1: 
        case 4: 
          paramJSONObject.put(AA.ae(str), this.AB.getString(str));
          break;
        case 2: 
          paramJSONObject.put(AA.ae(str), this.AB.getInt(str));
          break;
        case 3: 
          paramJSONObject.put(AA.ae(str), this.AB.getDouble(str));
          break;
          paramVarArgs = this.AB.keySet().iterator();
          while (paramVarArgs.hasNext())
          {
            str = (String)paramVarArgs.next();
            if (!str.startsWith("com.google."))
            {
              Object localObject = this.AB.get(str);
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
        Object localObject1 = (String)localIterator.next();
        if (!"metadataType".equals(localObject1))
        {
          Object localObject2 = AA.af((String)localObject1);
          if (localObject2 != null)
          {
            boolean bool = paramVarArgs.contains(localObject2);
            if (!bool) {}
          }
          else
          {
            try
            {
              localObject1 = paramJSONObject.get((String)localObject1);
              if (localObject1 != null) {
                switch (AA.ag((String)localObject2))
                {
                case 1: 
                  if ((localObject1 instanceof String)) {
                    this.AB.putString((String)localObject2, (String)localObject1);
                  }
                  break;
                case 4: 
                  if (((localObject1 instanceof String)) && (gt.aq((String)localObject1) != null)) {
                    this.AB.putString((String)localObject2, (String)localObject1);
                  }
                  break;
                case 2: 
                  if ((localObject1 instanceof Integer)) {
                    this.AB.putInt((String)localObject2, ((Integer)localObject1).intValue());
                  }
                  break;
                case 3: 
                  if ((localObject1 instanceof Double))
                  {
                    this.AB.putDouble((String)localObject2, ((Double)localObject1).doubleValue());
                    continue;
                    localObject2 = paramJSONObject.get((String)localObject1);
                    if ((localObject2 instanceof String)) {
                      this.AB.putString((String)localObject1, (String)localObject2);
                    } else if ((localObject2 instanceof Integer)) {
                      this.AB.putInt((String)localObject1, ((Integer)localObject2).intValue());
                    } else if ((localObject2 instanceof Double)) {
                      this.AB.putDouble((String)localObject1, ((Double)localObject2).doubleValue());
                    }
                  }
                  break;
                }
              }
            }
            catch (JSONException localJSONException) {}
          }
        }
      }
      return;
    }
    catch (JSONException paramJSONObject) {}
  }
  
  private void d(String paramString, int paramInt)
    throws IllegalArgumentException
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("null and empty keys are not allowed");
    }
    int i = AA.ag(paramString);
    if ((i != paramInt) && (i != 0)) {
      throw new IllegalArgumentException("Value for " + paramString + " must be a " + Az[paramInt]);
    }
  }
  
  public void addImage(WebImage paramWebImage)
  {
    this.zN.add(paramWebImage);
  }
  
  public void b(JSONObject paramJSONObject)
  {
    clear();
    this.AC = 0;
    try
    {
      this.AC = paramJSONObject.getInt("metadataType");
      gt.a(this.zN, paramJSONObject);
      switch (this.AC)
      {
      default: 
        b(paramJSONObject, new String[0]);
        return;
      case 0: 
        b(paramJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE" });
        return;
      case 1: 
        b(paramJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.STUDIO", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE" });
        return;
      case 2: 
        b(paramJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.SERIES_TITLE", "com.google.android.gms.cast.metadata.SEASON_NUMBER", "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "com.google.android.gms.cast.metadata.BROADCAST_DATE" });
        return;
      case 3: 
        b(paramJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ALBUM_TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "com.google.android.gms.cast.metadata.COMPOSER", "com.google.android.gms.cast.metadata.TRACK_NUMBER", "com.google.android.gms.cast.metadata.DISC_NUMBER", "com.google.android.gms.cast.metadata.RELEASE_DATE" });
        return;
      }
      b(paramJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.LOCATION_NAME", "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "com.google.android.gms.cast.metadata.WIDTH", "com.google.android.gms.cast.metadata.HEIGHT", "com.google.android.gms.cast.metadata.CREATION_DATE" });
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
  }
  
  public void clear()
  {
    this.AB.clear();
    this.zN.clear();
  }
  
  public void clearImages()
  {
    this.zN.clear();
  }
  
  public boolean containsKey(String paramString)
  {
    return this.AB.containsKey(paramString);
  }
  
  public JSONObject dU()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("metadataType", this.AC);
      gt.a(localJSONObject, this.zN);
      switch (this.AC)
      {
      default: 
        a(localJSONObject, new String[0]);
        return localJSONObject;
      case 0: 
        a(localJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE" });
        return localJSONObject;
      case 1: 
        a(localJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.STUDIO", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE" });
        return localJSONObject;
      case 2: 
        a(localJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.SERIES_TITLE", "com.google.android.gms.cast.metadata.SEASON_NUMBER", "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "com.google.android.gms.cast.metadata.BROADCAST_DATE" });
        return localJSONObject;
      case 3: 
        a(localJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.ALBUM_TITLE", "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "com.google.android.gms.cast.metadata.COMPOSER", "com.google.android.gms.cast.metadata.TRACK_NUMBER", "com.google.android.gms.cast.metadata.DISC_NUMBER", "com.google.android.gms.cast.metadata.RELEASE_DATE" });
        return localJSONObject;
      }
      a(localJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.LOCATION_NAME", "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "com.google.android.gms.cast.metadata.WIDTH", "com.google.android.gms.cast.metadata.HEIGHT", "com.google.android.gms.cast.metadata.CREATION_DATE" });
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
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
    } while ((a(this.AB, ((MediaMetadata)paramObject).AB)) && (this.zN.equals(((MediaMetadata)paramObject).zN)));
    return false;
  }
  
  public Calendar getDate(String paramString)
  {
    d(paramString, 4);
    paramString = this.AB.getString(paramString);
    if (paramString != null) {
      return gt.aq(paramString);
    }
    return null;
  }
  
  public String getDateAsString(String paramString)
  {
    d(paramString, 4);
    return this.AB.getString(paramString);
  }
  
  public double getDouble(String paramString)
  {
    d(paramString, 3);
    return this.AB.getDouble(paramString);
  }
  
  public List<WebImage> getImages()
  {
    return this.zN;
  }
  
  public int getInt(String paramString)
  {
    d(paramString, 2);
    return this.AB.getInt(paramString);
  }
  
  public int getMediaType()
  {
    return this.AC;
  }
  
  public String getString(String paramString)
  {
    d(paramString, 1);
    return this.AB.getString(paramString);
  }
  
  public boolean hasImages()
  {
    return (this.zN != null) && (!this.zN.isEmpty());
  }
  
  public int hashCode()
  {
    Iterator localIterator = this.AB.keySet().iterator();
    String str;
    for (int i = 17; localIterator.hasNext(); i = this.AB.get(str).hashCode() + i * 31) {
      str = (String)localIterator.next();
    }
    return i * 31 + this.zN.hashCode();
  }
  
  public Set<String> keySet()
  {
    return this.AB.keySet();
  }
  
  public void putDate(String paramString, Calendar paramCalendar)
  {
    d(paramString, 4);
    this.AB.putString(paramString, gt.a(paramCalendar));
  }
  
  public void putDouble(String paramString, double paramDouble)
  {
    d(paramString, 3);
    this.AB.putDouble(paramString, paramDouble);
  }
  
  public void putInt(String paramString, int paramInt)
  {
    d(paramString, 2);
    this.AB.putInt(paramString, paramInt);
  }
  
  public void putString(String paramString1, String paramString2)
  {
    d(paramString1, 1);
    this.AB.putString(paramString1, paramString2);
  }
  
  private static class a
  {
    private final Map<String, String> AD = new HashMap();
    private final Map<String, String> AE = new HashMap();
    private final Map<String, Integer> AF = new HashMap();
    
    public a a(String paramString1, String paramString2, int paramInt)
    {
      this.AD.put(paramString1, paramString2);
      this.AE.put(paramString2, paramString1);
      this.AF.put(paramString1, Integer.valueOf(paramInt));
      return this;
    }
    
    public String ae(String paramString)
    {
      return (String)this.AD.get(paramString);
    }
    
    public String af(String paramString)
    {
      return (String)this.AE.get(paramString);
    }
    
    public int ag(String paramString)
    {
      paramString = (Integer)this.AF.get(paramString);
      if (paramString != null) {
        return paramString.intValue();
      }
      return 0;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/cast/MediaMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */