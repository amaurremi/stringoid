package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.atomic.apps.ringtone.cutter.aa;
import com.google.android.gms.a.d;
import com.google.android.gms.ads.b.b;
import com.google.android.gms.ads.b.c;
import com.google.android.gms.ads.b.e;
import java.util.Iterator;
import org.json.JSONObject;

public final class as
  extends an
{
  private final b a;
  private final Bundle b;
  
  public as(b paramb, Bundle paramBundle)
  {
    this.a = paramb;
    this.b = paramBundle;
  }
  
  private Bundle a(String paramString1, int paramInt, String paramString2)
  {
    aa.e("Server parameters: " + paramString1);
    Bundle localBundle;
    try
    {
      localBundle = new Bundle();
      if (paramString1 != null)
      {
        paramString1 = new JSONObject(paramString1);
        localBundle = new Bundle();
        Iterator localIterator = paramString1.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localBundle.putString(str, paramString1.getString(str));
        }
      }
      if (!(this.a instanceof com.google.a.a.a.a)) {
        break label135;
      }
    }
    catch (Throwable paramString1)
    {
      aa.b("Could not get Server Parameters Bundle.", paramString1);
      throw new RemoteException();
    }
    localBundle.putString("adJson", paramString2);
    localBundle.putInt("tagForChildDirectedTreatment", paramInt);
    label135:
    return localBundle;
  }
  
  public final com.google.android.gms.a.a a()
  {
    if (!(this.a instanceof c))
    {
      aa.e("MediationAdapter is not a MediationBannerAdapter: " + this.a.getClass().getCanonicalName());
      throw new RemoteException();
    }
    try
    {
      com.google.android.gms.a.a locala = d.a(((c)this.a).d());
      return locala;
    }
    catch (Throwable localThrowable)
    {
      aa.b("Could not get banner view from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public final void a(com.google.android.gms.a.a parama, ah paramah, String paramString, ap paramap)
  {
    a(parama, paramah, paramString, null, paramap);
  }
  
  /* Error */
  public final void a(com.google.android.gms.a.a parama, ah paramah, String paramString1, String paramString2, ap paramap)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 15	com/google/android/gms/internal/as:a	Lcom/google/android/gms/ads/b/b;
    //   4: instanceof 122
    //   7: ifne +39 -> 46
    //   10: new 23	java/lang/StringBuilder
    //   13: dup
    //   14: ldc 124
    //   16: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   19: aload_0
    //   20: getfield 15	com/google/android/gms/internal/as:a	Lcom/google/android/gms/ads/b/b;
    //   23: invokevirtual 100	java/lang/Object:getClass	()Ljava/lang/Class;
    //   26: invokevirtual 105	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   29: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 41	com/atomic/apps/ringtone/cutter/aa:e	(Ljava/lang/String;)V
    //   38: new 78	android/os/RemoteException
    //   41: dup
    //   42: invokespecial 79	android/os/RemoteException:<init>	()V
    //   45: athrow
    //   46: ldc 126
    //   48: invokestatic 128	com/atomic/apps/ringtone/cutter/aa:a	(Ljava/lang/String;)V
    //   51: aload_0
    //   52: getfield 15	com/google/android/gms/internal/as:a	Lcom/google/android/gms/ads/b/b;
    //   55: checkcast 122	com/google/android/gms/ads/b/e
    //   58: astore 7
    //   60: aload_2
    //   61: getfield 133	com/google/android/gms/internal/ah:e	Ljava/util/List;
    //   64: ifnull +91 -> 155
    //   67: new 135	java/util/HashSet
    //   70: dup
    //   71: aload_2
    //   72: getfield 133	com/google/android/gms/internal/ah:e	Ljava/util/List;
    //   75: invokespecial 138	java/util/HashSet:<init>	(Ljava/util/Collection;)V
    //   78: astore 6
    //   80: new 140	com/google/android/gms/ads/b/a
    //   83: dup
    //   84: new 142	java/util/Date
    //   87: dup
    //   88: aload_2
    //   89: getfield 145	com/google/android/gms/internal/ah:b	J
    //   92: invokespecial 148	java/util/Date:<init>	(J)V
    //   95: aload_2
    //   96: getfield 151	com/google/android/gms/internal/ah:d	I
    //   99: aload 6
    //   101: aload_2
    //   102: getfield 155	com/google/android/gms/internal/ah:f	Z
    //   105: aload_2
    //   106: getfield 158	com/google/android/gms/internal/ah:g	I
    //   109: invokespecial 161	com/google/android/gms/ads/b/a:<init>	(Ljava/util/Date;ILjava/util/Set;ZI)V
    //   112: astore 6
    //   114: aload 7
    //   116: aload_1
    //   117: invokestatic 164	com/google/android/gms/a/d:a	(Lcom/google/android/gms/a/a;)Ljava/lang/Object;
    //   120: checkcast 166	android/content/Context
    //   123: new 168	com/google/android/gms/ads/b/d
    //   126: dup
    //   127: aload 5
    //   129: invokespecial 171	com/google/android/gms/ads/b/d:<init>	(Lcom/google/android/gms/internal/ap;)V
    //   132: aload_0
    //   133: aload_3
    //   134: aload_2
    //   135: getfield 158	com/google/android/gms/internal/ah:g	I
    //   138: aload 4
    //   140: invokespecial 173	com/google/android/gms/internal/as:a	(Ljava/lang/String;ILjava/lang/String;)Landroid/os/Bundle;
    //   143: aload 6
    //   145: aload_0
    //   146: getfield 17	com/google/android/gms/internal/as:b	Landroid/os/Bundle;
    //   149: invokeinterface 176 6 0
    //   154: return
    //   155: aconst_null
    //   156: astore 6
    //   158: goto -78 -> 80
    //   161: astore_1
    //   162: ldc -78
    //   164: aload_1
    //   165: invokestatic 76	com/atomic/apps/ringtone/cutter/aa:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   168: new 78	android/os/RemoteException
    //   171: dup
    //   172: invokespecial 79	android/os/RemoteException:<init>	()V
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	as
    //   0	176	1	parama	com.google.android.gms.a.a
    //   0	176	2	paramah	ah
    //   0	176	3	paramString1	String
    //   0	176	4	paramString2	String
    //   0	176	5	paramap	ap
    //   78	79	6	localObject	Object
    //   58	57	7	locale	e
    // Exception table:
    //   from	to	target	type
    //   51	80	161	java/lang/Throwable
    //   80	154	161	java/lang/Throwable
  }
  
  public final void a(com.google.android.gms.a.a parama, ak paramak, ah paramah, String paramString, ap paramap)
  {
    a(parama, paramak, paramah, paramString, null, paramap);
  }
  
  /* Error */
  public final void a(com.google.android.gms.a.a parama, ak paramak, ah paramah, String paramString1, String paramString2, ap paramap)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 15	com/google/android/gms/internal/as:a	Lcom/google/android/gms/ads/b/b;
    //   4: instanceof 92
    //   7: ifne +39 -> 46
    //   10: new 23	java/lang/StringBuilder
    //   13: dup
    //   14: ldc 94
    //   16: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   19: aload_0
    //   20: getfield 15	com/google/android/gms/internal/as:a	Lcom/google/android/gms/ads/b/b;
    //   23: invokevirtual 100	java/lang/Object:getClass	()Ljava/lang/Class;
    //   26: invokevirtual 105	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   29: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 41	com/atomic/apps/ringtone/cutter/aa:e	(Ljava/lang/String;)V
    //   38: new 78	android/os/RemoteException
    //   41: dup
    //   42: invokespecial 79	android/os/RemoteException:<init>	()V
    //   45: athrow
    //   46: ldc -72
    //   48: invokestatic 128	com/atomic/apps/ringtone/cutter/aa:a	(Ljava/lang/String;)V
    //   51: aload_0
    //   52: getfield 15	com/google/android/gms/internal/as:a	Lcom/google/android/gms/ads/b/b;
    //   55: checkcast 92	com/google/android/gms/ads/b/c
    //   58: astore 8
    //   60: aload_3
    //   61: getfield 133	com/google/android/gms/internal/ah:e	Ljava/util/List;
    //   64: ifnull +107 -> 171
    //   67: new 135	java/util/HashSet
    //   70: dup
    //   71: aload_3
    //   72: getfield 133	com/google/android/gms/internal/ah:e	Ljava/util/List;
    //   75: invokespecial 138	java/util/HashSet:<init>	(Ljava/util/Collection;)V
    //   78: astore 7
    //   80: new 140	com/google/android/gms/ads/b/a
    //   83: dup
    //   84: new 142	java/util/Date
    //   87: dup
    //   88: aload_3
    //   89: getfield 145	com/google/android/gms/internal/ah:b	J
    //   92: invokespecial 148	java/util/Date:<init>	(J)V
    //   95: aload_3
    //   96: getfield 151	com/google/android/gms/internal/ah:d	I
    //   99: aload 7
    //   101: aload_3
    //   102: getfield 155	com/google/android/gms/internal/ah:f	Z
    //   105: aload_3
    //   106: getfield 158	com/google/android/gms/internal/ah:g	I
    //   109: invokespecial 161	com/google/android/gms/ads/b/a:<init>	(Ljava/util/Date;ILjava/util/Set;ZI)V
    //   112: astore 7
    //   114: aload 8
    //   116: aload_1
    //   117: invokestatic 164	com/google/android/gms/a/d:a	(Lcom/google/android/gms/a/a;)Ljava/lang/Object;
    //   120: checkcast 166	android/content/Context
    //   123: new 168	com/google/android/gms/ads/b/d
    //   126: dup
    //   127: aload 6
    //   129: invokespecial 171	com/google/android/gms/ads/b/d:<init>	(Lcom/google/android/gms/internal/ap;)V
    //   132: aload_0
    //   133: aload 4
    //   135: aload_3
    //   136: getfield 158	com/google/android/gms/internal/ah:g	I
    //   139: aload 5
    //   141: invokespecial 173	com/google/android/gms/internal/as:a	(Ljava/lang/String;ILjava/lang/String;)Landroid/os/Bundle;
    //   144: aload_2
    //   145: getfield 188	com/google/android/gms/internal/ak:f	I
    //   148: aload_2
    //   149: getfield 191	com/google/android/gms/internal/ak:c	I
    //   152: aload_2
    //   153: getfield 194	com/google/android/gms/internal/ak:b	Ljava/lang/String;
    //   156: invokestatic 199	com/google/android/gms/ads/c:a	(IILjava/lang/String;)Lcom/google/android/gms/ads/d;
    //   159: aload 7
    //   161: aload_0
    //   162: getfield 17	com/google/android/gms/internal/as:b	Landroid/os/Bundle;
    //   165: invokeinterface 202 7 0
    //   170: return
    //   171: aconst_null
    //   172: astore 7
    //   174: goto -94 -> 80
    //   177: astore_1
    //   178: ldc -52
    //   180: aload_1
    //   181: invokestatic 76	com/atomic/apps/ringtone/cutter/aa:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   184: new 78	android/os/RemoteException
    //   187: dup
    //   188: invokespecial 79	android/os/RemoteException:<init>	()V
    //   191: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	as
    //   0	192	1	parama	com.google.android.gms.a.a
    //   0	192	2	paramak	ak
    //   0	192	3	paramah	ah
    //   0	192	4	paramString1	String
    //   0	192	5	paramString2	String
    //   0	192	6	paramap	ap
    //   78	95	7	localObject	Object
    //   58	57	8	localc	c
    // Exception table:
    //   from	to	target	type
    //   51	80	177	java/lang/Throwable
    //   80	170	177	java/lang/Throwable
  }
  
  public final void b()
  {
    if (!(this.a instanceof e))
    {
      aa.e("MediationAdapter is not a MediationInterstitialAdapter: " + this.a.getClass().getCanonicalName());
      throw new RemoteException();
    }
    aa.a("Showing interstitial from adapter.");
    try
    {
      ((e)this.a).e();
      return;
    }
    catch (Throwable localThrowable)
    {
      aa.b("Could not show interstitial from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public final void c()
  {
    try
    {
      this.a.a();
      return;
    }
    catch (Throwable localThrowable)
    {
      aa.b("Could not destroy adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public final void d()
  {
    try
    {
      this.a.b();
      return;
    }
    catch (Throwable localThrowable)
    {
      aa.b("Could not pause adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public final void e()
  {
    try
    {
      this.a.c();
      return;
    }
    catch (Throwable localThrowable)
    {
      aa.b("Could not resume adapter.", localThrowable);
      throw new RemoteException();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */