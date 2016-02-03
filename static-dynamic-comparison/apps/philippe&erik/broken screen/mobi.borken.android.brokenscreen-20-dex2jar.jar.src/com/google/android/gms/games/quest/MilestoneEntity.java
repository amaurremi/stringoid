package com.google.android.gms.games.quest;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;

public final class MilestoneEntity
  implements SafeParcelable, Milestone
{
  public static final MilestoneEntityCreator CREATOR = new MilestoneEntityCreator();
  private final String Nf;
  private final String Oq;
  private final long TJ;
  private final long TK;
  private final byte[] TL;
  private final int mState;
  private final int xJ;
  
  MilestoneEntity(int paramInt1, String paramString1, long paramLong1, long paramLong2, byte[] paramArrayOfByte, int paramInt2, String paramString2)
  {
    this.xJ = paramInt1;
    this.Oq = paramString1;
    this.TJ = paramLong1;
    this.TK = paramLong2;
    this.TL = paramArrayOfByte;
    this.mState = paramInt2;
    this.Nf = paramString2;
  }
  
  public MilestoneEntity(Milestone paramMilestone)
  {
    this.xJ = 4;
    this.Oq = paramMilestone.getMilestoneId();
    this.TJ = paramMilestone.getCurrentProgress();
    this.TK = paramMilestone.getTargetProgress();
    this.mState = paramMilestone.getState();
    this.Nf = paramMilestone.getEventId();
    paramMilestone = paramMilestone.getCompletionRewardData();
    if (paramMilestone == null)
    {
      this.TL = null;
      return;
    }
    this.TL = new byte[paramMilestone.length];
    System.arraycopy(paramMilestone, 0, this.TL, 0, paramMilestone.length);
  }
  
  static int a(Milestone paramMilestone)
  {
    return hl.hashCode(new Object[] { paramMilestone.getMilestoneId(), Long.valueOf(paramMilestone.getCurrentProgress()), Long.valueOf(paramMilestone.getTargetProgress()), Integer.valueOf(paramMilestone.getState()), paramMilestone.getEventId() });
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
      if ((!hl.equal(((Milestone)paramObject).getMilestoneId(), paramMilestone.getMilestoneId())) || (!hl.equal(Long.valueOf(((Milestone)paramObject).getCurrentProgress()), Long.valueOf(paramMilestone.getCurrentProgress()))) || (!hl.equal(Long.valueOf(((Milestone)paramObject).getTargetProgress()), Long.valueOf(paramMilestone.getTargetProgress()))) || (!hl.equal(Integer.valueOf(((Milestone)paramObject).getState()), Integer.valueOf(paramMilestone.getState())))) {
        break;
      }
      bool1 = bool2;
    } while (hl.equal(((Milestone)paramObject).getEventId(), paramMilestone.getEventId()));
    return false;
  }
  
  static String b(Milestone paramMilestone)
  {
    return hl.e(paramMilestone).a("MilestoneId", paramMilestone.getMilestoneId()).a("CurrentProgress", Long.valueOf(paramMilestone.getCurrentProgress())).a("TargetProgress", Long.valueOf(paramMilestone.getTargetProgress())).a("State", Integer.valueOf(paramMilestone.getState())).a("CompletionRewardData", paramMilestone.getCompletionRewardData()).a("EventId", paramMilestone.getEventId()).toString();
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
    return this.TL;
  }
  
  public long getCurrentProgress()
  {
    return this.TJ;
  }
  
  public String getEventId()
  {
    return this.Nf;
  }
  
  public String getMilestoneId()
  {
    return this.Oq;
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  public long getTargetProgress()
  {
    return this.TK;
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
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    MilestoneEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/quest/MilestoneEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */