package com.quoord.newonboarding;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import com.quoord.tapatalkpro.action.CategoriesAction;
import com.quoord.tapatalkpro.action.CategoriesAction.CategoriesActionCallBack;
import com.quoord.tapatalkpro.action.GetHotTermsAction;
import com.quoord.tapatalkpro.action.GetHotTermsAction.ActionBack;
import com.quoord.tapatalkpro.action.InitGcmTool;
import com.quoord.tapatalkpro.bean.TapatalkCategory;
import com.quoord.tapatalkpro.bean.TapatalkForumForSearch;
import com.quoord.tapatalkpro.ics.action.IcsSearchForumAction;
import com.quoord.tapatalkpro.ics.action.IcsSearchForumAction.IcsSearchForumActionBack;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.CustomTracker;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tools.TapatalkLog;
import com.quoord.tools.directoryurl.DirectoryUrlUtil;
import com.quoord.tools.net.JSONUtil;
import com.quoord.tools.net.TapatalkAjaxAction;
import com.quoord.tools.net.TapatalkAjaxAction.ActionCallBack;
import com.tapstream.sdk.Config;
import com.tapstream.sdk.ConversionListener;
import com.tapstream.sdk.Tapstream;

import java.net.URI;
import java.util.ArrayList;
import java.util.Stack;

import org.json.JSONArray;
import org.json.JSONObject;

public class ObEntryActivity
        extends FragmentActivity {
    public static final int FINISHONBOAEDING = 1;
    public static final String GUESTLOGIN = "guestLogin";
    public static final String INNERLOGIN = "innerLogin";
    public static final String LOGINPAGE = "accountPage";
    public static final String NOTIFICATION = "fromNotification";
    public static final String STARTSEARCH = "fromsearch";
    public static final int STARTSKIP = 2;
    public static TapatalkForumForSearch tapstreamForum;
    public Stack<QuoordFragment> allstack = new Stack();
    public QuoordFragment currentFragment;
    private boolean fromSearch = false;
    public boolean guestLogin = false;
    private Handler handler;
    public boolean innerLogin = false;
    public boolean isNotification = false;
    public boolean loginPage = false;
    private FragmentManager manager;
    public boolean notification_register = false;
    public SharedPreferences prefs = null;
    private FragmentTransaction transaction;

    private void initFirstShow() {
        if ((this.loginPage) || (this.innerLogin) || (this.isNotification)) {
            showFragment(new ObWelcomeFragment());
            return;
        }
        if (!this.fromSearch) {
            showFragment(new ObWelcomeFragment());
            return;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("needBack", false);
        localIntent.setClass(this, ObJoinActivity.class);
        startActivityForResult(localIntent, 2);
    }

    private void initGcm() {
        new InitGcmTool(this).initGcm();
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        this.currentFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        this.prefs = Prefs.get(this);
        setContentView(2130903243);
        this.handler = new Handler() {
            public void handleMessage(Message paramAnonymousMessage) {
                super.handleMessage(paramAnonymousMessage);
                paramAnonymousMessage.toString();
            }
        };
        getActionBar().hide();
        paramBundle = new Config();
        Tapstream.create(getApplication(), "tapatalk", "bx8RnDF4RHKdMHMhxP7saA", paramBundle);
        Tapstream.getInstance().getConversionData(new ConversionListener() {
            public void conversionData(String paramAnonymousString) {
                if (paramAnonymousString != null) {
                    try {
                        ObEntryActivity.this.handler.obtainMessage().obj = paramAnonymousString;
                        paramAnonymousString = new JSONObject(paramAnonymousString).optJSONArray("hits");
                        if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0)) {
                            paramAnonymousString = new JSONUtil(((JSONObject) paramAnonymousString.get(0)).getJSONObject("custom_parameters"));
                            Object localObject = paramAnonymousString.optString("fid");
                            String str = paramAnonymousString.optString("referer");
                            if ((localObject != null) && (!((String) localObject).equals(""))) {
                                paramAnonymousString = DirectoryUrlUtil.createGetForumById(ObEntryActivity.this, (String) localObject);
                                new TapatalkAjaxAction(ObEntryActivity.this).getJsonArrayAction(paramAnonymousString, new TapatalkAjaxAction.ActionCallBack() {
                                    public void actionCallBack(Object paramAnonymous2Object) {
                                        JSONArray localJSONArray = (JSONArray) paramAnonymous2Object;
                                        ArrayList localArrayList = new ArrayList();
                                        if (localJSONArray != null) {
                                            TapatalkLog.v("tapatalkLog", "search forum by id back " + paramAnonymous2Object.toString());
                                        }
                                        try {
                                            int j = localJSONArray.length();
                                            int i;
                                            if (j > 0) {
                                                i = 0;
                                            }
                                            for (; ; ) {
                                                if (i >= j) {
                                                    if (localArrayList.size() > 0) {
                                                        ObEntryActivity.tapstreamForum = (TapatalkForumForSearch) localArrayList.get(0);
                                                    }
                                                    return;
                                                }
                                                localArrayList.add(TapatalkForumForSearch.getForum(localJSONArray.getJSONObject(i), null, null, null));
                                                i += 1;
                                            }
                                            return;
                                        } catch (Exception paramAnonymous2Object) {
                                        }
                                    }
                                });
                                return;
                            }
                            if (str.equals("")) {
                                paramAnonymousString.optString("referrer");
                            }
                            if ((str != null) && (!str.equals(""))) {
                                localObject = URI.create(str);
                                paramAnonymousString = "";
                                if (((URI) localObject).getHost() != null) {
                                    paramAnonymousString = "" + ((URI) localObject).getHost();
                                }
                                paramAnonymousString = paramAnonymousString + ((URI) localObject).getPath();
                                new IcsSearchForumAction(ObEntryActivity.this).directoryUrlMatchSearchForum(paramAnonymousString, 1, 20, false, true, new IcsSearchForumAction.IcsSearchForumActionBack() {
                                    public void searchForumActionBack(ArrayList<TapatalkForumForSearch> paramAnonymous2ArrayList) {
                                        if (paramAnonymous2ArrayList.size() > 0) {
                                            ObEntryActivity.tapstreamForum = (TapatalkForumForSearch) paramAnonymous2ArrayList.get(0);
                                        }
                                    }
                                });
                                return;
                            }
                        }
                    } catch (Exception paramAnonymousString) {
                        paramAnonymousString.printStackTrace();
                    }
                }
            }
        });
        ObActivitiesStackManager.getInstance().addActivity(this);
        this.fromSearch = getIntent().getBooleanExtra("fromsearch", false);
        this.loginPage = getIntent().getBooleanExtra("accountPage", false);
        this.innerLogin = getIntent().getBooleanExtra("innerLogin", false);
        this.isNotification = getIntent().getBooleanExtra("fromNotification", false);
        this.guestLogin = getIntent().getBooleanExtra("guestLogin", false);
        paramBundle = this.prefs.edit();
        paramBundle.putBoolean("isNotification", this.isNotification);
        paramBundle.commit();
        initFirstShow();
        new CategoriesAction(this).getCategories(new CategoriesAction.CategoriesActionCallBack() {
            public void actionCallBack(ArrayList<TapatalkCategory> paramAnonymousArrayList) {
            }
        });
        new GetHotTermsAction(this).getHotTerms(new GetHotTermsAction.ActionBack() {
            public void getActionBack(ArrayList<String> paramAnonymousArrayList) {
            }
        });
        initGcm();
    }

    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
        if (paramInt == 4) {
            finish();
        }
        return true;
    }

    protected void onResume() {
        new Handler().post(new Runnable() {
            public void run() {
                if (ObEntryActivity.this.getActionBar() != null) {
                    ObEntryActivity.this.getActionBar().hide();
                }
            }
        });
        super.onResume();
        CustomTracker.comScoreResume(this);
    }

    public void onStart() {
        super.onStart();
        CustomTracker.start(this);
    }

    public void onStop() {
        super.onStop();
        CustomTracker.stop(this);
    }

    public void removeAllFragment() {
        this.allstack.removeAllElements();
        FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
        getSupportFragmentManager().popBackStack(null, 1);
        localFragmentTransaction.commitAllowingStateLoss();
    }

    public void removeFragment(QuoordFragment paramQuoordFragment) {
        this.allstack.remove(paramQuoordFragment);
        if (!this.allstack.empty()) {
            showFragment((QuoordFragment) this.allstack.peek());
        }
    }

    public void showFragment(QuoordFragment paramQuoordFragment) {
        FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (this.currentFragment != null) {
            localFragmentTransaction.hide(this.currentFragment);
        }
        if (getSupportFragmentManager().findFragmentByTag(String.valueOf(paramQuoordFragment.hashCode())) != null) {
            localFragmentTransaction.show(paramQuoordFragment);
        }
        for (; ; ) {
            this.currentFragment = paramQuoordFragment;
            localFragmentTransaction.commitAllowingStateLoss();
            invalidateOptionsMenu();
            return;
            localFragmentTransaction.add(2131231313, paramQuoordFragment, String.valueOf(paramQuoordFragment.hashCode()));
        }
    }

    public void showFragmentAndAddStack(QuoordFragment paramQuoordFragment) {
        this.allstack.add(paramQuoordFragment);
        showFragment(paramQuoordFragment);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/newonboarding/ObEntryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */