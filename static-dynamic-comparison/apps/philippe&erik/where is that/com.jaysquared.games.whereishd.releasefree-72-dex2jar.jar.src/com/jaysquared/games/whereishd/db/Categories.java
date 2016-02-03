package com.jaysquared.games.whereishd.db;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.jaysquared.games.whereishd.ApplicationManager;
import com.jaysquared.games.whereishd.utils.Language;
import com.jaysquared.games.whereishd.utils.PersistantSettings;
import com.jaysquared.games.whereishd.utils.SLog;
import org.osmdroid.util.BoundingBoxE6;
import org.osmdroid.util.GeoPoint;

@DatabaseTable
public class Categories
{
  private static final String LOG_TAG = Categories.class.getSimpleName();
  public static final String UUID_FIELD_NAME = "uuid";
  @DatabaseField
  private String icon;
  @DatabaseField
  private Double icon_latitude;
  @DatabaseField
  private Double icon_longitude;
  @DatabaseField
  private Double latitude;
  @DatabaseField
  private Double longitude;
  @DatabaseField
  private Double maxlatitude;
  @DatabaseField
  private Double maxlongitude;
  @DatabaseField
  private Double minlatitude;
  @DatabaseField
  private Double minlongitude;
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
  @DatabaseField
  private Integer treshold;
  @DatabaseField(canBeNull=true, defaultValue="0", foreign=true, foreignAutoCreate=true, foreignAutoRefresh=true)
  private CategoriesUserdata userdata;
  @DatabaseField(columnName="uuid", id=true)
  private String uuid;
  @DatabaseField
  private Double zoom;
  
  public BoundingBoxE6 getBoundingBox()
  {
    return new BoundingBoxE6(this.maxlatitude.doubleValue(), this.maxlongitude.doubleValue(), this.minlatitude.doubleValue(), this.minlongitude.doubleValue());
  }
  
  public GeoPoint getGeoPoint()
  {
    return new GeoPoint(this.latitude.doubleValue(), this.longitude.doubleValue());
  }
  
  public String getIcon()
  {
    return this.icon;
  }
  
  public GeoPoint getIconPoint()
  {
    return new GeoPoint(this.icon_latitude.doubleValue(), this.icon_longitude.doubleValue());
  }
  
  public Double getIcon_latitude()
  {
    return this.icon_latitude;
  }
  
  public Double getIcon_longitude()
  {
    return this.icon_longitude;
  }
  
  public Double getLatitude()
  {
    return this.latitude;
  }
  
  public Double getLongitude()
  {
    return this.longitude;
  }
  
  public Double getMaxlatitude()
  {
    return this.maxlatitude;
  }
  
  public Double getMaxlongitude()
  {
    return this.maxlatitude;
  }
  
  public Double getMinlatitude()
  {
    return this.minlatitude;
  }
  
  public Double getMinlongitude()
  {
    return this.minlongitude;
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
  
  public Double getTreshold()
  {
    return Double.valueOf(1000.0D * this.treshold.intValue());
  }
  
  public CategoriesUserdata getUserdata()
  {
    return this.userdata;
  }
  
  public String getUuid()
  {
    return this.uuid;
  }
  
  public Integer getZoom()
  {
    SLog.d(LOG_TAG, "db Zoom: " + this.zoom.toString());
    return Integer.valueOf((int)Math.round(this.zoom.doubleValue()));
  }
  
  public void setIcon(String paramString)
  {
    this.icon = paramString;
  }
  
  public void setIcon_latitude(Double paramDouble)
  {
    this.icon_latitude = paramDouble;
  }
  
  public void setIcon_longitude(Double paramDouble)
  {
    this.icon_longitude = paramDouble;
  }
  
  public void setLatitude(Double paramDouble)
  {
    this.latitude = paramDouble;
  }
  
  public void setLongitude(Double paramDouble)
  {
    this.longitude = paramDouble;
  }
  
  public void setMaxLongitude(Double paramDouble)
  {
    this.maxlongitude = paramDouble;
  }
  
  public void setMaxlatitude(Double paramDouble)
  {
    this.maxlatitude = paramDouble;
  }
  
  public void setMinlatitude(Double paramDouble)
  {
    this.minlatitude = paramDouble;
  }
  
  public void setMinlongitude(Double paramDouble)
  {
    this.minlongitude = paramDouble;
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
  
  public void setTreshold(Integer paramInteger)
  {
    this.treshold = paramInteger;
  }
  
  public void setUserdata(CategoriesUserdata paramCategoriesUserdata)
  {
    this.userdata = paramCategoriesUserdata;
  }
  
  public void setUuid(String paramString)
  {
    this.uuid = paramString;
  }
  
  public void setZoom(Double paramDouble)
  {
    this.zoom = paramDouble;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/db/Categories.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */