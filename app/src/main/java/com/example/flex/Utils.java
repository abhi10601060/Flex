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
    private ArrayList<Exercise> allExercises;
    private static Utils instance ;

    Utils(){
        if(allExercises==null){
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
        allExercises.add(new Exercise(1,"Push Up","https://manofmany.com/wp-content/uploads/2020/02/How-to-do-a-proper-pushup.jpg"
                ,"This is an Exercise to build chest muscles","Long Description"));
    }
}
