package com.facebook;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphUser;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TestSession
        extends Session {
    private static final String LOG_TAG = "FacebookSDK.TestSession";
    private static Map<String, TestSession.TestAccount> appTestAccounts;
    private static final long serialVersionUID = 1L;
    private static String testApplicationId;
    private static String testApplicationSecret;
    private final TestSession.Mode mode;
    private final List<String> requestedPermissions;
    private final String sessionUniqueUserTag;
    private String testAccountId;
    private String testAccountUserName;
    private boolean wasAskedToExtendAccessToken;

    static {
        if (!TestSession.class.desiredAssertionStatus()) {
        }
        for (boolean bool = true; ; bool = false) {
            $assertionsDisabled = bool;
            return;
        }
    }

    TestSession(Activity paramActivity, List<String> paramList, TokenCachingStrategy paramTokenCachingStrategy, String paramString, TestSession.Mode paramMode) {
        super(paramActivity, testApplicationId, paramTokenCachingStrategy);
        Validate.notNull(paramList, "permissions");
        Validate.notNullOrEmpty(testApplicationId, "testApplicationId");
        Validate.notNullOrEmpty(testApplicationSecret, "testApplicationSecret");
        this.sessionUniqueUserTag = paramString;
        this.mode = paramMode;
        this.requestedPermissions = paramList;
    }

    public static TestSession createSessionWithPrivateUser(Activity paramActivity, List<String> paramList) {
        return createTestSession(paramActivity, paramList, TestSession.Mode.PRIVATE, null);
    }

    public static TestSession createSessionWithSharedUser(Activity paramActivity, List<String> paramList) {
        return createSessionWithSharedUser(paramActivity, paramList, null);
    }

    public static TestSession createSessionWithSharedUser(Activity paramActivity, List<String> paramList, String paramString) {
        return createTestSession(paramActivity, paramList, TestSession.Mode.SHARED, paramString);
    }

    private TestSession.TestAccount createTestAccountAndFinishAuth() {
        Bundle localBundle = new Bundle();
        localBundle.putString("installed", "true");
        localBundle.putString("permissions", getPermissionsString());
        localBundle.putString("access_token", getAppAccessToken());
        if (this.mode == TestSession.Mode.SHARED) {
            localBundle.putString("name", String.format("Shared %s Testuser", new Object[]{getSharedTestAccountIdentifier()}));
        }
        Object localObject = new Request(null, String.format("%s/accounts/test-users", new Object[]{testApplicationId}), localBundle, HttpMethod.POST).executeAndWait();
        FacebookRequestError localFacebookRequestError = ((Response) localObject).getError();
        localObject = (TestSession.TestAccount) ((Response) localObject).getGraphObjectAs(TestSession.TestAccount.class);
        if (localFacebookRequestError != null) {
            finishAuthOrReauth(null, localFacebookRequestError.getException());
            return null;
        }
        assert (localObject != null);
        if (this.mode == TestSession.Mode.SHARED) {
            ((TestSession.TestAccount) localObject).setName(localBundle.getString("name"));
            storeTestAccount((TestSession.TestAccount) localObject);
        }
        finishAuthWithTestAccount((TestSession.TestAccount) localObject);
        return (TestSession.TestAccount) localObject;
    }

    private static TestSession createTestSession(Activity paramActivity, List<String> paramList, TestSession.Mode paramMode, String paramString) {
        try {
            if ((Utility.isNullOrEmpty(testApplicationId)) || (Utility.isNullOrEmpty(testApplicationSecret))) {
                throw new FacebookException("Must provide app ID and secret");
            }
        } finally {
            throw paramActivity;
            if (Utility.isNullOrEmpty(paramList)) {
                paramList = Arrays.asList(new String[]{"email", "publish_actions"});
                paramActivity = new TestSession(paramActivity, paramList, new TestSession.TestTokenCachingStrategy(null), paramString, paramMode);
            }
        }
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
        while ((((GraphObject) localObject).getProperty("FACEBOOK_NON_JSON_RESULT") != Boolean.valueOf(false)) && (((GraphObject) localObject).getProperty("success") != Boolean.valueOf(false))) {
            return;
        }
        Log.w("FacebookSDK.TestSession", String.format("Could not delete test account %s: unknown reason", new Object[]{paramString1}));
    }

    private void findOrCreateSharedTestAccount() {
        TestSession.TestAccount localTestAccount = findTestAccountMatchingIdentifier(getSharedTestAccountIdentifier());
        if (localTestAccount != null) {
            finishAuthWithTestAccount(localTestAccount);
            return;
        }
        createTestAccountAndFinishAuth();
    }

    /* Error */
    private static TestSession.TestAccount findTestAccountMatchingIdentifier(String paramString) {
        // Byte code:
        //   0: ldc 2
        //   2: monitorenter
        //   3: invokestatic 264	com/facebook/TestSession:retrieveTestAccountsForAppIfNeeded	()V
        //   6: getstatic 266	com/facebook/TestSession:appTestAccounts	Ljava/util/Map;
        //   9: invokeinterface 272 1 0
        //   14: invokeinterface 278 1 0
        //   19: astore_3
        //   20: aload_3
        //   21: invokeinterface 283 1 0
        //   26: ifeq +35 -> 61
        //   29: aload_3
        //   30: invokeinterface 287 1 0
        //   35: checkcast 152	com/facebook/TestSession$TestAccount
        //   38: astore_2
        //   39: aload_2
        //   40: invokeinterface 290 1 0
        //   45: aload_0
        //   46: invokevirtual 294	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   49: istore_1
        //   50: iload_1
        //   51: ifeq -31 -> 20
        //   54: aload_2
        //   55: astore_0
        //   56: ldc 2
        //   58: monitorexit
        //   59: aload_0
        //   60: areturn
        //   61: aconst_null
        //   62: astore_0
        //   63: goto -7 -> 56
        //   66: astore_0
        //   67: ldc 2
        //   69: monitorexit
        //   70: aload_0
        //   71: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	72	0	paramString	String
        //   49	2	1	bool	boolean
        //   38	17	2	localTestAccount	TestSession.TestAccount
        //   19	11	3	localIterator	Iterator
        // Exception table:
        //   from	to	target	type
        //   3	20	66	finally
        //   20	50	66	finally
    }

    private void finishAuthWithTestAccount(TestSession.TestAccount paramTestAccount) {
        this.testAccountId = paramTestAccount.getId();
        this.testAccountUserName = paramTestAccount.getName();
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
            return validNameStringFromInteger(l1 ^ l2 & 0xFFFFFFFF);
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

    private static void populateTestAccounts(Collection<TestSession.TestAccount> paramCollection, GraphObject paramGraphObject) {
        try {
            paramCollection = paramCollection.iterator();
            while (paramCollection.hasNext()) {
                TestSession.TestAccount localTestAccount = (TestSession.TestAccount) paramCollection.next();
                localTestAccount.setName(((GraphUser) paramGraphObject.getPropertyAs(localTestAccount.getId(), GraphUser.class)).getName());
                storeTestAccount(localTestAccount);
            }
        } finally {
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
                Request.setDefaultBatchApplicationId(testApplicationId);
                localObject1 = new Bundle();
                ((Bundle) localObject1).putString("access_token", getAppAccessToken());
                localObject1 = new Request(null, "app/accounts/test-users", (Bundle) localObject1, null);
                ((Request) localObject1).setBatchEntryName("testUsers");
                ((Request) localObject1).setBatchEntryOmitResultOnSuccess(false);
                Object localObject3 = new Bundle();
                ((Bundle) localObject3).putString("access_token", getAppAccessToken());
                ((Bundle) localObject3).putString("ids", "{result=testUsers:$.data.*.id}");
                ((Bundle) localObject3).putString("fields", "name");
                localObject3 = new Request(null, "", (Bundle) localObject3, null);
                ((Request) localObject3).setBatchEntryDependsOn("testUsers");
                localObject1 = Request.executeBatchAndWait(new Request[]{localObject1, localObject3});
                if ((localObject1 == null) || (((List) localObject1).size() != 2)) {
                    throw new FacebookException("Unexpected number of results from TestUsers batch query");
                }
            } finally {
            }
            populateTestAccounts(((TestSession.TestAccountsResponse) ((Response) ((List) localObject2).get(0)).getGraphObjectAs(TestSession.TestAccountsResponse.class)).getData(), ((Response) ((List) localObject2).get(1)).getGraphObject());
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

    private static void storeTestAccount(TestSession.TestAccount paramTestAccount) {
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
        localObject = ((String) localObject).toCharArray();
        int n = localObject.length;
        int j = 0;
        int i;
        for (int k = 0; j < n; k = i) {
            int m = localObject[j];
            i = m;
            if (m == k) {
                i = (char) (m + 10);
            }
            localStringBuilder.append((char) (i + 97 - 48));
            j += 1;
        }
        return localStringBuilder.toString();
    }

    void authorize(Session.AuthorizationRequest paramAuthorizationRequest) {
        if (this.mode == TestSession.Mode.PRIVATE) {
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
        setTokenInfo(new AccessToken(localAccessToken.getToken(), new Date(), localAccessToken.getPermissions(), localAccessToken.getDeclinedPermissions(), AccessTokenSource.TEST_USER, new Date(0L)));
        setLastAttemptedTokenExtendDate(new Date(0L));
    }

    public final String getTestUserId() {
        return this.testAccountId;
    }

    public final String getTestUserName() {
        return this.testAccountUserName;
    }

    boolean getWasAskedToExtendAccessToken() {
        return this.wasAskedToExtendAccessToken;
    }

    void postStateChange(SessionState paramSessionState1, SessionState paramSessionState2, Exception paramException) {
        String str = this.testAccountId;
        super.postStateChange(paramSessionState1, paramSessionState2, paramException);
        if ((paramSessionState2.isClosed()) && (str != null) && (this.mode == TestSession.Mode.PRIVATE)) {
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
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/TestSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */