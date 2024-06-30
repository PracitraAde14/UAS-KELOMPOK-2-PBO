package projekuas;

public class BookStorage {
    private Book[] books;  // Array untuk menyimpan objek Book
    private int count;     // Counter untuk menghitung jumlah buku

    public BookStorage(int size) {
        books = new Book[size];
        count = 0;
    }

    public void addBook(Book book) {
        if (count < books.length) {
            books[count] = book;
            count++;
        } else {
            System.out.println("Penyimpanan penuh.");
        }
    }

    public Book searchBook(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].getJudul().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    public Book[] getAllBooks() {
        Book[] result = new Book[count];
        System.arraycopy(books, 0, result, 0, count);
        return result;
    }

    public int getCount() {
        return count;
    }
}
