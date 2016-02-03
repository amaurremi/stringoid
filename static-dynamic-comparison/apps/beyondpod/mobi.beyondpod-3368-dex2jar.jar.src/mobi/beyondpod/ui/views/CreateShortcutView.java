package mobi.beyondpod.ui.views;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.StringUtils;

public class CreateShortcutView
  extends Activity
{
  private void setupShortcut()
  {
    final Object localObject = new AlertDialog.Builder(this);
    final View localView = LayoutInflater.from(this).inflate(2130903096, null);
    ((AlertDialog.Builder)localObject).setView(localView);
    ((AlertDialog.Builder)localObject).setTitle(2131296394);
    ((AlertDialog.Builder)localObject).setPositiveButton(2131296752, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        String str2 = ((EditText)localView.findViewById(2131230908)).getText().toString().trim();
        String str1 = ((EditText)localView.findViewById(2131230909)).getText().toString().trim();
        paramAnonymousDialogInterface = new Intent("android.media.action.MEDIA_PLAY_FROM_SEARCH");
        paramAnonymousDialogInterface.setClassName(CreateShortcutView.this, MasterView.class.getName());
        paramAnonymousDialogInterface.putExtra("query", str2);
        Intent localIntent = new Intent();
        localIntent.putExtra("android.intent.extra.shortcut.INTENT", paramAnonymousDialogInterface);
        paramAnonymousDialogInterface = str1;
        if (StringUtils.IsNullOrEmpty(str1)) {
          paramAnonymousDialogInterface = CreateShortcutView.this.getResources().getString(2131296975) + " " + str2;
        }
        localIntent.putExtra("android.intent.extra.shortcut.NAME", paramAnonymousDialogInterface);
        localIntent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(CreateShortcutView.this, 2130838001));
        CreateShortcutView.this.setResult(-1, localIntent);
        CreateShortcutView.this.finish();
      }
    });
    ((AlertDialog.Builder)localObject).setNegativeButton(2131296315, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.cancel();
        CreateShortcutView.this.finish();
      }
    });
    ((AlertDialog.Builder)localObject).setNeutralButton(2131296757, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface = new Intent("android.intent.action.VIEW");
        paramAnonymousDialogInterface.setData(Configuration.HelpFileQuickPlayURL());
        CreateShortcutView.this.startActivity(paramAnonymousDialogInterface);
        CreateShortcutView.this.finish();
      }
    });
    ((AlertDialog.Builder)localObject).setIcon(2130838001);
    localObject = ((AlertDialog.Builder)localObject).show();
    ((AlertDialog)localObject).getButton(-1).setEnabled(false);
    ((EditText)localView.findViewById(2131230908)).addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        Button localButton = localObject.getButton(-1);
        if (paramAnonymousCharSequence.length() > 0) {}
        for (boolean bool = true;; bool = false)
        {
          localButton.setEnabled(bool);
          return;
        }
      }
    });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ("android.intent.action.CREATE_SHORTCUT".equals(getIntent().getAction())) {
      setupShortcut();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/CreateShortcutView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */