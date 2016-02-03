package com.google.android.gms.games;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class PlayerBuffer
  extends DataBuffer<Player>
{
  public PlayerBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  public Player get(int paramInt)
  {
    return new PlayerRef(this.DD, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/PlayerBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */