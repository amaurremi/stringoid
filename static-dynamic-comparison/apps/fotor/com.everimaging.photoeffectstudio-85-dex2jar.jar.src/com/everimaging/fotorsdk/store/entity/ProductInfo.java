package com.everimaging.fotorsdk.store.entity;

import java.util.List;

public class ProductInfo {
    private String name;
    private String packageName;
    private float price;
    private int resourceId;
    private String resourceUrl;
    private List<? extends FotorStoreJsonObjects.PurchasablePackBaseJsonObject> subPacks;
    private String type;

    public ProductInfo(String paramString1, int paramInt, String paramString2, String paramString3, float paramFloat, List<? extends FotorStoreJsonObjects.PurchasablePackBaseJsonObject> paramList) {
        this.resourceId = paramInt;
        this.packageName = paramString2;
        this.name = paramString3;
        this.price = paramFloat;
        this.type = paramString1;
        this.subPacks = paramList;
    }

    public ProductInfo(String paramString1, int paramInt, String paramString2, String paramString3, float paramFloat, List<? extends FotorStoreJsonObjects.PurchasablePackBaseJsonObject> paramList, String paramString4) {
        this(paramString1, paramInt, paramString2, paramString3, paramFloat, paramList);
        this.resourceUrl = paramString4;
    }

    public String getName() {
        return this.name;
    }

    public String getPackID() {
        return this.type + "_" + this.name;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public float getPrice() {
        return this.price;
    }

    public int getResourceId() {
        return this.resourceId;
    }

    public String getResourceUrl() {
        return this.resourceUrl;
    }

    public List<? extends FotorStoreJsonObjects.PurchasablePackBaseJsonObject> getSubPacks() {
        return this.subPacks;
    }

    public String getType() {
        return this.type;
    }

    public boolean isBundleProduct() {
        return (this.subPacks == null) || (this.subPacks.size() == 0);
    }

    public boolean isFree() {
        return Float.compare(this.price, 0.0F) == 0;
    }

    public void setName(String paramString) {
        this.name = paramString;
    }

    public void setPackageName(String paramString) {
        this.packageName = paramString;
    }

    public void setPrice(float paramFloat) {
        this.price = paramFloat;
    }

    public void setResourceId(int paramInt) {
        this.resourceId = paramInt;
    }

    public void setResourceUrl(String paramString) {
        this.resourceUrl = paramString;
    }

    public String toString() {
        return "ProductInfo(name" + this.name + ",id:" + this.resourceId + ",price:" + this.price + ",type:" + this.type + ",resUrl:" + this.resourceUrl + ",pkgName:" + this.packageName + ")";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/entity/ProductInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */