package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Command
        implements Parcelable {
    public static final Parcelable.Creator<Command> CREATOR = new Parcelable.Creator() {
        public Command a(Parcel paramAnonymousParcel) {
            return new Command(paramAnonymousParcel);
        }

        public Command[] a(int paramAnonymousInt) {
            return new Command[paramAnonymousInt];
        }
    };
    private String a;
    private String b;
    private String c;

    public Command() {
    }

    Command(Parcel paramParcel) {
        a(paramParcel);
    }

    public Command(String paramString1, String paramString2, String paramString3) {
        this.a = paramString1;
        this.b = paramString2;
        this.c = paramString3;
    }

    private void a(Parcel paramParcel) {
        this.a = paramParcel.readString();
        this.b = paramParcel.readString();
        this.c = paramParcel.readString();
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.a);
        paramParcel.writeString(this.b);
        paramParcel.writeString(this.c);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/google/android/gms/analytics/internal/Command.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */