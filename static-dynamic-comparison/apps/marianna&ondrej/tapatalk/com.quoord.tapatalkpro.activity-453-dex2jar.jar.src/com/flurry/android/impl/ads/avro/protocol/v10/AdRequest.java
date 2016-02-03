package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn.q;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;
import com.flurry.sdk.gx;

import java.util.List;
import java.util.Map;

public class AdRequest
        extends gw
        implements gv {
    public static final fn SCHEMA$ = new fn.q().a("{\"type\":\"record\",\"name\":\"AdRequest\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"apiKey\",\"type\":\"string\"},{\"name\":\"agentVersion\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"adSpaceName\",\"type\":\"string\"},{\"name\":\"sessionId\",\"type\":\"long\"},{\"name\":\"adReportedIds\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"AdReportedId\",\"fields\":[{\"name\":\"type\",\"type\":\"int\"},{\"name\":\"id\",\"type\":\"bytes\"}]}}},{\"name\":\"location\",\"type\":{\"type\":\"record\",\"name\":\"Location\",\"fields\":[{\"name\":\"lat\",\"type\":\"float\",\"default\":0.0},{\"name\":\"lon\",\"type\":\"float\",\"default\":0.0}]},\"default\":\"null\"},{\"name\":\"testDevice\",\"type\":\"boolean\",\"default\":false},{\"name\":\"bindings\",\"type\":{\"type\":\"array\",\"items\":\"int\"}},{\"name\":\"adViewContainer\",\"type\":{\"type\":\"record\",\"name\":\"AdViewContainer\",\"fields\":[{\"name\":\"viewWidth\",\"type\":\"int\",\"default\":0},{\"name\":\"viewHeight\",\"type\":\"int\",\"default\":0},{\"name\":\"screenWidth\",\"type\":\"int\",\"default\":0},{\"name\":\"screenHeight\",\"type\":\"int\",\"default\":0},{\"name\":\"density\",\"type\":\"float\",\"default\":1.0},{\"name\":\"screenOrientation\",\"type\":{\"type\":\"enum\",\"name\":\"ScreenOrientationType\",\"symbols\":[\"PORTRAIT\",\"LANDSCAPE\",\"UNKNOWN\"]},\"default\":\"UNKNOWN\"}]},\"default\":\"null\"},{\"name\":\"locale\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"timezone\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"osVersion\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"devicePlatform\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"testAds\",\"type\":{\"type\":\"record\",\"name\":\"TestAds\",\"fields\":[{\"name\":\"adspacePlacement\",\"type\":\"int\",\"default\":0}]},\"default\":\"null\"},{\"name\":\"keywords\",\"type\":{\"type\":\"map\",\"values\":\"string\"},\"default\":[]},{\"name\":\"refresh\",\"type\":\"boolean\",\"default\":false},{\"name\":\"canDoSKAppStore\",\"type\":\"boolean\",\"default\":false},{\"name\":\"networkStatus\",\"type\":\"int\",\"default\":1},{\"name\":\"frequencyCapInfos\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"FrequencyCapInfo\",\"fields\":[{\"name\":\"idHash\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"serveTime\",\"type\":\"long\"},{\"name\":\"expirationTime\",\"type\":\"long\"},{\"name\":\"views\",\"type\":\"int\"},{\"name\":\"newCap\",\"type\":\"int\"},{\"name\":\"previousCap\",\"type\":\"int\"},{\"name\":\"previousCapType\",\"type\":\"int\"}]}}},{\"name\":\"adTrackingEnabled\",\"type\":\"boolean\"},{\"name\":\"preferredLanguage\",\"type\":\"string\"},{\"name\":\"bcat\",\"type\":{\"type\":\"array\",\"items\":\"string\"}},{\"name\":\"userAgent\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"targetingOverride\",\"type\":{\"type\":\"record\",\"name\":\"TargetingOverride\",\"fields\":[{\"name\":\"ageRange\",\"type\":\"int\",\"default\":-2},{\"name\":\"gender\",\"type\":\"int\",\"default\":-2},{\"name\":\"personas\",\"type\":{\"type\":\"array\",\"items\":\"int\"},\"default\":[]}]},\"default\":[]},{\"name\":\"sendConfiguration\",\"type\":\"boolean\",\"default\":false},{\"name\":\"origins\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"default\":[]},{\"name\":\"renderTime\",\"type\":\"boolean\",\"default\":false},{\"name\":\"clientSideRtbPayload\",\"type\":{\"type\":\"map\",\"values\":\"string\"},\"default\":[]}]}");
    @Deprecated
    public boolean A;
    @Deprecated
    public Map<CharSequence, CharSequence> B;
    @Deprecated
    public CharSequence a;
    @Deprecated
    public CharSequence b;
    @Deprecated
    public CharSequence c;
    @Deprecated
    public long d;
    @Deprecated
    public List<AdReportedId> e;
    @Deprecated
    public Location f;
    @Deprecated
    public boolean g;
    @Deprecated
    public List<Integer> h;
    @Deprecated
    public AdViewContainer i;
    @Deprecated
    public CharSequence j;
    @Deprecated
    public CharSequence k;
    @Deprecated
    public CharSequence l;
    @Deprecated
    public CharSequence m;
    @Deprecated
    public TestAds n;
    @Deprecated
    public Map<CharSequence, CharSequence> o;
    @Deprecated
    public boolean p;
    @Deprecated
    public boolean q;
    @Deprecated
    public int r;
    @Deprecated
    public List<FrequencyCapInfo> s;
    @Deprecated
    public boolean t;
    @Deprecated
    public CharSequence u;
    @Deprecated
    public List<CharSequence> v;
    @Deprecated
    public CharSequence w;
    @Deprecated
    public TargetingOverride x;
    @Deprecated
    public boolean y;
    @Deprecated
    public List<CharSequence> z;

    public static Builder b() {
        return new Builder(null);
    }

    public fn a() {
        return SCHEMA$;
    }

    public Object a(int paramInt) {
        switch (paramInt) {
            default:
                throw new fk("Bad index");
            case 0:
                return this.a;
            case 1:
                return this.b;
            case 2:
                return this.c;
            case 3:
                return Long.valueOf(this.d);
            case 4:
                return this.e;
            case 5:
                return this.f;
            case 6:
                return Boolean.valueOf(this.g);
            case 7:
                return this.h;
            case 8:
                return this.i;
            case 9:
                return this.j;
            case 10:
                return this.k;
            case 11:
                return this.l;
            case 12:
                return this.m;
            case 13:
                return this.n;
            case 14:
                return this.o;
            case 15:
                return Boolean.valueOf(this.p);
            case 16:
                return Boolean.valueOf(this.q);
            case 17:
                return Integer.valueOf(this.r);
            case 18:
                return this.s;
            case 19:
                return Boolean.valueOf(this.t);
            case 20:
                return this.u;
            case 21:
                return this.v;
            case 22:
                return this.w;
            case 23:
                return this.x;
            case 24:
                return Boolean.valueOf(this.y);
            case 25:
                return this.z;
            case 26:
                return Boolean.valueOf(this.A);
        }
        return this.B;
    }

    public void a(int paramInt, Object paramObject) {
        switch (paramInt) {
            default:
                throw new fk("Bad index");
            case 0:
                this.a = ((CharSequence) paramObject);
                return;
            case 1:
                this.b = ((CharSequence) paramObject);
                return;
            case 2:
                this.c = ((CharSequence) paramObject);
                return;
            case 3:
                this.d = ((Long) paramObject).longValue();
                return;
            case 4:
                this.e = ((List) paramObject);
                return;
            case 5:
                this.f = ((Location) paramObject);
                return;
            case 6:
                this.g = ((Boolean) paramObject).booleanValue();
                return;
            case 7:
                this.h = ((List) paramObject);
                return;
            case 8:
                this.i = ((AdViewContainer) paramObject);
                return;
            case 9:
                this.j = ((CharSequence) paramObject);
                return;
            case 10:
                this.k = ((CharSequence) paramObject);
                return;
            case 11:
                this.l = ((CharSequence) paramObject);
                return;
            case 12:
                this.m = ((CharSequence) paramObject);
                return;
            case 13:
                this.n = ((TestAds) paramObject);
                return;
            case 14:
                this.o = ((Map) paramObject);
                return;
            case 15:
                this.p = ((Boolean) paramObject).booleanValue();
                return;
            case 16:
                this.q = ((Boolean) paramObject).booleanValue();
                return;
            case 17:
                this.r = ((Integer) paramObject).intValue();
                return;
            case 18:
                this.s = ((List) paramObject);
                return;
            case 19:
                this.t = ((Boolean) paramObject).booleanValue();
                return;
            case 20:
                this.u = ((CharSequence) paramObject);
                return;
            case 21:
                this.v = ((List) paramObject);
                return;
            case 22:
                this.w = ((CharSequence) paramObject);
                return;
            case 23:
                this.x = ((TargetingOverride) paramObject);
                return;
            case 24:
                this.y = ((Boolean) paramObject).booleanValue();
                return;
            case 25:
                this.z = ((List) paramObject);
                return;
            case 26:
                this.A = ((Boolean) paramObject).booleanValue();
                return;
        }
        this.B = ((Map) paramObject);
    }

    public void a(TestAds paramTestAds) {
        this.n = paramTestAds;
    }

    public void a(Boolean paramBoolean) {
        this.p = paramBoolean.booleanValue();
    }

    public void a(CharSequence paramCharSequence) {
        this.c = paramCharSequence;
    }

    public void a(Map<CharSequence, CharSequence> paramMap) {
        this.o = paramMap;
    }

    public void b(Map<CharSequence, CharSequence> paramMap) {
        this.B = paramMap;
    }

    public static class Builder
            extends gx<AdRequest> {
        private boolean A;
        private Map<CharSequence, CharSequence> B;
        private CharSequence a;
        private CharSequence b;
        private CharSequence c;
        private long d;
        private List<AdReportedId> e;
        private Location f;
        private boolean g;
        private List<Integer> h;
        private AdViewContainer i;
        private CharSequence j;
        private CharSequence k;
        private CharSequence l;
        private CharSequence m;
        private TestAds n;
        private Map<CharSequence, CharSequence> o;
        private boolean p;
        private boolean q;
        private int r;
        private List<FrequencyCapInfo> s;
        private boolean t;
        private CharSequence u;
        private List<CharSequence> v;
        private CharSequence w;
        private TargetingOverride x;
        private boolean y;
        private List<CharSequence> z;

        private Builder() {
            super();
        }

        public Builder a(int paramInt) {
            a(b()[17], Integer.valueOf(paramInt));
            this.r = paramInt;
            c()[17] = 1;
            return this;
        }

        public Builder a(long paramLong) {
            a(b()[3], Long.valueOf(paramLong));
            this.d = paramLong;
            c()[3] = 1;
            return this;
        }

        public Builder a(AdViewContainer paramAdViewContainer) {
            a(b()[8], paramAdViewContainer);
            this.i = paramAdViewContainer;
            c()[8] = 1;
            return this;
        }

        public Builder a(Location paramLocation) {
            a(b()[5], paramLocation);
            this.f = paramLocation;
            c()[5] = 1;
            return this;
        }

        public Builder a(CharSequence paramCharSequence) {
            a(b()[0], paramCharSequence);
            this.a = paramCharSequence;
            c()[0] = 1;
            return this;
        }

        public Builder a(List<AdReportedId> paramList) {
            a(b()[4], paramList);
            this.e = paramList;
            c()[4] = 1;
            return this;
        }

        public Builder a(boolean paramBoolean) {
            a(b()[6], Boolean.valueOf(paramBoolean));
            this.g = paramBoolean;
            c()[6] = 1;
            return this;
        }

        /* Error */
        public AdRequest a() {
            // Byte code:
            //   0: new 7	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest
            //   3: dup
            //   4: invokespecial 116	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:<init>	()V
            //   7: astore 6
            //   9: aload_0
            //   10: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:c	()[Z
            //   13: iconst_0
            //   14: baload
            //   15: ifeq +631 -> 646
            //   18: aload_0
            //   19: getfield 99	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	Ljava/lang/CharSequence;
            //   22: astore 5
            //   24: aload 6
            //   26: aload 5
            //   28: putfield 117	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:a	Ljava/lang/CharSequence;
            //   31: aload_0
            //   32: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:c	()[Z
            //   35: iconst_1
            //   36: baload
            //   37: ifeq +627 -> 664
            //   40: aload_0
            //   41: getfield 119	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:b	Ljava/lang/CharSequence;
            //   44: astore 5
            //   46: aload 6
            //   48: aload 5
            //   50: putfield 120	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:b	Ljava/lang/CharSequence;
            //   53: aload_0
            //   54: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:c	()[Z
            //   57: iconst_2
            //   58: baload
            //   59: ifeq +623 -> 682
            //   62: aload_0
            //   63: getfield 122	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:c	Ljava/lang/CharSequence;
            //   66: astore 5
            //   68: aload 6
            //   70: aload 5
            //   72: putfield 123	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:c	Ljava/lang/CharSequence;
            //   75: aload_0
            //   76: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:c	()[Z
            //   79: iconst_3
            //   80: baload
            //   81: ifeq +619 -> 700
            //   84: aload_0
            //   85: getfield 90	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:d	J
            //   88: lstore_2
            //   89: aload 6
            //   91: lload_2
            //   92: putfield 124	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:d	J
            //   95: aload_0
            //   96: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:c	()[Z
            //   99: iconst_4
            //   100: baload
            //   101: ifeq +619 -> 720
            //   104: aload_0
            //   105: getfield 102	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:e	Ljava/util/List;
            //   108: astore 5
            //   110: aload 6
            //   112: aload 5
            //   114: putfield 125	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:e	Ljava/util/List;
            //   117: aload_0
            //   118: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:c	()[Z
            //   121: iconst_5
            //   122: baload
            //   123: ifeq +615 -> 738
            //   126: aload_0
            //   127: getfield 96	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:f	Lcom/flurry/android/impl/ads/avro/protocol/v10/Location;
            //   130: astore 5
            //   132: aload 6
            //   134: aload 5
            //   136: putfield 126	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:f	Lcom/flurry/android/impl/ads/avro/protocol/v10/Location;
            //   139: aload_0
            //   140: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:c	()[Z
            //   143: bipush 6
            //   145: baload
            //   146: ifeq +610 -> 756
            //   149: aload_0
            //   150: getfield 112	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:g	Z
            //   153: istore 4
            //   155: aload 6
            //   157: iload 4
            //   159: putfield 127	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:g	Z
            //   162: aload_0
            //   163: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:c	()[Z
            //   166: bipush 7
            //   168: baload
            //   169: ifeq +609 -> 778
            //   172: aload_0
            //   173: getfield 129	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:h	Ljava/util/List;
            //   176: astore 5
            //   178: aload 6
            //   180: aload 5
            //   182: putfield 130	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:h	Ljava/util/List;
            //   185: aload_0
            //   186: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:c	()[Z
            //   189: bipush 8
            //   191: baload
            //   192: ifeq +605 -> 797
            //   195: aload_0
            //   196: getfield 93	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:i	Lcom/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer;
            //   199: astore 5
            //   201: aload 6
            //   203: aload 5
            //   205: putfield 131	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:i	Lcom/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer;
            //   208: aload_0
            //   209: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:c	()[Z
            //   212: bipush 9
            //   214: baload
            //   215: ifeq +601 -> 816
            //   218: aload_0
            //   219: getfield 133	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:j	Ljava/lang/CharSequence;
            //   222: astore 5
            //   224: aload 6
            //   226: aload 5
            //   228: putfield 134	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:j	Ljava/lang/CharSequence;
            //   231: aload_0
            //   232: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:c	()[Z
            //   235: bipush 10
            //   237: baload
            //   238: ifeq +597 -> 835
            //   241: aload_0
            //   242: getfield 136	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:k	Ljava/lang/CharSequence;
            //   245: astore 5
            //   247: aload 6
            //   249: aload 5
            //   251: putfield 137	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:k	Ljava/lang/CharSequence;
            //   254: aload_0
            //   255: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:c	()[Z
            //   258: bipush 11
            //   260: baload
            //   261: ifeq +593 -> 854
            //   264: aload_0
            //   265: getfield 139	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:l	Ljava/lang/CharSequence;
            //   268: astore 5
            //   270: aload 6
            //   272: aload 5
            //   274: putfield 140	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:l	Ljava/lang/CharSequence;
            //   277: aload_0
            //   278: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:c	()[Z
            //   281: bipush 12
            //   283: baload
            //   284: ifeq +589 -> 873
            //   287: aload_0
            //   288: getfield 142	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:m	Ljava/lang/CharSequence;
            //   291: astore 5
            //   293: aload 6
            //   295: aload 5
            //   297: putfield 143	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:m	Ljava/lang/CharSequence;
            //   300: aload_0
            //   301: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:c	()[Z
            //   304: bipush 13
            //   306: baload
            //   307: ifeq +585 -> 892
            //   310: aload_0
            //   311: getfield 145	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:n	Lcom/flurry/android/impl/ads/avro/protocol/v10/TestAds;
            //   314: astore 5
            //   316: aload 6
            //   318: aload 5
            //   320: putfield 146	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:n	Lcom/flurry/android/impl/ads/avro/protocol/v10/TestAds;
            //   323: aload_0
            //   324: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:c	()[Z
            //   327: bipush 14
            //   329: baload
            //   330: ifeq +581 -> 911
            //   333: aload_0
            //   334: getfield 148	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:o	Ljava/util/Map;
            //   337: astore 5
            //   339: aload 6
            //   341: aload 5
            //   343: putfield 149	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:o	Ljava/util/Map;
            //   346: aload_0
            //   347: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:c	()[Z
            //   350: bipush 15
            //   352: baload
            //   353: ifeq +577 -> 930
            //   356: aload_0
            //   357: getfield 151	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:p	Z
            //   360: istore 4
            //   362: aload 6
            //   364: iload 4
            //   366: putfield 152	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:p	Z
            //   369: aload_0
            //   370: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:c	()[Z
            //   373: bipush 16
            //   375: baload
            //   376: ifeq +576 -> 952
            //   379: aload_0
            //   380: getfield 154	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:q	Z
            //   383: istore 4
            //   385: aload 6
            //   387: iload 4
            //   389: putfield 155	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:q	Z
            //   392: aload_0
            //   393: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:c	()[Z
            //   396: bipush 17
            //   398: baload
            //   399: ifeq +575 -> 974
            //   402: aload_0
            //   403: getfield 79	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:r	I
            //   406: istore_1
            //   407: aload 6
            //   409: iload_1
            //   410: putfield 156	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:r	I
            //   413: aload_0
            //   414: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:c	()[Z
            //   417: bipush 18
            //   419: baload
            //   420: ifeq +575 -> 995
            //   423: aload_0
            //   424: getfield 158	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:s	Ljava/util/List;
            //   427: astore 5
            //   429: aload 6
            //   431: aload 5
            //   433: putfield 159	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:s	Ljava/util/List;
            //   436: aload_0
            //   437: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:c	()[Z
            //   440: bipush 19
            //   442: baload
            //   443: ifeq +571 -> 1014
            //   446: aload_0
            //   447: getfield 161	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:t	Z
            //   450: istore 4
            //   452: aload 6
            //   454: iload 4
            //   456: putfield 162	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:t	Z
            //   459: aload_0
            //   460: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:c	()[Z
            //   463: bipush 20
            //   465: baload
            //   466: ifeq +570 -> 1036
            //   469: aload_0
            //   470: getfield 164	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:u	Ljava/lang/CharSequence;
            //   473: astore 5
            //   475: aload 6
            //   477: aload 5
            //   479: putfield 165	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:u	Ljava/lang/CharSequence;
            //   482: aload_0
            //   483: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:c	()[Z
            //   486: bipush 21
            //   488: baload
            //   489: ifeq +566 -> 1055
            //   492: aload_0
            //   493: getfield 167	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:v	Ljava/util/List;
            //   496: astore 5
            //   498: aload 6
            //   500: aload 5
            //   502: putfield 168	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:v	Ljava/util/List;
            //   505: aload_0
            //   506: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:c	()[Z
            //   509: bipush 22
            //   511: baload
            //   512: ifeq +562 -> 1074
            //   515: aload_0
            //   516: getfield 170	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:w	Ljava/lang/CharSequence;
            //   519: astore 5
            //   521: aload 6
            //   523: aload 5
            //   525: putfield 171	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:w	Ljava/lang/CharSequence;
            //   528: aload_0
            //   529: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:c	()[Z
            //   532: bipush 23
            //   534: baload
            //   535: ifeq +558 -> 1093
            //   538: aload_0
            //   539: getfield 173	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:x	Lcom/flurry/android/impl/ads/avro/protocol/v10/TargetingOverride;
            //   542: astore 5
            //   544: aload 6
            //   546: aload 5
            //   548: putfield 174	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:x	Lcom/flurry/android/impl/ads/avro/protocol/v10/TargetingOverride;
            //   551: aload_0
            //   552: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:c	()[Z
            //   555: bipush 24
            //   557: baload
            //   558: ifeq +554 -> 1112
            //   561: aload_0
            //   562: getfield 176	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:y	Z
            //   565: istore 4
            //   567: aload 6
            //   569: iload 4
            //   571: putfield 177	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:y	Z
            //   574: aload_0
            //   575: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:c	()[Z
            //   578: bipush 25
            //   580: baload
            //   581: ifeq +553 -> 1134
            //   584: aload_0
            //   585: getfield 179	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:z	Ljava/util/List;
            //   588: astore 5
            //   590: aload 6
            //   592: aload 5
            //   594: putfield 180	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:z	Ljava/util/List;
            //   597: aload_0
            //   598: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:c	()[Z
            //   601: bipush 26
            //   603: baload
            //   604: ifeq +549 -> 1153
            //   607: aload_0
            //   608: getfield 182	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:A	Z
            //   611: istore 4
            //   613: aload 6
            //   615: iload 4
            //   617: putfield 183	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:A	Z
            //   620: aload_0
            //   621: invokevirtual 82	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:c	()[Z
            //   624: bipush 27
            //   626: baload
            //   627: ifeq +548 -> 1175
            //   630: aload_0
            //   631: getfield 185	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:B	Ljava/util/Map;
            //   634: astore 5
            //   636: aload 6
            //   638: aload 5
            //   640: putfield 186	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest:B	Ljava/util/Map;
            //   643: aload 6
            //   645: areturn
            //   646: aload_0
            //   647: aload_0
            //   648: invokevirtual 68	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   651: iconst_0
            //   652: aaload
            //   653: invokevirtual 189	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   656: checkcast 191	java/lang/CharSequence
            //   659: astore 5
            //   661: goto -637 -> 24
            //   664: aload_0
            //   665: aload_0
            //   666: invokevirtual 68	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   669: iconst_1
            //   670: aaload
            //   671: invokevirtual 189	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   674: checkcast 191	java/lang/CharSequence
            //   677: astore 5
            //   679: goto -633 -> 46
            //   682: aload_0
            //   683: aload_0
            //   684: invokevirtual 68	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   687: iconst_2
            //   688: aaload
            //   689: invokevirtual 189	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   692: checkcast 191	java/lang/CharSequence
            //   695: astore 5
            //   697: goto -629 -> 68
            //   700: aload_0
            //   701: aload_0
            //   702: invokevirtual 68	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   705: iconst_3
            //   706: aaload
            //   707: invokevirtual 189	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   710: checkcast 85	java/lang/Long
            //   713: invokevirtual 195	java/lang/Long:longValue	()J
            //   716: lstore_2
            //   717: goto -628 -> 89
            //   720: aload_0
            //   721: aload_0
            //   722: invokevirtual 68	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   725: iconst_4
            //   726: aaload
            //   727: invokevirtual 189	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   730: checkcast 197	java/util/List
            //   733: astore 5
            //   735: goto -625 -> 110
            //   738: aload_0
            //   739: aload_0
            //   740: invokevirtual 68	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   743: iconst_5
            //   744: aaload
            //   745: invokevirtual 189	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   748: checkcast 199	com/flurry/android/impl/ads/avro/protocol/v10/Location
            //   751: astore 5
            //   753: goto -621 -> 132
            //   756: aload_0
            //   757: aload_0
            //   758: invokevirtual 68	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   761: bipush 6
            //   763: aaload
            //   764: invokevirtual 189	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   767: checkcast 107	java/lang/Boolean
            //   770: invokevirtual 203	java/lang/Boolean:booleanValue	()Z
            //   773: istore 4
            //   775: goto -620 -> 155
            //   778: aload_0
            //   779: aload_0
            //   780: invokevirtual 68	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   783: bipush 7
            //   785: aaload
            //   786: invokevirtual 189	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   789: checkcast 197	java/util/List
            //   792: astore 5
            //   794: goto -616 -> 178
            //   797: aload_0
            //   798: aload_0
            //   799: invokevirtual 68	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   802: bipush 8
            //   804: aaload
            //   805: invokevirtual 189	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   808: checkcast 205	com/flurry/android/impl/ads/avro/protocol/v10/AdViewContainer
            //   811: astore 5
            //   813: goto -612 -> 201
            //   816: aload_0
            //   817: aload_0
            //   818: invokevirtual 68	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   821: bipush 9
            //   823: aaload
            //   824: invokevirtual 189	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   827: checkcast 191	java/lang/CharSequence
            //   830: astore 5
            //   832: goto -608 -> 224
            //   835: aload_0
            //   836: aload_0
            //   837: invokevirtual 68	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   840: bipush 10
            //   842: aaload
            //   843: invokevirtual 189	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   846: checkcast 191	java/lang/CharSequence
            //   849: astore 5
            //   851: goto -604 -> 247
            //   854: aload_0
            //   855: aload_0
            //   856: invokevirtual 68	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   859: bipush 11
            //   861: aaload
            //   862: invokevirtual 189	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   865: checkcast 191	java/lang/CharSequence
            //   868: astore 5
            //   870: goto -600 -> 270
            //   873: aload_0
            //   874: aload_0
            //   875: invokevirtual 68	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   878: bipush 12
            //   880: aaload
            //   881: invokevirtual 189	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   884: checkcast 191	java/lang/CharSequence
            //   887: astore 5
            //   889: goto -596 -> 293
            //   892: aload_0
            //   893: aload_0
            //   894: invokevirtual 68	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   897: bipush 13
            //   899: aaload
            //   900: invokevirtual 189	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   903: checkcast 207	com/flurry/android/impl/ads/avro/protocol/v10/TestAds
            //   906: astore 5
            //   908: goto -592 -> 316
            //   911: aload_0
            //   912: aload_0
            //   913: invokevirtual 68	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   916: bipush 14
            //   918: aaload
            //   919: invokevirtual 189	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   922: checkcast 209	java/util/Map
            //   925: astore 5
            //   927: goto -588 -> 339
            //   930: aload_0
            //   931: aload_0
            //   932: invokevirtual 68	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   935: bipush 15
            //   937: aaload
            //   938: invokevirtual 189	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   941: checkcast 107	java/lang/Boolean
            //   944: invokevirtual 203	java/lang/Boolean:booleanValue	()Z
            //   947: istore 4
            //   949: goto -587 -> 362
            //   952: aload_0
            //   953: aload_0
            //   954: invokevirtual 68	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   957: bipush 16
            //   959: aaload
            //   960: invokevirtual 189	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   963: checkcast 107	java/lang/Boolean
            //   966: invokevirtual 203	java/lang/Boolean:booleanValue	()Z
            //   969: istore 4
            //   971: goto -586 -> 385
            //   974: aload_0
            //   975: aload_0
            //   976: invokevirtual 68	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   979: bipush 17
            //   981: aaload
            //   982: invokevirtual 189	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   985: checkcast 70	java/lang/Integer
            //   988: invokevirtual 213	java/lang/Integer:intValue	()I
            //   991: istore_1
            //   992: goto -585 -> 407
            //   995: aload_0
            //   996: aload_0
            //   997: invokevirtual 68	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   1000: bipush 18
            //   1002: aaload
            //   1003: invokevirtual 189	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   1006: checkcast 197	java/util/List
            //   1009: astore 5
            //   1011: goto -582 -> 429
            //   1014: aload_0
            //   1015: aload_0
            //   1016: invokevirtual 68	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   1019: bipush 19
            //   1021: aaload
            //   1022: invokevirtual 189	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   1025: checkcast 107	java/lang/Boolean
            //   1028: invokevirtual 203	java/lang/Boolean:booleanValue	()Z
            //   1031: istore 4
            //   1033: goto -581 -> 452
            //   1036: aload_0
            //   1037: aload_0
            //   1038: invokevirtual 68	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   1041: bipush 20
            //   1043: aaload
            //   1044: invokevirtual 189	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   1047: checkcast 191	java/lang/CharSequence
            //   1050: astore 5
            //   1052: goto -577 -> 475
            //   1055: aload_0
            //   1056: aload_0
            //   1057: invokevirtual 68	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   1060: bipush 21
            //   1062: aaload
            //   1063: invokevirtual 189	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   1066: checkcast 197	java/util/List
            //   1069: astore 5
            //   1071: goto -573 -> 498
            //   1074: aload_0
            //   1075: aload_0
            //   1076: invokevirtual 68	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   1079: bipush 22
            //   1081: aaload
            //   1082: invokevirtual 189	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   1085: checkcast 191	java/lang/CharSequence
            //   1088: astore 5
            //   1090: goto -569 -> 521
            //   1093: aload_0
            //   1094: aload_0
            //   1095: invokevirtual 68	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   1098: bipush 23
            //   1100: aaload
            //   1101: invokevirtual 189	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   1104: checkcast 215	com/flurry/android/impl/ads/avro/protocol/v10/TargetingOverride
            //   1107: astore 5
            //   1109: goto -565 -> 544
            //   1112: aload_0
            //   1113: aload_0
            //   1114: invokevirtual 68	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   1117: bipush 24
            //   1119: aaload
            //   1120: invokevirtual 189	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   1123: checkcast 107	java/lang/Boolean
            //   1126: invokevirtual 203	java/lang/Boolean:booleanValue	()Z
            //   1129: istore 4
            //   1131: goto -564 -> 567
            //   1134: aload_0
            //   1135: aload_0
            //   1136: invokevirtual 68	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   1139: bipush 25
            //   1141: aaload
            //   1142: invokevirtual 189	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   1145: checkcast 197	java/util/List
            //   1148: astore 5
            //   1150: goto -560 -> 590
            //   1153: aload_0
            //   1154: aload_0
            //   1155: invokevirtual 68	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   1158: bipush 26
            //   1160: aaload
            //   1161: invokevirtual 189	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   1164: checkcast 107	java/lang/Boolean
            //   1167: invokevirtual 203	java/lang/Boolean:booleanValue	()Z
            //   1170: istore 4
            //   1172: goto -559 -> 613
            //   1175: aload_0
            //   1176: aload_0
            //   1177: invokevirtual 68	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:b	()[Lcom/flurry/sdk/fn$f;
            //   1180: bipush 27
            //   1182: aaload
            //   1183: invokevirtual 189	com/flurry/android/impl/ads/avro/protocol/v10/AdRequest$Builder:a	(Lcom/flurry/sdk/fn$f;)Ljava/lang/Object;
            //   1186: checkcast 209	java/util/Map
            //   1189: astore 5
            //   1191: goto -555 -> 636
            //   1194: astore 5
            //   1196: new 217	com/flurry/sdk/fk
            //   1199: dup
            //   1200: aload 5
            //   1202: invokespecial 220	com/flurry/sdk/fk:<init>	(Ljava/lang/Throwable;)V
            //   1205: athrow
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	1206	0	this	Builder
            //   406	586	1	i1	int
            //   88	629	2	l1	long
            //   153	1018	4	bool	boolean
            //   22	1168	5	localObject	Object
            //   1194	7	5	localException	Exception
            //   7	637	6	localAdRequest	AdRequest
            // Exception table:
            //   from	to	target	type
            //   0	24	1194	java/lang/Exception
            //   24	46	1194	java/lang/Exception
            //   46	68	1194	java/lang/Exception
            //   68	89	1194	java/lang/Exception
            //   89	110	1194	java/lang/Exception
            //   110	132	1194	java/lang/Exception
            //   132	155	1194	java/lang/Exception
            //   155	178	1194	java/lang/Exception
            //   178	201	1194	java/lang/Exception
            //   201	224	1194	java/lang/Exception
            //   224	247	1194	java/lang/Exception
            //   247	270	1194	java/lang/Exception
            //   270	293	1194	java/lang/Exception
            //   293	316	1194	java/lang/Exception
            //   316	339	1194	java/lang/Exception
            //   339	362	1194	java/lang/Exception
            //   362	385	1194	java/lang/Exception
            //   385	407	1194	java/lang/Exception
            //   407	429	1194	java/lang/Exception
            //   429	452	1194	java/lang/Exception
            //   452	475	1194	java/lang/Exception
            //   475	498	1194	java/lang/Exception
            //   498	521	1194	java/lang/Exception
            //   521	544	1194	java/lang/Exception
            //   544	567	1194	java/lang/Exception
            //   567	590	1194	java/lang/Exception
            //   590	613	1194	java/lang/Exception
            //   613	636	1194	java/lang/Exception
            //   636	643	1194	java/lang/Exception
            //   646	661	1194	java/lang/Exception
            //   664	679	1194	java/lang/Exception
            //   682	697	1194	java/lang/Exception
            //   700	717	1194	java/lang/Exception
            //   720	735	1194	java/lang/Exception
            //   738	753	1194	java/lang/Exception
            //   756	775	1194	java/lang/Exception
            //   778	794	1194	java/lang/Exception
            //   797	813	1194	java/lang/Exception
            //   816	832	1194	java/lang/Exception
            //   835	851	1194	java/lang/Exception
            //   854	870	1194	java/lang/Exception
            //   873	889	1194	java/lang/Exception
            //   892	908	1194	java/lang/Exception
            //   911	927	1194	java/lang/Exception
            //   930	949	1194	java/lang/Exception
            //   952	971	1194	java/lang/Exception
            //   974	992	1194	java/lang/Exception
            //   995	1011	1194	java/lang/Exception
            //   1014	1033	1194	java/lang/Exception
            //   1036	1052	1194	java/lang/Exception
            //   1055	1071	1194	java/lang/Exception
            //   1074	1090	1194	java/lang/Exception
            //   1093	1109	1194	java/lang/Exception
            //   1112	1131	1194	java/lang/Exception
            //   1134	1150	1194	java/lang/Exception
            //   1153	1172	1194	java/lang/Exception
            //   1175	1191	1194	java/lang/Exception
        }

        public Builder b(CharSequence paramCharSequence) {
            a(b()[1], paramCharSequence);
            this.b = paramCharSequence;
            c()[1] = 1;
            return this;
        }

        public Builder b(List<Integer> paramList) {
            a(b()[7], paramList);
            this.h = paramList;
            c()[7] = 1;
            return this;
        }

        public Builder b(boolean paramBoolean) {
            a(b()[16], Boolean.valueOf(paramBoolean));
            this.q = paramBoolean;
            c()[16] = 1;
            return this;
        }

        public Builder c(CharSequence paramCharSequence) {
            a(b()[2], paramCharSequence);
            this.c = paramCharSequence;
            c()[2] = 1;
            return this;
        }

        public Builder c(List<FrequencyCapInfo> paramList) {
            a(b()[18], paramList);
            this.s = paramList;
            c()[18] = 1;
            return this;
        }

        public Builder c(boolean paramBoolean) {
            a(b()[19], Boolean.valueOf(paramBoolean));
            this.t = paramBoolean;
            c()[19] = 1;
            return this;
        }

        public Builder d(CharSequence paramCharSequence) {
            a(b()[9], paramCharSequence);
            this.j = paramCharSequence;
            c()[9] = 1;
            return this;
        }

        public Builder d(List<CharSequence> paramList) {
            a(b()[21], paramList);
            this.v = paramList;
            c()[21] = 1;
            return this;
        }

        public Builder d(boolean paramBoolean) {
            a(b()[24], Boolean.valueOf(paramBoolean));
            this.y = paramBoolean;
            c()[24] = 1;
            return this;
        }

        public Builder e(CharSequence paramCharSequence) {
            a(b()[10], paramCharSequence);
            this.k = paramCharSequence;
            c()[10] = 1;
            return this;
        }

        public Builder e(List<CharSequence> paramList) {
            a(b()[25], paramList);
            this.z = paramList;
            c()[25] = 1;
            return this;
        }

        public Builder e(boolean paramBoolean) {
            a(b()[26], Boolean.valueOf(paramBoolean));
            this.A = paramBoolean;
            c()[26] = 1;
            return this;
        }

        public Builder f(CharSequence paramCharSequence) {
            a(b()[11], paramCharSequence);
            this.l = paramCharSequence;
            c()[11] = 1;
            return this;
        }

        public Builder g(CharSequence paramCharSequence) {
            a(b()[12], paramCharSequence);
            this.m = paramCharSequence;
            c()[12] = 1;
            return this;
        }

        public Builder h(CharSequence paramCharSequence) {
            a(b()[20], paramCharSequence);
            this.u = paramCharSequence;
            c()[20] = 1;
            return this;
        }

        public Builder i(CharSequence paramCharSequence) {
            a(b()[22], paramCharSequence);
            this.w = paramCharSequence;
            c()[22] = 1;
            return this;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/android/impl/ads/avro/protocol/v10/AdRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */