package com.google.android.gms.games.multiplayer.turnbased;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import com.google.android.gms.internal.il;
import java.util.ArrayList;

public final class TurnBasedMatchEntity
  implements SafeParcelable, TurnBasedMatch
{
  public static final TurnBasedMatchEntityCreator CREATOR = new TurnBasedMatchEntityCreator();
  private final String Mm;
  private final String Of;
  private final GameEntity Rq;
  private final long SR;
  private final ArrayList<ParticipantEntity> SU;
  private final int SV;
  private final int TA;
  private final int TB;
  private final byte[] TC;
  private final String TD;
  private final byte[] TE;
  private final int TF;
  private final int TG;
  private final boolean TH;
  private final String TI;
  private final Bundle Tl;
  private final String Tp;
  private final String Tx;
  private final long Ty;
  private final String Tz;
  private final int xJ;
  
  TurnBasedMatchEntity(int paramInt1, GameEntity paramGameEntity, String paramString1, String paramString2, long paramLong1, String paramString3, long paramLong2, String paramString4, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte1, ArrayList<ParticipantEntity> paramArrayList, String paramString5, byte[] paramArrayOfByte2, int paramInt5, Bundle paramBundle, int paramInt6, boolean paramBoolean, String paramString6, String paramString7)
  {
    this.xJ = paramInt1;
    this.Rq = paramGameEntity;
    this.Of = paramString1;
    this.Tp = paramString2;
    this.SR = paramLong1;
    this.Tx = paramString3;
    this.Ty = paramLong2;
    this.Tz = paramString4;
    this.TA = paramInt2;
    this.TG = paramInt6;
    this.SV = paramInt3;
    this.TB = paramInt4;
    this.TC = paramArrayOfByte1;
    this.SU = paramArrayList;
    this.TD = paramString5;
    this.TE = paramArrayOfByte2;
    this.TF = paramInt5;
    this.Tl = paramBundle;
    this.TH = paramBoolean;
    this.Mm = paramString6;
    this.TI = paramString7;
  }
  
  public TurnBasedMatchEntity(TurnBasedMatch paramTurnBasedMatch)
  {
    this.xJ = 2;
    this.Rq = new GameEntity(paramTurnBasedMatch.getGame());
    this.Of = paramTurnBasedMatch.getMatchId();
    this.Tp = paramTurnBasedMatch.getCreatorId();
    this.SR = paramTurnBasedMatch.getCreationTimestamp();
    this.Tx = paramTurnBasedMatch.getLastUpdaterId();
    this.Ty = paramTurnBasedMatch.getLastUpdatedTimestamp();
    this.Tz = paramTurnBasedMatch.getPendingParticipantId();
    this.TA = paramTurnBasedMatch.getStatus();
    this.TG = paramTurnBasedMatch.getTurnStatus();
    this.SV = paramTurnBasedMatch.getVariant();
    this.TB = paramTurnBasedMatch.getVersion();
    this.TD = paramTurnBasedMatch.getRematchId();
    this.TF = paramTurnBasedMatch.getMatchNumber();
    this.Tl = paramTurnBasedMatch.getAutoMatchCriteria();
    this.TH = paramTurnBasedMatch.isLocallyModified();
    this.Mm = paramTurnBasedMatch.getDescription();
    this.TI = paramTurnBasedMatch.getDescriptionParticipantId();
    byte[] arrayOfByte = paramTurnBasedMatch.getData();
    if (arrayOfByte == null)
    {
      this.TC = null;
      arrayOfByte = paramTurnBasedMatch.getPreviousMatchData();
      if (arrayOfByte != null) {
        break label313;
      }
      this.TE = null;
    }
    for (;;)
    {
      paramTurnBasedMatch = paramTurnBasedMatch.getParticipants();
      int j = paramTurnBasedMatch.size();
      this.SU = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        this.SU.add((ParticipantEntity)((Participant)paramTurnBasedMatch.get(i)).freeze());
        i += 1;
      }
      this.TC = new byte[arrayOfByte.length];
      System.arraycopy(arrayOfByte, 0, this.TC, 0, arrayOfByte.length);
      break;
      label313:
      this.TE = new byte[arrayOfByte.length];
      System.arraycopy(arrayOfByte, 0, this.TE, 0, arrayOfByte.length);
    }
  }
  
  static int a(TurnBasedMatch paramTurnBasedMatch)
  {
    return hl.hashCode(new Object[] { paramTurnBasedMatch.getGame(), paramTurnBasedMatch.getMatchId(), paramTurnBasedMatch.getCreatorId(), Long.valueOf(paramTurnBasedMatch.getCreationTimestamp()), paramTurnBasedMatch.getLastUpdaterId(), Long.valueOf(paramTurnBasedMatch.getLastUpdatedTimestamp()), paramTurnBasedMatch.getPendingParticipantId(), Integer.valueOf(paramTurnBasedMatch.getStatus()), Integer.valueOf(paramTurnBasedMatch.getTurnStatus()), paramTurnBasedMatch.getDescription(), Integer.valueOf(paramTurnBasedMatch.getVariant()), Integer.valueOf(paramTurnBasedMatch.getVersion()), paramTurnBasedMatch.getParticipants(), paramTurnBasedMatch.getRematchId(), Integer.valueOf(paramTurnBasedMatch.getMatchNumber()), paramTurnBasedMatch.getAutoMatchCriteria(), Integer.valueOf(paramTurnBasedMatch.getAvailableAutoMatchSlots()), Boolean.valueOf(paramTurnBasedMatch.isLocallyModified()) });
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
      if ((!hl.equal(((TurnBasedMatch)paramObject).getGame(), paramTurnBasedMatch.getGame())) || (!hl.equal(((TurnBasedMatch)paramObject).getMatchId(), paramTurnBasedMatch.getMatchId())) || (!hl.equal(((TurnBasedMatch)paramObject).getCreatorId(), paramTurnBasedMatch.getCreatorId())) || (!hl.equal(Long.valueOf(((TurnBasedMatch)paramObject).getCreationTimestamp()), Long.valueOf(paramTurnBasedMatch.getCreationTimestamp()))) || (!hl.equal(((TurnBasedMatch)paramObject).getLastUpdaterId(), paramTurnBasedMatch.getLastUpdaterId())) || (!hl.equal(Long.valueOf(((TurnBasedMatch)paramObject).getLastUpdatedTimestamp()), Long.valueOf(paramTurnBasedMatch.getLastUpdatedTimestamp()))) || (!hl.equal(((TurnBasedMatch)paramObject).getPendingParticipantId(), paramTurnBasedMatch.getPendingParticipantId())) || (!hl.equal(Integer.valueOf(((TurnBasedMatch)paramObject).getStatus()), Integer.valueOf(paramTurnBasedMatch.getStatus()))) || (!hl.equal(Integer.valueOf(((TurnBasedMatch)paramObject).getTurnStatus()), Integer.valueOf(paramTurnBasedMatch.getTurnStatus()))) || (!hl.equal(((TurnBasedMatch)paramObject).getDescription(), paramTurnBasedMatch.getDescription())) || (!hl.equal(Integer.valueOf(((TurnBasedMatch)paramObject).getVariant()), Integer.valueOf(paramTurnBasedMatch.getVariant()))) || (!hl.equal(Integer.valueOf(((TurnBasedMatch)paramObject).getVersion()), Integer.valueOf(paramTurnBasedMatch.getVersion()))) || (!hl.equal(((TurnBasedMatch)paramObject).getParticipants(), paramTurnBasedMatch.getParticipants())) || (!hl.equal(((TurnBasedMatch)paramObject).getRematchId(), paramTurnBasedMatch.getRematchId())) || (!hl.equal(Integer.valueOf(((TurnBasedMatch)paramObject).getMatchNumber()), Integer.valueOf(paramTurnBasedMatch.getMatchNumber()))) || (!hl.equal(((TurnBasedMatch)paramObject).getAutoMatchCriteria(), paramTurnBasedMatch.getAutoMatchCriteria())) || (!hl.equal(Integer.valueOf(((TurnBasedMatch)paramObject).getAvailableAutoMatchSlots()), Integer.valueOf(paramTurnBasedMatch.getAvailableAutoMatchSlots())))) {
        break;
      }
      bool1 = bool2;
    } while (hl.equal(Boolean.valueOf(((TurnBasedMatch)paramObject).isLocallyModified()), Boolean.valueOf(paramTurnBasedMatch.isLocallyModified())));
    return false;
  }
  
  static String b(TurnBasedMatch paramTurnBasedMatch)
  {
    return hl.e(paramTurnBasedMatch).a("Game", paramTurnBasedMatch.getGame()).a("MatchId", paramTurnBasedMatch.getMatchId()).a("CreatorId", paramTurnBasedMatch.getCreatorId()).a("CreationTimestamp", Long.valueOf(paramTurnBasedMatch.getCreationTimestamp())).a("LastUpdaterId", paramTurnBasedMatch.getLastUpdaterId()).a("LastUpdatedTimestamp", Long.valueOf(paramTurnBasedMatch.getLastUpdatedTimestamp())).a("PendingParticipantId", paramTurnBasedMatch.getPendingParticipantId()).a("MatchStatus", Integer.valueOf(paramTurnBasedMatch.getStatus())).a("TurnStatus", Integer.valueOf(paramTurnBasedMatch.getTurnStatus())).a("Description", paramTurnBasedMatch.getDescription()).a("Variant", Integer.valueOf(paramTurnBasedMatch.getVariant())).a("Data", paramTurnBasedMatch.getData()).a("Version", Integer.valueOf(paramTurnBasedMatch.getVersion())).a("Participants", paramTurnBasedMatch.getParticipants()).a("RematchId", paramTurnBasedMatch.getRematchId()).a("PreviousData", paramTurnBasedMatch.getPreviousMatchData()).a("MatchNumber", Integer.valueOf(paramTurnBasedMatch.getMatchNumber())).a("AutoMatchCriteria", paramTurnBasedMatch.getAutoMatchCriteria()).a("AvailableAutoMatchSlots", Integer.valueOf(paramTurnBasedMatch.getAvailableAutoMatchSlots())).a("LocallyModified", Boolean.valueOf(paramTurnBasedMatch.isLocallyModified())).a("DescriptionParticipantId", paramTurnBasedMatch.getDescriptionParticipantId()).toString();
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
    return (this.TA == 2) && (this.TD == null);
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
    return this.Tl;
  }
  
  public int getAvailableAutoMatchSlots()
  {
    if (this.Tl == null) {
      return 0;
    }
    return this.Tl.getInt("max_automatch_players");
  }
  
  public long getCreationTimestamp()
  {
    return this.SR;
  }
  
  public String getCreatorId()
  {
    return this.Tp;
  }
  
  public byte[] getData()
  {
    return this.TC;
  }
  
  public String getDescription()
  {
    return this.Mm;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    il.b(this.Mm, paramCharArrayBuffer);
  }
  
  public Participant getDescriptionParticipant()
  {
    return getParticipant(getDescriptionParticipantId());
  }
  
  public String getDescriptionParticipantId()
  {
    return this.TI;
  }
  
  public Game getGame()
  {
    return this.Rq;
  }
  
  public long getLastUpdatedTimestamp()
  {
    return this.Ty;
  }
  
  public String getLastUpdaterId()
  {
    return this.Tx;
  }
  
  public String getMatchId()
  {
    return this.Of;
  }
  
  public int getMatchNumber()
  {
    return this.TF;
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
    return new ArrayList(this.SU);
  }
  
  public String getPendingParticipantId()
  {
    return this.Tz;
  }
  
  public byte[] getPreviousMatchData()
  {
    return this.TE;
  }
  
  public String getRematchId()
  {
    return this.TD;
  }
  
  public int getStatus()
  {
    return this.TA;
  }
  
  public int getTurnStatus()
  {
    return this.TG;
  }
  
  public int getVariant()
  {
    return this.SV;
  }
  
  public int getVersion()
  {
    return this.TB;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
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
    return this.TH;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */