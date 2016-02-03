package com.google.android.gms.auth.api;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class GoogleAuthApiResponseCreator
  implements Parcelable.Creator<GoogleAuthApiResponse>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  static void a(GoogleAuthApiResponse paramGoogleAuthApiResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = b.D(paramParcel);
    b.c(paramParcel, 1, paramGoogleAuthApiResponse.responseCode);
    b.c(paramParcel, 1000, paramGoogleAuthApiResponse.versionCode);
    b.a(paramParcel, 2, paramGoogleAuthApiResponse.Dz, false);
    b.a(paramParcel, 3, paramGoogleAuthApiResponse.DA, false);
    b.H(paramParcel, paramInt);
  }
  
  public GoogleAuthApiResponse createFromParcel(Parcel paramParcel)
  {
    byte[] arrayOfByte = null;
    int j = 0;
    int k = a.C(paramParcel);
    Bundle localBundle = null;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.B(paramParcel);
      switch (a.aD(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        j = a.g(paramParcel, m);
        break;
      case 1000: 
        i = a.g(paramParcel, m);
        break;
      case 2: 
        localBundle = a.q(paramParcel, m);
        break;
      case 3: 
        arrayOfByte = a.r(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new GoogleAuthApiResponse(i, j, localBundle, arrayOfByte);
  }
  
  public GoogleAuthApiResponse[] newArray(int paramInt)
  {
    return new GoogleAuthApiResponse[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/auth/api/GoogleAuthApiResponseCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */