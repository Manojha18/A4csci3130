package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateContactAcitivity extends Activity {

    private Button submitButton;
    private EditText nameField, emailField, businessField, primField, addressField, provinceField;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        /**
         * @ param referring to layout
         */

        submitButton = (Button) findViewById(R.id.submitButton);
        nameField = (EditText) findViewById(R.id.name);
        emailField = (EditText) findViewById(R.id.email);
        businessField = (EditText) findViewById(R.id.business_num);
        primField = (EditText) findViewById(R.id.prim_business);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);
    }

    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String personID = appState.firebaseReference.push().getKey();
        String name = nameField.getText().toString();
        String email = emailField.getText().toString();
        String business_num = businessField.getText().toString();
        String prim_business = primField.getText().toString();
        String address = addressField.getText().toString();
        String province = provinceField.getText().toString();

        Contact person = new Contact(personID, name, email, business_num, prim_business, address, province );

        appState.firebaseReference.child(personID).setValue(person);

        finish();

    }
}
