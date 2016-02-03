package mobi.ifunny.userlists;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ab;
import android.support.v4.app.q;
import mobi.ifunny.f;
import mobi.ifunny.gallery.GalleryFragment;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.util.r;

public class UserListActivity
        extends f {
    private static final String o = GalleryFragment.class.getSimpleName();

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903183);
    }

    protected void onPostCreate(Bundle paramBundle) {
        super.onPostCreate(paramBundle);
        Object localObject1;
        Object localObject2;
        int i;
        if (paramBundle == null) {
            paramBundle = getIntent();
            localObject1 = paramBundle.getStringExtra("intent.uid");
            localObject2 = (IFunny) paramBundle.getParcelableExtra("intent.content");
            i = paramBundle.getIntExtra("intent.users_count", -1);
            int j = paramBundle.getIntExtra("intent.user_list_type", -1);
            if (i < 0) {
                i = 0;
            }
            while (j < 0) {
                throw new IllegalArgumentException("Wrong user list type!");
            }
            paramBundle = null;
            switch (j) {
            }
        }
        for (; ; ) {
            paramBundle.b(i);
            localObject1 = f();
            localObject2 = ((q) localObject1).a();
            ((ab) localObject2).a(2131493364, paramBundle, o);
            ((ab) localObject2).b();
            ((q) localObject1).b();
            return;
            paramBundle = new d();
            ((d) paramBundle).a((String) localObject1);
            setTitle(r.b(getResources(), 2131623948, 2131690179, i));
            continue;
            paramBundle = new c();
            ((c) paramBundle).a((String) localObject1);
            setTitle(r.b(getResources(), 2131623947, 2131690177, i));
            continue;
            paramBundle = new b();
            ((b) paramBundle).a((IFunny) localObject2);
            setTitle(r.b(getResources(), 2131623946, 2131690174, i));
            continue;
            paramBundle = new a();
            ((a) paramBundle).a((IFunny) localObject2);
            setTitle(r.b(getResources(), 2131623945, 2131690171, i));
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/userlists/UserListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */