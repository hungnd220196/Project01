package ra.projectMD2.business.entity;

import ra.projectMD2.business.utils.InputMethods;
import ra.projectMD2.business.utils.ShopConfig;

import java.io.Serializable;
import java.time.LocalDate;

public class User implements Serializable {
    private int userId;
    private String userName;
    private String password;
    private String fullName;
    private String email;
    private String phone;
    private int accountType = 1;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private double wallet;
    private boolean status = true;
    private boolean role = true;

    public User() {
    }

    public User(int userId, String userName, String password, String fullName, String email, String phone, int accountType, LocalDate createdAt, LocalDate updatedAt, double wallet, boolean status, boolean role) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.accountType = accountType;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.wallet = wallet;
        this.status = status;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public void inputUsername() {
        while (true) {
            this.userName = InputMethods.getString();
            if (this.userName.length() >= 6) {
                break;
            } else {
                System.err.println("Tên đăng nhập phải lớn hơn 6 kí tự");
            }
        }
    }

    public void inputPassword() {
        this.password = InputMethods.getString();
    }

    public void inputEmail() {
        this.email = InputMethods.getString();
    }

    public void inputPhoneNumber() {
        this.phone = InputMethods.getString();
    }

    public void inputFullname() {
        this.fullName = InputMethods.getString();
    }

    public void inputCreatedAt() {
        this.createdAt = LocalDate.now();
    }

    public void inputUpdatedAt() {
        this.updatedAt = LocalDate.now();
    }


    public void displayUser() {
        System.out.println("Users[" +
                "usersId : " + this.userId +
                ", accountType : " + (this.accountType == 1 ? "Thường" : "VIP") +
                ", userName : '" + this.userName + '\'' +
                ", email : '" + this.email + '\'' +
                ", fullName : '" + this.fullName + '\'' +
                ", password : '" + this.password + '\'' +
                ", phone : '" + this.phone + '\'' +
                ", status : " + this.status +
                ", createdAt : " + this.createdAt.format(ShopConfig.DTF) +
                ", UpdatedAt : " + this.updatedAt.format(ShopConfig.DTF) +
                ", role : " + role +
                '}');
    }
}