package com.example.sharingapp;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Observer;

/**
 * ItemList class
 */
public class ContactList extends Observable{

    private static ArrayList<Item> items;
    private String FILENAME = "items.sav";

    public ContactList() {
        ArrayList<Contact> contacts = new ArrayList<Contact>();
    }

    public void setItems(ArrayList<Item> item_list) {
        items = item_list;
        notifyObservers();
    }

    private void notifyObservers() {
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
        notifyObservers();
    }

    public void deleteItem(Item item) {
        items.remove(item);
        notifyObservers();
    }

    public Contact getCotnact(int index) {
        Dictionary contacts = null;
        return (Contact) contacts.get(index);
    }

    public int getIndex(Contact item) {
        int pos = 0;
        for (Item i : items) {
            if (item.getId().equals(i.getId())) {
                return pos;
            }
            pos = pos + 1;
        }
        return -1;
    }

    public int getSize() {
        return items.size();
    }

    public void loadContacts(Context context) {

        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            InputStreamReader isr = new InputStreamReader(fis);
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Item>>() {
            }.getType();
            items = gson.fromJson(isr, listType); // temporary
            fis.close();
        } catch (FileNotFoundException e) {
            items = new ArrayList<Item>();
        } catch (IOException e) {
            items = new ArrayList<Item>();
        }
        notifyObservers();
    }

    public boolean saveItems(Context context) {
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME, 0);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(items, osw);
            osw.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public ArrayList<Contact> getActiveBorrowers() {

        ArrayList<Contact> active_borrowers = new ArrayList<Contact>();
        for (Item i : items) {
            Contact borrower = i.getBorrower();
            if (borrower != null) {
                active_borrowers.add(borrower);
            }
        }
        return active_borrowers;
    }

    public ArrayList<Contact> filterContactsByStatus(String status){
        ArrayList<Contact> selected_contact = new ArrayList<>();
        for (Contact i: contacts) {
            if (i.getStatus().equals(status)) {
                selected_items.add(i);
            }
        }
        return selected_items;
    }

    public void addObserver(Observer observer) {
    }

    public void removeObserver(Observer observer) {
    }

    public Contact getContactByUsername(String username){
        for (Contact c : contacts){
            if (c.getUsername().equals(username)){
                return c;
            }
        }
        return null;
    }

}

