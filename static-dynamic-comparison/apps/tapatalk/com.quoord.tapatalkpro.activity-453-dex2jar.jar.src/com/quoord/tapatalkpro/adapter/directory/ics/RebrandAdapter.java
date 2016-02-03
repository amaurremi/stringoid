package com.quoord.tapatalkpro.adapter.directory.ics;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.activity.directory.ics.IcsRebrandingEntryActivity;
import com.quoord.tapatalkpro.activity.directory.ics.RebrandFragment;
import com.quoord.tapatalkpro.bean.ForumItemBean;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.util.AvatarTool;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;

import java.util.ArrayList;

public class RebrandAdapter
        extends BaseAdapter {
    public String cacheFile = null;
    public ArrayList<Object> forumItemId = new ArrayList();
    private FavoriateSqlHelper helper;
    public ArrayList<ForumItemBean> list = new ArrayList();
    public Activity mActivity = null;
    public ArrayList<ForumItemBean> mDatas = new ArrayList();
    private Typeface tf;

    public RebrandAdapter(Activity paramActivity) {
        this.mActivity = paramActivity;
        this.cacheFile = AppCacheManager.getRebrandAdapterUrl(this.mActivity);
        this.tf = Typeface.createFromAsset(this.mActivity.getAssets(), "font/Roboto-Light.ttf");
        addDefualtForum();
        getLoginForum();
        getCacheForum();
    }

    private void setSection(LinearLayout paramLinearLayout, String paramString) {
        TextView localTextView = new TextView(this.mActivity);
        paramLinearLayout.setBackgroundColor(-5588020);
        localTextView.setTextColor(-1);
        localTextView.setText(paramString.substring(0, 1).toUpperCase());
        localTextView.setTextSize(20.0F);
        localTextView.setPadding(5, 0, 0, 0);
        localTextView.setGravity(16);
        paramLinearLayout.addView(localTextView);
    }

    public void addDefualtForum() {
        if (this.mDatas.size() == 0) {
            ForumItemBean localForumItemBean = new ForumItemBean();
            localForumItemBean.setForumUrl("http://tow411.yuku.com/");
            localForumItemBean.setForumName("Tow411");
            localForumItemBean.setForumId(Util.getMD5(new String("tow411")).hashCode());
            this.mDatas.add(localForumItemBean);
            this.forumItemId.add(Integer.valueOf(Util.getMD5(new String("tow411")).hashCode()));
            localForumItemBean = new ForumItemBean();
            localForumItemBean.setForumUrl("http://yukusupport.yuku.com/");
            localForumItemBean.setForumName("Welcome to Yuku Support");
            localForumItemBean.setForumId(Util.getMD5(new String("yukusupport")).hashCode());
            this.mDatas.add(localForumItemBean);
            this.forumItemId.add(Integer.valueOf(Util.getMD5(new String("yukusupport")).hashCode()));
            localForumItemBean = new ForumItemBean();
            localForumItemBean.setForumUrl("http://jjb.yuku.com/");
            localForumItemBean.setForumName("theJJB.com");
            localForumItemBean.setForumId(Util.getMD5(new String("jjb")).hashCode());
            this.mDatas.add(localForumItemBean);
            this.forumItemId.add(Integer.valueOf(Util.getMD5(new String("jjb")).hashCode()));
            localForumItemBean = new ForumItemBean();
            localForumItemBean.setForumUrl("http://survivorsucks.yuku.com/");
            localForumItemBean.setForumName("Survivor Sucks");
            localForumItemBean.setForumId(Util.getMD5(new String("survivorsucks")).hashCode());
            this.mDatas.add(localForumItemBean);
            this.forumItemId.add(Integer.valueOf(Util.getMD5(new String("survivorsucks")).hashCode()));
        }
    }

    public void getCacheForum() {
        if (AppCacheManager.checkFile(this.cacheFile)) {
        }
        try {
            Object localObject = AppCacheManager.getCacheData(this.cacheFile);
            if (((localObject instanceof ArrayList)) && (localObject != null)) {
                this.mDatas = ((ArrayList) localObject);
                this.mDatas.addAll(0, this.list);
                i = 0;
                if (i < this.mDatas.size()) {
                    break label79;
                }
                notifyDataSetChanged();
            }
        } catch (Exception localException) {
            int i;
            int j;
            for (; ; ) {
            }
        }
        AppCacheManager.cacheData(this.cacheFile, this.mDatas);
        return;
        label79:
        j = 0;
        for (; ; ) {
            if (j >= this.list.size()) {
                i += 1;
                break;
            }
            if ((((ForumItemBean) this.mDatas.get(i)).getForumName().equals(((ForumItemBean) this.list.get(j)).getForumName())) && (((ForumItemBean) this.mDatas.get(i)).getUserName() == null)) {
                this.mDatas.remove(i);
            }
            j += 1;
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

    public void getLoginForum() {
        this.list.clear();
        this.helper = new FavoriateSqlHelper(this.mActivity, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version));
        ArrayList localArrayList = this.helper.getFavrivate();
        int i = 0;
        for (; ; ) {
            if (i >= localArrayList.size()) {
                return;
            }
            if ((((TapatalkForum) localArrayList.get(i)).getUserName() != null) && (((TapatalkForum) localArrayList.get(i)).getUserName().length() > 0) && (((TapatalkForum) localArrayList.get(i)).hasPassword())) {
                ForumItemBean localForumItemBean = new ForumItemBean();
                TapatalkForum localTapatalkForum = (TapatalkForum) localArrayList.get(i);
                localForumItemBean.setForumName(localTapatalkForum.getName());
                localForumItemBean.setForumId(localTapatalkForum.getId().intValue());
                localForumItemBean.setForumUrl(localTapatalkForum.getUrl());
                localForumItemBean.setIconUrl(localTapatalkForum.getIconUrl());
                localForumItemBean.setUserName(((TapatalkForum) localArrayList.get(i)).getUserName());
                this.list.add(localForumItemBean);
            }
            i += 1;
        }
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        Object localObject1 = (ForumItemBean) this.mDatas.get(paramInt);
        label173:
        label194:
        Object localObject2;
        label262:
        int i;
        if (paramView == null) {
            paramView = this.mActivity.getLayoutInflater().inflate(2130903279, null);
            paramViewGroup = new ViewHolder(null);
            paramViewGroup.icon = ((ImageView) paramView.findViewById(2131230992));
            paramViewGroup.text = ((TextView) paramView.findViewById(2131230904));
            paramViewGroup.description = ((TextView) paramView.findViewById(2131230993));
            paramViewGroup.header = ((LinearLayout) paramView.findViewById(2131231398));
            paramViewGroup.textView = ((TextView) paramView.findViewById(2131230838));
            paramViewGroup.icon.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("avator_background", this.mActivity));
            paramView.setTag(paramViewGroup);
            if ((((ForumItemBean) localObject1).getIconUrl() == null) || (((ForumItemBean) localObject1).getIconUrl().equals(""))) {
                break label407;
            }
            AvatarTool.showLogo(this.mActivity, paramViewGroup.icon, ((ForumItemBean) localObject1).getIconUrl(), 5);
            if (paramInt % 2 != 1) {
                break label430;
            }
            paramView.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("favforum_item1_color", this.mActivity));
            paramViewGroup.description.setTypeface(this.tf);
            paramViewGroup.description.setText(((ForumItemBean) localObject1).getForumName());
            localObject2 = this.helper.getFavrivate();
            if ((((ArrayList) localObject2).size() <= paramInt) || (!((TapatalkForum) ((ArrayList) localObject2).get(paramInt)).hasPassword())) {
                break label447;
            }
            paramViewGroup.text.setText(((ForumItemBean) localObject1).getUserName());
            localObject2 = ((ForumItemBean) this.mDatas.get(paramInt)).getForumName();
            i = (((ForumItemBean) localObject1).getForumId() + ((ForumItemBean) localObject1).getUserName()).hashCode();
            if (((IcsRebrandingEntryActivity) this.mActivity).allInOneFragment.selectedPosition == i) {
                if (!SettingsFragment.isLightTheme(this.mActivity)) {
                    break label489;
                }
                paramView.setBackgroundResource(2131165504);
            }
            label344:
            if ((localObject2 != null) && (!((String) localObject2).equals(""))) {
                i = ((String) localObject2).toUpperCase().charAt(0);
                if (paramInt != 0) {
                    break label499;
                }
                setSection(paramViewGroup.header, (String) localObject2);
            }
        }
        for (; ; ) {
            paramViewGroup.textView.setText((CharSequence) localObject2);
            return paramView;
            paramViewGroup = (ViewHolder) paramView.getTag();
            break;
            label407:
            paramViewGroup.icon.setImageDrawable(this.mActivity.getResources().getDrawable(2130837853));
            break label173;
            label430:
            paramView.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("favforum_item2_color", this.mActivity));
            break label194;
            label447:
            paramViewGroup.text.setText(((ForumItemBean) localObject1).getForumUrl().replaceAll("https://", "").replaceAll("http://", "").replaceAll("/", ""));
            break label262;
            label489:
            paramView.setBackgroundResource(2131165509);
            break label344;
            label499:
            localObject1 = ((ForumItemBean) this.mDatas.get(paramInt - 1)).getForumName();
            if ((localObject1 != null) && (!((String) localObject1).equals(""))) {
                if (i != ((String) localObject1).toUpperCase().charAt(0)) {
                    setSection(paramViewGroup.header, (String) localObject2);
                    paramViewGroup.header.setVisibility(0);
                } else {
                    paramViewGroup.header.setVisibility(8);
                }
            }
        }
    }

    private class ViewHolder {
        TextView description;
        LinearLayout header;
        ImageView icon;
        TextView text;
        TextView textView;

        private ViewHolder() {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/directory/ics/RebrandAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */