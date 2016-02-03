package com.getjar.sdk.comm.persistence;

import com.getjar.sdk.utilities.Base64;
import com.getjar.sdk.utilities.StringUtility;
import java.io.IOException;
import java.io.Serializable;
import java.util.Locale;

public class PurchaseUnmanagedBucket
  extends TransactionBucket
{
  public PurchaseUnmanagedBucket()
  {
    setType(DBTransactions.TransactionType.PURCHASE);
  }
  
  public PurchaseUnmanagedBucket(String paramString, Serializable paramSerializable)
    throws IOException
  {
    super(paramString, DBTransactions.TransactionType.PURCHASE, paramSerializable);
  }
  
  public RelatedPurchaseData getRelatedObject()
    throws IOException, ClassNotFoundException
  {
    if (StringUtility.isNullOrEmpty(this._relatedObject)) {
      return null;
    }
    return (RelatedPurchaseData)Base64.decodeToObject(this._relatedObject);
  }
  
  public DBTransactions.PurchaseState getState()
  {
    return (DBTransactions.PurchaseState)Enum.valueOf(DBTransactions.PurchaseState.class, super.getStateString());
  }
  
  public void setState(DBTransactions.PurchaseState paramPurchaseState)
  {
    setStateString(paramPurchaseState.name());
  }
  
  protected void setStateString(String paramString)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'state' can not be NULL or empty");
    }
    try
    {
      Enum.valueOf(DBTransactions.PurchaseState.class, paramString);
      super.setStateString(paramString);
      return;
    }
    catch (Exception localException)
    {
      throw new IllegalArgumentException(String.format(Locale.US, "Can not set the state for PurchaseBucket to '%1$s'", new Object[] { paramString }), localException);
    }
  }
  
  public void setType(DBTransactions.TransactionType paramTransactionType)
  {
    if (!DBTransactions.TransactionType.PURCHASE.equals(paramTransactionType)) {
      throw new IllegalArgumentException(String.format(Locale.US, "Can not set the TransactionType for PurchaseBucket to '%1$s'", new Object[] { paramTransactionType.name() }));
    }
    super.setTypeString(DBTransactions.TransactionType.PURCHASE.name());
  }
  
  protected void setTypeString(String paramString)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'type' can not be NULL or empty");
    }
    DBTransactions.TransactionType localTransactionType = (DBTransactions.TransactionType)Enum.valueOf(DBTransactions.TransactionType.class, paramString);
    if (!DBTransactions.TransactionType.PURCHASE.equals(localTransactionType)) {
      throw new IllegalArgumentException(String.format(Locale.US, "Can not set the TransactionType for PurchaseBucket to '%1$s'", new Object[] { paramString }));
    }
    super.setTypeString(DBTransactions.TransactionType.PURCHASE.name());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/persistence/PurchaseUnmanagedBucket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */