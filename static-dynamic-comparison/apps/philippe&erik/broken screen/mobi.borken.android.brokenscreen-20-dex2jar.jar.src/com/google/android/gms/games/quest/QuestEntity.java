package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import com.google.android.gms.internal.il;
import java.util.ArrayList;
import java.util.List;

public final class QuestEntity
  implements SafeParcelable, Quest
{
  public static final QuestEntityCreator CREATOR = new QuestEntityCreator();
  private final int AQ;
  private final String Mm;
  private final GameEntity Rq;
  private final String TM;
  private final long TN;
  private final Uri TO;
  private final String TP;
  private final long TQ;
  private final Uri TR;
  private final String TS;
  private final long TT;
  private final long TU;
  private final ArrayList<MilestoneEntity> TV;
  private final long Ty;
  private final String mName;
  private final int mState;
  private final int xJ;
  
  QuestEntity(int paramInt1, GameEntity paramGameEntity, String paramString1, long paramLong1, Uri paramUri1, String paramString2, String paramString3, long paramLong2, long paramLong3, Uri paramUri2, String paramString4, String paramString5, long paramLong4, long paramLong5, int paramInt2, int paramInt3, ArrayList<MilestoneEntity> paramArrayList)
  {
    this.xJ = paramInt1;
    this.Rq = paramGameEntity;
    this.TM = paramString1;
    this.TN = paramLong1;
    this.TO = paramUri1;
    this.TP = paramString2;
    this.Mm = paramString3;
    this.TQ = paramLong2;
    this.Ty = paramLong3;
    this.TR = paramUri2;
    this.TS = paramString4;
    this.mName = paramString5;
    this.TT = paramLong4;
    this.TU = paramLong5;
    this.mState = paramInt2;
    this.AQ = paramInt3;
    this.TV = paramArrayList;
  }
  
  public QuestEntity(Quest paramQuest)
  {
    this.xJ = 2;
    this.Rq = new GameEntity(paramQuest.getGame());
    this.TM = paramQuest.getQuestId();
    this.TN = paramQuest.getAcceptedTimestamp();
    this.Mm = paramQuest.getDescription();
    this.TO = paramQuest.getBannerImageUri();
    this.TP = paramQuest.getBannerImageUrl();
    this.TQ = paramQuest.getEndTimestamp();
    this.TR = paramQuest.getIconImageUri();
    this.TS = paramQuest.getIconImageUrl();
    this.Ty = paramQuest.getLastUpdatedTimestamp();
    this.mName = paramQuest.getName();
    this.TT = paramQuest.iF();
    this.TU = paramQuest.getStartTimestamp();
    this.mState = paramQuest.getState();
    this.AQ = paramQuest.getType();
    paramQuest = paramQuest.iE();
    int j = paramQuest.size();
    this.TV = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      this.TV.add((MilestoneEntity)((Milestone)paramQuest.get(i)).freeze());
      i += 1;
    }
  }
  
  static int a(Quest paramQuest)
  {
    return hl.hashCode(new Object[] { paramQuest.getGame(), paramQuest.getQuestId(), Long.valueOf(paramQuest.getAcceptedTimestamp()), paramQuest.getBannerImageUri(), paramQuest.getDescription(), Long.valueOf(paramQuest.getEndTimestamp()), paramQuest.getIconImageUri(), Long.valueOf(paramQuest.getLastUpdatedTimestamp()), paramQuest.iE(), paramQuest.getName(), Long.valueOf(paramQuest.iF()), Long.valueOf(paramQuest.getStartTimestamp()), Integer.valueOf(paramQuest.getState()) });
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
      if ((!hl.equal(((Quest)paramObject).getGame(), paramQuest.getGame())) || (!hl.equal(((Quest)paramObject).getQuestId(), paramQuest.getQuestId())) || (!hl.equal(Long.valueOf(((Quest)paramObject).getAcceptedTimestamp()), Long.valueOf(paramQuest.getAcceptedTimestamp()))) || (!hl.equal(((Quest)paramObject).getBannerImageUri(), paramQuest.getBannerImageUri())) || (!hl.equal(((Quest)paramObject).getDescription(), paramQuest.getDescription())) || (!hl.equal(Long.valueOf(((Quest)paramObject).getEndTimestamp()), Long.valueOf(paramQuest.getEndTimestamp()))) || (!hl.equal(((Quest)paramObject).getIconImageUri(), paramQuest.getIconImageUri())) || (!hl.equal(Long.valueOf(((Quest)paramObject).getLastUpdatedTimestamp()), Long.valueOf(paramQuest.getLastUpdatedTimestamp()))) || (!hl.equal(((Quest)paramObject).iE(), paramQuest.iE())) || (!hl.equal(((Quest)paramObject).getName(), paramQuest.getName())) || (!hl.equal(Long.valueOf(((Quest)paramObject).iF()), Long.valueOf(paramQuest.iF()))) || (!hl.equal(Long.valueOf(((Quest)paramObject).getStartTimestamp()), Long.valueOf(paramQuest.getStartTimestamp())))) {
        break;
      }
      bool1 = bool2;
    } while (hl.equal(Integer.valueOf(((Quest)paramObject).getState()), Integer.valueOf(paramQuest.getState())));
    return false;
  }
  
  static String b(Quest paramQuest)
  {
    return hl.e(paramQuest).a("Game", paramQuest.getGame()).a("QuestId", paramQuest.getQuestId()).a("AcceptedTimestamp", Long.valueOf(paramQuest.getAcceptedTimestamp())).a("BannerImageUri", paramQuest.getBannerImageUri()).a("BannerImageUrl", paramQuest.getBannerImageUrl()).a("Description", paramQuest.getDescription()).a("EndTimestamp", Long.valueOf(paramQuest.getEndTimestamp())).a("IconImageUri", paramQuest.getIconImageUri()).a("IconImageUrl", paramQuest.getIconImageUrl()).a("LastUpdatedTimestamp", Long.valueOf(paramQuest.getLastUpdatedTimestamp())).a("Milestones", paramQuest.iE()).a("Name", paramQuest.getName()).a("NotifyTimestamp", Long.valueOf(paramQuest.iF())).a("StartTimestamp", Long.valueOf(paramQuest.getStartTimestamp())).a("State", Integer.valueOf(paramQuest.getState())).toString();
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
    return this.TN;
  }
  
  public Uri getBannerImageUri()
  {
    return this.TO;
  }
  
  public String getBannerImageUrl()
  {
    return this.TP;
  }
  
  public Milestone getCurrentMilestone()
  {
    return (Milestone)iE().get(0);
  }
  
  public String getDescription()
  {
    return this.Mm;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    il.b(this.Mm, paramCharArrayBuffer);
  }
  
  public long getEndTimestamp()
  {
    return this.TQ;
  }
  
  public Game getGame()
  {
    return this.Rq;
  }
  
  public Uri getIconImageUri()
  {
    return this.TR;
  }
  
  public String getIconImageUrl()
  {
    return this.TS;
  }
  
  public long getLastUpdatedTimestamp()
  {
    return this.Ty;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public void getName(CharArrayBuffer paramCharArrayBuffer)
  {
    il.b(this.mName, paramCharArrayBuffer);
  }
  
  public String getQuestId()
  {
    return this.TM;
  }
  
  public long getStartTimestamp()
  {
    return this.TU;
  }
  
  public int getState()
  {
    return this.mState;
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
  
  public List<Milestone> iE()
  {
    return new ArrayList(this.TV);
  }
  
  public long iF()
  {
    return this.TT;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public boolean isEndingSoon()
  {
    return this.TT <= System.currentTimeMillis() + 1800000L;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/quest/QuestEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */