package com.skplanet.tad.common;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.skplanet.tad.protocol.AdInAppResponseRich;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Hashtable;
import java.util.Locale;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  private static b m = null;
  public c a = new c();
  public a b = new a();
  public String c = "3.1.1.6";
  public String d = null;
  public String e = null;
  public String f = null;
  public String g = null;
  public Location h = null;
  public String i = "http://ad.adotsolution.com:15000/inapp/ad_request";
  public String j = "http://event.adotsolution.com:16000/logger";
  LocationListener k = new LocationListener()
  {
    public void onLocationChanged(Location paramAnonymousLocation)
    {
      a.c("AdSdkContext.onLocationChanged:" + paramAnonymousLocation.getLatitude());
      b.a(b.this, paramAnonymousLocation);
      b.this.d();
    }
    
    public void onProviderDisabled(String paramAnonymousString)
    {
      a.c("AdSdkContext.onProviderDisabled:" + paramAnonymousString);
      b.this.d();
    }
    
    public void onProviderEnabled(String paramAnonymousString) {}
    
    public void onStatusChanged(String paramAnonymousString, int paramAnonymousInt, Bundle paramAnonymousBundle) {}
  };
  private Context l;
  private String n = null;
  private Object o = new Object();
  private int p = -1;
  private Object q = new Object();
  private LocationManager r;
  private int s = 0;
  private Object t = new Object();
  private Object u = new Object();
  
  private b(Context paramContext)
  {
    this.l = paramContext;
    n();
    m();
    j();
    a.c("AdSdkContext.constructor, TermsState : " + a());
    o();
  }
  
  public static b a(Context paramContext)
  {
    try
    {
      if (m == null) {
        m = new b(paramContext);
      }
      paramContext = m;
      return paramContext;
    }
    finally {}
  }
  
  private void a(Location paramLocation)
  {
    synchronized (this.u)
    {
      this.h = paramLocation;
      return;
    }
  }
  
  private SecretKey b(String paramString)
    throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException
  {
    paramString = new DESKeySpec(paramString.getBytes());
    return SecretKeyFactory.getInstance("DES").generateSecret(paramString);
  }
  
  private void m()
  {
    int i2;
    int i1;
    try
    {
      arrayOfActivityInfo = this.l.getPackageManager().getPackageInfo(this.l.getPackageName(), 1).activities;
      i2 = arrayOfActivityInfo.length;
      i1 = 0;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      ActivityInfo[] arrayOfActivityInfo;
      ActivityInfo localActivityInfo;
      localNameNotFoundException.printStackTrace();
      return;
    }
    localActivityInfo = arrayOfActivityInfo[i1];
    if (localActivityInfo.name.equals("com.skplanet.tad.AdActivity")) {
      this.b.a = true;
    } else if (localActivityInfo.name.equals("com.skplanet.tad.AdVideoPlayer")) {
      this.b.b = true;
    }
    while (i1 >= i2)
    {
      return;
      i1 += 1;
    }
  }
  
  private void n()
  {
    if (this.l.checkCallingOrSelfPermission("android.permission.INTERNET") != 0)
    {
      a.b("android.permission.INTERNET permission must be added in AndroidManifest.xml");
      this.a.a = false;
    }
    if (this.l.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0)
    {
      a.b("android.permission.ACCESS_COARSE_LOCATION permission must be added in AndroidManifest.xml");
      this.a.b = false;
    }
    if (this.l.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0)
    {
      a.b("android.permission.ACCESS_NETWORK_STATE permission must be added in AndroidManifest.xml");
      this.a.c = false;
    }
    if (this.l.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0)
    {
      a.b("android.permission.READ_PHONE_STATE permission must be added in AndroidManifest.xml");
      this.a.d = false;
    }
    if (this.l.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
    {
      a.b("android.permission.WRITE_EXTERNAL_STORAGE permission must be added in AndroidManifest.xml");
      this.a.e = false;
    }
  }
  
  private void o()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)this.l.getSystemService("phone");
    if ((localTelephonyManager != null) && (this.a.d))
    {
      this.d = localTelephonyManager.getNetworkOperator();
      this.e = localTelephonyManager.getLine1Number();
    }
    this.f = p();
    this.g = this.l.getResources().getConfiguration().locale.toString();
    e();
  }
  
  private String p()
  {
    String str1 = Settings.Secure.getString(this.l.getContentResolver(), "android_id");
    if ((!str1.equals("")) && (!str1.equals("9774d56d682e549c"))) {
      return UUID.nameUUIDFromBytes(str1.getBytes()).toString();
    }
    Object localObject = (TelephonyManager)this.l.getSystemService("phone");
    String str2 = ((TelephonyManager)localObject).getDeviceId();
    localObject = ((TelephonyManager)localObject).getSimSerialNumber();
    if ((!str2.equals("")) && (!((String)localObject).equals(""))) {
      return new UUID(str1.hashCode(), str2.hashCode() << 32 | ((String)localObject).hashCode()).toString();
    }
    return UUID.randomUUID().toString();
  }
  
  public int a()
  {
    synchronized (this.q)
    {
      int i1 = this.p;
      return i1;
    }
  }
  
  public Object a(JSONObject paramJSONObject, Class paramClass)
    throws InstantiationException, IllegalAccessException
  {
    Field[] arrayOfField = (Field[])null;
    arrayOfField = paramClass.getDeclaredFields();
    paramClass = paramClass.newInstance();
    int i1 = 0;
    for (;;)
    {
      if (i1 >= arrayOfField.length) {
        return paramClass;
      }
      Field localField = arrayOfField[i1];
      str1 = localField.getName();
      str2 = localField.getType().toString();
      for (;;)
      {
        try
        {
          if (!str2.equals("int")) {
            continue;
          }
          str1 = paramJSONObject.getString(str1).toLowerCase();
        }
        catch (JSONException localJSONException)
        {
          a.d("AdSdkContext.getFromJSON");
          continue;
          if (!str2.equals("class java.lang.String")) {
            continue;
          }
          localJSONException.set(paramClass, paramJSONObject.getString(str1));
          continue;
          if (!str2.equals("class com.skplanet.tad.protocol.AdInAppResponseRich")) {
            continue;
          }
          localJSONException.set(paramClass, (AdInAppResponseRich)a(new JSONObject(paramJSONObject.getString(str1)), AdInAppResponseRich.class));
          continue;
        }
        try
        {
          localField.set(paramClass, Integer.valueOf(Integer.parseInt(str1)));
          i1 += 1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          a.d("AdSdkContext.getfromJSON, NumberFormatException");
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    synchronized (this.q)
    {
      a.c("setTermsState, before(" + this.p + "), after(" + paramInt + ")");
      this.p = paramInt;
      return;
    }
  }
  
  public boolean a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      try
      {
        if ((paramString.substring(0, 2).equals("AX")) || (paramString.substring(0, 2).equals("TV")) || (paramString.substring(0, 2).equals("TL"))) {
          if (paramString.length() < 0)
          {
            int i1 = paramString.length();
            if (i1 > 9) {}
          }
          else
          {
            return true;
          }
        }
      }
      catch (Exception localException)
      {
        a.d("AdSdkContext.checkClientIdValidation(), clientId : " + paramString);
      }
    }
    return false;
  }
  
  public boolean b()
  {
    synchronized (this.q)
    {
      return this.p > 0;
    }
  }
  
  public boolean b(int paramInt)
  {
    for (;;)
    {
      synchronized (this.q)
      {
        if ((this.p & paramInt) > 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void c()
  {
    synchronized (this.t)
    {
      if ((b(4)) && (this.a.b))
      {
        a.c("AdSdkContext.registerLocation,  mLocationRefCount : " + this.s);
        if (this.s == 0) {
          this.r = ((LocationManager)this.l.getSystemService("location"));
        }
      }
      try
      {
        this.r.requestLocationUpdates("network", 0L, 0.0F, this.k);
        this.s += 1;
        return;
      }
      catch (Throwable localThrowable)
      {
        a.d("AdSdkContext.registerLocation, requestLocationUpdates error, " + localThrowable);
        return;
      }
    }
  }
  
  public void d()
  {
    synchronized (this.t)
    {
      a.c("AdSdkContext.unRegisterLocation,  mLocationRefCount : " + this.s);
      if (this.s > 0)
      {
        this.s -= 1;
        if (this.s == 0) {
          this.r.removeUpdates(this.k);
        }
      }
      return;
    }
  }
  
  public void e()
  {
    synchronized (this.o)
    {
      if ((b(2)) && (b(1)) && (this.a.d))
      {
        this.n = g();
        return;
      }
      this.n = null;
    }
  }
  
  public String f()
  {
    synchronized (this.o)
    {
      String str = this.n;
      return str;
    }
  }
  
  public String g()
  {
    String str = this.e;
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    try
    {
      str = new b(b("nasanghy")).a(str);
      return str;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public boolean h()
  {
    return (this.a != null) && (this.a.a) && (this.a.e);
  }
  
  public boolean i()
  {
    return (this.b != null) && (this.b.a) && (this.b.b);
  }
  
  public void j()
  {
    try
    {
      k();
      a.c(a());
      if (a() < 0) {
        l();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public int k()
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokevirtual 117	com/skplanet/tad/common/b:a	()I
    //   8: istore_1
    //   9: iload_1
    //   10: iconst_m1
    //   11: if_icmpne +135 -> 146
    //   14: invokestatic 478	com/skplanet/tad/common/e:a	()Lcom/skplanet/tad/common/e;
    //   17: invokevirtual 481	com/skplanet/tad/common/e:b	()Lcom/skplanet/tad/common/c;
    //   20: astore_3
    //   21: aload_3
    //   22: ifnonnull +7 -> 29
    //   25: aload_0
    //   26: monitorexit
    //   27: iload_2
    //   28: ireturn
    //   29: aload_3
    //   30: invokevirtual 485	com/skplanet/tad/common/c:a	()Ljava/lang/String;
    //   33: astore 4
    //   35: iload_2
    //   36: istore_1
    //   37: aload 4
    //   39: ifnull +22 -> 61
    //   42: iload_2
    //   43: istore_1
    //   44: aload_3
    //   45: invokevirtual 485	com/skplanet/tad/common/c:a	()Ljava/lang/String;
    //   48: invokestatic 373	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   51: istore_2
    //   52: iload_2
    //   53: istore_1
    //   54: aload_0
    //   55: iload_2
    //   56: invokevirtual 487	com/skplanet/tad/common/b:a	(I)V
    //   59: iload_2
    //   60: istore_1
    //   61: aload_3
    //   62: invokevirtual 489	com/skplanet/tad/common/c:b	()Ljava/lang/String;
    //   65: astore 4
    //   67: aload 4
    //   69: ifnull +13 -> 82
    //   72: aload_3
    //   73: invokevirtual 489	com/skplanet/tad/common/c:b	()Ljava/lang/String;
    //   76: invokestatic 373	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   79: invokestatic 490	com/skplanet/tad/common/a:a	(I)V
    //   82: aload_3
    //   83: invokevirtual 492	com/skplanet/tad/common/c:c	()Ljava/lang/String;
    //   86: ifnull +11 -> 97
    //   89: aload_0
    //   90: aload_3
    //   91: invokevirtual 492	com/skplanet/tad/common/c:c	()Ljava/lang/String;
    //   94: putfield 82	com/skplanet/tad/common/b:i	Ljava/lang/String;
    //   97: iload_1
    //   98: istore_2
    //   99: aload_3
    //   100: invokevirtual 494	com/skplanet/tad/common/c:d	()Ljava/lang/String;
    //   103: ifnull -78 -> 25
    //   106: aload_0
    //   107: aload_3
    //   108: invokevirtual 494	com/skplanet/tad/common/c:d	()Ljava/lang/String;
    //   111: putfield 86	com/skplanet/tad/common/b:j	Ljava/lang/String;
    //   114: iload_1
    //   115: istore_2
    //   116: goto -91 -> 25
    //   119: astore_3
    //   120: aload_0
    //   121: monitorexit
    //   122: aload_3
    //   123: athrow
    //   124: astore 4
    //   126: ldc_w 496
    //   129: invokestatic 385	com/skplanet/tad/common/a:d	(Ljava/lang/String;)V
    //   132: goto -71 -> 61
    //   135: astore 4
    //   137: ldc_w 498
    //   140: invokestatic 385	com/skplanet/tad/common/a:d	(Ljava/lang/String;)V
    //   143: goto -61 -> 82
    //   146: iload_1
    //   147: istore_2
    //   148: goto -123 -> 25
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	b
    //   8	139	1	i1	int
    //   1	147	2	i2	int
    //   20	88	3	localc	c
    //   119	4	3	localObject	Object
    //   33	35	4	str	String
    //   124	1	4	localNumberFormatException1	NumberFormatException
    //   135	1	4	localNumberFormatException2	NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   4	9	119	finally
    //   14	21	119	finally
    //   29	35	119	finally
    //   44	52	119	finally
    //   54	59	119	finally
    //   61	67	119	finally
    //   72	82	119	finally
    //   82	97	119	finally
    //   99	114	119	finally
    //   126	132	119	finally
    //   137	143	119	finally
    //   44	52	124	java/lang/NumberFormatException
    //   54	59	124	java/lang/NumberFormatException
    //   72	82	135	java/lang/NumberFormatException
  }
  
  public void l()
  {
    String str2 = null;
    for (;;)
    {
      try
      {
        Hashtable localHashtable = d.a().a(this.l);
        if (localHashtable == null) {
          break label114;
        }
        String str1 = (String)localHashtable.get(d.a.c.toString());
        str2 = (String)localHashtable.get(d.a.e.toString());
        if ((str1 != null) && (str1.length() > 0) && (str2 != null) && (str2.equals("T")))
        {
          a(7);
          return;
        }
        if ((str1 != null) && (str1.length() > 0))
        {
          a(15);
          continue;
        }
        a(0);
      }
      finally {}
      continue;
      label114:
      Object localObject2 = null;
    }
  }
  
  public class a
  {
    public boolean a = false;
    public boolean b = false;
    
    public a() {}
  }
  
  class b
  {
    final String a = "DES/ECB/PKCS5Padding";
    Cipher b = Cipher.getInstance("DES/ECB/PKCS5Padding");
    
    b(SecretKey paramSecretKey)
      throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException
    {
      this.b.init(1, paramSecretKey);
    }
    
    public String a(String paramString)
    {
      try
      {
        paramString = paramString.getBytes();
        paramString = new String(a(this.b.doFinal(paramString)));
        return paramString;
      }
      catch (Exception paramString) {}
      return null;
    }
    
    public byte[] a(byte[] paramArrayOfByte)
    {
      byte[] arrayOfByte = (byte[])null;
      try
      {
        Class localClass = Class.forName("org.apache.commons.codec.binary.Base64");
        paramArrayOfByte = (byte[])localClass.getMethod("encodeBase64", new Class[] { byte[].class }).invoke(localClass, new Object[] { paramArrayOfByte });
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte) {}
      return arrayOfByte;
    }
  }
  
  public class c
  {
    public boolean a = true;
    public boolean b = true;
    public boolean c = true;
    public boolean d = true;
    public boolean e = true;
    
    public c() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/common/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */