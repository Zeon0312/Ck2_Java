/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
/**
 *
 * @author MSI GF63 11UC
 */
public class Product {
    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

String maSanPham;
String tenSanPham;
double giaSanPham;
String imagePath;

public Product(String maSanPham, String tenSanPham, double giaSanPham, String imagePath) {
    this.maSanPham = maSanPham;
    this.tenSanPham = tenSanPham;
    this.giaSanPham = giaSanPham;
    this.imagePath = imagePath;
}

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public void setGiaSanPham(double giaSanPham) {
        this.giaSanPham = giaSanPham;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

public String getMaSanPham() {
    return maSanPham;
}

public String getTenSanPham() {
    return tenSanPham;
}

public double getGiaSanPham() {
    return giaSanPham;
}

public String getImagePath() {
    return imagePath;
}
}



