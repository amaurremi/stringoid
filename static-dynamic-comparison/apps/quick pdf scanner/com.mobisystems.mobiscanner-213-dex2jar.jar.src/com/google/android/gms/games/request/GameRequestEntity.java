package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.cz;
import com.google.android.gms.internal.cz.a;
import java.util.ArrayList;
import java.util.Arrays;

public final class GameRequestEntity
  implements SafeParcelable, GameRequest
{
  public static final b wD = new b();
  private final int qh;
  private final int sw;
  private final GameEntity vL;
  private final long vN;
  private final PlayerEntity wE;
  private final String wF;
  private final ArrayList<PlayerEntity> wG;
  private final long wH;
  private final Bundle wI;
  private final byte[] ww;
  
  GameRequestEntity(int paramInt1, GameEntity paramGameEntity, PlayerEntity paramPlayerEntity, byte[] paramArrayOfByte, String paramString, ArrayList<PlayerEntity> paramArrayList, int paramInt2, long paramLong1, long paramLong2, Bundle paramBundle)
  {
    this.qh = paramInt1;
    this.vL = paramGameEntity;
    this.wE = paramPlayerEntity;
    this.ww = paramArrayOfByte;
    this.wF = paramString;
    this.wG = paramArrayList;
    this.sw = paramInt2;
    this.vN = paramLong1;
    this.wH = paramLong2;
    this.wI = paramBundle;
  }
  
  public GameRequestEntity(GameRequest paramGameRequest)
  {
    this.qh = 1;
    this.vL = new GameEntity(paramGameRequest.nX());
    this.wE = new PlayerEntity(paramGameRequest.oF());
    this.wF = paramGameRequest.oE();
    this.sw = paramGameRequest.getType();
    this.vN = paramGameRequest.oa();
    this.wH = paramGameRequest.oH();
    Object localObject = paramGameRequest.getData();
    if (localObject == null) {
      this.ww = null;
    }
    for (;;)
    {
      localObject = paramGameRequest.oG();
      int j = ((ArrayList)localObject).size();
      this.wG = new ArrayList(j);
      this.wI = new Bundle();
      int i = 0;
      while (i < j)
      {
        Player localPlayer = (Player)((Player)((ArrayList)localObject).get(i)).mM();
        String str = localPlayer.nS();
        this.wG.add((PlayerEntity)localPlayer);
        this.wI.putInt(str, paramGameRequest.ax(str));
        i += 1;
      }
      this.ww = new byte[localObject.length];
      System.arraycopy(localObject, 0, this.ww, 0, localObject.length);
    }
  }
  
  static int a(GameRequest paramGameRequest)
  {
    return cz.hashCode(new Object[] { paramGameRequest.nX(), paramGameRequest.oG(), paramGameRequest.oE(), paramGameRequest.oF(), b(paramGameRequest), Integer.valueOf(paramGameRequest.getType()), Long.valueOf(paramGameRequest.oa()), Long.valueOf(paramGameRequest.oH()) });
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
      if ((!cz.b(((GameRequest)paramObject).nX(), paramGameRequest.nX())) || (!cz.b(((GameRequest)paramObject).oG(), paramGameRequest.oG())) || (!cz.b(((GameRequest)paramObject).oE(), paramGameRequest.oE())) || (!cz.b(((GameRequest)paramObject).oF(), paramGameRequest.oF())) || (!Arrays.equals(b((GameRequest)paramObject), b(paramGameRequest))) || (!cz.b(Integer.valueOf(((GameRequest)paramObject).getType()), Integer.valueOf(paramGameRequest.getType()))) || (!cz.b(Long.valueOf(((GameRequest)paramObject).oa()), Long.valueOf(paramGameRequest.oa())))) {
        break;
      }
      bool1 = bool2;
    } while (cz.b(Long.valueOf(((GameRequest)paramObject).oH()), Long.valueOf(paramGameRequest.oH())));
    return false;
  }
  
  private static int[] b(GameRequest paramGameRequest)
  {
    ArrayList localArrayList = paramGameRequest.oG();
    int j = localArrayList.size();
    int[] arrayOfInt = new int[j];
    int i = 0;
    while (i < j)
    {
      arrayOfInt[i] = paramGameRequest.ax(((Player)localArrayList.get(i)).nS());
      i += 1;
    }
    return arrayOfInt;
  }
  
  static String c(GameRequest paramGameRequest)
  {
    return cz.M(paramGameRequest).a("Game", paramGameRequest.nX()).a("Sender", paramGameRequest.oF()).a("Recipients", paramGameRequest.oG()).a("Data", paramGameRequest.getData()).a("RequestId", paramGameRequest.oE()).a("Type", Integer.valueOf(paramGameRequest.getType())).a("CreationTimestamp", Long.valueOf(paramGameRequest.oa())).a("ExpirationTimestamp", Long.valueOf(paramGameRequest.oH())).toString();
  }
  
  public int ax(String paramString)
  {
    return this.wI.getInt(paramString, 0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public byte[] getData()
  {
    return this.ww;
  }
  
  public int getType()
  {
    return this.sw;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public int lX()
  {
    return this.qh;
  }
  
  public Game nX()
  {
    return this.vL;
  }
  
  public String oE()
  {
    return this.wF;
  }
  
  public Player oF()
  {
    return this.wE;
  }
  
  public ArrayList<Player> oG()
  {
    return new ArrayList(this.wG);
  }
  
  public long oH()
  {
    return this.wH;
  }
  
  public Bundle oI()
  {
    return this.wI;
  }
  
  public GameRequest oJ()
  {
    return this;
  }
  
  public long oa()
  {
    return this.vN;
  }
  
  public String toString()
  {
    return c(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/games/request/GameRequestEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */