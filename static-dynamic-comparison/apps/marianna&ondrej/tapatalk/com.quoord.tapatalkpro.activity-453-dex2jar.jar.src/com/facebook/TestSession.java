package com.facebook;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObjectList;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class TestSession
        extends Session {
    private static final String LOG_TAG = "FacebookSDK.TestSession";
    private static Map<String, TestAccount> appTestAccounts;
    private static final long serialVersionUID = 1L;
    private static String testApplicationId;
    private static String testApplicationSecret;
    private final Mode mode;
    private final List<String> requestedPermissions;
    private final String sessionUniqueUserTag;
    private String testAccountId;
    private boolean wasAskedToExtendAccessToken;

    static {
        if (!TestSession.class.desiredAssertionStatus()) {
        }
        for (boolean bool = true; ; bool = false) {
            $assertionsDisabled = bool;
            return;
        }
    }

    TestSession(Activity paramActivity, List<String> paramList, TokenCachingStrategy paramTokenCachingStrategy, String paramString, Mode paramMode) {
        super(paramActivity, testApplicationId, paramTokenCachingStrategy);
        Validate.notNull(paramList, "permissions");
        Validate.notNullOrEmpty(testApplicationId, "testApplicationId");
        Validate.notNullOrEmpty(testApplicationSecret, "testApplicationSecret");
        this.sessionUniqueUserTag = paramString;
        this.mode = paramMode;
        this.requestedPermissions = paramList;
    }

    public static TestSession createSessionWithPrivateUser(Activity paramActivity, List<String> paramList) {
        return createTestSession(paramActivity, paramList, Mode.PRIVATE, null);
    }

    public static TestSession createSessionWithSharedUser(Activity paramActivity, List<String> paramList) {
        return createSessionWithSharedUser(paramActivity, paramList, null);
    }

    public static TestSession createSessionWithSharedUser(Activity paramActivity, List<String> paramList, String paramString) {
        return createTestSession(paramActivity, paramList, Mode.SHARED, paramString);
    }

    private TestAccount createTestAccountAndFinishAuth() {
        Bundle localBundle = new Bundle();
        localBundle.putString("installed", "true");
        localBundle.putString("permissions", getPermissionsString());
        localBundle.putString("access_token", getAppAccessToken());
        if (this.mode == Mode.SHARED) {
            localBundle.putString("name", String.format("Shared %s Testuser", new Object[]{getSharedTestAccountIdentifier()}));
        }
        Object localObject = new Request(null, String.format("%s/accounts/test-users", new Object[]{testApplicationId}), localBundle, HttpMethod.POST).executeAndWait();
        FacebookRequestError localFacebookRequestError = ((Response) localObject).getError();
        localObject = (TestAccount) ((Response) localObject).getGraphObjectAs(TestAccount.class);
        if (localFacebookRequestError != null) {
            finishAuthOrReauth(null, localFacebookRequestError.getException());
            return null;
        }
        assert (localObject != null);
        if (this.mode == Mode.SHARED) {
            ((TestAccount) localObject).setName(localBundle.getString("name"));
            storeTestAccount((TestAccount) localObject);
        }
        finishAuthWithTestAccount((TestAccount) localObject);
        return (TestAccount) localObject;
    }

    private static TestSession createTestSession(Activity paramActivity, List<String> paramList, Mode paramMode, String paramString) {
        Object localObject;
        try {
            if ((Utility.isNullOrEmpty(testApplicationId)) || (Utility.isNullOrEmpty(testApplicationSecret))) {
                throw new FacebookException("Must provide app ID and secret");
            }
        } finally {
            throw paramActivity;
            localObject = paramList;
            if (Utility.isNullOrEmpty(paramList)) {
                localObject = Arrays.asList(new String[]{"email", "publish_actions"});
            }
        }
        return paramActivity;
    }

    private void deleteTestAccount(String paramString1, String paramString2) {
        Object localObject = new Bundle();
        ((Bundle) localObject).putString("access_token", paramString2);
        localObject = new Request(null, paramString1, (Bundle) localObject, HttpMethod.DELETE).executeAndWait();
        paramString2 = ((Response) localObject).getError();
        localObject = ((Response) localObject).getGraphObject();
        if (paramString2 != null) {
            Log.w("FacebookSDK.TestSession", String.format("Could not delete test account %s: %s", new Object[]{paramString1, paramString2.getException().toString()}));
        }
        while (((GraphObject) localObject).getProperty("FACEBOOK_NON_JSON_RESULT") != Boolean.valueOf(false)) {
            return;
        }
        Log.w("FacebookSDK.TestSession", String.format("Could not delete test account %s: unknown reason", new Object[]{paramString1}));
    }

    private void findOrCreateSharedTestAccount() {
        TestAccount localTestAccount = findTestAccountMatchingIdentifier(getSharedTestAccountIdentifier());
        if (localTestAccount != null) {
            finishAuthWithTestAccount(localTestAccount);
            return;
        }
        createTestAccountAndFinishAuth();
    }

    /* Error */
    private static TestAccount findTestAccountMatchingIdentifier(String paramString) {
        // Byte code:
        //   0: ldc 2
        //   2: monitorenter
        //   3: invokestatic 273	com/facebook/TestSession:retrieveTestAccountsForAppIfNeeded	()V
        //   6: getstatic 275	com/facebook/TestSession:appTestAccounts	Ljava/util/Map;
        //   9: invokeinterface 281 1 0
        //   14: invokeinterface 287 1 0
        //   19: astore_3
        //   20: aload_3
        //   21: invokeinterface 292 1 0
        //   26: istore_1
        //   27: iload_1
        //   28: ifne +10 -> 38
        //   31: aconst_null
        //   32: astore_0
        //   33: ldc 2
        //   35: monitorexit
        //   36: aload_0
        //   37: areturn
        //   38: aload_3
        //   39: invokeinterface 296 1 0
        //   44: checkcast 15	com/facebook/TestSession$TestAccount
        //   47: astore_2
        //   48: aload_2
        //   49: invokeinterface 299 1 0
        //   54: aload_0
        //   55: invokevirtual 303	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   58: istore_1
        //   59: iload_1
        //   60: ifeq -40 -> 20
        //   63: aload_2
        //   64: astore_0
        //   65: goto -32 -> 33
        //   68: astore_0
        //   69: ldc 2
        //   71: monitorexit
        //   72: aload_0
        //   73: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	74	0	paramString	String
        //   26	34	1	bool	boolean
        //   47	17	2	localTestAccount	TestAccount
        //   19	20	3	localIterator	Iterator
        // Exception table:
        //   from	to	target	type
        //   3	20	68	finally
        //   20	27	68	finally
        //   38	59	68	finally
    }

    private void finishAuthWithTestAccount(TestAccount paramTestAccount) {
        this.testAccountId = paramTestAccount.getId();
        finishAuthOrReauth(AccessToken.createFromString(paramTestAccount.getAccessToken(), this.requestedPermissions, AccessTokenSource.TEST_USER), null);
    }

    static final String getAppAccessToken() {
        return testApplicationId + "|" + testApplicationSecret;
    }

    private String getPermissionsString() {
        return TextUtils.join(",", this.requestedPermissions);
    }

    private String getSharedTestAccountIdentifier() {
        long l2 = getPermissionsString().hashCode();
        if (this.sessionUniqueUserTag != null) {
        }
        for (long l1 = this.sessionUniqueUserTag.hashCode() & 0xFFFFFFFF; ; l1 = 0L) {
            return validNameStringFromInteger(l2 & 0xFFFFFFFF ^ l1);
        }
    }

    public static String getTestApplicationId() {
        try {
            String str = testApplicationId;
            return str;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public static String getTestApplicationSecret() {
        try {
            String str = testApplicationSecret;
            return str;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    private static void populateTestAccounts(Collection<TestAccount> paramCollection, Collection<UserAccount> paramCollection1) {
        for (; ; ) {
            try {
                paramCollection = paramCollection.iterator();
                if (!paramCollection.hasNext()) {
                    paramCollection = paramCollection1.iterator();
                    boolean bool = paramCollection.hasNext();
                    if (bool) {
                    }
                } else {
                    storeTestAccount((TestAccount) paramCollection.next());
                    continue;
                }
                paramCollection1 = (UserAccount) paramCollection.next();
            } finally {
            }
            TestAccount localTestAccount = (TestAccount) appTestAccounts.get(paramCollection1.getUid());
            if (localTestAccount != null) {
                localTestAccount.setName(paramCollection1.getName());
            }
        }
    }

    private static void retrieveTestAccountsForAppIfNeeded() {
        for (; ; ) {
            try {
                Object localObject1 = appTestAccounts;
                if (localObject1 != null) {
                    return;
                }
                appTestAccounts = new HashMap();
                localObject1 = String.format("SELECT id,access_token FROM test_account WHERE app_id = %s", new Object[]{testApplicationId});
                Bundle localBundle = new Bundle();
                JSONObject localJSONObject;
                localGraphObjectList = ((FqlResponse) localJSONException.getGraphObjectAs(FqlResponse.class)).getData();
            } finally {
                try {
                    localJSONObject = new JSONObject();
                    localJSONObject.put("test_accounts", localObject1);
                    localJSONObject.put("users", "SELECT uid,name FROM user WHERE uid IN (SELECT id FROM #test_accounts)");
                    localBundle.putString("q", localJSONObject.toString());
                    localBundle.putString("access_token", getAppAccessToken());
                    localObject1 = new Request(null, "fql", localBundle, null).executeAndWait();
                    if (((Response) localObject1).getError() == null) {
                        break label146;
                    }
                    throw ((Response) localObject1).getError().getException();
                } catch (JSONException localJSONException) {
                    throw new FacebookException(localJSONException);
                }
                localObject2 =finally;
            }
            label146:
            GraphObjectList localGraphObjectList;
            if ((localGraphObjectList == null) || (localGraphObjectList.size() != 2)) {
                throw new FacebookException("Unexpected number of results from FQL query");
            }
            populateTestAccounts(((FqlResult) localGraphObjectList.get(0)).getFqlResultSet().castToListOf(TestAccount.class), ((FqlResult) localGraphObjectList.get(1)).getFqlResultSet().castToListOf(UserAccount.class));
        }
    }

    public static void setTestApplicationId(String paramString) {
        try {
            if ((testApplicationId != null) && (!testApplicationId.equals(paramString))) {
                throw new FacebookException("Can't have more than one test application ID");
            }
        } finally {
        }
        testApplicationId = paramString;
    }

    public static void setTestApplicationSecret(String paramString) {
        try {
            if ((testApplicationSecret != null) && (!testApplicationSecret.equals(paramString))) {
                throw new FacebookException("Can't have more than one test application secret");
            }
        } finally {
        }
        testApplicationSecret = paramString;
    }

    private static void storeTestAccount(TestAccount paramTestAccount) {
        try {
            appTestAccounts.put(paramTestAccount.getId(), paramTestAccount);
            return;
        } finally {
            paramTestAccount =finally;
            throw paramTestAccount;
        }
    }

    private String validNameStringFromInteger(long paramLong) {
        Object localObject = Long.toString(paramLong);
        StringBuilder localStringBuilder = new StringBuilder("Perm");
        int k = 0;
        localObject = ((String) localObject).toCharArray();
        int n = localObject.length;
        int j = 0;
        for (; ; ) {
            if (j >= n) {
                return localStringBuilder.toString();
            }
            int m = localObject[j];
            int i = m;
            if (m == k) {
                i = (char) (m + 10);
            }
            localStringBuilder.append((char) (i + 97 - 48));
            j += 1;
            k = i;
        }
    }

    void authorize(Session.AuthorizationRequest paramAuthorizationRequest) {
        if (this.mode == Mode.PRIVATE) {
            createTestAccountAndFinishAuth();
            return;
        }
        findOrCreateSharedTestAccount();
    }

    void extendAccessToken() {
        this.wasAskedToExtendAccessToken = true;
        super.extendAccessToken();
    }

    void fakeTokenRefreshAttempt() {
        setCurrentTokenRefreshRequest(new Session.TokenRefreshRequest(this));
    }

    void forceExtendAccessToken(boolean paramBoolean) {
        AccessToken localAccessToken = getTokenInfo();
        setTokenInfo(new AccessToken(localAccessToken.getToken(), new Date(), localAccessToken.getPermissions(), AccessTokenSource.TEST_USER, new Date(0L)));
        setLastAttemptedTokenExtendDate(new Date(0L));
    }

    public final String getTestUserId() {
        return this.testAccountId;
    }

    boolean getWasAskedToExtendAccessToken() {
        return this.wasAskedToExtendAccessToken;
    }

    void postStateChange(SessionState paramSessionState1, SessionState paramSessionState2, Exception paramException) {
        String str = this.testAccountId;
        super.postStateChange(paramSessionState1, paramSessionState2, paramException);
        if ((paramSessionState2.isClosed()) && (str != null) && (this.mode == Mode.PRIVATE)) {
            deleteTestAccount(str, getAppAccessToken());
        }
    }

    boolean shouldExtendAccessToken() {
        boolean bool = super.shouldExtendAccessToken();
        this.wasAskedToExtendAccessToken = false;
        return bool;
    }

    public final String toString() {
        String str = super.toString();
        return "{TestSession" + " testUserId:" + this.testAccountId + " " + str + "}";
    }

    private static abstract interface FqlResponse
            extends GraphObject {
        public abstract GraphObjectList<TestSession.FqlResult> getData();
    }

    private static abstract interface FqlResult
            extends GraphObject {
        public abstract GraphObjectList<GraphObject> getFqlResultSet();
    }

    private static enum Mode {
        PRIVATE, SHARED;
    }

    private static abstract interface TestAccount
            extends GraphObject {
        public abstract String getAccessToken();

        public abstract String getId();

        public abstract String getName();

        public abstract void setName(String paramString);
    }

    private static final class TestTokenCachingStrategy
            extends TokenCachingStrategy {
        private Bundle bundle;

        public void clear() {
            this.bundle = null;
        }

        public Bundle load() {
            return this.bundle;
        }

        public void save(Bundle paramBundle) {
            this.bundle = paramBundle;
        }
    }

    private static abstract interface UserAccount
            extends GraphObject {
        public abstract String getName();

        public abstract String getUid();

        public abstract void setName(String paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/TestSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */