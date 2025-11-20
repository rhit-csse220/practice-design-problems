package booksA;

import java.util.ArrayList;
import java.util.List;

public class BookMain {

    // God-ish controller holding everything
    List<Kid> kids = new ArrayList<>();

    void handleNewReading(String bookName, String kidName) {
        // message-chain / name-based lookup everywhere
        Kid kid = findOrCreateKid(kidName);
        Book book = findOrCreateBookForKid(kid, bookName);

        // bidirectional many-to-many, done manually
        kid.addBook(book);
        book.addKid(kid);
    }

    void handlePrintReportForKid(String kidName) {
        Kid kid = findKidByName(kidName);
        if (kid != null) {
            kid.printReport();
        } else {
            System.out.println("No such kid: " + kidName);
        }
    }

    void handlePrintReportForBook(String bookName) {
        Book found = null;

        // No global list of books; search through every kid's books
        for (Kid k : kids) {
            for (Book b : k.books) {
                if (b.name != null && b.name.equals(bookName)) {
                    found = b;
                    break;
                }
            }
            if (found != null) {
                break;
            }
        }

        if (found != null) {
            found.printReport();
        } else {
            System.out.println("No such book: " + bookName);
        }
    }

    // --- Bad, name-based lookup helpers (message chains / God class) ---

    private Kid findOrCreateKid(String kidName) {
        Kid kid = findKidByName(kidName);
        if (kid == null) {
            kid = new Kid();
            kid.name = kidName;
            kid.gradeLevel = "unknown"; // no real model of grade
            kids.add(kid);
        }
        return kid;
    }

    private Kid findKidByName(String name) {
        for (Kid k : kids) {
            if (k.name != null && k.name.equals(name)) {
                return k;
            }
        }
        return null;
    }

    private Book findOrCreateBookForKid(Kid kid, String bookName) {
        for (Book b : kid.books) {
            if (b.name != null && b.name.equals(bookName)) {
                return b;
            }
        }
        Book book = new Book();
        book.name = bookName;
        book.author = "unknown"; // no real model of author
        kid.books.add(book);
        return book;
    }


    // --- Simple main to exercise the bad design ---

    public static void main(String[] args) {
        BookMain app = new BookMain();

        app.handleNewReading("Moby Dick", "Alice");
        app.handleNewReading("Moby Dick", "Bob");
        app.handleNewReading("1984", "Alice");

        app.handlePrintReportForKid("Alice");
        app.handlePrintReportForBook("Moby Dick");
    }
}

