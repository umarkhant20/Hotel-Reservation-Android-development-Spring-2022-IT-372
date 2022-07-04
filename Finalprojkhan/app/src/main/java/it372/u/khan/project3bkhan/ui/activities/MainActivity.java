package it372.u.khan.project3bkhan.ui.activities;

// Umar Khan
// IT-372
// Final Project

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import it372.u.khan.project3bkhan.R;
import it372.u.khan.project3bkhan.model.ModelClass;
import it372.u.khan.project3bkhan.repository.RecordsRepository;
import java.util.ArrayList;

//private instance variables for all the widgets
public class MainActivity extends AppCompatActivity {

  private EditText edtDate;
  private Spinner spnGuests;
  private CheckBox chkStatus;
  private RadioButton radStdRoom;
  private RadioButton radDlxRoom;
  private EditText firstNameEdt;
  private EditText lastNameEdt;
  private EditText ageEdt;
  private EditText phoneEdt;
  private RecordsRepository recordsRepository;
  private Button searchBtn;
  private EditText searchEdt;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    recordsRepository = new RecordsRepository(getApplicationContext());

    //it gets the data from the fields by their ID
    firstNameEdt = findViewById(R.id.first_name);
    lastNameEdt = findViewById(R.id.last_name);
    ageEdt = findViewById(R.id.edt_age);
    phoneEdt = findViewById(R.id.edt_phone);
    edtDate = findViewById(R.id.edt_date);
    spnGuests = findViewById(R.id.spn_guests);
    chkStatus = findViewById(R.id.chk_status);
    radStdRoom = findViewById(R.id.rad_std_room);
    radDlxRoom = findViewById(R.id.rad_dlx_room);
    searchBtn = findViewById(R.id.search_btn);
    searchEdt = findViewById(R.id.edit_search);
  }

  //it sends the given information to second activity
  public void reserveInformation(View view) {
    String firstName = firstNameEdt.getText().toString();
    String lastName = lastNameEdt.getText().toString();
    String age = ageEdt.getText().toString();
    String phone = phoneEdt.getText().toString();
    String date = edtDate.getText().toString();
    String guests = spnGuests.getSelectedItem().toString();
    String status = chkStatus.isChecked() ? "Yes" : "No";
    String room = radDlxRoom.isChecked() ? "Deluxe Room" : "Standard Room";
    String total = radStdRoom.isChecked() ? "$120" : "$200";
    recordsRepository
        .insertRecord(firstName + " " + lastName, age, phone, date, guests, status, room, total);
    Intent intent = new Intent(this, ConfirmationActivity.class);
    ArrayList<ModelClass> info = new ArrayList<>();
    intent.putParcelableArrayListExtra("information", info);
    startActivity(intent);

  }

  public void searchRecord(View view) {
    recordsRepository.getRecord(searchEdt.getText().toString()).observe(this,
        new Observer<ModelClass>() {
          @Override
          public void onChanged(@Nullable ModelClass record) {
            ArrayList<ModelClass> info = new ArrayList<>();
            info.add(record);
            Intent intent = new Intent(MainActivity.this, ConfirmationActivity.class);
            intent.putParcelableArrayListExtra("information", info);
            startActivity(intent);
          }
        });

  }


  //it resets all text fields, checkbox, radiobutton, and spinner
  public void resetInformation(View view) {
    lastNameEdt.setText("");
    firstNameEdt.setText("");
    ageEdt.setText("");
    phoneEdt.setText("");
    edtDate.setText("");
    spnGuests.setSelection(0);
    chkStatus.setChecked(false);
    radDlxRoom.setChecked(false);
    radStdRoom.setChecked(false);
    searchEdt.setText("");
  }
}