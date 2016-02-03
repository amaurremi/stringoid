package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;
import java.util.List;

public final class QuestEntity
  implements SafeParcelable, Quest
{
  public static final QuestEntityCreator CREATOR = new QuestEntityCreator();
  private final int BR;
  private final int FD;
  private final String Tg;
  private final long VZ;
  private final GameEntity aan;
  private final String acG;
  private final long acH;
  private final Uri acI;
  private final String acJ;
  private final long acK;
  private final Uri acL;
  private final String acM;
  private final long acN;
  private final long acO;
  private final ArrayList<MilestoneEntity> acP;
  private final String mName;
  private final int mState;
  
  QuestEntity(int paramInt1, GameEntity paramGameEntity, String paramString1, long paramLong1, Uri paramUri1, String paramString2, String paramString3, long paramLong2, long paramLong3, Uri paramUri2, String paramString4, String paramString5, long paramLong4, long paramLong5, int paramInt2, int paramInt3, ArrayList<MilestoneEntity> paramArrayList)
  {
    this.BR = paramInt1;
    this.aan = paramGameEntity;
    this.acG = paramString1;
    this.acH = paramLong1;
    this.acI = paramUri1;
    this.acJ = paramString2;
    this.Tg = paramString3;
    this.acK = paramLong2;
    this.VZ = paramLong3;
    this.acL = paramUri2;
    this.acM = paramString4;
    this.mName = paramString5;
    this.acN = paramLong4;
    this.acO = paramLong5;
    this.mState = paramInt2;
    this.FD = paramInt3;
    this.acP = paramArrayList;
  }
  
  public QuestEntity(Quest paramQuest)
  {
    this.BR = 2;
    this.aan = new GameEntity(paramQuest.getGame());
    this.acG = paramQuest.getQuestId();
    this.acH = paramQuest.getAcceptedTimestamp();
    this.Tg = paramQuest.getDescription();
    this.acI = paramQuest.getBannerImageUri();
    this.acJ = paramQuest.getBannerImageUrl();
    this.acK = paramQuest.getEndTimestamp();
    this.acL = paramQuest.getIconImageUri();
    this.acM = paramQuest.getIconImageUrl();
    this.VZ = paramQuest.getLastUpdatedTimestamp();
    this.mName = paramQuest.getName();
    this.acN = paramQuest.lI();
    this.acO = paramQuest.getStartTimestamp();
    this.mState = paramQuest.getState();
    this.FD = paramQuest.getType();
    paramQuest = paramQuest.lH();
    int j = paramQuest.size();
    this.acP = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      this.acP.add((MilestoneEntity)((Milestone)paramQuest.get(i)).freeze());
      i += 1;
    }
  }
  
  static int a(Quest paramQuest)
  {
    return m.hashCode(new Object[] { paramQuest.getGame(), paramQuest.getQuestId(), Long.valueOf(paramQuest.getAcceptedTimestamp()), paramQuest.getBannerImageUri(), paramQuest.getDescription(), Long.valueOf(paramQuest.getEndTimestamp()), paramQuest.getIconImageUri(), Long.valueOf(paramQuest.getLastUpdatedTimestamp()), paramQuest.lH(), paramQuest.getName(), Long.valueOf(paramQuest.lI()), Long.valueOf(paramQuest.getStartTimestamp()), Integer.valueOf(paramQuest.getState()) });
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
      if ((!m.equal(((Quest)paramObject).getGame(), paramQuest.getGame())) || (!m.equal(((Quest)paramObject).getQuestId(), paramQuest.getQuestId())) || (!m.equal(Long.valueOf(((Quest)paramObject).getAcceptedTimestamp()), Long.valueOf(paramQuest.getAcceptedTimestamp()))) || (!m.equal(((Quest)paramObject).getBannerImageUri(), paramQuest.getBannerImageUri())) || (!m.equal(((Quest)paramObject).getDescription(), paramQuest.getDescription())) || (!m.equal(Long.valueOf(((Quest)paramObject).getEndTimestamp()), Long.valueOf(paramQuest.getEndTimestamp()))) || (!m.equal(((Quest)paramObject).getIconImageUri(), paramQuest.getIconImageUri())) || (!m.equal(Long.valueOf(((Quest)paramObject).getLastUpdatedTimestamp()), Long.valueOf(paramQuest.getLastUpdatedTimestamp()))) || (!m.equal(((Quest)paramObject).lH(), paramQuest.lH())) || (!m.equal(((Quest)paramObject).getName(), paramQuest.getName())) || (!m.equal(Long.valueOf(((Quest)paramObject).lI()), Long.valueOf(paramQuest.lI()))) || (!m.equal(Long.valueOf(((Quest)paramObject).getStartTimestamp()), Long.valueOf(paramQuest.getStartTimestamp())))) {
        break;
      }
      bool1 = bool2;
    } while (m.equal(Integer.valueOf(((Quest)paramObject).getState()), Integer.valueOf(paramQuest.getState())));
    return false;
  }
  
  static String b(Quest paramQuest)
  {
    return m.h(paramQuest).a("Game", paramQuest.getGame()).a("QuestId", paramQuest.getQuestId()).a("AcceptedTimestamp", Long.valueOf(paramQuest.getAcceptedTimestamp())).a("BannerImageUri", paramQuest.getBannerImageUri()).a("BannerImageUrl", paramQuest.getBannerImageUrl()).a("Description", paramQuest.getDescription()).a("EndTimestamp", Long.valueOf(paramQuest.getEndTimestamp())).a("IconImageUri", paramQuest.getIconImageUri()).a("IconImageUrl", paramQuest.getIconImageUrl()).a("LastUpdatedTimestamp", Long.valueOf(paramQuest.getLastUpdatedTimestamp())).a("Milestones", paramQuest.lH()).a("Name", paramQuest.getName()).a("NotifyTimestamp", Long.valueOf(paramQuest.lI())).a("StartTimestamp", Long.valueOf(paramQuest.getStartTimestamp())).a("State", Integer.valueOf(paramQuest.getState())).toString();
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
    return this.acH;
  }
  
  public Uri getBannerImageUri()
  {
    return this.acI;
  }
  
  public String getBannerImageUrl()
  {
    return this.acJ;
  }
  
  public Milestone getCurrentMilestone()
  {
    return (Milestone)lH().get(0);
  }
  
  public String getDescription()
  {
    return this.Tg;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    jv.b(this.Tg, paramCharArrayBuffer);
  }
  
  public long getEndTimestamp()
  {
    return this.acK;
  }
  
  public Game getGame()
  {
    return this.aan;
  }
  
  public Uri getIconImageUri()
  {
    return this.acL;
  }
  
  public String getIconImageUrl()
  {
    return this.acM;
  }
  
  public long getLastUpdatedTimestamp()
  {
    return this.VZ;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public void getName(CharArrayBuffer paramCharArrayBuffer)
  {
    jv.b(this.mName, paramCharArrayBuffer);
  }
  
  public String getQuestId()
  {
    return this.acG;
  }
  
  public long getStartTimestamp()
  {
    return this.acO;
  }
  
  public int getState()
  {
    return this.mState;
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
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public boolean isEndingSoon()
  {
    return this.acN <= System.currentTimeMillis() + 1800000L;
  }
  
  public List<Milestone> lH()
  {
    return new ArrayList(this.acP);
  }
  
  public long lI()
  {
    return this.acN;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/quest/QuestEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */