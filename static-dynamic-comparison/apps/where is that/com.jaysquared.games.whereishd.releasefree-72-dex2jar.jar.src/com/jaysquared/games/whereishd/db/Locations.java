package com.jaysquared.games.whereishd.db;

import android.content.Context;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.jaysquared.games.whereishd.ApplicationManager;
import com.jaysquared.games.whereishd.utils.Language;
import com.jaysquared.games.whereishd.utils.PersistantSettings;
import com.jaysquared.games.whereishd.utils.SLog;
import org.osmdroid.util.GeoPoint;

@DatabaseTable
public class Locations
{
  public static final String CATEGORY_ID_FIELD_NAME = "category_id";
  public static final String ID_FIELD_NAME = "id";
  private static final String LOG_TAG = Locations.class.getSimpleName();
  public static final String ORDER_FIELD_NAME = "lasttimestamp";
  public static final String UUID_FIELD_NAME = "uuid";
  @DatabaseField
  private String boundaries;
  @DatabaseField(columnName="category_id", index=true)
  private String category_id;
  @DatabaseField(columnName="id", generatedId=true)
  private int id;
  @DatabaseField(columnName="lasttimestamp", defaultValue="0")
  private long lasttimestamp;
  @DatabaseField
  private Double latitude;
  @DatabaseField
  private Double longitude;
  @DatabaseField
  private String title;
  @DatabaseField
  private String title_de;
  @DatabaseField
  private String title_es;
  @DatabaseField
  private String title_fr;
  @DatabaseField
  private String title_it;
  @DatabaseField
  private String title_nl;
  @DatabaseField
  private String title_pt;
  @DatabaseField(canBeNull=true, defaultValue="0", foreign=true, foreignAutoCreate=true, foreignAutoRefresh=true, foreignColumnName="id")
  private LocationsUserdata userdata;
  @DatabaseField(columnName="uuid", index=true)
  private String uuid;
  @DatabaseField
  private String wikipedia;
  @DatabaseField
  private String wikipedia_de;
  @DatabaseField
  private String wikipedia_es;
  @DatabaseField
  private String wikipedia_fr;
  @DatabaseField
  private String wikipedia_it;
  @DatabaseField
  private String wikipedia_nl;
  @DatabaseField
  private String wikipedia_pt;
  
  public String getBoundaries()
  {
    if (this.boundaries.length() > 0) {
      return this.boundaries;
    }
    return null;
  }
  
  public String getCategory_id()
  {
    return this.category_id;
  }
  
  public GeoPoint getGeoPoint()
  {
    return new GeoPoint(this.latitude.doubleValue(), this.longitude.doubleValue());
  }
  
  public long getLasttimestamp()
  {
    return this.lasttimestamp;
  }
  
  public Double getLatitude()
  {
    return this.latitude;
  }
  
  public Double getLongitude()
  {
    return this.longitude;
  }
  
  public String getTitle()
  {
    Language localLanguage = ApplicationManager.getInstance().getSettings().getLanguage();
    if ((localLanguage.equals(Language.DE)) && (this.title_de.length() > 0)) {
      return this.title_de;
    }
    if ((localLanguage.equals(Language.FR)) && (this.title_fr.length() > 0)) {
      return this.title_fr;
    }
    if ((localLanguage.equals(Language.ES)) && (this.title_es.length() > 0)) {
      return this.title_es;
    }
    if ((localLanguage.equals(Language.IT)) && (this.title_it.length() > 0)) {
      return this.title_it;
    }
    if ((localLanguage.equals(Language.PT)) && (this.title_pt.length() > 0)) {
      return this.title_pt;
    }
    if ((localLanguage.equals(Language.NL)) && (this.title_nl.length() > 0)) {
      return this.title_nl;
    }
    return this.title;
  }
  
  public String getTitle_de()
  {
    return this.title_de;
  }
  
  public String getTitle_es()
  {
    return this.title_es;
  }
  
  public String getTitle_fr()
  {
    return this.title_fr;
  }
  
  public String getTitle_it()
  {
    return this.title_it;
  }
  
