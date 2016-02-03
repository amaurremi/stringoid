package com.getjar.sdk.comm.persistence;

import com.getjar.sdk.utilities.Base64;
import com.getjar.sdk.utilities.StringUtility;
import java.io.IOException;
import java.io.Serializable;
import java.util.Locale;

public abstract class TransactionBucket
{
  private String _clientTransactionId;
  private int _databaseId;
  private boolean _isNewTransaction = false;
  private DBTransactions.NotificationState _notificationState = null;
  protected String _relatedObject = null;
  private String _state = null;
  private long _timestampCreated;
  private long _timestampLastUpdated;
  private DBTransactions.TransactionType _type;
  
  protected TransactionBucket() {}
  
  protected TransactionBucket(String paramString, DBTransactions.TransactionType paramTransactionType, Serializable paramSerializable)
    throws IOException
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'clientTransactionId' can not be NULL or empty");
    }
    if (paramTransactionType == null) {
      throw new IllegalArgumentException("'type' can not be NULL");
    }
    this._clientTransactionId = paramString;
    this._type = paramTransactionType;
    if (paramSerializable != null) {
      this._relatedObject = Base64.encodeObject(paramSerializable);
    }
  }
  
  public String getClientTransactionId()
  {
    return this._clientTransactionId;
  }
  
  protected int getDatabaseId()
  {
    return this._databaseId;
  }
  
  public boolean getIsNewTransaction()
  {
    return this._isNewTransaction;
  }
  
  public DBTransactions.NotificationState getNotificationState()
  {
    return this._notificationState;
  }
  
  public Serializable getRelatedObject()
    throws IOException, ClassNotFoundException
  {
    if (StringUtility.isNullOrEmpty(this._relatedObject)) {
      return null;
    }
    return (Serializable)Base64.decodeToObject(this._relatedObject);
  }
  
  protected String getSerializedRelatedObject()
  {
    return this._relatedObject;
  }
  
  protected String getStateString()
  {
    return this._state;
  }
  
  public long getTimestampCreated()
  {
    return this._timestampCreated;
  }
  
  public long getTimestampLastUpdated()
  {
    return this._timestampLastUpdated;
  }
  
  public DBTransactions.TransactionType getType()
  {
    return this._type;
  }
  
  protected String getTypeString()
  {
    return this._type.name();
  }
  
  public void setClientTransactionId(String paramString)
  {
    this._clientTransactionId = paramString;
  }
  
  protected void setDatabaseId(int paramInt)
  {
    this._databaseId = paramInt;
  }
  
  public void setNotificationState(DBTransactions.NotificationState paramNotificationState)
  {
    this._notificationState = paramNotificationState;
  }
  
  public void setRelatedObject(Serializable paramSerializable)
    throws IOException
  {
    if (paramSerializable == null)
    {
      this._relatedObject = null;
      return;
    }
    this._relatedObject = Base64.encodeObject(paramSerializable);
  }
  
  protected void setSerializedRelatedObject(String paramString)
  {
    this._relatedObject = paramString;
  }
  
  protected void setStateString(String paramString)
  {
    try
    {
      if (((EarnBucket.class.isInstance(this)) && (((DBTransactions.EarnState)Enum.valueOf(DBTransactions.EarnState.class, paramString)).equals(DBTransactions.EarnState.CREATED))) || ((PurchaseUnmanagedBucket.class.isInstance(this)) && (((DBTransactions.PurchaseState)Enum.valueOf(DBTransactions.PurchaseState.class, paramString)).equals(DBTransactions.PurchaseState.CREATED)))) {
        this._isNewTransaction = true;
      }
      this._state = paramString;
      return;
    }
    catch (Exception localException)
    {
      throw new IllegalArgumentException(String.format(Locale.US, "Unable to parse the string '%1$s' into one of our transaction state enums", new Object[] { paramString }), localException);
    }
  }
  
  public void setTimestampCreated(long paramLong)
  {
    this._timestampCreated = paramLong;
  }
  
  public void setTimestampLastUpdated(long paramLong)
  {
    this._timestampLastUpdated = paramLong;
  }
  
  public void setType(DBTransactions.TransactionType paramTransactionType)
  {
    this._type = paramTransactionType;
  }
  
  protected void setTypeString(String paramString)
  {
    this._type = ((DBTransactions.TransactionType)Enum.valueOf(DBTransactions.TransactionType.class, paramString));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DB ID: ");
    localStringBuilder.append(this._databaseId);
    localStringBuilder.append("\r\n      ");
    localStringBuilder.append(this._clientTransactionId);
    localStringBuilder.append("\r\n      ");
    localStringBuilder.append(this._timestampCreated);
    localStringBuilder.append("\r\n      ");
    localStringBuilder.append(this._timestampLastUpdated);
    localStringBuilder.append("\r\n      ");
    localStringBuilder.append(this._type.name());
    localStringBuilder.append("\r\n      ");
    localStringBuilder.append(this._state);
    localStringBuilder.append("\r\n      ");
    localStringBuilder.append(this._relatedObject);
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/persistence/TransactionBucket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */