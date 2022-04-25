/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.flex;

import static com.example.flex.ExerciseActivity.EXERCISE_KEY;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class PlanDialog extends DialogFragment {

    private Button btn_add , btn_dismiss;
    private TextView exercise_name;
    private EditText time;
    private Spinner days;

    public interface PassPlan {
        void getPlan(Plan plan);
    }

    private PassPlan passPlan;



    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.plan_dialog,null);
        init(view);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle("Enter Details")
                .setView(view);

        Bundle bundle = getArguments();
        if(bundle!= null){
            Exercise exercise = bundle.getParcelable(EXERCISE_KEY);
            if(exercise!= null){
                exercise_name.setText(exercise.getName());

                btn_dismiss.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dismiss();
                    }
                });

                btn_add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        int minutes =Integer.valueOf(time.getText().toString());
                        String day = days.getSelectedItem().toString();

                        Plan plan = new Plan(exercise,minutes,false,day);

                        passPlan.getPlan(plan);
                    }
                });



            }

        }


        return builder.create();
    }
    private void init(View view){
        btn_add= view.findViewById(R.id.btn_add);
        btn_dismiss=view.findViewById(R.id.btn_dismiss);
        exercise_name =view.findViewById(R.id.txt_name);
        time=view.findViewById(R.id.edt_minutes);
        days=view.findViewById(R.id.days_spinner);

    }
}
