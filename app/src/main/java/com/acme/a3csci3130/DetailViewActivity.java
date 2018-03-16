package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailViewActivity extends Activity {

    private EditText nameField, emailField, businessField, primField, addressField, provinceField;
    Contact receivedPersonInfo;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");

        appState = ((MyApplicationData) getApplicationContext());

        nameField = (EditText) findViewById(R.id.name);
        emailField = (EditText) findViewById(R.id.email);
        businessField =(EditText) findViewById(R.id.business_num);
        primField = (EditText) findViewById(R.id.prim_business);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);




        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            emailField.setText(receivedPersonInfo.email);
            businessField.setText(receivedPersonInfo.business_num);
            primField.setText(receivedPersonInfo.prim_business);
            addressField.setText(receivedPersonInfo.address);
            provinceField.setText(receivedPersonInfo.province);
        }
    }

    public void updateContact(View v){
        //TODO: Update contact functionality

        /** getting the input text and converting into string
         *
         */

        receivedPersonInfo.name= nameField.getText().toString();
        receivedPersonInfo.email=emailField.getText().toString();
        receivedPersonInfo.business_num = businessField.getText().toString();
        receivedPersonInfo.prim_business = primField.getText().toString();
        receivedPersonInfo.address = addressField.getText().toString();
        receivedPersonInfo.province = provinceField.getText().toString();

        /**
         * using the firebase reference and  uid,  updating the existing details
         */

        appState.firebaseReference.child(receivedPersonInfo.uid).setValue(receivedPersonInfo);


        finish();

    }

    public void eraseContact(View v)
    {
        //TODO: Erase contact functionality

        /**  using the firebase reference and uid removing the user
         *
         */

        appState.firebaseReference.child(receivedPersonInfo.uid).removeValue();

        finish();
    }
}
