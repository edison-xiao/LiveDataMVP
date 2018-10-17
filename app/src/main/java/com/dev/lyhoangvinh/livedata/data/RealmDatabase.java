package com.dev.lyhoangvinh.livedata.data;


import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmDatabase {

    private final Realm mRealm;

    public RealmDatabase(Realm realm) {
        mRealm = realm;
    }

    /**
     * Closes the Realm instance and all its resources.
     * see {@link Realm#close()}
     */
    public void close() {
        mRealm.close();
    }

    public void clearAll() {
        mRealm.beginTransaction();
        //Deletes
        mRealm.commitTransaction();
        mRealm.close();
    }
}
