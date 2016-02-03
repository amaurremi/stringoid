package com.everimaging.fotorsdk.plugins;

public class FeaturePurchasedPack
        extends FeatureInternalPack {
    private String mDescription;
    private FeatureDownloadedPack mDownloadPack;
    private String mIconUrlDefault;
    private String mIconUrlPressed;
    private int mId;
    private int mItemsCount;
    private float mPrice;
    private String mReleaseDate;
    private String mZipUrl;

    public FeaturePurchasedPack(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt5, String paramString7) {
        super(paramString1, paramString2, paramInt2, paramInt3, paramInt4);
        this.mId = paramInt1;
        this.mPrice = paramFloat;
        this.mIconUrlDefault = ("http://dl.fotor.com/store/v1/" + paramString4);
        this.mIconUrlPressed = ("http://dl.fotor.com/store/v1/" + paramString5);
        this.mDescription = paramString3;
        this.mItemsCount = paramInt5;
        this.mReleaseDate = paramString7;
        this.mZipUrl = paramString6;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public FeatureDownloadedPack getDownloadPack() {
        return this.mDownloadPack;
    }

    public String getIconUrlDefault() {
        return this.mIconUrlDefault;
    }

    public String getIconUrlPressed() {
        return this.mIconUrlPressed;
    }

    public int getId() {
        return this.mId;
    }

    public int getItemsCount() {
        return this.mItemsCount;
    }

    public float getPrice() {
        return this.mPrice;
    }

    public String getReleaseDate() {
        return this.mReleaseDate;
    }

    public String getZipUrl() {
        return this.mZipUrl;
    }

    public boolean isFree() {
        return this.mPrice == 0.0F;
    }

    public void setDownloadPack(FeatureDownloadedPack paramFeatureDownloadedPack) {
        this.mDownloadPack = paramFeatureDownloadedPack;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/plugins/FeaturePurchasedPack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */