package com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;

public final class ExperienceEventRef
  extends d
  implements ExperienceEvent
{
  public ExperienceEventRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  public String getIconImageUrl()
  {
    return getString("icon_url");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/experience/ExperienceEventRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */