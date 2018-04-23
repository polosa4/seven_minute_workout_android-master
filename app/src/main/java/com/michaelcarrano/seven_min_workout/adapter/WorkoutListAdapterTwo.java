package com.michaelcarrano.seven_min_workout.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.michaelcarrano.seven_min_workout.R;
import com.michaelcarrano.seven_min_workout.data.WorkoutContent;
import com.michaelcarrano.seven_min_workout.data.WorkoutContent.Workout;
import com.michaelcarrano.seven_min_workout.data.WorkoutContentTwo;
import com.michaelcarrano.seven_min_workout.data.WorkoutContentTwo.WorkoutTwo;

/**
 * Custom adapter for {@link com.michaelcarrano.seven_min_workout.WorkoutListFragment } to display
 * the ID and Name of Workout in a ListView row.
 *
 * @author michaelcarrano
 */
public class WorkoutListAdapterTwo extends BaseAdapter {

    private static LayoutInflater mLayoutInflater = null;

    public WorkoutListAdapterTwo(Activity ctx) {
        this.mLayoutInflater = ctx.getLayoutInflater();
    }

    @Override
    public int getCount() {
        return WorkoutContentTwo.WORKOUTSTWO.size();
    }

    @Override
    public Object getItem(int position) {
        return WorkoutContentTwo.WORKOUTSTWO.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        WorkoutTwo workout = (WorkoutTwo) getItem(position);

        String [] arrOfStrings = workout.name.split(",");

        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.adapter_workout_row, parent, false);

            holder = new ViewHolder();
            holder.id = (TextView) convertView.findViewById(R.id.workout_id);
            holder.name = (TextView) convertView.findViewById(R.id.workout_name);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Set the content for the ListView row
        holder.id.setText(workout.id);
        for (int i = 0; i < arrOfStrings.length; i++){
            holder.name.setText(arrOfStrings[i]);
        }


        // Set the color for the ListView row
        holder.id.setBackgroundColor(workout.dark);
        holder.name.setBackgroundColor(workout.light);

        return convertView;
    }

    private static class ViewHolder {

        public TextView id;

        public TextView name;
    }
}
