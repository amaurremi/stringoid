package com.inmobi.commons.thinICE.cellular;

public final class CellOperatorInfo
{
  public static final int MCC_NOT_AVAILABLE = -1;
  public static final int MNC_NOT_AVAILABLE = -1;
  public int currentMcc;
  public int currentMnc;
  public int simMcc;
  public int simMnc;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName()).append("[");
    localStringBuilder.append("currentMcc=").append(this.currentMcc).append(", ");
    localStringBuilder.append("currentMnc=").append(this.currentMnc).append(", ");
    localStringBuilder.append("simMcc=").append(this.simMcc).append(", ");
    localStringBuilder.append("simMnc=").append(this.simMnc);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/thinICE/cellular/CellOperatorInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */