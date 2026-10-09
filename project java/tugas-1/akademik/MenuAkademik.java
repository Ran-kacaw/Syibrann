package akademik;

import java.util.Scanner;

public class MenuAkademik {

    static Scanner input = new Scanner(System.in);

    static int bacaInt(String pesan) {
        System.out.print(pesan);
        while (!input.hasNextInt()) {
            System.out.print("Input harus angka! " + pesan);
            input.next();
        }
        return input.nextInt();
    }

    static double bacaDouble(String pesan) {
        System.out.print(pesan);
        while (!input.hasNextDouble()) {
            System.out.print("Input harus angka! " + pesan);
            input.next();
        }
        return input.nextDouble();
    }

    static String tentukanGrade(double nilai) {
        if (nilai >= 85) {
            return "A";
        } else if (nilai >= 70) {
            return "B";
        } else if (nilai >= 55) {
            return "C";
        } else if (nilai >= 40) {
            return "D";
        } else {
            return "E";
        }
    }

    static void inputNilai() {
        int jumlah = bacaInt("Jumlah mahasiswa: ");
        if (jumlah <= 0) {
            System.out.println("Jumlah mahasiswa harus lebih dari 0.");
            return;
        }
        double[] daftarNilai = new double[jumlah];
        double total = 0;
        for (int i = 0; i < jumlah; i++) {
            double nilai = bacaDouble("Nilai mahasiswa ke-" + (i + 1) + " (0-100): ");
            while (nilai < 0 || nilai > 100) {
                System.out.println("Nilai harus 0-100!");
                nilai = bacaDouble("Nilai mahasiswa ke-" + (i + 1) + " (0-100): ");
            }
            daftarNilai[i] = nilai;
            total += nilai;
        }

        String garis = "+-------------+-------+-------+-------------+";
        System.out.println();
        System.out.println(garis);
        System.out.println("| Mahasiswa   | Nilai | Grade | Status      |");
        System.out.println(garis);
        for (int i = 0; i < jumlah; i++) {
            String status = (daftarNilai[i] >= 55) ? "LULUS" : "TIDAK LULUS";
            System.out.printf("| %-11s | %5.1f | %-5s | %-11s |%n",
                    "Mahasiswa " + (i + 1), daftarNilai[i], tentukanGrade(daftarNilai[i]), status);
        }
        System.out.println(garis);
        double rata = total / jumlah;
        System.out.printf("Rata-rata kelas: %.2f (Grade %s)%n", rata, tentukanGrade(rata));
    }

    static void bilanganGenap() {
        int batas = bacaInt("Tampilkan bilangan genap sampai: ");
        if (batas < 2) {
            System.out.println("Tidak ada bilangan genap positif pada rentang tersebut.");
            return;
        }
        for (int i = 2; i <= batas; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void faktorial() {
        int n = bacaInt("Masukkan bilangan: ");
        if (n < 0) {
            System.out.println("Faktorial tidak terdefinisi untuk bilangan negatif.");
        } else if (n > 20) {
            System.out.println("Maksimal 20 (lebih dari itu overflow tipe long).");
        } else {
            long hasil = 1;
            int i = n;
            while (i > 1) {
                hasil *= i;
                i--;
            }
            System.out.println(n + "! = " + hasil);
        }
    }

    static void polaBintang() {
        int tinggi = bacaInt("Tinggi pola: ");
        if (tinggi <= 0) {
            System.out.println("Tinggi harus lebih dari 0.");
            return;
        }
        for (int baris = 1; baris <= tinggi; baris++) {
            for (int kolom = 1; kolom <= baris; kolom++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // Submenu setelah output tiap menu: 0 = kembali, 1 = keluar. Mengembalikan 5 jika keluar.
    static int menuLanjut() {
        System.out.println();
        System.out.println("0. Kembali ke menu utama");
        System.out.println("1. Keluar");
        int pilih = bacaInt("Pilih: ");
        while (pilih != 0 && pilih != 1) {
            System.out.println("Pilihan tidak valid! Pilih 0 atau 1.");
            pilih = bacaInt("Pilih: ");
        }
        return (pilih == 1) ? 5 : 0;
    }

    static void tampilMenu() {
        System.out.println("================================");
        System.out.println("       MENU AKADEMIK");
        System.out.println("================================");
        System.out.println("1. Input Nilai Mahasiswa");
        System.out.println("2. Tampilkan Bilangan Genap");
        System.out.println("3. Hitung Faktorial");
        System.out.println("4. Tampilkan Pola Bintang");
        System.out.println("5. Keluar");
        System.out.println("================================");
    }

    public static void main(String[] args) {
        int pilihan;
        do {
            tampilMenu();
            pilihan = bacaInt("Pilih menu: ");
            System.out.println();
            switch (pilihan) {
                case 1: inputNilai(); pilihan = menuLanjut(); break;
                case 2: bilanganGenap(); pilihan = menuLanjut(); break;
                case 3: faktorial(); pilihan = menuLanjut(); break;
                case 4: polaBintang(); pilihan = menuLanjut(); break;
                case 5: break;
                default: System.out.println("Pilihan tidak valid! Pilih 1-5.");
            }
            if (pilihan == 5) {
                System.out.println("Terima kasih. Program selesai.");
            }
            System.out.println();
        } while (pilihan != 5);
        input.close();
    }
}