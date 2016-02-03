package com.facebook.widget;

import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;

class PlacePickerFragment$3
        implements Runnable {
    PlacePickerFragment$3(PlacePickerFragment paramPlacePickerFragment) {
    }

    public void run() {
        try {
            this.this$0.loadData(true);
            PickerFragment.OnErrorListener localOnErrorListener1;
            return;
        } catch (FacebookException localFacebookException1) {
            while (localFacebookException1 == null) {
            }
            localOnErrorListener2 = this.this$0.getOnErrorListener();
            if (localOnErrorListener2 == null) {
                break label84;
            }
            localOnErrorListener2.onError(this.this$0, localFacebookException1);
            return;
            Logger.log(LoggingBehavior.REQUESTS, "PlacePickerFragment", "Error loading data : %s", new Object[]{localFacebookException1});
            return;
        } catch (Exception localException) {
            label84:
            do {
                localFacebookException2 = new FacebookException(localException);
            } while (localFacebookException2 == null);
            localOnErrorListener2 = this.this$0.getOnErrorListener();
            if (localOnErrorListener2 == null) {
                break label141;
            }
            localOnErrorListener2.onError(this.this$0, localFacebookException2);
            return;
            label141:
            Logger.log(LoggingBehavior.REQUESTS, "PlacePickerFragment", "Error loading data : %s", new Object[]{localFacebookException2});
            return;
        } finally {
            if (0 == 0) {
                break label188;
            }
            localOnErrorListener2 = this.this$0.getOnErrorListener();
            if (localOnErrorListener2 == null) {
                break label190;
            }
            localOnErrorListener2.onError(this.this$0, null);
        }
        Logger.log(LoggingBehavior.REQUESTS, "PlacePickerFragment", "Error loading data : %s", new Object[]{null});
        return;
        for (; ; ) {
            PickerFragment.OnErrorListener localOnErrorListener2;
            FacebookException localFacebookException2;
            label188:
            throw ((Throwable) localObject);
            label190:
            Logger.log(LoggingBehavior.REQUESTS, "PlacePickerFragment", "Error loading data : %s", new Object[]{null});
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/PlacePickerFragment$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */