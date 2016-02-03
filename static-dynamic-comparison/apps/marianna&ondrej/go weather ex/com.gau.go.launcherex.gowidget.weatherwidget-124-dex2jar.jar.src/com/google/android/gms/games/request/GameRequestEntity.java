package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.fo.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GameRequestEntity
  implements SafeParcelable, GameRequest
{
  public static final GameRequestEntityCreator CREATOR = new GameRequestEntityCreator();
  private final String Jo;
  private final int LF;
  private final GameEntity Lt;
  private final int MB;
  private final long Mu;
  private final byte[] Nf;
  private final PlayerEntity Nm;
  private final ArrayList<PlayerEntity> Nn;
  private final long No;
  private final Bundle Np;
  private final int xH;
  
  GameRequestEntity(int paramInt1, GameEntity paramGameEntity, PlayerEntity paramPlayerEntity, byte[] paramArrayOfByte, String paramString, ArrayList<PlayerEntity> paramArrayList, int paramInt2, long paramLong1, long paramLong2, Bundle paramBundle, int paramInt3)
  {
    this.xH = paramInt1;
    this.Lt = paramGameEntity;
    this.Nm = paramPlayerEntity;
    this.Nf = paramArrayOfByte;
    this.Jo = paramString;
    this.Nn = paramArrayList;
    this.LF = paramInt2;
    this.Mu = paramLong1;
    this.No = paramLong2;
    this.Np = paramBundle;
    this.MB = paramInt3;
  }
  
  public GameRequestEntity(GameRequest paramGameRequest)
  {
    this.xH = 2;
    this.Lt = new GameEntity(paramGameRequest.getGame());
    this.Nm = new PlayerEntity(paramGameRequest.getSender());
    this.Jo = paramGameRequest.getRequestId();
    this.LF = paramGameRequest.getType();
    this.Mu = paramGameRequest.getCreationTimestamp();
    this.No = paramGameRequest.getExpirationTimestamp();
    this.MB = paramGameRequest.getStatus();
    Object localObject = paramGameRequest.getData();
    if (localObject == null) {
      this.Nf = null;
    }
    for (;;)
    {
      localObject = paramGameRequest.getRecipients();
      int j = ((List)localObject).size();
      this.Nn = new ArrayList(j);
      this.Np = new Bundle();
      int i = 0;
      while (i < j)
      {
        Player localPlayer = (Player)((Player)((List)localObject).get(i)).freeze();
        String str = localPlayer.getPlayerId();
        this.Nn.add((PlayerEntity)localPlayer);
        this.Np.putInt(str, paramGameRequest.getRecipientStatus(str));
        i += 1;
      }
      this.Nf = new byte[localObject.length];
      System.arraycopy(localObject, 0, this.Nf, 0, localObject.length);
    }
  }
  
  static int a(GameRequest paramGameRequest)
  {
    return fo.hashCode(new Object[] { paramGameRequest.getGame(), paramGameRequest.getRecipients(), paramGameRequest.getRequestId(), paramGameRequest.getSender(), b(paramGameRequest), Integer.valueOf(paramGameRequest.getType()), Long.valueOf(paramGameRequest.getCreationTimestamp()), Long.valueOf(paramGameRequest.getExpirationTimestamp()) });
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
      if ((!fo.equal(((GameRequest)paramObject).getGame(), paramGameRequest.getGame())) || (!fo.equal(((GameRequest)paramObject).getRecipients(), paramGameRequest.getRecipients())) || (!fo.equal(((GameRequest)paramObject).getRequestId(), paramGameRequest.getRequestId())) || (!fo.equal(((GameRequest)paramObject).getSender(), paramGameRequest.getSender())) || (!Arrays.equals(b((GameRequest)paramObject), b(paramGameRequest))) || (!fo.equal(Integer.valueOf(((GameRequest)paramObject).getType()), Integer.valueOf(paramGameRequest.getType()))) || (!fo.equal(Long.valueOf(((GameRequest)paramObject).getCreationTimestamp()), Long.valueOf(paramGameRequest.getCreationTimestamp())))) {
        break;
      }
      bool1 = bool2;
    } while (fo.equal(Long.valueOf(((GameRequest)paramObject).getExpirationTimestamp()), Long.valueOf(paramGameRequest.getExpirationTimestamp())));
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
    return fo.e(paramGameRequest).a("Game", paramGameRequest.getGame()).a("Sender", paramGameRequest.getSender()).a("Recipients", paramGameRequest.getRecipients()).a("Data", paramGameRequest.getData()).a("RequestId", paramGameRequest.getRequestId()).a("Type", Integer.valueOf(paramGameRequest.getType())).a("CreationTimestamp", Long.valueOf(paramGameRequest.getCreationTimestamp())).a("ExpirationTimestamp", Long.valueOf(paramGameRequest.getExpirationTimestamp())).toString();
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
    return this.Mu;
  }
  
  public byte[] getData()
  {
    return this.Nf;
  }
  
  public long getExpirationTimestamp()
  {
    return this.No;
  }
  
  public Game getGame()
  {
    return this.Lt;
  }
  
  public int getRecipientStatus(String paramString)
  {
    return this.Np.getInt(paramString, 0);
  }
  
  public List<Player> getRecipients()
  {
    return new ArrayList(this.Nn);
  }
  
  public String getRequestId()
  {
    return this.Jo;
  }
  
  public Player getSender()
  {
    return this.Nm;
  }
  
  public int getStatus()
  {
    return this.MB;
  }
  
  public int getType()
  {
    return this.LF;
  }
  
  public int getVersionCode()
  {
    return this.xH;
  }
  
  public Bundle hK()
  {
    return this.Np;
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
  
  public String toString()
  {
    return c(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    GameRequestEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/games/request/GameRequestEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */