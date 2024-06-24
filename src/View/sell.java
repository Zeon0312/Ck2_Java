/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Database.Mysql;
import Model.Product;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSI GF63 11UC
 */
public class sell extends javax.swing.JFrame {
   
    private static final long serialVersionUID = 1L;
    private JPanel trangchu;
    private JTextField txtsearch;
    private JPanel productsPanel;
    public sell() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800); // Đặt kích thước cửa sổ JFrame
        setLocationRelativeTo(null); // Đặt cửa sổ ở giữa màn hình
        trangchu = new JPanel();
        trangchu.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(trangchu);
        trangchu.setLayout(null);

        JPanel thanhmenu = new JPanel();
        thanhmenu.setBackground(new Color(204,102,0));
        thanhmenu.setBounds(0, 0, 1165, 93);
        trangchu.add(thanhmenu);
        thanhmenu.setLayout(null);

        txtsearch = new JTextField();
        txtsearch.setFont(new Font("Dialog", Font.PLAIN, 28));
        txtsearch.setBounds(285, 26, 476, 46);
        thanhmenu.add(txtsearch);

        JLabel searchLabel = new JLabel();
        ImageIcon searchIcon = new ImageIcon("F:\\DoAnCoSo1\\DoAnCoSo\\src\\icon\\icon\\loupe.png"); // Khởi tạo biến icon ở đây
        Image scaledSearchImage = searchIcon.getImage().getScaledInstance(67, 67, Image.SCALE_SMOOTH);
        ImageIcon scaledSearchIcon = new ImageIcon(scaledSearchImage);
        searchLabel.setIcon(scaledSearchIcon);
        searchLabel.setBounds(784, 10, 69, 70);
        thanhmenu.add(searchLabel);
        searchLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchLabelMouseClicked(evt);
            }
        });

        JButton thanhtoanButton = new JButton("Trang chủ");
        thanhtoanButton.setForeground(new Color(255, 0, 0));
        thanhtoanButton.setBackground(new Color(255, 255, 255));
        thanhtoanButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Home1 Back = new Home1();
        		Back.setVisible(true);
                        setVisible(false);
        	}
        });
        thanhtoanButton.setFont(new Font("Dialog", Font.PLAIN, 20));
        thanhtoanButton.setBounds(952, 10, 174, 62);
        thanhmenu.add(thanhtoanButton);

        JLabel logoLabel = new JLabel();
        ImageIcon logoIcon = new ImageIcon("F:\\DoAnCoSo1\\DoAnCoSo\\src\\icon\\icon\\coffee-cup.png");
        Image scaledLogoImage = logoIcon.getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledLogoIcon = new ImageIcon(scaledLogoImage);
        logoLabel.setIcon(scaledLogoIcon);
        logoLabel.setBounds(3, 0, 263, 93);
        thanhmenu.add(logoLabel);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(204,102,0));
        panel.setBounds(0, 103, 1155, 375);
        trangchu.add(panel);
        panel.setLayout(null);

        JLabel bannerLabel = new JLabel();
        ImageIcon bannerIcon = new ImageIcon("C:\\Users\\MSI GF63 11UC\\Pictures\\Saved Pictures\\national-coffee-day-news.jpg");
        Image scaledBannerImage = bannerIcon.getImage().getScaledInstance(900, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledBannerIcon = new ImageIcon(scaledBannerImage);
        bannerLabel.setIcon(new ImageIcon("C:\\Users\\MSI GF63 11UC\\Pictures\\Saved Pictures\\national-coffee-day-news.jpg"));
        bannerLabel.setBounds(0, 0, 1200, 500);
        panel.add(bannerLabel);

        // Create a new panel for content and set a scroll pane around it
        JPanel contentPanel = new JPanel();
        contentPanel.setBounds(10, 488, 1155, 276); // Set the bounds for the content panel below the banner
        trangchu.add(contentPanel);
        contentPanel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 1155, 266); // Set the bounds to cover the whole content area
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Always show vertical scrollbar
        contentPanel.add(scrollPane);

        productsPanel = new JPanel();
        productsPanel.setLayout(new GridLayout(0, 5, 10, 10)); // Set layout to GridLayout with 5 columns
        scrollPane.setViewportView(productsPanel);

        loadProducts();
    }
     private void searchLabelMouseClicked(java.awt.event.MouseEvent evt) {
        String keyword = txtsearch.getText();
        ArrayList<Product> searchResults = searchProducts(keyword);
        updateUIWithSearchResults(searchResults);
    }

    private void loadProducts() {
        ArrayList<Product> productList = getProductsFromDatabase();

        for (Product product : productList) {
            JPanel productPanel = new JPanel();
            productPanel.setLayout(new BoxLayout(productPanel, BoxLayout.Y_AXIS));
            productPanel.setBackground(Color.WHITE);

            JLabel productImageLabel = new JLabel();
            try {
                File imgFile = new File(product.getImagePath());
                if (imgFile.exists()) {
                    BufferedImage img = ImageIO.read(imgFile);
                    Image scaledImg = img.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
                    productImageLabel.setIcon(new ImageIcon(scaledImg));
                } else {
                    productImageLabel.setText("No Image");
                }
            } catch (IOException e) {
                productImageLabel.setText("Error");
            }

            JLabel productInfoLabel = new JLabel("<html>" + "[ " + product.getMaSanPham() + " ] " +
                    "<div style='width: 170px; text-align: left;'>" + product.getTenSanPham() + "</div>" +
                    "<br><div style='margin-left:80px; margin-top:10px'> " + product.getGiaSanPham() + " đ</html>");
            productInfoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            productInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);

            productPanel.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    int option = JOptionPane.showConfirmDialog(null, "Bạn muốn thêm sản phẩm này vào hóa đơn?",
                            "Xác nhận", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        try {
                            // Thêm sản phẩm vào cơ sở dữ liệu
                            addProductToCart(product);
                        } catch (IOException ex) {
                            Logger.getLogger(sell.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });

            productPanel.add(productImageLabel);
            productPanel.add(productInfoLabel);

            productsPanel.add(productPanel);
        }
    }

    // Thêm sản phẩm vào cơ sở dữ liệu
    private void addProductToCart(Product product) throws IOException, IOException, IOException {
        try {
            Connection conn = Mysql.getConnection();
            String sql = "INSERT INTO hoadon (masp, tensp, gia, hinhanhsp) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, product.getMaSanPham());
            pstmt.setString(2, product.getTenSanPham());
            pstmt.setDouble(3, product.getGiaSanPham());
            pstmt.setString(4, product.getImagePath());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sản phẩm đã được thêm vào hóa đơn!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi thêm sản phẩm vào hóa đơn!");
        }
    }


private ArrayList<Product> getProductsFromDatabase() {
ArrayList<Product> productList = new ArrayList<>();
try {
    Connection conn = Mysql.getConnection();
    String sql = "SELECT maSanPham, tenSanPham, giaSanPham, hinhanhsp FROM product";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    ResultSet rs = pstmt.executeQuery();

    while (rs.next()) {
        String maSanPham = rs.getString("maSanPham");
        String tenSanPham = rs.getString("tenSanPham");
        double giaSanPham = rs.getDouble("giaSanPham");
        String hinhAnh = rs.getString("hinhanhsp");
        Product product = new Product(maSanPham, tenSanPham, giaSanPham, hinhAnh);
        productList.add(product);
    }

    
} catch (SQLException e) {
    e.printStackTrace();
}
return productList;
}

private ArrayList<Product> searchProducts(String keyword) {
ArrayList<Product> searchResults = new ArrayList<>();
try {
    Connection conn = Mysql.getConnection();
    String sql = "SELECT maSanPham, tenSanPham, giaSanPham, hinhanhsp FROM product WHERE tenSanPham  LIKE ?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, "%" + keyword + "%");
    ResultSet rs = pstmt.executeQuery();

    while (rs.next()) {
        String maSanPham = rs.getString("maSanPham");
        String tenSanPham = rs.getString("tenSanPham");
        double giaSanPham = rs.getDouble("giaSanPham");
        String hinhAnh = rs.getString("hinhanhsp");
        Product product = new Product(maSanPham, tenSanPham, giaSanPham, hinhAnh);
        searchResults.add(product);
    }

   
} catch (SQLException e) {
    e.printStackTrace();
}
return searchResults;
}

private void updateUIWithSearchResults(ArrayList<Product> searchResults) {
productsPanel.removeAll(); 
for (Product product : searchResults) {
    JPanel productPanel = new JPanel();
    productPanel.setLayout(new BoxLayout(productPanel, BoxLayout.Y_AXIS));
    productPanel.setBackground(Color.WHITE);

    JLabel productImageLabel = new JLabel();
    try {
        File imgFile = new File(product.getImagePath());
        if (imgFile.exists()) {
            BufferedImage img = ImageIO.read(imgFile);
            Image scaledImg = img.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
            productImageLabel.setIcon(new ImageIcon(scaledImg));
        } else {
            productImageLabel.setText("No Image");
        }
    } catch (IOException e) {
        productImageLabel.setText("Error");
    }

    JLabel productInfoLabel = new JLabel("<html>" + "[" + product.getMaSanPham() + "]" + product.getTenSanPham()
            + "<br><div style='margin-left:80px; margin-top:10px'> " + product.getGiaSanPham() + " đ</html>");
    productInfoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
    productInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);

    productPanel.add(productImageLabel);
    productPanel.add(productInfoLabel);

    productsPanel.add(productPanel);
}
productsPanel.revalidate(); // Cập nhật lại giao diện
productsPanel.repaint();
}


  
    /**
     * Creates new form sell
     */
//    public sell() {
//        initComponents();
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(sell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sell().setVisible(true);
            }
        });
    }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
