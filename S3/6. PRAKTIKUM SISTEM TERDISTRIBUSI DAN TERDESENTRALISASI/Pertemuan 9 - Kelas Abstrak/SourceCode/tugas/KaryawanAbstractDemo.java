package tugas;

public class KaryawanAbstractDemo {
    public static void main(String[] args) {
        KaryawanTetap karyawan1 = new KaryawanTetap(20000000, 5000000, "Xavier Christian Rihi");
        KaryawanHarian karyawan2 = new KaryawanHarian(100000, 15, "Muhhamad Zakir Afri");

        karyawan1.info();
        karyawan2.info();
    }
}
