package com.getjar.sdk.comm.persistence;

import com.getjar.sdk.utilities.Base64;
import com.getjar.sdk.utilities.StringUtility;
import java.io.IOException;
import java.io.Serializable;
import java.util.Locale;

public class GrantGetjarPassBucket
  extends TransactionBucket
{
  public GrantGetjarPassBucket()
  {
    setType(DBTransactions.TransactionType.GRANT_GETJAR_PASS);
  }
  
  public GrantGetjarPassBucket(String paramString, Serializable paramSerializable)
    throws IOException
  {
    super(paramString, DBTransactions.TransactionType.GRANT_GETJAR_PASS, paramSerializable);
  }
  
  public RelatedGrantGetjarPassData getRelatedObject()
    throws IOException, ClassNotFoundException
  {
    if (StringUtility.isNullOrEmpty(this._relatedObject)) {
      return null;
    }
    return (RelatedGrantGetjarPassData)Base64.decodeToObject(this._relatedObject);
  }
  
  public DBTransactions.GrantGetjarPassState getState()
  {
    return (DBTransactions.GrantGetjarPassState)Enum.valueOf(DBTransactions.GrantGetjarPassState.class, super.getStateString());
  }
  
  public void setState(DBTransactions.GrantGetjarPassState paramGrantGetjarPassState)
  {
    setStateString(paramGrantGetjarPassState.name());
  }
  
  protected void setStateString(String paramString)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'state' can not be NULL or empty");
    }
    try
    {
      Enum.valueOf(DBTransactions.GrantGetjarPassState.class, paramString);
      super.setStateString(paramString);
      return;
    }
    catch (Exception localException)
    {
      throw new IllegalArgumentException(String.format(Locale.US, "Can not set the state for EarnBucket to '%1$s'", new Object[] { paramString }), localException);
    }
  }
  
  public void setType(DBTransactions.TransactionType paramTransactionType)
  {
    if (!DBTransactions.TransactionType.GRANT_GETJAR_PASS.equals(paramTransactionType)) {
      throw new IllegalArgumentException(String.format(Locale.US, "Can not set the TransactionType for GrantGetjarPassBucket to '%1$s'", new Object[] { paramTransactionType.name() }));
    }
    super.setTypeString(DBTransactions.TransactionType.GRANT_GETJAR_PASS.name());
  }
  
  protected void setTypeString(String paramString)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'type' can not be NULL or empty");
    }
    DBTransactions.TransactionType localTransactionType = (DBTransactions.TransactionType)Enum.valueOf(DBTransactions.TransactionType.class, paramString);
    if (!DBTransactions.TransactionType.GRANT_GETJAR_PASS.equals(localTransactionType)) {
      throw new IllegalArgumentException(String.format(Locale.US, "Can not set the TransactionType for GrantGetjarPassBucket to '%1$s'", new Object[] { paramString }));
    }
    super.setTypeString(DBTransactions.TransactionType.GRANT_GETJAR_PASS.name());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/persistence/GrantGetjarPassBucket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */