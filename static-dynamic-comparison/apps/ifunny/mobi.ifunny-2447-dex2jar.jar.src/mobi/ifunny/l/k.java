package mobi.ifunny.l;

import android.os.AsyncTask;

import java.util.concurrent.atomic.AtomicBoolean;

class k
        extends AsyncTask<Params, Progress, Result> {
    private k(i parami) {
    }

    private void a(Result paramResult) {
        if (!i.access$400(this.a).get()) {
            i.access$400(this.a).set(true);
            i.access$200(this.a).b(this.a);
            paramResult = new o(this, this.a.subscribeId, this.a, paramResult);
            i.access$200(this.a).a(paramResult);
            if (!i.access$100(this.a).get()) {
                paramResult = new p(this, this.a.subscribeId, this.a);
                i.access$200(this.a).a(paramResult);
            }
        }
    }

    public void a(Progress... paramVarArgs) {
        publishProgress(paramVarArgs);
    }

    protected Result doInBackground(Params... paramVarArgs) {
        return (Result) this.a.doInBackground(paramVarArgs);
    }

    protected void onCancelled() {
        onCancelled(null);
    }

    protected void onCancelled(Result paramResult) {
        a(paramResult);
    }

    protected void onPostExecute(Result paramResult) {
        if (i.access$300(this.a).get()) {
            a(paramResult);
        }
        while (i.access$400(this.a).get()) {
            return;
        }
        i.access$400(this.a).set(true);
        i.access$200(this.a).b(this.a);
        paramResult = new n(this, this.a.subscribeId, this.a, paramResult);
        i.access$200(this.a).a(paramResult);
    }

    protected void onPreExecute() {
        if (!i.access$100(this.a).get()) {
            l locall = new l(this, this.a.subscribeId, this.a);
            i.access$200(this.a).a(locall);
        }
    }

    protected void onProgressUpdate(Progress... paramVarArgs) {
        if (!i.access$100(this.a).get()) {
            paramVarArgs = new m(this, this.a.subscribeId, this.a, paramVarArgs);
            i.access$200(this.a).a(paramVarArgs);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/l/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */