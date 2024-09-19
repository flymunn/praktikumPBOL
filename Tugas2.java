import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class CRUDMahasiswa {
    private static Map<String, String> dataMahasiswa = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Daftar Mahasiswa");
            System.out.println("3. Pembaharuan Mahasiswa");
            System.out.println("4. Pengahapusan Mahasiswa");
            System.out.print("Pilih opsi (1-4): ");
            pilihan = scanner.nextInt();
            scanner.nextLine();  

            switch (pilihan) {
                case 1:
                    createMahasiswa();
                    break;
                case 2:
                    readMahasiswa();
                    break;
                case 3:
                    updateMahasiswa();
                    break;
                case 4:
                    deleteMahasiswa();
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        } while (pilihan != 4);
    }

    private static void createMahasiswa() {
        System.out.println("\n--- Tambah Mahasiswa ---");
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();

        if (dataMahasiswa.containsKey(nim)) {
            System.out.println("NIM sudah terdaftar! Silakan gunakan NIM lain.");
        } else {
            System.out.print("Masukkan Nama: ");
            String nama = scanner.nextLine();
            dataMahasiswa.put(nim, nama);
            System.out.println("Mahasiswa berhasil ditambahkan.");
        }
    }

    private static void readMahasiswa() {
        System.out.println("\n--- Daftar Mahasiswa ---");
        if (dataMahasiswa.isEmpty()) {
            System.out.println("Tidak ada data mahasiswa.");
        } else {
            for (Map.Entry<String, String> entry : dataMahasiswa.entrySet()) {
                System.out.println("NIM: " + entry.getKey() + ", Nama: " + entry.getValue());
            }
        }
    }

    private static void updateMahasiswa() {
        System.out.println("\n--- Update Mahasiswa ---");
        System.out.print("Masukkan NIM mahasiswa yang ingin diupdate: ");
        String nim = scanner.nextLine();

        if (dataMahasiswa.containsKey(nim)) {
            System.out.print("Masukkan Nama baru: ");
            String namaBaru = scanner.nextLine();
            dataMahasiswa.put(nim, namaBaru);
            System.out.println("Data mahasiswa berhasil diupdate.");
        } else {
            System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
        }
    }

    private static void deleteMahasiswa() {
        System.out.println("\n--- Hapus Mahasiswa ---");
        System.out.print("Masukkan NIM mahasiswa yang ingin dihapus: ");
        String nim = scanner.nextLine();

        if (dataMahasiswa.containsKey(nim)) {
            dataMahasiswa.remove(nim);
            System.out.println("Data mahasiswa berhasil dihapus.");
        } else {
            System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
        }
    }
}
