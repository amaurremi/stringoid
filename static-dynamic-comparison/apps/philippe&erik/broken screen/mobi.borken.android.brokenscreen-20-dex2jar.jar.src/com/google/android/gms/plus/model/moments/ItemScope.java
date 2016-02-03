package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.internal.ko;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract interface ItemScope
  extends Freezable<ItemScope>
{
  public abstract ItemScope getAbout();
  
  public abstract List<String> getAdditionalName();
  
  public abstract ItemScope getAddress();
  
  public abstract String getAddressCountry();
  
  public abstract String getAddressLocality();
  
  public abstract String getAddressRegion();
  
  public abstract List<ItemScope> getAssociated_media();
  
  public abstract int getAttendeeCount();
  
  public abstract List<ItemScope> getAttendees();
  
  public abstract ItemScope getAudio();
  
  public abstract List<ItemScope> getAuthor();
  
  public abstract String getBestRating();
  
  public abstract String getBirthDate();
  
  public abstract ItemScope getByArtist();
  
  public abstract String getCaption();
  
  public abstract String getContentSize();
  
  public abstract String getContentUrl();
  
  public abstract List<ItemScope> getContributor();
  
  public abstract String getDateCreated();
  
  public abstract String getDateModified();
  
  public abstract String getDatePublished();
  
  public abstract String getDescription();
  
  public abstract String getDuration();
  
  public abstract String getEmbedUrl();
  
  public abstract String getEndDate();
  
  public abstract String getFamilyName();
  
  public abstract String getGender();
  
  public abstract ItemScope getGeo();
  
  public abstract String getGivenName();
  
  public abstract String getHeight();
  
  public abstract String getId();
  
  public abstract String getImage();
  
  public abstract ItemScope getInAlbum();
  
  public abstract double getLatitude();
  
  public abstract ItemScope getLocation();
  
  public abstract double getLongitude();
  
  public abstract String getName();
  
  public abstract ItemScope getPartOfTVSeries();
  
  public abstract List<ItemScope> getPerformers();
  
  public abstract String getPlayerType();
  
  public abstract String getPostOfficeBoxNumber();
  
  public abstract String getPostalCode();
  
  public abstract String getRatingValue();
  
  public abstract ItemScope getReviewRating();
  
  public abstract String getStartDate();
  
  public abstract String getStreetAddress();
  
  public abstract String getText();
  
  public abstract ItemScope getThumbnail();
  
  public abstract String getThumbnailUrl();
  
  public abstract String getTickerSymbol();
  
  public abstract String getType();
  
  public abstract String getUrl();
  
  public abstract String getWidth();
  
  public abstract String getWorstRating();
  
  public abstract boolean hasAbout();
  
  public abstract boolean hasAdditionalName();
  
  public abstract boolean hasAddress();
  
  public abstract boolean hasAddressCountry();
  
  public abstract boolean hasAddressLocality();
  
  public abstract boolean hasAddressRegion();
  
  public abstract boolean hasAssociated_media();
  
  public abstract boolean hasAttendeeCount();
  
  public abstract boolean hasAttendees();
  
  public abstract boolean hasAudio();
  
  public abstract boolean hasAuthor();
  
  public abstract boolean hasBestRating();
  
  public abstract boolean hasBirthDate();
  
  public abstract boolean hasByArtist();
  
  public abstract boolean hasCaption();
  
  public abstract boolean hasContentSize();
  
  public abstract boolean hasContentUrl();
  
  public abstract boolean hasContributor();
  
  public abstract boolean hasDateCreated();
  
  public abstract boolean hasDateModified();
  
  public abstract boolean hasDatePublished();
  
  public abstract boolean hasDescription();
  
  public abstract boolean hasDuration();
  
  public abstract boolean hasEmbedUrl();
  
  public abstract boolean hasEndDate();
  
  public abstract boolean hasFamilyName();
  
  public abstract boolean hasGender();
  
  public abstract boolean hasGeo();
  
  public abstract boolean hasGivenName();
  
  public abstract boolean hasHeight();
  
  public abstract boolean hasId();
  
  public abstract boolean hasImage();
  
  public abstract boolean hasInAlbum();
  
  public abstract boolean hasLatitude();
  
  public abstract boolean hasLocation();
  
  public abstract boolean hasLongitude();
  
  public abstract boolean hasName();
  
  public abstract boolean hasPartOfTVSeries();
  
  public abstract boolean hasPerformers();
  
  public abstract boolean hasPlayerType();
  
  public abstract boolean hasPostOfficeBoxNumber();
  
  public abstract boolean hasPostalCode();
  
  public abstract boolean hasRatingValue();
  
  public abstract boolean hasReviewRating();
  
  public abstract boolean hasStartDate();
  
  public abstract boolean hasStreetAddress();
  
  public abstract boolean hasText();
  
  public abstract boolean hasThumbnail();
  
  public abstract boolean hasThumbnailUrl();
  
  public abstract boolean hasTickerSymbol();
  
  public abstract boolean hasType();
  
  public abstract boolean hasUrl();
  
  public abstract boolean hasWidth();
  
  public abstract boolean hasWorstRating();
  
  public static class Builder
  {
    private String Mm;
    private double Va;
    private double Vb;
    private List<ko> acA;
    private String acB;
    private String acC;
    private ko acD;
    private String acE;
    private String acF;
    private List<ko> acG;
    private String acH;
    private String acI;
    private String acJ;
    private String acK;
    private String acL;
    private String acM;
    private String acN;
    private String acO;
    private ko acP;
    private String acQ;
    private String acR;
    private String acS;
    private ko acT;
    private ko acU;
    private ko acV;
    private List<ko> acW;
    private String acX;
    private String acY;
    private String acZ;
    private final Set<Integer> acp = new HashSet();
    private ko acq;
    private List<String> acr;
    private ko acs;
    private String act;
    private String acu;
    private String acv;
    private List<ko> acw;
    private int acx;
    private List<ko> acy;
    private ko acz;
    private String ada;
    private ko adb;
    private String adc;
    private String add;
    private String ade;
    private ko adf;
    private String adg;
    private String adh;
    private String adi;
    private String adj;
    private String mName;
    private String mi;
    private String qU;
    private String qV;
    private String xD;
    
    public ItemScope build()
    {
      return new ko(this.acp, this.acq, this.acr, this.acs, this.act, this.acu, this.acv, this.acw, this.acx, this.acy, this.acz, this.acA, this.acB, this.acC, this.acD, this.acE, this.acF, this.mi, this.acG, this.acH, this.acI, this.acJ, this.Mm, this.acK, this.acL, this.acM, this.acN, this.acO, this.acP, this.acQ, this.acR, this.xD, this.acS, this.acT, this.Va, this.acU, this.Vb, this.mName, this.acV, this.acW, this.acX, this.acY, this.acZ, this.ada, this.adb, this.adc, this.add, this.ade, this.adf, this.adg, this.adh, this.qU, this.qV, this.adi, this.adj);
    }
    
    public Builder setAbout(ItemScope paramItemScope)
    {
      this.acq = ((ko)paramItemScope);
      this.acp.add(Integer.valueOf(2));
      return this;
    }
    
    public Builder setAdditionalName(List<String> paramList)
    {
      this.acr = paramList;
      this.acp.add(Integer.valueOf(3));
      return this;
    }
    
    public Builder setAddress(ItemScope paramItemScope)
    {
      this.acs = ((ko)paramItemScope);
      this.acp.add(Integer.valueOf(4));
      return this;
    }
    
    public Builder setAddressCountry(String paramString)
    {
      this.act = paramString;
      this.acp.add(Integer.valueOf(5));
      return this;
    }
    
    public Builder setAddressLocality(String paramString)
    {
      this.acu = paramString;
      this.acp.add(Integer.valueOf(6));
      return this;
    }
    
    public Builder setAddressRegion(String paramString)
    {
      this.acv = paramString;
      this.acp.add(Integer.valueOf(7));
      return this;
    }
    
    public Builder setAssociated_media(List<ItemScope> paramList)
    {
      this.acw = paramList;
      this.acp.add(Integer.valueOf(8));
      return this;
    }
    
    public Builder setAttendeeCount(int paramInt)
    {
      this.acx = paramInt;
      this.acp.add(Integer.valueOf(9));
      return this;
    }
    
    public Builder setAttendees(List<ItemScope> paramList)
    {
      this.acy = paramList;
      this.acp.add(Integer.valueOf(10));
      return this;
    }
    
    public Builder setAudio(ItemScope paramItemScope)
    {
      this.acz = ((ko)paramItemScope);
      this.acp.add(Integer.valueOf(11));
      return this;
    }
    
    public Builder setAuthor(List<ItemScope> paramList)
    {
      this.acA = paramList;
      this.acp.add(Integer.valueOf(12));
      return this;
    }
    
    public Builder setBestRating(String paramString)
    {
      this.acB = paramString;
      this.acp.add(Integer.valueOf(13));
      return this;
    }
    
    public Builder setBirthDate(String paramString)
    {
      this.acC = paramString;
      this.acp.add(Integer.valueOf(14));
      return this;
    }
    
    public Builder setByArtist(ItemScope paramItemScope)
    {
      this.acD = ((ko)paramItemScope);
      this.acp.add(Integer.valueOf(15));
      return this;
    }
    
    public Builder setCaption(String paramString)
    {
      this.acE = paramString;
      this.acp.add(Integer.valueOf(16));
      return this;
    }
    
    public Builder setContentSize(String paramString)
    {
      this.acF = paramString;
      this.acp.add(Integer.valueOf(17));
      return this;
    }
    
    public Builder setContentUrl(String paramString)
    {
      this.mi = paramString;
      this.acp.add(Integer.valueOf(18));
      return this;
    }
    
    public Builder setContributor(List<ItemScope> paramList)
    {
      this.acG = paramList;
      this.acp.add(Integer.valueOf(19));
      return this;
    }
    
    public Builder setDateCreated(String paramString)
    {
      this.acH = paramString;
      this.acp.add(Integer.valueOf(20));
      return this;
    }
    
    public Builder setDateModified(String paramString)
    {
      this.acI = paramString;
      this.acp.add(Integer.valueOf(21));
      return this;
    }
    
    public Builder setDatePublished(String paramString)
    {
      this.acJ = paramString;
      this.acp.add(Integer.valueOf(22));
      return this;
    }
    
    public Builder setDescription(String paramString)
    {
      this.Mm = paramString;
      this.acp.add(Integer.valueOf(23));
      return this;
    }
    
    public Builder setDuration(String paramString)
    {
      this.acK = paramString;
      this.acp.add(Integer.valueOf(24));
      return this;
    }
    
    public Builder setEmbedUrl(String paramString)
    {
      this.acL = paramString;
      this.acp.add(Integer.valueOf(25));
      return this;
    }
    
    public Builder setEndDate(String paramString)
    {
      this.acM = paramString;
      this.acp.add(Integer.valueOf(26));
      return this;
    }
    
    public Builder setFamilyName(String paramString)
    {
      this.acN = paramString;
      this.acp.add(Integer.valueOf(27));
      return this;
    }
    
    public Builder setGender(String paramString)
    {
      this.acO = paramString;
      this.acp.add(Integer.valueOf(28));
      return this;
    }
    
    public Builder setGeo(ItemScope paramItemScope)
    {
      this.acP = ((ko)paramItemScope);
      this.acp.add(Integer.valueOf(29));
      return this;
    }
    
    public Builder setGivenName(String paramString)
    {
      this.acQ = paramString;
      this.acp.add(Integer.valueOf(30));
      return this;
    }
    
    public Builder setHeight(String paramString)
    {
      this.acR = paramString;
      this.acp.add(Integer.valueOf(31));
      return this;
    }
    
    public Builder setId(String paramString)
    {
      this.xD = paramString;
      this.acp.add(Integer.valueOf(32));
      return this;
    }
    
    public Builder setImage(String paramString)
    {
      this.acS = paramString;
      this.acp.add(Integer.valueOf(33));
      return this;
    }
    
    public Builder setInAlbum(ItemScope paramItemScope)
    {
      this.acT = ((ko)paramItemScope);
      this.acp.add(Integer.valueOf(34));
      return this;
    }
    
    public Builder setLatitude(double paramDouble)
    {
      this.Va = paramDouble;
      this.acp.add(Integer.valueOf(36));
      return this;
    }
    
    public Builder setLocation(ItemScope paramItemScope)
    {
      this.acU = ((ko)paramItemScope);
      this.acp.add(Integer.valueOf(37));
      return this;
    }
    
    public Builder setLongitude(double paramDouble)
    {
      this.Vb = paramDouble;
      this.acp.add(Integer.valueOf(38));
      return this;
    }
    
    public Builder setName(String paramString)
    {
      this.mName = paramString;
      this.acp.add(Integer.valueOf(39));
      return this;
    }
    
    public Builder setPartOfTVSeries(ItemScope paramItemScope)
    {
      this.acV = ((ko)paramItemScope);
      this.acp.add(Integer.valueOf(40));
      return this;
    }
    
    public Builder setPerformers(List<ItemScope> paramList)
    {
      this.acW = paramList;
      this.acp.add(Integer.valueOf(41));
      return this;
    }
    
    public Builder setPlayerType(String paramString)
    {
      this.acX = paramString;
      this.acp.add(Integer.valueOf(42));
      return this;
    }
    
    public Builder setPostOfficeBoxNumber(String paramString)
    {
      this.acY = paramString;
      this.acp.add(Integer.valueOf(43));
      return this;
    }
    
    public Builder setPostalCode(String paramString)
    {
      this.acZ = paramString;
      this.acp.add(Integer.valueOf(44));
      return this;
    }
    
    public Builder setRatingValue(String paramString)
    {
      this.ada = paramString;
      this.acp.add(Integer.valueOf(45));
      return this;
    }
    
    public Builder setReviewRating(ItemScope paramItemScope)
    {
      this.adb = ((ko)paramItemScope);
      this.acp.add(Integer.valueOf(46));
      return this;
    }
    
    public Builder setStartDate(String paramString)
    {
      this.adc = paramString;
      this.acp.add(Integer.valueOf(47));
      return this;
    }
    
    public Builder setStreetAddress(String paramString)
    {
      this.add = paramString;
      this.acp.add(Integer.valueOf(48));
      return this;
    }
    
    public Builder setText(String paramString)
    {
      this.ade = paramString;
      this.acp.add(Integer.valueOf(49));
      return this;
    }
    
    public Builder setThumbnail(ItemScope paramItemScope)
    {
      this.adf = ((ko)paramItemScope);
      this.acp.add(Integer.valueOf(50));
      return this;
    }
    
    public Builder setThumbnailUrl(String paramString)
    {
      this.adg = paramString;
      this.acp.add(Integer.valueOf(51));
      return this;
    }
    
    public Builder setTickerSymbol(String paramString)
    {
      this.adh = paramString;
      this.acp.add(Integer.valueOf(52));
      return this;
    }
    
    public Builder setType(String paramString)
    {
      this.qU = paramString;
      this.acp.add(Integer.valueOf(53));
      return this;
    }
    
    public Builder setUrl(String paramString)
    {
      this.qV = paramString;
      this.acp.add(Integer.valueOf(54));
      return this;
    }
    
    public Builder setWidth(String paramString)
    {
      this.adi = paramString;
      this.acp.add(Integer.valueOf(55));
      return this;
    }
    
    public Builder setWorstRating(String paramString)
    {
      this.adj = paramString;
      this.acp.add(Integer.valueOf(56));
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/plus/model/moments/ItemScope.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */