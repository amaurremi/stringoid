package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hk.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GameRequestEntity
  implements SafeParcelable, GameRequest
{
  public static final GameRequestEntityCreator CREATOR = new GameRequestEntityCreator();
  private final int AT;
  private final String OB;
  private final GameEntity Rt;
  private final long SU;
  private final byte[] TF;
  private final int Tb;
  private final PlayerEntity Ua;
  private final ArrayList<PlayerEntity> Ub;
  private final long Uc;
  private final Bundle Ud;
  private final int xM;
  
  GameRequestEntity(int paramInt1, GameEntity paramGameEntity, PlayerEntity paramPlayerEntity, byte[] paramArrayOfByte, String paramString, ArrayList<PlayerEntity> paramArrayList, int paramInt2, long paramLong1, long paramLong2, Bundle paramBundle, int paramInt3)
  {
    this.xM = paramInt1;
    this.Rt = paramGameEntity;
    this.Ua = paramPlayerEntity;
    this.TF = paramArrayOfByte;
    this.OB = paramString;
    this.Ub = paramArrayList;
    this.AT = paramInt2;
    this.SU = paramLong1;
    this.Uc = paramLong2;
    this.Ud = paramBundle;
    this.Tb = paramInt3;
  }
  
  public GameRequestEntity(GameRequest paramGameRequest)
  {
    this.xM = 2;
    this.Rt = new GameEntity(paramGameRequest.getGame());
    this.Ua = new PlayerEntity(paramGameRequest.getSender());
    this.OB = paramGameRequest.getRequestId();
    this.AT = paramGameRequest.getType();
    this.SU = paramGameRequest.getCreationTimestamp();
    this.Uc = paramGameRequest.getExpirationTimestamp();
    this.Tb = paramGameRequest.getStatus();
    Object localObject = paramGameRequest.getData();
    if (localObject == null) {
      this.TF = null;
    }
    for (;;)
    {
      localObject = paramGameRequest.getRecipients();
      int j = ((List)localObject).size();
      this.Ub = new ArrayList(j);
      this.Ud = new Bundle();
      int i = 0;
      while (i < j)
      {
        Player localPlayer = (Player)((Player)((List)localObject).get(i)).freeze();
        String str = localPlayer.getPlayerId();
        this.Ub.add((PlayerEntity)localPlayer);
        this.Ud.putInt(str, paramGameRequest.getRecipientStatus(str));
        i += 1;
      }
      this.TF = new byte[localObject.length];
      System.arraycopy(localObject, 0, this.TF, 0, localObject.length);
    }
  }
  
  static int a(GameRequest paramGameRequest)
  {
    return hk.hashCode(new Object[] { paramGameRequest.getGame(), paramGameRequest.getRecipients(), paramGameRequest.getRequestId(), paramGameRequest.getSender(), b(paramGameRequest), Integer.valueOf(paramGameRequest.getType()), Long.valueOf(paramGameRequest.getCreationTimestamp()), Long.valueOf(paramGameRequest.getExpirationTimestamp()) });
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
      if ((!hk.equal(((GameRequest)paramObject).getGame(), paramGameRequest.getGame())) || (!hk.equal(((GameRequest)paramObject).getRecipients(), paramGameRequest.getRecipients())) || (!hk.equal(((GameRequest)paramObject).getRequestId(), paramGameRequest.getRequestId())) || (!hk.equal(((GameRequest)paramObject).getSender(), paramGameRequest.getSender())) || (!Arrays.equals(b((GameRequest)paramObject), b(paramGameRequest))) || (!hk.equal(Integer.valueOf(((GameRequest)paramObject).getType()), Integer.valueOf(paramGameRequest.getType()))) || (!hk.equal(Long.valueOf(((GameRequest)paramObject).getCreationTimestamp()), Long.valueOf(paramGameRequest.getCreationTimestamp())))) {
        break;
      }
      bool1 = bool2;
    } while (hk.equal(Long.valueOf(((GameRequest)paramObject).getExpirationTimestamp()), Long.valueOf(paramGameRequest.getExpirationTimestamp())));
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
    return hk.e(paramGameRequest).a("Game", paramGameRequest.getGame()).a("Sender", paramGameRequest.getSender()).a("Recipients", paramGameRequest.getRecipients()).a("Data", paramGameRequest.getData()).a("RequestId", paramGameRequest.getRequestId()).a("Type", Integer.valueOf(paramGameRequest.getType())).a("CreationTimestamp", Long.valueOf(paramGameRequest.getCreationTimestamp())).a("ExpirationTimestamp", Long.valueOf(paramGameRequest.getExpirationTimestamp())).toString();
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
    return this.SU;
  }
  
  public byte[] getData()
  {
    return this.TF;
  }
  
  public long getExpirationTimestamp()
  {
    return this.Uc;
  }
  
  public Game getGame()
  {
    return this.Rt;
  }
  
  public int getRecipientStatus(String paramString)
  {
    return this.Ud.getInt(paramString, 0);
  }
  
  public List<Player> getRecipients()
  {
    return new ArrayList(this.Ub);
  }
  
  public String getRequestId()
  {
    return this.OB;
  }
  
  public Player getSender()
  {
    return this.Ua;
  }
  
  public int getStatus()
  {
    return this.Tb;
  }
  
  public int getType()
  {
    return this.AT;
  }
  
  public int getVersionCode()
  {
    return this.xM;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public Bundle iL()
  {
    return this.Ud;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/request/GameRequestEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */