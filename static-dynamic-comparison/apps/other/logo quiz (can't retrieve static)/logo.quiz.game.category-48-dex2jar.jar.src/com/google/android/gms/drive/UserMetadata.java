package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class UserMetadata
  implements SafeParcelable
{
  public static final Parcelable.Creator<UserMetadata> CREATOR = new h();
  final int BR;
  final String NA;
  final boolean NB;
  final String NC;
  final String Ny;
  final String Nz;
  
  UserMetadata(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    this.BR = paramInt;
    this.Ny = paramString1;
    this.Nz = paramString2;
    this.NA = paramString3;
    this.NB = paramBoolean;
    this.NC = paramString4;
  }
  
  public UserMetadata(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    this(1, paramString1, paramString2, paramString3, paramBoolean, paramString4);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return String.format("Permission ID: '%s', Display Name: '%s', Picture URL: '%s', Authenticated User: %b, Email: '%s'", new Object[] { this.Ny, this.Nz, this.NA, Boolean.valueOf(this.NB), this.NC });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    h.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/UserMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */