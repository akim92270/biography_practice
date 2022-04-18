import java.util.ArrayList;
import java.util.Scanner;

public class Biography {
    public static void main(String[] args) {

        /**
         * WORK ON BOOK AND AUTHOR CLASSES FIRST
         This will be our actual program that we define author and his books
         In this program we will write the biography of Stefan Zweig, an Austrian novelist.


         Write a program that will get information from user and
         -Print information for the favorite author
         -Print information of the books of favorite author

         Full name = Stefan Zweig
         County = Austria
         Is still alive: No (28 November 1881 – 22 February 1942)
         Some of his books as listed below:

         BookName                            Genre           TotalPage
         Amok                                tale            189
         The Royal Game                      novella         53
         24 Hours in the Life of a Woman     novella         80
         */

        /*
        Expected result:
        Author's information = Author{firstName='Stefan', lastName='Zweig', country='Austria', isAlive=false}
        Author's books are as listed below:
        Book{name='Amok', genre:'tale', page=189}
        Book{name='The Royal Game', tale='novella', page=53}
        Book{name='24 Hours in the Life of a Woman', tale='novella', page=80}
         */

        //YOUR CODE HERE

        Scanner scan = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        System.out.println(AuthorQuestions.firstName);
        String firstName = scan.next();

        System.out.println(AuthorQuestions.lastName);
        String lastName = scan.next();
        scan.nextLine();

        System.out.println(AuthorQuestions.authorFrom);
        String authorCountry = scan.nextLine();

        System.out.println(AuthorQuestions.authorAlive);
        boolean authorAlive = scan.next().toUpperCase().startsWith("Y");

        int authorAge = 0;
        if (authorAlive) {
            System.out.println(AuthorQuestions.authorAge);
            authorAge = scan.nextInt();
        }

        String bookInfo;

        do {
            System.out.println(BookQuestions.bookInfo);
            bookInfo = scan.nextLine();

            if (bookInfo.toUpperCase().startsWith("N")) break;
            else if (bookInfo.toUpperCase().startsWith("Y")) {

                System.out.println(BookQuestions.bookName);
                String bookName = scan.nextLine();

                System.out.println(BookQuestions.bookGenre);
                String bookGenre = scan.nextLine();

                System.out.println(BookQuestions.bookPages);
                int bookPages = scan.nextInt();

                Book book = new Book(bookName, bookGenre, bookPages);
                books.add(book);

            }
        }
        while (bookInfo.toUpperCase().startsWith("Y"));

        Author author = new Author(firstName, lastName, authorCountry, authorAlive, authorAge, books);
        System.out.println("Author's information = " + author);

        if (!books.isEmpty()) {
            System.out.println("Author's books are as listed below:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}
