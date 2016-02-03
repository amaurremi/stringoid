package com.quoord.tapatalkpro.activity.directory.ics;

import android.app.ActionBar;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gcm.GCMRegistrar;
import com.mobeta.android.dslv.DragSortListView;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.adapter.CallBackInterface;
import com.quoord.tapatalkpro.adapter.directory.FavoriteForumAdapter;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsActivity;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;

import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONException;
import org.json.JSONObject;

public class FavForumsFragment
        extends QuoordFragment
        implements CallBackInterface {
    AlertDialog.Builder alert;
    private TapatalkJsonEngine engine = null;
    private View forumHeader = null;
    private TextView forumsHint;
    private boolean isFirstLaunch = false;
    public FavoriteForumAdapter mNetworkAdapter;
    public LinearLayout message_lay;
    public boolean needUpdateRemote = false;
    public DragSortListView networkItemList;
    private SharedPreferences prefs;

    public static void clearAllSigninForums(Context paramContext, ArrayList<TapatalkForum> paramArrayList, int paramInt) {
        try {
            paramContext = Prefs.get(paramContext).edit();
            int j = paramArrayList.size();
            int i = 0;
            for (; ; ) {
                if (i >= j) {
                    paramContext.commit();
                    return;
                }
                Object localObject = (TapatalkForum) paramArrayList.get(i);
                String str = ((TapatalkForum) localObject).getId().intValue() + paramInt + ((TapatalkForum) localObject).getName() + "usesignin";
                localObject = paramInt + ((TapatalkForum) localObject).getId() + ((TapatalkForum) localObject).getLowerUserName() + "usesignin";
                paramContext.putString(str, "");
                paramContext.putString((String) localObject, "");
                i += 1;
            }
            return;
        } catch (Exception paramContext) {
        }
    }

    private void handleActionBar() {
        getActivity().getActionBar().show();
        this.prefs = Prefs.get(getActivity());
        if ((getActivity() instanceof ShowFragmentActivityInter)) {
            ((ShowFragmentActivityInter) getActivity()).actionBar4ShowTitle("defaultTitleString");
        }
    }

    private void onConfigChange(Configuration paramConfiguration) {
        int i = (int) getResources().getDimension(2131427376);
        ((RelativeLayout.LayoutParams) this.networkItemList.getLayoutParams()).setMargins(i, 0, i, 0);
        this.networkItemList.invalidate();
        this.mNetworkAdapter.updateProfile();
    }

    public void callBack(EngineResponse paramEngineResponse) {
        Object localObject1 = paramEngineResponse.getMethod();
        if ((!paramEngineResponse.isSuccess()) || (((String) localObject1).contains("au_update_profile"))) {
        }
        for (; ; ) {
            try {
                localObject1 = (JSONObject) paramEngineResponse.getResponse();
                paramEngineResponse = (Boolean) ((JSONObject) localObject1).get("result");
                localObject1 = (String) ((JSONObject) localObject1).get("result_text");
                if (paramEngineResponse.booleanValue()) {
                    this.mNetworkAdapter.removeSignInfo();
                }
                Toast.makeText(getActivity(), (CharSequence) localObject1, 1).show();
                return;
            } catch (Exception paramEngineResponse) {
            }
            if (((String) localObject1).contains("au_update_profile")) {
            }
            try {
                Object localObject2 = (JSONObject) paramEngineResponse.getResponse();
                Object localObject3 = (Boolean) ((JSONObject) localObject2).get("result");
                localObject2 = (String) ((JSONObject) localObject2).get("result_text");
                Toast.makeText(getActivity(), (CharSequence) localObject2, 1).show();
                if (((String) localObject1).contains("au_resend_code")) {
                }
                try {
                    localObject2 = (JSONObject) paramEngineResponse.getResponse();
                    localObject3 = (Boolean) ((JSONObject) localObject2).get("result");
                    localObject2 = (String) ((JSONObject) localObject2).get("result_text");
                    Toast.makeText(getActivity(), (CharSequence) localObject2, 1).show();
                    if (((String) localObject1).contains("au_sign_in")) {
                        paramEngineResponse = (JSONObject) paramEngineResponse.getResponse();
                        try {
                            localObject1 = (Boolean) paramEngineResponse.get("result");
                            if (((Boolean) localObject1).booleanValue()) {
                                int i = paramEngineResponse.getInt("au_id");
                                localObject2 = (String) paramEngineResponse.get("token");
                                localObject3 = this.prefs.edit();
                                ((SharedPreferences.Editor) localObject3).putInt("tapatalk_auid", i);
                                ((SharedPreferences.Editor) localObject3).putBoolean("login", ((Boolean) localObject1).booleanValue());
                                ((SharedPreferences.Editor) localObject3).putString("username", paramEngineResponse.get("username").toString());
                                ((SharedPreferences.Editor) localObject3).putString("email", paramEngineResponse.get("email").toString());
                                ((SharedPreferences.Editor) localObject3).putString("status", paramEngineResponse.get("status").toString());
                                ((SharedPreferences.Editor) localObject3).putString("trueusername", paramEngineResponse.get("username").toString());
                                ((SharedPreferences.Editor) localObject3).putString("token", (String) localObject2);
                                ((SharedPreferences.Editor) localObject3).commit();
                                return;
                            }
                        } catch (JSONException paramEngineResponse) {
                            paramEngineResponse.printStackTrace();
                            return;
                        }
                        paramEngineResponse = (String) paramEngineResponse.get("result_text");
                        Toast.makeText(getActivity(), paramEngineResponse, 1).show();
                        return;
                    }
                } catch (Exception localException1) {
                }
            } catch (Exception localException2) {
            }
        }
    }

    public boolean clearActionMode() {
        if (this.mNetworkAdapter != null) {
            return this.mNetworkAdapter.clearActionMode();
        }
        return false;
    }

    public void clearData() {
        if (this.mNetworkAdapter != null) {
            this.mNetworkAdapter.clearTempData();
            this.mNetworkAdapter.notifyDataSetChanged();
            this.mNetworkAdapter.getmDatas().clear();
        }
    }

    public void closeHint(int paramInt) {
        Util.hideHintview(this.forumsHint, paramInt);
    }

    public void dialogCancle(DialogInterface paramDialogInterface, boolean paramBoolean) {
        try {
            Field localField = paramDialogInterface.getClass().getSuperclass().getDeclaredField("mShowing");
            localField.setAccessible(true);
            localField.set(paramDialogInterface, Boolean.valueOf(paramBoolean));
            return;
        } catch (Exception paramDialogInterface) {
            paramDialogInterface.printStackTrace();
        }
    }

    public FavoriteForumAdapter getmNetworkAdapter() {
        return this.mNetworkAdapter;
    }

    public boolean isOpCancel() {
        return false;
    }

    public boolean matchUsername(String paramString) {
        return Pattern.compile("([A-Za-z0-9]|[.]){3,32}").matcher(paramString).matches();
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.isFirstLaunch = true;
        handleActionBar();
        Prefs.isShowHint(getActivity(), this.forumsHint);
        this.forumsHint.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent) {
                FavForumsFragment.this.closeHint(0);
                return true;
            }
        });
        this.mNetworkAdapter = new FavoriteForumAdapter(this, getActivity(), this.networkItemList, this.message_lay, this.forumHeader);
        this.networkItemList.setDropListener(this.mNetworkAdapter);
        onConfigChange(getActivity().getResources().getConfiguration());
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        if ((paramInt1 == 42716) || (paramInt1 == 9667)) {
            this.mNetworkAdapter.onActivityResult(paramInt1, paramInt2, paramIntent);
        }
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        super.onConfigurationChanged(paramConfiguration);
        onConfigChange(paramConfiguration);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903041, paramViewGroup, false);
        this.networkItemList = ((DragSortListView) paramLayoutInflater.findViewById(2131230759));
        this.message_lay = ((LinearLayout) paramLayoutInflater.findViewById(2131230761));
        this.forumsHint = ((TextView) paramLayoutInflater.findViewById(2131230764));
        this.forumHeader = paramLayoutInflater.findViewById(2131230760);
        ThemeUtil.setListViewStyle(this.networkItemList, getActivity());
        this.networkItemList.setDivider(null);
        return paramLayoutInflater;
    }

    public void onDestroy() {
        super.onDestroy();
        this.mNetworkAdapter = null;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return false;
        }
        paramMenuItem = new Intent(getActivity(), SettingsActivity.class);
        paramMenuItem.addFlags(67108864);
        startActivityForResult(paramMenuItem, 10);
        return true;
    }

    public void onResume() {
        super.onResume();
        this.prefs = Prefs.get(getActivity());
        Util.hideSoftKeyb(getActivity(), this.networkItemList);
        if (this.isFirstLaunch) {
            this.isFirstLaunch = false;
        }
        while (this.mNetworkAdapter == null) {
            return;
        }
        this.mNetworkAdapter.updateProfile();
        this.mNetworkAdapter.updatedata(this.needUpdateRemote);
    }

    public void reLogin() {
        if (!this.prefs.getString("email", "").equals("")) {
            String str2 = TapatalkJsonEngine.SIGNIN + "?email=" + URLEncoder.encode(this.prefs.getString("email", "")) + "&password=" + this.prefs.getString("ttidpassword", "");
            String str3 = GCMRegistrar.getRegistrationId(getActivity());
            String str1 = str2;
            if (!str3.equals("")) {
                str1 = new StringBuilder(String.valueOf(str2)).append("&push_token=").append(str3).toString() + "&device_id=" + Util.getMD5(Util.getMacAddress(getActivity())) + "&device_type=" + Util.getDeviceName();
            }
            this.engine = new TapatalkJsonEngine(getActivity(), this);
            this.engine.call(str1);
        }
    }

    public void resend() {
        this.engine = new TapatalkJsonEngine(getActivity(), this);
        Object localObject = TapatalkIdFactory.getTapatalkId(getActivity());
        if (Util.checkString(((TapatalkId) localObject).getTapatalkIdEmail())) {
            localObject = TapatalkJsonEngine.RESEDNG + "?au_id=" + ((TapatalkId) localObject).getAuid() + "&token=" + ((TapatalkId) localObject).getToken();
            this.engine.call((String) localObject);
        }
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void showDialog(int paramInt) {
        final Object localObject = TapatalkIdFactory.getTapatalkId(getActivity());
        switch (paramInt) {
            default:
                return;
            case 23:
                new DialogFragment() {
                    public Dialog onCreateDialog(Bundle paramAnonymousBundle) {
                        new AlertDialog.Builder(getActivity()).setMessage(getString(2131100485) + " " + localObject.getTapatalkIdEmail()).setNegativeButton(getString(2131100588), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                                FavForumsFragment.this.needUpdateRemote = true;
                                paramAnonymous2DialogInterface = new Intent(FavForumsFragment .2.
                                this.getActivity(), TapatalkIdWebviewActivity.class);
                                Object localObject = TapatalkIdFactory.getTapatalkId(FavForumsFragment .2.
                                this.getActivity());
                                localObject = "https://directory.tapatalk.com/id/manage.php?token=" + ((TapatalkId) localObject).getToken() + "&code=" + Util.getMD5(new StringBuilder(String.valueOf(((TapatalkId) localObject).getAuid())).append("|").append(((TapatalkId) localObject).getToken()).toString()) + "&from=" + FavForumsFragment.this.prefs.getString("handle", "");
                                paramAnonymous2DialogInterface.putExtra("change_url", (String) localObject);
                                paramAnonymous2DialogInterface = new Intent("android.intent.action.VIEW");
                                paramAnonymous2DialogInterface.setData(Uri.parse((String) localObject));
                                FavForumsFragment .2. this.startActivity(paramAnonymous2DialogInterface);
                            }
                        }).setNeutralButton(getString(2131099976), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                                FavForumsFragment.this.mNetworkAdapter.removeSignInfo();
                                FavForumsFragment.this.resend();
                            }
                        }).create();
                    }
                }.show(getFragmentManager(), "dailog");
                return;
        }
        this.alert = new AlertDialog.Builder(getActivity());
        this.alert.setTitle(getString(2131100587));
        localObject = LayoutInflater.from(getActivity()).inflate(2130903360, null);
        final EditText localEditText = (EditText) ((View) localObject).findViewById(2131231190);
        this.alert.setView((View) localObject);
        this.alert.setPositiveButton(getString(2131099976), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                FavForumsFragment.this.needUpdateRemote = true;
                String str = localEditText.getEditableText().toString();
                str.length();
                Object localObject = TapatalkIdFactory.getTapatalkId(FavForumsFragment.this.getActivity());
                localObject = "https://directory.tapatalk.com/au_update_profile.php?" + TapatalkApp.APP_KEY + "&au_id=" + ((TapatalkId) localObject).getAuid() + "&token=" + ((TapatalkId) localObject).getToken() + "&username=" + str;
                if ((str != null) && (!str.trim().equals(""))) {
                    if (FavForumsFragment.this.matchUsername(str)) {
                        FavForumsFragment.this.engine = new TapatalkJsonEngine(FavForumsFragment.this.getActivity(), FavForumsFragment.this);
                        FavForumsFragment.this.engine.call((String) localObject);
                        FavForumsFragment.this.dialogCancle(paramAnonymousDialogInterface, true);
                        return;
                    }
                    FavForumsFragment.this.dialogCancle(paramAnonymousDialogInterface, false);
                    Toast.makeText(FavForumsFragment.this.getActivity(), FavForumsFragment.this.getString(2131100702), 0).show();
                    return;
                }
                FavForumsFragment.this.dialogCancle(paramAnonymousDialogInterface, false);
                Toast.makeText(FavForumsFragment.this.getActivity(), FavForumsFragment.this.getString(2131100701), 0).show();
            }
        });
        this.alert.setNegativeButton(getString(2131100478), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                FavForumsFragment.this.dialogCancle(paramAnonymousDialogInterface, true);
            }
        });
        this.alert.show();
    }

    public void updateSubclassDialog(int paramInt) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/directory/ics/FavForumsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */