package com.getjar.sdk.data.package_events;

import android.database.Cursor;
import com.getjar.sdk.data.DatabaseRecordBase;
import com.getjar.sdk.utilities.StringUtility;

public class PackageEventRecord
  extends DatabaseRecordBase
{
  private final PackageEventManager.EventType _eventType;
  private final long _id;
  private final String _packageName;
  private final boolean _synced;
  private final long _timestamp;
  
  private PackageEventRecord(long paramLong1, String paramString, long paramLong2, PackageEventManager.EventType paramEventType, boolean paramBoolean)
  {
    if (paramLong1 < 0L) {
      throw new IllegalArgumentException("'id' cannot be negative");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'packageName' cannot be NULL or empty");
    }
    if (paramLong2 < 0L) {
      throw new IllegalArgumentException("'timestamp' cannot be negative");
    }
    if (paramEventType == null) {
      throw new IllegalArgumentException("'eventType' cannot be NULL");
    }
    this._id = paramLong1;
    this._packageName = paramString;
    this._timestamp = paramLong2;
    this._eventType = paramEventType;
    this._synced = paramBoolean;
  }
  
  protected static PackageEventRecord loadFromDB(Cursor paramCursor)
  {
    boolean bool = true;
    long l1 = paramCursor.getLong(0);
    String str = paramCursor.getString(1);
    long l2 = paramCursor.getLong(2);
    PackageEventManager.EventType localEventType = PackageEventManager.EventType.valueOf(paramCursor.getString(3));
    if (paramCursor.getLong(4) == 1L) {}
    for (;;)
    {
      return new PackageEventRecord(l1, str, l2, localEventType, bool);
      bool = false;
    }
  }
  
  protected PackageEventManager.EventType getEventType()
  {
    return this._eventType;
  }
  
  public long getId()
  {
    return this._id;
  }
  
  protected String getPackageName()
  {
    return this._packageName;
  }
  
  protected long getTimestamp()
  {
    return this._timestamp;
  }
  
  protected boolean isSynced()
  {
    return this._synced;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("PackageEventRecord [");
    localStringBuilder.append("id:");
    localStringBuilder.append(this._id);
    localStringBuilder.append(" packageName:");
    localStringBuilder.append(this._packageName);
    localStringBuilder.append(" timestamp:");
    localStringBuilder.append(this._timestamp);
    localStringBuilder.append(" eventType:");
    localStringBuilder.append(this._eventType.name());
    localStringBuilder.append(" synced:");
    localStringBuilder.append(this._synced);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/package_events/PackageEventRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */