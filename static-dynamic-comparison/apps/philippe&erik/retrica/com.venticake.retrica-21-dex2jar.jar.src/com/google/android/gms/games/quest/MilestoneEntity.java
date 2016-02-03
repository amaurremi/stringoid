package com.google.android.gms.games.quest;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hk.a;

public final class MilestoneEntity
  implements SafeParcelable, Milestone
{
  public static final MilestoneEntityCreator CREATOR = new MilestoneEntityCreator();
  private final String Ni;
  private final String Ot;
  private final long TM;
  private final long TN;
  private final byte[] TO;
  private final int mState;
  private final int xM;
  
  MilestoneEntity(int paramInt1, String paramString1, long paramLong1, long paramLong2, byte[] paramArrayOfByte, int paramInt2, String paramString2)
  {
    this.xM = paramInt1;
    this.Ot = paramString1;
    this.TM = paramLong1;
    this.TN = paramLong2;
    this.TO = paramArrayOfByte;
    this.mState = paramInt2;
    this.Ni = paramString2;
  }
  
  public MilestoneEntity(Milestone paramMilestone)
  {
    this.xM = 4;
    this.Ot = paramMilestone.getMilestoneId();
    this.TM = paramMilestone.getCurrentProgress();
    this.TN = paramMilestone.getTargetProgress();
    this.mState = paramMilestone.getState();
    this.Ni = paramMilestone.getEventId();
    paramMilestone = paramMilestone.getCompletionRewardData();
    if (paramMilestone == null)
    {
      this.TO = null;
      return;
    }
    this.TO = new byte[paramMilestone.length];
    System.arraycopy(paramMilestone, 0, this.TO, 0, paramMilestone.length);
  }
  
  static int a(Milestone paramMilestone)
  {
    return hk.hashCode(new Object[] { paramMilestone.getMilestoneId(), Long.valueOf(paramMilestone.getCurrentProgress()), Long.valueOf(paramMilestone.getTargetProgress()), Integer.valueOf(paramMilestone.getState()), paramMilestone.getEventId() });
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
      if ((!hk.equal(((Milestone)paramObject).getMilestoneId(), paramMilestone.getMilestoneId())) || (!hk.equal(Long.valueOf(((Milestone)paramObject).getCurrentProgress()), Long.valueOf(paramMilestone.getCurrentProgress()))) || (!hk.equal(Long.valueOf(((Milestone)paramObject).getTargetProgress()), Long.valueOf(paramMilestone.getTargetProgress()))) || (!hk.equal(Integer.valueOf(((Milestone)paramObject).getState()), Integer.valueOf(paramMilestone.getState())))) {
        break;
      }
      bool1 = bool2;
    } while (hk.equal(((Milestone)paramObject).getEventId(), paramMilestone.getEventId()));
    return false;
  }
  
  static String b(Milestone paramMilestone)
  {
    return hk.e(paramMilestone).a("MilestoneId", paramMilestone.getMilestoneId()).a("CurrentProgress", Long.valueOf(paramMilestone.getCurrentProgress())).a("TargetProgress", Long.valueOf(paramMilestone.getTargetProgress())).a("State", Integer.valueOf(paramMilestone.getState())).a("CompletionRewardData", paramMilestone.getCompletionRewardData()).a("EventId", paramMilestone.getEventId()).toString();
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
    return this.TO;
  }
  
  public long getCurrentProgress()
  {
    return this.TM;
  }
  
  public String getEventId()
  {
    return this.Ni;
  }
  
  public String getMilestoneId()
  {
    return this.Ot;
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  public long getTargetProgress()
  {
    return this.TN;
  }
  
  public int getVersionCode()
  {
    return this.xM;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/quest/MilestoneEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */