package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.a;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.jv;

public final class AchievementEntity
  implements SafeParcelable, Achievement
{
  public static final AchievementEntityCreator CREATOR = new AchievementEntityCreator();
  private final int BR;
  private final int FD;
  private final String Tg;
  private final String VP;
  private final Uri VQ;
  private final String VR;
  private final Uri VS;
  private final String VT;
  private final int VU;
  private final String VV;
  private final PlayerEntity VW;
  private final int VX;
  private final String VY;
  private final long VZ;
  private final long Wa;
  private final String mName;
  private final int mState;
  
  AchievementEntity(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, Uri paramUri1, String paramString4, Uri paramUri2, String paramString5, int paramInt3, String paramString6, PlayerEntity paramPlayerEntity, int paramInt4, int paramInt5, String paramString7, long paramLong1, long paramLong2)
  {
    this.BR = paramInt1;
    this.VP = paramString1;
    this.FD = paramInt2;
    this.mName = paramString2;
    this.Tg = paramString3;
    this.VQ = paramUri1;
    this.VR = paramString4;
    this.VS = paramUri2;
    this.VT = paramString5;
    this.VU = paramInt3;
    this.VV = paramString6;
    this.VW = paramPlayerEntity;
    this.mState = paramInt4;
    this.VX = paramInt5;
    this.VY = paramString7;
    this.VZ = paramLong1;
    this.Wa = paramLong2;
  }
  
  public AchievementEntity(Achievement paramAchievement)
  {
    this.BR = 1;
    this.VP = paramAchievement.getAchievementId();
    this.FD = paramAchievement.getType();
    this.mName = paramAchievement.getName();
    this.Tg = paramAchievement.getDescription();
    this.VQ = paramAchievement.getUnlockedImageUri();
    this.VR = paramAchievement.getUnlockedImageUrl();
    this.VS = paramAchievement.getRevealedImageUri();
    this.VT = paramAchievement.getRevealedImageUrl();
    this.VW = ((PlayerEntity)paramAchievement.getPlayer().freeze());
    this.mState = paramAchievement.getState();
    this.VZ = paramAchievement.getLastUpdatedTimestamp();
    this.Wa = paramAchievement.getXpValue();
    if (paramAchievement.getType() == 1)
    {
      this.VU = paramAchievement.getTotalSteps();
      this.VV = paramAchievement.getFormattedTotalSteps();
      this.VX = paramAchievement.getCurrentSteps();
    }
    for (this.VY = paramAchievement.getFormattedCurrentSteps();; this.VY = null)
    {
      a.f(this.VP);
      a.f(this.Tg);
      return;
      this.VU = 0;
      this.VV = null;
      this.VX = 0;
    }
  }
  
  static int a(Achievement paramAchievement)
  {
    int j;
    int i;
    if (paramAchievement.getType() == 1)
    {
      j = paramAchievement.getCurrentSteps();
      i = paramAchievement.getTotalSteps();
    }
    for (;;)
    {
      return m.hashCode(new Object[] { paramAchievement.getAchievementId(), paramAchievement.getName(), Integer.valueOf(paramAchievement.getType()), paramAchievement.getDescription(), Long.valueOf(paramAchievement.getXpValue()), Integer.valueOf(paramAchievement.getState()), Long.valueOf(paramAchievement.getLastUpdatedTimestamp()), paramAchievement.getPlayer(), Integer.valueOf(j), Integer.valueOf(i) });
      i = 0;
      j = 0;
    }
  }
  
  static boolean a(Achievement paramAchievement, Object paramObject)
  {
    boolean bool3 = true;
    boolean bool2;
    if (!(paramObject instanceof Achievement)) {
      bool2 = false;
    }
    do
    {
      return bool2;
      bool2 = bool3;
    } while (paramAchievement == paramObject);
    paramObject = (Achievement)paramObject;
    boolean bool1;
    if (paramAchievement.getType() == 1)
    {
      bool2 = m.equal(Integer.valueOf(((Achievement)paramObject).getCurrentSteps()), Integer.valueOf(paramAchievement.getCurrentSteps()));
      bool1 = m.equal(Integer.valueOf(((Achievement)paramObject).getTotalSteps()), Integer.valueOf(paramAchievement.getTotalSteps()));
    }
    for (;;)
    {
      if ((m.equal(((Achievement)paramObject).getAchievementId(), paramAchievement.getAchievementId())) && (m.equal(((Achievement)paramObject).getName(), paramAchievement.getName())) && (m.equal(Integer.valueOf(((Achievement)paramObject).getType()), Integer.valueOf(paramAchievement.getType()))) && (m.equal(((Achievement)paramObject).getDescription(), paramAchievement.getDescription())) && (m.equal(Long.valueOf(((Achievement)paramObject).getXpValue()), Long.valueOf(paramAchievement.getXpValue()))) && (m.equal(Integer.valueOf(((Achievement)paramObject).getState()), Integer.valueOf(paramAchievement.getState()))) && (m.equal(Long.valueOf(((Achievement)paramObject).getLastUpdatedTimestamp()), Long.valueOf(paramAchievement.getLastUpdatedTimestamp()))) && (m.equal(((Achievement)paramObject).getPlayer(), paramAchievement.getPlayer())) && (bool2))
      {
        bool2 = bool3;
        if (bool1) {
          break;
        }
      }
      return false;
      bool1 = true;
      bool2 = true;
    }
  }
  
  static String b(Achievement paramAchievement)
  {
    m.a locala = m.h(paramAchievement).a("Id", paramAchievement.getAchievementId()).a("Type", Integer.valueOf(paramAchievement.getType())).a("Name", paramAchievement.getName()).a("Description", paramAchievement.getDescription()).a("Player", paramAchievement.getPlayer()).a("State", Integer.valueOf(paramAchievement.getState()));
    if (paramAchievement.getType() == 1)
    {
      locala.a("CurrentSteps", Integer.valueOf(paramAchievement.getCurrentSteps()));
      locala.a("TotalSteps", Integer.valueOf(paramAchievement.getTotalSteps()));
    }
    return locala.toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public Achievement freeze()
  {
    return this;
  }
  
  public String getAchievementId()
  {
    return this.VP;
  }
  
  public int getCurrentSteps()
  {
    return this.VX;
  }
  
  public String getDescription()
  {
    return this.Tg;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    jv.b(this.Tg, paramCharArrayBuffer);
  }
  
  public String getFormattedCurrentSteps()
  {
    return this.VY;
  }
  
  public void getFormattedCurrentSteps(CharArrayBuffer paramCharArrayBuffer)
  {
    jv.b(this.VY, paramCharArrayBuffer);
  }
  
  public String getFormattedTotalSteps()
  {
    return this.VV;
  }
  
  public void getFormattedTotalSteps(CharArrayBuffer paramCharArrayBuffer)
  {
    jv.b(this.VV, paramCharArrayBuffer);
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
  
  public Player getPlayer()
  {
    return this.VW;
  }
  
  public Uri getRevealedImageUri()
  {
    return this.VS;
  }
  
  public String getRevealedImageUrl()
  {
    return this.VT;
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  public int getTotalSteps()
  {
    return this.VU;
  }
  
  public int getType()
  {
    return this.FD;
  }
  
  public Uri getUnlockedImageUri()
  {
    return this.VQ;
  }
  
  public String getUnlockedImageUrl()
  {
    return this.VR;
  }
  
  public int getVersionCode()
  {
    return this.BR;
  }
  
  public long getXpValue()
  {
    return this.Wa;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AchievementEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/achievement/AchievementEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */