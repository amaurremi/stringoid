package com.quoord.DialogUtil;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import com.quoord.tapatalkpro.action.DeletePostAction;
import com.quoord.tapatalkpro.action.SubscribeForumAndTopicAction;
import com.quoord.tapatalkpro.activity.forum.BanUserActivity;
import com.quoord.tapatalkpro.adapter.forum.ConfigAdapter;
import com.quoord.tapatalkpro.adapter.forum.ForumRootAdapter;
import com.quoord.tapatalkpro.adapter.forum.NewSubscribeForumAndTopicAdapter;
import com.quoord.tapatalkpro.adapter.forum.moderation.ModerationInterface;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.PostData;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.TwoPanelControllerWithId;

import java.util.ArrayList;

public class DialogUtil {
    public static CheckBox cb_in_ban;

    public static void delete() {
    }

    public static Dialog getBanDialog(Activity paramActivity, ForumStatus paramForumStatus, final String paramString, final ForumRootAdapter paramForumRootAdapter) {
        RelativeLayout localRelativeLayout = (RelativeLayout) LayoutInflater.from(paramActivity).inflate(2130903069, null);
        final CheckBox localCheckBox = (CheckBox) localRelativeLayout.findViewById(2131230852);
        if ((paramForumStatus != null) && (paramForumStatus.isBan_delete_type())) {
            localCheckBox.setVisibility(8);
        }
        ThemeUtil.setCheckBox(paramActivity, localCheckBox);
        cb_in_ban = localCheckBox;
        localCheckBox.setText(paramActivity.getString(2131100059) + " " + paramString);
        localCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean) {
                if (paramAnonymousBoolean) {
                    DialogUtil.getDeleteAllPostDialog(DialogUtil.this, paramString).show();
                }
            }
        });
        paramForumStatus = (EditText) localRelativeLayout.findViewById(2131230851);
        new AlertDialog.Builder(paramActivity).setTitle(paramActivity.getString(2131100057) + " " + paramString).setView(localRelativeLayout).setPositiveButton(paramActivity.getString(2131100057), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                paramAnonymousDialogInterface = DialogUtil.this.getText().toString();
                boolean bool = localCheckBox.isChecked();
                ForumRootAdapter localForumRootAdapter = paramForumRootAdapter;
                String str = paramString;
                if (bool) {
                }
                for (paramAnonymousInt = 2; ; paramAnonymousInt = 1) {
                    localForumRootAdapter.banUser(str, paramAnonymousDialogInterface, paramAnonymousInt);
                    return;
                }
            }
        }).setNegativeButton(paramActivity.getString(2131099974), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        }).create();
    }

    public static Dialog getBanDialog(Activity paramActivity, ForumStatus paramForumStatus, final String paramString, final NewSubscribeForumAndTopicAdapter paramNewSubscribeForumAndTopicAdapter) {
        RelativeLayout localRelativeLayout = (RelativeLayout) LayoutInflater.from(paramActivity).inflate(2130903069, null);
        final CheckBox localCheckBox = (CheckBox) localRelativeLayout.findViewById(2131230852);
        if ((paramForumStatus != null) && (paramForumStatus.isBan_delete_type())) {
            localCheckBox.setVisibility(8);
        }
        ThemeUtil.setCheckBox(paramActivity, localCheckBox);
        cb_in_ban = localCheckBox;
        localCheckBox.setText(paramActivity.getString(2131100059) + " " + paramString);
        localCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean) {
                if (paramAnonymousBoolean) {
                    DialogUtil.getDeleteAllPostDialog(DialogUtil.this, paramString).show();
                }
            }
        });
        paramForumStatus = (EditText) localRelativeLayout.findViewById(2131230851);
        new AlertDialog.Builder(paramActivity).setTitle(paramActivity.getString(2131100057) + " " + paramString).setView(localRelativeLayout).setPositiveButton(paramActivity.getString(2131100057), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                paramAnonymousDialogInterface = DialogUtil.this.getText().toString();
                boolean bool = localCheckBox.isChecked();
                SubscribeForumAndTopicAction localSubscribeForumAndTopicAction = paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction();
                String str = paramString;
                if (bool) {
                }
                for (paramAnonymousInt = 2; ; paramAnonymousInt = 1) {
                    localSubscribeForumAndTopicAction.banUser(str, paramAnonymousDialogInterface, paramAnonymousInt);
                    return;
                }
            }
        }).setNegativeButton(paramActivity.getString(2131099974), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        }).create();
    }

    public static Dialog getDeleteAllPostDialog(Context paramContext, String paramString) {
        new AlertDialog.Builder(paramContext).setMessage(paramContext.getString(2131100060) + " " + paramString).setPositiveButton(paramContext.getText(2131099976).toString(), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        }).setNegativeButton(paramContext.getString(2131099974), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                if (DialogUtil.cb_in_ban != null) {
                    DialogUtil.cb_in_ban.setChecked(false);
                }
            }
        }).create();
    }

    public static Dialog getDeleteDialog(final Activity paramActivity, final ForumStatus paramForumStatus, final Topic paramTopic, final ForumRootAdapter paramForumRootAdapter) {
        if ((paramForumStatus.isDeleteReason()) || (paramForumStatus.isAdvanceDelete()) || (paramTopic.isCanBan())) {
            Object localObject = (LinearLayout) LayoutInflater.from(paramActivity).inflate(2130903128, null);
            EditText localEditText = (EditText) ((LinearLayout) localObject).findViewById(2131230991);
            RadioGroup localRadioGroup = (RadioGroup) ((LinearLayout) localObject).findViewById(2131230988);
            RadioButton localRadioButton1 = (RadioButton) ((LinearLayout) localObject).findViewById(2131230989);
            final RadioButton localRadioButton2 = (RadioButton) ((LinearLayout) localObject).findViewById(2131230990);
            CheckBox localCheckBox = (CheckBox) ((LinearLayout) localObject).findViewById(2131230852);
            localCheckBox.setText(paramActivity.getString(2131100057) + " " + paramTopic.getRealName());
            if (!paramForumStatus.isAdvanceDelete()) {
                localRadioGroup.setVisibility(8);
            }
            if (!paramForumStatus.isDeleteReason()) {
                localEditText.setVisibility(8);
            }
            if (!paramTopic.isCanBan()) {
                localCheckBox.setVisibility(8);
            }
            localRadioButton1.setChecked(true);
            localObject = new AlertDialog.Builder(paramActivity).setTitle(paramTopic.getTitle()).setView((View) localObject).setCancelable(false).setPositiveButton(paramActivity.getString(2131100016), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                    paramAnonymousDialogInterface = "";
                    if (DialogUtil.this.getText() != null) {
                        paramAnonymousDialogInterface = DialogUtil.this.getText().toString();
                    }
                    if (localRadioButton2.isChecked()) {
                        paramTopic.deleteTopic(paramForumRootAdapter, paramActivity, paramAnonymousDialogInterface, 2);
                    }
                    for (; ; ) {
                        Util.hideSoftKeyb(paramActivity, DialogUtil.this);
                        paramForumRootAdapter.removeItem(paramForumRootAdapter.getmLongclickItemPosition());
                        if (((paramActivity instanceof SlidingMenuActivity)) && ((((SlidingMenuActivity) paramActivity).currentFragment instanceof TwoPanelControllerWithId)) && ((paramActivity instanceof SlidingMenuActivity)) && (((TwoPanelControllerWithId) ((SlidingMenuActivity) paramActivity).currentFragment).getIdByTwoPanel() != null) && (((TwoPanelControllerWithId) ((SlidingMenuActivity) paramActivity).currentFragment).getIdByTwoPanel().equals(paramTopic.getId()))) {
                            ((SlidingMenuActivity) paramActivity).setBackStackAnimation(((SlidingMenuActivity) paramActivity).outerFragment);
                        }
                        paramAnonymousDialogInterface = paramForumRootAdapter;
                        paramForumRootAdapter.notifyDataSetChanged();
                        return;
                        paramTopic.deleteTopic(paramForumRootAdapter, paramActivity, paramAnonymousDialogInterface, 1);
                    }
                }
            }).setNegativeButton(paramActivity.getString(2131099974), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                }
            }).create();
            localCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean) {
                    if (paramAnonymousBoolean) {
                        DialogUtil.this.dismiss();
                        DialogUtil.getBanDialog(paramActivity, paramForumStatus, paramTopic.getRealName(), paramForumRootAdapter).show();
                    }
                }
            });
            return (Dialog) localObject;
        }
        new AlertDialog.Builder(paramActivity).setTitle(paramActivity.getString(2131100213)).setCancelable(false).setPositiveButton(paramActivity.getString(2131099972), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                DialogUtil.this.deleteTopic(paramForumRootAdapter, paramActivity, "", 1);
                paramForumRootAdapter.removeItem(paramForumRootAdapter.getmLongclickItemPosition());
                paramForumRootAdapter.notifyDataSetChanged();
            }
        }).setNegativeButton(paramActivity.getString(2131099974), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        }).create();
    }

    public static Dialog getDeleteDialog(final Activity paramActivity, final ForumStatus paramForumStatus, final Topic paramTopic, final NewSubscribeForumAndTopicAdapter paramNewSubscribeForumAndTopicAdapter) {
        if ((paramForumStatus.isDeleteReason()) || (paramForumStatus.isAdvanceDelete()) || (paramTopic.isCanBan())) {
            Object localObject = (LinearLayout) LayoutInflater.from(paramActivity).inflate(2130903128, null);
            EditText localEditText = (EditText) ((LinearLayout) localObject).findViewById(2131230991);
            RadioGroup localRadioGroup = (RadioGroup) ((LinearLayout) localObject).findViewById(2131230988);
            RadioButton localRadioButton1 = (RadioButton) ((LinearLayout) localObject).findViewById(2131230989);
            final RadioButton localRadioButton2 = (RadioButton) ((LinearLayout) localObject).findViewById(2131230990);
            CheckBox localCheckBox = (CheckBox) ((LinearLayout) localObject).findViewById(2131230852);
            localCheckBox.setText(paramActivity.getString(2131100057) + " " + paramTopic.getRealName());
            if (!paramForumStatus.isAdvanceDelete()) {
                localRadioGroup.setVisibility(8);
            }
            if (!paramForumStatus.isDeleteReason()) {
                localEditText.setVisibility(8);
            }
            if (!paramTopic.isCanBan()) {
                localCheckBox.setVisibility(8);
            }
            localRadioButton1.setChecked(true);
            localObject = new AlertDialog.Builder(paramActivity).setTitle(paramTopic.getTitle()).setView((View) localObject).setCancelable(false).setPositiveButton(paramActivity.getString(2131100016), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                    paramAnonymousDialogInterface = "";
                    if (DialogUtil.this.getText() != null) {
                        paramAnonymousDialogInterface = DialogUtil.this.getText().toString();
                    }
                    if (localRadioButton2.isChecked()) {
                        paramTopic.deleteTopic(paramNewSubscribeForumAndTopicAdapter, paramActivity, paramAnonymousDialogInterface, 2);
                    }
                    for (; ; ) {
                        Util.hideSoftKeyb(paramActivity, DialogUtil.this);
                        paramNewSubscribeForumAndTopicAdapter.removeTopicsItem(paramTopic);
                        if (((paramActivity instanceof SlidingMenuActivity)) && ((((SlidingMenuActivity) paramActivity).currentFragment instanceof TwoPanelControllerWithId)) && ((paramActivity instanceof SlidingMenuActivity)) && (((TwoPanelControllerWithId) ((SlidingMenuActivity) paramActivity).currentFragment).getIdByTwoPanel() != null) && (((TwoPanelControllerWithId) ((SlidingMenuActivity) paramActivity).currentFragment).getIdByTwoPanel().equals(paramTopic.getId()))) {
                            ((SlidingMenuActivity) paramActivity).setBackStackAnimation(((SlidingMenuActivity) paramActivity).outerFragment);
                        }
                        paramNewSubscribeForumAndTopicAdapter.notifyDataSetChanged();
                        return;
                        paramTopic.deleteTopic(paramNewSubscribeForumAndTopicAdapter, paramActivity, paramAnonymousDialogInterface, 1);
                    }
                }
            }).setNegativeButton(paramActivity.getString(2131099974), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                }
            }).create();
            localCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean) {
                    if (paramAnonymousBoolean) {
                        DialogUtil.this.dismiss();
                        DialogUtil.getBanDialog(paramActivity, paramForumStatus, paramTopic.getRealName(), paramNewSubscribeForumAndTopicAdapter).show();
                    }
                }
            });
            return (Dialog) localObject;
        }
        new AlertDialog.Builder(paramActivity).setTitle(paramActivity.getString(2131100213)).setCancelable(false).setPositiveButton(paramActivity.getString(2131099972), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                DialogUtil.this.deleteTopic(paramNewSubscribeForumAndTopicAdapter, paramActivity, "", 1);
                paramNewSubscribeForumAndTopicAdapter.removeTopicsItem(DialogUtil.this);
                paramNewSubscribeForumAndTopicAdapter.notifyDataSetChanged();
            }
        }).setNegativeButton(paramActivity.getString(2131099974), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        }).create();
    }

    public static Dialog getLoginModDialog(final Activity paramActivity, ForumStatus paramForumStatus, final BanUserActivity paramBanUserActivity) {
        LinearLayout localLinearLayout = (LinearLayout) LayoutInflater.from(paramActivity).inflate(2130903266, null);
        final EditText localEditText = (EditText) localLinearLayout.getChildAt(0);
        new AlertDialog.Builder(paramActivity).setTitle(paramActivity.getString(2131100049)).setView(localLinearLayout).setCancelable(false).setPositiveButton(paramActivity.getString(2131099972), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                DialogUtil.this.banUser = paramBanUserActivity;
                new ConfigAdapter(paramActivity, DialogUtil.this.getUrl()).login_mod(localEditText.getText().toString());
            }
        }).setNegativeButton(paramActivity.getString(2131099974), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        }).create();
    }

    public static Dialog getLoginModDialog(final Activity paramActivity, ForumStatus paramForumStatus, final ForumRootAdapter paramForumRootAdapter) {
        LinearLayout localLinearLayout = (LinearLayout) LayoutInflater.from(paramActivity).inflate(2130903266, null);
        final EditText localEditText = (EditText) localLinearLayout.getChildAt(0);
        new AlertDialog.Builder(paramActivity).setTitle(paramActivity.getString(2131100049)).setView(localLinearLayout).setCancelable(false).setPositiveButton(paramActivity.getString(2131099972), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                DialogUtil.this.tempAdapter = paramForumRootAdapter;
                new ConfigAdapter(paramActivity, DialogUtil.this.getUrl()).login_mod(localEditText.getText().toString());
            }
        }).setNegativeButton(paramActivity.getString(2131099974), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        }).create();
    }

    public static Dialog getLoginModDialog(final Activity paramActivity, ForumStatus paramForumStatus, final ModerationInterface paramModerationInterface) {
        LinearLayout localLinearLayout = (LinearLayout) LayoutInflater.from(paramActivity).inflate(2130903266, null);
        final EditText localEditText = (EditText) localLinearLayout.getChildAt(0);
        new AlertDialog.Builder(paramActivity).setTitle(paramActivity.getString(2131100049)).setView(localLinearLayout).setCancelable(false).setPositiveButton(paramActivity.getString(2131099972), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                DialogUtil.this.ModeInterface = paramModerationInterface;
                new ConfigAdapter(paramActivity, DialogUtil.this.getUrl()).login_mod(localEditText.getText().toString());
            }
        }).setNegativeButton(paramActivity.getString(2131099974), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        }).create();
    }

    public static Dialog getMuitlDeletePostDialog(final Activity paramActivity, final ForumStatus paramForumStatus, final Topic paramTopic, final ForumRootAdapter paramForumRootAdapter, final ArrayList<PostData> paramArrayList, final DeletePostAction paramDeletePostAction) {
        if ((paramForumStatus.isDeleteReason()) || (paramForumStatus.isAdvanceDelete())) {
            LinearLayout localLinearLayout = (LinearLayout) LayoutInflater.from(paramActivity).inflate(2130903128, null);
            final EditText localEditText = (EditText) localLinearLayout.findViewById(2131230991);
            RadioGroup localRadioGroup = (RadioGroup) localLinearLayout.findViewById(2131230988);
            Object localObject = (RadioButton) localLinearLayout.findViewById(2131230989);
            RadioButton localRadioButton = (RadioButton) localLinearLayout.findViewById(2131230990);
            localObject = (CheckBox) localLinearLayout.findViewById(2131230852);
            ((CheckBox) localObject).setText(paramActivity.getString(2131100057) + " " + paramTopic.getRealName());
            ((CheckBox) localObject).setTextColor(paramActivity.getResources().getColor(2131165213));
            if (!paramForumStatus.isAdvanceDelete()) {
                localRadioGroup.setVisibility(8);
            }
            if (!paramForumStatus.isDeleteReason()) {
                localEditText.setVisibility(8);
            }
            ((CheckBox) localObject).setVisibility(8);
            paramTopic.getId();
            paramArrayList = new AlertDialog.Builder(paramActivity).setTitle(paramActivity.getResources().getString(2131100828)).setView(localLinearLayout).setCancelable(false).setPositiveButton(paramActivity.getString(2131100016), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                    if (DialogUtil.this.isChecked()) {
                        paramDeletePostAction.deletePost(localEditText.getText().toString(), 2, paramArrayList);
                    }
                    for (; ; ) {
                        paramForumRootAdapter.removeItem(paramForumRootAdapter.getmLongclickItemPosition());
                        paramForumRootAdapter.notifyDataSetChanged();
                        return;
                        paramDeletePostAction.deletePost(localEditText.getText().toString(), 1, paramArrayList);
                    }
                }
            }).setNegativeButton(paramActivity.getString(2131099974), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                }
            }).create();
            ((CheckBox) localObject).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean) {
                    if (paramAnonymousBoolean) {
                        DialogUtil.this.dismiss();
                        DialogUtil.getBanDialog(paramActivity, paramForumStatus, paramTopic.getRealName(), paramForumRootAdapter).show();
                    }
                }
            });
            return paramArrayList;
        }
        new AlertDialog.Builder(paramActivity).setTitle(paramActivity.getString(2131100214)).setCancelable(false).setPositiveButton(paramActivity.getString(2131099972), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                DialogUtil.this.deletePost("", 1, paramArrayList);
                paramForumRootAdapter.removeItem(paramForumRootAdapter.getmLongclickItemPosition());
                paramForumRootAdapter.notifyDataSetChanged();
            }
        }).setNegativeButton(paramActivity.getString(2131099974), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        }).create();
    }

    public static Dialog getXFInlineDialog(Activity paramActivity, EditText paramEditText, final String paramString) {
        String str1 = paramActivity.getString(2131100055);
        String str2 = paramActivity.getString(2131100056);
        paramActivity = new AlertDialog.Builder(paramActivity).setTitle(paramActivity.getString(2131099962));
        paramEditText = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                if (paramAnonymousInt == 0) {
                    DialogUtil.this.getEditableText().insert(DialogUtil.this.getSelectionStart(), "[ATTACH]" + paramString + "[/ATTACH]");
                    return;
                }
                DialogUtil.this.getEditableText().insert(DialogUtil.this.getSelectionStart(), "[ATTACH=full]" + paramString + "[/ATTACH]");
            }
        };
        return paramActivity.setItems(new String[]{str1, str2}, paramEditText).create();
    }

    public static void updateProgressDialog(ProgressDialog paramProgressDialog, int paramInt, Context paramContext) {
        String str = "";
        if (paramInt == 0) {
            str = paramContext.getString(2131099870);
        }
        for (; ; ) {
            if (paramProgressDialog != null) {
                paramProgressDialog.setMessage(str);
            }
            return;
            if (paramInt == 1) {
                str = paramContext.getString(2131099871);
            } else if (paramInt == 2) {
                str = paramContext.getString(2131099872);
            } else if (paramInt == 3) {
                str = paramContext.getString(2131099873);
            } else if (paramInt == 4) {
                str = paramContext.getString(2131099874);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/DialogUtil/DialogUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */