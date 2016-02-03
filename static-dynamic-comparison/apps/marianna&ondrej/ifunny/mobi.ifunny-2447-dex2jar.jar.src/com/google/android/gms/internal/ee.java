package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.b.b;
import com.google.android.gms.ads.b.c;
import com.google.android.gms.ads.b.e;
import com.google.android.gms.b.a;
import com.google.android.gms.b.d;

import java.util.Iterator;

import org.json.JSONObject;

@ii
public final class ee
        extends dy {
    private final b a;

    public ee(b paramb) {
        this.a = paramb;
    }

    private Bundle a(String paramString1, int paramInt, String paramString2) {
        mx.e("Server parameters: " + paramString1);
        Bundle localBundle;
        try {
            localBundle = new Bundle();
            if (paramString1 != null) {
                paramString1 = new JSONObject(paramString1);
                localBundle = new Bundle();
                Iterator localIterator = paramString1.keys();
                while (localIterator.hasNext()) {
                    String str = (String) localIterator.next();
                    localBundle.putString(str, paramString1.getString(str));
                }
            }
            if (!(this.a instanceof AdMobAdapter)) {
                break label138;
            }
        } catch (Throwable paramString1) {
            mx.d("Could not get Server Parameters Bundle.", paramString1);
            throw new RemoteException();
        }
        localBundle.putString("adJson", paramString2);
        localBundle.putInt("tagForChildDirectedTreatment", paramInt);
        label138:
        return localBundle;
    }

    public a a() {
        if (!(this.a instanceof c)) {
            mx.e("MediationAdapter is not a MediationBannerAdapter: " + this.a.getClass().getCanonicalName());
            throw new RemoteException();
        }
        try {
            a locala = d.a(((c) this.a).getBannerView());
            return locala;
        } catch (Throwable localThrowable) {
            mx.d("Could not get banner view from adapter.", localThrowable);
            throw new RemoteException();
        }
    }

    public void a(a parama, av paramav, String paramString, ea paramea) {
        a(parama, paramav, paramString, null, paramea);
    }

    /* Error */
    public void a(a parama, av paramav, String paramString1, String paramString2, ea paramea) {
        // Byte code:
        //   0: aload_0
        //   1: getfield 14	com/google/android/gms/internal/ee:a	Lcom/google/android/gms/ads/b/b;
        //   4: instanceof 120
        //   7: ifne +42 -> 49
        //   10: new 20	java/lang/StringBuilder
        //   13: dup
        //   14: invokespecial 21	java/lang/StringBuilder:<init>	()V
        //   17: ldc 122
        //   19: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   22: aload_0
        //   23: getfield 14	com/google/android/gms/internal/ee:a	Lcom/google/android/gms/ads/b/b;
        //   26: invokevirtual 98	java/lang/Object:getClass	()Ljava/lang/Class;
        //   29: invokevirtual 103	java/lang/Class:getCanonicalName	()Ljava/lang/String;
        //   32: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   35: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   38: invokestatic 37	com/google/android/gms/internal/mx:e	(Ljava/lang/String;)V
        //   41: new 76	android/os/RemoteException
        //   44: dup
        //   45: invokespecial 77	android/os/RemoteException:<init>	()V
        //   48: athrow
        //   49: ldc 124
        //   51: invokestatic 126	com/google/android/gms/internal/mx:a	(Ljava/lang/String;)V
        //   54: aload_0
        //   55: getfield 14	com/google/android/gms/internal/ee:a	Lcom/google/android/gms/ads/b/b;
        //   58: checkcast 120	com/google/android/gms/ads/b/e
        //   61: astore 7
        //   63: aload_2
        //   64: getfield 131	com/google/android/gms/internal/av:e	Ljava/util/List;
        //   67: ifnull +117 -> 184
        //   70: new 133	java/util/HashSet
        //   73: dup
        //   74: aload_2
        //   75: getfield 131	com/google/android/gms/internal/av:e	Ljava/util/List;
        //   78: invokespecial 136	java/util/HashSet:<init>	(Ljava/util/Collection;)V
        //   81: astore 6
        //   83: new 138	com/google/android/gms/internal/ed
        //   86: dup
        //   87: new 140	java/util/Date
        //   90: dup
        //   91: aload_2
        //   92: getfield 144	com/google/android/gms/internal/av:b	J
        //   95: invokespecial 147	java/util/Date:<init>	(J)V
        //   98: aload_2
        //   99: getfield 150	com/google/android/gms/internal/av:d	I
        //   102: aload 6
        //   104: aload_2
        //   105: getfield 154	com/google/android/gms/internal/av:k	Landroid/location/Location;
        //   108: aload_2
        //   109: getfield 158	com/google/android/gms/internal/av:f	Z
        //   112: aload_2
        //   113: getfield 161	com/google/android/gms/internal/av:g	I
        //   116: invokespecial 164	com/google/android/gms/internal/ed:<init>	(Ljava/util/Date;ILjava/util/Set;Landroid/location/Location;ZI)V
        //   119: astore 8
        //   121: aload_2
        //   122: getfield 168	com/google/android/gms/internal/av:m	Landroid/os/Bundle;
        //   125: ifnull +65 -> 190
        //   128: aload_2
        //   129: getfield 168	com/google/android/gms/internal/av:m	Landroid/os/Bundle;
        //   132: aload 7
        //   134: invokevirtual 98	java/lang/Object:getClass	()Ljava/lang/Class;
        //   137: invokevirtual 171	java/lang/Class:getName	()Ljava/lang/String;
        //   140: invokevirtual 175	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
        //   143: astore 6
        //   145: aload 7
        //   147: aload_1
        //   148: invokestatic 178	com/google/android/gms/b/d:a	(Lcom/google/android/gms/b/a;)Ljava/lang/Object;
        //   151: checkcast 180	android/content/Context
        //   154: new 182	com/google/android/gms/internal/ef
        //   157: dup
        //   158: aload 5
        //   160: invokespecial 185	com/google/android/gms/internal/ef:<init>	(Lcom/google/android/gms/internal/ea;)V
        //   163: aload_0
        //   164: aload_3
        //   165: aload_2
        //   166: getfield 161	com/google/android/gms/internal/av:g	I
        //   169: aload 4
        //   171: invokespecial 187	com/google/android/gms/internal/ee:a	(Ljava/lang/String;ILjava/lang/String;)Landroid/os/Bundle;
        //   174: aload 8
        //   176: aload 6
        //   178: invokeinterface 191 6 0
        //   183: return
        //   184: aconst_null
        //   185: astore 6
        //   187: goto -104 -> 83
        //   190: aconst_null
        //   191: astore 6
        //   193: goto -48 -> 145
        //   196: astore_1
        //   197: ldc -63
        //   199: aload_1
        //   200: invokestatic 74	com/google/android/gms/internal/mx:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   203: new 76	android/os/RemoteException
        //   206: dup
        //   207: invokespecial 77	android/os/RemoteException:<init>	()V
        //   210: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	211	0	this	ee
        //   0	211	1	parama	a
        //   0	211	2	paramav	av
        //   0	211	3	paramString1	String
        //   0	211	4	paramString2	String
        //   0	211	5	paramea	ea
        //   81	111	6	localObject	Object
        //   61	85	7	locale	e
        //   119	56	8	localed	ed
        // Exception table:
        //   from	to	target	type
        //   54	83	196	java/lang/Throwable
        //   83	145	196	java/lang/Throwable
        //   145	183	196	java/lang/Throwable
    }

    public void a(a parama, ay paramay, av paramav, String paramString, ea paramea) {
        a(parama, paramay, paramav, paramString, null, paramea);
    }

    /* Error */
    public void a(a parama, ay paramay, av paramav, String paramString1, String paramString2, ea paramea) {
        // Byte code:
        //   0: aconst_null
        //   1: astore 8
        //   3: aload_0
        //   4: getfield 14	com/google/android/gms/internal/ee:a	Lcom/google/android/gms/ads/b/b;
        //   7: instanceof 90
        //   10: ifne +42 -> 52
        //   13: new 20	java/lang/StringBuilder
        //   16: dup
        //   17: invokespecial 21	java/lang/StringBuilder:<init>	()V
        //   20: ldc 92
        //   22: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   25: aload_0
        //   26: getfield 14	com/google/android/gms/internal/ee:a	Lcom/google/android/gms/ads/b/b;
        //   29: invokevirtual 98	java/lang/Object:getClass	()Ljava/lang/Class;
        //   32: invokevirtual 103	java/lang/Class:getCanonicalName	()Ljava/lang/String;
        //   35: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   38: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   41: invokestatic 37	com/google/android/gms/internal/mx:e	(Ljava/lang/String;)V
        //   44: new 76	android/os/RemoteException
        //   47: dup
        //   48: invokespecial 77	android/os/RemoteException:<init>	()V
        //   51: athrow
        //   52: ldc -57
        //   54: invokestatic 126	com/google/android/gms/internal/mx:a	(Ljava/lang/String;)V
        //   57: aload_0
        //   58: getfield 14	com/google/android/gms/internal/ee:a	Lcom/google/android/gms/ads/b/b;
        //   61: checkcast 90	com/google/android/gms/ads/b/c
        //   64: astore 9
        //   66: aload_3
        //   67: getfield 131	com/google/android/gms/internal/av:e	Ljava/util/List;
        //   70: ifnull +137 -> 207
        //   73: new 133	java/util/HashSet
        //   76: dup
        //   77: aload_3
        //   78: getfield 131	com/google/android/gms/internal/av:e	Ljava/util/List;
        //   81: invokespecial 136	java/util/HashSet:<init>	(Ljava/util/Collection;)V
        //   84: astore 7
        //   86: new 138	com/google/android/gms/internal/ed
        //   89: dup
        //   90: new 140	java/util/Date
        //   93: dup
        //   94: aload_3
        //   95: getfield 144	com/google/android/gms/internal/av:b	J
        //   98: invokespecial 147	java/util/Date:<init>	(J)V
        //   101: aload_3
        //   102: getfield 150	com/google/android/gms/internal/av:d	I
        //   105: aload 7
        //   107: aload_3
        //   108: getfield 154	com/google/android/gms/internal/av:k	Landroid/location/Location;
        //   111: aload_3
        //   112: getfield 158	com/google/android/gms/internal/av:f	Z
        //   115: aload_3
        //   116: getfield 161	com/google/android/gms/internal/av:g	I
        //   119: invokespecial 164	com/google/android/gms/internal/ed:<init>	(Ljava/util/Date;ILjava/util/Set;Landroid/location/Location;ZI)V
        //   122: astore 10
        //   124: aload 8
        //   126: astore 7
        //   128: aload_3
        //   129: getfield 168	com/google/android/gms/internal/av:m	Landroid/os/Bundle;
        //   132: ifnull +20 -> 152
        //   135: aload_3
        //   136: getfield 168	com/google/android/gms/internal/av:m	Landroid/os/Bundle;
        //   139: aload 9
        //   141: invokevirtual 98	java/lang/Object:getClass	()Ljava/lang/Class;
        //   144: invokevirtual 171	java/lang/Class:getName	()Ljava/lang/String;
        //   147: invokevirtual 175	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
        //   150: astore 7
        //   152: aload 9
        //   154: aload_1
        //   155: invokestatic 178	com/google/android/gms/b/d:a	(Lcom/google/android/gms/b/a;)Ljava/lang/Object;
        //   158: checkcast 180	android/content/Context
        //   161: new 182	com/google/android/gms/internal/ef
        //   164: dup
        //   165: aload 6
        //   167: invokespecial 185	com/google/android/gms/internal/ef:<init>	(Lcom/google/android/gms/internal/ea;)V
        //   170: aload_0
        //   171: aload 4
        //   173: aload_3
        //   174: getfield 161	com/google/android/gms/internal/av:g	I
        //   177: aload 5
        //   179: invokespecial 187	com/google/android/gms/internal/ee:a	(Ljava/lang/String;ILjava/lang/String;)Landroid/os/Bundle;
        //   182: aload_2
        //   183: getfield 203	com/google/android/gms/internal/ay:f	I
        //   186: aload_2
        //   187: getfield 206	com/google/android/gms/internal/ay:c	I
        //   190: aload_2
        //   191: getfield 209	com/google/android/gms/internal/ay:b	Ljava/lang/String;
        //   194: invokestatic 214	com/google/android/gms/ads/h:a	(IILjava/lang/String;)Lcom/google/android/gms/ads/e;
        //   197: aload 10
        //   199: aload 7
        //   201: invokeinterface 218 7 0
        //   206: return
        //   207: aconst_null
        //   208: astore 7
        //   210: goto -124 -> 86
        //   213: astore_1
        //   214: ldc -36
        //   216: aload_1
        //   217: invokestatic 74	com/google/android/gms/internal/mx:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   220: new 76	android/os/RemoteException
        //   223: dup
        //   224: invokespecial 77	android/os/RemoteException:<init>	()V
        //   227: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	228	0	this	ee
        //   0	228	1	parama	a
        //   0	228	2	paramay	ay
        //   0	228	3	paramav	av
        //   0	228	4	paramString1	String
        //   0	228	5	paramString2	String
        //   0	228	6	paramea	ea
        //   84	125	7	localObject1	Object
        //   1	124	8	localObject2	Object
        //   64	89	9	localc	c
        //   122	76	10	localed	ed
        // Exception table:
        //   from	to	target	type
        //   57	86	213	java/lang/Throwable
        //   86	124	213	java/lang/Throwable
        //   128	152	213	java/lang/Throwable
        //   152	206	213	java/lang/Throwable
    }

    public void b() {
        if (!(this.a instanceof e)) {
            mx.e("MediationAdapter is not a MediationInterstitialAdapter: " + this.a.getClass().getCanonicalName());
            throw new RemoteException();
        }
        mx.a("Showing interstitial from adapter.");
        try {
            ((e) this.a).showInterstitial();
            return;
        } catch (Throwable localThrowable) {
            mx.d("Could not show interstitial from adapter.", localThrowable);
            throw new RemoteException();
        }
    }

    public void c() {
        try {
            this.a.onDestroy();
            return;
        } catch (Throwable localThrowable) {
            mx.d("Could not destroy adapter.", localThrowable);
            throw new RemoteException();
        }
    }

    public void d() {
        try {
            this.a.onPause();
            return;
        } catch (Throwable localThrowable) {
            mx.d("Could not pause adapter.", localThrowable);
            throw new RemoteException();
        }
    }

    public void e() {
        try {
            this.a.onResume();
            return;
        } catch (Throwable localThrowable) {
            mx.d("Could not resume adapter.", localThrowable);
            throw new RemoteException();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */