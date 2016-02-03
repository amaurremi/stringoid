package com.androidquery.util;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.view.View;
import android.widget.ProgressBar;
import com.androidquery.AQuery;

public class Progress
        implements Runnable {
    private Activity act;
    private int bytes;
    private int current;
    private ProgressBar pb;
    private ProgressDialog pd;
    private boolean unknown;
    private String url;
    private View view;

    public Progress(Object paramObject) {
        if ((paramObject instanceof ProgressBar)) {
            this.pb = ((ProgressBar) paramObject);
        }
        do {
            return;
            if ((paramObject instanceof ProgressDialog)) {
                this.pd = ((ProgressDialog) paramObject);
                return;
            }
            if ((paramObject instanceof Activity)) {
                this.act = ((Activity) paramObject);
                return;
            }
        } while (!(paramObject instanceof View));
        this.view = ((View) paramObject);
    }

    private void dismiss(String paramString) {
        if (this.pd != null) {
            new AQuery(this.pd.getContext()).dismiss(this.pd);
        }
        if (this.act != null) {
            this.act.setProgressBarIndeterminateVisibility(false);
            this.act.setProgressBarVisibility(false);
        }
        if (this.pb != null) {
            this.pb.setTag(1090453505, paramString);
            this.pb.setVisibility(0);
        }
        Object localObject2 = this.pb;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            localObject1 = this.view;
        }
        if (localObject1 != null) {
            localObject2 = ((View) localObject1).getTag(1090453505);
            if ((localObject2 == null) || (localObject2.equals(paramString))) {
                ((View) localObject1).setTag(1090453505, null);
                if ((this.pb != null) && (this.pb.isIndeterminate())) {
                    ((View) localObject1).setVisibility(8);
                }
            }
        }
    }

    private void showProgress(Object paramObject, String paramString, boolean paramBoolean) {
        View localView;
        ProgressBar localProgressBar;
        if (paramObject != null) {
            if (!(paramObject instanceof View)) {
                break label119;
            }
            localView = (View) paramObject;
            localProgressBar = null;
            if ((paramObject instanceof ProgressBar)) {
                localProgressBar = (ProgressBar) paramObject;
            }
            if (!paramBoolean) {
                break label70;
            }
            localView.setTag(1090453505, paramString);
            localView.setVisibility(0);
            if (localProgressBar != null) {
                localProgressBar.setProgress(0);
                localProgressBar.setMax(100);
            }
        }
        label70:
        label119:
        do {
            do {
                do {
                    do {
                        return;
                        paramObject = localView.getTag(1090453505);
                    } while ((paramObject != null) && (!paramObject.equals(paramString)));
                    localView.setTag(1090453505, null);
                } while ((localProgressBar == null) || (!localProgressBar.isIndeterminate()));
                localView.setVisibility(8);
                return;
                if ((paramObject instanceof Dialog)) {
                    paramObject = (Dialog) paramObject;
                    paramString = new AQuery(((Dialog) paramObject).getContext());
                    if (paramBoolean) {
                        paramString.show((Dialog) paramObject);
                        return;
                    }
                    paramString.dismiss((Dialog) paramObject);
                    return;
                }
            } while (!(paramObject instanceof Activity));
            paramObject = (Activity) paramObject;
            ((Activity) paramObject).setProgressBarIndeterminateVisibility(paramBoolean);
            ((Activity) paramObject).setProgressBarVisibility(paramBoolean);
        } while (!paramBoolean);
        ((Activity) paramObject).setProgress(0);
    }

    public void done() {
        if (this.pb != null) {
            this.pb.setProgress(this.pb.getMax());
        }
        if (this.pd != null) {
            this.pd.setProgress(this.pd.getMax());
        }
        if (this.act != null) {
            this.act.setProgress(9999);
        }
    }

    public void hide(String paramString) {
        if (AQUtility.isUIThread()) {
            dismiss(paramString);
            return;
        }
        this.url = paramString;
        AQUtility.post(this);
    }

    public void increment(int paramInt) {
        int j = 1;
        Object localObject;
        int i;
        if (this.pb != null) {
            localObject = this.pb;
            if (this.unknown) {
                i = 1;
                ((ProgressBar) localObject).incrementProgressBy(i);
            }
        } else {
            if (this.pd != null) {
                localObject = this.pd;
                if (!this.unknown) {
                    break label111;
                }
                i = j;
                label52:
                ((ProgressDialog) localObject).incrementProgressBy(i);
            }
            if (this.act != null) {
                if (!this.unknown) {
                    break label116;
                }
                paramInt = this.current;
                this.current = (paramInt + 1);
            }
        }
        for (; ; ) {
            i = paramInt;
            if (paramInt > 9999) {
                i = 9999;
            }
            this.act.setProgress(i);
            return;
            i = paramInt;
            break;
            label111:
            i = paramInt;
            break label52;
            label116:
            this.current += paramInt;
            paramInt = this.current * 10000 / this.bytes;
        }
    }

    public void reset() {
        if (this.pb != null) {
            this.pb.setProgress(0);
            this.pb.setMax(10000);
        }
        if (this.pd != null) {
            this.pd.setProgress(0);
            this.pd.setMax(10000);
        }
        if (this.act != null) {
            this.act.setProgress(0);
        }
        this.unknown = false;
        this.current = 0;
        this.bytes = 10000;
    }

    public void run() {
        dismiss(this.url);
    }

    public void setBytes(int paramInt) {
        int i = paramInt;
        if (paramInt <= 0) {
            this.unknown = true;
            i = 10000;
        }
        this.bytes = i;
        if (this.pb != null) {
            this.pb.setProgress(0);
            this.pb.setMax(i);
        }
        if (this.pd != null) {
            this.pd.setProgress(0);
            this.pd.setMax(i);
        }
    }

    public void show(String paramString) {
        reset();
        if (this.pd != null) {
            new AQuery(this.pd.getContext()).show(this.pd);
        }
        if (this.act != null) {
            this.act.setProgressBarIndeterminateVisibility(true);
            this.act.setProgressBarVisibility(true);
        }
        if (this.pb != null) {
            this.pb.setTag(1090453505, paramString);
            this.pb.setVisibility(0);
        }
        if (this.view != null) {
            this.view.setTag(1090453505, paramString);
            this.view.setVisibility(0);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/androidquery/util/Progress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */