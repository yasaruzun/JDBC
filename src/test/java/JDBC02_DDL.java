import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC02_DDL {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

/*
A) CREATE TABLE, DROP TABLE, ALTER TABLE gibi DDL ifadeleri icin sonuc kümesi (ResultSet)
      dondurmeyen metotlar kullanilmalidir. Bunun icin JDBC'de 2 alternatif bulunmaktadir.
       1) execute() metodu
       2) executeUpdate() metodu.

   B) - execute() metodu her tur SQL ifadesiyle kullanibilen genel bir komuttur.
      - execute(), Boolean bir deger dondurur. DDL islemlerinde false dondururken,
        DML islemlerinde true deger dondurur.
      - Ozellikle, hangi tip SQL ifadesinin kullanilmasinin gerektiginin belli olmadigi
        durumlarda tercih edilmektedir.

   C) - executeUpdate() metodu ise INSERT, Update gibi DML islemlerinde yaygin kullanilir.
      - bu islemlerde islemden etkilenen satir sayisini dondurur.
      - Ayrıca, DDL islemlerinde de kullanilabilir ve bu islemlerde 0 dondurur.
 */

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1487");
        Statement st =con.createStatement();

/*======================================================================
          ORNEK1:isciler tablosunu siliniz
    ========================================================================*/

       // String dropTable="drop table isciler";

       // st.execute(dropTable);

/*=======================================================================
	  ORNEK2:isciler adinda bir tablo olusturunuz id int,
	  birim VARCHAR(10), maas int
	========================================================================*/

      //String createTable="create table isciler (id int,birim varchar(10),maas int) ";

        //st.execute(createTable);



       // String insertTable="insert into isciler values(80, 'ARGE', 4000) ";
        //st.executeUpdate(insertTable);


        /*=======================================================================
          ORNEK4: isciler tablosuna birden fazla yeni kayıt ekleyelim.

            INSERT INTO isciler VALUES(70, 'HR', 5000)
            INSERT INTO isciler VALUES(60, 'LAB', 3000)
            INSERT INTO isciler VALUES(50, 'ARGE', 4000)
         ========================================================================*/

     //  String [] sorgular = {"INSERT INTO isciler VALUES(70, 'HR', 5000)",
     //                          "INSERT INTO isciler VALUES(60, 'LAB', 3000)",
     //                          "INSERT INTO isciler VALUES(50, 'ARGE', 4000)"};

     //  int count = 0;

     //  for (String each : sorgular) {
     //      count+= st.executeUpdate(each);
     //  }
     //  System.out.println(count + " satir eklendi!");


      //System.out.println("=============== 2. Yontem ==============");

      //// 2.YONTEM (addBatch ve executeBatch() metotlari ile)
      //// ----------------------------------------------------
      //// addBatch metodu ile SQL ifadeleri gruplandirilabilir ve executeBatch()
      //// metodu ile veritabanina bir kere gonderilebilir.
      //// executeBatch() metodu bir int [] dizi dondurur. Bu dizi her bir ifade sonucunda
      //// etkilenen satir sayisini gosterir.

      //String [] sorgular2 = {"INSERT INTO isciler VALUES(40, 'HR', 6000)",
      //        "INSERT INTO isciler VALUES(30, 'LAB', 2000)",
      //        "INSERT INTO isciler VALUES(20, 'ARGE', 5000)"};

      //for (String each : sorgular2) {
      //    st.addBatch(each);
      //}

      //st.executeBatch();

      //System.out.println("Satirlar eklendi");

        /*=======================================================================
		  ORNEK5: isciler tablosundaki maasi 5000'den az olan iscilerin maasina
		   %10 zam yapiniz
		========================================================================*/

        String update="update isciler set maas=maas*1.1 where maas<5000";

       int satir= st.executeUpdate(update);

        System.out.println(satir +" satir güncellendi");

        con.close();
        st.close();



    }
}
