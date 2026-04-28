package model;

import java.util.ArrayList;

public class Pembeli {
    private String nama;
    private ArrayList<String> daftarMenu;
    private ArrayList<Integer> daftarJumlah;
    private int total;
    private int nomorAntrian;

    public Pembeli(String nama, int nomorAntrian) {
        this.nama = nama;
        this.nomorAntrian = nomorAntrian;
        this.daftarMenu = new ArrayList<>();
        this.daftarJumlah = new ArrayList<>();
        this.total = 0;
    }

    // tambah pesanan
    public void tambahPesanan(String menu, int jumlah) {
        int harga = setHarga(menu);
        if (harga == 0) return;

        daftarMenu.add(menu);
        daftarJumlah.add(jumlah);
        total += harga * jumlah;
    }

    // harga menu
    private int setHarga(String menu) {
        switch (menu.toLowerCase()) {
            case "bakwan":
            case "tempe":
            case "pisang coklat":
            case "tahu":
            case "ubi goreng":
                return 10000;
            case "sosis":
            case "roti isi ayam":
            case "nugget":
                return 15000;
            case "cappucino":
            case "chokolatos":
                return 8000;
            default:
                return 0;
        }
    }

    public boolean isValidMenu(String menu) {
        return setHarga(menu) != 0;
    }

    // estimasi waktu (2 menit per item)
    public int getEstimasiWaktu() {
        int totalItem = 0;
        for (int j : daftarJumlah) {
            totalItem += j;
        }
        return totalItem * 2;
    }

    // getter
    public String getNama() { return nama; }
    public int getTotal() { return total; }
    public int getNomorAntrian() { return nomorAntrian; }
    public ArrayList<String> getDaftarMenu() { return daftarMenu; }
    public ArrayList<Integer> getDaftarJumlah() { return daftarJumlah; }
}