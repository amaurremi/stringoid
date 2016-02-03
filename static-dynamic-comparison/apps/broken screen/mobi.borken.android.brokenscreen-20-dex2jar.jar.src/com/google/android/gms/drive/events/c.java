package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.ArrayList;

public class c
  implements Parcelable.Creator<FileConflictEvent>
{
  static void a(FileConflictEvent paramFileConflictEvent, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramFileConflictEvent.xJ);
    b.a(paramParcel, 2, paramFileConflictEvent.Hw, paramInt, false);
    b.a(paramParcel, 3, paramFileConflictEvent.yN, false);
    b.a(paramParcel, 4, paramFileConflictEvent.Ig, paramInt, false);
    b.a(paramParcel, 5, paramFileConflictEvent.Ih, paramInt, false);
    b.a(paramParcel, 6, paramFileConflictEvent.Ii, paramInt, false);
    b.a(paramParcel, 7, paramFileConflictEvent.Ij, false);
    b.G(paramParcel, i);
  }
  
  public FileConflictEvent Q(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int j = a.B(paramParcel);
    int i = 0;
    MetadataBundle localMetadataBundle = null;
    ParcelFileDescriptor localParcelFileDescriptor1 = null;
    ParcelFileDescriptor localParcelFileDescriptor2 = null;
    String str = null;
    DriveId localDriveId = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        localDriveId = (DriveId)a.a(paramParcel, k, DriveId.CREATOR);
        break;
      case 3: 
        str = a.o(paramParcel, k);
        break;
      case 4: 
        localParcelFileDescriptor2 = (ParcelFileDescriptor)a.a(paramParcel, k, ParcelFileDescriptor.CREATOR);
        break;
      case 5: 
        localParcelFileDescriptor1 = (ParcelFileDescriptor)a.a(paramParcel, k, ParcelFileDescriptor.CREATOR);
        break;
      case 6: 
        localMetadataBundle = (MetadataBundle)a.a(paramParcel, k, MetadataBundle.CREATOR);
        break;
      case 7: 
        localArrayList = a.B(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new FileConflictEvent(i, localDriveId, str, localParcelFileDescriptor2, localParcelFileDescriptor1, localMetadataBundle, localArrayList);
  }
  
  public FileConflictEvent[] aL(int paramInt)
  {
    return new FileConflictEvent[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/events/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */