/*    */
package android.accounts;
/*    */

import android.os.Bundle;

/*    */
/*  4 */ public abstract class AbstractAccountAuthenticator {
    public AbstractAccountAuthenticator(android.content.Context context) {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public final android.os.IBinder getIBinder() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract Bundle editProperties(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, String paramString);

    /*    */
    public abstract Bundle addAccount(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, String paramString1, String paramString2, String[] paramArrayOfString, Bundle paramBundle) throws NetworkErrorException;

    /*    */
    public abstract Bundle confirmCredentials(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, Bundle paramBundle) throws NetworkErrorException;

    /*    */
    public abstract Bundle getAuthToken(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String paramString, Bundle paramBundle) throws NetworkErrorException;

    /*    */
    public abstract String getAuthTokenLabel(String paramString);

    /*    */
    public abstract Bundle updateCredentials(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String paramString, Bundle paramBundle) throws NetworkErrorException;

    /*    */
    public abstract Bundle hasFeatures(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String[] paramArrayOfString) throws NetworkErrorException;

    /* 13 */
    public Bundle getAccountRemovalAllowed(AccountAuthenticatorResponse response, Account account) throws NetworkErrorException {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/accounts/AbstractAccountAuthenticator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */