package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class ib
  extends es
  implements SafeParcelable, ItemScope
{
  public static final ic CREATOR = new ic();
  private static final HashMap<String, es.a<?, ?>> Ep = new HashMap();
  private String AI;
  private ib EA;
  private List<ib> EB;
  private String EC;
  private String ED;
  private ib EE;
  private String EF;
  private String EG;
  private String EH;
  private List<ib> EI;
  private String EJ;
  private String EK;
  private String EL;
  private String EM;
  private String EN;
  private String EO;
  private String EP;
  private String EQ;
  private ib ER;
  private String ES;
  private String ET;
  private String EU;
  private ib EV;
  private ib EW;
  private ib EX;
  private List<ib> EY;
  private String EZ;
  private final Set<Integer> Eq;
  private ib Er;
  private List<String> Es;
  private ib Et;
  private String Eu;
  private String Ev;
  private String Ew;
  private List<ib> Ex;
  private int Ey;
  private List<ib> Ez;
  private String Fa;
  private String Fb;
  private String Fc;
  private ib Fd;
  private String Fe;
  private String Ff;
  private String Fg;
  private ib Fh;
  private String Fi;
  private String Fj;
  private String Fk;
  private String Fl;
  private String iH;
  private final int kg;
  private String mName;
  private String sJ;
  private String uS;
  private double xw;
  private double xx;
  
  static
  {
    Ep.put("about", es.a.a("about", 2, ib.class));
    Ep.put("additionalName", es.a.h("additionalName", 3));
    Ep.put("address", es.a.a("address", 4, ib.class));
    Ep.put("addressCountry", es.a.g("addressCountry", 5));
    Ep.put("addressLocality", es.a.g("addressLocality", 6));
    Ep.put("addressRegion", es.a.g("addressRegion", 7));
    Ep.put("associated_media", es.a.b("associated_media", 8, ib.class));
    Ep.put("attendeeCount", es.a.d("attendeeCount", 9));
    Ep.put("attendees", es.a.b("attendees", 10, ib.class));
    Ep.put("audio", es.a.a("audio", 11, ib.class));
    Ep.put("author", es.a.b("author", 12, ib.class));
    Ep.put("bestRating", es.a.g("bestRating", 13));
    Ep.put("birthDate", es.a.g("birthDate", 14));
    Ep.put("byArtist", es.a.a("byArtist", 15, ib.class));
    Ep.put("caption", es.a.g("caption", 16));
    Ep.put("contentSize", es.a.g("contentSize", 17));
    Ep.put("contentUrl", es.a.g("contentUrl", 18));
    Ep.put("contributor", es.a.b("contributor", 19, ib.class));
    Ep.put("dateCreated", es.a.g("dateCreated", 20));
    Ep.put("dateModified", es.a.g("dateModified", 21));
    Ep.put("datePublished", es.a.g("datePublished", 22));
    Ep.put("description", es.a.g("description", 23));
    Ep.put("duration", es.a.g("duration", 24));
    Ep.put("embedUrl", es.a.g("embedUrl", 25));
    Ep.put("endDate", es.a.g("endDate", 26));
    Ep.put("familyName", es.a.g("familyName", 27));
    Ep.put("gender", es.a.g("gender", 28));
    Ep.put("geo", es.a.a("geo", 29, ib.class));
    Ep.put("givenName", es.a.g("givenName", 30));
    Ep.put("height", es.a.g("height", 31));
    Ep.put("id", es.a.g("id", 32));
    Ep.put("image", es.a.g("image", 33));
    Ep.put("inAlbum", es.a.a("inAlbum", 34, ib.class));
    Ep.put("latitude", es.a.e("latitude", 36));
    Ep.put("location", es.a.a("location", 37, ib.class));
    Ep.put("longitude", es.a.e("longitude", 38));
    Ep.put("name", es.a.g("name", 39));
    Ep.put("partOfTVSeries", es.a.a("partOfTVSeries", 40, ib.class));
    Ep.put("performers", es.a.b("performers", 41, ib.class));
    Ep.put("playerType", es.a.g("playerType", 42));
    Ep.put("postOfficeBoxNumber", es.a.g("postOfficeBoxNumber", 43));
    Ep.put("postalCode", es.a.g("postalCode", 44));
    Ep.put("ratingValue", es.a.g("ratingValue", 45));
    Ep.put("reviewRating", es.a.a("reviewRating", 46, ib.class));
    Ep.put("startDate", es.a.g("startDate", 47));
    Ep.put("streetAddress", es.a.g("streetAddress", 48));
    Ep.put("text", es.a.g("text", 49));
    Ep.put("thumbnail", es.a.a("thumbnail", 50, ib.class));
    Ep.put("thumbnailUrl", es.a.g("thumbnailUrl", 51));
    Ep.put("tickerSymbol", es.a.g("tickerSymbol", 52));
    Ep.put("type", es.a.g("type", 53));
    Ep.put("url", es.a.g("url", 54));
    Ep.put("width", es.a.g("width", 55));
    Ep.put("worstRating", es.a.g("worstRating", 56));
  }
  
  public ib()
  {
    this.kg = 1;
    this.Eq = new HashSet();
  }
  
  ib(Set<Integer> paramSet, int paramInt1, ib paramib1, List<String> paramList, ib paramib2, String paramString1, String paramString2, String paramString3, List<ib> paramList1, int paramInt2, List<ib> paramList2, ib paramib3, List<ib> paramList3, String paramString4, String paramString5, ib paramib4, String paramString6, String paramString7, String paramString8, List<ib> paramList4, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, ib paramib5, String paramString18, String paramString19, String paramString20, String paramString21, ib paramib6, double paramDouble1, ib paramib7, double paramDouble2, String paramString22, ib paramib8, List<ib> paramList5, String paramString23, String paramString24, String paramString25, String paramString26, ib paramib9, String paramString27, String paramString28, String paramString29, ib paramib10, String paramString30, String paramString31, String paramString32, String paramString33, String paramString34, String paramString35)
  {
    this.Eq = paramSet;
    this.kg = paramInt1;
    this.Er = paramib1;
    this.Es = paramList;
    this.Et = paramib2;
    this.Eu = paramString1;
    this.Ev = paramString2;
    this.Ew = paramString3;
    this.Ex = paramList1;
    this.Ey = paramInt2;
    this.Ez = paramList2;
    this.EA = paramib3;
    this.EB = paramList3;
    this.EC = paramString4;
    this.ED = paramString5;
    this.EE = paramib4;
    this.EF = paramString6;
    this.EG = paramString7;
    this.EH = paramString8;
    this.EI = paramList4;
    this.EJ = paramString9;
    this.EK = paramString10;
    this.EL = paramString11;
    this.sJ = paramString12;
    this.EM = paramString13;
    this.EN = paramString14;
    this.EO = paramString15;
    this.EP = paramString16;
    this.EQ = paramString17;
    this.ER = paramib5;
    this.ES = paramString18;
    this.ET = paramString19;
    this.uS = paramString20;
    this.EU = paramString21;
    this.EV = paramib6;
    this.xw = paramDouble1;
    this.EW = paramib7;
    this.xx = paramDouble2;
    this.mName = paramString22;
    this.EX = paramib8;
    this.EY = paramList5;
    this.EZ = paramString23;
    this.Fa = paramString24;
    this.Fb = paramString25;
    this.Fc = paramString26;
    this.Fd = paramib9;
    this.Fe = paramString27;
    this.Ff = paramString28;
    this.Fg = paramString29;
    this.Fh = paramib10;
    this.Fi = paramString30;
    this.Fj = paramString31;
    this.AI = paramString32;
    this.iH = paramString33;
    this.Fk = paramString34;
    this.Fl = paramString35;
  }
  
  public ib(Set<Integer> paramSet, ib paramib1, List<String> paramList, ib paramib2, String paramString1, String paramString2, String paramString3, List<ib> paramList1, int paramInt, List<ib> paramList2, ib paramib3, List<ib> paramList3, String paramString4, String paramString5, ib paramib4, String paramString6, String paramString7, String paramString8, List<ib> paramList4, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, ib paramib5, String paramString18, String paramString19, String paramString20, String paramString21, ib paramib6, double paramDouble1, ib paramib7, double paramDouble2, String paramString22, ib paramib8, List<ib> paramList5, String paramString23, String paramString24, String paramString25, String paramString26, ib paramib9, String paramString27, String paramString28, String paramString29, ib paramib10, String paramString30, String paramString31, String paramString32, String paramString33, String paramString34, String paramString35)
  {
    this.Eq = paramSet;
    this.kg = 1;
    this.Er = paramib1;
    this.Es = paramList;
    this.Et = paramib2;
    this.Eu = paramString1;
    this.Ev = paramString2;
    this.Ew = paramString3;
    this.Ex = paramList1;
    this.Ey = paramInt;
    this.Ez = paramList2;
    this.EA = paramib3;
    this.EB = paramList3;
    this.EC = paramString4;
    this.ED = paramString5;
    this.EE = paramib4;
    this.EF = paramString6;
    this.EG = paramString7;
    this.EH = paramString8;
    this.EI = paramList4;
    this.EJ = paramString9;
    this.EK = paramString10;
    this.EL = paramString11;
    this.sJ = paramString12;
    this.EM = paramString13;
    this.EN = paramString14;
    this.EO = paramString15;
    this.EP = paramString16;
    this.EQ = paramString17;
    this.ER = paramib5;
    this.ES = paramString18;
    this.ET = paramString19;
    this.uS = paramString20;
    this.EU = paramString21;
    this.EV = paramib6;
    this.xw = paramDouble1;
    this.EW = paramib7;
    this.xx = paramDouble2;
    this.mName = paramString22;
    this.EX = paramib8;
    this.EY = paramList5;
    this.EZ = paramString23;
    this.Fa = paramString24;
    this.Fb = paramString25;
    this.Fc = paramString26;
    this.Fd = paramib9;
    this.Fe = paramString27;
    this.Ff = paramString28;
    this.Fg = paramString29;
    this.Fh = paramib10;
    this.Fi = paramString30;
    this.Fj = paramString31;
    this.AI = paramString32;
    this.iH = paramString33;
    this.Fk = paramString34;
    this.Fl = paramString35;
  }
  
  protected Object V(String paramString)
  {
    return null;
  }
  
  protected boolean W(String paramString)
  {
    return false;
  }
  
  protected boolean a(es.a parama)
  {
    return this.Eq.contains(Integer.valueOf(parama.cq()));
  }
  
  protected Object b(es.a parama)
  {
    switch (parama.cq())
    {
    case 35: 
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + parama.cq());
    case 2: 
      return this.Er;
    case 3: 
      return this.Es;
    case 4: 
      return this.Et;
    case 5: 
      return this.Eu;
    case 6: 
      return this.Ev;
    case 7: 
      return this.Ew;
    case 8: 
      return this.Ex;
    case 9: 
      return Integer.valueOf(this.Ey);
    case 10: 
      return this.Ez;
    case 11: 
      return this.EA;
    case 12: 
      return this.EB;
    case 13: 
      return this.EC;
    case 14: 
      return this.ED;
    case 15: 
      return this.EE;
    case 16: 
      return this.EF;
    case 17: 
      return this.EG;
    case 18: 
      return this.EH;
    case 19: 
      return this.EI;
    case 20: 
      return this.EJ;
    case 21: 
      return this.EK;
    case 22: 
      return this.EL;
    case 23: 
      return this.sJ;
    case 24: 
      return this.EM;
    case 25: 
      return this.EN;
    case 26: 
      return this.EO;
    case 27: 
      return this.EP;
    case 28: 
      return this.EQ;
    case 29: 
      return this.ER;
    case 30: 
      return this.ES;
    case 31: 
      return this.ET;
    case 32: 
      return this.uS;
    case 33: 
      return this.EU;
    case 34: 
      return this.EV;
    case 36: 
      return Double.valueOf(this.xw);
    case 37: 
      return this.EW;
    case 38: 
      return Double.valueOf(this.xx);
    case 39: 
      return this.mName;
    case 40: 
      return this.EX;
    case 41: 
      return this.EY;
    case 42: 
      return this.EZ;
    case 43: 
      return this.Fa;
    case 44: 
      return this.Fb;
    case 45: 
      return this.Fc;
    case 46: 
      return this.Fd;
    case 47: 
      return this.Fe;
    case 48: 
      return this.Ff;
    case 49: 
      return this.Fg;
    case 50: 
      return this.Fh;
    case 51: 
      return this.Fi;
    case 52: 
      return this.Fj;
    case 53: 
      return this.AI;
    case 54: 
      return this.iH;
    case 55: 
      return this.Fk;
    }
    return this.Fl;
  }
  
  public HashMap<String, es.a<?, ?>> cj()
  {
    return Ep;
  }
  
  public int describeContents()
  {
    ic localic = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ib)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (ib)paramObject;
    Iterator localIterator = Ep.values().iterator();
    while (localIterator.hasNext())
    {
      es.a locala = (es.a)localIterator.next();
      if (a(locala))
      {
        if (((ib)paramObject).a(locala))
        {
          if (!b(locala).equals(((ib)paramObject).b(locala))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((ib)paramObject).a(locala)) {
        return false;
      }
    }
    return true;
  }
  
  Set<Integer> fa()
  {
    return this.Eq;
  }
  
  ib fb()
  {
    return this.Er;
  }
  
  ib fc()
  {
    return this.Et;
  }
  
  List<ib> fd()
  {
    return this.Ex;
  }
  
  List<ib> fe()
  {
    return this.Ez;
  }
  
  ib ff()
  {
    return this.EA;
  }
  
  List<ib> fg()
  {
    return this.EB;
  }
  
  ib fh()
  {
    return this.EE;
  }
  
  List<ib> fi()
  {
    return this.EI;
  }
  
  ib fj()
  {
    return this.ER;
  }
  
  ib fk()
  {
    return this.EV;
  }
  
  ib fl()
  {
    return this.EW;
  }
  
  ib fm()
  {
    return this.EX;
  }
  
  List<ib> fn()
  {
    return this.EY;
  }
  
  ib fo()
  {
    return this.Fd;
  }
  
  ib fp()
  {
    return this.Fh;
  }
  
  public ib fq()
  {
    return this;
  }
  
  public ItemScope getAbout()
  {
    return this.Er;
  }
  
  public List<String> getAdditionalName()
  {
    return this.Es;
  }
  
  public ItemScope getAddress()
  {
    return this.Et;
  }
  
  public String getAddressCountry()
  {
    return this.Eu;
  }
  
  public String getAddressLocality()
  {
    return this.Ev;
  }
  
  public String getAddressRegion()
  {
    return this.Ew;
  }
  
  public List<ItemScope> getAssociated_media()
  {
    return (ArrayList)this.Ex;
  }
  
  public int getAttendeeCount()
  {
    return this.Ey;
  }
  
  public List<ItemScope> getAttendees()
  {
    return (ArrayList)this.Ez;
  }
  
  public ItemScope getAudio()
  {
    return this.EA;
  }
  
  public List<ItemScope> getAuthor()
  {
    return (ArrayList)this.EB;
  }
  
  public String getBestRating()
  {
    return this.EC;
  }
  
  public String getBirthDate()
  {
    return this.ED;
  }
  
  public ItemScope getByArtist()
  {
    return this.EE;
  }
  
  public String getCaption()
  {
    return this.EF;
  }
  
  public String getContentSize()
  {
    return this.EG;
  }
  
  public String getContentUrl()
  {
    return this.EH;
  }
  
  public List<ItemScope> getContributor()
  {
    return (ArrayList)this.EI;
  }
  
  public String getDateCreated()
  {
    return this.EJ;
  }
  
  public String getDateModified()
  {
    return this.EK;
  }
  
  public String getDatePublished()
  {
    return this.EL;
  }
  
  public String getDescription()
  {
    return this.sJ;
  }
  
  public String getDuration()
  {
    return this.EM;
  }
  
  public String getEmbedUrl()
  {
    return this.EN;
  }
  
  public String getEndDate()
  {
    return this.EO;
  }
  
  public String getFamilyName()
  {
    return this.EP;
  }
  
  public String getGender()
  {
    return this.EQ;
  }
  
  public ItemScope getGeo()
  {
    return this.ER;
  }
  
  public String getGivenName()
  {
    return this.ES;
  }
  
  public String getHeight()
  {
    return this.ET;
  }
  
  public String getId()
  {
    return this.uS;
  }
  
  public String getImage()
  {
    return this.EU;
  }
  
  public ItemScope getInAlbum()
  {
    return this.EV;
  }
  
  public double getLatitude()
  {
    return this.xw;
  }
  
  public ItemScope getLocation()
  {
    return this.EW;
  }
  
  public double getLongitude()
  {
    return this.xx;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public ItemScope getPartOfTVSeries()
  {
    return this.EX;
  }
  
  public List<ItemScope> getPerformers()
  {
    return (ArrayList)this.EY;
  }
  
  public String getPlayerType()
  {
    return this.EZ;
  }
  
  public String getPostOfficeBoxNumber()
  {
    return this.Fa;
  }
  
  public String getPostalCode()
  {
    return this.Fb;
  }
  
  public String getRatingValue()
  {
    return this.Fc;
  }
  
  public ItemScope getReviewRating()
  {
    return this.Fd;
  }
  
  public String getStartDate()
  {
    return this.Fe;
  }
  
  public String getStreetAddress()
  {
    return this.Ff;
  }
  
  public String getText()
  {
    return this.Fg;
  }
  
  public ItemScope getThumbnail()
  {
    return this.Fh;
  }
  
  public String getThumbnailUrl()
  {
    return this.Fi;
  }
  
  public String getTickerSymbol()
  {
    return this.Fj;
  }
  
  public String getType()
  {
    return this.AI;
  }
  
  public String getUrl()
  {
    return this.iH;
  }
  
  int getVersionCode()
  {
    return this.kg;
  }
  
  public String getWidth()
  {
    return this.Fk;
  }
  
  public String getWorstRating()
  {
    return this.Fl;
  }
  
  public boolean hasAbout()
  {
    return this.Eq.contains(Integer.valueOf(2));
  }
  
  public boolean hasAdditionalName()
  {
    return this.Eq.contains(Integer.valueOf(3));
  }
  
  public boolean hasAddress()
  {
    return this.Eq.contains(Integer.valueOf(4));
  }
  
  public boolean hasAddressCountry()
  {
    return this.Eq.contains(Integer.valueOf(5));
  }
  
  public boolean hasAddressLocality()
  {
    return this.Eq.contains(Integer.valueOf(6));
  }
  
  public boolean hasAddressRegion()
  {
    return this.Eq.contains(Integer.valueOf(7));
  }
  
  public boolean hasAssociated_media()
  {
    return this.Eq.contains(Integer.valueOf(8));
  }
  
  public boolean hasAttendeeCount()
  {
    return this.Eq.contains(Integer.valueOf(9));
  }
  
  public boolean hasAttendees()
  {
    return this.Eq.contains(Integer.valueOf(10));
  }
  
  public boolean hasAudio()
  {
    return this.Eq.contains(Integer.valueOf(11));
  }
  
  public boolean hasAuthor()
  {
    return this.Eq.contains(Integer.valueOf(12));
  }
  
  public boolean hasBestRating()
  {
    return this.Eq.contains(Integer.valueOf(13));
  }
  
  public boolean hasBirthDate()
  {
    return this.Eq.contains(Integer.valueOf(14));
  }
  
  public boolean hasByArtist()
  {
    return this.Eq.contains(Integer.valueOf(15));
  }
  
  public boolean hasCaption()
  {
    return this.Eq.contains(Integer.valueOf(16));
  }
  
  public boolean hasContentSize()
  {
    return this.Eq.contains(Integer.valueOf(17));
  }
  
  public boolean hasContentUrl()
  {
    return this.Eq.contains(Integer.valueOf(18));
  }
  
  public boolean hasContributor()
  {
    return this.Eq.contains(Integer.valueOf(19));
  }
  
  public boolean hasDateCreated()
  {
    return this.Eq.contains(Integer.valueOf(20));
  }
  
  public boolean hasDateModified()
  {
    return this.Eq.contains(Integer.valueOf(21));
  }
  
  public boolean hasDatePublished()
  {
    return this.Eq.contains(Integer.valueOf(22));
  }
  
  public boolean hasDescription()
  {
    return this.Eq.contains(Integer.valueOf(23));
  }
  
  public boolean hasDuration()
  {
    return this.Eq.contains(Integer.valueOf(24));
  }
  
  public boolean hasEmbedUrl()
  {
    return this.Eq.contains(Integer.valueOf(25));
  }
  
  public boolean hasEndDate()
  {
    return this.Eq.contains(Integer.valueOf(26));
  }
  
  public boolean hasFamilyName()
  {
    return this.Eq.contains(Integer.valueOf(27));
  }
  
  public boolean hasGender()
  {
    return this.Eq.contains(Integer.valueOf(28));
  }
  
  public boolean hasGeo()
  {
    return this.Eq.contains(Integer.valueOf(29));
  }
  
  public boolean hasGivenName()
  {
    return this.Eq.contains(Integer.valueOf(30));
  }
  
  public boolean hasHeight()
  {
    return this.Eq.contains(Integer.valueOf(31));
  }
  
  public boolean hasId()
  {
    return this.Eq.contains(Integer.valueOf(32));
  }
  
  public boolean hasImage()
  {
    return this.Eq.contains(Integer.valueOf(33));
  }
  
  public boolean hasInAlbum()
  {
    return this.Eq.contains(Integer.valueOf(34));
  }
  
  public boolean hasLatitude()
  {
    return this.Eq.contains(Integer.valueOf(36));
  }
  
  public boolean hasLocation()
  {
    return this.Eq.contains(Integer.valueOf(37));
  }
  
  public boolean hasLongitude()
  {
    return this.Eq.contains(Integer.valueOf(38));
  }
  
  public boolean hasName()
  {
    return this.Eq.contains(Integer.valueOf(39));
  }
  
  public boolean hasPartOfTVSeries()
  {
    return this.Eq.contains(Integer.valueOf(40));
  }
  
  public boolean hasPerformers()
  {
    return this.Eq.contains(Integer.valueOf(41));
  }
  
  public boolean hasPlayerType()
  {
    return this.Eq.contains(Integer.valueOf(42));
  }
  
  public boolean hasPostOfficeBoxNumber()
  {
    return this.Eq.contains(Integer.valueOf(43));
  }
  
  public boolean hasPostalCode()
  {
    return this.Eq.contains(Integer.valueOf(44));
  }
  
  public boolean hasRatingValue()
  {
    return this.Eq.contains(Integer.valueOf(45));
  }
  
  public boolean hasReviewRating()
  {
    return this.Eq.contains(Integer.valueOf(46));
  }
  
  public boolean hasStartDate()
  {
    return this.Eq.contains(Integer.valueOf(47));
  }
  
  public boolean hasStreetAddress()
  {
    return this.Eq.contains(Integer.valueOf(48));
  }
  
  public boolean hasText()
  {
    return this.Eq.contains(Integer.valueOf(49));
  }
  
  public boolean hasThumbnail()
  {
    return this.Eq.contains(Integer.valueOf(50));
  }
  
  public boolean hasThumbnailUrl()
  {
    return this.Eq.contains(Integer.valueOf(51));
  }
  
  public boolean hasTickerSymbol()
  {
    return this.Eq.contains(Integer.valueOf(52));
  }
  
  public boolean hasType()
  {
    return this.Eq.contains(Integer.valueOf(53));
  }
  
  public boolean hasUrl()
  {
    return this.Eq.contains(Integer.valueOf(54));
  }
  
  public boolean hasWidth()
  {
    return this.Eq.contains(Integer.valueOf(55));
  }
  
  public boolean hasWorstRating()
  {
    return this.Eq.contains(Integer.valueOf(56));
  }
  
  public int hashCode()
  {
    Iterator localIterator = Ep.values().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      es.a locala = (es.a)localIterator.next();
      if (!a(locala)) {
        break label68;
      }
      int j = locala.cq();
      i = b(locala).hashCode() + (i + j);
    }
    label68:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ic localic = CREATOR;
    ic.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/ib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */