package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Contents
        implements SafeParcelable {
    public static final Parcelable.Creator<Contents> CREATOR = new a();
    final ParcelFileDescriptor Cj;
    final int Eu;
    final int Ev;
    final DriveId Ew;
    private boolean Ex = false;
    private boolean Ey = false;
    private boolean mClosed = false;
    final int xH;

    Contents(int paramInt1, ParcelFileDescriptor paramParcelFileDescriptor, int paramInt2, int paramInt3, DriveId paramDriveId) {
        this.xH = paramInt1;
        this.Cj = paramParcelFileDescriptor;
        this.Eu = paramInt2;
        this.Ev = paramInt3;
        this.Ew = paramDriveId;
    }

    public void close() {
        this.mClosed = true;
    }

    public int describeContents() {
        return 0;
    }

    public int fA() {
        return this.Eu;
    }

    public DriveId getDriveId() {
        return this.Ew;
    }

    public InputStream getInputStream() {
        if (this.mClosed) {
            throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
        }
        if (this.Ev != 268435456) {
            throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
        }
        if (this.Ex) {
            throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
        }
        this.Ex = true;
        return new FileInputStream(this.Cj.getFileDescriptor());
    }

    public int getMode() {
        return this.Ev;
    }

    public OutputStream getOutputStream() {
        if (this.mClosed) {
            throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
        }
        if (this.Ev != 536870912) {
            throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
        }
        if (this.Ey) {
            throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
        }
        this.Ey = true;
        return new FileOutputStream(this.Cj.getFileDescriptor());
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        if (this.mClosed) {
            throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
        }
        return this.Cj;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        a.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/Contents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */