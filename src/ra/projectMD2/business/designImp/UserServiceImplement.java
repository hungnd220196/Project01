package ra.projectMD2.business.designImp;

import ra.projectMD2.business.design.IGenericDesign;
import ra.projectMD2.business.design.IUserDesign;
import ra.projectMD2.business.entity.User;
import ra.projectMD2.business.utils.IOFile;
import ra.projectMD2.business.utils.InputMethods;
import ra.projectMD2.business.utils.ShopConfig;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImplement implements IUserDesign {
    public static List<User> userList = IOFile.readFromFile(IOFile.USER_PATH);

    @Override
    public void displayAll() {
        List<User> userList = IOFile.readFromFile(IOFile.USER_PATH);
        System.out.printf("| %-3s | %-15s | %-7s | %-30s | %-20s | %-16s | %-20s | %-20s |%-10s\n",
                "ID", "Tên đăng nhập", "Vai trò", "Email", "Số điện thoại", "VIP", "Thời gian đăng ký", "Cập nhật gần nhất", "Trạng thái");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (User user : userList) {
            System.out.printf("| %-3d | %-15s | %-7s | %-30s | %-20s | %-10s | %-20s | %-20s |%-10s\n",
                    user.getUserId(), user.getUserName(), user.isRole() ? "User" : "Admin", user.getEmail(), user.getPhone(),
                    user.getAccountType() == 1 ? "Tài khoản thường" : "Tài khoản Vip", user.getCreatedAt().format(ShopConfig.DTF), user.getUpdatedAt().format(ShopConfig.DTF), user.isStatus() ? "Active" : "Block");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }

    @Override
    public User findById(Integer id) {
        return userList.stream().filter(e -> e.getUserId() == id).findFirst().orElse(null);

    }

    @Override
    public void addNew() {

        System.out.println("Mời bạn chọn tài khoản muốn thêm ");
        while (true) {
            System.out.println("1.Thêm mới tài khoản admin");
            System.out.println("2.Thêm mới tài khoản user");
            System.out.println("3.Thoát");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    //Thêm mới tài khoản admin
                    User admin = new User();
                    admin.setUserId(getNewId());
                    admin.setUserName(InputMethods.getString());
                    admin.setPassword(InputMethods.getString());
                    admin.setRole(false);
                    admin.setStatus(true);
                    userList.add(admin);
                    IOFile.writeToFile(IOFile.USER_PATH, userList);
                    break;
                case 2:
                    //Thêm mới tài khoản user
                    System.out.println("--------------Đăng ký----------------");
                    User user = new User();
                    user.setUserId(getNewId());
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
                    userList.add(user);
                    System.out.println("Đăng ký thành công");
                    IOFile.writeToFile(IOFile.USER_PATH, userList);
                    break;
                case 3:
                    return;
                default:
                    System.err.println(ShopConfig.CHOICE_FALSE);
            }
        }

    }

    @Override
    public void edit() {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void searchUserByName() {

        System.out.println("mời bạn nhập tên user cần tìm");
        String nameSearch = InputMethods.getString();
        userList.stream().filter(user -> user.getUserName().contains(nameSearch)).toList().forEach(User::displayUser);
    }

    @Override
    public User changeStatusUser(Integer id) {

        for (User user : userList) {
            if (user.getUserId() == id) {
                user.setStatus(!user.isStatus());
                IOFile.writeToFile(IOFile.USER_PATH, userList);
                return user;
            }
        }
        return null;
    }

    public int getNewId() {
        int max = userList.stream().map(User::getUserId).max(Comparator.naturalOrder()).orElse(0);
        return max + 1;
    }
}
