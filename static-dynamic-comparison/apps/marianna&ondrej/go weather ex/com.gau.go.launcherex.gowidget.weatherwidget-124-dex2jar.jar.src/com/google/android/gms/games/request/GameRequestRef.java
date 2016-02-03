package com.google.android.gms.games.request;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.b;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import java.util.ArrayList;
import java.util.List;

public final class GameRequestRef
  extends b
  implements GameRequest
{
  private final int LE;
  
  public GameRequestRef(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    super(paramDataHolder, paramInt1);
    this.LE = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return GameRequestEntity.a(this, paramObject);
  }
  
  public GameRequest freeze()
  {
    return new GameRequestEntity(this);
  }
  
  public long getCreationTimestamp()
  {
    return getLong("creation_timestamp");
  }
  
  public byte[] getData()
  {
    return getByteArray("data");
  }
  
  public long getExpirationTimestamp()
  {
    return getLong("expiration_timestamp");
  }
  
  public Game getGame()
  {
    return new GameRef(this.BB, this.BD);
  }
  
  public int getRecipientStatus(String paramString)
  {
    int i = this.BD;
    while (i < this.BD + this.LE)
    {
      int j = this.BB.G(i);
      if (this.BB.getString("recipient_external_player_id", i, j).equals(paramString)) {
        return this.BB.getInteger("recipient_status", i, j);
      }
      i += 1;
    }
    return -1;
  }
  
  public List<Player> getRecipients()
  {
    ArrayList localArrayList = new ArrayList(this.LE);
    int i = 0;
    while (i < this.LE)
    {
      localArrayList.add(new PlayerRef(this.BB, this.BD + i, "recipient_"));
      i += 1;
    }
    return localArrayList;
  }
  
  public String getRequestId()
  {
    return getString("external_request_id");
  }
  
  public Player getSender()
  {
    return new PlayerRef(this.BB, this.BD, "sender_");
  }
  
  public int getStatus()
  {
    return getInteger("status");
  }
  
  public int getType()
  {
    return getInteger("type");
  }
  
  public int hashCode()
  {
    return GameRequestEntity.a(this);
  }
  
  public boolean isConsumed(String paramString)
  {
    return getRecipientStatus(paramString) == 1;
  }
  
  public String toString()
  {
    return GameRequestEntity.c(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((GameRequestEntity)freeze()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/games/request/GameRequestRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */