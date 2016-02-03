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
  implements SafeParcelable
{
  public static final Parcelable.Creator<Contents> CREATOR = new a();
  final ParcelFileDescriptor Fj;
  String HA;
  boolean HB;
  private boolean HC = false;
  private boolean HD = false;
  private boolean HE = false;
  final int Hy;
  final DriveId Hz;
  private boolean mClosed = false;
  final int ra;
  final int xM;
  
  Contents(int paramInt1, ParcelFileDescriptor paramParcelFileDescriptor, int paramInt2, int paramInt3, DriveId paramDriveId, String paramString, boolean paramBoolean)
  {
    this.xM = paramInt1;
    this.Fj = paramParcelFileDescriptor;
    this.ra = paramInt2;
    this.Hy = paramInt3;
    this.Hz = paramDriveId;
    this.HA = paramString;
    this.HB = paramBoolean;
  }
  
  public void close()
  {
    this.mClosed = true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public DriveId getDriveId()
  {
    return this.Hz;
  }
  
  public InputStream getInputStream()
  {
    if (this.mClosed) {
      throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
    }
    if (this.Hy != 268435456) {
      throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
    }
    if (this.HC) {
      throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
    }
    this.HC = true;
    return new FileInputStream(this.Fj.getFileDescriptor());
  }
  
  public int getMode()
  {
    return this.Hy;
  }
  
  public OutputStream getOutputStream()
  {
    if (this.mClosed) {
      throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
    }
    if (this.Hy != 536870912) {
      throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
    }
    if (this.HD) {
      throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
    }
    this.HD = true;
    return new FileOutputStream(this.Fj.getFileDescriptor());
  }
  
  public ParcelFileDescriptor getParcelFileDescriptor()
  {
    if (this.mClosed) {
      throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
    }
    return this.Fj;
  }
  
  public int getRequestId()
  {
    return this.ra;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/Contents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */