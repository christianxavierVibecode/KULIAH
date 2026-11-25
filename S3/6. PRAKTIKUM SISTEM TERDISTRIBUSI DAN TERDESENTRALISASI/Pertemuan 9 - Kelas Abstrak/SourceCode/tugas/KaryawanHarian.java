package tugas;

public class KaryawanHarian extends Karyawan {
    private int upahPerHari;
    private int jumlahHari;

    public KaryawanHarian(int newUpahPerHari, int newJumlahHari, String newNama) {
        super(newNama);
        this.upahPerHari = newUpahPerHari;
        this.jumlahHari = newJumlahHari;
    }

    @Override
    public int hitungGaji() {
        return this.upahPerHari * this.jumlahHari;
    }

    public void info() {
        System.out.println("================================");
        System.out.println("Informasi Karyawan Harian");
        System.out.println("Nama Karyawan : " + this.name);
        System.out.println("Gaji Karyawan : " + hitungGaji());
        System.out.println("================================");
    }
}
