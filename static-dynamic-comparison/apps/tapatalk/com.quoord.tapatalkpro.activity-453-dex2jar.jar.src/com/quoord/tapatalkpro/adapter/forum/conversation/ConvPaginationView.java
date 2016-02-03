package com.quoord.tapatalkpro.adapter.forum.conversation;

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
import com.quoord.tapatalkpro.activity.forum.conversation.ConversationOuterFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;

public class ConvPaginationView {
    public static LinearLayout get(final ConversationOuterFragment paramConversationOuterFragment, final int paramInt) {
        paramInt += 1;
        int i = paramConversationOuterFragment.mConvController.getPageNum();
        LinearLayout localLinearLayout;
        ImageView localImageView1;
        ImageView localImageView2;
        final TextView localTextView;
        ImageView localImageView3;
        ImageView localImageView4;
        RelativeLayout localRelativeLayout;
        if (SettingsFragment.getColorMode(paramConversationOuterFragment.getActivity()).booleanValue()) {
            localLinearLayout = (LinearLayout) paramConversationOuterFragment.getActivity().getLayoutInflater().inflate(2130903123, null);
            localImageView1 = (ImageView) localLinearLayout.findViewById(2131230973);
            localImageView2 = (ImageView) localLinearLayout.findViewById(2131230974);
            localTextView = (TextView) localLinearLayout.findViewById(2131230976);
            localImageView3 = (ImageView) localLinearLayout.findViewById(2131230977);
            localImageView4 = (ImageView) localLinearLayout.findViewById(2131230978);
            localRelativeLayout = (RelativeLayout) localLinearLayout.findViewById(2131230975);
            if (paramInt > 0) {
                localTextView.setText(paramInt + "/" + paramConversationOuterFragment.mConvController.getPageNum());
            }
            if (!SettingsFragment.getColorMode(paramConversationOuterFragment.getActivity()).booleanValue()) {
                break label330;
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
                    if (ConvPaginationView.this.getCurrentPageNum() == 0) {
                        Toast.makeText(ConvPaginationView.this.getActivity(), ConvPaginationView.this.getActivity().getString(2131099834), 1).show();
                    }
                    while (!(ConvPaginationView.this instanceof ConversationOuterFragment)) {
                        return;
                    }
                    ConvPaginationView.this.setCurrentPage(0);
                    paramAnonymousView = paramInt + "/" + ConvPaginationView.this.mConvController.getPageNum();
                    localTextView.setText(paramAnonymousView);
                }
            });
            localImageView2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    if ((ConvPaginationView.this instanceof ConversationOuterFragment)) {
                        ConvPaginationView.this.setCurrentPage(ConvPaginationView.this.getCurrentPageNum() - 1);
                        paramAnonymousView = paramInt + "/" + ConvPaginationView.this.mConvController.getPageNum();
                        localTextView.setText(paramAnonymousView);
                    }
                }
            });
            localRelativeLayout.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    ConvPaginationView.this.pageListDialog = new AlertDialog.Builder(ConvPaginationView.this.getActivity()).setTitle(ConvPaginationView.this.getString(2131099838)).setSingleChoiceItems(ConvPaginationView.this.mConvController.getPageView(), ConvPaginationView.this.getCurrentPageNum(), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                            if ((this.val$mContext instanceof ConversationOuterFragment)) {
                                this.val$mContext.setCurrentPage(paramAnonymous2Int);
                                paramAnonymous2DialogInterface = this.val$page_dislay + "/" + this.val$mContext.mConvController.getPageNum();
                                this.val$pagelist.setText(paramAnonymous2DialogInterface);
                            }
                            this.val$mContext.pageListDialog.dismiss();
                        }
                    }).create();
                    ConvPaginationView.this.pageListDialog.show();
                }
            });
            localImageView3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    if ((ConvPaginationView.this instanceof ConversationOuterFragment)) {
                        ConvPaginationView.this.getCurrentPageNum();
                        ConvPaginationView.this.setCurrentPage(ConvPaginationView.this.getCurrentPageNum() + 1);
                        paramAnonymousView = paramInt + "/" + ConvPaginationView.this.mConvController.getPageNum();
                        localTextView.setText(paramAnonymousView);
                    }
                }
            });
            localImageView4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    if (this.val$pageNum == paramConversationOuterFragment.getCurrentPageNum()) {
                        Toast.makeText(paramConversationOuterFragment.getActivity(), paramConversationOuterFragment.getString(2131099835), 1).show();
                    }
                    while (!(paramConversationOuterFragment instanceof ConversationOuterFragment)) {
                        return;
                    }
                    paramConversationOuterFragment.setCurrentPage(this.val$pageNum - 1);
                    paramAnonymousView = paramInt + "/" + paramConversationOuterFragment.mConvController.getPageNum();
                    localTextView.setText(paramAnonymousView);
                }
            });
            localLinearLayout.setGravity(17);
            return localLinearLayout;
            localLinearLayout = (LinearLayout) paramConversationOuterFragment.getActivity().getLayoutInflater().inflate(2130903122, null);
            break;
            label330:
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/conversation/ConvPaginationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */