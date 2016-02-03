package com.getjar.sdk.comm.persistence;

import com.getjar.sdk.GetjarLicense.Scope;
import com.getjar.sdk.utilities.StringUtility;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class RelatedPurchaseData
  implements Serializable
{
  private static final long serialVersionUID = 1387628907828312943L;
  private Integer _amount;
  private GetjarLicense.Scope _licenseScope = null;
  private String _productDescription = "";
  private String _productId = "";
  private String _productName = "";
  private HashMap<String, String> _trackingMetadata = new HashMap();
  
  public RelatedPurchaseData() {}
  
  public RelatedPurchaseData(String paramString1, String paramString2, String paramString3, int paramInt, GetjarLicense.Scope paramScope, HashMap<String, String> paramHashMap)
  {
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("'productId' cannot be null or empty");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("'productName' cannot be null or empty");
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("'amount' cannot be less than 0");
    }
    this._productId = paramString1;
    this._productName = paramString2;
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    this._productDescription = paramString1;
    this._amount = Integer.valueOf(paramInt);
    if (paramHashMap != null) {
      this._trackingMetadata = paramHashMap;
    }
    this._licenseScope = paramScope;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    this._amount = Integer.valueOf(paramObjectInputStream.readInt());
    this._productDescription = paramObjectInputStream.readUTF();
    this._productId = paramObjectInputStream.readUTF();
    this._productName = paramObjectInputStream.readUTF();
    this._trackingMetadata = ((HashMap)paramObjectInputStream.readObject());
    paramObjectInputStream = paramObjectInputStream.readUTF();
    if (!StringUtility.isNullOrEmpty(paramObjectInputStream)) {}
    for (this._licenseScope = GetjarLicense.Scope.valueOf(paramObjectInputStream);; this._licenseScope = null)
    {
      validateObjectState();
      return;
    }
  }
  
  private void validateObjectState()
  {
    if ((this._amount == null) || (this._amount.intValue() < 0)) {
      throw new IllegalStateException("'amount' can not be NULL or less than 0");
    }
    if (StringUtility.isNullOrEmpty(this._productId)) {
      throw new IllegalStateException("'productId' can not be NULL or empty");
    }
    if (StringUtility.isNullOrEmpty(this._productName)) {
      throw new IllegalStateException("'productName' can not be NULL or empty");
    }
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeInt(this._amount.intValue());
    paramObjectOutputStream.writeUTF(this._productDescription);
    paramObjectOutputStream.writeUTF(this._productId);
    paramObjectOutputStream.writeUTF(this._productName);
    paramObjectOutputStream.writeObject(this._trackingMetadata);
    if (this._licenseScope != null)
    {
      paramObjectOutputStream.writeUTF(this._licenseScope.name());
      return;
    }
    paramObjectOutputStream.writeUTF("");
  }
  
  public Integer getAmount()
  {
    return this._amount;
  }
  
  public GetjarLicense.Scope getLicenseScope()
  {
    return this._licenseScope;
  }
  
  public String getProductDescription()
  {
    return this._productDescription;
  }
  
  public String getProductId()
  {
    return this._productId;
  }
  
  public String getProductName()
  {
    return this._productName;
  }
  
  public HashMap<String, String> getTrackingMetadata()
  {
    return this._trackingMetadata;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/persistence/RelatedPurchaseData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */