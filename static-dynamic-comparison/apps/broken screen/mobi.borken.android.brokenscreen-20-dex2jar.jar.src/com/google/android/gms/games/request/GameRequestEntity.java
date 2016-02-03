package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GameRequestEntity
  implements SafeParcelable, GameRequest
{
  public static final GameRequestEntityCreator CREATOR = new GameRequestEntityCreator();
  private final int AQ;
  private final String Oy;
  private final GameEntity Rq;
  private final long SR;
  private final int SY;
  private final byte[] TC;
  private final PlayerEntity TX;
  private final ArrayList<PlayerEntity> TY;
  private final long TZ;
  private final Bundle Ua;
  private final int xJ;
  
  GameRequestEntity(int paramInt1, GameEntity paramGameEntity, PlayerEntity paramPlayerEntity, byte[] paramArrayOfByte, String paramString, ArrayList<PlayerEntity> paramArrayList, int paramInt2, long paramLong1, long paramLong2, Bundle paramBundle, int paramInt3)
  {
    this.xJ = paramInt1;
    this.Rq = paramGameEntity;
    this.TX = paramPlayerEntity;
    this.TC = paramArrayOfByte;
    this.Oy = paramString;
    this.TY = paramArrayList;
    this.AQ = paramInt2;
    this.SR = paramLong1;
    this.TZ = paramLong2;
    this.Ua = paramBundle;
    this.SY = paramInt3;
  }
  
  public GameRequestEntity(GameRequest paramGameRequest)
  {
    this.xJ = 2;
    this.Rq = new GameEntity(paramGameRequest.getGame());
    this.TX = new PlayerEntity(paramGameRequest.getSender());
    this.Oy = paramGameRequest.getRequestId();
    this.AQ = paramGameRequest.getType();
    this.SR = paramGameRequest.getCreationTimestamp();
    this.TZ = paramGameRequest.getExpirationTimestamp();
    this.SY = paramGameRequest.getStatus();
    Object localObject = paramGameRequest.getData();
    if (localObject == null) {
      this.TC = null;
    }
    for (;;)
    {
      localObject = paramGameRequest.getRecipients();
      int j = ((List)localObject).size();
      this.TY = new ArrayList(j);
      this.Ua = new Bundle();
      int i = 0;
      while (i < j)
      {
        Player localPlayer = (Player)((Player)((List)localObject).get(i)).freeze();
        String str = localPlayer.getPlayerId();
        this.TY.add((PlayerEntity)localPlayer);
        this.Ua.putInt(str, paramGameRequest.getRecipientStatus(str));
        i += 1;
      }
      this.TC = new byte[localObject.length];
      System.arraycopy(localObject, 0, this.TC, 0, localObject.length);
    }
  }
  
  static int a(GameRequest paramGameRequest)
  {
    return hl.hashCode(new Object[] { paramGameRequest.getGame(), paramGameRequest.getRecipients(), paramGameRequest.getRequestId(), paramGameRequest.getSender(), b(paramGameRequest), Integer.valueOf(paramGameRequest.getType()), Long.valueOf(paramGameRequest.getCreationTimestamp()), Long.valueOf(paramGameRequest.getExpirationTimestamp()) });
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
      if ((!hl.equal(((GameRequest)paramObject).getGame(), paramGameRequest.getGame())) || (!hl.equal(((GameRequest)paramObject).getRecipients(), paramGameRequest.getRecipients())) || (!hl.equal(((GameRequest)paramObject).getRequestId(), paramGameRequest.getRequestId())) || (!hl.equal(((GameRequest)paramObject).getSender(), paramGameRequest.getSender())) || (!Arrays.equals(b((GameRequest)paramObject), b(paramGameRequest))) || (!hl.equal(Integer.valueOf(((GameRequest)paramObject).getType()), Integer.valueOf(paramGameRequest.getType()))) || (!hl.equal(Long.valueOf(((GameRequest)paramObject).getCreationTimestamp()), Long.valueOf(paramGameRequest.getCreationTimestamp())))) {
        break;
      }
      bool1 = bool2;
    } while (hl.equal(Long.valueOf(((GameRequest)paramObject).getExpirationTimestamp()), Long.valueOf(paramGameRequest.getExpirationTimestamp())));
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
    return hl.e(paramGameRequest).a("Game", paramGameRequest.getGame()).a("Sender", paramGameRequest.getSender()).a("Recipients", paramGameRequest.getRecipients()).a("Data", paramGameRequest.getData()).a("RequestId", paramGameRequest.getRequestId()).a("Type", Integer.valueOf(paramGameRequest.getType())).a("CreationTimestamp", Long.valueOf(paramGameRequest.getCreationTimestamp())).a("ExpirationTimestamp", Long.valueOf(paramGameRequest.getExpirationTimestamp())).toString();
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
    return this.SR;
  }
  
  public byte[] getData()
  {
    return this.TC;
  }
  
  public long getExpirationTimestamp()
  {
    return this.TZ;
  }
  
  public Game getGame()
  {
    return this.Rq;
  }
  
  public int getRecipientStatus(String paramString)
  {
    return this.Ua.getInt(paramString, 0);
  }
  
  public List<Player> getRecipients()
  {
    return new ArrayList(this.TY);
  }
  
  public String getRequestId()
  {
    return this.Oy;
  }
  
  public Player getSender()
  {
    return this.TX;
  }
  
  public int getStatus()
  {
    return this.SY;
  }
  
  public int getType()
  {
    return this.AQ;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public Bundle iG()
  {
    return this.Ua;
  }
  
  public boolean isConsumed(String paramString)
  {
    return getRecipientStatus(paramString) == 1;
  }
  
  public boolean isDataValid()
  {
    return true;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/request/GameRequestEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */