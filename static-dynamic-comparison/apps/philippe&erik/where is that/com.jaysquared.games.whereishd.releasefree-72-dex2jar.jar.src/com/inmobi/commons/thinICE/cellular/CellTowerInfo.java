package com.inmobi.commons.thinICE.cellular;

public final class CellTowerInfo
{
  public String id;
  public int signalStrength;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName()).append("[");
    localStringBuilder.append("id=").append(this.id).append(", ");
    localStringBuilder.append("ss=").append(this.signalStrength).append(", ");
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/thinICE/cellular/CellTowerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */