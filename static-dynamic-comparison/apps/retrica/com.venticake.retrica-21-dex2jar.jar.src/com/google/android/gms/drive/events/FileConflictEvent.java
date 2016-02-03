package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.ArrayList;

public final class FileConflictEvent
  implements SafeParcelable, DriveEvent
{
  public static final Parcelable.Creator<FileConflictEvent> CREATOR = new c();
  final DriveId Hz;
  final ParcelFileDescriptor Ij;
  final ParcelFileDescriptor Ik;
  final MetadataBundle Il;
  final ArrayList<String> Im;
  private boolean In = false;
  private boolean Io = false;
  private boolean Ip = false;
  final int xM;
  final String yQ;
  
  FileConflictEvent(int paramInt, DriveId paramDriveId, String paramString, ParcelFileDescriptor paramParcelFileDescriptor1, ParcelFileDescriptor paramParcelFileDescriptor2, MetadataBundle paramMetadataBundle, ArrayList<String> paramArrayList)
  {
    this.xM = paramInt;
    this.Hz = paramDriveId;
    this.yQ = paramString;
    this.Ij = paramParcelFileDescriptor1;
    this.Ik = paramParcelFileDescriptor2;
    this.Il = paramMetadataBundle;
    this.Im = paramArrayList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public DriveId getDriveId()
  {
    return this.Hz;
  }
  
  public int getType()
  {
    return 2;
  }
  
  public String toString()
  {
    return String.format("FileConflictEvent [id=%s]", new Object[] { this.Hz });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/events/FileConflictEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */