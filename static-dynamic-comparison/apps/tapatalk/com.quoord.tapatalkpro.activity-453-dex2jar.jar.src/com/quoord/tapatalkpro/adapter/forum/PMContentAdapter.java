package com.quoord.tapatalkpro.adapter.forum;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.quoord.tapatalkpro.activity.forum.CreatePmActivity;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.activity.forum.PmContentFragment;
import com.quoord.tapatalkpro.activity.forum.ProfilesActivity;
import com.quoord.tapatalkpro.bean.BaseBean;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.NoPMView;
import com.quoord.tapatalkpro.bean.PrivateMessage;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.util.BBcodeUtil;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tapatalkpro.view.TapaButton;
import com.quoord.tapatalkpro.view.TimeStampView;
import com.quoord.tools.bitmap.ui.GifImageView;

import java.util.ArrayList;
import java.util.HashMap;

public class PMContentAdapter
        extends ForumRootAdapter {
    String boxid;
    PrivateMessage curPm;
    GifImageView currentIv;
    ImageView divider;
    ImageView divider1;
    public TapaButton forwardBtn;
    TextView fromnTv;
    ImageView imageView;
    private Activity mContext = null;
    private ArrayList<BaseBean> mDatas = new ArrayList();
    PmContentFragment mFragment;
    String pmid;
    View pmmain;
    public View progress;
    TextView recpitTv;
    public TapaButton replyAllBtn;
    public TapaButton replyBtn;
    TextView titleTv;

    public PMContentAdapter(PmContentFragment paramPmContentFragment, View paramView, String paramString, PrivateMessage paramPrivateMessage) {
        super(paramPmContentFragment.mActivity, paramPmContentFragment, paramString);
        this.loadingMore = true;
        this.mFragment = paramPmContentFragment;
        this.mContext = paramPmContentFragment.mActivity;
        this.curPm = paramPrivateMessage;
        this.pmmain = paramView;
        this.titleTv = ((TextView) this.pmmain.findViewById(2131231506));
        this.fromnTv = ((TextView) this.pmmain.findViewById(2131231507));
        this.recpitTv = ((TextView) this.pmmain.findViewById(2131231508));
        this.progress = this.pmmain.findViewById(2131230891);
        this.currentIv = ((GifImageView) this.pmmain.findViewById(2131231511));
        this.imageView = ((ImageView) this.pmmain.findViewById(2131230795));
        this.divider = ((ImageView) this.pmmain.findViewById(2131231509));
        this.divider1 = ((ImageView) this.pmmain.findViewById(2131231515));
        if (SettingsFragment.isLightTheme(this.mContext)) {
            this.titleTv.setTextColor(this.mContext.getResources().getColor(2131165279));
        }
        for (; ; ) {
            this.divider.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("thread_diver", paramPmContentFragment.mActivity));
            if ((this.forumStatus.tapatalkForum.getPassword() != null) || (this.forumStatus.tapatalkForum.getUserName() != null)) {
                break;
            }
            this.mContext.showDialog(3);
            return;
            this.titleTv.setTextColor(this.mContext.getResources().getColor(2131165213));
        }
        getMessage();
    }

    /* Error */
    public void createPMBeanQuote(HashMap paramHashMap) {
        // Byte code:
        //   0: aload_1
        //   1: ifnonnull +4 -> 5
        //   4: return
        //   5: aload_0
        //   6: getfield 62	com/quoord/tapatalkpro/adapter/forum/PMContentAdapter:curPm	Lcom/quoord/tapatalkpro/bean/PrivateMessage;
        //   9: new 168	java/lang/String
        //   12: dup
        //   13: aload_1
        //   14: ldc -86
        //   16: invokevirtual 176	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
        //   19: checkcast 178	[B
        //   22: ldc -76
        //   24: invokespecial 183	java/lang/String:<init>	([BLjava/lang/String;)V
        //   27: invokevirtual 189	com/quoord/tapatalkpro/bean/PrivateMessage:setMsgSubject	(Ljava/lang/String;)V
        //   30: aload_1
        //   31: ldc -65
        //   33: invokevirtual 195	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
        //   36: ifeq +28 -> 64
        //   39: aload_0
        //   40: getfield 62	com/quoord/tapatalkpro/adapter/forum/PMContentAdapter:curPm	Lcom/quoord/tapatalkpro/bean/PrivateMessage;
        //   43: new 168	java/lang/String
        //   46: dup
        //   47: aload_1
        //   48: ldc -65
        //   50: invokevirtual 176	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
        //   53: checkcast 178	[B
        //   56: ldc -76
        //   58: invokespecial 183	java/lang/String:<init>	([BLjava/lang/String;)V
        //   61: invokevirtual 198	com/quoord/tapatalkpro/bean/PrivateMessage:setTimeString	(Ljava/lang/String;)V
        //   64: ldc -56
        //   66: astore_3
        //   67: aload_1
        //   68: ldc -54
        //   70: invokevirtual 195	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
        //   73: istore_2
        //   74: iload_2
        //   75: ifeq -71 -> 4
        //   78: new 168	java/lang/String
        //   81: dup
        //   82: aload_1
        //   83: ldc -54
        //   85: invokevirtual 176	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
        //   88: checkcast 178	[B
        //   91: invokestatic 208	com/quoord/tapatalkpro/util/Util:parseByteArray	([B)[B
        //   94: ldc -76
        //   96: invokespecial 183	java/lang/String:<init>	([BLjava/lang/String;)V
        //   99: astore_1
        //   100: aload_0
        //   101: getfield 62	com/quoord/tapatalkpro/adapter/forum/PMContentAdapter:curPm	Lcom/quoord/tapatalkpro/bean/PrivateMessage;
        //   104: aload_1
        //   105: invokevirtual 211	com/quoord/tapatalkpro/bean/PrivateMessage:setTextBody	(Ljava/lang/String;)V
        //   108: return
        //   109: astore_1
        //   110: aload_1
        //   111: invokevirtual 214	java/io/UnsupportedEncodingException:printStackTrace	()V
        //   114: return
        //   115: astore_1
        //   116: aload_1
        //   117: invokevirtual 214	java/io/UnsupportedEncodingException:printStackTrace	()V
        //   120: aload_3
        //   121: astore_1
        //   122: goto -22 -> 100
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	125	0	this	PMContentAdapter
        //   0	125	1	paramHashMap	HashMap
        //   73	2	2	bool	boolean
        //   66	55	3	str	String
        // Exception table:
        //   from	to	target	type
        //   5	64	109	java/io/UnsupportedEncodingException
        //   67	74	109	java/io/UnsupportedEncodingException
        //   100	108	109	java/io/UnsupportedEncodingException
        //   116	120	109	java/io/UnsupportedEncodingException
        //   78	100	115	java/io/UnsupportedEncodingException
    }

    public void createReplyPMIntent(int paramInt) {
        Intent localIntent = new Intent(this.mContext, CreatePmActivity.class);
        localIntent.putExtra("action", paramInt);
        localIntent.putExtra("pm", this.curPm);
        localIntent.putExtra("forumStatus", this.forumStatus);
        this.mContext.startActivityForResult(localIntent, 11);
    }

    public void destory() {
        if (this.curPm != null) {
            this.curPm.destory();
        }
    }

    public int getCount() {
        return this.mDatas.size();
    }

    public PrivateMessage getCurPm() {
        return this.curPm;
    }

    public Object getItem(int paramInt) {
        return this.mDatas.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public void getMessage() {
        setTryTwice(false);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(this.curPm.getMsgId());
        if ((this.forumStatus.getApiLevel() >= 3) && (!this.forumStatus.isIP()) && (this.curPm.getBoxId() != null)) {
            localArrayList.add(this.curPm.getBoxId());
        }
        notifyDataSetChanged();
        this.engine.call("get_message", localArrayList);
    }

    public void getPmDetailView(final Activity paramActivity, ForumRootAdapter paramForumRootAdapter, final ForumStatus paramForumStatus) {
        this.imageView.setVisibility(0);
        label98:
        final Object localObject2;
        final Object localObject1;
        label138:
        int i;
        if (this.curPm.isInbox()) {
            Util.getUserImage(paramActivity, paramForumStatus, this.currentIv, this.curPm.getIconUrl(), this.imageView);
            if ((this.curPm.getIconUrl() == null) || (this.curPm.getIconUrl().trim().length() <= 0)) {
                break label777;
            }
            if (Util.getHost(paramForumStatus.getUrl()).equalsIgnoreCase(Util.getHost(this.curPm.getIconUrl()))) {
                this.curPm.setCookies(paramForumStatus.getCookie());
            }
            localObject2 = "";
            String str = "";
            if ((this.curPm.getMsgFrom() == null) || (this.curPm.getMsgFrom().length() <= 0)) {
                break label840;
            }
            localObject1 = this.curPm.getMsgFrom();
            localObject2 = str;
            if (this.curPm.getMsgFromId() != null) {
                localObject2 = str;
                if (this.curPm.getMsgFromId().length() > 0) {
                    localObject2 = this.curPm.getMsgFromId();
                }
            }
            this.currentIv.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    paramAnonymousView = new Intent(paramActivity, ProfilesActivity.class);
                    if ((PMContentAdapter.this.curPm.isInbox()) && (localObject1 != null)) {
                        paramAnonymousView.putExtra("iconusername", localObject1);
                        paramAnonymousView.putExtra("userid", localObject2);
                        paramAnonymousView.putExtra("forumStatus", paramForumStatus);
                        paramActivity.startActivity(paramAnonymousView);
                        return;
                    }
                    if ((!PMContentAdapter.this.curPm.isInbox()) && (PMContentAdapter.this.curPm.getMsgFrom() != null)) {
                        paramAnonymousView.putExtra("iconusername", PMContentAdapter.this.curPm.getMsgFrom().toString());
                        paramAnonymousView.putExtra("userid", PMContentAdapter.this.curPm.getMsgFromId());
                        paramAnonymousView.putExtra("forumStatus", paramForumStatus);
                        paramActivity.startActivity(paramAnonymousView);
                        return;
                    }
                    Toast.makeText(paramActivity, paramActivity.getString(2131099810), 1).show();
                }
            });
            localObject1 = (TimeStampView) this.pmmain.findViewById(2131231513);
            localObject2 = (LinearLayout) this.pmmain.findViewById(2131231514);
            paramForumRootAdapter = new MessageContentAdapter(paramActivity, paramForumRootAdapter, paramForumStatus).getViewFromPost(BBcodeUtil.process(this.curPm.getTextBody(), paramForumStatus, true, false, false, 0), this.curPm, false);
            i = 0;
            label266:
            if (i < paramForumRootAdapter.length) {
                break label883;
            }
            if ((this.curPm.getMsg_from_display() == null) || (this.curPm.getMsg_from_display().length() <= 0)) {
                break label948;
            }
            if (this.curPm.getMsg_from_display().length() <= 12) {
                break label908;
            }
            this.fromnTv.setText(paramActivity.getString(2131099947) + this.curPm.getMsg_from_display().substring(0, 12) + "...");
            label360:
            if (paramForumStatus.isLightTheme()) {
                this.recpitTv.setTextColor(paramActivity.getResources().getColor(2131165275));
                this.fromnTv.setTextColor(paramActivity.getResources().getColor(2131165275));
            }
            paramForumStatus = (TextView) this.pmmain.findViewById(2131231512);
            if ((this.curPm.getMsgFrom() == null) || (this.curPm.getMsgFrom().length() <= 0)) {
                break label1055;
            }
            paramForumRootAdapter = this.curPm.getMsgFrom();
            label446:
            paramForumStatus.setText(paramForumRootAdapter);
            if (paramActivity.getResources().getBoolean(2131558401)) {
                break label1100;
            }
            paramForumStatus.setTextColor(paramActivity.getResources().getColor(2131165278));
            label478:
            if ((this.curPm.getMsgToString() != null) && (this.curPm.getMsgToString().length() > 0)) {
                this.recpitTv.setVisibility(0);
                if (this.curPm.getMsgToString().length() <= 12) {
                    break label1108;
                }
                this.recpitTv.setText(paramActivity.getString(2131099946) + " " + this.curPm.getMsgToString().substring(0, 12) + "...");
            }
            label579:
            if (SettingsFragment.getTimeStyle(paramActivity) != 0) {
                break label1154;
            }
            ((TimeStampView) localObject1).setText(this.curPm.getSentSmartDateString());
            label598:
            this.titleTv.setText(this.curPm.getMsgSubject());
            paramActivity = new ArrayList();
            if ((this.curPm.getMsgToUserid() != null) && (this.curPm.getMsgToUserid().size() > 0) && (this.curPm.getMsgTo() != null) && (this.curPm.getMsgTo().size() > 0)) {
                i = 0;
            }
        }
        for (; ; ) {
            if (i >= this.curPm.getMsgToUserid().size()) {
                if ((this.curPm.getMsgFrom() != null) && (this.curPm.getMsgFromId() != null)) {
                    paramForumRootAdapter = new HashMap();
                    paramForumRootAdapter.put("userid", this.curPm.getMsgFromId());
                    paramForumRootAdapter.put("username", this.curPm.getMsgFrom());
                    paramActivity.add(paramForumRootAdapter);
                }
                this.mFragment.initInviteBar(paramActivity);
                return;
                Util.getUserImage(paramActivity, paramForumStatus, this.currentIv, paramForumStatus.getAvatarUrl(), this.imageView);
                break;
                label777:
                if ((this.curPm.getIconUrl() == null) || (this.curPm.getIconUrl().trim().length() <= 0) || (!Util.getHost(paramForumStatus.getUrl()).equalsIgnoreCase(Util.getHost(this.curPm.getIconUrl())))) {
                    break label98;
                }
                this.curPm.setCookies(paramForumStatus.getCookie());
                break label98;
                label840:
                localObject1 = localObject2;
                if (this.curPm.getMsg_from_display() == null) {
                    break label138;
                }
                localObject1 = localObject2;
                if (this.curPm.getMsg_from_display().length() <= 0) {
                    break label138;
                }
                localObject1 = this.curPm.getMsg_from_display();
                break label138;
                label883:
                if (paramForumRootAdapter[i] != null) {
                    ((LinearLayout) localObject2).addView(paramForumRootAdapter[i]);
                }
                i += 1;
                break label266;
                label908:
                this.fromnTv.setText(paramActivity.getString(2131099947) + this.curPm.getMsg_from_display());
                break label360;
                label948:
                if (this.curPm.getMsgFrom().length() > 12) {
                    this.fromnTv.setText(paramActivity.getString(2131099947) + this.curPm.getMsgFrom().substring(0, 12) + "...");
                    break label360;
                }
                this.fromnTv.setText(paramActivity.getString(2131099947) + this.curPm.getMsgFrom());
                break label360;
                label1055:
                if ((this.curPm.getMsg_from_display() != null) && (this.curPm.getMsg_from_display().length() > 0)) {
                    paramForumRootAdapter = this.curPm.getMsg_from_display();
                    break label446;
                }
                paramForumRootAdapter = this.curPm.getMsgToString();
                break label446;
                label1100:
                ThemeUtil.setAuthorColor(paramActivity, paramForumStatus);
                break label478;
                label1108:
                this.recpitTv.setText(paramActivity.getString(2131099946) + " " + this.curPm.getMsgToString());
                break label579;
                label1154:
                ((TimeStampView) localObject1).setText(this.curPm.getSentDateString());
                break label598;
            }
            paramForumRootAdapter = new HashMap();
            paramForumRootAdapter.put("userid", (String) this.curPm.getMsgToUserid().get(i));
            paramForumRootAdapter.put("username", (String) this.curPm.getMsgTo().get(i));
            paramActivity.add(paramForumRootAdapter);
            i += 1;
        }
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        return ((NoPMView) getItem(paramInt)).getItemView(this.mContext);
    }

    public void parseCallBack(EngineResponse paramEngineResponse) {
        String str = paramEngineResponse.getMethod();
        if (str.equals("get_message")) {
            paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
            this.curPm.getMsgTo().clear();
            this.curPm = PrivateMessage.createPMBean(paramEngineResponse, this.mContext, this.curPm.getBoxId(), this.curPm.isInbox(), this.curPm);
            getPmDetailView(this.mContext, this, this.forumStatus);
            this.mStatus.closeProgress();
            this.progress.setVisibility(8);
            this.divider.setVisibility(0);
            this.mContext.invalidateOptionsMenu();
        }
        for (; ; ) {
            if (this.forwardBtn != null) {
                this.forwardBtn.setEnabled(true);
            }
            if (this.replyBtn != null) {
                this.replyBtn.setEnabled(true);
            }
            if (this.replyAllBtn != null) {
                this.replyAllBtn.setEnabled(true);
            }
            return;
            if (str.equals("get_quote_pm")) {
                if (!paramEngineResponse.isSuccess()) {
                    createReplyPMIntent(this.curAction);
                } else {
                    createPMBeanQuote((HashMap) paramEngineResponse.getResponse());
                    this.mStatus.closeProgress();
                    createReplyPMIntent(this.curAction);
                }
            }
        }
    }

    public void refresh() {
    }

    public void report_pm(ArrayList paramArrayList) {
        setTryTwice(false);
        this.engine.call("report_pm", paramArrayList);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/PMContentAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */