package com.quoord.tapatalkpro.adapter.forum.conversation;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.quoord.tapatalkpro.activity.forum.conversation.ConversationOuterFragment;
import com.quoord.tapatalkpro.activity.forum.conversation.CreateOrReplyConversationActivity;
import com.quoord.tapatalkpro.activity.forum.conversation.ParticipatesFragment;
import com.quoord.tapatalkpro.activity.forum.conversation.TabConvDetailFragment;
import com.quoord.tapatalkpro.adapter.forum.ForumRootAdapter;
import com.quoord.tapatalkpro.adapter.forum.IItemView;
import com.quoord.tapatalkpro.bean.Conversation;
import com.quoord.tapatalkpro.bean.ConversationData;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.ImageInThread;
import com.quoord.tapatalkpro.bean.Participant;
import com.quoord.tapatalkpro.bean.PostData;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.ui.CustomImageViewLayout;
import com.quoord.tapatalkpro.util.BBcodeUtil;
import com.quoord.tapatalkpro.util.TapatalkEngine;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ConvDetailAdapter
        extends ForumRootAdapter
        implements Serializable {
    private boolean IS_QUOTE = false;
    public boolean canClose;
    public boolean can_invite = false;
    public boolean can_upload = false;
    private Conversation conv;
    private ConvHeaderView convHeaderView;
    private ConversationOuterFragment convOuterFragment;
    public String conv_id = "";
    public ArrayList<String> converId = new ArrayList();
    public int currentIndex;
    public int currentScrollState;
    private int end = 0;
    public ArrayList<ImageInThread> images = new ArrayList();
    private boolean inRelease = false;
    public boolean inviteConv = true;
    public boolean isClose;
    private boolean isFirstTag;
    int jumpPage;
    int jumpPosition;
    private ArrayList<Participant> list = new ArrayList();
    private ListView listView;
    Activity mContext;
    public ArrayList<Object> mDatas = new ArrayList();
    private TabConvDetailFragment mFragment;
    AlertDialog pageListDialog;
    public ArrayList<String> partiNameList = new ArrayList();
    HashMap<String, Participant> parts = new HashMap();
    public ProgressDialog progress = null;
    public HashMap raw_parts;
    private boolean shouldJump;
    private int start = 0;
    private String title = "";
    HashMap titleImgHash = new HashMap();
    public int totalCount;
    public int totalPage = 1;
    private String userNameCacheAddress;
    private HashMap<String, String> userNameList;

    public ConvDetailAdapter(String paramString, Conversation paramConversation, ConversationOuterFragment paramConversationOuterFragment, TabConvDetailFragment paramTabConvDetailFragment, boolean paramBoolean, int paramInt) {
        super(paramConversationOuterFragment.mActivity, paramConversationOuterFragment, paramString);
        this.mContext = paramConversationOuterFragment.getActivity();
        this.conv = paramConversation;
        this.conv_id = this.conv.getConv_id();
        this.convOuterFragment = paramConversationOuterFragment;
        this.mFragment = paramTabConvDetailFragment;
        this.isFirstTag = paramBoolean;
        this.progress = new ProgressDialog(this.mContext);
        this.progress.setMessage(this.mContext.getResources().getString(2131099873));
        this.userNameCacheAddress = AppCacheManager.getForumUseNameUrl(paramConversationOuterFragment.mActivity, this.forumStatus.getUrl(), this.forumStatus.tapatalkForum.getLowerUserName());
        paramString = AppCacheManager.getCacheData(this.userNameCacheAddress);
        this.convHeaderView = new ConvHeaderView();
        if (paramString == null) {
            this.userNameList = new HashMap();
        }
        for (; ; ) {
            if ((this.isFirstTag) || (paramInt == this.convOuterFragment.getCurrentPageNum())) {
                getConversationDetail(paramInt);
            }
            return;
            if ((paramString instanceof HashMap)) {
                this.userNameList = ((HashMap) paramString);
            } else {
                this.userNameList = new HashMap();
            }
        }
    }

    public void actionQuote(String paramString1, String paramString2) {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramString1);
        localArrayList.add(paramString2);
        this.engine.call("get_quote_conversation", localArrayList);
        this.mContext.showDialog(0);
    }

    public void checkImages() {
        if (this.inRelease) {
            return;
        }
        this.inRelease = true;
        int i = 0;
        for (; ; ) {
            if (i >= this.mDatas.size()) {
                this.inRelease = false;
                return;
            }
            try {
                if ((this.mDatas.get(i) instanceof ConversationData)) {
                    recycleImage(((PostData) this.mDatas.get(i)).mBeansFinished);
                }
                i += 1;
            } catch (Exception localException) {
                for (; ; ) {
                }
            }
        }
    }

    public void destroy() {
        int i = 0;
        for (; ; ) {
            if (i >= this.mDatas.size()) {
                this.mDatas.clear();
                return;
            }
            if ((this.mDatas.get(i) instanceof ConversationData)) {
                ((ConversationData) this.mDatas.get(i)).destory();
            }
            i += 1;
        }
    }

    public ConversationOuterFragment getConvOuterFragment() {
        return this.convOuterFragment;
    }

    public ConversationData getConversation(int paramInt) {
        return (ConversationData) this.mDatas.get(paramInt);
    }

    public void getConversationDetail(int paramInt) {
        setTryTwice(false);
        this.mDatas.clear();
        if (this.convOuterFragment.mConvController.getPageNum() > 1) {
            this.mDatas.add(this.convHeaderView);
            if ((this.mFragment.progress != null) && (this.mFragment.progress.getVisibility() == 0)) {
                this.mFragment.progress.setVisibility(8);
            }
        }
        ArrayList localArrayList = new ArrayList();
        this.start = (this.convOuterFragment.mConvController.getCountPerPage() * paramInt);
        this.end = ((paramInt + 1) * this.convOuterFragment.mConvController.getCountPerPage() - 1);
        localArrayList.add(this.conv_id);
        localArrayList.add(Integer.valueOf(this.start));
        localArrayList.add(Integer.valueOf(this.end));
        if (this.forumStatus.isSupprotBBcode()) {
            localArrayList.add(Boolean.valueOf(true));
        }
        this.engine.call("get_conversation", localArrayList);
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

    public int getItemViewType(int paramInt) {
        Object localObject = this.mDatas.get(paramInt);
        if ((getItem(paramInt) instanceof ConversationData)) {
            if (((ConversationData) localObject).getParticipant() == null) {
                return 0;
            }
            if ((((ConversationData) localObject).getParticipant().getUserName().equalsIgnoreCase(this.forumStatus.tapatalkForum.getUserName())) || (((ConversationData) localObject).getParticipant().getUserName().equals(this.forumStatus.tapatalkForum.getDisplayName()))) {
                return 1;
            }
            return 2;
        }
        if ((getItem(paramInt) instanceof ConvHeaderView)) {
            return 3;
        }
        return 4;
    }

    public String[] getPageNum() {
        String[] arrayOfString = new String[this.totalPage];
        int i = arrayOfString.length;
        i = 0;
        if (i >= this.totalPage) {
            return arrayOfString;
        }
        if (i == this.totalPage) {
            arrayOfString[i] = (this.convOuterFragment.mConvController.getCountPerPage() * i + 1 + "-" + this.totalCount);
        }
        for (; ; ) {
            i += 1;
            break;
            arrayOfString[i] = (this.convOuterFragment.mConvController.getCountPerPage() * i + 1 + "-" + (i + 1) * this.convOuterFragment.mConvController.getCountPerPage());
        }
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        Object localObject = this.mDatas.get(paramInt);
        paramViewGroup = null;
        if ((localObject instanceof ConversationData)) {
            if (((ConversationData) localObject).getParticipant() == null) {
                paramViewGroup = new Participant();
                paramViewGroup.setIcon(null);
                paramViewGroup.setIcon_url(null);
                paramViewGroup.setUserName(this.mContext.getResources().getString(2131100483));
                ((ConversationData) localObject).setParticipant(paramViewGroup);
                paramView = ((ConversationData) localObject).getConversationView(this.forumStatus, paramInt, this, paramView, this.convOuterFragment);
            }
        }
        for (; ; ) {
            return paramView;
            if ((((ConversationData) localObject).getParticipant().getUserName().equalsIgnoreCase(this.forumStatus.tapatalkForum.getUserName())) || (((ConversationData) localObject).getParticipant().getUserName().equals(this.forumStatus.tapatalkForum.getDisplayName()))) {
                paramView = ((ConversationData) localObject).getConversationView(this.forumStatus, paramInt, this, paramView, this.convOuterFragment, true);
            } else {
                paramView = ((ConversationData) localObject).getConversationView(this.forumStatus, paramInt, this, paramView, this.convOuterFragment);
                continue;
                if ((this.mDatas.get(paramInt) instanceof ConvHeaderView)) {
                    paramView = ConvHeaderView.getHeaderView(this.convOuterFragment, this.mFragment.getCurrentPage());
                    paramViewGroup = (LinearLayout) paramView.findViewById(2131230848);
                    if (getCount() > 1) {
                        paramViewGroup.setVisibility(8);
                    }
                    for (; ; ) {
                        return paramView;
                        paramViewGroup.setVisibility(0);
                    }
                }
                paramView = paramViewGroup;
                if ((localObject instanceof IItemView)) {
                    paramView = ((IItemView) localObject).getItemView();
                }
            }
        }
    }

    public int getViewTypeCount() {
        return 5;
    }

    public boolean isShouldJump() {
        return this.shouldJump;
    }

    public void parseCallBack(EngineResponse paramEngineResponse) {
        String str1 = paramEngineResponse.getMethod();
        if (str1.equals("get_conversation")) {
        }
        try {
            this.mContext.dismissDialog(0);
            if (this.convOuterFragment.convFragment.ad != null) {
                this.convOuterFragment.convFragment.ad.dismiss();
            }
            this.mDatas.clear();
            if (this.mFragment.progress != null) {
                this.mFragment.progress.setVisibility(8);
            }
            Object localObject2 = (HashMap) paramEngineResponse.getResponse();
            String str2 = (String) ((HashMap) localObject2).get("conv_id");
            if (((HashMap) localObject2).containsKey("can_invite")) {
                this.can_invite = ((Boolean) ((HashMap) localObject2).get("can_invite")).booleanValue();
            }
            if (((HashMap) localObject2).containsKey("can_close")) {
                this.canClose = ((Boolean) ((HashMap) localObject2).get("can_close")).booleanValue();
            }
            if (((HashMap) localObject2).containsKey("can_upload")) {
                this.can_upload = ((Boolean) ((HashMap) localObject2).get("can_upload")).booleanValue();
                if (this.forumStatus != null) {
                    this.forumStatus.setCan_upload_attachment_conv(this.can_upload);
                }
            }
            if (((HashMap) localObject2).containsKey("is_closed")) {
                this.isClose = ((Boolean) ((HashMap) localObject2).get("is_closed")).booleanValue();
            }
            try {
                if (((HashMap) localObject2).containsKey("conv_title")) {
                    this.title = new String((byte[]) ((HashMap) localObject2).get("conv_title"), "UTF-8");
                    this.mContext.getActionBar().setTitle(this.title);
                }
                localObject1 = null;
                if (((HashMap) localObject2).containsKey("list")) {
                    localObject1 = (Object[]) ((HashMap) localObject2).get("list");
                }
                if (((HashMap) localObject2).containsKey("participants")) {
                    this.raw_parts = ((HashMap) ((HashMap) localObject2).get("participants"));
                }
                if (((HashMap) localObject2).containsKey("total_message_num")) {
                    this.totalCount = Integer.parseInt(String.valueOf(((HashMap) localObject2).get("total_message_num")));
                }
                if (this.totalCount % this.convOuterFragment.mConvController.getCountPerPage() == 0) {
                    this.totalPage = (this.totalCount / this.convOuterFragment.mConvController.getCountPerPage());
                    this.convOuterFragment.mConvController.setTotal_post_num(this.totalCount);
                    if ((this.totalPage <= 1) || (this.mDatas.contains(this.convHeaderView))) {
                        break label988;
                    }
                    this.mDatas.add(this.convHeaderView);
                    if ((this.raw_parts != null) && (this.raw_parts.size() > 0)) {
                        localObject2 = this.raw_parts.keySet().iterator();
                        if (((Iterator) localObject2).hasNext()) {
                            break label1003;
                        }
                        this.convOuterFragment.setConvMembers(this.parts);
                    }
                    if ((localObject1 != null) && (localObject1.length > 0)) {
                        i = 0;
                        if (i < localObject1.length) {
                            break label1143;
                        }
                    }
                    this.shouldJump = true;
                    if (this.isFirstTag) {
                        if ((this.shouldJump) && (this.convOuterFragment.mConvController != null)) {
                            this.jumpPosition = ((this.convOuterFragment.mConvController.getTotal_post_num() - this.conv.getUnread_num()) % this.convOuterFragment.mConvController.getCountPerPage());
                            this.jumpPage = ((this.convOuterFragment.mConvController.getTotal_post_num() - this.conv.getUnread_num()) / this.convOuterFragment.mConvController.getCountPerPage());
                        }
                        this.convOuterFragment.mConvController.getPageNum();
                        if (this.jumpPosition == 0) {
                            this.jumpPosition = 1;
                            this.jumpPage -= 1;
                        }
                        this.convOuterFragment.setConvPagerAdapterAndPosition(this.jumpPage, this.mFragment, this.jumpPage, this.jumpPosition, this.isFirstTag);
                        this.isFirstTag = false;
                    }
                    if ((this.mFragment.detailFragment_CurrentPage == this.convOuterFragment.getJumpPage()) && (this.mFragment.listview != null)) {
                        new Handler().postDelayed(new Runnable() {
                            public void run() {
                                ConvDetailAdapter.this.mFragment.listview.setSelection(ConvDetailAdapter.this.convOuterFragment.getJumpToPosition());
                            }
                        }, 500L);
                        this.shouldJump = false;
                    }
                    AppCacheManager.cacheData(this.userNameCacheAddress, this.userNameList);
                    notifyDataSetChanged();
                    this.convOuterFragment.pagerAdapter.notifyDataSetChanged();
                    if (this.shouldJump) {
                        new Handler().postDelayed(new Runnable() {
                            public void run() {
                                int i = 1;
                                try {
                                    if ((ConvDetailAdapter.this.convOuterFragment.convFragment != null) && (ConvDetailAdapter.this.convOuterFragment.convFragment.listview != null)) {
                                        ListView localListView = ConvDetailAdapter.this.convOuterFragment.convFragment.listview;
                                        int j = ConvDetailAdapter.this.mDatas.size();
                                        if (ConvDetailAdapter.this.totalPage > 1) {
                                            i = 2;
                                        }
                                        localListView.setSelection(j - i);
                                    }
                                    return;
                                } catch (Exception localException) {
                                    localException.printStackTrace();
                                }
                            }
                        }, 100L);
                    }
                    this.shouldJump = false;
                    this.progress.dismiss();
                    if (this.convOuterFragment.particiFragment != null) {
                        this.convOuterFragment.particiFragment.getParticipates();
                    }
                    if (str1.equals("get_quote_conversation")) {
                        paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
                        localObject1 = "";
                    }
                }
            } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
                for (; ; ) {
                    try {
                        paramEngineResponse = new String((byte[]) paramEngineResponse.get("text_body"), "UTF-8");
                    } catch (Exception localException4) {
                        Object localObject1;
                        int i;
                        label988:
                        label1003:
                        String str3;
                        HashMap localHashMap;
                        Participant localParticipant;
                        label1143:
                        paramEngineResponse = localUnsupportedEncodingException;
                        Exception localException1 = localException4;
                        localException1.printStackTrace();
                        continue;
                    }
                    try {
                        this.mContext.dismissDialog(0);
                        localObject1 = new Intent(this.mContext, CreateOrReplyConversationActivity.class);
                        this.IS_QUOTE = true;
                        ((Intent) localObject1).putExtra("is_quote", this.IS_QUOTE);
                        ((Intent) localObject1).putExtra("text_body", paramEngineResponse);
                        ((Intent) localObject1).putExtra("conv_id", this.conv_id);
                        ((Intent) localObject1).putExtra("conv", this.conv);
                        ((Intent) localObject1).putExtra("forumStatus", this.forumStatus);
                        this.mContext.startActivity((Intent) localObject1);
                        return;
                    } catch (Exception localException2) {
                        continue;
                    }
                    localUnsupportedEncodingException = localUnsupportedEncodingException;
                    localUnsupportedEncodingException.printStackTrace();
                    continue;
                    this.totalPage = (this.totalCount / this.convOuterFragment.mConvController.getCountPerPage() + 1);
                    continue;
                    this.mDatas.remove(this.convHeaderView);
                    continue;
                    str3 = (String) ((Iterator) localObject2).next();
                    localHashMap = (HashMap) this.raw_parts.get(str3);
                    localParticipant = new Participant();
                    localParticipant.setUserId(str3);
                    localParticipant.setUserName(new String((byte[]) localHashMap.get("username")));
                    this.partiNameList.add(new String((byte[]) localHashMap.get("username")));
                    localParticipant.setIcon_url((String) localHashMap.get("icon_url"));
                    this.titleImgHash.put(localParticipant.getUserName(), localParticipant.getIcon_url());
                    this.parts.put(str3, localParticipant);
                    continue;
                    localObject2 = (HashMap) localUnsupportedEncodingException[i];
                    localObject2 = ConversationData.getConversation((HashMap) localObject2, (Participant) this.parts.get((String) ((HashMap) localObject2).get("msg_author_id")), str2, this.mContext, this);
                    if ((this.inviteConv) && (!this.converId.contains(((ConversationData) localObject2).getMsg_id()))) {
                        this.converId.add(((ConversationData) localObject2).getMsg_id());
                        this.mDatas.add(localObject2);
                    }
                    this.inviteConv = true;
                    ((ConversationData) localObject2).posts = BBcodeUtil.process(((ConversationData) localObject2).getMsg_content(), this.forumStatus, true, this.forumStatus.isSupprotBBcode(), false, 0);
                    if ((((ConversationData) localObject2).getParticipant() != null) && (((ConversationData) localObject2).getParticipant().getUserName() != null) && (((ConversationData) localObject2).getParticipant().getUserName().length() > 0)) {
                        this.userNameList.put(((ConversationData) localObject2).getParticipant().getUserName(), ((ConversationData) localObject2).getParticipant().getUserName());
                    }
                    i += 1;
                }
            }
        } catch (Exception localException3) {
            for (; ; ) {
            }
        }
    }

    public void recycleImage(ArrayList<ImageInThread> paramArrayList) {
        int i = 0;
        for (; ; ) {
            if (i >= paramArrayList.size()) {
                return;
            }
            if (paramArrayList.get(i) != null) {
                int[] arrayOfInt = new int[2];
                ((ImageInThread) paramArrayList.get(i)).iv.getLocationInWindow(arrayOfInt);
                int j = arrayOfInt[1];
                if ((j >= this.mContext.getWindowManager().getDefaultDisplay().getHeight() - 30) || (j <= -(((ImageInThread) paramArrayList.get(i)).iv.getMeasuredHeight() - 20)) || (!((ImageInThread) paramArrayList.get(i)).iv.isShown())) {
                    ((ImageInThread) paramArrayList.get(i)).iv.recyle();
                }
            }
            i += 1;
        }
    }

    public void refresh() {
        this.mDatas.clear();
        if (this.mFragment.progress != null) {
            this.mFragment.progress.setVisibility(8);
        }
        this.converId.clear();
        getConversationDetail(this.mFragment.detailFragment_CurrentPage);
    }

    public void setConvOuterFragment(ConversationOuterFragment paramConversationOuterFragment) {
        this.convOuterFragment = paramConversationOuterFragment;
    }

    public void setShouldJump(boolean paramBoolean) {
        this.shouldJump = paramBoolean;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/conversation/ConvDetailAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */