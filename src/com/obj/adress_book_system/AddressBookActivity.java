package com.obj.adress_book_system;
import java.util.*;

public class AddressBookActivity {

    static final int ADD_DETAILS = 1;
    static final int DISPLAY_DETAILS = 2;
    static final int EDIT_DETAILS = 3;
    static final int DELETE_DETAILS = 4;
    static final int EXIT_PROGRAM = 5;
    public int choiceOfUsers;

    Scanner scanner = new Scanner(System.in);
    Map<String, ArrayList<Contacts>> multipleAddressBookMap = new HashMap<>();
    ArrayList<Contacts> contactArray;
    Contacts addressBookContacts;
    Scanner choice = new Scanner(System.in);
        void addDetails() {
            System.out.println("\n You have chosen to Add a new contact details.\n");
            System.out.print("Enter contact's first name : ");
            String firstName = scanner.next();
            System.out.println("Enter contact's last name : ");
            String lastName = scanner.next();
            System.out.println("Enter contact's address : ");
            String address = scanner.next();
            System.out.println("Enter contact's city : ");
            String city = scanner.next();
            System.out.println("Enter contact's state : ");
            String state = scanner.next();
            System.out.println("Enter contact's zip code : ");
            int zipCode = scanner.nextInt();
            System.out.println("Enter contact's phone number : ");
            long phoneNumber = scanner.nextLong();
            System.out.println("Enter contact's email : ");
            String email = scanner.next();
            addressBookContacts = new Contacts(firstName, lastName, address, city, state, zipCode, phoneNumber, email);
            System.out.println("\n Your details are successfully added in Address book");
            System.out.println("how many books you want to add");
                System.out.println("enter the name of the book ");
                String bookName = scanner.next();
            if (multipleAddressBookMap.containsKey(bookName)) {
                multipleAddressBookMap.get(bookName).add(addressBookContacts);
                System.out.println("Contact added successfully in existing book :"  + bookName);
            }
            else {
                contactArray = new ArrayList<>();
                contactArray.add(addressBookContacts);
                multipleAddressBookMap.put(bookName, contactArray);
                System.out.println("Successfully created book " + bookName);
                System.out.println("New contact added in the new arraylist in new address book " + bookName);
            }
                displayAddedDetails(addressBookContacts);

        }
    void editDetails() {

        System.out.println("\n You have chosen to update the existing contact details.\n");
        System.out.println("To edit the details");
        Contacts varEdit = isSearchedMatched();
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

    void removeDetail() {

        System.out.println("\n You have chosen to remove the existing contact details.\n");
        System.out.println("To delete the details");
        Contacts varDelete = isSearchedMatched();
        if (varDelete == null)
            return;

        contactArray.remove(varDelete);
        System.out.println("Record was Deleted");
    }

    void displayAddedDetails(Contacts toDisplayDetails) {

        System.out.println(toDisplayDetails);
    }

    void displayPersonDetails() {

        System.out.println("\n To print the details");
        Contacts varPrint = isSearchedMatched();
        if (varPrint == null)
            return;

        displayAddedDetails(varPrint);
    }

    Contacts isSearchedMatched() {
        System.out.println("Enter the address book name first. \n ");
        displayAllAddressBooksName();
        System.out.println("entered Your choice: ");
        String bookName = scanner.next();
        Iterator<Contacts>iterator = contactArray.iterator();
        System.out.println("entered first name of the person");
        String inputName = scanner.next();
        ArrayList<Contacts> tempMapValue = multipleAddressBookMap.get(bookName);
        Contacts tempRefVar;

        while (iterator.hasNext()){
            if ((tempMapValue.iterator().next().getFirstName().equals(inputName))) {
                tempRefVar = tempMapValue.iterator().next();
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


    public void takeInputChoices() {

        printChoices();
        System.out.println(" \n Enter a number between 1 to 4 to run any one of the functionality and 5 to terminate : \n");
        System.out.print("your choice : ");
        choiceOfUsers = choice.nextInt();
    }

    void displayAllAddressBooksName() {
        multipleAddressBookMap.forEach((key, value) -> System.out.println(key));
    }
}
