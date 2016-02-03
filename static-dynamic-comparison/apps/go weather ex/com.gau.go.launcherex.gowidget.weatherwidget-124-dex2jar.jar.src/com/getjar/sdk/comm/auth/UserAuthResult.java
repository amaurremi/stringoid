package com.getjar.sdk.comm.auth;

import com.getjar.sdk.config.SettingsValue;
import com.getjar.sdk.utilities.StringUtility;
import java.util.Map;

public class UserAuthResult
  extends AuthResult
{
  private final boolean _isNewUser;
  private final String _userAccessId;
  private final String _userDeviceId;
  
  public UserAuthResult(String paramString, AuthResult.State paramState)
  {
    super(paramString, paramState);
    this._userAccessId = null;
    this._userDeviceId = null;
    this._isNewUser = false;
  }
  
  public UserAuthResult(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, Map<String, String> paramMap, Map<String, SettingsValue> paramMap1, long paramLong1, long paramLong2)
  {
    super(paramString1, paramString4, paramMap, paramMap1, paramLong1, paramLong2);
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("the user acess id is required");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("the user device id is required");
    }
    this._userAccessId = paramString2;
    this._userDeviceId = paramString3;
    this._isNewUser = paramBoolean;
  }
  
  public String getUserAccessId()
  {
    return this._userAccessId;
  }
  
  public String getUserDeviceId()
  {
    return this._userDeviceId;
  }
  
  public boolean isNewUser()
  {
    return this._isNewUser;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/auth/UserAuthResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */