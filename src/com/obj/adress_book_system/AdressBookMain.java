package com.obj.adress_book_system;

public class AdressBookMain {
    public static void main(String[] args) {

        ProcessAddressBook processAddressBook = new ProcessAddressBook();

        while (true) {

            processAddressBook.takingInputOverWhileLoop();

            switch (processAddressBook.choiceOfUsers) {

                case ProcessAddressBook.ADD_DETAILS:
                    processAddressBook.addDetails();
                    break;
                case ProcessAddressBook.PRINT_DETAILS:
                    processAddressBook.displayPersonDetails();
                    break;
                case ProcessAddressBook.EDIT_DETAILS:
                    processAddressBook.editDetails();
                    break;
                case ProcessAddressBook.DELETE_DETAILS:
                    processAddressBook.deleteDetails();
                    break;
                case ProcessAddressBook.EXIT_PROGRAM:
                    processAddressBook.displayTermination();
                    return;
                default:
                    System.out.println("Please Enter correct input !");
                    break;
            }
        }
    }
}