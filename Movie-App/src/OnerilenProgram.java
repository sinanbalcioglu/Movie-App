public class OnerilenProgram {
    
    private String isim;
    private String kategori;
    private int puan;

    public OnerilenProgram(String isim, String kategori, int puan) {
        this.isim = isim;
        this.kategori = kategori;
        this.puan = puan;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }
    
    
}
