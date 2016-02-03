package com.millennialmedia.android;

import com.nuance.nmdp.speechkit.DataUploadCommand;
import com.nuance.nmdp.speechkit.DataUploadCommand.Listener;
import com.nuance.nmdp.speechkit.DataUploadResult;
import com.nuance.nmdp.speechkit.SpeechError;

class NVASpeechKit$4
        implements DataUploadCommand.Listener {
    NVASpeechKit$4(NVASpeechKit paramNVASpeechKit) {
    }

    private void a(DataUploadCommand paramDataUploadCommand) {
        if ((NVASpeechKit.c(this.a) != null) && (NVASpeechKit.h(this.a) == paramDataUploadCommand)) {
            if (NVASpeechKit.i(this.a) != NVASpeechKit.CustomWordsOp.Add) {
                break label56;
            }
            NVASpeechKit.c(this.a).onCustomWordsAdded();
        }
        for (; ; ) {
            NVASpeechKit.a(this.a, null);
            return;
            label56:
            NVASpeechKit.c(this.a).onCustomWordsDeleted();
        }
    }

    public void onError(DataUploadCommand paramDataUploadCommand, SpeechError paramSpeechError) {
        MMLog.e("NVASpeechKit", "DataUploadCommand listener error. command:" + paramDataUploadCommand.toString() + " Error:" + paramSpeechError.getErrorDetail());
        a(paramDataUploadCommand);
    }

    public void onResults(DataUploadCommand paramDataUploadCommand, DataUploadResult paramDataUploadResult) {
        MMLog.b("NVASpeechKit", "DataUploadCommand listener successful command:" + paramDataUploadCommand.toString() + " isVocRegenerated:" + paramDataUploadResult.isVocRegenerated() + " results:" + paramDataUploadResult.toString());
        a(paramDataUploadCommand);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/NVASpeechKit$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */