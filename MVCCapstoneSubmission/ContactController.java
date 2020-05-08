package com.example.sharingapp;

import android.graphics.Bitmap;

/**
 * ItemController is responsible for all communication between views and Item object
 */
public class ContactController {

    private Contact contact;

    public ContactController(Contact contact){
        this.contact = contact;
    }

    public String getId(){
        return contact.getId();
    }

    public void setId() {
        contact.setId();
    }

    public void setTitle(String title) {
        contact.setTitle(title);
    }

    public String getTitle() {
        return contact.getTitle();
    }

    public void setMaker(String maker) {
        contact.setMaker(maker);
    }

    public String getMaker() {
        return contact.getMaker();
    }

    public void setDescription(String description) {
        contact.setDescription(description);
    }

    public String getDescription() {
        return contact.getDescription();
    }

    public void setDimensions(String length, String width, String height) {
        contact.setDimensions(length, width, height);
    }

    public String getLength() {
        return contact.getLength();
    }

    public String getWidth(){
        return contact.getWidth();
    }

    public String getHeight(){
        return contact.getHeight();
    }

    public void setStatus(String status) {
        contact.setStatus(status);
    }

    public String getStatus() {
        return contact.getStatus();
    }

    public void setBorrower(Contact borrower) {
        contact.setBorrower(borrower);
    }

    public Contact getBorrower() {
        return contact.getBorrower();
    }

    public void addContact(Bitmap new_image){
        contact.addContact(new_image);
    }

    public Bitmap getImage(){
        return contact.getImage();
    }

    public Item getItem() { return this.contact; }

    public void addObserver(Observer observer) {
        contact.addObserver(observer);
    }

    public void removeObserver(Observer observer) {
        contact.removeObserver(observer);
    }
}
