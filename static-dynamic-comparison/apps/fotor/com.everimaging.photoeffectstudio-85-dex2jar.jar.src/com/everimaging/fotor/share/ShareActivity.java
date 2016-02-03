package com.everimaging.fotor.share;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.everimaging.fotor.App;
import com.everimaging.fotor.HomeActivity;
import com.everimaging.fotor.HomeActivity.SDKModule;
import com.everimaging.fotor.app.FotorAlertDialog;
import com.everimaging.fotor.app.FotorAlertDialog.a;
import com.everimaging.fotor.b;
import com.everimaging.fotor.log.LoggerFactory;
import com.everimaging.fotor.log.LoggerFactory.LoggerType;
import com.everimaging.fotor.log.LoggerFactory.c;
import com.everimaging.fotor.preference.PreferenceUtils;
import com.everimaging.fotor.preference.PreferenceUtils.RateUsAction;
import com.everimaging.fotor.preference.PreferenceUtils.RateUsAction.ActionType;
import com.everimaging.fotorsdk.editor.FotorHDFilter;
import com.everimaging.fotorsdk.editor.FotorHDFilter.MegaPixels;
import com.everimaging.fotorsdk.provider.FotorContentProvider.SessionColumns;
import com.everimaging.fotorsdk.provider.FotorContentProvider.SessionColumns.Session;
import com.everimaging.fotorsdk.utils.FotorAsyncTask;
import com.everimaging.fotorsdk.utils.Utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ShareActivity
        extends b
        implements AdapterView.OnItemClickListener {
    private static final String a = ShareActivity.class.getSimpleName();
    private static final LoggerFactory.c b = LoggerFactory.a(a, LoggerFactory.LoggerType.CONSOLE);
    private static List<String> h = new ArrayList();
    private List<ResolveInfo> c;
    private List<ResolveInfo> d;
    private List<c> e;
    private ListView f;
    private b g;
    private boolean i;
    private Uri j;
    private String k;
    private boolean l;
    private a m;
    private boolean n;
    private HomeActivity.SDKModule o;

    static {
        h.add("com.instagram.android");
        h.add("com.facebook.katana");
        h.add("com.whatsapp");
        h.add("com.twitter.android");
        h.add("com.yahoo.mobile.client.android.flickr");
        h.add("com.tencent.mm");
    }

    private long a(Date paramDate) {
        if (paramDate == null) {
            return 0L;
        }
        b.c(new Object[]{"before day:" + paramDate});
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTime(paramDate);
        paramDate = Calendar.getInstance();
        b.c(new Object[]{"today:" + paramDate.getTime()});
        long l1 = (paramDate.getTimeInMillis() - localCalendar.getTimeInMillis()) / 86400000L;
        b.c(new Object[]{"diff day:" + l1});
        return l1;
    }

    private String a(Context paramContext, String paramString) {
        Object localObject2 = null;
        Object localObject1 = FotorContentProvider.SessionColumns.getContentUri(paramContext, paramString);
        FotorContentProvider.SessionColumns.Session localSession = FotorContentProvider.SessionColumns.Session.create(paramContext.getContentResolver().query((Uri) localObject1, null, null, null, null));
        Utils.printMemoryInfo();
        localObject1 = localObject2;
        if (localSession != null) {
        }
        try {
            localObject1 = new FotorHDFilter(paramContext, localSession);
            ((FotorHDFilter) localObject1).setMaxMegaPixels(FotorHDFilter.MegaPixels.Mp12);
            ((FotorHDFilter) localObject1).loadImage();
            ((FotorHDFilter) localObject1).executeFilter();
            paramContext = App.b.e();
            boolean bool = ((FotorHDFilter) localObject1).save(paramContext);
            ((FotorHDFilter) localObject1).dispose();
            b(paramString);
            localObject1 = localObject2;
            if (bool) {
                localObject1 = paramContext;
            }
            return (String) localObject1;
        } catch (IllegalStateException paramContext) {
            b.e(new Object[]{paramContext.getMessage()});
        }
        return null;
    }

    private void a(PackageManager paramPackageManager, List<ResolveInfo> paramList, CharSequence paramCharSequence) {
        c localc;
        if (this.i) {
            localc = new c();
            localc.b = paramCharSequence;
            localc.d = false;
            this.e.add(localc);
        }
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
            paramCharSequence = (ResolveInfo) paramList.next();
            localc = new c();
            localc.b = paramCharSequence.loadLabel(paramPackageManager);
            localc.a = paramCharSequence.loadIcon(paramPackageManager);
            localc.c = paramCharSequence;
            localc.d = true;
            this.e.add(localc);
        }
    }

    private void a(c paramc) {
        paramc = paramc.c;
        Object localObject = new Intent();
        ((Intent) localObject).setAction("android.intent.action.SEND");
        ((Intent) localObject).setClassName(paramc.activityInfo.packageName, paramc.activityInfo.name);
        ((Intent) localObject).setType("image/*");
        ((Intent) localObject).putExtra("android.intent.extra.STREAM", this.j);
        ((Intent) localObject).putExtra("android.intent.extra.SUBJECT", getString(2131296643));
        startActivityForResult((Intent) localObject, 0);
        paramc = paramc.loadLabel(getPackageManager());
        a("Fotor_Share_Item_Click");
        localObject = new HashMap();
        if (paramc != null) {
        }
        for (paramc = paramc.toString(); ; paramc = "unknown") {
            ((Map) localObject).put("Fotor_Share_Item_Name", paramc);
            a("Fotor_Share_Item_Name", (Map) localObject);
            com.everimaging.fotor.a.a.a(this, paramc);
            return;
        }
    }

    private String b(Context paramContext, String paramString) {
        Object localObject1 = null;
        Object localObject2 = FotorContentProvider.SessionColumns.getContentUri(paramContext, paramString);
        localObject2 = FotorContentProvider.SessionColumns.Session.create(paramContext.getContentResolver().query((Uri) localObject2, null, null, null, null));
        paramContext = (Context) localObject1;
        if (localObject2 != null) {
        }
        try {
            paramContext = new com.everimaging.fotorsdk.collage.d(this, (FotorContentProvider.SessionColumns.Session) localObject2);
            paramContext.a();
            localObject2 = App.b.e();
            boolean bool = paramContext.a((String) localObject2);
            b(paramString);
            paramContext = (Context) localObject1;
            if (bool) {
                paramContext = (Context) localObject2;
            }
            return paramContext;
        } catch (IllegalStateException paramContext) {
            paramContext.printStackTrace();
        }
        return null;
    }

    private void b() {
        this.f = ((ListView) findViewById(16908298));
    }

    private void b(String paramString) {
        paramString = FotorContentProvider.SessionColumns.getContentUri(this, paramString);
        int i1 = getContentResolver().delete(paramString, null, null);
        b.c(new Object[]{"delete session count:" + i1});
    }

    private void c() {
        Object localObject = PreferenceUtils.d(this);
        if ((PreferenceUtils.c(this) < 2) && ((localObject == null) || (((PreferenceUtils.RateUsAction) localObject).a() != PreferenceUtils.RateUsAction.ActionType.RATE_US))) {
            if (localObject != null) {
                break label36;
            }
            d();
        }
        label36:
        int i1;
        int i2;
        do {
            do {
                do {
                    return;
                    b.c(new Object[]{"rate us action date:" + ((PreferenceUtils.RateUsAction) localObject).b()});
                    if (((PreferenceUtils.RateUsAction) localObject).a() != PreferenceUtils.RateUsAction.ActionType.LATER) {
                        break;
                    }
                } while (a(((PreferenceUtils.RateUsAction) localObject).b()) <= 1L);
                d();
                return;
            }
            while ((((PreferenceUtils.RateUsAction) localObject).a() != PreferenceUtils.RateUsAction.ActionType.NO_THANKS) || (a(((PreferenceUtils.RateUsAction) localObject).b()) <= 7L));
            Calendar localCalendar = Calendar.getInstance();
            localCalendar.setTime(((PreferenceUtils.RateUsAction) localObject).b());
            localCalendar.add(5, 7);
            localObject = new Date(localCalendar.getTimeInMillis());
            b.c(new Object[]{"judgeDate:" + localObject});
            i1 = com.everimaging.fotor.a.a.a(this, (Date) localObject);
            i2 = com.everimaging.fotor.a.a.b(this, (Date) localObject);
            b.c(new Object[]{"launcCount:" + i1 + ",shareCount:" + i2});
        } while ((i1 <= 3) && (i2 <= 3));
        d();
    }

    private void d() {
        try {
            PreferenceUtils.b(this);
            if (getSupportFragmentManager().findFragmentByTag("rate_us") != null) {
                b.d(new Object[]{"rate us dialog is shown"});
                return;
            }
            FotorAlertDialog localFotorAlertDialog = FotorAlertDialog.a();
            Bundle localBundle = new Bundle();
            localBundle.putCharSequence("TITLE", getText(2131296636));
            localBundle.putCharSequence("MESSAGE", getText(2131296635));
            localBundle.putCharSequence("NEGATIVE_BUTTON_TEXT", getText(2131296638));
            localBundle.putCharSequence("POSITIVE_BUTTON_TEXT", getText(2131296637));
            localFotorAlertDialog.setArguments(localBundle);
            localFotorAlertDialog.a(new FotorAlertDialog.a() {
                public void a(FotorAlertDialog paramAnonymousFotorAlertDialog) {
                    PreferenceUtils.a(ShareActivity.this, new PreferenceUtils.RateUsAction(PreferenceUtils.RateUsAction.ActionType.RATE_US, new Date(System.currentTimeMillis())));
                    ShareActivity.e(ShareActivity.this);
                    ShareActivity.a(ShareActivity.this, "Fotor_Share_Rate_Rate_Us_Click");
                }

                public void b(FotorAlertDialog paramAnonymousFotorAlertDialog) {
                    PreferenceUtils.a(ShareActivity.this, new PreferenceUtils.RateUsAction(PreferenceUtils.RateUsAction.ActionType.LATER, new Date(System.currentTimeMillis())));
                    ShareActivity.b(ShareActivity.this, "Fotor_Share_Rate_Later_Click");
                }

                public void c(FotorAlertDialog paramAnonymousFotorAlertDialog) {
                }
            });
            localFotorAlertDialog.a(new DialogInterface.OnKeyListener() {
                public boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent) {
                    if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 1)) {
                        ShareActivity.a().c(new Object[]{"onKey code back"});
                        PreferenceUtils.a(ShareActivity.this, new PreferenceUtils.RateUsAction(PreferenceUtils.RateUsAction.ActionType.NO_THANKS, new Date(System.currentTimeMillis())));
                        ShareActivity.c(ShareActivity.this, "Fotor_Share_Rate_No_Thanks_Click");
                    }
                    return false;
                }
            });
            localFotorAlertDialog.a(getSupportFragmentManager(), "rate_us", true);
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    private void e() {
        b.c(new Object[]{"onRateUs"});
        a("Fotor_Rate_Us_Click");
        App.b(this);
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903213);
        b();
        Object localObject1 = getIntent();
        if ((localObject1 == null) || (((Intent) localObject1).getData() == null)) {
            b.e(new Object[]{"share image uri is null"});
            finish();
            return;
        }
        this.j = ((Intent) localObject1).getData();
        this.k = ((Intent) localObject1).getStringExtra("extra_fotor_session_id");
        this.o = ((HomeActivity.SDKModule) ((Intent) localObject1).getSerializableExtra("extra_sdk_module"));
        this.l = ((Intent) localObject1).getBooleanExtra("extra_is_bitmap_changed", false);
        this.c = new ArrayList();
        this.d = new ArrayList();
        localObject1 = getPackageManager();
        Object localObject2 = new Intent("android.intent.action.SEND");
        ((Intent) localObject2).addCategory("android.intent.category.DEFAULT");
        ((Intent) localObject2).setDataAndType(null, "image/*");
        Object localObject3 = ((PackageManager) localObject1).queryIntentActivities((Intent) localObject2, 65536);
        this.e = new ArrayList();
        localObject2 = getPackageName();
        if ((localObject3 != null) && (((List) localObject3).size() > 0)) {
            localObject3 = ((List) localObject3).iterator();
            while (((Iterator) localObject3).hasNext()) {
                ResolveInfo localResolveInfo = (ResolveInfo) ((Iterator) localObject3).next();
                String str = localResolveInfo.activityInfo.packageName;
                if (h.contains(str)) {
                    this.c.add(localResolveInfo);
                } else if ((str != null) && (!str.equals(localObject2))) {
                    this.d.add(localResolveInfo);
                }
            }
        }
        if ((this.c.size() > 0) && (this.d.size() > 0)) {
        }
        for (boolean bool = true; ; bool = false) {
            this.i = bool;
            this.e.clear();
            a((PackageManager) localObject1, this.c, getText(2131296647));
            a((PackageManager) localObject1, this.d, getText(2131296648));
            this.g = new b(null);
            this.f.setAdapter(this.g);
            this.f.setOnItemClickListener(this);
            b.c(new Object[]{"mBitmapChanged:" + this.l, "savedInstanceState:" + paramBundle});
            if (paramBundle != null) {
                break;
            }
            if (this.m != null) {
                this.m.cancel(true);
            }
            if (!this.l) {
                break label527;
            }
            this.m = new a(this, this.k);
            this.m.execute(new Void[0]);
            return;
        }
        label527:
        c();
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131755013, paramMenu);
        return true;
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        a(this.g.a(paramInt));
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2131558933) {
            if (!this.n) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        Intent localIntent = new Intent(ShareActivity.this, HomeActivity.class);
                        localIntent.setFlags(67108864);
                        ShareActivity.this.startActivity(localIntent);
                        ShareActivity.this.finish();
                        ShareActivity.a(ShareActivity.this, false);
                    }
                }, 100L);
            }
            this.n = true;
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    protected void onPause() {
        super.onPause();
        com.everimaging.fotorsdk.engine.d.a(this, 0);
    }

    protected void onResume() {
        super.onResume();
        com.everimaging.fotorsdk.engine.d.a(this, 2);
    }

    class a
            extends FotorAsyncTask<Void, Void, String> {
        private ProgressDialog b;
        private Context c;
        private String d;

        public a(Context paramContext, String paramString) {
            this.c = paramContext;
            this.d = paramString;
        }

        protected String a(Void... paramVarArgs) {
            paramVarArgs = null;
            if (ShareActivity.c(ShareActivity.this) == HomeActivity.SDKModule.EDITOR) {
                paramVarArgs = ShareActivity.a(ShareActivity.this, this.c, this.d);
            }
            for (; ; ) {
                Utils.printMemoryInfo();
                return paramVarArgs;
                if (ShareActivity.c(ShareActivity.this) == HomeActivity.SDKModule.COLLAGE) {
                    paramVarArgs = ShareActivity.b(ShareActivity.this, this.c, this.d);
                }
            }
        }

        protected void a(String paramString) {

            try {
                if (this.b != null) {
                    this.b.dismiss();
                }
                String str = ShareActivity.this.getString(2131296642);
                if (paramString != null) {
                    com.everimaging.fotor.picture.album.a.a(paramString);
                    str = ShareActivity.this.getString(2131296641);
                }
                Toast.makeText(this.c, str, 1).show();
                ShareActivity.d(ShareActivity.this);
                return;
            } catch (Exception paramString) {
                paramString.printStackTrace();
            }
        }

        protected void onPreExecute() {
            this.b = ProgressDialog.show(this.c, null, ShareActivity.this.getText(2131296640));
        }
    }

    private class b
            extends BaseAdapter {
        private b() {
        }

        public ShareActivity.c a(int paramInt) {
            return (ShareActivity.c) ShareActivity.a(ShareActivity.this).get(paramInt);
        }

        public boolean areAllItemsEnabled() {
            return false;
        }

        public int getCount() {
            return ShareActivity.a(ShareActivity.this).size();
        }

        public long getItemId(int paramInt) {
            return paramInt;
        }

        public int getItemViewType(int paramInt) {
            if (a(paramInt).d) {
                return 1;
            }
            return 0;
        }

        public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
            Object localObject = (ShareActivity.c) ShareActivity.a(ShareActivity.this).get(paramInt);
            paramInt = getItemViewType(paramInt);
            paramViewGroup = paramView;
            CharSequence localCharSequence;
            if (paramView == null) {
                if (paramInt == 0) {
                    paramViewGroup = ShareActivity.this.getLayoutInflater().inflate(17367042, null);
                }
            } else {
                paramView = (TextView) paramViewGroup.findViewById(16908310);
                if (paramView != null) {
                    localCharSequence = ((ShareActivity.c) localObject).b;
                    if (!TextUtils.isEmpty(localCharSequence)) {
                        break label142;
                    }
                    paramView.setVisibility(8);
                }
                label83:
                paramView = (ImageView) paramViewGroup.findViewById(16908294);
                if (paramView != null) {
                    localObject = ((ShareActivity.c) localObject).a;
                    paramView.setImageDrawable((Drawable) localObject);
                    if (localObject != null) {
                        break label156;
                    }
                }
            }
            label142:
            label156:
            for (paramInt = 8; ; paramInt = 0) {
                paramView.setVisibility(paramInt);
                return paramViewGroup;
                paramViewGroup = ShareActivity.this.getLayoutInflater().inflate(2130903214, null);
                break;
                paramView.setText(localCharSequence);
                paramView.setVisibility(0);
                break label83;
            }
        }

        public int getViewTypeCount() {
            if (ShareActivity.b(ShareActivity.this)) {
                return 2;
            }
            return 1;
        }

        public boolean hasStableIds() {
            return true;
        }

        public boolean isEnabled(int paramInt) {
            if ((paramInt < 0) || (paramInt >= getCount())) {
                return true;
            }
            return a(paramInt).d;
        }
    }

    class c {
        Drawable a;
        CharSequence b;
        ResolveInfo c;
        boolean d;

        c() {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/share/ShareActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */