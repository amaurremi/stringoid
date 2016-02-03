package com.everimaging.fotorsdk.utils;

public class SimpleStatusMachine {
    public static int INVALID_STATUS = -1;
    private int currentStatus = INVALID_STATUS;
    private OnStatusChangeListener mStatusListener;
    private int previousStatus = INVALID_STATUS;

    public int getCurrentStatus() {
        return this.currentStatus;
    }

    public void setOnStatusChangeListener(OnStatusChangeListener paramOnStatusChangeListener) {
        this.mStatusListener = paramOnStatusChangeListener;
    }

    public void setStatus(int paramInt) {
        if (paramInt != this.currentStatus) {
            this.previousStatus = this.currentStatus;
            this.currentStatus = paramInt;
            if (this.mStatusListener != null) {
                this.mStatusListener.OnStatusChanged(this.previousStatus, this.currentStatus);
            }
        }
        while (this.mStatusListener == null) {
            return;
        }
        this.mStatusListener.OnStatusUpdated(paramInt);
    }

    public static abstract interface OnStatusChangeListener {
        public abstract void OnStatusChanged(int paramInt1, int paramInt2);

        public abstract void OnStatusUpdated(int paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/utils/SimpleStatusMachine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */