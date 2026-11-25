package tugas;

public abstract class Karyawan {
    protected String name;

    public Karyawan(String newName) {
        this.name = newName;
    }

    public abstract int hitungGaji();
}
