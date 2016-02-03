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
  public static final Parcelable.Creator<Contents> CREATOR = new i();
  final int CR;
  private boolean mClosed = false;
  final int qh;
  final int sF;
  final DriveId sG;
  private boolean sH = false;
  private boolean sI = false;
  final ParcelFileDescriptor sq;
  
  Contents(int paramInt1, ParcelFileDescriptor paramParcelFileDescriptor, int paramInt2, int paramInt3, DriveId paramDriveId)
  {
    this.qh = paramInt1;
    this.sq = paramParcelFileDescriptor;
    this.sF = paramInt2;
    this.CR = paramInt3;
    this.sG = paramDriveId;
  }
  
  public void close()
  {
    this.mClosed = true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public InputStream getInputStream()
  {
    if (this.mClosed) {
      throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
    }
    if (this.CR != 268435456) {
      throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
    }
    if (this.sH) {
      throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
    }
    this.sH = true;
    return new FileInputStream(this.sq.getFileDescriptor());
  }
  
  public OutputStream getOutputStream()
  {
    if (this.mClosed) {
      throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
    }
    if (this.CR != 536870912) {
      throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
    }
    if (this.sI) {
      throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
    }
    this.sI = true;
    return new FileOutputStream(this.sq.getFileDescriptor());
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    i.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/Contents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */