/*    */
package android.accounts;
/*    */

import android.os.Bundle;

/*    */
/*  4 */ public class AccountManager {
    AccountManager() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public static AccountManager get(android.content.Context context) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public String getPassword(Account account) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public String getUserData(Account account, String key) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public AuthenticatorDescription[] getAuthenticatorTypes() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public Account[] getAccounts() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public Account[] getAccountsByType(String type) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public AccountManagerFuture<Boolean> hasFeatures(Account account, String[] features, AccountManagerCallback<Boolean> callback, android.os.Handler handler) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public AccountManagerFuture<Account[]> getAccountsByTypeAndFeatures(String type, String[] features, AccountManagerCallback<Account[]> callback, android.os.Handler handler) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public boolean addAccountExplicitly(Account account, String password, Bundle userdata) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public AccountManagerFuture<Boolean> removeAccount(Account account, AccountManagerCallback<Boolean> callback, android.os.Handler handler) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void invalidateAuthToken(String accountType, String authToken) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public String peekAuthToken(Account account, String authTokenType) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void setPassword(Account account, String password) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void clearPassword(Account account) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void setUserData(Account account, String key, String value) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void setAuthToken(Account account, String authTokenType, String authToken) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public String blockingGetAuthToken(Account account, String authTokenType, boolean notifyAuthFailure) throws OperationCanceledException, java.io.IOException, AuthenticatorException {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public AccountManagerFuture<Bundle> getAuthToken(Account account, String authTokenType, Bundle options, android.app.Activity activity, AccountManagerCallback<Bundle> callback, android.os.Handler handler) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 24 */ public AccountManagerFuture<Bundle> getAuthToken(Account account, String authTokenType, boolean notifyAuthFailure, AccountManagerCallback<Bundle> callback, android.os.Handler handler) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public AccountManagerFuture<Bundle> getAuthToken(Account account, String authTokenType, Bundle options, boolean notifyAuthFailure, AccountManagerCallback<Bundle> callback, android.os.Handler handler) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public AccountManagerFuture<Bundle> addAccount(String accountType, String authTokenType, String[] requiredFeatures, Bundle addAccountOptions, android.app.Activity activity, AccountManagerCallback<Bundle> callback, android.os.Handler handler) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public AccountManagerFuture<Bundle> confirmCredentials(Account account, Bundle options, android.app.Activity activity, AccountManagerCallback<Bundle> callback, android.os.Handler handler) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public AccountManagerFuture<Bundle> updateCredentials(Account account, String authTokenType, Bundle options, android.app.Activity activity, AccountManagerCallback<Bundle> callback, android.os.Handler handler) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public AccountManagerFuture<Bundle> editProperties(String accountType, android.app.Activity activity, AccountManagerCallback<Bundle> callback, android.os.Handler handler) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public AccountManagerFuture<Bundle> getAuthTokenByFeatures(String accountType, String authTokenType, String[] features, android.app.Activity activity, Bundle addAccountOptions, Bundle getAuthTokenOptions, AccountManagerCallback<Bundle> callback, android.os.Handler handler) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public static android.content.Intent newChooseAccountIntent(Account selectedAccount, java.util.ArrayList<Account> allowableAccounts, String[] allowableAccountTypes, boolean alwaysPromptForAccount, String descriptionOverrideText, String addAccountAuthTokenType, String[] addAccountRequiredFeatures, Bundle addAccountOptions) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public void addOnAccountsUpdatedListener(OnAccountsUpdateListener listener, android.os.Handler handler, boolean updateImmediately) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public void removeOnAccountsUpdatedListener(OnAccountsUpdateListener listener) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int ERROR_CODE_REMOTE_EXCEPTION = 1;
    /*    */   public static final int ERROR_CODE_NETWORK_ERROR = 3;
    /*    */   public static final int ERROR_CODE_CANCELED = 4;
    /*    */   public static final int ERROR_CODE_INVALID_RESPONSE = 5;
    /*    */   public static final int ERROR_CODE_UNSUPPORTED_OPERATION = 6;
    /*    */   public static final int ERROR_CODE_BAD_ARGUMENTS = 7;
    /*    */   public static final int ERROR_CODE_BAD_REQUEST = 8;
    /*    */   public static final String KEY_ACCOUNT_NAME = "authAccount";
    /*    */   public static final String KEY_ACCOUNT_TYPE = "accountType";
    /*    */   public static final String KEY_AUTHTOKEN = "authtoken";
    /*    */   public static final String KEY_INTENT = "intent";
    /*    */   public static final String KEY_PASSWORD = "password";
    /*    */   public static final String KEY_ACCOUNTS = "accounts";
    /*    */   public static final String KEY_ACCOUNT_AUTHENTICATOR_RESPONSE = "accountAuthenticatorResponse";
    /*    */   public static final String KEY_ACCOUNT_MANAGER_RESPONSE = "accountManagerResponse";
    /*    */   public static final String KEY_AUTHENTICATOR_TYPES = "authenticator_types";
    /*    */   public static final String KEY_AUTH_FAILED_MESSAGE = "authFailedMessage";
    /*    */   public static final String KEY_AUTH_TOKEN_LABEL = "authTokenLabelKey";
    /*    */   public static final String KEY_BOOLEAN_RESULT = "booleanResult";
    /*    */   public static final String KEY_ERROR_CODE = "errorCode";
    /*    */   public static final String KEY_ERROR_MESSAGE = "errorMessage";
    /*    */   public static final String KEY_USERDATA = "userdata";
    /*    */   public static final String KEY_CALLER_UID = "callerUid";
    /*    */   public static final String KEY_CALLER_PID = "callerPid";
    /*    */   public static final String KEY_ANDROID_PACKAGE_NAME = "androidPackageName";
    /*    */   public static final String ACTION_AUTHENTICATOR_INTENT = "android.accounts.AccountAuthenticator";
    /*    */   public static final String AUTHENTICATOR_META_DATA_NAME = "android.accounts.AccountAuthenticator";
    /*    */   public static final String AUTHENTICATOR_ATTRIBUTES_NAME = "account-authenticator";
    /*    */   public static final String LOGIN_ACCOUNTS_CHANGED_ACTION = "android.accounts.LOGIN_ACCOUNTS_CHANGED";
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/accounts/AccountManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */