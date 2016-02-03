package com.quoord.tapatalkpro.ui;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.quoord.tapatalkpro.activity.forum.ThreadOuterFragment;
import com.quoord.tapatalkpro.bean.TopicController;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;

public class ThreadPaginationView {
    public static LinearLayout get(final ThreadOuterFragment paramThreadOuterFragment, final int paramInt) {
        paramInt += 1;
        int i = paramThreadOuterFragment.mTopicController.getPageNum();
        LinearLayout localLinearLayout;
        ImageView localImageView1;
        ImageView localImageView2;
        final TextView localTextView;
        ImageView localImageView3;
        ImageView localImageView4;
        RelativeLayout localRelativeLayout;
        if (SettingsFragment.getColorMode(paramThreadOuterFragment.getActivity()).booleanValue()) {
            localLinearLayout = (LinearLayout) paramThreadOuterFragment.getActivity().getLayoutInflater().inflate(2130903400, null);
            localImageView1 = (ImageView) localLinearLayout.findViewById(2131230973);
            localImageView2 = (ImageView) localLinearLayout.findViewById(2131230974);
            localTextView = (TextView) localLinearLayout.findViewById(2131230976);
            localImageView3 = (ImageView) localLinearLayout.findViewById(2131230977);
            localImageView4 = (ImageView) localLinearLayout.findViewById(2131230978);
            localRelativeLayout = (RelativeLayout) localLinearLayout.findViewById(2131230975);
            if (paramInt > 0) {
                localTextView.setText(paramInt + "/" + paramThreadOuterFragment.mTopicController.getPageNum());
            }
            if (!SettingsFragment.getColorMode(paramThreadOuterFragment.getActivity()).booleanValue()) {
                break label327;
            }
            if (paramInt == 1) {
                localImageView1.setImageResource(2130838740);
                localImageView2.setImageResource(2130837540);
                localImageView1.setEnabled(false);
                localImageView2.setEnabled(false);
            }
            if (paramInt == i) {
                localImageView3.setImageResource(2130838833);
                localImageView4.setImageResource(2130838745);
                localImageView3.setEnabled(false);
                localImageView4.setEnabled(false);
            }
        }
        for (; ; ) {
            localImageView1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    if (ThreadPaginationView.this.getCurrentPageNum() == 0) {
                        Toast.makeText(ThreadPaginationView.this.getActivity(), ThreadPaginationView.this.getActivity().getString(2131099834), 1).show();
                    }
                    while (!(ThreadPaginationView.this instanceof ThreadOuterFragment)) {
                        return;
                    }
                    ThreadPaginationView.this.setCurrentPage(0);
                    paramAnonymousView = "1/" + ThreadPaginationView.this.mTopicController.getPageNum();
                    localTextView.setText(paramAnonymousView);
                }
            });
            localImageView2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    if ((ThreadPaginationView.this instanceof ThreadOuterFragment)) {
                        ThreadPaginationView.this.setCurrentPage(ThreadPaginationView.this.getCurrentPageNum() - 1);
                        paramAnonymousView = paramInt - 1 + "/" + ThreadPaginationView.this.mTopicController.getPageNum();
                        localTextView.setText(paramAnonymousView);
                    }
                }
            });
            localRelativeLayout.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    ThreadPaginationView.this.pageListDialog = new AlertDialog.Builder(ThreadPaginationView.this.getActivity()).setTitle(ThreadPaginationView.this.getString(2131099838)).setSingleChoiceItems(ThreadPaginationView.this.mTopicController.getPageView(), ThreadPaginationView.this.getCurrentPageNum(), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                            if ((this.val$mContext instanceof ThreadOuterFragment)) {
                                this.val$mContext.setCurrentPage(paramAnonymous2Int);
                                paramAnonymous2DialogInterface = paramAnonymous2Int + 1 + "/" + this.val$mContext.mTopicController.getPageNum();
                                this.val$pagelist.setText(paramAnonymous2DialogInterface);
                            }
                            this.val$mContext.pageListDialog.dismiss();
                        }
                    }).create();
                    ThreadPaginationView.this.pageListDialog.show();
                }
            });
            localImageView3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    if ((ThreadPaginationView.this instanceof ThreadOuterFragment)) {
                        ThreadPaginationView.this.getCurrentPageNum();
                        ThreadPaginationView.this.setCurrentPage(ThreadPaginationView.this.getCurrentPageNum() + 1);
                        paramAnonymousView = paramInt + "/" + ThreadPaginationView.this.mTopicController.getPageNum();
                        localTextView.setText(paramAnonymousView);
                    }
                }
            });
            localImageView4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    if (this.val$pageNum == paramThreadOuterFragment.getCurrentPageNum()) {
                        Toast.makeText(paramThreadOuterFragment.getActivity(), paramThreadOuterFragment.getString(2131099835), 1).show();
                    }
                    while (!(paramThreadOuterFragment instanceof ThreadOuterFragment)) {
                        return;
                    }
                    paramThreadOuterFragment.setCurrentPage(paramThreadOuterFragment.mTopicController.getPageNum());
                    paramAnonymousView = paramThreadOuterFragment.mTopicController.getPageNum() + "/" + paramThreadOuterFragment.mTopicController.getPageNum();
                    localTextView.setText(paramAnonymousView);
                }
            });
            localLinearLayout.setGravity(17);
            return localLinearLayout;
            localLinearLayout = (LinearLayout) paramThreadOuterFragment.getActivity().getLayoutInflater().inflate(2130903399, null);
            break;
            label327:
            if (paramInt == 1) {
                localImageView1.setImageResource(2130838739);
                localImageView2.setImageResource(2130837539);
                localImageView1.setEnabled(false);
                localImageView2.setEnabled(false);
            }
            if (paramInt == i) {
                localImageView3.setImageResource(2130838832);
                localImageView4.setImageResource(2130838744);
                localImageView3.setEnabled(false);
                localImageView4.setEnabled(false);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ui/ThreadPaginationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */