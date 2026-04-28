package model;

/**
 * Program: Sistem Pengiriman Paket
 * Author : Indah Elsadai Nainggolan
 * NIM    : 12S24046
 */

public class Paket {
    private String kodeKota;
    private double beratButet;
    private double beratUcok;
    private double totalBerat;
    private double hargaPerKg;
    private double totalOngkir;
    private boolean diskon;
    private boolean asuransi;

    // Constructor
    public Paket(String kodeKota, double beratButet) {
        this.kodeKota = kodeKota;
        this.beratButet = beratButet;
    }

    // Set harga berdasarkan kota
    private void setHarga() {
        switch (kodeKota.toUpperCase()) {
            case "MDN":
                hargaPerKg = 8000;
                break;
            case "BLG":
                hargaPerKg = 5000;
                break;
            case "JKT":
                hargaPerKg = 12000;
                break;
            case "SBY":
                hargaPerKg = 13000;
                break;
        }
    }

    // Proses perhitungan
    public void hitung() {
        beratUcok = (3.0 / 2.0) * beratButet;
        totalBerat = beratButet + beratUcok;

        setHarga();

        totalOngkir = totalBerat * hargaPerKg;

        // Diskon
        if (totalBerat > 10) {
            totalOngkir *= 0.9;
            diskon = true;
        } else {
            diskon = false;
        }

        // Asuransi
        if (kodeKota.equalsIgnoreCase("JKT") || kodeKota.equalsIgnoreCase("SBY")) {
            asuransi = true;
        } else {
            asuransi = false;
        }
    }

    // Getter
    public String getKodeKota() { return kodeKota; }
    public double getBeratButet() { return beratButet; }
    public double getBeratUcok() { return beratUcok; }
    public double getTotalBerat() { return totalBerat; }
    public double getTotalOngkir() { return totalOngkir; }
    public boolean isDiskon() { return diskon; }
    public boolean isAsuransi() { return asuransi; }
}