  public String getTitle_nl()
  {
    return this.title_nl;
  }
  
  public String getTitle_pt()
  {
    return this.title_pt;
  }
  
  public LocationsUserdata getUserdata()
  {
    return this.userdata;
  }
  
  public String getUuid()
  {
    return this.uuid;
  }
  
  public String getWikipedia(Context paramContext)
  {
    paramContext = ApplicationManager.getInstance().getSettings().getLanguage();
    if ((paramContext.equals(Language.DE)) && (this.wikipedia_de.length() > 0)) {
      return this.wikipedia_de;
    }
    if ((paramContext.equals(Language.FR)) && (this.wikipedia_fr.length() > 0)) {
      return this.wikipedia_fr;
    }
    if ((paramContext.equals(Language.ES)) && (this.wikipedia_es.length() > 0)) {
      return this.wikipedia_es;
    }
    if ((paramContext.equals(Language.IT)) && (this.wikipedia_it.length() > 0)) {
      return this.wikipedia_it;
    }
    if ((paramContext.equals(Language.PT)) && (this.wikipedia_pt.length() > 0)) {
      return this.wikipedia_pt;
    }
    if ((paramContext.equals(Language.NL)) && (this.wikipedia_nl.length() > 0)) {
      return this.wikipedia_nl;
    }
    return this.wikipedia;
  }
  
  public String getWikipedia_de()
  {
    return this.wikipedia_de;
  }
  
  public String getWikipedia_es()
  {
    return this.wikipedia_es;
  }
  
  public String getWikipedia_fr()
  {
    return this.wikipedia_fr;
  }
  
  public String getWikipedia_it()
  {
    return this.wikipedia_it;
  }
  
  public String getWikipedia_nl()
  {
    return this.wikipedia_nl;
  }
  
  public String getWikipedia_pt()
  {
    return this.wikipedia_pt;
  }
  
  public void setBoundaries(String paramString)
  {
    this.boundaries = paramString;
  }
  
  public void setCategory_id(String paramString)
  {
    this.category_id = paramString;
  }
  
  public void setLasttimestamp(long paramLong)
  {
    this.lasttimestamp = paramLong;
  }
  
  public void setLatitude(Double paramDouble)
  {
    this.latitude = paramDouble;
  }
  
  public void setLongitude(Double paramDouble)
  {
    this.longitude = paramDouble;
  }
  
  public void setTimestamp()
  {
    this.lasttimestamp = System.currentTimeMillis();
    SLog.d(LOG_TAG, "db set time: " + System.currentTimeMillis() + " result:" + this.lasttimestamp);
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setTitle_de(String paramString)
  {
    this.title_de = paramString;
  }
  
  public void setTitle_es(String paramString)
  {
    this.title_es = paramString;
  }
  
  public void setTitle_fr(String paramString)
  {
    this.title_fr = paramString;
  }
  
  public void setTitle_it(String paramString)
  {
    this.title_it = paramString;
  }
  
  public void setTitle_nl(String paramString)
  {
    this.title_nl = paramString;
  }
  
  public void setTitle_pt(String paramString)
  {
    this.title_pt = paramString;
  }
  
  public void setUserdata(LocationsUserdata paramLocationsUserdata)
  {
    this.userdata = paramLocationsUserdata;
  }
  
  public void setUuid(String paramString)
  {
    this.uuid = paramString;
  }
  
  public void setWikipedia(String paramString)
  {
    this.wikipedia = paramString;
  }
  
  public void setWikipedia_de(String paramString)
  {
    this.wikipedia_de = paramString;
  }
  
  public void setWikipedia_es(String paramString)
  {
    this.wikipedia_es = paramString;
  }
  
  public void setWikipedia_fr(String paramString)
  {
    this.wikipedia_fr = paramString;
  }
  
  public void setWikipedia_it(String paramString)
  {
    this.wikipedia_it = paramString;
  }
  
  public void setWikipedia_nl(String paramString)
  {
    this.wikipedia_nl = paramString;
  }
  
  public void setWikipedia_pt(String paramString)
  {
    this.wikipedia_pt = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/db/Locations.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */