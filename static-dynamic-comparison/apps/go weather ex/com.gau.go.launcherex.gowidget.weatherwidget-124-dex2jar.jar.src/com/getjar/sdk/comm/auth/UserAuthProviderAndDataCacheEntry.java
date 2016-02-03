package com.getjar.sdk.comm.auth;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;

public class UserAuthProviderAndDataCacheEntry
  implements Serializable
{
  private static final long serialVersionUID = -6814393690712845165L;
  private HashMap<String, String> _cachedProviderData = null;
  private Class<? extends UserAuthProvider> _userAuthProviderType = null;
  
  public UserAuthProviderAndDataCacheEntry() {}
  
  public UserAuthProviderAndDataCacheEntry(Class<? extends UserAuthProvider> paramClass, HashMap<String, String> paramHashMap)
  {
    this._userAuthProviderType = paramClass;
    this._cachedProviderData = paramHashMap;
    validateObjectState();
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    this._userAuthProviderType = ((Class)paramObjectInputStream.readObject());
    this._cachedProviderData = ((HashMap)paramObjectInputStream.readObject());
    validateObjectState();
  }
  
  private void validateObjectState()
  {
    if (this._userAuthProviderType == null) {
      throw new IllegalArgumentException("'userAuthProviderType' can not be NULL");
    }
    if (!UserAuthProvider.class.isAssignableFrom(this._userAuthProviderType)) {
      throw new IllegalArgumentException(String.format(Locale.US, "'userAuthProviderType' must implement UserAuthProviderInterface [type:%1$s]", new Object[] { this._userAuthProviderType.getName() }));
    }
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeObject(this._userAuthProviderType);
    paramObjectOutputStream.writeObject(this._cachedProviderData);
  }
  
  public HashMap<String, String> getCachedProviderData()
  {
    return this._cachedProviderData;
  }
  
  public Class<? extends UserAuthProvider> getUserAuthProviderType()
  {
    return this._userAuthProviderType;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/auth/UserAuthProviderAndDataCacheEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */