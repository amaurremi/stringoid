package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.b.a.a.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class fq
  extends dw
  implements a, SafeParcelable
{
  public static final bx CREATOR = new bx();
  private static final HashMap a = new HashMap();
  private String A;
  private String B;
  private String C;
  private String D;
  private fq E;
  private String F;
  private String G;
  private String H;
  private String I;
  private fq J;
  private double K;
  private fq L;
  private double M;
  private String N;
  private fq O;
  private List P;
  private String Q;
  private String R;
  private String S;
  private String T;
  private fq U;
  private String V;
  private String W;
  private String X;
  private fq Y;
  private String Z;
  private String aa;
  private String ab;
  private String ac;
  private String ad;
  private String ae;
  private final Set b;
  private final int c;
  private fq d;
  private List e;
  private fq f;
  private String g;
  private String h;
  private String i;
  private List j;
  private int k;
  private List l;
  private fq m;
  private List n;
  private String o;
  private String p;
  private fq q;
  private String r;
  private String s;
  private String t;
  private List u;
  private String v;
  private String w;
  private String x;
  private String y;
  private String z;
  
  static
  {
    a.put("about", dw.a.a("about", 2, fq.class));
    a.put("additionalName", dw.a.e("additionalName", 3));
    a.put("address", dw.a.a("address", 4, fq.class));
    a.put("addressCountry", dw.a.d("addressCountry", 5));
    a.put("addressLocality", dw.a.d("addressLocality", 6));
    a.put("addressRegion", dw.a.d("addressRegion", 7));
    a.put("associated_media", dw.a.b("associated_media", 8, fq.class));
    a.put("attendeeCount", dw.a.a("attendeeCount", 9));
    a.put("attendees", dw.a.b("attendees", 10, fq.class));
    a.put("audio", dw.a.a("audio", 11, fq.class));
    a.put("author", dw.a.b("author", 12, fq.class));
    a.put("bestRating", dw.a.d("bestRating", 13));
    a.put("birthDate", dw.a.d("birthDate", 14));
    a.put("byArtist", dw.a.a("byArtist", 15, fq.class));
    a.put("caption", dw.a.d("caption", 16));
    a.put("contentSize", dw.a.d("contentSize", 17));
    a.put("contentUrl", dw.a.d("contentUrl", 18));
    a.put("contributor", dw.a.b("contributor", 19, fq.class));
    a.put("dateCreated", dw.a.d("dateCreated", 20));
    a.put("dateModified", dw.a.d("dateModified", 21));
    a.put("datePublished", dw.a.d("datePublished", 22));
    a.put("description", dw.a.d("description", 23));
    a.put("duration", dw.a.d("duration", 24));
    a.put("embedUrl", dw.a.d("embedUrl", 25));
    a.put("endDate", dw.a.d("endDate", 26));
    a.put("familyName", dw.a.d("familyName", 27));
    a.put("gender", dw.a.d("gender", 28));
    a.put("geo", dw.a.a("geo", 29, fq.class));
    a.put("givenName", dw.a.d("givenName", 30));
    a.put("height", dw.a.d("height", 31));
    a.put("id", dw.a.d("id", 32));
    a.put("image", dw.a.d("image", 33));
    a.put("inAlbum", dw.a.a("inAlbum", 34, fq.class));
    a.put("latitude", dw.a.b("latitude", 36));
    a.put("location", dw.a.a("location", 37, fq.class));
    a.put("longitude", dw.a.b("longitude", 38));
    a.put("name", dw.a.d("name", 39));
    a.put("partOfTVSeries", dw.a.a("partOfTVSeries", 40, fq.class));
    a.put("performers", dw.a.b("performers", 41, fq.class));
    a.put("playerType", dw.a.d("playerType", 42));
    a.put("postOfficeBoxNumber", dw.a.d("postOfficeBoxNumber", 43));
    a.put("postalCode", dw.a.d("postalCode", 44));
    a.put("ratingValue", dw.a.d("ratingValue", 45));
    a.put("reviewRating", dw.a.a("reviewRating", 46, fq.class));
    a.put("startDate", dw.a.d("startDate", 47));
    a.put("streetAddress", dw.a.d("streetAddress", 48));
    a.put("text", dw.a.d("text", 49));
    a.put("thumbnail", dw.a.a("thumbnail", 50, fq.class));
    a.put("thumbnailUrl", dw.a.d("thumbnailUrl", 51));
    a.put("tickerSymbol", dw.a.d("tickerSymbol", 52));
    a.put("type", dw.a.d("type", 53));
    a.put("url", dw.a.d("url", 54));
    a.put("width", dw.a.d("width", 55));
    a.put("worstRating", dw.a.d("worstRating", 56));
  }
  
  public fq()
  {
    this.c = 1;
    this.b = new HashSet();
  }
  
  fq(Set paramSet, int paramInt1, fq paramfq1, List paramList1, fq paramfq2, String paramString1, String paramString2, String paramString3, List paramList2, int paramInt2, List paramList3, fq paramfq3, List paramList4, String paramString4, String paramString5, fq paramfq4, String paramString6, String paramString7, String paramString8, List paramList5, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, fq paramfq5, String paramString18, String paramString19, String paramString20, String paramString21, fq paramfq6, double paramDouble1, fq paramfq7, double paramDouble2, String paramString22, fq paramfq8, List paramList6, String paramString23, String paramString24, String paramString25, String paramString26, fq paramfq9, String paramString27, String paramString28, String paramString29, fq paramfq10, String paramString30, String paramString31, String paramString32, String paramString33, String paramString34, String paramString35)
  {
    this.b = paramSet;
    this.c = paramInt1;
    this.d = paramfq1;
    this.e = paramList1;
    this.f = paramfq2;
    this.g = paramString1;
    this.h = paramString2;
    this.i = paramString3;
    this.j = paramList2;
    this.k = paramInt2;
    this.l = paramList3;
    this.m = paramfq3;
    this.n = paramList4;
    this.o = paramString4;
    this.p = paramString5;
    this.q = paramfq4;
    this.r = paramString6;
    this.s = paramString7;
    this.t = paramString8;
    this.u = paramList5;
    this.v = paramString9;
    this.w = paramString10;
    this.x = paramString11;
    this.y = paramString12;
    this.z = paramString13;
    this.A = paramString14;
    this.B = paramString15;
    this.C = paramString16;
    this.D = paramString17;
    this.E = paramfq5;
    this.F = paramString18;
    this.G = paramString19;
    this.H = paramString20;
    this.I = paramString21;
    this.J = paramfq6;
    this.K = paramDouble1;
    this.L = paramfq7;
    this.M = paramDouble2;
    this.N = paramString22;
    this.O = paramfq8;
    this.P = paramList6;
    this.Q = paramString23;
    this.R = paramString24;
    this.S = paramString25;
    this.T = paramString26;
    this.U = paramfq9;
    this.V = paramString27;
    this.W = paramString28;
    this.X = paramString29;
    this.Y = paramfq10;
    this.Z = paramString30;
    this.aa = paramString31;
    this.ab = paramString32;
    this.ac = paramString33;
    this.ad = paramString34;
    this.ae = paramString35;
  }
  
  public String A()
  {
    return this.x;
  }
  
  public String B()
  {
    return this.y;
  }
  
  public String C()
  {
    return this.z;
  }
  
  public String D()
  {
    return this.A;
  }
  
  public String E()
  {
    return this.B;
  }
  
  public String F()
  {
    return this.C;
  }
  
  public String G()
  {
    return this.D;
  }
  
  fq H()
  {
    return this.E;
  }
  
  public String I()
  {
    return this.F;
  }
  
  public String J()
  {
    return this.G;
  }
  
  public String K()
  {
    return this.H;
  }
  
  public String L()
  {
    return this.I;
  }
  
  fq M()
  {
    return this.J;
  }
  
  public double N()
  {
    return this.K;
  }
  
  fq O()
  {
    return this.L;
  }
  
  public double P()
  {
    return this.M;
  }
  
  public String Q()
  {
    return this.N;
  }
  
  fq R()
  {
    return this.O;
  }
  
  List S()
  {
    return this.P;
  }
  
  public String T()
  {
    return this.Q;
  }
  
  public String U()
  {
    return this.R;
  }
  
  public String V()
  {
    return this.S;
  }
  
  public String W()
  {
    return this.T;
  }
  
  fq X()
  {
    return this.U;
  }
  
  public String Y()
  {
    return this.V;
  }
  
  public String Z()
  {
    return this.W;
  }
  
  protected Object a(String paramString)
  {
    return null;
  }
  
  protected boolean a(dw.a parama)
  {
    return this.b.contains(Integer.valueOf(parama.g()));
  }
  
  public String aa()
  {
    return this.X;
  }
  
  fq ab()
  {
    return this.Y;
  }
  
  public String ac()
  {
    return this.Z;
  }
  
  public String ad()
  {
    return this.aa;
  }
  
  public String ae()
  {
    return this.ab;
  }
  
  public String af()
  {
    return this.ac;
  }
  
  public String ag()
  {
    return this.ad;
  }
  
  public String ah()
  {
    return this.ae;
  }
  
  public fq ai()
  {
    return this;
  }
  
  protected Object b(dw.a parama)
  {
    switch (parama.g())
    {
    case 35: 
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + parama.g());
    case 2: 
      return this.d;
    case 3: 
      return this.e;
    case 4: 
      return this.f;
    case 5: 
      return this.g;
    case 6: 
      return this.h;
    case 7: 
      return this.i;
    case 8: 
      return this.j;
    case 9: 
      return Integer.valueOf(this.k);
    case 10: 
      return this.l;
    case 11: 
      return this.m;
    case 12: 
      return this.n;
    case 13: 
      return this.o;
    case 14: 
      return this.p;
    case 15: 
      return this.q;
    case 16: 
      return this.r;
    case 17: 
      return this.s;
    case 18: 
      return this.t;
    case 19: 
      return this.u;
    case 20: 
      return this.v;
    case 21: 
      return this.w;
    case 22: 
      return this.x;
    case 23: 
      return this.y;
    case 24: 
      return this.z;
    case 25: 
      return this.A;
    case 26: 
      return this.B;
    case 27: 
      return this.C;
    case 28: 
      return this.D;
    case 29: 
      return this.E;
    case 30: 
      return this.F;
    case 31: 
      return this.G;
    case 32: 
      return this.H;
    case 33: 
      return this.I;
    case 34: 
      return this.J;
    case 36: 
      return Double.valueOf(this.K);
    case 37: 
      return this.L;
    case 38: 
      return Double.valueOf(this.M);
    case 39: 
      return this.N;
    case 40: 
      return this.O;
    case 41: 
      return this.P;
    case 42: 
      return this.Q;
    case 43: 
      return this.R;
    case 44: 
      return this.S;
    case 45: 
      return this.T;
    case 46: 
      return this.U;
    case 47: 
      return this.V;
    case 48: 
      return this.W;
    case 49: 
      return this.X;
    case 50: 
      return this.Y;
    case 51: 
      return this.Z;
    case 52: 
      return this.aa;
    case 53: 
      return this.ab;
    case 54: 
      return this.ac;
    case 55: 
      return this.ad;
    }
    return this.ae;
  }
  
  public HashMap b()
  {
    return a;
  }
  
  protected boolean b(String paramString)
  {
    return false;
  }
  
  public int describeContents()
  {
    bx localbx = CREATOR;
    return 0;
  }
  
  Set e()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof fq)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (fq)paramObject;
    Iterator localIterator = a.values().iterator();
    while (localIterator.hasNext())
    {
      dw.a locala = (dw.a)localIterator.next();
      if (a(locala))
      {
        if (((fq)paramObject).a(locala))
        {
          if (!b(locala).equals(((fq)paramObject).b(locala))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((fq)paramObject).a(locala)) {
        return false;
      }
    }
    return true;
  }
  
  int f()
  {
    return this.c;
  }
  
  fq g()
  {
    return this.d;
  }
  
  public List h()
  {
    return this.e;
  }
  
  public int hashCode()
  {
    Iterator localIterator = a.values().iterator();
    int i1 = 0;
    if (localIterator.hasNext())
    {
      dw.a locala = (dw.a)localIterator.next();
      if (!a(locala)) {
        break label68;
      }
      int i2 = locala.g();
      i1 = b(locala).hashCode() + (i1 + i2);
    }
    label68:
    for (;;)
    {
      break;
      return i1;
    }
  }
  
  fq i()
  {
    return this.f;
  }
  
  public String j()
  {
    return this.g;
  }
  
  public String k()
  {
    return this.h;
  }
  
  public String l()
  {
    return this.i;
  }
  
  List m()
  {
    return this.j;
  }
  
  public int n()
  {
    return this.k;
  }
  
  List o()
  {
    return this.l;
  }
  
  fq p()
  {
    return this.m;
  }
  
  List q()
  {
    return this.n;
  }
  
  public String r()
  {
    return this.o;
  }
  
  public String s()
  {
    return this.p;
  }
  
  fq t()
  {
    return this.q;
  }
  
  public String u()
  {
    return this.r;
  }
  
  public String v()
  {
    return this.s;
  }
  
  public String w()
  {
    return this.t;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    bx localbx = CREATOR;
    bx.a(this, paramParcel, paramInt);
  }
  
  List x()
  {
    return this.u;
  }
  
  public String y()
  {
    return this.v;
  }
  
  public String z()
  {
    return this.w;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/fq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */