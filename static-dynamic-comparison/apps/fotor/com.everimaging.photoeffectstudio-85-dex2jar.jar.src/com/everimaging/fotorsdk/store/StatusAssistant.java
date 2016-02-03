package com.everimaging.fotorsdk.store;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.BundleDetailsJsonObject;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.ModulesJsonObject.PurchaseResourceInfo;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.PurchasablePackBaseJsonObject;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.ResPackageJsonObject;
import com.everimaging.fotorsdk.store.iap.a;
import com.everimaging.fotorsdk.store.widget.PurchaseButton;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StatusAssistant {
    private static final String a = StatusAssistant.class.getSimpleName();
    private static final FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);

    public static StatusInfo a(FotorStoreJsonObjects.BundleDetailsJsonObject paramBundleDetailsJsonObject, ArrayList<String> paramArrayList, a parama) {
        return a(paramBundleDetailsJsonObject, paramBundleDetailsJsonObject.resources, paramArrayList, parama);
    }

    public static StatusInfo a(FotorStoreJsonObjects.PurchasablePackBaseJsonObject paramPurchasablePackBaseJsonObject, ArrayList<String> paramArrayList, a parama) {
        int i = 2;
        String str = paramPurchasablePackBaseJsonObject.getPackID();
        float f;
        if ((str != null) && (paramArrayList.contains(str))) {
            f = -1.0F;
            i = 3;
            paramPurchasablePackBaseJsonObject = null;
        }
        for (; ; ) {
            return new StatusInfo(i, f, paramPurchasablePackBaseJsonObject);
            int j = c.a().a(str);
            if (j >= 0) {
                f = j;
                i = 6;
                f *= 0.01F;
                paramPurchasablePackBaseJsonObject = null;
            } else if (com.everimaging.fotorsdk.store.utils.c.d()) {
                if (paramPurchasablePackBaseJsonObject.price == 0.0F) {
                    paramPurchasablePackBaseJsonObject = null;
                    i = 0;
                    f = -1.0F;
                } else {
                    f = -1.0F;
                    i = 1;
                    paramPurchasablePackBaseJsonObject = null;
                }
            } else {
                boolean bool = parama.a(str);
                paramPurchasablePackBaseJsonObject = com.everimaging.fotorsdk.store.utils.c.a(paramPurchasablePackBaseJsonObject.id);
                if (paramPurchasablePackBaseJsonObject == null) {
                    if (bool) {
                    }
                    for (; ; ) {
                        f = -1.0F;
                        paramPurchasablePackBaseJsonObject = null;
                        break;
                        i = 0;
                    }
                }
                if ((a.a().a(paramPurchasablePackBaseJsonObject.productId)) || (bool)) {
                    f = -1.0F;
                    i = 2;
                    paramPurchasablePackBaseJsonObject = null;
                } else if (TextUtils.isEmpty(paramPurchasablePackBaseJsonObject.realPrice)) {
                    f = -1.0F;
                    i = 5;
                    paramPurchasablePackBaseJsonObject = null;
                } else {
                    paramPurchasablePackBaseJsonObject = paramPurchasablePackBaseJsonObject.realPrice;
                    i = 4;
                    f = -1.0F;
                }
            }
        }
    }

    private static StatusInfo a(FotorStoreJsonObjects.PurchasablePackBaseJsonObject paramPurchasablePackBaseJsonObject, List<? extends FotorStoreJsonObjects.PurchasablePackBaseJsonObject> paramList, ArrayList<String> paramArrayList, a parama) {
        Object localObject = null;
        int i2 = 0;
        paramList = paramList.iterator();
        int m = 0;
        int k = 0;
        int j = 0;
        int i = 0;
        StatusInfo localStatusInfo;
        int n;
        int i1;
        if (paramList.hasNext()) {
            localStatusInfo = a((FotorStoreJsonObjects.PurchasablePackBaseJsonObject) paramList.next(), paramArrayList, parama);
            if (localStatusInfo.b()) {
                n = m;
                i1 = k;
                m = i + 1;
                k = j;
                j = i1;
                i = n;
            }
        }
        for (; ; ) {
            n = m;
            i1 = k;
            m = i;
            k = j;
            j = i1;
            i = n;
            break;
            if (localStatusInfo.d()) {
                i1 = j + 1;
                n = i;
                i = m;
                j = k;
                k = i1;
                m = n;
            } else if (localStatusInfo.a()) {
                i1 = k + 1;
                k = j;
                n = i;
                i = m;
                j = i1;
                m = n;
            } else if (localStatusInfo.c()) {
                i1 = m + 1;
                m = j;
                n = i;
                i = i1;
                j = k;
                k = m;
                m = n;
                continue;
                if (i > 0) {
                    paramPurchasablePackBaseJsonObject = com.everimaging.fotorsdk.store.utils.c.a(paramPurchasablePackBaseJsonObject.id);
                    if (paramPurchasablePackBaseJsonObject == null) {
                        b.e(new Object[]{"this bundle pack is not have product id"});
                        paramPurchasablePackBaseJsonObject = null;
                        i = i2;
                        paramPurchasablePackBaseJsonObject = new StatusInfo(i, paramPurchasablePackBaseJsonObject);
                    }
                }
                do {
                    return paramPurchasablePackBaseJsonObject;
                    if (a.a().a(paramPurchasablePackBaseJsonObject.productId)) {
                        b.e(new Object[]{"this bundle pack was purchased but why it's sub packs status is not refresh yet?"});
                        paramPurchasablePackBaseJsonObject = null;
                        i = 2;
                        break;
                    }
                    if (TextUtils.isEmpty(paramPurchasablePackBaseJsonObject.realPrice)) {
                        i = 5;
                        paramPurchasablePackBaseJsonObject = null;
                        break;
                    }
                    i = 4;
                    paramPurchasablePackBaseJsonObject = paramPurchasablePackBaseJsonObject.realPrice;
                    break;
                    if (j > 0) {
                        return new StatusInfo(2);
                    }
                    if (k > 0) {
                        return new StatusInfo(6);
                    }
                    paramPurchasablePackBaseJsonObject = (FotorStoreJsonObjects.PurchasablePackBaseJsonObject) localObject;
                } while (m <= 0);
                return new StatusInfo(3);
            } else {
                n = j;
                i1 = i;
                i = m;
                j = k;
                k = n;
                m = i1;
            }
        }
    }

    public static StatusInfo a(FotorStoreJsonObjects.ResPackageJsonObject paramResPackageJsonObject, ArrayList<String> paramArrayList, a parama) {
        return a(paramResPackageJsonObject, paramResPackageJsonObject.resources, paramArrayList, parama);
    }

    public static void a(Context paramContext, StatusInfo paramStatusInfo, PurchaseButton paramPurchaseButton) {
        a(paramContext, paramStatusInfo, paramPurchaseButton, false);
    }

    public static void a(Context paramContext, StatusInfo paramStatusInfo, PurchaseButton paramPurchaseButton, boolean paramBoolean) {
        boolean bool = true;
        float f = -1.0F;
        paramPurchaseButton.b();
        String str = "";
        switch (StatusInfo.a(paramStatusInfo)) {
            default:
                bool = false;
                paramContext = str;
        }
        for (; ; ) {
            paramPurchaseButton.setText(paramContext);
            paramPurchaseButton.setEnabled(bool);
            if ((!paramBoolean) && (f >= 0.0F)) {
                paramPurchaseButton.a(f);
            }
            return;
            paramContext = paramContext.getString(R.string.fotor_store_pkg_buy);
            continue;
            paramContext = paramContext.getString(R.string.fotor_store_pkg_download);
            continue;
            paramContext = paramContext.getString(R.string.fotor_store_pkg_free);
            continue;
            paramContext = paramContext.getString(R.string.fotor_store_pkg_installed);
            bool = false;
            continue;
            paramContext = paramContext.getString(R.string.fotor_store_pkg_installing);
            if (!paramBoolean) {
                paramPurchaseButton.a();
            }
            f = StatusInfo.b(paramStatusInfo);
            bool = false;
            continue;
            paramContext = paramContext.getString(R.string.fotor_store_pkg_invalid);
            bool = false;
            continue;
            paramContext = StatusInfo.c(paramStatusInfo);
        }
    }

    public static class StatusInfo
            implements Parcelable {
        public static final Parcelable.Creator<StatusInfo> CREATOR = new Parcelable.Creator() {
            public StatusAssistant.StatusInfo a(Parcel paramAnonymousParcel) {
                return new StatusAssistant.StatusInfo(paramAnonymousParcel);
            }

            public StatusAssistant.StatusInfo[] a(int paramAnonymousInt) {
                return new StatusAssistant.StatusInfo[paramAnonymousInt];
            }
        };
        private int a;
        private float b;
        private String c;

        public StatusInfo(int paramInt) {
            this.a = paramInt;
        }

        public StatusInfo(int paramInt, float paramFloat, String paramString) {
            this.a = paramInt;
            this.b = paramFloat;
            this.c = paramString;
        }

        public StatusInfo(int paramInt, String paramString) {
            this(paramInt);
            this.c = paramString;
        }

        public StatusInfo(Parcel paramParcel) {
            this.a = paramParcel.readInt();
            this.b = paramParcel.readFloat();
            this.c = paramParcel.readString();
        }

        public void a(float paramFloat) {
            this.b = paramFloat;
        }

        public void a(int paramInt) {
            this.a = paramInt;
        }

        public boolean a() {
            return this.a == 6;
        }

        public boolean b() {
            return (this.a == 1) || (this.a == 0) || (this.a == 4) || (this.a == 5);
        }

        public boolean c() {
            return this.a == 3;
        }

        public boolean d() {
            return this.a == 2;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel paramParcel, int paramInt) {
            paramParcel.writeInt(this.a);
            paramParcel.writeFloat(this.b);
            paramParcel.writeString(this.c);
        }
    }

    public static abstract interface a {
        public abstract boolean a(String paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/StatusAssistant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */