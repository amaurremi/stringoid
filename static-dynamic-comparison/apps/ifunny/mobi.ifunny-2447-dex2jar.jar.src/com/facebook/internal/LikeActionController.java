package com.facebook.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.a.n;
import android.util.Log;
import com.facebook.AppEventsLogger;
import com.facebook.FacebookRequestError;
import com.facebook.RequestBatch;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.Settings;
import com.facebook.widget.FacebookDialog;
import com.facebook.widget.FacebookDialog.Callback;
import com.facebook.widget.FacebookDialog.PendingCall;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.json.JSONException;
import org.json.JSONObject;

public class LikeActionController {
    public static final String ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR = "com.facebook.sdk.LikeActionController.DID_ERROR";
    public static final String ACTION_LIKE_ACTION_CONTROLLER_DID_RESET = "com.facebook.sdk.LikeActionController.DID_RESET";
    public static final String ACTION_LIKE_ACTION_CONTROLLER_UPDATED = "com.facebook.sdk.LikeActionController.UPDATED";
    public static final String ACTION_OBJECT_ID_KEY = "com.facebook.sdk.LikeActionController.OBJECT_ID";
    private static final int ERROR_CODE_OBJECT_ALREADY_LIKED = 3501;
    public static final String ERROR_INVALID_OBJECT_ID = "Invalid Object Id";
    private static final String JSON_BOOL_IS_OBJECT_LIKED_KEY = "is_object_liked";
    private static final String JSON_BUNDLE_PENDING_CALL_ANALYTICS_BUNDLE = "pending_call_analytics_bundle";
    private static final String JSON_INT_VERSION_KEY = "com.facebook.internal.LikeActionController.version";
    private static final String JSON_STRING_LIKE_COUNT_WITHOUT_LIKE_KEY = "like_count_string_without_like";
    private static final String JSON_STRING_LIKE_COUNT_WITH_LIKE_KEY = "like_count_string_with_like";
    private static final String JSON_STRING_OBJECT_ID_KEY = "object_id";
    private static final String JSON_STRING_PENDING_CALL_ID_KEY = "pending_call_id";
    private static final String JSON_STRING_SOCIAL_SENTENCE_WITHOUT_LIKE_KEY = "social_sentence_without_like";
    private static final String JSON_STRING_SOCIAL_SENTENCE_WITH_LIKE_KEY = "social_sentence_with_like";
    private static final String JSON_STRING_UNLIKE_TOKEN_KEY = "unlike_token";
    private static final String LIKE_ACTION_CONTROLLER_STORE = "com.facebook.LikeActionController.CONTROLLER_STORE_KEY";
    private static final String LIKE_ACTION_CONTROLLER_STORE_OBJECT_SUFFIX_KEY = "OBJECT_SUFFIX";
    private static final String LIKE_ACTION_CONTROLLER_STORE_PENDING_OBJECT_ID_KEY = "PENDING_CONTROLLER_KEY";
    private static final int LIKE_ACTION_CONTROLLER_VERSION = 2;
    private static final String LIKE_DIALOG_RESPONSE_LIKE_COUNT_STRING_KEY = "like_count_string";
    private static final String LIKE_DIALOG_RESPONSE_OBJECT_IS_LIKED_KEY = "object_is_liked";
    private static final String LIKE_DIALOG_RESPONSE_SOCIAL_SENTENCE_KEY = "social_sentence";
    private static final String LIKE_DIALOG_RESPONSE_UNLIKE_TOKEN_KEY = "unlike_token";
    private static final int MAX_CACHE_SIZE = 128;
    private static final int MAX_OBJECT_SUFFIX = 1000;
    private static final String TAG = LikeActionController.class.getSimpleName();
    private static final ConcurrentHashMap<String, LikeActionController> cache = new ConcurrentHashMap();
    private static FileLruCache controllerDiskCache;
    private static WorkQueue diskIOWorkQueue = new WorkQueue(1);
    private static Handler handler;
    private static boolean isInitialized;
    private static boolean isPendingBroadcastReset;
    private static WorkQueue mruCacheWorkQueue = new WorkQueue(1);
    private static String objectIdForPendingController;
    private static volatile int objectSuffix;
    private AppEventsLogger appEventsLogger;
    private Context context;
    private boolean isObjectLiked;
    private boolean isObjectLikedOnServer;
    private boolean isPendingLikeOrUnlike;
    private String likeCountStringWithLike;
    private String likeCountStringWithoutLike;
    private String objectId;
    private boolean objectIsPage;
    private Bundle pendingCallAnalyticsBundle;
    private UUID pendingCallId;
    private Session session;
    private String socialSentenceWithLike;
    private String socialSentenceWithoutLike;
    private String unlikeToken;
    private String verifiedObjectId;

    private LikeActionController(Context paramContext, Session paramSession, String paramString) {
        this.context = paramContext;
        this.session = paramSession;
        this.objectId = paramString;
        this.appEventsLogger = AppEventsLogger.newLogger(paramContext, paramSession);
    }

    private static void broadcastAction(Context paramContext, LikeActionController paramLikeActionController, String paramString) {
        broadcastAction(paramContext, paramLikeActionController, paramString, null);
    }

    private static void broadcastAction(Context paramContext, LikeActionController paramLikeActionController, String paramString, Bundle paramBundle) {
        Intent localIntent = new Intent(paramString);
        paramString = paramBundle;
        if (paramLikeActionController != null) {
            paramString = paramBundle;
            if (paramBundle == null) {
                paramString = new Bundle();
            }
            paramString.putString("com.facebook.sdk.LikeActionController.OBJECT_ID", paramLikeActionController.getObjectId());
        }
        if (paramString != null) {
            localIntent.putExtras(paramString);
        }
        n.a(paramContext.getApplicationContext()).a(localIntent);
    }

    private boolean canUseOGPublish(boolean paramBoolean) {
        return (!this.objectIsPage) && (this.verifiedObjectId != null) && (this.session != null) && (this.session.getPermissions() != null) && (this.session.getPermissions().contains("publish_actions")) && ((paramBoolean) || (!Utility.isNullOrEmpty(this.unlikeToken)));
    }

    private static void createControllerForObjectId(Context paramContext, String paramString, LikeActionController.CreationCallback paramCreationCallback) {
        Object localObject = getControllerFromInMemoryCache(paramString);
        if (localObject != null) {
            invokeCallbackWithController(paramCreationCallback, (LikeActionController) localObject);
            return;
        }
        LikeActionController localLikeActionController = deserializeFromDiskSynchronously(paramContext, paramString);
        localObject = localLikeActionController;
        if (localLikeActionController == null) {
            localObject = new LikeActionController(paramContext, Session.getActiveSession(), paramString);
            serializeToDiskAsync((LikeActionController) localObject);
        }
        putControllerInMemoryCache(paramString, (LikeActionController) localObject);
        handler.post(new LikeActionController .2 ((LikeActionController) localObject));
        invokeCallbackWithController(paramCreationCallback, (LikeActionController) localObject);
    }

    /* Error */
    private static LikeActionController deserializeFromDiskSynchronously(Context paramContext, String paramString) {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: aconst_null
        //   4: astore 5
        //   6: aload_1
        //   7: invokestatic 372	com/facebook/internal/LikeActionController:getCacheKeyForObjectId	(Ljava/lang/String;)Ljava/lang/String;
        //   10: astore_1
        //   11: getstatic 261	com/facebook/internal/LikeActionController:controllerDiskCache	Lcom/facebook/internal/FileLruCache;
        //   14: aload_1
        //   15: invokevirtual 378	com/facebook/internal/FileLruCache:get	(Ljava/lang/String;)Ljava/io/InputStream;
        //   18: astore_1
        //   19: aload 5
        //   21: astore_3
        //   22: aload_1
        //   23: ifnull +33 -> 56
        //   26: aload_1
        //   27: astore_2
        //   28: aload_1
        //   29: invokestatic 382	com/facebook/internal/Utility:readStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
        //   32: astore 6
        //   34: aload 5
        //   36: astore_3
        //   37: aload_1
        //   38: astore_2
        //   39: aload 6
        //   41: invokestatic 331	com/facebook/internal/Utility:isNullOrEmpty	(Ljava/lang/String;)Z
        //   44: ifne +12 -> 56
        //   47: aload_1
        //   48: astore_2
        //   49: aload_0
        //   50: aload 6
        //   52: invokestatic 385	com/facebook/internal/LikeActionController:deserializeFromJson	(Landroid/content/Context;Ljava/lang/String;)Lcom/facebook/internal/LikeActionController;
        //   55: astore_3
        //   56: aload_3
        //   57: astore_0
        //   58: aload_1
        //   59: ifnull +9 -> 68
        //   62: aload_1
        //   63: invokestatic 389	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   66: aload_3
        //   67: astore_0
        //   68: aload_0
        //   69: areturn
        //   70: astore_0
        //   71: aconst_null
        //   72: astore_1
        //   73: aload_1
        //   74: astore_2
        //   75: getstatic 125	com/facebook/internal/LikeActionController:TAG	Ljava/lang/String;
        //   78: ldc_w 391
        //   81: aload_0
        //   82: invokestatic 397	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   85: pop
        //   86: aload 4
        //   88: astore_0
        //   89: aload_1
        //   90: ifnull -22 -> 68
        //   93: aload_1
        //   94: invokestatic 389	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   97: aconst_null
        //   98: areturn
        //   99: astore_0
        //   100: aconst_null
        //   101: astore_2
        //   102: aload_2
        //   103: ifnull +7 -> 110
        //   106: aload_2
        //   107: invokestatic 389	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
        //   110: aload_0
        //   111: athrow
        //   112: astore_0
        //   113: goto -11 -> 102
        //   116: astore_0
        //   117: goto -44 -> 73
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	120	0	paramContext	Context
        //   0	120	1	paramString	String
        //   27	80	2	str1	String
        //   21	46	3	localObject1	Object
        //   1	86	4	localObject2	Object
        //   4	31	5	localObject3	Object
        //   32	19	6	str2	String
        // Exception table:
        //   from	to	target	type
        //   6	19	70	java/io/IOException
        //   6	19	99	finally
        //   28	34	112	finally
        //   39	47	112	finally
        //   49	56	112	finally
        //   75	86	112	finally
        //   28	34	116	java/io/IOException
        //   39	47	116	java/io/IOException
        //   49	56	116	java/io/IOException
    }

    private static LikeActionController deserializeFromJson(Context paramContext, String paramString) {
        try {
            JSONObject localJSONObject = new JSONObject(paramString);
            if (localJSONObject.optInt("com.facebook.internal.LikeActionController.version", -1) != 2) {
                return null;
            }
            paramString = new LikeActionController(paramContext, Session.getActiveSession(), localJSONObject.getString("object_id"));
            paramString.likeCountStringWithLike = localJSONObject.optString("like_count_string_with_like", null);
            paramString.likeCountStringWithoutLike = localJSONObject.optString("like_count_string_without_like", null);
            paramString.socialSentenceWithLike = localJSONObject.optString("social_sentence_with_like", null);
            paramString.socialSentenceWithoutLike = localJSONObject.optString("social_sentence_without_like", null);
            paramString.isObjectLiked = localJSONObject.optBoolean("is_object_liked");
            paramString.unlikeToken = localJSONObject.optString("unlike_token", null);
            paramContext = localJSONObject.optString("pending_call_id", null);
            if (!Utility.isNullOrEmpty(paramContext)) {
                paramString.pendingCallId = UUID.fromString(paramContext);
            }
            localJSONObject = localJSONObject.optJSONObject("pending_call_analytics_bundle");
            paramContext = paramString;
            if (localJSONObject != null) {
                paramString.pendingCallAnalyticsBundle = BundleJSONConverter.convertToBundle(localJSONObject);
                paramContext = paramString;
            }
        } catch (JSONException paramContext) {
            for (; ; ) {
                Log.e(TAG, "Unable to deserialize controller from JSON", paramContext);
                paramContext = null;
            }
        }
        return paramContext;
    }

    private void fetchVerifiedObjectId(LikeActionController.RequestCompletionCallback paramRequestCompletionCallback) {
        if (!Utility.isNullOrEmpty(this.verifiedObjectId)) {
            if (paramRequestCompletionCallback != null) {
                paramRequestCompletionCallback.onComplete();
            }
            return;
        }
        LikeActionController.GetOGObjectIdRequestWrapper localGetOGObjectIdRequestWrapper = new LikeActionController.GetOGObjectIdRequestWrapper(this, this.objectId);
        LikeActionController.GetPageIdRequestWrapper localGetPageIdRequestWrapper = new LikeActionController.GetPageIdRequestWrapper(this, this.objectId);
        RequestBatch localRequestBatch = new RequestBatch();
        localGetOGObjectIdRequestWrapper.addToBatch(localRequestBatch);
        localGetPageIdRequestWrapper.addToBatch(localRequestBatch);
        localRequestBatch.addCallback(new LikeActionController .10
        (this, localGetOGObjectIdRequestWrapper, localGetPageIdRequestWrapper, paramRequestCompletionCallback));
        localRequestBatch.executeAsync();
    }

    private static String getCacheKeyForObjectId(String paramString) {
        Object localObject2 = null;
        Session localSession = Session.getActiveSession();
        Object localObject1 = localObject2;
        if (localSession != null) {
            localObject1 = localObject2;
            if (localSession.isOpened()) {
                localObject1 = localSession.getAccessToken();
            }
        }
        localObject2 = localObject1;
        if (localObject1 != null) {
            localObject2 = Utility.md5hash((String) localObject1);
        }
        return String.format("%s|%s|com.fb.sdk.like|%d", new Object[]{paramString, Utility.coerceValueIfNullOrEmpty((String) localObject2, ""), Integer.valueOf(objectSuffix)});
    }

    public static void getControllerForObjectId(Context paramContext, String paramString, LikeActionController.CreationCallback paramCreationCallback) {
        if (!isInitialized) {
            performFirstInitialize(paramContext);
        }
        LikeActionController localLikeActionController = getControllerFromInMemoryCache(paramString);
        if (localLikeActionController != null) {
            invokeCallbackWithController(paramCreationCallback, localLikeActionController);
            return;
        }
        diskIOWorkQueue.addActiveWorkItem(new LikeActionController.CreateLikeActionControllerWorkItem(paramContext, paramString, paramCreationCallback));
    }

    private static LikeActionController getControllerFromInMemoryCache(String paramString) {
        paramString = getCacheKeyForObjectId(paramString);
        LikeActionController localLikeActionController = (LikeActionController) cache.get(paramString);
        if (localLikeActionController != null) {
            mruCacheWorkQueue.addActiveWorkItem(new LikeActionController.MRUCacheWorkItem(paramString, false));
        }
        return localLikeActionController;
    }

    private FacebookDialog.Callback getFacebookDialogCallback(Bundle paramBundle) {
        return new LikeActionController .5 (this, paramBundle);
    }

    public static boolean handleOnActivityResult(Context paramContext, int paramInt1, int paramInt2, Intent paramIntent) {
        UUID localUUID = NativeProtocol.getCallIdFromIntent(paramIntent);
        if (localUUID == null) {
        }
        do {
            return false;
            if (Utility.isNullOrEmpty(objectIdForPendingController)) {
                objectIdForPendingController = paramContext.getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).getString("PENDING_CONTROLLER_KEY", null);
            }
        } while (Utility.isNullOrEmpty(objectIdForPendingController));
        getControllerForObjectId(paramContext, objectIdForPendingController, new LikeActionController .1
        (paramInt1, paramInt2, paramIntent, localUUID));
        return true;
    }

    private static void invokeCallbackWithController(LikeActionController.CreationCallback paramCreationCallback, LikeActionController paramLikeActionController) {
        if (paramCreationCallback == null) {
            return;
        }
        handler.post(new LikeActionController .3 (paramCreationCallback, paramLikeActionController));
    }

    private void logAppEventForError(String paramString, Bundle paramBundle) {
        paramBundle = new Bundle(paramBundle);
        paramBundle.putString("object_id", this.objectId);
        paramBundle.putString("current_action", paramString);
        this.appEventsLogger.logSdkEvent("fb_like_control_error", null, paramBundle);
    }

    private void logAppEventForError(String paramString, FacebookRequestError paramFacebookRequestError) {
        Bundle localBundle = new Bundle();
        if (paramFacebookRequestError != null) {
            paramFacebookRequestError = paramFacebookRequestError.getRequestResult();
            if (paramFacebookRequestError != null) {
                localBundle.putString("error", paramFacebookRequestError.toString());
            }
        }
        logAppEventForError(paramString, localBundle);
    }

    private boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent, UUID paramUUID) {
        if ((this.pendingCallId == null) || (!this.pendingCallId.equals(paramUUID))) {
        }
        do {
            return false;
            paramUUID = PendingCallStore.getInstance().getPendingCallById(this.pendingCallId);
        } while (paramUUID == null);
        FacebookDialog.handleActivityResult(this.context, paramUUID, paramInt1, paramIntent, getFacebookDialogCallback(this.pendingCallAnalyticsBundle));
        stopTrackingPendingCall();
        return true;
    }

    /* Error */
    private static void performFirstInitialize(Context paramContext) {
        // Byte code:
        //   0: ldc 2
        //   2: monitorenter
        //   3: getstatic 507	com/facebook/internal/LikeActionController:isInitialized	Z
        //   6: istore_1
        //   7: iload_1
        //   8: ifeq +7 -> 15
        //   11: ldc 2
        //   13: monitorexit
        //   14: return
        //   15: new 362	android/os/Handler
        //   18: dup
        //   19: invokestatic 615	android/os/Looper:getMainLooper	()Landroid/os/Looper;
        //   22: invokespecial 618	android/os/Handler:<init>	(Landroid/os/Looper;)V
        //   25: putstatic 269	com/facebook/internal/LikeActionController:handler	Landroid/os/Handler;
        //   28: aload_0
        //   29: ldc 56
        //   31: iconst_0
        //   32: invokevirtual 548	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
        //   35: ldc 59
        //   37: iconst_1
        //   38: invokeinterface 621 3 0
        //   43: putstatic 253	com/facebook/internal/LikeActionController:objectSuffix	I
        //   46: new 374	com/facebook/internal/FileLruCache
        //   49: dup
        //   50: aload_0
        //   51: getstatic 125	com/facebook/internal/LikeActionController:TAG	Ljava/lang/String;
        //   54: new 623	com/facebook/internal/FileLruCache$Limits
        //   57: dup
        //   58: invokespecial 624	com/facebook/internal/FileLruCache$Limits:<init>	()V
        //   61: invokespecial 627	com/facebook/internal/FileLruCache:<init>	(Landroid/content/Context;Ljava/lang/String;Lcom/facebook/internal/FileLruCache$Limits;)V
        //   64: putstatic 261	com/facebook/internal/LikeActionController:controllerDiskCache	Lcom/facebook/internal/FileLruCache;
        //   67: aload_0
        //   68: invokestatic 630	com/facebook/internal/LikeActionController:registerSessionBroadcastReceivers	(Landroid/content/Context;)V
        //   71: iconst_1
        //   72: putstatic 507	com/facebook/internal/LikeActionController:isInitialized	Z
        //   75: goto -64 -> 11
        //   78: astore_0
        //   79: ldc 2
        //   81: monitorexit
        //   82: aload_0
        //   83: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	84	0	paramContext	Context
        //   6	2	1	bool	boolean
        // Exception table:
        //   from	to	target	type
        //   3	7	78	finally
        //   15	75	78	finally
    }

    private void performLikeOrUnlike(Activity paramActivity, boolean paramBoolean, Bundle paramBundle) {
        if (canUseOGPublish(paramBoolean)) {
            if (paramBoolean) {
                publishLikeAsync(paramActivity, paramBundle);
                return;
            }
            publishUnlikeAsync(paramActivity, paramBundle);
            return;
        }
        presentLikeDialog(paramActivity, paramBundle);
    }

    private void presentLikeDialog(Activity paramActivity, Bundle paramBundle) {
        LikeActionController.LikeDialogBuilder localLikeDialogBuilder = new LikeActionController.LikeDialogBuilder(paramActivity, this.objectId);
        if (localLikeDialogBuilder.canPresent()) {
            trackPendingCall(localLikeDialogBuilder.build().present(), paramBundle);
            this.appEventsLogger.logSdkEvent("fb_like_control_did_present_dialog", null, paramBundle);
        }
        String str;
        do {
            return;
            str = localLikeDialogBuilder.getWebFallbackUrl();
        }
        while ((Utility.isNullOrEmpty(str)) || (!FacebookWebFallbackDialog.presentWebFallback(paramActivity, str, localLikeDialogBuilder.getApplicationId(), localLikeDialogBuilder.getAppCall(), getFacebookDialogCallback(paramBundle))));
        this.appEventsLogger.logSdkEvent("fb_like_control_did_present_fallback_dialog", null, paramBundle);
    }

    private void publishLikeAsync(Activity paramActivity, Bundle paramBundle) {
        this.isPendingLikeOrUnlike = true;
        fetchVerifiedObjectId(new LikeActionController .6 (this, paramActivity, paramBundle));
    }

    private void publishUnlikeAsync(Activity paramActivity, Bundle paramBundle) {
        this.isPendingLikeOrUnlike = true;
        RequestBatch localRequestBatch = new RequestBatch();
        LikeActionController.PublishUnlikeRequestWrapper localPublishUnlikeRequestWrapper = new LikeActionController.PublishUnlikeRequestWrapper(this, this.unlikeToken);
        localPublishUnlikeRequestWrapper.addToBatch(localRequestBatch);
        localRequestBatch.addCallback(new LikeActionController .7
        (this, localPublishUnlikeRequestWrapper, paramActivity, paramBundle));
        localRequestBatch.executeAsync();
    }

    private static void putControllerInMemoryCache(String paramString, LikeActionController paramLikeActionController) {
        paramString = getCacheKeyForObjectId(paramString);
        mruCacheWorkQueue.addActiveWorkItem(new LikeActionController.MRUCacheWorkItem(paramString, true));
        cache.put(paramString, paramLikeActionController);
    }

    private void refreshStatusAsync() {
        if ((this.session == null) || (this.session.isClosed()) || (SessionState.CREATED.equals(this.session.getState()))) {
            refreshStatusViaService();
            return;
        }
        fetchVerifiedObjectId(new LikeActionController .8 (this));
    }

    private void refreshStatusViaService() {
        LikeStatusClient localLikeStatusClient = new LikeStatusClient(this.context, Settings.getApplicationId(), this.objectId);
        if (!localLikeStatusClient.start()) {
            return;
        }
        localLikeStatusClient.setCompletedListener(new LikeActionController .9 (this));
    }

    private static void registerSessionBroadcastReceivers(Context paramContext) {
        paramContext = n.a(paramContext);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.facebook.sdk.ACTIVE_SESSION_UNSET");
        localIntentFilter.addAction("com.facebook.sdk.ACTIVE_SESSION_CLOSED");
        localIntentFilter.addAction("com.facebook.sdk.ACTIVE_SESSION_OPENED");
        paramContext.a(new LikeActionController .4 (), localIntentFilter);
    }

    private static void serializeToDiskAsync(LikeActionController paramLikeActionController) {
        String str = serializeToJson(paramLikeActionController);
        paramLikeActionController = getCacheKeyForObjectId(paramLikeActionController.objectId);
        if ((!Utility.isNullOrEmpty(str)) && (!Utility.isNullOrEmpty(paramLikeActionController))) {
            diskIOWorkQueue.addActiveWorkItem(new LikeActionController.SerializeToDiskWorkItem(paramLikeActionController, str));
        }
    }

    private static void serializeToDiskSynchronously(String paramString1, String paramString2) {
        Object localObject = null;
        String str = null;
        try {
            paramString1 = controllerDiskCache.openPutStream(paramString1);
            str = paramString1;
            localObject = paramString1;
            paramString1.write(paramString2.getBytes());
            if (paramString1 != null) {
                Utility.closeQuietly(paramString1);
            }
            return;
        } catch (IOException paramString1) {
            do {
                localObject = str;
                Log.e(TAG, "Unable to serialize controller to disk", paramString1);
            } while (str == null);
            Utility.closeQuietly(str);
            return;
        } finally {
            if (localObject != null) {
                Utility.closeQuietly((Closeable) localObject);
            }
        }
    }

    private static String serializeToJson(LikeActionController paramLikeActionController) {
        JSONObject localJSONObject = new JSONObject();
        try {
            localJSONObject.put("com.facebook.internal.LikeActionController.version", 2);
            localJSONObject.put("object_id", paramLikeActionController.objectId);
            localJSONObject.put("like_count_string_with_like", paramLikeActionController.likeCountStringWithLike);
            localJSONObject.put("like_count_string_without_like", paramLikeActionController.likeCountStringWithoutLike);
            localJSONObject.put("social_sentence_with_like", paramLikeActionController.socialSentenceWithLike);
            localJSONObject.put("social_sentence_without_like", paramLikeActionController.socialSentenceWithoutLike);
            localJSONObject.put("is_object_liked", paramLikeActionController.isObjectLiked);
            localJSONObject.put("unlike_token", paramLikeActionController.unlikeToken);
            if (paramLikeActionController.pendingCallId != null) {
                localJSONObject.put("pending_call_id", paramLikeActionController.pendingCallId.toString());
            }
            if (paramLikeActionController.pendingCallAnalyticsBundle != null) {
                paramLikeActionController = BundleJSONConverter.convertToJSON(paramLikeActionController.pendingCallAnalyticsBundle);
                if (paramLikeActionController != null) {
                    localJSONObject.put("pending_call_analytics_bundle", paramLikeActionController);
                }
            }
            return localJSONObject.toString();
        } catch (JSONException paramLikeActionController) {
            Log.e(TAG, "Unable to serialize controller to JSON", paramLikeActionController);
        }
        return null;
    }

    private void stopTrackingPendingCall() {
        PendingCallStore.getInstance().stopTrackingPendingCall(this.pendingCallId);
        this.pendingCallId = null;
        this.pendingCallAnalyticsBundle = null;
        storeObjectIdForPendingController(null);
    }

    private void storeObjectIdForPendingController(String paramString) {
        objectIdForPendingController = paramString;
        this.context.getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).edit().putString("PENDING_CONTROLLER_KEY", objectIdForPendingController).apply();
    }

    private void toggleAgainIfNeeded(Activity paramActivity, Bundle paramBundle) {
        if (this.isObjectLiked != this.isObjectLikedOnServer) {
            performLikeOrUnlike(paramActivity, this.isObjectLiked, paramBundle);
        }
    }

    private void trackPendingCall(FacebookDialog.PendingCall paramPendingCall, Bundle paramBundle) {
        PendingCallStore.getInstance().trackPendingCall(paramPendingCall);
        this.pendingCallId = paramPendingCall.getCallId();
        storeObjectIdForPendingController(this.objectId);
        this.pendingCallAnalyticsBundle = paramBundle;
        serializeToDiskAsync(this);
    }

    private void updateState(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
        paramString1 = Utility.coerceValueIfNullOrEmpty(paramString1, null);
        paramString2 = Utility.coerceValueIfNullOrEmpty(paramString2, null);
        paramString3 = Utility.coerceValueIfNullOrEmpty(paramString3, null);
        paramString4 = Utility.coerceValueIfNullOrEmpty(paramString4, null);
        paramString5 = Utility.coerceValueIfNullOrEmpty(paramString5, null);
        if ((paramBoolean != this.isObjectLiked) || (!Utility.areObjectsEqual(paramString1, this.likeCountStringWithLike)) || (!Utility.areObjectsEqual(paramString2, this.likeCountStringWithoutLike)) || (!Utility.areObjectsEqual(paramString3, this.socialSentenceWithLike)) || (!Utility.areObjectsEqual(paramString4, this.socialSentenceWithoutLike)) || (!Utility.areObjectsEqual(paramString5, this.unlikeToken))) {
        }
        for (int i = 1; i == 0; i = 0) {
            return;
        }
        this.isObjectLiked = paramBoolean;
        this.likeCountStringWithLike = paramString1;
        this.likeCountStringWithoutLike = paramString2;
        this.socialSentenceWithLike = paramString3;
        this.socialSentenceWithoutLike = paramString4;
        this.unlikeToken = paramString5;
        serializeToDiskAsync(this);
        broadcastAction(this.context, this, "com.facebook.sdk.LikeActionController.UPDATED");
    }

    public String getLikeCountString() {
        if (this.isObjectLiked) {
            return this.likeCountStringWithLike;
        }
        return this.likeCountStringWithoutLike;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public String getSocialSentence() {
        if (this.isObjectLiked) {
            return this.socialSentenceWithLike;
        }
        return this.socialSentenceWithoutLike;
    }

    public boolean isObjectLiked() {
        return this.isObjectLiked;
    }

    public void toggleLike(Activity paramActivity, Bundle paramBundle) {
        this.appEventsLogger.logSdkEvent("fb_like_control_did_tap", null, paramBundle);
        if (!this.isObjectLiked) {
        }
        for (boolean bool = true; canUseOGPublish(bool); bool = false) {
            updateState(bool, this.likeCountStringWithLike, this.likeCountStringWithoutLike, this.socialSentenceWithLike, this.socialSentenceWithoutLike, this.unlikeToken);
            if (!this.isPendingLikeOrUnlike) {
                break;
            }
            this.appEventsLogger.logSdkEvent("fb_like_control_did_undo_quickly", null, paramBundle);
            return;
        }
        performLikeOrUnlike(paramActivity, bool, paramBundle);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/LikeActionController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */