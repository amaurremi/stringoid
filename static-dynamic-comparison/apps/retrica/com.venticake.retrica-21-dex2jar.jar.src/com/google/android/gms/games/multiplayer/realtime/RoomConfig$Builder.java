package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.internal.hm;
import java.util.ArrayList;
import java.util.Arrays;

public final class RoomConfig$Builder
{
  int SY = -1;
  final RoomUpdateListener Tk;
  RoomStatusUpdateListener Tl;
  RealTimeMessageReceivedListener Tm;
  Bundle To;
  boolean Tp = false;
  String Tq = null;
  ArrayList<String> Tr = new ArrayList();
  
  private RoomConfig$Builder(RoomUpdateListener paramRoomUpdateListener)
  {
    this.Tk = ((RoomUpdateListener)hm.b(paramRoomUpdateListener, "Must provide a RoomUpdateListener"));
  }
  
  public Builder addPlayersToInvite(ArrayList<String> paramArrayList)
  {
    hm.f(paramArrayList);
    this.Tr.addAll(paramArrayList);
    return this;
  }
  
  public Builder addPlayersToInvite(String... paramVarArgs)
  {
    hm.f(paramVarArgs);
    this.Tr.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public RoomConfig build()
  {
    return new RoomConfig(this, null);
  }
  
  public Builder setAutoMatchCriteria(Bundle paramBundle)
  {
    this.To = paramBundle;
    return this;
  }
  
  public Builder setInvitationIdToAccept(String paramString)
  {
    hm.f(paramString);
    this.Tq = paramString;
    return this;
  }
  
  public Builder setMessageReceivedListener(RealTimeMessageReceivedListener paramRealTimeMessageReceivedListener)
  {
    this.Tm = paramRealTimeMessageReceivedListener;
    return this;
  }
  
  public Builder setRoomStatusUpdateListener(RoomStatusUpdateListener paramRoomStatusUpdateListener)
  {
    this.Tl = paramRoomStatusUpdateListener;
    return this;
  }
  
  public Builder setSocketCommunicationEnabled(boolean paramBoolean)
  {
    this.Tp = paramBoolean;
    return this;
  }
  
  public Builder setVariant(int paramInt)
  {
    if ((paramInt == -1) || (paramInt > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      hm.b(bool, "Variant must be a positive integer or Room.ROOM_VARIANT_ANY");
      this.SY = paramInt;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/multiplayer/realtime/RoomConfig$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */