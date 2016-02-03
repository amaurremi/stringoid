package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.internal.hn;
import java.util.ArrayList;
import java.util.Arrays;

public final class RoomConfig
{
  private final String NN;
  private final int SV;
  private final RoomUpdateListener Th;
  private final RoomStatusUpdateListener Ti;
  private final RealTimeMessageReceivedListener Tj;
  private final String[] Tk;
  private final Bundle Tl;
  private final boolean Tm;
  
  private RoomConfig(Builder paramBuilder)
  {
    this.Th = paramBuilder.Th;
    this.Ti = paramBuilder.Ti;
    this.Tj = paramBuilder.Tj;
    this.NN = paramBuilder.Tn;
    this.SV = paramBuilder.SV;
    this.Tl = paramBuilder.Tl;
    this.Tm = paramBuilder.Tm;
    int i = paramBuilder.To.size();
    this.Tk = ((String[])paramBuilder.To.toArray(new String[i]));
    if (this.Tj == null) {
      hn.a(this.Tm, "Must either enable sockets OR specify a message listener");
    }
  }
  
  public static Builder builder(RoomUpdateListener paramRoomUpdateListener)
  {
    return new Builder(paramRoomUpdateListener, null);
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
    return this.Tl;
  }
  
  public String getInvitationId()
  {
    return this.NN;
  }
  
  public String[] getInvitedPlayerIds()
  {
    return this.Tk;
  }
  
  public RealTimeMessageReceivedListener getMessageReceivedListener()
  {
    return this.Tj;
  }
  
  public RoomStatusUpdateListener getRoomStatusUpdateListener()
  {
    return this.Ti;
  }
  
  public RoomUpdateListener getRoomUpdateListener()
  {
    return this.Th;
  }
  
  public int getVariant()
  {
    return this.SV;
  }
  
  public boolean isSocketEnabled()
  {
    return this.Tm;
  }
  
  public static final class Builder
  {
    int SV = -1;
    final RoomUpdateListener Th;
    RoomStatusUpdateListener Ti;
    RealTimeMessageReceivedListener Tj;
    Bundle Tl;
    boolean Tm = false;
    String Tn = null;
    ArrayList<String> To = new ArrayList();
    
    private Builder(RoomUpdateListener paramRoomUpdateListener)
    {
      this.Th = ((RoomUpdateListener)hn.b(paramRoomUpdateListener, "Must provide a RoomUpdateListener"));
    }
    
    public Builder addPlayersToInvite(ArrayList<String> paramArrayList)
    {
      hn.f(paramArrayList);
      this.To.addAll(paramArrayList);
      return this;
    }
    
    public Builder addPlayersToInvite(String... paramVarArgs)
    {
      hn.f(paramVarArgs);
      this.To.addAll(Arrays.asList(paramVarArgs));
      return this;
    }
    
    public RoomConfig build()
    {
      return new RoomConfig(this, null);
    }
    
    public Builder setAutoMatchCriteria(Bundle paramBundle)
    {
      this.Tl = paramBundle;
      return this;
    }
    
    public Builder setInvitationIdToAccept(String paramString)
    {
      hn.f(paramString);
      this.Tn = paramString;
      return this;
    }
    
    public Builder setMessageReceivedListener(RealTimeMessageReceivedListener paramRealTimeMessageReceivedListener)
    {
      this.Tj = paramRealTimeMessageReceivedListener;
      return this;
    }
    
    public Builder setRoomStatusUpdateListener(RoomStatusUpdateListener paramRoomStatusUpdateListener)
    {
      this.Ti = paramRoomStatusUpdateListener;
      return this;
    }
    
    public Builder setSocketCommunicationEnabled(boolean paramBoolean)
    {
      this.Tm = paramBoolean;
      return this;
    }
    
    public Builder setVariant(int paramInt)
    {
      if ((paramInt == -1) || (paramInt > 0)) {}
      for (boolean bool = true;; bool = false)
      {
        hn.b(bool, "Variant must be a positive integer or Room.ROOM_VARIANT_ANY");
        this.SV = paramInt;
        return this;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/multiplayer/realtime/RoomConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */