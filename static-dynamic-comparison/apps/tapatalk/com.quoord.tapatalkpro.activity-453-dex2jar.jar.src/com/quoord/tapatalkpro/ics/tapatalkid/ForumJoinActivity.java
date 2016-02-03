package com.quoord.tapatalkpro.ics.tapatalkid;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.util.AvatarTool;
import com.quoord.tapatalkpro.view.TapaButton;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ForumJoinActivity
        extends FragmentActivity
        implements ForumActivityStatus {
    Bitmap bitmap2;
    TapaButton leaveButton;
    ForumStatus mForumStatus;
    ImageView mImage;
    TextView mText;
    LinearLayout rootLay;
    TapaButton tpButton;

    private Bitmap getBitmapFromUrl(String paramString) {
        Object localObject4 = null;
        Object localObject3 = null;
        Object localObject1 = localObject3;
        Object localObject2 = localObject4;
        try {
            BufferedInputStream localBufferedInputStream = new BufferedInputStream(new URL(paramString).openConnection().getInputStream());
            localObject1 = localObject3;
            localObject2 = localObject4;
            paramString = BitmapFactory.decodeStream(localBufferedInputStream);
            localObject1 = paramString;
            localObject2 = paramString;
            localBufferedInputStream.close();
            return paramString;
        } catch (MalformedURLException paramString) {
            paramString.printStackTrace();
            return (Bitmap) localObject1;
        } catch (IOException paramString) {
            paramString.printStackTrace();
        }
        return (Bitmap) localObject2;
    }

    public void clickFinish(View paramView) {
        finish();
    }

    public void clickToJoin(View paramView) {
        setResult(-1);
        finish();
    }

    public void closeProgress() {
    }

    public Activity getDefaultActivity() {
        return this;
    }

    public ForumActivityStatus getForumActivityStatus() {
        return this;
    }

    public ForumStatus getForumStatus() {
        return null;
    }

    public ForumStatus getForumStatus(TapatalkForum paramTapatalkForum) {
        return null;
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903170);
        this.rootLay = ((LinearLayout) findViewById(2131231107));
        this.mImage = ((ImageView) findViewById(2131231108));
        this.mText = ((TextView) findViewById(2131231109));
        this.tpButton = ((TapaButton) findViewById(2131231110));
        this.leaveButton = ((TapaButton) findViewById(2131231111));
        this.mForumStatus = ((ForumStatus) getIntent().getSerializableExtra("forumstatus"));
        paramBundle = Typeface.createFromAsset(getAssets(), "font/Roboto_Condensed.ttf");
        this.mText.setTypeface(paramBundle);
        this.mText.setText("Welcome to " + this.mForumStatus.tapatalkForum.getName());
        this.tpButton.setText("Join " + this.mForumStatus.tapatalkForum.getName());
        this.tpButton.setTextColor(-1);
        this.leaveButton.setTextColor(-1);
        AvatarTool.showLogo(this, this.mImage, this.mForumStatus.tapatalkForum.getIconUrl(), 5);
    }

    public void onResume() {
        super.onResume();
    }

    public void showProgress() {
    }

    public void showProgress(String paramString) {
    }

    public void updateDialog(int paramInt) {
    }

    public void updateUI(int paramInt, Object paramObject) {
    }

    public void updateUI(String paramString) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/tapatalkid/ForumJoinActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */