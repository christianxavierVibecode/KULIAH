import java.util.Scanner;

public class latihan_searchingarray {
    // Sequential Search
    public static int SequentialSearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Menghindari overflow pada array besar

            if (arr[mid] == target) {
                return mid; // Data ditemukan
            }

            if (arr[mid] < target) {
                low = mid + 1; // Cari di bagian kanan
            } else {
                high = mid - 1; // Cari di bagian kiri
            }
        }
        return -1;
    }

    // Binary Search
    public static int BinarySearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Mengembalikan indeks jika ditemukan
            }
        }
        return -1; // Mengembalikan -1 jika tidak ditemukan
    }

    public static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        int[] data = { 7, 12, 23, 45, 56, 89 };
        int result = 0;

        System.out.println("Contoh Data Array => {7, 12, 23, 45, 56, 89}");
        System.out.print("Masukkan data yang ingin dicari : ");
        int target = userInput.nextInt();
        System.out.println();

        while (true) {
            System.out.println("Menu");
            System.out.println("1. SequentialSearch");
            System.out.println("2. BinarySearch");
            System.out.print("Silahkan masukkan pilihan anda : ");
            int pilihan = userInput.nextInt();

            boolean valid = true;
            switch (pilihan) {
                case 1:
                    result = SequentialSearch(data, target);

                    if (result != -1) {
                        System.out.println("Sequential : Angka " + target + " ditemukan di indeks " + result);
                    } else {
                        System.out.println("Binary: Angka tidak ditemukan.");
                    }
                    break;

                case 2:
                    result = BinarySearch(data, target);

                    if (result != -1) {
                        System.out.println("Binary : Angka " + target + " ditemukan di indeks " + result);
                    } else {
                        System.out.println("Sequential: Angka tidak ditemukan.");
                    }
                    break;

                default:
                    System.out.println("Pilihan yang anda masukkan tidak valid!!!");
                    System.out.println("");
                    valid = false;
                    break;
            }

            if (valid)
                break;
        }
    }
}
