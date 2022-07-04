package it372.u.khan.project3bkhan.ui.adapter;
// Umar Khan
// IT-372
// Final Project

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import it372.u.khan.project3bkhan.R;
import it372.u.khan.project3bkhan.model.ModelClass;
import java.util.ArrayList;
import java.util.List;

public class ContactsAdapter extends
    RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

  private List<ModelClass> mContacts = new ArrayList<>();

  public ContactsAdapter(List<ModelClass> contacts) {
    mContacts = contacts;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    Context context = parent.getContext();
    LayoutInflater inflater = LayoutInflater.from(context);

    View contactView = inflater.inflate(R.layout.item_contact, parent, false);
    ViewHolder viewHolder = new ViewHolder(contactView);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    ModelClass infoItem = mContacts.get(position);

    holder.txtName.setText("Name: " + infoItem.getName());
    holder.txtAge.setText("Age: " + infoItem.getAge());
    holder.txtPhone.setText("Phone: " + infoItem.getPhone());
    holder.txtDate.setText("Date: " + infoItem.getDate());
    holder.txtGuests.setText("Guest(s): " + infoItem.getGuests());
    holder.txtStatus.setText("Golden Member: " + infoItem.getStatus());
    holder.txtRoom.setText("Room: " + infoItem.getRoom());
    holder.txtTotal.setText("Total Cost: " + infoItem.getTotal());
  }

  @Override
  public int getItemCount() {
    return mContacts.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    private final TextView txtName, txtAge, txtPhone, txtDate, txtGuests, txtStatus, txtRoom, txtTotal;

    public ViewHolder(View itemView) {
      super(itemView);
      txtName = itemView.findViewById(R.id.txt_name);
      txtAge = itemView.findViewById(R.id.txt_age);
      txtPhone = itemView.findViewById(R.id.txt_phone);
      txtDate = itemView.findViewById(R.id.txt_date);
      txtGuests = itemView.findViewById(R.id.txt_guests);
      txtStatus = itemView.findViewById(R.id.txt_status);
      txtRoom = itemView.findViewById(R.id.txt_room);
      txtTotal = itemView.findViewById(R.id.txt_total);
    }
  }
}