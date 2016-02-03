package com.mapbar.android.location;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.zip.DeflaterOutputStream;

public final class b
{
  private static long a = 15000L;
  private static long b = 5000L;
  private static long c = 60000L;
  private static short d = 1000;
  private static b v;
  private boolean e;
  private int f;
  private long g;
  private Context h;
  private Hashtable<String, LocationListener> i;
  private Location j;
  private long k;
  private TelephonyManager l;
  private WifiManager m;
  private String n;
  private String o;
  private String p;
  private int q;
  private int r;
  private Vector<b> s = new Vector();
  private Hashtable<String, d> t = new Hashtable();
  private c u = new c();
  private Handler w = new c(this);
  private a x = null;
  private PhoneStateListener y;
  
  private b(Context paramContext)
  {
    new d(this);
    new e(this);
    this.y = new f(this);
    this.h = paramContext;
    this.e = false;
    this.j = null;
    this.k = 0L;
    this.q = 0;
    this.i = new Hashtable();
  }
  
  public static int a()
  {
    return 2;
  }
  
  public static b a(Context paramContext)
  {
    if (v == null) {
      v = new b(paramContext);
    }
    v.h = paramContext;
    return v;
  }
  
  private static String a(String paramString, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localStringBuilder.append(e("\b\026goLOMdv\004\005\016vl\005N\017ro\024\001\020=|\031\rMcp\005\t\026zp\030O]t}KPP5k\006]S 9\025\b_fk\020MZ5v\025\024_!9\035\005\033.")).append(URLEncoder.encode(paramString, e("\025\026u2N"))).append("&idx=").append(paramInt1);
      return localStringBuilder.toString();
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
  }
  
