package mobi.beyondpod.ui.dialogs;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import com.google.android.gcm.GCMRegistrar;
import java.util.Date;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.sync.ChangeTracker;
import mobi.beyondpod.sync.trackers.bp.BPTracker;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.core.ActionBarActivityBase;
import mobi.beyondpod.ui.core.ActionBarHelper;

public class CrossDeviceSyncSetupActivity
  extends ActionBarActivityBase
{
  private static final String BEYOND_POD_HELP = CoreHelper.LoadResourceString(2131297061);
  private static final int MENU_HELP = 0;
  Spinner _AcceptFeeds;
  Context _CDSRegistrationContext;
  Button _CreateAccount;
  TextView _CurrentUser;
  TextView _DeviceId;
  TextView _ForgotPassword;
  TextView _Help;
  Button _Login;
  View _LoginArea;
  private View.OnClickListener _LoginCreateListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), CrossDeviceSyncLoginActivity.class);
      localIntent.setFlags(524288);
      if (paramAnonymousView == CrossDeviceSyncSetupActivity.this._Login) {}
      for (paramAnonymousView = "LOGIN";; paramAnonymousView = "CREATE")
      {
        localIntent.putExtra("TYPE", paramAnonymousView);
        CrossDeviceSyncSetupActivity.this.startActivityForResult(localIntent, 100);
        return;
      }
    }
  };
  private View.OnClickListener _LogoutListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      BPTracker.Logout();
      paramAnonymousView = CrossDeviceSyncSetupActivity.this;
      CrossDeviceSyncSetupActivity localCrossDeviceSyncSetupActivity = CrossDeviceSyncSetupActivity.this;
      CrossDeviceSyncSetupActivity.this._Token = "";
      localCrossDeviceSyncSetupActivity._Password = "";
      paramAnonymousView._UserName = "";
      CrossDeviceSyncSetupActivity.this.SaveSettings();
    }
  };
  CheckBox _OptAllowRemoteDeletions;
  String _Password;
  View _SettingsArea;
  CheckBox _SyncEnabled;
  private CompoundButton.OnCheckedChangeListener _SyncSettingsChangedListener = new CompoundButton.OnCheckedChangeListener()
  {
    public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
    {
      Configuration.setCDSAllowRemoteEpisodeDeletions(CrossDeviceSyncSetupActivity.this._OptAllowRemoteDeletions.isChecked());
    }
  };
  String _Token;
  private Runnable _UpdateLoginAreaRunnable = new Runnable()
  {
    public void run()
    {
      CrossDeviceSyncSetupActivity.this.updateLoginArea();
    }
  };
  String _UserName;
  
  private void SaveSettings()
  {
    if ((StringUtils.IsNullOrEmpty(this._UserName)) || (StringUtils.IsNullOrEmpty(this._Password)) || (StringUtils.IsNullOrEmpty(ChangeTracker.DeviceID())))
    {
      Configuration.setCDSEnabled(false);
      Configuration.setCDSUserName(this._UserName);
      Configuration.setCDSPassword(this._Password);
      Configuration.setCDSDeviceID(ChangeTracker.DeviceID());
      Configuration.setCDSSyncRetryInterval(0);
      if (!Configuration.CDSEnabled()) {
        break label141;
      }
      ChangeTracker.InitializeHistory();
      if (Configuration.LastRemoteChangeTimeStamp() < 0L) {
        Configuration.setLastRemoteChangeTimeStamp(new Date().getTime());
      }
      if ((BeyondPodApplication.GetInstance().IsGCMSupportedOnDevice()) && (!GCMRegistrar.isRegistered(this._CDSRegistrationContext))) {
        GCMRegistrar.register(this._CDSRegistrationContext, new String[] { Configuration.GCMSenderID() });
      }
    }
    for (;;)
    {
      updateLoginArea();
      return;
      Configuration.setCDSEnabled(this._SyncEnabled.isChecked());
      break;
      label141:
      if ((BeyondPodApplication.GetInstance().IsGCMSupportedOnDevice()) && (GCMRegistrar.isRegistered(this._CDSRegistrationContext))) {
        GCMRegistrar.unregister(this._CDSRegistrationContext);
      }
    }
  }
  
  private void UpdateLoginAreaDelayed()
  {
    this._Login.removeCallbacks(this._UpdateLoginAreaRunnable);
    this._Login.postDelayed(this._UpdateLoginAreaRunnable, 500L);
  }
  
  private void updateLoginArea()
  {
    Object localObject1 = this._LoginArea;
    int i;
    label136:
    int j;
    if (this._SyncEnabled.isChecked())
    {
      i = 0;
      ((View)localObject1).setVisibility(i);
      if ((StringUtils.IsNullOrEmpty(this._UserName)) || (StringUtils.IsNullOrEmpty(this._Password))) {
        break label444;
      }
      Object localObject2 = getString(2131297222, new Object[] { ChangeTracker.DeviceID() });
      localObject1 = localObject2;
      if (!StringUtils.IsNullOrEmpty(this._Token))
      {
        localObject2 = new StringBuilder(String.valueOf(localObject2 + "\n" + this._Token)).append("\n");
        if (!new Date().after(Configuration.CDSTokenExpiration())) {
          break label323;
        }
        localObject1 = "Token Expired";
        localObject1 = (String)localObject1;
      }
      j = 0;
      i = 0;
      if (!Configuration.CDSDebugEnabled()) {
        break label430;
      }
      if (!BeyondPodApplication.GetInstance().IsGCMSupportedOnDevice()) {
        break label406;
      }
      if (!StringUtils.IsNullOrEmpty(GCMRegistrar.getRegistrationId(this._CDSRegistrationContext))) {
        break label346;
      }
      localObject1 = localObject1 + "\nNot registered for InstantSync!";
      i = 1;
      label200:
      localObject1 = localObject1 + "\n" + Configuration.CDSEndpoint();
      this._DeviceId.setText((CharSequence)localObject1);
      this._DeviceId.setVisibility(0);
    }
    for (;;)
    {
      this._CurrentUser.setText(this._UserName);
      this._CurrentUser.setVisibility(0);
      this._Login.setVisibility(8);
      this._ForgotPassword.setVisibility(8);
      this._SettingsArea.setVisibility(0);
      this._CreateAccount.setText(2131297220);
      this._CreateAccount.setOnClickListener(this._LogoutListener);
      if (i != 0) {
        UpdateLoginAreaDelayed();
      }
      return;
      i = 8;
      break;
      label323:
      localObject1 = "Token Expires: " + Configuration.CDSTokenExpiration();
      break label136;
      label346:
      if (GCMRegistrar.isRegisteredOnServer(this._CDSRegistrationContext))
      {
        localObject1 = localObject1 + "\nRegistered for InstantSync!";
        break label200;
      }
      localObject1 = localObject1 + "\nRegistered with GCM but not with CDS!";
      i = 1;
      break label200;
      label406:
      localObject1 = localObject1 + "\nInstantSync is not supported on this device!";
      break label200;
      label430:
      this._DeviceId.setVisibility(8);
      i = j;
    }
    label444:
    this._DeviceId.setVisibility(8);
    this._CurrentUser.setVisibility(8);
    this._Login.setVisibility(0);
    this._CreateAccount.setText(2131297219);
    this._CreateAccount.setOnClickListener(this._LoginCreateListener);
    this._SettingsArea.setVisibility(8);
    this._ForgotPassword.setVisibility(0);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 100) {}
    while (paramInt2 == 0) {
      return;
    }
    this._UserName = paramIntent.getStringExtra("UserName");
    this._Password = paramIntent.getStringExtra("Password");
    if (StringUtils.IsNullOrEmpty(this._Password))
    {
      paramIntent = new AlertDialog.Builder(this);
      paramIntent.setTitle(2131297215);
      paramIntent.setMessage(getResources().getString(2131297216, new Object[] { this._UserName }));
      paramIntent.setCancelable(true);
      paramIntent.setNegativeButton(2131296752, null);
      paramIntent.create().show();
    }
    SaveSettings();
  }
  
  protected void onCreate(final Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this._CDSRegistrationContext = this;
    this._UserName = Configuration.CDSUserName();
    this._Password = Configuration.CDSPassword();
    this._Token = Configuration.CDSToken();
    setContentView(2130903098);
    this._LoginArea = findViewById(2131230918);
    this._SettingsArea = findViewById(2131230924);
    this._ForgotPassword = ((TextView)findViewById(2131230923));
    paramBundle = getResources().getString(2131297214);
    Object localObject = new SpannableString(paramBundle);
    ((SpannableString)localObject).setSpan(new UnderlineSpan(), 0, paramBundle.length(), 33);
    this._ForgotPassword.setText((CharSequence)localObject);
    this._ForgotPassword.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CommandManager.CmdStartHtmlViewActivity(Uri.withAppendedPath(Configuration.CDSEndpoint(), "forgotPassword"), paramBundle, false);
      }
    });
    this._OptAllowRemoteDeletions = ((CheckBox)findViewById(2131230925));
    this._OptAllowRemoteDeletions.setChecked(Configuration.CDSAllowRemoteEpisodeDeletions());
    this._OptAllowRemoteDeletions.setOnCheckedChangeListener(this._SyncSettingsChangedListener);
    this._AcceptFeeds = ((Spinner)findViewById(2131230926));
    paramBundle = ArrayAdapter.createFromResource(this, 2131624004, 17367048);
    paramBundle.setDropDownViewResource(17367049);
    this._AcceptFeeds.setAdapter(paramBundle);
    int i = CoreHelper.FindIndexInNumArray(this, 2131624003, Integer.valueOf(Configuration.CDSAllowRemoteFeeds()));
    if (i != -1) {
      this._AcceptFeeds.setSelection(i);
    }
    for (;;)
    {
      this._AcceptFeeds.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
      {
        public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousInt = CoreHelper.FindIndexValueInNumArray(CrossDeviceSyncSetupActivity.this, 2131624003, paramAnonymousInt);
          if (paramAnonymousInt != Integer.MIN_VALUE) {
            Configuration.setCDSAllowRemoteFeeds(paramAnonymousInt);
          }
        }
        
        public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
      });
      this._Login = ((Button)findViewById(2131230921));
      this._Login.setOnClickListener(this._LoginCreateListener);
      this._CreateAccount = ((Button)findViewById(2131230922));
      this._CreateAccount.setOnClickListener(this._LoginCreateListener);
      this._DeviceId = ((TextView)findViewById(2131230920));
      this._CurrentUser = ((TextView)findViewById(2131230919));
      this._Help = ((TextView)findViewById(2131230916));
      paramBundle = getResources().getString(2131297212);
      localObject = getResources().getString(2131297211, new Object[] { paramBundle });
      SpannableString localSpannableString = new SpannableString((CharSequence)localObject);
      i = ((String)localObject).indexOf(paramBundle);
      int j = paramBundle.length();
      localSpannableString.setSpan(new UnderlineSpan(), i, i + j, 33);
      this._Help.setText(localSpannableString);
      this._Help.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          CommandManager.CmdStartHtmlViewActivity(Configuration.HelpFileCDSURL(), CrossDeviceSyncSetupActivity.BEYOND_POD_HELP, false);
        }
      });
      this._SyncEnabled = ((CheckBox)findViewById(2131230917));
      this._SyncEnabled.setChecked(Configuration.CDSEnabled());
      this._SyncEnabled.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          CrossDeviceSyncSetupActivity.this.SaveSettings();
        }
      });
      getActionBarHelper().setDisplayOptions(4, 4);
      setTitle(2131297207);
      if (ChangeTracker.IsTrackingEnabled()) {
        ChangeTracker.InitializeHistory();
      }
      if (!Configuration.CDSEnabled()) {
        new AlertDialog.Builder(this).setTitle(2131297242).setMessage(2131297243).setNegativeButton(2131296759, null).setCancelable(true).show();
      }
      updateLoginArea();
      return;
      this._AcceptFeeds.setSelection(0);
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
    CommandManager.CmdStartHtmlViewActivity(Configuration.HelpFileCDSURL(), BEYOND_POD_HELP, false);
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/dialogs/CrossDeviceSyncSetupActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */