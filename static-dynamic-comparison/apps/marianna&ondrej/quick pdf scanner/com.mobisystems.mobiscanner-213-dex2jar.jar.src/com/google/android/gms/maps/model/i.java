package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class i
  implements Parcelable.Creator<PolygonOptions>
{
  static void a(PolygonOptions paramPolygonOptions, Parcel paramParcel, int paramInt)
  {
    paramInt = b.k(paramParcel);
    b.c(paramParcel, 1, paramPolygonOptions.lX());
    b.b(paramParcel, 2, paramPolygonOptions.vh(), false);
    b.c(paramParcel, 3, paramPolygonOptions.vg(), false);
    b.a(paramParcel, 4, paramPolygonOptions.getStrokeWidth());
    b.c(paramParcel, 5, paramPolygonOptions.uQ());
    b.c(paramParcel, 6, paramPolygonOptions.uR());
    b.a(paramParcel, 7, paramPolygonOptions.uS());
    b.a(paramParcel, 8, paramPolygonOptions.isVisible());
    b.a(paramParcel, 9, paramPolygonOptions.vi());
    b.D(paramParcel, paramInt);
  }
  
  public PolygonOptions bq(Parcel paramParcel)
  {
    float f1 = 0.0F;
    boolean bool1 = false;
    int m = a.j(paramParcel);
    ArrayList localArrayList1 = null;
    ArrayList localArrayList2 = new ArrayList();
    boolean bool2 = false;
    int i = 0;
    int j = 0;
    float f2 = 0.0F;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.i(paramParcel);
      switch (a.br(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        k = a.g(paramParcel, n);
        break;
      case 2: 
        localArrayList1 = a.c(paramParcel, n, LatLng.Vo);
        break;
      case 3: 
        a.a(paramParcel, n, localArrayList2, getClass().getClassLoader());
        break;
      case 4: 
        f2 = a.j(paramParcel, n);
        break;
      case 5: 
        j = a.g(paramParcel, n);
        break;
      case 6: 
        i = a.g(paramParcel, n);
        break;
      case 7: 
        f1 = a.j(paramParcel, n);
        break;
      case 8: 
        bool2 = a.c(paramParcel, n);
        break;
      case 9: 
        bool1 = a.c(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new PolygonOptions(k, localArrayList1, localArrayList2, f2, j, i, f1, bool2, bool1);
  }
  
  public PolygonOptions[] dY(int paramInt)
  {
    return new PolygonOptions[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/maps/model/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */