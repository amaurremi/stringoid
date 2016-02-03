package mobi.beyondpod.ui.dialogs;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.repository.FeedRepository;

public class DeleteFeedDialog
{
  private static final String ARE_YOU_SURE_YOU_WANT_TO_DELETE = CoreHelper.LoadResourceString(2131297008);
  private static final String FEED = CoreHelper.LoadResourceString(2131297009);
  Context _Context;
  Feed _Feed;
  DialogInterface.OnClickListener _OnOK = new DialogInterface.OnClickListener()
  {
    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
    {
      FeedRepository.DeleteFeedAndRelatedFoldersAsync(DeleteFeedDialog.this._Feed);
    }
  };
  
  private String GetMessage()
  {
    Context localContext = this._Context;
    int i;
    if ((this._Feed.HasUrl()) && (this._Feed.HasPodcasts()))
    {
      i = 2131296708;
      if (this._Feed == null) {
        break label63;
      }
    }
    label63:
    for (String str = this._Feed.getName();; str = FEED)
    {
      return localContext.getString(i, new Object[] { str });
      i = 2131296707;
      break;
    }
  }
  
  public static void ShowDialog(Context paramContext, Feed paramFeed)
  {
    DeleteFeedDialog localDeleteFeedDialog = new DeleteFeedDialog();
    localDeleteFeedDialog._Feed = paramFeed;
    localDeleteFeedDialog._Context = paramContext;
    localDeleteFeedDialog.CreateDialog().show();
  }
  
  public Dialog CreateDialog()
  {
    if (this._Feed == null) {
      return null;
    }
    return new AlertDialog.Builder(this._Context).setIcon(17301543).setTitle(2131296706).setMessage(GetMessage()).setPositiveButton(2131296752, this._OnOK).setNegativeButton(2131296315, null).create();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/dialogs/DeleteFeedDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */