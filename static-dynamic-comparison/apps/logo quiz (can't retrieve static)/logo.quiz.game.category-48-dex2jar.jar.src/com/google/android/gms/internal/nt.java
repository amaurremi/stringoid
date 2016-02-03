package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class nt
  extends jj
  implements ItemScope
{
  public static final nu CREATOR = new nu();
  private static final HashMap<String, ji.a<?, ?>> alQ = new HashMap();
  String BL;
  final int BR;
  String Tg;
  double adZ;
  double aea;
  final Set<Integer> alR;
  nt alS;
  List<String> alT;
  nt alU;
  String alV;
  String alW;
  String alX;
  List<nt> alY;
  int alZ;
  String amA;
  String amB;
  String amC;
  nt amD;
  String amE;
  String amF;
  String amG;
  nt amH;
  String amI;
  String amJ;
  String amK;
  String amL;
  List<nt> ama;
  nt amb;
  List<nt> amc;
  String amd;
  String ame;
  nt amf;
  String amg;
  String amh;
  List<nt> ami;
  String amj;
  String amk;
  String aml;
  String amm;
  String amn;
  String amo;
  String amp;
  String amq;
  nt amr;
  String ams;
  String amt;
  String amu;
  nt amv;
  nt amw;
  nt amx;
  List<nt> amy;
  String amz;
  String mName;
  String ol;
  String uO;
  String uR;
  
  static
  {
    alQ.put("about", ji.a.a("about", 2, nt.class));
    alQ.put("additionalName", ji.a.m("additionalName", 3));
    alQ.put("address", ji.a.a("address", 4, nt.class));
    alQ.put("addressCountry", ji.a.l("addressCountry", 5));
    alQ.put("addressLocality", ji.a.l("addressLocality", 6));
    alQ.put("addressRegion", ji.a.l("addressRegion", 7));
    alQ.put("associated_media", ji.a.b("associated_media", 8, nt.class));
    alQ.put("attendeeCount", ji.a.i("attendeeCount", 9));
    alQ.put("attendees", ji.a.b("attendees", 10, nt.class));
    alQ.put("audio", ji.a.a("audio", 11, nt.class));
    alQ.put("author", ji.a.b("author", 12, nt.class));
    alQ.put("bestRating", ji.a.l("bestRating", 13));
    alQ.put("birthDate", ji.a.l("birthDate", 14));
    alQ.put("byArtist", ji.a.a("byArtist", 15, nt.class));
    alQ.put("caption", ji.a.l("caption", 16));
    alQ.put("contentSize", ji.a.l("contentSize", 17));
    alQ.put("contentUrl", ji.a.l("contentUrl", 18));
    alQ.put("contributor", ji.a.b("contributor", 19, nt.class));
    alQ.put("dateCreated", ji.a.l("dateCreated", 20));
    alQ.put("dateModified", ji.a.l("dateModified", 21));
    alQ.put("datePublished", ji.a.l("datePublished", 22));
    alQ.put("description", ji.a.l("description", 23));
    alQ.put("duration", ji.a.l("duration", 24));
    alQ.put("embedUrl", ji.a.l("embedUrl", 25));
    alQ.put("endDate", ji.a.l("endDate", 26));
    alQ.put("familyName", ji.a.l("familyName", 27));
    alQ.put("gender", ji.a.l("gender", 28));
    alQ.put("geo", ji.a.a("geo", 29, nt.class));
    alQ.put("givenName", ji.a.l("givenName", 30));
    alQ.put("height", ji.a.l("height", 31));
    alQ.put("id", ji.a.l("id", 32));
    alQ.put("image", ji.a.l("image", 33));
    alQ.put("inAlbum", ji.a.a("inAlbum", 34, nt.class));
    alQ.put("latitude", ji.a.j("latitude", 36));
    alQ.put("location", ji.a.a("location", 37, nt.class));
    alQ.put("longitude", ji.a.j("longitude", 38));
    alQ.put("name", ji.a.l("name", 39));
    alQ.put("partOfTVSeries", ji.a.a("partOfTVSeries", 40, nt.class));
    alQ.put("performers", ji.a.b("performers", 41, nt.class));
    alQ.put("playerType", ji.a.l("playerType", 42));
    alQ.put("postOfficeBoxNumber", ji.a.l("postOfficeBoxNumber", 43));
    alQ.put("postalCode", ji.a.l("postalCode", 44));
    alQ.put("ratingValue", ji.a.l("ratingValue", 45));
    alQ.put("reviewRating", ji.a.a("reviewRating", 46, nt.class));
    alQ.put("startDate", ji.a.l("startDate", 47));
    alQ.put("streetAddress", ji.a.l("streetAddress", 48));
    alQ.put("text", ji.a.l("text", 49));
    alQ.put("thumbnail", ji.a.a("thumbnail", 50, nt.class));
    alQ.put("thumbnailUrl", ji.a.l("thumbnailUrl", 51));
    alQ.put("tickerSymbol", ji.a.l("tickerSymbol", 52));
    alQ.put("type", ji.a.l("type", 53));
    alQ.put("url", ji.a.l("url", 54));
    alQ.put("width", ji.a.l("width", 55));
    alQ.put("worstRating", ji.a.l("worstRating", 56));
  }
  
  public nt()
  {
    this.BR = 1;
    this.alR = new HashSet();
  }
  
  nt(Set<Integer> paramSet, int paramInt1, nt paramnt1, List<String> paramList, nt paramnt2, String paramString1, String paramString2, String paramString3, List<nt> paramList1, int paramInt2, List<nt> paramList2, nt paramnt3, List<nt> paramList3, String paramString4, String paramString5, nt paramnt4, String paramString6, String paramString7, String paramString8, List<nt> paramList4, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, nt paramnt5, String paramString18, String paramString19, String paramString20, String paramString21, nt paramnt6, double paramDouble1, nt paramnt7, double paramDouble2, String paramString22, nt paramnt8, List<nt> paramList5, String paramString23, String paramString24, String paramString25, String paramString26, nt paramnt9, String paramString27, String paramString28, String paramString29, nt paramnt10, String paramString30, String paramString31, String paramString32, String paramString33, String paramString34, String paramString35)
  {
    this.alR = paramSet;
    this.BR = paramInt1;
    this.alS = paramnt1;
    this.alT = paramList;
    this.alU = paramnt2;
    this.alV = paramString1;
    this.alW = paramString2;
    this.alX = paramString3;
    this.alY = paramList1;
    this.alZ = paramInt2;
    this.ama = paramList2;
    this.amb = paramnt3;
    this.amc = paramList3;
    this.amd = paramString4;
    this.ame = paramString5;
    this.amf = paramnt4;
    this.amg = paramString6;
    this.amh = paramString7;
    this.ol = paramString8;
    this.ami = paramList4;
    this.amj = paramString9;
    this.amk = paramString10;
    this.aml = paramString11;
    this.Tg = paramString12;
    this.amm = paramString13;
    this.amn = paramString14;
    this.amo = paramString15;
    this.amp = paramString16;
    this.amq = paramString17;
    this.amr = paramnt5;
    this.ams = paramString18;
    this.amt = paramString19;
    this.BL = paramString20;
    this.amu = paramString21;
    this.amv = paramnt6;
    this.adZ = paramDouble1;
    this.amw = paramnt7;
    this.aea = paramDouble2;
    this.mName = paramString22;
    this.amx = paramnt8;
    this.amy = paramList5;
    this.amz = paramString23;
    this.amA = paramString24;
    this.amB = paramString25;
    this.amC = paramString26;
    this.amD = paramnt9;
    this.amE = paramString27;
    this.amF = paramString28;
    this.amG = paramString29;
    this.amH = paramnt10;
    this.amI = paramString30;
    this.amJ = paramString31;
    this.uO = paramString32;
    this.uR = paramString33;
    this.amK = paramString34;
    this.amL = paramString35;
  }
  
  public nt(Set<Integer> paramSet, nt paramnt1, List<String> paramList, nt paramnt2, String paramString1, String paramString2, String paramString3, List<nt> paramList1, int paramInt, List<nt> paramList2, nt paramnt3, List<nt> paramList3, String paramString4, String paramString5, nt paramnt4, String paramString6, String paramString7, String paramString8, List<nt> paramList4, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, nt paramnt5, String paramString18, String paramString19, String paramString20, String paramString21, nt paramnt6, double paramDouble1, nt paramnt7, double paramDouble2, String paramString22, nt paramnt8, List<nt> paramList5, String paramString23, String paramString24, String paramString25, String paramString26, nt paramnt9, String paramString27, String paramString28, String paramString29, nt paramnt10, String paramString30, String paramString31, String paramString32, String paramString33, String paramString34, String paramString35)
  {
    this.alR = paramSet;
    this.BR = 1;
    this.alS = paramnt1;
    this.alT = paramList;
    this.alU = paramnt2;
    this.alV = paramString1;
    this.alW = paramString2;
    this.alX = paramString3;
    this.alY = paramList1;
    this.alZ = paramInt;
    this.ama = paramList2;
    this.amb = paramnt3;
    this.amc = paramList3;
    this.amd = paramString4;
    this.ame = paramString5;
    this.amf = paramnt4;
    this.amg = paramString6;
    this.amh = paramString7;
    this.ol = paramString8;
    this.ami = paramList4;
    this.amj = paramString9;
    this.amk = paramString10;
    this.aml = paramString11;
    this.Tg = paramString12;
    this.amm = paramString13;
    this.amn = paramString14;
    this.amo = paramString15;
    this.amp = paramString16;
    this.amq = paramString17;
    this.amr = paramnt5;
    this.ams = paramString18;
    this.amt = paramString19;
    this.BL = paramString20;
    this.amu = paramString21;
    this.amv = paramnt6;
    this.adZ = paramDouble1;
    this.amw = paramnt7;
    this.aea = paramDouble2;
    this.mName = paramString22;
    this.amx = paramnt8;
    this.amy = paramList5;
    this.amz = paramString23;
    this.amA = paramString24;
    this.amB = paramString25;
    this.amC = paramString26;
    this.amD = paramnt9;
    this.amE = paramString27;
    this.amF = paramString28;
    this.amG = paramString29;
    this.amH = paramnt10;
    this.amI = paramString30;
    this.amJ = paramString31;
    this.uO = paramString32;
    this.uR = paramString33;
    this.amK = paramString34;
    this.amL = paramString35;
  }
  
  protected boolean a(ji.a parama)
  {
    return this.alR.contains(Integer.valueOf(parama.hm()));
  }
  
  protected Object b(ji.a parama)
  {
    switch (parama.hm())
    {
    case 35: 
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + parama.hm());
    case 2: 
      return this.alS;
    case 3: 
      return this.alT;
    case 4: 
      return this.alU;
    case 5: 
      return this.alV;
    case 6: 
      return this.alW;
    case 7: 
      return this.alX;
    case 8: 
      return this.alY;
    case 9: 
      return Integer.valueOf(this.alZ);
    case 10: 
      return this.ama;
    case 11: 
      return this.amb;
    case 12: 
      return this.amc;
    case 13: 
      return this.amd;
    case 14: 
      return this.ame;
    case 15: 
      return this.amf;
    case 16: 
      return this.amg;
    case 17: 
      return this.amh;
    case 18: 
      return this.ol;
    case 19: 
      return this.ami;
    case 20: 
      return this.amj;
    case 21: 
      return this.amk;
    case 22: 
      return this.aml;
    case 23: 
      return this.Tg;
    case 24: 
      return this.amm;
    case 25: 
      return this.amn;
    case 26: 
      return this.amo;
    case 27: 
      return this.amp;
    case 28: 
      return this.amq;
    case 29: 
      return this.amr;
    case 30: 
      return this.ams;
    case 31: 
      return this.amt;
    case 32: 
      return this.BL;
    case 33: 
      return this.amu;
    case 34: 
      return this.amv;
    case 36: 
      return Double.valueOf(this.adZ);
    case 37: 
      return this.amw;
    case 38: 
      return Double.valueOf(this.aea);
    case 39: 
      return this.mName;
    case 40: 
      return this.amx;
    case 41: 
      return this.amy;
    case 42: 
      return this.amz;
    case 43: 
      return this.amA;
    case 44: 
      return this.amB;
    case 45: 
      return this.amC;
    case 46: 
      return this.amD;
    case 47: 
      return this.amE;
    case 48: 
      return this.amF;
    case 49: 
      return this.amG;
    case 50: 
      return this.amH;
    case 51: 
      return this.amI;
    case 52: 
      return this.amJ;
    case 53: 
      return this.uO;
    case 54: 
      return this.uR;
    case 55: 
      return this.amK;
    }
    return this.amL;
  }
  
  public int describeContents()
  {
    nu localnu = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof nt)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (nt)paramObject;
    Iterator localIterator = alQ.values().iterator();
    while (localIterator.hasNext())
    {
      ji.a locala = (ji.a)localIterator.next();
      if (a(locala))
      {
        if (((nt)paramObject).a(locala))
        {
          if (!b(locala).equals(((nt)paramObject).b(locala))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((nt)paramObject).a(locala)) {
        return false;
      }
    }
    return true;
  }
  
  public ItemScope getAbout()
  {
    return this.alS;
  }
  
  public List<String> getAdditionalName()
  {
    return this.alT;
  }
  
  public ItemScope getAddress()
  {
    return this.alU;
  }
  
  public String getAddressCountry()
  {
    return this.alV;
  }
  
  public String getAddressLocality()
  {
    return this.alW;
  }
  
  public String getAddressRegion()
  {
    return this.alX;
  }
  
  public List<ItemScope> getAssociated_media()
  {
    return (ArrayList)this.alY;
  }
  
  public int getAttendeeCount()
  {
    return this.alZ;
  }
  
  public List<ItemScope> getAttendees()
  {
    return (ArrayList)this.ama;
  }
  
  public ItemScope getAudio()
  {
    return this.amb;
  }
  
  public List<ItemScope> getAuthor()
  {
    return (ArrayList)this.amc;
  }
  
  public String getBestRating()
  {
    return this.amd;
  }
  
  public String getBirthDate()
  {
    return this.ame;
  }
  
  public ItemScope getByArtist()
  {
    return this.amf;
  }
  
  public String getCaption()
  {
    return this.amg;
  }
  
  public String getContentSize()
  {
    return this.amh;
  }
  
  public String getContentUrl()
  {
    return this.ol;
  }
  
  public List<ItemScope> getContributor()
  {
    return (ArrayList)this.ami;
  }
  
  public String getDateCreated()
  {
    return this.amj;
  }
  
  public String getDateModified()
  {
    return this.amk;
  }
  
  public String getDatePublished()
  {
    return this.aml;
  }
  
  public String getDescription()
  {
    return this.Tg;
  }
  
  public String getDuration()
  {
    return this.amm;
  }
  
  public String getEmbedUrl()
  {
    return this.amn;
  }
  
  public String getEndDate()
  {
    return this.amo;
  }
  
  public String getFamilyName()
  {
    return this.amp;
  }
  
  public String getGender()
  {
    return this.amq;
  }
  
  public ItemScope getGeo()
  {
    return this.amr;
  }
  
  public String getGivenName()
  {
    return this.ams;
  }
  
  public String getHeight()
  {
    return this.amt;
  }
  
  public String getId()
  {
    return this.BL;
  }
  
  public String getImage()
  {
    return this.amu;
  }
  
  public ItemScope getInAlbum()
  {
    return this.amv;
  }
  
  public double getLatitude()
  {
    return this.adZ;
  }
  
  public ItemScope getLocation()
  {
    return this.amw;
  }
  
  public double getLongitude()
  {
    return this.aea;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public ItemScope getPartOfTVSeries()
  {
    return this.amx;
  }
  
  public List<ItemScope> getPerformers()
  {
    return (ArrayList)this.amy;
  }
  
  public String getPlayerType()
  {
    return this.amz;
  }
  
  public String getPostOfficeBoxNumber()
  {
    return this.amA;
  }
  
  public String getPostalCode()
  {
    return this.amB;
  }
  
  public String getRatingValue()
  {
    return this.amC;
  }
  
  public ItemScope getReviewRating()
  {
    return this.amD;
  }
  
  public String getStartDate()
  {
    return this.amE;
  }
  
  public String getStreetAddress()
  {
    return this.amF;
  }
  
  public String getText()
  {
    return this.amG;
  }
  
  public ItemScope getThumbnail()
  {
    return this.amH;
  }
  
  public String getThumbnailUrl()
  {
    return this.amI;
  }
  
  public String getTickerSymbol()
  {
    return this.amJ;
  }
  
  public String getType()
  {
    return this.uO;
  }
  
  public String getUrl()
  {
    return this.uR;
  }
  
  public String getWidth()
  {
    return this.amK;
  }
  
  public String getWorstRating()
  {
    return this.amL;
  }
  
  public boolean hasAbout()
  {
    return this.alR.contains(Integer.valueOf(2));
  }
  
  public boolean hasAdditionalName()
  {
    return this.alR.contains(Integer.valueOf(3));
  }
  
  public boolean hasAddress()
  {
    return this.alR.contains(Integer.valueOf(4));
  }
  
  public boolean hasAddressCountry()
  {
    return this.alR.contains(Integer.valueOf(5));
  }
  
  public boolean hasAddressLocality()
  {
    return this.alR.contains(Integer.valueOf(6));
  }
  
  public boolean hasAddressRegion()
  {
    return this.alR.contains(Integer.valueOf(7));
  }
  
  public boolean hasAssociated_media()
  {
    return this.alR.contains(Integer.valueOf(8));
  }
  
  public boolean hasAttendeeCount()
  {
    return this.alR.contains(Integer.valueOf(9));
  }
  
  public boolean hasAttendees()
  {
    return this.alR.contains(Integer.valueOf(10));
  }
  
  public boolean hasAudio()
  {
    return this.alR.contains(Integer.valueOf(11));
  }
  
  public boolean hasAuthor()
  {
    return this.alR.contains(Integer.valueOf(12));
  }
  
  public boolean hasBestRating()
  {
    return this.alR.contains(Integer.valueOf(13));
  }
  
  public boolean hasBirthDate()
  {
    return this.alR.contains(Integer.valueOf(14));
  }
  
  public boolean hasByArtist()
  {
    return this.alR.contains(Integer.valueOf(15));
  }
  
  public boolean hasCaption()
  {
    return this.alR.contains(Integer.valueOf(16));
  }
  
  public boolean hasContentSize()
  {
    return this.alR.contains(Integer.valueOf(17));
  }
  
  public boolean hasContentUrl()
  {
    return this.alR.contains(Integer.valueOf(18));
  }
  
  public boolean hasContributor()
  {
    return this.alR.contains(Integer.valueOf(19));
  }
  
  public boolean hasDateCreated()
  {
    return this.alR.contains(Integer.valueOf(20));
  }
  
  public boolean hasDateModified()
  {
    return this.alR.contains(Integer.valueOf(21));
  }
  
  public boolean hasDatePublished()
  {
    return this.alR.contains(Integer.valueOf(22));
  }
  
  public boolean hasDescription()
  {
    return this.alR.contains(Integer.valueOf(23));
  }
  
  public boolean hasDuration()
  {
    return this.alR.contains(Integer.valueOf(24));
  }
  
  public boolean hasEmbedUrl()
  {
    return this.alR.contains(Integer.valueOf(25));
  }
  
  public boolean hasEndDate()
  {
    return this.alR.contains(Integer.valueOf(26));
  }
  
  public boolean hasFamilyName()
  {
    return this.alR.contains(Integer.valueOf(27));
  }
  
  public boolean hasGender()
  {
    return this.alR.contains(Integer.valueOf(28));
  }
  
  public boolean hasGeo()
  {
    return this.alR.contains(Integer.valueOf(29));
  }
  
  public boolean hasGivenName()
  {
    return this.alR.contains(Integer.valueOf(30));
  }
  
  public boolean hasHeight()
  {
    return this.alR.contains(Integer.valueOf(31));
  }
  
  public boolean hasId()
  {
    return this.alR.contains(Integer.valueOf(32));
  }
  
  public boolean hasImage()
  {
    return this.alR.contains(Integer.valueOf(33));
  }
  
  public boolean hasInAlbum()
  {
    return this.alR.contains(Integer.valueOf(34));
  }
  
  public boolean hasLatitude()
  {
    return this.alR.contains(Integer.valueOf(36));
  }
  
  public boolean hasLocation()
  {
    return this.alR.contains(Integer.valueOf(37));
  }
  
  public boolean hasLongitude()
  {
    return this.alR.contains(Integer.valueOf(38));
  }
  
  public boolean hasName()
  {
    return this.alR.contains(Integer.valueOf(39));
  }
  
  public boolean hasPartOfTVSeries()
  {
    return this.alR.contains(Integer.valueOf(40));
  }
  
  public boolean hasPerformers()
  {
    return this.alR.contains(Integer.valueOf(41));
  }
  
  public boolean hasPlayerType()
  {
    return this.alR.contains(Integer.valueOf(42));
  }
  
  public boolean hasPostOfficeBoxNumber()
  {
    return this.alR.contains(Integer.valueOf(43));
  }
  
  public boolean hasPostalCode()
  {
    return this.alR.contains(Integer.valueOf(44));
  }
  
  public boolean hasRatingValue()
  {
    return this.alR.contains(Integer.valueOf(45));
  }
  
  public boolean hasReviewRating()
  {
    return this.alR.contains(Integer.valueOf(46));
  }
  
  public boolean hasStartDate()
  {
    return this.alR.contains(Integer.valueOf(47));
  }
  
  public boolean hasStreetAddress()
  {
    return this.alR.contains(Integer.valueOf(48));
  }
  
  public boolean hasText()
  {
    return this.alR.contains(Integer.valueOf(49));
  }
  
  public boolean hasThumbnail()
  {
    return this.alR.contains(Integer.valueOf(50));
  }
  
  public boolean hasThumbnailUrl()
  {
    return this.alR.contains(Integer.valueOf(51));
  }
  
  public boolean hasTickerSymbol()
  {
    return this.alR.contains(Integer.valueOf(52));
  }
  
  public boolean hasType()
  {
    return this.alR.contains(Integer.valueOf(53));
  }
  
  public boolean hasUrl()
  {
    return this.alR.contains(Integer.valueOf(54));
  }
  
  public boolean hasWidth()
  {
    return this.alR.contains(Integer.valueOf(55));
  }
  
  public boolean hasWorstRating()
  {
    return this.alR.contains(Integer.valueOf(56));
  }
  
  public int hashCode()
  {
    Iterator localIterator = alQ.values().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      ji.a locala = (ji.a)localIterator.next();
      if (!a(locala)) {
        break label68;
      }
      int j = locala.hm();
      i = b(locala).hashCode() + (i + j);
    }
    label68:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public HashMap<String, ji.a<?, ?>> hf()
  {
    return alQ;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public nt np()
  {
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    nu localnu = CREATOR;
    nu.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/nt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */