package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.internal.eg;
import java.util.ArrayList;
import java.util.Arrays;

public final class RoomConfig
{
  private final String uf;
  private final RoomUpdateListener wD;
  private final RoomStatusUpdateListener wE;
  private final RealTimeMessageReceivedListener wF;
  private final String[] wG;
  private final Bundle wH;
  private final boolean wI;
  private final int wo;
  
  private RoomConfig(Builder paramBuilder)
  {
    this.wD = paramBuilder.wD;
    this.wE = paramBuilder.wE;
    this.wF = paramBuilder.wF;
    this.uf = paramBuilder.wJ;
    this.wo = paramBuilder.wo;
    this.wH = paramBuilder.wH;
    this.wI = paramBuilder.wI;
    int i = paramBuilder.wK.size();
    this.wG = ((String[])paramBuilder.wK.toArray(new String[i]));
    if (this.wF == null) {
      eg.a(this.wI, "Must either enable sockets OR specify a message listener");
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
    return this.wH;
  }
  
  public String getInvitationId()
  {
    return this.uf;
  }
  
  public String[] getInvitedPlayerIds()
  {
    return this.wG;
  }
  
  public RealTimeMessageReceivedListener getMessageReceivedListener()
  {
    return this.wF;
  }
  
  public RoomStatusUpdateListener getRoomStatusUpdateListener()
  {
    return this.wE;
  }
  
  public RoomUpdateListener getRoomUpdateListener()
  {
    return this.wD;
  }
  
  public int getVariant()
  {
    return this.wo;
  }
  
  public boolean isSocketEnabled()
  {
    return this.wI;
  }
  
  public static final class Builder
  {
    final RoomUpdateListener wD;
    RoomStatusUpdateListener wE;
    RealTimeMessageReceivedListener wF;
    Bundle wH;
    boolean wI = false;
    String wJ = null;
    ArrayList<String> wK = new ArrayList();
    int wo = -1;
    
    private Builder(RoomUpdateListener paramRoomUpdateListener)
    {
      this.wD = ((RoomUpdateListener)eg.b(paramRoomUpdateListener, "Must provide a RoomUpdateListener"));
    }
    
    public Builder addPlayersToInvite(ArrayList<String> paramArrayList)
    {
      eg.f(paramArrayList);
      this.wK.addAll(paramArrayList);
      return this;
    }
    
    public Builder addPlayersToInvite(String... paramVarArgs)
    {
      eg.f(paramVarArgs);
      this.wK.addAll(Arrays.asList(paramVarArgs));
      return this;
    }
    
    public RoomConfig build()
    {
      return new RoomConfig(this, null);
    }
    
    public Builder setAutoMatchCriteria(Bundle paramBundle)
    {
      this.wH = paramBundle;
      return this;
    }
    
    public Builder setInvitationIdToAccept(String paramString)
    {
      eg.f(paramString);
      this.wJ = paramString;
      return this;
    }
    
    public Builder setMessageReceivedListener(RealTimeMessageReceivedListener paramRealTimeMessageReceivedListener)
    {
      this.wF = paramRealTimeMessageReceivedListener;
      return this;
    }
    
    public Builder setRoomStatusUpdateListener(RoomStatusUpdateListener paramRoomStatusUpdateListener)
    {
      this.wE = paramRoomStatusUpdateListener;
      return this;
    }
    
    public Builder setSocketCommunicationEnabled(boolean paramBoolean)
    {
      this.wI = paramBoolean;
      return this;
    }
    
    public Builder setVariant(int paramInt)
    {
      if ((paramInt == -1) || (paramInt > 0)) {}
      for (boolean bool = true;; bool = false)
      {
        eg.b(bool, "Variant must be a positive integer or Room.ROOM_VARIANT_ANY");
        this.wo = paramInt;
        return this;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/games/multiplayer/realtime/RoomConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */