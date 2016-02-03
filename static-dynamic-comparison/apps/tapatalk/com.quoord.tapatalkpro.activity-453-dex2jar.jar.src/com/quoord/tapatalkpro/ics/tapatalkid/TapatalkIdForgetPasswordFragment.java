package com.quoord.tapatalkpro.ics.tapatalkid;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.Bundle;
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
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.view.TapaButton;

import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONException;
import org.json.JSONObject;

public class TapatalkIdForgetPasswordFragment
        extends QuoordFragment
        implements CallBackInterface {
    private EditText email = null;
    private TapatalkJsonEngine engine = null;
    private View layout = null;
    private Activity mActivity = null;
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
                this.mActivity.finish();
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
        super.onCreate(paramBundle);
        this.mActivity = getActivity();
        paramBundle = this.mActivity.getActionBar();
        paramBundle.setDisplayHomeAsUpEnabled(true);
        paramBundle.setTitle(getString(2131100318));
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/tapatalkid/TapatalkIdForgetPasswordFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */