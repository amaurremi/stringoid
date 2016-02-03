package com.jaysquared.games.whereishd.db;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.jaysquared.games.whereishd.utils.SLog;

@DatabaseTable
public class CategoriesUserdata
{
  public static final String CATEGORY_ID_FIELD_NAME = "category_id";
  private static final String LOG_TAG = CategoriesUserdata.class.getSimpleName();
  @DatabaseField(columnName="category_id", index=true)
  public String category_id;
  @DatabaseField(defaultValue="0")
  public int distanceFactor;
  @DatabaseField(defaultValue="0")
  private int exclude;
  @DatabaseField(defaultValue="0")
  public int highscore;
  @DatabaseField(generatedId=true)
  private int id;
  @DatabaseField(defaultValue="0")
  public int locations;
  @DatabaseField(defaultValue="0")
  public int locationsSelection;
  @DatabaseField(defaultValue="0")
  public int locationsTotal;
  @DatabaseField(defaultValue="0")
  public int total_missed;
  @DatabaseField(defaultValue="0")
  public int total_rights;
  
  public String getCategory_id()
  {
    return this.category_id;
  }
  
  public int getDistanceFactor()
  {
    return this.distanceFactor;
  }
  
  public int getExclude()
  {
    return this.exclude;
  }
  
  public int getHighscore()
  {
    return this.highscore;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public int getLocations()
  {
    return this.locations;
  }
  
  public int getLocationsSelection()
  {
    return this.locationsSelection;
  }
  
  public int getLocationsTotal()
  {
    return this.locationsTotal;
  }
  
  public int getTotal_missed()
  {
    return this.total_missed;
  }
  
  public int getTotal_rights()
  {
    return this.total_rights;
  }
  
  public void resetCategory()
  {
    setTotal_missed(0);
    setTotal_rights(0);
    setLocations(0);
    setLocationsSelection(0);
    setExclude(0);
    Categories localCategories = DatabaseManager.getInstance().getCategory(this.category_id);
    SLog.d(LOG_TAG, "DistanceFactor reset category()- setDistanceFactor(category.getTreshold().intValue() " + localCategories.getTreshold().intValue());
    setDistanceFactor((int)(localCategories.getTreshold().doubleValue() / 1000.0D));
  }
  
  public void setCategory_id(String paramString)
  {
    this.category_id = paramString;
  }
  
  public void setDistanceFactor(int paramInt)
  {
    this.distanceFactor = paramInt;
  }
  
  public void setExclude(int paramInt)
  {
    this.exclude = paramInt;
  }
  
  public void setHighscore(int paramInt)
  {
    this.highscore = paramInt;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setLocations(int paramInt)
  {
    this.locations = paramInt;
  }
  
  public void setLocationsSelection(int paramInt)
  {
    this.locationsSelection = paramInt;
  }
  
  public void setLocationsTotal(int paramInt)
  {
    this.locationsTotal = paramInt;
  }
  
  public void setTotal_missed(int paramInt)
  {
    this.total_missed = paramInt;
  }
  
  public void setTotal_rights(int paramInt)
  {
    this.total_rights = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/db/CategoriesUserdata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */