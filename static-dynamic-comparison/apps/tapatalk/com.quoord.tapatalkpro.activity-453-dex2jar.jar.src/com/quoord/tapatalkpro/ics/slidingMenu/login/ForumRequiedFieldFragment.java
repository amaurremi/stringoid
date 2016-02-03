package com.quoord.tapatalkpro.ics.slidingMenu.login;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.quoord.tapatalkpro.action.ForumLoginOrSignAction;
import com.quoord.tapatalkpro.action.ForumLoginOrSignAction.ActionCallBack;
import com.quoord.tapatalkpro.action.ForumLoginOrSignAction.ActionFoceViewAThread;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.activity.forum.ThreadActivity;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.commonvalue.IntentValue;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.Util;

import java.util.ArrayList;
import java.util.HashMap;

public class ForumRequiedFieldFragment
        extends QuoordFragment {
    public static final int MENU_DONE = 0;
    private FragmentActivity activity;
    private ActionBar bar;
    public ArrayList<CustomFieldView> customFieldViews = new ArrayList();
    public ArrayList<CustomRegisterField> customFields = new ArrayList();
    public ForumStatus forumStatus;
    private AlertDialog loginerrorDialog;
    public LinearLayout requiedContiner;
    private ForumLoginOrSignAction siginAction;
    private TapatalkId tapatalkId;
    private EditText username;
    public View view;

    public static ForumRequiedFieldFragment newInstance(ArrayList<CustomRegisterField> paramArrayList, ForumStatus paramForumStatus) {
        ForumRequiedFieldFragment localForumRequiedFieldFragment = new ForumRequiedFieldFragment();
        localForumRequiedFieldFragment.customFields = paramArrayList;
        localForumRequiedFieldFragment.forumStatus = paramForumStatus;
        return localForumRequiedFieldFragment;
    }

    private void signForum(final String paramString1, String paramString2, HashMap paramHashMap) {
        this.siginAction.signForum(paramString1, paramString2, true, true, true, paramHashMap, true, new ForumLoginOrSignAction.ActionCallBack()
        new ForumLoginOrSignAction.ActionFoceViewAThread
        {
            public void actionErrorBack (String paramAnonymousString1, String paramAnonymousString2)
            {
                ((ForumActivityStatus) ForumRequiedFieldFragment.this.activity).closeProgress();
                if (paramAnonymousString2.equals("1")) {
                    paramAnonymousString2 = paramAnonymousString1;
                    if (!Util.checkString(paramAnonymousString1)) {
                        paramAnonymousString2 = String.format(ForumRequiedFieldFragment.this.getString(2131100532), new Object[]{paramString1});
                    }
                    Util.showToastForLong(ForumRequiedFieldFragment.this.activity, paramAnonymousString2);
                }
                while (paramAnonymousString2.equals("2")) {
                    return;
                }
                if (paramAnonymousString2.equals("3")) {
                    ForumRequiedFieldFragment.this.showErrorDialog(ForumRequiedFieldFragment.this.getString(2131100697));
                    return;
                }
                Util.showToastForLong(ForumRequiedFieldFragment.this.activity, paramAnonymousString1);
            }

        public void actionSuccessBack (ForumStatus paramAnonymousForumStatus)
        {
            if ((ForumRequiedFieldFragment.this.activity instanceof SlidingMenuActivity)) {
                ((SlidingMenuActivity) ForumRequiedFieldFragment.this.activity).closeProgress();
                ((SlidingMenuActivity) ForumRequiedFieldFragment.this.activity).clearStack();
                ((SlidingMenuActivity) ForumRequiedFieldFragment.this.activity).showView();
                ((SlidingMenuActivity) ForumRequiedFieldFragment.this.activity).getUnreadNumbers();
            }
            if ((ForumRequiedFieldFragment.this.activity instanceof ForumLoginActivity)) {
                ((ForumLoginActivity) ForumRequiedFieldFragment.this.activity).closeProgress();
                ForumRequiedFieldFragment.this.activity.getIntent().putExtra("forumStatus", paramAnonymousForumStatus);
                ForumRequiedFieldFragment.this.activity.setResult(-1, ForumRequiedFieldFragment.this.activity.getIntent());
                ForumRequiedFieldFragment.this.activity.finish();
            }
        }
        },new ForumLoginOrSignAction.ActionFoceViewAThread() {
            public void actionViewThread(String paramAnonymousString) {
                Intent localIntent = new Intent(ForumRequiedFieldFragment.this.activity, ThreadActivity.class);
                localIntent.putExtra("forumStatus", ForumRequiedFieldFragment.this.forumStatus);
                localIntent.putExtra("topic_id", paramAnonymousString);
                localIntent.putExtra(IntentValue.FORCE_VIEW_THREAD, true);
                ForumRequiedFieldFragment.this.startActivity(localIntent);
            }
        });
        ((ForumActivityStatus) this.activity).showProgress();
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.activity = getActivity();
        this.bar = getActivity().getActionBar();
        this.bar.setSubtitle(null);
        this.bar.setTitle(2131100778);
        this.tapatalkId = TapatalkIdFactory.getTapatalkId(this.activity);
        this.siginAction = new ForumLoginOrSignAction(this.activity, this.forumStatus);
        paramBundle = null;
        if (this.tapatalkId.getUsername() != null) {
            paramBundle = this.tapatalkId.getUsername();
        }
        Object localObject = paramBundle;
        if (paramBundle == null) {
            localObject = this.tapatalkId.getTapatalkIdEmail();
        }
        this.username.setText((CharSequence) localObject);
        int i = 0;
        for (; ; ) {
            if (i >= this.customFields.size()) {
                return;
            }
            paramBundle = new CustomFieldView(this.activity, (CustomRegisterField) this.customFields.get(i));
            this.customFieldViews.add(paramBundle);
            this.requiedContiner.addView(paramBundle.getRequiedView());
            i += 1;
        }
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        this.view = paramLayoutInflater.inflate(2130903346, paramViewGroup, false);
        this.requiedContiner = ((LinearLayout) this.view.findViewById(2131231583));
        this.username = ((EditText) this.view.findViewById(2131231582));
        return this.view;
    }

    public void onHiddenChanged(boolean paramBoolean) {
        super.onHiddenChanged(paramBoolean);
        if (!paramBoolean) {
            this.bar.setSubtitle(null);
            this.bar.setTitle(2131100778);
        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        String str1;
        HashMap localHashMap;
        int i;
        if (paramMenuItem.getItemId() == 0) {
            str1 = this.username.getEditableText().toString();
            localHashMap = new HashMap();
            i = 0;
        }
        for (; ; ) {
            if (i >= this.customFieldViews.size()) {
                signForum(str1, this.tapatalkId.getTapatalkIdEmail(), localHashMap);
                return super.onOptionsItemSelected(paramMenuItem);
            }
            CustomFieldView localCustomFieldView = (CustomFieldView) this.customFieldViews.get(i);
            String str2 = localCustomFieldView.registerField.key;
            if (((localCustomFieldView.registerField.type != null) && (localCustomFieldView.registerField.type.equalsIgnoreCase("input"))) || (localCustomFieldView.registerField.type.equalsIgnoreCase("textarea"))) {
                String str3 = localCustomFieldView.fieldValue.getEditableText().toString().trim();
                if (str3.equals("")) {
                    Toast.makeText(this.activity, localCustomFieldView.registerField.name + getString(2131100780), 0).show();
                    return false;
                }
                localHashMap.put(str2, str3);
            }
            if ((localCustomFieldView.registerField.type != null) && (localCustomFieldView.registerField.type.equalsIgnoreCase("cbox"))) {
                if (localCustomFieldView.fieldValue.getEditableText().toString().trim().equals("")) {
                    Toast.makeText(this.activity, localCustomFieldView.registerField.name + getString(2131100780), 0).show();
                    return false;
                }
                localHashMap.put(str2, localCustomFieldView.getCBOXHashRequiedField());
            }
            if ((localCustomFieldView.registerField.type != null) && ((localCustomFieldView.registerField.type.equalsIgnoreCase("radio")) || (localCustomFieldView.registerField.type.equalsIgnoreCase("drop")))) {
                if (localCustomFieldView.fieldValue.getEditableText().toString().trim().equals("")) {
                    Toast.makeText(this.activity, localCustomFieldView.registerField.name + getString(2131100780), 0).show();
                    return false;
                }
                localHashMap.put(str2, localCustomFieldView.getSingleCheckRequiedField());
            }
            i += 1;
        }
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
        paramMenu.removeGroup(0);
        paramMenu.add(0, 0, 0, getActivity().getString(2131100410)).setShowAsAction(2);
    }

    public void showErrorDialog(String paramString) {
        if (this.loginerrorDialog == null) {
            AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.activity);
            LinearLayout localLinearLayout = (LinearLayout) this.activity.getLayoutInflater().inflate(2130903233, null);
            TextView localTextView1 = (TextView) localLinearLayout.findViewById(2131230900);
            TextView localTextView2 = (TextView) localLinearLayout.findViewById(2131231298);
            localTextView1.setText(this.activity.getString(2131100538));
            localTextView2.setText(paramString);
            localBuilder.setView(localLinearLayout);
            localBuilder.setNegativeButton(this.activity.getString(2131100288), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                }
            });
            this.loginerrorDialog = localBuilder.create();
        }
        if (!this.loginerrorDialog.isShowing()) {
            this.loginerrorDialog.show();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/slidingMenu/login/ForumRequiedFieldFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */