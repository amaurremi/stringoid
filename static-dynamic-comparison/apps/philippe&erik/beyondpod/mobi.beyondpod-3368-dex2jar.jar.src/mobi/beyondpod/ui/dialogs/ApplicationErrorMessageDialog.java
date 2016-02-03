package mobi.beyondpod.ui.dialogs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import mobi.beyondpod.ui.commands.CommandManager;

public class ApplicationErrorMessageDialog
  extends Activity
{
  public static String BUTTON_TEXT = "mobi.beyondpod.ButtonText";
  public static String ERROR_MESSAGE = "mobi.beyondpod.ErrorMessage";
  public static String ERROR_TYPE = "mobi.beyondpod.ErrorType";
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    requestWindowFeature(3);
    setContentView(2130903068);
    getWindow().setFeatureDrawableResource(3, 17301543);
    TextView localTextView = (TextView)findViewById(2131230814);
    Button localButton = (Button)findViewById(2131230817);
    int i;
    if (paramBundle != null)
    {
      localTextView.setText(paramBundle.getStringExtra(ERROR_MESSAGE));
      i = paramBundle.getIntExtra(ERROR_TYPE, -1);
      if (i >= 0) {
        break label102;
      }
      localButton.setText(2131296752);
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          ApplicationErrorMessageDialog.this.finish();
        }
      });
    }
    label102:
    do
    {
      return;
      localButton.setText(paramBundle.getStringExtra(BUTTON_TEXT));
    } while (i != 1);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CommandManager.CmdOpenGReaderLogin(ApplicationErrorMessageDialog.this, 1);
        ApplicationErrorMessageDialog.this.finish();
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/dialogs/ApplicationErrorMessageDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */