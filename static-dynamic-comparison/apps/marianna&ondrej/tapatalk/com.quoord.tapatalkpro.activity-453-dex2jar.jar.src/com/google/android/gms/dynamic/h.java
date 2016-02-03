package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

public final class h
        extends c.a {
    private Fragment Hz;

    private h(Fragment paramFragment) {
        this.Hz = paramFragment;
    }

    public static h a(Fragment paramFragment) {
        if (paramFragment != null) {
            return new h(paramFragment);
        }
        return null;
    }

    public void b(d paramd) {
        paramd = (View) e.d(paramd);
        this.Hz.registerForContextMenu(paramd);
    }

    public void c(d paramd) {
        paramd = (View) e.d(paramd);
        this.Hz.unregisterForContextMenu(paramd);
    }

    public d fX() {
        return e.h(this.Hz.getActivity());
    }

    public c fY() {
        return a(this.Hz.getParentFragment());
    }

    public d fZ() {
        return e.h(this.Hz.getResources());
    }

    public c ga() {
        return a(this.Hz.getTargetFragment());
    }

    public Bundle getArguments() {
        return this.Hz.getArguments();
    }

    public int getId() {
        return this.Hz.getId();
    }

    public boolean getRetainInstance() {
        return this.Hz.getRetainInstance();
    }

    public String getTag() {
        return this.Hz.getTag();
    }

    public int getTargetRequestCode() {
        return this.Hz.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.Hz.getUserVisibleHint();
    }

    public d getView() {
        return e.h(this.Hz.getView());
    }

    public boolean isAdded() {
        return this.Hz.isAdded();
    }

    public boolean isDetached() {
        return this.Hz.isDetached();
    }

    public boolean isHidden() {
        return this.Hz.isHidden();
    }

    public boolean isInLayout() {
        return this.Hz.isInLayout();
    }

    public boolean isRemoving() {
        return this.Hz.isRemoving();
    }

    public boolean isResumed() {
        return this.Hz.isResumed();
    }

    public boolean isVisible() {
        return this.Hz.isVisible();
    }

    public void setHasOptionsMenu(boolean paramBoolean) {
        this.Hz.setHasOptionsMenu(paramBoolean);
    }

    public void setMenuVisibility(boolean paramBoolean) {
        this.Hz.setMenuVisibility(paramBoolean);
    }

    public void setRetainInstance(boolean paramBoolean) {
        this.Hz.setRetainInstance(paramBoolean);
    }

    public void setUserVisibleHint(boolean paramBoolean) {
        this.Hz.setUserVisibleHint(paramBoolean);
    }

    public void startActivity(Intent paramIntent) {
        this.Hz.startActivity(paramIntent);
    }

    public void startActivityForResult(Intent paramIntent, int paramInt) {
        this.Hz.startActivityForResult(paramIntent, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/dynamic/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */