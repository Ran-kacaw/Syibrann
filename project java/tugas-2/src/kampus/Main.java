package kampus;

import java.util.Scanner;

public class Main {
    private static final Scanner INPUT=new Scanner(System.in);
    private static Mahasiswa data;

    public static void main(String[] args) {
        boolean selesai=false;
        do {
            tampilkanMenu();
            String pilihan=INPUT.nextLine().trim();
            switch(pilihan) {
                case "1": inputData(); break;
                case "2": jalankan(2); break;
                case "3": jalankan(3); break;
                case "4": jalankan(4); break;
                case "5": jalankan(5); break;
                case "6": jalankan(6); break;
                case "7": selesai=true; System.out.println("Program selesai."); break;
                default: System.out.println("Gunakan menu 1-7.");
            }
        } while(!selesai);
        INPUT.close();
    }

    private static void tampilkanMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Input Data Mahasiswa");
        System.out.println("2. Tampilkan Data Mahasiswa");
        System.out.println("3. Hitung Nilai Akhir");
        System.out.println("4. Tampilkan Grade");
        System.out.println("5. Tampilkan Status Kelulusan");
        System.out.println("6. Tampilkan Predikat");
        System.out.println("7. Keluar");
        System.out.print("Pilih menu: ");
    }

    private static void inputData() {
        System.out.print("NIM: "); String nim=INPUT.nextLine();
        System.out.print("Nama: "); String nama=INPUT.nextLine();
        double tugas=bacaAngka("Tugas");
        double uts=bacaAngka("UTS");
        double uas=bacaAngka("UAS");
        double hadir=bacaAngka("Kehadiran (%)");
        data=new Mahasiswa(nim,nama,tugas,uts,uas,hadir);
        System.out.println("Object mahasiswa berhasil dibuat.");
    }

    private static double bacaAngka(String label) {
        while(true) {
            System.out.print(label+" (0-100): ");
            try {
                double nilai=Double.parseDouble(INPUT.nextLine());
                if(Mahasiswa.nilaiValid(nilai)) return nilai;
                System.out.println("Nilai wajib 0-100.");
            } catch(NumberFormatException e) {
                System.out.println("Masukkan angka yang valid.");
            }
        }
    }

    private static void jalankan(int aksi) {
        if(data==null) { System.out.println("Input data terlebih dahulu."); return; }
        switch(aksi) {
            case 2: data.tampilkanData(); break;
            case 3: System.out.printf("Nilai Akhir: %.2f%n",data.hitungNilaiAkhir()); break;
            case 4: System.out.println("Grade: "+data.getGrade()); break;
            case 5: System.out.println("Status: "+data.getStatusKelulusan()); break;
            case 6: System.out.println("Predikat: "+data.getPredikat()); System.out.println(data.getPenghargaan()); break;
            default: System.out.println("Aksi tidak valid.");
        }
    }
}
