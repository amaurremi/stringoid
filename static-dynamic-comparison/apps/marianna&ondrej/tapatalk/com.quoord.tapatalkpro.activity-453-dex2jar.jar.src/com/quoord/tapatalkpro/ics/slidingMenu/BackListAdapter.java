package com.quoord.tapatalkpro.ics.slidingMenu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.activity.forum.moderation.ModerateActivity;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.resourcefactory.AbsColorFactory;
import com.quoord.tapatalkpro.resourcefactory.AbsColorRender;
import com.quoord.tapatalkpro.resourcefactory.backlist.BackListItemBackColorFactory;
import com.quoord.tapatalkpro.resourcefactory.backlist.BackListItemCharacterColorFactory;
import com.quoord.tapatalkpro.util.AvatarTool;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.zgy.view.listview.StickyListHeadersAdapter;

import java.util.ArrayList;

public class BackListAdapter
        extends BaseAdapter
        implements StickyListHeadersAdapter, SectionIndexer {
    private SlidingMenuActivity context;
    private TextView forum_name;
    private BackListFragment fragment;
    public AbsColorRender itemBackColorRender;
    AbsColorFactory itemCharacterColorFactory;
    AbsColorRender itemCharacterColorRender;
    AbsColorFactory itemColorBackFactory;
    private SharedPreferences prefs;
    private ImageView proboard;
    public ArrayList<TabItem> tabItemList = new ArrayList();
    private RelativeLayout user;
    private ImageView userIcon;
    private RelativeLayout userLay;
    private TextView userName;

    public BackListAdapter(SlidingMenuActivity paramSlidingMenuActivity, BackListFragment paramBackListFragment, ArrayList<TabItem> paramArrayList) {
        this.context = paramSlidingMenuActivity;
        this.fragment = paramBackListFragment;
        this.prefs = Prefs.get(this.context);
        this.tabItemList = paramArrayList;
    }

    private void setHeaderBack() {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, this.context.getResources().getDimensionPixelOffset(2131427371));
        if (SettingsFragment.isLightTheme(this.context)) {
            this.userLay.setBackgroundResource(2130837878);
            this.userLay.setLayoutParams(localLayoutParams);
        }
        for (; ; ) {
            localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
            if ((this.context != null) && (this.context.getForumStatus() != null) && (!this.context.getForumStatus().isLogin())) {
                localLayoutParams.addRule(13);
            }
            localLayoutParams.setMargins(0, this.context.getResources().getDimensionPixelOffset(2131427372), 0, 0);
            this.user.setLayoutParams(localLayoutParams);
            return;
            this.userLay.setBackgroundResource(2130837879);
            this.userLay.setLayoutParams(localLayoutParams);
        }
    }

    private void setListSelector(View paramView, TextView paramTextView) {
        initColorRender();
        StateListDrawable localStateListDrawable = new StateListDrawable();
        ColorDrawable localColorDrawable = new ColorDrawable(this.itemBackColorRender.getSelectedColor());
        localStateListDrawable.addState(new int[]{16842919}, localColorDrawable);
        localColorDrawable = new ColorDrawable(this.itemBackColorRender.getSelectedColor());
        localStateListDrawable.addState(new int[]{16842913}, localColorDrawable);
        localColorDrawable = new ColorDrawable(this.itemBackColorRender.getSelectedColor());
        localStateListDrawable.addState(new int[]{16842908}, localColorDrawable);
        localColorDrawable = new ColorDrawable(this.itemBackColorRender.getDefaultColor());
        localStateListDrawable.addState(new int[0], localColorDrawable);
        paramView.setBackgroundDrawable(localStateListDrawable);
        paramView = new StateListDrawable();
        localColorDrawable = new ColorDrawable(this.itemCharacterColorRender.getSelectedColor());
        localStateListDrawable.addState(new int[]{16842919}, localColorDrawable);
        localColorDrawable = new ColorDrawable(this.itemCharacterColorRender.getSelectedColor());
        localStateListDrawable.addState(new int[]{16842913}, localColorDrawable);
        localColorDrawable = new ColorDrawable(this.itemCharacterColorRender.getSelectedColor());
        localStateListDrawable.addState(new int[]{16842908}, localColorDrawable);
        localColorDrawable = new ColorDrawable(this.itemCharacterColorRender.getDefaultColor());
        localStateListDrawable.addState(new int[0], localColorDrawable);
        paramTextView.setBackgroundDrawable(paramView);
    }

    public int getCount() {
        return this.tabItemList.size();
    }

    public long getHeaderId(int paramInt) {
        if ((getItem(0) != null) && (getItem(0).getMenuid() == 1010)) {
            return 0L;
        }
        return -1L;
    }

    public View getHeaderView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        paramViewGroup = paramView;
        if (getItem(0) != null) {
            paramViewGroup = paramView;
            if (getItem(0).getMenuid() == 1010) {
                if (!SettingsFragment.isRebranding(this.context)) {
                    break label338;
                }
                if (!this.context.getResources().getBoolean(2131558402)) {
                    break label287;
                }
                paramViewGroup = LayoutInflater.from(this.context).inflate(2130903194, null);
                this.userLay = ((RelativeLayout) paramViewGroup.findViewById(2131231189));
                this.userIcon = ((ImageView) paramViewGroup.findViewById(2131230794));
                this.user = ((RelativeLayout) paramViewGroup.findViewById(2131231021));
                this.user.setEnabled(false);
                this.forum_name = ((TextView) paramViewGroup.findViewById(2131231178));
                this.userName = ((TextView) paramViewGroup.findViewById(2131231190));
                this.proboard = ((ImageView) paramViewGroup.findViewById(2131231014));
                setHeaderBack();
                paramView = this.context.getForumStatus();
                if ((this.context.getForumStatus() != null) && (this.context.getForumStatus().isLogin())) {
                    this.userName.setText(paramView.tapatalkForum.getDisplayNameOrUsername());
                }
                if (SettingsFragment.isRebranding(this.context)) {
                    break label374;
                }
                this.forum_name.setText(paramView.tapatalkForum.getName());
                AvatarTool.showLogo(this.context, this.userIcon, paramView.tapatalkForum.getIconUrl(), 5);
                if ((paramView.tapatalkForum.getType() == null) || (!paramView.tapatalkForum.equals("proboards"))) {
                    break label362;
                }
                this.proboard.setVisibility(0);
            }
        }
        for (; ; ) {
            paramView.tapatalkForum.getIconFromFile(this.context);
            return paramViewGroup;
            label287:
            if (this.context.getResources().getBoolean(2131558406)) {
                paramViewGroup = LayoutInflater.from(this.context).inflate(2130903193, null);
                break;
            }
            paramViewGroup = LayoutInflater.from(this.context).inflate(2130903194, null);
            break;
            label338:
            paramViewGroup = paramView;
            if (paramView != null) {
                break;
            }
            paramViewGroup = LayoutInflater.from(this.context).inflate(2130903193, null);
            break;
            label362:
            this.proboard.setVisibility(8);
            continue;
            label374:
            if ((paramView.tapatalkForum.getIconUrl() != null) && (!paramView.tapatalkForum.getIconUrl().equals(""))) {
                AvatarTool.showLogo(this.context, this.userIcon, paramView.tapatalkForum.getIconUrl(), 5);
            }
            for (; ; ) {
                if (TapatalkApp.rebranding_url.contains("xda-developers")) {
                    this.userIcon.setBackgroundColor(-1);
                }
                if (this.context.getResources().getBoolean(2131558406)) {
                    break label491;
                }
                this.forum_name.setText(TapatalkApp.rebranding_name);
                break;
                this.userIcon.setImageDrawable(this.context.getResources().getDrawable(2130837525));
            }
            label491:
            this.forum_name.setText(paramView.tapatalkForum.getName());
        }
    }

    public TabItem getItem(int paramInt) {
        return (TabItem) this.tabItemList.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public int getItemViewType(int paramInt) {
        if ((getItem(paramInt) != null) && (getItem(paramInt).getMenuid() == 1010)) {
            return 0;
        }
        if ((getItem(paramInt) != null) && (getItem(paramInt).getMenuid() == 1031)) {
            return 1;
        }
        if ((getItem(paramInt) != null) && (getItem(paramInt).getMenuid() == 1044)) {
            return 2;
        }
        return 3;
    }

    public int getPositionForSection(int paramInt) {
        return -1;
    }

    public int getSectionForPosition(int paramInt) {
        return -1;
    }

    public Object[] getSections() {
        return null;
    }

    public int getSelection() {
        int i = 0;
        for (; ; ) {
            int j;
            if (i >= this.tabItemList.size()) {
                j = 0;
            }
            do {
                return j;
                j = i;
            } while (((TabItem) this.tabItemList.get(i)).isSelected());
            i += 1;
        }
    }

    public View getSlidingMenuTabView(View paramView, int paramInt) {
        initColorRender();
        paramView = getItem(paramInt);
        if (!paramView.isDiver()) {
            localView = LayoutInflater.from(this.context).inflate(2130903215, null);
            TextView localTextView = (TextView) localView.findViewById(2131231255);
            ImageView localImageView = (ImageView) localView.findViewById(2131231256);
            localTextView.setText(paramView.getTabName());
            localTextView.setTextColor(this.itemCharacterColorRender.getDefaultColor());
            if (paramView.isSelected()) {
                localView.setBackgroundColor(this.itemBackColorRender.getSelectedColor());
                localTextView.setTextColor(this.itemCharacterColorRender.getSelectedColor());
                localImageView.setImageResource(paramView.getIconSelected());
                return localView;
            }
            setListSelector(localView, localTextView);
            localImageView.setImageResource(paramView.getIcon());
            return localView;
        }
        View localView = LayoutInflater.from(this.context).inflate(2130903214, null);
        ((TextView) localView.findViewById(2131231255)).setText(paramView.getTabName());
        return localView;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        if ((getItem(paramInt) != null) && (getItem(paramInt).getMenuid() == 1010)) {
            return new View(this.context);
        }
        if (getItem(paramInt).getMenuid() == 1044) {
            return setNewTopicView(paramView, paramInt);
        }
        return getSlidingMenuTabView(paramView, paramInt);
    }

    public int getViewTypeCount() {
        return 4;
    }

    public void initColorRender() {
        if ((this.itemBackColorRender == null) || (this.itemCharacterColorRender == null)) {
            this.itemColorBackFactory = new BackListItemBackColorFactory();
            this.itemBackColorRender = this.itemColorBackFactory.createColorRender(this.context, -1);
            this.itemCharacterColorFactory = new BackListItemCharacterColorFactory();
            this.itemCharacterColorRender = this.itemCharacterColorFactory.createColorRender(this.context, -1);
        }
    }

    public boolean isEnabled(int paramInt) {
        return true;
    }

    public View setNewTopicView(View paramView, int paramInt) {
        View localView = paramView;
        LinearLayout localLinearLayout;
        TextView localTextView;
        if (getItem(paramInt) != null) {
            localView = paramView;
            if (getItem(paramInt).getMenuid() == 1044) {
                localView = LayoutInflater.from(this.context).inflate(2130903127, null);
                paramView = (ImageView) localView.findViewById(2131230987);
                paramView.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("slidingmenu_newtopic_icon", this.context));
                localLinearLayout = (LinearLayout) localView.findViewById(2131230986);
                localTextView = (TextView) localView.findViewById(2131230919);
                localLinearLayout.setBackgroundResource(2130837517);
                paramView.setBackgroundResource(2130839316);
                localLinearLayout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View paramAnonymousView) {
                    }
                });
                if (!"banned".equals(this.context.getForumStatus().getUserType())) {
                    break label154;
                }
                localTextView.setText(this.context.getString(2131100706));
            }
        }
        return localView;
        label154:
        if ("unapproved".equals(this.context.getForumStatus().getUserType())) {
            localTextView.setText(this.context.getString(2131100707));
            return localView;
        }
        if ("inactive".equals(this.context.getForumStatus().getUserType())) {
            localTextView.setText(this.context.getString(2131100708));
            return localView;
        }
        if ("validating".equals(this.context.getForumStatus().getUserType())) {
            localTextView.setText(this.context.getString(2131100709));
            return localView;
        }
        localLinearLayout.setBackgroundResource(2130837516);
        paramView.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("slidingmenu_newtopic_icon", this.context));
        localLinearLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                paramAnonymousView = new Intent(BackListAdapter.this.context, ModerateActivity.class);
                paramAnonymousView.putExtra("forumStatus", BackListAdapter.this.context.getForumStatus());
                paramAnonymousView.putExtra("select_forum_action", 0);
                BackListAdapter.this.context.startActivity(paramAnonymousView);
            }
        });
        return localView;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/slidingMenu/BackListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */