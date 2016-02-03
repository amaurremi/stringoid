package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import java.util.Iterator;
import org.json.JSONObject;

public final class by
  extends bv.a
{
  private final MediationAdapter nQ;
  
  public by(MediationAdapter paramMediationAdapter)
  {
    this.nQ = paramMediationAdapter;
  }
  
  private Bundle a(String paramString1, int paramInt, String paramString2)
    throws RemoteException
  {
    ev.D("Server parameters: " + paramString1);
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
      if (!(this.nQ instanceof AdMobAdapter)) {
        break label138;
      }
    }
    catch (Throwable paramString1)
    {
      ev.c("Could not get Server Parameters Bundle.", paramString1);
      throw new RemoteException();
    }
    localBundle.putString("adJson", paramString2);
    localBundle.putInt("tagForChildDirectedTreatment", paramInt);
    label138:
    return localBundle;
  }
  
  public void a(d paramd, aj paramaj, String paramString, bw parambw)
    throws RemoteException
  {
    a(paramd, paramaj, paramString, null, parambw);
  }
  
  /* Error */
  public void a(d paramd, aj paramaj, String paramString1, String paramString2, bw parambw)
    throws RemoteException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: getfield 13	com/google/android/gms/internal/by:nQ	Lcom/google/android/gms/ads/mediation/MediationAdapter;
    //   7: instanceof 94
    //   10: ifne +42 -> 52
    //   13: new 22	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   20: ldc 96
    //   22: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: getfield 13	com/google/android/gms/internal/by:nQ	Lcom/google/android/gms/ads/mediation/MediationAdapter;
    //   29: invokevirtual 102	java/lang/Object:getClass	()Ljava/lang/Class;
    //   32: invokevirtual 107	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   35: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 39	com/google/android/gms/internal/ev:D	(Ljava/lang/String;)V
    //   44: new 18	android/os/RemoteException
    //   47: dup
    //   48: invokespecial 77	android/os/RemoteException:<init>	()V
    //   51: athrow
    //   52: ldc 109
    //   54: invokestatic 112	com/google/android/gms/internal/ev:z	(Ljava/lang/String;)V
    //   57: aload_0
    //   58: getfield 13	com/google/android/gms/internal/by:nQ	Lcom/google/android/gms/ads/mediation/MediationAdapter;
    //   61: checkcast 94	com/google/android/gms/ads/mediation/MediationInterstitialAdapter
    //   64: astore 8
    //   66: aload_2
    //   67: getfield 118	com/google/android/gms/internal/aj:lS	Ljava/util/List;
    //   70: ifnull +117 -> 187
    //   73: new 120	java/util/HashSet
    //   76: dup
    //   77: aload_2
    //   78: getfield 118	com/google/android/gms/internal/aj:lS	Ljava/util/List;
    //   81: invokespecial 123	java/util/HashSet:<init>	(Ljava/util/Collection;)V
    //   84: astore 6
    //   86: new 125	com/google/android/gms/internal/bx
    //   89: dup
    //   90: new 127	java/util/Date
    //   93: dup
    //   94: aload_2
    //   95: getfield 131	com/google/android/gms/internal/aj:lQ	J
    //   98: invokespecial 134	java/util/Date:<init>	(J)V
    //   101: aload_2
    //   102: getfield 138	com/google/android/gms/internal/aj:lR	I
    //   105: aload 6
    //   107: aload_2
    //   108: getfield 142	com/google/android/gms/internal/aj:lT	Z
    //   111: aload_2
    //   112: getfield 145	com/google/android/gms/internal/aj:lU	I
    //   115: invokespecial 148	com/google/android/gms/internal/bx:<init>	(Ljava/util/Date;ILjava/util/Set;ZI)V
    //   118: astore 9
    //   120: aload 7
    //   122: astore 6
    //   124: aload_2
    //   125: getfield 152	com/google/android/gms/internal/aj:ma	Landroid/os/Bundle;
    //   128: ifnull +20 -> 148
    //   131: aload_2
    //   132: getfield 152	com/google/android/gms/internal/aj:ma	Landroid/os/Bundle;
    //   135: aload 8
    //   137: invokevirtual 102	java/lang/Object:getClass	()Ljava/lang/Class;
    //   140: invokevirtual 155	java/lang/Class:getName	()Ljava/lang/String;
    //   143: invokevirtual 159	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   146: astore 6
    //   148: aload 8
    //   150: aload_1
    //   151: invokestatic 165	com/google/android/gms/dynamic/e:e	(Lcom/google/android/gms/dynamic/d;)Ljava/lang/Object;
    //   154: checkcast 167	android/content/Context
    //   157: new 169	com/google/android/gms/internal/bz
    //   160: dup
    //   161: aload 5
    //   163: invokespecial 172	com/google/android/gms/internal/bz:<init>	(Lcom/google/android/gms/internal/bw;)V
    //   166: aload_0
    //   167: aload_3
    //   168: aload_2
    //   169: getfield 145	com/google/android/gms/internal/aj:lU	I
    //   172: aload 4
    //   174: invokespecial 174	com/google/android/gms/internal/by:a	(Ljava/lang/String;ILjava/lang/String;)Landroid/os/Bundle;
    //   177: aload 9
    //   179: aload 6
    //   181: invokeinterface 178 6 0
    //   186: return
    //   187: aconst_null
    //   188: astore 6
    //   190: goto -104 -> 86
    //   193: astore_1
    //   194: ldc -76
    //   196: aload_1
    //   197: invokestatic 76	com/google/android/gms/internal/ev:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   200: new 18	android/os/RemoteException
    //   203: dup
    //   204: invokespecial 77	android/os/RemoteException:<init>	()V
    //   207: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	by
    //   0	208	1	paramd	d
    //   0	208	2	paramaj	aj
    //   0	208	3	paramString1	String
    //   0	208	4	paramString2	String
    //   0	208	5	parambw	bw
    //   84	105	6	localObject1	Object
    //   1	120	7	localObject2	Object
    //   64	85	8	localMediationInterstitialAdapter	MediationInterstitialAdapter
    //   118	60	9	localbx	bx
    // Exception table:
    //   from	to	target	type
    //   57	86	193	java/lang/Throwable
    //   86	120	193	java/lang/Throwable
    //   124	148	193	java/lang/Throwable
    //   148	186	193	java/lang/Throwable
  }
  
  public void a(d paramd, am paramam, aj paramaj, String paramString, bw parambw)
    throws RemoteException
  {
    a(paramd, paramam, paramaj, paramString, null, parambw);
  }
  
  /* Error */
  public void a(d paramd, am paramam, aj paramaj, String paramString1, String paramString2, bw parambw)
    throws RemoteException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_0
    //   4: getfield 13	com/google/android/gms/internal/by:nQ	Lcom/google/android/gms/ads/mediation/MediationAdapter;
    //   7: instanceof 186
    //   10: ifne +42 -> 52
    //   13: new 22	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   20: ldc -68
    //   22: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: getfield 13	com/google/android/gms/internal/by:nQ	Lcom/google/android/gms/ads/mediation/MediationAdapter;
    //   29: invokevirtual 102	java/lang/Object:getClass	()Ljava/lang/Class;
    //   32: invokevirtual 107	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   35: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 39	com/google/android/gms/internal/ev:D	(Ljava/lang/String;)V
    //   44: new 18	android/os/RemoteException
    //   47: dup
    //   48: invokespecial 77	android/os/RemoteException:<init>	()V
    //   51: athrow
    //   52: ldc -66
    //   54: invokestatic 112	com/google/android/gms/internal/ev:z	(Ljava/lang/String;)V
    //   57: aload_0
    //   58: getfield 13	com/google/android/gms/internal/by:nQ	Lcom/google/android/gms/ads/mediation/MediationAdapter;
    //   61: checkcast 186	com/google/android/gms/ads/mediation/MediationBannerAdapter
    //   64: astore 9
    //   66: aload_3
    //   67: getfield 118	com/google/android/gms/internal/aj:lS	Ljava/util/List;
    //   70: ifnull +133 -> 203
    //   73: new 120	java/util/HashSet
    //   76: dup
    //   77: aload_3
    //   78: getfield 118	com/google/android/gms/internal/aj:lS	Ljava/util/List;
    //   81: invokespecial 123	java/util/HashSet:<init>	(Ljava/util/Collection;)V
    //   84: astore 7
    //   86: new 125	com/google/android/gms/internal/bx
    //   89: dup
    //   90: new 127	java/util/Date
    //   93: dup
    //   94: aload_3
    //   95: getfield 131	com/google/android/gms/internal/aj:lQ	J
    //   98: invokespecial 134	java/util/Date:<init>	(J)V
    //   101: aload_3
    //   102: getfield 138	com/google/android/gms/internal/aj:lR	I
    //   105: aload 7
    //   107: aload_3
    //   108: getfield 142	com/google/android/gms/internal/aj:lT	Z
    //   111: aload_3
    //   112: getfield 145	com/google/android/gms/internal/aj:lU	I
    //   115: invokespecial 148	com/google/android/gms/internal/bx:<init>	(Ljava/util/Date;ILjava/util/Set;ZI)V
    //   118: astore 10
    //   120: aload 8
    //   122: astore 7
    //   124: aload_3
    //   125: getfield 152	com/google/android/gms/internal/aj:ma	Landroid/os/Bundle;
    //   128: ifnull +20 -> 148
    //   131: aload_3
    //   132: getfield 152	com/google/android/gms/internal/aj:ma	Landroid/os/Bundle;
    //   135: aload 9
    //   137: invokevirtual 102	java/lang/Object:getClass	()Ljava/lang/Class;
    //   140: invokevirtual 155	java/lang/Class:getName	()Ljava/lang/String;
    //   143: invokevirtual 159	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   146: astore 7
    //   148: aload 9
    //   150: aload_1
    //   151: invokestatic 165	com/google/android/gms/dynamic/e:e	(Lcom/google/android/gms/dynamic/d;)Ljava/lang/Object;
    //   154: checkcast 167	android/content/Context
    //   157: new 169	com/google/android/gms/internal/bz
    //   160: dup
    //   161: aload 6
    //   163: invokespecial 172	com/google/android/gms/internal/bz:<init>	(Lcom/google/android/gms/internal/bw;)V
    //   166: aload_0
    //   167: aload 4
    //   169: aload_3
    //   170: getfield 145	com/google/android/gms/internal/aj:lU	I
    //   173: aload 5
    //   175: invokespecial 174	com/google/android/gms/internal/by:a	(Ljava/lang/String;ILjava/lang/String;)Landroid/os/Bundle;
    //   178: aload_2
    //   179: getfield 195	com/google/android/gms/internal/am:width	I
    //   182: aload_2
    //   183: getfield 198	com/google/android/gms/internal/am:height	I
    //   186: aload_2
    //   187: getfield 202	com/google/android/gms/internal/am:mc	Ljava/lang/String;
    //   190: invokestatic 207	com/google/android/gms/ads/a:a	(IILjava/lang/String;)Lcom/google/android/gms/ads/AdSize;
    //   193: aload 10
    //   195: aload 7
    //   197: invokeinterface 211 7 0
    //   202: return
    //   203: aconst_null
    //   204: astore 7
    //   206: goto -120 -> 86
    //   209: astore_1
    //   210: ldc -43
    //   212: aload_1
    //   213: invokestatic 76	com/google/android/gms/internal/ev:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   216: new 18	android/os/RemoteException
    //   219: dup
    //   220: invokespecial 77	android/os/RemoteException:<init>	()V
    //   223: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	by
    //   0	224	1	paramd	d
    //   0	224	2	paramam	am
    //   0	224	3	paramaj	aj
    //   0	224	4	paramString1	String
    //   0	224	5	paramString2	String
    //   0	224	6	parambw	bw
    //   84	121	7	localObject1	Object
    //   1	120	8	localObject2	Object
    //   64	85	9	localMediationBannerAdapter	MediationBannerAdapter
    //   118	76	10	localbx	bx
    // Exception table:
    //   from	to	target	type
    //   57	86	209	java/lang/Throwable
    //   86	120	209	java/lang/Throwable
    //   124	148	209	java/lang/Throwable
    //   148	202	209	java/lang/Throwable
  }
  
  public void destroy()
    throws RemoteException
  {
    try
    {
      this.nQ.onDestroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      ev.c("Could not destroy adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public d getView()
    throws RemoteException
  {
    if (!(this.nQ instanceof MediationBannerAdapter))
    {
      ev.D("MediationAdapter is not a MediationBannerAdapter: " + this.nQ.getClass().getCanonicalName());
      throw new RemoteException();
    }
    try
    {
      d locald = e.h(((MediationBannerAdapter)this.nQ).getBannerView());
      return locald;
    }
    catch (Throwable localThrowable)
    {
      ev.c("Could not get banner view from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void pause()
    throws RemoteException
  {
    try
    {
      this.nQ.onPause();
      return;
    }
    catch (Throwable localThrowable)
    {
      ev.c("Could not pause adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void resume()
    throws RemoteException
  {
    try
    {
      this.nQ.onResume();
      return;
    }
    catch (Throwable localThrowable)
    {
      ev.c("Could not resume adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void showInterstitial()
    throws RemoteException
  {
    if (!(this.nQ instanceof MediationInterstitialAdapter))
    {
      ev.D("MediationAdapter is not a MediationInterstitialAdapter: " + this.nQ.getClass().getCanonicalName());
      throw new RemoteException();
    }
    ev.z("Showing interstitial from adapter.");
    try
    {
      ((MediationInterstitialAdapter)this.nQ).showInterstitial();
      return;
    }
    catch (Throwable localThrowable)
    {
      ev.c("Could not show interstitial from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */