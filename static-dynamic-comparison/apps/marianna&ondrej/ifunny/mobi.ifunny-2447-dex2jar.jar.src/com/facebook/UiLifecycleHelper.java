package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.a.n;
import android.util.Log;
import com.facebook.internal.LikeActionController;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PendingCallStore;
import com.facebook.widget.FacebookDialog;
import com.facebook.widget.FacebookDialog.Callback;
import com.facebook.widget.FacebookDialog.PendingCall;

import java.util.UUID;

public class UiLifecycleHelper {
    private static final String ACTIVITY_NULL_MESSAGE = "activity cannot be null";
    private static final String DIALOG_CALL_ID_SAVE_KEY = "com.facebook.UiLifecycleHelper.pendingFacebookDialogCallKey";
    private final Activity activity;
    private AppEventsLogger appEventsLogger;
    private final n broadcastManager;
    private final Session.StatusCallback callback;
    private UUID pendingFacebookDialogCallId;
    private PendingCallStore pendingFacebookDialogCallStore;
    private final BroadcastReceiver receiver;

    public UiLifecycleHelper(Activity paramActivity, Session.StatusCallback paramStatusCallback) {
        if (paramActivity == null) {
            throw new IllegalArgumentException("activity cannot be null");
        }
        this.activity = paramActivity;
        this.callback = paramStatusCallback;
        this.receiver = new UiLifecycleHelper.ActiveSessionBroadcastReceiver(this, null);
        this.broadcastManager = n.a(paramActivity);
        this.pendingFacebookDialogCallStore = PendingCallStore.getInstance();
        Settings.sdkInitialize(paramActivity);
    }

    private void cancelPendingAppCall(FacebookDialog.Callback paramCallback) {
        if (this.pendingFacebookDialogCallId == null) {
        }
        FacebookDialog.PendingCall localPendingCall;
        do {
            return;
            localPendingCall = this.pendingFacebookDialogCallStore.getPendingCallById(this.pendingFacebookDialogCallId);
        } while (localPendingCall == null);
        if (paramCallback != null) {
            Intent localIntent1 = localPendingCall.getRequestIntent();
            Intent localIntent2 = new Intent();
            localIntent2.putExtra("com.facebook.platform.protocol.CALL_ID", localIntent1.getStringExtra("com.facebook.platform.protocol.CALL_ID"));
            localIntent2.putExtra("com.facebook.platform.protocol.PROTOCOL_ACTION", localIntent1.getStringExtra("com.facebook.platform.protocol.PROTOCOL_ACTION"));
            localIntent2.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", localIntent1.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0));
            localIntent2.putExtra("com.facebook.platform.status.ERROR_TYPE", "UnknownError");
            FacebookDialog.handleActivityResult(this.activity, localPendingCall, localPendingCall.getRequestCode(), localIntent2, paramCallback);
        }
        stopTrackingPendingAppCall();
    }

    private boolean handleFacebookDialogActivityResult(int paramInt1, int paramInt2, Intent paramIntent, FacebookDialog.Callback paramCallback) {
        if (this.pendingFacebookDialogCallId == null) {
        }
        FacebookDialog.PendingCall localPendingCall;
        do {
            return false;
            localPendingCall = this.pendingFacebookDialogCallStore.getPendingCallById(this.pendingFacebookDialogCallId);
        } while ((localPendingCall == null) || (localPendingCall.getRequestCode() != paramInt1));
        if (paramIntent == null) {
            cancelPendingAppCall(paramCallback);
            return true;
        }
        UUID localUUID = NativeProtocol.getCallIdFromIntent(paramIntent);
        if ((localUUID != null) && (this.pendingFacebookDialogCallId.equals(localUUID))) {
            FacebookDialog.handleActivityResult(this.activity, localPendingCall, paramInt1, paramIntent, paramCallback);
        }
        for (; ; ) {
            stopTrackingPendingAppCall();
            return true;
            cancelPendingAppCall(paramCallback);
        }
    }

