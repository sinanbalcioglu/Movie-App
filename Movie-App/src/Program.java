
public class Program {
    
    private String isim;
    private String tip;
    private String kategori;
    private int bolumSay;
    private int uzunluk;

    public Program(String isim, String tip, String kategori, int bolumSay, int uzunluk) {
        this.isim = isim;
        this.tip = tip;
        this.kategori = kategori;
        this.bolumSay = bolumSay;
        this.uzunluk = uzunluk;
    }

    public int getBolumSay() {
        return bolumSay;
    }

    public void setBolumSay(int bolumSay) {
        this.bolumSay = bolumSay;
    }

    public int getUzunluk() {
        return uzunluk;
    }

    public void setUzunluk(int uzunluk) {
        this.uzunluk = uzunluk;
    }


    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
    
    
}
