public class Akun {
    private int saldo;
    private String nomerPelanggan;
    private String nama;
    private String pin;

    private int jumlahSalahPin;
    private boolean isBlokir = false;

    public Akun (String nama, String nomerPelanggan, int saldo, String pin) {
        this.nama = nama;
        this.nomerPelanggan = nomerPelanggan;
        this.saldo = saldo;
        this.pin = pin;
    }

    public int getSaldo() {
        return saldo;
    }

    public String getNomerPelanggan() {
        return nomerPelanggan;
    }

    public String getNama() {
        return nama;
    }

    public String getPin() {
        return pin;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public void setNomerPelanggan(String nomerPelanggan) {
        this.nomerPelanggan = nomerPelanggan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
    
    public void tambahSaldo(int tambah) {
        this.saldo += tambah;
    }
    
    public void kurangSaldo(int kurang) {
        this.saldo += kurang;
    }
    
    public void tambahSalahPin(){
        this.jumlahSalahPin++;
        if (this.jumlahSalahPin >= 3) {
            isBlokir = true;
        }
    }

    public int getJumlahSalahPin() {
        return jumlahSalahPin;
    }

    public boolean isBlokir() {
        return isBlokir;
    }
}
