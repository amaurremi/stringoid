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

public final class bu
  extends br.a
{
  private final MediationAdapter nE;
  private final Bundle nF;
  
  public bu(MediationAdapter paramMediationAdapter, Bundle paramBundle)
  {
    this.nE = paramMediationAdapter;
    this.nF = paramBundle;
  }
  
  private Bundle a(String paramString1, int paramInt, String paramString2)
    throws RemoteException
  {
    dw.z("Server parameters: " + paramString1);
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
      if (!(this.nE instanceof AdMobAdapter)) {
        break label138;
      }
    }
    catch (Throwable paramString1)
    {
      dw.c("Could not get Server Parameters Bundle.", paramString1);
      throw new RemoteException();
    }
    localBundle.putString("adJson", paramString2);
    localBundle.putInt("tagForChildDirectedTreatment", paramInt);
    label138:
    return localBundle;
  }
  
  public void a(d paramd, ah paramah, String paramString, bs parambs)
    throws RemoteException
  {
    a(paramd, paramah, paramString, null, parambs);
  }
  
  /* Error */
  public void a(d paramd, ah paramah, String paramString1, String paramString2, bs parambs)
    throws RemoteException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 15	com/google/android/gms/internal/bu:nE	Lcom/google/android/gms/ads/mediation/MediationAdapter;
    //   4: instanceof 98
    //   7: ifne +42 -> 49
    //   10: new 26	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   17: ldc 100
    //   19: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_0
    //   23: getfield 15	com/google/android/gms/internal/bu:nE	Lcom/google/android/gms/ads/mediation/MediationAdapter;
    //   26: invokevirtual 106	java/lang/Object:getClass	()Ljava/lang/Class;
    //   29: invokevirtual 111	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   32: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 43	com/google/android/gms/internal/dw:z	(Ljava/lang/String;)V
    //   41: new 22	android/os/RemoteException
    //   44: dup
    //   45: invokespecial 81	android/os/RemoteException:<init>	()V
    //   48: athrow
    //   49: ldc 113
    //   51: invokestatic 116	com/google/android/gms/internal/dw:v	(Ljava/lang/String;)V
    //   54: aload_0
    //   55: getfield 15	com/google/android/gms/internal/bu:nE	Lcom/google/android/gms/ads/mediation/MediationAdapter;
    //   58: checkcast 98	com/google/android/gms/ads/mediation/MediationInterstitialAdapter
    //   61: astore 7
    //   63: aload_2
    //   64: getfield 122	com/google/android/gms/internal/ah:lJ	Ljava/util/List;
    //   67: ifnull +91 -> 158
    //   70: new 124	java/util/HashSet
    //   73: dup
    //   74: aload_2
    //   75: getfield 122	com/google/android/gms/internal/ah:lJ	Ljava/util/List;
    //   78: invokespecial 127	java/util/HashSet:<init>	(Ljava/util/Collection;)V
    //   81: astore 6
    //   83: new 129	com/google/android/gms/internal/bt
    //   86: dup
    //   87: new 131	java/util/Date
    //   90: dup
    //   91: aload_2
    //   92: getfield 135	com/google/android/gms/internal/ah:lH	J
    //   95: invokespecial 138	java/util/Date:<init>	(J)V
    //   98: aload_2
    //   99: getfield 142	com/google/android/gms/internal/ah:lI	I
    //   102: aload 6
    //   104: aload_2
    //   105: getfield 146	com/google/android/gms/internal/ah:lK	Z
    //   108: aload_2
    //   109: getfield 149	com/google/android/gms/internal/ah:lL	I
    //   112: invokespecial 152	com/google/android/gms/internal/bt:<init>	(Ljava/util/Date;ILjava/util/Set;ZI)V
    //   115: astore 6
    //   117: aload 7
    //   119: aload_1
    //   120: invokestatic 158	com/google/android/gms/dynamic/e:d	(Lcom/google/android/gms/dynamic/d;)Ljava/lang/Object;
    //   123: checkcast 160	android/content/Context
    //   126: new 162	com/google/android/gms/internal/bv
    //   129: dup
    //   130: aload 5
    //   132: invokespecial 165	com/google/android/gms/internal/bv:<init>	(Lcom/google/android/gms/internal/bs;)V
    //   135: aload_0
    //   136: aload_3
    //   137: aload_2
    //   138: getfield 149	com/google/android/gms/internal/ah:lL	I
    //   141: aload 4
    //   143: invokespecial 167	com/google/android/gms/internal/bu:a	(Ljava/lang/String;ILjava/lang/String;)Landroid/os/Bundle;
    //   146: aload 6
    //   148: aload_0
    //   149: getfield 17	com/google/android/gms/internal/bu:nF	Landroid/os/Bundle;
    //   152: invokeinterface 171 6 0
    //   157: return
    //   158: aconst_null
    //   159: astore 6
    //   161: goto -78 -> 83
    //   164: astore_1
    //   165: ldc -83
    //   167: aload_1
    //   168: invokestatic 80	com/google/android/gms/internal/dw:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   171: new 22	android/os/RemoteException
    //   174: dup
    //   175: invokespecial 81	android/os/RemoteException:<init>	()V
    //   178: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	bu
    //   0	179	1	paramd	d
    //   0	179	2	paramah	ah
    //   0	179	3	paramString1	String
    //   0	179	4	paramString2	String
    //   0	179	5	parambs	bs
    //   81	79	6	localObject	Object
    //   61	57	7	localMediationInterstitialAdapter	MediationInterstitialAdapter
    // Exception table:
    //   from	to	target	type
    //   54	83	164	java/lang/Throwable
    //   83	157	164	java/lang/Throwable
  }
  
  public void a(d paramd, ak paramak, ah paramah, String paramString, bs parambs)
    throws RemoteException
  {
    a(paramd, paramak, paramah, paramString, null, parambs);
  }
  
  /* Error */
  public void a(d paramd, ak paramak, ah paramah, String paramString1, String paramString2, bs parambs)
    throws RemoteException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 15	com/google/android/gms/internal/bu:nE	Lcom/google/android/gms/ads/mediation/MediationAdapter;
    //   4: instanceof 179
    //   7: ifne +42 -> 49
    //   10: new 26	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   17: ldc -75
    //   19: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_0
    //   23: getfield 15	com/google/android/gms/internal/bu:nE	Lcom/google/android/gms/ads/mediation/MediationAdapter;
    //   26: invokevirtual 106	java/lang/Object:getClass	()Ljava/lang/Class;
    //   29: invokevirtual 111	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   32: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 43	com/google/android/gms/internal/dw:z	(Ljava/lang/String;)V
    //   41: new 22	android/os/RemoteException
    //   44: dup
    //   45: invokespecial 81	android/os/RemoteException:<init>	()V
    //   48: athrow
    //   49: ldc -73
    //   51: invokestatic 116	com/google/android/gms/internal/dw:v	(Ljava/lang/String;)V
    //   54: aload_0
    //   55: getfield 15	com/google/android/gms/internal/bu:nE	Lcom/google/android/gms/ads/mediation/MediationAdapter;
    //   58: checkcast 179	com/google/android/gms/ads/mediation/MediationBannerAdapter
    //   61: astore 8
    //   63: aload_3
    //   64: getfield 122	com/google/android/gms/internal/ah:lJ	Ljava/util/List;
    //   67: ifnull +107 -> 174
    //   70: new 124	java/util/HashSet
    //   73: dup
    //   74: aload_3
    //   75: getfield 122	com/google/android/gms/internal/ah:lJ	Ljava/util/List;
    //   78: invokespecial 127	java/util/HashSet:<init>	(Ljava/util/Collection;)V
    //   81: astore 7
    //   83: new 129	com/google/android/gms/internal/bt
    //   86: dup
    //   87: new 131	java/util/Date
    //   90: dup
    //   91: aload_3
    //   92: getfield 135	com/google/android/gms/internal/ah:lH	J
    //   95: invokespecial 138	java/util/Date:<init>	(J)V
    //   98: aload_3
    //   99: getfield 142	com/google/android/gms/internal/ah:lI	I
    //   102: aload 7
    //   104: aload_3
    //   105: getfield 146	com/google/android/gms/internal/ah:lK	Z
    //   108: aload_3
    //   109: getfield 149	com/google/android/gms/internal/ah:lL	I
    //   112: invokespecial 152	com/google/android/gms/internal/bt:<init>	(Ljava/util/Date;ILjava/util/Set;ZI)V
    //   115: astore 7
    //   117: aload 8
    //   119: aload_1
    //   120: invokestatic 158	com/google/android/gms/dynamic/e:d	(Lcom/google/android/gms/dynamic/d;)Ljava/lang/Object;
    //   123: checkcast 160	android/content/Context
    //   126: new 162	com/google/android/gms/internal/bv
    //   129: dup
    //   130: aload 6
    //   132: invokespecial 165	com/google/android/gms/internal/bv:<init>	(Lcom/google/android/gms/internal/bs;)V
    //   135: aload_0
    //   136: aload 4
    //   138: aload_3
    //   139: getfield 149	com/google/android/gms/internal/ah:lL	I
    //   142: aload 5
    //   144: invokespecial 167	com/google/android/gms/internal/bu:a	(Ljava/lang/String;ILjava/lang/String;)Landroid/os/Bundle;
    //   147: aload_2
    //   148: getfield 188	com/google/android/gms/internal/ak:width	I
    //   151: aload_2
    //   152: getfield 191	com/google/android/gms/internal/ak:height	I
    //   155: aload_2
    //   156: getfield 195	com/google/android/gms/internal/ak:lS	Ljava/lang/String;
    //   159: invokestatic 200	com/google/android/gms/ads/a:a	(IILjava/lang/String;)Lcom/google/android/gms/ads/AdSize;
    //   162: aload 7
    //   164: aload_0
    //   165: getfield 17	com/google/android/gms/internal/bu:nF	Landroid/os/Bundle;
    //   168: invokeinterface 204 7 0
    //   173: return
    //   174: aconst_null
    //   175: astore 7
    //   177: goto -94 -> 83
    //   180: astore_1
    //   181: ldc -50
    //   183: aload_1
    //   184: invokestatic 80	com/google/android/gms/internal/dw:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   187: new 22	android/os/RemoteException
    //   190: dup
    //   191: invokespecial 81	android/os/RemoteException:<init>	()V
    //   194: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	bu
    //   0	195	1	paramd	d
    //   0	195	2	paramak	ak
    //   0	195	3	paramah	ah
    //   0	195	4	paramString1	String
    //   0	195	5	paramString2	String
    //   0	195	6	parambs	bs
    //   81	95	7	localObject	Object
    //   61	57	8	localMediationBannerAdapter	MediationBannerAdapter
    // Exception table:
    //   from	to	target	type
    //   54	83	180	java/lang/Throwable
    //   83	173	180	java/lang/Throwable
  }
  
  public void destroy()
    throws RemoteException
  {
    try
    {
      this.nE.onDestroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      dw.c("Could not destroy adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public d getView()
    throws RemoteException
  {
    if (!(this.nE instanceof MediationBannerAdapter))
    {
      dw.z("MediationAdapter is not a MediationBannerAdapter: " + this.nE.getClass().getCanonicalName());
      throw new RemoteException();
    }
    try
    {
      d locald = e.h(((MediationBannerAdapter)this.nE).getBannerView());
      return locald;
    }
    catch (Throwable localThrowable)
    {
      dw.c("Could not get banner view from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void pause()
    throws RemoteException
  {
    try
    {
      this.nE.onPause();
      return;
    }
    catch (Throwable localThrowable)
    {
      dw.c("Could not pause adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void resume()
    throws RemoteException
  {
    try
    {
      this.nE.onResume();
      return;
    }
    catch (Throwable localThrowable)
    {
      dw.c("Could not resume adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void showInterstitial()
    throws RemoteException
  {
    if (!(this.nE instanceof MediationInterstitialAdapter))
    {
      dw.z("MediationAdapter is not a MediationInterstitialAdapter: " + this.nE.getClass().getCanonicalName());
      throw new RemoteException();
    }
    dw.v("Showing interstitial from adapter.");
    try
    {
      ((MediationInterstitialAdapter)this.nE).showInterstitial();
      return;
    }
    catch (Throwable localThrowable)
    {
      dw.c("Could not show interstitial from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */