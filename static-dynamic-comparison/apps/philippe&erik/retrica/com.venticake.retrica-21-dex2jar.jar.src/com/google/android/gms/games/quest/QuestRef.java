package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;
import java.util.List;

public final class QuestRef
  extends d
  implements Quest
{
  private final int RG;
  private final Game Ss;
  
  QuestRef(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    super(paramDataHolder, paramInt1);
    this.Ss = new GameRef(paramDataHolder, paramInt1);
    this.RG = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return QuestEntity.a(this, paramObject);
  }
  
  public Quest freeze()
  {
    return new QuestEntity(this);
  }
  
  public long getAcceptedTimestamp()
  {
    return getLong("accepted_ts");
  }
  
  public Uri getBannerImageUri()
  {
    return aw("quest_banner_image_uri");
  }
  
  public String getBannerImageUrl()
  {
    return getString("quest_banner_image_url");
  }
  
  public Milestone getCurrentMilestone()
  {
    return (Milestone)iJ().get(0);
  }
  
  public String getDescription()
  {
    return getString("quest_description");
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    a("quest_description", paramCharArrayBuffer);
  }
  
  public long getEndTimestamp()
  {
    return getLong("quest_end_ts");
  }
  
  public Game getGame()
  {
    return this.Ss;
  }
  
  public Uri getIconImageUri()
  {
    return aw("quest_icon_image_uri");
  }
  
  public String getIconImageUrl()
  {
    return getString("quest_icon_image_url");
  }
  
  public long getLastUpdatedTimestamp()
  {
    return getLong("quest_last_updated_ts");
  }
  
  public String getName()
  {
    return getString("quest_name");
  }
  
  public void getName(CharArrayBuffer paramCharArrayBuffer)
  {
    a("quest_name", paramCharArrayBuffer);
  }
  
  public String getQuestId()
  {
    return getString("external_quest_id");
  }
  
  public long getStartTimestamp()
  {
    return getLong("quest_start_ts");
  }
  
  public int getState()
  {
    return getInteger("quest_state");
  }
  
  public int getType()
  {
    return getInteger("quest_type");
  }
  
  public int hashCode()
  {
    return QuestEntity.a(this);
  }
  
  public List<Milestone> iJ()
  {
    ArrayList localArrayList = new ArrayList(this.RG);
    int i = 0;
    while (i < this.RG)
    {
      localArrayList.add(new MilestoneRef(this.DG, this.EC + i));
      i += 1;
    }
    return localArrayList;
  }
  
  public long iK()
  {
    return getLong("notification_ts");
  }
  
  public boolean isEndingSoon()
  {
    return iK() <= System.currentTimeMillis() + 1800000L;
  }
  
  public String toString()
  {
    return QuestEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((QuestEntity)freeze()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/quest/QuestRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */