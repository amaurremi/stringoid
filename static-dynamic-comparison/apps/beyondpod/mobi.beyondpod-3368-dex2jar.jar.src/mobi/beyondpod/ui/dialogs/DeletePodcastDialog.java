package mobi.beyondpod.ui.dialogs;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import java.util.Iterator;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.TrackList;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.rss.ItemStateHistory;
import mobi.beyondpod.ui.core.MusicUtils;

public class DeletePodcastDialog
{
  ICompletionListener _CompletionListener;
  Context _Context;
  boolean _DeleteLocked = false;
  DialogInterface.OnClickListener _OnOK = new DialogInterface.OnClickListener()
  {
    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
    {
      paramAnonymousDialogInterface = DeletePodcastDialog.this._Tracks.iterator();
      for (;;)
      {
        if (!paramAnonymousDialogInterface.hasNext())
        {
          if (Configuration.ForceMediaDatabaseRescanOnDownloadOrDelete()) {
            MusicUtils.ForceMediaScanFor(FeedRepository.getRootPath());
          }
          if (DeletePodcastDialog.this._CompletionListener != null) {
            DeletePodcastDialog.this._CompletionListener.OnDeleted();
          }
          return;
        }
        Track localTrack = (Track)paramAnonymousDialogInterface.next();
        if ((DeletePodcastDialog.this._DeleteLocked) || (localTrack.AllowAutoDelete()))
        {
          FeedRepository.DeleteTrackAsync(localTrack);
          ItemStateHistory.MarkTracksItemAsRead(localTrack);
        }
      }
    }
  };
  TrackList _Tracks;
  
  private String GetFormattedTracks(boolean paramBoolean)
  {
    if (this._Tracks == null) {
      return this._Context.getResources().getString(2131296960);
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    Iterator localIterator = this._Tracks.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        return this._Context.getString(2131296705, new Object[] { localStringBuilder1.toString() });
      }
      localObject = (Track)localIterator.next();
    } while ((!((Track)localObject).AllowAutoDelete()) && (paramBoolean));
    if (localStringBuilder1.length() > 1) {
      localStringBuilder1.append("\n\n");
    }
    StringBuilder localStringBuilder2 = new StringBuilder("• ").append(((Track)localObject).DisplayName());
    if (!((Track)localObject).AllowAutoDelete()) {}
    for (Object localObject = " (" + CoreHelper.LoadResourceString(2131296961) + ")";; localObject = "")
    {
      localStringBuilder1.append((String)localObject);
      break;
    }
  }
  
  private boolean HasLockedTracks()
  {
    if (this._Tracks == null) {}
    Iterator localIterator;
    do
    {
      while (!localIterator.hasNext())
      {
        return false;
        localIterator = this._Tracks.iterator();
      }
    } while (((Track)localIterator.next()).AllowAutoDelete());
    return true;
  }
  
  private static DeletePodcastDialog Init(Context paramContext, TrackList paramTrackList)
  {
    DeletePodcastDialog localDeletePodcastDialog = new DeletePodcastDialog();
    localDeletePodcastDialog._Tracks = paramTrackList;
    localDeletePodcastDialog._Context = paramContext;
    return localDeletePodcastDialog;
  }
  
  public static void ShowDialog(Context paramContext, TrackList paramTrackList)
  {
    Init(paramContext, paramTrackList).CreateDialog().show();
  }
  
  public static void ShowDialog(Context paramContext, TrackList paramTrackList, ICompletionListener paramICompletionListener)
  {
    paramContext = Init(paramContext, paramTrackList);
    paramContext._CompletionListener = paramICompletionListener;
    paramContext.CreateDialog().show();
  }
  
  public Dialog CreateDialog()
  {
    int i = 0;
    View localView = LayoutInflater.from(this._Context).inflate(2130903093, null);
    final TextView localTextView = (TextView)localView.findViewById(2131230809);
    localTextView.setGravity(3);
    boolean bool;
    label60:
    CheckBox localCheckBox;
    if (this._Tracks.size() == 1)
    {
      bool = true;
      this._DeleteLocked = bool;
      if (!this._DeleteLocked) {
        break label176;
      }
      bool = false;
      localTextView.setText(GetFormattedTracks(bool));
      localCheckBox = (CheckBox)localView.findViewById(2131230902);
      if ((this._Tracks.size() <= 1) || (!HasLockedTracks())) {
        break label181;
      }
    }
    for (;;)
    {
      localCheckBox.setVisibility(i);
      localCheckBox.setText(2131296727);
      localCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          DeletePodcastDialog.this._DeleteLocked = paramAnonymousBoolean;
          paramAnonymousCompoundButton = localTextView;
          DeletePodcastDialog localDeletePodcastDialog = DeletePodcastDialog.this;
          if (DeletePodcastDialog.this._DeleteLocked) {}
          for (paramAnonymousBoolean = false;; paramAnonymousBoolean = true)
          {
            paramAnonymousCompoundButton.setText(localDeletePodcastDialog.GetFormattedTracks(paramAnonymousBoolean));
            return;
          }
        }
      });
      return new AlertDialog.Builder(this._Context).setIcon(17301543).setTitle(2131296704).setView(localView).setPositiveButton(2131296752, this._OnOK).setNegativeButton(2131296315, null).create();
      bool = false;
      break;
      label176:
      bool = true;
      break label60;
      label181:
      i = 8;
    }
  }
  
  public static abstract interface ICompletionListener
  {
    public abstract void OnDeleted();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/dialogs/DeletePodcastDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */