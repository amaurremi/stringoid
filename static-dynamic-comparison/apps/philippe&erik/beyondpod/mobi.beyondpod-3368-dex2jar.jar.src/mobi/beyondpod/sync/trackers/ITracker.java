package mobi.beyondpod.sync.trackers;

import java.util.List;
import mobi.beyondpod.sync.TrackedChangeBase;

public abstract interface ITracker
{
  public abstract void Close();
  
  public abstract List<TrackedChangeBase> GetRemoteChangesSince(long paramLong)
    throws Exception;
  
  public abstract void Initialize()
    throws Exception;
  
  public abstract void SyncChangesUp(List<TrackedChangeBase> paramList)
    throws Exception;
  
  public abstract List<TrackedChangeBase> SyncPushPull(List<TrackedChangeBase> paramList, long paramLong)
    throws Exception;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/sync/trackers/ITracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */