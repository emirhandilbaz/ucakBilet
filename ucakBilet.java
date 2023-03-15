/* 
Java ile mesafeye ve şartlara göre uçak bileti fiyatı hesaplayan programı yapın. 
Kullanıcıdan Mesafe (KM), yaşı ve yolculuk tipi (Tek Yön, Gidiş-Dönüş) bilgilerini alın. 
Mesafe başına ücret 0,10 TL / km olarak alın. 
İlk olarak uçuşun toplam fiyatını hesaplayın ve sonrasında ki koşullara göre müşteriye aşağıdaki indirimleri uygulayın ;

Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı, yolculuk tipi ise 1 veya 2) olmalıdır. 
Aksi takdirde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.
Kişi 12 yaşından küçükse bilet fiyatı üzerinden %50 indirim uygulanır.
Kişi 12-24 yaşları arasında ise bilet fiyatı üzerinden %10 indirim uygulanır.
Kişi 65 yaşından büyük ise bilet fiyatı üzerinden %30 indirim uygulanır.
Kişi "Yolculuk Tipini" gidiş dönüş seçmiş ise bilet fiyatı üzerinden %20 indirim uygulanır.
*/

package Java.ikinciKonu_kosulluDurumlar.egzersizler;

import java.util.Scanner;

public class ucakBilet {
    public static void main(String[] args){
        int yas, km, tip;
        double kmUcret = 0.10, tutar, yasIndirim, yonIndirim;

        Scanner scan = new Scanner(System.in);

        System.out.print("Lütfen gideceğiniz kilometre mesafesini giriniz: ");
        km = scan.nextInt();

        System.out.print("Lütfen yaş bilginizi giriniz: ");
        yas = scan.nextInt();

        System.out.print("Lütfen bilet türünüzü giriniz: \nGidiş - Dönüş ise 1'i, sadece gidiş ise 2'ye basınız: ");
        tip = scan.nextInt();

        tutar = km * kmUcret;

        
        if (km > 0 &&  yas > 0) {
            if (yas < 12){
                yasIndirim = tutar * 0.50;
                tutar -= yasIndirim;
            }

            else if (yas > 12 && yas < 24){
                yasIndirim = tutar * 0.10;
                tutar -= yasIndirim;
            }

            else if (yas >= 65){
                yasIndirim = tutar * 0.30;
                tutar -= yasIndirim;
            }
        
            switch (tip) {
                case 1:
                    System.out.println("Toplam tutar:" + tutar + "TL'dir.");
                    break;
                case 2:
                    yonIndirim = tutar*0.2;
                    tutar = (tutar-yonIndirim) * 2;
                    System.out.println("Toplam tutar:" + tutar + "TL'dir.");
                    break;
                default:
                    System.out.println("Verileri yanlış girdiniz.");
                    break;
            }
        }    

        else {
            System.out.print("Verileri hatalı girdiniz..");
        }
                
    }
        
}