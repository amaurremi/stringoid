package com.getjar.sdk.comm.persistence;

import com.getjar.sdk.utilities.StringUtility;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class RelatedEarnData
  implements Serializable
{
  private static final long serialVersionUID = -7091798013980336693L;
  private String _itemId;
  private HashMap<String, String> _itemMetadata;
  private String _packageName;
  private HashMap<String, String> _trackingMetadata;
  
  public RelatedEarnData() {}
  
  public RelatedEarnData(String paramString1, String paramString2, HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2)
  {
    this._itemId = paramString1;
    this._packageName = paramString2;
    this._itemMetadata = paramHashMap1;
    this._trackingMetadata = paramHashMap2;
    validateObjectState();
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    this._itemId = paramObjectInputStream.readUTF();
    this._packageName = paramObjectInputStream.readUTF();
    this._itemMetadata = ((HashMap)paramObjectInputStream.readObject());
    this._trackingMetadata = ((HashMap)paramObjectInputStream.readObject());
  }
  
  private void validateObjectState()
  {
    if (StringUtility.isNullOrEmpty(this._itemId)) {
      throw new IllegalStateException("'itemId' can not be NULL or empty");
    }
    if (StringUtility.isNullOrEmpty(this._packageName)) {
      throw new IllegalStateException("'packageName' can not be NULL or empty");
    }
    if ((this._itemMetadata == null) || (this._itemMetadata.size() <= 0)) {
      throw new IllegalStateException("'itemMetadata' can not be NULL or empty");
    }
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeUTF(this._itemId);
    paramObjectOutputStream.writeUTF(this._packageName);
    paramObjectOutputStream.writeObject(this._itemMetadata);
    paramObjectOutputStream.writeObject(this._trackingMetadata);
  }
  
  public String getItemId()
  {
    return this._itemId;
  }
  
  public HashMap<String, String> getItemMetadata()
  {
    return this._itemMetadata;
  }
  
  public String getPackageName()
  {
    return this._packageName;
  }
  
  public HashMap<String, String> getTrackingMetadata()
  {
    return this._trackingMetadata;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/persistence/RelatedEarnData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */