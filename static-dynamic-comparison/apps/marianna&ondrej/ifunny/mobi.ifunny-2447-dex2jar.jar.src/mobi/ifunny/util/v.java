package mobi.ifunny.util;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import mobi.ifunny.profile.ProfileActivity;
import mobi.ifunny.rest.content.Counters;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.userlists.UserListActivity;

public class v {
    public static void a(Activity paramActivity, String paramString) {
        if ((paramActivity == null) || (TextUtils.isEmpty(paramString))) {
            return;
        }
        Intent localIntent = new Intent(paramActivity, ProfileActivity.class);
        localIntent.putExtra("intent.uid", paramString);
        paramActivity.startActivity(localIntent);
    }

    public static void a(Activity paramActivity, String paramString, int paramInt) {
        if ((paramActivity == null) || (TextUtils.isEmpty(paramString))) {
            return;
        }
        Intent localIntent = new Intent(paramActivity, UserListActivity.class);
        localIntent.putExtra("intent.uid", paramString);
        localIntent.putExtra("intent.user_list_type", 2);
        localIntent.putExtra("intent.users_count", paramInt);
        paramActivity.startActivity(localIntent);
    }

    public static void a(Activity paramActivity, IFunny paramIFunny) {
        if ((paramActivity == null) || (paramIFunny == null)) {
            return;
        }
        Intent localIntent = new Intent(paramActivity, UserListActivity.class);
        localIntent.putExtra("intent.content", paramIFunny);
        localIntent.putExtra("intent.user_list_type", 3);
        localIntent.putExtra("intent.users_count", paramIFunny.num.smiles);
        paramActivity.startActivity(localIntent);
    }

    public static void b(Activity paramActivity, String paramString, int paramInt) {
        if ((paramActivity == null) || (TextUtils.isEmpty(paramString))) {
            return;
        }
        Intent localIntent = new Intent(paramActivity, UserListActivity.class);
        localIntent.putExtra("intent.uid", paramString);
        localIntent.putExtra("intent.user_list_type", 1);
        localIntent.putExtra("intent.users_count", paramInt);
        paramActivity.startActivity(localIntent);
    }

    public static void b(Activity paramActivity, IFunny paramIFunny) {
        if ((paramActivity == null) || (paramIFunny == null)) {
            return;
        }
        Intent localIntent = new Intent(paramActivity, UserListActivity.class);
        localIntent.putExtra("intent.content", paramIFunny);
        localIntent.putExtra("intent.user_list_type", 4);
        localIntent.putExtra("intent.users_count", paramIFunny.num.republished);
        paramActivity.startActivity(localIntent);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */