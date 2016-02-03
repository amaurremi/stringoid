package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestEntity;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hl;
import java.util.ArrayList;

public final class GameRequestCluster
  implements SafeParcelable, GameRequest
{
  public static final GameRequestClusterCreator CREATOR = new GameRequestClusterCreator();
  private final ArrayList<GameRequestEntity> Sj;
  private final int xJ;
  
  GameRequestCluster(int paramInt, ArrayList<GameRequestEntity> paramArrayList)
  {
    this.xJ = paramInt;
    this.Sj = paramArrayList;
    id();
  }
  
  private void id()
  {
    GameRequest localGameRequest1;
    int i;
    label39:
    GameRequest localGameRequest2;
    if (!this.Sj.isEmpty())
    {
      bool = true;
      gy.A(bool);
      localGameRequest1 = (GameRequest)this.Sj.get(0);
      int j = this.Sj.size();
      i = 1;
      if (i >= j) {
        return;
      }
      localGameRequest2 = (GameRequest)this.Sj.get(i);
      if (localGameRequest1.getType() != localGameRequest2.getType()) {
        break label116;
      }
    }
    label116:
    for (boolean bool = true;; bool = false)
    {
      gy.a(bool, "All the requests must be of the same type");
      gy.a(localGameRequest1.getSender().equals(localGameRequest2.getSender()), "All the requests must be from the same sender");
      i += 1;
      break label39;
      bool = false;
      break;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof GameRequestCluster)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (GameRequestCluster)paramObject;
    if (((GameRequestCluster)paramObject).Sj.size() != this.Sj.size()) {
      return false;
    }
    int j = this.Sj.size();
    int i = 0;
    while (i < j)
    {
      if (!((GameRequest)this.Sj.get(i)).equals((GameRequest)((GameRequestCluster)paramObject).Sj.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public GameRequest freeze()
  {
    return this;
  }
  
  public long getCreationTimestamp()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public byte[] getData()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public long getExpirationTimestamp()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public Game getGame()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public int getRecipientStatus(String paramString)
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public String getRequestId()
  {
    return ((GameRequestEntity)this.Sj.get(0)).getRequestId();
  }
  
  public Player getSender()
  {
    return ((GameRequestEntity)this.Sj.get(0)).getSender();
  }
  
  public int getStatus()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public int getType()
  {
    return ((GameRequestEntity)this.Sj.get(0)).getType();
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    return hl.hashCode(this.Sj.toArray());
  }
  
  public ArrayList<GameRequest> ir()
  {
    return new ArrayList(this.Sj);
  }
  
  public ArrayList<Player> is()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public boolean isConsumed(String paramString)
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    GameRequestClusterCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/internal/request/GameRequestCluster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */