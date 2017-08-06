package com.danatran.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> items;
    ArrayAdapter<String> itemsAdapter;
    // get reference to list view and set adapter to list view
    ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readItems();
        populateArrayItems();
        lvItems = (ListView) findViewById(R.id.lvItems);
        // set adapter on list view
        lvItems.setAdapter(itemsAdapter);
        setupListViewListener();
    }

    public void populateArrayItems() {
//        items = new ArrayList<String>();
//        items.add("First item");
//        items.add("Second item");
        // first param is context (instance of activity, which is this)
        // second param is resource file that should be used for each row - you can create a text view for layout or use
        // one that android provides
        // third param is array list of strings
        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
    }

    public void onAddItem(View view) { // view that gets passed in is button
        // find reference to EditText view
        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        // store the value of the text field
        String itemText = etNewItem.getText().toString();
        // add text of item to adapter
        itemsAdapter.add(itemText);
        // clear display of EditText view
        etNewItem.setText("");
        writeItems();
    }

    public void setupListViewListener() {
        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View item, int pos, long id) {
                items.remove(pos); // pos indicates which row to remove
                itemsAdapter.notifyDataSetChanged(); // if you modify data source without notifying adapter, it will throw exception so this is needed instead
                writeItems();
                return true; // signals we've handled this event
            }
        });
        lvItems.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View item, int pos, long id) {
                // launch edit item activity
                launchEditItem(adapter, pos);
            }
        });
    }

    public void launchEditItem(AdapterView<?> adapter, int pos) {
        final int REQUEST_CODE = pos;
        Intent i = new Intent(MainActivity.this, EditItemActivity.class);
        String editableText = (String)adapter.getItemAtPosition(pos);
        i.putExtra("editableText", editableText);
        i.putExtra("position", pos);
        startActivityForResult(i, REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            // extract value of edited text from result extras
            String editedText = data.getExtras().getString("editedText");
            items.set(requestCode, editedText);
            itemsAdapter.notifyDataSetChanged();
            writeItems();
        }
    }

    private void readItems() {
        File filesDir = getFilesDir(); // get reference to directory this app can read/write from
        File file = new File(filesDir, "todo.txt"); // read file from this directory
        try {
            items = new ArrayList<String>(FileUtils.readLines(file)); // read from file and store in array list
        } catch (IOException e) {

        }
    }

    private void writeItems() {
        File filesDir = getFilesDir(); // get reference to directory this app can read/write from
        File file = new File(filesDir, "todo.txt"); // read file from this directory
        try {
            FileUtils.writeLines(file, items); // pass data to disk
        } catch (IOException e) {

        }
    }
}
