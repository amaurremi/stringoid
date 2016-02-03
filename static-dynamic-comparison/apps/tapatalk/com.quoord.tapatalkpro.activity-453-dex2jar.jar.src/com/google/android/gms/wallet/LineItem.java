package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LineItem
        implements SafeParcelable {
    public static final Parcelable.Creator<LineItem> CREATOR = new i();
    String abc;
    String abd;
    String abv;
    String abw;
    int abx;
    String description;
    private final int xH;

    LineItem() {
        this.xH = 1;
        this.abx = 0;
    }

    LineItem(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5) {
        this.xH = paramInt1;
        this.description = paramString1;
        this.abv = paramString2;
        this.abw = paramString3;
        this.abc = paramString4;
        this.abx = paramInt2;
        this.abd = paramString5;
    }

    public static Builder newBuilder() {
        LineItem localLineItem = new LineItem();
        localLineItem.getClass();
        return new Builder(null);
    }

    public int describeContents() {
        return 0;
    }

    public String getCurrencyCode() {
        return this.abd;
    }

    public String getDescription() {
        return this.description;
    }

    public String getQuantity() {
        return this.abv;
    }

    public int getRole() {
        return this.abx;
    }

    public String getTotalPrice() {
        return this.abc;
    }

    public String getUnitPrice() {
        return this.abw;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        i.a(this, paramParcel, paramInt);
    }

    public final class Builder {
        private Builder() {
        }

        public LineItem build() {
            return LineItem.this;
        }

        public Builder setCurrencyCode(String paramString) {
            LineItem.this.abd = paramString;
            return this;
        }

        public Builder setDescription(String paramString) {
            LineItem.this.description = paramString;
            return this;
        }

        public Builder setQuantity(String paramString) {
            LineItem.this.abv = paramString;
            return this;
        }

        public Builder setRole(int paramInt) {
            LineItem.this.abx = paramInt;
            return this;
        }

        public Builder setTotalPrice(String paramString) {
            LineItem.this.abc = paramString;
            return this;
        }

        public Builder setUnitPrice(String paramString) {
            LineItem.this.abw = paramString;
            return this;
        }
    }

    public static abstract interface Role {
        public static final int REGULAR = 0;
        public static final int SHIPPING = 2;
        public static final int TAX = 1;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/wallet/LineItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */