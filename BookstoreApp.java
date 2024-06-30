package projekuas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookstoreApp extends JFrame {
    private JTextField judulField, namaPengarangField, penerbitField, tahunCetakField, searchField;
    private JComboBox<String> kategoriComboBox;
    private JTextArea displayArea;
    private BookStorage bookStorage;

    public BookstoreApp() {
        setTitle("Aplikasi Toko Buku");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        bookStorage = new BookStorage(3);

        JPanel inputPanel = new JPanel(new GridLayout(7, 2));

        inputPanel.add(new JLabel("Judul:"));
        judulField = new JTextField();
        inputPanel.add(judulField);

        inputPanel.add(new JLabel("Nama Pengarang:"));
        namaPengarangField = new JTextField();
        inputPanel.add(namaPengarangField);

        inputPanel.add(new JLabel("Penerbit:"));
        penerbitField = new JTextField();
        inputPanel.add(penerbitField);

        inputPanel.add(new JLabel("Tahun Cetak:"));
        tahunCetakField = new JTextField();
        inputPanel.add(tahunCetakField);

        inputPanel.add(new JLabel("Kategori:"));
        String[] categories = {"su = semua umur", "r = remaja", "d = dewasa", "a = anak"};
        kategoriComboBox = new JComboBox<>(categories);
        inputPanel.add(kategoriComboBox);

        JButton addButton = new JButton("Tambahkan Buku");
        inputPanel.add(addButton);

        JButton searchButton = new JButton("Cari Buku");
        inputPanel.add(searchButton);

        searchField = new JTextField();
        inputPanel.add(searchField);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bookStorage.getCount() < 3) {
                    String judul = judulField.getText();
                    String namaPengarang = namaPengarangField.getText();
                    String penerbit = penerbitField.getText();
                    int tahunCetak = Integer.parseInt(tahunCetakField.getText());
                    String kategori = (String) kategoriComboBox.getSelectedItem();

                    Book book = new Book(judul, namaPengarang, penerbit, tahunCetak, kategori);
                    bookStorage.addBook(book);
                    displayBooks();
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(BookstoreApp.this, "Anda hanya bisa menambahkan 3 buku.");
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = searchField.getText();
                Book book = bookStorage.searchBook(title);
                if (book != null) {
                    displayArea.setText("Buku ditemukan:\n" + book.toString());
                } else {
                    displayArea.setText("Buku tidak ditemukan.");
                }
            }
        });
    }

    private void displayBooks() {
        displayArea.setText("");
        Book[] books = bookStorage.getAllBooks();
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            displayArea.append("Buku " + (i + 1) + ":\n");
            displayArea.append(book.toString() + "\n\n");
        }
    }

    private void clearFields() {
        judulField.setText("");
        namaPengarangField.setText("");
        penerbitField.setText("");
        tahunCetakField.setText("");
        kategoriComboBox.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BookstoreApp().setVisible(true);
            }
        });
    }
}
