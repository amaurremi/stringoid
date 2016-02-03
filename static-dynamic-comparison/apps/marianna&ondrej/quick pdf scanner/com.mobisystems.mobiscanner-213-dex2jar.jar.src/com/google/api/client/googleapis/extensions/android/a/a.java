package com.google.api.client.googleapis.extensions.android.a;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import com.google.api.client.util.x;

public final class a
{
  private final AccountManager ZA;
  
  public a(AccountManager paramAccountManager)
  {
    this.ZA = ((AccountManager)x.ad(paramAccountManager));
  }
  
  public a(Context paramContext)
  {
    this(AccountManager.get(paramContext));
  }
  
  public Account bx(String paramString)
  {
    if (paramString != null)
    {
      Account[] arrayOfAccount = getAccounts();
      int j = arrayOfAccount.length;
      int i = 0;
      while (i < j)
      {
        Account localAccount = arrayOfAccount[i];
        if (paramString.equals(localAccount.name)) {
          return localAccount;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public Account[] getAccounts()
  {
    return this.ZA.getAccountsByType("com.google");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/googleapis/extensions/android/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */