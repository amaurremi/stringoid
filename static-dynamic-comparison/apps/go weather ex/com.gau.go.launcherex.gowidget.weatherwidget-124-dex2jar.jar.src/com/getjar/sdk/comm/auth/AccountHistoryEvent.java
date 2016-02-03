package com.getjar.sdk.comm.auth;

import android.database.Cursor;

public class AccountHistoryEvent
{
  private final AccountEventType _eventType;
  private final int _id;
  private final long _timestamp;
  private final String _userAccessId;
  
  public AccountHistoryEvent(Cursor paramCursor)
  {
    if (paramCursor == null) {
      throw new IllegalArgumentException("'dbCursor' can not be NULL");
    }
    this._id = paramCursor.getInt(0);
    this._userAccessId = paramCursor.getString(1);
    this._eventType = AccountEventType.valueOf(paramCursor.getString(2));
    this._timestamp = paramCursor.getLong(3);
  }
  
  public AccountEventType getEventType()
  {
    return this._eventType;
  }
  
  public int getId()
  {
    return this._id;
  }
  
  public long getTimestamp()
  {
    return this._timestamp;
  }
  
  public String getUserAccessId()
  {
    return this._userAccessId;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/auth/AccountHistoryEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */