package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableCollaborator
  implements SafeParcelable
{
  public static final Parcelable.Creator<ParcelableCollaborator> CREATOR = new p();
  final boolean Lk;
  final boolean Ll;
  final String Lm;
  final String Ln;
  final String Lo;
  final String Lp;
  final String rR;
  final int xM;
  
  ParcelableCollaborator(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.xM = paramInt;
    this.Lk = paramBoolean1;
    this.Ll = paramBoolean2;
    this.rR = paramString1;
    this.Lm = paramString2;
    this.Ln = paramString3;
    this.Lo = paramString4;
    this.Lp = paramString5;
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
    return this.rR.equals(((ParcelableCollaborator)paramObject).rR);
  }
  
  public int hashCode()
  {
    return this.rR.hashCode();
  }
  
  public String toString()
  {
    return "Collaborator [isMe=" + this.Lk + ", isAnonymous=" + this.Ll + ", sessionId=" + this.rR + ", userId=" + this.Lm + ", displayName=" + this.Ln + ", color=" + this.Lo + ", photoUrl=" + this.Lp + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    p.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/ParcelableCollaborator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */