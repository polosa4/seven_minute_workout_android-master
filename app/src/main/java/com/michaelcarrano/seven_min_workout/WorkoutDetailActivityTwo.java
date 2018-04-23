package com.michaelcarrano.seven_min_workout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.michaelcarrano.seven_min_workout.data.WorkoutContent;
import com.michaelcarrano.seven_min_workout.data.WorkoutContentTwo;


/**
 * An activity representing a list of Workouts. This activity has different presentations for
 * handset and tablet-size devices. On handsets, the activity presents a list of items, which when
 * touched, lead to a {@link WorkoutDetailActivity} representing item details. On tablets, the
 * activity presents the list of items and item details side-by-side using two vertical panes. <p>
 * The activity makes heavy use of fragments. The list of items is a {@link WorkoutListFragment} and
 * the item details (if present) is a {@link WorkoutDetailFragment}. <p> This activity also
 * implements the required {@link WorkoutListFragment.Callbacks} interface to listen for item
 * selections.
 */
public class WorkoutDetailActivityTwo extends BaseActivity implements WorkoutListFragmentTwo.Callbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_detail_two);

        int selected = getIntent().getExtras().getInt(WorkoutDetailFragmentTwo.ARG_WORKOUT_POS);
        WorkoutContent.Workout workout = WorkoutContent.WORKOUTS.get(selected);
        Log.i("7min", "Selected: " + selected + " " + workout.name);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        addFab().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent workoutIntent = new Intent(WorkoutDetailActivityTwo.this, WorkoutCountdownActivity.class);
                startActivity(workoutIntent);
            }
        });
    }

    /**
     * Callback method from {@link WorkoutListFragment.Callbacks} indicating that the workout with
     * the given ID was selected.
     */
    @Override
    public void onItemSelected(int position) {
        // Start the detail activity for the selected workout ID.
        Intent detailIntent = new Intent(this, WorkoutDetailActivityTwo.class);
        detailIntent.putExtra(WorkoutDetailFragment.ARG_WORKOUT_POS, position);
        startActivity(detailIntent);
    }

    /**
     * Add menu items to ActionBar
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    /**
     * Handle menu item clicks
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_about_app:
                Intent aboutIntent = new Intent(this, AboutActivity.class);
                startActivity(aboutIntent);
                break;
        }
        return true;
    }
}
