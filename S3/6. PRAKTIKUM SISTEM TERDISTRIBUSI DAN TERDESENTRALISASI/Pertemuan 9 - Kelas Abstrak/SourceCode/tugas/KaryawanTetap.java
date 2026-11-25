package tugas;

public class KaryawanTetap extends Karyawan {
    private int gajiPokok;
    private int tunjangan;

    public KaryawanTetap(int newGajiPokok, int newTunjangan, String newNama) {
        super(newNama);
        this.gajiPokok = newGajiPokok;
        this.tunjangan = newTunjangan;
    }

    @Override
    public int hitungGaji() {
        return this.gajiPokok + this.tunjangan;
    }

    public void info() {
        System.out.println("================================");
        System.out.println("Informasi Karyawan Tetap");
        System.out.println("Nama Karyawan : " + this.name);
        System.out.println("Gaji Karyawan : " + hitungGaji());
        System.out.println("================================");
    }
}
