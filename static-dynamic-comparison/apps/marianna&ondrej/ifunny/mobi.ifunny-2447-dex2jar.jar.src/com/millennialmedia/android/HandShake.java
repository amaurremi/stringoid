package com.millennialmedia.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.millennialmedia.a.a.j;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class HandShake {
    static String a = "28913";
    private static String l = "https://ads.mp.mydas.mobi/appConfigServlet?apid=";
    private static boolean m;
    private static HandShake n;
    private static String y = "http://androidsdk.ads.mp.mydas.mobi/getAd.php5?";
    boolean b = false;
    String c;
    long d = 259200000L;
    boolean e;
    String f;
    String g;
    long h;
    String i;
    HandShake.NuanceCredentials j;
    DTOCachedVideo[] k;
    private WeakReference<Context> o;
    private WeakReference<Context> p;
    private final Handler q = new Handler(Looper.getMainLooper());
    private long r;
    private String s;
    private final LinkedHashMap<String, HandShake.AdTypeHandShake> t = new LinkedHashMap();
    private final ArrayList<HandShake.Scheme> u = new ArrayList();
    private String v;
    private long w = 3600000L;
    private long x = 86400000L;
    private final Runnable z = new HandShake
    .2(this);

    private HandShake() {
    }

    private HandShake(Context paramContext) {
        this.o = new WeakReference(paramContext);
        this.p = new WeakReference(paramContext.getApplicationContext());
        if ((m) || (!f(paramContext)) || (System.currentTimeMillis() - this.r > this.x)) {
            m = false;
            this.r = System.currentTimeMillis();
            a(false);
        }
    }

    /* Error */
    static HandShake a(Context paramContext) {
        // Byte code:
        //   0: ldc 2
        //   2: monitorenter
        //   3: getstatic 50	com/millennialmedia/android/HandShake:a	Ljava/lang/String;
        //   6: ifnonnull +17 -> 23
        //   9: ldc -115
        //   11: ldc -113
        //   13: invokestatic 148	com/millennialmedia/android/MMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   16: aconst_null
        //   17: astore_0
        //   18: ldc 2
        //   20: monitorexit
        //   21: aload_0
        //   22: areturn
        //   23: getstatic 150	com/millennialmedia/android/HandShake:n	Lcom/millennialmedia/android/HandShake;
        //   26: ifnonnull +21 -> 47
        //   29: new 2	com/millennialmedia/android/HandShake
        //   32: dup
        //   33: aload_0
        //   34: invokespecial 152	com/millennialmedia/android/HandShake:<init>	(Landroid/content/Context;)V
        //   37: putstatic 150	com/millennialmedia/android/HandShake:n	Lcom/millennialmedia/android/HandShake;
        //   40: getstatic 150	com/millennialmedia/android/HandShake:n	Lcom/millennialmedia/android/HandShake;
        //   43: astore_0
        //   44: goto -26 -> 18
        //   47: invokestatic 133	java/lang/System:currentTimeMillis	()J
        //   50: getstatic 150	com/millennialmedia/android/HandShake:n	Lcom/millennialmedia/android/HandShake;
        //   53: getfield 135	com/millennialmedia/android/HandShake:r	J
        //   56: lsub
        //   57: getstatic 150	com/millennialmedia/android/HandShake:n	Lcom/millennialmedia/android/HandShake;
        //   60: getfield 95	com/millennialmedia/android/HandShake:x	J
        //   63: lcmp
        //   64: ifle -24 -> 40
        //   67: ldc -115
        //   69: ldc -102
        //   71: invokestatic 156	com/millennialmedia/android/MMLog:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   74: new 2	com/millennialmedia/android/HandShake
        //   77: dup
        //   78: aload_0
        //   79: invokespecial 152	com/millennialmedia/android/HandShake:<init>	(Landroid/content/Context;)V
        //   82: putstatic 150	com/millennialmedia/android/HandShake:n	Lcom/millennialmedia/android/HandShake;
        //   85: goto -45 -> 40
        //   88: astore_0
        //   89: ldc 2
        //   91: monitorexit
        //   92: aload_0
        //   93: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	94	0	paramContext	Context
        // Exception table:
        //   from	to	target	type
        //   3	16	88	finally
        //   23	40	88	finally
        //   40	44	88	finally
        //   47	85	88	finally
    }

    static String a() {
        if ((!TextUtils.isEmpty(y)) && (URLUtil.isHttpUrl(y.replace("getAd.php5?", "")))) {
            return y;
        }
        return "http://androidsdk.ads.mp.mydas.mobi/getAd.php5?";
    }

    static void a(String paramString) {
        if (!TextUtils.isEmpty(paramString)) {
            if (!paramString.endsWith("/")) {
                y = paramString + "/" + "getAd.php5?";
            }
        } else {
            return;
        }
        y = paramString + "getAd.php5?";
    }

    private void a(JSONObject paramJSONObject) {
        Context localContext = (Context) this.o.get();
        Object localObject1;
        int i1;
        label57:
        Object localObject3;
        Object localObject2;
        if (localContext == null) {
            localContext = (Context) this.p.get();
            if (localContext == null) {
                MMLog.e("HandShake", "No context for handshake");
            }
            while (paramJSONObject == null) {
                return;
            }
            try {
                localObject1 = paramJSONObject.optJSONArray("errors");
                if (localObject1 != null) {
                    i1 = 0;
                    if (i1 < ((JSONArray) localObject1).length()) {
                        localObject3 = ((JSONArray) localObject1).optJSONObject(i1);
                        if (localObject3 == null) {
                            break label612;
                        }
                        localObject2 = ((JSONObject) localObject3).optString("message", null);
                        localObject3 = ((JSONObject) localObject3).optString("type", null);
                        if ((localObject2 == null) || (localObject3 == null)) {
                            break label612;
                        }
                        if (((String) localObject3).equalsIgnoreCase("log")) {
                            MMLog.e("HandShake", (String) localObject2);
                        } else if (((String) localObject3).equalsIgnoreCase("prompt")) {
                            this.q.post(new HandShake .3 (this, localContext, (String) localObject2));
                        }
                    }
                }
            } catch (Exception paramJSONObject) {
                MMLog.a("HandShake", "Error deserializing handshake", paramJSONObject);
                return;
            }
            localObject1 = paramJSONObject.optJSONObject("adtypes");
            if (localObject1 != null) {
                localObject2 = MMAdImpl.l();
                i1 = 0;
                label193:
                if (i1 < localObject2.length) {
                    localObject3 = ((JSONObject) localObject1).optJSONObject(localObject2[i1]);
                    if (localObject3 == null) {
                        break label619;
                    }
                    HandShake.AdTypeHandShake localAdTypeHandShake = new HandShake.AdTypeHandShake(this);
                    localAdTypeHandShake.a((JSONObject) localObject3);
                    localAdTypeHandShake.b(localContext, localObject2[i1]);
                    this.t.put(localObject2[i1], localAdTypeHandShake);
                    break label619;
                }
            }
        }
        for (; ; ) {
            try {
                localObject1 = paramJSONObject.optJSONArray("schemes");
                if (localObject1 != null) {
                    if ((this.u == null) || (this.u.size() <= 0)) {
                        break label626;
                    }
                    this.u.removeAll(this.u);
                    break label626;
                    if (i1 < ((JSONArray) localObject1).length()) {
                        localObject2 = ((JSONArray) localObject1).optJSONObject(i1);
                        if (localObject2 == null) {
                            break label631;
                        }
                        localObject3 = new HandShake.Scheme(this);
                        ((HandShake.Scheme) localObject3).a((JSONObject) localObject2);
                        this.u.add(localObject3);
                        break label631;
                    }
                }
                this.h = paramJSONObject.optLong("adrefresh", 0L);
                this.w = (paramJSONObject.optLong("deferredviewtimeout", 3600L) * 1000L);
                this.b = paramJSONObject.optBoolean("kill");
                a(paramJSONObject.optString("baseURL"));
                this.x = (paramJSONObject.optLong("handshakecallback", 86400L) * 1000L);
                this.d = (paramJSONObject.optLong("creativeCacheTimeout", 259200L) * 1000L);
                this.e = paramJSONObject.optBoolean("hardwareAccelerationEnabled");
                this.f = paramJSONObject.optString("startSessionURL");
                this.g = paramJSONObject.optString("endSessionURL");
                localObject1 = paramJSONObject.optString("nuanceCredentials");
                this.j = ((HandShake.NuanceCredentials) new j().a((String) localObject1, HandShake.NuanceCredentials.class));
                this.i = paramJSONObject.optString("mmjs");
                a(paramJSONObject, localContext);
                if ((!TextUtils.isEmpty(this.i)) && (!MRaid.d(localContext, this.i))) {
                    MRaid.b((Context) this.p.get(), this.i);
                    return;
                }
            } finally {
            }
            MMLog.d("HandShake", "Not downloading MMJS - (" + this.i + ")");
            return;
            break;
            label612:
            i1 += 1;
            break label57;
            label619:
            i1 += 1;
            break label193;
            label626:
            i1 = 0;
            continue;
            label631:
            i1 += 1;
        }
    }

    private void a(JSONObject paramJSONObject, Context paramContext) {
        JSONArray localJSONArray = paramJSONObject.optJSONArray("cachedVideos");
        if (localJSONArray != null) {
            this.k = ((DTOCachedVideo[]) new j().a(localJSONArray.toString(), DTOCachedVideo[].class));
            MMLog.b("HandShake", this.k.toString());
        }
        this.s = paramJSONObject.optString("noVideosToCacheURL");
        if (this.k != null) {
            PreCacheWorker.a(this.k, paramContext, this.s);
        }
    }

    private void a(boolean paramBoolean) {
        Object localObject = (Context) this.o.get();
        if (localObject != null) {
            localObject = ((Context) localObject).getSharedPreferences("MillennialMediaSettings", 0).getString("handShakeUrl", null);
            if (localObject != null) {
                b((String) localObject);
            }
        }
        Utils.ThreadUtils.a(new HandShake .1 (this, paramBoolean));
    }

    /* Error */
    static boolean b(String paramString) {
        // Byte code:
        //   0: ldc 2
        //   2: monitorenter
        //   3: aload_0
        //   4: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   7: istore_1
        //   8: iload_1
        //   9: ifeq +10 -> 19
        //   12: iconst_0
        //   13: istore_1
        //   14: ldc 2
        //   16: monitorexit
        //   17: iload_1
        //   18: ireturn
        //   19: aload_0
        //   20: astore_2
        //   21: aload_0
        //   22: ldc_w 422
        //   25: invokevirtual 425	java/lang/String:startsWith	(Ljava/lang/String;)Z
        //   28: ifeq +14 -> 42
        //   31: aload_0
        //   32: ldc_w 422
        //   35: ldc_w 427
        //   38: invokevirtual 430	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   41: astore_2
        //   42: new 196	java/lang/StringBuilder
        //   45: dup
        //   46: invokespecial 197	java/lang/StringBuilder:<init>	()V
        //   49: aload_2
        //   50: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   53: ldc_w 432
        //   56: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   59: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   62: putstatic 54	com/millennialmedia/android/HandShake:l	Ljava/lang/String;
        //   65: iconst_1
        //   66: istore_1
        //   67: goto -53 -> 14
        //   70: astore_0
        //   71: ldc 2
        //   73: monitorexit
        //   74: aload_0
        //   75: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	76	0	paramString	String
        //   7	60	1	bool	boolean
        //   20	30	2	str	String
        // Exception table:
        //   from	to	target	type
        //   3	8	70	finally
        //   21	42	70	finally
        //   42	65	70	finally
    }

    private boolean d(Context paramContext) {
        if (paramContext == null) {
            return false;
        }
        return paramContext.getSharedPreferences("MillennialMediaSettings", 0).getBoolean("firstlaunchHandshake", true);
    }

    private void e(Context paramContext) {
        if (paramContext != null) {
            paramContext = paramContext.getSharedPreferences("MillennialMediaSettings", 0).edit();
            paramContext.putBoolean("firstlaunchHandshake", false);
            paramContext.commit();
        }
    }

    private boolean f(Context paramContext) {
        int i2 = 0;
        boolean bool2 = false;
        SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("MillennialMediaSettings", 0);
        if (localSharedPreferences == null) {
            return bool2;
        }
        boolean bool1;
        label57:
        Object localObject1;
        int i1;
        Object localObject2;
        if (localSharedPreferences.contains("handshake_deferredviewtimeout")) {
            this.w = localSharedPreferences.getLong("handshake_deferredviewtimeout", this.w);
            bool1 = true;
            if (localSharedPreferences.contains("handshake_baseUrl")) {
                y = localSharedPreferences.getString("handshake_baseUrl", y);
                bool1 = true;
            }
            if (localSharedPreferences.contains("handshake_callback")) {
                this.x = localSharedPreferences.getLong("handshake_callback", this.x);
                bool1 = true;
            }
            if (localSharedPreferences.contains("handshake_hardwareAccelerationEnabled")) {
                this.e = localSharedPreferences.getBoolean("handshake_hardwareAccelerationEnabled", false);
                bool1 = true;
            }
            if (localSharedPreferences.contains("handshake_startSessionURL")) {
                this.f = localSharedPreferences.getString("handshake_startSessionURL", "");
                bool1 = true;
            }
            if (localSharedPreferences.contains("handshake_endSessionURL")) {
                this.g = localSharedPreferences.getString("handshake_endSessionURL", "");
                bool1 = true;
            }
            if (localSharedPreferences.contains("handshake_nuanceCredentials")) {
                localObject1 = localSharedPreferences.getString("handshake_nuanceCredentials", "");
                this.j = ((HandShake.NuanceCredentials) new j().a((String) localObject1, HandShake.NuanceCredentials.class));
                bool1 = true;
            }
            if (localSharedPreferences.contains("handshake_mmdid")) {
                a(paramContext, localSharedPreferences.getString("handshake_mmdid", this.c), false);
                bool1 = true;
            }
            if (localSharedPreferences.contains("handshake_creativecachetimeout")) {
                this.d = localSharedPreferences.getLong("handshake_creativecachetimeout", this.d);
                bool1 = true;
            }
            if (localSharedPreferences.contains("handshake_mmjs")) {
                this.i = localSharedPreferences.getString("handshake_mmjs", this.i);
                bool1 = true;
            }
            localObject1 = MMAdImpl.l();
            i1 = 0;
            while (i1 < localObject1.length) {
                localObject2 = new HandShake.AdTypeHandShake(this);
                if (((HandShake.AdTypeHandShake) localObject2).a(localSharedPreferences, localObject1[i1])) {
                    this.t.put(localObject1[i1], localObject2);
                    bool1 = true;
                }
                i1 += 1;
            }
        }
        for (; ; ) {
            try {
                if (!localSharedPreferences.contains("handshake_schemes")) {
                    break label747;
                }
                localObject1 = localSharedPreferences.getString("handshake_schemes", "");
                if (((String) localObject1).length() <= 0) {
                    break label747;
                }
                localObject1 = ((String) localObject1).split("\n");
                int i3 = localObject1.length;
                i1 = i2;
                if (i1 >= i3) {
                    break label763;
                }
                localObject2 = localObject1[i1].split("\t");
                if (localObject2.length < 2) {
                    break label756;
                }
                localObject2 = new HandShake.Scheme(this, localObject2[0], Integer.parseInt(localObject2[1]));
                this.u.add(localObject2);
            } finally {
            }
            if (localSharedPreferences.contains("handshake_cachedvideos5.0")) {
                localObject1 = localSharedPreferences.getString("handshake_cachedvideos5.0", "");
                if (((String) localObject1).length() > 0) {
                    this.k = ((DTOCachedVideo[]) new j().a((String) localObject1, DTOCachedVideo[].class));
                }
            }
            if (localSharedPreferences.contains("handshake_lasthandshake")) {
                this.r = localSharedPreferences.getLong("handshake_lasthandshake", this.r);
                bool1 = true;
            }
            bool2 = bool1;
            if (!bool1) {
                break;
            }
            MMLog.b("HandShake", "Handshake successfully loaded from shared preferences.");
            if (System.currentTimeMillis() - this.r < this.x) {
                this.q.postDelayed(this.z, this.x - (System.currentTimeMillis() - this.r));
            }
            this.s = localSharedPreferences.getString("handshake_novideostocacheurl", "");
            bool2 = bool1;
            if (this.k == null) {
                break;
            }
            PreCacheWorker.a(this.k, paramContext, this.s);
            return bool1;
            label747:
            continue;
            bool1 = false;
            break label57;
            label756:
            i1 += 1;
            continue;
            label763:
            bool1 = true;
        }
    }

    private JSONObject g(String paramString) {
        MMLog.b("HandShake", String.format("JSON String: %s", new Object[]{paramString}));
        if (paramString != null) {
            try {
                paramString = new JSONObject(paramString);
                MMLog.a("HandShake", paramString.toString());
                if (paramString.has("mmishake")) {
                    paramString = paramString.getJSONObject("mmishake");
                    return paramString;
                }
            } catch (JSONException paramString) {
                MMLog.a("HandShake", "Error parsing json", paramString);
            }
        }
        return null;
    }

    private void g(Context paramContext) {
        paramContext = paramContext.getSharedPreferences("MillennialMediaSettings", 0).edit();
        paramContext.putLong("handshake_deferredviewtimeout", this.w);
        paramContext.putBoolean("handshake_kill", this.b);
        paramContext.putString("handshake_baseUrl", y);
        paramContext.putLong("handshake_callback", this.x);
        paramContext.putBoolean("handshake_hardwareAccelerationEnabled", this.e);
        paramContext.putString("handshake_startSessionURL", this.f);
        if (this.j != null) {
            paramContext.putString("handshake_nuanceCredentials", new j().a(this.j));
        }
        paramContext.putString("handshake_endSessionURL", this.g);
        paramContext.putLong("handshake_creativecaetimeout", this.d);
        paramContext.putString("handshake_mmjs", this.i);
        Object localObject1 = this.t.keySet().iterator();
        Object localObject2;
        while (((Iterator) localObject1).hasNext()) {
            localObject2 = (String) ((Iterator) localObject1).next();
            ((HandShake.AdTypeHandShake) this.t.get(localObject2)).a(paramContext, (String) localObject2);
        }
        try {
            localObject1 = new StringBuilder();
            int i1 = 0;
            while (i1 < this.u.size()) {
                localObject2 = (HandShake.Scheme) this.u.get(i1);
                if (i1 > 0) {
                    ((StringBuilder) localObject1).append("\n");
                }
                ((StringBuilder) localObject1).append(((HandShake.Scheme) localObject2).a + "\t" + ((HandShake.Scheme) localObject2).b);
                i1 += 1;
            }
            paramContext.putString("handshake_schemes", ((StringBuilder) localObject1).toString());
            if (this.k != null) {
                paramContext.putString("handshake_cachedvideos5.0", new j().a(this.k));
            }
            paramContext.putString("handshake_novideostocacheurl", this.s);
            paramContext.putLong("handshake_lasthandshake", this.r);
            paramContext.commit();
            return;
        } finally {
        }
    }

    /* Error */
    void a(Context paramContext, String paramString, boolean paramBoolean) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_2
        //   3: ifnull +74 -> 77
        //   6: aload_2
        //   7: invokevirtual 494	java/lang/String:length	()I
        //   10: ifeq +13 -> 23
        //   13: aload_2
        //   14: ldc_w 597
        //   17: invokevirtual 600	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   20: ifeq +57 -> 77
        //   23: aload_0
        //   24: aconst_null
        //   25: putfield 481	com/millennialmedia/android/HandShake:c	Ljava/lang/String;
        //   28: aload_0
        //   29: getfield 481	com/millennialmedia/android/HandShake:c	Ljava/lang/String;
        //   32: invokestatic 603	com/millennialmedia/android/MMSDK:a	(Ljava/lang/String;)V
        //   35: iload_3
        //   36: ifeq +38 -> 74
        //   39: aload_1
        //   40: ldc_w 391
        //   43: iconst_0
        //   44: invokevirtual 395	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
        //   47: invokeinterface 447 1 0
        //   52: astore_1
        //   53: aload_1
        //   54: ldc_w 479
        //   57: aload_0
        //   58: getfield 481	com/millennialmedia/android/HandShake:c	Ljava/lang/String;
        //   61: invokeinterface 556 3 0
        //   66: pop
        //   67: aload_1
        //   68: invokeinterface 457 1 0
        //   73: pop
        //   74: aload_0
        //   75: monitorexit
        //   76: return
        //   77: aload_0
        //   78: aload_2
        //   79: putfield 481	com/millennialmedia/android/HandShake:c	Ljava/lang/String;
        //   82: goto -54 -> 28
        //   85: astore_1
        //   86: aload_0
        //   87: monitorexit
        //   88: aload_1
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	HandShake
        //   0	90	1	paramContext	Context
        //   0	90	2	paramString	String
        //   0	90	3	paramBoolean	boolean
        // Exception table:
        //   from	to	target	type
        //   6	23	85	finally
        //   23	28	85	finally
        //   28	35	85	finally
        //   39	74	85	finally
        //   77	82	85	finally
    }

    /* Error */
    boolean a(Context paramContext, String paramString) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 80	com/millennialmedia/android/HandShake:t	Ljava/util/LinkedHashMap;
        //   6: aload_2
        //   7: invokevirtual 582	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
        //   10: checkcast 270	com/millennialmedia/android/HandShake$AdTypeHandShake
        //   13: astore_2
        //   14: aload_2
        //   15: ifnull +13 -> 28
        //   18: aload_2
        //   19: aload_1
        //   20: invokevirtual 605	com/millennialmedia/android/HandShake$AdTypeHandShake:a	(Landroid/content/Context;)Z
        //   23: istore_3
        //   24: aload_0
        //   25: monitorexit
        //   26: iload_3
        //   27: ireturn
        //   28: iconst_1
        //   29: istore_3
        //   30: goto -6 -> 24
        //   33: astore_1
        //   34: aload_0
        //   35: monitorexit
        //   36: aload_1
        //   37: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	38	0	this	HandShake
        //   0	38	1	paramContext	Context
        //   0	38	2	paramString	String
        //   23	7	3	bool	boolean
        // Exception table:
        //   from	to	target	type
        //   2	14	33	finally
        //   18	24	33	finally
    }

    /* Error */
    boolean a(String paramString, long paramLong) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 80	com/millennialmedia/android/HandShake:t	Ljava/util/LinkedHashMap;
        //   6: aload_1
        //   7: invokevirtual 582	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
        //   10: checkcast 270	com/millennialmedia/android/HandShake$AdTypeHandShake
        //   13: astore_1
        //   14: aload_1
        //   15: ifnull +15 -> 30
        //   18: aload_1
        //   19: lload_2
        //   20: invokevirtual 609	com/millennialmedia/android/HandShake$AdTypeHandShake:a	(J)Z
        //   23: istore 4
        //   25: aload_0
        //   26: monitorexit
        //   27: iload 4
        //   29: ireturn
        //   30: iconst_1
        //   31: istore 4
        //   33: goto -8 -> 25
        //   36: astore_1
        //   37: aload_0
        //   38: monitorexit
        //   39: aload_1
        //   40: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	41	0	this	HandShake
        //   0	41	1	paramString	String
        //   0	41	2	paramLong	long
        //   23	9	4	bool	boolean
        // Exception table:
        //   from	to	target	type
        //   2	14	36	finally
        //   18	25	36	finally
    }

    String b(Context paramContext) {
        StringBuilder localStringBuilder;
        for (; ; ) {
            try {
                if ((this.v != null) || (this.u.size() <= 0)) {
                    break label139;
                }
                localStringBuilder = new StringBuilder();
                Iterator localIterator = this.u.iterator();
                if (!localIterator.hasNext()) {
                    break;
                }
                HandShake.Scheme localScheme = (HandShake.Scheme) localIterator.next();
                if (localScheme.a(paramContext)) {
                    if (localStringBuilder.length() > 0) {
                        localStringBuilder.append("," + localScheme.b);
                    } else {
                        localStringBuilder.append(Integer.toString(localScheme.b));
                    }
                }
            } finally {
            }
        }
        if (localStringBuilder.length() > 0) {
            this.v = localStringBuilder.toString();
        }
        label139:
        paramContext = this.v;
        return paramContext;
    }

    void b() {
        a(true);
    }

    void b(Context paramContext, String paramString) {
        try {
            HandShake.AdTypeHandShake localAdTypeHandShake = (HandShake.AdTypeHandShake) this.t.get(paramString);
            if (localAdTypeHandShake != null) {
                localAdTypeHandShake.a(paramContext, paramString);
            }
            return;
        } finally {
        }
    }

    JSONArray c(Context paramContext) {
        JSONArray localJSONArray;
        try {
            localJSONArray = new JSONArray();
            if (this.u.size() > 0) {
                Iterator localIterator = this.u.iterator();
                while (localIterator.hasNext()) {
                    HandShake.Scheme localScheme = (HandShake.Scheme) localIterator.next();
                    boolean bool = localScheme.a(paramContext);
                    if (bool) {
                        try {
                            JSONObject localJSONObject = new JSONObject();
                            localJSONObject.put("scheme", localScheme.a);
                            localJSONObject.put("schemeid", localScheme.b);
                            localJSONArray.put(localJSONObject);
                        } catch (JSONException localJSONException) {
                            MMLog.a("HandShake", "Json error getting scheme", localJSONException);
                        }
                    }
                }
            }
        } finally {
        }
        return localJSONArray;
    }

    void c() {
        if (!TextUtils.isEmpty(this.f)) {
            Utils.HttpUtils.a(this.f);
        }
    }

    void c(Context paramContext, String paramString) {
        a(paramContext, paramString, true);
    }

    /* Error */
    boolean c(String paramString) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 80	com/millennialmedia/android/HandShake:t	Ljava/util/LinkedHashMap;
        //   6: aload_1
        //   7: invokevirtual 582	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
        //   10: checkcast 270	com/millennialmedia/android/HandShake$AdTypeHandShake
        //   13: astore_1
        //   14: aload_1
        //   15: ifnull +12 -> 27
        //   18: aload_1
        //   19: getfield 645	com/millennialmedia/android/HandShake$AdTypeHandShake:c	Z
        //   22: istore_2
        //   23: aload_0
        //   24: monitorexit
        //   25: iload_2
        //   26: ireturn
        //   27: iconst_0
        //   28: istore_2
        //   29: goto -6 -> 23
        //   32: astore_1
        //   33: aload_0
        //   34: monitorexit
        //   35: aload_1
        //   36: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	37	0	this	HandShake
        //   0	37	1	paramString	String
        //   22	7	2	bool	boolean
        // Exception table:
        //   from	to	target	type
        //   2	14	32	finally
        //   18	23	32	finally
    }

    void d(String paramString) {
        try {
            paramString = (HandShake.AdTypeHandShake) this.t.get(paramString);
            if (paramString != null) {
                paramString.c = true;
            }
            return;
        } finally {
        }
    }

    void e(String paramString) {
        try {
            paramString = (HandShake.AdTypeHandShake) this.t.get(paramString);
            if (paramString != null) {
                paramString.c = false;
            }
            return;
        } finally {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/HandShake.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */