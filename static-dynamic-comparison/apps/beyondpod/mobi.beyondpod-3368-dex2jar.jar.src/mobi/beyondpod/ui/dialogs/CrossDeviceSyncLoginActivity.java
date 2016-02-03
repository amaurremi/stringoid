package mobi.beyondpod.ui.dialogs;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.sync.ChangeTracker;
import mobi.beyondpod.sync.trackers.bp.AuthenticationException;
import mobi.beyondpod.sync.trackers.bp.AuthenticationResult;
import mobi.beyondpod.sync.trackers.bp.BeyondPodServiceClientV1;
import mobi.beyondpod.sync.trackers.bp.BeyondPodServiceClientV1.AuthType;
import mobi.beyondpod.sync.trackers.bp.ServiceException;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.core.ActionBarActivityBase;
import mobi.beyondpod.ui.core.ActionBarHelper;

public class CrossDeviceSyncLoginActivity
  extends ActionBarActivityBase
{
  private static final String BEYOND_POD_HELP = CoreHelper.LoadResourceString(2131297061);
  private static final int MENU_HELP = 0;
  private static final String TAG = CrossDeviceSyncLoginActivity.class.getSimpleName();
  public final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");
  private Button _Cancel;
  Context _Context;
  private TextView _InfoLabel;
  private Button _Login;
  private String _LoginPassword;
  private ProgressBar _LoginProgress;
  private String _LoginUserName;
  private boolean _ModeCreate;
  private TextView _ModeLabel;
  private EditText _Password;
  private EditText _RetypePassword;
  private EditText _UserName;
  
  protected void onCreate(final Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this._Context = this;
    setContentView(2130903097);
    this._UserName = ((EditText)findViewById(2131230912));
    this._Password = ((EditText)findViewById(2131230913));
    this._RetypePassword = ((EditText)findViewById(2131230914));
    this._ModeCreate = "CREATE".equals(getIntent().getStringExtra("TYPE"));
    this._LoginProgress = ((ProgressBar)findViewById(2131230911));
    this._LoginProgress.setVisibility(4);
    this._Cancel = ((Button)findViewById(2131230929));
    this._Cancel.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CrossDeviceSyncLoginActivity.this.finish();
      }
    });
    this._Login = ((Button)findViewById(2131230928));
    this._Login.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = (InputMethodManager)CrossDeviceSyncLoginActivity.this.getSystemService("input_method");
        paramAnonymousView.hideSoftInputFromWindow(CrossDeviceSyncLoginActivity.this._UserName.getWindowToken(), 0);
        paramAnonymousView.hideSoftInputFromWindow(CrossDeviceSyncLoginActivity.this._Password.getWindowToken(), 0);
        paramAnonymousView.hideSoftInputFromWindow(CrossDeviceSyncLoginActivity.this._RetypePassword.getWindowToken(), 0);
        CrossDeviceSyncLoginActivity.this._LoginUserName = CrossDeviceSyncLoginActivity.this._UserName.getText().toString().trim();
        CrossDeviceSyncLoginActivity.this._LoginPassword = CrossDeviceSyncLoginActivity.this._Password.getText().toString().trim();
        if ((StringUtils.IsNullOrEmpty(CrossDeviceSyncLoginActivity.this._LoginUserName)) || (!CrossDeviceSyncLoginActivity.this.EMAIL_ADDRESS_PATTERN.matcher(CrossDeviceSyncLoginActivity.this._LoginUserName).matches()))
        {
          CrossDeviceSyncLoginActivity.this._UserName.setText(CrossDeviceSyncLoginActivity.this._LoginUserName);
          CrossDeviceSyncLoginActivity.this._UserName.requestFocus();
          Toast.makeText(CrossDeviceSyncLoginActivity.this, 2131297226, 0).show();
          return;
        }
        if ((StringUtils.IsNullOrEmpty(CrossDeviceSyncLoginActivity.this._LoginPassword)) || (CrossDeviceSyncLoginActivity.this._LoginPassword.length() < 5))
        {
          CrossDeviceSyncLoginActivity.this._Password.setText(CrossDeviceSyncLoginActivity.this._LoginPassword);
          CrossDeviceSyncLoginActivity.this._Password.requestFocus();
          Toast.makeText(CrossDeviceSyncLoginActivity.this, 2131297227, 0).show();
          return;
        }
        if (CrossDeviceSyncLoginActivity.this._ModeCreate)
        {
          paramAnonymousView = CrossDeviceSyncLoginActivity.this._RetypePassword.getText().toString().trim();
          if (!CrossDeviceSyncLoginActivity.this._LoginPassword.equals(paramAnonymousView))
          {
            CrossDeviceSyncLoginActivity.this._RetypePassword.requestFocus();
            Toast.makeText(CrossDeviceSyncLoginActivity.this, 2131297229, 0).show();
            return;
          }
          new CrossDeviceSyncLoginActivity.LoginTask(CrossDeviceSyncLoginActivity.this, null).execute(new String[] { CrossDeviceSyncLoginActivity.this._LoginUserName, CrossDeviceSyncLoginActivity.this._LoginPassword, paramAnonymousView });
          return;
        }
        new CrossDeviceSyncLoginActivity.LoginTask(CrossDeviceSyncLoginActivity.this, null).execute(new String[] { CrossDeviceSyncLoginActivity.this._LoginUserName, CrossDeviceSyncLoginActivity.this._LoginPassword });
      }
    });
    this._ModeLabel = ((TextView)findViewById(2131230910));
    this._InfoLabel = ((TextView)findViewById(2131230915));
    if (this._ModeCreate)
    {
      this._RetypePassword.setVisibility(0);
      this._ModeLabel.setText(2131297219);
      this._Login.setText(2131297221);
      this._InfoLabel.setText(2131297213);
    }
    for (;;)
    {
      getActionBarHelper().setDisplayOptions(4, 4);
      setTitle("");
      getWindow().setSoftInputMode(3);
      return;
      this._RetypePassword.setVisibility(8);
      this._ModeLabel.setText(2131297218);
      this._Login.setText(2131297218);
      paramBundle = getResources().getString(2131297214);
      this._InfoLabel.setText(paramBundle);
      this._InfoLabel.setGravity(5);
      this._InfoLabel.setText(2131297214);
      this._InfoLabel.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          CommandManager.CmdStartHtmlViewActivity(Uri.withAppendedPath(Configuration.CDSEndpoint(), "forgotPassword"), paramBundle, false);
        }
      });
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    paramMenu.add(0, 0, 0, 2131296681);
    return true;
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    case 16908332: 
      finish();
      return true;
    }
    CommandManager.CmdStartHtmlViewActivity(Configuration.BackupRestoreFileURL(), BEYOND_POD_HELP, false);
    return true;
  }
  
  private static class LoginResult
  {
    static final int RESULT_ACCOUNT_ALREADY_EXISTS = -4;
    static final int RESULT_ACCOUNT_QUOTA_REACHED = -6;
    static final int RESULT_AUTH_FAILED = -1;
    static final int RESULT_INVALID_EMAIL = -5;
    static final int RESULT_NETWORK_ERROR = -2;
    static final int RESULT_OK = 0;
    static final int RESULT_UNVERIFIED_ACCOUNT = -3;
    AuthenticationResult AuthResult;
    int LoginStatus;
  }
  
  private class LoginTask
    extends AsyncTask<String, Integer, CrossDeviceSyncLoginActivity.LoginResult>
  {
    private LoginTask() {}
    
    protected CrossDeviceSyncLoginActivity.LoginResult doInBackground(String... paramVarArgs)
    {
      CrossDeviceSyncLoginActivity.LoginResult localLoginResult = new CrossDeviceSyncLoginActivity.LoginResult(null);
      Object localObject = new BeyondPodServiceClientV1();
      for (;;)
      {
        try
        {
          if (paramVarArgs.length <= 2) {
            continue;
          }
          localLoginResult.AuthResult = ((BeyondPodServiceClientV1)localObject).registerUser(paramVarArgs[0], paramVarArgs[1], BeyondPodServiceClientV1.AuthType.BeyondPod, ChangeTracker.DeviceID());
          if (!localLoginResult.AuthResult.isWaitingForEmailVerification()) {
            continue;
          }
          i = -3;
        }
        catch (ServiceException paramVarArgs)
        {
          localObject = CrossDeviceSyncLoginActivity.TAG;
          StringBuilder localStringBuilder = new StringBuilder("Service Error! ");
          if (paramVarArgs.getCause() == null) {
            continue;
          }
          paramVarArgs = paramVarArgs.getCause().getMessage();
          CoreHelper.WriteLogEntry((String)localObject, paramVarArgs);
          localLoginResult.LoginStatus = -2;
          return localLoginResult;
          int i = 0;
          continue;
          paramVarArgs = paramVarArgs.getMessage();
          continue;
        }
        catch (AuthenticationException paramVarArgs)
        {
          switch (paramVarArgs.getStatusCode())
          {
          default: 
            localLoginResult.LoginStatus = -1;
            return localLoginResult;
          }
        }
        localLoginResult.LoginStatus = i;
        return localLoginResult;
        localLoginResult.AuthResult = ((BeyondPodServiceClientV1)localObject).authenticateUser(paramVarArgs[0], paramVarArgs[1], BeyondPodServiceClientV1.AuthType.BeyondPod, ChangeTracker.DeviceID(), false);
      }
      localLoginResult.LoginStatus = -4;
      return localLoginResult;
      localLoginResult.LoginStatus = -5;
      return localLoginResult;
      localLoginResult.LoginStatus = -3;
      return localLoginResult;
      localLoginResult.LoginStatus = -6;
      return localLoginResult;
    }
    
    protected void onPostExecute(CrossDeviceSyncLoginActivity.LoginResult paramLoginResult)
    {
      CrossDeviceSyncLoginActivity.this._LoginProgress.setVisibility(4);
      if ((paramLoginResult == null) || (paramLoginResult.LoginStatus == -2))
      {
        Toast.makeText(CrossDeviceSyncLoginActivity.this, 2131297232, 1).show();
        return;
      }
      if (paramLoginResult.LoginStatus == -1)
      {
        Toast.makeText(CrossDeviceSyncLoginActivity.this, 2131297230, 1).show();
        return;
      }
      if (paramLoginResult.LoginStatus == -4)
      {
        Toast.makeText(CrossDeviceSyncLoginActivity.this, 2131297231, 1).show();
        return;
      }
      if (paramLoginResult.LoginStatus == -5)
      {
        Toast.makeText(CrossDeviceSyncLoginActivity.this, 2131297226, 1).show();
        return;
      }
      if (paramLoginResult.LoginStatus == -6)
      {
        Toast.makeText(CrossDeviceSyncLoginActivity.this, 2131297228, 1).show();
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("UserName", CrossDeviceSyncLoginActivity.this._LoginUserName);
      if (paramLoginResult.LoginStatus == 0) {
        localIntent.putExtra("Password", paramLoginResult.AuthResult.getEncryptedPassword());
      }
      localIntent.putExtra("DeviceID", ChangeTracker.DeviceID());
      CrossDeviceSyncLoginActivity.this.setResult(-1, localIntent);
      CrossDeviceSyncLoginActivity.this.finish();
    }
    
    protected void onPreExecute()
    {
      CrossDeviceSyncLoginActivity.this._LoginProgress.setVisibility(0);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/dialogs/CrossDeviceSyncLoginActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */