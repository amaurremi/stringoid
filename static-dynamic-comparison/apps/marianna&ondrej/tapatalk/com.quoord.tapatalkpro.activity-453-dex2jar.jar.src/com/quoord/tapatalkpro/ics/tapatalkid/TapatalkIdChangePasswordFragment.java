package com.quoord.tapatalkpro.ics.tapatalkid;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import com.quoord.tapatalkpro.adapter.CallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.view.TapaButton;

import java.net.URLEncoder;

import org.json.JSONException;
import org.json.JSONObject;

public class TapatalkIdChangePasswordFragment
        extends QuoordFragment
        implements CallBackInterface {
    private TapaButton changepassword = null;
    private EditText confirm_new_password = null;
    private TapatalkJsonEngine engine = null;
    private View layout = null;
    private Activity mActivity;
    private EditText new_password = null;
    private EditText old_password = null;
    private SharedPreferences prefs = null;
    private ProgressDialog progress = null;

    public void callBack(EngineResponse paramEngineResponse) {
        Object localObject;
        if ((!"".equals(paramEngineResponse.getMethod())) && ((paramEngineResponse.getResponse() instanceof JSONObject))) {
            localObject = (JSONObject) paramEngineResponse.getResponse();
        }
        try {
            if (((JSONObject) localObject).getBoolean("result")) {
                paramEngineResponse = this.confirm_new_password.getText().toString().trim();
                localObject = ((JSONObject) localObject).getString("token");
                Toast.makeText(this.mActivity, this.mActivity.getResources().getString(2131100310), 1).show();
                SharedPreferences.Editor localEditor = this.prefs.edit();
                localEditor.putString("password", paramEngineResponse);
                localEditor.putString("token", (String) localObject);
                localEditor.commit();
                this.mActivity.finish();
            }
            for (; ; ) {
                this.progress.cancel();
                return;
                paramEngineResponse = (String) ((JSONObject) localObject).get("result_text");
                Toast.makeText(this.mActivity, paramEngineResponse, 1).show();
            }
        } catch (JSONException paramEngineResponse) {
            for (; ; ) {
                paramEngineResponse.printStackTrace();
            }
        }
    }

    public void changePassword() {
        this.changepassword.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                paramAnonymousView = TapatalkIdChangePasswordFragment.this.old_password.getText().toString().trim();
                String str1 = TapatalkIdChangePasswordFragment.this.new_password.getText().toString().trim();
                String str2 = TapatalkIdChangePasswordFragment.this.confirm_new_password.getText().toString().trim();
                if ((!"".equals(paramAnonymousView)) && (!"".equals(str1)) && (!"".equals(str2))) {
                    if ((str1.length() > 3) && (str2.length() > 3)) {
                        if (!str1.equals(str2)) {
                            Toast.makeText(TapatalkIdChangePasswordFragment.this.mActivity, TapatalkIdChangePasswordFragment.this.mActivity.getResources().getString(2131100308), 1).show();
                        }
                    }
                }
                do {
                    return;
                    paramAnonymousView = TapatalkJsonEngine.CHANGE_PASS_WORD + "?au_id=" + TapatalkIdChangePasswordFragment.this.prefs.getInt("tapatalk_auid", 0) + "&token=" + TapatalkIdChangePasswordFragment.this.prefs.getString("token", "") + "&password=" + URLEncoder.encode(TapatalkIdChangePasswordFragment.this.old_password.getText().toString().trim()) + "&new_password=" + URLEncoder.encode(TapatalkIdChangePasswordFragment.this.confirm_new_password.getText().toString().trim());
                    TapatalkIdChangePasswordFragment.this.engine.call(paramAnonymousView);
                    TapatalkIdChangePasswordFragment.this.progress.show();
                    return;
                    Toast.makeText(TapatalkIdChangePasswordFragment.this.mActivity, TapatalkIdChangePasswordFragment.this.mActivity.getResources().getString(2131100315), 1).show();
                    return;
                    if (("".equals(paramAnonymousView)) || ("".equals(str1))) {
                        Toast.makeText(TapatalkIdChangePasswordFragment.this.mActivity, TapatalkIdChangePasswordFragment.this.mActivity.getResources().getString(2131100303), 1).show();
                        return;
                    }
                } while (!"".equals(str2));
                Toast.makeText(TapatalkIdChangePasswordFragment.this.mActivity, TapatalkIdChangePasswordFragment.this.mActivity.getResources().getString(2131100309), 1).show();
            }
        });
    }

    public boolean isOpCancel() {
        return false;
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.mActivity = getActivity();
        paramBundle = getActivity().getActionBar();
        paramBundle.setDisplayHomeAsUpEnabled(true);
        paramBundle.setTitle(this.mActivity.getResources().getString(2131100296));
        this.prefs = Prefs.get(this.mActivity);
        this.engine = new TapatalkJsonEngine(this.mActivity, this);
        this.progress = new ProgressDialog(this.mActivity);
        this.progress.setMessage(this.mActivity.getResources().getString(2131100313));
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        this.layout = paramLayoutInflater.inflate(2130903091, null);
        this.old_password = ((EditText) this.layout.findViewById(2131230912));
        this.new_password = ((EditText) this.layout.findViewById(2131230913));
        this.confirm_new_password = ((EditText) this.layout.findViewById(2131230914));
        this.changepassword = ((TapaButton) this.layout.findViewById(2131230915));
        changePassword();
        return this.layout;
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void updateSubclassDialog(int paramInt) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/tapatalkid/TapatalkIdChangePasswordFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */