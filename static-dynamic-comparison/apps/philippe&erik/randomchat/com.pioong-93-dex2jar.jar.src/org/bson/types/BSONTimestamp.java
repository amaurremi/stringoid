package org.bson.types;

import java.io.Serializable;
import java.util.Date;

public class BSONTimestamp
  implements Comparable<BSONTimestamp>, Serializable
{
  static final boolean D = Boolean.getBoolean("DEBUG.DBTIMESTAMP");
  private static final long serialVersionUID = -3268482672267936464L;
  final int _inc;
  final Date _time;
  
  public BSONTimestamp()
  {
    this._inc = 0;
    this._time = null;
  }
  
  public BSONTimestamp(int paramInt1, int paramInt2)
  {
    this._time = new Date(paramInt1 * 1000L);
    this._inc = paramInt2;
  }
  
  public int compareTo(BSONTimestamp paramBSONTimestamp)
  {
    if (getTime() != paramBSONTimestamp.getTime()) {
      return getTime() - paramBSONTimestamp.getTime();
    }
    return getInc() - paramBSONTimestamp.getInc();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof BSONTimestamp)) {
        break;
      }
      paramObject = (BSONTimestamp)paramObject;
    } while ((getTime() == ((BSONTimestamp)paramObject).getTime()) && (getInc() == ((BSONTimestamp)paramObject).getInc()));
    return false;
    return false;
  }
  
  public int getInc()
  {
    return this._inc;
  }
  
  public int getTime()
  {
    if (this._time == null) {
      return 0;
    }
    return (int)(this._time.getTime() / 1000L);
  }
  
  public int hashCode()
  {
    return (this._inc + 31) * 31 + getTime();
  }
  
  public String toString()
  {
    return "TS time:" + this._time + " inc:" + this._inc;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/types/BSONTimestamp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */