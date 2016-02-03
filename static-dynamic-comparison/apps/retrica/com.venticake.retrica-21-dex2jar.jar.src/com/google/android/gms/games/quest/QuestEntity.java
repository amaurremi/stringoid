package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hk.a;
import com.google.android.gms.internal.ik;
import java.util.ArrayList;
import java.util.List;

public final class QuestEntity
  implements SafeParcelable, Quest
{
  public static final QuestEntityCreator CREATOR = new QuestEntityCreator();
  private final int AT;
  private final String Mp;
  private final GameEntity Rt;
  private final long TB;
  private final String TP;
  private final long TQ;
  private final Uri TR;
  private final String TS;
  private final long TT;
  private final Uri TU;
  private final String TV;
  private final long TW;
  private final long TX;
  private final ArrayList<MilestoneEntity> TY;
  private final String mName;
  private final int mState;
  private final int xM;
  
  QuestEntity(int paramInt1, GameEntity paramGameEntity, String paramString1, long paramLong1, Uri paramUri1, String paramString2, String paramString3, long paramLong2, long paramLong3, Uri paramUri2, String paramString4, String paramString5, long paramLong4, long paramLong5, int paramInt2, int paramInt3, ArrayList<MilestoneEntity> paramArrayList)
  {
    this.xM = paramInt1;
    this.Rt = paramGameEntity;
    this.TP = paramString1;
    this.TQ = paramLong1;
    this.TR = paramUri1;
    this.TS = paramString2;
    this.Mp = paramString3;
    this.TT = paramLong2;
    this.TB = paramLong3;
    this.TU = paramUri2;
    this.TV = paramString4;
    this.mName = paramString5;
    this.TW = paramLong4;
    this.TX = paramLong5;
    this.mState = paramInt2;
    this.AT = paramInt3;
    this.TY = paramArrayList;
  }
  
  public QuestEntity(Quest paramQuest)
  {
    this.xM = 2;
    this.Rt = new GameEntity(paramQuest.getGame());
    this.TP = paramQuest.getQuestId();
    this.TQ = paramQuest.getAcceptedTimestamp();
    this.Mp = paramQuest.getDescription();
    this.TR = paramQuest.getBannerImageUri();
    this.TS = paramQuest.getBannerImageUrl();
    this.TT = paramQuest.getEndTimestamp();
    this.TU = paramQuest.getIconImageUri();
    this.TV = paramQuest.getIconImageUrl();
    this.TB = paramQuest.getLastUpdatedTimestamp();
    this.mName = paramQuest.getName();
    this.TW = paramQuest.iK();
    this.TX = paramQuest.getStartTimestamp();
    this.mState = paramQuest.getState();
    this.AT = paramQuest.getType();
    paramQuest = paramQuest.iJ();
    int j = paramQuest.size();
    this.TY = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      this.TY.add((MilestoneEntity)((Milestone)paramQuest.get(i)).freeze());
      i += 1;
    }
  }
  
  static int a(Quest paramQuest)
  {
    return hk.hashCode(new Object[] { paramQuest.getGame(), paramQuest.getQuestId(), Long.valueOf(paramQuest.getAcceptedTimestamp()), paramQuest.getBannerImageUri(), paramQuest.getDescription(), Long.valueOf(paramQuest.getEndTimestamp()), paramQuest.getIconImageUri(), Long.valueOf(paramQuest.getLastUpdatedTimestamp()), paramQuest.iJ(), paramQuest.getName(), Long.valueOf(paramQuest.iK()), Long.valueOf(paramQuest.getStartTimestamp()), Integer.valueOf(paramQuest.getState()) });
  }
  
  static boolean a(Quest paramQuest, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof Quest)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramQuest == paramObject);
      paramObject = (Quest)paramObject;
      if ((!hk.equal(((Quest)paramObject).getGame(), paramQuest.getGame())) || (!hk.equal(((Quest)paramObject).getQuestId(), paramQuest.getQuestId())) || (!hk.equal(Long.valueOf(((Quest)paramObject).getAcceptedTimestamp()), Long.valueOf(paramQuest.getAcceptedTimestamp()))) || (!hk.equal(((Quest)paramObject).getBannerImageUri(), paramQuest.getBannerImageUri())) || (!hk.equal(((Quest)paramObject).getDescription(), paramQuest.getDescription())) || (!hk.equal(Long.valueOf(((Quest)paramObject).getEndTimestamp()), Long.valueOf(paramQuest.getEndTimestamp()))) || (!hk.equal(((Quest)paramObject).getIconImageUri(), paramQuest.getIconImageUri())) || (!hk.equal(Long.valueOf(((Quest)paramObject).getLastUpdatedTimestamp()), Long.valueOf(paramQuest.getLastUpdatedTimestamp()))) || (!hk.equal(((Quest)paramObject).iJ(), paramQuest.iJ())) || (!hk.equal(((Quest)paramObject).getName(), paramQuest.getName())) || (!hk.equal(Long.valueOf(((Quest)paramObject).iK()), Long.valueOf(paramQuest.iK()))) || (!hk.equal(Long.valueOf(((Quest)paramObject).getStartTimestamp()), Long.valueOf(paramQuest.getStartTimestamp())))) {
        break;
      }
      bool1 = bool2;
    } while (hk.equal(Integer.valueOf(((Quest)paramObject).getState()), Integer.valueOf(paramQuest.getState())));
    return false;
  }
  
  static String b(Quest paramQuest)
  {
    return hk.e(paramQuest).a("Game", paramQuest.getGame()).a("QuestId", paramQuest.getQuestId()).a("AcceptedTimestamp", Long.valueOf(paramQuest.getAcceptedTimestamp())).a("BannerImageUri", paramQuest.getBannerImageUri()).a("BannerImageUrl", paramQuest.getBannerImageUrl()).a("Description", paramQuest.getDescription()).a("EndTimestamp", Long.valueOf(paramQuest.getEndTimestamp())).a("IconImageUri", paramQuest.getIconImageUri()).a("IconImageUrl", paramQuest.getIconImageUrl()).a("LastUpdatedTimestamp", Long.valueOf(paramQuest.getLastUpdatedTimestamp())).a("Milestones", paramQuest.iJ()).a("Name", paramQuest.getName()).a("NotifyTimestamp", Long.valueOf(paramQuest.iK())).a("StartTimestamp", Long.valueOf(paramQuest.getStartTimestamp())).a("State", Integer.valueOf(paramQuest.getState())).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public Quest freeze()
  {
    return this;
  }
  
  public long getAcceptedTimestamp()
  {
    return this.TQ;
  }
  
  public Uri getBannerImageUri()
  {
    return this.TR;
  }
  
  public String getBannerImageUrl()
  {
    return this.TS;
  }
  
  public Milestone getCurrentMilestone()
  {
    return (Milestone)iJ().get(0);
  }
  
  public String getDescription()
  {
    return this.Mp;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    ik.b(this.Mp, paramCharArrayBuffer);
  }
  
  public long getEndTimestamp()
  {
    return this.TT;
  }
  
  public Game getGame()
  {
    return this.Rt;
  }
  
  public Uri getIconImageUri()
  {
    return this.TU;
  }
  
  public String getIconImageUrl()
  {
    return this.TV;
  }
  
  public long getLastUpdatedTimestamp()
  {
    return this.TB;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public void getName(CharArrayBuffer paramCharArrayBuffer)
  {
    ik.b(this.mName, paramCharArrayBuffer);
  }
  
  public String getQuestId()
  {
    return this.TP;
  }
  
  public long getStartTimestamp()
  {
    return this.TX;
  }
  
  public int getState()
  {
    return this.mState;
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
  
  public List<Milestone> iJ()
  {
    return new ArrayList(this.TY);
  }
  
  public long iK()
  {
    return this.TW;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public boolean isEndingSoon()
  {
    return this.TW <= System.currentTimeMillis() + 1800000L;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    QuestEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/quest/QuestEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */