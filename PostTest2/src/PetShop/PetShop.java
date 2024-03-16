package PetShop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Barang {
    protected String nama; // Encapsulation: Protected access modifier
    private double harga; // Encapsulation: Private access modifier

    // Encapsulation: Public access modifier
    public Barang(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public double getHarga() {
        return harga;
    }
    public void setHarga(double harga) {
        this.harga = harga;
    }
}

class MakananHewan extends Barang {
    private String jenisHewan; 
    private String namaMakanan;

    public MakananHewan(String namaMakanan, double harga, String jenisHewan) {
        super(namaMakanan, harga);
        this.namaMakanan = namaMakanan;
        this.jenisHewan = jenisHewan;
    }
    public String getNamaMakanan() {
        return namaMakanan;
    }
    public void setNamaMakanan(String namaMakanan) {
        this.namaMakanan = namaMakanan;
    }
    public String getJenisHewan() {
        return jenisHewan;
    }
    public void setJenisHewan(String jenisHewan) {
        this.jenisHewan = jenisHewan;
    }
}

class Suplemen extends Barang {
    private String namaSuplemen;
    private String jenisHewan;

    public Suplemen(String namaSuplemen, double harga, String jenisHewan) {
        super(namaSuplemen, harga);
        this.namaSuplemen = namaSuplemen;
        this.jenisHewan = jenisHewan;
    }
    public String getNamaSuplemen() {
        return namaSuplemen;
    }
    public void setNamaSuplemen(String namaSuplemen) {
        this.namaSuplemen = namaSuplemen;
    }
    public String getJenisHewan() {
        return jenisHewan;
    }
    public void setJenisHewan(String jenisHewan) {
        this.jenisHewan = jenisHewan;
    }
}

public class PetShop {
    private static List<Barang> daftarBarang = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            clearScreen();
            System.out.println("------------------------------------------");
            System.out.println("|    SELAMAT DATANG DI MOZAA PET SHOP    |");
            System.out.println("------------------------------------------");
            System.out.println("|                  MENU                  |");
            System.out.println("------------------------------------------");
            System.out.println("| 1. INPUT DAFTAR BARANG                 |");
            System.out.println("| 2. MENAMPILKAN DAFTAR BARANG           |");
            System.out.println("| 3. UPDATE DAFTAR BARANG                |");
            System.out.println("| 4. DELETE DAFTAR BARANG                |");
            System.out.println("| 5. EXIT                                |");
            System.out.println("------------------------------------------");
            System.out.print("Pilih Menu : ");
            int menu;
            while (true) {
                try {
                    menu = Integer.parseInt(scanner.nextLine());
                    if (menu <= 0) {
                        throw new NumberFormatException();
                    }
                    break; 
                    } 
                catch (NumberFormatException e) {
                    System.out.println("SILAHKAN PILIH MENU YANG TERSEDIA");
                    System.out.print("Pilih Menu : ");
                }
            }
            switch (menu) {
                case 1:
                    menuInput();
                    break;
                case 2:
                    tampilkanBarang();
                    break;
                case 3:
                    UpdateBarang();
                    break;
                case 4:
                    deleteBarang();
                    break;
                case 5:
                    clearScreen();
                    System.out.println("~ ~           THANK YOU           ~ ~");
                    System.out.println("~ ~       BY MOZAA PET SHOP       ~ ~");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("MENU TIDAK TERSEDIA");
                    scanner.nextLine();
            }
        }
    }

    private static void menuInput() {
        clearScreen();
        System.out.println("----------------------------");
        System.out.println("|      MOZAA PET SHOP      |");
        System.out.println("----------------------------");
        System.out.println("| 1. BARANG UMUM           |");
        System.out.println("| 2. MAKANAN HEWAN         |");
        System.out.println("| 3. SUPLEMEN              |");
        System.out.println("| 4. BACK TO MENU          |");
        System.out.println("----------------------------");
        System.out.print("Pilih Jenis Barang : ");
        int jenis;
            while (true) {
                try {
                    jenis = Integer.parseInt(scanner.nextLine());
                    if (jenis <= 0) {
                        throw new NumberFormatException(); 
                    }
                    break; 
                    } 
                catch (NumberFormatException e) {
                    System.out.println("SILAHKAN PILIH JENIS BARANG YANG TERSEDIA");
                    System.out.print("Pilih Jenis Barang : ");
                }
            }
        switch (jenis) {
            case 1:
                TambahBarang();
                break;
            case 2:
                TambahMakanan();
                break;
            case 3:
                TambahSuplemen();
                break;
            case 4:
                return;
            default:
                System.out.println("PILIHAN TIDAK TERSEDIA");
                scanner.nextLine();
        }
    }

    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error while clearing the screen: " + e.getMessage());
        }
    }
    
    private static void TambahBarang() {
        clearScreen();
        String nama;
        double harga;
        System.out.print("Nama Barang   : ");
        nama = scanner.nextLine();
        while (true) {
            System.out.print("Harga Barang  : ");
            if (scanner.hasNextDouble()){
                harga = scanner.nextDouble();
                scanner.nextLine();            
                if (harga >= 10000) {
                    break;
                } else {
                    System.out.println("HARGA MINIMAL 10000");
                }
            } else {
                System.out.println("HARGA HARUS BERUPA ANGKA");
                scanner.nextLine();
            }
        }
        Barang barang = new Barang(nama, harga);
        daftarBarang.add(barang);
        System.out.println("-------------------------------");
        System.out.println("BARANG BERHASIL DITAMBAHKAN");
        scanner.nextLine();
    }

    private static void TambahMakanan() {
        clearScreen();
        String nama , jenisHewan;
        double harga;
        System.out.print("Nama Makanan   : ");
        nama = scanner.nextLine();
        while (true) {
            System.out.print("Harga Makanan  : ");
            if (scanner.hasNextDouble()){
                harga = scanner.nextDouble();
                scanner.nextLine();            
                if (harga >= 10000) {
                    break;
                } else {
                    System.out.println("HARGA MINIMAL 10000");
                }
            } else {
                System.out.println("HARGA HARUS BERUPA ANGKA");
                scanner.nextLine();
            }
        }            
        System.out.print("Jenis Hewan    : ");
        jenisHewan = scanner.nextLine();
        MakananHewan makananHewan = new MakananHewan(nama, harga, jenisHewan);
        daftarBarang.add(makananHewan);
        System.out.println("--------------------------------------");
        System.out.println("MAKANAN HEWAN BERHASIL DITAMBAHKAN");
        scanner.nextLine();
    }

    private static void TambahSuplemen() {
        clearScreen();
        String nama, jenisHewan;
        double harga;
        System.out.print("Nama Suplemen   : ");
        nama = scanner.nextLine();
        while (true) {
            System.out.print("Harga Suplemen  : ");
            if (scanner.hasNextDouble()){
                harga = scanner.nextDouble();
                scanner.nextLine();            
                if (harga >= 10000) {
                    break;
                } else {
                    System.out.println("HARGA MINIMAL 10000");
                }
            } else {
                System.out.println("HARGA HARUS BERUPA ANGKA");
                scanner.nextLine();
            }
        }
        System.out.print("Jenis Hewan     : ");
        jenisHewan = scanner.nextLine();
        Suplemen suplemen = new Suplemen(nama, harga, jenisHewan);
        daftarBarang.add(suplemen);
        System.out.println("---------------------------------");
        System.out.println("SUPLEMEN BERHASIL DITAMBAHKAN");
        scanner.nextLine();
    }

    private static void tampilkanBarang() {
        clearScreen();
        if (daftarBarang.isEmpty()) {
            System.out.println("MAAF, BARANG BELUM TERSEDIA");
        } else {
            System.out.println("--------------------------------------------------------------------------------------------");
            System.out.println("|                                     MOZAA PET SHOP                                       |");
            System.out.println("--------------------------------------------------------------------------------------------");
            System.out.printf("| %-2s | %-17s | %-20s | %-20s | %-17s |%n", "No", "Jenis Barang", "Jenis Hewan", "Nama", "Harga");
            System.out.println("--------------------------------------------------------------------------------------------");
    
            int counter = 1;
            for (Barang barang : daftarBarang) {
                String jenis = "";
                String jenisHewan = "";
                if (barang instanceof MakananHewan) {
                    jenis = "Makanan";
                    jenisHewan = ((MakananHewan) barang).getJenisHewan();
                } else if (barang instanceof Suplemen) {
                    jenis = "Suplemen";
                    jenisHewan = ((Suplemen) barang).getJenisHewan();
                } else {
                    jenis = "Barang Umum";
                    jenisHewan = "Umum";
                }
    
                System.out.printf("| %-2d | %-17s | %-20s | %-20s | %-17.2f |%n", counter++, jenis, jenisHewan, barang.getNama(), barang.getHarga());
                System.out.println("--------------------------------------------------------------------------------------------");
            }
        }
        scanner.nextLine();
    }
    
    private static void UpdateBarang() {
        clearScreen();
        if (daftarBarang.isEmpty()) {
            System.out.println("MAAF, BARANG BELUM TERSEDIA");
            scanner.nextLine();
            return;
        }
        tampilkanBarang();
        double harga;
        int nomorToUpdate;
    
        while (true) {
            System.out.print("Update Barang Nomor   : ");
            String input = scanner.nextLine();
            try {
                nomorToUpdate = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("MASUKKAN NOMOR YANG VALID");
                continue;
            }
            if (nomorToUpdate < 1 || nomorToUpdate > daftarBarang.size()) {
                System.out.println("NOMOR BARANG TIDAK TERSEDIA");
                continue;
            } else {
                break;
            }
        }
        Barang barangToUpdate = daftarBarang.get(nomorToUpdate - 1);
        
        String namaBarang = "";
        if (barangToUpdate instanceof MakananHewan) {
            namaBarang = "Nama Makanan Terbaru  : ";
        } else if (barangToUpdate instanceof Suplemen) {
            namaBarang = "Nama Suplemen Terbaru : ";
        } else {
            namaBarang = "Nama Barang Terbaru   : ";
        }
    
        System.out.print(namaBarang);
        String namaBaru = scanner.nextLine();
        barangToUpdate.setNama(namaBaru);
    
        while (true) {
            System.out.print("Harga Terbaru         : ");
            if (scanner.hasNextDouble()) {
                harga = scanner.nextDouble();
                scanner.nextLine();
                if (harga >= 10000) {
                    barangToUpdate.setHarga(harga);
                    break;
                } else {
                    System.out.println("HARGA MINIMAL 10000");
                }
            } else {
                System.out.println("HARGA HARUS BERUPA ANGKA");
                scanner.nextLine();
            }
        }
    
        if (barangToUpdate instanceof MakananHewan || barangToUpdate instanceof Suplemen) {
            System.out.print("Jenis Hewan Terbaru   : ");
            String jenisHewan = scanner.nextLine();
            if (barangToUpdate instanceof MakananHewan) {
                ((MakananHewan) barangToUpdate).setJenisHewan(jenisHewan);
            } else {
                ((Suplemen) barangToUpdate).setJenisHewan(jenisHewan);
            }
        }
        System.out.println("----------------------------");
        System.out.println("BARANG BERHASIL DIUPDATE");
        scanner.nextLine();
    }
    
    private static void deleteBarang() {
        clearScreen();
        if (daftarBarang.isEmpty()) {
            System.out.println("MAAF, BARANG BELUM TERSEDIA");
            scanner.nextLine();
            return;
        }
        tampilkanBarang();
        int nomorToDelete;
        while (true) {
            System.out.print("Hapus Barang Nomor : ");
            String input = scanner.nextLine();
            try {
                nomorToDelete = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("MASUKKAN NOMOR YANG VALID");
                continue;
            }
    
            if (nomorToDelete < 1 || nomorToDelete > daftarBarang.size()) {
                System.out.println("NOMOR BARANG TIDAK TERSEDIA");
                continue;
            } else {
                break;
            }
        } 
        Barang barangToDelete = daftarBarang.remove(nomorToDelete - 1);
        System.out.println("[" + barangToDelete.getNama() + "]" + " Berhasil Dihapus");
        scanner.nextLine();
    }
}
