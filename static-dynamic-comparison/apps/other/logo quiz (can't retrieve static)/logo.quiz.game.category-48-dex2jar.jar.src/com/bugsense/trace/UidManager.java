package com.bugsense.trace;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Random;

public class UidManager
{
  private static final char[] DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final int UID_CORRECT_LENTH = 32;
  private static final String UID_ERROR_ID = "12345678901234567890123456789012";
  private static final String UID_FIELD = "UID_FIELD";
  private static final String UID_NOSAVED = "UID_NOSAVED";
  private static final String UID_PREFERENCES = "UIDPREFERENCES";
  
  private static final char[] encodeHex(byte[] paramArrayOfByte)
  {
    int j = 0;
    int k = paramArrayOfByte.length;
    char[] arrayOfChar = new char[k << 1];
    int i = 0;
    while (i < k)
    {
      int m = j + 1;
      arrayOfChar[j] = DIGITS[((paramArrayOfByte[i] & 0xF0) >>> 4)];
      j = m + 1;
      arrayOfChar[m] = DIGITS[(paramArrayOfByte[i] & 0xF)];
      i += 1;
    }
    return arrayOfChar;
  }
  
  private static final String generateUid()
  {
    Object localObject1 = Long.valueOf(new Date().getTime()).toString();
    Object localObject2 = new Object().toString();
    long l = System.nanoTime();
    try
    {
      Thread.sleep(256L, 42);
      String str1 = Long.valueOf(System.nanoTime() - l).toString();
      String str2 = Integer.valueOf((int)(new Random(System.currentTimeMillis()).nextDouble() * 65535.0D)).toString();
      localObject2 = (String)localObject1 + (String)localObject2 + str1 + str2 + "android_id";
      localObject1 = null;
      try
      {
        localObject2 = ((String)localObject2).getBytes("UTF-8");
        localObject2 = MessageDigest.getInstance("MD5").digest((byte[])localObject2);
        localObject1 = localObject2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        for (;;)
        {
          localNoSuchAlgorithmException.printStackTrace();
        }
      }
      return new String(encodeHex((byte[])localObject1));
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  protected static final String getUid(Context paramContext)
  {
    Object localObject2;
    if ((G.UID != null) && (G.UID.length() == 32)) {
      localObject2 = G.UID;
    }
    do
    {
      return (String)localObject2;
      localObject2 = "12345678901234567890123456789012";
      localObject1 = localObject2;
      if (paramContext != null)
      {
        SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("UIDPREFERENCES", 0);
        localObject1 = localObject2;
        if (localSharedPreferences != null) {
          localObject1 = localSharedPreferences.getString("UID_FIELD", "UID_NOSAVED");
        }
      }
      if (((String)localObject1).equals("UID_NOSAVED")) {
        break;
      }
      localObject2 = localObject1;
    } while (!((String)localObject1).equals("12345678901234567890123456789012"));
    Object localObject1 = generateUid();
    saveUid(paramContext, (String)localObject1);
    return (String)localObject1;
  }
  
  protected static boolean saveUid(Context paramContext, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.length() == 32)
      {
        G.UID = paramString;
        paramContext = paramContext.getSharedPreferences("UIDPREFERENCES", 0);
        bool1 = bool2;
        if (paramContext != null) {
          bool1 = paramContext.edit().putString("UID_FIELD", paramString).commit();
        }
      }
    }
    return bool1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bugsense/trace/UidManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */