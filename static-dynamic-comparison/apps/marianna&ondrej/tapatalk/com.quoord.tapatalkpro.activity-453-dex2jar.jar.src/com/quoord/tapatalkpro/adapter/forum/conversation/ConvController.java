package com.quoord.tapatalkpro.adapter.forum.conversation;

import android.app.Activity;
import com.quoord.tapatalkpro.bean.Conversation;

import java.io.Serializable;

public class ConvController
        implements Serializable {
    private Conversation conv;
    private int countPerPage = 10;
    private Activity mContext;
    private boolean needNotifyDataSetChanged = false;
    private int total_post_num = 0;

    public ConvController(Conversation paramConversation, Activity paramActivity) {
        this.conv = paramConversation;
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
        String[] arrayOfString = new String[getPageNum()];
        int i = 0;
        if (i >= getPageNum()) {
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/conversation/ConvController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */