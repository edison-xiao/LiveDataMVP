package com.dev.lyhoangvinh.livedata.local;

import android.util.Log;

import com.dev.lyhoangvinh.livedata.model.Collections;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmDatabase {

    protected final RealmConfiguration mRealmConfiguration;

    public RealmDatabase(RealmConfiguration realmConfiguration) {
        this.mRealmConfiguration = realmConfiguration;
    }

    public void clearAll() {
        Realm mRealm = Realm.getInstance(mRealmConfiguration);
        mRealm.beginTransaction();
        //delete
        mRealm.delete(Collections.class);
        //...
        mRealm.commitTransaction();
        mRealm.close();
    }
}
