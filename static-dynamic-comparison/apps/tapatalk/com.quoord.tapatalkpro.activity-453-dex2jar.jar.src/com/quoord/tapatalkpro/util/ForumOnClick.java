package com.quoord.tapatalkpro.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.action.TapatalkAccountAction;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;

import java.net.URLEncoder;

public class ForumOnClick
        implements View.OnClickListener {
    boolean canRemove = false;
    private String channel = "account";
    String fid;
    TapatalkForum forum;
    ImageView imageView;
    boolean isNewSearch = false;
    View layout;
    Activity mContext;

    public ForumOnClick(String paramString1, TapatalkForum paramTapatalkForum, Activity paramActivity, ImageView paramImageView, View paramView, String paramString2) {
        this(paramString1, paramTapatalkForum, paramActivity, paramImageView, paramView, paramString2, false, false);
    }

    public ForumOnClick(String paramString1, TapatalkForum paramTapatalkForum, Activity paramActivity, ImageView paramImageView, View paramView, String paramString2, boolean paramBoolean) {
        this(paramString1, paramTapatalkForum, paramActivity, paramImageView, paramView, paramString2, paramBoolean, false);
    }

    public ForumOnClick(String paramString1, TapatalkForum paramTapatalkForum, Activity paramActivity, ImageView paramImageView, View paramView, String paramString2, boolean paramBoolean1, boolean paramBoolean2) {
        this.imageView = paramImageView;
        this.layout = paramView;
        this.mContext = paramActivity;
        this.forum = paramTapatalkForum;
        this.fid = paramString1;
        this.channel = paramString2;
        this.isNewSearch = paramBoolean1;
        this.canRemove = paramBoolean2;
    }

    private void removeFavorite(TapatalkForum paramTapatalkForum, Context paramContext) {
        TapatalkAccountAction.deleteCurrenForums(paramTapatalkForum);
        paramContext = new FavoriateSqlHelper(this.mContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version));
        Object localObject = paramContext.getFavrivateById(Integer.toString(paramTapatalkForum.getId().intValue()));
        if ((localObject != null) && (((TapatalkForum) localObject).getId().equals(paramTapatalkForum.getId()))) {
            paramContext.deleteFavoriate((TapatalkForum) localObject);
        }
        paramContext = Prefs.get(this.mContext);
        localObject = new StringBuilder();
        ((StringBuilder) localObject).append(TapatalkJsonEngine.AU_DELETE_ACCONT).append("?au_id=").append(paramContext.getInt("tapatalk_auid", 0)).append("&token=").append(paramContext.getString("token", "")).append("&fid=").append(paramTapatalkForum.getId());
        if (paramTapatalkForum.getUserName() != null) {
            ((StringBuilder) localObject).append("&username=").append(URLEncoder.encode(paramTapatalkForum.getUserName()));
        }
        if (paramTapatalkForum.getUserId() != null) {
            ((StringBuilder) localObject).append("&uid=").append(paramTapatalkForum.getUserId());
        }
        TapatalkJsonEngine.callLogin(this.mContext, ((StringBuilder) localObject).toString());
        ((StringBuilder) localObject).setLength(0);
    }

    public void onClick(View paramView) {
        if ((this.isNewSearch) && (!this.canRemove)) {
            this.layout.setVisibility(8);
        }
        while (this.canRemove) {
            if (Util.isFavoriate(this.mContext, this.forum.getId().intValue())) {
                removeFavorite(this.forum, this.mContext);
                this.imageView.setImageResource(2130837512);
                return;
                this.imageView.setImageResource(2130837513);
            } else {
                TapatalkJsonEngine.auAddAccount(this.mContext, this.fid, "Guest", null, "0", null, this.channel, this.forum);
                saveFavoriate(this.forum, this.mContext);
                Util.showToastDialog(this.mContext, this.mContext.getResources().getString(2131099707));
                this.imageView.setImageResource(2130837513);
                return;
            }
        }
        this.layout.setClickable(false);
        TapatalkJsonEngine.auAddAccount(this.mContext, this.fid, "Guest", null, "0", null, this.channel, this.forum);
        saveFavoriate(this.forum, this.mContext);
        Util.showToastDialog(this.mContext, this.mContext.getResources().getString(2131099707));
    }

    public void saveFavoriate(TapatalkForum paramTapatalkForum, Context paramContext) {
        paramContext = new FavoriateSqlHelper(this.mContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version));
        TapatalkAccountAction.addToCurrenForums(paramTapatalkForum, this.mContext);
        TapatalkForum localTapatalkForum = paramContext.getFavrivateById(paramTapatalkForum.getId());
        if ((localTapatalkForum == null) || (localTapatalkForum.getId().intValue() != paramTapatalkForum.getId().intValue())) {
            paramContext.saveFavoriate(paramTapatalkForum);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/ForumOnClick.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */