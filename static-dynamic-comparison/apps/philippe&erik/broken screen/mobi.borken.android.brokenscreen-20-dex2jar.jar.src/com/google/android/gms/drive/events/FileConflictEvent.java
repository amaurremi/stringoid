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
  final DriveId Hw;
  final ParcelFileDescriptor Ig;
  final ParcelFileDescriptor Ih;
  final MetadataBundle Ii;
  final ArrayList<String> Ij;
  private boolean Ik = false;
  private boolean Il = false;
  private boolean Im = false;
  final int xJ;
  final String yN;
  
  FileConflictEvent(int paramInt, DriveId paramDriveId, String paramString, ParcelFileDescriptor paramParcelFileDescriptor1, ParcelFileDescriptor paramParcelFileDescriptor2, MetadataBundle paramMetadataBundle, ArrayList<String> paramArrayList)
  {
    this.xJ = paramInt;
    this.Hw = paramDriveId;
    this.yN = paramString;
    this.Ig = paramParcelFileDescriptor1;
    this.Ih = paramParcelFileDescriptor2;
    this.Ii = paramMetadataBundle;
    this.Ij = paramArrayList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public DriveId getDriveId()
  {
    return this.Hw;
  }
  
  public int getType()
  {
    return 2;
  }
  
  public String toString()
  {
    return String.format("FileConflictEvent [id=%s]", new Object[] { this.Hw });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/events/FileConflictEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */