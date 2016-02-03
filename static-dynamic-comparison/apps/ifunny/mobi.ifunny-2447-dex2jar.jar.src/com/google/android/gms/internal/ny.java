package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.plus.a.b.a;
import com.google.android.gms.plus.a.b.f;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class ny
        extends jj
        implements a {
    private static final HashMap<String, ji.a<?, ?>> A;
    public static final rw CREATOR = new rw();
    final Set<Integer> a;
    final int b;
    String c;
    ny.a d;
    String e;
    String f;
    int g;
    ny.b h;
    String i;
    String j;
    int k;
    String l;
    ny.c m;
    boolean n;
    String o;
    ny.d p;
    String q;
    int r;
    List<ny.f> s;
    List<ny.g> t;
    int u;
    int v;
    String w;
    String x;
    List<ny.h> y;
    boolean z;

    static {
        A = new HashMap();
        A.put("aboutMe", ji.a.d("aboutMe", 2));
        A.put("ageRange", ji.a.a("ageRange", 3, ny.a.class));
        A.put("birthday", ji.a.d("birthday", 4));
        A.put("braggingRights", ji.a.d("braggingRights", 5));
        A.put("circledByCount", ji.a.a("circledByCount", 6));
        A.put("cover", ji.a.a("cover", 7, ny.b.class));
        A.put("currentLocation", ji.a.d("currentLocation", 8));
        A.put("displayName", ji.a.d("displayName", 9));
        A.put("gender", ji.a.a("gender", 12, new jf().a("male", 0).a("female", 1).a("other", 2), false));
        A.put("id", ji.a.d("id", 14));
        A.put("image", ji.a.a("image", 15, ny.c.class));
        A.put("isPlusUser", ji.a.c("isPlusUser", 16));
        A.put("language", ji.a.d("language", 18));
        A.put("name", ji.a.a("name", 19, ny.d.class));
        A.put("nickname", ji.a.d("nickname", 20));
        A.put("objectType", ji.a.a("objectType", 21, new jf().a("person", 0).a("page", 1), false));
        A.put("organizations", ji.a.b("organizations", 22, ny.f.class));
        A.put("placesLived", ji.a.b("placesLived", 23, ny.g.class));
        A.put("plusOneCount", ji.a.a("plusOneCount", 24));
        A.put("relationshipStatus", ji.a.a("relationshipStatus", 25, new jf().a("single", 0).a("in_a_relationship", 1).a("engaged", 2).a("married", 3).a("its_complicated", 4).a("open_relationship", 5).a("widowed", 6).a("in_domestic_partnership", 7).a("in_civil_union", 8), false));
        A.put("tagline", ji.a.d("tagline", 26));
        A.put("url", ji.a.d("url", 27));
        A.put("urls", ji.a.b("urls", 28, ny.h.class));
        A.put("verified", ji.a.c("verified", 29));
    }

    public ny() {
        this.b = 1;
        this.a = new HashSet();
    }

    ny(Set<Integer> paramSet, int paramInt1, String paramString1, ny.a parama, String paramString2, String paramString3, int paramInt2, ny.b paramb, String paramString4, String paramString5, int paramInt3, String paramString6, ny.c paramc, boolean paramBoolean1, String paramString7, ny.d paramd, String paramString8, int paramInt4, List<ny.f> paramList, List<ny.g> paramList1, int paramInt5, int paramInt6, String paramString9, String paramString10, List<ny.h> paramList2, boolean paramBoolean2) {
        this.a = paramSet;
        this.b = paramInt1;
        this.c = paramString1;
        this.d = parama;
        this.e = paramString2;
        this.f = paramString3;
        this.g = paramInt2;
        this.h = paramb;
        this.i = paramString4;
        this.j = paramString5;
        this.k = paramInt3;
        this.l = paramString6;
        this.m = paramc;
        this.n = paramBoolean1;
        this.o = paramString7;
        this.p = paramd;
        this.q = paramString8;
        this.r = paramInt4;
        this.s = paramList;
        this.t = paramList1;
        this.u = paramInt5;
        this.v = paramInt6;
        this.w = paramString9;
        this.x = paramString10;
        this.y = paramList2;
        this.z = paramBoolean2;
    }

    public static ny a(byte[] paramArrayOfByte) {
        Parcel localParcel = Parcel.obtain();
        localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
        localParcel.setDataPosition(0);
        paramArrayOfByte = CREATOR.a(localParcel);
        localParcel.recycle();
        return paramArrayOfByte;
    }

    protected boolean a(ji.a parama) {
        return this.a.contains(Integer.valueOf(parama.g()));
    }

    protected Object b(ji.a parama) {
        switch (parama.g()) {
            case 10:
            case 11:
            case 13:
            case 17:
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
                return Integer.valueOf(this.g);
            case 7:
                return this.h;
            case 8:
                return this.i;
            case 9:
                return this.j;
            case 12:
                return Integer.valueOf(this.k);
            case 14:
                return this.l;
            case 15:
                return this.m;
            case 16:
                return Boolean.valueOf(this.n);
            case 18:
                return this.o;
            case 19:
                return this.p;
            case 20:
                return this.q;
            case 21:
                return Integer.valueOf(this.r);
            case 22:
                return this.s;
            case 23:
                return this.t;
            case 24:
                return Integer.valueOf(this.u);
            case 25:
                return Integer.valueOf(this.v);
            case 26:
                return this.w;
            case 27:
                return this.x;
            case 28:
                return this.y;
        }
        return Boolean.valueOf(this.z);
    }

    public HashMap<String, ji.a<?, ?>> b() {
        return A;
    }

    public int describeContents() {
        rw localrw = CREATOR;
        return 0;
    }

    public String e() {
        return this.j;
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof ny)) {
            return false;
        }
        if (this == paramObject) {
            return true;
        }
        paramObject = (ny) paramObject;
        Iterator localIterator = A.values().iterator();
        while (localIterator.hasNext()) {
            ji.a locala = (ji.a) localIterator.next();
            if (a(locala)) {
                if (((ny) paramObject).a(locala)) {
                    if (!b(locala).equals(((ny) paramObject).b(locala))) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (((ny) paramObject).a(locala)) {
                return false;
            }
        }
        return true;
    }

    public String f() {
        return this.l;
    }

    public f g() {
        return this.m;
    }

    public ny h() {
        return this;
    }

    public int hashCode() {
        Iterator localIterator = A.values().iterator();
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
        rw localrw = CREATOR;
        rw.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ny.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */