package com.quoord.tapatalkpro.action;

import android.app.Activity;
import android.content.res.Resources;
import android.os.RemoteException;
import android.widget.Toast;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.util.TapatalkEngine;

public class CallBackChecker {
    public static boolean checkCallBack(EngineResponse paramEngineResponse, Activity paramActivity, ForumStatus paramForumStatus, TapatalkEngine paramTapatalkEngine, boolean paramBoolean, TryTwiceCallBackInterface paramTryTwiceCallBackInterface) {
        boolean bool2;
        try {
            bool2 = paramEngineResponse.isSuccess();
            boolean bool1 = true;
            try {
                boolean bool3 = parseCallBackPreCheck(paramActivity, paramEngineResponse, paramForumStatus, paramTapatalkEngine, paramTryTwiceCallBackInterface, paramBoolean);
                bool1 = bool3;
            } catch (RemoteException paramEngineResponse) {
                do {
                    for (; ; ) {
                        paramEngineResponse.printStackTrace();
                    }
                } while (bool2);
                ((ForumActivityStatus) paramActivity).closeProgress();
                Toast.makeText(paramActivity, paramActivity.getString(2131100071), 1).show();
            }
            if ((!bool1) || (paramBoolean)) {
                bool1 = false;
                return bool1;
            }
        } catch (Exception localException) {
            for (; ; ) {
                bool2 = false;
            }
        }
        return false;
    }

    public static boolean parseCallBackPreCheck(Activity paramActivity, EngineResponse paramEngineResponse, final ForumStatus paramForumStatus, final TapatalkEngine paramTapatalkEngine, final TryTwiceCallBackInterface paramTryTwiceCallBackInterface, boolean paramBoolean)
            throws RemoteException {
        final ForumLoginOrSignAction localForumLoginOrSignAction = new ForumLoginOrSignAction(paramActivity, paramForumStatus);
        try {
            boolean bool = paramEngineResponse.isSuccess();
            localBoolean1 = Boolean.valueOf(bool);
        } catch (Exception localException) {
            for (; ; ) {
                Boolean localBoolean1;
                Boolean localBoolean2 = Boolean.valueOf(false);
                continue;
                localForumLoginOrSignAction.loginForum(paramForumStatus.tapatalkForum.getUserNameOrDisplayName(), paramForumStatus.tapatalkForum.getPassword(), false, false, false, new ForumLoginOrSignAction.ActionCallBack() {
                    public void actionErrorBack(String paramAnonymousString1, String paramAnonymousString2) {
                    }

                    public void actionSuccessBack(ForumStatus paramAnonymousForumStatus) {
                        if ((CallBackChecker.this.getTryTwice()) && (paramAnonymousForumStatus.isLogin())) {
                            if (CallBackChecker.this.getSaxCall()) {
                                paramTapatalkEngine.resaxcall();
                            }
                        } else {
                            return;
                        }
                        paramTapatalkEngine.reCall();
                    }
                });
            }
        }
        if (localBoolean1.booleanValue()) {
            if (!paramBoolean) {
                paramEngineResponse = paramEngineResponse.getMethod();
                if ((paramForumStatus != null) && (!paramEngineResponse.equals(paramForumStatus.getAuthroizeUserFunction())) && (!paramEngineResponse.equals("get_config")) && (!paramEngineResponse.equals("sign_in")) && (!paramEngineResponse.equals("logout_user")) && (!paramEngineResponse.equalsIgnoreCase(paramForumStatus.getUrl()))) {
                    if ((!paramForumStatus.isLogin()) || (paramTapatalkEngine.getLoginStatus()) || (paramTryTwiceCallBackInterface.getTryTwice()) || (paramActivity.getResources().getBoolean(2131558402))) {
                        break label318;
                    }
                    paramTryTwiceCallBackInterface.setTryTwice(true);
                    paramBoolean = paramForumStatus.isSignInForumUser(paramActivity);
                    if ((paramForumStatus.isTapatalkSignIn(paramActivity)) && (paramBoolean) && (!paramForumStatus.tapatalkForum.hasPassword())) {
                        localForumLoginOrSignAction.signForum(paramForumStatus.tapatalkForum.getUserNameOrDisplayName(), null, false, false, false, new ForumLoginOrSignAction.ActionCallBack() {
                            public void actionErrorBack(String paramAnonymousString1, String paramAnonymousString2) {
                                if ((paramForumStatus.tapatalkForum.getPassword() != null) && (paramForumStatus.tapatalkForum.getPassword().equals(""))) {
                                    localForumLoginOrSignAction.loginForum(paramForumStatus.tapatalkForum.getUserNameOrDisplayName(), paramForumStatus.tapatalkForum.getPassword(), false, false, false, new ForumLoginOrSignAction.ActionCallBack() {
                                        public void actionErrorBack(String paramAnonymous2String1, String paramAnonymous2String2) {
                                        }

                                        public void actionSuccessBack(ForumStatus paramAnonymous2ForumStatus) {
                                            if ((this.val$tryInterface.getTryTwice()) && (paramAnonymous2ForumStatus.isLogin())) {
                                                if (this.val$tryInterface.getSaxCall()) {
                                                    this.val$engine.resaxcall();
                                                }
                                            } else {
                                                return;
                                            }
                                            this.val$engine.reCall();
                                        }
                                    });
                                }
                            }

                            public void actionSuccessBack(ForumStatus paramAnonymousForumStatus) {
                                paramAnonymousForumStatus.setSignInForumUser(CallBackChecker.this);
                                if ((paramTryTwiceCallBackInterface.getTryTwice()) && (paramAnonymousForumStatus.isLogin())) {
                                    if (paramTryTwiceCallBackInterface.getSaxCall()) {
                                        paramTapatalkEngine.resaxcall();
                                    }
                                } else {
                                    return;
                                }
                                paramTapatalkEngine.reCall();
                            }
                        });
                        return false;
                    }
                }
                return true;
            }
        } else {
            if ((paramEngineResponse.getMethod() != null) && (paramEngineResponse.getMethod().length() > 0) && (paramEngineResponse.getMethod().toString().equals(paramForumStatus.getUrl()))) {
                return true;
            }
            try {
                ((ForumActivityStatus) paramActivity).closeProgress();
                Toast.makeText(paramActivity, paramActivity.getString(2131100071), 1).show();
                return false;
            } catch (Exception paramActivity) {
                for (; ; ) {
                    paramActivity.printStackTrace();
                }
            }
        }
        label318:
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/CallBackChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */