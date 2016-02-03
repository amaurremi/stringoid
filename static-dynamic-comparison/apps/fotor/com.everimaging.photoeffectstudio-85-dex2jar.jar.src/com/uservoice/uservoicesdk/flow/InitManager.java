package com.uservoice.uservoicesdk.flow;

import android.content.Context;
import com.uservoice.uservoicesdk.Config;
import com.uservoice.uservoicesdk.Session;
import com.uservoice.uservoicesdk.babayaga.Babayaga;
import com.uservoice.uservoicesdk.babayaga.Babayaga.Event;
import com.uservoice.uservoicesdk.model.AccessToken;
import com.uservoice.uservoicesdk.model.AccessTokenResult;
import com.uservoice.uservoicesdk.model.BaseModel;
import com.uservoice.uservoicesdk.model.ClientConfig;
import com.uservoice.uservoicesdk.model.RequestToken;
import com.uservoice.uservoicesdk.model.User;
import com.uservoice.uservoicesdk.ui.DefaultCallback;

public class InitManager {
    private final Runnable callback;
    private boolean canceled;
    private final Context context;

    public InitManager(Context paramContext, Runnable paramRunnable) {
        this.context = paramContext;
        this.callback = paramRunnable;
    }

    private void done() {
        this.callback.run();
    }

    private void loadUser() {
        if (Session.getInstance().getUser() == null) {
            if (shouldSignIn()) {
                RequestToken.getRequestToken(new DefaultCallback(this.context) {
                    public void onModel(RequestToken paramAnonymousRequestToken) {
                        if (InitManager.this.canceled) {
                            return;
                        }
                        Session.getInstance().setRequestToken(paramAnonymousRequestToken);
                        paramAnonymousRequestToken = Session.getInstance().getConfig();
                        User.findOrCreate(paramAnonymousRequestToken.getEmail(), paramAnonymousRequestToken.getName(), paramAnonymousRequestToken.getGuid(), new DefaultCallback(InitManager.this.context) {
                            public void onModel(AccessTokenResult<User> paramAnonymous2AccessTokenResult) {
                                if (InitManager.this.canceled) {
                                    return;
                                }
                                Session.getInstance().setAccessToken(InitManager.this.context, paramAnonymous2AccessTokenResult.getAccessToken());
                                Session.getInstance().setUser((User) paramAnonymous2AccessTokenResult.getModel());
                                InitManager.this.done();
                            }
                        });
                    }
                });
                return;
            }
            AccessToken localAccessToken = (AccessToken) BaseModel.load(Session.getInstance().getSharedPreferences(), "access_token", "access_token", AccessToken.class);
            if (localAccessToken != null) {
                Session.getInstance().setAccessToken(localAccessToken);
                User.loadCurrentUser(new DefaultCallback(this.context) {
                    public void onModel(User paramAnonymousUser) {
                        Session.getInstance().setUser(paramAnonymousUser);
                        InitManager.this.done();
                    }
                });
                return;
            }
            done();
            return;
        }
        done();
    }

    private boolean shouldSignIn() {
        return Session.getInstance().getConfig().getEmail() != null;
    }

    public void cancel() {
        this.canceled = true;
    }

    public void init() {
        if (Session.getInstance().getClientConfig() == null) {
            ClientConfig.loadClientConfig(new DefaultCallback(this.context) {
                public void onModel(ClientConfig paramAnonymousClientConfig) {
                    Session.getInstance().setClientConfig(paramAnonymousClientConfig);
                    Babayaga.track(Babayaga.Event.VIEW_CHANNEL);
                    InitManager.this.loadUser();
                }
            });
            return;
        }
        loadUser();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/flow/InitManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */