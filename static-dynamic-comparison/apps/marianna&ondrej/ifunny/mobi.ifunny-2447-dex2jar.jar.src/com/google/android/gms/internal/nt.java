package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.plus.a.a.a;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class nt
        extends jj
        implements a {
    public static final ru CREATOR = new ru();
    private static final HashMap<String, ji.a<?, ?>> ae = new HashMap();
    String A;
    String B;
    String C;
    nt D;
    String E;
    String F;
    String G;
    String H;
    nt I;
    double J;
    nt K;
    double L;
    String M;
    nt N;
    List<nt> O;
    String P;
    String Q;
    String R;
    String S;
    nt T;
    String U;
    String V;
    String W;
    nt X;
    String Y;
    String Z;
    final Set<Integer> a;
    String aa;
    String ab;
    String ac;
    String ad;
    final int b;
    nt c;
    List<String> d;
    nt e;
    String f;
    String g;
    String h;
    List<nt> i;
    int j;
    List<nt> k;
    nt l;
    List<nt> m;
    String n;
    String o;
    nt p;
    String q;
    String r;
    String s;
    List<nt> t;
    String u;
    String v;
    String w;
    String x;
    String y;
    String z;

    static {
        ae.put("about", ji.a.a("about", 2, nt.class));
        ae.put("additionalName", ji.a.e("additionalName", 3));
        ae.put("address", ji.a.a("address", 4, nt.class));
        ae.put("addressCountry", ji.a.d("addressCountry", 5));
        ae.put("addressLocality", ji.a.d("addressLocality", 6));
        ae.put("addressRegion", ji.a.d("addressRegion", 7));
        ae.put("associated_media", ji.a.b("associated_media", 8, nt.class));
        ae.put("attendeeCount", ji.a.a("attendeeCount", 9));
        ae.put("attendees", ji.a.b("attendees", 10, nt.class));
        ae.put("audio", ji.a.a("audio", 11, nt.class));
        ae.put("author", ji.a.b("author", 12, nt.class));
        ae.put("bestRating", ji.a.d("bestRating", 13));
        ae.put("birthDate", ji.a.d("birthDate", 14));
        ae.put("byArtist", ji.a.a("byArtist", 15, nt.class));
        ae.put("caption", ji.a.d("caption", 16));
        ae.put("contentSize", ji.a.d("contentSize", 17));
        ae.put("contentUrl", ji.a.d("contentUrl", 18));
        ae.put("contributor", ji.a.b("contributor", 19, nt.class));
        ae.put("dateCreated", ji.a.d("dateCreated", 20));
        ae.put("dateModified", ji.a.d("dateModified", 21));
        ae.put("datePublished", ji.a.d("datePublished", 22));
        ae.put("description", ji.a.d("description", 23));
        ae.put("duration", ji.a.d("duration", 24));
        ae.put("embedUrl", ji.a.d("embedUrl", 25));
        ae.put("endDate", ji.a.d("endDate", 26));
        ae.put("familyName", ji.a.d("familyName", 27));
        ae.put("gender", ji.a.d("gender", 28));
        ae.put("geo", ji.a.a("geo", 29, nt.class));
        ae.put("givenName", ji.a.d("givenName", 30));
        ae.put("height", ji.a.d("height", 31));
        ae.put("id", ji.a.d("id", 32));
        ae.put("image", ji.a.d("image", 33));
        ae.put("inAlbum", ji.a.a("inAlbum", 34, nt.class));
        ae.put("latitude", ji.a.b("latitude", 36));
        ae.put("location", ji.a.a("location", 37, nt.class));
        ae.put("longitude", ji.a.b("longitude", 38));
        ae.put("name", ji.a.d("name", 39));
        ae.put("partOfTVSeries", ji.a.a("partOfTVSeries", 40, nt.class));
        ae.put("performers", ji.a.b("performers", 41, nt.class));
        ae.put("playerType", ji.a.d("playerType", 42));
        ae.put("postOfficeBoxNumber", ji.a.d("postOfficeBoxNumber", 43));
        ae.put("postalCode", ji.a.d("postalCode", 44));
        ae.put("ratingValue", ji.a.d("ratingValue", 45));
        ae.put("reviewRating", ji.a.a("reviewRating", 46, nt.class));
        ae.put("startDate", ji.a.d("startDate", 47));
        ae.put("streetAddress", ji.a.d("streetAddress", 48));
        ae.put("text", ji.a.d("text", 49));
        ae.put("thumbnail", ji.a.a("thumbnail", 50, nt.class));
        ae.put("thumbnailUrl", ji.a.d("thumbnailUrl", 51));
        ae.put("tickerSymbol", ji.a.d("tickerSymbol", 52));
        ae.put("type", ji.a.d("type", 53));
        ae.put("url", ji.a.d("url", 54));
        ae.put("width", ji.a.d("width", 55));
        ae.put("worstRating", ji.a.d("worstRating", 56));
    }

    public nt() {
        this.b = 1;
        this.a = new HashSet();
    }

    nt(Set<Integer> paramSet, int paramInt1, nt paramnt1, List<String> paramList, nt paramnt2, String paramString1, String paramString2, String paramString3, List<nt> paramList1, int paramInt2, List<nt> paramList2, nt paramnt3, List<nt> paramList3, String paramString4, String paramString5, nt paramnt4, String paramString6, String paramString7, String paramString8, List<nt> paramList4, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, nt paramnt5, String paramString18, String paramString19, String paramString20, String paramString21, nt paramnt6, double paramDouble1, nt paramnt7, double paramDouble2, String paramString22, nt paramnt8, List<nt> paramList5, String paramString23, String paramString24, String paramString25, String paramString26, nt paramnt9, String paramString27, String paramString28, String paramString29, nt paramnt10, String paramString30, String paramString31, String paramString32, String paramString33, String paramString34, String paramString35) {
        this.a = paramSet;
        this.b = paramInt1;
        this.c = paramnt1;
        this.d = paramList;
        this.e = paramnt2;
        this.f = paramString1;
        this.g = paramString2;
        this.h = paramString3;
        this.i = paramList1;
        this.j = paramInt2;
        this.k = paramList2;
        this.l = paramnt3;
        this.m = paramList3;
        this.n = paramString4;
        this.o = paramString5;
        this.p = paramnt4;
        this.q = paramString6;
        this.r = paramString7;
        this.s = paramString8;
        this.t = paramList4;
        this.u = paramString9;
        this.v = paramString10;
        this.w = paramString11;
        this.x = paramString12;
        this.y = paramString13;
        this.z = paramString14;
        this.A = paramString15;
        this.B = paramString16;
        this.C = paramString17;
        this.D = paramnt5;
        this.E = paramString18;
        this.F = paramString19;
        this.G = paramString20;
        this.H = paramString21;
        this.I = paramnt6;
        this.J = paramDouble1;
        this.K = paramnt7;
        this.L = paramDouble2;
        this.M = paramString22;
        this.N = paramnt8;
        this.O = paramList5;
        this.P = paramString23;
        this.Q = paramString24;
        this.R = paramString25;
        this.S = paramString26;
        this.T = paramnt9;
        this.U = paramString27;
        this.V = paramString28;
        this.W = paramString29;
        this.X = paramnt10;
        this.Y = paramString30;
        this.Z = paramString31;
        this.aa = paramString32;
        this.ab = paramString33;
        this.ac = paramString34;
        this.ad = paramString35;
    }

    protected boolean a(ji.a parama) {
        return this.a.contains(Integer.valueOf(parama.g()));
    }

    protected Object b(ji.a parama) {
        switch (parama.g()) {
            case 35:
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + parama.g());
            case 2:
                return this.c;
            case 3:
                return this.d;
            case 4:
                return this.e;
            case 5:
                return this.f;
            case 6:
                return this.g;
            case 7:
                return this.h;
            case 8:
                return this.i;
            case 9:
                return Integer.valueOf(this.j);
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
                return this.p;
            case 16:
                return this.q;
            case 17:
                return this.r;
            case 18:
                return this.s;
            case 19:
                return this.t;
            case 20:
                return this.u;
            case 21:
                return this.v;
            case 22:
                return this.w;
            case 23:
                return this.x;
            case 24:
                return this.y;
            case 25:
                return this.z;
            case 26:
                return this.A;
            case 27:
                return this.B;
            case 28:
                return this.C;
            case 29:
                return this.D;
            case 30:
                return this.E;
            case 31:
                return this.F;
            case 32:
                return this.G;
            case 33:
                return this.H;
            case 34:
                return this.I;
            case 36:
                return Double.valueOf(this.J);
            case 37:
                return this.K;
            case 38:
                return Double.valueOf(this.L);
            case 39:
                return this.M;
            case 40:
                return this.N;
            case 41:
                return this.O;
            case 42:
                return this.P;
            case 43:
                return this.Q;
            case 44:
                return this.R;
            case 45:
                return this.S;
            case 46:
                return this.T;
            case 47:
                return this.U;
            case 48:
                return this.V;
            case 49:
                return this.W;
            case 50:
                return this.X;
            case 51:
                return this.Y;
            case 52:
                return this.Z;
            case 53:
                return this.aa;
            case 54:
                return this.ab;
            case 55:
                return this.ac;
        }
        return this.ad;
    }

    public HashMap<String, ji.a<?, ?>> b() {
        return ae;
    }

    public int describeContents() {
        ru localru = CREATOR;
        return 0;
    }

    public nt e() {
        return this;
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof nt)) {
            return false;
        }
        if (this == paramObject) {
            return true;
        }
        paramObject = (nt) paramObject;
        Iterator localIterator = ae.values().iterator();
        while (localIterator.hasNext()) {
            ji.a locala = (ji.a) localIterator.next();
            if (a(locala)) {
                if (((nt) paramObject).a(locala)) {
                    if (!b(locala).equals(((nt) paramObject).b(locala))) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (((nt) paramObject).a(locala)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Iterator localIterator = ae.values().iterator();
        int i1 = 0;
        if (localIterator.hasNext()) {
            ji.a locala = (ji.a) localIterator.next();
            if (!a(locala)) {
                break label68;
            }
            int i2 = locala.g();
            i1 = b(locala).hashCode() + (i1 + i2);
        }
        label68:
        for (; ; ) {
            break;
            return i1;
        }
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ru localru = CREATOR;
        ru.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/nt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */