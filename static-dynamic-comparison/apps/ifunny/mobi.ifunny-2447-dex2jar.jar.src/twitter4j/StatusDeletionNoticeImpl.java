package twitter4j;

import java.io.Serializable;

class StatusDeletionNoticeImpl
        implements Serializable, StatusDeletionNotice {
    private static final long serialVersionUID = 9144204870473786368L;
    private final long statusId;
    private final long userId;

    StatusDeletionNoticeImpl(JSONObject paramJSONObject) {
        this.statusId = ParseUtil.getLong("id", paramJSONObject);
        this.userId = ParseUtil.getLong("user_id", paramJSONObject);
    }

    public int compareTo(StatusDeletionNotice paramStatusDeletionNotice) {
        long l = this.statusId - paramStatusDeletionNotice.getStatusId();
        if (l < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        if (l > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) l;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if ((paramObject == null) || (getClass() != paramObject.getClass())) {
                return false;
            }
            paramObject = (StatusDeletionNoticeImpl) paramObject;
            if (this.statusId != ((StatusDeletionNoticeImpl) paramObject).statusId) {
                return false;
            }
        } while (this.userId == ((StatusDeletionNoticeImpl) paramObject).userId);
        return false;
    }

    public long getStatusId() {
        return this.statusId;
    }

    public long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return (int) (this.statusId ^ this.statusId >>> 32) * 31 + (int) (this.userId ^ this.userId >>> 32);
    }

    public String toString() {
        return "StatusDeletionNoticeImpl{statusId=" + this.statusId + ", userId=" + this.userId + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/StatusDeletionNoticeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */