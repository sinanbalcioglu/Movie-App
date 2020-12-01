import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Tayfun Kuşçu
 */

public class searchPage extends javax.swing.JDialog {
    operations ops = new operations();
    DefaultTableModel model;
    LocalDate date = LocalDate.now();
    private int izlenmeSuresi=1,bolumSayisi=1;
    private String email;
    
    private String progAdi;
    private boolean stop=false; // durdur butonunun kontrolü için kullanılır
    
    public searchPage(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        email=loginPage.getEmail(); //eğer loginPage ten giriş yapıldıysa ordaki maili kullanır
        initComponents();
        model = (DefaultTableModel) programTable.getModel();
        programList();
        
    }
    public searchPage(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        email=signupPage.getEmail(); //eğer signupPage ten giriş yapıldıysa ordaki maili kullanır
        initComponents();
        model = (DefaultTableModel) programTable.getModel();
        programList();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        programTable = new javax.swing.JTable();
        searchBar = new javax.swing.JTextField();
        watchButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        puanAlani = new javax.swing.JTextField();
        puanButton = new javax.swing.JButton();
        checkProgress = new javax.swing.JProgressBar(0,60);
        jLabel6 = new javax.swing.JLabel();
        progAdiAlani = new javax.swing.JLabel();
        bolumAlani = new javax.swing.JLabel();
        tarihAlani = new javax.swing.JLabel();
        puanLabel = new javax.swing.JLabel();
        alertText = new javax.swing.JLabel();
        sureAlani = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        stopButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 20, 20));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/netflix_logo.png"))); // NOI18N
        jLabel8.setText("jLabel8");
        jLabel8.setMaximumSize(new java.awt.Dimension(300, 93));
        jLabel8.setMinimumSize(new java.awt.Dimension(300, 93));
        jLabel8.setName(""); // NOI18N
        jLabel8.setPreferredSize(new java.awt.Dimension(300, 93));

        programTable.setBackground(new java.awt.Color(20, 20, 20));
        programTable.setForeground(new java.awt.Color(255, 255, 255));
        programTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "İsim", "Tip", "Kategori", "Bolum Sayisi", "Uzunluk"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        programTable.setSelectionBackground(new java.awt.Color(229, 9, 20));
        programTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        programTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                programTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(programTable);
        if (programTable.getColumnModel().getColumnCount() > 0) {
            programTable.getColumnModel().getColumn(0).setResizable(false);
            programTable.getColumnModel().getColumn(1).setResizable(false);
            programTable.getColumnModel().getColumn(3).setResizable(false);
            programTable.getColumnModel().getColumn(4).setResizable(false);
        }

        searchBar.setBackground(new java.awt.Color(20, 20, 20));
        searchBar.setForeground(new java.awt.Color(255, 255, 255));
        searchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarActionPerformed(evt);
            }
        });
        searchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchBarKeyReleased(evt);
            }
        });

        watchButton.setBackground(new java.awt.Color(255, 255, 255));
        watchButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        watchButton.setForeground(new java.awt.Color(229, 9, 20));
        watchButton.setText("İzle");
        watchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                watchButtonActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(229, 9, 20));
        jLabel1.setText("Film Adı veya Türüne Göre arama yapabilirsiniz");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(229, 9, 20));
        jLabel2.setText("Program Adı:");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(229, 9, 20));
        jLabel3.setText("Bölüm");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(229, 9, 20));
        jLabel4.setText("Tarih");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(229, 9, 20));
        jLabel5.setText("Puan");

        puanAlani.setBackground(new java.awt.Color(20, 20, 20));
        puanAlani.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        puanAlani.setForeground(new java.awt.Color(255, 255, 255));
        puanAlani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                puanAlaniActionPerformed(evt);
            }
        });

        puanButton.setBackground(new java.awt.Color(255, 255, 255));
        puanButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        puanButton.setForeground(new java.awt.Color(229, 9, 20));
        puanButton.setText("Puan Ver");
        puanButton.setDefaultCapable(false);
        puanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                puanButtonActionPerformed(evt);
            }
        });

        checkProgress.setBackground(new java.awt.Color(229, 9, 20));
        checkProgress.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        checkProgress.setForeground(new java.awt.Color(229, 9, 20));
        checkProgress.setStringPainted(true);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(229, 9, 20));
        jLabel6.setText("İzlenen Süre");

        progAdiAlani.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        progAdiAlani.setForeground(new java.awt.Color(255, 255, 255));

        bolumAlani.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        bolumAlani.setForeground(new java.awt.Color(255, 255, 255));

        tarihAlani.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tarihAlani.setForeground(new java.awt.Color(255, 255, 255));

        puanLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        puanLabel.setForeground(new java.awt.Color(255, 255, 255));

        alertText.setForeground(new java.awt.Color(255, 255, 255));

        sureAlani.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        sureAlani.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("sn");

        stopButton.setBackground(new java.awt.Color(255, 255, 255));
        stopButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        stopButton.setForeground(new java.awt.Color(229, 9, 20));
        stopButton.setText("Durdur");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alertText, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(puanAlani, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(puanButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(sureAlani, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(stopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(checkProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(searchBar)
                            .addGap(18, 18, 18)
                            .addComponent(watchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1004, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(puanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(progAdiAlani, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tarihAlani, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(bolumAlani, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(248, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(progAdiAlani, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bolumAlani, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(tarihAlani, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(puanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stopButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(sureAlani, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(puanAlani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(puanButton))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alertText, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(watchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(400, 200, 1077, 731);
    }// </editor-fold>//GEN-END:initComponents

    private void searchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBarActionPerformed

    private void watchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_watchButtonActionPerformed
        //TODO add your handling code here:
        //int izlenenSure;
        Timer timer = new Timer(1000, null);
        int selectedRow = programTable.getSelectedRow();
        int modelRow = programTable.convertRowIndexToModel(selectedRow);
        
        progAdi= programTable.getModel().getValueAt(modelRow, 0).toString();
        String kategori = programTable.getModel().getValueAt(modelRow, 2).toString();
        String tarih= date.toString();
        System.out.println(tarih);
        
        boolean izlenmeCheck = ops.programIzlendiMi(email,progAdi);
        
        //eğer daha önce izlendiyse sadece izlenme tarihini günceller, izlenmediyse kullaniciProgram da izlenme kaydını tutar.
        if(izlenmeCheck){
            System.out.println("Program İzlendi");
            ops.setIzlenmeTarihi(email,progAdi, tarih);
        }else{
            ops.programIzle(email,progAdi,tarih);
        }
        //eğer bu program daha önce herhangi bir kullanıcı tarafından izlendiyse öneri listesinde olacaktır, aşağıdaki sorgu bu kontrolü yapar eğer listede yoksa programı öneri listesine ekler.
        if(ops.oneriListesiCheck(progAdi) != true)  
                ops.oneriListesineEkle(progAdi, kategori);
        
        izlenmeSuresi = ops.getIzlenmeSuresi(email,progAdi);    
        bolumSayisi = ops.getBolumSayisi(email,progAdi);
        
        timer.addActionListener(new ActionListener() {
            // progress bar ve izlenme süresi işlemleri burada yapılmaktadır.
            @Override
            public void actionPerformed(ActionEvent e) {
                izlenmeSuresi++;
                sureAlani.setText(Integer.toString(izlenmeSuresi));
                
                ops.setIzlenmeSuresi(email,progAdi,izlenmeSuresi,bolumSayisi);  //kullanıcı aniden kapatma ihtimaline karşı her saniye ilerlediğinde izlenme süresi kaydedilir.
                checkProgress.setValue(izlenmeSuresi); //izlenme süresi progress bara yansıtılır
                if(stop){ //durdur butonuna basıldığı takdirde stop değer true olmaktadır
                    timer.stop();
                    stop=false; 
                }
                //programların uzunlugu 60sn olarak tutulmuştur, 60sn sonunda program bittikten sonra yapılacak işlemler aşağıdadır.
                if(checkProgress.getValue() == 60){ 
                    timer.stop();
                    //eğer izlenene program dizi ise bölüm sayısı artırılır, film ise işlem yapılmaz
                    if(ops.getTip(progAdi))
                        bolumSayisi++;
                    
                    ops.setIzlenmeSuresi(email,progAdi,1,bolumSayisi); //program bittiği için izlenme süresi başa sarılır
                    checkProgress.setValue(0); //progress bar sıfırlanır
                    sureAlani.setText("0");
                    bolumAlani.setText(Integer.toString(bolumSayisi)); //sol üstteki bölüm sayısı güncellenir
                    JOptionPane.showMessageDialog(searchPage.this, "Bölüm Bitti."); //kullanıcıya bildirim penceresi açar
                }
            }
        });
        timer.start();
        
    }//GEN-LAST:event_watchButtonActionPerformed
    public void dynamicSearch(String search){
        //kullanıcının arama alanına yazarken anında dinamik arama yapılan fonksiyon
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        
        programTable.setRowSorter(tr);
        
        tr.setRowFilter(RowFilter.regexFilter(search));
    }
    private void searchBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBarKeyReleased

        //kullanıcı arama alanına yazdığı metni anlık olarak dinamik aramaa kısmına gönderir.
        String search = searchBar.getText();
        
        dynamicSearch(search);
    }//GEN-LAST:event_searchBarKeyReleased

    private void programTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_programTableMouseClicked
        // TODO add your handling code here:
        //tablodaki tıklanan programın bilgilerini üst kısımdaki Program adı,bölüm gibi ilgili kısımlara aktarır
        int selectedRow = programTable.getSelectedRow();
        int modelRow = programTable.convertRowIndexToModel(selectedRow);
        
        progAdi = programTable.getModel().getValueAt(modelRow, 0).toString();
        
        progAdiAlani.setText(programTable.getModel().getValueAt(modelRow, 0).toString());
        bolumAlani.setText(Integer.toString(ops.getBolumSayisi(email,progAdi)));
        tarihAlani.setText(date.toString());
        puanLabel.setText(Integer.toString(ops.puanYaz(email,progAdi)));
        
        izlenmeSuresi = ops.getIzlenmeSuresi(email,progAdi); 
        checkProgress.setValue(izlenmeSuresi);
        sureAlani.setText(Integer.toString(izlenmeSuresi));
    }//GEN-LAST:event_programTableMouseClicked

    private void puanAlaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_puanAlaniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_puanAlaniActionPerformed

    private void puanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_puanButtonActionPerformed
        // TODO add your handling code here:
        //puan verme işleminin yapıldığı kısım
        alertText.setText("");
        int puan = Integer.parseInt(puanAlani.getText());
        if(puan>0 && puan <= 10){ //kullanıcının girdiği değer 1-10 arasında ise işlemlere başlar
            int selectedRow = programTable.getSelectedRow();
            int modelRow = programTable.convertRowIndexToModel(selectedRow);
            progAdi = programTable.getModel().getValueAt(modelRow, 0).toString();
        
            boolean izlenmeCheck = ops.programIzlendiMi(email,progAdi);
        
                if(izlenmeCheck){ //puan vermeden önce izlenmeye başlandıysa puan verilebilir
                    ops.puanGuncelle(email,progAdi,puan);
                    ops.oneriListesiGuncelle(progAdi);
                    alertText.setText("Puanınız kaydedildi");
                    puanLabel.setText(Integer.toString(puan));
                }
                else{ //daha önce izlenmediyse kullanıcıya uyarı mesajı gönderilir
                    alertText.setText("Puan vermeden önce izlemeniz gerekmektedir.");
                }
        }else{ //girilen değer 1-10 arasında değilse uyarı mesajı gönderilir
            alertText.setText("Hata:1-10 arasında puan veriniz.");
        }
    }//GEN-LAST:event_puanButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        // TODO add your handling code here:
        //durdur butonu kontrolü burada yapılır
        stop=true;
    }//GEN-LAST:event_stopButtonActionPerformed


    public void programList(){
        //veri tabanında program tablosundan alınan veriler tabloya eklenir
        model.setRowCount(0);
        
        ArrayList<Program> programlar = new ArrayList<Program>();
        
        programlar = ops.programlariListele();
        
        if(programlar != null){
            for(Program program: programlar){
                Object[] eklenecek = {program.getIsim(),program.getTip(),program.getKategori(),program.getBolumSay(),program.getUzunluk()};
                
                model.addRow(eklenecek);
            }
        }
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(searchPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(searchPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(searchPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(searchPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                searchPage dialog = new searchPage(new javax.swing.JFrame(), true);
                searchPage dialogJ = new searchPage(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alertText;
    private javax.swing.JLabel bolumAlani;
    private javax.swing.JProgressBar checkProgress;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel progAdiAlani;
    private javax.swing.JTable programTable;
    private javax.swing.JTextField puanAlani;
    private javax.swing.JButton puanButton;
    private javax.swing.JLabel puanLabel;
    private javax.swing.JTextField searchBar;
    private javax.swing.JButton stopButton;
    private javax.swing.JLabel sureAlani;
    private javax.swing.JLabel tarihAlani;
    private javax.swing.JButton watchButton;
    // End of variables declaration//GEN-END:variables
}
