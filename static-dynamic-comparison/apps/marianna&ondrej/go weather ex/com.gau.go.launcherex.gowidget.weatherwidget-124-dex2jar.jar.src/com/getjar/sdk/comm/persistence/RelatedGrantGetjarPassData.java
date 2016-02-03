package com.getjar.sdk.comm.persistence;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class RelatedGrantGetjarPassData
  implements Serializable
{
  private static final long serialVersionUID = -222128530582135557L;
  private HashMap<String, String> _purchaseMetadata;
  
  public RelatedGrantGetjarPassData() {}
  
  public RelatedGrantGetjarPassData(HashMap<String, String> paramHashMap)
  {
    if ((paramHashMap == null) || (paramHashMap.isEmpty())) {
      throw new IllegalArgumentException("'purchaseMetadata' cannot be NULL or empty");
    }
    this._purchaseMetadata = paramHashMap;
    this._purchaseMetadata.put("marketplace", "marketplace.google_play");
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    this._purchaseMetadata = ((HashMap)paramObjectInputStream.readObject());
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeObject(this._purchaseMetadata);
  }
  
  public HashMap<String, String> getPurchaseMetadata()
  {
    return this._purchaseMetadata;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/persistence/RelatedGrantGetjarPassData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */