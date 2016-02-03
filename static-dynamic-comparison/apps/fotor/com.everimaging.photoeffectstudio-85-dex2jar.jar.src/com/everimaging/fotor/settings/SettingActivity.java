package com.everimaging.fotor.settings;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.preference.PreferenceFragment;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.everimaging.fotor.App;
import com.everimaging.fotor.App.MarketType;
import com.everimaging.fotor.app.FotorAlertDialog;
import com.everimaging.fotor.b;
import com.everimaging.fotor.c.c;
import com.everimaging.fotor.log.LoggerFactory;
import com.everimaging.fotor.log.LoggerFactory.LoggerType;
import com.everimaging.fotor.log.LoggerFactory.c;
import com.everimaging.fotorsdk.utils.PackageManagerUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SettingActivity
        extends b {
    private static final String a = SettingActivity.class.getSimpleName();
    private static final LoggerFactory.c b = LoggerFactory.a(a, LoggerFactory.LoggerType.CONSOLE);
    private static final HashMap<String, Boolean> d = new HashMap();
    private SettingFragment c;

    static {
        d.put("com.android.bluetooth.opp", Boolean.valueOf(true));
        d.put("com.broadcom.bt.app.opp", Boolean.valueOf(true));
        d.put("mail", Boolean.valueOf(false));
        d.put("message", Boolean.valueOf(false));
        d.put("mms", Boolean.valueOf(false));
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903212);
        this.c = new SettingFragment();
        this.c.a(new SettingActivity.SettingFragment.b() {
            public void a(boolean paramAnonymousBoolean) {
                HashMap localHashMap = new HashMap();
                if (paramAnonymousBoolean) {
                }
                for (String str = "HOME"; ; str = "CAMERA") {
                    localHashMap.put("Fotor_Setting_Launch_Mode", str);
                    SettingActivity.a(SettingActivity.this, "Fotor_Setting_Launch_Mode", localHashMap);
                    return;
                }
            }
        });
        getSupportFragmentManager().beginTransaction().replace(2131558476, this.c).commit();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public static class SettingFragment
            extends PreferenceFragment
            implements Preference.OnPreferenceChangeListener, Preference.OnPreferenceClickListener {
        private PreferenceCategory a;
        private ListPreference b;
        private ListPreference c;
        private Preference d;
        private a e;
        private b f;
        private Context g;

        private void a() {
            int i = 0;
            PreferenceScreen localPreferenceScreen = getPreferenceScreen();
            this.a = ((PreferenceCategory) localPreferenceScreen.findPreference(this.g.getString(2131296543)));
            this.b = ((ListPreference) localPreferenceScreen.findPreference(this.g.getString(2131296544)));
            this.c = ((ListPreference) localPreferenceScreen.findPreference(this.g.getString(2131296546)));
            this.c.setOnPreferenceChangeListener(this);
            List localList = a.a();
            if ((localList != null) && (!localList.isEmpty())) {
                String[] arrayOfString1 = new String[localList.size()];
                String[] arrayOfString2 = new String[localList.size()];
                while (i < localList.size()) {
                    c localc = (c) localList.get(i);
                    arrayOfString1[i] = (localc.a + " x " + localc.b);
                    arrayOfString2[i] = localc.a();
                    i += 1;
                }
                this.b.setEntries(arrayOfString1);
                this.b.setEntryValues(arrayOfString2);
                this.b.setEnabled(true);
            }
            for (; ; ) {
                this.d = localPreferenceScreen.findPreference(this.g.getString(2131296548));
                this.d.setOnPreferenceClickListener(this);
                return;
                this.b.setEnabled(false);
                try {
                    this.a.removePreference(this.b);
                } catch (Exception localException) {
                }
            }
        }

        public void a(b paramb) {
            this.f = paramb;
        }

        public void onCreate(Bundle paramBundle) {
            super.onCreate(paramBundle);
            addPreferencesFromResource(2131034112);
            this.g = getActivity().getApplicationContext();
            a();
        }

        public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
            return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
        }

        public boolean onPreferenceChange(Preference paramPreference, Object paramObject) {
            if (paramPreference == this.c) {
                boolean bool = Boolean.valueOf((String) paramObject).booleanValue();
                if (this.f != null) {
                    this.f.a(bool);
                }
            }
            return true;
        }

        public boolean onPreferenceClick(Preference paramPreference) {
            if (paramPreference == this.d) {
                if (this.e == null) {
                    this.e = new a(getActivity());
                }
                paramPreference = new FotorAlertDialog();
                Bundle localBundle = new Bundle();
                localBundle.putCharSequence("TITLE", getString(2131296622));
                if (this.e.getCount() > 0) {
                    if (this.e.getCount() == 1) {
                        this.e.b(0);
                    }
                }
                for (; ; ) {
                    paramPreference.setArguments(localBundle);
                    paramPreference.show(getFragmentManager(), "");
                    return true;
                    paramPreference.a(this.e, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                            SettingActivity.SettingFragment.a(SettingActivity.SettingFragment.this).b(paramAnonymousInt);
                        }
                    });
                    continue;
                    localBundle.putCharSequence("MESSAGE", getText(2131296623));
                }
            }
            return false;
        }

        class a
                extends BaseAdapter {
            private final Intent b;
            private final LayoutInflater c;
            private PackageManager d = null;
            private List<a> e;
            private Context f;

            public a(Context paramContext) {
                this.f = paramContext;
                this.d = paramContext.getPackageManager();
                this.c = ((LayoutInflater) paramContext.getSystemService("layout_inflater"));
                this.b = new Intent("android.intent.action.SEND", null);
                this.b.addCategory("android.intent.category.DEFAULT");
                this.b.setType("*/*");
                this$1 = this.d.queryIntentActivities(this.b, 0);
                if ((SettingActivity.SettingFragment.this != null) && (!SettingActivity.SettingFragment.this.isEmpty())) {
                    this.e = new ArrayList();
                    while (i < SettingActivity.SettingFragment.this.size()) {
                        paramContext = (ResolveInfo) SettingActivity.SettingFragment.this.get(i);
                        if (!TextUtils.isEmpty(a(paramContext.activityInfo.name))) {
                            paramContext = new a(paramContext, paramContext.loadLabel(this.d));
                            this.e.add(paramContext);
                        }
                        i += 1;
                    }
                }
            }

            private String a(String paramString) {
                Object localObject = null;
                String str = null;
                if (TextUtils.isEmpty(paramString)) {
                    localObject = str;
                }
                Iterator localIterator;
                do {
                    return (String) localObject;
                    str = paramString.toLowerCase();
                    localIterator = SettingActivity.a().keySet().iterator();
                    paramString = (String) localObject;
                    localObject = paramString;
                } while (!localIterator.hasNext());
                localObject = (String) localIterator.next();
                if (str.contains((CharSequence) localObject)) {
                    paramString = (String) localObject;
                }
                for (; ; ) {
                    break;
                }
            }

            private final void a(View paramView, a parama) {
                paramView = (TextView) paramView.findViewById(16908308);
                paramView.setText(parama.b);
                if (parama.c == null) {
                    parama.c = parama.a.loadIcon(this.d);
                }
                paramView.setCompoundDrawablesWithIntrinsicBounds(parama.c, null, null, null);
            }

            public Intent a(int paramInt) {
                if ((this.e == null) && (this.e.isEmpty())) {
                    return null;
                }
                Object localObject = (a) this.e.get(paramInt);
                Intent localIntent = new Intent();
                localIntent.addFlags(50331648);
                localObject = ((a) localObject).a.activityInfo;
                String str1 = ((ActivityInfo) localObject).name;
                String str2 = a(str1);
                if (!TextUtils.isEmpty(str2)) {
                }
                for (boolean bool = ((Boolean) SettingActivity.a().get(str2)).booleanValue(); ; bool = false) {
                    localIntent.setAction("android.intent.action.SEND");
                    localIntent.setClassName(((ActivityInfo) localObject).applicationInfo.packageName, str1);
                    localIntent.setType("*/*");
                    if (bool) {
                        localObject = a(this.f);
                        if (localObject != null) {
                            localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile((File) localObject));
                        }
                    }
                    localIntent.putExtra("android.intent.extra.SUBJECT", SettingActivity.SettingFragment.this.getString(2131296620));
                    localIntent.putExtra("android.intent.extra.TEXT", SettingActivity.SettingFragment.this.getString(2131296621, new Object[]{App.a.getDownloadURL()}));
                    return localIntent;
                }
            }

            public File a(Context paramContext) {
                paramContext = PackageManagerUtils.getApplicationInfo(paramContext).publicSourceDir;
                SettingActivity.b().c(new Object[]{"file Path:" + paramContext});
                File localFile = new File(paramContext);
                paramContext = localFile;
                if (!localFile.exists()) {
                    paramContext = null;
                }
                return paramContext;
            }

            public void b(int paramInt) {
                Intent localIntent = a(paramInt);
                SettingActivity.SettingFragment.this.startActivity(localIntent);
            }

            public int getCount() {
                if (this.e != null) {
                    return this.e.size();
                }
                return 0;
            }

            public Object getItem(int paramInt) {
                return Integer.valueOf(paramInt);
            }

            public long getItemId(int paramInt) {
                return paramInt;
            }

            public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
                paramViewGroup = paramView;
                if (paramView == null) {
                    paramViewGroup = this.c.inflate(2130903211, null);
                }
                a(paramViewGroup, (a) this.e.get(paramInt));
                return paramViewGroup;
            }

            private final class a {
                ResolveInfo a;
                CharSequence b;
                Drawable c;

                a(ResolveInfo paramResolveInfo, CharSequence paramCharSequence) {
                    this.a = paramResolveInfo;
                    this.b = paramCharSequence;
                }
            }
        }

        public static abstract interface b {
            public abstract void a(boolean paramBoolean);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/settings/SettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */