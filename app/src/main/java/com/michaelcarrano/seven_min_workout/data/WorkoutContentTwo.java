package com.michaelcarrano.seven_min_workout.data;

import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * WorkoutContent Class provides data about individual Workouts.
 *
 * @author michaelcarrano
 */
public class WorkoutContentTwo {

    /**
     * An array of workouts.
     */
    public static List<WorkoutTwo> WORKOUTSTWO = new ArrayList<WorkoutTwo>();

    public static void addWorkout(WorkoutTwo workout) {
        WORKOUTSTWO.add(workout);
    }

    /**
     * A Workout representing information related to the workout item.
     */
    public static class WorkoutTwo {

        public String id;

        public String name;

        public String content;

        public String video;

        public int dark;

        public int light;

        public WorkoutTwo(@NonNull String id,
                       @NonNull String name,
                       @NonNull String content,
                       @NonNull String video,
                       @ColorRes int dark,
                       @ColorRes int light) {
            this.id = id;
            this.name = name;
            this.content = content;
            this.video = video;
            this.dark = dark;
            this.light = light;
        }
    }
}
