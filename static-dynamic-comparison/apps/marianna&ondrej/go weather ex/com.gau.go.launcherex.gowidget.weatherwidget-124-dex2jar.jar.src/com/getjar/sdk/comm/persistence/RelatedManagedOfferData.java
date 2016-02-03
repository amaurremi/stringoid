package com.getjar.sdk.comm.persistence;

import com.getjar.sdk.utilities.StringUtility;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class RelatedManagedOfferData
  implements Serializable
{
  private static final long serialVersionUID = 1387628907828312943L;
  private String _offerId;
  private HashMap<String, String> _purchaseMetadata;
  private HashMap<String, String> _trackingMetadata;
  
  public RelatedManagedOfferData() {}
  
  public RelatedManagedOfferData(String paramString, HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'productId' cannot be null or empty");
    }
    if ((paramHashMap1 == null) || (paramHashMap1.isEmpty())) {
      throw new IllegalArgumentException("'itemMetadata' cannot be null or empty");
    }
    if ((paramHashMap2 == null) || (paramHashMap2.isEmpty())) {
      throw new IllegalArgumentException("'trackingMetadata' cannot be null or empty");
    }
    this._offerId = paramString;
    this._purchaseMetadata = paramHashMap1;
    this._trackingMetadata = paramHashMap2;
    this._purchaseMetadata.put("marketplace", "marketplace.google_play");
  }
  
  public RelatedManagedOfferData(HashMap<String, String> paramHashMap)
  {
    if ((paramHashMap == null) || (paramHashMap.isEmpty())) {
      throw new IllegalArgumentException("'itemMetadata' cannot be null or empty");
    }
    this._purchaseMetadata = paramHashMap;
    this._purchaseMetadata.put("marketplace", "marketplace.google_play");
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    this._offerId = paramObjectInputStream.readUTF();
    if (StringUtility.isNullOrEmpty(this._offerId)) {
      this._offerId = null;
    }
    try
    {
      this._trackingMetadata = ((HashMap)paramObjectInputStream.readObject());
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          this._purchaseMetadata = ((HashMap)paramObjectInputStream.readObject());
          return;
        }
        catch (Exception paramObjectInputStream)
        {
          this._purchaseMetadata = null;
        }
        localException = localException;
        this._trackingMetadata = null;
      }
    }
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    if (StringUtility.isNullOrEmpty(this._offerId))
    {
      paramObjectOutputStream.writeUTF("");
      if (this._trackingMetadata != null) {
        break label54;
      }
      paramObjectOutputStream.writeObject("");
    }
    for (;;)
    {
      if (this._purchaseMetadata != null) {
        break label65;
      }
      paramObjectOutputStream.writeObject("");
      return;
      paramObjectOutputStream.writeUTF(this._offerId);
      break;
      label54:
      paramObjectOutputStream.writeObject(this._trackingMetadata);
    }
    label65:
    paramObjectOutputStream.writeObject(this._purchaseMetadata);
  }
  
  public void addGooglePlayTransactionData(String paramString1, String paramString2)
  {
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("'purchaseData' cannot be null or empty");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("'signature' cannot be null or empty");
    }
    if (this._purchaseMetadata == null)
    {
      this._purchaseMetadata = new HashMap();
      this._purchaseMetadata.put("marketplace", "marketplace.google_play");
    }
    this._purchaseMetadata.put("order.google_play.signature", paramString2);
    this._purchaseMetadata.put("order.google_play.signed_data", paramString1);
  }
  
  public String getOfferToken()
  {
    return this._offerId;
  }
  
  public HashMap<String, String> getPurchaseMetadata()
  {
    return this._purchaseMetadata;
  }
  
  public HashMap<String, String> getTrackingMetadata()
  {
    return this._trackingMetadata;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/persistence/RelatedManagedOfferData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */