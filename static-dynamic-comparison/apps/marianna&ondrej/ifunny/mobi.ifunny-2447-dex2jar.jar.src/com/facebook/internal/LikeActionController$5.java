package com.facebook.internal;

import android.os.Bundle;
import com.facebook.AppEventsLogger;
import com.facebook.LoggingBehavior;
import com.facebook.widget.FacebookDialog.Callback;
import com.facebook.widget.FacebookDialog.PendingCall;

import java.util.UUID;

class LikeActionController$5
        implements FacebookDialog.Callback {
    LikeActionController$5(LikeActionController paramLikeActionController, Bundle paramBundle) {
    }

    public void onComplete(FacebookDialog.PendingCall paramPendingCall, Bundle paramBundle) {
        if (!paramBundle.containsKey("object_is_liked")) {
            return;
        }
        boolean bool = paramBundle.getBoolean("object_is_liked");
        String str1 = paramBundle.getString("like_count_string");
        String str2 = paramBundle.getString("social_sentence");
        String str3 = paramBundle.getString("unlike_token");
        if (this.val$analyticsParameters == null) {
        }
        for (paramBundle = new Bundle(); ; paramBundle = this.val$analyticsParameters) {
            paramBundle.putString("call_id", paramPendingCall.getCallId().toString());
            LikeActionController.access$800(this.this$0).logSdkEvent("fb_like_control_dialog_did_succeed", null, paramBundle);
            LikeActionController.access$900(this.this$0, bool, str1, str1, str2, str2, str3);
            return;
        }
    }

    public void onError(FacebookDialog.PendingCall paramPendingCall, Exception paramException, Bundle paramBundle) {
        Logger.log(LoggingBehavior.REQUESTS, LikeActionController.access$1000(), "Like Dialog failed with error : %s", new Object[]{paramException});
        if (this.val$analyticsParameters == null) {
        }
        for (paramException = new Bundle(); ; paramException = this.val$analyticsParameters) {
            paramException.putString("call_id", paramPendingCall.getCallId().toString());
            LikeActionController.access$1100(this.this$0, "present_dialog", paramException);
            LikeActionController.access$1300(LikeActionController.access$1200(this.this$0), this.this$0, "com.facebook.sdk.LikeActionController.DID_ERROR", paramBundle);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/LikeActionController$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */