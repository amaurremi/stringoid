package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.b.f;
import com.umeng.analytics.b.k;
import com.umeng.analytics.b.m;
import com.umeng.analytics.b.m.a;
import com.umeng.analytics.b.n;
import com.umeng.analytics.b.r;
import com.umeng.analytics.onlineconfig.UmengOnlineConfigureListener;
import com.umeng.common.Log;

import java.util.HashMap;
import java.util.Map;

public class c
        implements k {
    private final com.umeng.analytics.onlineconfig.a a = new com.umeng.analytics.onlineconfig.a();
    private Context b = null;
    private b c;
    private com.umeng.analytics.b.c d = new com.umeng.analytics.b.c();
    private r e = new r();
    private n f = new n();
    private com.umeng.analytics.b.d g;
    private boolean h = false;

    c() {
        this.d.a(this);
    }

    private void f(Context paramContext) {
        if (!this.h) {
            this.b = paramContext.getApplicationContext();
            this.g = new com.umeng.analytics.b.d(paramContext);
            this.h = true;
        }
    }

    private void g(Context paramContext) {
        this.f.c(paramContext);
        if (this.c != null) {
            this.c.a();
        }
    }

    private void h(Context paramContext) {
        this.f.d(paramContext);
        this.e.a(paramContext);
        if (this.c != null) {
            this.c.b();
        }
        com.umeng.analytics.b.a.a(paramContext).b();
    }

    public void a(int paramInt) {
        AnalyticsConfig.mVerticalType = paramInt;
    }

    void a(final Context paramContext) {
        if (paramContext == null) {
            Log.b("MobclickAgent", "unexpected null context in onResume");
            return;
        }
        this.a.a(paramContext);
        try {
            d.a(new e() {
                public void a() {
                    f localf = com.umeng.analytics.b.a.a(paramContext).a();
                    if ((localf instanceof com.umeng.analytics.onlineconfig.c)) {
                        c.a(c.this).a((com.umeng.analytics.onlineconfig.c) localf);
                    }
                }
            });
            return;
        } catch (Exception paramContext) {
            paramContext.printStackTrace();
        }
    }

    void a(Context paramContext, String paramString) {
        if (TextUtils.isEmpty(paramString)) {
            return;
        }
        if (paramContext == null) {
            Log.b("MobclickAgent", "unexpected null context in reportError");
            return;
        }
        try {
            if (!this.h) {
                f(paramContext);
            }
            paramContext = com.umeng.analytics.b.a.a(paramContext);
            paramContext.a(new com.umeng.analytics.c.c(paramString).a(false));
            paramContext.a(1);
            return;
        } catch (Exception paramContext) {
            Log.b("MobclickAgent", "", paramContext);
        }
    }

    void a(Context paramContext, final String paramString1, final String paramString2) {
        try {
            if (!this.h) {
                f(paramContext);
            }
            d.a(new e() {
                public void a() {
                    c.b(c.this).a(paramString1, paramString2);
                }
            });
            return;
        } catch (Exception paramContext) {
            Log.b("MobclickAgent", "", paramContext);
        }
    }

    public void a(Context paramContext, String paramString1, String paramString2, long paramLong, int paramInt) {
        try {
            if (!this.h) {
                f(paramContext);
            }
            this.g.a(paramString1, paramString2, paramLong, paramInt);
            return;
        } catch (Exception paramContext) {
            Log.b("MobclickAgent", "", paramContext);
        }
    }

    public void a(Context paramContext, String paramString, HashMap<String, Object> paramHashMap) {
        try {
            if (!this.h) {
                f(paramContext);
            }
            this.g.a(paramString, paramHashMap);
            return;
        } catch (Exception paramContext) {
            Log.b("MobclickAgent", "", paramContext);
        }
    }

    void a(Context paramContext, final String paramString1, final HashMap<String, Object> paramHashMap, final String paramString2) {
        try {
            if (!this.h) {
                f(paramContext);
            }
            d.a(new e() {
                public void a() {
                    c.b(c.this).a(paramString1, paramHashMap, paramString2);
                }
            });
            return;
        } catch (Exception paramContext) {
            Log.b("MobclickAgent", "", paramContext);
        }
    }

    void a(Context paramContext, String paramString, Map<String, Object> paramMap, long paramLong) {
        try {
            if (!this.h) {
                f(paramContext);
            }
            this.g.a(paramString, paramMap, paramLong);
            return;
        } catch (Exception paramContext) {
            Log.b("MobclickAgent", "", paramContext);
        }
    }

    void a(Context paramContext, Throwable paramThrowable) {
        if ((paramContext == null) || (paramThrowable == null)) {
            return;
        }
        try {
            if (!this.h) {
                f(paramContext);
            }
            paramContext = com.umeng.analytics.b.a.a(paramContext);
            paramContext.a(new com.umeng.analytics.c.c(paramThrowable).a(false));
            paramContext.a(1);
            return;
        } catch (Exception paramContext) {
            Log.b("MobclickAgent", "", paramContext);
        }
    }

    public void a(b paramb) {
        this.c = paramb;
    }

    void a(UmengOnlineConfigureListener paramUmengOnlineConfigureListener) {
        this.a.a(paramUmengOnlineConfigureListener);
    }

    void a(String paramString) {
        if (!AnalyticsConfig.ACTIVITY_DURATION_OPEN) {
        }
        try {
            this.e.a(paramString);
            return;
        } catch (Exception paramString) {
            paramString.printStackTrace();
        }
    }

    public void a(String paramString1, String paramString2) {
        AnalyticsConfig.mWrapperType = paramString1;
        AnalyticsConfig.mWrapperVersion = paramString2;
    }

    public void a(Throwable paramThrowable) {
        try {
            this.e.a();
            if (this.b != null) {
                if (paramThrowable != null) {
                    com.umeng.analytics.b.a.a(this.b).a(new com.umeng.analytics.c.c(paramThrowable));
                }
                h(this.b);
                m.a(this.b).a().c();
            }
            d.a();
            return;
        } catch (Exception paramThrowable) {
            Log.a("MobclickAgent", "Exception in onAppCrash", paramThrowable);
        }
    }

    void b(final Context paramContext) {
        if (paramContext == null) {
            Log.b("MobclickAgent", "unexpected null context in onResume");
            return;
        }
        if (AnalyticsConfig.ACTIVITY_DURATION_OPEN) {
            this.e.a(paramContext.getClass().getName());
        }
        try {
            if (!this.h) {
                f(paramContext);
            }
            d.a(new e() {
                public void a() {
                    c.a(c.this, paramContext.getApplicationContext());
                }
            });
            return;
        } catch (Exception paramContext) {
            Log.b("MobclickAgent", "Exception occurred in Mobclick.onResume(). ", paramContext);
        }
    }

    void b(Context paramContext, final String paramString) {
        try {
            if (!this.h) {
                f(paramContext);
            }
            d.a(new e() {
                public void a() {
                    c.b(c.this).a(paramString, null);
                }
            });
            return;
        } catch (Exception paramContext) {
            Log.b("MobclickAgent", "", paramContext);
        }
    }

    void b(Context paramContext, final String paramString1, final String paramString2) {
        try {
            d.a(new e() {
                public void a() {
                    c.b(c.this).b(paramString1, paramString2);
                }
            });
            return;
        } catch (Exception paramContext) {
            Log.b("MobclickAgent", "", paramContext);
        }
    }

    void b(String paramString) {
        if (!AnalyticsConfig.ACTIVITY_DURATION_OPEN) {
        }
        try {
            this.e.b(paramString);
            return;
        } catch (Exception paramString) {
            paramString.printStackTrace();
        }
    }

    void c(final Context paramContext) {
        if (paramContext == null) {
            Log.b("MobclickAgent", "unexpected null context in onPause");
            return;
        }
        if (AnalyticsConfig.ACTIVITY_DURATION_OPEN) {
            this.e.b(paramContext.getClass().getName());
        }
        try {
            d.a(new e() {
                public void a() {
                    c.b(c.this, paramContext.getApplicationContext());
                }
            });
            return;
        } catch (Exception paramContext) {
            Log.b("MobclickAgent", "Exception occurred in Mobclick.onRause(). ", paramContext);
        }
    }

    void c(Context paramContext, final String paramString) {
        try {
            d.a(new e() {
                public void a() {
                    c.b(c.this).b(paramString, null);
                }
            });
            return;
        } catch (Exception paramContext) {
            Log.b("MobclickAgent", "", paramContext);
        }
    }

    void c(Context paramContext, final String paramString1, final String paramString2) {
        try {
            d.a(new e() {
                public void a() {
                    c.b(c.this).c(paramString1, paramString2);
                }
            });
            return;
        } catch (Exception paramContext) {
            Log.b("MobclickAgent", "", paramContext);
        }
    }

    void d(Context paramContext) {
        try {
            if (!this.h) {
                f(paramContext);
            }
            com.umeng.analytics.b.a.a(paramContext).a(2);
            return;
        } catch (Exception paramContext) {
            Log.b("MobclickAgent", "", paramContext);
        }
    }

    void e(Context paramContext) {
        try {
            this.e.a();
            h(paramContext);
            m.a(paramContext).a().c();
            d.a();
            return;
        } catch (Exception paramContext) {
            paramContext.printStackTrace();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */