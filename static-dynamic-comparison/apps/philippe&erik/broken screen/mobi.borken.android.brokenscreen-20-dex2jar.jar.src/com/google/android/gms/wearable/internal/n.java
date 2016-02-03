package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class n
  implements Parcelable.Creator<m>
{
  static void a(m paramm, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramm.xJ);
    b.a(paramParcel, 2, paramm.getUri(), paramInt, false);
    b.a(paramParcel, 4, paramm.nh(), false);
    b.a(paramParcel, 5, paramm.getData(), false);
    b.G(paramParcel, i);
  }
  
  public m cx(Parcel paramParcel)
  {
    byte[] arrayOfByte = null;
    int j = a.B(paramParcel);
    int i = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = a.A(paramParcel);
      Object localObject3;
      switch (a.ar(k))
      {
      case 3: 
      default: 
        a.b(paramParcel, k);
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      for (;;)
      {
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
        i = a.g(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = (Uri)a.a(paramParcel, k, Uri.CREATOR);
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = a.q(paramParcel, k);
        localObject2 = localObject1;
        localObject1 = localObject3;
        continue;
        arrayOfByte = a.r(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new m(i, (Uri)localObject1, (Bundle)localObject2, arrayOfByte);
  }
  
  public m[] eg(int paramInt)
  {
    return new m[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/wearable/internal/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */