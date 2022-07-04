package it372.u.khan.project3bkhan.model;
// Umar Khan
// IT-372
// Final Project

import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ModelClass implements Parcelable {
  @PrimaryKey(autoGenerate = true)
  private int id;

  private String date;
  private String total;
  private String name;
  private String guests;
  private String room;
  private String status;
  private String age;
  private String phone;

  public ModelClass(String name, String age, String phone, String date, String guests,
                    String status, String room,
                    String total) {
    this.date = date;
    this.age = age;
    this.phone = phone;
    this.total = total;
    this.name = name;
    this.guests = guests;
    this.room = room;
    this.status = status;
  }

  protected ModelClass(Parcel in) {
    date = in.readString();
    total = in.readString();
    name = in.readString();
    guests = in.readString();
    room = in.readString();
    status = in.readString();
    age = in.readString();
    phone = in.readString();
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(date);
    dest.writeString(total);
    dest.writeString(name);
    dest.writeString(guests);
    dest.writeString(room);
    dest.writeString(status);
    dest.writeString(age);
    dest.writeString(phone);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  public static final Creator<ModelClass> CREATOR = new Creator<ModelClass>() {
    @Override
    public ModelClass createFromParcel(Parcel in) {
      return new ModelClass(in);
    }

    @Override
    public ModelClass[] newArray(int size) {
      return new ModelClass[size];
    }
  };

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getTotal() {
    return total;
  }

  public void setTotal(String total) {
    this.total = total;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGuests() {
    return guests;
  }

  public void setGuests(String guests) {
    this.guests = guests;
  }

  public String getRoom() {
    return room;
  }

  public void setRoom(String room) {
    this.room = room;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public static Creator<ModelClass> getCREATOR() {
    return CREATOR;
  }
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}