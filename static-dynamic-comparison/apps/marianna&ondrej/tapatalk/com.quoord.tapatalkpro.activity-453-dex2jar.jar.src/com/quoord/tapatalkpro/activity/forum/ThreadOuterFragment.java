package com.quoord.tapatalkpro.activity.forum;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.Editable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import com.quoord.DialogUtil.ModerationDialogAdapter;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.action.AddToFavoriate.AddFavoriate;
import com.quoord.tapatalkpro.action.CallBackChecker;
import com.quoord.tapatalkpro.activity.directory.ics.AccountEntryActivity;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.adapter.directory.ics.ThreadNavigationAdapter;
import com.quoord.tapatalkpro.adapter.forum.ThreadAdapter;
import com.quoord.tapatalkpro.alarm.notification.TopTopicNotification;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.Forum;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.PostData;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.bean.TopicController;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.ics.BaseListFragment;
import com.quoord.tapatalkpro.ics.advancesearch.AdvanceSearchActivity;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ics.slidingMenu.login.ForumLoginActivity;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.ui.ThreadQuoteHelper;
import com.quoord.tapatalkpro.util.BBcodeUtil;
import com.quoord.tapatalkpro.util.BroadcastControl;
import com.quoord.tapatalkpro.util.CountdownTool;
import com.quoord.tapatalkpro.util.CustomTracker;
import com.quoord.tapatalkpro.util.ForumUrlUtil;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.TwoPanelController;
import com.quoord.tools.net.TapatalkAjaxLogAction;
import com.quoord.tools.net.TapatalkLogUrlUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

public class ThreadOuterFragment
        extends BaseListFragment
        implements ForumActivityStatus, TryTwiceCallBackInterface, TwoPanelController, AddToFavoriate.AddFavoriate {
    public Activity activity;
    private RelativeLayout addView;
    private LinearLayout addtoFavoriateView;
    public ActionBar bar;
    public LinearLayout bottomView;
    public String cacheFile;
    public boolean canReply = false;
    private String channel = null;
    private TextView countdown;
    private SharedPreferences countdownPrefs;
    private CountdownTool countdownTool;
    private int currentPage;
    public HashMap dataCache = new HashMap();
    private int deepPage = -1;
    private int deepPerpage = -1;
    private TextView deleteStatus;
    private TapatalkEngine engine;
    private TextView firstReplyMessage;
    private RelativeLayout firstReplyMessageLayout;
    private boolean forceShowThread = false;
    public ArrayList<Forum> forumList = new ArrayList();
    public ForumStatus forumStatus;
    public boolean fromFeed;
    private boolean fromIntent = true;
    public boolean getPost = false;
    public boolean goto_first_post;
    private RelativeLayout guest_reply_layout;
    private TextView guestreply;
    private ImageView guestreplyline;
    public boolean isAnn = false;
    private boolean isFromTopTopicNotification = false;
    private boolean isJumped = false;
    boolean isNew = false;
    private boolean isShowReply = true;
    private int jumpPage;
    private int jumpToPosition;
    private ProgressBar loading;
    private String mForumId = null;
    public ThreadFragment mFragment;
    public ViewPager mPager;
    private String mPostId;
    ProgressDialog mProgressDialog = null;
    public int mReplyCount;
    private SearchView mSearchView;
    public ThreadAdapter mThreadAdapter;
    public Topic mTopic = null;
    public TopicController mTopicController;
    private String mTopicId = null;
    private String mTopicTitle = null;
    private Handler mUIhandler;
    public String openMode = null;
    public AlertDialog pageListDialog;
    public ThreadPagerAdapter pagerAdapter;
    private int post_countdown = 0;
    private SharedPreferences prefs;
    private LinearLayout progress;
    private LinearLayout quick_lay;
    private RelativeLayout quickbar;
    private EditText quickreply_text;
    public ThreadQuoteHelper quoteHelper;
    private ImageView reply;
    private MenuItem searchItem;
    private ImageView show_all;
    private String spkey;
    private MenuItem subItem;
    public ArrayList<String> titleList = new ArrayList();
    private boolean tryTwice = false;
    private MenuItem unSubItem;
    private View view;

    public ThreadOuterFragment() {
    }

    public ThreadOuterFragment(boolean paramBoolean) {
        this.forceShowThread = paramBoolean;
    }

    public ThreadOuterFragment(boolean paramBoolean, HashMap paramHashMap) {
        this.fromIntent = paramBoolean;
        if (paramHashMap.containsKey("forumStatus")) {
            this.forumStatus = ((ForumStatus) paramHashMap.get("forumStatus"));
        }
        if (paramHashMap.containsKey("mForumId")) {
            this.mForumId = ((String) paramHashMap.get("mForumId"));
        }
        if (paramHashMap.containsKey("reply_count")) {
            this.mReplyCount = ((Integer) paramHashMap.get("reply_count")).intValue();
        }
        if (paramHashMap.containsKey("topic_id")) {
            this.mTopicId = ((String) paramHashMap.get("topic_id"));
        }
        if (paramHashMap.containsKey("post_id")) {
            this.mPostId = ((String) paramHashMap.get("post_id"));
        }
        if (paramHashMap.containsKey("topic_title")) {
            this.mTopicTitle = ((String) paramHashMap.get("topic_title"));
        }
        if (paramHashMap.containsKey("isAnn")) {
            this.isAnn = ((Boolean) paramHashMap.get("isAnn")).booleanValue();
        }
        if (paramHashMap.containsKey("isNew")) {
            this.isNew = ((Boolean) paramHashMap.get("isNew")).booleanValue();
        }
        if (paramHashMap.containsKey("goto_first_post")) {
            this.goto_first_post = ((Boolean) paramHashMap.get("goto_first_post")).booleanValue();
        }
        if (paramHashMap.containsKey("getPost")) {
            this.getPost = ((Boolean) paramHashMap.get("getPost")).booleanValue();
        }
        if (paramHashMap.containsKey("spkey")) {
            this.spkey = ((String) paramHashMap.get("spkey"));
        }
        if (paramHashMap.containsKey("topic")) {
            this.mTopic = ((Topic) paramHashMap.get("topic"));
        }
        if (paramHashMap.containsKey("channel")) {
            this.channel = ((String) paramHashMap.get("channel"));
        }
        if (paramHashMap.containsKey("openMode")) {
            this.openMode = ((String) paramHashMap.get("openMode"));
        }
    }

    private void getData(Bundle paramBundle) {
        Intent localIntent = this.activity.getIntent();
        if (this.fromIntent) {
            if (!localIntent.getBooleanExtra("fromFeed", false)) {
                break label431;
            }
        }
        label431:
        for (this.forumStatus = ((ThreadActivity) this.activity).forumStatus; ; this.forumStatus = ((ForumStatus) localIntent.getSerializableExtra("forumStatus"))) {
            this.mForumId = localIntent.getStringExtra("forumId");
            this.mReplyCount = localIntent.getIntExtra("reply_count", 0);
            this.mTopicId = localIntent.getStringExtra("topic_id");
            this.mPostId = localIntent.getStringExtra("post_id");
            this.mTopicTitle = localIntent.getStringExtra("topic_title");
            this.isAnn = localIntent.getBooleanExtra("isAnn", false);
            this.isNew = localIntent.getBooleanExtra("isNew", false);
            this.goto_first_post = localIntent.getBooleanExtra("goto_first_post", false);
            this.getPost = localIntent.getBooleanExtra("getPost", false);
            this.mTopic = ((Topic) localIntent.getSerializableExtra("topic"));
            this.spkey = localIntent.getStringExtra("spkey");
            this.fromFeed = localIntent.getBooleanExtra("fromFeed", false);
            this.channel = localIntent.getStringExtra("channel");
            this.openMode = localIntent.getStringExtra("openMode");
            this.isFromTopTopicNotification = localIntent.getBooleanExtra(TopTopicNotification.VIEW_TOP_TOPIC_ACTION, false);
            this.deepPage = localIntent.getIntExtra("page", -1);
            this.deepPerpage = localIntent.getIntExtra("perpage", -1);
            if (this.mTopic == null) {
                this.mTopic = new Topic();
                this.mTopic.setId(this.mTopicId);
                this.mTopic.setForumId(this.mForumId);
                this.mTopic.setPostId(this.mPostId);
            }
            if (paramBundle != null) {
                this.forumStatus = ((ForumStatus) paramBundle.getSerializable("forumStatus"));
                this.mForumId = paramBundle.getString("mForumId");
                this.mReplyCount = paramBundle.getInt("reply_count");
                this.mTopicId = paramBundle.getString("topic_id");
                this.mPostId = paramBundle.getString("post_id");
                this.mTopicTitle = paramBundle.getString("topic_title");
                this.isAnn = paramBundle.getBoolean("isAnn");
                this.isNew = paramBundle.getBoolean("isNew");
                this.goto_first_post = paramBundle.getBoolean("goto_first_post");
                this.getPost = paramBundle.getBoolean("getPost");
                this.spkey = paramBundle.getString("spkey");
                this.mTopic = ((Topic) paramBundle.getSerializable("topic"));
                this.deepPage = paramBundle.getInt("page");
                this.deepPerpage = paramBundle.getInt("perpage");
            }
            return;
        }
    }

    private void setThreadPageView() {
        this.mPager.removeAllViews();
        label45:
        label108:
        label258:
        int i;
        if (this.forumStatus != null) {
            if (this.mTopicId != null) {
                localObject = this.mTopicId;
                this.cacheFile = AppCacheManager.getThreadCacheUrl(this.activity, this.forumStatus.getUrl(), (String) localObject);
                if ((this.mPostId != null) && (!this.mPostId.equals(""))) {
                    this.isNew = true;
                }
                this.mTopicController = new TopicController(this.mTopic, this.activity);
                if (this.deepPerpage == -1) {
                    break label601;
                }
                this.mTopicController.setCountPerPage(this.deepPerpage);
                this.mTopicController.setTotal_post_num(this.mReplyCount + 1);
                this.quoteHelper = new ThreadQuoteHelper(this, this.forumStatus);
                localObject = this.activity;
                getActivity();
                localObject = ((Activity) localObject).getSharedPreferences("notification", 0).edit();
                ((SharedPreferences.Editor) localObject).remove(this.spkey);
                ((SharedPreferences.Editor) localObject).commit();
                this.titleList.clear();
                this.forumList.clear();
                if (!SettingsFragment.isShowThreadPrefix(this.activity)) {
                    break label659;
                }
                if ((this.mTopicTitle == null) || (this.mTopicTitle.equals(""))) {
                    break label618;
                }
                this.titleList.add(this.mTopic.getPrefix() + this.mTopicTitle);
                if ((this.mForumId != null) && (!this.mForumId.equals(""))) {
                    this.forumList = this.forumStatus.getForumHierarch(this.activity, this.mForumId);
                }
                i = 0;
                label299:
                if (i < this.forumList.size()) {
                    break label712;
                }
                if (!getResources().getBoolean(2131558401)) {
                    break label755;
                }
                this.titleList.add(TapatalkApp.rebranding_name);
                label334:
                this.bar.setListNavigationCallbacks(new ThreadNavigationAdapter(this.activity, this.titleList), new ActionBar.OnNavigationListener() {
                    public boolean onNavigationItemSelected(int paramAnonymousInt, long paramAnonymousLong) {
                        if (paramAnonymousInt == 0) {
                        }
                        do {
                            return false;
                            if ((paramAnonymousInt == 0) || (paramAnonymousInt == ThreadOuterFragment.this.titleList.size() - 1)) {
                                break;
                            }
                        } while (!(ThreadOuterFragment.this.forumList.get(paramAnonymousInt - 1) instanceof Forum));
                        Forum localForum = (Forum) ThreadOuterFragment.this.forumList.get(paramAnonymousInt - 1);
                        ThreadOuterFragment.this.finishActiviry(localForum.getId());
                        return false;
                        ThreadOuterFragment.this.finishActiviry(SlidingMenuActivity.CATOGORIES_FORUM_ID);
                        return false;
                    }
                });
                this.mPager.setOffscreenPageLimit(1);
                this.pagerAdapter = new ThreadPagerAdapter(getChildFragmentManager(), null);
                this.mPager.setAdapter(this.pagerAdapter);
                this.mFragment = ThreadFragment.newInstance(true);
                if ((this.deepPage == -1) || (this.deepPerpage == -1)) {
                    break label793;
                }
                this.mThreadAdapter = new ThreadAdapter(this, this.forumStatus.getUrl(), this.mReplyCount, this.isNew, this.isAnn, this.mTopic, this.deepPage, true, this.mFragment);
                this.mFragment.mThreadAdapter = this.mThreadAdapter;
                label478:
                if ((this.mTopicId == null) || (this.mTopic.equals(""))) {
                    break label848;
                }
            }
        }
        label601:
        label618:
        label659:
        label712:
        label755:
        label793:
        label848:
        for (Object localObject = this.mTopicId; ; localObject = this.mTopic.getId()) {
            localObject = TapatalkLogUrlUtil.getLogTopicUrl(this.activity, this.forumStatus.tapatalkForum.getId(), (String) localObject);
            new TapatalkAjaxLogAction(this.activity).logTapatalkLog((String) localObject);
            this.mUIhandler = new Handler() {
                public void handleMessage(Message paramAnonymousMessage) {
                    if (paramAnonymousMessage.what == 38) {
                        paramAnonymousMessage = ThreadOuterFragment.this.pagerAdapter.getFragment(ThreadOuterFragment.this.mPager.getCurrentItem()).threadList;
                        int j = ThreadOuterFragment.this.pagerAdapter.getFragment(ThreadOuterFragment.this.mPager.getCurrentItem()).threadList.getCount();
                        if (ThreadOuterFragment.this.mTopicController.isFootNeeded()) {
                            i = 1;
                            paramAnonymousMessage.setSelection(j - 1 - i);
                            new Handler().postDelayed(new Runnable() {
                                public void run() {
                                    try {
                                        if (ThreadOuterFragment.this.pagerAdapter.getFragment(ThreadOuterFragment.this.mPager.getCurrentItem()).mThreadAdapter.flipper != null) {
                                            ThreadOuterFragment.this.pagerAdapter.getFragment(ThreadOuterFragment.this.mPager.getCurrentItem()).mThreadAdapter.flipper.setDisplayedChild(0);
                                            ThreadOuterFragment.this.pagerAdapter.getFragment(ThreadOuterFragment.this.mPager.getCurrentItem()).mThreadAdapter.shouldAnimId = "";
                                        }
                                        return;
                                    } catch (Exception localException) {
                                        localException.printStackTrace();
                                    }
                                }
                            }, 200L);
                        }
                    }
                    do {
                        return;
                        i = 0;
                        break;
                        if (13 == paramAnonymousMessage.what) {
                            paramAnonymousMessage = (String) ((HashMap) paramAnonymousMessage.obj).get("errormessage");
                            ThreadOuterFragment.this.closeProgress();
                            Toast.makeText(ThreadOuterFragment.this.getActivity(), ThreadOuterFragment.this.getActivity().getString(2131100071), 1).show();
                            return;
                        }
                    } while ((31 != paramAnonymousMessage.what) || (ThreadOuterFragment.this.mProgressDialog == null));
                    int i = ((Integer) paramAnonymousMessage.obj).intValue();
                    paramAnonymousMessage = "";
                    if (i == 0) {
                        paramAnonymousMessage = ThreadOuterFragment.this.getActivity().getString(2131099870);
                    }
                    for (; ; ) {
                        ThreadOuterFragment.this.mProgressDialog.setMessage(paramAnonymousMessage);
                        return;
                        if (i == 1) {
                            paramAnonymousMessage = ThreadOuterFragment.this.getActivity().getString(2131099871);
                        } else if (i == 2) {
                            paramAnonymousMessage = ThreadOuterFragment.this.getActivity().getString(2131099872);
                        } else if (i == 3) {
                            paramAnonymousMessage = ThreadOuterFragment.this.getActivity().getString(2131099873);
                        }
                    }
                }
            };
            return;
            localObject = this.mTopic.getId();
            break;
            if (!(this.activity instanceof ThreadActivity)) {
                break label45;
            }
            this.forumStatus = ((ThreadActivity) this.activity).forumStatus;
            break label45;
            this.mTopicController.setCountPerPage(SettingsFragment.getPostPerPageChoice(this.activity));
            break label108;
            this.titleList.add(this.mTopic.getPrefix() + this.mTopic.getTitle());
            break label258;
            if ((this.mTopicTitle != null) && (!this.mTopicTitle.equals(""))) {
                this.titleList.add(this.mTopicTitle);
                break label258;
            }
            this.titleList.add(this.mTopic.getTitle());
            break label258;
            if ((this.forumList.get(i) instanceof Forum)) {
                this.titleList.add(((Forum) this.forumList.get(i)).getName());
            }
            i += 1;
            break label299;
            if ((this.forumStatus == null) || (this.forumStatus.tapatalkForum == null)) {
                break label334;
            }
            this.titleList.add(this.forumStatus.tapatalkForum.getName());
            break label334;
            this.mThreadAdapter = new ThreadAdapter(this, this.forumStatus.getUrl(), this.mReplyCount, this.isNew, this.isAnn, this.mTopic, 0, true, this.mFragment);
            this.mFragment.mThreadAdapter = this.mThreadAdapter;
            break label478;
        }
    }

    public void Report(ForumStatus paramForumStatus) {
        LinearLayout localLinearLayout = (LinearLayout) LayoutInflater.from(getActivity()).inflate(2130903343, null);
        final EditText localEditText = (EditText) localLinearLayout.getChildAt(0);
        String str1 = getActivity().getString(2131099956);
        String str2 = SettingsFragment.getSingature(getActivity(), paramForumStatus.getSigType(), paramForumStatus);
        paramForumStatus = str1;
        if (str2 != null) {
            paramForumStatus = str1;
            if (str2.length() > 0) {
                paramForumStatus = str1 + "\n\n" + str2;
            }
        }
        localEditText.setText(paramForumStatus);
        new AlertDialog.Builder(getActivity()).setTitle(getActivity().getString(2131099955)).setView(localLinearLayout).setCancelable(false).setPositiveButton(getActivity().getString(2131099972), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                paramAnonymousDialogInterface = new ArrayList();
                if ((ThreadOuterFragment.this.mThreadAdapter.getPost(1) != null) && (ThreadOuterFragment.this.mThreadAdapter.getPost(1).getPostId() != null)) {
                    paramAnonymousDialogInterface.add(ThreadOuterFragment.this.mThreadAdapter.getPost(1).getPostId());
                }
                if (localEditText.getText() != null) {
                    paramAnonymousDialogInterface.add(localEditText.getText().toString().getBytes());
                }
                for (; ; ) {
                    ThreadOuterFragment.this.mThreadAdapter.report_post(paramAnonymousDialogInterface);
                    Toast.makeText(ThreadOuterFragment.this.getActivity(), ThreadOuterFragment.this.getActivity().getString(2131099957), 1).show();
                    return;
                    paramAnonymousDialogInterface.add(null);
                }
            }
        }).setNegativeButton(getActivity().getString(2131099974), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        }).create().show();
    }

    public void addOnePage(int paramInt) {
        this.progress.setVisibility(8);
        this.currentPage = paramInt;
        this.mPager.setVisibility(0);
        if (this.pagerAdapter != null) {
            this.pagerAdapter.setTopicController(this.mTopicController);
            this.pagerAdapter.notifyDataSetChanged();
        }
        showQuickReply();
    }

    public void cacheThreadData() {
    }

    public void callBack(EngineResponse paramEngineResponse) {
        Object localObject;
        HashMap localHashMap;
        if (CallBackChecker.checkCallBack(paramEngineResponse, this.activity, this.forumStatus, this.engine, isOpCancel(), this)) {
            localObject = paramEngineResponse.getMethod();
            this.loading.setVisibility(8);
            this.reply.setVisibility(0);
            if (!paramEngineResponse.isSuccess()) {
                break label1070;
            }
            localHashMap = (HashMap) paramEngineResponse.getResponse();
            if ((localHashMap.get("result").toString() == null) || (!localHashMap.get("result").toString().equals("false"))) {
                break label129;
            }
            paramEngineResponse = new String((byte[]) localHashMap.get("result_text"));
            Toast.makeText(this.activity, paramEngineResponse, 1).show();
        }
        label128:
        label129:
        int j;
        label818:
        do {
            break label128;
            do {
                return;
            } while ((!((String) localObject).equals("reply_topic")) && (!((String) localObject).equals("reply_post")));
            if (!getResources().getBoolean(2131558401)) {
            }
            int i;
            for (; ; ) {
                try {
                    String str = TapatalkJsonEngine.REPLAY_POST + "?" + "device_id=" + Util.getMD5(Util.getMacAddress(this.activity)) + "&fid=" + this.forumStatus.getForumId() + "&pid=" + localHashMap.get("post_id") + "&tid=" + this.mTopic.getId() + "&author=" + URLEncoder.encode(this.forumStatus.tapatalkForum.getUserName(), "utf-8") + "&author_id=" + this.forumStatus.tapatalkForum.getUserId() + "&title=" + URLEncoder.encode(this.mTopic.getTitle(), "utf-8");
                    TapatalkId localTapatalkId = TapatalkIdFactory.getTapatalkId(this.activity);
                    if ((this.mForumId == null) || (this.mForumId.equals(""))) {
                        continue;
                    }
                    paramEngineResponse = this.mForumId;
                    localObject = str;
                    if (paramEngineResponse != null) {
                        localObject = str;
                        if (!paramEngineResponse.equals("")) {
                            localObject = str + "&sub_fid=" + paramEngineResponse;
                        }
                    }
                    paramEngineResponse = localObject + "&au_id=" + localTapatalkId.getAuid();
                    TapatalkJsonEngine.callLogin(this.activity, paramEngineResponse);
                } catch (UnsupportedEncodingException paramEngineResponse) {
                    paramEngineResponse.printStackTrace();
                    continue;
                    if (((HashMap) this.dataCache.get("data") == null) || (!((HashMap) this.dataCache.get("data")).containsKey(Integer.valueOf(j - 1)))) {
                        continue;
                    }
                    ((HashMap) this.dataCache.get("data")).remove(Integer.valueOf(j - 1));
                    if ((this.pagerAdapter.getFragment(this.mPager.getCurrentItem() + 1) == null) || (this.pagerAdapter.getFragment(this.mPager.getCurrentItem() + 1).mThreadAdapter == null)) {
                        continue;
                    }
                    this.pagerAdapter.getFragment(this.mPager.getCurrentItem() + 1).mThreadAdapter.refresh(this.mTopicController.getPageNum() - 1);
                    this.pagerAdapter.notifyDataSetChanged();
                    return;
                }
                i = this.mTopicController.getPageNum();
                this.mTopicController.setTotal_post_num(this.mTopicController.getTotal_post_num() + 1);
                j = this.mTopicController.getPageNum();
                if ((localHashMap == null) || (!localHashMap.get("result").toString().equals("true"))) {
                    break;
                }
                if ((localHashMap == null) || (!localHashMap.containsKey("post_content")) || (this.pagerAdapter == null)) {
                    break label818;
                }
                localHashMap.put("floor_number", Integer.valueOf(this.mTopicController.getTotal_post_num()));
                if ((this.pagerAdapter.getFragment(this.mPager.getCurrentItem()) == null) || (this.pagerAdapter.getFragment(this.mPager.getCurrentItem()).mThreadAdapter == null)) {
                    break;
                }
                Toast.makeText(this.activity, this.activity.getString(2131100051), 0).show();
                startCountdown(false);
                if (this.currentPage + 1 != j) {
                    continue;
                }
                this.mTopicController.setTotal_post_num(this.mTopicController.getTotal_post_num() - 1);
                this.pagerAdapter.getFragment(this.mPager.getCurrentItem()).mThreadAdapter.addItem(localHashMap);
                return;
                paramEngineResponse = this.mTopic.getForumId();
            }
            try {
                Toast.makeText(this.activity, this.activity.getString(2131100051), 0).show();
                startCountdown(false);
                if (i != j) {
                    break;
                }
                if (this.currentPage + 1 == j) {
                    this.pagerAdapter.getFragment(this.mPager.getCurrentItem()).mThreadAdapter.refresh(this.mTopicController.getPageNum() - 1);
                    this.pagerAdapter.getFragment(this.mPager.getCurrentItem()).mThreadAdapter.setReplyPosition(this.mFragment.threadList.getFirstVisiblePosition());
                    return;
                }
            } catch (Exception paramEngineResponse) {
                paramEngineResponse.printStackTrace();
                return;
            }
            if (((HashMap) this.dataCache.get("data") != null) && (((HashMap) this.dataCache.get("data")).containsKey(Integer.valueOf(j - 1)))) {
                ((HashMap) this.dataCache.get("data")).remove(Integer.valueOf(j - 1));
            }
        }
        while ((this.pagerAdapter.getFragment(this.mPager.getCurrentItem() + 1) == null) || (this.pagerAdapter.getFragment(this.mPager.getCurrentItem() + 1).mThreadAdapter == null));
        this.pagerAdapter.getFragment(this.mPager.getCurrentItem() + 1).mThreadAdapter.refresh(this.mTopicController.getPageNum() - 1);
        return;
        addOnePage(j - 1);
        return;
        label1070:
        paramEngineResponse = paramEngineResponse.getErrorMessage();
        Toast.makeText(this.activity, paramEngineResponse, 1).show();
    }

    public void closeProgress() {
        try {
            getActivity().dismissDialog(0);
            return;
        } catch (Exception localException) {
        }
    }

    public void finishActiviry(String paramString) {
        if ((getActivity() instanceof ThreadActivity)) {
            if (this.fromFeed) {
                localIntent = new Intent();
                localIntent.setClass(getActivity(), SlidingMenuActivity.class);
                localIntent.putExtra("forumStatus", this.forumStatus);
                localIntent.putExtra("shortcut", true);
                if ((this.forumStatus != null) && (this.forumStatus.tapatalkForum != null)) {
                    localIntent.putExtra("forum", this.forumStatus.tapatalkForum);
                }
                localIntent.putExtra("fromFeedBack", this.fromFeed);
                localIntent.putExtra("shortcutID", paramString);
                getActivity().startActivity(localIntent);
                getActivity().finish();
            }
        }
        while (!(getActivity() instanceof SlidingMenuActivity)) {
            return;
            Intent localIntent = new Intent(BroadcastControl.FINISH_ACTIVITY);
            getActivity().sendBroadcast(localIntent);
            ((ThreadActivity) getActivity()).finishActivity(this.mTopicId, this.mTopic.isSubscribe(), this.forumStatus.cookies);
        }
        ((SlidingMenuActivity) getActivity()).breadcrumBackStack(paramString);
    }

    public void finishActiviry(boolean paramBoolean) {
        Intent localIntent = new Intent();
        localIntent.putExtra("needLogin", paramBoolean);
        this.activity.setResult(-1, localIntent);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                ThreadOuterFragment.this.activity.finish();
            }
        }, 300L);
    }

    public BaseAdapter getAdapter() {
        return null;
    }

    public int getCountdownNumber() {
        if (this.countdownTool != null) {
            return this.countdownTool.getNumber();
        }
        return 0;
    }

    public ThreadFragment getCurrentFragment() {
        if (this.pagerAdapter != null) {
            int i = this.mPager.getCurrentItem();
            return this.pagerAdapter.getFragment(i);
        }
        return null;
    }

    public int getCurrentPageNum() {
        return this.currentPage;
    }

    public int getDeepPage() {
        return this.deepPage;
    }

    public int getDeepPerpage() {
        return this.deepPerpage;
    }

    public Activity getDefaultActivity() {
        return getActivity();
    }

    public ForumActivityStatus getForumActivityStatus() {
        return null;
    }

    public ForumStatus getForumStatus() {
        return this.forumStatus;
    }

    public ForumStatus getForumStatus(TapatalkForum paramTapatalkForum) {
        return null;
    }

    public int getJumpPage() {
        return this.jumpPage;
    }

    public int getJumpToPosition() {
        return this.jumpToPosition;
    }

    public boolean getSaxCall() {
        return false;
    }

    public int getScrollState() {
        if ((getCurrentFragment() != null) && (getCurrentFragment().mThreadAdapter != null)) {
            return getCurrentFragment().mThreadAdapter.currentScrollState;
        }
        return 0;
    }

    public boolean getTryTwice() {
        return this.tryTwice;
    }

    public void initFont() {
        Object localObject = AnimationUtils.loadAnimation(this.activity, 2130968608);
        ((Animation) localObject).setRepeatCount(-1);
        this.firstReplyMessage.startAnimation((Animation) localObject);
        try {
            localObject = Typeface.createFromAsset(this.activity.getAssets(), "font/GothamRounded-Bold.ttf");
            this.firstReplyMessage.setTypeface((Typeface) localObject);
            return;
        } catch (Exception localException) {
        }
    }

    public boolean isOpCancel() {
        return false;
    }

    public void onActivityCreated(Bundle paramBundle) {
        this.bar = getActivity().getActionBar();
        super.onActivityCreated(paramBundle);
        this.activity.invalidateOptionsMenu();
        this.prefs = Prefs.get(this.activity);
        if ((this.mTopic != null) && (this.mTopic.isDeleted())) {
            this.deleteStatus.setVisibility(0);
        }
        initFont();
        getData(paramBundle);
        startCountdown(true);
        setThreadPageView();
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        int i;
        int j;
        if ((paramInt1 == 38) && (paramInt2 == -1)) {
            this.quickreply_text.setText("");
            i = this.mTopicController.getPageNum();
            this.mTopicController.setTotal_post_num(this.mTopicController.getTotal_post_num() + 1);
            j = this.mTopicController.getPageNum();
            if ((paramIntent == null) || (!paramIntent.hasExtra("post")) || (this.pagerAdapter == null)) {
                break label558;
            }
            HashMap localHashMap = (HashMap) paramIntent.getSerializableExtra("post");
            localHashMap.put("floor_number", Integer.valueOf(this.mTopicController.getTotal_post_num()));
            if ((this.pagerAdapter.getFragment(this.mPager.getCurrentItem()) != null) && (this.pagerAdapter.getFragment(this.mPager.getCurrentItem()).mThreadAdapter != null)) {
                startCountdown(false);
                Toast.makeText(this.activity, this.activity.getString(2131100051), 0).show();
                if (this.currentPage + 1 != j) {
                    break label410;
                }
                this.mTopicController.setTotal_post_num(this.mTopicController.getTotal_post_num() - 1);
                this.pagerAdapter.getFragment(this.mPager.getCurrentItem()).mThreadAdapter.addItem(localHashMap);
            }
        }
        for (; ; ) {
            if ((paramInt1 == 40) && (paramInt2 == -1) && (this.pagerAdapter.getFragment(this.mPager.getCurrentItem()) != null) && (this.pagerAdapter.getFragment(this.mPager.getCurrentItem()).mThreadAdapter != null)) {
                this.pagerAdapter.getFragment(this.mPager.getCurrentItem()).mThreadAdapter.refresh();
            }
            if ((paramInt1 == 901) && (paramInt2 == 902) && (this.pagerAdapter.getFragment(this.mPager.getCurrentItem()) != null) && (this.pagerAdapter.getFragment(this.mPager.getCurrentItem()).mThreadAdapter != null)) {
                this.pagerAdapter.getFragment(this.mPager.getCurrentItem()).mThreadAdapter.refresh();
            }
            if ((paramInt1 == 2001) && (paramIntent != null) && (paramIntent.getSerializableExtra("forumStatus") != null)) {
                this.forumStatus = ((ForumStatus) paramIntent.getSerializableExtra("forumStatus"));
                this.dataCache.clear();
                setThreadPageView();
            }
            super.onActivityResult(paramInt1, paramInt2, paramIntent);
            return;
            label410:
            if (((HashMap) this.dataCache.get("data") != null) && (((HashMap) this.dataCache.get("data")).containsKey(Integer.valueOf(j - 1)))) {
                ((HashMap) this.dataCache.get("data")).remove(Integer.valueOf(j - 1));
            }
            if ((this.pagerAdapter.getFragment(this.mPager.getCurrentItem() + 1) != null) && (this.pagerAdapter.getFragment(this.mPager.getCurrentItem() + 1).mThreadAdapter != null)) {
                this.pagerAdapter.getFragment(this.mPager.getCurrentItem() + 1).mThreadAdapter.refresh(this.mTopicController.getPageNum() - 1);
            }
            this.pagerAdapter.notifyDataSetChanged();
            continue;
            try {
                label558:
                Toast.makeText(this.activity, this.activity.getString(2131100051), 0).show();
                startCountdown(false);
                if (i != j) {
                    break label815;
                }
                if (this.currentPage + 1 != j) {
                    break label674;
                }
                this.pagerAdapter.getFragment(this.mPager.getCurrentItem()).mThreadAdapter.refresh(this.mTopicController.getPageNum() - 1);
                this.pagerAdapter.getFragment(this.mPager.getCurrentItem()).mThreadAdapter.setReplyPosition(this.mFragment.threadList.getFirstVisiblePosition());
            } catch (Exception localException) {
                localException.printStackTrace();
            }
            continue;
            label674:
            if (((HashMap) this.dataCache.get("data") != null) && (((HashMap) this.dataCache.get("data")).containsKey(Integer.valueOf(j - 1)))) {
                ((HashMap) this.dataCache.get("data")).remove(Integer.valueOf(j - 1));
            }
            if ((this.pagerAdapter.getFragment(this.mPager.getCurrentItem() + 1) != null) && (this.pagerAdapter.getFragment(this.mPager.getCurrentItem() + 1).mThreadAdapter != null)) {
                this.pagerAdapter.getFragment(this.mPager.getCurrentItem() + 1).mThreadAdapter.refresh(this.mTopicController.getPageNum() - 1);
                continue;
                label815:
                addOnePage(j - 1);
            }
        }
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.activity = getActivity();
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        this.view = paramLayoutInflater.inflate(2130903391, paramViewGroup, false);
        this.deleteStatus = ((TextView) this.view.findViewById(2131231649));
        this.mPager = ((ViewPager) this.view.findViewById(2131230971));
        this.quickbar = ((RelativeLayout) this.view.findViewById(2131230970));
        this.quick_lay = ((LinearLayout) this.quickbar.findViewById(2131231655));
        this.show_all = ((ImageView) this.quickbar.findViewById(2131231656));
        this.reply = ((ImageView) this.quickbar.findViewById(2131231661));
        this.countdown = ((TextView) this.quickbar.findViewById(2131231662));
        this.loading = ((ProgressBar) this.quickbar.findViewById(2131230844));
        this.quickreply_text = ((EditText) this.quickbar.findViewById(2131231657));
        this.guestreply = ((TextView) this.quickbar.findViewById(2131231659));
        this.guestreplyline = ((ImageView) this.quickbar.findViewById(2131231660));
        this.firstReplyMessage = ((TextView) this.view.findViewById(2131231654));
        this.firstReplyMessageLayout = ((RelativeLayout) this.view.findViewById(2131231653));
        this.progress = ((LinearLayout) this.view.findViewById(2131230891));
        this.addtoFavoriateView = ((LinearLayout) this.view.findViewById(2131231652));
        this.bottomView = ((LinearLayout) this.view.findViewById(2131231650));
        this.addView = ((RelativeLayout) this.view.findViewById(2131231651));
        this.guest_reply_layout = ((RelativeLayout) this.quickbar.findViewById(2131231658));
        this.guestreplyline.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("guest_reply_line", this.activity));
        this.reply.setImageResource(ThemeUtil.getDrawableIdByPicName("menu_send", this.activity));
        this.quick_lay.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("thread_bottom_background", this.activity));
        this.firstReplyMessageLayout.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent) {
                if (ThreadOuterFragment.this.firstReplyMessageLayout.getVisibility() == 0) {
                    ThreadOuterFragment.this.firstReplyMessageLayout.setVisibility(8);
                }
                return true;
            }
        });
        return this.view;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.post_countdown != 0) {
            SharedPreferences.Editor localEditor = this.prefs.edit();
            localEditor.putLong("post_countdown_quite_time|" + this.forumStatus.getForumId(), System.currentTimeMillis());
            localEditor.putInt("post_countdown_number|" + this.forumStatus.getForumId(), getCountdownNumber());
            localEditor.commit();
        }
        if (this.quoteHelper != null) {
            this.quoteHelper.actionFinish();
        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
            case 0:
            case 38:
            case 42:
                for (; ; ) {
                    return super.onOptionsItemSelected(paramMenuItem);
                    if (getCurrentFragment() != null) {
                        getCurrentFragment().mThreadAdapter.refresh();
                    }
                    return true;
                    Util.startReplyActivity(this, this.forumStatus, this.mTopic, null, null, 0, this.mThreadAdapter.isCanUpload(), getCountdownNumber());
                    return true;
                    getActivity().finish();
                }
            case 15:
                this.mTopic.setSubscribe(true);
                this.mTopic.subscribeTopic(this.mThreadAdapter, getActivity());
                Toast.makeText(getActivity(), getString(2131099902), 0).show();
                getActivity().invalidateOptionsMenu();
                return true;
            case 43:
                this.mTopic.setSubscribe(false);
                this.mTopic.unSubscribeTopic(this.mThreadAdapter, getActivity());
                Toast.makeText(getActivity(), getString(2131099904), 0).show();
                getActivity().invalidateOptionsMenu();
                return true;
        }
        try {
            if (this.mTopicId != null) {
            }
            for (paramMenuItem = this.mTopicId; ; paramMenuItem = this.mTopic.getId()) {
                paramMenuItem = new Intent("android.intent.action.VIEW", Uri.parse(ForumUrlUtil.getTopicUrl(this.forumStatus, paramMenuItem, this.mTopic.getTitle(), this.mTopic.getForumId(), this.isAnn)));
                getActivity().startActivity(paramMenuItem);
                break;
            }
            ModerationDialogAdapter.getModerateDialog(getActivity(), this.forumStatus, this.mThreadAdapter, this.mTopic).show();
            return true;
        } catch (Exception paramMenuItem) {
        }
        this.mTopic.actionShareTopic(this.forumStatus, getActivity());
        return true;
        if (this.mTopicId != null) {
        }
        for (paramMenuItem = this.mTopicId; ; paramMenuItem = this.mTopic.getId()) {
            paramMenuItem = ForumUrlUtil.getTopicUrl(this.forumStatus, paramMenuItem, this.mTopic.getTitle(), this.mTopic.getForumId(), this.isAnn);
            ((ClipboardManager) getActivity().getSystemService("clipboard")).setText(paramMenuItem);
            Toast.makeText(getActivity(), getActivity().getString(2131100175), 1).show();
            return true;
        }
        removeDetail();
        return true;
        paramMenuItem = new Intent(getActivity(), AdvanceSearchActivity.class);
        Bundle localBundle = new Bundle();
        localBundle.putString("threadid", this.mTopic.getId());
        localBundle.putSerializable("forumStatus", this.forumStatus);
        paramMenuItem.putExtras(localBundle);
        getActivity().startActivity(paramMenuItem);
        getActivity().invalidateOptionsMenu();
        return true;
        Report(this.forumStatus);
        return true;
        return true;
    }

    public void onPause() {
        super.onPause();
        CustomTracker.comScorePause(getActivity());
        if ((getCurrentFragment() != null) && (getCurrentFragment().mThreadAdapter != null)) {
            getCurrentFragment().mThreadAdapter.cacheLastPosition(this.cacheFile);
        }
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
        if (this.forceShowThread) {
            paramMenu.removeGroup(0);
            paramMenu.add(0, 42, 0, getString(2131100410)).setShowAsAction(2);
        }
        while (this.mThreadAdapter == null) {
            return;
        }
        paramMenu.removeGroup(0);
        Object localObject;
        if ((this.forumStatus != null) && (this.forumStatus.isCanSearch()) && (this.forumStatus.isAdvancedSearch())) {
            localObject = new DisplayMetrics();
            this.activity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics) localObject);
            double d = Math.sqrt(Math.pow(((DisplayMetrics) localObject).widthPixels / ((DisplayMetrics) localObject).xdpi, 2.0D) + Math.pow(((DisplayMetrics) localObject).heightPixels / ((DisplayMetrics) localObject).ydpi, 2.0D));
            if ((!getResources().getBoolean(2131558401)) && (d > 5.0D)) {
                this.activity.getMenuInflater().inflate(2131623942, paramMenu);
                this.searchItem = paramMenu.findItem(2131231753);
                this.mSearchView = ((SearchView) this.searchItem.getActionView());
                this.mSearchView.requestFocus();
                this.mSearchView.setMaxWidth(getResources().getDimensionPixelOffset(2131427370));
                setupSearchView(this.searchItem);
            }
        } else {
            label250:
            localObject = paramMenu.add(0, 0, 0, getString(2131099796));
            ((MenuItem) localObject).setIcon(ThemeUtil.getMenuIconByPicName("menu_refresh_new", getActivity()));
            if ((this.mFragment != null) && (this.mFragment.getCurrentPage() == 0) && (this.forumStatus.isReportPost())) {
                paramMenu.add(0, 19, 0, getString(2131099843));
            }
            ((MenuItem) localObject).setIcon(ThemeUtil.getMenuIconByPicName("menu_refresh_new", getActivity()));
            if (this.forumStatus.isLogin()) {
                if (((!this.isAnn) || (!this.forumStatus.isVB())) && (this.mThreadAdapter.isCanReply())) {
                    paramMenu.add(0, 38, 0, getString(2131099815));
                }
                if ((!this.isAnn) || (!this.forumStatus.isVB())) {
                    if (!this.mTopic.isSubscribe()) {
                        break label776;
                    }
                    this.unSubItem = paramMenu.add(0, 43, 0, getString(2131099848));
                    this.unSubItem.setShowAsAction(2);
                    this.unSubItem.setIcon(ThemeUtil.getMenuIconByPicName("menu_subscribe_selected", getActivity()));
                }
            }
        }
        for (; ; ) {
            if ((this.mTopic != null) && ((this.mTopic.isCanApprove()) || (this.mTopic.isCanClose()) || (this.mTopic.isCanDelete()) || (this.mTopic.isCanStick()) || (this.mTopic.isCanMove()))) {
                paramMenu.add(0, 45, 0, getString(2131100039));
            }
            if ((!this.forumStatus.isVB()) && (!this.forumStatus.isIP()) && (!this.forumStatus.isSMF()) && (!this.forumStatus.isPB()) && (!this.forumStatus.isXF()) && (!this.forumStatus.isMB()) && (!this.forumStatus.isBB()) && (!this.forumStatus.isKN1()) && (!this.forumStatus.isKN2()) && ((this.forumStatus.tapatalkForum.getType() == null) || (!this.forumStatus.tapatalkForum.getType().equals("proboards")))) {
                break;
            }
            paramMenu.add(0, 46, 0, getString(2131100054));
            paramMenu.add(0, 44, 0, getString(2131099968));
            paramMenu.add(0, 22, 0, getString(2131100109));
            return;
            paramMenu.add(0, 1081, 1, getString(2131099795)).setIcon(ThemeUtil.getMenuIconByPicName("ic_menu_search", getActivity())).setShowAsAction(5);
            break label250;
            label776:
            this.subItem = paramMenu.add(0, 15, 0, getString(2131099807));
            this.subItem.setShowAsAction(2);
            this.subItem.setIcon(ThemeUtil.getMenuIconByPicName("menu_subscribe", getActivity()));
        }
    }

    public void onResume() {
        super.onResume();
        setActionBar(getActivity());
        CustomTracker.comScoreResume(getActivity());
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putSerializable("forumStatus", this.forumStatus);
        paramBundle.putString("mForumId", this.mForumId);
        paramBundle.putInt("reply_count", this.mReplyCount);
        paramBundle.putString("topic_id", this.mTopicId);
        paramBundle.putString("post_id", this.mPostId);
        paramBundle.putString("topic_title", this.mTopicTitle);
        paramBundle.putBoolean("isAnn", this.isAnn);
        paramBundle.putBoolean("isNew", this.isNew);
        paramBundle.putBoolean("goto_first_post", this.goto_first_post);
        paramBundle.putBoolean("getPost", this.getPost);
        paramBundle.putString("spkey", this.spkey);
        paramBundle.putSerializable("topic", this.mTopic);
        paramBundle.putInt("page", this.deepPage);
        paramBundle.putInt("perpage", this.deepPerpage);
    }

    public void onStart() {
        super.onStart();
        CustomTracker.start(getActivity());
    }

    public void onStop() {
        super.onStop();
        CustomTracker.stop(getActivity());
    }

    public void quickReply() {
        if (this.engine == null) {
            this.engine = new TapatalkEngine(this, this.forumStatus, this.activity);
        }
        str = SettingsFragment.getSingature(this.activity, this.forumStatus.getSigType(), this.forumStatus);
        localArrayList = new ArrayList();
        Object localObject2 = this.quickreply_text.getText().toString();
        localObject1 = localObject2;
        if (this.forumStatus.isSupportEmoji()) {
        }
        for (localObject1 = BBcodeUtil.parseAllForumPublicSmileToEmojiBBCode((String) localObject2); ; localObject1 = localObject2) {
            try {
                if ((!this.forumStatus.isSupportSignature()) || (str == null) || (str.length() <= 0)) {
                    break label352;
                }
                localObject2 = (localObject1 + "\n\n" + str + "\n\n").getBytes("UTF-8");
                localObject1 = localObject2;
            } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
                for (; ; ) {
                    label352:
                    if ((this.forumStatus.isSupportSignature()) && (str != null) && (str.length() > 0)) {
                        localObject1 = (localObject1 + "\n\n" + str + "\n\n").getBytes();
                    } else {
                        localObject1 = ((String) localObject1).getBytes();
                        continue;
                        localArrayList.add(Boolean.valueOf(false));
                        continue;
                        localArrayList.add(this.mTopic.getId());
                        localArrayList.add(new byte[0]);
                        localArrayList.add(new byte[0]);
                        localArrayList.add(localObject1);
                    }
                }
            }
            if (this.forumStatus.getApiLevel() < 3) {
                break label447;
            }
            localArrayList.add(this.mTopic.getForumId());
            localArrayList.add(this.mTopic.getId());
            localArrayList.add(new byte[0]);
            localArrayList.add(localObject1);
            if (this.forumStatus.isNoRerefreshPost()) {
                localArrayList.add(new String[0]);
                localArrayList.add("");
            }
            if (this.forumStatus.isNoRerefreshPost()) {
                if (!this.forumStatus.isSupprotBBcode()) {
                    break label435;
                }
                localArrayList.add(Boolean.valueOf(true));
            }
            setTryTwice(false);
            this.engine.call(this.forumStatus.getReplyPostFunction(), localArrayList);
            this.quickreply_text.setText("");
            this.loading.setVisibility(0);
            this.reply.setVisibility(8);
            ((InputMethodManager) this.activity.getSystemService("input_method")).hideSoftInputFromWindow(this.quickreply_text.getWindowToken(), 0);
            return;
            localObject2 = ((String) localObject1).getBytes("UTF-8");
        }
    }

    public void refresh() {
        if ((getCurrentFragment() != null) && (getCurrentFragment().mThreadAdapter != null)) {
            getCurrentFragment().mThreadAdapter.refresh();
        }
    }

    public void removeDetail() {
        if ((getActivity() instanceof SlidingMenuActivity)) {
            ((SlidingMenuActivity) getActivity()).removeDetail(this);
        }
        if (this.isFromTopTopicNotification) {
            startActivity(new Intent(getActivity(), AccountEntryActivity.class));
            this.activity.finish();
        }
    }

    public void saveFavoriate() {
        Util.saveFavoriate(this.activity, this.forumStatus.tapatalkForum, this.channel, true);
    }

    public void setActionBar(Activity paramActivity) {
        if (this.bar == null) {
            this.bar = paramActivity.getActionBar();
        }
        this.bar.setTitle("");
        this.bar.setDisplayShowTitleEnabled(false);
        this.bar.setNavigationMode(1);
    }

    public void setCurrentPage(int paramInt) {
        this.currentPage = paramInt;
        this.pagerAdapter.setTopicController(this.mTopicController);
        this.pagerAdapter.getItem(paramInt);
        try {
            this.mPager.setCurrentItem(paramInt);
            this.pagerAdapter.notifyDataSetChanged();
            return;
        } catch (Exception localException) {
            for (; ; ) {
            }
        }
    }

    public void setCurrentPageNum(int paramInt) {
        this.currentPage = paramInt;
    }

    public void setDeepPage(int paramInt) {
        this.deepPage = paramInt;
    }

    public void setDeepPerpage(int paramInt) {
        this.deepPerpage = paramInt;
    }

    public void setJumpPage(int paramInt) {
        this.jumpPage = paramInt;
    }

    public void setJumpToPosition(int paramInt) {
        this.jumpToPosition = paramInt;
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void setPagerAdapterAndPosition(int paramInt1, ThreadFragment paramThreadFragment, int paramInt2, int paramInt3, final boolean paramBoolean) {
        this.progress.setVisibility(8);
        this.mPager.setVisibility(0);
        this.currentPage = paramInt1;
        this.jumpPage = paramInt2;
        this.jumpToPosition = paramInt3;
        paramThreadFragment.currentPage = this.currentPage;
        this.mPager.setOffscreenPageLimit(1);
        if ((this.pagerAdapter != null) && (!this.pagerAdapter.mPageReferenceMap.containsKey(Integer.valueOf(this.currentPage)))) {
            this.pagerAdapter.setTopicController(this.mTopicController);
            this.pagerAdapter.mPageReferenceMap.put(Integer.valueOf(this.currentPage), paramThreadFragment);
        }
        this.pagerAdapter.notifyDataSetChanged();
        try {
            this.mPager.setCurrentItem(this.currentPage);
            this.mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                public void onPageScrollStateChanged(int paramAnonymousInt) {
                }

                public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {
                }

                public void onPageSelected(int paramAnonymousInt) {
                    ThreadOuterFragment.this.currentPage = paramAnonymousInt;
                    if ((paramBoolean) && (!ThreadOuterFragment.this.isJumped)) {
                        ThreadOuterFragment.this.isJumped = true;
                    }
                    if ((ThreadOuterFragment.this.pagerAdapter != null) && (ThreadOuterFragment.this.pagerAdapter.mPageReferenceMap.get(Integer.valueOf(paramAnonymousInt)) != null) && (((ThreadFragment) ThreadOuterFragment.this.pagerAdapter.mPageReferenceMap.get(Integer.valueOf(paramAnonymousInt))).mThreadAdapter != null)) {
                        ((ThreadFragment) ThreadOuterFragment.this.pagerAdapter.mPageReferenceMap.get(Integer.valueOf(paramAnonymousInt))).getPageData();
                    }
                    if ((ThreadOuterFragment.this.pagerAdapter != null) && (ThreadOuterFragment.this.pagerAdapter.mPageReferenceMap.get(Integer.valueOf(paramAnonymousInt + 1)) != null) && (((ThreadFragment) ThreadOuterFragment.this.pagerAdapter.mPageReferenceMap.get(Integer.valueOf(paramAnonymousInt + 1))).mThreadAdapter != null)) {
                        ((ThreadFragment) ThreadOuterFragment.this.pagerAdapter.mPageReferenceMap.get(Integer.valueOf(paramAnonymousInt + 1))).mThreadAdapter.checkImages();
                    }
                    if ((ThreadOuterFragment.this.pagerAdapter != null) && (ThreadOuterFragment.this.pagerAdapter.mPageReferenceMap.get(Integer.valueOf(paramAnonymousInt - 1)) != null) && (((ThreadFragment) ThreadOuterFragment.this.pagerAdapter.mPageReferenceMap.get(Integer.valueOf(paramAnonymousInt - 1))).mThreadAdapter != null)) {
                        ((ThreadFragment) ThreadOuterFragment.this.pagerAdapter.mPageReferenceMap.get(Integer.valueOf(paramAnonymousInt - 1))).mThreadAdapter.checkImages();
                    }
                }
            });
            this.pagerAdapter.notifyDataSetChanged();
            showQuickReply();
            this.activity.invalidateOptionsMenu();
            return;
        } catch (Exception paramThreadFragment) {
            for (; ; ) {
            }
        }
    }

    public void setSaxCall(boolean paramBoolean) {
    }

    public void setTryTwice(boolean paramBoolean) {
        this.tryTwice = paramBoolean;
    }

    public void setupSearchView(MenuItem paramMenuItem) {
        paramMenuItem.setShowAsActionFlags(1);
        if (this.mFragment != null) {
            this.mSearchView.setOnQueryTextListener(this.mFragment);
            this.mSearchView.setOnCloseListener(this.mFragment);
        }
    }

    public void showAddOrReplayView(boolean paramBoolean) {
        if (paramBoolean) {
            this.addtoFavoriateView.setVisibility(0);
            if (SettingsFragment.isLightTheme(this.activity)) {
                this.addView.setBackgroundResource(2131165213);
            }
            this.addView.setVisibility(0);
            this.quickbar.setVisibility(8);
            return;
        }
        this.addtoFavoriateView.setVisibility(8);
        this.quickbar.setVisibility(0);
        this.addView.setVisibility(8);
        this.quickbar.bringToFront();
        showReplayEditText(false);
    }

    public void showDialog(int paramInt) {
    }

    public void showProgress() {
        showDialog(0);
    }

    public void showProgress(String paramString) {
    }

    public void showQuickReply() {
        if (this.forumStatus.isLogin()) {
            if ((this.prefs.getBoolean("showQuick_replay", true)) && (((this.mThreadAdapter != null) && (this.mThreadAdapter.canReply)) || (this.canReply))) {
                showReplayEditText(true);
                this.reply.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View paramAnonymousView) {
                        if (ThreadOuterFragment.this.quickreply_text.getText().toString().length() > 0) {
                            ThreadOuterFragment.this.quickReply();
                        }
                    }
                });
                this.show_all.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View paramAnonymousView) {
                        if ((ThreadOuterFragment.this.quickreply_text.getText() != null) && (!ThreadOuterFragment.this.quickreply_text.getText().toString().equals(""))) {
                            if ((ThreadOuterFragment.this.forumStatus != null) && (ThreadOuterFragment.this.pagerAdapter != null) && (ThreadOuterFragment.this.pagerAdapter.getFragment(ThreadOuterFragment.this.mPager.getCurrentItem()) != null)) {
                                Util.startReplyActivity(ThreadOuterFragment.this, ThreadOuterFragment.this.forumStatus, ThreadOuterFragment.this.mTopic, null, null, 0, ThreadOuterFragment.this.pagerAdapter.getFragment(ThreadOuterFragment.this.mPager.getCurrentItem()).mThreadAdapter.isCanUpload(), ThreadOuterFragment.this.quickreply_text.getText().toString(), ThreadOuterFragment.this.getCountdownNumber());
                            }
                        }
                        while ((ThreadOuterFragment.this.forumStatus == null) || (ThreadOuterFragment.this.pagerAdapter == null) || (ThreadOuterFragment.this.pagerAdapter.getFragment(ThreadOuterFragment.this.mPager.getCurrentItem()) == null)) {
                            return;
                        }
                        Util.startReplyActivity(ThreadOuterFragment.this, ThreadOuterFragment.this.forumStatus, ThreadOuterFragment.this.mTopic, null, null, 0, ThreadOuterFragment.this.pagerAdapter.getFragment(ThreadOuterFragment.this.mPager.getCurrentItem()).mThreadAdapter.isCanUpload(), ThreadOuterFragment.this.getCountdownNumber());
                    }
                });
                return;
            }
            this.bottomView.setVisibility(8);
            return;
        }
        if (!Util.isFavoriate(this.activity, this.forumStatus.tapatalkForum.getId().intValue())) {
            showAddOrReplayView(true);
        }
        for (; ; ) {
            this.guestreply.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    if (!ThreadOuterFragment.this.forumStatus.isLogin()) {
                        paramAnonymousView = new Intent(ThreadOuterFragment.this.activity, ForumLoginActivity.class);
                        paramAnonymousView.putExtra("forumStatus", ThreadOuterFragment.this.forumStatus);
                        ThreadOuterFragment.this.startActivityForResult(paramAnonymousView, 2001);
                    }
                }
            });
            this.addtoFavoriateView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    Util.saveFavoriate(ThreadOuterFragment.this.activity, ThreadOuterFragment.this.forumStatus.tapatalkForum, ThreadOuterFragment.this.channel, true);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            ThreadOuterFragment.this.showQuickReply();
                        }
                    }, 300L);
                }
            });
            return;
            showAddOrReplayView(false);
        }
    }

    public void showReplayEditText(boolean paramBoolean) {
        this.bottomView.setVisibility(0);
        if (paramBoolean) {
            this.quickreply_text.setVisibility(0);
            this.guest_reply_layout.setVisibility(8);
            this.show_all.setVisibility(0);
            if (this.isShowReply) {
                this.reply.setVisibility(0);
            }
        }
        for (; ; ) {
            this.quickbar.setVisibility(0);
            this.quickbar.bringToFront();
            return;
            this.reply.setVisibility(8);
            continue;
            this.quickreply_text.setVisibility(8);
            this.guest_reply_layout.setVisibility(0);
            this.show_all.setVisibility(8);
            this.reply.setVisibility(8);
        }
    }

    public void startCountdown(boolean paramBoolean) {
        if (this.forumStatus != null) {
            this.post_countdown = this.forumStatus.getPost_countdown();
        }
        if (this.post_countdown != 0) {
            if (this.countdownTool == null) {
                this.countdownTool = new CountdownTool(this.activity, this.reply, this.countdown);
            }
            if (!paramBoolean) {
                break label184;
            }
            long l1 = this.prefs.getLong("post_countdown_quite_time|" + this.forumStatus.getForumId(), System.currentTimeMillis());
            long l2 = System.currentTimeMillis();
            int i = this.prefs.getInt("post_countdown_number|" + this.forumStatus.getForumId(), 0);
            this.prefs.edit();
            int j = (int) ((l2 - l1) / 1000L);
            if (j < i) {
                this.isShowReply = false;
                this.countdownTool.setNumber(i - j);
                this.countdownTool.initView();
            }
        }
        return;
        label184:
        this.countdownTool.setNumber(this.post_countdown);
        this.countdownTool.initView();
    }

    public void tryFailed(String paramString) {
    }

    public void updateDialog(int paramInt) {
        Message localMessage = this.mUIhandler.obtainMessage();
        localMessage.what = 31;
        localMessage.obj = new Integer(paramInt);
        this.mUIhandler.sendMessage(localMessage);
    }

    public void updateSubclassDialog(int paramInt) {
    }

    public void updateUI(int paramInt, Object paramObject) {
    }

    public void updateUI(String paramString) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/ThreadOuterFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */