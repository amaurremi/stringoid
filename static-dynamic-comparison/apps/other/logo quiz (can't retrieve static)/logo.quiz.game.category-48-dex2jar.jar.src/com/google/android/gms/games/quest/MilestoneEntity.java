package com.google.android.gms.games.quest;

import android.os.Parcel;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class MilestoneEntity
  implements SafeParcelable, Milestone
{
  public static final MilestoneEntityCreator CREATOR = new MilestoneEntityCreator();
  private final int BR;
  private final String Wb;
  private final String Xj;
  private final long acD;
  private final long acE;
  private final byte[] acF;
  private final int mState;
  
  MilestoneEntity(int paramInt1, String paramString1, long paramLong1, long paramLong2, byte[] paramArrayOfByte, int paramInt2, String paramString2)
  {
    this.BR = paramInt1;
    this.Xj = paramString1;
    this.acD = paramLong1;
    this.acE = paramLong2;
    this.acF = paramArrayOfByte;
    this.mState = paramInt2;
    this.Wb = paramString2;
  }
  
  public MilestoneEntity(Milestone paramMilestone)
  {
    this.BR = 4;
    this.Xj = paramMilestone.getMilestoneId();
    this.acD = paramMilestone.getCurrentProgress();
    this.acE = paramMilestone.getTargetProgress();
    this.mState = paramMilestone.getState();
    this.Wb = paramMilestone.getEventId();
    paramMilestone = paramMilestone.getCompletionRewardData();
    if (paramMilestone == null)
    {
      this.acF = null;
      return;
    }
    this.acF = new byte[paramMilestone.length];
    System.arraycopy(paramMilestone, 0, this.acF, 0, paramMilestone.length);
  }
  
  static int a(Milestone paramMilestone)
  {
    return m.hashCode(new Object[] { paramMilestone.getMilestoneId(), Long.valueOf(paramMilestone.getCurrentProgress()), Long.valueOf(paramMilestone.getTargetProgress()), Integer.valueOf(paramMilestone.getState()), paramMilestone.getEventId() });
  }
  
  static boolean a(Milestone paramMilestone, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof Milestone)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramMilestone == paramObject);
      paramObject = (Milestone)paramObject;
      if ((!m.equal(((Milestone)paramObject).getMilestoneId(), paramMilestone.getMilestoneId())) || (!m.equal(Long.valueOf(((Milestone)paramObject).getCurrentProgress()), Long.valueOf(paramMilestone.getCurrentProgress()))) || (!m.equal(Long.valueOf(((Milestone)paramObject).getTargetProgress()), Long.valueOf(paramMilestone.getTargetProgress()))) || (!m.equal(Integer.valueOf(((Milestone)paramObject).getState()), Integer.valueOf(paramMilestone.getState())))) {
        break;
      }
      bool1 = bool2;
    } while (m.equal(((Milestone)paramObject).getEventId(), paramMilestone.getEventId()));
    return false;
  }
  
  static String b(Milestone paramMilestone)
  {
    return m.h(paramMilestone).a("MilestoneId", paramMilestone.getMilestoneId()).a("CurrentProgress", Long.valueOf(paramMilestone.getCurrentProgress())).a("TargetProgress", Long.valueOf(paramMilestone.getTargetProgress())).a("State", Integer.valueOf(paramMilestone.getState())).a("CompletionRewardData", paramMilestone.getCompletionRewardData()).a("EventId", paramMilestone.getEventId()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public Milestone freeze()
  {
    return this;
  }
  
  public byte[] getCompletionRewardData()
  {
    return this.acF;
  }
  
  public long getCurrentProgress()
  {
    return this.acD;
  }
  
  public String getEventId()
  {
    return this.Wb;
  }
  
  public String getMilestoneId()
  {
    return this.Xj;
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  public long getTargetProgress()
  {
    return this.acE;
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
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    MilestoneEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/quest/MilestoneEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */