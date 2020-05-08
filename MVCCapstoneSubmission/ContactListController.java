package com.example.sharingapp;

import android.content.Context;

import java.util.ArrayList;
import java.util.Observer;

/**
 * ItemListController is responsible for all communication between views and ItemList object
 */
public class ContactListController {

    private ContactList contact_list;

    public ContactListController(ContactList contact_list){
        this.contact_list = contact_list;
    }

    public void setItems(ArrayList<Contact> item_list) {
        this.contact_list.setContacts(item_list);
    }

    public ArrayList<Contact> getContacts() {
        return contact_list.getContacts();
    }

    public boolean addContact(Contact item, Context context){
        AddContactCommand add_item_command = new AddContactCommand(contact_list, contact, context);
        add_item_command.execute();
        return add_item_command.isExecuted();
    }

    public boolean deleteContact(Contact item, Context context) {
        DeleteContactCommand delete_item_command = new DeleteContactCommand(contact_list, contact, context);
        delete_item_command.execute();
        return delete_item_command.isExecuted();
    }

    public boolean editContact(Contact item, Contact updated_item, Context context){
        EditContactCommand edit_item_command = new EditContactCommand(contact_list, contact, updated_item, context);
        edit_item_command.execute();
        return edit_item_command.isExecuted();
    }

    public Item getContact(int index) {
        return contact_list.getItem(index);
    }

    public int getIndex(Contact item) {
        return contact_list.getIndex(item);
    }

    public int getSize() {
        return contact_list.getSize();
    }

    public void loadContacts(Context context) {
        contact_list.loadContacts(context);
    }

    public ArrayList<Contact> getActiveBorrowers() {
        return contact_list.getActiveBorrowers();
    }

    public ArrayList<Contact> filterItemsByStatus(String status){
        return contact_list.filterContactsByStatus(status);
    }

    public void addObserver(Observer observer) {
        contact_list.addObserver(observer);
    }

    public void removeObserver(Observer observer) {
        contact_list.removeObserver(observer);
    }
}
