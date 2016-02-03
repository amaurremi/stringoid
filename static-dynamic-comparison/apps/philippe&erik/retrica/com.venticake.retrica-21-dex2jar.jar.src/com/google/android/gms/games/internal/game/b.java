package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;

final class b
  extends GameBadgeEntityCreator
{
  public GameBadgeEntity bh(Parcel paramParcel)
  {
    if ((GameBadgeEntity.b(GameBadgeEntity.gR())) || (GameBadgeEntity.aQ(GameBadgeEntity.class.getCanonicalName()))) {
      return super.bh(paramParcel);
    }
    int i = paramParcel.readInt();
    String str1 = paramParcel.readString();
    String str2 = paramParcel.readString();
    paramParcel = paramParcel.readString();
    if (paramParcel == null) {}
    for (paramParcel = null;; paramParcel = Uri.parse(paramParcel)) {
      return new GameBadgeEntity(1, i, str1, str2, paramParcel);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/game/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */