package ra.projectMD2.business.entity;

import ra.projectMD2.business.utils.InputMethods;

import java.io.Serializable;
import java.time.LocalDate;

public class History implements Serializable {
    private int historyId;
    private int songId;
    private int userId;
    private double totalPrice;
    private int typePackage;
    private LocalDate createAt;
    private LocalDate expiryDate;

    public History() {

    }

    public History(int historyId, int songId, int userId, double totalPrice, int typePackage, LocalDate createAt, LocalDate expiryDate) {
        this.historyId = historyId;
        this.songId = songId;
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.typePackage = typePackage;
        this.createAt = createAt;
        this.expiryDate = expiryDate;
    }

    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTypePackage() {
        return typePackage;
    }

    public void setTypePackage(int typePackage) {
        this.typePackage = typePackage;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

}
