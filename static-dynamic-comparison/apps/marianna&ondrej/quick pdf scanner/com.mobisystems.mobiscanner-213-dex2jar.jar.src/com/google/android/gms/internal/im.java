package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.a.a.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class im
  extends fb
  implements SafeParcelable, a
{
  public static final fk Qw = new fk();
  private static final HashMap<String, fb.a<?, ?>> Qx = new HashMap();
  private String Fv;
  private String Gi;
  private double MU;
  private double MV;
  private String PI;
  private List<String> QA;
  private im QB;
  private String QC;
  private String QD;
  private String QE;
  private List<im> QF;
  private int QG;
  private List<im> QH;
  private im QI;
  private List<im> QJ;
  private String QK;
  private String QL;
  private im QM;
  private String QN;
  private String QO;
  private List<im> QP;
  private String QQ;
  private String QS;
  private String QT;
  private String QU;
  private String QV;
  private String QW;
  private String QX;
  private String QY;
  private im QZ;
  private final Set<Integer> Qy;
  private im Qz;
  private String Ra;
  private String Rb;
  private String Rc;
  private im Rd;
  private im Re;
  private im Rf;
  private List<im> Rg;
  private String Rh;
  private String Ri;
  private String Rj;
  private String Rk;
  private im Rl;
  private String Rm;
  private String Rn;
  private String Ro;
  private im Rp;
  private String Rq;
  private String Rr;
  private String Rs;
  private String Rt;
  private String mName;
  private final int qh;
  private String vf;
  private String xf;
  
  static
  {
    Qx.put("about", fb.a.a("about", 2, im.class));
    Qx.put("additionalName", fb.a.i("additionalName", 3));
    Qx.put("address", fb.a.a("address", 4, im.class));
    Qx.put("addressCountry", fb.a.h("addressCountry", 5));
    Qx.put("addressLocality", fb.a.h("addressLocality", 6));
    Qx.put("addressRegion", fb.a.h("addressRegion", 7));
    Qx.put("associated_media", fb.a.b("associated_media", 8, im.class));
    Qx.put("attendeeCount", fb.a.e("attendeeCount", 9));
    Qx.put("attendees", fb.a.b("attendees", 10, im.class));
    Qx.put("audio", fb.a.a("audio", 11, im.class));
    Qx.put("author", fb.a.b("author", 12, im.class));
    Qx.put("bestRating", fb.a.h("bestRating", 13));
    Qx.put("birthDate", fb.a.h("birthDate", 14));
    Qx.put("byArtist", fb.a.a("byArtist", 15, im.class));
    Qx.put("caption", fb.a.h("caption", 16));
    Qx.put("contentSize", fb.a.h("contentSize", 17));
    Qx.put("contentUrl", fb.a.h("contentUrl", 18));
    Qx.put("contributor", fb.a.b("contributor", 19, im.class));
    Qx.put("dateCreated", fb.a.h("dateCreated", 20));
    Qx.put("dateModified", fb.a.h("dateModified", 21));
    Qx.put("datePublished", fb.a.h("datePublished", 22));
    Qx.put("description", fb.a.h("description", 23));
    Qx.put("duration", fb.a.h("duration", 24));
    Qx.put("embedUrl", fb.a.h("embedUrl", 25));
    Qx.put("endDate", fb.a.h("endDate", 26));
    Qx.put("familyName", fb.a.h("familyName", 27));
    Qx.put("gender", fb.a.h("gender", 28));
    Qx.put("geo", fb.a.a("geo", 29, im.class));
    Qx.put("givenName", fb.a.h("givenName", 30));
    Qx.put("height", fb.a.h("height", 31));
    Qx.put("id", fb.a.h("id", 32));
    Qx.put("image", fb.a.h("image", 33));
    Qx.put("inAlbum", fb.a.a("inAlbum", 34, im.class));
    Qx.put("latitude", fb.a.f("latitude", 36));
    Qx.put("location", fb.a.a("location", 37, im.class));
    Qx.put("longitude", fb.a.f("longitude", 38));
    Qx.put("name", fb.a.h("name", 39));
    Qx.put("partOfTVSeries", fb.a.a("partOfTVSeries", 40, im.class));
    Qx.put("performers", fb.a.b("performers", 41, im.class));
    Qx.put("playerType", fb.a.h("playerType", 42));
    Qx.put("postOfficeBoxNumber", fb.a.h("postOfficeBoxNumber", 43));
    Qx.put("postalCode", fb.a.h("postalCode", 44));
    Qx.put("ratingValue", fb.a.h("ratingValue", 45));
    Qx.put("reviewRating", fb.a.a("reviewRating", 46, im.class));
    Qx.put("startDate", fb.a.h("startDate", 47));
    Qx.put("streetAddress", fb.a.h("streetAddress", 48));
    Qx.put("text", fb.a.h("text", 49));
    Qx.put("thumbnail", fb.a.a("thumbnail", 50, im.class));
    Qx.put("thumbnailUrl", fb.a.h("thumbnailUrl", 51));
    Qx.put("tickerSymbol", fb.a.h("tickerSymbol", 52));
    Qx.put("type", fb.a.h("type", 53));
    Qx.put("url", fb.a.h("url", 54));
    Qx.put("width", fb.a.h("width", 55));
    Qx.put("worstRating", fb.a.h("worstRating", 56));
  }
  
  public im()
  {
    this.qh = 1;
    this.Qy = new HashSet();
  }
  
  im(Set<Integer> paramSet, int paramInt1, im paramim1, List<String> paramList, im paramim2, String paramString1, String paramString2, String paramString3, List<im> paramList1, int paramInt2, List<im> paramList2, im paramim3, List<im> paramList3, String paramString4, String paramString5, im paramim4, String paramString6, String paramString7, String paramString8, List<im> paramList4, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, im paramim5, String paramString18, String paramString19, String paramString20, String paramString21, im paramim6, double paramDouble1, im paramim7, double paramDouble2, String paramString22, im paramim8, List<im> paramList5, String paramString23, String paramString24, String paramString25, String paramString26, im paramim9, String paramString27, String paramString28, String paramString29, im paramim10, String paramString30, String paramString31, String paramString32, String paramString33, String paramString34, String paramString35)
  {
    this.Qy = paramSet;
    this.qh = paramInt1;
    this.Qz = paramim1;
    this.QA = paramList;
    this.QB = paramim2;
    this.QC = paramString1;
    this.QD = paramString2;
    this.QE = paramString3;
    this.QF = paramList1;
    this.QG = paramInt2;
    this.QH = paramList2;
    this.QI = paramim3;
    this.QJ = paramList3;
    this.QK = paramString4;
    this.QL = paramString5;
    this.QM = paramim4;
    this.QN = paramString6;
    this.QO = paramString7;
    this.xf = paramString8;
    this.QP = paramList4;
    this.QQ = paramString9;
    this.QS = paramString10;
    this.QT = paramString11;
    this.vf = paramString12;
    this.QU = paramString13;
    this.QV = paramString14;
    this.QW = paramString15;
    this.QX = paramString16;
    this.QY = paramString17;
    this.QZ = paramim5;
    this.Ra = paramString18;
    this.Rb = paramString19;
    this.Gi = paramString20;
    this.Rc = paramString21;
    this.Rd = paramim6;
    this.MU = paramDouble1;
    this.Re = paramim7;
    this.MV = paramDouble2;
    this.mName = paramString22;
    this.Rf = paramim8;
    this.Rg = paramList5;
    this.Rh = paramString23;
    this.Ri = paramString24;
    this.Rj = paramString25;
    this.Rk = paramString26;
    this.Rl = paramim9;
    this.Rm = paramString27;
    this.Rn = paramString28;
    this.Ro = paramString29;
    this.Rp = paramim10;
    this.Rq = paramString30;
    this.Rr = paramString31;
    this.PI = paramString32;
    this.Fv = paramString33;
    this.Rs = paramString34;
    this.Rt = paramString35;
  }
  
  protected boolean a(fb.a parama)
  {
    return this.Qy.contains(Integer.valueOf(parama.qK()));
  }
  
  protected Object aP(String paramString)
  {
    return null;
  }
  
  protected boolean aQ(String paramString)
  {
    return false;
  }
  
  protected Object b(fb.a parama)
  {
    switch (parama.qK())
    {
    case 35: 
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + parama.qK());
    case 2: 
      return this.Qz;
    case 3: 
      return this.QA;
    case 4: 
      return this.QB;
    case 5: 
      return this.QC;
    case 6: 
      return this.QD;
    case 7: 
      return this.QE;
    case 8: 
      return this.QF;
    case 9: 
      return Integer.valueOf(this.QG);
    case 10: 
      return this.QH;
    case 11: 
      return this.QI;
    case 12: 
      return this.QJ;
    case 13: 
      return this.QK;
    case 14: 
      return this.QL;
    case 15: 
      return this.QM;
    case 16: 
      return this.QN;
    case 17: 
      return this.QO;
    case 18: 
      return this.xf;
    case 19: 
      return this.QP;
    case 20: 
      return this.QQ;
    case 21: 
      return this.QS;
    case 22: 
      return this.QT;
    case 23: 
      return this.vf;
    case 24: 
      return this.QU;
    case 25: 
      return this.QV;
    case 26: 
      return this.QW;
    case 27: 
      return this.QX;
    case 28: 
      return this.QY;
    case 29: 
      return this.QZ;
    case 30: 
      return this.Ra;
    case 31: 
      return this.Rb;
    case 32: 
      return this.Gi;
    case 33: 
      return this.Rc;
    case 34: 
      return this.Rd;
    case 36: 
      return Double.valueOf(this.MU);
    case 37: 
      return this.Re;
    case 38: 
      return Double.valueOf(this.MV);
    case 39: 
      return this.mName;
    case 40: 
      return this.Rf;
    case 41: 
      return this.Rg;
    case 42: 
      return this.Rh;
    case 43: 
      return this.Ri;
    case 44: 
      return this.Rj;
    case 45: 
      return this.Rk;
    case 46: 
      return this.Rl;
    case 47: 
      return this.Rm;
    case 48: 
      return this.Rn;
    case 49: 
      return this.Ro;
    case 50: 
      return this.Rp;
    case 51: 
      return this.Rq;
    case 52: 
      return this.Rr;
    case 53: 
      return this.PI;
    case 54: 
      return this.Fv;
    case 55: 
      return this.Rs;
    }
    return this.Rt;
  }
  
  public int describeContents()
  {
    fk localfk = Qw;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof im)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (im)paramObject;
    Iterator localIterator = Qx.values().iterator();
    while (localIterator.hasNext())
    {
      fb.a locala = (fb.a)localIterator.next();
      if (a(locala))
      {
        if (((im)paramObject).a(locala))
        {
          if (!b(locala).equals(((im)paramObject).b(locala))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((im)paramObject).a(locala)) {
        return false;
      }
    }
    return true;
  }
  
  public String getDescription()
  {
    return this.vf;
  }
  
  public String getId()
  {
    return this.Gi;
  }
  
  public double getLatitude()
  {
    return this.MU;
  }
  
  public double getLongitude()
  {
    return this.MV;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getPostalCode()
  {
    return this.Rj;
  }
  
  public String getText()
  {
    return this.Ro;
  }
  
  public String getType()
  {
    return this.PI;
  }
  
  public String getUrl()
  {
    return this.Fv;
  }
  
  public int hashCode()
  {
    Iterator localIterator = Qx.values().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      fb.a locala = (fb.a)localIterator.next();
      if (!a(locala)) {
        break label68;
      }
      int j = locala.qK();
      i = b(locala).hashCode() + (i + j);
    }
    label68:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  int lX()
  {
    return this.qh;
  }
  
  public String oQ()
  {
    return this.xf;
  }
  
  public HashMap<String, fb.a<?, ?>> qE()
  {
    return Qx;
  }
  
  Set<Integer> rI()
  {
    return this.Qy;
  }
  
  im rJ()
  {
    return this.Qz;
  }
  
  public List<String> rK()
  {
    return this.QA;
  }
  
  im rL()
  {
    return this.QB;
  }
  
  public String rM()
  {
    return this.QC;
  }
  
  public String rN()
  {
    return this.QD;
  }
  
  public String rO()
  {
    return this.QE;
  }
  
  List<im> rP()
  {
    return this.QF;
  }
  
  public int rQ()
  {
    return this.QG;
  }
  
  List<im> rR()
  {
    return this.QH;
  }
  
  im rS()
  {
    return this.QI;
  }
  
  List<im> rT()
  {
    return this.QJ;
  }
  
  public String rU()
  {
    return this.QK;
  }
  
  public String rV()
  {
    return this.QL;
  }
  
  im rW()
  {
    return this.QM;
  }
  
  public String rX()
  {
    return this.QN;
  }
  
  public String rY()
  {
    return this.QO;
  }
  
  List<im> rZ()
  {
    return this.QP;
  }
  
  public String sA()
  {
    return this.Rt;
  }
  
  public im sB()
  {
    return this;
  }
  
  public String sa()
  {
    return this.QQ;
  }
  
  public String sb()
  {
    return this.QS;
  }
  
  public String sc()
  {
    return this.QT;
  }
  
  public String sd()
  {
    return this.QU;
  }
  
  public String se()
  {
    return this.QV;
  }
  
  public String sf()
  {
    return this.QW;
  }
  
  public String sg()
  {
    return this.QX;
  }
  
  public String sh()
  {
    return this.QY;
  }
  
  im si()
  {
    return this.QZ;
  }
  
  public String sj()
  {
    return this.Ra;
  }
  
  public String sk()
  {
    return this.Rb;
  }
  
  public String sl()
  {
    return this.Rc;
  }
  
  im sm()
  {
    return this.Rd;
  }
  
  im sn()
  {
    return this.Re;
  }
  
  im so()
  {
    return this.Rf;
  }
  
  List<im> sp()
  {
    return this.Rg;
  }
  
  public String sq()
  {
    return this.Rh;
  }
  
  public String sr()
  {
    return this.Ri;
  }
  
  public String ss()
  {
    return this.Rk;
  }
  
  im st()
  {
    return this.Rl;
  }
  
  public String su()
  {
    return this.Rm;
  }
  
  public String sv()
  {
    return this.Rn;
  }
  
  im sw()
  {
    return this.Rp;
  }
  
  public String sx()
  {
    return this.Rq;
  }
  
  public String sy()
  {
    return this.Rr;
  }
  
  public String sz()
  {
    return this.Rs;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    fk localfk = Qw;
    fk.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/im.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */