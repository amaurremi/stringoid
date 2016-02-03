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

public final class ic
  extends ga
  implements SafeParcelable, ItemScope
{
  public static final id CREATOR = new id();
  private static final HashMap<String, ga.a<?, ?>> UI = new HashMap();
  private String HD;
  private double NX;
  private double NY;
  private String Rd;
  private final Set<Integer> UJ;
  private ic UK;
  private List<String> UL;
  private ic UM;
  private String UN;
  private String UO;
  private String UP;
  private List<ic> UQ;
  private int UR;
  private List<ic> US;
  private ic UT;
  private List<ic> UU;
  private String UV;
  private String UW;
  private ic UX;
  private String UY;
  private String UZ;
  private String VA;
  private String VB;
  private String VC;
  private String VD;
  private List<ic> Va;
  private String Vb;
  private String Vc;
  private String Vd;
  private String Ve;
  private String Vf;
  private String Vg;
  private String Vh;
  private String Vi;
  private ic Vj;
  private String Vk;
  private String Vl;
  private String Vm;
  private ic Vn;
  private ic Vo;
  private ic Vp;
  private List<ic> Vq;
  private String Vr;
  private String Vs;
  private String Vt;
  private String Vu;
  private ic Vv;
  private String Vw;
  private String Vx;
  private String Vy;
  private ic Vz;
  private String lY;
  private String mName;
  private String ro;
  private String wp;
  private final int xH;
  
  static
  {
    UI.put("about", ga.a.a("about", 2, ic.class));
    UI.put("additionalName", ga.a.k("additionalName", 3));
    UI.put("address", ga.a.a("address", 4, ic.class));
    UI.put("addressCountry", ga.a.j("addressCountry", 5));
    UI.put("addressLocality", ga.a.j("addressLocality", 6));
    UI.put("addressRegion", ga.a.j("addressRegion", 7));
    UI.put("associated_media", ga.a.b("associated_media", 8, ic.class));
    UI.put("attendeeCount", ga.a.g("attendeeCount", 9));
    UI.put("attendees", ga.a.b("attendees", 10, ic.class));
    UI.put("audio", ga.a.a("audio", 11, ic.class));
    UI.put("author", ga.a.b("author", 12, ic.class));
    UI.put("bestRating", ga.a.j("bestRating", 13));
    UI.put("birthDate", ga.a.j("birthDate", 14));
    UI.put("byArtist", ga.a.a("byArtist", 15, ic.class));
    UI.put("caption", ga.a.j("caption", 16));
    UI.put("contentSize", ga.a.j("contentSize", 17));
    UI.put("contentUrl", ga.a.j("contentUrl", 18));
    UI.put("contributor", ga.a.b("contributor", 19, ic.class));
    UI.put("dateCreated", ga.a.j("dateCreated", 20));
    UI.put("dateModified", ga.a.j("dateModified", 21));
    UI.put("datePublished", ga.a.j("datePublished", 22));
    UI.put("description", ga.a.j("description", 23));
    UI.put("duration", ga.a.j("duration", 24));
    UI.put("embedUrl", ga.a.j("embedUrl", 25));
    UI.put("endDate", ga.a.j("endDate", 26));
    UI.put("familyName", ga.a.j("familyName", 27));
    UI.put("gender", ga.a.j("gender", 28));
    UI.put("geo", ga.a.a("geo", 29, ic.class));
    UI.put("givenName", ga.a.j("givenName", 30));
    UI.put("height", ga.a.j("height", 31));
    UI.put("id", ga.a.j("id", 32));
    UI.put("image", ga.a.j("image", 33));
    UI.put("inAlbum", ga.a.a("inAlbum", 34, ic.class));
    UI.put("latitude", ga.a.h("latitude", 36));
    UI.put("location", ga.a.a("location", 37, ic.class));
    UI.put("longitude", ga.a.h("longitude", 38));
    UI.put("name", ga.a.j("name", 39));
    UI.put("partOfTVSeries", ga.a.a("partOfTVSeries", 40, ic.class));
    UI.put("performers", ga.a.b("performers", 41, ic.class));
    UI.put("playerType", ga.a.j("playerType", 42));
    UI.put("postOfficeBoxNumber", ga.a.j("postOfficeBoxNumber", 43));
    UI.put("postalCode", ga.a.j("postalCode", 44));
    UI.put("ratingValue", ga.a.j("ratingValue", 45));
    UI.put("reviewRating", ga.a.a("reviewRating", 46, ic.class));
    UI.put("startDate", ga.a.j("startDate", 47));
    UI.put("streetAddress", ga.a.j("streetAddress", 48));
    UI.put("text", ga.a.j("text", 49));
    UI.put("thumbnail", ga.a.a("thumbnail", 50, ic.class));
    UI.put("thumbnailUrl", ga.a.j("thumbnailUrl", 51));
    UI.put("tickerSymbol", ga.a.j("tickerSymbol", 52));
    UI.put("type", ga.a.j("type", 53));
    UI.put("url", ga.a.j("url", 54));
    UI.put("width", ga.a.j("width", 55));
    UI.put("worstRating", ga.a.j("worstRating", 56));
  }
  
  public ic()
  {
    this.xH = 1;
    this.UJ = new HashSet();
  }
  
  ic(Set<Integer> paramSet, int paramInt1, ic paramic1, List<String> paramList, ic paramic2, String paramString1, String paramString2, String paramString3, List<ic> paramList1, int paramInt2, List<ic> paramList2, ic paramic3, List<ic> paramList3, String paramString4, String paramString5, ic paramic4, String paramString6, String paramString7, String paramString8, List<ic> paramList4, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, ic paramic5, String paramString18, String paramString19, String paramString20, String paramString21, ic paramic6, double paramDouble1, ic paramic7, double paramDouble2, String paramString22, ic paramic8, List<ic> paramList5, String paramString23, String paramString24, String paramString25, String paramString26, ic paramic9, String paramString27, String paramString28, String paramString29, ic paramic10, String paramString30, String paramString31, String paramString32, String paramString33, String paramString34, String paramString35)
  {
    this.UJ = paramSet;
    this.xH = paramInt1;
    this.UK = paramic1;
    this.UL = paramList;
    this.UM = paramic2;
    this.UN = paramString1;
    this.UO = paramString2;
    this.UP = paramString3;
    this.UQ = paramList1;
    this.UR = paramInt2;
    this.US = paramList2;
    this.UT = paramic3;
    this.UU = paramList3;
    this.UV = paramString4;
    this.UW = paramString5;
    this.UX = paramic4;
    this.UY = paramString6;
    this.UZ = paramString7;
    this.lY = paramString8;
    this.Va = paramList4;
    this.Vb = paramString9;
    this.Vc = paramString10;
    this.Vd = paramString11;
    this.HD = paramString12;
    this.Ve = paramString13;
    this.Vf = paramString14;
    this.Vg = paramString15;
    this.Vh = paramString16;
    this.Vi = paramString17;
    this.Vj = paramic5;
    this.Vk = paramString18;
    this.Vl = paramString19;
    this.wp = paramString20;
    this.Vm = paramString21;
    this.Vn = paramic6;
    this.NX = paramDouble1;
    this.Vo = paramic7;
    this.NY = paramDouble2;
    this.mName = paramString22;
    this.Vp = paramic8;
    this.Vq = paramList5;
    this.Vr = paramString23;
    this.Vs = paramString24;
    this.Vt = paramString25;
    this.Vu = paramString26;
    this.Vv = paramic9;
    this.Vw = paramString27;
    this.Vx = paramString28;
    this.Vy = paramString29;
    this.Vz = paramic10;
    this.VA = paramString30;
    this.VB = paramString31;
    this.Rd = paramString32;
    this.ro = paramString33;
    this.VC = paramString34;
    this.VD = paramString35;
  }
  
  public ic(Set<Integer> paramSet, ic paramic1, List<String> paramList, ic paramic2, String paramString1, String paramString2, String paramString3, List<ic> paramList1, int paramInt, List<ic> paramList2, ic paramic3, List<ic> paramList3, String paramString4, String paramString5, ic paramic4, String paramString6, String paramString7, String paramString8, List<ic> paramList4, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, ic paramic5, String paramString18, String paramString19, String paramString20, String paramString21, ic paramic6, double paramDouble1, ic paramic7, double paramDouble2, String paramString22, ic paramic8, List<ic> paramList5, String paramString23, String paramString24, String paramString25, String paramString26, ic paramic9, String paramString27, String paramString28, String paramString29, ic paramic10, String paramString30, String paramString31, String paramString32, String paramString33, String paramString34, String paramString35)
  {
    this.UJ = paramSet;
    this.xH = 1;
    this.UK = paramic1;
    this.UL = paramList;
    this.UM = paramic2;
    this.UN = paramString1;
    this.UO = paramString2;
    this.UP = paramString3;
    this.UQ = paramList1;
    this.UR = paramInt;
    this.US = paramList2;
    this.UT = paramic3;
    this.UU = paramList3;
    this.UV = paramString4;
    this.UW = paramString5;
    this.UX = paramic4;
    this.UY = paramString6;
    this.UZ = paramString7;
    this.lY = paramString8;
    this.Va = paramList4;
    this.Vb = paramString9;
    this.Vc = paramString10;
    this.Vd = paramString11;
    this.HD = paramString12;
    this.Ve = paramString13;
    this.Vf = paramString14;
    this.Vg = paramString15;
    this.Vh = paramString16;
    this.Vi = paramString17;
    this.Vj = paramic5;
    this.Vk = paramString18;
    this.Vl = paramString19;
    this.wp = paramString20;
    this.Vm = paramString21;
    this.Vn = paramic6;
    this.NX = paramDouble1;
    this.Vo = paramic7;
    this.NY = paramDouble2;
    this.mName = paramString22;
    this.Vp = paramic8;
    this.Vq = paramList5;
    this.Vr = paramString23;
    this.Vs = paramString24;
    this.Vt = paramString25;
    this.Vu = paramString26;
    this.Vv = paramic9;
    this.Vw = paramString27;
    this.Vx = paramString28;
    this.Vy = paramString29;
    this.Vz = paramic10;
    this.VA = paramString30;
    this.VB = paramString31;
    this.Rd = paramString32;
    this.ro = paramString33;
    this.VC = paramString34;
    this.VD = paramString35;
  }
  
  protected boolean a(ga.a parama)
  {
    return this.UJ.contains(Integer.valueOf(parama.ff()));
  }
  
  protected Object aq(String paramString)
  {
    return null;
  }
  
  protected boolean ar(String paramString)
  {
    return false;
  }
  
  protected Object b(ga.a parama)
  {
    switch (parama.ff())
    {
    case 35: 
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + parama.ff());
    case 2: 
      return this.UK;
    case 3: 
      return this.UL;
    case 4: 
      return this.UM;
    case 5: 
      return this.UN;
    case 6: 
      return this.UO;
    case 7: 
      return this.UP;
    case 8: 
      return this.UQ;
    case 9: 
      return Integer.valueOf(this.UR);
    case 10: 
      return this.US;
    case 11: 
      return this.UT;
    case 12: 
      return this.UU;
    case 13: 
      return this.UV;
    case 14: 
      return this.UW;
    case 15: 
      return this.UX;
    case 16: 
      return this.UY;
    case 17: 
      return this.UZ;
    case 18: 
      return this.lY;
    case 19: 
      return this.Va;
    case 20: 
      return this.Vb;
    case 21: 
      return this.Vc;
    case 22: 
      return this.Vd;
    case 23: 
      return this.HD;
    case 24: 
      return this.Ve;
    case 25: 
      return this.Vf;
    case 26: 
      return this.Vg;
    case 27: 
      return this.Vh;
    case 28: 
      return this.Vi;
    case 29: 
      return this.Vj;
    case 30: 
      return this.Vk;
    case 31: 
      return this.Vl;
    case 32: 
      return this.wp;
    case 33: 
      return this.Vm;
    case 34: 
      return this.Vn;
    case 36: 
      return Double.valueOf(this.NX);
    case 37: 
      return this.Vo;
    case 38: 
      return Double.valueOf(this.NY);
    case 39: 
      return this.mName;
    case 40: 
      return this.Vp;
    case 41: 
      return this.Vq;
    case 42: 
      return this.Vr;
    case 43: 
      return this.Vs;
    case 44: 
      return this.Vt;
    case 45: 
      return this.Vu;
    case 46: 
      return this.Vv;
    case 47: 
      return this.Vw;
    case 48: 
      return this.Vx;
    case 49: 
      return this.Vy;
    case 50: 
      return this.Vz;
    case 51: 
      return this.VA;
    case 52: 
      return this.VB;
    case 53: 
      return this.Rd;
    case 54: 
      return this.ro;
    case 55: 
      return this.VC;
    }
    return this.VD;
  }
  
  public int describeContents()
  {
    id localid = CREATOR;
    return 0;
  }
  
  public HashMap<String, ga.a<?, ?>> eY()
  {
    return UI;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ic)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (ic)paramObject;
    Iterator localIterator = UI.values().iterator();
    while (localIterator.hasNext())
    {
      ga.a locala = (ga.a)localIterator.next();
      if (a(locala))
      {
        if (((ic)paramObject).a(locala))
        {
          if (!b(locala).equals(((ic)paramObject).b(locala))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((ic)paramObject).a(locala)) {
        return false;
      }
    }
    return true;
  }
  
  public ItemScope getAbout()
  {
    return this.UK;
  }
  
  public List<String> getAdditionalName()
  {
    return this.UL;
  }
  
  public ItemScope getAddress()
  {
    return this.UM;
  }
  
  public String getAddressCountry()
  {
    return this.UN;
  }
  
  public String getAddressLocality()
  {
    return this.UO;
  }
  
  public String getAddressRegion()
  {
    return this.UP;
  }
  
  public List<ItemScope> getAssociated_media()
  {
    return (ArrayList)this.UQ;
  }
  
  public int getAttendeeCount()
  {
    return this.UR;
  }
  
  public List<ItemScope> getAttendees()
  {
    return (ArrayList)this.US;
  }
  
  public ItemScope getAudio()
  {
    return this.UT;
  }
  
  public List<ItemScope> getAuthor()
  {
    return (ArrayList)this.UU;
  }
  
  public String getBestRating()
  {
    return this.UV;
  }
  
  public String getBirthDate()
  {
    return this.UW;
  }
  
  public ItemScope getByArtist()
  {
    return this.UX;
  }
  
  public String getCaption()
  {
    return this.UY;
  }
  
  public String getContentSize()
  {
    return this.UZ;
  }
  
  public String getContentUrl()
  {
    return this.lY;
  }
  
  public List<ItemScope> getContributor()
  {
    return (ArrayList)this.Va;
  }
  
  public String getDateCreated()
  {
    return this.Vb;
  }
  
  public String getDateModified()
  {
    return this.Vc;
  }
  
  public String getDatePublished()
  {
    return this.Vd;
  }
  
  public String getDescription()
  {
    return this.HD;
  }
  
  public String getDuration()
  {
    return this.Ve;
  }
  
  public String getEmbedUrl()
  {
    return this.Vf;
  }
  
  public String getEndDate()
  {
    return this.Vg;
  }
  
  public String getFamilyName()
  {
    return this.Vh;
  }
  
  public String getGender()
  {
    return this.Vi;
  }
  
  public ItemScope getGeo()
  {
    return this.Vj;
  }
  
  public String getGivenName()
  {
    return this.Vk;
  }
  
  public String getHeight()
  {
    return this.Vl;
  }
  
  public String getId()
  {
    return this.wp;
  }
  
  public String getImage()
  {
    return this.Vm;
  }
  
  public ItemScope getInAlbum()
  {
    return this.Vn;
  }
  
  public double getLatitude()
  {
    return this.NX;
  }
  
  public ItemScope getLocation()
  {
    return this.Vo;
  }
  
  public double getLongitude()
  {
    return this.NY;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public ItemScope getPartOfTVSeries()
  {
    return this.Vp;
  }
  
  public List<ItemScope> getPerformers()
  {
    return (ArrayList)this.Vq;
  }
  
  public String getPlayerType()
  {
    return this.Vr;
  }
  
  public String getPostOfficeBoxNumber()
  {
    return this.Vs;
  }
  
  public String getPostalCode()
  {
    return this.Vt;
  }
  
  public String getRatingValue()
  {
    return this.Vu;
  }
  
  public ItemScope getReviewRating()
  {
    return this.Vv;
  }
  
  public String getStartDate()
  {
    return this.Vw;
  }
  
  public String getStreetAddress()
  {
    return this.Vx;
  }
  
  public String getText()
  {
    return this.Vy;
  }
  
  public ItemScope getThumbnail()
  {
    return this.Vz;
  }
  
  public String getThumbnailUrl()
  {
    return this.VA;
  }
  
  public String getTickerSymbol()
  {
    return this.VB;
  }
  
  public String getType()
  {
    return this.Rd;
  }
  
  public String getUrl()
  {
    return this.ro;
  }
  
  int getVersionCode()
  {
    return this.xH;
  }
  
  public String getWidth()
  {
    return this.VC;
  }
  
  public String getWorstRating()
  {
    return this.VD;
  }
  
  public boolean hasAbout()
  {
    return this.UJ.contains(Integer.valueOf(2));
  }
  
  public boolean hasAdditionalName()
  {
    return this.UJ.contains(Integer.valueOf(3));
  }
  
  public boolean hasAddress()
  {
    return this.UJ.contains(Integer.valueOf(4));
  }
  
  public boolean hasAddressCountry()
  {
    return this.UJ.contains(Integer.valueOf(5));
  }
  
  public boolean hasAddressLocality()
  {
    return this.UJ.contains(Integer.valueOf(6));
  }
  
  public boolean hasAddressRegion()
  {
    return this.UJ.contains(Integer.valueOf(7));
  }
  
  public boolean hasAssociated_media()
  {
    return this.UJ.contains(Integer.valueOf(8));
  }
  
  public boolean hasAttendeeCount()
  {
    return this.UJ.contains(Integer.valueOf(9));
  }
  
  public boolean hasAttendees()
  {
    return this.UJ.contains(Integer.valueOf(10));
  }
  
  public boolean hasAudio()
  {
    return this.UJ.contains(Integer.valueOf(11));
  }
  
  public boolean hasAuthor()
  {
    return this.UJ.contains(Integer.valueOf(12));
  }
  
  public boolean hasBestRating()
  {
    return this.UJ.contains(Integer.valueOf(13));
  }
  
  public boolean hasBirthDate()
  {
    return this.UJ.contains(Integer.valueOf(14));
  }
  
  public boolean hasByArtist()
  {
    return this.UJ.contains(Integer.valueOf(15));
  }
  
  public boolean hasCaption()
  {
    return this.UJ.contains(Integer.valueOf(16));
  }
  
  public boolean hasContentSize()
  {
    return this.UJ.contains(Integer.valueOf(17));
  }
  
  public boolean hasContentUrl()
  {
    return this.UJ.contains(Integer.valueOf(18));
  }
  
  public boolean hasContributor()
  {
    return this.UJ.contains(Integer.valueOf(19));
  }
  
  public boolean hasDateCreated()
  {
    return this.UJ.contains(Integer.valueOf(20));
  }
  
  public boolean hasDateModified()
  {
    return this.UJ.contains(Integer.valueOf(21));
  }
  
  public boolean hasDatePublished()
  {
    return this.UJ.contains(Integer.valueOf(22));
  }
  
  public boolean hasDescription()
  {
    return this.UJ.contains(Integer.valueOf(23));
  }
  
  public boolean hasDuration()
  {
    return this.UJ.contains(Integer.valueOf(24));
  }
  
  public boolean hasEmbedUrl()
  {
    return this.UJ.contains(Integer.valueOf(25));
  }
  
  public boolean hasEndDate()
  {
    return this.UJ.contains(Integer.valueOf(26));
  }
  
  public boolean hasFamilyName()
  {
    return this.UJ.contains(Integer.valueOf(27));
  }
  
  public boolean hasGender()
  {
    return this.UJ.contains(Integer.valueOf(28));
  }
  
  public boolean hasGeo()
  {
    return this.UJ.contains(Integer.valueOf(29));
  }
  
  public boolean hasGivenName()
  {
    return this.UJ.contains(Integer.valueOf(30));
  }
  
  public boolean hasHeight()
  {
    return this.UJ.contains(Integer.valueOf(31));
  }
  
  public boolean hasId()
  {
    return this.UJ.contains(Integer.valueOf(32));
  }
  
  public boolean hasImage()
  {
    return this.UJ.contains(Integer.valueOf(33));
  }
  
  public boolean hasInAlbum()
  {
    return this.UJ.contains(Integer.valueOf(34));
  }
  
  public boolean hasLatitude()
  {
    return this.UJ.contains(Integer.valueOf(36));
  }
  
  public boolean hasLocation()
  {
    return this.UJ.contains(Integer.valueOf(37));
  }
  
  public boolean hasLongitude()
  {
    return this.UJ.contains(Integer.valueOf(38));
  }
  
  public boolean hasName()
  {
    return this.UJ.contains(Integer.valueOf(39));
  }
  
  public boolean hasPartOfTVSeries()
  {
    return this.UJ.contains(Integer.valueOf(40));
  }
  
  public boolean hasPerformers()
  {
    return this.UJ.contains(Integer.valueOf(41));
  }
  
  public boolean hasPlayerType()
  {
    return this.UJ.contains(Integer.valueOf(42));
  }
  
  public boolean hasPostOfficeBoxNumber()
  {
    return this.UJ.contains(Integer.valueOf(43));
  }
  
  public boolean hasPostalCode()
  {
    return this.UJ.contains(Integer.valueOf(44));
  }
  
  public boolean hasRatingValue()
  {
    return this.UJ.contains(Integer.valueOf(45));
  }
  
  public boolean hasReviewRating()
  {
    return this.UJ.contains(Integer.valueOf(46));
  }
  
  public boolean hasStartDate()
  {
    return this.UJ.contains(Integer.valueOf(47));
  }
  
  public boolean hasStreetAddress()
  {
    return this.UJ.contains(Integer.valueOf(48));
  }
  
  public boolean hasText()
  {
    return this.UJ.contains(Integer.valueOf(49));
  }
  
  public boolean hasThumbnail()
  {
    return this.UJ.contains(Integer.valueOf(50));
  }
  
  public boolean hasThumbnailUrl()
  {
    return this.UJ.contains(Integer.valueOf(51));
  }
  
  public boolean hasTickerSymbol()
  {
    return this.UJ.contains(Integer.valueOf(52));
  }
  
  public boolean hasType()
  {
    return this.UJ.contains(Integer.valueOf(53));
  }
  
  public boolean hasUrl()
  {
    return this.UJ.contains(Integer.valueOf(54));
  }
  
  public boolean hasWidth()
  {
    return this.UJ.contains(Integer.valueOf(55));
  }
  
  public boolean hasWorstRating()
  {
    return this.UJ.contains(Integer.valueOf(56));
  }
  
  public int hashCode()
  {
    Iterator localIterator = UI.values().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      ga.a locala = (ga.a)localIterator.next();
      if (!a(locala)) {
        break label68;
      }
      int j = locala.ff();
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
  
  Set<Integer> ja()
  {
    return this.UJ;
  }
  
  ic jb()
  {
    return this.UK;
  }
  
  ic jc()
  {
    return this.UM;
  }
  
  List<ic> jd()
  {
    return this.UQ;
  }
  
  List<ic> je()
  {
    return this.US;
  }
  
  ic jf()
  {
    return this.UT;
  }
  
  List<ic> jg()
  {
    return this.UU;
  }
  
  ic jh()
  {
    return this.UX;
  }
  
  List<ic> ji()
  {
    return this.Va;
  }
  
  ic jj()
  {
    return this.Vj;
  }
  
  ic jk()
  {
    return this.Vn;
  }
  
  ic jl()
  {
    return this.Vo;
  }
  
  ic jm()
  {
    return this.Vp;
  }
  
  List<ic> jn()
  {
    return this.Vq;
  }
  
  ic jo()
  {
    return this.Vv;
  }
  
  ic jp()
  {
    return this.Vz;
  }
  
  public ic jq()
  {
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    id localid = CREATOR;
    id.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/ic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */