package mobi.borken.android.brokenscreen.view.helper;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.SpannableString;
import android.text.util.Linkify;
import android.widget.TextView;

public class DialogHelper
{
  public static Dialog createAboutDialog(Context paramContext, String paramString)
  {
    if (paramString == null) {
      paramContext.getString(2131165238);
    }
    SpannableString localSpannableString = new SpannableString(paramContext.getString(2131165237));
    TextView localTextView = new TextView(paramContext);
    localTextView.setPadding(4, 4, 4, 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localSpannableString).append("\n\n").append(paramContext.getString(2131165236, new Object[] { paramString }));
    localTextView.setText(localStringBuilder);
    Linkify.addLinks(localTextView, 15);
    new AlertDialog.Builder(paramContext).setTitle(paramContext.getString(2131165235)).setCancelable(true).setIcon(2130837548).setView(localTextView).setPositiveButton(2131165219, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.cancel();
      }
    }).create();
  }
  
  public static Dialog createChangesDialog(Context paramContext)
  {
    SpannableString localSpannableString = new SpannableString(paramContext.getString(2131165221));
    TextView localTextView = new TextView(paramContext);
    localTextView.setPadding(4, 4, 4, 4);
    localTextView.setText(localSpannableString);
    Linkify.addLinks(localTextView, 15);
    new AlertDialog.Builder(paramContext).setTitle(paramContext.getString(2131165220)).setCancelable(true).setIcon(2130837548).setView(localTextView).setPositiveButton(2131165219, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.cancel();
      }
    }).create();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/mobi/borken/android/brokenscreen/view/helper/DialogHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */