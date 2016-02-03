package mobi.beyondpod.aggregators;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.aggregators.feedly.Feedly;
import mobi.beyondpod.aggregators.greader.GoogleReader;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.rss.ItemStateHistory;
import mobi.beyondpod.rsscore.rss.RssFeedCache;

public abstract class AggregatorLoginHelper
{
  public static String AuthRequestHeader = RequestBase.AuthRequestHeader;
  public static final int LOGIN_TYPE_ACCOUNT_MANAGER = 1;
  public static final int LOGIN_TYPE_CREDENTIALS = 2;
  public static final int LOGIN_TYPE_OAUTH = 3;
  private static final String TAG = AggregatorLoginHelper.class.getSimpleName();
  
  public static void AddSubscription(Feed paramFeed, GSimpleResult paramGSimpleResult)
    throws Exception
  {
    if (CurrentAccount().getType() == 3)
    {
      Feedly.AddSubscription(paramFeed, paramGSimpleResult);
      return;
    }
    GoogleReader.AddSubscription(paramFeed, paramGSimpleResult);
  }
  
  public static String BlockingGetAuthToken()
  {
    AccountInfo localAccountInfo = CurrentAccount();
    if (localAccountInfo.getType() == 3) {
      return AggregatorLoginHelper.OAuthLogin.Holder.sInstance.BlockingGetAuthTokenInternal(localAccountInfo);
    }
    if (localAccountInfo.getType() == 2) {
      return AggregatorLoginHelper.CredentialsLogin.Holder.sInstance.BlockingGetAuthTokenInternal(localAccountInfo);
    }
    return AggregatorLoginHelper.AccountManagerLogin.Holder.sInstance.BlockingGetAuthTokenInternal(localAccountInfo);
  }
  
  public static void ClearAccountToken()
  {
    AccountInfo localAccountInfo = CurrentAccount();
    if (localAccountInfo.getType() == 3)
    {
      AggregatorLoginHelper.OAuthLogin.Holder.sInstance.ClearAccountTokenInternal(localAccountInfo);
      return;
    }
    if (localAccountInfo.getType() == 2)
    {
      AggregatorLoginHelper.CredentialsLogin.Holder.sInstance.ClearAccountTokenInternal(localAccountInfo);
      return;
    }
    AggregatorLoginHelper.AccountManagerLogin.Holder.sInstance.ClearAccountTokenInternal(localAccountInfo);
  }
  
  public static void ClearLogin()
  {
    CoreHelper.WriteTraceEntry(TAG, "Clearing all aggregator login data");
    Configuration.setGReaderAccountName(null);
    Configuration.setGReaderCookie(null);
    Configuration.setGReaderAuthValue(null);
    Configuration.setOAuthAccessToken(null);
    Configuration.setOAuthAccessTokenExpiration(null);
    Configuration.setOAuthUser(null);
    Configuration.setOAuthRefreshToken(null);
  }
  
  public static AccountInfo CurrentAccount()
  {
    return OAuthLogin.DefaultAccount;
  }
  
  public static OAuthAccountInfo CurrentOAuthAccount()
  {
    return OAuthLogin.DefaultAccount;
  }
  
  public static int DisconnectFromAggregator()
  {
    int i = 0;
    Iterator localIterator = getAllAggregatorFeeds().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        ClearLogin();
        ItemStateHistory.PurgeAllGoogleReaderItems();
        ItemStateHistory.SaveHistorySync();
        FeedRepository.SaveRepositoryAsync();
        return i;
      }
      Feed localFeed = (Feed)localIterator.next();
      if (!IsCategoryAggregatorFeed(localFeed))
      {
        localFeed.setType(0);
        localFeed.setItemFingerprintAlgorithm(-1);
        localFeed.setNumUnreadItems(0);
        localFeed.setLastModifiedDate(null);
        localFeed.setLastServerModifiedDate(null);
        localFeed.setLastItemID(null);
        localFeed.setFeedImageUrl(null);
        RssFeedCache.DeleteFeedCacheFor(localFeed);
        i += 1;
      }
    }
  }
  
  public static void GetAuthToken(AccountInfo paramAccountInfo, GetAuthTokenResult paramGetAuthTokenResult, Activity paramActivity)
  {
    if (paramAccountInfo.getType() == 3)
    {
      AggregatorLoginHelper.OAuthLogin.Holder.sInstance.GetAuthTokenInternal(paramAccountInfo, paramGetAuthTokenResult, paramActivity);
      return;
    }
    if (paramAccountInfo.getType() == 2)
    {
      AggregatorLoginHelper.CredentialsLogin.Holder.sInstance.GetAuthTokenInternal(paramAccountInfo, paramGetAuthTokenResult, paramActivity);
      return;
    }
    AggregatorLoginHelper.AccountManagerLogin.Holder.sInstance.GetAuthTokenInternal(paramAccountInfo, paramGetAuthTokenResult, paramActivity);
  }
  
  public static Uri GetFeedUri(Feed paramFeed)
  {
    if (CurrentAccount().getType() == 3) {
      return Feedly.GetFeedUri(paramFeed);
    }
    return GoogleReader.GetFeedUri(paramFeed);
  }
  
  public static boolean IsCategoryAggregatorFeed(Feed paramFeed)
  {
    return (GoogleReader.IsCategoryAggregatorFeed(paramFeed)) || (Feedly.IsCategoryAggregatorFeed(paramFeed));
  }
  
  public static boolean IsLoggedIn()
  {
    return IsLoggedIn(CurrentAccount());
  }
  
  public static boolean IsLoggedIn(AccountInfo paramAccountInfo)
  {
    if (paramAccountInfo.getType() == 3) {
      return AggregatorLoginHelper.OAuthLogin.Holder.sInstance.IsCurrentlyLoggedIn();
    }
    if (paramAccountInfo.getType() == 2) {
      return AggregatorLoginHelper.CredentialsLogin.Holder.sInstance.IsCurrentlyLoggedIn();
    }
    return AggregatorLoginHelper.AccountManagerLogin.Holder.sInstance.IsCurrentlyLoggedIn();
  }
  
  public static boolean IsSyncing()
  {
    if (CurrentAccount().getType() == 3) {
      return Feedly.IsSyncing();
    }
    return GoogleReader.IsSyncing();
  }
  
  public static void SimulateInvalidToken()
  {
    CoreHelper.WriteTraceEntry(TAG, "Invalidating current oAuth token...");
    Configuration.setOAuthAccessToken("AQAAP2B7InQiOjEsInYiOiJwcm9kdWN0aW9uIiwiaSI6IjJhMWY5NDI2LTQzZWQtNDZiZS04YTE0LThhY2Y1ZThiZmM5MSIsImEiOiJCZXlvbmRQb2QiLCJwIjoxLCJlIjoxMzcxNTkyMjA0NTc4fQ==");
  }
  
  public static void StopSyncing()
  {
    if (CurrentAccount().getType() == 3)
    {
      Feedly.StopSyncing();
      return;
    }
    GoogleReader.StopSyncing();
  }
  
  public static boolean SyncItemStatus(GSyncStatusResult paramGSyncStatusResult)
    throws Exception
  {
    if (CurrentAccount().getType() == 3) {
      return Feedly.SyncItemStatus(paramGSyncStatusResult);
    }
    return GoogleReader.SyncItemStatus(paramGSyncStatusResult);
  }
  
  public static FeedList getAllAggregatorFeeds()
  {
    FeedList localFeedList = new FeedList();
    Iterator localIterator = FeedRepository.getRootFeed().SubFeeds().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localFeedList;
      }
      Feed localFeed = (Feed)localIterator.next();
      if ((localFeed.IsGReaderFeed()) || (IsCategoryAggregatorFeed(localFeed))) {
        localFeedList.add(localFeed);
      }
    }
  }
  
  public static FeedList getAllSpecialAggregatorFeeds()
  {
    FeedList localFeedList = new FeedList();
    Iterator localIterator = FeedRepository.getRootFeed().SubFeeds().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localFeedList;
      }
      Feed localFeed = (Feed)localIterator.next();
      if (IsCategoryAggregatorFeed(localFeed)) {
        localFeedList.add(localFeed);
      }
    }
  }
  
  protected static AggregatorLoginHelper getInstance()
  {
    return AggregatorLoginHelper.OAuthLogin.Holder.sInstance;
  }
  
  protected abstract String BlockingGetAuthTokenInternal(AccountInfo paramAccountInfo);
  
  protected abstract void ClearAccountTokenInternal(AccountInfo paramAccountInfo);
  
  protected abstract void GetAuthTokenInternal(AccountInfo paramAccountInfo, GetAuthTokenResult paramGetAuthTokenResult, Activity paramActivity);
  
  public abstract AccountInfo[] GetAvailableAccounts();
  
  public abstract int LoginType();
  
  public static class AccountInfo
  {
    protected String _AccountName = "Email/Password";
    protected int _AccountType = 2;
    
    public AccountInfo() {}
    
    public AccountInfo(int paramInt, String paramString)
    {
      this._AccountName = paramString;
      this._AccountType = paramInt;
    }
    
    public String AccountName()
    {
      return this._AccountName;
    }
    
    public int getType()
    {
      return this._AccountType;
    }
    
    public String toString()
    {
      if (this._AccountType == 1) {}
      for (String str = "Use   ";; str = "Enter ") {
        return str + this._AccountName;
      }
    }
  }
  
  private static class AccountManagerLogin
    extends AggregatorLoginHelper
  {
    private static final String ACCOUT_TYPE_COM_GOOGLE = "com.google";
    private static final String SERVICE_READER = "reader";
    
    private Account GetAccountFor(AggregatorLoginHelper.AccountInfo paramAccountInfo)
    {
      for (;;)
      {
        Account[] arrayOfAccount;
        int i;
        Object localObject;
        try
        {
          arrayOfAccount = AccountManager.get(BeyondPodApplication.GetInstance()).getAccountsByType("com.google");
          int j = arrayOfAccount.length;
          i = 0;
          if (i >= j)
          {
            localObject = null;
            return (Account)localObject;
          }
        }
        catch (Exception paramAccountInfo)
        {
          CoreHelper.LogException(AggregatorLoginHelper.TAG, "Unable to generate list of AccountManager Accounts", paramAccountInfo);
          return null;
        }
        Account localAccount = arrayOfAccount[i];
        if (!StringUtils.IsNullOrEmpty(localAccount.name))
        {
          localObject = localAccount;
          if (localAccount.name.equals(paramAccountInfo.AccountName())) {}
        }
        else
        {
          i += 1;
        }
      }
    }
    
    public static AggregatorLoginHelper.AccountInfo[] GetAvailableAccountsInternal()
    {
      localObject1 = new Account[0];
      try
      {
        localObject2 = AccountManager.get(BeyondPodApplication.GetInstance()).getAccountsByType("com.google");
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          int i;
          CoreHelper.LogException(AggregatorLoginHelper.TAG, "Unable to generate list of AccountManager Accounts", localException);
          continue;
          localException[i] = new AggregatorLoginHelper.AccountInfo(1, localObject1[i].name);
          i += 1;
        }
      }
      localObject2 = new AggregatorLoginHelper.AccountInfo[localObject1.length + 1];
      i = 0;
      if (i == localObject1.length)
      {
        localObject2[localObject1.length] = AggregatorLoginHelper.CredentialsLogin.DefaultAccount;
        return (AggregatorLoginHelper.AccountInfo[])localObject2;
      }
    }
    
    private String MakeRequestHeader(String paramString)
    {
      if (StringUtils.IsNullOrEmpty(paramString)) {
        return null;
      }
      return "GoogleLogin auth=" + paramString;
    }
    
    protected String BlockingGetAuthTokenInternal(AggregatorLoginHelper.AccountInfo paramAccountInfo)
    {
      try
      {
        Account localAccount = GetAccountFor(paramAccountInfo);
        if (localAccount == null)
        {
          CoreHelper.WriteLogEntryInProduction(AggregatorLoginHelper.TAG, "Unable to find Account Manager Account for: " + paramAccountInfo.AccountName());
          return null;
        }
        CoreHelper.WriteTraceEntry(AggregatorLoginHelper.TAG, "Requesting Reader Authentication from AccountManager");
        paramAccountInfo = MakeRequestHeader(AccountManager.get(BeyondPodApplication.GetInstance()).blockingGetAuthToken(localAccount, "reader", true));
        return paramAccountInfo;
      }
      catch (OperationCanceledException paramAccountInfo)
      {
        return null;
      }
      catch (AuthenticatorException paramAccountInfo)
      {
        return null;
      }
      catch (IOException paramAccountInfo) {}
      return null;
    }
    
    public void ClearAccountTokenInternal(AggregatorLoginHelper.AccountInfo paramAccountInfo)
    {
      try
      {
        paramAccountInfo = GetAccountFor(paramAccountInfo);
        if (paramAccountInfo == null) {
          return;
        }
        paramAccountInfo = AccountManager.get(BeyondPodApplication.GetInstance()).blockingGetAuthToken(paramAccountInfo, "reader", false);
        if (!StringUtils.IsNullOrEmpty(paramAccountInfo))
        {
          CoreHelper.WriteTraceEntry(AggregatorLoginHelper.TAG, "Clearing Reader authentication token from AccountManager");
          AccountManager.get(BeyondPodApplication.GetInstance()).invalidateAuthToken("com.google", paramAccountInfo);
          return;
        }
      }
      catch (Exception paramAccountInfo)
      {
        CoreHelper.LogException(AggregatorLoginHelper.TAG, "Unable to clear Account Manager Token", paramAccountInfo);
      }
    }
    
    protected void GetAuthTokenInternal(AggregatorLoginHelper.AccountInfo paramAccountInfo, final AggregatorLoginHelper.GetAuthTokenResult paramGetAuthTokenResult, Activity paramActivity)
    {
      Account localAccount = GetAccountFor(paramAccountInfo);
      if (localAccount == null)
      {
        paramAccountInfo = new Exception("Unable to find Account Manager Account for: " + paramAccountInfo.AccountName());
        CoreHelper.LogException(AggregatorLoginHelper.TAG, "Authentication Failure", paramAccountInfo);
        if (paramGetAuthTokenResult != null) {
          paramGetAuthTokenResult.Failed(paramAccountInfo);
        }
      }
      AccountManager.get(BeyondPodApplication.GetInstance()).getAuthToken(localAccount, "reader", null, paramActivity, new AccountManagerCallback()
      {
        public void run(AccountManagerFuture<Bundle> paramAnonymousAccountManagerFuture)
        {
          try
          {
            paramAnonymousAccountManagerFuture = (Bundle)paramAnonymousAccountManagerFuture.getResult();
            if (paramGetAuthTokenResult != null) {
              paramGetAuthTokenResult.Success(AggregatorLoginHelper.AccountManagerLogin.this.MakeRequestHeader(paramAnonymousAccountManagerFuture.getString("authtoken")));
            }
            return;
          }
          catch (Exception paramAnonymousAccountManagerFuture)
          {
            while (paramGetAuthTokenResult == null) {}
            paramGetAuthTokenResult.Failed(paramAnonymousAccountManagerFuture);
          }
        }
      }, null);
    }
    
    public AggregatorLoginHelper.AccountInfo[] GetAvailableAccounts()
    {
      return GetAvailableAccountsInternal();
    }
    
    boolean IsCurrentlyLoggedIn()
    {
      return true;
    }
    
    public int LoginType()
    {
      return 1;
    }
    
    private static class Holder
    {
      private static final AggregatorLoginHelper.AccountManagerLogin sInstance = new AggregatorLoginHelper.AccountManagerLogin(null);
    }
  }
  
  public static class AuthenticationException
    extends Exception
  {
    private static final String ERROR_HEADER = "Error";
    private static final String INVALID_OR_EXPIRED_GOOGLE_READER_LOGIN = "Invalid or expired Feedly login! (You can modify your Feedly login in: Add Feed > Import Feeds > Import from Feedly)";
    private static final long serialVersionUID = -6829746333153305412L;
    HashMap<String, String> _Contents = new HashMap();
    
    public AuthenticationException()
    {
      super();
    }
    
    public AuthenticationException(String paramString)
    {
      this();
      int j;
      int i;
      if (!StringUtils.IsNullOrEmpty(paramString))
      {
        paramString = paramString.split("\r\n|\r|\n");
        if (paramString != null)
        {
          j = paramString.length;
          i = 0;
        }
      }
      for (;;)
      {
        if (i >= j) {
          return;
        }
        String[] arrayOfString = paramString[i].split("=");
        if (arrayOfString.length == 2) {
          this._Contents.put(arrayOfString[0], arrayOfString[1]);
        }
        i += 1;
      }
    }
    
    public String getMessage()
    {
      String str = (String)this._Contents.get("Error");
      if (str != null)
      {
        if ("BadAuthentication".equals(str)) {
          return "Invalid username or password.";
        }
        if ("NotVerified".equals(str)) {
          return "The account email address has not been verified. You will need to access your Google account directly to resolve the issue before logging in using BeyondPod.";
        }
        if ("TermsNotAgreed".equals(str)) {
          return "Account has not agreed to terms. You will need to access your Google account directly to resolve the issue before logging in using BeyondPod";
        }
        if ("CaptchaRequired".equals(str)) {
          return "A CAPTCHA is required! Try to loging in to Google Reader using the device browser";
        }
        if ("Unknown".equals(str)) {
          return "Unknown error! The request contained invalid input or was malformed.";
        }
        if ("AccountDeleted".equals(str)) {
          return "Your user account has been deleted.";
        }
        if ("ServiceDisabled".equals(str)) {
          return "The user's access to the Google Reader Service has been disabled. (The user account may still be valid.)";
        }
        if ("ServiceUnavailable".equals(str)) {
          return "The service is not available; try again later.";
        }
      }
      return super.getMessage();
    }
  }
  
  private static class CredentialsLogin
    extends AggregatorLoginHelper
  {
    public static AggregatorLoginHelper.AccountInfo DefaultAccount = new AggregatorLoginHelper.AccountInfo();
    
    protected String BlockingGetAuthTokenInternal(AggregatorLoginHelper.AccountInfo paramAccountInfo)
    {
      CoreHelper.WriteTraceEntry(AggregatorLoginHelper.TAG, "Requesting Reader Authentication from cache");
      return Configuration.GReaderAuthValue();
    }
    
    public void ClearAccountTokenInternal(AggregatorLoginHelper.AccountInfo paramAccountInfo) {}
    
    protected void GetAuthTokenInternal(AggregatorLoginHelper.AccountInfo paramAccountInfo, AggregatorLoginHelper.GetAuthTokenResult paramGetAuthTokenResult, Activity paramActivity)
    {
      if (paramGetAuthTokenResult != null) {
        paramGetAuthTokenResult.Success(BlockingGetAuthTokenInternal(paramAccountInfo));
      }
    }
    
    public AggregatorLoginHelper.AccountInfo[] GetAvailableAccounts()
    {
      return new AggregatorLoginHelper.AccountInfo[] { DefaultAccount };
    }
    
    boolean IsCurrentlyLoggedIn()
    {
      return !StringUtils.IsNullOrEmpty(Configuration.GReaderAuthValue());
    }
    
    public int LoginType()
    {
      return 2;
    }
    
    private static class Holder
    {
      private static final AggregatorLoginHelper.CredentialsLogin sInstance = new AggregatorLoginHelper.CredentialsLogin(null);
    }
  }
  
  public static class FeedlyOAuthAccountInfo
    extends AggregatorLoginHelper.OAuthAccountInfo
  {
    public FeedlyOAuthAccountInfo()
    {
      super();
    }
    
    public FeedlyOAuthAccountInfo(String paramString)
    {
      super();
    }
    
    public AggregatorLoginHelper.OAuthAccountInfo.RedirectResult CheckRedirectUrl(String paramString)
    {
      if ((StringUtils.IsNullOrEmpty(paramString)) || (!paramString.startsWith("http://localhost"))) {
        return new AggregatorLoginHelper.OAuthAccountInfo.RedirectResult(0);
      }
      Object localObject = Uri.parse(paramString);
      paramString = ((Uri)localObject).getQueryParameter("code");
      if (!StringUtils.IsNullOrEmpty(paramString))
      {
        localObject = new AggregatorLoginHelper.OAuthAccountInfo.RedirectResult(1);
        ((AggregatorLoginHelper.OAuthAccountInfo.RedirectResult)localObject).AuthCode = paramString;
        return (AggregatorLoginHelper.OAuthAccountInfo.RedirectResult)localObject;
      }
      paramString = ((Uri)localObject).getQueryParameter("error");
      if (!StringUtils.IsNullOrEmpty(paramString))
      {
        localObject = new AggregatorLoginHelper.OAuthAccountInfo.RedirectResult(-1);
        ((AggregatorLoginHelper.OAuthAccountInfo.RedirectResult)localObject).Error = paramString;
        return (AggregatorLoginHelper.OAuthAccountInfo.RedirectResult)localObject;
      }
      return new AggregatorLoginHelper.OAuthAccountInfo.RedirectResult(-2);
    }
    
    public String OAuthEndPoint()
    {
      return Feedly.OAuthEndPoint;
    }
    
    public String OAuthScope()
    {
      return Feedly.OAuthScope;
    }
    
    public String OAuthTokenEndPoint()
    {
      return null;
    }
  }
  
  public static abstract interface GSimpleResult
  {
    public abstract void Failed(Exception paramException);
    
    public abstract void Success();
  }
  
  public static abstract interface GSyncStatusResult
  {
    public abstract void SyncCompleted(boolean paramBoolean, int paramInt1, int paramInt2);
  }
  
  public static abstract interface GetAuthTokenResult
  {
    public abstract void Failed(Exception paramException);
    
    public abstract void Success(String paramString);
  }
  
  public static abstract class OAuthAccountInfo
    extends AggregatorLoginHelper.AccountInfo
  {
    public OAuthAccountInfo()
    {
      this("N/A");
    }
    
    public OAuthAccountInfo(String paramString)
    {
      super(paramString);
    }
    
    public abstract RedirectResult CheckRedirectUrl(String paramString);
    
    public abstract String OAuthEndPoint();
    
    public abstract String OAuthScope();
    
    public abstract String OAuthTokenEndPoint();
    
    public String toString()
    {
      return this._AccountName;
    }
    
    public static class RedirectResult
    {
      public static final int RESULT_TYPE_ACCESS_DENIED = -1;
      public static final int RESULT_TYPE_ACCESS_GRANTED = 1;
      public static final int RESULT_TYPE_ACCESS_UNKNOWN = -2;
      public static final int RESULT_TYPE_INVALID_REDIRECT = 0;
      public String AuthCode;
      public String Error;
      public int Result = 0;
      
      public RedirectResult(int paramInt)
      {
        this.Result = paramInt;
      }
    }
  }
  
  private static class OAuthLogin
    extends AggregatorLoginHelper
  {
    public static AggregatorLoginHelper.OAuthAccountInfo DefaultAccount = new AggregatorLoginHelper.FeedlyOAuthAccountInfo();
    
    protected String BlockingGetAuthTokenInternal(AggregatorLoginHelper.AccountInfo paramAccountInfo)
    {
      CoreHelper.WriteTraceEntry(AggregatorLoginHelper.TAG, "Requesting OAuth Authentication...");
      return Feedly.BlockingGetAuthToken();
    }
    
    protected void ClearAccountTokenInternal(AggregatorLoginHelper.AccountInfo paramAccountInfo)
    {
      CoreHelper.WriteTraceEntry(AggregatorLoginHelper.TAG, "Clearing OAuth token...");
      Configuration.setOAuthAccessToken(null);
      Configuration.setOAuthAccessTokenExpiration(null);
    }
    
    protected void GetAuthTokenInternal(AggregatorLoginHelper.AccountInfo paramAccountInfo, final AggregatorLoginHelper.GetAuthTokenResult paramGetAuthTokenResult, Activity paramActivity)
    {
      try
      {
        Feedly.LogIn(paramAccountInfo._AccountName, new AggregatorLoginHelper.GSimpleResult()
        {
          public void Failed(Exception paramAnonymousException)
          {
            if (paramGetAuthTokenResult != null) {
              paramGetAuthTokenResult.Failed(paramAnonymousException);
            }
          }
          
          public void Success()
          {
            if (paramGetAuthTokenResult != null) {
              paramGetAuthTokenResult.Success(Configuration.OAuthAccessToken());
            }
          }
        });
        return;
      }
      catch (Exception paramAccountInfo)
      {
        while (paramGetAuthTokenResult == null) {}
        paramGetAuthTokenResult.Failed(paramAccountInfo);
      }
    }
    
    public AggregatorLoginHelper.AccountInfo[] GetAvailableAccounts()
    {
      return new AggregatorLoginHelper.AccountInfo[] { DefaultAccount };
    }
    
    boolean IsCurrentlyLoggedIn()
    {
      return !StringUtils.IsNullOrEmpty(Configuration.OAuthAccessToken());
    }
    
    public int LoginType()
    {
      return 3;
    }
    
    private static class Holder
    {
      private static final AggregatorLoginHelper.OAuthLogin sInstance = new AggregatorLoginHelper.OAuthLogin(null);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/aggregators/AggregatorLoginHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */