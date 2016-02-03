package com.google.android.gms.plus.model.moments;

import com.google.android.gms.internal.kn;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ItemScope$Builder
{
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
  private final Set<Integer> acs = new HashSet();
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
  
  public ItemScope build()
  {
    return new kn(this.acs, this.act, this.acu, this.acv, this.acw, this.acx, this.acy, this.acz, this.acA, this.acB, this.acC, this.acD, this.acE, this.acF, this.acG, this.acH, this.acI, this.mk, this.acJ, this.acK, this.acL, this.acM, this.Mp, this.acN, this.acO, this.acP, this.acQ, this.acR, this.acS, this.acT, this.acU, this.xG, this.acV, this.acW, this.Vd, this.acX, this.Ve, this.mName, this.acY, this.acZ, this.ada, this.adb, this.adc, this.add, this.ade, this.adf, this.adg, this.adh, this.adi, this.adj, this.adk, this.qX, this.qY, this.adl, this.adm);
  }
  
  public Builder setAbout(ItemScope paramItemScope)
  {
    this.act = ((kn)paramItemScope);
    this.acs.add(Integer.valueOf(2));
    return this;
  }
  
  public Builder setAdditionalName(List<String> paramList)
  {
    this.acu = paramList;
    this.acs.add(Integer.valueOf(3));
    return this;
  }
  
  public Builder setAddress(ItemScope paramItemScope)
  {
    this.acv = ((kn)paramItemScope);
    this.acs.add(Integer.valueOf(4));
    return this;
  }
  
  public Builder setAddressCountry(String paramString)
  {
    this.acw = paramString;
    this.acs.add(Integer.valueOf(5));
    return this;
  }
  
  public Builder setAddressLocality(String paramString)
  {
    this.acx = paramString;
    this.acs.add(Integer.valueOf(6));
    return this;
  }
  
  public Builder setAddressRegion(String paramString)
  {
    this.acy = paramString;
    this.acs.add(Integer.valueOf(7));
    return this;
  }
  
  public Builder setAssociated_media(List<ItemScope> paramList)
  {
    this.acz = paramList;
    this.acs.add(Integer.valueOf(8));
    return this;
  }
  
  public Builder setAttendeeCount(int paramInt)
  {
    this.acA = paramInt;
    this.acs.add(Integer.valueOf(9));
    return this;
  }
  
  public Builder setAttendees(List<ItemScope> paramList)
  {
    this.acB = paramList;
    this.acs.add(Integer.valueOf(10));
    return this;
  }
  
  public Builder setAudio(ItemScope paramItemScope)
  {
    this.acC = ((kn)paramItemScope);
    this.acs.add(Integer.valueOf(11));
    return this;
  }
  
  public Builder setAuthor(List<ItemScope> paramList)
  {
    this.acD = paramList;
    this.acs.add(Integer.valueOf(12));
    return this;
  }
  
  public Builder setBestRating(String paramString)
  {
    this.acE = paramString;
    this.acs.add(Integer.valueOf(13));
    return this;
  }
  
  public Builder setBirthDate(String paramString)
  {
    this.acF = paramString;
    this.acs.add(Integer.valueOf(14));
    return this;
  }
  
  public Builder setByArtist(ItemScope paramItemScope)
  {
    this.acG = ((kn)paramItemScope);
    this.acs.add(Integer.valueOf(15));
    return this;
  }
  
  public Builder setCaption(String paramString)
  {
    this.acH = paramString;
    this.acs.add(Integer.valueOf(16));
    return this;
  }
  
  public Builder setContentSize(String paramString)
  {
    this.acI = paramString;
    this.acs.add(Integer.valueOf(17));
    return this;
  }
  
  public Builder setContentUrl(String paramString)
  {
    this.mk = paramString;
    this.acs.add(Integer.valueOf(18));
    return this;
  }
  
  public Builder setContributor(List<ItemScope> paramList)
  {
    this.acJ = paramList;
    this.acs.add(Integer.valueOf(19));
    return this;
  }
  
  public Builder setDateCreated(String paramString)
  {
    this.acK = paramString;
    this.acs.add(Integer.valueOf(20));
    return this;
  }
  
  public Builder setDateModified(String paramString)
  {
    this.acL = paramString;
    this.acs.add(Integer.valueOf(21));
    return this;
  }
  
  public Builder setDatePublished(String paramString)
  {
    this.acM = paramString;
    this.acs.add(Integer.valueOf(22));
    return this;
  }
  
  public Builder setDescription(String paramString)
  {
    this.Mp = paramString;
    this.acs.add(Integer.valueOf(23));
    return this;
  }
  
  public Builder setDuration(String paramString)
  {
    this.acN = paramString;
    this.acs.add(Integer.valueOf(24));
    return this;
  }
  
  public Builder setEmbedUrl(String paramString)
  {
    this.acO = paramString;
    this.acs.add(Integer.valueOf(25));
    return this;
  }
  
  public Builder setEndDate(String paramString)
  {
    this.acP = paramString;
    this.acs.add(Integer.valueOf(26));
    return this;
  }
  
  public Builder setFamilyName(String paramString)
  {
    this.acQ = paramString;
    this.acs.add(Integer.valueOf(27));
    return this;
  }
  
  public Builder setGender(String paramString)
  {
    this.acR = paramString;
    this.acs.add(Integer.valueOf(28));
    return this;
  }
  
  public Builder setGeo(ItemScope paramItemScope)
  {
    this.acS = ((kn)paramItemScope);
    this.acs.add(Integer.valueOf(29));
    return this;
  }
  
  public Builder setGivenName(String paramString)
  {
    this.acT = paramString;
    this.acs.add(Integer.valueOf(30));
    return this;
  }
  
  public Builder setHeight(String paramString)
  {
    this.acU = paramString;
    this.acs.add(Integer.valueOf(31));
    return this;
  }
  
  public Builder setId(String paramString)
  {
    this.xG = paramString;
    this.acs.add(Integer.valueOf(32));
    return this;
  }
  
  public Builder setImage(String paramString)
  {
    this.acV = paramString;
    this.acs.add(Integer.valueOf(33));
    return this;
  }
  
  public Builder setInAlbum(ItemScope paramItemScope)
  {
    this.acW = ((kn)paramItemScope);
    this.acs.add(Integer.valueOf(34));
    return this;
  }
  
  public Builder setLatitude(double paramDouble)
  {
    this.Vd = paramDouble;
    this.acs.add(Integer.valueOf(36));
    return this;
  }
  
  public Builder setLocation(ItemScope paramItemScope)
  {
    this.acX = ((kn)paramItemScope);
    this.acs.add(Integer.valueOf(37));
    return this;
  }
  
  public Builder setLongitude(double paramDouble)
  {
    this.Ve = paramDouble;
    this.acs.add(Integer.valueOf(38));
    return this;
  }
  
  public Builder setName(String paramString)
  {
    this.mName = paramString;
    this.acs.add(Integer.valueOf(39));
    return this;
  }
  
  public Builder setPartOfTVSeries(ItemScope paramItemScope)
  {
    this.acY = ((kn)paramItemScope);
    this.acs.add(Integer.valueOf(40));
    return this;
  }
  
  public Builder setPerformers(List<ItemScope> paramList)
  {
    this.acZ = paramList;
    this.acs.add(Integer.valueOf(41));
    return this;
  }
  
  public Builder setPlayerType(String paramString)
  {
    this.ada = paramString;
    this.acs.add(Integer.valueOf(42));
    return this;
  }
  
  public Builder setPostOfficeBoxNumber(String paramString)
  {
    this.adb = paramString;
    this.acs.add(Integer.valueOf(43));
    return this;
  }
  
  public Builder setPostalCode(String paramString)
  {
    this.adc = paramString;
    this.acs.add(Integer.valueOf(44));
    return this;
  }
  
  public Builder setRatingValue(String paramString)
  {
    this.add = paramString;
    this.acs.add(Integer.valueOf(45));
    return this;
  }
  
  public Builder setReviewRating(ItemScope paramItemScope)
  {
    this.ade = ((kn)paramItemScope);
    this.acs.add(Integer.valueOf(46));
    return this;
  }
  
  public Builder setStartDate(String paramString)
  {
    this.adf = paramString;
    this.acs.add(Integer.valueOf(47));
    return this;
  }
  
  public Builder setStreetAddress(String paramString)
  {
    this.adg = paramString;
    this.acs.add(Integer.valueOf(48));
    return this;
  }
  
  public Builder setText(String paramString)
  {
    this.adh = paramString;
    this.acs.add(Integer.valueOf(49));
    return this;
  }
  
  public Builder setThumbnail(ItemScope paramItemScope)
  {
    this.adi = ((kn)paramItemScope);
    this.acs.add(Integer.valueOf(50));
    return this;
  }
  
  public Builder setThumbnailUrl(String paramString)
  {
    this.adj = paramString;
    this.acs.add(Integer.valueOf(51));
    return this;
  }
  
  public Builder setTickerSymbol(String paramString)
  {
    this.adk = paramString;
    this.acs.add(Integer.valueOf(52));
    return this;
  }
  
  public Builder setType(String paramString)
  {
    this.qX = paramString;
    this.acs.add(Integer.valueOf(53));
    return this;
  }
  
  public Builder setUrl(String paramString)
  {
    this.qY = paramString;
    this.acs.add(Integer.valueOf(54));
    return this;
  }
  
  public Builder setWidth(String paramString)
  {
    this.adl = paramString;
    this.acs.add(Integer.valueOf(55));
    return this;
  }
  
  public Builder setWorstRating(String paramString)
  {
    this.adm = paramString;
    this.acs.add(Integer.valueOf(56));
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/plus/model/moments/ItemScope$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */