package com.google.android.gms.dynamic;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public final class b
        extends c.a {
    private Fragment Hv;

    private b(Fragment paramFragment) {
        this.Hv = paramFragment;
    }

    public static b a(Fragment paramFragment) {
        if (paramFragment != null) {
            return new b(paramFragment);
        }
        return null;
    }

    public void b(d paramd) {
        paramd = (View) e.d(paramd);
        this.Hv.registerForContextMenu(paramd);
    }

    public void c(d paramd) {
        paramd = (View) e.d(paramd);
        this.Hv.unregisterForContextMenu(paramd);
    }

    public d fX() {
        return e.h(this.Hv.getActivity());
    }

    public c fY() {
        return a(this.Hv.getParentFragment());
    }

    public d fZ() {
        return e.h(this.Hv.getResources());
    }

    public c ga() {
        return a(this.Hv.getTargetFragment());
    }

    public Bundle getArguments() {
        return this.Hv.getArguments();
    }

    public int getId() {
        return this.Hv.getId();
    }

    public boolean getRetainInstance() {
        return this.Hv.getRetainInstance();
    }

    public String getTag() {
        return this.Hv.getTag();
    }

    public int getTargetRequestCode() {
        return this.Hv.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.Hv.getUserVisibleHint();
    }

    public d getView() {
        return e.h(this.Hv.getView());
    }

    public boolean isAdded() {
        return this.Hv.isAdded();
    }

    public boolean isDetached() {
        return this.Hv.isDetached();
    }

    public boolean isHidden() {
        return this.Hv.isHidden();
    }

    public boolean isInLayout() {
        return this.Hv.isInLayout();
    }

    public boolean isRemoving() {
        return this.Hv.isRemoving();
    }

    public boolean isResumed() {
        return this.Hv.isResumed();
    }

    public boolean isVisible() {
        return this.Hv.isVisible();
    }

    public void setHasOptionsMenu(boolean paramBoolean) {
        this.Hv.setHasOptionsMenu(paramBoolean);
    }

    public void setMenuVisibility(boolean paramBoolean) {
        this.Hv.setMenuVisibility(paramBoolean);
    }

    public void setRetainInstance(boolean paramBoolean) {
        this.Hv.setRetainInstance(paramBoolean);
    }

    public void setUserVisibleHint(boolean paramBoolean) {
        this.Hv.setUserVisibleHint(paramBoolean);
    }

    public void startActivity(Intent paramIntent) {
        this.Hv.startActivity(paramIntent);
    }

    public void startActivityForResult(Intent paramIntent, int paramInt) {
        this.Hv.startActivityForResult(paramIntent, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/dynamic/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */