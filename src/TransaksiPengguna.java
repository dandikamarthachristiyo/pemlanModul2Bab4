public class TransaksiPengguna {
    public static void topUp (Akun akun, int nominal) {
        akun.tambahSaldo(nominal);
        System.out.printf("Top up Anda berhasi. Saldo anda sekarang : %,d\n" , akun.getSaldo());
    }
    
    public static void pembelian(Akun akun, int nominal) {
        String kodeDepan = akun.getNomerPelanggan().substring(0, 2);
        int cashback = 0;

        if (kodeDepan.equals("38")) {
            if (nominal > 1000000) {
                cashback = (int) (nominal * 0.05);
            }
        } else if (kodeDepan.equals("56")){
            if (nominal > 1000000) {
                cashback = (int) (nominal * 0.07);
            } else {
                cashback = (int) (nominal * 0.02);
            }
        } else if (kodeDepan.equals("74")){
            if (nominal > 1000000) {
                cashback = (int) (nominal * 0.10);
            } else {
                cashback = (int) (nominal * 0.05);
            }
        }

        int saldoMinimal = akun.getSaldo() - nominal + cashback;

        if (saldoMinimal < 10000) {
            System.out.println("Transaksi gagal. Saldo setelah transaksi minimal Rp. 10.000");
            System.out.println("Saldo pasca transaksi Anda sekitar : " + saldoMinimal);
        } else {
            akun.kurangSaldo(nominal);
            akun.tambahSaldo(cashback);
            System.out.println("Pembelian Berhasil.");
            if (cashback > 0) {
                System.out.printf("Selamat, anda mendapat cashback sebesar Rp. %,d\n" , cashback);
            }
        }
    }
}
