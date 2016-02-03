package mobi.beyondpod.ui.dialogs;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Date;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.ConfigurationSD;
import mobi.beyondpod.rsscore.rss.LicenseManager;
import org.apache.http.impl.cookie.DateUtils;

public class PurchaseUnlockKeyDialog
{
  private Context _Context;
  
  private PurchaseUnlockKeyDialog(Context paramContext)
  {
    this._Context = paramContext;
  }
  
  public static void ShowDialog(Context paramContext)
  {
    new PurchaseUnlockKeyDialog(paramContext).CreateDialog().show();
  }
  
  public Dialog CreateDialog()
  {
    View localView = LayoutInflater.from(this._Context).inflate(2130903159, null);
    TextView localTextView = (TextView)localView.findViewById(2131231170);
    if (new Date().compareTo(LicenseManager.TrialExpirationDate()) > 0) {}
    for (int i = 2131296774;; i = 2131296773)
    {
      localTextView.setText(i);
      ((TextView)localView.findViewById(2131231171)).setText(DateUtils.formatDate(LicenseManager.TrialExpirationDate(), "MMM d yyyy"));
      ((TextView)localView.findViewById(2131231172)).setText(ConfigurationSD.getAppStoreMessageId());
      new AlertDialog.Builder(this._Context).setTitle(2131296772).setView(localView).setPositiveButton(2131296777, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface = new Intent("android.intent.action.VIEW");
          paramAnonymousDialogInterface.setData(Configuration.getUnlocKeyAppStoreIntent());
          try
          {
            PurchaseUnlockKeyDialog.this._Context.startActivity(paramAnonymousDialogInterface);
            return;
          }
          catch (Exception paramAnonymousDialogInterface)
          {
            Toast.makeText(PurchaseUnlockKeyDialog.this._Context, paramAnonymousDialogInterface.getMessage(), 1).show();
          }
        }
      }).create();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/dialogs/PurchaseUnlockKeyDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */