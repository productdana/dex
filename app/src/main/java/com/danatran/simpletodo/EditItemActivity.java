package com.danatran.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        // get todoItem text from main activity & display on editItemActivity
        String editableText = getIntent().getStringExtra("editableText");
        EditText etEditText = (EditText) findViewById(R.id.etEditText);
        etEditText.setText(editableText);
        // set cursor at end of edit text
        int position = etEditText.length();
        Editable etext = etEditText.getText();
        Selection.setSelection(etext, position);
    }

    public void onSaveEditItem(View view) {
        // store edited text
        EditText etEditText = (EditText) findViewById(R.id.etEditText);
        // prepare data intent
        Intent data = new Intent();
        // pass edited text (relevant data) back as a result
        data.putExtra("editedText", etEditText.getText().toString());
        setResult(RESULT_OK, data);
        finish();
    }
}
