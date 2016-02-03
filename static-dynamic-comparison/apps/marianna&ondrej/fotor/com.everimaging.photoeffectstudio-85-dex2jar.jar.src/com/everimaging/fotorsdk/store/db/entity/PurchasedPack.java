package com.everimaging.fotorsdk.store.db.entity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.everimaging.fotorsdk.store.db.b;

import java.util.ArrayList;
import java.util.List;

public class PurchasedPack {
    private String highDefault;
    private String highPressed;
    private long id;
    private long installDate;
    private boolean isInstalled;
    private String lowDefault;
    private String lowPressed;
    private String packName;
    private long purchaseDate;
    private int resourceId;
    private String resourceUrl;
    private String type;

    public static PurchasedPack create(Cursor paramCursor) {
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (paramCursor != null) {
            localObject1 = localObject2;
            if (paramCursor.moveToFirst()) {
                localObject1 = readFromCursor(paramCursor);
            }
        }
        return (PurchasedPack) localObject1;
    }

    public static List<PurchasedPack> getAllPurchasePack(Context paramContext) {
        Object localObject1 = null;
        Object localObject2 = b.a(paramContext);
        localObject2 = paramContext.getContentResolver().query((Uri) localObject2, null, null, null, "purchase_date DESC");
        paramContext = (Context) localObject1;
        if (localObject2 != null) {
            paramContext = (Context) localObject1;
            if (((Cursor) localObject2).moveToFirst()) {
                paramContext = new ArrayList();
                do {
                    paramContext.add(readFromCursor((Cursor) localObject2));
                } while (((Cursor) localObject2).moveToNext());
            }
        }
        if (localObject2 != null) {
            ((Cursor) localObject2).close();
        }
        return paramContext;
    }

    private static ContentValues getContentValues(PurchasedPack paramPurchasedPack) {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("high_default", paramPurchasedPack.getHighDefault());
        localContentValues.put("high_pressed", paramPurchasedPack.getHighPressed());
        localContentValues.put("install_date", Long.valueOf(paramPurchasedPack.getInstallDate()));
        if (paramPurchasedPack.isInstalled()) {
        }
        for (int i = 1; ; i = 0) {
            localContentValues.put("installed", Integer.valueOf(i));
            localContentValues.put("low_default", paramPurchasedPack.getLowDefault());
            localContentValues.put("low_pressed", paramPurchasedPack.getLowPressed());
            localContentValues.put("pack_name", paramPurchasedPack.getPackName());
            localContentValues.put("resource_id", Integer.valueOf(paramPurchasedPack.getResourceId()));
            localContentValues.put("resource_url", paramPurchasedPack.getResourceUrl());
            localContentValues.put("pack_type", paramPurchasedPack.getType());
            return localContentValues;
        }
    }

    public static Uri insert(Context paramContext, PurchasedPack paramPurchasedPack) {
        Uri localUri = b.a(paramContext);
        paramPurchasedPack = getContentValues(paramPurchasedPack);
        return paramContext.getContentResolver().insert(localUri, paramPurchasedPack);
    }

    private static PurchasedPack readFromCursor(Cursor paramCursor) {
        PurchasedPack localPurchasedPack = new PurchasedPack();
        localPurchasedPack.id = paramCursor.getLong(paramCursor.getColumnIndex("id"));
        localPurchasedPack.highDefault = paramCursor.getString(paramCursor.getColumnIndex("high_default"));
        localPurchasedPack.highPressed = paramCursor.getString(paramCursor.getColumnIndex("high_pressed"));
        localPurchasedPack.installDate = paramCursor.getLong(paramCursor.getColumnIndex("install_date"));
        if (paramCursor.getInt(paramCursor.getInt(paramCursor.getColumnIndex("installed"))) > 0) {
        }
        for (boolean bool = true; ; bool = false) {
            localPurchasedPack.isInstalled = bool;
            localPurchasedPack.lowDefault = paramCursor.getString(paramCursor.getColumnIndex("low_default"));
            localPurchasedPack.lowPressed = paramCursor.getString(paramCursor.getColumnIndex("low_pressed"));
            localPurchasedPack.packName = paramCursor.getString(paramCursor.getColumnIndex("pack_name"));
            localPurchasedPack.purchaseDate = paramCursor.getLong(paramCursor.getColumnIndex("purchase_date"));
            localPurchasedPack.resourceId = paramCursor.getInt(paramCursor.getColumnIndex("resource_id"));
            localPurchasedPack.resourceUrl = paramCursor.getString(paramCursor.getColumnIndex("resource_url"));
            localPurchasedPack.type = paramCursor.getString(paramCursor.getColumnIndex("pack_type"));
            return localPurchasedPack;
        }
    }

    public static int update(Context paramContext, PurchasedPack paramPurchasedPack) {
        Uri localUri = b.a(paramContext, paramPurchasedPack.getId());
        paramPurchasedPack = getContentValues(paramPurchasedPack);
        return paramContext.getContentResolver().update(localUri, paramPurchasedPack, null, null);
    }

    public String getHighDefault() {
        return this.highDefault;
    }

    public String getHighPressed() {
        return this.highPressed;
    }

    public long getId() {
        return this.id;
    }

    public long getInstallDate() {
        return this.installDate;
    }

    public String getLowDefault() {
        return this.lowDefault;
    }

    public String getLowPressed() {
        return this.lowPressed;
    }

    public String getPackID() {
        return this.type + "_" + this.packName;
    }

    public String getPackName() {
        return this.packName;
    }

    public long getPurchaseDate() {
        return this.purchaseDate;
    }

    public int getResourceId() {
        return this.resourceId;
    }

    public String getResourceUrl() {
        return this.resourceUrl;
    }

    public String getType() {
        return this.type;
    }

    public boolean isInstalled() {
        return this.isInstalled;
    }

    public void setHighDefault(String paramString) {
        this.highDefault = paramString;
    }

    public void setHighPressed(String paramString) {
        this.highPressed = paramString;
    }

    public void setId(int paramInt) {
        this.id = paramInt;
    }

    public void setInstallDate(long paramLong) {
        this.installDate = paramLong;
    }

    public void setInstalled(boolean paramBoolean) {
        this.isInstalled = paramBoolean;
    }

    public void setLowDefault(String paramString) {
        this.lowDefault = paramString;
    }

    public void setLowPressed(String paramString) {
        this.lowPressed = paramString;
    }

    public void setPackName(String paramString) {
        this.packName = paramString;
    }

    public void setPurchaseDate(long paramLong) {
        this.purchaseDate = paramLong;
    }

    public void setResourceId(int paramInt) {
        this.resourceId = paramInt;
    }

    public void setResourceUrl(String paramString) {
        this.resourceUrl = paramString;
    }

    public void setType(String paramString) {
        this.type = paramString;
    }

    public String toString() {
        return "Purchased pack{type=" + this.type + ",packname=" + this.packName + "}";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/db/entity/PurchasedPack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */