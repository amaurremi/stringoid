package com.quoord.viewmanager;

import android.view.View;

public class ToggleManager {
    private View antitheticalView;
    private View mainView;
    private boolean showMainView = true;

    public ToggleManager(View paramView1, View paramView2, boolean paramBoolean) {
        this.mainView = paramView1;
        this.antitheticalView = paramView2;
        this.showMainView = paramBoolean;
        toggle(paramBoolean);
    }

    private void toggle(boolean paramBoolean) {
        if (paramBoolean) {
            this.mainView.setVisibility(0);
            this.antitheticalView.setVisibility(8);
            return;
        }
        this.mainView.setVisibility(8);
        this.antitheticalView.setVisibility(0);
    }

    public boolean isMainShow() {
        return this.showMainView;
    }

    public void showAntithetical() {
        this.showMainView = false;
        toggle(this.showMainView);
    }

    public void showMain() {
        this.showMainView = true;
        toggle(this.showMainView);
    }

    public void toggle() {
        if (this.showMainView) {
        }
        for (boolean bool = false; ; bool = true) {
            this.showMainView = bool;
            toggle(this.showMainView);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/viewmanager/ToggleManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */