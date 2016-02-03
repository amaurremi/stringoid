package com.quoord.DialogUtil;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.activity.forum.ThreadOuterFragment;
import com.quoord.tapatalkpro.adapter.forum.ThreadAdapter;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.PostData;

import java.util.ArrayList;

public class ThreadDialogUtil {
    public static AlertDialog getDeleteDialog(final ForumStatus paramForumStatus, ThreadOuterFragment paramThreadOuterFragment, final ThreadAdapter paramThreadAdapter, final PostData paramPostData) {
        final FragmentActivity localFragmentActivity = paramThreadOuterFragment.getActivity();
        if ((paramForumStatus.isDeleteReason()) || (paramForumStatus.isAdvanceDelete()) || (paramPostData.canBan)) {
            LinearLayout localLinearLayout = (LinearLayout) LayoutInflater.from(localFragmentActivity).inflate(2130903128, null);
            RadioGroup localRadioGroup = (RadioGroup) localLinearLayout.findViewById(2131230988);
            final EditText localEditText = (EditText) localLinearLayout.findViewById(2131230991);
            Object localObject = (RadioButton) localLinearLayout.findViewById(2131230989);
            final RadioButton localRadioButton = (RadioButton) localLinearLayout.findViewById(2131230990);
            ((RadioButton) localObject).setChecked(true);
            final String str = paramPostData.postId;
            localObject = (CheckBox) localLinearLayout.findViewById(2131230852);
            ((CheckBox) localObject).setText(localFragmentActivity.getString(2131100057) + " " + paramPostData.getRealName());
            if (!paramForumStatus.isAdvanceDelete()) {
                localRadioGroup.setVisibility(8);
            }
            if (!paramForumStatus.isDeleteReason()) {
                localEditText.setVisibility(8);
            }
            if (!paramPostData.canBan) {
                ((CheckBox) localObject).setVisibility(8);
            }
            paramThreadOuterFragment = new AlertDialog.Builder(localFragmentActivity).setTitle(localFragmentActivity.getString(2131100033)).setView(localLinearLayout).setCancelable(false).setPositiveButton(localFragmentActivity.getString(2131099972), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                    ThreadDialogUtil.this.showProgress();
                    paramAnonymousDialogInterface = new ArrayList();
                    paramAnonymousDialogInterface.add(str);
                    if (localRadioButton.isChecked()) {
                        paramAnonymousDialogInterface.add(Integer.valueOf(2));
                        if (localEditText.getText() == null) {
                            break label96;
                        }
                        paramAnonymousDialogInterface.add(localEditText.getText().toString().getBytes());
                    }
                    for (; ; ) {
                        paramPostData.deletePost(paramAnonymousDialogInterface);
                        return;
                        paramAnonymousDialogInterface.add(Integer.valueOf(1));
                        break;
                        label96:
                        paramAnonymousDialogInterface.add(null);
                    }
                }
            }).setNegativeButton(localFragmentActivity.getString(2131099974), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                }
            }).create();
            ((CheckBox) localObject).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean) {
                    if (paramAnonymousBoolean) {
                        ThreadDialogUtil.this.dismiss();
                        DialogUtil.getBanDialog(localFragmentActivity, paramForumStatus, paramPostData.getRealName(), paramThreadAdapter).show();
                    }
                }
            });
            return paramThreadOuterFragment;
        }
        paramForumStatus = paramPostData.postId;
        new AlertDialog.Builder(localFragmentActivity).setTitle(localFragmentActivity.getString(2131100214)).setCancelable(false).setPositiveButton(localFragmentActivity.getString(2131099972), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                ThreadDialogUtil.this.showProgress();
                paramAnonymousDialogInterface = new ArrayList();
                paramAnonymousDialogInterface.add(paramForumStatus);
                paramAnonymousDialogInterface.add(Integer.valueOf(1));
                paramAnonymousDialogInterface.add(new byte[0]);
                paramPostData.deletePost(paramAnonymousDialogInterface);
            }
        }).setNegativeButton(localFragmentActivity.getString(2131099974), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        }).create();
    }

    public static AlertDialog getDeleteFirstPostDialog(ForumStatus paramForumStatus, final ThreadOuterFragment paramThreadOuterFragment, final ThreadAdapter paramThreadAdapter, final PostData paramPostData) {
        FragmentActivity localFragmentActivity = paramThreadOuterFragment.getActivity();
        new AlertDialog.Builder(localFragmentActivity).setMessage(localFragmentActivity.getString(2131100038)).setPositiveButton(localFragmentActivity.getText(2131099976).toString(), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                ThreadDialogUtil.getDeleteDialog(ThreadDialogUtil.this, paramThreadOuterFragment, paramThreadAdapter, paramPostData).show();
            }
        }).setNegativeButton(localFragmentActivity.getString(2131099974), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        }).create();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/DialogUtil/ThreadDialogUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */