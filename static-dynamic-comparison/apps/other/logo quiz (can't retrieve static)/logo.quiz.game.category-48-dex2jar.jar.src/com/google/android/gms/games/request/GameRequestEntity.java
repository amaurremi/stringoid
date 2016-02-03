package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GameRequestEntity
  implements SafeParcelable, GameRequest
{
  public static final GameRequestEntityCreator CREATOR = new GameRequestEntityCreator();
  private final int BR;
  private final int FD;
  private final int Fa;
  private final String Xr;
  private final GameEntity aan;
  private final long abO;
  private final PlayerEntity acR;
  private final ArrayList<PlayerEntity> acS;
  private final long acT;
  private final Bundle acU;
  private final byte[] acw;
  
  GameRequestEntity(int paramInt1, GameEntity paramGameEntity, PlayerEntity paramPlayerEntity, byte[] paramArrayOfByte, String paramString, ArrayList<PlayerEntity> paramArrayList, int paramInt2, long paramLong1, long paramLong2, Bundle paramBundle, int paramInt3)
  {
    this.BR = paramInt1;
    this.aan = paramGameEntity;
    this.acR = paramPlayerEntity;
    this.acw = paramArrayOfByte;
    this.Xr = paramString;
    this.acS = paramArrayList;
    this.FD = paramInt2;
    this.abO = paramLong1;
    this.acT = paramLong2;
    this.acU = paramBundle;
    this.Fa = paramInt3;
  }
  
  public GameRequestEntity(GameRequest paramGameRequest)
  {
    this.BR = 2;
    this.aan = new GameEntity(paramGameRequest.getGame());
    this.acR = new PlayerEntity(paramGameRequest.getSender());
    this.Xr = paramGameRequest.getRequestId();
    this.FD = paramGameRequest.getType();
    this.abO = paramGameRequest.getCreationTimestamp();
    this.acT = paramGameRequest.getExpirationTimestamp();
    this.Fa = paramGameRequest.getStatus();
    Object localObject = paramGameRequest.getData();
    if (localObject == null) {
      this.acw = null;
    }
    for (;;)
    {
      localObject = paramGameRequest.getRecipients();
      int j = ((List)localObject).size();
      this.acS = new ArrayList(j);
      this.acU = new Bundle();
      int i = 0;
      while (i < j)
      {
        Player localPlayer = (Player)((Player)((List)localObject).get(i)).freeze();
        String str = localPlayer.getPlayerId();
        this.acS.add((PlayerEntity)localPlayer);
        this.acU.putInt(str, paramGameRequest.getRecipientStatus(str));
        i += 1;
      }
      this.acw = new byte[localObject.length];
      System.arraycopy(localObject, 0, this.acw, 0, localObject.length);
    }
  }
  
  static int a(GameRequest paramGameRequest)
  {
    return m.hashCode(new Object[] { paramGameRequest.getGame(), paramGameRequest.getRecipients(), paramGameRequest.getRequestId(), paramGameRequest.getSender(), b(paramGameRequest), Integer.valueOf(paramGameRequest.getType()), Long.valueOf(paramGameRequest.getCreationTimestamp()), Long.valueOf(paramGameRequest.getExpirationTimestamp()) });
  }
  
  static boolean a(GameRequest paramGameRequest, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof GameRequest)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramGameRequest == paramObject);
      paramObject = (GameRequest)paramObject;
      if ((!m.equal(((GameRequest)paramObject).getGame(), paramGameRequest.getGame())) || (!m.equal(((GameRequest)paramObject).getRecipients(), paramGameRequest.getRecipients())) || (!m.equal(((GameRequest)paramObject).getRequestId(), paramGameRequest.getRequestId())) || (!m.equal(((GameRequest)paramObject).getSender(), paramGameRequest.getSender())) || (!Arrays.equals(b((GameRequest)paramObject), b(paramGameRequest))) || (!m.equal(Integer.valueOf(((GameRequest)paramObject).getType()), Integer.valueOf(paramGameRequest.getType()))) || (!m.equal(Long.valueOf(((GameRequest)paramObject).getCreationTimestamp()), Long.valueOf(paramGameRequest.getCreationTimestamp())))) {
        break;
      }
      bool1 = bool2;
    } while (m.equal(Long.valueOf(((GameRequest)paramObject).getExpirationTimestamp()), Long.valueOf(paramGameRequest.getExpirationTimestamp())));
    return false;
  }
  
  private static int[] b(GameRequest paramGameRequest)
  {
    List localList = paramGameRequest.getRecipients();
    int j = localList.size();
    int[] arrayOfInt = new int[j];
    int i = 0;
    while (i < j)
    {
      arrayOfInt[i] = paramGameRequest.getRecipientStatus(((Player)localList.get(i)).getPlayerId());
      i += 1;
    }
    return arrayOfInt;
  }
  
  static String c(GameRequest paramGameRequest)
  {
    return m.h(paramGameRequest).a("Game", paramGameRequest.getGame()).a("Sender", paramGameRequest.getSender()).a("Recipients", paramGameRequest.getRecipients()).a("Data", paramGameRequest.getData()).a("RequestId", paramGameRequest.getRequestId()).a("Type", Integer.valueOf(paramGameRequest.getType())).a("CreationTimestamp", Long.valueOf(paramGameRequest.getCreationTimestamp())).a("ExpirationTimestamp", Long.valueOf(paramGameRequest.getExpirationTimestamp())).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public GameRequest freeze()
  {
    return this;
  }
  
  public long getCreationTimestamp()
  {
    return this.abO;
  }
  
  public byte[] getData()
  {
    return this.acw;
  }
  
  public long getExpirationTimestamp()
  {
    return this.acT;
  }
  
  public Game getGame()
  {
    return this.aan;
  }
  
  public int getRecipientStatus(String paramString)
  {
    return this.acU.getInt(paramString, 0);
  }
  
  public List<Player> getRecipients()
  {
    return new ArrayList(this.acS);
  }
  
  public String getRequestId()
  {
    return this.Xr;
  }
  
  public Player getSender()
  {
    return this.acR;
  }
  
  public int getStatus()
  {
    return this.Fa;
  }
  
  public int getType()
  {
    return this.FD;
  }
  
  public int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isConsumed(String paramString)
  {
    return getRecipientStatus(paramString) == 1;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public Bundle lJ()
  {
    return this.acU;
  }
  
  public String toString()
  {
    return c(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    GameRequestEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/request/GameRequestEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */