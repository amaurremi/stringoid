package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.a.c;
import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;

public class ct
        implements Iterable<Intent> {
    private static final cv a = new cw();
    private final ArrayList<Intent> b = new ArrayList();
    private final Context c;

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            a = new cx();
            return;
        }
    }

    private ct(Context paramContext) {
        this.c = paramContext;
    }

    public static ct a(Context paramContext) {
        return new ct(paramContext);
    }

    public ct a(Activity paramActivity) {
        Object localObject = null;
        if ((paramActivity instanceof cu)) {
            localObject = ((cu) paramActivity).a_();
        }
        if (localObject == null) {
        }
        for (paramActivity = aj.a(paramActivity); ; paramActivity = (Activity) localObject) {
            if (paramActivity != null) {
                ComponentName localComponentName = paramActivity.getComponent();
                localObject = localComponentName;
                if (localComponentName == null) {
                    localObject = paramActivity.resolveActivity(this.c.getPackageManager());
                }
                a((ComponentName) localObject);
                a(paramActivity);
            }
            return this;
        }
    }

    public ct a(ComponentName paramComponentName) {
        int i = this.b.size();
        try {
            for (paramComponentName = aj.a(this.c, paramComponentName); paramComponentName != null; paramComponentName = aj.a(this.c, paramComponentName.getComponent())) {
                this.b.add(i, paramComponentName);
            }
            return this;
        } catch (PackageManager.NameNotFoundException paramComponentName) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(paramComponentName);
        }
    }

    public ct a(Intent paramIntent) {
        this.b.add(paramIntent);
        return this;
    }

    public void a() {
        a(null);
    }

    public void a(Bundle paramBundle) {
        if (this.b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] arrayOfIntent = (Intent[]) this.b.toArray(new Intent[this.b.size()]);
        arrayOfIntent[0] = new Intent(arrayOfIntent[0]).addFlags(268484608);
        if (!c.a(this.c, arrayOfIntent, paramBundle)) {
            paramBundle = new Intent(arrayOfIntent[(arrayOfIntent.length - 1)]);
            paramBundle.addFlags(268435456);
            this.c.startActivity(paramBundle);
        }
    }

    public ct b(Intent paramIntent) {
        ComponentName localComponentName2 = paramIntent.getComponent();
        ComponentName localComponentName1 = localComponentName2;
        if (localComponentName2 == null) {
            localComponentName1 = paramIntent.resolveActivity(this.c.getPackageManager());
        }
        if (localComponentName1 != null) {
            a(localComponentName1);
        }
        a(paramIntent);
        return this;
    }

    public Iterator<Intent> iterator() {
        return this.b.iterator();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/ct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */