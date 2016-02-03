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
  final int kg;
  private boolean mClosed = false;
  final ParcelFileDescriptor om;
  final int qE;
  final int qF;
  final DriveId qG;
  private boolean qH = false;
  private boolean qI = false;
  
  Contents(int paramInt1, ParcelFileDescriptor paramParcelFileDescriptor, int paramInt2, int paramInt3, DriveId paramDriveId)
  {
    this.kg = paramInt1;
    this.om = paramParcelFileDescriptor;
    this.qE = paramInt2;
    this.qF = paramInt3;
    this.qG = paramDriveId;
  }
  
  public int cJ()
  {
    return this.qE;
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
    return this.qG;
  }
  
  public InputStream getInputStream()
  {
    if (this.mClosed) {
      throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
    }
    if (this.qF != 268435456) {
      throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
    }
    if (this.qH) {
      throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
    }
    this.qH = true;
    return new FileInputStream(this.om.getFileDescriptor());
  }
  
  public int getMode()
  {
    return this.qF;
  }
  
  public OutputStream getOutputStream()
  {
    if (this.mClosed) {
      throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
    }
    if (this.qF != 536870912) {
      throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
    }
    if (this.qI) {
      throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
    }
    this.qI = true;
    return new FileOutputStream(this.om.getFileDescriptor());
  }
  
  public ParcelFileDescriptor getParcelFileDescriptor()
  {
    if (this.mClosed) {
      throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
    }
    return this.om;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/Contents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */