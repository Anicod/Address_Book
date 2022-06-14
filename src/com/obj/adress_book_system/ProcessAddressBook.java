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

}