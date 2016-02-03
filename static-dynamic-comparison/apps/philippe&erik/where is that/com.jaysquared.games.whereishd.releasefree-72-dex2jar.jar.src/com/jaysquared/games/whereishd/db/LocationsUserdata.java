package com.jaysquared.games.whereishd.db;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class LocationsUserdata
{
  public static final String LOCATION_EXCLUDE_FIELD_NAME = "exclude_rights";
  public static final String LOCATION_ID_FIELD_NAME = "location_id";
  @DatabaseField(columnName="exclude_rights", defaultValue="0")
  public int exclude_rights;
  @DatabaseField(generatedId=true)
  private int id;
  @DatabaseField(columnName="location_id", index=true)
  public String location_id;
  
  public int getExclude_rights()
  {
    return this.exclude_rights;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getLocation_id()
  {
    return this.location_id;
  }
  
  public void resetLocation()
  {
    setExclude_rights(0);
  }
  
  public void setExclude_rights(int paramInt)
  {
    this.exclude_rights = paramInt;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setLocation_id(String paramString)
  {
    this.location_id = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/db/LocationsUserdata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */