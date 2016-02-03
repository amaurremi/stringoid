package com.google.android.gms.auth.api;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class GoogleAuthApiRequestCreator
  implements Parcelable.Creator<GoogleAuthApiRequest>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  static void a(GoogleAuthApiRequest paramGoogleAuthApiRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = b.D(paramParcel);
    b.a(paramParcel, 1, paramGoogleAuthApiRequest.name, false);
    b.c(paramParcel, 1000, paramGoogleAuthApiRequest.versionCode);
    b.a(paramParcel, 2, paramGoogleAuthApiRequest.version, false);
    b.a(paramParcel, 3, paramGoogleAuthApiRequest.Dt, false);
    b.a(paramParcel, 4, paramGoogleAuthApiRequest.yR, false);
    b.a(paramParcel, 5, paramGoogleAuthApiRequest.Du, false);
    b.a(paramParcel, 6, paramGoogleAuthApiRequest.Dv, false);
    b.b(paramParcel, 7, paramGoogleAuthApiRequest.Dw, false);
    b.a(paramParcel, 8, paramGoogleAuthApiRequest.Dx, false);
    b.c(paramParcel, 9, paramGoogleAuthApiRequest.Dy);
    b.a(paramParcel, 10, paramGoogleAuthApiRequest.Dz, false);
    b.a(paramParcel, 11, paramGoogleAuthApiRequest.DA, false);
    b.a(paramParcel, 12, paramGoogleAuthApiRequest.DB);
    b.H(paramParcel, paramInt);
  }
  
  public GoogleAuthApiRequest createFromParcel(Parcel paramParcel)
  {
    int k = a.C(paramParcel);
    int j = 0;
    String str6 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    Bundle localBundle2 = null;
    String str2 = null;
    ArrayList localArrayList = null;
    String str1 = null;
    int i = 0;
    Bundle localBundle1 = null;
    byte[] arrayOfByte = null;
    long l = 0L;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.B(paramParcel);
      switch (a.aD(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        str6 = a.o(paramParcel, m);
        break;
      case 1000: 
        j = a.g(paramParcel, m);
        break;
      case 2: 
        str5 = a.o(paramParcel, m);
        break;
      case 3: 
        str4 = a.o(paramParcel, m);
        break;
      case 4: 
        str3 = a.o(paramParcel, m);
        break;
      case 5: 
        localBundle2 = a.q(paramParcel, m);
        break;
      case 6: 
        str2 = a.o(paramParcel, m);
        break;
      case 7: 
        localArrayList = a.C(paramParcel, m);
        break;
      case 8: 
        str1 = a.o(paramParcel, m);
        break;
      case 9: 
        i = a.g(paramParcel, m);
        break;
      case 10: 
        localBundle1 = a.q(paramParcel, m);
        break;
      case 11: 
        arrayOfByte = a.r(paramParcel, m);
        break;
      case 12: 
        l = a.i(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new GoogleAuthApiRequest(j, str6, str5, str4, str3, localBundle2, str2, localArrayList, str1, i, localBundle1, arrayOfByte, l);
  }
  
  public GoogleAuthApiRequest[] newArray(int paramInt)
  {
    return new GoogleAuthApiRequest[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/auth/api/GoogleAuthApiRequestCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */