import java.util.Scanner;

class Kendaraan {
    String platNomor;
    String jenisKendaraan;

    public Kendaraan(String platNomor, String jenisKendaraan) {
        this.platNomor = platNomor;
        this.jenisKendaraan = jenisKendaraan;
    }
}

class Node {
    Kendaraan data;
    Node next;

    public Node(Kendaraan data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public void tambahKendaraan(Kendaraan kendaraan) {
        Node newNode = new Node(kendaraan);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        System.out.println("Kendaraan dengan plat nomor " + kendaraan.platNomor + " " + "berjenis" + " " + kendaraan.jenisKendaraan + " memasuki area parkir.");
    }

    public void hapusKendaraan(String platNomor) {
        if (head == null) {
            System.out.println("Daftar parkir kosong.");
            return;
        }
        if (head.data.platNomor.equals(platNomor)) {
            head = head.next;
            System.out.println("Kendaraan dengan plat nomor " + platNomor  + " telah meninggalkan area parkir.");
            return;
        }
        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            if (curr.data.platNomor.equals(platNomor)) {
                prev.next = curr.next;
                System.out.println("Kendaraan dengan plat nomor " + platNomor + " telah meninggalkan area parkir.");
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        System.out.println("Kendaraan dengan plat nomor " + platNomor + " tidak ditemukan dalam daftar parkir.");
    }

    public void tampilkanDaftarParkir() {
        if (head == null) {
            System.out.println("Daftar parkir kosong.");
            return;
        }
        System.out.println("Daftar Parkir:");
        Node curr = head;
        int i = 1;
        while (curr != null) {
            System.out.println(i + ". Plat Nomor: " + curr.data.platNomor + ", Jenis Kendaraan: " + curr.data.jenisKendaraan);
            curr = curr.next;
            i++;
        }
    }
}

public class Parkir {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList daftarParkir = new LinkedList();

        int pilihan = 0;
        while (pilihan != 4) {
            System.out.println("============================================");
            System.out.println("             STASIUN KERETA API             ");
            System.out.println("                 BANYUWANGI                 ");
            System.out.println("--------------------------------------------");
            System.out.println("Petugas : Dewi                              ");
            System.out.println("============================================");
            System.out.println("Pengaturan :");
            System.out.println("1. Masuk");
            System.out.println("2. Keluar");
            System.out.println("3. Daftar Parkir");
            System.out.println("4. EXIT");
            System.out.print("Pilihan Anda: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Masukkan plat nomor kendaraan: ");
                    String platNomor = scanner.nextLine();
                    System.out.print("Jenis kendaraan: ");
                    String jenisKendaraan = scanner.nextLine();
                    Kendaraan kendaraan = new Kendaraan(platNomor, jenisKendaraan);
                    daftarParkir.tambahKendaraan(kendaraan);
                    System.out.println();
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Masukkan plat nomor: ");
                    platNomor = scanner.nextLine();
                    daftarParkir.hapusKendaraan(platNomor);
                    System.out.println();
                    break;
                case 3:
                    daftarParkir.tampilkanDaftarParkir();
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Selesai");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    System.out.println();
                    break;
            }
        }
    }
}