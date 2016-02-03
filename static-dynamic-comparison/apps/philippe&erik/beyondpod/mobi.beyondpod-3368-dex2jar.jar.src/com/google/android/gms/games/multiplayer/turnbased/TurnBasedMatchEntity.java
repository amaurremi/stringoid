package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.ee.a;
import java.util.ArrayList;

public final class TurnBasedMatchEntity
  implements SafeParcelable, TurnBasedMatch
{
  public static final TurnBasedMatchEntityCreator CREATOR = new TurnBasedMatchEntityCreator();
  private final int kg;
  private final String ul;
  private final Bundle wH;
  private final String wL;
  private final String wU;
  private final long wV;
  private final String wW;
  private final int wX;
  private final int wY;
  private final byte[] wZ;
  private final GameEntity wj;
  private final long wk;
  private final ArrayList<ParticipantEntity> wn;
  private final int wo;
  private final String xa;
  private final byte[] xb;
  private final int xc;
  private final int xd;
  private final boolean xe;
  
  TurnBasedMatchEntity(int paramInt1, GameEntity paramGameEntity, String paramString1, String paramString2, long paramLong1, String paramString3, long paramLong2, String paramString4, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte1, ArrayList<ParticipantEntity> paramArrayList, String paramString5, byte[] paramArrayOfByte2, int paramInt5, Bundle paramBundle, int paramInt6, boolean paramBoolean)
  {
    this.kg = paramInt1;
    this.wj = paramGameEntity;
    this.ul = paramString1;
    this.wL = paramString2;
    this.wk = paramLong1;
    this.wU = paramString3;
    this.wV = paramLong2;
    this.wW = paramString4;
    this.wX = paramInt2;
    this.xd = paramInt6;
    this.wo = paramInt3;
    this.wY = paramInt4;
    this.wZ = paramArrayOfByte1;
    this.wn = paramArrayList;
    this.xa = paramString5;
    this.xb = paramArrayOfByte2;
    this.xc = paramInt5;
    this.wH = paramBundle;
    this.xe = paramBoolean;
  }
  
  public TurnBasedMatchEntity(TurnBasedMatch paramTurnBasedMatch)
  {
    this.kg = 2;
    this.wj = new GameEntity(paramTurnBasedMatch.getGame());
    this.ul = paramTurnBasedMatch.getMatchId();
    this.wL = paramTurnBasedMatch.getCreatorId();
    this.wk = paramTurnBasedMatch.getCreationTimestamp();
    this.wU = paramTurnBasedMatch.getLastUpdaterId();
    this.wV = paramTurnBasedMatch.getLastUpdatedTimestamp();
    this.wW = paramTurnBasedMatch.getPendingParticipantId();
    this.wX = paramTurnBasedMatch.getStatus();
    this.xd = paramTurnBasedMatch.getTurnStatus();
    this.wo = paramTurnBasedMatch.getVariant();
    this.wY = paramTurnBasedMatch.getVersion();
    this.xa = paramTurnBasedMatch.getRematchId();
    this.xc = paramTurnBasedMatch.getMatchNumber();
    this.wH = paramTurnBasedMatch.getAutoMatchCriteria();
    this.xe = paramTurnBasedMatch.isLocallyModified();
    byte[] arrayOfByte = paramTurnBasedMatch.getData();
    if (arrayOfByte == null)
    {
      this.wZ = null;
      arrayOfByte = paramTurnBasedMatch.getPreviousMatchData();
      if (arrayOfByte != null) {
        break label293;
      }
      this.xb = null;
    }
    for (;;)
    {
      paramTurnBasedMatch = paramTurnBasedMatch.getParticipants();
      int j = paramTurnBasedMatch.size();
      this.wn = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        this.wn.add((ParticipantEntity)((Participant)paramTurnBasedMatch.get(i)).freeze());
        i += 1;
      }
      this.wZ = new byte[arrayOfByte.length];
      System.arraycopy(arrayOfByte, 0, this.wZ, 0, arrayOfByte.length);
      break;
      label293:
      this.xb = new byte[arrayOfByte.length];
      System.arraycopy(arrayOfByte, 0, this.xb, 0, arrayOfByte.length);
    }
  }
  
  static int a(TurnBasedMatch paramTurnBasedMatch)
  {
    return ee.hashCode(new Object[] { paramTurnBasedMatch.getGame(), paramTurnBasedMatch.getMatchId(), paramTurnBasedMatch.getCreatorId(), Long.valueOf(paramTurnBasedMatch.getCreationTimestamp()), paramTurnBasedMatch.getLastUpdaterId(), Long.valueOf(paramTurnBasedMatch.getLastUpdatedTimestamp()), paramTurnBasedMatch.getPendingParticipantId(), Integer.valueOf(paramTurnBasedMatch.getStatus()), Integer.valueOf(paramTurnBasedMatch.getTurnStatus()), Integer.valueOf(paramTurnBasedMatch.getVariant()), Integer.valueOf(paramTurnBasedMatch.getVersion()), paramTurnBasedMatch.getParticipants(), paramTurnBasedMatch.getRematchId(), Integer.valueOf(paramTurnBasedMatch.getMatchNumber()), paramTurnBasedMatch.getAutoMatchCriteria(), Integer.valueOf(paramTurnBasedMatch.getAvailableAutoMatchSlots()), Boolean.valueOf(paramTurnBasedMatch.isLocallyModified()) });
  }
  
  static int a(TurnBasedMatch paramTurnBasedMatch, String paramString)
  {
    ArrayList localArrayList = paramTurnBasedMatch.getParticipants();
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      Participant localParticipant = (Participant)localArrayList.get(i);
      if (localParticipant.getParticipantId().equals(paramString)) {
        return localParticipant.getStatus();
      }
      i += 1;
    }
    throw new IllegalStateException("Participant " + paramString + " is not in match " + paramTurnBasedMatch.getMatchId());
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
      if ((!ee.equal(((TurnBasedMatch)paramObject).getGame(), paramTurnBasedMatch.getGame())) || (!ee.equal(((TurnBasedMatch)paramObject).getMatchId(), paramTurnBasedMatch.getMatchId())) || (!ee.equal(((TurnBasedMatch)paramObject).getCreatorId(), paramTurnBasedMatch.getCreatorId())) || (!ee.equal(Long.valueOf(((TurnBasedMatch)paramObject).getCreationTimestamp()), Long.valueOf(paramTurnBasedMatch.getCreationTimestamp()))) || (!ee.equal(((TurnBasedMatch)paramObject).getLastUpdaterId(), paramTurnBasedMatch.getLastUpdaterId())) || (!ee.equal(Long.valueOf(((TurnBasedMatch)paramObject).getLastUpdatedTimestamp()), Long.valueOf(paramTurnBasedMatch.getLastUpdatedTimestamp()))) || (!ee.equal(((TurnBasedMatch)paramObject).getPendingParticipantId(), paramTurnBasedMatch.getPendingParticipantId())) || (!ee.equal(Integer.valueOf(((TurnBasedMatch)paramObject).getStatus()), Integer.valueOf(paramTurnBasedMatch.getStatus()))) || (!ee.equal(Integer.valueOf(((TurnBasedMatch)paramObject).getTurnStatus()), Integer.valueOf(paramTurnBasedMatch.getTurnStatus()))) || (!ee.equal(Integer.valueOf(((TurnBasedMatch)paramObject).getVariant()), Integer.valueOf(paramTurnBasedMatch.getVariant()))) || (!ee.equal(Integer.valueOf(((TurnBasedMatch)paramObject).getVersion()), Integer.valueOf(paramTurnBasedMatch.getVersion()))) || (!ee.equal(((TurnBasedMatch)paramObject).getParticipants(), paramTurnBasedMatch.getParticipants())) || (!ee.equal(((TurnBasedMatch)paramObject).getRematchId(), paramTurnBasedMatch.getRematchId())) || (!ee.equal(Integer.valueOf(((TurnBasedMatch)paramObject).getMatchNumber()), Integer.valueOf(paramTurnBasedMatch.getMatchNumber()))) || (!ee.equal(((TurnBasedMatch)paramObject).getAutoMatchCriteria(), paramTurnBasedMatch.getAutoMatchCriteria())) || (!ee.equal(Integer.valueOf(((TurnBasedMatch)paramObject).getAvailableAutoMatchSlots()), Integer.valueOf(paramTurnBasedMatch.getAvailableAutoMatchSlots())))) {
        break;
      }
      bool1 = bool2;
    } while (ee.equal(Boolean.valueOf(((TurnBasedMatch)paramObject).isLocallyModified()), Boolean.valueOf(paramTurnBasedMatch.isLocallyModified())));
    return false;
  }
  
  static String b(TurnBasedMatch paramTurnBasedMatch)
  {
    return ee.e(paramTurnBasedMatch).a("Game", paramTurnBasedMatch.getGame()).a("MatchId", paramTurnBasedMatch.getMatchId()).a("CreatorId", paramTurnBasedMatch.getCreatorId()).a("CreationTimestamp", Long.valueOf(paramTurnBasedMatch.getCreationTimestamp())).a("LastUpdaterId", paramTurnBasedMatch.getLastUpdaterId()).a("LastUpdatedTimestamp", Long.valueOf(paramTurnBasedMatch.getLastUpdatedTimestamp())).a("PendingParticipantId", paramTurnBasedMatch.getPendingParticipantId()).a("MatchStatus", Integer.valueOf(paramTurnBasedMatch.getStatus())).a("TurnStatus", Integer.valueOf(paramTurnBasedMatch.getTurnStatus())).a("Variant", Integer.valueOf(paramTurnBasedMatch.getVariant())).a("Data", paramTurnBasedMatch.getData()).a("Version", Integer.valueOf(paramTurnBasedMatch.getVersion())).a("Participants", paramTurnBasedMatch.getParticipants()).a("RematchId", paramTurnBasedMatch.getRematchId()).a("PreviousData", paramTurnBasedMatch.getPreviousMatchData()).a("MatchNumber", Integer.valueOf(paramTurnBasedMatch.getMatchNumber())).a("AutoMatchCriteria", paramTurnBasedMatch.getAutoMatchCriteria()).a("AvailableAutoMatchSlots", Integer.valueOf(paramTurnBasedMatch.getAvailableAutoMatchSlots())).a("LocallyModified", Boolean.valueOf(paramTurnBasedMatch.isLocallyModified())).toString();
  }
  
  static String b(TurnBasedMatch paramTurnBasedMatch, String paramString)
  {
    paramTurnBasedMatch = paramTurnBasedMatch.getParticipants();
    int j = paramTurnBasedMatch.size();
    int i = 0;
    while (i < j)
    {
      Participant localParticipant = (Participant)paramTurnBasedMatch.get(i);
      Player localPlayer = localParticipant.getPlayer();
      if ((localPlayer != null) && (localPlayer.getPlayerId().equals(paramString))) {
        return localParticipant.getParticipantId();
      }
      i += 1;
    }
    return null;
  }
  
  static Participant c(TurnBasedMatch paramTurnBasedMatch, String paramString)
  {
    ArrayList localArrayList = paramTurnBasedMatch.getParticipants();
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      Participant localParticipant = (Participant)localArrayList.get(i);
      if (localParticipant.getParticipantId().equals(paramString)) {
        return localParticipant;
      }
      i += 1;
    }
    throw new IllegalStateException("Participant " + paramString + " is not in match " + paramTurnBasedMatch.getMatchId());
  }
  
  static ArrayList<String> c(TurnBasedMatch paramTurnBasedMatch)
  {
    paramTurnBasedMatch = paramTurnBasedMatch.getParticipants();
    int j = paramTurnBasedMatch.size();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(((Participant)paramTurnBasedMatch.get(i)).getParticipantId());
      i += 1;
    }
    return localArrayList;
  }
  
  public boolean canRematch()
  {
    return (this.wX == 2) && (this.xa == null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public TurnBasedMatch freeze()
  {
    return this;
  }
  
  public Bundle getAutoMatchCriteria()
  {
    return this.wH;
  }
  
  public int getAvailableAutoMatchSlots()
  {
    if (this.wH == null) {
      return 0;
    }
    return this.wH.getInt("max_automatch_players");
  }
  
  public long getCreationTimestamp()
  {
    return this.wk;
  }
  
  public String getCreatorId()
  {
    return this.wL;
  }
  
  public byte[] getData()
  {
    return this.wZ;
  }
  
  public Game getGame()
  {
    return this.wj;
  }
  
  public long getLastUpdatedTimestamp()
  {
    return this.wV;
  }
  
  public String getLastUpdaterId()
  {
    return this.wU;
  }
  
  public String getMatchId()
  {
    return this.ul;
  }
  
  public int getMatchNumber()
  {
    return this.xc;
  }
  
  public Participant getParticipant(String paramString)
  {
    return c(this, paramString);
  }
  
  public String getParticipantId(String paramString)
  {
    return b(this, paramString);
  }
  
  public ArrayList<String> getParticipantIds()
  {
    return c(this);
  }
  
  public int getParticipantStatus(String paramString)
  {
    return a(this, paramString);
  }
  
  public ArrayList<Participant> getParticipants()
  {
    return new ArrayList(this.wn);
  }
  
  public String getPendingParticipantId()
  {
    return this.wW;
  }
  
  public byte[] getPreviousMatchData()
  {
    return this.xb;
  }
  
  public String getRematchId()
  {
    return this.xa;
  }
  
  public int getStatus()
  {
    return this.wX;
  }
  
  public int getTurnStatus()
  {
    return this.xd;
  }
  
  public int getVariant()
  {
    return this.wo;
  }
  
  public int getVersion()
  {
    return this.wY;
  }
  
  public int getVersionCode()
  {
    return this.kg;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public boolean isLocallyModified()
  {
    return this.xe;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    TurnBasedMatchEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */