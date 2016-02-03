package mobi.ifunny.studio.publish;

import android.widget.Toast;
import mobi.ifunny.IFunnyApplication;
import mobi.ifunny.l.b;
import mobi.ifunny.util.l;

final class d
        extends b<PublishDraftActivity, Void, Void, Object> {
    private final byte[] a;
    private final String b;

    public d(PublishDraftActivity paramPublishDraftActivity, String paramString1, byte[] paramArrayOfByte, String paramString2) {
        super(paramPublishDraftActivity, paramString1);
        this.a = paramArrayOfByte;
        this.b = paramString2;
    }

    protected Object a(Void... paramVarArgs) {
        if (l.a(IFunnyApplication.a, this.a, this.b)) {
            return this;
        }
        return null;
    }

    protected void a(PublishDraftActivity paramPublishDraftActivity, Object paramObject) {
        super.onPostExecute(paramPublishDraftActivity, paramObject);
        if (paramObject == null) {
            Toast.makeText(paramPublishDraftActivity, 2131689629, 0).show();
            return;
        }
        Toast.makeText(paramPublishDraftActivity, 2131689635, 0).show();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/publish/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */