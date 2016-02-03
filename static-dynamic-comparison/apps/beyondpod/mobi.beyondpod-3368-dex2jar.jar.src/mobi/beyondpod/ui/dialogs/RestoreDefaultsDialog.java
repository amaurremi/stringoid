package mobi.beyondpod.ui.dialogs;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import mobi.beyondpod.rsscore.repository.FeedRepository;

public class RestoreDefaultsDialog
{
  private Context _Context;
  DialogInterface.OnClickListener _OnOK = new DialogInterface.OnClickListener()
  {
    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
    {
      FeedRepository.DeleteAllRepositoryFiles();
      System.exit(0);
    }
  };
  
  private RestoreDefaultsDialog(Context paramContext)
  {
    this._Context = paramContext;
  }
  
  public static void ShowDialog(Context paramContext)
  {
    new RestoreDefaultsDialog(paramContext).CreateDialog().show();
  }
  
  public Dialog CreateDialog()
  {
    return new AlertDialog.Builder(this._Context).setIcon(17301543).setTitle(2131296899).setMessage(2131296900).setPositiveButton(2131296752, this._OnOK).create();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/dialogs/RestoreDefaultsDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */