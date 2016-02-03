package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.internal.hm;
import java.util.ArrayList;

public final class RoomConfig
{
  private final String NQ;
  private final int SY;
  private final RoomUpdateListener Tk;
  private final RoomStatusUpdateListener Tl;
  private final RealTimeMessageReceivedListener Tm;
  private final String[] Tn;
  private final Bundle To;
  private final boolean Tp;
  
  private RoomConfig(RoomConfig.Builder paramBuilder)
  {
    this.Tk = paramBuilder.Tk;
    this.Tl = paramBuilder.Tl;
    this.Tm = paramBuilder.Tm;
    this.NQ = paramBuilder.Tq;
    this.SY = paramBuilder.SY;
    this.To = paramBuilder.To;
    this.Tp = paramBuilder.Tp;
    int i = paramBuilder.Tr.size();
    this.Tn = ((String[])paramBuilder.Tr.toArray(new String[i]));
    if (this.Tm == null) {
      hm.a(this.Tp, "Must either enable sockets OR specify a message listener");
    }
  }
  
  public static RoomConfig.Builder builder(RoomUpdateListener paramRoomUpdateListener)
  {
    return new RoomConfig.Builder(paramRoomUpdateListener, null);
  }
  
  public static Bundle createAutoMatchCriteria(int paramInt1, int paramInt2, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("min_automatch_players", paramInt1);
    localBundle.putInt("max_automatch_players", paramInt2);
    localBundle.putLong("exclusive_bit_mask", paramLong);
    return localBundle;
  }
  
  public Bundle getAutoMatchCriteria()
  {
    return this.To;
  }
  
  public String getInvitationId()
  {
    return this.NQ;
  }
  
  public String[] getInvitedPlayerIds()
  {
    return this.Tn;
  }
  
  public RealTimeMessageReceivedListener getMessageReceivedListener()
  {
    return this.Tm;
  }
  
  public RoomStatusUpdateListener getRoomStatusUpdateListener()
  {
    return this.Tl;
  }
  
  public RoomUpdateListener getRoomUpdateListener()
  {
    return this.Tk;
  }
  
  public int getVariant()
  {
    return this.SY;
  }
  
  public boolean isSocketEnabled()
  {
    return this.Tp;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/multiplayer/realtime/RoomConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */