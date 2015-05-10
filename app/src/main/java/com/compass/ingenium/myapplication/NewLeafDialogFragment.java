package com.compass.ingenium.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Mert on 10.05.2015.
 */
public class NewLeafDialogFragment extends DialogFragment {

        static String newLeafTitle, newLeafDescription;

        /* The activity that creates an instance of this dialog fragment must
         * implement this interface in order to receive event callbacks.
         * Each method passes the DialogFragment in case the host needs to query it. */
        public interface LeafDialogListener {
            public void onDialogPositiveClick(DialogFragment dialog);
            public void onDialogNegativeClick(DialogFragment dialog);
        }

        // Use this instance of the interface to deliver action events
        LeafDialogListener mListener;

        // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            // Verify that the host activity implements the callback interface
            try {
                // Instantiate the NoticeDialogListener so we can send events to the host
                mListener = (LeafDialogListener) activity;
            } catch (ClassCastException e) {
                // The activity doesn't implement the interface, throw exception
                throw new ClassCastException(activity.toString()
                        + " must implement NoticeDialogListener");
            }
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the Builder class for convenient dialog construction
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            // Get the layout inflater
            LayoutInflater inflater = getActivity().getLayoutInflater();

            View v = inflater.inflate(R.layout.new_leaf_dialog, null);
            builder.setView(v);

            final EditText titleBox = (EditText)v.findViewById(R.id.new_leaf_title);
            final EditText descriptionBox = (EditText)v.findViewById(R.id.new_leaf_description);

            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            // Add action buttons
            builder.setPositiveButton(R.string.create, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    newLeafTitle = titleBox.getText().toString();
                    newLeafDescription = descriptionBox.getText().toString();
                    // Send the positive button event back to the host activity
                    mListener.onDialogPositiveClick(NewLeafDialogFragment.this);
                }
            })
                    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            NewLeafDialogFragment.this.getDialog().cancel();
                        }
                    });
            return builder.create();
        }
    }
