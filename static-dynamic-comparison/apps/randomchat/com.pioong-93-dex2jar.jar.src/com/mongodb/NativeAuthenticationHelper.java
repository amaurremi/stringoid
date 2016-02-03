package com.mongodb;

import com.mongodb.util.Util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

class NativeAuthenticationHelper
{
  static byte[] createHash(String paramString, char[] paramArrayOfChar)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramString.length() + 20 + paramArrayOfChar.length);
    for (;;)
    {
      int i;
      try
      {
        localByteArrayOutputStream.write(paramString.getBytes());
        localByteArrayOutputStream.write(":mongo:".getBytes());
        int j = paramArrayOfChar.length;
        i = 0;
        if (i >= j) {
          break;
        }
        k = paramArrayOfChar[i];
        if (k >= 128) {
          throw new IllegalArgumentException("can't handle non-ascii passwords yet");
        }
      }
      catch (IOException paramString)
      {
        throw new RuntimeException("impossible", paramString);
      }
      int k = (byte)k;
      localByteArrayOutputStream.write(k);
      i += 1;
    }
    return Util.hexMD5(localByteArrayOutputStream.toByteArray()).getBytes();
  }
  
  static DBObject getAuthCommand(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    paramArrayOfByte = paramString2 + paramString1 + new String(paramArrayOfByte);
    BasicDBObject localBasicDBObject = new BasicDBObject();
    localBasicDBObject.put("authenticate", Integer.valueOf(1));
    localBasicDBObject.put("user", paramString1);
    localBasicDBObject.put("nonce", paramString2);
    localBasicDBObject.put("key", Util.hexMD5(paramArrayOfByte.getBytes()));
    return localBasicDBObject;
  }
  
  static DBObject getAuthCommand(String paramString1, char[] paramArrayOfChar, String paramString2)
  {
    return getAuthCommand(paramString1, createHash(paramString1, paramArrayOfChar), paramString2);
  }
  
  static BasicDBObject getNonceCommand()
  {
    return new BasicDBObject("getnonce", Integer.valueOf(1));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/NativeAuthenticationHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */