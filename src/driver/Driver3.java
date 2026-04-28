package driver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import model.Pembeli;

public class Driver3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue<Pembeli> antrian = new LinkedList<>();

        int nomorAntrian = 1;

        while (true) {
            System.out.println("\n=== SISTEM KAFETARIA IT DEL ===");
            System.out.println("1. Indah");
            System.out.println("2. Adryan");
            System.out.println("3. Laura");
            System.out.println("0. Selesai");
            System.out.print("Pilih pembeli: ");
            int pilih = input.nextInt();
            input.nextLine();

            if (pilih == 0) break;

            String nama = "";
            switch (pilih) {
                case 1: nama = "Indah"; break;
                case 2: nama = "Adryan"; break;
                case 3: nama = "Laura"; break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    continue;
            }

            Pembeli p = new Pembeli(nama, nomorAntrian);

            // MULTI PESANAN
            while (true) {
                System.out.print("Masukkan menu: ");
                String menu = input.nextLine();

                if (!p.isValidMenu(menu)) {
                    System.out.println("Menu tidak tersedia!");
                    continue;
                }

                System.out.print("Jumlah: ");
                int jumlah = input.nextInt();
                input.nextLine();

                p.tambahPesanan(menu, jumlah);

                System.out.print("Tambah pesanan lagi? (y/n): ");
                String lagi = input.nextLine();
                if (lagi.equalsIgnoreCase("n")) break;
            }

            antrian.add(p);

            // hitung waktu tunggu
            int waktuTunggu = 0;
            for (Pembeli x : antrian) {
                if (x == p) break;
                waktuTunggu += x.getEstimasiWaktu();
            }

            System.out.println("\n✔ Pesanan berhasil!");
            System.out.println("Nomor Antrian : " + p.getNomorAntrian());
            System.out.println("Nama          : " + p.getNama());
            System.out.println("Total Bayar   : Rp " + p.getTotal());
            System.out.println("Estimasi Tunggu: " + waktuTunggu + " menit");

            nomorAntrian++;
        }

        // PROSES ANTRIAN
        System.out.println("\n=== PROSES TRANSAKSI ===");
        while (!antrian.isEmpty()) {
            Pembeli p = antrian.poll();

            System.out.println("\n===== STRUK =====");
            System.out.println("No Antrian : " + p.getNomorAntrian());
            System.out.println("Nama       : " + p.getNama());

            for (int i = 0; i < p.getDaftarMenu().size(); i++) {
                System.out.println("- " + p.getDaftarMenu().get(i) +
                                   " x" + p.getDaftarJumlah().get(i));
            }

            System.out.println("Total      : Rp " + p.getTotal());
            System.out.println("=================");
        }

        input.close();
    }
}