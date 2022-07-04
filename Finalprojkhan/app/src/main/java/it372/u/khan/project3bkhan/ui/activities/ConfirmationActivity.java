package it372.u.khan.project3bkhan.ui.activities;

// Umar Khan
// IT-372
// Project 3b

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import it372.u.khan.project3bkhan.R;
import it372.u.khan.project3bkhan.model.ModelClass;
import it372.u.khan.project3bkhan.repository.RecordsRepository;
import it372.u.khan.project3bkhan.ui.adapter.ContactsAdapter;
import java.util.ArrayList;
import java.util.List;

//private instance variables for all the widgets
public class ConfirmationActivity extends AppCompatActivity {

  //it will display all the information it receives from MainActivity
  private RecordsRepository recordsRepository;
  private RecyclerView rvContacts;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_confirmation);
    recordsRepository = new RecordsRepository(getApplicationContext());
    rvContacts = (RecyclerView) findViewById(R.id.rvContacts);
    rvContacts.setLayoutManager(new LinearLayoutManager(this));
    Intent intent = getIntent();
    ArrayList<ModelClass> information = intent.getParcelableArrayListExtra("information");

    if (information.size() > 0) {
      //search query case
      ContactsAdapter adapter = new ContactsAdapter(information);
      rvContacts.setAdapter(adapter);
    } else {
      // fetch records from db
      updateTaskList();
    }

  }

  private void updateTaskList() {
    recordsRepository.getRecords().observe(this, new Observer<List<ModelClass>>() {
      @Override
      public void onChanged(@Nullable List<ModelClass> records) {
        if (records.size() > 0) {
          ContactsAdapter adapter = new ContactsAdapter(records);
          rvContacts.setAdapter(adapter);
        }
      }
    });
  }

}