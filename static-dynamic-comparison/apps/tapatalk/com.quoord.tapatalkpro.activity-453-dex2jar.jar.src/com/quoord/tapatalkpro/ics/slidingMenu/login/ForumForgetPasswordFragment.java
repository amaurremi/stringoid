package com.quoord.tapatalkpro.ics.slidingMenu.login;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.ImageTools;

import java.util.ArrayList;
import java.util.HashMap;

public class ForumForgetPasswordFragment
        extends QuoordFragment
        implements TryTwiceCallBackInterface {
    private int au_id = 0;
    private String email = null;
    private TapatalkEngine engine = null;
    private ImageView forumIcon;
    private TextView forumName;
    private ForumStatus forumStatus = null;
    private Activity mActivity = null;
    private ProgressDialog progress = null;
    private Button skip = null;
    private String token = null;
    private EditText username = null;
    private View viewLayout = null;

    public static ForumForgetPasswordFragment newInstance(ForumStatus paramForumStatus, String paramString1, int paramInt, String paramString2) {
        ForumForgetPasswordFragment localForumForgetPasswordFragment = new ForumForgetPasswordFragment();
        localForumForgetPasswordFragment.forumStatus = paramForumStatus;
        localForumForgetPasswordFragment.token = paramString1;
        localForumForgetPasswordFragment.au_id = paramInt;
        localForumForgetPasswordFragment.email = paramString2;
        return localForumForgetPasswordFragment;
    }

    private void resetDialog() {
        LinearLayout localLinearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(2130903347, null);
        final EditText localEditText1 = (EditText) localLinearLayout.findViewById(2131231584);
        final EditText localEditText2 = (EditText) localLinearLayout.findViewById(2131231585);
        new AlertDialog.Builder(this.mActivity).setTitle("Reset").setView(localLinearLayout).setPositiveButton(this.mActivity.getResources().getString(2131099914), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                ForumForgetPasswordFragment.this.progress.show();
                Object localObject = localEditText1.getText().toString().trim();
                paramAnonymousDialogInterface = localEditText2.getText().toString().trim();
                if ((!"".equals(localObject)) && (!"".equals(paramAnonymousDialogInterface)) && (!"".equals(paramAnonymousDialogInterface))) {
                    if ((((String) localObject).length() > 3) && (paramAnonymousDialogInterface.length() > 3)) {
                        if (!((String) localObject).equals(paramAnonymousDialogInterface)) {
                            Toast.makeText(ForumForgetPasswordFragment.this.mActivity, ForumForgetPasswordFragment.this.mActivity.getResources().getString(2131100308), 1).show();
                        }
                    }
                }
                while ((!"".equals(localObject)) && (!"".equals(paramAnonymousDialogInterface))) {
                    return;
                    localObject = new ArrayList();
                    ((ArrayList) localObject).add(paramAnonymousDialogInterface.getBytes());
                    ((ArrayList) localObject).add(ForumForgetPasswordFragment.this.token);
                    ((ArrayList) localObject).add(Util.getMD5(ForumForgetPasswordFragment.this.forumStatus.getForumId() + "|" + ForumForgetPasswordFragment.this.au_id + "|" + ForumForgetPasswordFragment.this.email));
                    ForumForgetPasswordFragment.this.engine.call("update_password", (ArrayList) localObject);
                    return;
                    Toast.makeText(ForumForgetPasswordFragment.this.mActivity, ForumForgetPasswordFragment.this.mActivity.getResources().getString(2131100315), 1).show();
                    return;
                }
                Toast.makeText(ForumForgetPasswordFragment.this.mActivity, ForumForgetPasswordFragment.this.mActivity.getResources().getString(2131100303), 1).show();
            }
        }).setNegativeButton(this.mActivity.getResources().getString(2131099974), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        }).create().show();
    }

    private void setForgetPasswordClick() {
        this.skip.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                paramAnonymousView = ForumForgetPasswordFragment.this.username.getText().toString().trim();
                if ((!paramAnonymousView.equals("")) && (paramAnonymousView != null)) {
                    ArrayList localArrayList = new ArrayList();
                    localArrayList.add(paramAnonymousView.getBytes());
                    if ((ForumForgetPasswordFragment.this.token != null) && (!ForumForgetPasswordFragment.this.token.equals(""))) {
                        localArrayList.add(ForumForgetPasswordFragment.this.token);
                        localArrayList.add(Util.getMD5(ForumForgetPasswordFragment.this.forumStatus.getForumId() + "|" + ForumForgetPasswordFragment.this.au_id + "|" + ForumForgetPasswordFragment.this.email));
                    }
                    ForumForgetPasswordFragment.this.engine.call("forget_password", localArrayList);
                    ForumForgetPasswordFragment.this.progress.show();
                    return;
                }
                Toast.makeText(ForumForgetPasswordFragment.this.mActivity, ForumForgetPasswordFragment.this.mActivity.getResources().getString(2131100394), 1).show();
            }
        });
    }

    public void callBack(EngineResponse paramEngineResponse) {
        Object localObject = paramEngineResponse.getMethod();
        if ((!"".equals(localObject)) && ((paramEngineResponse.getResponse() instanceof HashMap))) {
            paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
            if (((String) localObject).equals("forget_password")) {
                for (; ; ) {
                    try {
                        if (((Boolean) paramEngineResponse.get("result")).booleanValue()) {
                            if (((Boolean) paramEngineResponse.get("verified")).booleanValue()) {
                                resetDialog();
                                this.progress.dismiss();
                                return;
                            }
                            paramEngineResponse = (byte[]) paramEngineResponse.get("result_text");
                            Toast.makeText(this.mActivity, new String(paramEngineResponse), 1).show();
                            continue;
                        }
                        paramEngineResponse = (byte[]) paramEngineResponse.get("result_text");
                    } catch (Exception paramEngineResponse) {
                        paramEngineResponse.printStackTrace();
                        return;
                    }
                    Toast.makeText(this.mActivity, new String(paramEngineResponse), 1).show();
                }
            }
            if (((String) localObject).equals("update_password")) {
                this.progress.dismiss();
                localObject = (Boolean) paramEngineResponse.get("result");
                paramEngineResponse = (byte[]) paramEngineResponse.get("result_text");
                if (!((Boolean) localObject).booleanValue()) {
                    if ((paramEngineResponse != null) && (!paramEngineResponse.equals(""))) {
                        Toast.makeText(this.mActivity, new String(paramEngineResponse), 1).show();
                    }
                } else {
                    if ((this.mActivity instanceof SlidingMenuActivity)) {
                        ((SlidingMenuActivity) this.mActivity).backStack(true);
                        Toast.makeText(this.mActivity, this.mActivity.getResources().getString(2131100310), 1).show();
                    }
                    boolean bool = this.mActivity instanceof ForumLoginActivity;
                }
            }
        }
    }

    public boolean getSaxCall() {
        return false;
    }

    public boolean getTryTwice() {
        return false;
    }

    public void initForumIconandName() {
        if (this.forumStatus != null) {
            this.forumName.setText(this.forumStatus.tapatalkForum.getName());
            if (SettingsFragment.isLightTheme(getActivity())) {
                ImageTools.glideLoad(this.forumStatus.tapatalkForum.getIconUrl(), this.forumIcon, 2131165574);
            }
        } else {
            return;
        }
        this.forumName.setTextColor(-1);
        ImageTools.glideLoad(this.forumStatus.tapatalkForum.getIconUrl(), this.forumIcon, 2131165573);
    }

    public boolean isOpCancel() {
        return false;
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.mActivity = getActivity();
        this.mActivity.getActionBar().setTitle(this.mActivity.getResources().getString(2131100938));
        if (paramBundle != null) {
            this.forumStatus = ((ForumStatus) paramBundle.getSerializable("forumStatus"));
            this.token = paramBundle.getString("token");
            this.au_id = paramBundle.getInt("au_id");
            this.email = paramBundle.getString("email");
        }
        initForumIconandName();
        this.skip.setText(getString(2131099916));
        if (SettingsFragment.isLightTheme(this.mActivity)) {
            Util.setBg(this.skip, this.mActivity.getResources().getDrawable(2130838824));
        }
        for (; ; ) {
            this.progress = new ProgressDialog(this.mActivity);
            this.progress.setMessage(this.mActivity.getResources().getString(2131100313));
            if (this.forumStatus != null) {
                this.engine = new TapatalkEngine(this, this.forumStatus, this.mActivity);
            }
            return;
            Util.setBg(this.skip, this.mActivity.getResources().getDrawable(2130838825));
        }
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        this.viewLayout = paramLayoutInflater.inflate(2130903424, null);
        this.skip = ((Button) this.viewLayout.findViewById(2131231350));
        this.username = ((EditText) this.viewLayout.findViewById(2131231024));
        this.forumIcon = ((ImageView) this.viewLayout.findViewById(2131231076));
        this.forumName = ((TextView) this.viewLayout.findViewById(2131231092));
        setForgetPasswordClick();
        return this.viewLayout;
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putSerializable("forumStatus", this.forumStatus);
        paramBundle.putString("token", this.token);
        paramBundle.putInt("au_id", this.au_id);
        paramBundle.putString("email", this.email);
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void setSaxCall(boolean paramBoolean) {
    }

    public void setTryTwice(boolean paramBoolean) {
    }

    public void tryFailed(String paramString) {
    }

    public void updateSubclassDialog(int paramInt) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/slidingMenu/login/ForumForgetPasswordFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */