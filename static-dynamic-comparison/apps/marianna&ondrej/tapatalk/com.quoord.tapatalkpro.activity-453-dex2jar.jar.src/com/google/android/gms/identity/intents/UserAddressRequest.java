package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class UserAddressRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<UserAddressRequest> CREATOR = new a();
    List<CountrySpecification> Ny;
    private final int xH;

    UserAddressRequest() {
        this.xH = 1;
    }

    UserAddressRequest(int paramInt, List<CountrySpecification> paramList) {
        this.xH = paramInt;
        this.Ny = paramList;
    }

    public static Builder newBuilder() {
        UserAddressRequest localUserAddressRequest = new UserAddressRequest();
        localUserAddressRequest.getClass();
        return new Builder(null);
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        a.a(this, paramParcel, paramInt);
    }

    public final class Builder {
        private Builder() {
        }

        public Builder addAllowedCountrySpecification(CountrySpecification paramCountrySpecification) {
            if (UserAddressRequest.this.Ny == null) {
                UserAddressRequest.this.Ny = new ArrayList();
            }
            UserAddressRequest.this.Ny.add(paramCountrySpecification);
            return this;
        }

        public Builder addAllowedCountrySpecifications(Collection<CountrySpecification> paramCollection) {
            if (UserAddressRequest.this.Ny == null) {
                UserAddressRequest.this.Ny = new ArrayList();
            }
            UserAddressRequest.this.Ny.addAll(paramCollection);
            return this;
        }

        public UserAddressRequest build() {
            if (UserAddressRequest.this.Ny != null) {
                UserAddressRequest.this.Ny = Collections.unmodifiableList(UserAddressRequest.this.Ny);
            }
            return UserAddressRequest.this;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/identity/intents/UserAddressRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */