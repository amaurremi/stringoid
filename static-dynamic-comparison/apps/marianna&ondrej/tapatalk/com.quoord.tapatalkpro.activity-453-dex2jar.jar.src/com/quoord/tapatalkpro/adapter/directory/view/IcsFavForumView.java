package com.quoord.tapatalkpro.adapter.directory.view;

import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Glide.Request;
import com.bumptech.glide.Glide.RequestListener;
import com.bumptech.glide.presenter.target.Target;
import com.quoord.DialogUtil.AccountDialog;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.action.Logout;
import com.quoord.tapatalkpro.adapter.directory.FavoriteForumAdapter;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.ImageTools;

import java.text.NumberFormat;
import java.util.Locale;

public class IcsFavForumView {
    private Activity mActivity;
    private FavoriteForumAdapter mAdapter;
    private TapatalkForum mForum;
    private boolean mIsLast;
    private String mProfileAvatarUrl = null;
    private boolean mShowFlag;
    private boolean mTapatalkLogin;

    public IcsFavForumView(Activity paramActivity, FavoriteForumAdapter paramFavoriteForumAdapter, boolean paramBoolean) {
        this.mActivity = paramActivity;
        this.mAdapter = paramFavoriteForumAdapter;
        this.mTapatalkLogin = paramBoolean;
    }

    private void hideForum(TapatalkForum paramTapatalkForum, ImageView paramImageView) {
        paramImageView.setImageResource(2130838801);
        paramTapatalkForum.setHide(Integer.valueOf(1));
    }

    private IcsFavForumViewHolder initViewHolder(View paramView) {
        IcsFavForumViewHolder localIcsFavForumViewHolder = new IcsFavForumViewHolder(null);
        localIcsFavForumViewHolder.itemLayout = paramView.findViewById(2131231152);
        localIcsFavForumViewHolder.forumLogoImg = ((ImageView) paramView.findViewById(2131231153));
        localIcsFavForumViewHolder.proboardImg = ((ImageView) paramView.findViewById(2131231154));
        localIcsFavForumViewHolder.userAvatarImg = ((ImageView) paramView.findViewById(2131231155));
        localIcsFavForumViewHolder.forumNameTv = ((TextView) paramView.findViewById(2131231156));
        localIcsFavForumViewHolder.userCountIcon = ((ImageView) paramView.findViewById(2131231158));
        localIcsFavForumViewHolder.userCountTv = ((TextView) paramView.findViewById(2131231159));
        localIcsFavForumViewHolder.threadCountIcon = ((ImageView) paramView.findViewById(2131231160));
        localIcsFavForumViewHolder.threadCountTv = ((TextView) paramView.findViewById(2131231161));
        localIcsFavForumViewHolder.forumDescriptionTv = ((TextView) paramView.findViewById(2131231162));
        localIcsFavForumViewHolder.signLayout = paramView.findViewById(2131231164);
        localIcsFavForumViewHolder.signInfoTv = ((TextView) paramView.findViewById(2131231165));
        localIcsFavForumViewHolder.signoutIcon = ((ImageView) paramView.findViewById(2131231166));
        localIcsFavForumViewHolder.signinIcon = ((ImageView) paramView.findViewById(2131231167));
        localIcsFavForumViewHolder.signinTv = ((TextView) paramView.findViewById(2131231168));
        localIcsFavForumViewHolder.editLayout = paramView.findViewById(2131231169);
        localIcsFavForumViewHolder.hideImg = ((ImageView) paramView.findViewById(2131231170));
        localIcsFavForumViewHolder.slideImg = ((ImageView) paramView.findViewById(2131231171));
        localIcsFavForumViewHolder.removeImg = ((ImageView) paramView.findViewById(2131231172));
        localIcsFavForumViewHolder.signinIcon.setImageDrawable(ThemeUtil.getDrawableByPicName("profile_signin", this.mActivity));
        localIcsFavForumViewHolder.signoutIcon.setImageDrawable(ThemeUtil.getDrawableByPicName("profile_signout", this.mActivity));
        return localIcsFavForumViewHolder;
    }

    private void setEditArea(IcsFavForumViewHolder paramIcsFavForumViewHolder, final int paramInt) {
        if (this.mShowFlag) {
            paramIcsFavForumViewHolder.editLayout.setVisibility(0);
            paramIcsFavForumViewHolder.removeImg.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    AccountDialog.showDeleteDialog(paramInt, IcsFavForumView.this.mActivity, IcsFavForumView.this.mAdapter);
                }
            });
            if (!this.mForum.isHide()) {
                break label76;
            }
            paramIcsFavForumViewHolder.hideImg.setImageResource(2130838801);
        }
        for (; ; ) {
            paramIcsFavForumViewHolder.hideImg.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    if (IcsFavForumView.this.mForum.isHide()) {
                        IcsFavForumView.this.showForum(IcsFavForumView.this.mForum, (ImageView) paramAnonymousView);
                        return;
                    }
                    IcsFavForumView.this.hideForum(IcsFavForumView.this.mForum, (ImageView) paramAnonymousView);
                }
            });
            return;
            paramIcsFavForumViewHolder.editLayout.setVisibility(8);
            return;
            label76:
            paramIcsFavForumViewHolder.hideImg.setImageResource(2130838804);
        }
    }

    private void setForumInfo(IcsFavForumViewHolder paramIcsFavForumViewHolder) {
        if (!Util.isEmpty(this.mForum.getName())) {
            paramIcsFavForumViewHolder.forumNameTv.setText(this.mForum.getName());
        }
        NumberFormat localNumberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
        if (Util.isEmpty(this.mForum.getTapatalkUserCount())) {
            paramIcsFavForumViewHolder.userCountTv.setText("--");
            if (!Util.isEmpty(this.mForum.getTotalThreads())) {
                break label124;
            }
            paramIcsFavForumViewHolder.threadCountTv.setText("--");
        }
        for (; ; ) {
            if (!Util.isEmpty(this.mForum.getDescription())) {
                break label145;
            }
            paramIcsFavForumViewHolder.forumDescriptionTv.setVisibility(8);
            return;
            paramIcsFavForumViewHolder.userCountTv.setText(localNumberFormat.format(this.mForum.getTapatalkUserCount()));
            break;
            label124:
            paramIcsFavForumViewHolder.threadCountTv.setText(localNumberFormat.format(this.mForum.getTotalThreads()));
        }
        label145:
        paramIcsFavForumViewHolder.forumDescriptionTv.setVisibility(0);
        paramIcsFavForumViewHolder.forumDescriptionTv.setText(this.mForum.getDescription());
    }

    private void setForumLogo(IcsFavForumViewHolder paramIcsFavForumViewHolder) {
        ImageTools.glideLoad(this.mForum.getIconUrl(), paramIcsFavForumViewHolder.forumLogoImg);
        if ((this.mForum.getType() != null) && (this.mForum.getType().equals("proboards"))) {
            paramIcsFavForumViewHolder.proboardImg.setVisibility(0);
            return;
        }
        paramIcsFavForumViewHolder.proboardImg.setVisibility(8);
    }

    private void setSignArea(IcsFavForumViewHolder paramIcsFavForumViewHolder, final int paramInt) {
        String str = this.mForum.getDisplayNameOrUsername();
        int i;
        if ((!Util.isEmpty(str)) && (!Util.isSignOutUser(this.mActivity, this.mForum))) {
            i = 1;
            if (i == 0) {
                break label153;
            }
            paramIcsFavForumViewHolder.signInfoTv.setVisibility(0);
            paramIcsFavForumViewHolder.signoutIcon.setVisibility(0);
            paramIcsFavForumViewHolder.signinTv.setVisibility(8);
            paramIcsFavForumViewHolder.signinIcon.setVisibility(8);
            str = this.mActivity.getString(2131100590) + " " + str;
            paramIcsFavForumViewHolder.signInfoTv.setText(str);
        }
        for (; ; ) {
            if (!this.mShowFlag) {
                break label207;
            }
            paramIcsFavForumViewHolder.signinIcon.setOnClickListener(null);
            paramIcsFavForumViewHolder.signinTv.setOnClickListener(null);
            paramIcsFavForumViewHolder.signoutIcon.setOnClickListener(null);
            return;
            i = 0;
            break;
            label153:
            paramIcsFavForumViewHolder.signInfoTv.setVisibility(8);
            paramIcsFavForumViewHolder.signoutIcon.setVisibility(8);
            paramIcsFavForumViewHolder.signinTv.setVisibility(0);
            paramIcsFavForumViewHolder.signinIcon.setVisibility(0);
            paramIcsFavForumViewHolder.signinTv.setText(this.mActivity.getString(2131100518));
        }
        label207:
        paramIcsFavForumViewHolder.signinIcon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                IcsFavForumView.this.signIn();
            }
        });
        paramIcsFavForumViewHolder.signinTv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                IcsFavForumView.this.signIn();
            }
        });
        paramIcsFavForumViewHolder.signoutIcon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                IcsFavForumView.this.signOut(paramInt);
            }
        });
    }

    private void setUserAvatar(final IcsFavForumViewHolder paramIcsFavForumViewHolder) {
        if ((!Util.isEmpty(this.mForum.getDisplayNameOrUsername())) && (!Util.isSignOutUser(this.mActivity, this.mForum))) {
        }
        for (int i = 1; ; i = 0) {
            if ((Util.isEmpty(this.mForum.getUserIconUrl())) && (!Util.isEmpty(this.mForum.getUrl())) && (!Util.isEmpty(this.mForum.getUserId())) && (!this.mForum.getUserId().equals("0"))) {
                this.mForum.setUserIconUrl(this.mForum.getUrl() + "/mobiquo/avatar.php?user_id=" + this.mForum.getUserId());
            }
            if ((i != 0) && ((Util.isEmpty(this.mForum.getUserIconUrl())) || (this.mForum.getUserIconUrl().equals("-1")))) {
                break;
            }
            try {
                Glide.load(this.mForum.getUserIconUrl()).placeholder(2130837856).listener(new Glide.RequestListener() {
                    public void onException(Exception paramAnonymousException, String paramAnonymousString, Target paramAnonymousTarget) {
                        try {
                            if (IcsFavForumView.this.mAdapter.getProfileBitmap() != null) {
                                paramIcsFavForumViewHolder.userAvatarImg.setImageBitmap(IcsFavForumView.this.mAdapter.getProfileBitmap());
                            }
                            for (; ; ) {
                                IcsFavForumView.this.mForum.setUserIconUrl("-1");
                                new FavoriateSqlHelper(IcsFavForumView.this.mActivity, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).saveFavoriate(IcsFavForumView.this.mForum);
                                return;
                                paramIcsFavForumViewHolder.userAvatarImg.setImageResource(2130837856);
                            }
                            return;
                        } catch (Exception paramAnonymousException) {
                        }
                    }

                    public void onImageReady(String paramAnonymousString, Target paramAnonymousTarget) {
                    }
                }).into(paramIcsFavForumViewHolder.userAvatarImg);
                return;
            } catch (Exception paramIcsFavForumViewHolder) {
            }
        }
        if (this.mAdapter.getProfileBitmap() != null) {
            paramIcsFavForumViewHolder.userAvatarImg.setImageBitmap(this.mAdapter.getProfileBitmap());
            return;
        }
        paramIcsFavForumViewHolder.userAvatarImg.setImageResource(2130837856);
        return;
        if (this.mTapatalkLogin) {
            paramIcsFavForumViewHolder.userAvatarImg.setImageResource(2130837857);
            return;
        }
        paramIcsFavForumViewHolder.userAvatarImg.setImageResource(2130837858);
        return;
    }

    private void showForum(TapatalkForum paramTapatalkForum, ImageView paramImageView) {
        paramImageView.setImageResource(2130838804);
        paramTapatalkForum.setHide(Integer.valueOf(0));
    }

    private void signIn() {
        this.mForum.openTapatalkForum(this.mActivity, true);
    }

    private void signOut(int paramInt) {
        Logout.begin(this.mForum, this.mActivity);
        this.mAdapter.signOutForum(paramInt);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                IcsFavForumView.this.mAdapter.notifyDataSetChanged();
            }
        }, 50L);
    }

    private void updateViewHolder(IcsFavForumViewHolder paramIcsFavForumViewHolder, int paramInt) {
        if (this.mForum == null) {
            return;
        }
        setForumInfo(paramIcsFavForumViewHolder);
        setUserAvatar(paramIcsFavForumViewHolder);
        setForumLogo(paramIcsFavForumViewHolder);
        setSignArea(paramIcsFavForumViewHolder, paramInt);
        setEditArea(paramIcsFavForumViewHolder, paramInt);
        Util.setBg(paramIcsFavForumViewHolder.itemLayout, ThemeUtil.getBgDrawableByPicNameForList("list_item_bg_normal", this.mActivity, this.mIsLast));
    }

    public View getView(TapatalkForum paramTapatalkForum, int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2) {
        this.mForum = paramTapatalkForum;
        this.mShowFlag = paramBoolean1;
        this.mIsLast = paramBoolean2;
        if (paramView == null) {
            paramView = this.mActivity.getLayoutInflater().inflate(2130903185, paramViewGroup, false);
            paramTapatalkForum = initViewHolder(paramView);
            paramView.setTag(paramTapatalkForum);
        }
        for (; ; ) {
            updateViewHolder(paramTapatalkForum, paramInt);
            return paramView;
            paramTapatalkForum = (IcsFavForumViewHolder) paramView.getTag();
        }
    }

    public void setProfileAvatar(String paramString) {
        this.mProfileAvatarUrl = paramString;
    }

    private static class IcsFavForumViewHolder {
        View editLayout;
        TextView forumDescriptionTv;
        ImageView forumLogoImg;
        TextView forumNameTv;
        ImageView hideImg;
        View itemLayout;
        ImageView proboardImg;
        ImageView removeImg;
        TextView signInfoTv;
        View signLayout;
        ImageView signinIcon;
        TextView signinTv;
        ImageView signoutIcon;
        ImageView slideImg;
        ImageView threadCountIcon;
        TextView threadCountTv;
        ImageView userAvatarImg;
        ImageView userCountIcon;
        TextView userCountTv;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/directory/view/IcsFavForumView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */