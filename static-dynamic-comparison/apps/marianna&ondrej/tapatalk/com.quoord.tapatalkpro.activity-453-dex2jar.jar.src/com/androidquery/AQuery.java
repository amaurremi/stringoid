package com.androidquery;

import android.app.Activity;
import android.content.Context;
import android.view.View;

public class AQuery
        extends AbstractAQuery<AQuery> {
    public AQuery(Activity paramActivity) {
        super(paramActivity);
    }

    public AQuery(Activity paramActivity, View paramView) {
        super(paramActivity, paramView);
    }

    public AQuery(Context paramContext) {
        super(paramContext);
    }

    public AQuery(View paramView) {
        super(paramView);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/androidquery/AQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */