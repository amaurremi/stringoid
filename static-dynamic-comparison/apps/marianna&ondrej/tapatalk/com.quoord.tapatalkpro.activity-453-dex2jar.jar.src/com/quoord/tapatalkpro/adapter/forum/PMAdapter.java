package com.quoord.tapatalkpro.adapter.forum;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import com.quoord.DialogUtil.PMDialogAdapter;
import com.quoord.tapatalkpro.activity.forum.CreatePmActivity;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.activity.forum.PmContentFragment;
import com.quoord.tapatalkpro.activity.forum.ProfilesActivity;
import com.quoord.tapatalkpro.bean.BaseBean;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.NoPMView;
import com.quoord.tapatalkpro.bean.PrivateMessage;
import com.quoord.tapatalkpro.ics.conversation.PMListFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.BackListAdapter;
import com.quoord.tapatalkpro.ics.slidingMenu.BackListFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.BackListFragment.ChangeUnreadNumbers;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ics.slidingMenu.TabItem;
import com.quoord.tapatalkpro.saxparser.PMSaxParser;
import com.quoord.tapatalkpro.saxparser.PMSaxParser.ICallback;
import com.quoord.tapatalkpro.ui.ButtomProgress;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tools.TwoPanelControllerWithId;
import com.quoord.tools.tracking.GoogleAnalyticsTools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PMAdapter
        extends ForumRootAdapter
        implements AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener {
    private int PMSAX_CLOSE_PROGRESS = 0;
    private int PMSAX_UPDATE_BEGIN = 3;
    private int PMSAX_UPDATE_END = 2;
    private int PMSAX_UPDATE_ITEM = 1;
    private int SAX_DISPLAY_ERROR = 4;
    public ActionMode anMode;
    private String boxId;
    PrivateMessage curPm;
    public int currentSelectedPosition = -1;
    private LinearLayout footlay;
    private String inboxId;
    protected Boolean isFootAdd = Boolean.valueOf(false);
    private boolean isInbox = true;
    private boolean loadingMore = false;
    private Activity mContext = null;
    private int mCountPerpage = 20;
    public ArrayList<BaseBean> mDatas = new ArrayList();
    protected PMSaxParser mPMParser;
    private int mStart = 0;
    private Handler mUIHandler = null;
    private String outboxId;
    public PMActionMode pmActionMode = null;
    private ArrayList<BaseBean> tempDatas = new ArrayList();
    private int total_message_count;
    private int total_unread_count;

    public PMAdapter(Activity paramActivity, String paramString, boolean paramBoolean, ListView paramListView) {
        super(paramActivity, paramString);
        this.mContext = paramActivity;
        this.mPMParser = new PMSaxParser(this.mContext);
        this.loadingMore = true;
        this.isInbox = paramBoolean;
        if (this.isInbox) {
            GoogleAnalyticsTools.trackPageView(this.mContext, "pm/inbox", this.forumStatus.getForumId(), this.forumStatus.getUrl());
        }
        for (; ; ) {
            this.mContext = paramActivity;
            this.mListView = paramListView;
            this.footlay = ButtomProgress.get(this.mContext);
            if (this.mListView.getFooterViewsCount() <= 0) {
                this.mListView.addFooterView(this.footlay);
            }
            this.mListView.setAdapter(this);
            addOnitemclickEven();
            addOnitemLongclickEven();
            this.mPMParser.setCallback(new PMSaxParser.ICallback() {
                public void onAddItem(HashMap paramAnonymousHashMap) {
                    Message localMessage = PMAdapter.this.mUIHandler.obtainMessage();
                    localMessage.what = PMAdapter.this.PMSAX_UPDATE_ITEM;
                    localMessage.obj = paramAnonymousHashMap;
                    PMAdapter.this.mUIHandler.sendMessage(localMessage);
                }

                public void onDocBegin() {
                    Message localMessage = PMAdapter.this.mUIHandler.obtainMessage();
                    localMessage.what = PMAdapter.this.PMSAX_UPDATE_BEGIN;
                    PMAdapter.this.mUIHandler.sendMessage(localMessage);
                }

                public void onDocEnd() {
                    Message localMessage = PMAdapter.this.mUIHandler.obtainMessage();
                    localMessage.what = PMAdapter.this.PMSAX_UPDATE_END;
                    PMAdapter localPMAdapter = PMAdapter.this;
                    localPMAdapter.mStart += PMAdapter.this.mCountPerpage;
                    PMAdapter.this.mUIHandler.sendMessage(localMessage);
                }

                public void onGetPMInfo(HashMap paramAnonymousHashMap) {
                    PMAdapter.this.total_message_count = ((Integer) paramAnonymousHashMap.get("total_message_count")).intValue();
                    paramAnonymousHashMap = PMAdapter.this.mUIHandler.obtainMessage();
                    paramAnonymousHashMap.what = PMAdapter.this.PMSAX_CLOSE_PROGRESS;
                    PMAdapter.this.mUIHandler.sendMessage(paramAnonymousHashMap);
                }

                public void onGetPMUnReadInfo(HashMap paramAnonymousHashMap) {
                    PMAdapter.this.total_unread_count = ((Integer) paramAnonymousHashMap.get("total_unread_count")).intValue();
                    paramAnonymousHashMap = PMAdapter.this.mUIHandler.obtainMessage();
                    paramAnonymousHashMap.what = PMAdapter.this.PMSAX_CLOSE_PROGRESS;
                    PMAdapter.this.mUIHandler.sendMessage(paramAnonymousHashMap);
                }

                public void onGetResultText(String paramAnonymousString) {
                    Message localMessage = PMAdapter.this.mUIHandler.obtainMessage();
                    localMessage.what = PMAdapter.this.SAX_DISPLAY_ERROR;
                    localMessage.obj = paramAnonymousString;
                    PMAdapter.this.mUIHandler.sendMessage(localMessage);
                }
            });
            this.mUIHandler = new Handler() {
                public void handleMessage(Message paramAnonymousMessage) {
                    int i = paramAnonymousMessage.what;
                    i = paramAnonymousMessage.what;
                    if (paramAnonymousMessage.what == PMAdapter.this.PMSAX_UPDATE_ITEM) {
                        PMAdapter.this.tempDatas.add(PMAdapter.this.createPMBean((HashMap) paramAnonymousMessage.obj));
                        if ((PMAdapter.this.mListView != null) && (PMAdapter.this.mDatas != null) && (PMAdapter.this.mDatas.size() > 0) && (PMAdapter.this.mDatas.size() % 3 == 1) && (PMAdapter.this.mDatas.size() < PMAdapter.this.mListView.getLastVisiblePosition() + 3)) {
                            PMAdapter.this.mDatas.addAll(PMAdapter.this.tempDatas);
                            PMAdapter.this.tempDatas.clear();
                            PMAdapter.this.notifyDataSetChanged();
                        }
                        PMAdapter.this.mPMParser.setIsAddFinished(true);
                    }
                    if (paramAnonymousMessage.what == PMAdapter.this.PMSAX_UPDATE_END) {
                        if (PMAdapter.this.tempDatas.size() > 0) {
                            PMAdapter.this.mDatas.addAll(PMAdapter.this.tempDatas);
                            PMAdapter.this.tempDatas.clear();
                        }
                        PMAdapter.this.loadingMore = false;
                        if ((!PMAdapter.this.isFootNeeded()) && (PMAdapter.this.mListView.getFooterViewsCount() > 0)) {
                            PMAdapter.this.mListView.removeFooterView(PMAdapter.this.footlay);
                        }
                        if (PMAdapter.this.mDatas.size() == 0) {
                            PMAdapter.this.mDatas.add(new NoPMView());
                        }
                        PMAdapter.this.mContext.invalidateOptionsMenu();
                        PMAdapter.this.notifyDataSetChanged();
                    }
                    if (paramAnonymousMessage.what == PMAdapter.this.SAX_DISPLAY_ERROR) {
                        paramAnonymousMessage = (String) paramAnonymousMessage.obj;
                        Toast.makeText(PMAdapter.this.mContext, paramAnonymousMessage, 1).show();
                    }
                }
            };
            this.mListView.setFooterDividersEnabled(false);
            this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
                public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {
                    if ((paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3) && (!PMAdapter.this.loadingMore) && (PMAdapter.this.isFootNeeded())) {
                        PMAdapter.this.getbox();
                    }
                }

                public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {
                }
            });
            return;
            GoogleAnalyticsTools.trackPageView(this.mContext, "pm/sent-items", this.forumStatus.getForumId(), this.forumStatus.getUrl());
        }
    }

    private PrivateMessage createPMBean(HashMap paramHashMap) {
        if (paramHashMap == null) {
            return null;
        }
        return PrivateMessage.createPMBean(paramHashMap, this.mContext, this.boxId, this.isInbox, null);
    }

    /* Error */
    private void createPMBeanQuote(HashMap paramHashMap) {
        // Byte code:
        //   0: aload_1
        //   1: ifnonnull +4 -> 5
        //   4: return
        //   5: aload_0
        //   6: getfield 236	com/quoord/tapatalkpro/adapter/forum/PMAdapter:curPm	Lcom/quoord/tapatalkpro/bean/PrivateMessage;
        //   9: new 238	java/lang/String
        //   12: dup
        //   13: aload_1
        //   14: ldc -16
        //   16: invokevirtual 245	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
        //   19: checkcast 247	[B
        //   22: ldc -7
        //   24: invokespecial 252	java/lang/String:<init>	([BLjava/lang/String;)V
        //   27: invokevirtual 256	com/quoord/tapatalkpro/bean/PrivateMessage:setMsgSubject	(Ljava/lang/String;)V
        //   30: aload_1
        //   31: ldc_w 258
        //   34: invokevirtual 262	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
        //   37: ifeq +29 -> 66
        //   40: aload_0
        //   41: getfield 236	com/quoord/tapatalkpro/adapter/forum/PMAdapter:curPm	Lcom/quoord/tapatalkpro/bean/PrivateMessage;
        //   44: new 238	java/lang/String
        //   47: dup
        //   48: aload_1
        //   49: ldc_w 258
        //   52: invokevirtual 245	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
        //   55: checkcast 247	[B
        //   58: ldc -7
        //   60: invokespecial 252	java/lang/String:<init>	([BLjava/lang/String;)V
        //   63: invokevirtual 265	com/quoord/tapatalkpro/bean/PrivateMessage:setTimeString	(Ljava/lang/String;)V
        //   66: ldc_w 267
        //   69: astore_3
        //   70: aload_1
        //   71: ldc_w 269
        //   74: invokevirtual 262	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
        //   77: istore_2
        //   78: iload_2
        //   79: ifeq -75 -> 4
        //   82: new 238	java/lang/String
        //   85: dup
        //   86: aload_1
        //   87: ldc_w 269
        //   90: invokevirtual 245	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
        //   93: checkcast 247	[B
        //   96: invokestatic 275	com/quoord/tapatalkpro/util/Util:parseByteArray	([B)[B
        //   99: ldc -7
        //   101: invokespecial 252	java/lang/String:<init>	([BLjava/lang/String;)V
        //   104: astore_1
        //   105: aload_0
        //   106: getfield 236	com/quoord/tapatalkpro/adapter/forum/PMAdapter:curPm	Lcom/quoord/tapatalkpro/bean/PrivateMessage;
        //   109: aload_1
        //   110: invokevirtual 278	com/quoord/tapatalkpro/bean/PrivateMessage:setTextBody	(Ljava/lang/String;)V
        //   113: return
        //   114: astore_1
        //   115: aload_1
        //   116: invokevirtual 281	java/io/UnsupportedEncodingException:printStackTrace	()V
        //   119: return
        //   120: astore_1
        //   121: aload_1
        //   122: invokevirtual 281	java/io/UnsupportedEncodingException:printStackTrace	()V
        //   125: aload_3
        //   126: astore_1
        //   127: goto -22 -> 105
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	130	0	this	PMAdapter
        //   0	130	1	paramHashMap	HashMap
        //   77	2	2	bool	boolean
        //   69	57	3	str	String
        // Exception table:
        //   from	to	target	type
        //   5	66	114	java/io/UnsupportedEncodingException
        //   70	78	114	java/io/UnsupportedEncodingException
        //   105	113	114	java/io/UnsupportedEncodingException
        //   121	125	114	java/io/UnsupportedEncodingException
        //   82	105	120	java/io/UnsupportedEncodingException
    }

    public void addOnitemLongclickEven() {
        this.mListView.setOnItemLongClickListener(new topicListLongClickListener());
    }

    public void addOnitemclickEven() {
        this.mListView.setOnItemClickListener(this);
    }

    public void changeBackgroud(PrivateMessage paramPrivateMessage, View paramView) {
        int j = 0;
        int i = j;
        if (this.pmActionMode != null) {
            i = j;
            if (this.pmActionMode.pms != null) {
                i = j;
                if (this.pmActionMode.pms.size() != 0) {
                    i = j;
                    if (this.pmActionMode.pms.contains(paramPrivateMessage)) {
                        i = 1;
                    }
                }
            }
        }
        if (i != 0) {
            if (this.mContext.getResources().getBoolean(2131558401)) {
                break label127;
            }
            if (SettingsFragment.isLightTheme(this.mContext)) {
                paramView.setBackgroundColor(this.mContext.getResources().getColor(2131165504));
            }
        } else {
            return;
        }
        paramView.setBackgroundColor(this.mContext.getResources().getColor(2131165509));
        return;
        label127:
        ThemeUtil.setHeightLight(this.mContext, paramView);
    }

    public void clearAll() {
        notifyDataSetChanged();
    }

    public void createDialog(final int paramInt) {
        final PrivateMessage localPrivateMessage = (PrivateMessage) getItem(paramInt);
        final PMDialogAdapter localPMDialogAdapter = new PMDialogAdapter(this.mContext, this.forumStatus);
        new AlertDialog.Builder(this.mContext).setTitle(localPrivateMessage.getMsgSubject()).setAdapter(localPMDialogAdapter, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                if (localPMDialogAdapter.getItem(paramAnonymousInt).equalsIgnoreCase(PMAdapter.this.mContext.getString(2131099816))) {
                    if (PMAdapter.this.forumStatus.isCanSendPm()) {
                        ((ForumActivityStatus) PMAdapter.this.mContext).showProgress();
                        if (PMAdapter.this.forumStatus.getApiLevel() >= 3) {
                            PMAdapter.this.getQuotePm(localPrivateMessage, 2);
                        }
                    }
                }
                while (!localPMDialogAdapter.getItem(paramAnonymousInt).equalsIgnoreCase(PMAdapter.this.mContext.getString(2131099817))) {
                    return;
                    PMAdapter.this.delete_message(paramInt);
                    return;
                }
                PMAdapter.this.delete_message(paramInt);
            }
        }).create().show();
    }

    public void createReplyPMIntent(int paramInt) {
        Intent localIntent = new Intent(this.mContext, CreatePmActivity.class);
        localIntent.putExtra("action", paramInt);
        localIntent.putExtra("pm", getCurPM());
        localIntent.putExtra("forumStatus", this.forumStatus);
        this.mContext.startActivityForResult(localIntent, 11);
    }

    public void deletePm(PrivateMessage paramPrivateMessage) {
        if (((this.mContext instanceof SlidingMenuActivity)) && ((((SlidingMenuActivity) this.mContext).currentFragment instanceof TwoPanelControllerWithId)) && (((TwoPanelControllerWithId) ((SlidingMenuActivity) this.mContext).currentFragment).getIdByTwoPanel() != null) && (((TwoPanelControllerWithId) ((SlidingMenuActivity) this.mContext).currentFragment).getIdByTwoPanel().equals(paramPrivateMessage.getMsgId()))) {
            ((SlidingMenuActivity) this.mContext).setBackStackAnimation(((SlidingMenuActivity) this.mContext).outerFragment);
        }
        delete_message(paramPrivateMessage);
    }

    public void delete_message(int paramInt) {
        ((PrivateMessage) this.mDatas.get(paramInt)).deleteMessage(this);
        this.mDatas.remove(paramInt);
        this.total_message_count -= 1;
        if (this.mDatas.size() == 0) {
            this.mDatas.add(new NoPMView());
        }
        notifyDataSetChanged();
    }

    public void delete_message(PrivateMessage paramPrivateMessage) {
        if (this.mDatas.contains(paramPrivateMessage)) {
            paramPrivateMessage.deleteMessage(this);
            this.mDatas.remove(paramPrivateMessage);
            this.total_message_count -= 1;
            if (this.mDatas.size() == 0) {
                this.mDatas.add(new NoPMView());
            }
            notifyDataSetChanged();
        }
    }

    public void display() {
        if (this.mListView == null) {
            getbox();
        }
    }

    public void forwordPm(PrivateMessage paramPrivateMessage) {
        if (this.forumStatus.isCanSendPm()) {
            ((ForumActivityStatus) this.mContext).showProgress();
            if (this.forumStatus.getApiLevel() >= 3) {
                getQuotePm(paramPrivateMessage, 2);
            }
            return;
        }
        Intent localIntent = new Intent(this.mContext, ProfilesActivity.class);
        localIntent.putExtra("forumStatus", this.forumStatus);
        localIntent.putExtra("userid", paramPrivateMessage.getMsgFromId());
        paramPrivateMessage = paramPrivateMessage.getMsgFrom();
        if (paramPrivateMessage != null) {
            localIntent.putExtra("iconusername", paramPrivateMessage);
            this.mContext.startActivity(localIntent);
            return;
        }
        Toast.makeText(this.mContext, this.mContext.getString(2131099820), 1).show();
    }

    public int getCount() {
        return this.mDatas.size();
    }

    public PrivateMessage getCurPM() {
        return this.curPm;
    }

    public Object getItem(int paramInt) {
        return this.mDatas.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public void getQuotePm(PrivateMessage paramPrivateMessage, int paramInt) {
        this.curAction = paramInt;
        setTryTwice(false);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramPrivateMessage.getMsgId());
        this.curPm = paramPrivateMessage;
        this.engine.call("get_quote_pm", localArrayList);
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        if ((this.mDatas.get(paramInt) instanceof PrivateMessage)) {
            PrivateMessage localPrivateMessage = (PrivateMessage) this.mDatas.get(paramInt);
            localPrivateMessage.setBoxId(this.boxId);
            if ((!(this.mContext instanceof SlidingMenuActivity)) || (!((SlidingMenuActivity) this.mContext).getShowSlectionStatus()) || (paramInt == this.currentSelectedPosition)) {
                if ((!(this.mContext instanceof SlidingMenuActivity)) || (!((SlidingMenuActivity) this.mContext).getShowSlectionStatus())) {
                    break label169;
                }
                if (this.currentSelectedPosition != paramInt) {
                    break label138;
                }
                paramView = localPrivateMessage.getPMView(paramInt, localPrivateMessage, paramView, paramViewGroup, this.mContext, this.isInbox, (ForumActivityStatus) this.mContext, this, true);
            }
            for (; ; ) {
                changeBackgroud(localPrivateMessage, paramView);
                return paramView;
                break;
                label138:
                paramView = localPrivateMessage.getPMView(paramInt, localPrivateMessage, paramView, paramViewGroup, this.mContext, this.isInbox, (ForumActivityStatus) this.mContext, this, false);
                continue;
                label169:
                paramView = localPrivateMessage.getPMView(paramInt, localPrivateMessage, paramView, paramViewGroup, this.mContext, this.isInbox, (ForumActivityStatus) this.mContext, this, false);
            }
        }
        return ((NoPMView) getItem(paramInt)).getItemView(this.mContext);
    }

    public void getbox() {
        this.loadingMore = true;
        setTryTwice(false);
        ArrayList localArrayList = new ArrayList();
        if (this.isInbox) {
            localArrayList.add(this.inboxId);
        }
        for (; ; ) {
            localArrayList.add(Integer.valueOf(this.mStart));
            localArrayList.add(Integer.valueOf(this.mStart + this.mCountPerpage - 1));
            this.engine.saxcall(this.mPMParser, "get_box", localArrayList);
            return;
            localArrayList.add(this.outboxId);
        }
    }

    public void getboxInfo() {
        setTryTwice(false);
        ArrayList localArrayList = new ArrayList();
        this.engine.call("get_box_info", localArrayList);
    }

    public boolean isEnabled(int paramInt) {
        if ((paramInt == this.mDatas.size() - 1) && (isFootNeeded())) {
        }
        while (!(getItem(paramInt) instanceof PrivateMessage)) {
            return false;
        }
        return true;
    }

    public boolean isFootNeeded() {
        return this.mStart < this.total_message_count;
    }

    public void markMessageUnread(int paramInt) {
        setTryTwice(false);
        PrivateMessage localPrivateMessage = (PrivateMessage) this.mDatas.get(paramInt);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localPrivateMessage.getMsgId());
        localPrivateMessage.setMsgState(1);
        notifyDataSetChanged();
        this.engine.call("mark_pm_unread", localArrayList);
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        try {
            if ((this.mListView.getFooterViewsCount() <= 0) || (this.mDatas.size() > 0)) {
                if (paramInt >= this.mDatas.size()) {
                    return;
                }
                paramAdapterView = (PrivateMessage) getItem(paramInt - this.mListView.getHeaderViewsCount());
                paramAdapterView.setMsgState(0);
                paramView = new HashMap();
                paramView.put("forumStatus", this.forumStatus);
                paramView.put("pm", paramAdapterView);
                this.currentSelectedPosition = paramInt;
                ((SlidingMenuActivity) this.mContext).showDetail(new PmContentFragment(false, paramView));
                notifyDataSetChanged();
                if (paramAdapterView.getMsgState() == 1) {
                    ((BackListFragment) ((SlidingMenuActivity) this.mContext).getmFrag()).setChangeIngerface(new BackListFragment.ChangeUnreadNumbers() {
                        public void setUnreadNumbers(BackListAdapter paramAnonymousBackListAdapter) {
                            int i;
                            if ((paramAnonymousBackListAdapter != null) && (paramAnonymousBackListAdapter.tabItemList != null)) {
                                i = 0;
                                if (i < paramAnonymousBackListAdapter.tabItemList.size()) {
                                }
                            } else {
                                paramAnonymousBackListAdapter.notifyDataSetChanged();
                                return;
                            }
                            if (((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).getMenuid() == 1021) {
                                Object localObject = ((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).getTabName();
                                localObject = Pattern.compile("[^0-9]").matcher((CharSequence) localObject);
                                int j = 0;
                                if (!((Matcher) localObject).replaceAll("").trim().equals("")) {
                                    j = Integer.valueOf(((Matcher) localObject).replaceAll("").trim()).intValue() - 1;
                                }
                                if (j <= 0) {
                                    break label180;
                                }
                                ((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).setTabName(PMAdapter.this.mContext.getString(2131099880) + " (" + j + ") ");
                            }
                            for (; ; ) {
                                i += 1;
                                break;
                                label180:
                                ((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).setTabName(PMAdapter.this.mContext.getString(2131099880));
                            }
                        }
                    });
                    ((BackListFragment) ((SlidingMenuActivity) this.mContext).getmFrag()).ChangeUnreadNumbers();
                }
                if (((this.mContext instanceof SlidingMenuActivity)) && ((((SlidingMenuActivity) this.mContext).currentFragment instanceof PMListFragment))) {
                    ((PMListFragment) ((SlidingMenuActivity) this.mContext).currentFragment).setIdByTwoPanel(paramAdapterView.getMsgId());
                }
                paramAdapterView.setMsgState(0);
                notifyDataSetChanged();
                return;
            }
        } catch (Exception paramAdapterView) {
        }
    }

    public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        return true;
    }

    public void parseCallBack(EngineResponse paramEngineResponse) {
        Object localObject = paramEngineResponse.getMethod();
        int i;
        if (((String) localObject).equals("get_box_info")) {
            paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
            if (paramEngineResponse.containsKey("posts")) {
                paramEngineResponse = (Object[]) paramEngineResponse.get("posts");
                if (paramEngineResponse == null) {
                    break label202;
                }
                i = 0;
                if (i < paramEngineResponse.length) {
                    break label94;
                }
                if (!this.isInbox) {
                    break label187;
                }
                this.boxId = this.inboxId;
                getbox();
                label75:
                notifyDataSetChanged();
            }
        }
        label94:
        label151:
        label187:
        label202:
        do {
            return;
            paramEngineResponse = (Object[]) paramEngineResponse.get("list");
            break;
            localObject = (HashMap) paramEngineResponse[i];
            if (((HashMap) localObject).containsKey("box_type")) {
                if (!((String) ((HashMap) localObject).get("box_type")).equals("INBOX")) {
                    break label151;
                }
                this.inboxId = ((String) ((HashMap) localObject).get("box_id"));
            }
            for (; ; ) {
                i += 1;
                break;
                if (((String) ((HashMap) localObject).get("box_type")).equals("SENT")) {
                    this.outboxId = ((String) ((HashMap) localObject).get("box_id"));
                }
            }
            this.boxId = this.outboxId;
            getbox();
            break label75;
            this.mStatus.updateUI(13, null);
            return;
            if (((String) localObject).equals("get_message")) {
                this.curPm = PrivateMessage.createPMBean((HashMap) paramEngineResponse.getResponse(), this.mContext, this.boxId, this.isInbox, this.curPm);
                this.mStatus.closeProgress();
                createReplyPMIntent(this.curAction);
                return;
            }
            if (((String) localObject).equals("get_quote_pm")) {
                if (!paramEngineResponse.isSuccess()) {
                    createReplyPMIntent(this.curAction);
                    return;
                }
                createPMBeanQuote((HashMap) paramEngineResponse.getResponse());
                this.mStatus.closeProgress();
                createReplyPMIntent(this.curAction);
                return;
            }
        }
        while ((!((String) localObject).equals("mark_pm_unread")) || (!(this.mContext instanceof SlidingMenuActivity)));
        ((SlidingMenuActivity) this.mContext).getUnreadNumbers();
    }

    public void refresh() {
        this.mStart = 0;
        this.mDatas.clear();
        if (this.mListView.getFooterViewsCount() <= 0) {
            this.mListView.addFooterView(this.footlay);
        }
        this.loadingMore = true;
        notifyDataSetChanged();
        getbox();
    }

    public void removeItem(int paramInt) {
        notifyDataSetChanged();
    }

    public void replyPm(PrivateMessage paramPrivateMessage) {
        if (this.forumStatus.isCanSendPm()) {
            ((ForumActivityStatus) this.mContext).showProgress();
            if (this.forumStatus.getApiLevel() >= 3) {
                getQuotePm(paramPrivateMessage, 1);
            }
            return;
        }
        ((ForumActivityStatus) this.mContext).showProgress();
        delete_message(this.mLongclickItemPosition);
    }

    public void report_pm(ArrayList paramArrayList) {
        setTryTwice(false);
        this.engine.call("report_pm", paramArrayList);
    }

    public void viewPmProfile(PrivateMessage paramPrivateMessage) {
        Intent localIntent = new Intent(this.mContext, ProfilesActivity.class);
        localIntent.putExtra("forumStatus", this.forumStatus);
        localIntent.putExtra("userid", paramPrivateMessage.getMsgFromId());
        paramPrivateMessage = paramPrivateMessage.getMsgFrom();
        if (paramPrivateMessage != null) {
            localIntent.putExtra("iconusername", paramPrivateMessage);
            this.mContext.startActivity(localIntent);
            return;
        }
        Toast.makeText(this.mContext, this.mContext.getString(2131099820), 1).show();
    }

    class topicListLongClickListener
            implements AdapterView.OnItemLongClickListener {
        topicListLongClickListener() {
        }

        public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
            PMAdapter.this.mLongclickItemPosition = (paramInt - PMAdapter.this.mListView.getHeaderViewsCount());
            if ((PMAdapter.this.getItem(PMAdapter.this.mLongclickItemPosition) instanceof PrivateMessage)) {
                paramAdapterView = (PrivateMessage) PMAdapter.this.getItem(PMAdapter.this.mLongclickItemPosition);
                if (!PMAdapter.this.isInbox) {
                    break label152;
                }
                if (PMAdapter.this.anMode == null) {
                    PMAdapter.this.pmActionMode = new PMActionMode(PMAdapter.this.mContext, paramAdapterView, PMAdapter.this.forumStatus, paramInt, PMAdapter.this, PMAdapter.this.mListView, true);
                    PMAdapter.this.anMode = PMAdapter.this.mContext.startActionMode(PMAdapter.this.pmActionMode);
                    PMAdapter.this.notifyDataSetChanged();
                }
            }
            for (; ; ) {
                return true;
                label152:
                if (PMAdapter.this.anMode == null) {
                    PMAdapter.this.pmActionMode = new PMActionMode(PMAdapter.this.mContext, paramAdapterView, PMAdapter.this.forumStatus, paramInt, PMAdapter.this, PMAdapter.this.mListView, false);
                    PMAdapter.this.anMode = PMAdapter.this.mContext.startActionMode(PMAdapter.this.pmActionMode);
                    PMAdapter.this.notifyDataSetChanged();
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/PMAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */