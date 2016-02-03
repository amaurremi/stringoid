package com.flurry.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.flurry.android.FlurryAdSize;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v10.AdResponse;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.android.impl.ads.avro.protocol.v10.Configuration;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class t {
    private static final String a = t.class.getSimpleName();
    private final FlurryAdModule b;
    private final w c;
    private final Map<String, String> d;
    private final Map<String, a> e;
    private Configuration f;
    private int g;
    private boolean h;

    public t(FlurryAdModule paramFlurryAdModule) {
        this.b = paramFlurryAdModule;
        this.c = new w();
        this.d = new HashMap();
        this.e = new HashMap();
    }

    private a a(String paramString) {
        try {
            a locala2 = (a) this.e.get(paramString);
            a locala1 = locala2;
            if (locala2 == null) {
                locala1 = new a(paramString);
                this.e.put(paramString, locala1);
            }
            return locala1;
        } finally {
        }
    }

    private void e() {
        try {
            Configuration localConfiguration = this.f;
            if (localConfiguration == null) {
            }
            for (; ; ) {
                return;
                if (!this.h) {
                    break;
                }
                eo.a(3, a, "Media player assets: download not necessary");
            }
            if (this.g >= 3) {
            }
        } finally {
        }
        for (final String str = this.f.b().toString() + "android.zip"; ; str = "http://flurry.cachefly.net/vast/videocontrols/v1/android.zip") {
            final File localFile = do.a().b().getFileStreamPath(".flurryads.mediaassets");
            final SharedPreferences localSharedPreferences = do.
            a().b().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0);
            final Object localObject2 = localSharedPreferences.getString("flurry_last_media_asset_url", null);
            if ((localObject2 != null) && (((String) localObject2).equals(str)) && (localFile.exists())) {
                eo.a(3, a, "Media player assets: unchanged, download not necessary");
                this.h = true;
                break;
            }
            localObject2 = do.a().b().getFileStreamPath(".flurryads.mediaassets.tmp");
            ((File) localObject2).delete();
            eo.a(3, a, "Media player assets: attempting download from url: " + str);
            at localat = new at((File) localObject2);
            localat.a(str);
            localat.a(new as.a() {
                public void a(as paramAnonymousas) {
                    if ((paramAnonymousas.a()) && (localObject2.exists())) {
                        localFile.delete();
                        if (localObject2.renameTo(localFile)) {
                            eo.a(3, t.d(), "Media player assets: download successful");
                            paramAnonymousas = localSharedPreferences.edit();
                            paramAnonymousas.putString("flurry_last_media_asset_url", str);
                            paramAnonymousas.commit();
                            t.a(t.this, true);
                            return;
                        }
                        eo.a(3, t.d(), "Media player assets: couldn't rename tmp file (giving up)");
                        return;
                    }
                    eo.a(3, t.d(), "Media player assets: download failed");
                    if (ev.a().c()) {
                        t.e(t.this);
                    }
                    do.a().a(new ff() {
                        public void a() {
                            t.c(t.this);
                        }
                    }, 10000L);
                }
            });
            localat.d();
            break;
        }
    }

    public void a() {
        if (this.f == null) {
            a("", null, FlurryAdSize.BANNER_BOTTOM, true, null);
            return;
        }
        e();
    }

    public void a(String paramString, ViewGroup paramViewGroup, FlurryAdSize paramFlurryAdSize, boolean paramBoolean, AdUnit paramAdUnit) {
        eo.a(3, a, "requestAd: adSpaceName = " + paramString + ", viewGroup = " + paramViewGroup + ", size = " + paramFlurryAdSize + ", refresh = " + paramBoolean);
        a(paramString).a(paramViewGroup, paramFlurryAdSize, paramBoolean, paramAdUnit);
    }

    public void a(String paramString, List<AdUnit> paramList, int paramInt) {
        try {
            if ((!TextUtils.isEmpty(paramString)) && (paramList != null) && (paramList.size() > 0)) {
                a.a(a(paramString), paramList, paramInt);
            }
            return;
        } finally {
        }
    }

    public void b() {
        Iterator localIterator = this.e.values().iterator();
        while (localIterator.hasNext()) {
            ((a) localIterator.next()).a();
        }
        this.e.clear();
    }

    public File c() {
        if (this.h) {
            return do.a().b().getFileStreamPath(".flurryads.mediaassets");
        }
        return null;
    }

    class a {
        private final String b;
        private t.b c;
        private List<AdUnit> d;

        public a(String paramString) {
            this.b = paramString;
            this.c = t.b.a;
            a();
        }

        private void a(t.b paramb) {
            t.b localb = paramb;
            if (paramb == null) {
            }
            try {
                localb = t.b.a;
                eo.a(3, t.d(), "Setting state from " + this.c + " to " + localb);
                this.c = localb;
                return;
            } finally {
            }
        }

        /* Error */
        private void a(List<AdUnit> paramList, int paramInt) {
            // Byte code:
            //   0: aload_0
            //   1: monitorenter
            //   2: getstatic 34	com/flurry/sdk/t$b:a	Lcom/flurry/sdk/t$b;
            //   5: aload_0
            //   6: getfield 36	com/flurry/sdk/t$a:c	Lcom/flurry/sdk/t$b;
            //   9: invokevirtual 84	com/flurry/sdk/t$b:equals	(Ljava/lang/Object;)Z
            //   12: istore_3
            //   13: iload_3
            //   14: ifne +6 -> 20
            //   17: aload_0
            //   18: monitorexit
            //   19: return
            //   20: aload_0
            //   21: aload_1
            //   22: putfield 43	com/flurry/sdk/t$a:d	Ljava/util/List;
            //   25: aload_0
            //   26: getstatic 86	com/flurry/sdk/t$b:d	Lcom/flurry/sdk/t$b;
            //   29: invokespecial 51	com/flurry/sdk/t$a:a	(Lcom/flurry/sdk/t$b;)V
            //   32: aload_0
            //   33: invokespecial 88	com/flurry/sdk/t$a:b	()V
            //   36: goto -19 -> 17
            //   39: astore_1
            //   40: aload_0
            //   41: monitorexit
            //   42: aload_1
            //   43: athrow
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	44	0	this	a
            //   0	44	1	paramList	List<AdUnit>
            //   0	44	2	paramInt	int
            //   12	2	3	bool	boolean
            // Exception table:
            //   from	to	target	type
            //   2	13	39	finally
            //   20	36	39	finally
        }

        private void b() {
            for (; ; ) {
                try {
                    boolean bool = t.b.d.equals(this.c);
                    if (!bool) {
                        return;
                    }
                    Iterator localIterator = this.d.iterator();
                    if (localIterator.hasNext()) {
                        Object localObject2 = (AdUnit) localIterator.next();
                        if (((AdUnit) localObject2).d() == null) {
                            continue;
                        }
                        localObject2 = ((AdUnit) localObject2).d().iterator();
                        if (((Iterator) localObject2).hasNext()) {
                            AdFrame localAdFrame = (AdFrame) ((Iterator) localObject2).next();
                            String str = localAdFrame.c().toString();
                            if (cj.a(str) <= 0) {
                                continue;
                            }
                            t.a(t.this).a(localAdFrame.g().toString(), ck.a(str));
                            continue;
                        }
                        continue;
                    }
                    t.a(t.this).a(this.b, this.d);
                } finally {
                }
                a();
            }
        }

        /* Error */
        private void b(ViewGroup paramViewGroup, FlurryAdSize paramFlurryAdSize, boolean paramBoolean, AdUnit paramAdUnit) {
            // Byte code:
            //   0: aload_0
            //   1: monitorenter
            //   2: getstatic 145	com/flurry/sdk/t$b:b	Lcom/flurry/sdk/t$b;
            //   5: aload_0
            //   6: getfield 36	com/flurry/sdk/t$a:c	Lcom/flurry/sdk/t$b;
            //   9: invokevirtual 84	com/flurry/sdk/t$b:equals	(Ljava/lang/Object;)Z
            //   12: istore 11
            //   14: iload 11
            //   16: ifne +6 -> 22
            //   19: aload_0
            //   20: monitorexit
            //   21: return
            //   22: invokestatic 151	com/flurry/sdk/fc:i	()I
            //   25: invokestatic 154	com/flurry/sdk/fc:c	(I)Landroid/util/Pair;
            //   28: astore 12
            //   30: aload 12
            //   32: getfield 160	android/util/Pair:first	Ljava/lang/Object;
            //   35: checkcast 162	java/lang/Integer
            //   38: invokevirtual 165	java/lang/Integer:intValue	()I
            //   41: istore 9
            //   43: aload 12
            //   45: getfield 168	android/util/Pair:second	Ljava/lang/Object;
            //   48: checkcast 162	java/lang/Integer
            //   51: invokevirtual 165	java/lang/Integer:intValue	()I
            //   54: istore 10
            //   56: invokestatic 172	com/flurry/sdk/fc:j	()Landroid/util/Pair;
            //   59: astore 12
            //   61: aload 12
            //   63: getfield 160	android/util/Pair:first	Ljava/lang/Object;
            //   66: checkcast 162	java/lang/Integer
            //   69: invokevirtual 165	java/lang/Integer:intValue	()I
            //   72: istore 8
            //   74: aload 12
            //   76: getfield 168	android/util/Pair:second	Ljava/lang/Object;
            //   79: checkcast 162	java/lang/Integer
            //   82: invokevirtual 165	java/lang/Integer:intValue	()I
            //   85: istore 7
            //   87: iload 7
            //   89: istore 6
            //   91: aload_2
            //   92: ifnull +677 -> 769
            //   95: aload_2
            //   96: getstatic 178	com/flurry/android/FlurryAdSize:BANNER_BOTTOM	Lcom/flurry/android/FlurryAdSize;
            //   99: invokevirtual 179	com/flurry/android/FlurryAdSize:equals	(Ljava/lang/Object;)Z
            //   102: ifne +17 -> 119
            //   105: iload 7
            //   107: istore 6
            //   109: aload_2
            //   110: getstatic 182	com/flurry/android/FlurryAdSize:BANNER_TOP	Lcom/flurry/android/FlurryAdSize;
            //   113: invokevirtual 179	com/flurry/android/FlurryAdSize:equals	(Ljava/lang/Object;)Z
            //   116: ifeq +653 -> 769
            //   119: iload 7
            //   121: istore 5
            //   123: aload_1
            //   124: ifnull +23 -> 147
            //   127: iload 7
            //   129: istore 5
            //   131: aload_1
            //   132: invokevirtual 187	android/view/ViewGroup:getHeight	()I
            //   135: ifle +12 -> 147
            //   138: aload_1
            //   139: invokevirtual 187	android/view/ViewGroup:getHeight	()I
            //   142: invokestatic 190	com/flurry/sdk/fc:a	(I)I
            //   145: istore 5
            //   147: iload 5
            //   149: istore 6
            //   151: aload_1
            //   152: ifnull +617 -> 769
            //   155: iload 5
            //   157: istore 6
            //   159: aload_1
            //   160: invokevirtual 193	android/view/ViewGroup:getWidth	()I
            //   163: ifle +606 -> 769
            //   166: aload_1
            //   167: invokevirtual 193	android/view/ViewGroup:getWidth	()I
            //   170: invokestatic 190	com/flurry/sdk/fc:a	(I)I
            //   173: istore 6
            //   175: aload_0
            //   176: getfield 25	com/flurry/sdk/t$a:a	Lcom/flurry/sdk/t;
            //   179: invokestatic 125	com/flurry/sdk/t:a	(Lcom/flurry/sdk/t;)Lcom/flurry/android/impl/ads/FlurryAdModule;
            //   182: invokevirtual 196	com/flurry/android/impl/ads/FlurryAdModule:E	()Ljava/util/List;
            //   185: astore 13
            //   187: aload_0
            //   188: getfield 25	com/flurry/sdk/t$a:a	Lcom/flurry/sdk/t;
            //   191: invokestatic 125	com/flurry/sdk/t:a	(Lcom/flurry/sdk/t;)Lcom/flurry/android/impl/ads/FlurryAdModule;
            //   194: invokevirtual 199	com/flurry/android/impl/ads/FlurryAdModule:F	()Ljava/util/List;
            //   197: astore 14
            //   199: new 201	java/util/ArrayList
            //   202: dup
            //   203: invokespecial 202	java/util/ArrayList:<init>	()V
            //   206: astore 12
            //   208: aload_0
            //   209: getfield 25	com/flurry/sdk/t$a:a	Lcom/flurry/sdk/t;
            //   212: invokestatic 125	com/flurry/sdk/t:a	(Lcom/flurry/sdk/t;)Lcom/flurry/android/impl/ads/FlurryAdModule;
            //   215: invokevirtual 205	com/flurry/android/impl/ads/FlurryAdModule:U	()Z
            //   218: ifeq +31 -> 249
            //   221: aload 12
            //   223: ldc -49
            //   225: invokeinterface 210 2 0
            //   230: pop
            //   231: aload 12
            //   233: aload_0
            //   234: getfield 25	com/flurry/sdk/t$a:a	Lcom/flurry/sdk/t;
            //   237: invokestatic 125	com/flurry/sdk/t:a	(Lcom/flurry/sdk/t;)Lcom/flurry/android/impl/ads/FlurryAdModule;
            //   240: invokevirtual 213	com/flurry/android/impl/ads/FlurryAdModule:V	()Ljava/lang/CharSequence;
            //   243: invokeinterface 210 2 0
            //   248: pop
            //   249: aload 4
            //   251: ifnull +510 -> 761
            //   254: aload 4
            //   256: invokevirtual 217	com/flurry/android/impl/ads/avro/protocol/v10/AdUnit:s	()Ljava/lang/Boolean;
            //   259: invokevirtual 222	java/lang/Boolean:booleanValue	()Z
            //   262: istore 11
            //   264: aload 4
            //   266: invokevirtual 226	com/flurry/android/impl/ads/avro/protocol/v10/AdUnit:t	()Ljava/util/Map;
            //   269: astore_1
            //   270: invokestatic 231	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:b	()Lcom/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder;
            //   273: aload_0
            //   274: getfield 25	com/flurry/sdk/t$a:a	Lcom/flurry/sdk/t;
            //   277: invokestatic 125	com/flurry/sdk/t:a	(Lcom/flurry/sdk/t;)Lcom/flurry/android/impl/ads/FlurryAdModule;
            //   280: invokevirtual 233	com/flurry/android/impl/ads/FlurryAdModule:j	()Ljava/lang/String;
            //   283: invokevirtual 238	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(Ljava/lang/CharSequence;)Lcom/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder;
            //   286: ldc -16
            //   288: invokevirtual 242	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:c	(Ljava/lang/CharSequence;)Lcom/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder;
            //   291: aload_0
            //   292: getfield 25	com/flurry/sdk/t$a:a	Lcom/flurry/sdk/t;
            //   295: invokestatic 125	com/flurry/sdk/t:a	(Lcom/flurry/sdk/t;)Lcom/flurry/android/impl/ads/FlurryAdModule;
            //   298: invokevirtual 245	com/flurry/android/impl/ads/FlurryAdModule:X	()Ljava/util/List;
            //   301: invokevirtual 248	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:b	(Ljava/util/List;)Lcom/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder;
            //   304: aload 13
            //   306: invokevirtual 250	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(Ljava/util/List;)Lcom/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder;
            //   309: aload_0
            //   310: getfield 25	com/flurry/sdk/t$a:a	Lcom/flurry/sdk/t;
            //   313: invokestatic 125	com/flurry/sdk/t:a	(Lcom/flurry/sdk/t;)Lcom/flurry/android/impl/ads/FlurryAdModule;
            //   316: invokevirtual 254	com/flurry/android/impl/ads/FlurryAdModule:n	()Lcom/flurry/android/impl/ads/avro/protocol/v10/Location;
            //   319: invokevirtual 257	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(Lcom/flurry/android/impl/ads/avro/protocol/v10/Location;)Lcom/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder;
            //   322: aload_0
            //   323: getfield 25	com/flurry/sdk/t$a:a	Lcom/flurry/sdk/t;
            //   326: invokestatic 125	com/flurry/sdk/t:a	(Lcom/flurry/sdk/t;)Lcom/flurry/android/impl/ads/FlurryAdModule;
            //   329: invokevirtual 260	com/flurry/android/impl/ads/FlurryAdModule:Y	()Z
            //   332: invokevirtual 263	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(Z)Lcom/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder;
            //   335: invokestatic 268	com/flurry/android/FlurryAgent:getAgentVersion	()I
            //   338: invokestatic 271	java/lang/Integer:toString	(I)Ljava/lang/String;
            //   341: invokevirtual 273	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:b	(Ljava/lang/CharSequence;)Lcom/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder;
            //   344: aload_0
            //   345: getfield 25	com/flurry/sdk/t$a:a	Lcom/flurry/sdk/t;
            //   348: invokestatic 125	com/flurry/sdk/t:a	(Lcom/flurry/sdk/t;)Lcom/flurry/android/impl/ads/FlurryAdModule;
            //   351: invokevirtual 277	com/flurry/android/impl/ads/FlurryAdModule:h	()J
            //   354: invokevirtual 280	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(J)Lcom/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder;
            //   357: invokestatic 285	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer:b	()Lcom/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder;
            //   360: iload 10
            //   362: invokevirtual 290	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder:d	(I)Lcom/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder;
            //   365: iload 9
            //   367: invokevirtual 292	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder:c	(I)Lcom/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder;
            //   370: iload 5
            //   372: invokevirtual 294	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder:b	(I)Lcom/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder;
            //   375: iload 6
            //   377: invokevirtual 296	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder:a	(I)Lcom/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder;
            //   380: invokestatic 299	com/flurry/sdk/fc:d	()F
            //   383: invokevirtual 302	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder:a	(F)Lcom/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder;
            //   386: invokestatic 307	com/flurry/sdk/cc:a	()Lcom/flurry/android/impl/ads/avro/protocol/v10/ScreenOrientationType;
            //   389: invokevirtual 310	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder:a	(Lcom/flurry/android/impl/ads/avro/protocol/v10/ScreenOrientationType;)Lcom/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder;
            //   392: invokevirtual 313	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer$Builder:a	()Lcom/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer;
            //   395: invokevirtual 316	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(Lcom/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer;)Lcom/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder;
            //   398: aload_0
            //   399: getfield 25	com/flurry/sdk/t$a:a	Lcom/flurry/sdk/t;
            //   402: invokestatic 125	com/flurry/sdk/t:a	(Lcom/flurry/sdk/t;)Lcom/flurry/android/impl/ads/FlurryAdModule;
            //   405: invokevirtual 319	com/flurry/android/impl/ads/FlurryAdModule:l	()Ljava/lang/String;
            //   408: invokevirtual 321	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:d	(Ljava/lang/CharSequence;)Lcom/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder;
            //   411: aload_0
            //   412: getfield 25	com/flurry/sdk/t$a:a	Lcom/flurry/sdk/t;
            //   415: invokestatic 125	com/flurry/sdk/t:a	(Lcom/flurry/sdk/t;)Lcom/flurry/android/impl/ads/FlurryAdModule;
            //   418: invokevirtual 324	com/flurry/android/impl/ads/FlurryAdModule:m	()Ljava/lang/String;
            //   421: invokevirtual 327	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:e	(Ljava/lang/CharSequence;)Lcom/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder;
            //   424: aload_0
            //   425: getfield 25	com/flurry/sdk/t$a:a	Lcom/flurry/sdk/t;
            //   428: invokestatic 125	com/flurry/sdk/t:a	(Lcom/flurry/sdk/t;)Lcom/flurry/android/impl/ads/FlurryAdModule;
            //   431: invokevirtual 330	com/flurry/android/impl/ads/FlurryAdModule:Z	()Ljava/lang/String;
            //   434: invokevirtual 333	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:f	(Ljava/lang/CharSequence;)Lcom/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder;
            //   437: aload_0
            //   438: getfield 25	com/flurry/sdk/t$a:a	Lcom/flurry/sdk/t;
            //   441: invokestatic 125	com/flurry/sdk/t:a	(Lcom/flurry/sdk/t;)Lcom/flurry/android/impl/ads/FlurryAdModule;
            //   444: invokevirtual 336	com/flurry/android/impl/ads/FlurryAdModule:aa	()Ljava/lang/String;
            //   447: invokevirtual 338	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:g	(Ljava/lang/CharSequence;)Lcom/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder;
            //   450: iconst_0
            //   451: invokevirtual 340	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:b	(Z)Lcom/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder;
            //   454: aload_0
            //   455: getfield 25	com/flurry/sdk/t$a:a	Lcom/flurry/sdk/t;
            //   458: invokestatic 125	com/flurry/sdk/t:a	(Lcom/flurry/sdk/t;)Lcom/flurry/android/impl/ads/FlurryAdModule;
            //   461: invokevirtual 344	com/flurry/android/impl/ads/FlurryAdModule:T	()Lcom/flurry/sdk/ev$a;
            //   464: invokevirtual 348	com/flurry/sdk/ev$a:a	()I
            //   467: invokevirtual 351	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(I)Lcom/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder;
            //   470: aload 14
            //   472: invokevirtual 353	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:c	(Ljava/util/List;)Lcom/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder;
            //   475: invokestatic 358	com/flurry/sdk/dn:a	()Lcom/flurry/sdk/dn;
            //   478: invokevirtual 361	com/flurry/sdk/dn:k	()Z
            //   481: invokevirtual 363	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:c	(Z)Lcom/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder;
            //   484: invokestatic 369	java/util/Locale:getDefault	()Ljava/util/Locale;
            //   487: invokevirtual 372	java/util/Locale:getLanguage	()Ljava/lang/String;
            //   490: invokevirtual 374	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:h	(Ljava/lang/CharSequence;)Lcom/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder;
            //   493: aload_0
            //   494: getfield 25	com/flurry/sdk/t$a:a	Lcom/flurry/sdk/t;
            //   497: invokestatic 125	com/flurry/sdk/t:a	(Lcom/flurry/sdk/t;)Lcom/flurry/android/impl/ads/FlurryAdModule;
            //   500: invokevirtual 377	com/flurry/android/impl/ads/FlurryAdModule:ab	()Ljava/lang/String;
            //   503: invokevirtual 379	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:i	(Ljava/lang/CharSequence;)Lcom/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder;
            //   506: iload 11
            //   508: invokevirtual 381	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:e	(Z)Lcom/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder;
            //   511: astore 4
            //   513: aload_0
            //   514: getfield 25	com/flurry/sdk/t$a:a	Lcom/flurry/sdk/t;
            //   517: invokestatic 384	com/flurry/sdk/t:b	(Lcom/flurry/sdk/t;)Lcom/flurry/android/impl/ads/avro/protocol/v10/Configuration;
            //   520: ifnonnull +188 -> 708
            //   523: iconst_1
            //   524: istore 11
            //   526: aload 4
            //   528: iload 11
            //   530: invokevirtual 386	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:d	(Z)Lcom/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder;
            //   533: aload 12
            //   535: invokevirtual 388	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:d	(Ljava/util/List;)Lcom/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder;
            //   538: aload_0
            //   539: getfield 25	com/flurry/sdk/t$a:a	Lcom/flurry/sdk/t;
            //   542: invokestatic 125	com/flurry/sdk/t:a	(Lcom/flurry/sdk/t;)Lcom/flurry/android/impl/ads/FlurryAdModule;
            //   545: invokevirtual 390	com/flurry/android/impl/ads/FlurryAdModule:k	()Ljava/util/List;
            //   548: invokevirtual 392	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:e	(Ljava/util/List;)Lcom/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder;
            //   551: invokevirtual 395	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	()Lcom/flurry/android/impl/ads/avro/protocol/v10/AdRequest;
            //   554: astore 4
            //   556: iload_3
            //   557: ifeq +157 -> 714
            //   560: aload 4
            //   562: iload_3
            //   563: invokestatic 399	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
            //   566: invokevirtual 402	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:a	(Ljava/lang/Boolean;)V
            //   569: aload_2
            //   570: ifnull +21 -> 591
            //   573: aload 4
            //   575: invokestatic 407	com/flurry/android/impl/ads/avro/protocol/v10/TestAds:b	()Lcom/flurry/android/impl/ads/avro/protocol/v10/TestAds$Builder;
            //   578: aload_2
            //   579: invokevirtual 410	com/flurry/android/FlurryAdSize:getValue	()I
            //   582: invokevirtual 415	com/flurry/android/impl/ads/avro/protocol/v10/TestAds$Builder:a	(I)Lcom/flurry/android/impl/ads/avro/protocol/v10/TestAds$Builder;
            //   585: invokevirtual 418	com/flurry/android/impl/ads/avro/protocol/v10/TestAds$Builder:a	()Lcom/flurry/android/impl/ads/avro/protocol/v10/TestAds;
            //   588: invokevirtual 421	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:a	(Lcom/flurry/android/impl/ads/avro/protocol/v10/TestAds;)V
            //   591: aload_0
            //   592: getfield 25	com/flurry/sdk/t$a:a	Lcom/flurry/sdk/t;
            //   595: invokestatic 125	com/flurry/sdk/t:a	(Lcom/flurry/sdk/t;)Lcom/flurry/android/impl/ads/FlurryAdModule;
            //   598: invokevirtual 424	com/flurry/android/impl/ads/FlurryAdModule:r	()Z
            //   601: ifeq +18 -> 619
            //   604: aload 4
            //   606: aload_0
            //   607: getfield 25	com/flurry/sdk/t$a:a	Lcom/flurry/sdk/t;
            //   610: invokestatic 125	com/flurry/sdk/t:a	(Lcom/flurry/sdk/t;)Lcom/flurry/android/impl/ads/FlurryAdModule;
            //   613: invokevirtual 426	com/flurry/android/impl/ads/FlurryAdModule:s	()Ljava/util/Map;
            //   616: invokevirtual 429	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:a	(Ljava/util/Map;)V
            //   619: aload_1
            //   620: ifnull +9 -> 629
            //   623: aload 4
            //   625: aload_1
            //   626: invokevirtual 431	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:b	(Ljava/util/Map;)V
            //   629: aload_0
            //   630: getstatic 432	com/flurry/sdk/t$b:c	Lcom/flurry/sdk/t$b;
            //   633: invokespecial 51	com/flurry/sdk/t$a:a	(Lcom/flurry/sdk/t$b;)V
            //   636: iconst_3
            //   637: invokestatic 58	com/flurry/sdk/t:d	()Ljava/lang/String;
            //   640: new 60	java/lang/StringBuilder
            //   643: dup
            //   644: invokespecial 61	java/lang/StringBuilder:<init>	()V
            //   647: ldc_w 434
            //   650: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   653: aload 4
            //   655: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
            //   658: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   661: invokestatic 80	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
            //   664: aload_0
            //   665: getfield 25	com/flurry/sdk/t$a:a	Lcom/flurry/sdk/t;
            //   668: invokestatic 437	com/flurry/sdk/t:d	(Lcom/flurry/sdk/t;)Lcom/flurry/sdk/w;
            //   671: aload_0
            //   672: aload_0
            //   673: getfield 25	com/flurry/sdk/t$a:a	Lcom/flurry/sdk/t;
            //   676: invokestatic 125	com/flurry/sdk/t:a	(Lcom/flurry/sdk/t;)Lcom/flurry/android/impl/ads/FlurryAdModule;
            //   679: invokevirtual 440	com/flurry/android/impl/ads/FlurryAdModule:w	()Ljava/lang/String;
            //   682: aload 4
            //   684: ldc -28
            //   686: ldc_w 442
            //   689: new 11	com/flurry/sdk/t$a$2
            //   692: dup
            //   693: aload_0
            //   694: invokespecial 445	com/flurry/sdk/t$a$2:<init>	(Lcom/flurry/sdk/t$a;)V
            //   697: invokevirtual 450	com/flurry/sdk/w:a	(Ljava/lang/Object;Ljava/lang/String;Lcom/flurry/sdk/gw;Ljava/lang/Class;Ljava/lang/Class;Lcom/flurry/sdk/w$a;)V
            //   700: goto -681 -> 19
            //   703: astore_1
            //   704: aload_0
            //   705: monitorexit
            //   706: aload_1
            //   707: athrow
            //   708: iconst_0
            //   709: istore 11
            //   711: goto -185 -> 526
            //   714: aload 4
            //   716: aload_0
            //   717: getfield 30	com/flurry/sdk/t$a:b	Ljava/lang/String;
            //   720: invokevirtual 453	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:a	(Ljava/lang/CharSequence;)V
            //   723: goto -154 -> 569
            //   726: astore_1
            //   727: iconst_5
            //   728: invokestatic 58	com/flurry/sdk/t:d	()Ljava/lang/String;
            //   731: new 60	java/lang/StringBuilder
            //   734: dup
            //   735: invokespecial 61	java/lang/StringBuilder:<init>	()V
            //   738: ldc_w 455
            //   741: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   744: aload_1
            //   745: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
            //   748: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   751: invokestatic 80	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
            //   754: aload_0
            //   755: invokevirtual 38	com/flurry/sdk/t$a:a	()V
            //   758: goto -739 -> 19
            //   761: iconst_0
            //   762: istore 11
            //   764: aconst_null
            //   765: astore_1
            //   766: goto -496 -> 270
            //   769: iload 6
            //   771: istore 5
            //   773: iload 8
            //   775: istore 6
            //   777: goto -602 -> 175
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	780	0	this	a
            //   0	780	1	paramViewGroup	ViewGroup
            //   0	780	2	paramFlurryAdSize	FlurryAdSize
            //   0	780	3	paramBoolean	boolean
            //   0	780	4	paramAdUnit	AdUnit
            //   121	651	5	i	int
            //   89	687	6	j	int
            //   85	43	7	k	int
            //   72	702	8	m	int
            //   41	325	9	n	int
            //   54	307	10	i1	int
            //   12	751	11	bool	boolean
            //   28	506	12	localObject	Object
            //   185	120	13	localList1	List
            //   197	274	14	localList2	List
            // Exception table:
            //   from	to	target	type
            //   2	14	703	finally
            //   22	87	703	finally
            //   95	105	703	finally
            //   109	119	703	finally
            //   131	147	703	finally
            //   159	175	703	finally
            //   175	249	703	finally
            //   254	270	703	finally
            //   270	523	703	finally
            //   526	556	703	finally
            //   560	569	703	finally
            //   573	591	703	finally
            //   591	619	703	finally
            //   623	629	703	finally
            //   629	700	703	finally
            //   714	723	703	finally
            //   727	758	703	finally
            //   270	523	726	java/lang/Exception
            //   526	556	726	java/lang/Exception
            //   560	569	726	java/lang/Exception
            //   573	591	726	java/lang/Exception
            //   591	619	726	java/lang/Exception
            //   623	629	726	java/lang/Exception
            //   714	723	726	java/lang/Exception
        }

        public void a() {
            try {
                em.a().a(this);
                a(t.b.a);
                this.d = null;
                return;
            } finally {
                localObject =finally;
                throw ((Throwable) localObject);
            }
        }

        public void a(final ViewGroup paramViewGroup, final FlurryAdSize paramFlurryAdSize, final boolean paramBoolean, final AdUnit paramAdUnit) {
            for (; ; ) {
                try {
                    if (!t.b.a.equals(this.c)) {
                        eo.a(3, t.d(), "requestAds: request pending");
                        return;
                    }
                    if (!ev.a().c()) {
                        eo.a(5, t.d(), "There is no network connectivity (requestAds will fail)");
                        continue;
                    }
                    if (t.a(t.this).j() != null) {
                        break label81;
                    }
                } finally {
                }
                eo.a(5, t.d(), "There is no API key (requestAds will fail)");
                continue;
                label81:
                t.a(t.this).W().d();
                a(t.b.b);
                do.a().c(new ff() {
                    public void a() {
                        t.a.a(t.a.this, paramViewGroup, paramFlurryAdSize, paramBoolean, paramAdUnit);
                    }
                });
            }
        }
    }

    static enum b {
        private b() {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */