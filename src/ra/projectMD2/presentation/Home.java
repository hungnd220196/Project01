package ra.projectMD2.presentation;


import ra.projectMD2.business.design.IAuthentic;
import ra.projectMD2.business.designImp.AuthenticationService;
import ra.projectMD2.business.entity.User;
import ra.projectMD2.business.utils.IOFile;
import ra.projectMD2.business.utils.InputMethods;
import ra.projectMD2.business.utils.ShopConfig;
import ra.projectMD2.presentation.admin.MenuAdmin;
import ra.projectMD2.presentation.user.MenuUser;

import java.util.List;

import static ra.projectMD2.business.designImp.UserServiceImplement.userList;

public class Home {
    private static MenuUser menuUser = new MenuUser();
    private static IAuthentic authentic = new AuthenticationService();
    public static User user = null;

    public static void main(String[] args) {
        while (true) {
            System.out.println("++++++++++++++++++++++++MENU+++++++++++++++++++++++");
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng ký");
            System.out.println("3. Thoát");
            System.out.println("Nhập chức năng");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    System.out.println("Thoat");
                default:
                    System.err.println("Lua chon khong hop le");
            }
            if (choice == 3) {
                break;
            }
        }
    }

    public static void login() {
        System.out.println("----------Đăng nhập--------------");
        System.out.println("Nhập tên đăng nhập :");
        String username = InputMethods.getString();
        System.out.println("Nhập mật khẩu :");
        String password = InputMethods.getString();

        User userLogin = authentic.login(username, password);
        if (userLogin == null) {
            System.err.println("Tài khoản hoặc mật khẩu không chính xác");
            System.out.println("1. Tiếp tục đăng nhập");
            System.out.println("2. Bạn chưa có tài khoản. Đăng ký ngay");
            System.out.println("3. Thoát");
            System.out.println("------Nhập lựa chọn------");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    return;
                default:
                    System.err.println(ShopConfig.CHOICE_FALSE);
            }
        } else {
            if (!userLogin.isRole()) {
                user = userLogin;
                IOFile.writeUserLoginToFile(IOFile.USERLOGIN_PATH, userLogin);
                MenuAdmin.getInstance().displayMenuAdmin();
            } else if (userLogin.isRole()) {
                if (!userLogin.isStatus()) {
                    System.err.println("Tài khoản đã bị khóa, vui lòng liên hệ admin(0987342361)");
                } else {
                    user = userLogin;
                    IOFile.writeUserLoginToFile(IOFile.USERLOGIN_PATH, userLogin);
                    MenuUser.displayMenuUser();
                }
            } else {
                System.err.println("Không có quyền truy cập");
            }
        }
        IOFile.writeUserLoginToFile(IOFile.USERLOGIN_PATH, userLogin);
    }

    public static void register() {
        System.out.println("--------------Đăng ký----------------");
        User user = new User();
        System.out.println("Nhập tên đăng nhập");
        user.inputUsername();
        System.out.println("Nhập mật khẩu");
        user.inputPassword();
        System.out.println("Nhập email");
        user.inputEmail();
        System.out.println("Nhap số điện thoại");
        user.inputPhoneNumber();
        System.out.println("Nhap tên đầy đủ");
        user.inputFullname();
        authentic.register(user);
        System.out.println("Đăng ký thành công");
        login();
    }
}