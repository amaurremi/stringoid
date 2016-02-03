package com.quoord.newonboarding;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import com.quoord.tapatalkpro.adapter.CallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tapatalkpro.view.TapaButton;
import com.quoord.tools.ActionBarController;

import java.net.URLEncoder;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONException;
import org.json.JSONObject;

public class TapatalkIdForgetPasswordFragment
        extends QuoordFragment
        implements CallBackInterface, ActionBarController {
    private ActionBar bar;
    private EditText email = null;
    private TapatalkJsonEngine engine = null;
    private View layout = null;
    private ObJoinActivity mActivity = null;
    private ProgressDialog progress = null;
    private TapaButton reset = null;
    private boolean resetFlag = false;
    private String username_expression = null;

    private boolean EmailFormat(String paramString) {
        return Pattern.compile(this.username_expression).matcher(paramString).matches();
    }

    public static TapatalkIdForgetPasswordFragment newInstance() {
        return new TapatalkIdForgetPasswordFragment();
    }

    public void callBack(EngineResponse paramEngineResponse) {
        String str = paramEngineResponse.getMethod();
        if ((!"".equals(str)) && ((paramEngineResponse.getResponse() instanceof JSONObject))) {
            paramEngineResponse = (JSONObject) paramEngineResponse.getResponse();
            if (!str.contains("au_reset_password")) {
            }
        }
        try {
            this.resetFlag = ((Boolean) paramEngineResponse.get("result")).booleanValue();
            paramEngineResponse = (String) paramEngineResponse.get("result_text");
            Toast.makeText(this.mActivity, paramEngineResponse, 1).show();
            this.progress.cancel();
            paramEngineResponse = this.mActivity.getIntent();
            this.mActivity.setResult(37, paramEngineResponse);
            if (this.resetFlag) {
                Util.hideSoftKeyb(getActivity(), this.email);
                this.mActivity.removeFragment(this);
            }
            return;
        } catch (JSONException paramEngineResponse) {
            for (; ; ) {
                paramEngineResponse.printStackTrace();
            }
        }
    }

    public boolean isOpCancel() {
        return false;
    }

    public void onCreate(Bundle paramBundle) {
        Util.setPortrait(getActivity());
        super.onCreate(paramBundle);
        this.mActivity = ((ObJoinActivity) getActivity());
        setActionBar(getActivity());
        this.username_expression = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        this.engine = new TapatalkJsonEngine(this.mActivity, this);
        this.progress = new ProgressDialog(this.mActivity);
        this.progress.setMessage(this.mActivity.getResources().getString(2131100313));
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        this.layout = paramLayoutInflater.inflate(2130903380, null);
        this.email = ((EditText) this.layout.findViewById(2131231618));
        this.reset = ((TapaButton) this.layout.findViewById(2131231619));
        setResetOnclick();
        return this.layout;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (16908332 == paramMenuItem.getItemId()) {
            this.mActivity.allstack.pop();
            paramMenuItem = (QuoordFragment) this.mActivity.allstack.peek();
            this.mActivity.showFragment(paramMenuItem);
            return true;
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public void setActionBar(Activity paramActivity) {
        if (this.bar == null) {
            this.bar = getActivity().getActionBar();
        }
        this.bar.setTitle(getString(2131100318));
        this.bar.setDisplayHomeAsUpEnabled(true);
        this.bar.show();
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void setResetOnclick() {
        this.reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                if (!TapatalkIdForgetPasswordFragment.this.email.getText().toString().trim().equals("")) {
                    if (TapatalkIdForgetPasswordFragment.this.EmailFormat(TapatalkIdForgetPasswordFragment.this.email.getText().toString().trim())) {
                        paramAnonymousView = "https://directory.tapatalk.com/au_reset_password.php?email=" + URLEncoder.encode(TapatalkIdForgetPasswordFragment.this.email.getText().toString().trim());
                        TapatalkIdForgetPasswordFragment.this.engine.call(paramAnonymousView);
                        TapatalkIdForgetPasswordFragment.this.progress.show();
                        return;
                    }
                    Toast.makeText(TapatalkIdForgetPasswordFragment.this.mActivity, TapatalkIdForgetPasswordFragment.this.mActivity.getResources().getString(2131100302), 1).show();
                    return;
                }
                Toast.makeText(TapatalkIdForgetPasswordFragment.this.mActivity, TapatalkIdForgetPasswordFragment.this.mActivity.getResources().getString(2131100314), 1).show();
            }
        });
    }

    public void updateSubclassDialog(int paramInt) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/newonboarding/TapatalkIdForgetPasswordFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */