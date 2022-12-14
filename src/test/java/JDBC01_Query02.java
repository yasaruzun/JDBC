import java.sql.*;

public class JDBC01_Query02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1487");
        Statement st =con.createStatement();




        /*=======================================================================
         ORNEK2: Ankara'da yasayan calisanlarin isim ve maaslarini  maas ters
          sirali olarak listeleyiniz.
        ========================================================================*/


        ResultSet veri =st.executeQuery("select isim,maas from calisanlar where sehir='Ankara' order by maas desc");

        while(veri.next()){

            System.out.println(veri.getString("isim")+" "+veri.getString("maas"));
        }

        con.close();
        st.close();
        veri.close();


    }
}
