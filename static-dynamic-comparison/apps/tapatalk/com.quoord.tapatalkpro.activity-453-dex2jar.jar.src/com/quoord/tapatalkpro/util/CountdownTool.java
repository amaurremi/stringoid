package com.quoord.tapatalkpro.util;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CountdownTool {
    private TextView countdown = null;
    private Handler handler = new Handler();
    private boolean isTimer = false;
    private Activity mActivity;
    private int number = 0;
    private ImageView reply = null;
    private Runnable runnable = new Runnable() {
        public void run() {
            CountdownTool localCountdownTool = CountdownTool.this;
            localCountdownTool.number -= 1;
            if (CountdownTool.this.countdown != null) {
                CountdownTool.this.countdown.setText(CountdownTool.this.number);
            }
            if (CountdownTool.this.submit != null) {
                CountdownTool.this.submit.setTitle(CountdownTool.this.number);
            }
            if (CountdownTool.this.number > 0) {
                CountdownTool.this.startTimer();
            }
            do {
                return;
                CountdownTool.this.isTimer = false;
                CountdownTool.this.stopTimer();
                if ((CountdownTool.this.countdown != null) && (CountdownTool.this.reply != null)) {
                    CountdownTool.this.countdown.setVisibility(8);
                    CountdownTool.this.reply.setVisibility(0);
                }
            } while (CountdownTool.this.submit == null);
            CountdownTool.this.submit.setIcon(ThemeUtil.getMenuIconByPicName("menu_send_title", CountdownTool.this.mActivity));
            CountdownTool.this.submit.setTitle(CountdownTool.this.mActivity.getString(2131099972));
        }
    };
    private MenuItem submit = null;

    public CountdownTool(Activity paramActivity, MenuItem paramMenuItem) {
        this.mActivity = paramActivity;
        this.submit = paramMenuItem;
    }

    public CountdownTool(Activity paramActivity, ImageView paramImageView, TextView paramTextView) {
        this.mActivity = paramActivity;
        this.countdown = paramTextView;
        this.reply = paramImageView;
    }

    public int getNumber() {
        return this.number;
    }

    public void initView() {
        if ((this.countdown != null) && (this.reply != null)) {
            this.countdown.setVisibility(0);
            this.reply.setVisibility(8);
            this.countdown.setText(this.number);
        }
        if (this.submit != null) {
            this.submit.setIcon(null);
            this.submit.setTitle(this.number);
        }
        startTimer();
    }

    public void setNumber(int paramInt) {
        this.number = paramInt;
    }

    public void showDialog(String paramString) {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mActivity);
        localBuilder.setMessage(paramString);
        localBuilder.setPositiveButton(this.mActivity.getString(2131100919), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        });
        localBuilder.show();
    }

    public void showFirstReplyDialog(SharedPreferences paramSharedPreferences, RelativeLayout paramRelativeLayout) {
        if ((paramSharedPreferences != null) && (paramRelativeLayout != null) && (paramSharedPreferences.getInt("post_countdown_first_reply", 1) == 1)) {
            paramRelativeLayout.setVisibility(0);
            paramRelativeLayout = paramSharedPreferences.edit();
            paramRelativeLayout.putInt("post_countdown_first_reply", paramSharedPreferences.getInt("post_countdown_first_reply", 1) + 1);
            paramRelativeLayout.commit();
        }
    }

    public void startTimer() {
        this.handler.postDelayed(this.runnable, 1000L);
    }

    public void stopTimer() {
        this.handler.removeCallbacks(this.runnable);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/CountdownTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */