package model;

public class Gudang {
    private int[] stok;
    private String[] kategori;

    // Constructor
    public Gudang(int[] stok, String[] kategori) {
        this.stok = stok;
        this.kategori = kategori;
    }

    // Method untuk hitung total stok berdasarkan kategori
    public int hitungTotal(String targetKategori) {
        int total = 0;

        for (int i = 0; i < stok.length; i++) {
            if (kategori[i].equalsIgnoreCase(targetKategori)) {
                total += stok[i];
            }
        }

        return total;
    }
}