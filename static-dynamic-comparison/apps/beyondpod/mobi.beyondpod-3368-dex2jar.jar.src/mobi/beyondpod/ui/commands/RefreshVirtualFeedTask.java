package mobi.beyondpod.ui.commands;

import android.os.AsyncTask;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.TrackList;
import mobi.beyondpod.rsscore.repository.FeedRepository;

public class RefreshVirtualFeedTask
  extends AsyncTask<Feed, Integer, Void>
{
  ITrackImageRefreshProgress _ProgressNotifier;
  
  public RefreshVirtualFeedTask(ITrackImageRefreshProgress paramITrackImageRefreshProgress)
  {
    this._ProgressNotifier = paramITrackImageRefreshProgress;
  }
  
  public Void doInBackground(Feed... paramVarArgs)
  {
    if (paramVarArgs != null) {
      try
      {
        FeedRepository.RefreshFeed(paramVarArgs[0]);
        paramVarArgs = paramVarArgs[0].TracksAndSubTracks();
        int j = paramVarArgs.size() / 20;
        int i = 0;
        for (;;)
        {
          if (i == paramVarArgs.size())
          {
            publishProgress(new Integer[] { Integer.valueOf(99) });
            FeedRepository.SaveRepositorySync();
            publishProgress(new Integer[] { Integer.valueOf(100) });
            return null;
          }
          Track localTrack = (Track)paramVarArgs.get(i);
          localTrack.setTrackImagePath(null);
          localTrack.EnsureTrackHasContentTypeAndImage();
          if ((i % j == 0) && (i / j * 5 < 100)) {
            publishProgress(new Integer[] { Integer.valueOf(i / j * 5) });
          }
          i += 1;
        }
        return null;
      }
      catch (Exception paramVarArgs) {}
    }
  }
  
  protected void onPostExecute(Void paramVoid)
  {
    if (this._ProgressNotifier != null) {
      this._ProgressNotifier.OnRefreshCompleted();
    }
  }
  
  protected void onPreExecute()
  {
    if (this._ProgressNotifier != null) {
      this._ProgressNotifier.OnRefreshStarted();
    }
  }
  
  protected void onProgressUpdate(Integer... paramVarArgs)
  {
    if (this._ProgressNotifier != null) {
      this._ProgressNotifier.OnRefreshProgress(paramVarArgs[0].intValue());
    }
  }
  
  public static abstract interface ITrackImageRefreshProgress
  {
    public abstract void OnRefreshCompleted();
    
    public abstract void OnRefreshProgress(int paramInt);
    
    public abstract void OnRefreshStarted();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/commands/RefreshVirtualFeedTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */