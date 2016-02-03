package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

@Deprecated
public class Contents
  implements SafeParcelable
{
  public static final Parcelable.Creator<Contents> CREATOR = new a();
  final int BR;
  final ParcelFileDescriptor Kx;
  final int MN;
  final DriveId MO;
  final boolean MP;
  private boolean MQ = false;
  private boolean MR = false;
  private boolean mClosed = false;
  final int uQ;
  
  Contents(int paramInt1, ParcelFileDescriptor paramParcelFileDescriptor, int paramInt2, int paramInt3, DriveId paramDriveId, boolean paramBoolean)
  {
    this.BR = paramInt1;
    this.Kx = paramParcelFileDescriptor;
    this.uQ = paramInt2;
    this.MN = paramInt3;
    this.MO = paramDriveId;
    this.MP = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public DriveId getDriveId()
  {
    return this.MO;
  }
  
  public InputStream getInputStream()
  {
    if (this.mClosed) {
      throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
    }
    if (this.MN != 268435456) {
      throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
    }
    if (this.MQ) {
      throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
    }
    this.MQ = true;
    return new FileInputStream(this.Kx.getFileDescriptor());
  }
  
  public int getMode()
  {
    return this.MN;
  }
  
  public OutputStream getOutputStream()
  {
    if (this.mClosed) {
      throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
    }
    if (this.MN != 536870912) {
      throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
    }
    if (this.MR) {
      throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
    }
    this.MR = true;
    return new FileOutputStream(this.Kx.getFileDescriptor());
  }
  
  public ParcelFileDescriptor getParcelFileDescriptor()
  {
    if (this.mClosed) {
      throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
    }
    return this.Kx;
  }
  
  public int getRequestId()
  {
    return this.uQ;
  }
  
  public void hJ()
  {
    this.mClosed = true;
  }
  
  public boolean hK()
  {
    return this.mClosed;
  }
  
  public boolean hL()
  {
    return this.MP;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/Contents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */