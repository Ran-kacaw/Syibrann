package kampus;

public class Mahasiswa {
    private String nim; private String nama; private double tugas; private double uts; private double uas; private double kehadiran;

    public Mahasiswa(String nim,String nama,double tugas,double uts,double uas,double kehadiran) {
        this.nim=nim; this.nama=nama; this.tugas=tugas; this.uts=uts; this.uas=uas; this.kehadiran=kehadiran;
    }

    // Bobot sesuai ketentuan tugas praktikum.
    public double hitungNilaiAkhir() { return tugas*0.30 + uts*0.30 + uas*0.40; }

    public String getGrade() {
        double n=hitungNilaiAkhir();
        if(n>=85)return "A"; else if(n>=75)return "B"; else if(n>=65)return "C"; else if(n>=50)return "D"; else return "E";
    }

    public String getPredikat() {
        double n = hitungNilaiAkhir();
        int kode;
        if (n >= 90) kode=1; else if (n >= 80) kode=2; else if (n >= 70) kode=3; else kode=4;
        switch (kode) { case 1: return "Sangat Memuaskan"; case 2: return "Memuaskan"; case 3: return "Baik"; default: return "Perlu Peningkatan"; }
    }

    public String getStatusKelulusan() {
        double n=hitungNilaiAkhir();
        if(n>=60) {
            // Nested if memenuhi syarat nilai dan kehadiran secara terpisah.
            if(kehadiran>=75)return "LULUS";
            else return "TIDAK LULUS - Kehadiran kurang";
        } else if(n>=50)return "REMEDIAL";
        else return "TIDAK LULUS";
    }

    public String getPenghargaan() {
        if(hitungNilaiAkhir()>=90 && kehadiran>=90)return "Penghargaan: Mahasiswa Berprestasi";
        return "Belum memperoleh penghargaan akademik";
    }

    public void tampilkanData() {
        System.out.println("\n--- DATA MAHASISWA ---");
        System.out.println("NIM       : "+nim); System.out.println("Nama      : "+nama);
        System.out.println("Tugas     : "+tugas); System.out.println("UTS       : "+uts);
        System.out.println("UAS       : "+uas); System.out.println("Kehadiran : "+kehadiran+"%");
    }

    public static boolean nilaiValid(double n) { return n>=0 && n<=100; }
}
