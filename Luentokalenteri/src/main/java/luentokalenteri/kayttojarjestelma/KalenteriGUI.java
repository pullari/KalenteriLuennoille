/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luentokalenteri.kayttojarjestelma;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import luentokalenteri.domain.lista.Merkinta;
import luentokalenteri.domain.lista.Merkintalista;
import luentokalenteri.sovelluslogiikka.Sovelluslogiikka;

/**
 *
 * @author Pullis
 */
public class KalenteriGUI extends javax.swing.JFrame implements Runnable{

    /**
     * Creates new form KalenteriForm
     */
    Sovelluslogiikka logiikka;
    
    public KalenteriGUI() {
        initComponents();
        logiikka = new Sovelluslogiikka("src/main/java/luentokalenteri/domain/lista/testausta.txt");
        logiikka.puraTiedosto();
        lisataanTallennusKunRaksiaPainetaan();
        paivitaArea();
    }
    
    @Override
    public void run() {
        
        jTable1.getColumnModel().getColumn(1).setCellRenderer(new omaRenderoija());
        jTable1.getColumnModel().getColumn(2).setCellRenderer(new omaRenderoija());
        jTable1.getColumnModel().getColumn(3).setCellRenderer(new omaRenderoija());
        jTable1.getColumnModel().getColumn(4).setCellRenderer(new omaRenderoija());
        jTable1.getColumnModel().getColumn(5).setCellRenderer(new omaRenderoija());
        this.pack();
        this.setVisible(true);
    }
    
    public void lisataanTallennusKunRaksiaPainetaan(){
        
        java.awt.event.WindowAdapter ohitettuDefaultClose = new java.awt.event.WindowAdapter(){ 
            
            @Override  
            public void windowClosing(java.awt.event.WindowEvent evt){
                logiikka.tallennaTila();
                System.exit(0);
            }
        };
        this.addWindowListener(ohitettuDefaultClose);
    }
    
    private void paivitaArea(){
        jTextArea1.setText(logiikka.tulosta());
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        model.fireTableDataChanged();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kalenteri");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"08:00", null, null, null, null, null},
                {"09:00", null, null, null, null, null},
                {"10:00", null, null, null, null, null},
                {"11:00", null, null, null, null, null},
                {"12:00", null, null, null, null, null},
                {"13:00", null, null, null, null, null},
                {"14:00", null, null, null, null, null},
                {"15:00", null, null, null, null, null},
                {"16:00", null, null, null, null, null},
                {"17:00", null, null, null, null, null},
                {"18:00", null, null, null, null, null},
                {"19:00", null, null, null, null, null},
                {"20:00", null, null, null, null, null}
            },
            new String [] {
                "klo", "Maanantai", "Tiistai", "Keskiviikko", "Torstai", "Perjantai"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jMenu1.setText("File");

        jMenuItem1.setText("Tallenna");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem2.setText("Lisää");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Poista");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Tyhjennä");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        
        String paiva = JOptionPane.showInputDialog("Anna paiva (ma, ti, ke, to, pe)");
        String nimi = JOptionPane.showInputDialog("Anna nimi (ei puolipisteitä)");
        
        if(logiikka.suoritaKomento(2, paiva, nimi)){
            paivitaArea();
            
        }else{
            JOptionPane.showMessageDialog(null, "Virhe", "Poisto epäonnistui", JOptionPane.ERROR_MESSAGE);
            
        }
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        
        String paiva = JOptionPane.showInputDialog("Anna paiva (ma, ti, ke, to, pe)");
        String nimi = JOptionPane.showInputDialog("Anna nimi (ei puolipisteitä)");
        String aika = JOptionPane.showInputDialog("Ana aika (esim. 12-14)");
        
        if(logiikka.suoritaKomento(1, paiva, nimi, aika)){
            paivitaArea();
            
        }else{
            JOptionPane.showMessageDialog(null, "Virhe", "Lisäys epäonnistui", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        
        if(logiikka.suoritaKomento(3)){
            paivitaArea();
            
        }else{
            JOptionPane.showMessageDialog(null, "Virhe", "Tyhjennys epäonnistui", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        
        logiikka.tallennaTila();
    }//GEN-LAST:event_jMenuItem1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    
    public class omaRenderoija extends DefaultTableCellRenderer{

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
            
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Merkintalista tulostettavat = logiikka.getLista();
            Map<String, List<Merkinta>> tulosta = tulostettavat.getMap();
            
            if(column == 1){
                
                ArrayList<Integer> varjattavat = new ArrayList<>();
                
                for (Merkinta tama : tulosta.get("ma")) {
                    
                    lisaaAjatListaan(tama, varjattavat);
                }
                
                if(varjattavat.contains(row)){
                    cell.setBackground(Color.red);
                    
                }else{
                    cell.setBackground(Color.white);
                }
            }
            
            if(column == 2){
                
                ArrayList<Integer> varjattavat = new ArrayList<>();
                
                for (Merkinta tama : tulosta.get("ti")) {
                    
                    lisaaAjatListaan(tama, varjattavat);
                }
                
                if(varjattavat.contains(row)){
                    cell.setBackground(Color.red);
                    
                }else{
                    cell.setBackground(Color.white);
                }
            }
            
            if(column == 3){
                
                ArrayList<Integer> varjattavat = new ArrayList<>();
                
                for (Merkinta tama : tulosta.get("ke")) {
                    
                    lisaaAjatListaan(tama, varjattavat);
                }
                
                if(varjattavat.contains(row)){
                    cell.setBackground(Color.red);
                    
                }else{
                    cell.setBackground(Color.white);
                }
            }
            
            if(column == 4){
                
                ArrayList<Integer> varjattavat = new ArrayList<>();
                
                for (Merkinta tama : tulosta.get("to")) {
                    
                    lisaaAjatListaan(tama, varjattavat);
                }
                
                if(varjattavat.contains(row)){
                    cell.setBackground(Color.red);
                    
                }else{
                    cell.setBackground(Color.white);
                }
            }
            
            if(column == 5){
                
                ArrayList<Integer> varjattavat = new ArrayList<>();
                
                for (Merkinta tama : tulosta.get("pe")) {
                    
                    lisaaAjatListaan(tama, varjattavat);
                }
                
                if(varjattavat.contains(row)){
                    cell.setBackground(Color.red);
                    
                }else{
                    cell.setBackground(Color.white);
                }
            }
            return cell;
        }

        
        private void lisaaAjatListaan(Merkinta tama, ArrayList<Integer> lista){
            
            String aika = tama.getAika();
            String[] osat = aika.split("-");
            
            int eka = Integer.parseInt(osat[0]);
            int toka = Integer.parseInt(osat[1]);
            
            for (int i = eka; i <= toka; i++) {
                lista.add(i - 8); //Miinus 8 koska mukautetaan riveihin JTablessa.
            }
        }
    }
}