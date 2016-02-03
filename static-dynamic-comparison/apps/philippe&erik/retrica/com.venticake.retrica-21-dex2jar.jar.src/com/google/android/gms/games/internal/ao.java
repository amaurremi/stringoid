package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events.LoadEventsResult;

final class ao
  extends b
  implements Events.LoadEventsResult
{
  private final EventBuffer a;
  
  ao(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    this.a = new EventBuffer(paramDataHolder);
  }
  
  public EventBuffer getEvents()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */