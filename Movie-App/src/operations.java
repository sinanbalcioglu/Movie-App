import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tayfun Kuşçu
 */

public class operations {

    
    private static Connection con = null;
    
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    
    public operations(){
        //Veritabanına Bağlantı
        String url = "jdbc:sqlite:netflix.db";
        try {
            con= DriverManager.getConnection(url);
            System.out.println("Baglanti basarili");
        } catch (SQLException ex) {
            Logger.getLogger(operations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Program> programlariListele(){
        //izleme ve arama sayfası için veirtabanındaki programları getirir
        ArrayList<Program> output = new ArrayList<Program>();
        
        try {
            statement = con.createStatement();
            String sorgu = "select * from program";
            
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                String isim = rs.getString("progAdi");
                String tip = rs.getString("tip");
                String kategori = rs.getString("kategori");
                int bolumSay = rs.getInt("bolumSayisi");
                int uzunluk = rs.getInt("uzunluk");
                
                output.add(new Program(isim, tip, kategori, bolumSay, uzunluk));
                
            }
            return output;
            
        } catch (SQLException ex) {
            Logger.getLogger(operations.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public ArrayList<OnerilenProgram> onerileriListele(Set<String> kategoriler){
        //öneri sayfası için veirtabanındaki programları getirir
        ArrayList<OnerilenProgram> output = new ArrayList<OnerilenProgram>();
        
        try {
            statement = con.createStatement();
            String sorgu = "select * from programOner";
            
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                String isim = rs.getString("progAdi");
                String kategori = rs.getString("kategori");
                int puan = rs.getInt("puan");
                for(String tur:kategoriler){
                    if(kategori.contains(tur))
                        output.add(new OnerilenProgram(isim,kategori,puan));
                    else
                        continue;
                }
            }
            return output;
            
        } catch (SQLException ex) {
            Logger.getLogger(operations.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    public boolean login(String email, String pw) {
        //giriş sorgusu yapılır
        String sorgu= "SELECT * FROM kullanici WHERE email=? and sifre=? ";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, pw);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            if(rs.next() == false){
                return false;
            }else{
                con.close();
                preparedStatement.close();
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Giris Yapilamadi!");
        }
        return false;
    }
    
    static boolean signUp(String name, String email, String pw, String birthDay) {
        //kayıt işlemleri yapılır
        String sorgu= "INSERT INTO kullanici (isim,email,sifre,dogumTarihi) VALUES(?,?,?,?)";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, pw);
            preparedStatement.setString(4, birthDay);
            
            preparedStatement.executeUpdate();
            con.close();
            preparedStatement.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Kayit olsturulamadi");
        }
        return false;
    }
    
    public int puanYaz(String email,String progAdi){
        //izlenen filmin puanını yazar, daha önce izlenmeyise 1 yazar
        int puan = 1;
        
        try {
            statement = con.createStatement();
            String sorgu="select DISTINCT puan from kullaniciProgram WHERE progAdi='"+progAdi+"' and email='"+email+"'";
            ResultSet rs = statement.executeQuery(sorgu);
            puan = rs.getInt("puan");
            
            return puan;
        } catch (SQLException ex) {
            //System.out.println("Hata: Puan Yaz");
        }
        
        return puan;
    } 
    
    public void puanGuncelle(String email,String progAdi,int puan){
        //girilen puanı günceller
            String sorgu= "update kullaniciProgram set puan = ? where progAdi = ? and email= ?";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, puan);
            preparedStatement.setString(2, progAdi);
            preparedStatement.setString(3, email);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Hata: Puan Güncelle");
        }
    }
    
    public void programIzle(String email,String progAdi,String tarih){
        //izle butonuna basıldıktan sonra tıklanmış olan veriyi izlenenler listesine ekler
        String sorgu= "INSERT INTO kullaniciProgram (email,progAdi,izlenmeTarihi) VALUES(?,?,?)";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, progAdi);
            preparedStatement.setString(3, tarih);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Kayit olsturulamadi");
        }     
    }
     
    static boolean programIzlendiMi(String email,String progAdi){
        //programın izlenme kontrolünü yapar
        String sorgu= "SELECT * FROM kullaniciProgram WHERE email=? and progAdi=? ";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, progAdi);
            
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
            
        } catch (SQLException ex) {
            System.out.println("Hata: programIzlendiMi");
        }
        return false;
    }
    
    static int getIzlenmeSuresi(String email,String progAdi){
        //seçili programın izlenme süresini getirir.
        String sorgu= "SELECT * FROM kullaniciProgram WHERE email=? and progAdi=? ";
        int izlenmeSuresi=1;
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, progAdi);
            
            ResultSet rs = preparedStatement.executeQuery();
            izlenmeSuresi = rs.getInt("izlenmeSuresi");
            return izlenmeSuresi;
            
        } catch (SQLException ex) {
            //System.out.println("Hata: getIzlenmeSuresi");
        }
        return izlenmeSuresi;
    }
    
    static int getBolumSayisi(String email,String progAdi){
        //seçili programın bölüm sayısını getirir.
        String sorgu= "SELECT * FROM kullaniciProgram WHERE email=? and progAdi=? ";
        int bolumSayisi=1;
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, progAdi);
            
            ResultSet rs = preparedStatement.executeQuery();
            bolumSayisi = rs.getInt("bolum");
            return bolumSayisi;
            
        } catch (SQLException ex) {
            //System.out.println("Hata: getBolumSayisi");
        }
        return bolumSayisi;
    }
    
    public void setIzlenmeSuresi(String email,String progAdi,int izlenmeSuresi,int bolumSayisi){
        //program izlendiği süre boyunca saniye başına izlenme süresini günceller
        String sorgu= "update kullaniciProgram set izlenmeSuresi=?,bolum=? where progAdi=? and email=?";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, izlenmeSuresi);
            preparedStatement.setInt(2, bolumSayisi);
            preparedStatement.setString(3, progAdi);
            preparedStatement.setString(4, email);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Hata: setIzlenmeSuresi");
        }
    }
    
    public void setIzlenmeTarihi(String email,String progAdi,String tarih){
        //program daha önceden izlenmiş ve tekrar izlenecekse izlenen tarihi günceller
        String sorgu = "update kullaniciProgram set izlenmeTarihi=? where email=? and progAdi=?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, tarih);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, progAdi);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(operations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean getTip(String progAdi){
        //program bittikten sonra bölüm sayısını artırma işleminin kontrolü için dizi olup olmadığını kontrol eder
        String sorgu="select * from program where progAdi=?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, progAdi);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            String filmCheck = rs.getString("tip");
            
            if(filmCheck.equals("Dizi"))
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(operations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void oneriListesineEkle(String progAdi,String kategori){
        //herhangi bir kullanıcı tarafından izlenen dizi oneri listesinde yoksa ekleme işlemi yapılır
        String sorgu = "insert into programOner (progAdi,kategori) values(?,?)";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, progAdi);
            preparedStatement.setString(2, kategori);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Hata: oneriListesineEkle");
        }
    }
    
    public boolean oneriListesiCheck(String progAdi){
        //izlenen programın öneri listesinde olup olmadığı kontrol edilir
        String sorgu = "select * from programOner where progAdi=?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, progAdi);
            ResultSet rs = preparedStatement.executeQuery();
            
            if(rs.next() == false){
                return false;
            }else{
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(operations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void oneriListesiGuncelle(String progAdi){
        //farklı kullanıcılar ortak programları izledikçe sisteme kaydettikleri puanlarının ortalamaları alınıp önerilen listesindeki puan güncellenir
        String sorgu = "select avg(puan) from kullaniciProgram where progAdi=?";
        String sorgu2 = "update programOner set puan=? where progAdi=?";
        int ortalama;
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, progAdi);
            ResultSet rs = preparedStatement.executeQuery();
            ortalama = (int) rs.getFloat("avg(puan)");
            
            preparedStatement = con.prepareStatement(sorgu2);
            
            preparedStatement.setInt(1, ortalama);
            preparedStatement.setString(2, progAdi);
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(operations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void main(String[] args){
        operations ops = new operations();
        
    }

            
}
