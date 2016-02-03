package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableCollaborator
  implements SafeParcelable
{
  public static final Parcelable.Creator<ParcelableCollaborator> CREATOR = new p();
  final int BR;
  final String Nz;
  final boolean Rc;
  final boolean Rd;
  final String Re;
  final String Rf;
  final String Rg;
  final String vL;
  
  ParcelableCollaborator(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.BR = paramInt;
    this.Rc = paramBoolean1;
    this.Rd = paramBoolean2;
    this.vL = paramString1;
    this.Re = paramString2;
    this.Nz = paramString3;
    this.Rf = paramString4;
    this.Rg = paramString5;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ParcelableCollaborator)) {
      return false;
    }
    paramObject = (ParcelableCollaborator)paramObject;
    return this.vL.equals(((ParcelableCollaborator)paramObject).vL);
  }
  
  public int hashCode()
  {
    return this.vL.hashCode();
  }
  
  public String toString()
  {
    return "Collaborator [isMe=" + this.Rc + ", isAnonymous=" + this.Rd + ", sessionId=" + this.vL + ", userId=" + this.Re + ", displayName=" + this.Nz + ", color=" + this.Rf + ", photoUrl=" + this.Rg + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    p.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/ParcelableCollaborator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */