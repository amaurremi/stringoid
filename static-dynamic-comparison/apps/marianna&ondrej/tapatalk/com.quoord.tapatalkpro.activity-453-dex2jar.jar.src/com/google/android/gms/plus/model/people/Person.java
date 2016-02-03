package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.Freezable;

import java.util.List;

public abstract interface Person
        extends Freezable<Person> {
    public abstract String getAboutMe();

    public abstract AgeRange getAgeRange();

    public abstract String getBirthday();

    public abstract String getBraggingRights();

    public abstract int getCircledByCount();

    public abstract Cover getCover();

    public abstract String getCurrentLocation();

    public abstract String getDisplayName();

    public abstract int getGender();

    public abstract String getId();

    public abstract Image getImage();

    public abstract String getLanguage();

    public abstract Name getName();

    public abstract String getNickname();

    public abstract int getObjectType();

    public abstract List<Organizations> getOrganizations();

    public abstract List<PlacesLived> getPlacesLived();

    public abstract int getPlusOneCount();

    public abstract int getRelationshipStatus();

    public abstract String getTagline();

    public abstract String getUrl();

    public abstract List<Urls> getUrls();

    public abstract boolean hasAboutMe();

    public abstract boolean hasAgeRange();

    public abstract boolean hasBirthday();

    public abstract boolean hasBraggingRights();

    public abstract boolean hasCircledByCount();

    public abstract boolean hasCover();

    public abstract boolean hasCurrentLocation();

    public abstract boolean hasDisplayName();

    public abstract boolean hasGender();

    public abstract boolean hasId();

    public abstract boolean hasImage();

    public abstract boolean hasIsPlusUser();

    public abstract boolean hasLanguage();

    public abstract boolean hasName();

    public abstract boolean hasNickname();

    public abstract boolean hasObjectType();

    public abstract boolean hasOrganizations();

    public abstract boolean hasPlacesLived();

    public abstract boolean hasPlusOneCount();

    public abstract boolean hasRelationshipStatus();

    public abstract boolean hasTagline();

    public abstract boolean hasUrl();

    public abstract boolean hasUrls();

    public abstract boolean hasVerified();

    public abstract boolean isPlusUser();

    public abstract boolean isVerified();

    public static abstract interface AgeRange
            extends Freezable<AgeRange> {
        public abstract int getMax();

        public abstract int getMin();

        public abstract boolean hasMax();

        public abstract boolean hasMin();
    }

    public static abstract interface Cover
            extends Freezable<Cover> {
        public abstract CoverInfo getCoverInfo();

        public abstract CoverPhoto getCoverPhoto();

        public abstract int getLayout();

        public abstract boolean hasCoverInfo();

        public abstract boolean hasCoverPhoto();

        public abstract boolean hasLayout();

        public static abstract interface CoverInfo
                extends Freezable<CoverInfo> {
            public abstract int getLeftImageOffset();

            public abstract int getTopImageOffset();

            public abstract boolean hasLeftImageOffset();

            public abstract boolean hasTopImageOffset();
        }

        public static abstract interface CoverPhoto
                extends Freezable<CoverPhoto> {
            public abstract int getHeight();

            public abstract String getUrl();

            public abstract int getWidth();

            public abstract boolean hasHeight();

            public abstract boolean hasUrl();

            public abstract boolean hasWidth();
        }

        public static final class Layout {
            public static final int BANNER = 0;
        }
    }

    public static final class Gender {
        public static final int FEMALE = 1;
        public static final int MALE = 0;
        public static final int OTHER = 2;
    }

    public static abstract interface Image
            extends Freezable<Image> {
        public abstract String getUrl();

        public abstract boolean hasUrl();
    }

    public static abstract interface Name
            extends Freezable<Name> {
        public abstract String getFamilyName();

        public abstract String getFormatted();

        public abstract String getGivenName();

        public abstract String getHonorificPrefix();

        public abstract String getHonorificSuffix();

        public abstract String getMiddleName();

        public abstract boolean hasFamilyName();

        public abstract boolean hasFormatted();

        public abstract boolean hasGivenName();

        public abstract boolean hasHonorificPrefix();

        public abstract boolean hasHonorificSuffix();

        public abstract boolean hasMiddleName();
    }

    public static final class ObjectType {
        public static final int PAGE = 1;
        public static final int PERSON = 0;
    }

    public static abstract interface Organizations
            extends Freezable<Organizations> {
        public abstract String getDepartment();

        public abstract String getDescription();

        public abstract String getEndDate();

        public abstract String getLocation();

        public abstract String getName();

        public abstract String getStartDate();

        public abstract String getTitle();

        public abstract int getType();

        public abstract boolean hasDepartment();

        public abstract boolean hasDescription();

        public abstract boolean hasEndDate();

        public abstract boolean hasLocation();

        public abstract boolean hasName();

        public abstract boolean hasPrimary();

        public abstract boolean hasStartDate();

        public abstract boolean hasTitle();

        public abstract boolean hasType();

        public abstract boolean isPrimary();

        public static final class Type {
            public static final int SCHOOL = 1;
            public static final int WORK = 0;
        }
    }

    public static abstract interface PlacesLived
            extends Freezable<PlacesLived> {
        public abstract String getValue();

        public abstract boolean hasPrimary();

        public abstract boolean hasValue();

        public abstract boolean isPrimary();
    }

    public static final class RelationshipStatus {
        public static final int ENGAGED = 2;
        public static final int IN_A_RELATIONSHIP = 1;
        public static final int IN_CIVIL_UNION = 8;
        public static final int IN_DOMESTIC_PARTNERSHIP = 7;
        public static final int ITS_COMPLICATED = 4;
        public static final int MARRIED = 3;
        public static final int OPEN_RELATIONSHIP = 5;
        public static final int SINGLE = 0;
        public static final int WIDOWED = 6;
    }

    public static abstract interface Urls
            extends Freezable<Urls> {
        public abstract String getLabel();

        public abstract int getType();

        public abstract String getValue();

        public abstract boolean hasLabel();

        public abstract boolean hasType();

        public abstract boolean hasValue();

        public static final class Type {
            public static final int CONTRIBUTOR = 6;
            public static final int OTHER = 4;
            public static final int OTHER_PROFILE = 5;
            public static final int WEBSITE = 7;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/plus/model/people/Person.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */