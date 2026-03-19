import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Akun> daftarPelanggan = new ArrayList<>();

        daftarPelanggan.add(new Akun("Budi", "3827407689", 15000, "0102"));
        daftarPelanggan.add(new Akun("Chris", "5681907724", 50000000, "7777"));
        daftarPelanggan.add(new Akun("Dandika", "7455126201", 1000000000, "1234"));

        while (true) {
            System.out.print("Masukkan nomer pelanggan : ");
            String noCust = sc.nextLine();
           
            Akun ketemu = null;
            for (Akun cari : daftarPelanggan){
                    if (cari.getNomerPelanggan().equals(noCust)) {
                        ketemu = cari;
                        break;
                    }
            }
            if (ketemu == null) {
                System.out.println("Nomer Pelanggan tidak ditemukan.");
                continue;
            }

            System.out.print("Masukkan PIN : ");
            String pinCust = sc.nextLine();

            if (ketemu.getPin().equals(pinCust)) {
                boolean tampilMenu = true;
                while (tampilMenu) {
                    System.out.println("\nMENU:");
                    System.out.println("1. Top Up");
                    System.out.println("2. Pembelian");
                    System.out.println("3. Cek Saldo");
                    System.out.println("4. Keluar.");
                    System.out.print("Pilih transaksi: ");
                    int menu = sc.nextInt();
                    sc.nextLine();

                    switch (menu) {
                        case 1:
                            System.out.print("Masukkan nominal Top-Up : ");
                            int nominalTopUp = sc.nextInt();
                            TransaksiPengguna.topUp(ketemu, nominalTopUp);
                            break;
                        case 2:
                            System.out.print("Masukkan nominal Pembelian : ");
                            int nominalBeli = sc.nextInt();
                            TransaksiPengguna.pembelian(ketemu, nominalBeli);
                            break;
                        case 3:
                            System.out.printf("Saldo Anda : %,d\n" , ketemu.getSaldo());
                            break;
                        case 4:
                            System.out.println("Terima kasih telah menggunakan layanan kami!");
                            tampilMenu = false;
                            break;
                        default:
                            System.out.println("Pilihan tidak valid.");
                            break;
                    }
                }
            } else {
                ketemu.tambahSalahPin();
                if (ketemu.isBlokir()) {
                    System.out.println("Akun telah diblokir karena kesalahan PIN 3 kali.");
                } else {
                    System.out.println("PIN salah. Percobaan ke-" + ketemu.getJumlahSalahPin());
                }
                sc.close();
            }
        }
    }
}
