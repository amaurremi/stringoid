package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.internal.gx;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hk.a;

public final class AchievementRef
  extends d
  implements Achievement
{
  AchievementRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  public String getAchievementId()
  {
    return getString("external_achievement_id");
  }
  
  public int getCurrentSteps()
  {
    boolean bool = true;
    if (getType() == 1) {}
    for (;;)
    {
      gx.A(bool);
      return getInteger("current_steps");
      bool = false;
    }
  }
  
  public String getDescription()
  {
    return getString("description");
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    a("description", paramCharArrayBuffer);
  }
  
  public String getFormattedCurrentSteps()
  {
    boolean bool = true;
    if (getType() == 1) {}
    for (;;)
    {
      gx.A(bool);
      return getString("formatted_current_steps");
      bool = false;
    }
  }
  
  public void getFormattedCurrentSteps(CharArrayBuffer paramCharArrayBuffer)
  {
    boolean bool = true;
    if (getType() == 1) {}
    for (;;)
    {
      gx.A(bool);
      a("formatted_current_steps", paramCharArrayBuffer);
      return;
      bool = false;
    }
  }
  
  public String getFormattedTotalSteps()
  {
    boolean bool = true;
    if (getType() == 1) {}
    for (;;)
    {
      gx.A(bool);
      return getString("formatted_total_steps");
      bool = false;
    }
  }
  
  public void getFormattedTotalSteps(CharArrayBuffer paramCharArrayBuffer)
  {
    boolean bool = true;
    if (getType() == 1) {}
    for (;;)
    {
      gx.A(bool);
      a("formatted_total_steps", paramCharArrayBuffer);
      return;
      bool = false;
    }
  }
  
  public long getLastUpdatedTimestamp()
  {
    return getLong("last_updated_timestamp");
  }
  
  public String getName()
  {
    return getString("name");
  }
  
  public void getName(CharArrayBuffer paramCharArrayBuffer)
  {
    a("name", paramCharArrayBuffer);
  }
  
  public Player getPlayer()
  {
    return new PlayerRef(this.DG, this.EC);
  }
  
  public Uri getRevealedImageUri()
  {
    return aw("revealed_icon_image_uri");
  }
  
  public String getRevealedImageUrl()
  {
    return getString("revealed_icon_image_url");
  }
  
  public int getState()
  {
    return getInteger("state");
  }
  
  public int getTotalSteps()
  {
    boolean bool = true;
    if (getType() == 1) {}
    for (;;)
    {
      gx.A(bool);
      return getInteger("total_steps");
      bool = false;
    }
  }
  
  public int getType()
  {
    return getInteger("type");
  }
  
  public Uri getUnlockedImageUri()
  {
    return aw("unlocked_icon_image_uri");
  }
  
  public String getUnlockedImageUrl()
  {
    return getString("unlocked_icon_image_url");
  }
  
  public long getXpValue()
  {
    if ((!av("instance_xp_value")) || (ax("instance_xp_value"))) {
      return getLong("definition_xp_value");
    }
    return getLong("instance_xp_value");
  }
  
  public String toString()
  {
    hk.a locala = hk.e(this).a("AchievementId", getAchievementId()).a("Type", Integer.valueOf(getType())).a("Name", getName()).a("Description", getDescription()).a("UnlockedImageUri", getUnlockedImageUri()).a("UnlockedImageUrl", getUnlockedImageUrl()).a("RevealedImageUri", getRevealedImageUri()).a("RevealedImageUrl", getRevealedImageUrl()).a("Player", getPlayer()).a("LastUpdatedTimeStamp", Long.valueOf(getLastUpdatedTimestamp()));
    if (getType() == 1)
    {
      locala.a("CurrentSteps", Integer.valueOf(getCurrentSteps()));
      locala.a("TotalSteps", Integer.valueOf(getTotalSteps()));
    }
    return locala.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/achievement/AchievementRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */