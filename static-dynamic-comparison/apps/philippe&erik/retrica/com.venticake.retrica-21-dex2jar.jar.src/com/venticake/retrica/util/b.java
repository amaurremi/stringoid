package com.venticake.retrica.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.location.Location;
import android.os.Build.VERSION;
import com.amazonaws.auth.SystemPropertiesCredentialsProvider;
import com.venticake.retrica.setting.a;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.UUID;

public class b
{
  private static b a = null;
  private boolean b = false;
  
  private int a(Calendar paramCalendar)
  {
    switch (paramCalendar.get(7))
    {
    default: 
      return -1;
    case 2: 
      return 0;
    case 3: 
      return 1;
    case 4: 
      return 2;
    case 5: 
      return 3;
    case 6: 
      return 4;
    case 7: 
      return 5;
    }
    return 6;
  }
  
  /* Error */
  public static b a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 16	com/venticake/retrica/util/b:a	Lcom/venticake/retrica/util/b;
    //   6: ifnonnull +20 -> 26
    //   9: new 2	com/venticake/retrica/util/b
    //   12: dup
    //   13: invokespecial 38	com/venticake/retrica/util/b:<init>	()V
    //   16: astore_0
    //   17: aload_0
    //   18: putstatic 16	com/venticake/retrica/util/b:a	Lcom/venticake/retrica/util/b;
    //   21: ldc 2
    //   23: monitorexit
    //   24: aload_0
    //   25: areturn
    //   26: getstatic 16	com/venticake/retrica/util/b:a	Lcom/venticake/retrica/util/b;
    //   29: astore_0
    //   30: goto -9 -> 21
    //   33: astore_0
    //   34: ldc 2
    //   36: monitorexit
    //   37: aload_0
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   16	14	0	localb	b
    //   33	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	21	33	finally
    //   26	30	33	finally
  }
  
  private UUID a(Location paramLocation)
  {
    UUID localUUID2 = a.a().y();
    UUID localUUID1 = localUUID2;
    if (localUUID2 == null)
    {
      a.a().a(paramLocation);
      localUUID1 = a.a().y();
    }
    return localUUID1;
  }
  
  private SystemPropertiesCredentialsProvider b()
  {
    System.setProperty("aws.accessKeyId", a.d());
    System.setProperty("aws.secretKey", a.e());
    SystemPropertiesCredentialsProvider localSystemPropertiesCredentialsProvider = new SystemPropertiesCredentialsProvider();
    System.setProperty("aws.accessKeyId", "");
    System.setProperty("aws.secretKey", "");
    return localSystemPropertiesCredentialsProvider;
  }
  
  private String b(Calendar paramCalendar)
  {
    return paramCalendar.get(1) + "-" + paramCalendar.get(2) + "-" + paramCalendar.get(5);
  }
  
  @SuppressLint({"SimpleDateFormat"})
  private String c(Calendar paramCalendar)
  {
    TimeZone localTimeZone = TimeZone.getDefault();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZ");
    localSimpleDateFormat.setTimeZone(localTimeZone);
    return localSimpleDateFormat.format(paramCalendar.getTime());
  }
  
  public void a(Activity paramActivity)
  {
    if ((Build.VERSION.SDK_INT >= 10) && (this.b)) {
      new Thread(new RetricaLogger.2(this, paramActivity)).start();
    }
  }
  
  public void a(Activity paramActivity, Location paramLocation, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((Build.VERSION.SDK_INT >= 10) && (!this.b))
    {
      a.a().A();
      a.a().C();
      a(paramActivity, paramLocation, 1, paramInt1, paramInt2, paramInt3, paramInt4);
      this.b = true;
    }
  }
  
  public void a(Activity paramActivity, Location paramLocation, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    new Thread(new RetricaLogger.1(this, paramLocation, paramActivity, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5)).start();
  }
  
  public void b(Activity paramActivity, Location paramLocation, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 10)
    {
      a.a().A();
      a.a().C();
      a(paramActivity, paramLocation, 0, paramInt1, paramInt2, paramInt3, paramInt4);
      this.b = true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/util/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */