package com.obj.adress_book_system;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProcessAddressBook {

    static final int ADD_DETAILS = 1;
    static final int PRINT_DETAILS = 2;
    static final int EDIT_DETAILS = 3;
    static final int DELETE_DETAILS = 4;
    static final int EXIT_PROGRAM = 5;

    public int choiceOfUsers;

    Scanner scanner = new Scanner(System.in);
    List<AddressBookContacts> contactArray = new ArrayList<>();
    AddressBookContacts addressBookContacts;
    Scanner choice = new Scanner(System.in);

    void addDetails() {
        System.out.println("\n You have chosen to Add a new contact details.\n");
        System.out.print("Enter contact's first name : ");
        String firstName = scanner.next();

        System.out.print("Enter contact's last name : ");
        String lastName = scanner.next();

        System.out.print("Enter contact's address : ");
        scanner.nextLine();
        String address = scanner.nextLine();

        System.out.print("Enter contact's city : ");
        String city = scanner.next();

        System.out.print("Enter contact's state : ");
        String state = scanner.next();

        System.out.print("Enter contact's zip code : ");
        int zipCode = scanner.nextInt();

        System.out.print("Enter contact's phone number : ");
        long phoneNumber = scanner.nextLong();

        System.out.print("Enter contact's email : ");
        scanner.nextLine();
        String email = scanner.nextLine();

        addressBookContacts = new AddressBookContacts(firstName, lastName, address, city, state, zipCode, phoneNumber, email);
        contactArray.add(addressBookContacts);
        System.out.println("\n Your details are successfully added in Address book");

    }
    void editDetails() {

        System.out.println("\n You have chosen to update the existing contact details.\n");
        System.out.println("To edit the details");
        AddressBookContacts varEdit = isDetailsMatched();
        if (varEdit == null)
            return;

        System.out.print("Enter contact's first name : ");
        String firstName = scanner.next();
        varEdit.setFirstName(firstName);

        System.out.print("Enter contact's last name : ");
        String lastName = scanner.next();
        varEdit.setLastName(lastName);

        System.out.print("Enter contact's address : ");
        scanner.nextLine();
        String address = scanner.nextLine();
        varEdit.setAddress(address);

        System.out.print("Enter contact's city : ");
        String city = scanner.next();
        varEdit.setCity(city);

        System.out.print("Enter contact's state : ");
        String state = scanner.next();
        varEdit.setState(state);

        System.out.print("Enter contact's zip code : ");
        int zipCode = scanner.nextInt();
        varEdit.setZipCode(zipCode);

        System.out.print("Enter contact's phone number : ");
        long phoneNumber = scanner.nextLong();
        varEdit.setPhoneNumber(phoneNumber);

        System.out.print("Enter contact's email : ");
        scanner.nextLine();
        String email = scanner.nextLine();
        varEdit.setEmail(email);

        System.out.println("\n Your details are successfully edited in Address book");
    }

    void deleteDetails() {

        System.out.println("\n You have chosen to remove the existing contact details.\n");
        System.out.println("To delete the details");
        AddressBookContacts varDelete = isDetailsMatched();
        if (varDelete == null)
            return;

        contactArray.remove(varDelete);
        System.out.println("Record was Deleted");
    }

    void displayAddedDetails(AddressBookContacts toDisplayDetails) {

        System.out.println(toDisplayDetails);
    }

    void displayPersonDetails() {

        System.out.println("\n To print the details");
        AddressBookContacts varPrint = isDetailsMatched();
        if (varPrint == null)
            return;

        displayAddedDetails(varPrint);
    }

    AddressBookContacts isDetailsMatched() {

        System.out.print("Enter the first name of the person : ");
        String editName = scanner.next();
        AddressBookContacts tempRefVar;

        for (int index = 0; index < contactArray.size(); index++) {
            String name = contactArray.get(index).getFirstName();
            if ((name.equals(editName))) {
                tempRefVar = contactArray.get(index);
                System.out.println("\n Match found \n ");
                return tempRefVar;
            }
        }

        System.out.println("Invalid input, Please try again");
        return null;
    }

    void printChoices() {

        System.out.println("\n \n Welcome to Address Book Program.");
        System.out.println("These are the actions you can perform in the Address book");
        System.out.println("1. Adding a new contact details.");
        System.out.println("2. Printing a existing contact details.");
        System.out.println("3. Editing a existing contact.");
        System.out.println("4. Deleting a existing contact.");
    }

    void displayTermination() {

        System.out.println("Your program is Terminated.");
    }


    public void takingInputOverWhileLoop() {

        printChoices();
        System.out.println(" \n Enter a number between 1 to 4 to run any one of the functionality and 5 to terminate : \n");
        System.out.print("your choice : ");
        choiceOfUsers = choice.nextInt();
    }
}