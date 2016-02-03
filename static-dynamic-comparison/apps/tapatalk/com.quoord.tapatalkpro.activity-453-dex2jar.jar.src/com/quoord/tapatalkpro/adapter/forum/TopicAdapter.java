package com.quoord.tapatalkpro.adapter.forum;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.quoord.gif.GifView;
import com.quoord.tapatalkpro.action.GetTopicAction;
import com.quoord.tapatalkpro.action.GetTopicAction.UpdateTopic;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.ads.AdBean;
import com.quoord.tapatalkpro.ads.AdsService;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.Forum;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.ListItemClickable;
import com.quoord.tapatalkpro.bean.NoTopicView;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ui.NewTopicView;
import com.quoord.tapatalkpro.util.TapatalkEngine;

import java.util.ArrayList;
import java.util.HashMap;

public class TopicAdapter
        extends ForumRootAdapter {
    public int currentSelectedPosition = -1;
    public GetTopicAction getTopicAction;
    protected Boolean isFootAdd = Boolean.valueOf(false);
    public ArrayList<Object> mAllDatas = new ArrayList();
    private Activity mContext;
    private SubForumAdapter subforumAdapter = null;
    View tv;

    public TopicAdapter(Activity paramActivity, String paramString, Forum paramForum, final SubForumAdapter paramSubForumAdapter) {
        super(paramActivity, paramString);
        this.subforumAdapter = paramSubForumAdapter;
        this.tv = paramSubForumAdapter.tv;
        this.mContext = paramActivity;
        this.getTopicAction = new GetTopicAction(this.mContext, this.forumStatus, paramForum, false, new GetTopicAction.UpdateTopic() {
            public void update(ArrayList<Object> paramAnonymousArrayList, boolean paramAnonymousBoolean) {
                TopicAdapter.this.mAllDatas.clear();
                TopicAdapter.this.mAllDatas.addAll(paramAnonymousArrayList);
                TopicAdapter.this.notifyDataSetChanged();
                if (paramAnonymousBoolean) {
                    paramSubForumAdapter.removeFooter();
                }
            }
        });
        this.mForum = paramForum;
    }

    public boolean canPost() {
        return this.getTopicAction.canPost;
    }

    public void cleanNewPost() {
        int i = 0;
        for (; ; ) {
            if (i >= this.mAllDatas.size()) {
                return;
            }
            if ((this.mAllDatas.get(i) instanceof Topic)) {
                ((Topic) this.mAllDatas.get(i)).setNewPost(false);
            }
            i += 1;
        }
    }

    public void destroy() {
        int i = 0;
        if (i >= getCount()) {
            this.icons.clear();
            i = 0;
            label19:
            if (i < this.mAllDatas.size()) {
                break label277;
            }
            this.mAllDatas.clear();
            i = 0;
        }
        for (; ; ) {
            if (i >= this.getTopicAction.mChildForums.size()) {
                this.getTopicAction.mChildForums.clear();
                System.gc();
                System.runFinalization();
                return;
                Topic localTopic;
                if ((getItem(i) instanceof Topic)) {
                    localTopic = (Topic) getItem(i);
                    if ((this.icons.get(localTopic.getId()) == null) || (!(this.icons.get(localTopic.getId()) instanceof GifView))) {
                        break label208;
                    }
                    ((GifView) this.icons.get(localTopic.getId())).close();
                }
                for (; ; ) {
                    if ((this.icons.get(localTopic.getId()) != null) && ((((ImageView) this.icons.get(localTopic.getId())).getDrawable() instanceof BitmapDrawable))) {
                        ((BitmapDrawable) ((ImageView) this.icons.get(localTopic.getId())).getDrawable()).getBitmap().recycle();
                    }
                    i += 1;
                    break;
                    label208:
                    if (((ImageView) this.icons.get(localTopic.getId()) != null) && ((((ImageView) this.icons.get(localTopic.getId())).getDrawable() instanceof BitmapDrawable))) {
                        ((BitmapDrawable) ((ImageView) this.icons.get(localTopic.getId())).getDrawable()).getBitmap().recycle();
                    }
                }
                label277:
                this.mAllDatas.set(i, null);
                i += 1;
                break label19;
            }
            this.getTopicAction.mChildForums.set(i, null);
            i += 1;
        }
    }

    public int getCount() {
        return this.mAllDatas.size();
    }

    public ArrayList getDatas() {
        return this.mAllDatas;
    }

    public Forum getForum() {
        return this.mForum;
    }

    public Object getItem(int paramInt) {
        return this.mAllDatas.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public int getItemViewType(int paramInt) {
        if ((getItem(paramInt) instanceof Forum)) {
            return 0;
        }
        if ((getItem(paramInt) instanceof NoTopicView)) {
            return 1;
        }
        if ((getItem(paramInt) instanceof ListItemClickable)) {
            return 2;
        }
        if ((getItem(paramInt) instanceof NewTopicView)) {
            return 3;
        }
        return 4;
    }

    public void getTopic() {
        if (!this.mForum.isSubOnly()) {
            this.subforumAdapter.addFooter();
        }
        this.getTopicAction.getTopic();
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        if ((getItem(paramInt) instanceof Forum)) {
            if (paramInt == 0) {
                return Forum.getForumView(Forum.TOP_FORUM_ITEM, (Forum) getItem(paramInt), paramView, paramViewGroup, this.forumStatus, this.mContext, this, false);
            }
            if (paramInt == getCount() - 1) {
                return Forum.getForumView(Forum.BOTTOM_FORUM_ITEM, (Forum) getItem(paramInt), paramView, paramViewGroup, this.forumStatus, this.mContext, this, false);
            }
            return Forum.getForumView(Forum.MID_FORUM_ITEM, (Forum) getItem(paramInt), paramView, paramViewGroup, this.forumStatus, this.mContext, this, false);
        }
        if ((getItem(paramInt) instanceof NoTopicView)) {
            return ((NoTopicView) getItem(paramInt)).getItemView(this.mContext);
        }
        if ((getItem(paramInt) instanceof ListItemClickable)) {
            paramViewGroup = new HashMap();
            paramViewGroup.put("showForumName", Boolean.valueOf(false));
            paramViewGroup.put("isSubscribedTab", Boolean.valueOf(false));
            if (((this.mContext instanceof SlidingMenuActivity)) && (((SlidingMenuActivity) this.mContext).getShowSlectionStatus())) {
                if (paramInt != this.currentSelectedPosition) {
                    break label239;
                }
                paramViewGroup.put("showSelectBg", Boolean.valueOf(true));
            }
            for (; ; ) {
                return ((ListItemClickable) getItem(paramInt)).createView(paramViewGroup, paramView, (ForumActivityStatus) this.mContext);
                label239:
                paramViewGroup.put("showSelectBg", Boolean.valueOf(false));
            }
        }
        if ((getItem(paramInt) instanceof NewTopicView)) {
            return ((NewTopicView) getItem(paramInt)).getNewTopicView(this.mContext, this.forumStatus, this.mForum, this.getTopicAction);
        }
        return this.tv;
    }

    public int getViewTypeCount() {
        return 5;
    }

    public boolean isEnabled(int paramInt) {
        return ((getItem(paramInt) instanceof Forum)) || ((getItem(paramInt) instanceof Topic)) || ((getItem(paramInt) instanceof AdBean));
    }

    public boolean isFootNeeded() {
        return this.getTopicAction.isFootNeeded();
    }

    public void markForumRead1111() {
        setTryTwice(false);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(this.mForum.getId());
        this.engine.call("mark_all_as_read", localArrayList);
        int i = 0;
        for (; ; ) {
            if (i >= this.mAllDatas.size()) {
                this.forumStatus.cleanNewPost(this.mForum.getId());
                notifyDataSetChanged();
                Toast.makeText(this.baseContext, String.format(this.baseContext.getString(2131099970), new Object[]{this.mForum.getName()}), 1).show();
                return;
            }
            if ((this.mAllDatas.get(i) instanceof Topic)) {
                ((Topic) this.mAllDatas.get(i)).setNewPost(false);
            }
            i += 1;
        }
    }

    public void parseCallBack(EngineResponse paramEngineResponse) {
    }

    public void refresh() {
        int i;
        if (!this.mForum.isSubOnly()) {
            setOpCancel(false);
            this.getTopicAction.mStart = 0;
            this.getTopicAction.mPrefixes.clear();
            this.getTopicAction.clear();
            this.mAllDatas.clear();
            notifyDataSetChanged();
            i = this.forumStatus.tapatalkForum.isPRSupport().intValue();
            if (!this.forumStatus.isLogin()) {
                break label145;
            }
        }
        label145:
        for (; ; ) {
            if (i > 0) {
                i = this.forumStatus.tapatalkForum.getIsPT();
                AdsService.addAdsByPt(this.mContext, this.mForum.getId(), i, this.forumStatus.tapatalkForum.getId().intValue(), false, this.forumStatus);
            }
            this.subforumAdapter.addFooter();
            this.getTopicAction.getSubForums();
            this.getTopicAction.getTopics();
            return;
        }
    }

    public void removeItem(int paramInt) {
        this.mAllDatas.remove(paramInt);
    }

    public void setOpCancel(boolean paramBoolean) {
        this.isOpCancel = paramBoolean;
    }

    public void setSectionTitle(int paramInt) {
        ((TextView) this.tv).setText(paramInt + " " + this.mContext.getString(2131099812) + " @ " + this.mForum.getName());
    }

    public boolean showNewMenu() {
        return this.getTopicAction.showNewMenu;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/TopicAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */