package com.obj.adress_book_system;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddressBookActivity {

    static final int ADD_DETAILS = 1;
    static final int DISPLAY_DETAILS = 2;
    static final int EDIT_DETAILS = 3;
    static final int DELETE_DETAILS = 4;
    static final int EXIT_PROGRAM = 5;
    public int choiceOfUsers;

    Scanner scanner = new Scanner(System.in);
    Map<String, ArrayList<Contacts>> multipleAddressBook = new HashMap<>();
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

        // Creating object with newly added details
        addressBookContacts = new Contacts(firstName, lastName, address, city, state, zipCode, phoneNumber, email);
        System.out.println("\n Your details are successfully added in Address book");

        System.out.println("enter the name of the book ");
        String bookName = scanner.next();

        if (multipleAddressBook.containsKey(bookName)) { // Checking if bookName already exists

            // Checking if the data already exist

            Contacts searchedData = multipleAddressBook
                    .get(bookName) // Getting the corresponding list to bookName
                    .stream()// streaming the data to process
                    .filter(contacts -> contacts.equals(contacts.getFirstName().equals(firstName))) // Checking if the data with same name already exists
                    .findFirst() // if exists, return the data
                    .orElse(null) // else return null
            ;

            if (searchedData != null) { // Not adding the data if it pre-exists
                System.out.println("\n Match found, duplicate Entry \n ");
                return;
            }

            // Adding the data
            multipleAddressBook.get(bookName).add(addressBookContacts);
            System.out.println("Contact added successfully in existing book :" + bookName);

        } else { // Adding the bookName as it doesn't exists

            // Creating empty list for new book
            contactArray = new ArrayList<>();

            // Adding the first data to the book
            contactArray.add(addressBookContacts);
            multipleAddressBook.put(bookName, contactArray);

            System.out.println("Successfully created book " + bookName);
            System.out.println("New contact added in the new arraylist in new address book " + bookName);
        }

        displayAddedDetails(addressBookContacts);
    }

    void editDetails() {
        System.out.println("\n You have chosen to update the existing contact details.\n");
        System.out.println("To edit the details");

        String[] details = getRequriedDetailsToSearch();
        Contacts searchedData = searchContactByFirstName(details[0], details[1]);


        if (searchedData == null) {
            System.out.println("Cannot find the data in book name: "+details[0]+" with first name "+ details[1]+ "is:\n"+searchedData);
            return;
        }

        System.out.println("Data to be edited in book name: " +details[0]+" with first name: "+details[1]+" is :\n"+searchedData);

        System.out.print("Enter new first name : ");
        String newFirstName = scanner.next();

        System.out.print("Enter new last name : ");
        String lastName = scanner.next();

        System.out.print("Enter new address : ");
        String address = scanner.next();

        System.out.print("Enter new city : ");
        String city = scanner.next();

        System.out.print("Enter new state : ");
        String state = scanner.next();

        System.out.print("Enter new zip code : ");
        int zipCode = scanner.nextInt();

        System.out.print("Enter new phone number : ");
        long phoneNumber = scanner.nextLong();

        System.out.print("Enter new email : ");
        String email = scanner.nextLine();

        searchedData.resetContact(newFirstName, lastName, address, city, state, zipCode, phoneNumber, email);
        System.out.println("\n Your edited data in address book is: "+searchedData);
    }

    void removeDetail() {

        System.out.println("\n You have chosen to remove the existing contact details.\n");
        System.out.println("To delete the details");

        String[] details = getRequriedDetailsToSearch();

        Contacts varDelete = searchContactByFirstName(details[0], details[1]);
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

        String[] details = getRequriedDetailsToSearch();

        Contacts varPrint = searchContactByFirstName(details[0], details[1]);
        if (varPrint == null)
            return;

        displayAddedDetails(varPrint);
    }

    Contacts searchContactByFirstName(String bookName, String firstName) {

        // Streaming the data for processing
        Stream<Contacts> stream = multipleAddressBook.get(bookName).stream();
        Iterator<Contacts> iterator = stream.iterator();

        // searching the contact with given firstName
        while(iterator.hasNext()){ // Searching till the element has next element

            Contacts Item = iterator.next();
            if(Item.getFirstName().equals(firstName)) {
                return Item // return the current item if we've found the match
                ;
            }
        }

        // Other-wise return null
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
        multipleAddressBook.forEach((key, value) -> System.out.println(key));
    }


    // getRequriedDetailsToSearch returns an array of two strings book name and first name of user input respectively
    String []getRequriedDetailsToSearch(){
        String[] details = new String[2];

        System.out.println("Enter the address book name from the list : \n ");
        displayAllAddressBooksName();

        // Getting the book name
        System.out.println("entered the choice of your book name: ");
        details[0] = scanner.next();

        System.out.println("entered first name of the person");
        details[1] = scanner.next();

        return details;
    }
}
