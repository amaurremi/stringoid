package com.getjar.sdk.comm.persistence;

import com.getjar.sdk.utilities.StringUtility;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class RelatedConfirmVoucherData
  implements Serializable
{
  private static final long serialVersionUID = -8588857533701730856L;
  private String voucherToken;
  
  public RelatedConfirmVoucherData() {}
  
  public RelatedConfirmVoucherData(String paramString)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'voucherToken' cannot be NULL or empty");
    }
    this.voucherToken = paramString;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    this.voucherToken = paramObjectInputStream.readUTF();
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeUTF(this.voucherToken);
  }
  
  public String getVoucherToken()
  {
    return this.voucherToken;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/persistence/RelatedConfirmVoucherData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */