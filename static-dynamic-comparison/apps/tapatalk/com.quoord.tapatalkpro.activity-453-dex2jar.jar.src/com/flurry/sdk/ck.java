package com.flurry.sdk;

import android.text.TextUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ck {
    private static final String a = null;

    /* Error */
    public static ci a(String paramString) {
        // Byte code:
        //   0: aload_0
        //   1: ifnonnull +5 -> 6
        //   4: aconst_null
        //   5: areturn
        //   6: new 16	java/io/StringReader
        //   9: dup
        //   10: aload_0
        //   11: invokespecial 20	java/io/StringReader:<init>	(Ljava/lang/String;)V
        //   14: astore_2
        //   15: aload_2
        //   16: astore_1
        //   17: invokestatic 26	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
        //   20: astore_3
        //   21: aload_2
        //   22: astore_1
        //   23: aload_3
        //   24: ldc 28
        //   26: iconst_0
        //   27: invokeinterface 34 3 0
        //   32: aload_2
        //   33: astore_1
        //   34: aload_3
        //   35: aload_2
        //   36: invokeinterface 38 2 0
        //   41: aload_2
        //   42: astore_1
        //   43: aload_3
        //   44: invokeinterface 42 1 0
        //   49: pop
        //   50: aload_2
        //   51: astore_1
        //   52: aload_3
        //   53: new 44	com/flurry/sdk/ci$a
        //   56: dup
        //   57: invokespecial 46	com/flurry/sdk/ci$a:<init>	()V
        //   60: new 48	java/util/ArrayList
        //   63: dup
        //   64: invokespecial 49	java/util/ArrayList:<init>	()V
        //   67: invokestatic 52	com/flurry/sdk/ck:a	(Lorg/xmlpull/v1/XmlPullParser;Lcom/flurry/sdk/ci$a;Ljava/util/List;)Lcom/flurry/sdk/ci;
        //   70: astore_3
        //   71: aload_2
        //   72: astore_1
        //   73: iconst_3
        //   74: ldc 54
        //   76: new 56	java/lang/StringBuilder
        //   79: dup
        //   80: invokespecial 57	java/lang/StringBuilder:<init>	()V
        //   83: ldc 59
        //   85: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   88: aload_0
        //   89: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   92: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   95: invokestatic 72	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   98: aload_2
        //   99: invokestatic 77	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   102: aload_3
        //   103: areturn
        //   104: astore_3
        //   105: aconst_null
        //   106: astore_2
        //   107: aload_2
        //   108: astore_1
        //   109: iconst_3
        //   110: ldc 54
        //   112: new 56	java/lang/StringBuilder
        //   115: dup
        //   116: invokespecial 57	java/lang/StringBuilder:<init>	()V
        //   119: ldc 79
        //   121: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   124: aload_0
        //   125: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   128: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   131: aload_3
        //   132: invokestatic 82	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   135: aload_2
        //   136: astore_1
        //   137: new 44	com/flurry/sdk/ci$a
        //   140: dup
        //   141: invokespecial 46	com/flurry/sdk/ci$a:<init>	()V
        //   144: invokevirtual 85	com/flurry/sdk/ci$a:a	()Lcom/flurry/sdk/ci$a;
        //   147: invokevirtual 89	com/flurry/sdk/ci$a:b	()Lcom/flurry/sdk/ci;
        //   150: astore_0
        //   151: aload_2
        //   152: invokestatic 77	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   155: aload_0
        //   156: areturn
        //   157: astore_0
        //   158: aconst_null
        //   159: astore_1
        //   160: aload_1
        //   161: invokestatic 77	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   164: aload_0
        //   165: athrow
        //   166: astore_0
        //   167: goto -7 -> 160
        //   170: astore_3
        //   171: goto -64 -> 107
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	174	0	paramString	String
        //   16	145	1	localStringReader1	java.io.StringReader
        //   14	138	2	localStringReader2	java.io.StringReader
        //   20	83	3	localObject	Object
        //   104	28	3	localException1	Exception
        //   170	1	3	localException2	Exception
        // Exception table:
        //   from	to	target	type
        //   6	15	104	java/lang/Exception
        //   6	15	157	finally
        //   17	21	166	finally
        //   23	32	166	finally
        //   34	41	166	finally
        //   43	50	166	finally
        //   52	71	166	finally
        //   73	98	166	finally
        //   109	135	166	finally
        //   137	151	166	finally
        //   17	21	170	java/lang/Exception
        //   23	32	170	java/lang/Exception
        //   34	41	170	java/lang/Exception
        //   43	50	170	java/lang/Exception
        //   52	71	170	java/lang/Exception
        //   73	98	170	java/lang/Exception
    }

    private static ci a(XmlPullParser paramXmlPullParser, ci.a parama, List<cq> paramList)
            throws XmlPullParserException, IOException {
        paramXmlPullParser.require(2, a, "VAST");
        String str = paramXmlPullParser.getAttributeValue(a, "version");
        if (str != null) {
            for (; ; ) {
                try {
                    int i = Math.round(Float.parseFloat(str));
                    if ((i < 1) || (i > 3)) {
                        continue;
                    }
                    parama.a(i);
                } catch (NumberFormatException localNumberFormatException) {
                    eo.a(3, "VASTXmlParser", "Could not identify VAST version");
                    continue;
                } catch (Exception localException) {
                    eo.a(3, "VASTXmlParser", "VAST version not supported");
                    continue;
                    b(paramXmlPullParser);
                    continue;
                    parama.a(paramList);
                    parama.a(a(paramList));
                }
                if (paramXmlPullParser.next() == 3) {
                    continue;
                }
                if (paramXmlPullParser.getEventType() == 2) {
                    if (!paramXmlPullParser.getName().equals("Ad")) {
                        continue;
                    }
                    paramList.add(a(paramXmlPullParser, new cq.a()));
                }
            }
            throw new Exception();
        }
        for (; ; ) {
            return parama.b();
            eo.a(3, "VASTXmlParser", "Could not identify VAST version");
        }
    }

    private static cq a(XmlPullParser paramXmlPullParser, cq.a parama)
            throws IOException, XmlPullParserException {
        paramXmlPullParser.require(2, a, "Ad");
        parama.a(paramXmlPullParser.getAttributeValue(a, "id"));
        try {
            parama.a(Integer.parseInt(paramXmlPullParser.getAttributeValue(a, "sequence")));
            for (; ; ) {
                if (paramXmlPullParser.next() == 3) {
                    break label198;
                }
                if (paramXmlPullParser.getEventType() == 2) {
                    String str = paramXmlPullParser.getName();
                    if (!str.equals("InLine")) {
                        break;
                    }
                    parama.a(a(paramXmlPullParser, new cs.a(), new cr.a(), new ArrayList(), new ArrayList()));
                }
            }
        } catch (NumberFormatException localNumberFormatException) {
            for (; ; ) {
                eo.a(3, "VASTXmlParser", "Could not identify Ad Sequence");
                continue;
                if (localNumberFormatException.equals("Wrapper")) {
                    parama.a(a(paramXmlPullParser, new cs.a(), new cr.a(), new ArrayList(), new ArrayList(), new ArrayList()));
                } else {
                    b(paramXmlPullParser);
                }
            }
        }
        label198:
        return parama.a();
    }

    private static cs a(XmlPullParser paramXmlPullParser, cs.a parama, cr.a parama1, List<String> paramList1, List<String> paramList2)
            throws IOException, XmlPullParserException {
        parama.a(cl.b);
        paramXmlPullParser.require(2, a, "InLine");
        while (paramXmlPullParser.next() != 3) {
            if (paramXmlPullParser.getEventType() == 2) {
                String str = paramXmlPullParser.getName();
                if (str.equals("Creatives")) {
                    parama.d(a(paramXmlPullParser, new ArrayList()));
                } else if (str.equals("AdSystem")) {
                    parama1.a(paramXmlPullParser.getAttributeValue(a, "version"));
                    parama1.b(a(paramXmlPullParser));
                    parama.a(parama1.a());
                } else if (str.equals("AdTitle")) {
                    parama.a(a(paramXmlPullParser));
                } else if (str.equals("Impression")) {
                    a(paramList1, a(paramXmlPullParser));
                } else if (str.equals("Error")) {
                    a(paramList2, a(paramXmlPullParser));
                } else {
                    b(paramXmlPullParser);
                }
            }
        }
        parama.b(paramList1);
        parama.c(paramList2);
        return parama.a();
    }

    private static cs a(XmlPullParser paramXmlPullParser, cs.a parama, cr.a parama1, List<String> paramList1, List<String> paramList2, List<String> paramList3)
            throws IOException, XmlPullParserException {
        parama.a(cl.c);
        paramXmlPullParser.require(2, a, "Wrapper");
        while (paramXmlPullParser.next() != 3) {
            if (paramXmlPullParser.getEventType() == 2) {
                String str = paramXmlPullParser.getName();
                if (str.equals("Creatives")) {
                    parama.d(a(paramXmlPullParser, new ArrayList()));
                } else if (str.equals("AdSystem")) {
                    parama1.a(paramXmlPullParser.getAttributeValue(a, "version"));
                    parama1.b(a(paramXmlPullParser));
                    parama.a(parama1.a());
                } else if (str.equals("VASTAdTagURI")) {
                    a(paramList1, a(paramXmlPullParser));
                } else if (str.equals("Impression")) {
                    a(paramList2, a(paramXmlPullParser));
                } else if (str.equals("Error")) {
                    a(paramList3, a(paramXmlPullParser));
                } else {
                    b(paramXmlPullParser);
                }
            }
        }
        parama.a(paramList1);
        parama.b(paramList2);
        parama.c(paramList3);
        return parama.a();
    }

    private static ct a(XmlPullParser paramXmlPullParser, ct.a parama)
            throws IOException, XmlPullParserException {
        paramXmlPullParser.require(2, a, "Creative");
        parama.a(paramXmlPullParser.getAttributeValue(a, "id"));
        String str = paramXmlPullParser.getAttributeValue(a, "sequence");
        if (str != null) {
        }
        try {
            parama.a(Math.round(Float.parseFloat(str)));
            for (; ; ) {
                if (paramXmlPullParser.next() == 3) {
                    break label139;
                }
                if (paramXmlPullParser.getEventType() == 2) {
                    if (!paramXmlPullParser.getName().equals("Linear")) {
                        break;
                    }
                    parama.a(cm.b);
                    parama.a(a(paramXmlPullParser, new cu.a()));
                }
            }
        } catch (NumberFormatException localNumberFormatException) {
            for (; ; ) {
                eo.a(3, "VASTXmlParser", "Could not identify Creative sequence");
                continue;
                b(paramXmlPullParser);
            }
        }
        label139:
        return parama.a();
    }

    private static cu a(XmlPullParser paramXmlPullParser, cu.a parama)
            throws IOException, XmlPullParserException {
        paramXmlPullParser.require(2, a, "Linear");
        String str = paramXmlPullParser.getAttributeValue(a, "skipoffset");
        if (str != null) {
            parama.b(cj.b(str));
        }
        while (paramXmlPullParser.next() != 3) {
            if (paramXmlPullParser.getEventType() == 2) {
                str = paramXmlPullParser.getName();
                if (str.equals("Duration")) {
                    parama.a(cj.b(a(paramXmlPullParser)));
                } else if (str.equals("TrackingEvents")) {
                    parama.a(a(paramXmlPullParser, new ds()));
                } else if (str.equals("VideoClicks")) {
                    parama.a(a(paramXmlPullParser, new HashMap()));
                } else if (str.equals("MediaFiles")) {
                    parama.a(cj.a(b(paramXmlPullParser, new ArrayList())));
                } else {
                    b(paramXmlPullParser);
                }
            }
        }
        return parama.a();
    }

    private static cv a(XmlPullParser paramXmlPullParser, cv.a parama)
            throws IOException, XmlPullParserException {
        paramXmlPullParser.require(2, a, "MediaFile");
        parama.a(paramXmlPullParser.getAttributeValue(a, "id"));
        parama.d(paramXmlPullParser.getAttributeValue(a, "type"));
        parama.b(paramXmlPullParser.getAttributeValue(a, "apiFramework"));
        parama.a(cn.a(paramXmlPullParser.getAttributeValue(a, "delivery")));
        try {
            parama.b(Integer.parseInt(paramXmlPullParser.getAttributeValue(a, "height")));
        } catch (NumberFormatException localNumberFormatException2) {
            try {
                parama.c(Integer.parseInt(paramXmlPullParser.getAttributeValue(a, "width")));
            } catch (NumberFormatException localNumberFormatException2) {
                try {
                    for (; ; ) {
                        parama.a(Integer.parseInt(paramXmlPullParser.getAttributeValue(a, "bitrate")));
                        parama.b(Boolean.parseBoolean(paramXmlPullParser.getAttributeValue(a, "scalable")));
                        parama.a(Boolean.parseBoolean(paramXmlPullParser.getAttributeValue(a, "maintainAspectRatio")));
                        parama.c(a(paramXmlPullParser));
                        return parama.a();
                        localNumberFormatException1 = localNumberFormatException1;
                        eo.a(3, "VASTXmlParser", "Could not identify MediaFile height");
                        continue;
                        localNumberFormatException2 = localNumberFormatException2;
                        eo.a(3, "VASTXmlParser", "Could not identify MediaFile width");
                    }
                } catch (NumberFormatException localNumberFormatException3) {
                    for (; ; ) {
                        eo.a(3, "VASTXmlParser", "Could not identify MediaFile bitRate");
                    }
                }
            }
        }
    }

    private static cw a(XmlPullParser paramXmlPullParser, cw.a parama)
            throws IOException, XmlPullParserException {
        paramXmlPullParser.require(2, a, "Tracking");
        parama.a(co.a(paramXmlPullParser.getAttributeValue(a, "event")));
        parama.a(a(paramXmlPullParser));
        return parama.a();
    }

    private static ds<co, String> a(XmlPullParser paramXmlPullParser, ds<co, String> paramds)
            throws IOException, XmlPullParserException {
        paramXmlPullParser.require(2, a, "TrackingEvents");
        while (paramXmlPullParser.next() != 3) {
            if (paramXmlPullParser.getEventType() == 2) {
                if (paramXmlPullParser.getName().equals("Tracking")) {
                    cw localcw = a(paramXmlPullParser, new cw.a());
                    if (!TextUtils.isEmpty(localcw.b())) {
                        paramds.a(localcw.a(), localcw.b());
                    }
                } else {
                    b(paramXmlPullParser);
                }
            }
        }
        return paramds;
    }

    private static String a(XmlPullParser paramXmlPullParser)
            throws IOException, XmlPullParserException {
        String str = null;
        if (paramXmlPullParser.next() == 4) {
            str = paramXmlPullParser.getText().trim();
            paramXmlPullParser.nextTag();
        }
        return str;
    }

    private static List<ct> a(XmlPullParser paramXmlPullParser, List<ct> paramList)
            throws IOException, XmlPullParserException {
        paramXmlPullParser.require(2, a, "Creatives");
        while (paramXmlPullParser.next() != 3) {
            if (paramXmlPullParser.getEventType() == 2) {
                if (paramXmlPullParser.getName().equals("Creative")) {
                    paramList.add(a(paramXmlPullParser, new ct.a()));
                } else {
                    b(paramXmlPullParser);
                }
            }
        }
        return paramList;
    }

    private static Map<cp, String> a(XmlPullParser paramXmlPullParser, Map<cp, String> paramMap)
            throws IOException, XmlPullParserException {
        paramXmlPullParser.require(2, a, "VideoClicks");
        while (paramXmlPullParser.next() != 3) {
            if (paramXmlPullParser.getEventType() == 2) {
                String str = paramXmlPullParser.getName();
                if (str.equals("ClickThrough")) {
                    paramMap.put(cp.b, a(paramXmlPullParser));
                } else if (str.equals("ClickTracking")) {
                    paramMap.put(cp.c, a(paramXmlPullParser));
                } else if (str.equals("CustomClick")) {
                    paramMap.put(cp.d, a(paramXmlPullParser));
                } else {
                    b(paramXmlPullParser);
                }
            }
        }
        return paramMap;
    }

    private static void a(List<String> paramList, String paramString) {
        if (paramList == null) {
        }
        while (TextUtils.isEmpty(paramString)) {
            return;
        }
        paramList.add(paramString);
    }

    public static boolean a(List<cq> paramList) {
        if ((paramList == null) || (paramList.isEmpty())) {
            return false;
        }
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
            cs localcs = ((cq) paramList.next()).c();
            if ((localcs == null) || (!cl.b.equals(localcs.a()))) {
                return false;
            }
        }
        return true;
    }

    private static List<cv> b(XmlPullParser paramXmlPullParser, List<cv> paramList)
            throws IOException, XmlPullParserException {
        paramXmlPullParser.require(2, a, "MediaFiles");
        while (paramXmlPullParser.next() != 3) {
            if (paramXmlPullParser.getEventType() == 2) {
                if (paramXmlPullParser.getName().equals("MediaFile")) {
                    paramList.add(a(paramXmlPullParser, new cv.a()));
                } else {
                    b(paramXmlPullParser);
                }
            }
        }
        return paramList;
    }

    private static void b(XmlPullParser paramXmlPullParser)
            throws XmlPullParserException, IOException {
        if (paramXmlPullParser.getEventType() != 2) {
            throw new IllegalStateException();
        }
        int i = 1;
        while (i != 0) {
            switch (paramXmlPullParser.next()) {
                default:
                    break;
                case 2:
                    i += 1;
                    break;
                case 3:
                    i -= 1;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */