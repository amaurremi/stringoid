package com.amazon.device.ads;

import android.os.AsyncTask;

class AdMetricsSubmitAaxTask
        extends AsyncTask<WebRequest, Void, Void> {
    private static final String LOG_TAG = "AdMetricsSubmitTask";

    public Void doInBackground(WebRequest... paramVarArgs) {
        int j = paramVarArgs.length;
        int i = 0;
        for (; ; ) {
            if (i < j) {
                WebRequest localWebRequest = paramVarArgs[i];
                try {
                    localWebRequest.makeCall();
                    i += 1;
                } catch (WebRequest.WebRequestException localWebRequestException) {
                    for (; ; ) {
                        switch (localWebRequestException.getStatus()) {
                            default:
                                break;
                            case???:
                            Log.e("AdMetricsSubmitTask", "Unable to submit metrics for ad due to an Invalid Client Protocol, msg: %s", new Object[]{localWebRequestException.getMessage()});
                            break;
                            case???:
                            Log.e("AdMetricsSubmitTask", "Unable to submit metrics for ad due to Network Failure, msg: %s", new Object[]{localWebRequestException.getMessage()});
                            break;
                            case???:
                            Log.e("AdMetricsSubmitTask", "Unable to submit metrics for ad due to a Malformed Pixel URL, msg: %s", new Object[]{localWebRequestException.getMessage()});
                            case???:
                            Log.e("AdMetricsSubmitTask", "Unable to submit metrics for ad because of unsupported character encoding, msg: %s", new Object[]{localWebRequestException.getMessage()});
                        }
                    }
                }
            }
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/AdMetricsSubmitAaxTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */