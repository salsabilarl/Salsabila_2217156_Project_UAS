/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ojolrush;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author salsa
 */

public abstract class OjolRush implements InterfaceDriver {
    protected Scanner input = new Scanner(System.in);
    protected Scanner enter = new Scanner(System.in);
    
    protected int ratingDriver, uangDriver, pilih;
    protected String namaDriver, motorDriver;
    protected ArrayList<String> inventory = new ArrayList<>();

    public static void main(String[]args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Selamat Datang Driver OjolRush!\n");
        try{
            Driver driver = new Driver();
            driver.detail();
            driver.mulai();
        }finally{
            input.close();
        }
        
    }
    
    //polymorphism
    @Override
    public void setDriver(){
        System.out.println("Untuk mulai bekerja, masukan nama driver : ");
        namaDriver = input.nextLine();
        System.out.println("\nHalo " + namaDriver + ", berikut ini detail profil anda.\n");
        System.out.println("Kendaraan: " + motorDriver);
        System.out.println("Rating: " + ratingDriver +" bintang");
        System.out.println("Saldo: " + uangDriver +" rupiah");
    }
    
    @Override
    public void cekStatus(){
        System.out.println("\nKendaraan: " + motorDriver);
        System.out.println("Rating: " + ratingDriver +" bintang");
        System.out.println("Saldo: " + uangDriver);
        System.out.println("Tekan enter untuk kembali");
        enter.nextLine();
    }
    
    @Override
    public void mulaiDriver() {
        System.out.println("\n- Driver OjolRush hanya bisa pulang setelah target uang, rating, dan reward tercapai.");
        System.out.println("- Ambil order untuk menambah uang, rating, dan reward.");
        System.out.println("- Jenis motor dan tipe order akan mempengaruhi jumlah uang, rating, dan reward.");
        System.out.println("- Men-cancel order akan mengurangi rating.");
        System.out.println("\nMulai Kerja");
	System.out.println("1 Pulang");
	System.out.println("2 Kerja");
        System.out.println("3 Cek Status");
        System.out.println("Masukan pilihan anda: ");
	pilih = input.nextInt();

        switch (pilih) {
            case 1:
                if(uangDriver >= 10 || ratingDriver >= 4){
                    selesai();
                }else if(uangDriver < 10) {
                    System.out.println("\nTarget uang belum tercapai. Driver belum bisa pulang.\nTekan enter untuk kembali.");
                    enter.nextLine();
                    mulaiDriver();
                }else if(ratingDriver < 4) {
                    System.out.println("\nTarget rating belum tercapai. Driver belum bisa pulang.\nTekan enter untuk kembali.");
                    enter.nextLine();
                    mulaiDriver();
                }
                break;
            case 2:
                kerjaDriver();
                break;
            case 3:
                cekStatus();
            default:
                mulaiDriver();
                break;
        }
    }
    
    @Override
    public void kerjaDriver() {
            System.out.println("\nSelamat bekerja, Driver OjolRush!");
            System.out.println("1 Ambil Orderan");
            System.out.println("2 Upgrade Motor");
            System.out.println("3 Back");
            System.out.println("Masukan pilihan anda: ");
            pilih = input.nextInt();

        switch (pilih) {
            case 1:
                ambilOrderan();
                break;
            case 2:
                upgradeMotor();
                break;
            case 3:
                mulaiDriver();
                break;
            default:
                kerjaDriver();
                break;
        }
    }
    
    @Override
    public void upgradeMotor() {
        if ("Supra X".equals(motorDriver)){
            System.out.println("\nSelamat datang di OjolRush Store!");
            System.out.println("Motor anda telah diupgrade.");
            motorDriver = "Triumph";
            System.out.println("Kendaraan: " + motorDriver);
            System.out.println("Tekan enter untuk kembali bekerja");
            enter.nextLine();
            kerjaDriver();
        }else{
           System.out.println("\nMotor anda tidak bisa diupgrade lagi.\nTekan enter untuk kembali bekerja");
           enter.nextLine();
           kerjaDriver(); 
        }     
    }
    
    @Override
    public void ambilOrderan() {
            System.out.println("\n--- NEW ORDER---");
            System.out.println("1 Ambil");
            System.out.println("2 Cancel");
            System.out.println("Masukan pilihan anda: ");
            pilih = input.nextInt();

        switch (pilih) {
            case 1:
                order();
                break;
            case 2:
                ratingDriver = ratingDriver -1;
                if (ratingDriver<=0){
                    gameOver();
                }else{
                    kerjaDriver();
                }
                break;
            default:
                ambilOrderan();
                break;
        }
    }
    
    @Override
    public void order() {
            System.out.println("\n1 Process Order Rush Hour");
            System.out.println("2 Process Order Mode Hemat");
            System.out.println("3 Cancel Order");
            System.out.println("Masukan pilihan anda: ");
            pilih = input.nextInt();

        switch (pilih) {
            case 1:
                //System.out.println("\n Triumph: Rating +1, Uang +4");
                //System.out.println("\n Supra X: Rating +1, Uang +3");
                if (motorDriver == "Triumph"){
                    ratingDriver = ratingDriver +1;
                    inventory.add("Emas");
                    uangDriver = uangDriver +4;
                    cek();
                }else{
                   ratingDriver = ratingDriver +1;
                   inventory.add("Silver");
                   uangDriver = uangDriver +3;
                   cek();
                }
                break;
            case 2:
                //System.out.println("\n Triumph: Rating +1, Uang +2");
                //System.out.println("\n Supra X: Rating +1, Uang +1");
                if (motorDriver == "Triumph"){
                    ratingDriver = ratingDriver +1;
                    inventory.add("Tembaga");
                    uangDriver = uangDriver +2;
                    cek();
                }else{
                    ratingDriver = ratingDriver +1;
                    inventory.add("Kayu");
                    uangDriver = uangDriver +1;
                    cek();
                }
                break;
            case 3:
                ratingDriver = ratingDriver -1;
                if (ratingDriver<=0){
                    gameOver();
                }else{
                    kerjaDriver();
                }
            default:
                order();
                break;
        }
    }
    
 
    @Override
    public void cek(){
        if (uangDriver >=10 || ratingDriver >=4 ){
            selesai();
        }else{
            System.out.println("Order completed!");
            System.out.println("Driver memperoleh reward: " + inventory);
            System.out.println("Total Saldo Uang: " + uangDriver);
            System.out.println("Tekan enter untuk kembali bekerja.");
            enter.nextLine();
            kerjaDriver();
        }
    }
    
    @Override
    public void selesai() {
            System.out.println("\nSELAMAT!!!!");
            System.out.println("Target uang, rating, dan reward anda sudah terpenuhi");
            if (inventory == null) {
                    System.out.println("\nMohon cek lagi");
                    mulaiDriver();
                    }else{
                            System.out.println("\nKendaraan: " + motorDriver);
                            System.out.println("Rating: " + ratingDriver +" bintang");
                            System.out.println("Saldo: " + uangDriver);
                            System.out.println("\nSelamat anda boleh pulang!");
                            System.out.println("---END---");
          }
    }
	
    @Override
    public void gameOver() {
        System.out.println("\nDriver dengan rating 0 dipecat.");
        System.out.println("--- GAME OVER ---");
        System.exit(0);
    }
 }

interface InterfaceDriver {
	void setDriver();
    	void mulaiDriver();
	void cekStatus();
	void kerjaDriver();
    	void upgradeMotor();
    	void ambilOrderan();
    	void order();
   	void cek();
    	void selesai();
    	void gameOver();
}
