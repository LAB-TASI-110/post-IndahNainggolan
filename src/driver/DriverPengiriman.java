package driver;

import java.util.Scanner;
import model.Paket;

public class DriverPengiriman {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Masukkan kode kota (MDN/BLG/JKT/SBY) atau END: ");
            String kota = input.nextLine();

            if (kota.equalsIgnoreCase("END")) {
                System.out.println("Program selesai.");
                break;
            }

            // VALIDASI KOTA
            if (!(kota.equalsIgnoreCase("MDN") ||
                  kota.equalsIgnoreCase("BLG") ||
                  kota.equalsIgnoreCase("JKT") ||
                  kota.equalsIgnoreCase("SBY"))) {
                System.out.println("Kode kota tidak valid! Coba lagi.\n");
                continue;
            }

            System.out.print("Masukkan berat paket Butet (kg): ");
            double berat = input.nextDouble();
            input.nextLine();

            Paket paket = new Paket(kota, berat);
            paket.hitung();

            // OUTPUT STRUK
            System.out.println("\n===== STRUK PENGIRIMAN =====");
            System.out.println("Kota Tujuan     : " + paket.getKodeKota().toUpperCase());
            System.out.println("Berat Butet     : " + paket.getBeratButet() + " kg");
            System.out.println("Berat Ucok      : " + paket.getBeratUcok() + " kg");
            System.out.println("Total Berat     : " + paket.getTotalBerat() + " kg");

            // FORMAT ONGKIR TANPA .0
            System.out.println("Total Ongkir    : Rp " + (int)paket.getTotalOngkir());

            System.out.print("Promo           : ");
            if (paket.isDiskon()) {
                System.out.print("Diskon 10% ");
            }
            if (paket.isAsuransi()) {
                System.out.print("+ Asuransi Gratis");
            }
            if (!paket.isDiskon() && !paket.isAsuransi()) {
                System.out.print("Tidak ada promo");
            }

            System.out.println("\n============================\n");
        }

        input.close();
    }
}