package com.quoord.tapatalkpro.action;

import android.app.Activity;
import android.widget.Toast;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.util.TapatalkEngine;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoveAttach
        implements TryTwiceCallBackInterface {
    private TapatalkEngine engine = null;
    private ForumStatus forumStatus;
    private String groupId = null;
    private Activity mContext;

    public RemoveAttach(String paramString1, String paramString2, String paramString3, ArrayList paramArrayList, Activity paramActivity, ForumStatus paramForumStatus, String paramString4) {
        this.engine = new TapatalkEngine(this, paramForumStatus, paramActivity);
        this.forumStatus = paramForumStatus;
        this.mContext = paramActivity;
        try {
            paramArrayList.remove(paramString1);
            paramArrayList = new ArrayList();
            paramArrayList.add(paramString1);
            paramArrayList.add(paramString2);
            paramArrayList.add(paramString3);
            if (paramString4 != null) {
                paramArrayList.add(paramString4);
            }
            this.engine.call("remove_attachment", paramArrayList);
            return;
        } catch (Exception paramArrayList) {
            for (; ; ) {
            }
        }
    }

    public void callBack(EngineResponse paramEngineResponse) {
        if (paramEngineResponse.getMethod().equals("remove_attachment")) {
            try {
                boolean bool = paramEngineResponse.isSuccess();
                HashMap localHashMap = (HashMap) paramEngineResponse.getResponse();
                ((ForumActivityStatus) this.mContext).closeProgress();
                String str1;
                if (bool) {
                    if ((localHashMap.containsKey("result")) && (((Boolean) localHashMap.get("result")).booleanValue())) {
                        if (!localHashMap.containsKey("group_id")) {
                            return;
                        }
                        this.groupId = ((String) localHashMap.get("group_id"));
                        return;
                    }
                    str1 = "";
                    bool = localHashMap.containsKey("result_text");
                    if (!bool) {
                    }
                }
                String str2;
                String str3;
                return;
            } catch (Exception localException1) {
                try {
                    str1 = new String((byte[]) localHashMap.get("result_text"), "UTF-8");
                    new HashMap().put("errormessage", str1);
                    return;
                    localException1 = localException1;
                    localException1.printStackTrace();
                    if (!(paramEngineResponse.getResponse() instanceof String)) {
                        return;
                    }
                    Toast.makeText(this.mContext, paramEngineResponse.getResponse().toString(), 1).show();
                    return;
                } catch (Exception localException2) {
                    for (; ; ) {
                        str2 = new String((byte[]) localHashMap.get("result_text"));
                    }
                }
                str2 = "";
                bool = localHashMap.containsKey("result_text");
                if (bool) {
                }
                try {
                    str2 = new String((byte[]) localHashMap.get("result_text"), "UTF-8");
                    new HashMap().put("errormessage", str2);
                    return;
                } catch (Exception localException3) {
                    for (; ; ) {
                        str3 = new String((byte[]) localHashMap.get("result_text"));
                    }
                }
            }
        }
    }

    public boolean getSaxCall() {
        return false;
    }

    public boolean getTryTwice() {
        return false;
    }

    public boolean isOpCancel() {
        return false;
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void setSaxCall(boolean paramBoolean) {
    }

    public void setTryTwice(boolean paramBoolean) {
    }

    public void tryFailed(String paramString) {
    }

    public void updateSubclassDialog(int paramInt) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/RemoveAttach.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */