package com.quoord.tapatalkpro.adapter.forum;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import com.androidquery.callback.AjaxStatus;
import com.quoord.gif.GifView;
import com.quoord.tapatalkpro.action.AddBannerInterface;
import com.quoord.tapatalkpro.action.LatestTopicAction;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.activity.forum.ProfilesOuterFragment;
import com.quoord.tapatalkpro.ads.AdBean;
import com.quoord.tapatalkpro.ads.AdsService;
import com.quoord.tapatalkpro.bean.Banner;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.ListItemClickable;
import com.quoord.tapatalkpro.bean.NoTopicView;
import com.quoord.tapatalkpro.bean.RebrandingConfig;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ics.topics.TopicImageAction;
import com.quoord.tapatalkpro.ics.topics.TopicImageAction.TopicImageCallBack;
import com.quoord.tapatalkpro.ics.topics.TopicsFragment;
import com.quoord.tapatalkpro.saxparser.TopicSaxParser;
import com.quoord.tapatalkpro.util.Util;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

public class LatestTopicAdapter
        extends ForumRootAdapter
        implements AddBannerInterface, TopicImageAction.TopicImageCallBack {
    public static String LATEST = "latest";
    public static String PARTICIPATED = "participated";
    public static String UNREAD = "unread";
    public static final int latestTabId = 1;
    private Activity activity;
    private AddBannerInterface addRebrandBanner;
    private HashMap<Integer, Object> bannerHash = new HashMap();
    public int currentSelectedPosition = -1;
    View footLay;
    private String forumUrl;
    private boolean isDislayUnread = false;
    protected boolean isNeedRefreshIcon;
    public ArrayList<Object> mAllDatas;
    public ArrayList<Object> mDatas;
    protected String mFlag = null;
    private ListView mList;
    protected Handler mUIHandler;
    public ArrayList<Object> mUnreadDatas;
    public LatestTopicAction topicAction;
    private ArrayList<String> topicIds = new ArrayList();
    private TopicImageAction topicImageCall;
    public HashMap<String, String> userNameList;
    private String user_name = null;
    private NoTopicView view;

    public LatestTopicAdapter(Activity paramActivity, String paramString1, String paramString2, ListView paramListView, View paramView, String paramString3, String paramString4, ForumStatus paramForumStatus) {
        super(paramActivity, paramString1);
        this.activity = paramActivity;
        init(paramString1, paramString2, paramListView, paramView, paramString3, paramString4, paramForumStatus);
    }

    public LatestTopicAdapter(ProfilesOuterFragment paramProfilesOuterFragment, String paramString1, String paramString2, ListView paramListView, View paramView, String paramString3, String paramString4, ForumStatus paramForumStatus) {
        super(paramProfilesOuterFragment.mActivity, paramProfilesOuterFragment, paramString1);
        this.activity = paramProfilesOuterFragment.mActivity;
        init(paramString1, paramString2, paramListView, paramView, paramString3, paramString4, paramForumStatus);
    }

    public void AddRebrandBannerItem() {
        if (this.addRebrandBanner != null) {
            this.addRebrandBanner.addRebrandBanner();
            notifyDataSetChanged();
        }
    }

    public void addBanner(ArrayList<Object> paramArrayList) {
        if ((this.forumStatus != null) && (this.forumStatus.getRebrandingConfig() != null) && (this.forumStatus.isAdShow()) && (((this.forumStatus.getRebrandingConfig().getDfp_320x50() != null) && (!this.forumStatus.getRebrandingConfig().getDfp_320x50().equals(""))) || ((this.forumStatus.getRebrandingConfig().getAdmobId() != null) && (!this.forumStatus.getRebrandingConfig().getAdmobId().equals(""))))) {
            Banner.addBanner(this.activity, paramArrayList);
        }
    }

    public void addRebrandBanner() {
    }

    public void cleanDatas() {
        this.mDatas.clear();
        notifyDataSetChanged();
    }

    public void destroy() {
        int i = 0;
        if (i >= getCount()) {
            System.gc();
            this.icons.clear();
            this.mDatas.clear();
            return;
        }
        Topic localTopic = (Topic) getItem(i);
        if (this.icons.get(localTopic.getId()) != null) {
            if (!(this.icons.get(localTopic.getId()) instanceof GifView)) {
                break label104;
            }
            ((GifView) this.icons.get(localTopic.getId())).close();
        }
        for (; ; ) {
            this.icons.remove(localTopic.getId());
            i += 1;
            break;
            label104:
            ((ImageView) this.icons.get(localTopic.getId())).setImageBitmap(null);
            localTopic.getIcon().recycle();
        }
    }

    public AddBannerInterface getAddRebrandBanner() {
        return this.addRebrandBanner;
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
        if ((getItem(paramInt) instanceof HashMap)) {
            return 0;
        }
        if ((getItem(paramInt) instanceof Topic)) {
            return 1;
        }
        if ((getItem(paramInt) instanceof NoTopicView)) {
            return 2;
        }
        if ((getItem(paramInt) instanceof AdBean)) {
            return 3;
        }
        return 4;
    }

    public int getTotalTopicNum() {
        return this.topicAction.total_num;
    }

    public void getUnreadTopic(boolean paramBoolean) {
        this.isDislayUnread = paramBoolean;
        if (paramBoolean) {
        }
        for (this.mDatas = this.mUnreadDatas; ; this.mDatas = this.mAllDatas) {
            if (this.mDatas.contains(this.view)) {
                this.mDatas.remove(this.view);
            }
            notifyDataSetChanged();
            return;
        }
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        if ((getItem(paramInt) instanceof ListItemClickable)) {
            paramViewGroup = new HashMap();
            paramViewGroup.put("showForumName", Boolean.valueOf(true));
            paramViewGroup.put("isSubscribedTab", Boolean.valueOf(false));
            if (((this.activity instanceof SlidingMenuActivity)) && (((SlidingMenuActivity) this.activity).getShowSlectionStatus()) && (paramInt == this.currentSelectedPosition)) {
                if (paramInt == this.currentSelectedPosition) {
                    paramViewGroup.put("showSelectBg", Boolean.valueOf(true));
                }
            } else {
                paramView = ((ListItemClickable) getItem(paramInt)).createView(paramViewGroup, paramView, (ForumActivityStatus) this.baseContext);
            }
        }
        while (!(getItem(paramInt) instanceof NoTopicView)) {
            for (; ; ) {
                return paramView;
                paramViewGroup.put("showSelectBg", Boolean.valueOf(false));
            }
        }
        return ((NoTopicView) getItem(paramInt)).getItemView(this.baseContext);
    }

    public int getViewTypeCount() {
        return 5;
    }

    public void imageLoad(JSONObject paramJSONObject, AjaxStatus paramAjaxStatus) {
        int i;
        if (paramJSONObject != null) {
            i = 0;
        }
        for (; ; ) {
            if (i >= this.mDatas.size()) {
                notifyDataSetChanged();
                return;
            }
            if ((this.mDatas.get(i) instanceof Topic)) {
                paramAjaxStatus = ((Topic) this.mDatas.get(i)).getId();
                if (!paramJSONObject.has(paramAjaxStatus)) {
                }
            }
            try {
                paramAjaxStatus = paramJSONObject.getString(paramAjaxStatus);
                if ((paramAjaxStatus != null) && (!paramAjaxStatus.equals(""))) {
                    ((Topic) this.mDatas.get(i)).setTopicImgUrl(paramAjaxStatus);
                }
            } catch (JSONException paramAjaxStatus) {
                for (; ; ) {
                    paramAjaxStatus.printStackTrace();
                }
            }
            i += 1;
        }
    }

    public void init(String paramString1, String paramString2, ListView paramListView, final View paramView, String paramString3, String paramString4, final ForumStatus paramForumStatus) {
        this.forumUrl = paramString1;
        this.mDatas = new ArrayList();
        this.mAllDatas = new ArrayList();
        this.mUnreadDatas = new ArrayList();
        this.view = new NoTopicView();
        this.mFlag = paramString2;
        this.mList = paramListView;
        this.user_name = paramString3;
        paramString1 = new Handler() {
            public void handleMessage(Message paramAnonymousMessage) {
                int i;
                if (paramAnonymousMessage.what == LatestTopicAction.SAX_CLOSE_PROGRESS) {
                    i = Integer.valueOf(paramAnonymousMessage.obj.toString()).intValue();
                    if ((LatestTopicAdapter.this.mFlag.equalsIgnoreCase(LatestTopicAdapter.UNREAD)) && (((SlidingMenuActivity) LatestTopicAdapter.this.activity).fragmentMap != null) && (((SlidingMenuActivity) LatestTopicAdapter.this.activity).fragmentMap.get(Integer.valueOf(1013)) != null)) {
                        ((TopicsFragment) ((SlidingMenuActivity) LatestTopicAdapter.this.activity).fragmentMap.get(Integer.valueOf(1013))).changeUnreadNumber(i);
                    }
                }
                AdBean localAdBean;
                if (paramAnonymousMessage.what == LatestTopicAction.SAX_UPDATE_ITEM) {
                    LatestTopicAdapter.this.topicIds.add(((Topic) paramAnonymousMessage.obj).getId());
                    if ((LatestTopicAdapter.this.mFlag.equals(LatestTopicAdapter.PARTICIPATED)) && (((Topic) paramAnonymousMessage.obj).getNewPost())) {
                        LatestTopicAdapter.this.mUnreadDatas.add((Topic) paramAnonymousMessage.obj);
                    }
                    if (AdsService.showAdmode(LatestTopicAdapter.this.activity) != AdsService.SHOWNATIVE) {
                        break label566;
                    }
                    if (LatestTopicAdapter.this.mDatas.size() % 20 == 1) {
                        if (!LatestTopicAdapter.this.mFlag.equals(LatestTopicAdapter.UNREAD)) {
                            break label530;
                        }
                        localAdBean = AdsService.getLatestAdBean(paramForumStatus.tapatalkForum.getId().intValue());
                        if (localAdBean != null) {
                            LatestTopicAdapter.this.mDatas.add(localAdBean);
                        }
                    }
                    LatestTopicAdapter.this.mAllDatas.add((Topic) paramAnonymousMessage.obj);
                    LatestTopicAdapter.this.getUnreadTopic(LatestTopicAdapter.this.isDislayUnread);
                    LatestTopicAdapter.this.topicAction.mTopicParser.setIsAddFinished(true);
                } else if (paramAnonymousMessage.what == LatestTopicAction.SAX_UPDATE_END) {
                    LatestTopicAdapter.this.topicAction.loadingMoreLatest = false;
                    if (LatestTopicAdapter.this.mDatas.size() == 0) {
                        LatestTopicAdapter.this.mDatas.add(new NoTopicView());
                    }
                    if (!LatestTopicAdapter.this.isFootNeeded()) {
                        LatestTopicAdapter.this.mList.removeFooterView(paramView);
                    }
                    LatestTopicAdapter.this.notifyDataSetChanged();
                    if (paramForumStatus.tapatalkForum.isHasImage()) {
                        if (Util.is2GState(LatestTopicAdapter.this.activity)) {
                            break label583;
                        }
                        if (SettingsFragment.isEnableTopicImg(LatestTopicAdapter.this.activity)) {
                            LatestTopicAdapter.this.topicImageCall.getTopicImgUrl(paramForumStatus.tapatalkForum.getId().toString(), LatestTopicAdapter.this.topicIds);
                            LatestTopicAdapter.this.topicIds.clear();
                        }
                    }
                }
                for (; ; ) {
                    LatestTopicAdapter.this.activity.invalidateOptionsMenu();
                    i = paramAnonymousMessage.what;
                    i = LatestTopicAction.SAX_UPDATE_BEGIN;
                    if (paramAnonymousMessage.what == LatestTopicAction.SAX_DISPLAY_ERROR) {
                        paramAnonymousMessage = (String) paramAnonymousMessage.obj;
                        Toast.makeText(LatestTopicAdapter.this.baseContext, paramAnonymousMessage, 1);
                    }
                    return;
                    label530:
                    localAdBean = AdsService.getAdBean(paramForumStatus.tapatalkForum.getId().intValue());
                    if (localAdBean == null) {
                        break;
                    }
                    LatestTopicAdapter.this.mDatas.add(localAdBean);
                    break;
                    label566:
                    LatestTopicAdapter.this.addBanner(LatestTopicAdapter.this.mAllDatas);
                    break;
                    label583:
                    if (SettingsFragment.isEnableTopicImgWithSlowConn(LatestTopicAdapter.this.activity)) {
                        LatestTopicAdapter.this.topicImageCall.getTopicImgUrl(paramForumStatus.tapatalkForum.getId().toString(), LatestTopicAdapter.this.topicIds);
                        LatestTopicAdapter.this.topicIds.clear();
                    }
                }
            }
        };
        this.topicAction = new LatestTopicAction(this.activity, this.forumUrl, this.mFlag, this.user_name, paramForumStatus, paramString1);
        this.mList.addFooterView(paramView);
        this.mList.setAdapter(this);
        this.footLay = paramView;
        this.userNameList = this.topicAction.userNameList;
        this.mList.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {
                if ((paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3) && (!LatestTopicAdapter.this.topicAction.loadingMoreLatest) && (LatestTopicAdapter.this.isFootNeeded())) {
                    LatestTopicAdapter.this.topicAction.getTopic();
                }
            }

            public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {
            }
        });
        this.topicImageCall = new TopicImageAction(this.activity, this);
    }

    public boolean isEnabled(int paramInt) {
        if ((getItem(paramInt) instanceof Topic)) {
        }
        while ((getItem(paramInt) instanceof AdBean)) {
            return true;
        }
        return false;
    }

    public boolean isFootNeeded() {
        return this.topicAction.mLastStart < this.topicAction.total_num;
    }

    public void parseCallBack(EngineResponse paramEngineResponse) {
    }

    public void refresh() {
        setOpCancel(false);
        this.mAllDatas.clear();
        this.mUnreadDatas.clear();
        this.mDatas.clear();
        this.icons.clear();
        this.bannerHash.clear();
        if (this.mList.getFooterViewsCount() > 0) {
            this.mList.removeFooterView(this.footLay);
        }
        this.mList.addFooterView(this.footLay);
        this.topicAction.mLastStart = 0;
        this.topicAction.searchId = null;
        this.topicAction.getAds();
        this.topicAction.getTopic();
    }

    public void removeItem(int paramInt) {
        this.mDatas.remove(paramInt);
    }

    public void setAddRebrandBanner(AddBannerInterface paramAddBannerInterface) {
        this.addRebrandBanner = paramAddBannerInterface;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/LatestTopicAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */