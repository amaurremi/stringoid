package com.flurry.sdk;

import android.text.TextUtils;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

public class ap
        implements ao.a {
    private static final String b = ap.class.getSimpleName();
    private static final String[] c = new String[0];
    private static ap d;
    ao a;
    private long e;
    private long f;
    private boolean g;
    private boolean h;
    private final dt<b> i = new dt();

    private a a(a parama, ar paramar) {
        a locala;
        if (parama == null) {
            locala = a.a;
        }
        label150:
        do {
            do {
                do {
                    do {
                        do {
                            do {
                                do {
                                    return locala;
                                    locala = parama;
                                } while (paramar == null);
                                if (ar.g.equals(paramar)) {
                                    return a.f;
                                }
                                if (!ar.f.equals(paramar)) {
                                    break;
                                }
                                locala = parama;
                            } while (parama.equals(a.f));
                            return a.e;
                            if ((!ar.a.equals(paramar)) && (!ar.e.equals(paramar))) {
                                break;
                            }
                            locala = parama;
                        } while (parama.equals(a.f));
                        locala = parama;
                    } while (parama.equals(a.e));
                    return a.c;
                    if ((!ar.b.equals(paramar)) && (!ar.c.equals(paramar))) {
                        break label150;
                    }
                    if (a.a.equals(parama)) {
                        break;
                    }
                    locala = parama;
                } while (!a.d.equals(parama));
                return a.b;
                locala = parama;
            } while (!ar.d.equals(paramar));
            locala = parama;
        } while (!a.a.equals(parama));
        return a.d;
    }

    public static ap a() {
        try {
            if (d == null) {
                d = new ap();
            }
            ap localap = d;
            return localap;
        } finally {
        }
    }

    private String a(AdFrame paramAdFrame, String paramString) {
        if ((paramAdFrame == null) || (TextUtils.isEmpty(paramString))) {
        }
        do {
            do {
                return null;
            } while (paramAdFrame.d() == null);
            paramAdFrame = a(paramAdFrame.d().toString(), paramString);
        } while (TextUtils.isEmpty(paramAdFrame));
        return paramAdFrame;
    }

    private String a(String paramString1, String paramString2) {
        if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
            paramString2 = null;
        }
        for (; ; ) {
            return paramString2;
            String str = "";
            try {
                Iterator localIterator = Arrays.asList(paramString2.split("\\s*-\\s*")).iterator();
                paramString2 = str;
                if (!localIterator.hasNext()) {
                    continue;
                }
                paramString2 = (String) localIterator.next();
                paramString2 = new JSONObject(paramString1).getString(paramString2);
                boolean bool = TextUtils.isEmpty(paramString2);
                if (!bool) {
                    paramString1 = paramString2;
                }
                for (; ; ) {
                    break;
                }
            } catch (JSONException paramString1) {
                return null;
            }
        }
    }

    private boolean a(AdFrame paramAdFrame) {
        if (paramAdFrame == null) {
        }
        do {
            return false;
            if (FlurryAdModule.getInstance().b(paramAdFrame.g().toString()) != null) {
                return true;
            }
        } while (paramAdFrame.b().intValue() != 3);
        return true;
    }

    private boolean a(String paramString, long paramLong) {
        if (TextUtils.isEmpty(paramString)) {
            return false;
        }
        ay localay2 = ay.a;
        String str = URLConnection.guessContentTypeFromName(paramString);
        ay localay1 = localay2;
        if (str != null) {
            if (!str.startsWith("video")) {
                break label82;
            }
            eo.a(3, b, "Precaching: asset is a video: " + paramString);
            localay1 = ay.b;
        }
        for (; ; ) {
            return this.a.a(paramString, localay1, paramLong);
            label82:
            if (str.startsWith("image")) {
                eo.a(3, b, "Precaching: asset is an image: " + paramString);
                localay1 = ay.c;
            } else if (str.startsWith("text")) {
                eo.a(3, b, "Precaching: asset is text: " + paramString);
                localay1 = ay.d;
            } else {
                eo.a(5, b, "Precaching: could not identify media type for asset: " + paramString);
                localay1 = localay2;
            }
        }
    }

    private boolean a(List<CharSequence> paramList, String paramString) {
        if (paramList == null) {
            return false;
        }
        if (TextUtils.isEmpty(paramString)) {
            return false;
        }
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
            if (paramString.equals(((CharSequence) paramList.next()).toString())) {
                return true;
            }
        }
        return false;
    }

    private String b(AdFrame paramAdFrame) {
        paramAdFrame = FlurryAdModule.getInstance().b(paramAdFrame.g().toString());
        if (paramAdFrame != null) {
            return paramAdFrame.f();
        }
        return null;
    }

    private String c(AdFrame paramAdFrame) {
        if (paramAdFrame == null) {
        }
        while ((paramAdFrame.c() == null) || (paramAdFrame.b().intValue() != 3)) {
            return null;
        }
        return paramAdFrame.c().toString();
    }

    private boolean c(String paramString) {
        if (!this.h) {
        }
        do {
            do {
                return false;
            } while (TextUtils.isEmpty(paramString));
            eo.a(3, b, "Precaching: Saving local asset for adUnit.");
        } while (!ar.d.equals(this.a.b(paramString)));
        return e(paramString);
    }

    private void d(String paramString) {
        if (TextUtils.isEmpty(paramString)) {
            return;
        }
        this.a.b(paramString);
    }

    /* Error */
    private boolean e(String paramString) {
        // Byte code:
        //   0: aconst_null
        //   1: astore 5
        //   3: aload_1
        //   4: invokestatic 99	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   7: ifeq +7 -> 14
        //   10: iconst_0
        //   11: istore_3
        //   12: iload_3
        //   13: ireturn
        //   14: new 253	java/io/File
        //   17: dup
        //   18: ldc -1
        //   20: invokestatic 260	com/flurry/sdk/ce:b	(Ljava/lang/String;)Ljava/io/File;
        //   23: aload_0
        //   24: aload_1
        //   25: invokespecial 262	com/flurry/sdk/ap:f	(Ljava/lang/String;)Ljava/lang/String;
        //   28: invokespecial 265	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
        //   31: astore 8
        //   33: aload 8
        //   35: invokevirtual 268	java/io/File:exists	()Z
        //   38: istore_2
        //   39: iload_2
        //   40: ifeq +32 -> 72
        //   43: aconst_null
        //   44: astore 4
        //   46: aload 5
        //   48: invokestatic 273	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   51: aload 4
        //   53: invokestatic 273	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   56: iconst_1
        //   57: istore_2
        //   58: iload_2
        //   59: istore_3
        //   60: iload_2
        //   61: ifne -49 -> 12
        //   64: aload 8
        //   66: invokevirtual 276	java/io/File:delete	()Z
        //   69: pop
        //   70: iload_2
        //   71: ireturn
        //   72: aload 8
        //   74: invokestatic 281	com/flurry/sdk/fd:a	(Ljava/io/File;)Z
        //   77: ifne +102 -> 179
        //   80: new 251	java/io/IOException
        //   83: dup
        //   84: new 191	java/lang/StringBuilder
        //   87: dup
        //   88: invokespecial 192	java/lang/StringBuilder:<init>	()V
        //   91: ldc_w 283
        //   94: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   97: aload 8
        //   99: invokevirtual 286	java/io/File:getAbsolutePath	()Ljava/lang/String;
        //   102: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   105: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   108: invokespecial 287	java/io/IOException:<init>	(Ljava/lang/String;)V
        //   111: athrow
        //   112: astore 6
        //   114: aconst_null
        //   115: astore 5
        //   117: aconst_null
        //   118: astore 4
        //   120: bipush 6
        //   122: getstatic 39	com/flurry/sdk/ap:b	Ljava/lang/String;
        //   125: new 191	java/lang/StringBuilder
        //   128: dup
        //   129: invokespecial 192	java/lang/StringBuilder:<init>	()V
        //   132: ldc_w 289
        //   135: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   138: aload_1
        //   139: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   142: ldc_w 291
        //   145: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   148: aload 6
        //   150: invokevirtual 294	java/io/IOException:getMessage	()Ljava/lang/String;
        //   153: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   156: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   159: aload 6
        //   161: invokestatic 297	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   164: aload 4
        //   166: invokestatic 273	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   169: aload 5
        //   171: invokestatic 273	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   174: iconst_0
        //   175: istore_2
        //   176: goto -118 -> 58
        //   179: new 299	java/io/FileOutputStream
        //   182: dup
        //   183: aload 8
        //   185: invokespecial 302	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   188: astore 4
        //   190: aload_0
        //   191: getfield 208	com/flurry/sdk/ap:a	Lcom/flurry/sdk/ao;
        //   194: aload_1
        //   195: invokevirtual 305	com/flurry/sdk/ao:c	(Ljava/lang/String;)Lcom/flurry/sdk/aw$b;
        //   198: astore 5
        //   200: aload 5
        //   202: ifnull +58 -> 260
        //   205: aload 5
        //   207: invokevirtual 310	com/flurry/sdk/aw$b:a	()Ljava/io/InputStream;
        //   210: aload 4
        //   212: invokestatic 313	com/flurry/sdk/fe:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
        //   215: pop2
        //   216: iconst_3
        //   217: getstatic 39	com/flurry/sdk/ap:b	Ljava/lang/String;
        //   220: new 191	java/lang/StringBuilder
        //   223: dup
        //   224: invokespecial 192	java/lang/StringBuilder:<init>	()V
        //   227: ldc_w 315
        //   230: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   233: aload_1
        //   234: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   237: ldc_w 317
        //   240: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   243: aload 8
        //   245: invokevirtual 286	java/io/File:getAbsolutePath	()Ljava/lang/String;
        //   248: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   251: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   254: invokestatic 204	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   257: goto -211 -> 46
        //   260: iconst_3
        //   261: getstatic 39	com/flurry/sdk/ap:b	Ljava/lang/String;
        //   264: new 191	java/lang/StringBuilder
        //   267: dup
        //   268: invokespecial 192	java/lang/StringBuilder:<init>	()V
        //   271: ldc_w 319
        //   274: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   277: aload_1
        //   278: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   281: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   284: invokestatic 204	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   287: goto -241 -> 46
        //   290: astore 6
        //   292: aload 5
        //   294: astore_1
        //   295: aload 4
        //   297: astore 5
        //   299: aload_1
        //   300: astore 4
        //   302: aload 6
        //   304: astore_1
        //   305: aload 4
        //   307: invokestatic 273	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   310: aload 5
        //   312: invokestatic 273	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   315: aload_1
        //   316: athrow
        //   317: astore_1
        //   318: aconst_null
        //   319: astore 5
        //   321: aconst_null
        //   322: astore 4
        //   324: goto -19 -> 305
        //   327: astore_1
        //   328: aload 4
        //   330: astore 5
        //   332: aconst_null
        //   333: astore 4
        //   335: goto -30 -> 305
        //   338: astore_1
        //   339: goto -34 -> 305
        //   342: astore 6
        //   344: aload 4
        //   346: astore 5
        //   348: aconst_null
        //   349: astore 4
        //   351: goto -231 -> 120
        //   354: astore 6
        //   356: aload 4
        //   358: astore 7
        //   360: aload 5
        //   362: astore 4
        //   364: aload 7
        //   366: astore 5
        //   368: goto -248 -> 120
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	371	0	this	ap
        //   0	371	1	paramString	String
        //   38	138	2	bool1	boolean
        //   11	49	3	bool2	boolean
        //   44	319	4	localObject1	Object
        //   1	366	5	localObject2	Object
        //   112	48	6	localIOException1	IOException
        //   290	13	6	localObject3	Object
        //   342	1	6	localIOException2	IOException
        //   354	1	6	localIOException3	IOException
        //   358	7	7	localObject4	Object
        //   31	213	8	localFile	File
        // Exception table:
        //   from	to	target	type
        //   33	39	112	java/io/IOException
        //   72	112	112	java/io/IOException
        //   179	190	112	java/io/IOException
        //   205	257	290	finally
        //   260	287	290	finally
        //   33	39	317	finally
        //   72	112	317	finally
        //   179	190	317	finally
        //   190	200	327	finally
        //   120	164	338	finally
        //   190	200	342	java/io/IOException
        //   205	257	354	java/io/IOException
        //   260	287	354	java/io/IOException
    }

    private String f(String paramString) {
        return ce.c(paramString);
    }

    private boolean g(AdUnit paramAdUnit) {
        if (paramAdUnit == null) {
            return false;
        }
        paramAdUnit = paramAdUnit.d().iterator();
        while (paramAdUnit.hasNext()) {
            if (a((AdFrame) paramAdUnit.next())) {
                return true;
            }
        }
        return false;
    }

    private void h(AdUnit paramAdUnit) {
        if (!this.h) {
            return;
        }
        while (paramAdUnit == null) {
        }
        paramAdUnit = paramAdUnit.d().iterator();
        while (paramAdUnit.hasNext()) {
            Object localObject1 = (AdFrame) paramAdUnit.next();
            Object localObject2 = c.a(((AdFrame) localObject1).h().intValue());
            if ((c.a.equals(localObject2)) || (!a((AdFrame) localObject1))) {
                break;
            }
            Object localObject3 = ((AdFrame) localObject1).j();
            localObject2 = ((AdFrame) localObject1).k();
            if ((localObject3 != null) && (((List) localObject3).size() > 0)) {
                localObject1 = ((List) localObject3).iterator();
                while (((Iterator) localObject1).hasNext()) {
                    d(((CharSequence) ((Iterator) localObject1).next()).toString());
                }
            } else {
                localObject3 = b((AdFrame) localObject1);
                if ((!TextUtils.isEmpty((CharSequence) localObject3)) && (!a((List) localObject2, (String) localObject3))) {
                    d((String) localObject3);
                }
                localObject3 = c((AdFrame) localObject1);
                if ((!TextUtils.isEmpty((CharSequence) localObject3)) && (!a((List) localObject2, (String) localObject3))) {
                    d((String) localObject3);
                }
                localObject3 = c;
                int k = localObject3.length;
                int j = 0;
                while (j < k) {
                    String str = a((AdFrame) localObject1, localObject3[j]);
                    if ((!TextUtils.isEmpty(str)) && (!a((List) localObject2, str))) {
                        d(str);
                    }
                    j += 1;
                }
            }
        }
    }

    private List<b> i() {
        synchronized (this.i) {
            List localList = this.i.a();
            return localList;
        }
    }

    private void j() {
        try {
            File localFile = ce.b("fileStreamCacheDownloaderTmp");
            eo.a(3, b, "Precaching: Cleaning temp asset directory: " + localFile);
            fd.b(localFile);
            return;
        } catch (Exception localException) {
            eo.a(6, b, "Precaching: Error cleaning temp asset directory: " + localException.getMessage(), localException);
        }
    }

    public File a(String paramString) {
        if (!this.h) {
        }
        do {
            do {
                return null;
            } while (TextUtils.isEmpty(paramString));
            paramString = new File(ce.b("fileStreamCacheDownloaderTmp"), f(paramString));
        } while (!paramString.exists());
        return paramString;
    }

    /* Error */
    public void a(long paramLong1, long paramLong2) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 376	com/flurry/sdk/ap:g	Z
        //   6: istore 5
        //   8: iload 5
        //   10: ifeq +6 -> 16
        //   13: aload_0
        //   14: monitorexit
        //   15: return
        //   16: iconst_3
        //   17: getstatic 39	com/flurry/sdk/ap:b	Ljava/lang/String;
        //   20: ldc_w 378
        //   23: invokestatic 204	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   26: aload_0
        //   27: lload_1
        //   28: putfield 380	com/flurry/sdk/ap:e	J
        //   31: aload_0
        //   32: lload_3
        //   33: putfield 382	com/flurry/sdk/ap:f	J
        //   36: aload_0
        //   37: iconst_1
        //   38: putfield 376	com/flurry/sdk/ap:g	Z
        //   41: goto -28 -> 13
        //   44: astore 6
        //   46: aload_0
        //   47: monitorexit
        //   48: aload 6
        //   50: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	51	0	this	ap
        //   0	51	1	paramLong1	long
        //   0	51	3	paramLong2	long
        //   6	3	5	bool	boolean
        //   44	5	6	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	8	44	finally
        //   16	41	44	finally
    }

    public void a(b paramb) {
        synchronized (this.i) {
            this.i.a(paramb);
            return;
        }
    }

    public void a(InputStream paramInputStream)
            throws IOException {
        if (!this.g) {
            return;
        }
        this.a.a(paramInputStream);
    }

    public void a(OutputStream paramOutputStream)
            throws IOException {
        if (!this.g) {
            return;
        }
        this.a.a(paramOutputStream);
    }

    public void a(String paramString, ar paramar) {
        try {
            Iterator localIterator = i().iterator();
            while (localIterator.hasNext()) {
                ((b) localIterator.next()).a(paramString, paramar);
            }
            return;
        } catch (Throwable paramString) {
            eo.a(6, b, "", paramString);
        }
    }

    public void a(String paramString, List<AdUnit> paramList) {
        if (!this.h) {
            break label7;
        }
        label7:
        while (paramList == null) {
            return;
        }
        eo.a(3, b, "Handling ad response");
        if (TextUtils.isEmpty(paramString)) {
            if (this.f == 0L) {
            }
            for (int j = 5; ; j = (int) (this.e / this.f)) {
                paramString = paramList.iterator();
                int k = 0;
                for (; ; ) {
                    if (!paramString.hasNext()) {
                        break label84;
                    }
                    k = e((AdUnit) paramString.next()) + k;
                    if (k >= j) {
                        break;
                    }
                }
                label84:
                break label7;
            }
        }
        b(paramString, paramList);
    }

    public boolean a(AdUnit paramAdUnit) {
        if (!this.h) {
            return false;
        }
        if (paramAdUnit == null) {
            return false;
        }
        if (!g(paramAdUnit)) {
            return false;
        }
        paramAdUnit = paramAdUnit.d().iterator();
        while (paramAdUnit.hasNext()) {
            c localc = c.a(((AdFrame) paramAdUnit.next()).h().intValue());
            if ((c.b.equals(localc)) || (c.c.equals(localc))) {
                return true;
            }
        }
        return false;
    }

    public void b(String paramString) {
        if (!this.h) {
            return;
        }
        this.a.a(paramString);
    }

    public void b(String paramString, List<AdUnit> paramList) {
        if (!this.h) {
            break label7;
        }
        label7:
        while ((paramList == null) || (TextUtils.isEmpty(paramString))) {
            return;
        }
        int j = paramList.size() - 1;
        while (j >= 0) {
            h((AdUnit) paramList.get(j));
            j -= 1;
        }
        paramString = paramList.iterator();
        j = 0;
        label62:
        if (paramString.hasNext()) {
            if (e((AdUnit) paramString.next()) <= 0) {
                break label103;
            }
        }
        label103:
        for (int k = 1; ; k = 0) {
            j = k + j;
            if (j >= 2) {
                break;
            }
            break label62;
            break label7;
        }
    }

    public boolean b() {
        return this.g;
    }

    public boolean b(AdUnit paramAdUnit) {
        if (!this.h) {
            return false;
        }
        if (paramAdUnit == null) {
            return false;
        }
        if (!g(paramAdUnit)) {
            return false;
        }
        Iterator localIterator = paramAdUnit.d().iterator();
        while (localIterator.hasNext()) {
            c localc = c.a(((AdFrame) localIterator.next()).h().intValue());
            if ((g(paramAdUnit)) && (c.b.equals(localc))) {
                return true;
            }
        }
        return false;
    }

    public boolean b(b paramb) {
        synchronized (this.i) {
            boolean bool = this.i.b(paramb);
            return bool;
        }
    }

    public a c(AdUnit paramAdUnit) {
        if (!this.h) {
            localObject1 = a.f;
            return (a) localObject1;
        }
        if (paramAdUnit == null) {
            return a.d;
        }
        if (!g(paramAdUnit)) {
            return a.d;
        }
        Object localObject1 = a.a;
        Iterator localIterator = paramAdUnit.d().iterator();
        paramAdUnit = (AdUnit) localObject1;
        AdFrame localAdFrame;
        do {
            localObject1 = paramAdUnit;
            if (!localIterator.hasNext()) {
                break;
            }
            localAdFrame = (AdFrame) localIterator.next();
        } while (!a(localAdFrame));
        Object localObject2 = b(localAdFrame);
        localObject1 = paramAdUnit;
        if (!TextUtils.isEmpty((CharSequence) localObject2)) {
            localObject1 = a(paramAdUnit, this.a.b((String) localObject2));
        }
        localObject2 = c(localAdFrame);
        paramAdUnit = (AdUnit) localObject1;
        if (!TextUtils.isEmpty((CharSequence) localObject2)) {
            paramAdUnit = a((a) localObject1, this.a.b((String) localObject2));
        }
        localObject2 = c;
        int k = localObject2.length;
        int j = 0;
        for (localObject1 = paramAdUnit; ; localObject1 = paramAdUnit) {
            paramAdUnit = (AdUnit) localObject1;
            if (j >= k) {
                break;
            }
            String str = a(localAdFrame, localObject2[j]);
            paramAdUnit = (AdUnit) localObject1;
            if (!TextUtils.isEmpty(str)) {
                paramAdUnit = a((a) localObject1, this.a.b(str));
            }
            j += 1;
        }
    }

    /* Error */
    public void c() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 376	com/flurry/sdk/ap:g	Z
        //   6: istore_1
        //   7: iload_1
        //   8: ifne +6 -> 14
        //   11: aload_0
        //   12: monitorexit
        //   13: return
        //   14: aload_0
        //   15: getfield 242	com/flurry/sdk/ap:h	Z
        //   18: ifne -7 -> 11
        //   21: iconst_3
        //   22: getstatic 39	com/flurry/sdk/ap:b	Ljava/lang/String;
        //   25: ldc_w 431
        //   28: invokestatic 204	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   31: aload_0
        //   32: new 210	com/flurry/sdk/ao
        //   35: dup
        //   36: ldc_w 433
        //   39: aload_0
        //   40: getfield 380	com/flurry/sdk/ap:e	J
        //   43: aload_0
        //   44: getfield 382	com/flurry/sdk/ap:f	J
        //   47: iconst_0
        //   48: invokespecial 436	com/flurry/sdk/ao:<init>	(Ljava/lang/String;JJZ)V
        //   51: putfield 208	com/flurry/sdk/ap:a	Lcom/flurry/sdk/ao;
        //   54: aload_0
        //   55: getfield 208	com/flurry/sdk/ap:a	Lcom/flurry/sdk/ao;
        //   58: aload_0
        //   59: invokevirtual 439	com/flurry/sdk/ao:a	(Lcom/flurry/sdk/ao$a;)V
        //   62: aload_0
        //   63: getfield 208	com/flurry/sdk/ap:a	Lcom/flurry/sdk/ao;
        //   66: invokevirtual 441	com/flurry/sdk/ao:a	()V
        //   69: aload_0
        //   70: iconst_1
        //   71: putfield 242	com/flurry/sdk/ap:h	Z
        //   74: goto -63 -> 11
        //   77: astore_2
        //   78: aload_0
        //   79: monitorexit
        //   80: aload_2
        //   81: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	82	0	this	ap
        //   6	2	1	bool	boolean
        //   77	4	2	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	7	77	finally
        //   14	74	77	finally
    }

    /* Error */
    public void d() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 242	com/flurry/sdk/ap:h	Z
        //   6: istore_1
        //   7: iload_1
        //   8: ifne +6 -> 14
        //   11: aload_0
        //   12: monitorexit
        //   13: return
        //   14: iconst_3
        //   15: getstatic 39	com/flurry/sdk/ap:b	Ljava/lang/String;
        //   18: ldc_w 443
        //   21: invokestatic 204	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   24: aload_0
        //   25: getfield 208	com/flurry/sdk/ap:a	Lcom/flurry/sdk/ao;
        //   28: invokevirtual 445	com/flurry/sdk/ao:b	()V
        //   31: aload_0
        //   32: iconst_0
        //   33: putfield 242	com/flurry/sdk/ap:h	Z
        //   36: goto -25 -> 11
        //   39: astore_2
        //   40: aload_0
        //   41: monitorexit
        //   42: aload_2
        //   43: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	44	0	this	ap
        //   6	2	1	bool	boolean
        //   39	4	2	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	7	39	finally
        //   14	36	39	finally
    }

    public boolean d(AdUnit paramAdUnit) {
        if (!this.h) {
            return false;
        }
        if (paramAdUnit == null) {
            return false;
        }
        eo.a(3, b, "Precaching: Saving local assets for adUnit.");
        j();
        paramAdUnit = paramAdUnit.d().iterator();
        while (paramAdUnit.hasNext()) {
            AdFrame localAdFrame = (AdFrame) paramAdUnit.next();
            if (a(localAdFrame)) {
                Object localObject = b(localAdFrame);
                if ((!TextUtils.isEmpty((CharSequence) localObject)) && (!c((String) localObject))) {
                    return false;
                }
                localObject = c(localAdFrame);
                if ((!TextUtils.isEmpty((CharSequence) localObject)) && (!c((String) localObject))) {
                    return false;
                }
                localObject = c;
                int k = localObject.length;
                int j = 0;
                while (j < k) {
                    String str = a(localAdFrame, localObject[j]);
                    if ((!TextUtils.isEmpty(str)) && (!c(str))) {
                        return false;
                    }
                    j += 1;
                }
            }
        }
        return true;
    }

    public int e(AdUnit paramAdUnit) {
        if (!this.h) {
        }
        while (paramAdUnit == null) {
            return 0;
        }
        paramAdUnit = paramAdUnit.d().iterator();
        int j = 0;
        Object localObject1;
        Object localObject2;
        Object localObject3;
        long l;
        for (; ; ) {
            if (paramAdUnit.hasNext()) {
                localObject1 = (AdFrame) paramAdUnit.next();
                localObject2 = c.a(((AdFrame) localObject1).h().intValue());
                if ((!c.a.equals(localObject2)) && (a((AdFrame) localObject1))) {
                    localObject3 = ((AdFrame) localObject1).j();
                    localObject2 = ((AdFrame) localObject1).k();
                    l = ((AdFrame) localObject1).i().longValue();
                    if ((localObject3 != null) && (((List) localObject3).size() > 0)) {
                        localObject1 = ((List) localObject3).iterator();
                        while (((Iterator) localObject1).hasNext()) {
                            if (a(((CharSequence) ((Iterator) localObject1).next()).toString(), l)) {
                                j += 1;
                            }
                        }
                    }
                }
            }
        }
        for (; ; ) {
            break;
            localObject3 = b((AdFrame) localObject1);
            int k = j;
            if (!TextUtils.isEmpty((CharSequence) localObject3)) {
                k = j;
                if (!a((List) localObject2, (String) localObject3)) {
                    k = j;
                    if (a((String) localObject3, l)) {
                        k = j + 1;
                    }
                }
            }
            localObject3 = c((AdFrame) localObject1);
            j = k;
            if (!TextUtils.isEmpty((CharSequence) localObject3)) {
                j = k;
                if (!a((List) localObject2, (String) localObject3)) {
                    j = k;
                    if (a((String) localObject3, l)) {
                        j = k + 1;
                    }
                }
            }
            localObject3 = c;
            int n = localObject3.length;
            k = 0;
            while (k < n) {
                String str = a((AdFrame) localObject1, localObject3[k]);
                int m = j;
                if (!TextUtils.isEmpty(str)) {
                    m = j;
                    if (!a((List) localObject2, str)) {
                        m = j;
                        if (a(str, l)) {
                            m = j + 1;
                        }
                    }
                }
                k += 1;
                j = m;
                continue;
                return j;
            }
        }
    }

    /* Error */
    public void e() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 242	com/flurry/sdk/ap:h	Z
        //   6: istore_1
        //   7: iload_1
        //   8: ifne +6 -> 14
        //   11: aload_0
        //   12: monitorexit
        //   13: return
        //   14: iconst_3
        //   15: getstatic 39	com/flurry/sdk/ap:b	Ljava/lang/String;
        //   18: ldc_w 464
        //   21: invokestatic 204	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   24: aload_0
        //   25: getfield 208	com/flurry/sdk/ap:a	Lcom/flurry/sdk/ao;
        //   28: invokevirtual 466	com/flurry/sdk/ao:c	()V
        //   31: goto -20 -> 11
        //   34: astore_2
        //   35: aload_0
        //   36: monitorexit
        //   37: aload_2
        //   38: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	39	0	this	ap
        //   6	2	1	bool	boolean
        //   34	4	2	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	7	34	finally
        //   14	31	34	finally
    }

    /* Error */
    public void f() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 242	com/flurry/sdk/ap:h	Z
        //   6: istore_1
        //   7: iload_1
        //   8: ifne +6 -> 14
        //   11: aload_0
        //   12: monitorexit
        //   13: return
        //   14: iconst_3
        //   15: getstatic 39	com/flurry/sdk/ap:b	Ljava/lang/String;
        //   18: ldc_w 468
        //   21: invokestatic 204	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   24: aload_0
        //   25: getfield 208	com/flurry/sdk/ap:a	Lcom/flurry/sdk/ao;
        //   28: invokevirtual 470	com/flurry/sdk/ao:d	()V
        //   31: goto -20 -> 11
        //   34: astore_2
        //   35: aload_0
        //   36: monitorexit
        //   37: aload_2
        //   38: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	39	0	this	ap
        //   6	2	1	bool	boolean
        //   34	4	2	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	7	34	finally
        //   14	31	34	finally
    }

    public void f(AdUnit paramAdUnit) {
        if (!this.h) {
            return;
        }
        while (paramAdUnit == null) {
        }
        paramAdUnit = paramAdUnit.d().iterator();
        while (paramAdUnit.hasNext()) {
            Object localObject1 = (AdFrame) paramAdUnit.next();
            Object localObject2 = c.a(((AdFrame) localObject1).h().intValue());
            if ((c.a.equals(localObject2)) || (!a((AdFrame) localObject1))) {
                break;
            }
            Object localObject3 = ((AdFrame) localObject1).j();
            localObject2 = ((AdFrame) localObject1).k();
            ((AdFrame) localObject1).i().longValue();
            if ((localObject3 != null) && (((List) localObject3).size() > 0)) {
                localObject1 = ((List) localObject3).iterator();
                while (((Iterator) localObject1).hasNext()) {
                    b(((CharSequence) ((Iterator) localObject1).next()).toString());
                }
            } else {
                localObject3 = b((AdFrame) localObject1);
                if ((!TextUtils.isEmpty((CharSequence) localObject3)) && (!a((List) localObject2, (String) localObject3))) {
                    b(((String) localObject3).toString());
                }
                localObject3 = c((AdFrame) localObject1);
                if ((!TextUtils.isEmpty((CharSequence) localObject3)) && (!a((List) localObject2, (String) localObject3))) {
                    b(((String) localObject3).toString());
                }
                localObject3 = c;
                int k = localObject3.length;
                int j = 0;
                while (j < k) {
                    String str = a((AdFrame) localObject1, localObject3[j]);
                    if ((!TextUtils.isEmpty(str)) && (!a((List) localObject2, str))) {
                        b(str.toString());
                    }
                    j += 1;
                }
            }
        }
    }

    public void g() {
        if (!this.h) {
            return;
        }
        this.a.e();
    }

    public List<aq> h() {
        if (!this.h) {
            return Collections.emptyList();
        }
        return this.a.h();
    }

    public static enum a {
        private final int g;

        private a(int paramInt) {
            this.g = paramInt;
        }
    }

    public static abstract interface b {
        public abstract void a(String paramString, ar paramar);
    }

    public static enum c {
        private final int d;

        private c(int paramInt) {
            this.d = paramInt;
        }

        public static c a(int paramInt) {
            switch (paramInt) {
                default:
                    return null;
                case 0:
                    return a;
                case 1:
                    return b;
            }
            return c;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */