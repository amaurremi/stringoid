package com.facebook.widget;

import android.content.Context;
import com.facebook.NativeAppCallAttachmentStore;

import java.util.HashMap;

class FacebookDialog$Builder$1
        implements FacebookDialog.OnPresentCallback {
    FacebookDialog$Builder$1(FacebookDialog.Builder paramBuilder) {
    }

    public void onPresent(Context paramContext) {
        if ((this.this$0.imageAttachments != null) && (this.this$0.imageAttachments.size() > 0)) {
            FacebookDialog.access$900().addAttachmentsForCall(paramContext, this.this$0.appCall.getCallId(), this.this$0.imageAttachments);
        }
        if ((this.this$0.imageAttachmentFiles != null) && (this.this$0.imageAttachmentFiles.size() > 0)) {
            FacebookDialog.access$900().addAttachmentFilesForCall(paramContext, this.this$0.appCall.getCallId(), this.this$0.imageAttachmentFiles);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/FacebookDialog$Builder$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */