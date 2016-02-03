package com.quoord.tapatalkpro.activity.forum.conversation;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.quoord.tapatalkpro.action.PMAction;
import com.quoord.tapatalkpro.activity.forum.DrawerLayoutStatus;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.adapter.forum.ForumRootAdapter;
import com.quoord.tapatalkpro.adapter.forum.conversation.ConvController;
import com.quoord.tapatalkpro.adapter.forum.conversation.ConvDetailAdapter;
import com.quoord.tapatalkpro.adapter.forum.conversation.ConvPagerAdapter;
import com.quoord.tapatalkpro.bean.Conversation;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.Participant;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.ics.conversation.ConversationListFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ui.ConversationQuoteHelper;
import com.quoord.tapatalkpro.ui.InviteUserBar;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.BBcodeUtil;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tools.TwoPanelController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ConversationOuterFragment
        extends QuoordFragment
        implements ForumActivityStatus, TryTwiceCallBackInterface, TwoPanelController {
    public static final int MENU_PARTICIPATES = 0;
    private boolean IS_REPLY = false;
    private ActionBar bar;
    public TabConvDetailFragment convFragment = null;
    private String conv_id;
    public Conversation conversation;
    public QuoordFragment currentFragment = null;
    public HashMap dataCache = new HashMap();
    private TapatalkEngine engine;
    private String fid;
    public ForumStatus forumStatus;
    private boolean fromIntent = true;
    private boolean isJumped = false;
    private int jumpPage;
    private int jumpToPosition;
    private ProgressBar loading;
    public Activity mActivity;
    public ConvController mConvController;
    private View mInviteBarView = null;
    public ViewPager mPager;
    private int outer_currentPage;
    public AlertDialog pageListDialog;
    public ConvPagerAdapter pagerAdapter;
    public ParticipatesFragment particiFragment = null;
    private SharedPreferences prefs;
    private LinearLayout progress;
    private LinearLayout quick_lay;
    private RelativeLayout quickbar;
    private EditText quickqeply_text;
    private EditText quickreply_text;
    public ConversationQuoteHelper quoteHelper;
    private ImageView reply;
    private ImageView show_all;
    private String signature = null;
    private String spkey;
    public ConvDetailAdapter tabConvDetailAdapter = null;
    private boolean tryTwice = false;

    public ConversationOuterFragment() {
    }

    public ConversationOuterFragment(boolean paramBoolean, HashMap paramHashMap) {
        this.fromIntent = paramBoolean;
        if (paramHashMap.containsKey("forumStatus")) {
            this.forumStatus = ((ForumStatus) paramHashMap.get("forumStatus"));
        }
        if (paramHashMap.containsKey("conversation")) {
            this.conversation = ((Conversation) paramHashMap.get("conversation"));
        }
        if (paramHashMap.containsKey("conv_id")) {
            this.conv_id = ((String) paramHashMap.get("conv_id"));
        }
        if (paramHashMap.containsKey("spkey")) {
            this.spkey = ((String) paramHashMap.get("spkey"));
        }
        if (paramHashMap.containsKey("fid")) {
            this.fid = ((String) paramHashMap.get("fid"));
        }
    }

    private void initInviteBar(ArrayList<HashMap<String, String>> paramArrayList) {
        InviteUserBar localInviteUserBar = new InviteUserBar();
        localInviteUserBar.setActivity(this.mActivity);
        localInviteUserBar.setForumStatus(this.forumStatus);
        localInviteUserBar.setUserInfo(paramArrayList);
        localInviteUserBar.setInviteBarView(this.mInviteBarView);
        localInviteUserBar.process();
    }

    public void RefreshDatas() {
        this.mInviteBarView.setVisibility(8);
        if (this.quickreply_text != null) {
            this.quickreply_text.setText("");
        }
        if (this.pagerAdapter.mPageReferenceConvMap != null) {
            if ((this.mConvController.getPageNum() - 1 <= this.outer_currentPage) || (this.pagerAdapter.mPageReferenceConvMap.get(Integer.valueOf(this.outer_currentPage)) == null)) {
                break label186;
            }
            ((TabConvDetailFragment) this.pagerAdapter.mPageReferenceConvMap.get(Integer.valueOf(this.outer_currentPage + 1))).tabConvDetailAdapter.converId.clear();
            ((TabConvDetailFragment) this.pagerAdapter.mPageReferenceConvMap.get(Integer.valueOf(this.outer_currentPage + 1))).tabConvDetailAdapter.refresh();
            if (((TabConvDetailFragment) this.pagerAdapter.mPageReferenceConvMap.get(Integer.valueOf(this.outer_currentPage))).progress != null) {
                ((TabConvDetailFragment) this.pagerAdapter.mPageReferenceConvMap.get(Integer.valueOf(this.outer_currentPage + 1))).progress.setVisibility(0);
            }
        }
        label186:
        do {
            do {
                return;
            } while (this.pagerAdapter.mPageReferenceConvMap.get(Integer.valueOf(this.outer_currentPage)) == null);
            ((TabConvDetailFragment) this.pagerAdapter.mPageReferenceConvMap.get(Integer.valueOf(this.outer_currentPage))).tabConvDetailAdapter.converId.clear();
            ((TabConvDetailFragment) this.pagerAdapter.mPageReferenceConvMap.get(Integer.valueOf(this.outer_currentPage))).tabConvDetailAdapter.refresh();
        }
        while (((TabConvDetailFragment) this.pagerAdapter.mPageReferenceConvMap.get(Integer.valueOf(this.outer_currentPage))).progress == null);
        ((TabConvDetailFragment) this.pagerAdapter.mPageReferenceConvMap.get(Integer.valueOf(this.outer_currentPage))).progress.setVisibility(0);
    }

    public void ReplyConversation(ArrayList paramArrayList, Conversation paramConversation) {
        setTryTwice(false);
        ArrayList localArrayList = new ArrayList();
        this.conversation = paramConversation;
        paramConversation = paramConversation.partcipated.keySet().iterator();
        for (; ; ) {
            if (!paramConversation.hasNext()) {
                this.engine.call("reply_conversation", paramArrayList);
                return;
            }
            String str = (String) paramConversation.next();
            if (!str.equalsIgnoreCase(this.forumStatus.getUserId())) {
                localArrayList.add(str);
            }
        }
    }

    /* Error */
    public void callBack(com.quoord.tapatalkpro.bean.EngineResponse paramEngineResponse) {
        // Byte code:
        //   0: aload_1
        //   1: aload_0
        //   2: invokevirtual 301	com/quoord/tapatalkpro/activity/forum/conversation/ConversationOuterFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
        //   5: aload_0
        //   6: getfield 123	com/quoord/tapatalkpro/activity/forum/conversation/ConversationOuterFragment:forumStatus	Lcom/quoord/tapatalkpro/bean/ForumStatus;
        //   9: aload_0
        //   10: getfield 268	com/quoord/tapatalkpro/activity/forum/conversation/ConversationOuterFragment:engine	Lcom/quoord/tapatalkpro/util/TapatalkEngine;
        //   13: aload_0
        //   14: invokevirtual 304	com/quoord/tapatalkpro/activity/forum/conversation/ConversationOuterFragment:isOpCancel	()Z
        //   17: aload_0
        //   18: invokestatic 310	com/quoord/tapatalkpro/action/CallBackChecker:checkCallBack	(Lcom/quoord/tapatalkpro/bean/EngineResponse;Landroid/app/Activity;Lcom/quoord/tapatalkpro/bean/ForumStatus;Lcom/quoord/tapatalkpro/util/TapatalkEngine;ZLcom/quoord/tapatalkpro/adapter/TryTwiceCallBackInterface;)Z
        //   21: ifeq +503 -> 524
        //   24: aload_1
        //   25: invokevirtual 315	com/quoord/tapatalkpro/bean/EngineResponse:getMethod	()Ljava/lang/String;
        //   28: ldc_w 270
        //   31: invokevirtual 318	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   34: ifeq +490 -> 524
        //   37: aload_1
        //   38: invokevirtual 321	com/quoord/tapatalkpro/bean/EngineResponse:getResponse	()Ljava/lang/Object;
        //   41: checkcast 103	java/util/HashMap
        //   44: astore 4
        //   46: aload 4
        //   48: ldc_w 323
        //   51: invokevirtual 119	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
        //   54: checkcast 325	java/lang/Boolean
        //   57: astore 5
        //   59: ldc -65
        //   61: astore_3
        //   62: new 131	java/lang/String
        //   65: dup
        //   66: aload 4
        //   68: ldc_w 327
        //   71: invokevirtual 119	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
        //   74: checkcast 329	[B
        //   77: ldc_w 331
        //   80: invokespecial 334	java/lang/String:<init>	([BLjava/lang/String;)V
        //   83: astore 4
        //   85: aload 4
        //   87: astore_3
        //   88: aload 5
        //   90: invokevirtual 337	java/lang/Boolean:booleanValue	()Z
        //   93: ifeq +573 -> 666
        //   96: aload_0
        //   97: invokevirtual 301	com/quoord/tapatalkpro/activity/forum/conversation/ConversationOuterFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
        //   100: iconst_0
        //   101: invokevirtual 342	android/support/v4/app/FragmentActivity:dismissDialog	(I)V
        //   104: aload_1
        //   105: invokevirtual 321	com/quoord/tapatalkpro/bean/EngineResponse:getResponse	()Ljava/lang/Object;
        //   108: checkcast 103	java/util/HashMap
        //   111: astore 6
        //   113: aload_0
        //   114: getfield 123	com/quoord/tapatalkpro/activity/forum/conversation/ConversationOuterFragment:forumStatus	Lcom/quoord/tapatalkpro/bean/ForumStatus;
        //   117: invokevirtual 345	com/quoord/tapatalkpro/bean/ForumStatus:isPush	()Z
        //   120: ifne +404 -> 524
        //   123: aload_0
        //   124: invokevirtual 301	com/quoord/tapatalkpro/activity/forum/conversation/ConversationOuterFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
        //   127: invokevirtual 349	android/support/v4/app/FragmentActivity:getApplicationContext	()Landroid/content/Context;
        //   130: invokevirtual 355	android/content/Context:getResources	()Landroid/content/res/Resources;
        //   133: ldc_w 356
        //   136: invokevirtual 362	android/content/res/Resources:getBoolean	(I)Z
        //   139: ifne +385 -> 524
        //   142: new 103	java/util/HashMap
        //   145: dup
        //   146: invokespecial 104	java/util/HashMap:<init>	()V
        //   149: pop
        //   150: aload 6
        //   152: ldc_w 323
        //   155: invokevirtual 119	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
        //   158: checkcast 325	java/lang/Boolean
        //   161: invokevirtual 337	java/lang/Boolean:booleanValue	()Z
        //   164: ifeq +360 -> 524
        //   167: ldc -65
        //   169: astore_1
        //   170: aload_1
        //   171: astore_3
        //   172: aload 6
        //   174: ldc_w 364
        //   177: invokevirtual 115	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
        //   180: ifeq +27 -> 207
        //   183: aload 6
        //   185: ldc_w 364
        //   188: invokevirtual 119	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
        //   191: checkcast 229	java/util/ArrayList
        //   194: astore_3
        //   195: iconst_0
        //   196: istore_2
        //   197: iload_2
        //   198: aload_3
        //   199: invokevirtual 367	java/util/ArrayList:size	()I
        //   202: if_icmplt +333 -> 535
        //   205: aload_1
        //   206: astore_3
        //   207: aconst_null
        //   208: astore 5
        //   210: aconst_null
        //   211: astore 4
        //   213: aload 5
        //   215: astore_1
        //   216: aload 6
        //   218: ldc_w 369
        //   221: invokevirtual 115	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
        //   224: ifeq +44 -> 268
        //   227: aload 5
        //   229: astore_1
        //   230: aload 6
        //   232: ldc_w 369
        //   235: invokevirtual 115	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
        //   238: ifeq +30 -> 268
        //   241: aload 6
        //   243: ldc_w 369
        //   246: invokevirtual 119	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
        //   249: checkcast 229	java/util/ArrayList
        //   252: astore 5
        //   254: iconst_0
        //   255: istore_2
        //   256: aload 4
        //   258: astore_1
        //   259: iload_2
        //   260: aload 5
        //   262: invokevirtual 367	java/util/ArrayList:size	()I
        //   265: if_icmplt +330 -> 595
        //   268: new 371	java/lang/StringBuilder
        //   271: dup
        //   272: getstatic 376	com/quoord/tapatalkpro/util/TapatalkJsonEngine:LOG_CONV	Ljava/lang/String;
        //   275: invokestatic 379	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   278: invokespecial 382	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   281: ldc_w 384
        //   284: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   287: ldc_w 390
        //   290: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   293: aload_0
        //   294: getfield 123	com/quoord/tapatalkpro/activity/forum/conversation/ConversationOuterFragment:forumStatus	Lcom/quoord/tapatalkpro/bean/ForumStatus;
        //   297: invokevirtual 393	com/quoord/tapatalkpro/bean/ForumStatus:getForumId	()Ljava/lang/String;
        //   300: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   303: ldc_w 395
        //   306: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   309: aload_0
        //   310: invokevirtual 301	com/quoord/tapatalkpro/activity/forum/conversation/ConversationOuterFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
        //   313: invokestatic 401	com/quoord/tapatalkpro/util/Util:getMacAddress	(Landroid/content/Context;)Ljava/lang/String;
        //   316: invokestatic 405	com/quoord/tapatalkpro/util/Util:getMD5	(Ljava/lang/String;)Ljava/lang/String;
        //   319: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   322: ldc_w 407
        //   325: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   328: aload_0
        //   329: getfield 123	com/quoord/tapatalkpro/activity/forum/conversation/ConversationOuterFragment:forumStatus	Lcom/quoord/tapatalkpro/bean/ForumStatus;
        //   332: getfield 411	com/quoord/tapatalkpro/bean/ForumStatus:tapatalkForum	Lcom/quoord/tapatalkpro/bean/TapatalkForum;
        //   335: invokevirtual 416	com/quoord/tapatalkpro/bean/TapatalkForum:getUserName	()Ljava/lang/String;
        //   338: ldc_w 418
        //   341: invokestatic 424	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   344: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   347: ldc_w 426
        //   350: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   353: aload_0
        //   354: getfield 123	com/quoord/tapatalkpro/activity/forum/conversation/ConversationOuterFragment:forumStatus	Lcom/quoord/tapatalkpro/bean/ForumStatus;
        //   357: invokevirtual 284	com/quoord/tapatalkpro/bean/ForumStatus:getUserId	()Ljava/lang/String;
        //   360: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   363: ldc_w 428
        //   366: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   369: aload 6
        //   371: ldc -127
        //   373: invokevirtual 119	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
        //   376: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   379: ldc_w 433
        //   382: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   385: aload 6
        //   387: ldc_w 435
        //   390: invokevirtual 119	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
        //   393: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   396: ldc_w 437
        //   399: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   402: aload_3
        //   403: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   406: ldc_w 439
        //   409: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   412: aload_1
        //   413: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   416: invokevirtual 442	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   419: astore_3
        //   420: aload_3
        //   421: astore_1
        //   422: aload 6
        //   424: ldc_w 444
        //   427: invokevirtual 119	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
        //   430: ifnull +41 -> 471
        //   433: new 371	java/lang/StringBuilder
        //   436: dup
        //   437: aload_3
        //   438: invokestatic 379	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   441: invokespecial 382	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   444: ldc_w 446
        //   447: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   450: aload 6
        //   452: ldc_w 444
        //   455: invokevirtual 119	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
        //   458: checkcast 131	java/lang/String
        //   461: invokestatic 448	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
        //   464: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   467: invokevirtual 442	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   470: astore_1
        //   471: aload_0
        //   472: invokevirtual 301	com/quoord/tapatalkpro/activity/forum/conversation/ConversationOuterFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
        //   475: aload_1
        //   476: invokestatic 452	com/quoord/tapatalkpro/util/TapatalkJsonEngine:callLogin	(Landroid/content/Context;Ljava/lang/String;)V
        //   479: aload_0
        //   480: getfield 454	com/quoord/tapatalkpro/activity/forum/conversation/ConversationOuterFragment:loading	Landroid/widget/ProgressBar;
        //   483: bipush 8
        //   485: invokevirtual 457	android/widget/ProgressBar:setVisibility	(I)V
        //   488: aload_0
        //   489: getfield 459	com/quoord/tapatalkpro/activity/forum/conversation/ConversationOuterFragment:reply	Landroid/widget/ImageView;
        //   492: iconst_0
        //   493: invokevirtual 462	android/widget/ImageView:setVisibility	(I)V
        //   496: aload_0
        //   497: invokevirtual 301	com/quoord/tapatalkpro/activity/forum/conversation/ConversationOuterFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
        //   500: aload_0
        //   501: getfield 162	com/quoord/tapatalkpro/activity/forum/conversation/ConversationOuterFragment:mActivity	Landroid/app/Activity;
        //   504: invokevirtual 465	android/app/Activity:getResources	()Landroid/content/res/Resources;
        //   507: ldc_w 466
        //   510: invokevirtual 470	android/content/res/Resources:getString	(I)Ljava/lang/String;
        //   513: iconst_1
        //   514: invokestatic 476	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
        //   517: invokevirtual 479	android/widget/Toast:show	()V
        //   520: aload_0
        //   521: invokevirtual 481	com/quoord/tapatalkpro/activity/forum/conversation/ConversationOuterFragment:RefreshDatas	()V
        //   524: return
        //   525: astore 4
        //   527: aload 4
        //   529: invokevirtual 484	java/lang/Exception:printStackTrace	()V
        //   532: goto -444 -> 88
        //   535: aload_3
        //   536: ldc -65
        //   538: invokevirtual 485	java/util/ArrayList:equals	(Ljava/lang/Object;)Z
        //   541: ifeq +19 -> 560
        //   544: aload_3
        //   545: iload_2
        //   546: invokevirtual 488	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   549: checkcast 131	java/lang/String
        //   552: astore_1
        //   553: iload_2
        //   554: iconst_1
        //   555: iadd
        //   556: istore_2
        //   557: goto -360 -> 197
        //   560: new 371	java/lang/StringBuilder
        //   563: dup
        //   564: aload_1
        //   565: invokestatic 379	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   568: invokespecial 382	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   571: ldc_w 490
        //   574: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   577: aload_3
        //   578: iload_2
        //   579: invokevirtual 488	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   582: checkcast 131	java/lang/String
        //   585: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   588: invokevirtual 442	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   591: astore_1
        //   592: goto -39 -> 553
        //   595: aload 5
        //   597: ldc -65
        //   599: invokevirtual 485	java/util/ArrayList:equals	(Ljava/lang/Object;)Z
        //   602: ifeq +20 -> 622
        //   605: aload 5
        //   607: iload_2
        //   608: invokevirtual 488	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   611: checkcast 131	java/lang/String
        //   614: astore_1
        //   615: iload_2
        //   616: iconst_1
        //   617: iadd
        //   618: istore_2
        //   619: goto -360 -> 259
        //   622: new 371	java/lang/StringBuilder
        //   625: dup
        //   626: aload_1
        //   627: invokestatic 379	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   630: invokespecial 382	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   633: ldc_w 490
        //   636: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   639: aload 5
        //   641: iload_2
        //   642: invokevirtual 488	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   645: checkcast 131	java/lang/String
        //   648: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   651: invokevirtual 442	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   654: astore_1
        //   655: goto -40 -> 615
        //   658: astore_1
        //   659: aload_1
        //   660: invokevirtual 491	java/io/UnsupportedEncodingException:printStackTrace	()V
        //   663: goto -184 -> 479
        //   666: aload_0
        //   667: getfield 454	com/quoord/tapatalkpro/activity/forum/conversation/ConversationOuterFragment:loading	Landroid/widget/ProgressBar;
        //   670: bipush 8
        //   672: invokevirtual 457	android/widget/ProgressBar:setVisibility	(I)V
        //   675: aload_0
        //   676: getfield 459	com/quoord/tapatalkpro/activity/forum/conversation/ConversationOuterFragment:reply	Landroid/widget/ImageView;
        //   679: iconst_0
        //   680: invokevirtual 462	android/widget/ImageView:setVisibility	(I)V
        //   683: aload_0
        //   684: getfield 93	com/quoord/tapatalkpro/activity/forum/conversation/ConversationOuterFragment:tabConvDetailAdapter	Lcom/quoord/tapatalkpro/adapter/forum/conversation/ConvDetailAdapter;
        //   687: getfield 227	com/quoord/tapatalkpro/adapter/forum/conversation/ConvDetailAdapter:converId	Ljava/util/ArrayList;
        //   690: invokevirtual 232	java/util/ArrayList:clear	()V
        //   693: aload_0
        //   694: invokevirtual 301	com/quoord/tapatalkpro/activity/forum/conversation/ConversationOuterFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
        //   697: aload_3
        //   698: iconst_1
        //   699: invokestatic 476	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
        //   702: invokevirtual 479	android/widget/Toast:show	()V
        //   705: return
        //   706: astore_3
        //   707: goto -603 -> 104
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	710	0	this	ConversationOuterFragment
        //   0	710	1	paramEngineResponse	com.quoord.tapatalkpro.bean.EngineResponse
        //   196	446	2	i	int
        //   61	637	3	localObject1	Object
        //   706	1	3	localException1	Exception
        //   44	213	4	localObject2	Object
        //   525	3	4	localException2	Exception
        //   57	583	5	localObject3	Object
        //   111	340	6	localHashMap	HashMap
        // Exception table:
        //   from	to	target	type
        //   62	85	525	java/lang/Exception
        //   268	420	658	java/io/UnsupportedEncodingException
        //   422	471	658	java/io/UnsupportedEncodingException
        //   471	479	658	java/io/UnsupportedEncodingException
        //   96	104	706	java/lang/Exception
    }

    public void closeProgress() {
        try {
            getActivity().dismissDialog(0);
            return;
        } catch (Exception localException) {
        }
    }

    public void getActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        if (paramInt1 == 31) {
            this.convFragment.tabConvDetailAdapter.refresh();
        }
        label16:
        do {
            do {
                do {
                    break label16;
                    do {
                        return;
                    } while (paramInt1 != 53);
                    if (paramInt2 != 29) {
                        break;
                    }
                    if ((this.mActivity instanceof SlidingMenuActivity)) {
                        ((SlidingMenuActivity) this.mActivity).removeDetail(this);
                    }
                } while (!(this.currentFragment instanceof ConversationListFragment));
                ((ConversationListFragment) this.currentFragment).adapter.refresh();
                return;
                if (paramInt2 != 26) {
                    break;
                }
            } while (!(this.currentFragment instanceof ConversationListFragment));
            ((ConversationListFragment) this.currentFragment).adapter.refresh();
            return;
        }
        while ((paramInt2 != 27) || (this.pagerAdapter == null) || (this.pagerAdapter.mPageReferenceConvMap == null) || (this.mConvController == null) || (this.pagerAdapter.mPageReferenceConvMap.get(Integer.valueOf(this.mConvController.getPageNum() - 1)) == null) || (((TabConvDetailFragment) this.pagerAdapter.mPageReferenceConvMap.get(Integer.valueOf(this.mConvController.getPageNum() - 1))).tabConvDetailAdapter == null));
        ((TabConvDetailFragment) this.pagerAdapter.mPageReferenceConvMap.get(Integer.valueOf(this.mConvController.getPageNum() - 1))).tabConvDetailAdapter.converId.clear();
        ((TabConvDetailFragment) this.pagerAdapter.mPageReferenceConvMap.get(Integer.valueOf(this.mConvController.getPageNum() - 1))).tabConvDetailAdapter.refresh();
        ((TabConvDetailFragment) this.pagerAdapter.mPageReferenceConvMap.get(Integer.valueOf(this.mConvController.getPageNum() - 1))).progress.setVisibility(0);
    }

    public BaseAdapter getAdapter() {
        return null;
    }

    public int getCurrentPageNum() {
        return this.outer_currentPage;
    }

    public Activity getDefaultActivity() {
        return getActivity();
    }

    public ForumActivityStatus getForumActivityStatus() {
        return this;
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
        if ((this.convFragment != null) && (this.convFragment.tabConvDetailAdapter != null)) {
            return this.convFragment.tabConvDetailAdapter.currentScrollState;
        }
        return 0;
    }

    public boolean getTryTwice() {
        return this.tryTwice;
    }

    public boolean isOpCancel() {
        return false;
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.prefs = Prefs.get(getActivity());
        if (this.fromIntent) {
            this.forumStatus = ((ForumStatus) getActivity().getIntent().getSerializableExtra("forumStatus"));
            this.conv_id = getActivity().getIntent().getStringExtra("conv_id");
            this.fid = getActivity().getIntent().getStringExtra("fid");
            if ((getActivity().getIntent().hasExtra("notification")) || (getActivity().getIntent().hasExtra("fromWidget"))) {
                this.forumStatus.setLogin(true);
            }
            this.conversation = ((Conversation) getActivity().getIntent().getSerializableExtra("conversation"));
            this.spkey = getActivity().getIntent().getStringExtra("spkey");
        }
        if (this.conversation == null) {
            this.conversation = new Conversation();
            this.conversation.setConv_id(this.conv_id);
        }
        if (paramBundle != null) {
            this.forumStatus = ((ForumStatus) paramBundle.getSerializable("forumStatus"));
            this.conv_id = paramBundle.getString("conv_id");
            this.fid = paramBundle.getString("fid");
            this.conversation = ((Conversation) paramBundle.getSerializable("conversation"));
            this.spkey = paramBundle.getString("spkey");
        }
        if ((this.engine == null) && (this.forumStatus != null)) {
            this.engine = new TapatalkEngine(this, this.forumStatus, getActivity());
        }
        if (this.conversation != null) {
            this.mConvController = new ConvController(this.conversation, getActivity());
            this.mConvController.setCountPerPage(SettingsFragment.getPostPerPageChoice(getActivity()));
            this.mConvController.setTotal_post_num(0);
        }
        paramBundle = getActivity();
        getActivity();
        paramBundle = paramBundle.getSharedPreferences("notification", 0).edit();
        paramBundle.remove(this.spkey);
        paramBundle.commit();
        this.convFragment = TabConvDetailFragment.newInstance(0, true);
        showQuickReply();
        if ((this.forumStatus != null) && (this.conversation != null) && (this.convFragment != null)) {
            this.tabConvDetailAdapter = new ConvDetailAdapter(this.forumStatus.getUrl(), this.conversation, this, this.convFragment, true, 0);
            this.quoteHelper = new ConversationQuoteHelper(this, this.forumStatus);
        }
        if ((getActivity() instanceof SlidingMenuActivity)) {
            this.currentFragment = ((QuoordFragment) ((SlidingMenuActivity) getActivity()).currentFragment);
        }
        this.convFragment.tabConvDetailAdapter = this.tabConvDetailAdapter;
        this.mPager.setOffscreenPageLimit(2);
        this.pagerAdapter = new ConvPagerAdapter(getActivity().getSupportFragmentManager(), null);
        this.pagerAdapter.mPageReferenceConvMap.put(Integer.valueOf(0), this.convFragment);
        this.mPager.setAdapter(this.pagerAdapter);
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        getActivityResult(paramInt1, paramInt2, paramIntent);
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }

    public void onCreate(Bundle paramBundle) {
        this.mActivity = getActivity();
        setActionBar(this.mActivity);
        super.onCreate(paramBundle);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903120, paramViewGroup, false);
        this.mPager = ((ViewPager) paramLayoutInflater.findViewById(2131230971));
        this.quickbar = ((RelativeLayout) paramLayoutInflater.findViewById(2131230970));
        this.quick_lay = ((LinearLayout) this.quickbar.findViewById(2131231655));
        this.show_all = ((ImageView) this.quickbar.findViewById(2131231656));
        this.reply = ((ImageView) this.quickbar.findViewById(2131231661));
        this.loading = ((ProgressBar) this.quickbar.findViewById(2131230844));
        this.quickreply_text = ((EditText) this.quickbar.findViewById(2131231657));
        this.progress = ((LinearLayout) paramLayoutInflater.findViewById(2131230891));
        this.show_all.setImageResource(ThemeUtil.getDrawableIdByPicName("menu_expand", getActivity()));
        this.reply.setImageResource(ThemeUtil.getDrawableIdByPicName("menu_send", getActivity()));
        this.quick_lay.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("thread_bottom_background", getActivity()));
        this.mInviteBarView = paramLayoutInflater.findViewById(2131230969);
        return paramLayoutInflater;
    }

    public void onDestroy() {
        if (this.convFragment.tabConvDetailAdapter != null) {
            this.convFragment.tabConvDetailAdapter.destroy();
        }
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
        }
        for (; ; ) {
            return super.onOptionsItemSelected(paramMenuItem);
            paramMenuItem = new Intent(getActivity(), ParticipatesActivity.class);
            Bundle localBundle = new Bundle();
            localBundle.putSerializable("raw_parts", this.convFragment.tabConvDetailAdapter.raw_parts);
            localBundle.putBoolean("can_invite", this.convFragment.tabConvDetailAdapter.can_invite);
            localBundle.putSerializable("conversation", this.conversation);
            localBundle.putBoolean("can_upload", this.convFragment.tabConvDetailAdapter.can_upload);
            localBundle.putSerializable("forumStatus", this.forumStatus);
            paramMenuItem.putExtras(localBundle);
            startActivityForResult(paramMenuItem, 53);
            return true;
            RefreshDatas();
            return true;
            paramMenuItem = new Intent(getActivity(), CreateOrReplyConversationActivity.class);
            new Bundle();
            paramMenuItem.putExtra("conv", this.conversation);
            paramMenuItem.putExtra("conv_id", this.conversation.getConv_id());
            paramMenuItem.putExtra("count", this.conversation.getReply_count());
            paramMenuItem.putExtra("forumStatus", this.forumStatus);
            paramMenuItem.putExtra("can_upload", this.convFragment.tabConvDetailAdapter.can_upload);
            this.IS_REPLY = true;
            paramMenuItem.putExtra("is_reply", this.IS_REPLY);
            startActivityForResult(paramMenuItem, 53);
            return true;
            this.conversation.setNew_post(true);
            new PMAction(this.mActivity, this.forumStatus).markConsUnread(this.conversation);
            if ((this.mActivity instanceof SlidingMenuActivity)) {
                ((SlidingMenuActivity) this.mActivity).removeDetail(this);
            }
            if ((this.mActivity instanceof ConverSationActivity)) {
                this.mActivity.finish();
            }
        }
    }

    public void onPause() {
        if ((this.convFragment != null) && (this.convFragment.tabConvDetailAdapter != null) && (this.convFragment.tabConvDetailAdapter.partiNameList != null)) {
            this.convFragment.tabConvDetailAdapter.partiNameList.removeAll(this.convFragment.tabConvDetailAdapter.partiNameList);
        }
        super.onPause();
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        paramMenu.removeGroup(0);
        if (((getActivity() instanceof DrawerLayoutStatus)) && (((DrawerLayoutStatus) getActivity()).isDrawMenuOpen())) {
            return;
        }
        MenuItem localMenuItem = paramMenu.add(0, 0, 0, getActivity().getString(2131100167));
        localMenuItem.setIcon(ThemeUtil.getMenuIconByPicName("conversation_icon", getActivity()));
        localMenuItem.setShowAsAction(2);
        paramMenu.add(0, 38, 1, getString(2131099815)).setShowAsAction(0);
        if ((this.conversation != null) && (!this.conversation.isNew_post()) && (this.forumStatus.isMarkCsUnread())) {
            paramMenu.add(0, 27, 0, getString(2131099818)).setIcon(ThemeUtil.getMenuIconByPicName("bubble_mark_unread", getActivity())).setShowAsAction(0);
        }
        paramMenu.add(0, 34, 1, getString(2131099796)).setIcon(ThemeUtil.getMenuIconByPicName("menu_refresh_new", getActivity())).setShowAsAction(2);
    }

    public void onResume() {
        super.onResume();
        if (this.quoteHelper != null) {
            this.quoteHelper.setFirst(true);
        }
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putSerializable("forumStatus", this.forumStatus);
        paramBundle.putString("conv_id", this.conv_id);
        paramBundle.putString("spkey", this.spkey);
        paramBundle.putSerializable("conversation", this.conversation);
        paramBundle.putString("fid", this.fid);
    }

    public void quickReply() {
        if (this.quickreply_text.getText().toString().length() == 0) {
            Toast.makeText(getActivity(), getActivity().getString(2131099779), 1).show();
            return;
        }
        this.signature = SettingsFragment.getSingature(getActivity(), this.forumStatus.getSigType(), this.forumStatus);
        ArrayList localArrayList = new ArrayList();
        String str = this.quickreply_text.getText().toString();
        Object localObject = str;
        if (this.forumStatus.isSupportEmoji()) {
            localObject = BBcodeUtil.parseAllForumPublicSmileToEmojiBBCode(str);
        }
        if ((this.forumStatus.isSupportSignature()) && (this.signature != null) && (this.signature.length() > 0)) {
        }
        for (localObject = (localObject + "\n\n" + this.signature + "\n\n").getBytes(); ; localObject = ((String) localObject).getBytes()) {
            localArrayList.add(this.conversation.getConv_id());
            localArrayList.add(localObject);
            ReplyConversation(localArrayList, this.conversation);
            this.quickreply_text.setText("");
            this.loading.setVisibility(0);
            this.reply.setVisibility(8);
            ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.quickreply_text.getWindowToken(), 0);
            return;
        }
    }

    public void setActionBar(Activity paramActivity) {
        if (this.bar == null) {
            this.bar = paramActivity.getActionBar();
        }
        this.bar.setTitle("");
        this.bar.setDisplayShowTitleEnabled(false);
        this.bar.setDisplayShowHomeEnabled(true);
        this.bar.setDisplayHomeAsUpEnabled(true);
        this.bar.setNavigationMode(0);
    }

    public void setConvMembers(HashMap<String, Participant> paramHashMap) {
        ArrayList localArrayList = new ArrayList();
        paramHashMap = paramHashMap.entrySet().iterator();
        for (; ; ) {
            if (!paramHashMap.hasNext()) {
                initInviteBar(localArrayList);
                return;
            }
            Participant localParticipant = (Participant) ((Map.Entry) paramHashMap.next()).getValue();
            HashMap localHashMap = new HashMap();
            localHashMap.put("userid", localParticipant.getUserId());
            localHashMap.put("username", localParticipant.getUserName());
            localArrayList.add(localHashMap);
        }
    }

    public void setConvPagerAdapterAndPosition(int paramInt1, TabConvDetailFragment paramTabConvDetailFragment, int paramInt2, int paramInt3, final boolean paramBoolean) {
        this.progress.setVisibility(8);
        this.mPager.setVisibility(0);
        this.outer_currentPage = paramInt1;
        setJumpPage(paramInt2);
        setJumpToPosition(paramInt3);
        paramTabConvDetailFragment.detailFragment_CurrentPage = this.outer_currentPage;
        this.mPager.setOffscreenPageLimit(2);
        if (this.pagerAdapter != null) {
            this.pagerAdapter.setTopicController(this.mConvController);
        }
        this.pagerAdapter.notifyDataSetChanged();
        this.mPager.setCurrentItem(this.outer_currentPage);
        this.mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int paramAnonymousInt) {
            }

            public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {
            }

            public void onPageSelected(int paramAnonymousInt) {
                ConversationOuterFragment.this.outer_currentPage = paramAnonymousInt;
                if ((paramBoolean) && (!ConversationOuterFragment.this.isJumped)) {
                    ConversationOuterFragment.this.isJumped = true;
                }
                if ((ConversationOuterFragment.this.pagerAdapter != null) && (ConversationOuterFragment.this.pagerAdapter.mPageReferenceConvMap.get(Integer.valueOf(paramAnonymousInt)) != null) && (((TabConvDetailFragment) ConversationOuterFragment.this.pagerAdapter.mPageReferenceConvMap.get(Integer.valueOf(paramAnonymousInt))).tabConvDetailAdapter != null)) {
                    ((TabConvDetailFragment) ConversationOuterFragment.this.pagerAdapter.mPageReferenceConvMap.get(Integer.valueOf(paramAnonymousInt))).getPageData(ConversationOuterFragment.this.outer_currentPage);
                }
                if ((ConversationOuterFragment.this.pagerAdapter != null) && (ConversationOuterFragment.this.pagerAdapter.mPageReferenceConvMap.get(Integer.valueOf(paramAnonymousInt + 1)) != null) && (((TabConvDetailFragment) ConversationOuterFragment.this.pagerAdapter.mPageReferenceConvMap.get(Integer.valueOf(paramAnonymousInt + 1))).tabConvDetailAdapter != null)) {
                    ((TabConvDetailFragment) ConversationOuterFragment.this.pagerAdapter.mPageReferenceConvMap.get(Integer.valueOf(paramAnonymousInt + 1))).tabConvDetailAdapter.checkImages();
                }
                if ((ConversationOuterFragment.this.pagerAdapter != null) && (ConversationOuterFragment.this.pagerAdapter.mPageReferenceConvMap.get(Integer.valueOf(paramAnonymousInt - 1)) != null) && (((TabConvDetailFragment) ConversationOuterFragment.this.pagerAdapter.mPageReferenceConvMap.get(Integer.valueOf(paramAnonymousInt - 1))).tabConvDetailAdapter != null)) {
                    ((TabConvDetailFragment) ConversationOuterFragment.this.pagerAdapter.mPageReferenceConvMap.get(Integer.valueOf(paramAnonymousInt - 1))).tabConvDetailAdapter.checkImages();
                }
            }
        });
        this.pagerAdapter.notifyDataSetChanged();
    }

    public void setCurrentPage(int paramInt) {
        this.outer_currentPage = paramInt;
        this.pagerAdapter.setTopicController(this.mConvController);
        this.pagerAdapter.getItem(paramInt);
        this.mPager.setCurrentItem(paramInt);
        this.pagerAdapter.notifyDataSetChanged();
    }

    public void setCurrentPageNum(int paramInt) {
        this.outer_currentPage = paramInt;
    }

    public void setJumpPage(int paramInt) {
        this.jumpPage = paramInt;
    }

    public void setJumpToPosition(int paramInt) {
        this.jumpToPosition = paramInt;
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void setSaxCall(boolean paramBoolean) {
    }

    public void setTryTwice(boolean paramBoolean) {
        this.tryTwice = paramBoolean;
    }

    public void showDialog(int paramInt) {
    }

    public void showProgress() {
        getActivity().showDialog(0);
    }

    public void showProgress(String paramString) {
    }

    public void showQuickReply() {
        if ((this.forumStatus != null) && (this.forumStatus.isLogin()) && (this.prefs.getBoolean("showQuick_replay", true))) {
            this.quickbar.setVisibility(0);
            this.quickbar.bringToFront();
        }
        this.reply.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                if (ConversationOuterFragment.this.quickreply_text.getText().toString().length() > 0) {
                    ConversationOuterFragment.this.quickReply();
                }
            }
        });
        this.show_all.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                paramAnonymousView = new Intent(ConversationOuterFragment.this.getActivity(), CreateOrReplyConversationActivity.class);
                new Bundle();
                paramAnonymousView.putExtra("conv", ConversationOuterFragment.this.conversation);
                paramAnonymousView.putExtra("conv_id", ConversationOuterFragment.this.conversation.getConv_id());
                paramAnonymousView.putExtra("count", ConversationOuterFragment.this.conversation.getReply_count());
                paramAnonymousView.putExtra("forumStatus", ConversationOuterFragment.this.forumStatus);
                paramAnonymousView.putExtra("can_upload", ConversationOuterFragment.this.convFragment.tabConvDetailAdapter.can_upload);
                if (ConversationOuterFragment.this.quickreply_text.getText().toString().length() > 0) {
                    paramAnonymousView.putExtra("quickqeply_text", ConversationOuterFragment.this.quickreply_text.getText().toString());
                }
                ConversationOuterFragment.this.IS_REPLY = true;
                paramAnonymousView.putExtra("is_reply", ConversationOuterFragment.this.IS_REPLY);
                ConversationOuterFragment.this.startActivityForResult(paramAnonymousView, 53);
            }
        });
    }

    public void tryFailed(String paramString) {
    }

    public void updateDialog(int paramInt) {
    }

    public void updateSubclassDialog(int paramInt) {
    }

    public void updateUI(int paramInt, Object paramObject) {
    }

    public void updateUI(String paramString) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/conversation/ConversationOuterFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */