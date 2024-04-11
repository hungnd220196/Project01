package ra.projectMD2.presentation.user;

import org.mindrot.jbcrypt.BCrypt;
import ra.projectMD2.business.design.IAuthentic;
import ra.projectMD2.business.designImp.AuthenticationService;
import ra.projectMD2.business.designImp.UserServiceImplement;
import ra.projectMD2.business.entity.User;
import ra.projectMD2.business.utils.IOFile;
import ra.projectMD2.business.utils.InputMethods;
import ra.projectMD2.business.utils.ShopConfig;

import java.util.Objects;

import static ra.projectMD2.business.designImp.UserServiceImplement.userList;
import static ra.projectMD2.presentation.Home.login;

public class UserInfomation {
    private static IAuthentic authentic = new AuthenticationService();
    static User users = IOFile.readUserLoginFromFile(IOFile.USERLOGIN_PATH);
    static UserServiceImplement userService = new UserServiceImplement();

    public static void InformationManagement() {
        User users = IOFile.readUserLoginFromFile(IOFile.USERLOGIN_PATH);
        while (true) {

            System.out.println(" Quản lý thông tin cá nhân  ");

            System.out.println(" 1. Hiển thị thông tin cá nhân ");
            System.out.println(" 2. Chỉnh sửa thông tin cá nhân  ");
            System.out.println(" 3. Đổi mật khẩu ");
            System.out.println(" 4. Quay lại  ");

            System.out.println(" Chọn một tùy chọn:");

            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    users.displayUser();
                    break;
                case 2:
                    updateInforUser();
                    break;
                case 3:
                    changePassword();
                    break;
                case 4:
                    return;
                default:
                    System.out.println(ShopConfig.CHOICE_FALSE);
            }
        }

    }

    public static void updateInforUser() {
        User user = IOFile.readUserLoginFromFile(IOFile.USERLOGIN_PATH);
        System.out.println("Thông tin user cần sửa");
        user.displayUser();
        System.out.println("Nhập thông tin mới");
        user.inputUsername();
        System.out.println("Nhập mật khẩu");
        user.inputPassword();
        System.out.println("Nhập email");
        user.inputEmail();
        System.out.println("Nhap số điện thoại");
        user.inputPhoneNumber();
        System.out.println("Nhap tên đầy đủ");
        user.inputFullname();
        userList.add(user);
        IOFile.writeToFile(IOFile.USER_PATH, userList);
        System.out.println("Cập nhật thành công");
    }

    public static void changePassword() {
        User users = IOFile.readUserLoginFromFile(IOFile.USERLOGIN_PATH);
        while (true) {
            System.out.println("Nhập mật khẩu cũ");
            String oldPassWord = InputMethods.getString();
            if (BCrypt.checkpw(oldPassWord, users.getPassword())) {
                System.out.println("Nhập thông tin mật khẩu mới");
                String newPassword = InputMethods.getString();
                users.setPassword(BCrypt.hashpw(newPassword, BCrypt.gensalt(5)));
                userList.add(users);
                IOFile.writeToFile(IOFile.USER_PATH, userList);
                System.out.println("Đổi nhập khẩu thành công");
                break;
            } else {
                System.out.println("Sai mật khẩu, mời nhập lại");
            }
        }
    }
}