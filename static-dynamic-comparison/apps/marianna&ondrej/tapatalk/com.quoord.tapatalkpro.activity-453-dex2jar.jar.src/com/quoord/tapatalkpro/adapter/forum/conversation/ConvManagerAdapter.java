package com.quoord.tapatalkpro.adapter.forum.conversation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.quoord.tapatalkpro.activity.forum.conversation.CreateOrReplyConversationActivity;
import com.quoord.tapatalkpro.adapter.forum.ForumRootAdapter;
import com.quoord.tapatalkpro.bean.Conversation;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.Util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ConvManagerAdapter
        extends ForumRootAdapter {
    Conversation conv;
    CreateOrReplyConversationActivity mActivity;
    private ArrayList<String> userIds;

    public ConvManagerAdapter(Activity paramActivity, String paramString) {
        super(paramActivity, paramString);
        this.mActivity = ((CreateOrReplyConversationActivity) paramActivity);
    }

    public void CreateNewConversation(ArrayList paramArrayList) {
        this.engine.call("new_conversation", paramArrayList);
    }

    public void ReplyConversation(ArrayList paramArrayList, Conversation paramConversation) {
        this.userIds = new ArrayList();
        this.conv = paramConversation;
        paramConversation = paramConversation.partcipated.keySet().iterator();
        for (; ; ) {
            if (!paramConversation.hasNext()) {
                this.engine.call("reply_conversation", paramArrayList);
                return;
            }
            String str = (String) paramConversation.next();
            if (!str.equalsIgnoreCase(this.forumStatus.getUserId())) {
                this.userIds.add(str);
            }
        }
    }

    public int getCount() {
        return 0;
    }

    public Object getItem(int paramInt) {
        return null;
    }

    public long getItemId(int paramInt) {
        return 0L;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        return null;
    }

    public void parseCallBack(EngineResponse paramEngineResponse) {
        Object localObject = paramEngineResponse.getMethod();
        if (((String) localObject).equals("new_conversation")) {
            localObject = (Boolean) ((HashMap) paramEngineResponse.getResponse()).get("result");
        }
        try {
            this.mActivity.dismissDialog(0);
            HashMap localHashMap2;
            int i;
            ArrayList localArrayList;
            HashMap localHashMap1;
            if (((Boolean) localObject).booleanValue()) {
                Toast.makeText(this.mActivity, this.mActivity.getString(2131100166), 1).show();
                ((InputMethodManager) this.mActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.mActivity.getCurrentFocus().getWindowToken(), 2);
                localHashMap2 = (HashMap) paramEngineResponse.getResponse();
                if ((!this.forumStatus.isPush()) && (!this.mActivity.getApplicationContext().getResources().getBoolean(2131558401)) && (localHashMap2.containsKey("conv_id"))) {
                    localObject = null;
                    paramEngineResponse = null;
                    if (localHashMap2.containsKey("uids")) {
                        localObject = (ArrayList) localHashMap2.get("uids");
                        i = 0;
                        if (i < ((ArrayList) localObject).size()) {
                            break label473;
                        }
                        localObject = paramEngineResponse;
                    }
                    localArrayList = null;
                    localHashMap1 = null;
                    paramEngineResponse = localArrayList;
                    if (localHashMap2.containsKey("unames")) {
                        paramEngineResponse = localArrayList;
                        if (localHashMap2.containsKey("unames")) {
                            localArrayList = (ArrayList) localHashMap2.get("unames");
                            i = 0;
                            paramEngineResponse = localHashMap1;
                            if (i < localArrayList.size()) {
                                break label534;
                            }
                        }
                    }
                }
            }
            try {
                localObject = TapatalkJsonEngine.LOG_CONV + "?" + "fid=" + this.forumStatus.getForumId() + "&device_id=" + Util.getMD5(Util.getMacAddress(this.mActivity)) + "&author=" + URLEncoder.encode(this.forumStatus.tapatalkForum.getUserName(), "utf-8") + "&author_id=" + this.forumStatus.getUserId() + "&cid=" + localHashMap2.get("conv_id") + "&position=" + localHashMap2.get("position") + "&uids=" + (String) localObject + "&unames=" + paramEngineResponse;
                paramEngineResponse = (EngineResponse) localObject;
                if (localHashMap2.get("title") != null) {
                    paramEngineResponse = localObject + "&title=" + URLEncoder.encode((String) localHashMap2.get("title"));
                }
                TapatalkJsonEngine.callLogin(this.mActivity, paramEngineResponse);
            } catch (UnsupportedEncodingException paramEngineResponse) {
                for (; ; ) {
                    paramEngineResponse.printStackTrace();
                }
            }
            paramEngineResponse = new Intent(this.mActivity, SlidingMenuActivity.class);
            this.mActivity.setResult(26, paramEngineResponse);
            this.mActivity.finish();
            for (; ; ) {
                return;
                label473:
                if (((ArrayList) localObject).equals("")) {
                }
                for (paramEngineResponse = (String) ((ArrayList) localObject).get(i); ; paramEngineResponse = paramEngineResponse + "," + (String) ((ArrayList) localObject).get(i)) {
                    i += 1;
                    break;
                }
                label534:
                if (localArrayList.equals("")) {
                }
                for (paramEngineResponse = (String) localArrayList.get(i); ; paramEngineResponse = paramEngineResponse + "," + (String) localArrayList.get(i)) {
                    i += 1;
                    break;
                }
                if (!((String) localObject).equals("reply_conversation")) {
                    continue;
                }
                localHashMap1 = (HashMap) paramEngineResponse.getResponse();
                localObject = (Boolean) localHashMap1.get("result");
                try {
                    new String((byte[]) localHashMap1.get("result_text"), "UTF-8");
                } catch (Exception localException1) {
                    try {
                        for (; ; ) {
                            this.mActivity.dismissDialog(0);
                            if (!((Boolean) localObject).booleanValue()) {
                                break;
                            }
                            localHashMap2 = (HashMap) paramEngineResponse.getResponse();
                            if ((!this.forumStatus.isPush()) && (!this.mActivity.getApplicationContext().getResources().getBoolean(2131558401))) {
                                new HashMap();
                                if (((Boolean) localHashMap2.get("result")).booleanValue()) {
                                    paramEngineResponse = "";
                                    localObject = paramEngineResponse;
                                    if (localHashMap2.containsKey("uids")) {
                                        localObject = (ArrayList) localHashMap2.get("uids");
                                        i = 0;
                                        if (i < ((ArrayList) localObject).size()) {
                                            break label1099;
                                        }
                                        localObject = paramEngineResponse;
                                    }
                                    localArrayList = null;
                                    localHashMap1 = null;
                                    paramEngineResponse = localArrayList;
                                    if (localHashMap2.containsKey("unames")) {
                                        paramEngineResponse = localArrayList;
                                        if (localHashMap2.containsKey("unames")) {
                                            localArrayList = (ArrayList) localHashMap2.get("unames");
                                            i = 0;
                                            paramEngineResponse = localHashMap1;
                                            if (i < localArrayList.size()) {
                                                break label1160;
                                            }
                                        }
                                    }
                                }
                            }
                            try {
                                localObject = TapatalkJsonEngine.LOG_CONV + "?" + "fid=" + this.forumStatus.getForumId() + "&device_id=" + Util.getMD5(Util.getMacAddress(this.mActivity)) + "&author=" + URLEncoder.encode(this.forumStatus.tapatalkForum.getUserName(), "utf-8") + "&author_id=" + this.forumStatus.getUserId() + "&cid=" + localHashMap2.get("conv_id") + "&position=" + localHashMap2.get("position") + "&uids=" + (String) localObject + "&unames=" + paramEngineResponse;
                                paramEngineResponse = (EngineResponse) localObject;
                                if (localHashMap2.get("title") != null) {
                                    paramEngineResponse = localObject + "&title=" + URLEncoder.encode((String) localHashMap2.get("title"));
                                }
                                TapatalkJsonEngine.callLogin(this.mActivity, paramEngineResponse);
                            } catch (UnsupportedEncodingException paramEngineResponse) {
                                for (; ; ) {
                                    paramEngineResponse.printStackTrace();
                                }
                            }
                            ((InputMethodManager) this.mActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.mActivity.getCurrentFocus().getWindowToken(), 2);
                            paramEngineResponse = this.mActivity.getIntent();
                            this.mActivity.setResult(27, paramEngineResponse);
                            this.mActivity.finish();
                            return;
                            localException1 = localException1;
                            localException1.printStackTrace();
                        }
                        label1099:
                        if (((ArrayList) localObject).equals("")) {
                        }
                        for (paramEngineResponse = (String) ((ArrayList) localObject).get(i); ; paramEngineResponse = paramEngineResponse + "," + (String) ((ArrayList) localObject).get(i)) {
                            i += 1;
                            break;
                        }
                        label1160:
                        if (localArrayList.equals("")) {
                        }
                        for (paramEngineResponse = (String) localArrayList.get(i); ; paramEngineResponse = paramEngineResponse + "," + (String) localArrayList.get(i)) {
                            i += 1;
                            break;
                        }
                    } catch (Exception localException2) {
                        for (; ; ) {
                        }
                    }
                }
            }
        } catch (Exception localException3) {
            for (; ; ) {
            }
        }
    }

    public void refresh() {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/conversation/ConvManagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */