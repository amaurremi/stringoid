package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableCollaborator
  implements SafeParcelable
{
  public static final Parcelable.Creator<ParcelableCollaborator> CREATOR = new p();
  final boolean Lh;
  final boolean Li;
  final String Lj;
  final String Lk;
  final String Ll;
  final String Lm;
  final String rO;
  final int xJ;
  
  ParcelableCollaborator(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.xJ = paramInt;
    this.Lh = paramBoolean1;
    this.Li = paramBoolean2;
    this.rO = paramString1;
    this.Lj = paramString2;
    this.Lk = paramString3;
    this.Ll = paramString4;
    this.Lm = paramString5;
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
    return this.rO.equals(((ParcelableCollaborator)paramObject).rO);
  }
  
  public int hashCode()
  {
    return this.rO.hashCode();
  }
  
  public String toString()
  {
    return "Collaborator [isMe=" + this.Lh + ", isAnonymous=" + this.Li + ", sessionId=" + this.rO + ", userId=" + this.Lj + ", displayName=" + this.Lk + ", color=" + this.Ll + ", photoUrl=" + this.Lm + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    p.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/ParcelableCollaborator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */