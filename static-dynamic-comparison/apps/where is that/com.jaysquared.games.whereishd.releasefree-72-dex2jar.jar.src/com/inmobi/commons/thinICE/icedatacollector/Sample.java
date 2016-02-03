package com.inmobi.commons.thinICE.icedatacollector;

import com.inmobi.commons.thinICE.cellular.CellOperatorInfo;
import com.inmobi.commons.thinICE.cellular.CellTowerInfo;
import com.inmobi.commons.thinICE.location.LocationInfo;
import com.inmobi.commons.thinICE.wifi.WifiInfo;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class Sample
{
  public CellOperatorInfo cellOperator;
  public CellTowerInfo connectedCellTowerInfo;
  public WifiInfo connectedWifiAp;
  public HashMap<String, LocationInfo> lastKnownLocations;
  public long utc;
  public List<WifiInfo> visibleWifiAp;
  public int zoneOffset;
  
  Sample()
  {
    Calendar localCalendar = Calendar.getInstance();
    this.utc = localCalendar.getTimeInMillis();
    int i = localCalendar.get(15);
    this.zoneOffset = (localCalendar.get(16) + i);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName()).append("[\n");
    localStringBuilder.append("-- utc: ").append(this.utc).append("\n");
    localStringBuilder.append("-- zoneOffset: ").append(this.zoneOffset).append("\n");
    localStringBuilder.append("-- cell operator: ").append(this.cellOperator).append("\n");
    localStringBuilder.append("-- connected wifi access point: ").append(this.connectedWifiAp).append("\n");
    localStringBuilder.append("-- last known locations:");
    if (this.lastKnownLocations == null)
    {
      localStringBuilder.append(" null\n");
      localStringBuilder.append("-- visible wifi aps:");
      if (this.visibleWifiAp != null) {
        break label232;
      }
      localStringBuilder.append(" null\n");
    }
    for (;;)
    {
      localStringBuilder.append("-- connected serving cell tower: ").append(this.connectedCellTowerInfo).append("\n");
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      localStringBuilder.append("\n");
      Iterator localIterator = this.lastKnownLocations.values().iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = (LocationInfo)localIterator.next();
        localStringBuilder.append("   + ").append(localObject).append("\n");
      }
      break;
      label232:
      localStringBuilder.append("\n");
      localIterator = this.visibleWifiAp.iterator();
      while (localIterator.hasNext())
      {
        localObject = (WifiInfo)localIterator.next();
        localStringBuilder.append("   + ").append(localObject).append("\n");
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/thinICE/icedatacollector/Sample.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */