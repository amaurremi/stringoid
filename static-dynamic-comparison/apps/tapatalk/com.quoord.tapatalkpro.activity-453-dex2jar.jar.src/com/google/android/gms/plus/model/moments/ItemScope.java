package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.internal.ic;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract interface ItemScope
        extends Freezable<ItemScope> {
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

    public static class Builder {
        private String HD;
        private double NX;
        private double NY;
        private String Rd;
        private final Set<Integer> UJ = new HashSet();
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

        public ItemScope build() {
            return new ic(this.UJ, this.UK, this.UL, this.UM, this.UN, this.UO, this.UP, this.UQ, this.UR, this.US, this.UT, this.UU, this.UV, this.UW, this.UX, this.UY, this.UZ, this.lY, this.Va, this.Vb, this.Vc, this.Vd, this.HD, this.Ve, this.Vf, this.Vg, this.Vh, this.Vi, this.Vj, this.Vk, this.Vl, this.wp, this.Vm, this.Vn, this.NX, this.Vo, this.NY, this.mName, this.Vp, this.Vq, this.Vr, this.Vs, this.Vt, this.Vu, this.Vv, this.Vw, this.Vx, this.Vy, this.Vz, this.VA, this.VB, this.Rd, this.ro, this.VC, this.VD);
        }

        public Builder setAbout(ItemScope paramItemScope) {
            this.UK = ((ic) paramItemScope);
            this.UJ.add(Integer.valueOf(2));
            return this;
        }

        public Builder setAdditionalName(List<String> paramList) {
            this.UL = paramList;
            this.UJ.add(Integer.valueOf(3));
            return this;
        }

        public Builder setAddress(ItemScope paramItemScope) {
            this.UM = ((ic) paramItemScope);
            this.UJ.add(Integer.valueOf(4));
            return this;
        }

        public Builder setAddressCountry(String paramString) {
            this.UN = paramString;
            this.UJ.add(Integer.valueOf(5));
            return this;
        }

        public Builder setAddressLocality(String paramString) {
            this.UO = paramString;
            this.UJ.add(Integer.valueOf(6));
            return this;
        }

        public Builder setAddressRegion(String paramString) {
            this.UP = paramString;
            this.UJ.add(Integer.valueOf(7));
            return this;
        }

        public Builder setAssociated_media(List<ItemScope> paramList) {
            this.UQ = paramList;
            this.UJ.add(Integer.valueOf(8));
            return this;
        }

        public Builder setAttendeeCount(int paramInt) {
            this.UR = paramInt;
            this.UJ.add(Integer.valueOf(9));
            return this;
        }

        public Builder setAttendees(List<ItemScope> paramList) {
            this.US = paramList;
            this.UJ.add(Integer.valueOf(10));
            return this;
        }

        public Builder setAudio(ItemScope paramItemScope) {
            this.UT = ((ic) paramItemScope);
            this.UJ.add(Integer.valueOf(11));
            return this;
        }

        public Builder setAuthor(List<ItemScope> paramList) {
            this.UU = paramList;
            this.UJ.add(Integer.valueOf(12));
            return this;
        }

        public Builder setBestRating(String paramString) {
            this.UV = paramString;
            this.UJ.add(Integer.valueOf(13));
            return this;
        }

        public Builder setBirthDate(String paramString) {
            this.UW = paramString;
            this.UJ.add(Integer.valueOf(14));
            return this;
        }

        public Builder setByArtist(ItemScope paramItemScope) {
            this.UX = ((ic) paramItemScope);
            this.UJ.add(Integer.valueOf(15));
            return this;
        }

        public Builder setCaption(String paramString) {
            this.UY = paramString;
            this.UJ.add(Integer.valueOf(16));
            return this;
        }

        public Builder setContentSize(String paramString) {
            this.UZ = paramString;
            this.UJ.add(Integer.valueOf(17));
            return this;
        }

        public Builder setContentUrl(String paramString) {
            this.lY = paramString;
            this.UJ.add(Integer.valueOf(18));
            return this;
        }

        public Builder setContributor(List<ItemScope> paramList) {
            this.Va = paramList;
            this.UJ.add(Integer.valueOf(19));
            return this;
        }

        public Builder setDateCreated(String paramString) {
            this.Vb = paramString;
            this.UJ.add(Integer.valueOf(20));
            return this;
        }

        public Builder setDateModified(String paramString) {
            this.Vc = paramString;
            this.UJ.add(Integer.valueOf(21));
            return this;
        }

        public Builder setDatePublished(String paramString) {
            this.Vd = paramString;
            this.UJ.add(Integer.valueOf(22));
            return this;
        }

        public Builder setDescription(String paramString) {
            this.HD = paramString;
            this.UJ.add(Integer.valueOf(23));
            return this;
        }

        public Builder setDuration(String paramString) {
            this.Ve = paramString;
            this.UJ.add(Integer.valueOf(24));
            return this;
        }

        public Builder setEmbedUrl(String paramString) {
            this.Vf = paramString;
            this.UJ.add(Integer.valueOf(25));
            return this;
        }

        public Builder setEndDate(String paramString) {
            this.Vg = paramString;
            this.UJ.add(Integer.valueOf(26));
            return this;
        }

        public Builder setFamilyName(String paramString) {
            this.Vh = paramString;
            this.UJ.add(Integer.valueOf(27));
            return this;
        }

        public Builder setGender(String paramString) {
            this.Vi = paramString;
            this.UJ.add(Integer.valueOf(28));
            return this;
        }

        public Builder setGeo(ItemScope paramItemScope) {
            this.Vj = ((ic) paramItemScope);
            this.UJ.add(Integer.valueOf(29));
            return this;
        }

        public Builder setGivenName(String paramString) {
            this.Vk = paramString;
            this.UJ.add(Integer.valueOf(30));
            return this;
        }

        public Builder setHeight(String paramString) {
            this.Vl = paramString;
            this.UJ.add(Integer.valueOf(31));
            return this;
        }

        public Builder setId(String paramString) {
            this.wp = paramString;
            this.UJ.add(Integer.valueOf(32));
            return this;
        }

        public Builder setImage(String paramString) {
            this.Vm = paramString;
            this.UJ.add(Integer.valueOf(33));
            return this;
        }

        public Builder setInAlbum(ItemScope paramItemScope) {
            this.Vn = ((ic) paramItemScope);
            this.UJ.add(Integer.valueOf(34));
            return this;
        }

        public Builder setLatitude(double paramDouble) {
            this.NX = paramDouble;
            this.UJ.add(Integer.valueOf(36));
            return this;
        }

        public Builder setLocation(ItemScope paramItemScope) {
            this.Vo = ((ic) paramItemScope);
            this.UJ.add(Integer.valueOf(37));
            return this;
        }

        public Builder setLongitude(double paramDouble) {
            this.NY = paramDouble;
            this.UJ.add(Integer.valueOf(38));
            return this;
        }

        public Builder setName(String paramString) {
            this.mName = paramString;
            this.UJ.add(Integer.valueOf(39));
            return this;
        }

        public Builder setPartOfTVSeries(ItemScope paramItemScope) {
            this.Vp = ((ic) paramItemScope);
            this.UJ.add(Integer.valueOf(40));
            return this;
        }

        public Builder setPerformers(List<ItemScope> paramList) {
            this.Vq = paramList;
            this.UJ.add(Integer.valueOf(41));
            return this;
        }

        public Builder setPlayerType(String paramString) {
            this.Vr = paramString;
            this.UJ.add(Integer.valueOf(42));
            return this;
        }

        public Builder setPostOfficeBoxNumber(String paramString) {
            this.Vs = paramString;
            this.UJ.add(Integer.valueOf(43));
            return this;
        }

        public Builder setPostalCode(String paramString) {
            this.Vt = paramString;
            this.UJ.add(Integer.valueOf(44));
            return this;
        }

        public Builder setRatingValue(String paramString) {
            this.Vu = paramString;
            this.UJ.add(Integer.valueOf(45));
            return this;
        }

        public Builder setReviewRating(ItemScope paramItemScope) {
            this.Vv = ((ic) paramItemScope);
            this.UJ.add(Integer.valueOf(46));
            return this;
        }

        public Builder setStartDate(String paramString) {
            this.Vw = paramString;
            this.UJ.add(Integer.valueOf(47));
            return this;
        }

        public Builder setStreetAddress(String paramString) {
            this.Vx = paramString;
            this.UJ.add(Integer.valueOf(48));
            return this;
        }

        public Builder setText(String paramString) {
            this.Vy = paramString;
            this.UJ.add(Integer.valueOf(49));
            return this;
        }

        public Builder setThumbnail(ItemScope paramItemScope) {
            this.Vz = ((ic) paramItemScope);
            this.UJ.add(Integer.valueOf(50));
            return this;
        }

        public Builder setThumbnailUrl(String paramString) {
            this.VA = paramString;
            this.UJ.add(Integer.valueOf(51));
            return this;
        }

        public Builder setTickerSymbol(String paramString) {
            this.VB = paramString;
            this.UJ.add(Integer.valueOf(52));
            return this;
        }

        public Builder setType(String paramString) {
            this.Rd = paramString;
            this.UJ.add(Integer.valueOf(53));
            return this;
        }

        public Builder setUrl(String paramString) {
            this.ro = paramString;
            this.UJ.add(Integer.valueOf(54));
            return this;
        }

        public Builder setWidth(String paramString) {
            this.VC = paramString;
            this.UJ.add(Integer.valueOf(55));
            return this;
        }

        public Builder setWorstRating(String paramString) {
            this.VD = paramString;
            this.UJ.add(Integer.valueOf(56));
            return this;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/plus/model/moments/ItemScope.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */