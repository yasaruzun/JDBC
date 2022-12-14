import java.sql.*;

public class JDBC01_Query01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1- ilgili Driver'i yuklemeliyiz- MySQL  kullandigimizi bildiriyoruz

        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2- baglantiyi olusturmak icin username ve password girisi yapmaliyiz

        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1487");

        // 3- SQL Query'leri icin bir statement objesi olusturup  java da kendimize SQL sorgulari icin bir alan acacagiz

        Statement st =con.createStatement();

        // 4- SQL sorgularini yazip calistirabiliriz

        ResultSet veri =st.executeQuery("select * from calisanlar");

        // 5- sonuclari gormek icin Iteration ile Set icersindeki elemanlari While dongusu icerisinde yazdiracagiz


        //CREATE TABLE calisanlar
        //	(
        //		id INT PRIMARY KEY,
        //		isim VARCHAR(50),
        //		sehir VARCHAR(50),
        //		maas INT,
        //		sirket VARCHAR(20)
        //	);
        while (veri.next()){
            System.out.println(veri.getInt("id")+" "+veri.getString("isim")+" "+
                    veri.getString("sehir")+" "+
                    veri.getInt("maas")+" "+veri.getString("sirket"));
        }

        //6- olusturulan nesneleri close ile kapatiyoruz ki bellekten kaldiralim

        con.close();
        st.close();
        veri.close();

    }
}