  private static void a(List<NeighboringCellInfo> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramList != null) && (paramList.size() > 0)) {
      for (;;)
      {
        try
        {
          paramList = paramList.iterator();
          if (paramList.hasNext()) {
            localNeighboringCellInfo = (NeighboringCellInfo)paramList.next();
          }
        }
        catch (Exception paramList)
        {
          NeighboringCellInfo localNeighboringCellInfo;
          Object localObject;
          paramList.printStackTrace();
        }
        try
        {
          localObject = localNeighboringCellInfo.getClass();
          if (localObject == null) {
            break label193;
          }
          localObject = ((Class)localObject).getMethod("getLac", null);
          if (localObject == null) {
            break label193;
          }
          localObject = ((Method)localObject).invoke(localNeighboringCellInfo, null);
          if (localObject == null) {
            break label193;
          }
          i1 = ((Integer)localObject).intValue();
        }
        catch (Exception localException)
        {
          i1 = -1;
          continue;
          i1 = -1;
          continue;
        }
        if ((i1 >= 0) && (localNeighboringCellInfo.getCid() >= 0)) {
          localStringBuilder.append(l.k).append(",").append(l.l).append(",").append(i1).append(",").append(localNeighboringCellInfo.getCid()).append(",").append(localNeighboringCellInfo.getRssi()).append("|");
        }
      }
    }
    l.v = localStringBuilder.toString();
  }
  
  public static String b()
  {
    return "cell";
  }
  
  private static String b(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (paramString != null)
    {
      str1 = str2;
      if (paramString.length() <= 0) {}
    }
    try
    {
      int i1 = paramString.indexOf("|");
      str1 = str2;
      if (i1 > 0) {
        str1 = paramString.substring(0, i1);
      }
      return str1;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public static int c()
  {
    return 1;
  }
  
  private void c(final String paramString)
  {
    int i1;
    for (;;)
    {
      try
      {
        boolean bool = b.a(paramString);
        if (bool) {
          continue;
        }
      }
      catch (Exception localException)
      {
        try
        {
          localt = new t(this.h, 3, 0);
          this.q += 1;
          localt.a(a(paramString, this.q, 2));
          localt.a(this.q);
          localt.a(new f());
          localt.a(new e(paramString));
          this.s.add(new b(localt, paramString));
          localt.a(new Object[0]);
        }
        catch (Exception paramString) {}
        continue;
      }
      finally {}
      return;
      i1 = this.s.size();
      if (i1 > 0) {
        if (!paramString.equals(((b)this.s.get(i1 - 1)).b)) {
          break;
        }
      }
    }
    for (;;)
    {
      if (i1 >= 0)
      {
        ((b)this.s.get(i1)).a.a(true);
        this.s.remove(i1);
        i1 -= 1;
      }
      else
      {
        t localt;
        i1 -= 1;
      }
    }
  }
  
  /* Error */
  private static Location d(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +170 -> 171
    //   4: aload_0
    //   5: ldc_w 353
    //   8: invokestatic 434	com/mapbar/android/location/h:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Vector;
    //   11: invokestatic 437	com/mapbar/android/location/h:a	(Ljava/util/Vector;)Ljava/util/Vector;
    //   14: astore_0
    //   15: aload_0
    //   16: invokevirtual 380	java/util/Vector:size	()I
    //   19: iconst_1
    //   20: if_icmple +151 -> 171
    //   23: aload_0
    //   24: iconst_1
    //   25: invokevirtual 384	java/util/Vector:get	(I)Ljava/lang/Object;
    //   28: checkcast 439	[Ljava/lang/String;
    //   31: astore_2
    //   32: new 441	android/location/Location
    //   35: dup
    //   36: ldc -48
    //   38: invokespecial 443	android/location/Location:<init>	(Ljava/lang/String;)V
    //   41: astore_0
    //   42: aload_0
    //   43: invokestatic 448	java/lang/System:currentTimeMillis	()J
    //   46: invokevirtual 452	android/location/Location:setTime	(J)V
    //   49: aload_2
    //   50: iconst_0
    //   51: aaload
    //   52: astore_3
    //   53: aload_2
    //   54: iconst_1
    //   55: aaload
    //   56: astore 4
    //   58: aload_3
    //   59: ldc_w 346
    //   62: invokevirtual 368	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   65: istore_1
    //   66: aload_0
    //   67: aload_3
    //   68: iconst_0
    //   69: iload_1
    //   70: invokevirtual 372	java/lang/String:substring	(II)Ljava/lang/String;
    //   73: invokestatic 454	com/mapbar/android/location/h:a	(Ljava/lang/String;)I
    //   76: i2d
    //   77: ldc2_w 455
    //   80: ddiv
    //   81: invokevirtual 460	android/location/Location:setLongitude	(D)V
    //   84: aload_0
    //   85: aload_3
    //   86: iload_1
    //   87: iconst_1
    //   88: iadd
    //   89: invokevirtual 463	java/lang/String:substring	(I)Ljava/lang/String;
    //   92: invokestatic 454	com/mapbar/android/location/h:a	(Ljava/lang/String;)I
    //   95: i2d
    //   96: ldc2_w 455
    //   99: ddiv
    //   100: invokevirtual 466	android/location/Location:setLatitude	(D)V
    //   103: aload_0
    //   104: aload 4
    //   106: invokestatic 472	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   109: invokevirtual 476	android/location/Location:setAccuracy	(F)V
    //   112: aload_2
    //   113: arraylength
    //   114: iconst_2
    //   115: if_icmple +42 -> 157
    //   118: new 478	android/os/Bundle
    //   121: dup
    //   122: invokespecial 479	android/os/Bundle:<init>	()V
    //   125: astore_3
    //   126: aload_3
    //   127: ldc_w 481
    //   130: aload_2
    //   131: iconst_2
    //   132: aaload
    //   133: invokevirtual 485	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload_2
    //   137: arraylength
    //   138: iconst_3
    //   139: if_icmple +13 -> 152
    //   142: aload_3
    //   143: ldc_w 487
    //   146: aload_2
    //   147: iconst_3
    //   148: aaload
    //   149: invokevirtual 485	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: aload_0
    //   153: aload_3
    //   154: invokevirtual 491	android/location/Location:setExtras	(Landroid/os/Bundle;)V
    //   157: aload_0
    //   158: areturn
    //   159: astore_0
    //   160: aconst_null
    //   161: areturn
    //   162: astore_2
    //   163: aload_0
    //   164: areturn
    //   165: astore_0
    //   166: aconst_null
    //   167: areturn
    //   168: astore_2
    //   169: aload_0
    //   170: areturn
    //   171: aconst_null
    //   172: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	paramString	String
    //   65	24	1	i1	int
    //   31	116	2	arrayOfString	String[]
    //   162	1	2	localException	Exception
    //   168	1	2	localNumberFormatException	NumberFormatException
    //   52	102	3	localObject	Object
    //   56	49	4	str	String
    // Exception table:
    //   from	to	target	type
    //   4	32	159	java/lang/Exception
    //   32	42	159	java/lang/Exception
    //   42	49	162	java/lang/Exception
    //   58	152	162	java/lang/Exception
    //   152	157	162	java/lang/Exception
    //   32	42	165	java/lang/NumberFormatException
    //   42	49	168	java/lang/NumberFormatException
    //   58	152	168	java/lang/NumberFormatException
    //   152	157	168	java/lang/NumberFormatException
  }
  
  public static boolean d()
  {
    return false;
  }
  
  private static String e(String paramString)
  {
    paramString = paramString.toCharArray();
    int i3 = paramString.length;
    int i2 = 0;
    if (i2 < i3)
    {
      int i1;
      switch (i2 % 5)
      {
      default: 
        i1 = 118;
      }
      for (;;)
      {
        paramString[i2] = ((char)(i1 ^ paramString[i2]));
        i2 += 1;
        break;
        i1 = 96;
        continue;
        i1 = 98;
        continue;
        i1 = 19;
        continue;
        i1 = 31;
      }
    }
    return new String(paramString);
  }
  
  public static boolean e()
  {
    return true;
  }
  
  public static boolean f()
  {
    return true;
  }
  
  private static byte[] f(String paramString)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      DeflaterOutputStream localDeflaterOutputStream = new DeflaterOutputStream(localByteArrayOutputStream);
      localDeflaterOutputStream.write(paramString.getBytes());
      localDeflaterOutputStream.close();
      try
      {
        localByteArrayOutputStream.close();
        paramString = localByteArrayOutputStream.toByteArray();
        return paramString;
      }
      catch (IOException paramString)
      {
        for (;;) {}
      }
      return null;
    }
    catch (Exception paramString) {}
  }
  
  public static boolean g()
  {
    return false;
  }
  
  public static boolean h()
  {
    return true;
  }
  
  public static boolean i()
  {
    return false;
  }
  
  public static boolean j()
  {
    return false;
  }
  
  private String p()
  {
    for (;;)
    {
      try
      {
        localk = k.a(this.h);
        if (!localk.b()) {}
      }
      catch (Exception localException)
      {
        k localk;
        i.a("CellLocationImpl", "Exception: " + localException.getMessage());
        continue;
      }
      try
      {
        localk.wait(1000L);
        return l.a();
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
  }
  
  private void q()
  {
    try
    {
      if (this.m.isWifiEnabled()) {
        this.m.startScan();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private String r()
  {
    if ((this.x != null) && (this.x.a != null))
    {
      this.x.a.removeMessages(2);
      this.x.a.sendEmptyMessageDelayed(2, d);
    }
    Hashtable localHashtable = new Hashtable();
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      ScanResult localScanResult;
      try
      {
        localObject1 = this.m.getScanResults();
        if (localObject1 != null)
        {
          Collections.sort((List)localObject1, this.u);
          Iterator localIterator = ((List)localObject1).iterator();
          if (localIterator.hasNext())
          {
            localScanResult = (ScanResult)localIterator.next();
            localStringBuilder.append(localScanResult.BSSID).append("|");
            localObject2 = "";
            localObject1 = localObject2;
          }
        }
      }
      catch (Exception localException1)
      {
        Object localObject1;
        Object localObject2;
        Object localObject3;
        label255:
        localException1.printStackTrace();
        l.w = localStringBuilder.toString();
        this.t.clear();
        this.t = localHashtable;
        return l.w;
      }
      label428:
      try
      {
        localObject3 = f(localScanResult.SSID);
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          localObject2 = a.a((byte[])localObject3, "iso-8859-1");
          localObject1 = localObject2;
          localObject2 = ((String)localObject2).replaceAll("\n", "").replaceAll("\r", "");
          localObject1 = localObject2;
        }
      }
      catch (Exception localException2) {}
    }
    localStringBuilder.append((String)localObject1).append("|").append(localScanResult.level).append("|").append(localScanResult.frequency).append("|");
    if (TextUtils.isEmpty(localScanResult.capabilities))
    {
      localStringBuilder.append(1);
      localObject3 = localScanResult.BSSID + "|" + (String)localObject1;
      localObject2 = (d)this.t.get(localObject3);
      if (localObject2 == null) {
        break label428;
      }
      localObject1 = localObject2;
      if (((d)localObject2).a != localScanResult.level)
      {
        ((d)localObject2).a = localScanResult.level;
        ((d)localObject2).b = SystemClock.elapsedRealtime();
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localHashtable.put(localObject3, localObject1);
      long l1 = (SystemClock.elapsedRealtime() - ((d)localObject1).b) / 1000L;
      localStringBuilder.append("|").append(l1);
      localStringBuilder.append(",");
      break;
      localStringBuilder.append(0);
      break label255;
      d locald = new d();
      locald.a = localScanResult.level;
      locald.b = SystemClock.elapsedRealtime();
    }
  }
  
  public final String a(LocationListener paramLocationListener)
  {
    if ((paramLocationListener != null) && (this.i != null))
    {
      Object localObject = new Random();
      localObject = "CELL_LISTENER_" + ((Random)localObject).nextInt();
      this.i.put(localObject, paramLocationListener);
      return (String)localObject;
    }
    return null;
  }
  
  public final void a(Location paramLocation)
  {
    i.a("CellLocationImpl", "location=" + paramLocation);
    if (this.i != null)
    {
      Enumeration localEnumeration = this.i.elements();
      while (localEnumeration.hasMoreElements())
      {
        LocationListener localLocationListener = (LocationListener)localEnumeration.nextElement();
        if (localLocationListener != null) {
          try
          {
            localLocationListener.onLocationChanged(paramLocation);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }
    }
  }
  
  public final boolean a(Criteria paramCriteria)
  {
    if ((paramCriteria.getAccuracy() != 0) && (paramCriteria.getAccuracy() < 2)) {}
    do
    {
      int i1;
      do
      {
        return false;
        i1 = paramCriteria.getPowerRequirement();
      } while ((i1 != 0) && (i1 <= 0));
      paramCriteria.isAltitudeRequired();
    } while ((paramCriteria.isSpeedRequired()) || (paramCriteria.isBearingRequired()));
    return true;
  }
  
  public final boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return false;
    }
    if (this.i != null) {
      this.i.remove(paramString);
    }
    return true;
  }
  
  public final int k()
  {
    return this.f;
  }
  
  public final long l()
  {
    return this.g;
  }
  
  public final void m()
  {
    if (SystemClock.elapsedRealtime() - this.k > c)
    {
      this.j = null;
      this.n = null;
      this.o = null;
    }
    this.k = 0L;
    this.f = -1;
    if (!this.e)
    {
      this.e = true;
      if (this.i != null)
      {
        Enumeration localEnumeration = this.i.elements();
        while (localEnumeration.hasMoreElements())
        {
          LocationListener localLocationListener = (LocationListener)localEnumeration.nextElement();
          if (localLocationListener != null) {
            try
            {
              localLocationListener.onProviderEnabled("cell");
            }
            catch (Exception localException2)
            {
              localException2.printStackTrace();
            }
          }
        }
      }
      if (this.x != null) {
        break label149;
      }
      this.x = new a("LocationService");
      this.x.start();
    }
    for (;;)
    {
      label149:
      try
      {
        k.a(this.h).a();
        return;
      }
      catch (Exception localException1) {}
      if (this.x.a != null)
      {
        this.x.a.removeMessages(1);
        this.x.a.sendEmptyMessage(1);
      }
    }
  }
  
  public final void n()
  {
    this.e = false;
    if ((this.x != null) && (this.x.a != null)) {
      this.x.a.removeMessages(1);
    }
    if (this.i != null)
    {
      Enumeration localEnumeration = this.i.elements();
      while (localEnumeration.hasMoreElements())
      {
        LocationListener localLocationListener = (LocationListener)localEnumeration.nextElement();
        if (localLocationListener != null) {
          try
          {
            localLocationListener.onProviderDisabled("cell");
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
        }
      }
    }
    try
    {
      k.a(this.h).d();
      return;
    }
    catch (Exception localException1) {}
  }
  
  public final void o()
  {
    if (this.i != null) {
      this.i.clear();
    }
  }
  
  final class a
    extends Thread
  {
    public Handler a = null;
    
    public a(String paramString)
    {
      super();
    }
    
    public final void run()
    {
      
      if (!g.b)
      {
        PackageManager localPackageManager = b.b(b.this).getPackageManager();
        g.e = b.b(b.this).getPackageName();
        g.d = g.a(localPackageManager, g.e);
        g.c = b.d.a(localPackageManager, g.e);
        g.b = g.a(g.d);
      }
      try
      {
        CellLocation.requestLocationUpdate();
        b.a(b.this, (TelephonyManager)b.b(b.this).getSystemService("phone"));
        l.a = b.c(b.this).getDeviceId();
        l.b = b.c(b.this).getSimSerialNumber();
        b.c(b.this).listen(b.d(b.this), 19);
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            b.a(b.this, (WifiManager)b.b(b.this).getSystemService("wifi"));
            this.a = new Handler()
            {
              public final void handleMessage(Message paramAnonymousMessage)
              {
                switch (paramAnonymousMessage.what)
                {
                }
                for (;;)
                {
                  return;
                  if ((!b.e(b.this)) || (!g.b)) {
                    continue;
                  }
                  try
                  {
                    b.a(b.this, b.c(b.this), 0);
                    b.a(b.this, b.c(b.this), 1);
                    b.f(b.this);
                    return;
                    if ((b.e(b.this)) && (k.a(b.b(b.this)).b()))
                    {
                      b.g(b.this);
                      b.a((short)1000);
                    }
                    for (;;)
                    {
                      paramAnonymousMessage = b.h(b.this);
                      paramAnonymousMessage = b.a(b.this, paramAnonymousMessage);
                      if (("".equals(paramAnonymousMessage)) || (paramAnonymousMessage.equals(b.i(b.this)))) {
                        break;
                      }
                      b.b(b.this, paramAnonymousMessage);
                      k.a(b.b(b.this)).c();
                      return;
                      b.a((short)10000);
                    }
                  }
                  catch (Throwable paramAnonymousMessage)
                  {
                    for (;;) {}
                  }
                }
              }
            };
            this.a.removeMessages(2);
            this.a.sendEmptyMessage(2);
            this.a.removeMessages(1);
            this.a.sendEmptyMessageDelayed(1, 100L);
            Looper.loop();
            return;
            localException1 = localException1;
            localException1.printStackTrace();
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            localException2.printStackTrace();
          }
        }
      }
    }
  }
  
  public class b
  {
    t a;
    public String b;
    
    public b() {}
    
    public b(t paramt, String paramString)
    {
      this.a = null;
      this.b = null;
      this.a = paramt;
      this.b = paramString;
    }
    
    public static boolean a(String paramString)
    {
      return (paramString != null) && (paramString.trim().length() > 0);
    }
  }
  
  final class c
    implements Comparator<ScanResult>
  {
    c() {}
  }
  
  public class d
  {
    public int a;
    public long b;
    
    public d() {}
    
    d()
    {
      this.a = 0;
      this.b = 0L;
    }
    
    public static String a(PackageManager paramPackageManager, String paramString)
    {
      int i = 0;
      try
      {
        ApplicationInfo localApplicationInfo = paramPackageManager.getApplicationInfo(paramString, 0);
        if (localApplicationInfo == null) {
          return null;
        }
        if ((localApplicationInfo.flags & 0x1) != 0) {
          return "SYSTEM";
        }
        paramPackageManager = paramPackageManager.getPackageInfo(paramString, 64);
        if ((paramPackageManager != null) && (paramPackageManager.signatures != null) && (paramPackageManager.signatures.length != 0) && (paramPackageManager.signatures[0] != null))
        {
          paramPackageManager = paramPackageManager.signatures[0].toByteArray();
          paramString = MessageDigest.getInstance("MD5");
          if (paramString != null)
          {
            paramPackageManager = paramString.digest(paramPackageManager);
            if (paramPackageManager != null)
            {
              paramString = new StringBuffer(paramPackageManager.length << 1);
              int j = paramPackageManager.length;
              while (i < j)
              {
                paramString.append(String.format("%02x", new Object[] { Byte.valueOf(paramPackageManager[i]) }));
                i += 1;
              }
              paramPackageManager = paramString.toString();
              return paramPackageManager;
            }
          }
        }
      }
      catch (NoSuchAlgorithmException paramPackageManager)
      {
        return null;
      }
      catch (PackageManager.NameNotFoundException paramPackageManager) {}
      return null;
    }
  }
  
  public class e
  {
    public e(String paramString) {}
    
    public void a(t paramt, Object paramObject)
    {
      int i = paramt.e();
      if (i < b.j(b.this)) {}
      for (;;)
      {
        return;
        b.b(b.this, i);
        b.a(b.this, b.e(b.this, (String)paramObject));
        if (b.a(b.this) != null)
        {
          b.k(b.this).sendEmptyMessage(2);
          b.a(b.this, SystemClock.elapsedRealtime());
          b.k(b.this).sendEmptyMessage(3);
        }
        try
        {
          i = b.l(b.this).size();
          if ((i > 0) && (paramString.equals(((b.b)b.l(b.this).get(i - 1)).b)))
          {
            b.l(b.this).remove(i - 1);
            return;
          }
        }
        catch (Exception paramt) {}
      }
    }
  }
  
  public class f
  {
    public f() {}
    
    public void a(t paramt, int paramInt)
    {
      if ((paramInt != 200) && (paramt.e() > b.j(b.this)))
      {
        b.c(b.this, null);
        b.d(b.this, null);
        b.k(b.this).sendEmptyMessage(0);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/location/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */