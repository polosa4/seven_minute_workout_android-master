package com.michaelcarrano.seven_min_workout;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.ListFragment;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.michaelcarrano.seven_min_workout.adapter.WorkoutListAdapter;
import com.michaelcarrano.seven_min_workout.adapter.WorkoutListAdapterTwo;
import com.michaelcarrano.seven_min_workout.data.WorkoutContent;
import com.michaelcarrano.seven_min_workout.data.WorkoutContentTwo;

/**
 * A fragment representing a single Workout detail screen. This fragment is either contained in a
 * {@link WorkoutListActivity} in two-pane mode (on tablets) or a {@link WorkoutDetailActivity} on
 * handsets.
 */
public class WorkoutDetailFragmentTwo extends ListFragment {

    /**
     * The serialization (saved instance state) Bundle key representing the activated item position.
     * Only used on tablets.
     */
    public static final String ARG_WORKOUT_POS = "";
    private static final String STATE_ACTIVATED_POSITION = "activated_position";

    /**
     * Stores the scroll position of the ListView
     */
    private static Parcelable mListViewScrollPos = null;

    /**
     * A dummy implementation of the {@link WorkoutListFragment.Callbacks} interface that does nothing. Used only when
     * this fragment is not attached to an activity.
     */
    private static WorkoutListFragmentTwo.Callbacks sDummyCallbacks = new WorkoutListFragmentTwo.Callbacks() {
        @Override
        public void onItemSelected(int position) {
        }
    };

    /**
     * The fragment's current callback object, which is notified of list item clicks.
     */
    private WorkoutListFragmentTwo.Callbacks mCallbacks = sDummyCallbacks;

    /**
     * The current activated item position. Only used on tablets.
     */
    private int mActivatedPosition = ListView.INVALID_POSITION;
    private WorkoutContentTwo.WorkoutTwo mWorkoutTwo;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new WorkoutListAdapterTwo(getActivity()));


    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Restore the previously serialized activated item position.
        if (savedInstanceState != null
                && savedInstanceState.containsKey(STATE_ACTIVATED_POSITION)) {
            setActivatedPosition(savedInstanceState.getInt(STATE_ACTIVATED_POSITION));
        }
        // Remove the ListView divider
        getListView().setDividerHeight(0);

        // Restore ListView position
//        Log.i("7min", "onViewCreated");
        if (mListViewScrollPos != null) {
//            Log.i("7min", "Restore scroll position");
            getListView().onRestoreInstanceState(mListViewScrollPos);
        }


    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // Activities containing this fragment must implement its callbacks.
        if (!(activity instanceof WorkoutListFragmentTwo.Callbacks)) {
            throw new IllegalStateException("Activity must implement fragment's callbacks.");
        }

        mCallbacks = (WorkoutListFragmentTwo.Callbacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();

        // Reset the active callbacks interface to the dummy implementation.
        mCallbacks = sDummyCallbacks;
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        super.onListItemClick(listView, view, position, id);

        // Notify the active callbacks interface (the activity, if the
        // fragment is attached to one) that an item has been selected.
        mCallbacks.onItemSelected(position);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mActivatedPosition != ListView.INVALID_POSITION) {
            // Serialize and persist the activated item position.
            outState.putInt(STATE_ACTIVATED_POSITION, mActivatedPosition);
        }
//        Log.i("7min", "onSaveInstanceState");
        mListViewScrollPos = getListView().onSaveInstanceState();
    }

    /**
     * Turns on activate-on-click mode. When this mode is on, list items will be given the
     * 'activated' state when touched.
     */
    public void setActivateOnItemClick(boolean activateOnItemClick) {
        // When setting CHOICE_MODE_SINGLE, ListView will automatically
        // give items the 'activated' state when touched.
        getListView().setChoiceMode(activateOnItemClick
                ? ListView.CHOICE_MODE_SINGLE
                : ListView.CHOICE_MODE_NONE);
    }

    private void setActivatedPosition(int position) {
        if (position == ListView.INVALID_POSITION) {
            getListView().setItemChecked(mActivatedPosition, false);
        } else {
            getListView().setItemChecked(position, true);
        }

        mActivatedPosition = position;
    }

    /**
     * A callback interface that all activities containing this fragment must implement. This
     * mechanism allows activities to be notified of item selections.
     */
    public interface Callbacks {

        /**
         * Callback for when an item has been selected.
         */
        public void onItemSelected(int position);
    }}
