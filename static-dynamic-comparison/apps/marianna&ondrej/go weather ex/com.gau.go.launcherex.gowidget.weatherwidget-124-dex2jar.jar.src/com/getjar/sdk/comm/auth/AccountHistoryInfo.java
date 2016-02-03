package com.getjar.sdk.comm.auth;

import android.database.Cursor;

public class AccountHistoryInfo
{
  private final String _accountName;
  private final int _id;
  private final String _providerFilter;
  private final long _timestampCreated;
  private final long _timestampLastAuth;
  private final String _userAccessId;
  private final String _userDeviceId;
  
  public AccountHistoryInfo(Cursor paramCursor)
  {
    if (paramCursor == null) {
      throw new IllegalArgumentException("'dbCursor' can not be NULL");
    }
    this._id = paramCursor.getInt(0);
    this._userAccessId = paramCursor.getString(1);
    this._userDeviceId = paramCursor.getString(2);
    this._providerFilter = paramCursor.getString(3);
    this._accountName = paramCursor.getString(4);
    this._timestampLastAuth = paramCursor.getLong(5);
    this._timestampCreated = paramCursor.getLong(6);
  }
  
  public String getAccountName()
  {
    return this._accountName;
  }
  
  public int getId()
  {
    return this._id;
  }
  
  public String getProviderFilter()
  {
    return this._providerFilter;
  }
  
  public long getTimestampCreated()
  {
    return this._timestampCreated;
  }
  
  public long getTimestampLastAuth()
  {
    return this._timestampLastAuth;
  }
  
  public String getUserAccessId()
  {
    return this._userAccessId;
  }
  
  public String getUserDeviceId()
  {
    return this._userDeviceId;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/auth/AccountHistoryInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */