package com.getjar.sdk.data.install_state;

import android.database.Cursor;
import com.getjar.sdk.data.DatabaseRecordBase;
import com.getjar.sdk.utilities.StringUtility;

public class InstallStateRecord
  extends DatabaseRecordBase
{
  private final long _id;
  private final String _packageName;
  private final InstallStateManager.InstallState _status;
  private final long _timestamp;
  
  private InstallStateRecord(long paramLong1, String paramString, long paramLong2, InstallStateManager.InstallState paramInstallState)
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
    if (paramInstallState == null) {
      throw new IllegalArgumentException("'status' cannot be NULL");
    }
    this._id = paramLong1;
    this._packageName = paramString;
    this._timestamp = paramLong2;
    this._status = paramInstallState;
  }
  
  protected static InstallStateRecord loadFromDB(Cursor paramCursor)
  {
    return new InstallStateRecord(paramCursor.getLong(0), paramCursor.getString(1), paramCursor.getLong(2), InstallStateManager.InstallState.valueOf(paramCursor.getString(3)));
  }
  
  public long getId()
  {
    return this._id;
  }
  
  public String getPackageName()
  {
    return this._packageName;
  }
  
  protected InstallStateManager.InstallState getStatus()
  {
    return this._status;
  }
  
  protected long getTimestamp()
  {
    return this._timestamp;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("InstallStateRecord [");
    localStringBuilder.append("id:");
    localStringBuilder.append(this._id);
    localStringBuilder.append(" packageName:");
    localStringBuilder.append(this._packageName);
    localStringBuilder.append(" timestamp:");
    localStringBuilder.append(this._timestamp);
    localStringBuilder.append(" status:");
    localStringBuilder.append(this._status.name());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/install_state/InstallStateRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */