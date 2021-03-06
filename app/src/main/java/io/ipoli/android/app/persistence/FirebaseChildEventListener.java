package io.ipoli.android.app.persistence;

import android.support.annotation.NonNull;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;

import java.util.Map;

import io.ipoli.android.quest.persistence.OnChangeListener;

/**
 * Created by Venelin Valkov <venelin@curiousily.com>
 * on 1/24/17.
 */
public class FirebaseChildEventListener {

    @NonNull
    private static ChildEventListener createChildListener(final OnChangeListener changeListener) {
        return new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousName) {
                changeListener.onNew();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String previousName) {
                changeListener.onChanged();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                changeListener.onDeleted();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
    }

    public static void listenForChanges(OnChangeListener changeListener, Query query, Map<ChildEventListener, Query> childListeners) {
        query.orderByKey().limitToLast(1);
        ChildEventListener childListener = createChildListener(changeListener);
        childListeners.put(childListener, query);
        query.addChildEventListener(childListener);

    }
}
