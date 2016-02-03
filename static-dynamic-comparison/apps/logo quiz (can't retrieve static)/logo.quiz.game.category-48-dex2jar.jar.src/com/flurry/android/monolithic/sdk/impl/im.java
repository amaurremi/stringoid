package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.util.Arrays;

public class im
{
  private static final String a = im.class.getSimpleName();
  private static byte[] b;
  
  public static byte[] a()
  {
    if (b != null) {
      return b;
    }
    if (ia.a().b().checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
      return null;
    }
    b();
    return b;
  }
  
  private static void b()
  {
    Object localObject = (TelephonyManager)ia.a().b().getSystemService("phone");
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((TelephonyManager)localObject).getDeviceId();
    } while ((localObject == null) || (((String)localObject).trim().length() <= 0));
    try
    {
      localObject = je.d((String)localObject);
      if ((localObject != null) && (localObject.length == 20))
      {
        b = (byte[])localObject;
        return;
      }
    }
    catch (Exception localException)
    {
      ja.a(6, a, "Exception in generateHashedImei()");
      return;
    }
    ja.a(6, a, "sha1 is not " + 20 + " bytes long: " + Arrays.toString(localException));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/im.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */