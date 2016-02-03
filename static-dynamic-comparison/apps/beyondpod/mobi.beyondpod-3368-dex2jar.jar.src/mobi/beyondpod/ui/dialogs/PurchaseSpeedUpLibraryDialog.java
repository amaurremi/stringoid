package mobi.beyondpod.ui.dialogs;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.ui.commands.CommandManager;

public class PurchaseSpeedUpLibraryDialog
{
  Context _Context;
  
  public PurchaseSpeedUpLibraryDialog(Context paramContext)
  {
    this._Context = paramContext;
  }
  
  public static void ShowDialog(Context paramContext)
  {
    new PurchaseSpeedUpLibraryDialog(paramContext).CreateDialog().show();
  }
  
  public Dialog CreateDialog()
  {
    View localView = LayoutInflater.from(this._Context).inflate(2130903102, null);
    localView.setMinimumHeight(300);
    final TextView localTextView = (TextView)localView.findViewById(2131230809);
    localTextView.setGravity(3);
    localTextView.setText(2131296779);
    localTextView = (TextView)localView.findViewById(2131230903);
    localTextView.setGravity(3);
    final RadioGroup localRadioGroup = (RadioGroup)localView.findViewById(2131230810);
    localRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    {
      public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
      {
        localTextView.setVisibility(0);
        if (paramAnonymousInt == 2131230931)
        {
          localTextView.setText(2131296781);
          return;
        }
        localTextView.setText(2131296780);
      }
    });
    new AlertDialog.Builder(this._Context).setTitle(2131296778).setView(localView).setPositiveButton(2131296752, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        if (localRadioGroup.getCheckedRadioButtonId() == 2131230931)
        {
          Configuration.setEnableAudioPlugins(true);
          Configuration.setEnableSonicAudioPlugin(true);
          CommandManager.CmdLoadCurrentTrack();
        }
        while (localRadioGroup.getCheckedRadioButtonId() != 2131230932) {
          return;
        }
        Configuration.setEnableAudioPlugins(false);
        Configuration.setEnableSonicAudioPlugin(true);
      }
    }).setNegativeButton(2131296315, null).create();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/dialogs/PurchaseSpeedUpLibraryDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */