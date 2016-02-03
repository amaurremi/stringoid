package com.flurry.sdk;

import android.content.Context;
import android.os.Looper;
import android.telephony.TelephonyManager;
import java.util.Arrays;

public class dy
{
  private static final String a = dy.class.getSimpleName();
  private static byte[] b;
  
  public static byte[] a()
  {
    try
    {
      if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
        throw new IllegalStateException("Must be called from a background thread!");
      }
    }
    finally {}
    byte[] arrayOfByte;
    if (b != null) {
      arrayOfByte = b;
    }
    for (;;)
    {
      return arrayOfByte;
      if (do.a().b().checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0)
      {
        arrayOfByte = null;
      }
      else
      {
        b();
        arrayOfByte = b;
      }
    }
  }
  
  private static void b()
  {
    Object localObject = (TelephonyManager)do.a().b().getSystemService("phone");
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((TelephonyManager)localObject).getDeviceId();
    } while ((localObject == null) || (((String)localObject).trim().length() <= 0));
    try
    {
      localObject = fe.d((String)localObject);
      if ((localObject != null) && (localObject.length == 20))
      {
        b = (byte[])localObject;
        return;
      }
    }
    catch (Exception localException)
    {
      eo.a(6, a, "Exception in generateHashedImei()");
      return;
    }
    eo.a(6, a, "sha1 is not " + 20 + " bytes long: " + Arrays.toString(localException));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/flurry/sdk/dy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */