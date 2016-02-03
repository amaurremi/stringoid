package com.getjar.sdk.config;

import com.getjar.sdk.utilities.StringUtility;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SettingsValue
  implements Serializable
{
  private static final long serialVersionUID = 6297419565666938543L;
  private long expiresOn;
  private SettingsManager.Scope scope;
  private long ttl;
  private String type;
  private String value;
  
  private SettingsValue() {}
  
  public SettingsValue(String paramString1, String paramString2, SettingsManager.Scope paramScope)
  {
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("'type' cannot be null or empty");
    }
    this.type = paramString2;
    paramString2 = paramString1;
    if (paramString1 == null) {
      paramString2 = "";
    }
    this.value = paramString2;
    this.scope = paramScope;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException
  {
    this.type = paramObjectInputStream.readUTF();
    this.value = paramObjectInputStream.readUTF();
    this.scope = SettingsManager.Scope.valueOf(paramObjectInputStream.readUTF());
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeUTF(this.type);
    paramObjectOutputStream.writeUTF(this.value);
    paramObjectOutputStream.writeUTF(this.scope.name());
  }
  
  protected long getExpiresOn()
  {
    return this.expiresOn;
  }
  
  protected SettingsManager.Scope getScope()
  {
    return this.scope;
  }
  
  protected long getTtl()
  {
    return this.ttl;
  }
  
  protected String getType()
  {
    return this.type;
  }
  
  protected String getValue()
  {
    return this.value;
  }
  
  protected void setExpiresOn(long paramLong)
  {
    this.expiresOn = paramLong;
  }
  
  protected void setTtl(long paramLong)
  {
    this.ttl = paramLong;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/config/SettingsValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */