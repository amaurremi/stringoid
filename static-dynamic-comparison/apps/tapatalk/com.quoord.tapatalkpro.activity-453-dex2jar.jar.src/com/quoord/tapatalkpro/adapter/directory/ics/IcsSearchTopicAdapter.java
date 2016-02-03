package com.quoord.tapatalkpro.adapter.directory.ics;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.quoord.tapatalkpro.action.OpenThreadAction;
import com.quoord.tapatalkpro.action.TapatalkAccountAction;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.TapatalkForumForSearch;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ics.action.IcsSearchTopicAction;
import com.quoord.tapatalkpro.ics.action.IcsSearchTopicAction.IcsSearchTopicActionBack;
import com.quoord.tapatalkpro.ui.ButtomProgress;
import com.quoord.tapatalkpro.util.ForumOnClick;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.ImageTools;
import com.quoord.tools.tracking.GoogleAnalyticsTools;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class IcsSearchTopicAdapter
        extends BaseAdapter {
    private static final int PER_PAGE = 20;
    private boolean isLoadFinished = false;
    private int loading = 0;
    private Activity mActivity = null;
    private View mBottomProcessView = null;
    private ArrayList<Integer> mCurrentForumIds = null;
    private Integer mCurrentPage = Integer.valueOf(1);
    private ArrayList<TapatalkForumForSearch> mDatas = new ArrayList();
    private String mKeyword = null;
    private View mMiddleProcessView = null;
    private View mNoResultView = null;
    private ListView mResultListView = null;

    public IcsSearchTopicAdapter(Activity paramActivity, String paramString, ListView paramListView, View paramView1, View paramView2) {
        this.mActivity = paramActivity;
        this.mKeyword = paramString;
        this.mResultListView = paramListView;
        this.mMiddleProcessView = paramView1;
        this.mBottomProcessView = ButtomProgress.get(this.mActivity);
        this.mNoResultView = paramView2;
        initFavForumCache();
        initResultListView();
        getSearchTopic(this.mKeyword, true);
        GoogleAnalyticsTools.trackPageView(this.mActivity, "tap_search");
    }

    private void initFavForumCache() {
        this.mCurrentForumIds = new ArrayList();
        Iterator localIterator = TapatalkAccountAction.getCurrnentAllAccount(this.mActivity).iterator();
        for (; ; ) {
            if (!localIterator.hasNext()) {
                return;
            }
            TapatalkForum localTapatalkForum = (TapatalkForum) localIterator.next();
            if (!this.mCurrentForumIds.contains(localTapatalkForum.getId())) {
                this.mCurrentForumIds.add(localTapatalkForum.getId());
            }
        }
    }

    private void initResultListView() {
        this.mResultListView.addFooterView(this.mBottomProcessView);
        this.mResultListView.setAdapter(this);
        this.mResultListView.removeFooterView(this.mBottomProcessView);
        this.mResultListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                if ((IcsSearchTopicAdapter.this.getItem(paramAnonymousInt) instanceof TapatalkForum)) {
                    ((TapatalkForum) IcsSearchTopicAdapter.this.getItem(paramAnonymousInt)).openTapatalkForum(IcsSearchTopicAdapter.this.mActivity, false);
                }
            }
        });
        this.mResultListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {
                paramAnonymousInt1 += paramAnonymousInt2;
                if ((paramAnonymousInt1 != 0) && (paramAnonymousInt1 == paramAnonymousInt3) && (IcsSearchTopicAdapter.this.loading == 0) && (!IcsSearchTopicAdapter.this.isLoadFinished)) {
                    IcsSearchTopicAdapter.this.getSearchTopic(IcsSearchTopicAdapter.this.mKeyword, false);
                }
            }

            public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {
            }
        });
    }

    private TapatalkForumViewHolder initViewHolder(View paramView) {
        TapatalkForumViewHolder localTapatalkForumViewHolder = new TapatalkForumViewHolder(null);
        localTapatalkForumViewHolder.itemLayout = paramView.findViewById(2131231229);
        localTapatalkForumViewHolder.forumIcon = ((ImageView) paramView.findViewById(2131231230));
        localTapatalkForumViewHolder.forumNameTv = ((TextView) paramView.findViewById(2131231234));
        localTapatalkForumViewHolder.forumDescriptionTv = ((TextView) paramView.findViewById(2131231239));
        localTapatalkForumViewHolder.proboardImg = ((ImageView) paramView.findViewById(2131231231));
        localTapatalkForumViewHolder.tapatalkUserCountIcon = ((ImageView) paramView.findViewById(2131231235));
        localTapatalkForumViewHolder.tapatalkUserCountTv = ((TextView) paramView.findViewById(2131231236));
        localTapatalkForumViewHolder.totalThreadsIcon = ((ImageView) paramView.findViewById(2131231237));
        localTapatalkForumViewHolder.totalThreadsTv = ((TextView) paramView.findViewById(2131231238));
        localTapatalkForumViewHolder.addImg = ((ImageView) paramView.findViewById(2131231233));
        localTapatalkForumViewHolder.addArea = paramView.findViewById(2131231232);
        localTapatalkForumViewHolder.topicContainer = paramView.findViewById(2131231240);
        localTapatalkForumViewHolder.forumIcon.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("avator_background", this.mActivity));
        return localTapatalkForumViewHolder;
    }

    private void updateViewHolder(TapatalkForumViewHolder paramTapatalkForumViewHolder, int paramInt, boolean paramBoolean) {
        Object localObject1 = (TapatalkForumForSearch) this.mDatas.get(paramInt);
        if (localObject1 == null) {
        }
        label114:
        label151:
        label193:
        do {
            return;
            Util.setBg(paramTapatalkForumViewHolder.itemLayout, ThemeUtil.getBgDrawableByPicNameForList("list_item_bg_normal", this.mActivity, paramBoolean));
            if (((TapatalkForumForSearch) localObject1).getName() != null) {
                paramTapatalkForumViewHolder.forumNameTv.setText(((TapatalkForumForSearch) localObject1).getName());
            }
            if (((TapatalkForumForSearch) localObject1).getDescription() != null) {
                paramTapatalkForumViewHolder.forumDescriptionTv.setText(((TapatalkForumForSearch) localObject1).getDescription());
            }
            if ((((TapatalkForumForSearch) localObject1).getTapatalkUserCount() != null) && (((TapatalkForumForSearch) localObject1).getTapatalkUserCount().intValue() != 0)) {
                break;
            }
            paramTapatalkForumViewHolder.tapatalkUserCountIcon.setVisibility(8);
            paramTapatalkForumViewHolder.tapatalkUserCountTv.setVisibility(8);
            if ((((TapatalkForumForSearch) localObject1).getTotalThreads() != null) && (((TapatalkForumForSearch) localObject1).getTotalThreads().intValue() != 0)) {
                break label382;
            }
            paramTapatalkForumViewHolder.totalThreadsIcon.setVisibility(8);
            paramTapatalkForumViewHolder.totalThreadsTv.setVisibility(8);
            ImageTools.glideLoad(((TapatalkForumForSearch) localObject1).getIconUrl(), paramTapatalkForumViewHolder.forumIcon);
            if ((((TapatalkForumForSearch) localObject1).getType() == null) || (!((TapatalkForumForSearch) localObject1).getType().equals("proboards"))) {
                break label426;
            }
            paramTapatalkForumViewHolder.proboardImg.setVisibility(0);
            if (!this.mCurrentForumIds.contains(((TapatalkForumForSearch) this.mDatas.get(paramInt)).getId())) {
                break label438;
            }
            paramTapatalkForumViewHolder.addArea.setVisibility(8);
            ((LinearLayout) paramTapatalkForumViewHolder.topicContainer).removeAllViews();
            localObject1 = ((TapatalkForumForSearch) localObject1).getTopics();
        } while ((localObject1 == null) || (((ArrayList) localObject1).size() <= 0));
        paramTapatalkForumViewHolder.topicContainer.setVisibility(0);
        paramInt = 0;
        label266:
        Object localObject2;
        if (paramInt < ((ArrayList) localObject1).size()) {
            localObject2 = (Topic) ((ArrayList) localObject1).get(paramInt);
            if (paramInt != 0) {
                break label548;
            }
        }
        label382:
        label426:
        label438:
        label548:
        for (paramBoolean = true; ; paramBoolean = false) {
            localObject2 = new TopicView(this.mActivity, (Topic) localObject2, paramBoolean, (LinearLayout) paramTapatalkForumViewHolder.topicContainer);
            ((LinearLayout) paramTapatalkForumViewHolder.topicContainer).addView(((TopicView) localObject2).topicArea);
            paramInt += 1;
            break label266;
            break;
            paramTapatalkForumViewHolder.tapatalkUserCountIcon.setVisibility(0);
            paramTapatalkForumViewHolder.tapatalkUserCountTv.setVisibility(0);
            localObject2 = NumberFormat.getNumberInstance(Locale.getDefault());
            paramTapatalkForumViewHolder.tapatalkUserCountTv.setText(((NumberFormat) localObject2).format(((TapatalkForumForSearch) localObject1).getTapatalkUserCount()));
            break label114;
            paramTapatalkForumViewHolder.totalThreadsIcon.setVisibility(0);
            paramTapatalkForumViewHolder.totalThreadsTv.setVisibility(0);
            localObject2 = NumberFormat.getNumberInstance(Locale.getDefault());
            paramTapatalkForumViewHolder.totalThreadsTv.setText(((NumberFormat) localObject2).format(((TapatalkForumForSearch) localObject1).getTotalThreads()));
            break label151;
            paramTapatalkForumViewHolder.proboardImg.setVisibility(8);
            break label193;
            if (Util.isFavoriate(this.mActivity, ((TapatalkForumForSearch) this.mDatas.get(paramInt)).getId().intValue())) {
                paramTapatalkForumViewHolder.addArea.setVisibility(0);
                paramTapatalkForumViewHolder.addImg.setImageResource(2130837513);
            }
            for (; ; ) {
                paramTapatalkForumViewHolder.addArea.setOnClickListener(new ForumOnClick(((TapatalkForumForSearch) localObject1).getId().toString(), (TapatalkForum) localObject1, this.mActivity, paramTapatalkForumViewHolder.addImg, paramTapatalkForumViewHolder.addArea, "search", true, true));
                break;
                paramTapatalkForumViewHolder.addArea.setVisibility(0);
                paramTapatalkForumViewHolder.addImg.setImageResource(2130839293);
            }
        }
    }

    public int getCount() {
        return this.mDatas.size();
    }

    public Object getItem(int paramInt) {
        try {
            Object localObject = this.mDatas.get(paramInt);
            return localObject;
        } catch (Exception localException) {
        }
        return null;
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public void getSearchTopic(String paramString, boolean paramBoolean) {
        if (paramBoolean) {
            this.mDatas.clear();
            notifyDataSetChanged();
            this.isLoadFinished = false;
            this.mCurrentPage = Integer.valueOf(1);
            this.mKeyword = paramString;
        }
        this.loading += 1;
        this.mNoResultView.setVisibility(8);
        if (this.mCurrentPage.intValue() == 1) {
            this.mMiddleProcessView.setVisibility(0);
            this.mResultListView.removeFooterView(this.mBottomProcessView);
        }
        for (; ; ) {
            if ((this.mKeyword != null) && (!this.mKeyword.equals(""))) {
                searchTopic();
            }
            return;
            this.mResultListView.addFooterView(this.mBottomProcessView);
        }
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        if (paramView == null) {
            paramView = this.mActivity.getLayoutInflater().inflate(2130903204, null);
            paramViewGroup = initViewHolder(paramView);
            paramView.setTag(paramViewGroup);
            if (getCount() - 1 != paramInt) {
                break label64;
            }
        }
        label64:
        for (boolean bool = true; ; bool = false) {
            updateViewHolder(paramViewGroup, paramInt, bool);
            return paramView;
            paramViewGroup = (TapatalkForumViewHolder) paramView.getTag();
            break;
        }
    }

    public void searchTopic() {
        new IcsSearchTopicAction(this.mActivity).icsSearchTopic(this.mKeyword, this.mCurrentPage.intValue(), 20, false, new IcsSearchTopicAction.IcsSearchTopicActionBack() {
            public void searchTopicActionBack(ArrayList<TapatalkForumForSearch> paramAnonymousArrayList, Integer paramAnonymousInteger) {
                paramAnonymousInteger = IcsSearchTopicAdapter.this;
                paramAnonymousInteger.loading -= 1;
                if (IcsSearchTopicAdapter.this.loading > 0) {
                    return;
                }
                IcsSearchTopicAdapter.this.mMiddleProcessView.setVisibility(8);
                IcsSearchTopicAdapter.this.mResultListView.removeFooterView(IcsSearchTopicAdapter.this.mBottomProcessView);
                if (paramAnonymousArrayList != null) {
                }
                try {
                    if (paramAnonymousArrayList.size() != 0) {
                        paramAnonymousInteger = IcsSearchTopicAdapter.this;
                        paramAnonymousInteger.mCurrentPage = Integer.valueOf(paramAnonymousInteger.mCurrentPage.intValue() + 1);
                        IcsSearchTopicAdapter.this.mDatas.addAll(paramAnonymousArrayList);
                    }
                    for (; ; ) {
                        IcsSearchTopicAdapter.this.notifyDataSetChanged();
                        return;
                        IcsSearchTopicAdapter.this.isLoadFinished = true;
                        if (IcsSearchTopicAdapter.this.mCurrentPage.intValue() == 1) {
                            IcsSearchTopicAdapter.this.mNoResultView.setVisibility(0);
                        }
                    }
                } catch (Exception paramAnonymousArrayList) {
                    for (; ; ) {
                        paramAnonymousArrayList.printStackTrace();
                        paramAnonymousArrayList = IcsSearchTopicAdapter.this.mActivity.getResources().getString(2131100069);
                        Toast.makeText(IcsSearchTopicAdapter.this.mActivity, paramAnonymousArrayList, 1).show();
                    }
                }
            }
        });
    }

    private static class TapatalkForumViewHolder {
        View addArea;
        ImageView addImg;
        TextView forumDescriptionTv;
        ImageView forumIcon;
        TextView forumNameTv;
        View itemLayout;
        ImageView proboardImg;
        ImageView tapatalkUserCountIcon;
        TextView tapatalkUserCountTv;
        View topicContainer;
        ImageView totalThreadsIcon;
        TextView totalThreadsTv;
    }

    private class TopicView {
        private Activity activity;
        private boolean isFirst = true;
        private ViewGroup parent = null;
        private Topic topic;
        private View topicArea = null;
        private TextView topicDetailTv = null;
        private ImageView topicIcon = null;
        private ImageView topicImg = null;
        private View topicLayout = null;
        private TextView topicTitleTv = null;

        public TopicView(Activity paramActivity, Topic paramTopic, boolean paramBoolean, ViewGroup paramViewGroup) {
            this.topic = paramTopic;
            this.activity = paramActivity;
            this.isFirst = paramBoolean;
            this.parent = paramViewGroup;
            initBaseLayout();
            initData();
        }

        private void initBaseLayout() {
            this.topicArea = this.activity.getLayoutInflater().inflate(2130903206, this.parent, false);
            this.topicLayout = this.topicArea.findViewById(2131231222);
            this.topicIcon = ((ImageView) this.topicArea.findViewById(2131231223));
            this.topicImg = ((ImageView) this.topicArea.findViewById(2131231227));
            this.topicTitleTv = ((TextView) this.topicArea.findViewById(2131231225));
            this.topicDetailTv = ((TextView) this.topicArea.findViewById(2131231228));
            this.topicImg.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("avator_background", IcsSearchTopicAdapter.this.mActivity));
            this.topicIcon.setImageResource(2130839277);
            this.topicLayout.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("list_subitem_bg_normal", IcsSearchTopicAdapter.this.mActivity));
            if (this.isFirst) {
                new Handler().post(new Runnable() {
                    public void run() {
                        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams) IcsSearchTopicAdapter.TopicView.this.topicLayout.getLayoutParams();
                        localLayoutParams.setMargins(localLayoutParams.leftMargin, Util.getPxFromDip(IcsSearchTopicAdapter.TopicView.this.activity, 0.0F), localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
                        IcsSearchTopicAdapter.TopicView.this.topicLayout.setLayoutParams(localLayoutParams);
                    }
                });
            }
        }

        private void initData() {
            if (this.topic == null) {
                return;
            }
            if ((this.topic.getTopicImgUrl() == null) || (this.topic.getTopicImgUrl().equals(""))) {
                this.topicImg.setVisibility(8);
            }
            for (; ; ) {
                if (this.topic.getTitle() != null) {
                    localObject = new StringBuilder("");
                    ((StringBuilder) localObject).append("<b>" + this.topic.getTitle() + "</b>");
                    if ((this.topic.getShortContent() != null) && (!this.topic.getShortContent().equals(""))) {
                        ((StringBuilder) localObject).append(" - ");
                        String str = this.topic.getShortContent().replaceAll("(?i)" + IcsSearchTopicAdapter.this.mKeyword, "<b>" + IcsSearchTopicAdapter.this.mKeyword + "</b>");
                        ((StringBuilder) localObject).append("<font color=\"#999999\">" + str + "</font>");
                    }
                    localObject = ((StringBuilder) localObject).toString();
                    this.topicDetailTv.setText(Html.fromHtml((String) localObject));
                }
                Object localObject = NumberFormat.getNumberInstance(Locale.getDefault());
                this.topicTitleTv.setText(((NumberFormat) localObject).format(this.topic.getReplyCount()));
                this.topicLayout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View paramAnonymousView) {
                        OpenThreadAction.openThread(IcsSearchTopicAdapter.this.mActivity, IcsSearchTopicAdapter.TopicView.this.topic, "search");
                    }
                });
                new Handler().post(new Runnable() {
                    public void run() {
                        if ((IcsSearchTopicAdapter.TopicView.this.topicDetailTv.getLineCount() == 1) && (IcsSearchTopicAdapter.TopicView.this.topicImg.getVisibility() == 8)) {
                            View localView = IcsSearchTopicAdapter.TopicView.this.topicArea.findViewById(2131231246);
                            LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams) localView.getLayoutParams();
                            localLayoutParams.bottomMargin += Util.getPxFromDip(IcsSearchTopicAdapter.TopicView.this.activity, 10.0F);
                            localView.setLayoutParams(localLayoutParams);
                        }
                    }
                });
                return;
                this.topicImg.setVisibility(0);
                ImageTools.glideLoad(this.topic.getTopicImgUrl(), this.topicImg);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/directory/ics/IcsSearchTopicAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */