package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class a
  implements Parcelable.Creator<ApplicationMetadata>
{
  static void a(ApplicationMetadata paramApplicationMetadata, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    b.c(paramParcel, 1, paramApplicationMetadata.lX());
    b.a(paramParcel, 2, paramApplicationMetadata.lY(), false);
    b.a(paramParcel, 3, paramApplicationMetadata.getName(), false);
    b.b(paramParcel, 4, paramApplicationMetadata.mb(), false);
    b.a(paramParcel, 5, paramApplicationMetadata.qk, false);
    b.a(paramParcel, 6, paramApplicationMetadata.lZ(), false);
    b.a(paramParcel, 7, paramApplicationMetadata.ma(), paramInt, false);
    b.D(paramParcel, i);
  }
  
  public ApplicationMetadata[] bg(int paramInt)
  {
    return new ApplicationMetadata[paramInt];
  }
  
  public ApplicationMetadata d(Parcel paramParcel)
  {
    Uri localUri = null;
    int j = com.google.android.gms.common.internal.safeparcel.a.j(paramParcel);
    int i = 0;
    String str1 = null;
    ArrayList localArrayList1 = null;
    ArrayList localArrayList2 = null;
    String str2 = null;
    String str3 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.a.i(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.br(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
        break;
      case 1: 
        i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
        break;
      case 2: 
        str3 = com.google.android.gms.common.internal.safeparcel.a.m(paramParcel, k);
        break;
      case 3: 
        str2 = com.google.android.gms.common.internal.safeparcel.a.m(paramParcel, k);
        break;
      case 4: 
        localArrayList2 = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, k, WebImage.CREATOR);
        break;
      case 5: 
        localArrayList1 = com.google.android.gms.common.internal.safeparcel.a.y(paramParcel, k);
        break;
      case 6: 
        str1 = com.google.android.gms.common.internal.safeparcel.a.m(paramParcel, k);
        break;
      case 7: 
        localUri = (Uri)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, Uri.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ApplicationMetadata(i, str3, str2, localArrayList2, localArrayList1, str1, localUri);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/cast/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */