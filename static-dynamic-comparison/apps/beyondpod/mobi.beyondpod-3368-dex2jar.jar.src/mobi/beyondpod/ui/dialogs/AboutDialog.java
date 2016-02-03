package mobi.beyondpod.ui.dialogs;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.rss.LicenseManager;
import mobi.beyondpod.ui.commands.CommandManager;
import org.apache.http.impl.cookie.DateUtils;

public class AboutDialog
{
  private static final String ABOUT_BEYOND_POD = CoreHelper.LoadResourceString(2131296999);
  private static final String EXPIRES = CoreHelper.LoadResourceString(2131297000);
  private static final String LICENSED_TO = CoreHelper.LoadResourceString(2131297001);
  private Context _Context;
  LinearLayout _contextMenu;
  
  private AboutDialog(Context paramContext)
  {
    this._Context = paramContext;
  }
  
  private Dialog CreateDialog()
  {
    View localView = LayoutInflater.from(this._Context).inflate(2130903063, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131230799);
    localTextView1.setText(Configuration.ProductVersionAsString());
    TextView localTextView2 = (TextView)localView.findViewById(2131230802);
    Linkify.addLinks((TextView)localView.findViewById(2131230803), 15);
    this._contextMenu = ((LinearLayout)localView.findViewById(2131230800));
    ((Button)localView.findViewById(2131230801)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CommandManager.CmdShowDeveloperSettings();
        AboutDialog.this._contextMenu.setVisibility(8);
      }
    });
    String[] arrayOfString = LicenseManager.GetLicenseKey();
    if ((arrayOfString != null) && (arrayOfString.length > 1)) {
      localTextView2.setText(LICENSED_TO + ": " + arrayOfString[1]);
    }
    for (;;)
    {
      localTextView1.setOnLongClickListener(new View.OnLongClickListener()
      {
        public boolean onLongClick(View paramAnonymousView)
        {
          AboutDialog.this._contextMenu.setVisibility(0);
          return true;
        }
      });
      return new AlertDialog.Builder(this._Context).setIcon(17301659).setTitle(ABOUT_BEYOND_POD + " " + BeyondPodApplication.DumpWakeLocks()).setView(localView).setPositiveButton(2131296752, null).create();
      localTextView2.setText(EXPIRES + " " + DateUtils.formatDate(LicenseManager.TrialExpirationDate(), "MMM d yyyy"));
    }
  }
  
  public static void ShowDialog(Context paramContext)
  {
    new AboutDialog(paramContext).CreateDialog().show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/dialogs/AboutDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */