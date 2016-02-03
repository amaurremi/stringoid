package com.getjar.sdk.data;

import android.content.Context;
import com.getjar.sdk.rewards.InAppPurchaseManager;
import com.getjar.sdk.utilities.StringUtility;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class GooglePurchaseResponse
  implements Serializable
{
  private static final long serialVersionUID = -8955118537657295608L;
  private String developerPayload;
  private String notificationId;
  private String orderId;
  private String productId;
  private short purchaseState;
  private String signature;
  private String signedData;
  
  public GooglePurchaseResponse(String paramString1, String paramString2, String paramString3, short paramShort, String paramString4, String paramString5, String paramString6)
  {
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("notificationId cannot be empty or null");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("orderId cannot be empty or null");
    }
    if (StringUtility.isNullOrEmpty(paramString3)) {
      throw new IllegalArgumentException("productId cannot be empty or null");
    }
    if (StringUtility.isNullOrEmpty(paramString5)) {
      throw new IllegalArgumentException("signedData cannot be empty or null");
    }
    if (StringUtility.isNullOrEmpty(paramString6)) {
      throw new IllegalArgumentException("signature cannot be empty or null");
    }
    this.notificationId = paramString1;
    this.orderId = paramString2;
    this.productId = paramString3;
    this.purchaseState = paramShort;
    this.developerPayload = paramString4;
    this.signature = paramString6;
    this.signedData = paramString5;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    this.notificationId = paramObjectInputStream.readUTF();
    this.orderId = paramObjectInputStream.readUTF();
    this.productId = paramObjectInputStream.readUTF();
    this.purchaseState = paramObjectInputStream.readShort();
    this.developerPayload = paramObjectInputStream.readUTF();
    this.signedData = paramObjectInputStream.readUTF();
    this.signature = paramObjectInputStream.readUTF();
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeUTF(this.notificationId);
    paramObjectOutputStream.writeUTF(this.orderId);
    paramObjectOutputStream.writeUTF(this.productId);
    paramObjectOutputStream.writeShort(this.purchaseState);
    if (StringUtility.isNullOrEmpty(this.developerPayload)) {
      this.developerPayload = "";
    }
    paramObjectOutputStream.writeUTF(this.developerPayload);
    paramObjectOutputStream.writeUTF(this.signedData);
    paramObjectOutputStream.writeUTF(this.signature);
  }
  
  public String getDeveloperPayload()
  {
    return this.developerPayload;
  }
  
  public String getNotificationId()
  {
    return this.notificationId;
  }
  
  public String getOrderId()
  {
    return this.orderId;
  }
  
  public String getProductId()
  {
    return this.productId;
  }
  
  public short getPurchaseState()
  {
    return this.purchaseState;
  }
  
  public Map<String, String> getResponseAsMap(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(InAppPurchaseManager.getGoldBucketDetails(this.productId, paramContext));
    localHashMap.put("order.google_play.signed_data", this.signedData);
    localHashMap.put("order.google_play.signature", this.signature);
    return localHashMap;
  }
  
  public String getSignature()
  {
    return this.signature;
  }
  
  public String getSignedData()
  {
    return this.signedData;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/GooglePurchaseResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */