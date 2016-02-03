package com.quoord.tapatalkpro.adapter.forum;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.bean.BaseBean;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.NoPMView;
import com.quoord.tapatalkpro.bean.PrivateMessage;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.saxparser.PMSaxParser;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.Util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

public class NewPMAdapter
        extends ForumRootAdapter {
    private Activity mContext = null;
    private ArrayList<BaseBean> mDatas = new ArrayList();
    String mMstTo = "";
    protected PMSaxParser mPMParser;
    String mTitle = "";

    public NewPMAdapter(Activity paramActivity, String paramString) {
        super(paramActivity, paramString);
        this.mContext = paramActivity;
    }

    public void CreateNewPm(ArrayList paramArrayList) {
        setTryTwice(false);
        this.engine.call("create_message", paramArrayList);
    }

    public void clearAll() {
        notifyDataSetChanged();
    }

    public int getCount() {
        return 0;
    }

    public Object getItem(int paramInt) {
        return this.mDatas.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return 0L;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        return ((NoPMView) getItem(paramInt)).getItemView(this.mContext);
    }

    public void parseCallBack(EngineResponse paramEngineResponse) {
        if (paramEngineResponse.getMethod().equalsIgnoreCase("create_message")) {
        }
        try {
            if ((paramEngineResponse.getResponse() instanceof HashMap)) {
                Object localObject = (HashMap) paramEngineResponse.getResponse();
                if ((!this.forumStatus.isPush()) && (!this.mContext.getApplicationContext().getResources().getBoolean(2131558401))) {
                    localObject = TapatalkJsonEngine.NEW_PM + "?" + "fid=" + this.forumStatus.getForumId() + "&device_id=" + Util.getMD5(Util.getMacAddress(this.mContext)) + "&author=" + URLEncoder.encode(this.forumStatus.tapatalkForum.getUserName(), "utf-8") + "&author_id=" + this.forumStatus.tapatalkForum.getUserId() + "&mid=" + ((HashMap) localObject).get("msg_id") + "&title=" + this.mTitle + "&unames=" + this.mMstTo;
                    TapatalkJsonEngine.callLogin(this.mContext, (String) localObject);
                }
            }
            ((ForumActivityStatus) this.mContext).updateUI(24, paramEngineResponse.getResponse());
            return;
        } catch (Exception localException) {
            for (; ; ) {
                localException.printStackTrace();
            }
        }
    }

    public void refresh() {
    }

    public void removeItem(int paramInt) {
        notifyDataSetChanged();
    }

    public void submit(String paramString1, String paramString2, String paramString3, int paramInt, PrivateMessage paramPrivateMessage) {
        if (paramString1.length() == 0) {
            Toast.makeText(this.mContext, this.mContext.getString(2131099777), 1).show();
            return;
        }
        if (paramString2.length() == 0) {
            Toast.makeText(this.mContext, this.mContext.getString(2131099778), 1).show();
            return;
        }
        if (paramString3.length() == 0) {
            Toast.makeText(this.mContext, this.mContext.getString(2131099779), 1).show();
            return;
        }
        this.mTitle = paramString2;
        ArrayList localArrayList = new ArrayList();
        String[] arrayOfString = paramString3.split(";");
        this.mMstTo = paramString3;
        paramString3 = new Object[arrayOfString.length];
        int i = 0;
        for (; ; ) {
            if (i >= arrayOfString.length) {
                localArrayList.add(paramString3);
            }
            try {
                paramString3 = paramString1.getBytes("UTF-8");
                paramString1 = paramString3;
            } catch (UnsupportedEncodingException paramString3) {
                for (; ; ) {
                    label156:
                    paramString1 = paramString1.getBytes();
                }
            }
            try {
                paramString3 = paramString2.getBytes("UTF-8");
                paramString2 = paramString3;
            } catch (UnsupportedEncodingException paramString3) {
                paramString2 = paramString2.getBytes();
                break label156;
            }
            localArrayList.add(paramString2);
            localArrayList.add(paramString1);
            if (paramPrivateMessage != null) {
                localArrayList.add(Integer.valueOf(paramInt));
                localArrayList.add(paramPrivateMessage.getMsgId());
            }
            CreateNewPm(localArrayList);
            this.mContext.showDialog(0);
            return;
            paramString3[i] = arrayOfString[i].getBytes();
            i += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/NewPMAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */