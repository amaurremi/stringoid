package com.millennialmedia.android;

public class NVASpeechKit$Result {
    public final int resultScore;
    public final String resultString;

    public NVASpeechKit$Result(NVASpeechKit paramNVASpeechKit, String paramString, double paramDouble) {
        this.resultString = paramString;
        this.resultScore = ((int) paramDouble);
    }

    public int getResultScore() {
        return this.resultScore;
    }

    public String getResultString() {
        return this.resultString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/NVASpeechKit$Result.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */