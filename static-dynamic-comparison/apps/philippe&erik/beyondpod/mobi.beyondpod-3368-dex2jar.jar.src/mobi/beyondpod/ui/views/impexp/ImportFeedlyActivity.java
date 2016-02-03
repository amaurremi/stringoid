package mobi.beyondpod.ui.views.impexp;

import android.accounts.OperationCanceledException;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import mobi.beyondpod.aggregators.AggregatorLoginHelper;
import mobi.beyondpod.aggregators.AggregatorLoginHelper.AuthenticationException;
import mobi.beyondpod.aggregators.AggregatorLoginHelper.FeedlyOAuthAccountInfo;
import mobi.beyondpod.aggregators.AggregatorLoginHelper.GetAuthTokenResult;
import mobi.beyondpod.aggregators.GDataObject;
import mobi.beyondpod.aggregators.feedly.Feedly;
import mobi.beyondpod.aggregators.feedly.Feedly.FGetFeedsResult;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.CoreHelper.DeviceNetworkConnection;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.core.ActionBarActivityBase;
import mobi.beyondpod.ui.core.ActionBarHelper;
import mobi.beyondpod.ui.views.OAuthLoginActivity;

public class ImportFeedlyActivity
  extends ActionBarActivityBase
{
  private static final String FAILED_TO_LOAD_READER_SUBSCRIPTIONS = CoreHelper.LoadResourceString(2131297119);
  private static final String LOADING_FEED_SUBSCRIPTIONS = CoreHelper.LoadResourceString(2131297120);
  private static final String LOGIN_FAILED = CoreHelper.LoadResourceString(2131297121);
  private static final String OPERATION_CANCELED = CoreHelper.LoadResourceString(2131297127);
  private static final String RETRIEVING_ACCOUNT_DETAILS = CoreHelper.LoadResourceString(2131297128);
  private static final String SUCCESS = CoreHelper.LoadResourceString(2131297124);
  private static final String TAG = ImportFeedlyActivity.class.getSimpleName();
  boolean _ForLoginOnly = false;
  ProgressDialog _ProgressDialog;
  String _ProgressMessage;
  
  private void DismissProgressDialog()
  {
    if (this._ProgressDialog != null) {
      this._ProgressDialog.dismiss();
    }
  }
  
  private void GetFeedList()
  {
    ShowProgressDialog(LOADING_FEED_SUBSCRIPTIONS);
    Feedly.GetFeedList(new Feedly.FGetFeedsResult()
    {
      public void Failed(Exception paramAnonymousException)
      {
        CoreHelper.LogException(ImportFeedlyActivity.TAG, ImportFeedlyActivity.FAILED_TO_LOAD_READER_SUBSCRIPTIONS, paramAnonymousException);
        if ((paramAnonymousException instanceof AggregatorLoginHelper.AuthenticationException))
        {
          AggregatorLoginHelper.ClearAccountToken();
          ImportFeedlyActivity.this.ShowNotification(ImportFeedlyActivity.this.getString(2131296390));
          ImportFeedlyActivity.this.finish();
          return;
        }
        ImportFeedlyActivity.this.ShowNotification(ImportFeedlyActivity.FAILED_TO_LOAD_READER_SUBSCRIPTIONS + "\n\n" + CoreHelper.ExtractExceptionMessages(paramAnonymousException));
        ImportFeedlyActivity.this.finish();
      }
      
      public void Success(GDataObject paramAnonymousGDataObject)
      {
        CommandManager.CmdOpenOpmlImporter(Feedly.BuildFeedList(paramAnonymousGDataObject));
        ImportFeedlyActivity.this.DismissProgressDialog();
        ImportFeedlyActivity.this.finish();
      }
    });
  }
  
  private void ShowNotification(final CharSequence paramCharSequence)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        ImportFeedlyActivity.this.DismissProgressDialog();
        ImportFeedlyActivity localImportFeedlyActivity = ImportFeedlyActivity.this;
        CharSequence localCharSequence = paramCharSequence;
        if (paramCharSequence.length() < 20) {}
        for (int i = 0;; i = 1)
        {
          Toast.makeText(localImportFeedlyActivity, localCharSequence, i).show();
          return;
        }
      }
    });
  }
  
  private void ShowProgressDialog(String paramString)
  {
    DismissProgressDialog();
    this._ProgressMessage = paramString;
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        ImportFeedlyActivity.this.showDialog(0);
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 33445566)
    {
      if (paramInt2 == -1) {
        onOAuthAccessGranted(paramIntent.getAction());
      }
    }
    else {
      return;
    }
    onOAuthAccessDenied();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = true;
    super.onCreate(paramBundle);
    if (!FeedRepository.IsRepositoryAvailable())
    {
      CoreHelper.WriteTraceEntry(TAG, "Closing view because the repository is not Loaded");
      finish();
      return;
    }
    if (!CoreHelper.GetDeviceNetworkConnection().IsConnectedToNetwork())
    {
      ShowNotification(getResources().getString(2131297255));
      finish();
      return;
    }
    if (getIntent() != null) {
      if (getIntent().getIntExtra("LoginOnly", 0) == 0) {
        break label101;
      }
    }
    for (;;)
    {
      this._ForLoginOnly = bool;
      try
      {
        if (AggregatorLoginHelper.IsLoggedIn(AggregatorLoginHelper.CurrentAccount())) {
          GetFeedList();
        }
        for (;;)
        {
          getActionBarHelper().setDisplayOptions(4, 4);
          return;
          label101:
          bool = false;
          break;
          if (paramBundle == null) {
            try
            {
              startActivityForResult(new Intent(this, OAuthLoginActivity.class), 33445566);
            }
            catch (Exception paramBundle)
            {
              Toast.makeText(this, paramBundle.getMessage(), 1).show();
            }
          }
        }
      }
      catch (Exception paramBundle)
      {
        for (;;) {}
      }
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    this._ProgressDialog = new ProgressDialog(this);
    this._ProgressDialog.setMessage(this._ProgressMessage);
    this._ProgressDialog.setIndeterminate(true);
    this._ProgressDialog.setCancelable(true);
    return this._ProgressDialog;
  }
  
  public void onOAuthAccessDenied()
  {
    ShowNotification(OPERATION_CANCELED);
    finish();
  }
  
  public void onOAuthAccessGranted(String paramString)
  {
    if (StringUtils.IsNullOrEmpty(paramString))
    {
      ShowNotification(OPERATION_CANCELED);
      finish();
      return;
    }
    ShowProgressDialog(RETRIEVING_ACCOUNT_DETAILS);
    AggregatorLoginHelper.GetAuthToken(new AggregatorLoginHelper.FeedlyOAuthAccountInfo(paramString), new AggregatorLoginHelper.GetAuthTokenResult()
    {
      public void Failed(Exception paramAnonymousException)
      {
        if ((paramAnonymousException instanceof OperationCanceledException))
        {
          ImportFeedlyActivity.this.ShowNotification(ImportFeedlyActivity.OPERATION_CANCELED);
          return;
        }
        ImportFeedlyActivity.this.ShowNotification(ImportFeedlyActivity.LOGIN_FAILED + "\n\n" + CoreHelper.ExtractExceptionMessages(paramAnonymousException));
        ImportFeedlyActivity.this.finish();
      }
      
      public void Success(String paramAnonymousString)
      {
        if (!StringUtils.IsNullOrEmpty(paramAnonymousString))
        {
          if (ImportFeedlyActivity.this._ForLoginOnly)
          {
            ImportFeedlyActivity.this.ShowNotification(ImportFeedlyActivity.SUCCESS);
            ImportFeedlyActivity.this.finish();
          }
        }
        else {
          return;
        }
        ImportFeedlyActivity.this.GetFeedList();
      }
    }, this);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    }
    finish();
    return true;
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    this._ProgressDialog.setMessage(this._ProgressMessage);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/impexp/ImportFeedlyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */