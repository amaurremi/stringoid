package com.quoord.tapatalkpro.adapter.directory;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mobeta.android.dslv.DragSortController;
import com.mobeta.android.dslv.DragSortListView;
import com.mobeta.android.dslv.DragSortListView.DropListener;
import com.quoord.newonboarding.ObChooseActivity;
import com.quoord.newonboarding.ObEntryActivity;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.action.SynchaAccountAction;
import com.quoord.tapatalkpro.action.TapatalkAccountAction;
import com.quoord.tapatalkpro.action.TapatalkAccountAction.GetLocalAccountBack;
import com.quoord.tapatalkpro.action.TapatalkAccountAction.GetRemoteAccountBack;
import com.quoord.tapatalkpro.activity.directory.ics.AccountEntryActivity;
import com.quoord.tapatalkpro.activity.directory.ics.FavForumsFragment;
import com.quoord.tapatalkpro.adapter.CallBackInterface;
import com.quoord.tapatalkpro.adapter.directory.view.IcsFavForumView;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.Profile;
import com.quoord.tapatalkpro.bean.Profile.UploadAvatarCallback;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.ui.ButtomProgress;
import com.quoord.tapatalkpro.ui.ListItemRemoveAnimatorController;
import com.quoord.tapatalkpro.ui.ListItemRemoveAnimatorController.DismissCallbacks;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.ImageTools;
import com.quoord.tools.directoryurl.DirectoryUrlUtil;
import com.quoord.tools.net.TapatalkAjaxAction;
import com.quoord.tools.net.TapatalkAjaxAction.ActionCallBack;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class FavoriteForumAdapter
        extends BaseAdapter
        implements CallBackInterface, DragSortListView.DropListener {
    private static final int TAG_SIGNINFO_NOTID = 1;
    private static final int TAG_SIGNINFO_NOUSERNAME = 3;
    private static final int TAG_SIGNINFO_UNCONFIRMEMAIL = 2;
    private static final int VIEWTYPE_FORUM_WITHOUT_NAME = 1;
    private static final int VIEWTYPE_FORUM_WITH_NAME = 0;
    private TapatalkAccountAction accountAction;
    private ArrayList<String> accounts = new ArrayList();
    public String cloudCachePath;
    private LinearLayout footLay;
    private FavForumsFragment fragment;
    FavoriateSqlHelper helper;
    private boolean isForumHeaderStickTop = false;
    public ArrayList<TapatalkForum> localDatas = new ArrayList();
    private Activity mContext;
    private ArrayList<TapatalkForum> mDatas = new ArrayList();
    private MyDSController mDsController;
    private EditMode mEditMode = null;
    private View mForumHeadView = null;
    private View mForumHeaderStickTopView = null;
    private Boolean mHasSignout = Boolean.valueOf(false);
    private TextView mHeaderTopTv = null;
    private TextView mHeaderTv = null;
    private ArrayList<View> mListHeaderViews = null;
    public Profile mProfile = null;
    private Bitmap mProfileBitmap = null;
    private View mProfileView = null;
    private ListItemRemoveAnimatorController mRemover = null;
    private View mSignInfoView = null;
    private int mSigninfoTag = 0;
    ImageView messageIcon;
    LinearLayout messageLayout;
    TextView messageText;
    public DragSortListView networkItemList;
    public String orderMapPath;
    private boolean showFlag = false;
    private SynchaAccountAction syncAction;
    private TapatalkId tapatalkId;
    private OnForumsChangedResultListener unreadResultListener = null;
    RelativeLayout wrap;

    public FavoriteForumAdapter(FavForumsFragment paramFavForumsFragment, Activity paramActivity, DragSortListView paramDragSortListView, LinearLayout paramLinearLayout, View paramView) {
        this.fragment = paramFavForumsFragment;
        this.mContext = paramActivity;
        this.networkItemList = paramDragSortListView;
        this.messageLayout = paramLinearLayout;
        this.mForumHeaderStickTopView = paramView;
        initialze();
        initDsController();
        updateProfile();
        initForumHeader();
        this.footLay = ButtomProgress.get(this.mContext);
        this.networkItemList.addFooterView(this.footLay);
        this.networkItemList.setAdapter(this);
        notifyDataSetChanged();
        updatedata(false);
        initListView();
    }

    private void addHeaderView(View paramView) {
        if (paramView == null) {
            break label4;
        }
        label4:
        while (this.mListHeaderViews.contains(paramView)) {
            return;
        }
        if (paramView == this.mForumHeadView) {
            this.mListHeaderViews.add(paramView);
        }
        for (; ; ) {
            if (this.mForumHeadView != null) {
                this.networkItemList.removeHeaderView(this.mForumHeadView);
            }
            if (this.mProfileView != null) {
                this.networkItemList.removeHeaderView(this.mProfileView);
            }
            if (this.mSignInfoView != null) {
                this.networkItemList.removeHeaderView(this.mSignInfoView);
            }
            paramView = this.mListHeaderViews.iterator();
            while (paramView.hasNext()) {
                View localView = (View) paramView.next();
                this.networkItemList.addHeaderView(localView);
            }
            break label4;
            if (paramView == this.mProfileView) {
                if (this.mListHeaderViews.contains(this.mForumHeadView)) {
                    this.mListHeaderViews.add(this.mListHeaderViews.indexOf(this.mForumHeadView), paramView);
                } else {
                    this.mListHeaderViews.add(paramView);
                }
            } else {
                if (paramView != this.mSignInfoView) {
                    break;
                }
                this.mListHeaderViews.add(0, paramView);
            }
        }
    }

    private void deleteForumBackground(int paramInt) {
        Object localObject1 = null;
        try {
            TapatalkForum localTapatalkForum = (TapatalkForum) this.mDatas.get(paramInt);
            localObject1 = localTapatalkForum;
            if (localTapatalkForum == null) {
                return;
            }
        } catch (Exception localException) {
            do {
                TapatalkAccountAction.deleteCurrenForums((TapatalkForum) this.mDatas.get(paramInt));
                this.helper.deleteFavoriate((TapatalkForum) localObject1);
                Object localObject2 = Prefs.get(this.mContext);
                StringBuilder localStringBuilder = new StringBuilder();
                if (((SharedPreferences) localObject2).getInt("tapatalk_auid", 0) != 0) {
                    localStringBuilder.append(TapatalkJsonEngine.AU_DELETE_ACCONT).append("?au_id=").append(((SharedPreferences) localObject2).getInt("tapatalk_auid", 0)).append("&token=").append(((SharedPreferences) localObject2).getString("token", "")).append("&fid=").append(((TapatalkForum) localObject1).getId());
                    if (!Util.isEmpty(((TapatalkForum) localObject1).getUserNameOrDisplayName())) {
                        localStringBuilder.append("&username=").append(URLEncoder.encode(((TapatalkForum) localObject1).getUserNameOrDisplayName()));
                    }
                    if (((TapatalkForum) localObject1).getUserId() != null) {
                        localStringBuilder.append("&uid=").append(((TapatalkForum) localObject1).getUserId());
                    }
                    TapatalkJsonEngine.callLogin(this.mContext, localStringBuilder.toString());
                    localStringBuilder.setLength(0);
                }
                localObject2 = ((SharedPreferences) localObject2).edit();
                ((SharedPreferences.Editor) localObject2).remove(((TapatalkForum) localObject1).getId() + "|notification").commit();
                ((SharedPreferences.Editor) localObject2).remove("lognewlogin|" + ((TapatalkForum) localObject1).getId()).commit();
            } while (!Util.isLoginedUser(this.mContext, (TapatalkForum) localObject1));
            Util.deleteWidgetByForumId(this.mContext, ((TapatalkForum) localObject1).getId());
        }
    }

    private void forumHeaderEditOnClick() {
        this.showFlag = true;
        this.mHeaderTv.setText(this.mContext.getString(2131100410));
        this.mHeaderTv.setOnClickListener(new ForumHeaderDoneOnClickListener());
        this.mHeaderTopTv.setText(this.mContext.getString(2131100410));
        this.mHeaderTopTv.setOnClickListener(new ForumHeaderDoneOnClickListener());
    }

    private void getForums() {
        if ((this.mDatas == null) || (this.mDatas.size() == 0)) {
            return;
        }
        Object localObject = new StringBuilder();
        Iterator localIterator = this.mDatas.iterator();
        for (; ; ) {
            if (!localIterator.hasNext()) {
                ((StringBuilder) localObject).deleteCharAt(0);
                localObject = DirectoryUrlUtil.createGetForumById(this.mContext, ((StringBuilder) localObject).toString());
                new TapatalkAjaxAction(this.mContext).getJsonArrayAction((String) localObject, new TapatalkAjaxAction.ActionCallBack() {
                    public void actionCallBack(Object paramAnonymousObject) {
                        if (paramAnonymousObject == null) {
                            return;
                        }
                        JSONArray localJSONArray = (JSONArray) paramAnonymousObject;
                        Iterator localIterator = FavoriteForumAdapter.this.mDatas.iterator();
                        if (!localIterator.hasNext()) {
                            FavoriteForumAdapter.this.notifyDataSetChanged();
                            FavoriteForumAdapter.this.accountAction.cacheAccountData(FavoriteForumAdapter.this.mDatas);
                            return;
                        }
                        paramAnonymousObject = (TapatalkForum) localIterator.next();
                        int i = 0;
                        label71:
                        JSONObject localJSONObject;
                        Object localObject;
                        if (i < localJSONArray.length()) {
                            localJSONObject = localJSONArray.optJSONObject(i);
                            if (localJSONObject != null) {
                                break label104;
                            }
                            localObject = paramAnonymousObject;
                        }
                        for (; ; ) {
                            i += 1;
                            paramAnonymousObject = localObject;
                            break label71;
                            break;
                            label104:
                            localObject = paramAnonymousObject;
                            if (localJSONObject.optInt("id") == ((TapatalkForum) paramAnonymousObject).getId().intValue()) {
                                localObject = TapatalkForum.getForum(localJSONObject, ((TapatalkForum) paramAnonymousObject).getUserNameOrDisplayName(), ((TapatalkForum) paramAnonymousObject).getmUseEmail(), ((TapatalkForum) paramAnonymousObject).getUserId());
                            }
                        }
                    }
                });
                return;
            }
            TapatalkForum localTapatalkForum = (TapatalkForum) localIterator.next();
            ((StringBuilder) localObject).append("," + localTapatalkForum.getId());
        }
    }

    private void initDsController() {
        this.mDsController = new MyDSController(this.networkItemList);
        this.networkItemList.setFloatViewManager(this.mDsController);
        this.networkItemList.setOnTouchListener(this.mDsController);
    }

    private void initForumHeader() {
        this.mForumHeadView = this.mContext.getLayoutInflater().inflate(2130903140, null);
        if (this.mForumHeaderStickTopView == null) {
            this.mForumHeaderStickTopView = this.mForumHeadView;
        }
        Util.setBg(this.mForumHeadView, ThemeUtil.getDrawableByPicName("ob_section_title", this.mContext));
        Util.setBg(this.mForumHeaderStickTopView, ThemeUtil.getDrawableByPicName("ob_section_title", this.mContext));
        this.mHeaderTv = ((TextView) this.mForumHeadView.findViewById(2131231007));
        this.mHeaderTv.setText(this.mContext.getString(2131100909));
        this.mHeaderTv.setOnClickListener(new ForumHeaderEditOnClickListener());
        this.mHeaderTopTv = ((TextView) this.mForumHeaderStickTopView.findViewById(2131231007));
        this.mHeaderTopTv.setText(this.mContext.getString(2131100909));
        this.mHeaderTopTv.setOnClickListener(new ForumHeaderEditOnClickListener());
        addHeaderView(this.mForumHeadView);
    }

    private void initListView() {
        this.networkItemList.setSelector(2131165212);
        this.networkItemList.setOnItemClickListener(new NetworkOnItemClickListener());
        this.networkItemList.setOnItemLongClickListener(new NetWorkOnItemLongClickListener());
        this.networkItemList.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {
                if (FavoriteForumAdapter.this.mForumHeaderStickTopView == null) {
                }
                do {
                    return;
                    if ((paramAnonymousInt1 >= FavoriteForumAdapter.this.networkItemList.getHeaderViewsCount() - 1) && (!FavoriteForumAdapter.this.isForumHeaderStickTop)) {
                        FavoriteForumAdapter.this.isForumHeaderStickTop = true;
                        FavoriteForumAdapter.this.mForumHeaderStickTopView.setVisibility(0);
                        return;
                    }
                }
                while ((paramAnonymousInt1 >= FavoriteForumAdapter.this.networkItemList.getHeaderViewsCount() - 1) || (!FavoriteForumAdapter.this.isForumHeaderStickTop));
                FavoriteForumAdapter.this.isForumHeaderStickTop = false;
                FavoriteForumAdapter.this.mForumHeaderStickTopView.setVisibility(4);
            }

            public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {
            }
        });
    }

    private void initProfileArea() {
        if (this.mSigninfoTag != 0) {
            removeHeaderView(this.mSignInfoView);
            this.mSigninfoTag = 0;
        }
        getAllAccount();
        this.mProfile = new Profile(this.mContext);
        updateProfile();
        if (!this.tapatalkId.isConfirmed()) {
            this.mSigninfoTag = 2;
            this.mSignInfoView = this.mContext.getLayoutInflater().inflate(2130903319, null);
            ((TextView) this.mSignInfoView.findViewById(2131231521)).setText(this.mContext.getString(2131100586));
            addHeaderView(this.mSignInfoView);
            this.mSignInfoView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    FavoriteForumAdapter.this.fragment.showDialog(23);
                }
            });
        }
        for (; ; ) {
            addHeaderView(this.mProfileView);
            return;
            if (this.tapatalkId.getUsername() == null) {
                this.mSigninfoTag = 3;
                this.mSignInfoView = this.mContext.getLayoutInflater().inflate(2130903319, null);
                ((TextView) this.mSignInfoView.findViewById(2131231521)).setText(this.mContext.getString(2131100587));
                addHeaderView(this.mSignInfoView);
                this.mSignInfoView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View paramAnonymousView) {
                        FavoriteForumAdapter.this.fragment.showDialog(100);
                    }
                });
            }
        }
    }

    private void initSignInTapatalk() {
        if (this.mSigninfoTag != 0) {
            return;
        }
        this.mSigninfoTag = 1;
        this.mSignInfoView = this.mContext.getLayoutInflater().inflate(2130903322, null);
        addHeaderView(this.mSignInfoView);
        this.mSignInfoView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                FavoriteForumAdapter.this.fragment.needUpdateRemote = true;
                paramAnonymousView = new Intent();
                paramAnonymousView.setClass(FavoriteForumAdapter.this.mContext, ObEntryActivity.class);
                paramAnonymousView.putExtra("accountPage", true);
                paramAnonymousView.putExtra("guestLogin", true);
                FavoriteForumAdapter.this.mContext.startActivityForResult(paramAnonymousView, 37);
            }
        });
    }

    private void initialze() {
        this.tapatalkId = TapatalkIdFactory.getTapatalkId(this.mContext);
        this.accountAction = new TapatalkAccountAction(this.mContext);
        this.syncAction = new SynchaAccountAction(this.mContext);
        if ((this.mContext instanceof OnForumsChangedResultListener)) {
            setOnForumsChangedResultListener((OnForumsChangedResultListener) this.mContext);
        }
        this.helper = new FavoriateSqlHelper(this.mContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version));
        this.mRemover = new ListItemRemoveAnimatorController(this.networkItemList, new FavForumDismissCallbacks());
        this.mListHeaderViews = new ArrayList();
        this.mHasSignout = Boolean.valueOf(false);
    }

    private void removeHeaderView(View paramView) {
        if (paramView == null) {
            return;
        }
        this.networkItemList.removeHeaderView(paramView);
        this.mListHeaderViews.remove(paramView);
    }

    private void startOnBoarding() {
        Intent localIntent = new Intent();
        localIntent.setClass(this.mContext, ObChooseActivity.class);
        this.mContext.startActivity(localIntent);
        this.mContext.finish();
    }

    private void uploadHideState() {
        Object localObject1 = new StringBuilder();
        Object localObject2 = this.mDatas.iterator();
        for (; ; ) {
            if (!((Iterator) localObject2).hasNext()) {
                localObject2 = new HashMap();
                ((HashMap) localObject2).put("account", ((StringBuilder) localObject1).toString());
                localObject1 = DirectoryUrlUtil.getUploadProfileUrl(this.mContext, (HashMap) localObject2);
                new TapatalkAjaxAction(this.mContext).getJsonObjectAction((String) localObject1, new TapatalkAjaxAction.ActionCallBack() {
                    public void actionCallBack(Object paramAnonymousObject) {
                    }
                });
                return;
            }
            TapatalkForum localTapatalkForum = (TapatalkForum) ((Iterator) localObject2).next();
            if (((StringBuilder) localObject1).length() > 0) {
                ((StringBuilder) localObject1).append(",");
            }
            ((StringBuilder) localObject1).append(localTapatalkForum.getId());
            ((StringBuilder) localObject1).append("|");
            ((StringBuilder) localObject1).append(localTapatalkForum.getUserId());
            ((StringBuilder) localObject1).append("|");
            if (localTapatalkForum.isHide()) {
                ((StringBuilder) localObject1).append("private");
            } else {
                ((StringBuilder) localObject1).append("public");
            }
        }
    }

    public void callBack(EngineResponse paramEngineResponse) {
        if (paramEngineResponse.isSuccess()) {
            this.messageLayout.setVisibility(8);
        }
        try {
            this.helper.close();
            return;
        } catch (Exception paramEngineResponse) {
            paramEngineResponse.printStackTrace();
        }
    }

    public boolean clearActionMode() {
        if (this.mEditMode != null) {
            this.mEditMode.finishEditMode();
            return true;
        }
        return false;
    }

    public void clearTempData() {
        this.accounts.clear();
        this.mHasSignout = Boolean.valueOf(true);
        AppCacheManager.del(this.cloudCachePath);
        AppCacheManager.del(this.orderMapPath);
        Profile.clearProfile(this.mContext);
        this.mProfile = null;
        if (this.networkItemList.getHeaderViewsCount() > 0) {
            removeHeaderView(this.mProfileView);
            removeHeaderView(this.mForumHeadView);
            removeHeaderView(this.mSignInfoView);
        }
        if (this.mForumHeaderStickTopView != null) {
            this.mForumHeaderStickTopView.setVisibility(8);
        }
    }

    public void deleteFavoriateForum(int paramInt) {
        deleteForumBackground(paramInt);
        this.mRemover.removeItem(this.networkItemList.getChildAt(paramInt - this.networkItemList.getFirstVisiblePosition() + this.networkItemList.getHeaderViewsCount()), paramInt);
    }

    public void drop(int paramInt1, int paramInt2) {
        TapatalkForum localTapatalkForum = (TapatalkForum) this.mDatas.remove(paramInt1);
        this.mDatas.add(paramInt2, localTapatalkForum);
        notifyDataSetChanged();
    }

    public void forumHeaderDoneOnClick() {
        this.showFlag = false;
        this.mHeaderTv.setText(this.mContext.getString(2131100909));
        this.mHeaderTv.setOnClickListener(new ForumHeaderEditOnClickListener());
        this.mHeaderTopTv.setText(this.mContext.getString(2131100909));
        this.mHeaderTopTv.setOnClickListener(new ForumHeaderEditOnClickListener());
    }

    public void getAllAccount() {
        this.accountAction.getRemoteAccount(new TapatalkAccountAction.GetRemoteAccountBack() {
            public void getAccountBack(ArrayList<TapatalkForum> paramAnonymousArrayList) {
                FavoriteForumAdapter.this.updateProfile();
                Prefs.updateAccountTime(FavoriteForumAdapter.this.mContext);
                if (FavoriteForumAdapter.this.networkItemList.getFooterViewsCount() > 0) {
                    FavoriteForumAdapter.this.networkItemList.removeFooterView(FavoriteForumAdapter.this.footLay);
                }
                if (paramAnonymousArrayList.size() == 0) {
                    FavoriteForumAdapter.this.mDatas = FavoriteForumAdapter.this.localDatas;
                    if (FavoriteForumAdapter.this.localDatas.size() > 0) {
                        FavoriteForumAdapter.this.notifyDataSetChanged();
                        return;
                    }
                    FavoriteForumAdapter.this.networkItemList.setVisibility(8);
                    FavoriteForumAdapter.this.messageLayout.setVisibility(0);
                    Util.displayFullScreenMessage(FavoriteForumAdapter.this.mContext, FavoriteForumAdapter.this.mContext.getString(2131100206), 2130839107);
                }
                for (; ; ) {
                    if ((FavoriteForumAdapter.this.mContext instanceof AccountEntryActivity)) {
                        ((AccountEntryActivity) FavoriteForumAdapter.this.mContext).getFeeds(paramAnonymousArrayList);
                        ((AccountEntryActivity) FavoriteForumAdapter.this.mContext).updateFeedSettings(FavoriteForumAdapter.this.mDatas);
                    }
                    if (Prefs.needUpdateOrder(FavoriteForumAdapter.this.mContext)) {
                        FavoriteForumAdapter.this.syncAction.synchAccount(FavoriteForumAdapter.this.mDatas);
                        Prefs.updateOrderTime(FavoriteForumAdapter.this.mContext);
                    }
                    FavoriteForumAdapter.this.mContext.invalidateOptionsMenu();
                    return;
                    FavoriteForumAdapter.this.mDatas = paramAnonymousArrayList;
                    FavoriteForumAdapter.this.networkItemList.setVisibility(0);
                    FavoriteForumAdapter.this.messageLayout.setVisibility(8);
                    FavoriteForumAdapter.this.notifyDataSetChanged();
                }
            }
        });
    }

    public int getCount() {
        return this.mDatas.size();
    }

    public Object getItem(int paramInt) {
        return this.mDatas.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public int getItemViewType(int paramInt) {
        if (!Util.isEmpty(((TapatalkForum) this.mDatas.get(paramInt)).getUserName())) {
            return 0;
        }
        return 1;
    }

    public OnForumsChangedResultListener getOnForumsChangedResultListener() {
        return this.unreadResultListener;
    }

    public Bitmap getProfileBitmap() {
        return this.mProfileBitmap;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        Object localObject = this.mContext;
        TapatalkForum localTapatalkForum;
        boolean bool2;
        if (this.mSigninfoTag != 1) {
            bool1 = true;
            localObject = new IcsFavForumView((Activity) localObject, this, bool1);
            if (this.mProfile != null) {
                ((IcsFavForumView) localObject).setProfileAvatar(this.mProfile.getAvatar());
            }
            localTapatalkForum = (TapatalkForum) getItem(paramInt);
            bool2 = this.showFlag;
            if (paramInt != this.mDatas.size() - 1) {
                break label103;
            }
        }
        label103:
        for (boolean bool1 = true; ; bool1 = false) {
            return ((IcsFavForumView) localObject).getView(localTapatalkForum, paramInt, paramView, paramViewGroup, bool2, bool1);
            bool1 = false;
            break;
        }
    }

    public int getViewTypeCount() {
        return 4;
    }

    public ArrayList<TapatalkForum> getmDatas() {
        return this.mDatas;
    }

    public boolean isEnabled(int paramInt) {
        return (this.mDatas.get(paramInt) instanceof TapatalkForum);
    }

    public boolean isOpCancel() {
        return false;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message paramAnonymousMessage) {
                int m = FavoriteForumAdapter.this.mDatas.size();
                int j = 0;
                int i = 0;
                for (; ; ) {
                    if (i >= m) {
                        if ((j == 0) || (FavoriteForumAdapter.this.unreadResultListener != null)) {
                            if (1 != 0) {
                                FavoriteForumAdapter.this.unreadResultListener.loginStatusChangedResult(FavoriteForumAdapter.this.mDatas);
                            }
                            FavoriteForumAdapter.this.unreadResultListener.otherChangedResult(FavoriteForumAdapter.this.mDatas);
                        }
                        if (!FavoriteForumAdapter.this.mHasSignout.booleanValue()) {
                            FavoriteForumAdapter.this.updateProfile();
                        }
                        return;
                    }
                    paramAnonymousMessage = (TapatalkForum) FavoriteForumAdapter.this.mDatas.get(i);
                    int k = j;
                    if (Util.isLoggedForum(FavoriteForumAdapter.this.mContext, paramAnonymousMessage.getId(), paramAnonymousMessage.getLowerUserName(), paramAnonymousMessage.getPassword())) {
                        k = j + 1;
                    }
                    i += 1;
                    j = k;
                }
            }
        }.sendEmptyMessage(1);
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        if ((paramInt1 == 42716) || (paramInt1 == 9667)) {
            this.mProfile.onActivityResult(paramInt1, paramInt2, paramIntent);
        }
    }

    public void removeSignInfo() {
        this.mSigninfoTag = 0;
        removeHeaderView(this.mSignInfoView);
    }

    public void setOnForumsChangedResultListener(OnForumsChangedResultListener paramOnForumsChangedResultListener) {
        this.unreadResultListener = paramOnForumsChangedResultListener;
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void signOutForum(int paramInt) {
        TapatalkForum localTapatalkForum = (TapatalkForum) this.mDatas.get(paramInt);
        int j = 1;
        int i = 0;
        if (i >= this.mDatas.size()) {
            if (j != 0) {
                localTapatalkForum.setUserId("");
                localTapatalkForum.setUserName("");
                localTapatalkForum.setDisplayName("");
                localTapatalkForum.setPassword("");
                this.accountAction.cacheAccountData(this.mDatas);
                this.helper.saveFavoriate(localTapatalkForum);
            }
        } else {
            if (i == paramInt) {
            }
            for (; ; ) {
                i += 1;
                break;
                if (((TapatalkForum) this.mDatas.get(i)).getId().equals(localTapatalkForum.getId())) {
                    j = 0;
                }
            }
        }
        this.helper.deleteFavoriate(localTapatalkForum);
        TapatalkAccountAction.deleteCurrenForums((TapatalkForum) this.mDatas.get(paramInt));
        this.mRemover.removeItem(this.networkItemList.getChildAt(paramInt - this.networkItemList.getFirstVisiblePosition() + this.networkItemList.getHeaderViewsCount()), paramInt);
    }

    public void updateProfile() {
        if (this.mProfile == null) {
            if ((this.tapatalkId.getAuid() != -1) && (this.tapatalkId.isTapatalkIdLogin())) {
                initProfileArea();
            }
        } else {
            if ((this.tapatalkId.isConfirmed()) && (this.mSigninfoTag == 2)) {
                removeHeaderView(this.mSignInfoView);
                this.mSignInfoView = null;
                this.mSigninfoTag = 0;
            }
            if ((this.tapatalkId.getUsername() != null) && (this.mSigninfoTag == 3)) {
                removeHeaderView(this.mSignInfoView);
                this.mSignInfoView = null;
                this.mSigninfoTag = 0;
            }
            this.mProfile.updateProfile();
            this.mProfileBitmap = ImageTools.getBitmapFromCache(AppCacheManager.getLongtermCacheDir(this.mContext) + this.mProfile.getAvatar().hashCode());
            this.mProfileView = this.mProfile.getProfileView(this.mProfileView, this.mContext, null, new Profile.UploadAvatarCallback() {
                public void callback() {
                    FavoriteForumAdapter.this.updateProfile();
                }
            });
            return;
        }
        initSignInTapatalk();
    }

    public void updateSubclassDialog(int paramInt) {
    }

    public void updatedata(boolean paramBoolean) {
        if (paramBoolean) {
        }
        try {
            getAllAccount();
            return;
        } catch (Exception localException) {
        }
        this.accountAction.getLocalAccount(new TapatalkAccountAction.GetLocalAccountBack() {
            public void getLocalAccountBack(ArrayList<TapatalkForum> paramAnonymousArrayList) {
                if (paramAnonymousArrayList.size() > 0) {
                    if (FavoriteForumAdapter.this.networkItemList.getFooterViewsCount() > 0) {
                        FavoriteForumAdapter.this.networkItemList.removeFooterView(FavoriteForumAdapter.this.footLay);
                    }
                    FavoriteForumAdapter.this.mDatas.clear();
                    FavoriteForumAdapter.this.localDatas = paramAnonymousArrayList;
                    FavoriteForumAdapter.this.mDatas = paramAnonymousArrayList;
                    FavoriteForumAdapter.this.notifyDataSetChanged();
                    if (FavoriteForumAdapter.this.tapatalkId.getAuid() == -1) {
                        FavoriteForumAdapter.this.getForums();
                    }
                }
                if ((FavoriteForumAdapter.this.mContext instanceof AccountEntryActivity)) {
                    ((AccountEntryActivity) FavoriteForumAdapter.this.mContext).getFeeds(paramAnonymousArrayList);
                    ((AccountEntryActivity) FavoriteForumAdapter.this.mContext).updateFeedSettings(FavoriteForumAdapter.this.mDatas);
                }
            }
        });
        return;
    }

    class EditMode {
        public EditMode() {
            initEditMode();
        }

        private void finishEditMode() {
            FavoriteForumAdapter.this.showFlag = false;
            FavoriteForumAdapter.this.mEditMode = null;
            FavoriteForumAdapter.this.networkItemList.setOnTouchListener(null);
            FavoriteForumAdapter.this.networkItemList.setOnItemClickListener(new FavoriteForumAdapter.NetworkOnItemClickListener(FavoriteForumAdapter.this));
            FavoriteForumAdapter.this.networkItemList.setOnItemLongClickListener(new FavoriteForumAdapter.NetWorkOnItemLongClickListener(FavoriteForumAdapter.this));
            FavoriteForumAdapter.this.notifyDataSetChanged();
            FavoriteForumAdapter.this.syncAction.synchAccount(FavoriteForumAdapter.this.mDatas);
            FavoriteForumAdapter.this.accountAction.cacheAccountData(FavoriteForumAdapter.this.mDatas);
            FavoriteForumAdapter.this.forumHeaderDoneOnClick();
            FavoriteForumAdapter.this.uploadHideState();
        }

        private void initEditMode() {
            FavoriteForumAdapter.this.networkItemList.setOnTouchListener(FavoriteForumAdapter.this.mDsController);
            FavoriteForumAdapter.this.networkItemList.setOnItemLongClickListener(null);
            FavoriteForumAdapter.this.networkItemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                    new FavoriteForumAdapter.EditMode(FavoriteForumAdapter.this);
                    FavoriteForumAdapter.this.showFlag = true;
                    FavoriteForumAdapter.this.networkItemList.setOnTouchListener(FavoriteForumAdapter.this.mDsController);
                    FavoriteForumAdapter.this.notifyDataSetChanged();
                }
            });
            if (FavoriteForumAdapter.this.mProfile != null) {
                FavoriteForumAdapter.this.mProfile.uploadDescription();
            }
            FavoriteForumAdapter.this.forumHeaderEditOnClick();
        }
    }

    class FavForumDismissCallbacks
            implements ListItemRemoveAnimatorController.DismissCallbacks {
        FavForumDismissCallbacks() {
        }

        public void onDismiss(ListView paramListView, int[] paramArrayOfInt) {
            for (; ; ) {
                try {
                    int j = paramArrayOfInt.length;
                    i = 0;
                    if (i < j) {
                        continue;
                    }
                } catch (Exception paramListView) {
                    int i;
                    int k;
                    continue;
                }
                if ((FavoriteForumAdapter.this.mContext instanceof AccountEntryActivity)) {
                    ((AccountEntryActivity) FavoriteForumAdapter.this.mContext).updateFeedSettings(FavoriteForumAdapter.this.mDatas);
                }
                FavoriteForumAdapter.this.notifyDataSetChanged();
                if (FavoriteForumAdapter.this.getCount() == 0) {
                    FavoriteForumAdapter.this.tapatalkId.saveTapatalkIdData("tapatalkhasaccount", false);
                    FavoriteForumAdapter.this.startOnBoarding();
                }
                return;
                k = paramArrayOfInt[i];
                FavoriteForumAdapter.this.mDatas.remove(k);
                FavoriteForumAdapter.this.accountAction.cacheAccountData(FavoriteForumAdapter.this.mDatas);
                i += 1;
            }
        }
    }

    class ForumHeaderDoneOnClickListener
            implements View.OnClickListener {
        ForumHeaderDoneOnClickListener() {
        }

        public void onClick(View paramView) {
            if (FavoriteForumAdapter.this.mEditMode != null) {
                FavoriteForumAdapter.this.mEditMode.finishEditMode();
            }
            FavoriteForumAdapter.this.forumHeaderDoneOnClick();
        }
    }

    class ForumHeaderEditOnClickListener
            implements View.OnClickListener {
        ForumHeaderEditOnClickListener() {
        }

        public void onClick(View paramView) {
            if (FavoriteForumAdapter.this.mEditMode == null) {
                FavoriteForumAdapter.this.mEditMode = new FavoriteForumAdapter.EditMode(FavoriteForumAdapter.this);
                FavoriteForumAdapter.this.notifyDataSetChanged();
            }
            FavoriteForumAdapter.this.forumHeaderEditOnClick();
        }
    }

    public class MyDSController
            extends DragSortController {
        DragSortListView mDslv;

        public MyDSController(DragSortListView paramDragSortListView) {
            super();
            setDragHandleId(2131231171);
            setDragInitMode(2);
            this.mDslv = paramDragSortListView;
        }

        public View onCreateFloatView(int paramInt) {
            View localView = FavoriteForumAdapter.this.getView(paramInt, null, this.mDslv);
            localView.getBackground().setLevel(10000);
            return localView;
        }

        public void onDestroyFloatView(View paramView) {
        }

        public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
            FavoriteForumAdapter.this.fragment.closeHint(0);
            if ((FavoriteForumAdapter.this.mProfile != null) && (FavoriteForumAdapter.this.mProfile.uploadDescription())) {
                return true;
            }
            return super.onTouch(paramView, paramMotionEvent);
        }
    }

    class NetWorkOnItemLongClickListener
            implements AdapterView.OnItemLongClickListener {
        NetWorkOnItemLongClickListener() {
        }

        public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
            if (!(((Adapter) paramAdapterView.getAdapter()).getItem(paramInt) instanceof TapatalkForum)) {
                return false;
            }
            FavoriteForumAdapter.this.showFlag = true;
            if (FavoriteForumAdapter.this.mEditMode == null) {
                FavoriteForumAdapter.this.mEditMode = new FavoriteForumAdapter.EditMode(FavoriteForumAdapter.this);
                FavoriteForumAdapter.this.notifyDataSetChanged();
            }
            return true;
        }
    }

    class NetworkOnItemClickListener
            implements AdapterView.OnItemClickListener {
        NetworkOnItemClickListener() {
        }

        public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
            if ((((Adapter) paramAdapterView.getAdapter()).getItem(paramInt) instanceof TapatalkForum)) {
                ((TapatalkForum) ((Adapter) paramAdapterView.getAdapter()).getItem(paramInt)).openTapatalkForum(FavoriteForumAdapter.this.mContext, false);
            }
        }
    }

    public static abstract interface OnForumsChangedResultListener {
        public abstract void loginStatusChangedResult(ArrayList<TapatalkForum> paramArrayList);

        public abstract void otherChangedResult(ArrayList<TapatalkForum> paramArrayList);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/directory/FavoriteForumAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */