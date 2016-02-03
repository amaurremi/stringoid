package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import java.util.ArrayList;

public class InvitationClusterCreator
  implements Parcelable.Creator<ZInvitationCluster>
{
  static void a(ZInvitationCluster paramZInvitationCluster, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.b(paramParcel, 1, paramZInvitationCluster.ie(), false);
    b.c(paramParcel, 1000, paramZInvitationCluster.getVersionCode());
    b.G(paramParcel, paramInt);
  }
  
  public ZInvitationCluster bi(Parcel paramParcel)
  {
    int j = a.B(paramParcel);
    int i = 0;
    ArrayList localArrayList = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        localArrayList = a.c(paramParcel, k, InvitationEntity.CREATOR);
        break;
      case 1000: 
        i = a.g(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ZInvitationCluster(i, localArrayList);
  }
  
  public ZInvitationCluster[] cs(int paramInt)
  {
    return new ZInvitationCluster[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/internal/multiplayer/InvitationClusterCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */