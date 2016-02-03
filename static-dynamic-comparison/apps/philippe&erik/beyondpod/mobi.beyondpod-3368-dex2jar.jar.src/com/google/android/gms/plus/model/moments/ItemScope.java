package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.internal.ib;
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
    private final Set<Integer> Eq = new HashSet();
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
    private String mName;
    private String sJ;
    private String uS;
    private double xw;
    private double xx;
    
    public ItemScope build()
    {
      return new ib(this.Eq, this.Er, this.Es, this.Et, this.Eu, this.Ev, this.Ew, this.Ex, this.Ey, this.Ez, this.EA, this.EB, this.EC, this.ED, this.EE, this.EF, this.EG, this.EH, this.EI, this.EJ, this.EK, this.EL, this.sJ, this.EM, this.EN, this.EO, this.EP, this.EQ, this.ER, this.ES, this.ET, this.uS, this.EU, this.EV, this.xw, this.EW, this.xx, this.mName, this.EX, this.EY, this.EZ, this.Fa, this.Fb, this.Fc, this.Fd, this.Fe, this.Ff, this.Fg, this.Fh, this.Fi, this.Fj, this.AI, this.iH, this.Fk, this.Fl);
    }
    
    public Builder setAbout(ItemScope paramItemScope)
    {
      this.Er = ((ib)paramItemScope);
      this.Eq.add(Integer.valueOf(2));
      return this;
    }
    
    public Builder setAdditionalName(List<String> paramList)
    {
      this.Es = paramList;
      this.Eq.add(Integer.valueOf(3));
      return this;
    }
    
    public Builder setAddress(ItemScope paramItemScope)
    {
      this.Et = ((ib)paramItemScope);
      this.Eq.add(Integer.valueOf(4));
      return this;
    }
    
    public Builder setAddressCountry(String paramString)
    {
      this.Eu = paramString;
      this.Eq.add(Integer.valueOf(5));
      return this;
    }
    
    public Builder setAddressLocality(String paramString)
    {
      this.Ev = paramString;
      this.Eq.add(Integer.valueOf(6));
      return this;
    }
    
    public Builder setAddressRegion(String paramString)
    {
      this.Ew = paramString;
      this.Eq.add(Integer.valueOf(7));
      return this;
    }
    
    public Builder setAssociated_media(List<ItemScope> paramList)
    {
      this.Ex = paramList;
      this.Eq.add(Integer.valueOf(8));
      return this;
    }
    
    public Builder setAttendeeCount(int paramInt)
    {
      this.Ey = paramInt;
      this.Eq.add(Integer.valueOf(9));
      return this;
    }
    
    public Builder setAttendees(List<ItemScope> paramList)
    {
      this.Ez = paramList;
      this.Eq.add(Integer.valueOf(10));
      return this;
    }
    
    public Builder setAudio(ItemScope paramItemScope)
    {
      this.EA = ((ib)paramItemScope);
      this.Eq.add(Integer.valueOf(11));
      return this;
    }
    
    public Builder setAuthor(List<ItemScope> paramList)
    {
      this.EB = paramList;
      this.Eq.add(Integer.valueOf(12));
      return this;
    }
    
    public Builder setBestRating(String paramString)
    {
      this.EC = paramString;
      this.Eq.add(Integer.valueOf(13));
      return this;
    }
    
    public Builder setBirthDate(String paramString)
    {
      this.ED = paramString;
      this.Eq.add(Integer.valueOf(14));
      return this;
    }
    
    public Builder setByArtist(ItemScope paramItemScope)
    {
      this.EE = ((ib)paramItemScope);
      this.Eq.add(Integer.valueOf(15));
      return this;
    }
    
    public Builder setCaption(String paramString)
    {
      this.EF = paramString;
      this.Eq.add(Integer.valueOf(16));
      return this;
    }
    
    public Builder setContentSize(String paramString)
    {
      this.EG = paramString;
      this.Eq.add(Integer.valueOf(17));
      return this;
    }
    
    public Builder setContentUrl(String paramString)
    {
      this.EH = paramString;
      this.Eq.add(Integer.valueOf(18));
      return this;
    }
    
    public Builder setContributor(List<ItemScope> paramList)
    {
      this.EI = paramList;
      this.Eq.add(Integer.valueOf(19));
      return this;
    }
    
    public Builder setDateCreated(String paramString)
    {
      this.EJ = paramString;
      this.Eq.add(Integer.valueOf(20));
      return this;
    }
    
    public Builder setDateModified(String paramString)
    {
      this.EK = paramString;
      this.Eq.add(Integer.valueOf(21));
      return this;
    }
    
    public Builder setDatePublished(String paramString)
    {
      this.EL = paramString;
      this.Eq.add(Integer.valueOf(22));
      return this;
    }
    
    public Builder setDescription(String paramString)
    {
      this.sJ = paramString;
      this.Eq.add(Integer.valueOf(23));
      return this;
    }
    
    public Builder setDuration(String paramString)
    {
      this.EM = paramString;
      this.Eq.add(Integer.valueOf(24));
      return this;
    }
    
    public Builder setEmbedUrl(String paramString)
    {
      this.EN = paramString;
      this.Eq.add(Integer.valueOf(25));
      return this;
    }
    
    public Builder setEndDate(String paramString)
    {
      this.EO = paramString;
      this.Eq.add(Integer.valueOf(26));
      return this;
    }
    
    public Builder setFamilyName(String paramString)
    {
      this.EP = paramString;
      this.Eq.add(Integer.valueOf(27));
      return this;
    }
    
    public Builder setGender(String paramString)
    {
      this.EQ = paramString;
      this.Eq.add(Integer.valueOf(28));
      return this;
    }
    
    public Builder setGeo(ItemScope paramItemScope)
    {
      this.ER = ((ib)paramItemScope);
      this.Eq.add(Integer.valueOf(29));
      return this;
    }
    
    public Builder setGivenName(String paramString)
    {
      this.ES = paramString;
      this.Eq.add(Integer.valueOf(30));
      return this;
    }
    
    public Builder setHeight(String paramString)
    {
      this.ET = paramString;
      this.Eq.add(Integer.valueOf(31));
      return this;
    }
    
    public Builder setId(String paramString)
    {
      this.uS = paramString;
      this.Eq.add(Integer.valueOf(32));
      return this;
    }
    
    public Builder setImage(String paramString)
    {
      this.EU = paramString;
      this.Eq.add(Integer.valueOf(33));
      return this;
    }
    
    public Builder setInAlbum(ItemScope paramItemScope)
    {
      this.EV = ((ib)paramItemScope);
      this.Eq.add(Integer.valueOf(34));
      return this;
    }
    
    public Builder setLatitude(double paramDouble)
    {
      this.xw = paramDouble;
      this.Eq.add(Integer.valueOf(36));
      return this;
    }
    
    public Builder setLocation(ItemScope paramItemScope)
    {
      this.EW = ((ib)paramItemScope);
      this.Eq.add(Integer.valueOf(37));
      return this;
    }
    
    public Builder setLongitude(double paramDouble)
    {
      this.xx = paramDouble;
      this.Eq.add(Integer.valueOf(38));
      return this;
    }
    
    public Builder setName(String paramString)
    {
      this.mName = paramString;
      this.Eq.add(Integer.valueOf(39));
      return this;
    }
    
    public Builder setPartOfTVSeries(ItemScope paramItemScope)
    {
      this.EX = ((ib)paramItemScope);
      this.Eq.add(Integer.valueOf(40));
      return this;
    }
    
    public Builder setPerformers(List<ItemScope> paramList)
    {
      this.EY = paramList;
      this.Eq.add(Integer.valueOf(41));
      return this;
    }
    
    public Builder setPlayerType(String paramString)
    {
      this.EZ = paramString;
      this.Eq.add(Integer.valueOf(42));
      return this;
    }
    
    public Builder setPostOfficeBoxNumber(String paramString)
    {
      this.Fa = paramString;
      this.Eq.add(Integer.valueOf(43));
      return this;
    }
    
    public Builder setPostalCode(String paramString)
    {
      this.Fb = paramString;
      this.Eq.add(Integer.valueOf(44));
      return this;
    }
    
    public Builder setRatingValue(String paramString)
    {
      this.Fc = paramString;
      this.Eq.add(Integer.valueOf(45));
      return this;
    }
    
    public Builder setReviewRating(ItemScope paramItemScope)
    {
      this.Fd = ((ib)paramItemScope);
      this.Eq.add(Integer.valueOf(46));
      return this;
    }
    
    public Builder setStartDate(String paramString)
    {
      this.Fe = paramString;
      this.Eq.add(Integer.valueOf(47));
      return this;
    }
    
    public Builder setStreetAddress(String paramString)
    {
      this.Ff = paramString;
      this.Eq.add(Integer.valueOf(48));
      return this;
    }
    
    public Builder setText(String paramString)
    {
      this.Fg = paramString;
      this.Eq.add(Integer.valueOf(49));
      return this;
    }
    
    public Builder setThumbnail(ItemScope paramItemScope)
    {
      this.Fh = ((ib)paramItemScope);
      this.Eq.add(Integer.valueOf(50));
      return this;
    }
    
    public Builder setThumbnailUrl(String paramString)
    {
      this.Fi = paramString;
      this.Eq.add(Integer.valueOf(51));
      return this;
    }
    
    public Builder setTickerSymbol(String paramString)
    {
      this.Fj = paramString;
      this.Eq.add(Integer.valueOf(52));
      return this;
    }
    
    public Builder setType(String paramString)
    {
      this.AI = paramString;
      this.Eq.add(Integer.valueOf(53));
      return this;
    }
    
    public Builder setUrl(String paramString)
    {
      this.iH = paramString;
      this.Eq.add(Integer.valueOf(54));
      return this;
    }
    
    public Builder setWidth(String paramString)
    {
      this.Fk = paramString;
      this.Eq.add(Integer.valueOf(55));
      return this;
    }
    
    public Builder setWorstRating(String paramString)
    {
      this.Fl = paramString;
      this.Eq.add(Integer.valueOf(56));
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/plus/model/moments/ItemScope.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */