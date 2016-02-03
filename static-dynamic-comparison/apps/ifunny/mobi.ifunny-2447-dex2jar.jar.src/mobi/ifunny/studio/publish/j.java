package mobi.ifunny.studio.publish;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;

import java.util.EnumSet;

import mobi.ifunny.profile.l;
import mobi.ifunny.profile.u;
import mobi.ifunny.rest.content.TaskInfo;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Tasks;
import mobi.ifunny.rest.retrofit.RestResponse;
import mobi.ifunny.util.af;

final class j
        extends Handler {
    public j(PublishService paramPublishService, Looper paramLooper) {
        super(paramLooper);
    }

    public void handleMessage(Message paramMessage) {
        int i = paramMessage.arg1;
        int j = paramMessage.arg2;
        paramMessage = IFunnyRestRequest.Tasks.getAsyncProcess(((TaskInfo) paramMessage.obj).id);
        String str;
        if (paramMessage != null) {
            paramMessage = (TaskInfo) paramMessage.data;
            str = paramMessage.state;
            if (TextUtils.equals("pending", str)) {
                PublishService.a(this.a, paramMessage, i, j);
                return;
            }
            if (!TextUtils.equals("success", str)) {
                break label102;
            }
            l.h.add(u.a);
            af.a(this.a, j, true, null);
        }
        for (; ; ) {
            this.a.stopSelf(i);
            return;
            label102:
            if (TextUtils.equals("failure", str)) {
                af.a(this.a, j, false, PublishService.a(this.a, paramMessage.error));
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/publish/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */