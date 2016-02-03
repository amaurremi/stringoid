package com.getjar.sdk.utilities;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class CryptoUtility
{
  public static String getSHA256(String paramString)
    throws NoSuchAlgorithmException, UnsupportedEncodingException
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'input' cannot be NULL or empty");
    }
    MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
    localMessageDigest.reset();
    return Base64.encodeBytes(localMessageDigest.digest(paramString.getBytes("UTF-8")));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/utilities/CryptoUtility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */