package com.getjar.sdk.comm.auth;

import android.content.Context;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.StringUtility;
import java.util.Iterator;
import java.util.List;

public class AccountHistoryManager
{
  private static volatile AccountHistoryManager _Instance = null;
  private final Context _context;
  
  private AccountHistoryManager(Context paramContext)
  {
    this._context = paramContext;
  }
  
  public static AccountHistoryManager getInstance()
  {
    if (_Instance == null) {
      throw new IllegalStateException("AccountHistoryManager.initialize() must be called first");
    }
    return _Instance;
  }
  
  public static void initialize(Context paramContext)
  {
    try
    {
      if (_Instance == null) {
        _Instance = new AccountHistoryManager(paramContext);
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public void addEvent(String paramString, AccountEventType paramAccountEventType)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'userAccessId' cannot be NULL or empty");
    }
    if (paramAccountEventType == null) {
      throw new IllegalArgumentException("'eventType' cannot be NULL");
    }
    AccountHistoryDatabase.getInstance(this._context).insertEvent(paramString, paramAccountEventType, System.currentTimeMillis());
  }
  
  public void ensureAccountEntry(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("'userAccessId' cannot be NULL or empty");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("'userDeviceId' cannot be NULL or empty");
    }
    if (StringUtility.isNullOrEmpty(paramString3)) {
      throw new IllegalArgumentException("'accountName' cannot be NULL or empty");
    }
    if (StringUtility.isNullOrEmpty(paramString4)) {
      throw new IllegalArgumentException("'providerFilter' cannot be NULL or empty");
    }
    AccountHistoryDatabase.getInstance(this._context).ensureAccountEntry(paramString1, paramString2, paramString3, paramString4, System.currentTimeMillis());
  }
  
  public List<AccountHistoryInfo> getAccounts()
  {
    return AccountHistoryDatabase.getInstance(this._context).getAccounts();
  }
  
  public String getCurrentAccountName()
  {
    return AccountHistoryDatabase.getInstance(this._context).getCurrentAccountName();
  }
  
  public String getPreviousAccountName()
  {
    String str = null;
    Iterator localIterator = AccountHistoryDatabase.getInstance(this._context).getEvents().iterator();
    while (localIterator.hasNext())
    {
      AccountHistoryEvent localAccountHistoryEvent = (AccountHistoryEvent)localIterator.next();
      if (str == null)
      {
        str = localAccountHistoryEvent.getUserAccessId();
      }
      else if ((!str.equals(localAccountHistoryEvent.getUserAccessId())) && ((localAccountHistoryEvent.getEventType().isAuthEvent()) || (AccountEventType.USER_SWITCHED.equals(localAccountHistoryEvent.getEventType()))))
      {
        AccountHistoryInfo localAccountHistoryInfo = AccountHistoryDatabase.getInstance(this._context).getAccount(localAccountHistoryEvent.getUserAccessId());
        if (localAccountHistoryInfo == null) {
          Logger.e(Area.STORAGE.value() | Area.AUTH.value(), "getPreviousAccountName() Failed to load an account info record for user access ID '%1$s'", new Object[] { localAccountHistoryEvent.getUserAccessId() });
        } else {
          return localAccountHistoryInfo.getAccountName();
        }
      }
    }
    return null;
  }
  
  public boolean isUserSwitchedUINeeded(String paramString)
  {
    boolean bool2 = false;
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'userAccessId' can not be NULL or empty");
    }
    paramString = AccountHistoryDatabase.getInstance(this._context).getEvents(paramString).iterator();
    AccountHistoryEvent localAccountHistoryEvent;
    do
    {
      boolean bool1 = bool2;
      if (paramString.hasNext())
      {
        localAccountHistoryEvent = (AccountHistoryEvent)paramString.next();
        if (AccountEventType.USER_SWITCHED.equals(localAccountHistoryEvent.getEventType())) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
    } while (!AccountEventType.USER_SWITCHED_UI_COMPLETED.equals(localAccountHistoryEvent.getEventType()));
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/auth/AccountHistoryManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */