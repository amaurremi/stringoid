package com.google.android.gms.games.quest;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public abstract interface Milestone
  extends Parcelable, Freezable<Milestone>
{
  public static final int STATE_CLAIMED = 4;
  public static final int STATE_COMPLETED_NOT_CLAIMED = 3;
  public static final int STATE_NOT_COMPLETED = 2;
  public static final int STATE_NOT_STARTED = 1;
  public static final long UNSET_CRITERIA = -1L;
  
  public abstract byte[] getCompletionRewardData();
  
  public abstract long getCurrentProgress();
  
  public abstract String getEventId();
  
  public abstract String getMilestoneId();
  
  public abstract int getState();
  
  public abstract long getTargetProgress();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/quest/Milestone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */