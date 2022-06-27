package com.obj.adress_book_system;

public class AdressBookMain {
    public static void main(String[] args) {

        AddressBookActivity processAddressBook = new AddressBookActivity();

        while (true) {
            processAddressBook.takeInputChoices();
            switch (processAddressBook.choiceOfUsers) {
                case AddressBookActivity.ADD_DETAILS:
                    processAddressBook.addDetails();
                    break;
                case AddressBookActivity.DISPLAY_DETAILS:
                    processAddressBook.displayPersonDetails();
                    break;
                case AddressBookActivity.EDIT_DETAILS:
                    processAddressBook.editDetails();
                    break;
                case AddressBookActivity.DELETE_DETAILS:
                    processAddressBook.removeDetail();
                    break;
                case AddressBookActivity.EXIT_PROGRAM:
                    processAddressBook.displayTermination();
                    return;
                default:
                    System.out.println("Please Enter correct input ");
                    break;
            }
        }
    }
}