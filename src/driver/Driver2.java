package driver;

import java.util.Scanner;
import model.Gudang;

public class Driver2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input jumlah data
        System.out.print("Masukkan jumlah barang: ");
        int N = input.nextInt();

        int[] stok = new int[N];
        String[] kategori = new String[N];

        // Input stok
        System.out.println("Masukkan stok barang:");
        for (int i = 0; i < N; i++) {
            stok[i] = input.nextInt();
        }

        // Input kategori
        System.out.println("Masukkan kategori barang:");
        for (int i = 0; i < N; i++) {
            kategori[i] = input.next();
        }

        // Input kategori yang dicari
        System.out.print("Masukkan kategori yang ingin dihitung: ");
        String cari = input.next();

        // Proses
        Gudang gudang = new Gudang(stok, kategori);
        int total = gudang.hitungTotal(cari);

        // Output
        System.out.println("Total stok kategori " + cari + " = " + total);

        input.close();
    }
}