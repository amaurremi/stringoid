package com.quoord.tapatalkpro.adapter.forum.conversation;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.adapter.forum.ForumRootAdapter;
import com.quoord.tapatalkpro.bean.Conversation;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.Participant;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.cache.AppCacheManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class ConversationInviteAdapter
        extends ForumRootAdapter {
    public ArrayList UsermDatas = new ArrayList();
    public ArrayList allDatas = new ArrayList();
    Conversation conv;
    String inputTextContent = "";
    private Activity mContext;
    public ArrayList mDatas = new ArrayList();
    ListView name_Listview;
    HashMap<String, String> rawDatas;
    public ArrayList<String> selectedDatas = new ArrayList();
    public ArrayList<String> sourceDatas = new ArrayList();
    private Button submitButton;
    String userNameCacheAddress = "";
    public ArrayList<String> userNameList = new ArrayList();

    public ConversationInviteAdapter(Activity paramActivity, String paramString) {
        super(paramActivity, paramString);
        this.mContext = paramActivity;
        this.forumStatus = this.mStatus.getForumStatus();
    }

    public ConversationInviteAdapter(Activity paramActivity, String paramString, Conversation paramConversation, ListView paramListView, Button paramButton, ParticipatesAdapter paramParticipatesAdapter) {
        super(paramActivity, paramString);
        this.mContext = paramActivity;
        this.forumStatus = this.mStatus.getForumStatus();
        this.conv = paramConversation;
        this.name_Listview = paramListView;
        this.submitButton = paramButton;
        this.userNameCacheAddress = AppCacheManager.getForumUseNameUrl(paramActivity, this.forumStatus.getUrl(), this.forumStatus.tapatalkForum.getLowerUserName());
        paramActivity = AppCacheManager.getCacheData(this.userNameCacheAddress);
        int i;
        if (paramActivity != null) {
            if ((paramActivity instanceof HashMap)) {
                this.rawDatas = ((HashMap) paramActivity);
                paramActivity = this.rawDatas.values().toArray();
                i = 0;
                label187:
                if (i < paramActivity.length) {
                    break label269;
                }
                i = 0;
            }
        }
        for (; ; ) {
            if (i >= paramParticipatesAdapter.mData.size()) {
                paramActivity = new UserNameComparator(null);
                Collections.sort(this.sourceDatas, paramActivity);
                this.mDatas.addAll(this.sourceDatas);
                return;
                this.rawDatas = new HashMap();
                break;
                this.rawDatas = new HashMap();
                break;
                label269:
                if ((paramActivity[i] instanceof String)) {
                    this.sourceDatas.add((String) paramActivity[i]);
                }
                i += 1;
                break label187;
            }
            if (this.sourceDatas.contains(((Participant) paramParticipatesAdapter.mData.get(i)).getUserName())) {
                this.sourceDatas.remove(((Participant) paramParticipatesAdapter.mData.get(i)).getUserName());
            }
            i += 1;
        }
    }

    public int getCount() {
        return this.mDatas.size();
    }

    public Object getItem(int paramInt) {
        return this.mDatas.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup) {
        if ((paramView == null) || (paramView.getTag() == null)) {
            paramViewGroup = new ConvViewHolder();
            paramView = LayoutInflater.from(this.mContext).inflate(2130903230, null);
            paramViewGroup.checkbox = ((CheckBox) paramView.findViewById(2131231292));
        }
        for (; ; ) {
            if (this.mDatas != null) {
                paramViewGroup.checkbox.setText(this.mDatas.get(paramInt).toString());
                if (this.userNameList.contains(this.mDatas.get(paramInt).toString())) {
                    paramViewGroup.checkbox.setChecked(true);
                }
                paramViewGroup.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean) {
                        String str = (String) ConversationInviteAdapter.this.mDatas.get(paramInt);
                        if (paramAnonymousBoolean) {
                            ConversationInviteAdapter.this.submitButton.setEnabled(true);
                            paramAnonymousCompoundButton.setChecked(true);
                            ConversationInviteAdapter.this.userNameList.add(str);
                            ConversationInviteAdapter.this.userNameList.iterator();
                            return;
                        }
                        paramAnonymousCompoundButton.setChecked(false);
                        ConversationInviteAdapter.this.userNameList.remove(str);
                    }
                });
            }
            return paramView;
            paramViewGroup = (ConvViewHolder) paramView.getTag();
        }
    }

    public void parseCallBack(EngineResponse paramEngineResponse) {
    }

    public void refresh() {
    }

    public static class ConvViewHolder {
        CheckBox checkbox;
    }

    private class UserNameComparator
            implements Comparator<String> {
        private UserNameComparator() {
        }

        public int compare(String paramString1, String paramString2) {
            return paramString1.compareTo(paramString2);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/conversation/ConversationInviteAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */