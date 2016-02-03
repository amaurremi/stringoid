package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.a;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;

public final class GameRequestCluster
  implements SafeParcelable, GameRequest
{
  public static final GameRequestClusterCreator CREATOR = new GameRequestClusterCreator();
  private final int BR;
  private final ArrayList<GameRequestEntity> abg;
  
  GameRequestCluster(int paramInt, ArrayList<GameRequestEntity> paramArrayList)
  {
    this.BR = paramInt;
    this.abg = paramArrayList;
    lg();
  }
  
  private void lg()
  {
    GameRequest localGameRequest1;
    int i;
    label39:
    GameRequest localGameRequest2;
    if (!this.abg.isEmpty())
    {
      bool = true;
      a.I(bool);
      localGameRequest1 = (GameRequest)this.abg.get(0);
      int j = this.abg.size();
      i = 1;
      if (i >= j) {
        return;
      }
      localGameRequest2 = (GameRequest)this.abg.get(i);
      if (localGameRequest1.getType() != localGameRequest2.getType()) {
        break label116;
      }
    }
    label116:
    for (boolean bool = true;; bool = false)
    {
      a.a(bool, "All the requests must be of the same type");
      a.a(localGameRequest1.getSender().equals(localGameRequest2.getSender()), "All the requests must be from the same sender");
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
    if (((GameRequestCluster)paramObject).abg.size() != this.abg.size()) {
      return false;
    }
    int j = this.abg.size();
    int i = 0;
    while (i < j)
    {
      if (!((GameRequest)this.abg.get(i)).equals((GameRequest)((GameRequestCluster)paramObject).abg.get(i))) {
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
    return ((GameRequestEntity)this.abg.get(0)).getRequestId();
  }
  
  public Player getSender()
  {
    return ((GameRequestEntity)this.abg.get(0)).getSender();
  }
  
  public int getStatus()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public int getType()
  {
    return ((GameRequestEntity)this.abg.get(0)).getType();
  }
  
  public int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return m.hashCode(this.abg.toArray());
  }
  
  public boolean isConsumed(String paramString)
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public ArrayList<GameRequest> lu()
  {
    return new ArrayList(this.abg);
  }
  
  public ArrayList<Player> lv()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    GameRequestClusterCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/internal/request/GameRequestCluster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */