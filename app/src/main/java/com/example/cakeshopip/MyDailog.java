package com.example.cakeshopip;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyDailog extends DialogFragment {
    TextView txtMsg;
    Button btnOK;
    Button btnCancle;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View dailogView=inflater.inflate(R.layout.dailog_window,null);
        builder.setView(dailogView);
//        return super.onCreateDialog(savedInstanceState);


        txtMsg = dailogView.findViewById(R.id.txtMsg);
        btnOK = dailogView.findViewById(R.id.btnOK);
        btnCancle = dailogView.findViewById(R.id.btnCancle);
        txtMsg.setText("Your Order Has been Puchased!");

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context=view.getContext();
                Intent intent=new Intent(context,ProductActivity.class);
                context.startActivity(intent);
            }
        });

        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });


        return builder.create();
    }
}
