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

public final class kn
  extends hy
  implements SafeParcelable, ItemScope
{
  public static final ko CREATOR = new ko();
  private static final HashMap<String, hy.a<?, ?>> acr = new HashMap();
  private String Mp;
  private double Vd;
  private double Ve;
  private int acA;
  private List<kn> acB;
  private kn acC;
  private List<kn> acD;
  private String acE;
  private String acF;
  private kn acG;
  private String acH;
  private String acI;
  private List<kn> acJ;
  private String acK;
  private String acL;
  private String acM;
  private String acN;
  private String acO;
  private String acP;
  private String acQ;
  private String acR;
  private kn acS;
  private String acT;
  private String acU;
  private String acV;
  private kn acW;
  private kn acX;
  private kn acY;
  private List<kn> acZ;
  private final Set<Integer> acs;
  private kn act;
  private List<String> acu;
  private kn acv;
  private String acw;
  private String acx;
  private String acy;
  private List<kn> acz;
  private String ada;
  private String adb;
  private String adc;
  private String add;
  private kn ade;
  private String adf;
  private String adg;
  private String adh;
  private kn adi;
  private String adj;
  private String adk;
  private String adl;
  private String adm;
  private String mName;
  private String mk;
  private String qX;
  private String qY;
  private String xG;
  private final int xM;
  
  static
  {
    acr.put("about", hy.a.a("about", 2, kn.class));
    acr.put("additionalName", hy.a.k("additionalName", 3));
    acr.put("address", hy.a.a("address", 4, kn.class));
    acr.put("addressCountry", hy.a.j("addressCountry", 5));
    acr.put("addressLocality", hy.a.j("addressLocality", 6));
    acr.put("addressRegion", hy.a.j("addressRegion", 7));
    acr.put("associated_media", hy.a.b("associated_media", 8, kn.class));
    acr.put("attendeeCount", hy.a.g("attendeeCount", 9));
    acr.put("attendees", hy.a.b("attendees", 10, kn.class));
    acr.put("audio", hy.a.a("audio", 11, kn.class));
    acr.put("author", hy.a.b("author", 12, kn.class));
    acr.put("bestRating", hy.a.j("bestRating", 13));
    acr.put("birthDate", hy.a.j("birthDate", 14));
    acr.put("byArtist", hy.a.a("byArtist", 15, kn.class));
    acr.put("caption", hy.a.j("caption", 16));
    acr.put("contentSize", hy.a.j("contentSize", 17));
    acr.put("contentUrl", hy.a.j("contentUrl", 18));
    acr.put("contributor", hy.a.b("contributor", 19, kn.class));
    acr.put("dateCreated", hy.a.j("dateCreated", 20));
    acr.put("dateModified", hy.a.j("dateModified", 21));
    acr.put("datePublished", hy.a.j("datePublished", 22));
    acr.put("description", hy.a.j("description", 23));
    acr.put("duration", hy.a.j("duration", 24));
    acr.put("embedUrl", hy.a.j("embedUrl", 25));
    acr.put("endDate", hy.a.j("endDate", 26));
    acr.put("familyName", hy.a.j("familyName", 27));
    acr.put("gender", hy.a.j("gender", 28));
    acr.put("geo", hy.a.a("geo", 29, kn.class));
    acr.put("givenName", hy.a.j("givenName", 30));
    acr.put("height", hy.a.j("height", 31));
    acr.put("id", hy.a.j("id", 32));
    acr.put("image", hy.a.j("image", 33));
    acr.put("inAlbum", hy.a.a("inAlbum", 34, kn.class));
    acr.put("latitude", hy.a.h("latitude", 36));
    acr.put("location", hy.a.a("location", 37, kn.class));
    acr.put("longitude", hy.a.h("longitude", 38));
    acr.put("name", hy.a.j("name", 39));
    acr.put("partOfTVSeries", hy.a.a("partOfTVSeries", 40, kn.class));
    acr.put("performers", hy.a.b("performers", 41, kn.class));
    acr.put("playerType", hy.a.j("playerType", 42));
    acr.put("postOfficeBoxNumber", hy.a.j("postOfficeBoxNumber", 43));
    acr.put("postalCode", hy.a.j("postalCode", 44));
    acr.put("ratingValue", hy.a.j("ratingValue", 45));
    acr.put("reviewRating", hy.a.a("reviewRating", 46, kn.class));
    acr.put("startDate", hy.a.j("startDate", 47));
    acr.put("streetAddress", hy.a.j("streetAddress", 48));
    acr.put("text", hy.a.j("text", 49));
    acr.put("thumbnail", hy.a.a("thumbnail", 50, kn.class));
    acr.put("thumbnailUrl", hy.a.j("thumbnailUrl", 51));
    acr.put("tickerSymbol", hy.a.j("tickerSymbol", 52));
    acr.put("type", hy.a.j("type", 53));
    acr.put("url", hy.a.j("url", 54));
    acr.put("width", hy.a.j("width", 55));
    acr.put("worstRating", hy.a.j("worstRating", 56));
  }
  
  public kn()
  {
    this.xM = 1;
    this.acs = new HashSet();
  }
  
  kn(Set<Integer> paramSet, int paramInt1, kn paramkn1, List<String> paramList, kn paramkn2, String paramString1, String paramString2, String paramString3, List<kn> paramList1, int paramInt2, List<kn> paramList2, kn paramkn3, List<kn> paramList3, String paramString4, String paramString5, kn paramkn4, String paramString6, String paramString7, String paramString8, List<kn> paramList4, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, kn paramkn5, String paramString18, String paramString19, String paramString20, String paramString21, kn paramkn6, double paramDouble1, kn paramkn7, double paramDouble2, String paramString22, kn paramkn8, List<kn> paramList5, String paramString23, String paramString24, String paramString25, String paramString26, kn paramkn9, String paramString27, String paramString28, String paramString29, kn paramkn10, String paramString30, String paramString31, String paramString32, String paramString33, String paramString34, String paramString35)
  {
    this.acs = paramSet;
    this.xM = paramInt1;
    this.act = paramkn1;
    this.acu = paramList;
    this.acv = paramkn2;
    this.acw = paramString1;
    this.acx = paramString2;
    this.acy = paramString3;
    this.acz = paramList1;
    this.acA = paramInt2;
    this.acB = paramList2;
    this.acC = paramkn3;
    this.acD = paramList3;
    this.acE = paramString4;
    this.acF = paramString5;
    this.acG = paramkn4;
    this.acH = paramString6;
    this.acI = paramString7;
    this.mk = paramString8;
    this.acJ = paramList4;
    this.acK = paramString9;
    this.acL = paramString10;
    this.acM = paramString11;
    this.Mp = paramString12;
    this.acN = paramString13;
    this.acO = paramString14;
    this.acP = paramString15;
    this.acQ = paramString16;
    this.acR = paramString17;
    this.acS = paramkn5;
    this.acT = paramString18;
    this.acU = paramString19;
    this.xG = paramString20;
    this.acV = paramString21;
    this.acW = paramkn6;
    this.Vd = paramDouble1;
    this.acX = paramkn7;
    this.Ve = paramDouble2;
    this.mName = paramString22;
    this.acY = paramkn8;
    this.acZ = paramList5;
    this.ada = paramString23;
    this.adb = paramString24;
    this.adc = paramString25;
    this.add = paramString26;
    this.ade = paramkn9;
    this.adf = paramString27;
    this.adg = paramString28;
    this.adh = paramString29;
    this.adi = paramkn10;
    this.adj = paramString30;
    this.adk = paramString31;
    this.qX = paramString32;
    this.qY = paramString33;
    this.adl = paramString34;
    this.adm = paramString35;
  }
  
  public kn(Set<Integer> paramSet, kn paramkn1, List<String> paramList, kn paramkn2, String paramString1, String paramString2, String paramString3, List<kn> paramList1, int paramInt, List<kn> paramList2, kn paramkn3, List<kn> paramList3, String paramString4, String paramString5, kn paramkn4, String paramString6, String paramString7, String paramString8, List<kn> paramList4, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, kn paramkn5, String paramString18, String paramString19, String paramString20, String paramString21, kn paramkn6, double paramDouble1, kn paramkn7, double paramDouble2, String paramString22, kn paramkn8, List<kn> paramList5, String paramString23, String paramString24, String paramString25, String paramString26, kn paramkn9, String paramString27, String paramString28, String paramString29, kn paramkn10, String paramString30, String paramString31, String paramString32, String paramString33, String paramString34, String paramString35)
  {
    this.acs = paramSet;
    this.xM = 1;
    this.act = paramkn1;
    this.acu = paramList;
    this.acv = paramkn2;
    this.acw = paramString1;
    this.acx = paramString2;
    this.acy = paramString3;
    this.acz = paramList1;
    this.acA = paramInt;
    this.acB = paramList2;
    this.acC = paramkn3;
    this.acD = paramList3;
    this.acE = paramString4;
    this.acF = paramString5;
    this.acG = paramkn4;
    this.acH = paramString6;
    this.acI = paramString7;
    this.mk = paramString8;
    this.acJ = paramList4;
    this.acK = paramString9;
    this.acL = paramString10;
    this.acM = paramString11;
    this.Mp = paramString12;
    this.acN = paramString13;
    this.acO = paramString14;
    this.acP = paramString15;
    this.acQ = paramString16;
    this.acR = paramString17;
    this.acS = paramkn5;
    this.acT = paramString18;
    this.acU = paramString19;
    this.xG = paramString20;
    this.acV = paramString21;
    this.acW = paramkn6;
    this.Vd = paramDouble1;
    this.acX = paramkn7;
    this.Ve = paramDouble2;
    this.mName = paramString22;
    this.acY = paramkn8;
    this.acZ = paramList5;
    this.ada = paramString23;
    this.adb = paramString24;
    this.adc = paramString25;
    this.add = paramString26;
    this.ade = paramkn9;
    this.adf = paramString27;
    this.adg = paramString28;
    this.adh = paramString29;
    this.adi = paramkn10;
    this.adj = paramString30;
    this.adk = paramString31;
    this.qX = paramString32;
    this.qY = paramString33;
    this.adl = paramString34;
    this.adm = paramString35;
  }
  
  protected boolean a(hy.a parama)
  {
    return this.acs.contains(Integer.valueOf(parama.fN()));
  }
  
  protected Object aF(String paramString)
  {
    return null;
  }
  
  protected boolean aG(String paramString)
  {
    return false;
  }
  
  protected Object b(hy.a parama)
  {
    switch (parama.fN())
    {
    case 35: 
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + parama.fN());
    case 2: 
      return this.act;
    case 3: 
      return this.acu;
    case 4: 
      return this.acv;
    case 5: 
      return this.acw;
    case 6: 
      return this.acx;
    case 7: 
      return this.acy;
    case 8: 
      return this.acz;
    case 9: 
      return Integer.valueOf(this.acA);
    case 10: 
      return this.acB;
    case 11: 
      return this.acC;
    case 12: 
      return this.acD;
    case 13: 
      return this.acE;
    case 14: 
      return this.acF;
    case 15: 
      return this.acG;
    case 16: 
      return this.acH;
    case 17: 
      return this.acI;
    case 18: 
      return this.mk;
    case 19: 
      return this.acJ;
    case 20: 
      return this.acK;
    case 21: 
      return this.acL;
    case 22: 
      return this.acM;
    case 23: 
      return this.Mp;
    case 24: 
      return this.acN;
    case 25: 
      return this.acO;
    case 26: 
      return this.acP;
    case 27: 
      return this.acQ;
    case 28: 
      return this.acR;
    case 29: 
      return this.acS;
    case 30: 
      return this.acT;
    case 31: 
      return this.acU;
    case 32: 
      return this.xG;
    case 33: 
      return this.acV;
    case 34: 
      return this.acW;
    case 36: 
      return Double.valueOf(this.Vd);
    case 37: 
      return this.acX;
    case 38: 
      return Double.valueOf(this.Ve);
    case 39: 
      return this.mName;
    case 40: 
      return this.acY;
    case 41: 
      return this.acZ;
    case 42: 
      return this.ada;
    case 43: 
      return this.adb;
    case 44: 
      return this.adc;
    case 45: 
      return this.add;
    case 46: 
      return this.ade;
    case 47: 
      return this.adf;
    case 48: 
      return this.adg;
    case 49: 
      return this.adh;
    case 50: 
      return this.adi;
    case 51: 
      return this.adj;
    case 52: 
      return this.adk;
    case 53: 
      return this.qX;
    case 54: 
      return this.qY;
    case 55: 
      return this.adl;
    }
    return this.adm;
  }
  
  public int describeContents()
  {
    ko localko = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof kn)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (kn)paramObject;
    Iterator localIterator = acr.values().iterator();
    while (localIterator.hasNext())
    {
      hy.a locala = (hy.a)localIterator.next();
      if (a(locala))
      {
        if (((kn)paramObject).a(locala))
        {
          if (!b(locala).equals(((kn)paramObject).b(locala))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((kn)paramObject).a(locala)) {
        return false;
      }
    }
    return true;
  }
  
  public HashMap<String, hy.a<?, ?>> fG()
  {
    return acr;
  }
  
  public ItemScope getAbout()
  {
    return this.act;
  }
  
  public List<String> getAdditionalName()
  {
    return this.acu;
  }
  
  public ItemScope getAddress()
  {
    return this.acv;
  }
  
  public String getAddressCountry()
  {
    return this.acw;
  }
  
  public String getAddressLocality()
  {
    return this.acx;
  }
  
  public String getAddressRegion()
  {
    return this.acy;
  }
  
  public List<ItemScope> getAssociated_media()
  {
    return (ArrayList)this.acz;
  }
  
  public int getAttendeeCount()
  {
    return this.acA;
  }
  
  public List<ItemScope> getAttendees()
  {
    return (ArrayList)this.acB;
  }
  
  public ItemScope getAudio()
  {
    return this.acC;
  }
  
  public List<ItemScope> getAuthor()
  {
    return (ArrayList)this.acD;
  }
  
  public String getBestRating()
  {
    return this.acE;
  }
  
  public String getBirthDate()
  {
    return this.acF;
  }
  
  public ItemScope getByArtist()
  {
    return this.acG;
  }
  
  public String getCaption()
  {
    return this.acH;
  }
  
  public String getContentSize()
  {
    return this.acI;
  }
  
  public String getContentUrl()
  {
    return this.mk;
  }
  
  public List<ItemScope> getContributor()
  {
    return (ArrayList)this.acJ;
  }
  
  public String getDateCreated()
  {
    return this.acK;
  }
  
  public String getDateModified()
  {
    return this.acL;
  }
  
  public String getDatePublished()
  {
    return this.acM;
  }
  
  public String getDescription()
  {
    return this.Mp;
  }
  
  public String getDuration()
  {
    return this.acN;
  }
  
  public String getEmbedUrl()
  {
    return this.acO;
  }
  
  public String getEndDate()
  {
    return this.acP;
  }
  
  public String getFamilyName()
  {
    return this.acQ;
  }
  
  public String getGender()
  {
    return this.acR;
  }
  
  public ItemScope getGeo()
  {
    return this.acS;
  }
  
  public String getGivenName()
  {
    return this.acT;
  }
  
  public String getHeight()
  {
    return this.acU;
  }
  
  public String getId()
  {
    return this.xG;
  }
  
  public String getImage()
  {
    return this.acV;
  }
  
  public ItemScope getInAlbum()
  {
    return this.acW;
  }
  
  public double getLatitude()
  {
    return this.Vd;
  }
  
  public ItemScope getLocation()
  {
    return this.acX;
  }
  
  public double getLongitude()
  {
    return this.Ve;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public ItemScope getPartOfTVSeries()
  {
    return this.acY;
  }
  
  public List<ItemScope> getPerformers()
  {
    return (ArrayList)this.acZ;
  }
  
  public String getPlayerType()
  {
    return this.ada;
  }
  
  public String getPostOfficeBoxNumber()
  {
    return this.adb;
  }
  
  public String getPostalCode()
  {
    return this.adc;
  }
  
  public String getRatingValue()
  {
    return this.add;
  }
  
  public ItemScope getReviewRating()
  {
    return this.ade;
  }
  
  public String getStartDate()
  {
    return this.adf;
  }
  
  public String getStreetAddress()
  {
    return this.adg;
  }
  
  public String getText()
  {
    return this.adh;
  }
  
  public ItemScope getThumbnail()
  {
    return this.adi;
  }
  
  public String getThumbnailUrl()
  {
    return this.adj;
  }
  
  public String getTickerSymbol()
  {
    return this.adk;
  }
  
  public String getType()
  {
    return this.qX;
  }
  
  public String getUrl()
  {
    return this.qY;
  }
  
  int getVersionCode()
  {
    return this.xM;
  }
  
  public String getWidth()
  {
    return this.adl;
  }
  
  public String getWorstRating()
  {
    return this.adm;
  }
  
  public boolean hasAbout()
  {
    return this.acs.contains(Integer.valueOf(2));
  }
  
  public boolean hasAdditionalName()
  {
    return this.acs.contains(Integer.valueOf(3));
  }
  
  public boolean hasAddress()
  {
    return this.acs.contains(Integer.valueOf(4));
  }
  
  public boolean hasAddressCountry()
  {
    return this.acs.contains(Integer.valueOf(5));
  }
  
  public boolean hasAddressLocality()
  {
    return this.acs.contains(Integer.valueOf(6));
  }
  
  public boolean hasAddressRegion()
  {
    return this.acs.contains(Integer.valueOf(7));
  }
  
  public boolean hasAssociated_media()
  {
    return this.acs.contains(Integer.valueOf(8));
  }
  
  public boolean hasAttendeeCount()
  {
    return this.acs.contains(Integer.valueOf(9));
  }
  
  public boolean hasAttendees()
  {
    return this.acs.contains(Integer.valueOf(10));
  }
  
  public boolean hasAudio()
  {
    return this.acs.contains(Integer.valueOf(11));
  }
  
  public boolean hasAuthor()
  {
    return this.acs.contains(Integer.valueOf(12));
  }
  
  public boolean hasBestRating()
  {
    return this.acs.contains(Integer.valueOf(13));
  }
  
  public boolean hasBirthDate()
  {
    return this.acs.contains(Integer.valueOf(14));
  }
  
  public boolean hasByArtist()
  {
    return this.acs.contains(Integer.valueOf(15));
  }
  
  public boolean hasCaption()
  {
    return this.acs.contains(Integer.valueOf(16));
  }
  
  public boolean hasContentSize()
  {
    return this.acs.contains(Integer.valueOf(17));
  }
  
  public boolean hasContentUrl()
  {
    return this.acs.contains(Integer.valueOf(18));
  }
  
  public boolean hasContributor()
  {
    return this.acs.contains(Integer.valueOf(19));
  }
  
  public boolean hasDateCreated()
  {
    return this.acs.contains(Integer.valueOf(20));
  }
  
  public boolean hasDateModified()
  {
    return this.acs.contains(Integer.valueOf(21));
  }
  
  public boolean hasDatePublished()
  {
    return this.acs.contains(Integer.valueOf(22));
  }
  
  public boolean hasDescription()
  {
    return this.acs.contains(Integer.valueOf(23));
  }
  
  public boolean hasDuration()
  {
    return this.acs.contains(Integer.valueOf(24));
  }
  
  public boolean hasEmbedUrl()
  {
    return this.acs.contains(Integer.valueOf(25));
  }
  
  public boolean hasEndDate()
  {
    return this.acs.contains(Integer.valueOf(26));
  }
  
  public boolean hasFamilyName()
  {
    return this.acs.contains(Integer.valueOf(27));
  }
  
  public boolean hasGender()
  {
    return this.acs.contains(Integer.valueOf(28));
  }
  
  public boolean hasGeo()
  {
    return this.acs.contains(Integer.valueOf(29));
  }
  
  public boolean hasGivenName()
  {
    return this.acs.contains(Integer.valueOf(30));
  }
  
  public boolean hasHeight()
  {
    return this.acs.contains(Integer.valueOf(31));
  }
  
  public boolean hasId()
  {
    return this.acs.contains(Integer.valueOf(32));
  }
  
  public boolean hasImage()
  {
    return this.acs.contains(Integer.valueOf(33));
  }
  
  public boolean hasInAlbum()
  {
    return this.acs.contains(Integer.valueOf(34));
  }
  
  public boolean hasLatitude()
  {
    return this.acs.contains(Integer.valueOf(36));
  }
  
  public boolean hasLocation()
  {
    return this.acs.contains(Integer.valueOf(37));
  }
  
  public boolean hasLongitude()
  {
    return this.acs.contains(Integer.valueOf(38));
  }
  
  public boolean hasName()
  {
    return this.acs.contains(Integer.valueOf(39));
  }
  
  public boolean hasPartOfTVSeries()
  {
    return this.acs.contains(Integer.valueOf(40));
  }
  
  public boolean hasPerformers()
  {
    return this.acs.contains(Integer.valueOf(41));
  }
  
  public boolean hasPlayerType()
  {
    return this.acs.contains(Integer.valueOf(42));
  }
  
  public boolean hasPostOfficeBoxNumber()
  {
    return this.acs.contains(Integer.valueOf(43));
  }
  
  public boolean hasPostalCode()
  {
    return this.acs.contains(Integer.valueOf(44));
  }
  
  public boolean hasRatingValue()
  {
    return this.acs.contains(Integer.valueOf(45));
  }
  
  public boolean hasReviewRating()
  {
    return this.acs.contains(Integer.valueOf(46));
  }
  
  public boolean hasStartDate()
  {
    return this.acs.contains(Integer.valueOf(47));
  }
  
  public boolean hasStreetAddress()
  {
    return this.acs.contains(Integer.valueOf(48));
  }
  
  public boolean hasText()
  {
    return this.acs.contains(Integer.valueOf(49));
  }
  
  public boolean hasThumbnail()
  {
    return this.acs.contains(Integer.valueOf(50));
  }
  
  public boolean hasThumbnailUrl()
  {
    return this.acs.contains(Integer.valueOf(51));
  }
  
  public boolean hasTickerSymbol()
  {
    return this.acs.contains(Integer.valueOf(52));
  }
  
  public boolean hasType()
  {
    return this.acs.contains(Integer.valueOf(53));
  }
  
  public boolean hasUrl()
  {
    return this.acs.contains(Integer.valueOf(54));
  }
  
  public boolean hasWidth()
  {
    return this.acs.contains(Integer.valueOf(55));
  }
  
  public boolean hasWorstRating()
  {
    return this.acs.contains(Integer.valueOf(56));
  }
  
  public int hashCode()
  {
    Iterator localIterator = acr.values().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      hy.a locala = (hy.a)localIterator.next();
      if (!a(locala)) {
        break label68;
      }
      int j = locala.fN();
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
  
  public kn kA()
  {
    return this;
  }
  
  Set<Integer> kk()
  {
    return this.acs;
  }
  
  kn kl()
  {
    return this.act;
  }
  
  kn km()
  {
    return this.acv;
  }
  
  List<kn> kn()
  {
    return this.acz;
  }
  
  List<kn> ko()
  {
    return this.acB;
  }
  
  kn kp()
  {
    return this.acC;
  }
  
  List<kn> kq()
  {
    return this.acD;
  }
  
  kn kr()
  {
    return this.acG;
  }
  
  List<kn> ks()
  {
    return this.acJ;
  }
  
  kn kt()
  {
    return this.acS;
  }
  
  kn ku()
  {
    return this.acW;
  }
  
  kn kv()
  {
    return this.acX;
  }
  
  kn kw()
  {
    return this.acY;
  }
  
  List<kn> kx()
  {
    return this.acZ;
  }
  
  kn ky()
  {
    return this.ade;
  }
  
  kn kz()
  {
    return this.adi;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ko localko = CREATOR;
    ko.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/kn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */