package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ContactUs extends AppCompatActivity {
    EditText name;
    EditText email;
    EditText comments;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        name = findViewById(R.id.nameEditText);
        email = findViewById(R.id.emailEditText);
        comments = findViewById(R.id.commentsEditText);

        String namePref = sharedPreferences.getString("name", "");
        String emailPref = sharedPreferences.getString("email", "");
        String commentsPref = sharedPreferences.getString("comments", "");

        name.setText(namePref);
        email.setText(emailPref);
        comments.setText(commentsPref);
    }

    public void sendEmail(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", name.getText().toString());
        editor.putString("email", email.getText().toString());
        editor.putString("comments", comments.getText().toString());
        editor.apply();


        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"paneliyaviraj1001@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Contact");
        intent.putExtra(Intent.EXTRA_TEXT, comments.getText().toString());
        startActivity(Intent.createChooser(intent, "Send email"));
    }
}