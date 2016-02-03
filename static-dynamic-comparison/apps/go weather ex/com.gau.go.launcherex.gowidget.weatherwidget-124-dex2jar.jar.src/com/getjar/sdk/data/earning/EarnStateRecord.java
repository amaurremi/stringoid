package com.getjar.sdk.data.earning;

import android.database.Cursor;
import com.getjar.sdk.utilities.StringUtility;

public class EarnStateRecord
{
  private final String _applicationMetadata;
  private final String _clientTransactionId;
  private final String _currencyKey;
  private final Long _earnAmount;
  private final EarnStateDatabase.EarnState _earnState;
  private final String _earnSubstate;
  private final String _friendlyName;
  private final long _id;
  private final EarnStateDatabase.NotificationState _notificationState;
  private final String _packageName;
  private final EarnStateDatabase.Status _status;
  private final long _timestampCreated;
  private final long _timestampModified;
  private final String _trackingMetadata;
  
  public EarnStateRecord(Cursor paramCursor)
  {
    this._id = paramCursor.getLong(0);
    this._clientTransactionId = paramCursor.getString(1);
    this._packageName = paramCursor.getString(2);
    this._timestampCreated = paramCursor.getLong(3);
    this._timestampModified = paramCursor.getLong(4);
    this._friendlyName = paramCursor.getString(5);
    this._applicationMetadata = paramCursor.getString(6);
    this._trackingMetadata = paramCursor.getString(7);
    this._status = EarnStateDatabase.Status.valueOf(paramCursor.getString(8));
    String str1 = paramCursor.getString(9);
    this._earnSubstate = paramCursor.getString(10);
    this._earnAmount = Long.valueOf(paramCursor.getLong(11));
    String str2 = paramCursor.getString(12);
    this._currencyKey = paramCursor.getString(13);
    if (StringUtility.isNullOrEmpty(str1)) {}
    for (this._earnState = null; StringUtility.isNullOrEmpty(str2); this._earnState = EarnStateDatabase.EarnState.valueOf(str1))
    {
      this._notificationState = EarnStateDatabase.NotificationState.NONE;
      return;
    }
    this._notificationState = EarnStateDatabase.NotificationState.valueOf(str2);
  }
  
  public boolean canShowInstallReminder()
  {
    return EarnStateDatabase.NotificationState.NONE.equals(this._notificationState);
  }
  
  public boolean canShowOpenReminder()
  {
    return (EarnStateDatabase.NotificationState.NONE.equals(this._notificationState)) || (EarnStateDatabase.NotificationState.INSTALL_REMINDER.equals(this._notificationState));
  }
  
  public String getApplicationMetadata()
  {
    return this._applicationMetadata;
  }
  
  public String getClientTransactionId()
  {
    return this._clientTransactionId;
  }
  
  public String getCurrencyKey()
  {
    return this._currencyKey;
  }
  
  public Long getEarnAmount()
  {
    return this._earnAmount;
  }
  
  public EarnStateDatabase.EarnState getEarnState()
  {
    return this._earnState;
  }
  
  public String getEarnSubstate()
  {
    return this._earnSubstate;
  }
  
  public String getFriendlyName()
  {
    return this._friendlyName;
  }
  
  public long getId()
  {
    return this._id;
  }
  
  public EarnStateDatabase.NotificationState getNotificationState()
  {
    return this._notificationState;
  }
  
  public String getPackageName()
  {
    return this._packageName;
  }
  
  public EarnStateDatabase.Status getStatus()
  {
    return this._status;
  }
  
  public long getTimestampCreated()
  {
    return this._timestampCreated;
  }
  
  public long getTimestampModified()
  {
    return this._timestampModified;
  }
  
  public String getTrackingMetadata()
  {
    return this._trackingMetadata;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("EarnStateRecord [");
    localStringBuilder.append("id:");
    localStringBuilder.append(this._id);
    localStringBuilder.append(" clientTransactionId:");
    localStringBuilder.append(this._clientTransactionId);
    localStringBuilder.append(" packageName:");
    localStringBuilder.append(this._packageName);
    localStringBuilder.append(" timestampCreated:");
    localStringBuilder.append(this._timestampCreated);
    localStringBuilder.append(" timestampModified:");
    localStringBuilder.append(this._timestampModified);
    localStringBuilder.append(" friendlyName:");
    localStringBuilder.append(this._friendlyName);
    localStringBuilder.append(" applicationMetadata:");
    localStringBuilder.append(this._applicationMetadata);
    localStringBuilder.append(" trackingMetadata:");
    localStringBuilder.append(this._trackingMetadata);
    localStringBuilder.append(" status:");
    localStringBuilder.append(this._status);
    localStringBuilder.append(" earnState:");
    localStringBuilder.append(this._earnState);
    localStringBuilder.append(" earnSubstate:");
    localStringBuilder.append(this._earnSubstate);
    localStringBuilder.append(" earnAmount:");
    localStringBuilder.append(this._earnAmount);
    localStringBuilder.append(" notificationState:");
    localStringBuilder.append(this._notificationState);
    localStringBuilder.append(" currencyKey:");
    localStringBuilder.append(this._currencyKey);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/earning/EarnStateRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */