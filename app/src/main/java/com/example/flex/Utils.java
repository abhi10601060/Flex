/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.flex;

import java.util.ArrayList;

public class Utils {
    public ArrayList<Exercise> getAllExercises() {
        return allExercises;
    }

    private ArrayList<Exercise> allExercises;
    private static Utils instance ;



    public  Utils(){
        if(allExercises==null){
            allExercises = new ArrayList<>();
            init();
        }
    }
    public static Utils getInstance(){
        if(instance == null){
            instance=new Utils();
        }
        return instance;
    }
    private void init(){
        this.allExercises.add(new Exercise(1,"Push Up","https://manofmany.com/wp-content/uploads/2020/02/How-to-do-a-proper-pushup.jpg"
                ,"This is an Exercise to build chest muscles","Long Description"));
        this.allExercises.add(new Exercise(2,"Pull Up","https://www.muscleandperformance.com/wp-content/uploads/2018/03/pull-ups-for-bigger-back.jpg",
                "This is an Exercise to build back muscles","Long Description"));
        
    }
}