    private void stopTrackingPendingAppCall() {
        this.pendingFacebookDialogCallStore.stopTrackingPendingCall(this.pendingFacebookDialogCallId);
        this.pendingFacebookDialogCallId = null;
    }

    public AppEventsLogger getAppEventsLogger() {
        Session localSession = Session.getActiveSession();
        if (localSession == null) {
            return null;
        }
        if ((this.appEventsLogger == null) || (!this.appEventsLogger.isValidForSession(localSession))) {
            if (this.appEventsLogger != null) {
                AppEventsLogger.onContextStop();
            }
            this.appEventsLogger = AppEventsLogger.newLogger(this.activity, localSession);
        }
        return this.appEventsLogger;
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        onActivityResult(paramInt1, paramInt2, paramIntent, null);
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent, FacebookDialog.Callback paramCallback) {
        Session localSession = Session.getActiveSession();
        if (localSession != null) {
            localSession.onActivityResult(this.activity, paramInt1, paramInt2, paramIntent);
        }
        if (LikeActionController.handleOnActivityResult(this.activity, paramInt1, paramInt2, paramIntent)) {
            return;
        }
        handleFacebookDialogActivityResult(paramInt1, paramInt2, paramIntent, paramCallback);
    }

    public void onCreate(Bundle paramBundle) {
        Object localObject1 = Session.getActiveSession();
        if (localObject1 == null) {
            if (paramBundle != null) {
                localObject1 = Session.restoreSession(this.activity, null, this.callback, paramBundle);
            }
            Object localObject2 = localObject1;
            if (localObject1 == null) {
                localObject2 = new Session(this.activity);
            }
            Session.setActiveSession((Session) localObject2);
        }
        if (paramBundle != null) {
            localObject1 = paramBundle.getString("com.facebook.UiLifecycleHelper.pendingFacebookDialogCallKey");
            if (localObject1 != null) {
                this.pendingFacebookDialogCallId = UUID.fromString((String) localObject1);
            }
            this.pendingFacebookDialogCallStore.restoreFromSavedInstanceState(paramBundle);
        }
    }

    public void onDestroy() {
    }

    public void onPause() {
        this.broadcastManager.a(this.receiver);
        if (this.callback != null) {
            Session localSession = Session.getActiveSession();
            if (localSession != null) {
                localSession.removeCallback(this.callback);
            }
        }
    }

    public void onResume() {
        Object localObject = Session.getActiveSession();
        if (localObject != null) {
            if (this.callback != null) {
                ((Session) localObject).addCallback(this.callback);
            }
            if (SessionState.CREATED_TOKEN_LOADED.equals(((Session) localObject).getState())) {
                ((Session) localObject).openForRead(null);
            }
        }
        localObject = new IntentFilter();
        ((IntentFilter) localObject).addAction("com.facebook.sdk.ACTIVE_SESSION_SET");
        ((IntentFilter) localObject).addAction("com.facebook.sdk.ACTIVE_SESSION_UNSET");
        this.broadcastManager.a(this.receiver, (IntentFilter) localObject);
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        Session.saveSession(Session.getActiveSession(), paramBundle);
        if (this.pendingFacebookDialogCallId != null) {
            paramBundle.putString("com.facebook.UiLifecycleHelper.pendingFacebookDialogCallKey", this.pendingFacebookDialogCallId.toString());
        }
        this.pendingFacebookDialogCallStore.saveInstanceState(paramBundle);
    }

    public void onStop() {
    }

    public void trackPendingDialogCall(FacebookDialog.PendingCall paramPendingCall) {
        if (this.pendingFacebookDialogCallId != null) {
            Log.i("Facebook", "Tracking new app call while one is still pending; canceling pending call.");
            cancelPendingAppCall(null);
        }
        if (paramPendingCall != null) {
            this.pendingFacebookDialogCallId = paramPendingCall.getCallId();
            this.pendingFacebookDialogCallStore.trackPendingCall(paramPendingCall);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/UiLifecycleHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */