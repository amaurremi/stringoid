package com.quoord.tapatalkpro.bean;

import android.app.Activity;
import android.util.Log;

import java.io.Serializable;

public class TopicController
        implements Serializable {
    private int countPerPage = 10;
    private Activity mContext;
    private Topic mTopic;
    private boolean needNotifyDataSetChanged = false;
    private int total_post_num = 0;

    public TopicController(Topic paramTopic, Activity paramActivity) {
        this.mTopic = paramTopic;
        this.mContext = paramActivity;
    }

    public int getCountPerPage() {
        return this.countPerPage;
    }

    public int getPageNum() {
        int i = this.total_post_num;
        int j = this.countPerPage;
        if (i / j > i / j) {
            return i / j + 1;
        }
        return i / j;
    }

    public String[] getPageView() {
        long l = System.currentTimeMillis();
        String[] arrayOfString = new String[getPageNum()];
        int i = 0;
        if (i >= getPageNum()) {
            Log.d("pageview", System.currentTimeMillis() - l);
            return arrayOfString;
        }
        if (i == getPageNum() - 1) {
            arrayOfString[i] = (this.mContext.getString(2131100256) + " " + (i + 1) + " (" + (getCountPerPage() * i + 1) + "-" + getTotal_post_num() + ")");
        }
        for (; ; ) {
            i += 1;
            break;
            arrayOfString[i] = (this.mContext.getString(2131100256) + " " + (i + 1) + " (" + (getCountPerPage() * i + 1) + "-" + (i + 1) * getCountPerPage() + ")");
        }
    }

    public int getTotal_post_num() {
        return this.total_post_num;
    }

    public boolean isFootNeeded() {
        return this.countPerPage < this.total_post_num;
    }

    public boolean isNeedNotifyDataSetChanged() {
        return this.needNotifyDataSetChanged;
    }

    public void setCountPerPage(int paramInt) {
        this.countPerPage = paramInt;
    }

    public void setNeedNotifyDataSetChanged(boolean paramBoolean) {
        this.needNotifyDataSetChanged = paramBoolean;
    }

    public void setTotal_post_num(int paramInt) {
        if (paramInt != this.total_post_num) {
            this.needNotifyDataSetChanged = true;
        }
        this.total_post_num = paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/TopicController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */