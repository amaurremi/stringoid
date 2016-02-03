package com.google.android.gms.games.request;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.e;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.b;
import com.google.android.gms.games.d;
import java.util.ArrayList;

public final class a
  extends e
  implements GameRequest
{
  private final int IN;
  
  public int ax(String paramString)
  {
    int i = this.se;
    while (i < this.se + this.IN)
    {
      int j = this.rM.bo(i);
      if (this.rM.c("recipient_external_player_id", i, j).equals(paramString)) {
        return this.rM.b("recipient_status", i, j);
      }
      i += 1;
    }
    return -1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return GameRequestEntity.a(this, paramObject);
  }
  
  public byte[] getData()
  {
    return getByteArray("data");
  }
  
  public int getType()
  {
    return getInteger("type");
  }
  
  public int hashCode()
  {
    return GameRequestEntity.a(this);
  }
  
  public Game nX()
  {
    return new b(this.rM, this.se);
  }
  
  public String oE()
  {
    return getString("external_request_id");
  }
  
  public Player oF()
  {
    return new d(this.rM, this.se, "sender_");
  }
  
  public ArrayList<Player> oG()
  {
    ArrayList localArrayList = new ArrayList(this.IN);
    int i = 0;
    while (i < this.IN)
    {
      localArrayList.add(new d(this.rM, this.se + i, "recipient_"));
      i += 1;
    }
    return localArrayList;
  }
  
  public long oH()
  {
    return getLong("expiration_timestamp");
  }
  
  public GameRequest oJ()
  {
    return new GameRequestEntity(this);
  }
  
  public long oa()
  {
    return getLong("creation_timestamp");
  }
  
  public String toString()
  {
    return GameRequestEntity.c(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((GameRequestEntity)oJ()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/games/request/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */