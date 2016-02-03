package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.cz;
import com.google.android.gms.internal.cz.a;
import java.util.ArrayList;

public final class TurnBasedMatchEntity
  implements SafeParcelable, TurnBasedMatch
{
  public static final c wp = new c();
  private final int qh;
  private final GameEntity vL;
  private final long vN;
  private final ArrayList<ParticipantEntity> vQ;
  private final int vR;
  private final String vf;
  private final int wA;
  private final boolean wB;
  private final String wC;
  private final String wk;
  private final Bundle wm;
  private final String wq;
  private final String wr;
  private final long ws;
  private final String wt;
  private final int wu;
  private final int wv;
  private final byte[] ww;
  private final String wx;
  private final byte[] wy;
  private final int wz;
  
  TurnBasedMatchEntity(int paramInt1, GameEntity paramGameEntity, String paramString1, String paramString2, long paramLong1, String paramString3, long paramLong2, String paramString4, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte1, ArrayList<ParticipantEntity> paramArrayList, String paramString5, byte[] paramArrayOfByte2, int paramInt5, Bundle paramBundle, int paramInt6, boolean paramBoolean, String paramString6, String paramString7)
  {
    this.qh = paramInt1;
    this.vL = paramGameEntity;
    this.wq = paramString1;
    this.wk = paramString2;
    this.vN = paramLong1;
    this.wr = paramString3;
    this.ws = paramLong2;
    this.wt = paramString4;
    this.wu = paramInt2;
    this.wA = paramInt6;
    this.vR = paramInt3;
    this.wv = paramInt4;
    this.ww = paramArrayOfByte1;
    this.vQ = paramArrayList;
    this.wx = paramString5;
    this.wy = paramArrayOfByte2;
    this.wz = paramInt5;
    this.wm = paramBundle;
    this.wB = paramBoolean;
    this.vf = paramString6;
    this.wC = paramString7;
  }
  
  public TurnBasedMatchEntity(TurnBasedMatch paramTurnBasedMatch)
  {
    this.qh = 2;
    this.vL = new GameEntity(paramTurnBasedMatch.nX());
    this.wq = paramTurnBasedMatch.ot();
    this.wk = paramTurnBasedMatch.op();
    this.vN = paramTurnBasedMatch.oa();
    this.wr = paramTurnBasedMatch.ov();
    this.ws = paramTurnBasedMatch.ow();
    this.wt = paramTurnBasedMatch.ox();
    this.wu = paramTurnBasedMatch.getStatus();
    this.wA = paramTurnBasedMatch.ou();
    this.vR = paramTurnBasedMatch.oc();
    this.wv = paramTurnBasedMatch.getVersion();
    this.wx = paramTurnBasedMatch.oy();
    this.wz = paramTurnBasedMatch.oA();
    this.wm = paramTurnBasedMatch.oq();
    this.wB = paramTurnBasedMatch.oB();
    this.vf = paramTurnBasedMatch.getDescription();
    this.wC = paramTurnBasedMatch.oC();
    byte[] arrayOfByte = paramTurnBasedMatch.getData();
    if (arrayOfByte == null)
    {
      this.ww = null;
      arrayOfByte = paramTurnBasedMatch.oz();
      if (arrayOfByte != null) {
        break label313;
      }
      this.wy = null;
    }
    for (;;)
    {
      paramTurnBasedMatch = paramTurnBasedMatch.oe();
      int j = paramTurnBasedMatch.size();
      this.vQ = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        this.vQ.add((ParticipantEntity)((Participant)paramTurnBasedMatch.get(i)).mM());
        i += 1;
      }
      this.ww = new byte[arrayOfByte.length];
      System.arraycopy(arrayOfByte, 0, this.ww, 0, arrayOfByte.length);
      break;
      label313:
      this.wy = new byte[arrayOfByte.length];
      System.arraycopy(arrayOfByte, 0, this.wy, 0, arrayOfByte.length);
    }
  }
  
  static int a(TurnBasedMatch paramTurnBasedMatch)
  {
    return cz.hashCode(new Object[] { paramTurnBasedMatch.nX(), paramTurnBasedMatch.ot(), paramTurnBasedMatch.op(), Long.valueOf(paramTurnBasedMatch.oa()), paramTurnBasedMatch.ov(), Long.valueOf(paramTurnBasedMatch.ow()), paramTurnBasedMatch.ox(), Integer.valueOf(paramTurnBasedMatch.getStatus()), Integer.valueOf(paramTurnBasedMatch.ou()), paramTurnBasedMatch.getDescription(), Integer.valueOf(paramTurnBasedMatch.oc()), Integer.valueOf(paramTurnBasedMatch.getVersion()), paramTurnBasedMatch.oe(), paramTurnBasedMatch.oy(), Integer.valueOf(paramTurnBasedMatch.oA()), paramTurnBasedMatch.oq(), Integer.valueOf(paramTurnBasedMatch.od()), Boolean.valueOf(paramTurnBasedMatch.oB()) });
  }
  
  static boolean a(TurnBasedMatch paramTurnBasedMatch, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof TurnBasedMatch)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramTurnBasedMatch == paramObject);
      paramObject = (TurnBasedMatch)paramObject;
      if ((!cz.b(((TurnBasedMatch)paramObject).nX(), paramTurnBasedMatch.nX())) || (!cz.b(((TurnBasedMatch)paramObject).ot(), paramTurnBasedMatch.ot())) || (!cz.b(((TurnBasedMatch)paramObject).op(), paramTurnBasedMatch.op())) || (!cz.b(Long.valueOf(((TurnBasedMatch)paramObject).oa()), Long.valueOf(paramTurnBasedMatch.oa()))) || (!cz.b(((TurnBasedMatch)paramObject).ov(), paramTurnBasedMatch.ov())) || (!cz.b(Long.valueOf(((TurnBasedMatch)paramObject).ow()), Long.valueOf(paramTurnBasedMatch.ow()))) || (!cz.b(((TurnBasedMatch)paramObject).ox(), paramTurnBasedMatch.ox())) || (!cz.b(Integer.valueOf(((TurnBasedMatch)paramObject).getStatus()), Integer.valueOf(paramTurnBasedMatch.getStatus()))) || (!cz.b(Integer.valueOf(((TurnBasedMatch)paramObject).ou()), Integer.valueOf(paramTurnBasedMatch.ou()))) || (!cz.b(((TurnBasedMatch)paramObject).getDescription(), paramTurnBasedMatch.getDescription())) || (!cz.b(Integer.valueOf(((TurnBasedMatch)paramObject).oc()), Integer.valueOf(paramTurnBasedMatch.oc()))) || (!cz.b(Integer.valueOf(((TurnBasedMatch)paramObject).getVersion()), Integer.valueOf(paramTurnBasedMatch.getVersion()))) || (!cz.b(((TurnBasedMatch)paramObject).oe(), paramTurnBasedMatch.oe())) || (!cz.b(((TurnBasedMatch)paramObject).oy(), paramTurnBasedMatch.oy())) || (!cz.b(Integer.valueOf(((TurnBasedMatch)paramObject).oA()), Integer.valueOf(paramTurnBasedMatch.oA()))) || (!cz.b(((TurnBasedMatch)paramObject).oq(), paramTurnBasedMatch.oq())) || (!cz.b(Integer.valueOf(((TurnBasedMatch)paramObject).od()), Integer.valueOf(paramTurnBasedMatch.od())))) {
        break;
      }
      bool1 = bool2;
    } while (cz.b(Boolean.valueOf(((TurnBasedMatch)paramObject).oB()), Boolean.valueOf(paramTurnBasedMatch.oB())));
    return false;
  }
  
  static String b(TurnBasedMatch paramTurnBasedMatch)
  {
    return cz.M(paramTurnBasedMatch).a("Game", paramTurnBasedMatch.nX()).a("MatchId", paramTurnBasedMatch.ot()).a("CreatorId", paramTurnBasedMatch.op()).a("CreationTimestamp", Long.valueOf(paramTurnBasedMatch.oa())).a("LastUpdaterId", paramTurnBasedMatch.ov()).a("LastUpdatedTimestamp", Long.valueOf(paramTurnBasedMatch.ow())).a("PendingParticipantId", paramTurnBasedMatch.ox()).a("MatchStatus", Integer.valueOf(paramTurnBasedMatch.getStatus())).a("TurnStatus", Integer.valueOf(paramTurnBasedMatch.ou())).a("Description", paramTurnBasedMatch.getDescription()).a("Variant", Integer.valueOf(paramTurnBasedMatch.oc())).a("Data", paramTurnBasedMatch.getData()).a("Version", Integer.valueOf(paramTurnBasedMatch.getVersion())).a("Participants", paramTurnBasedMatch.oe()).a("RematchId", paramTurnBasedMatch.oy()).a("PreviousData", paramTurnBasedMatch.oz()).a("MatchNumber", Integer.valueOf(paramTurnBasedMatch.oA())).a("AutoMatchCriteria", paramTurnBasedMatch.oq()).a("AvailableAutoMatchSlots", Integer.valueOf(paramTurnBasedMatch.od())).a("LocallyModified", Boolean.valueOf(paramTurnBasedMatch.oB())).a("DescriptionParticipantId", paramTurnBasedMatch.oC()).toString();
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
  
  public String getDescription()
  {
    return this.vf;
  }
  
  public int getStatus()
  {
    return this.wu;
  }
  
  public int getVersion()
  {
    return this.wv;
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
  
  public int oA()
  {
    return this.wz;
  }
  
  public boolean oB()
  {
    return this.wB;
  }
  
  public String oC()
  {
    return this.wC;
  }
  
  public TurnBasedMatch oD()
  {
    return this;
  }
  
  public long oa()
  {
    return this.vN;
  }
  
  public int oc()
  {
    return this.vR;
  }
  
  public int od()
  {
    if (this.wm == null) {
      return 0;
    }
    return this.wm.getInt("max_automatch_players");
  }
  
  public ArrayList<Participant> oe()
  {
    return new ArrayList(this.vQ);
  }
  
  public String op()
  {
    return this.wk;
  }
  
  public Bundle oq()
  {
    return this.wm;
  }
  
  public String ot()
  {
    return this.wq;
  }
  
  public int ou()
  {
    return this.wA;
  }
  
  public String ov()
  {
    return this.wr;
  }
  
  public long ow()
  {
    return this.ws;
  }
  
  public String ox()
  {
    return this.wt;
  }
  
  public String oy()
  {
    return this.wx;
  }
  
  public byte[] oz()
  {
    return this.wy;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */