package projekuas;

public class Book {
    private String judul;
    private String namaPengarang;
    private String penerbit;
    private int tahunCetak;
    private String kategori;

    public Book(String judul, String namaPengarang, String penerbit, int tahunCetak, String kategori) {
        this.judul = judul;
        this.namaPengarang = namaPengarang;
        this.penerbit = penerbit;
        this.tahunCetak = tahunCetak;
        this.kategori = kategori;
    }

    public String getJudul() { return judul; }
    public String getNamaPengarang() { return namaPengarang; }
    public String getPenerbit() { return penerbit; }
    public int getTahunCetak() { return tahunCetak; }
    public String getKategori() { return kategori; }

    @Override
    public String toString() {
        return "Judul: " + judul + "\n" +
               "Nama Pengarang: " + namaPengarang + "\n" +
               "Penerbit: " + penerbit + "\n" +
               "Tahun Cetak: " + tahunCetak + "\n" +
               "Kategori: " + kategori;
    }
}
