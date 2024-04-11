package ra.projectMD2.presentation.admin;

import ra.projectMD2.business.designImp.UserServiceImplement;

import ra.projectMD2.business.utils.InputMethods;
import ra.projectMD2.business.utils.ShopConfig;



public class UserManagement {
    public static void UserMenu() {
        UserServiceImplement userServiceImplement = new UserServiceImplement();
        while (true) {
            System.out.println(" ===========Quản lý người dùng===========");
            System.out.println("1. Hiển thị danh sách người dùng ");
            System.out.println("2. Thêm mới tài khoản ");
            System.out.println("3. Tìm kiếm");
            System.out.println("4. Đổi trạng thái người dùng");
            System.out.println("5. Quay lại ");
            System.out.println(" Chọn một tùy chọn: ");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    userServiceImplement.displayAll();
                    break;
                case 2:
                    userServiceImplement.addNew();
                    break;
                case 3:
                    userServiceImplement.searchUserByName();
                    break;
                case 4:
                    System.out.println("mời bạn nhập id cần đổi trạng thái");
                    int idChangeStatus = InputMethods.getInteger();
                    userServiceImplement.changeStatusUser(idChangeStatus);
                    break;
                case 5:
                    return;
                default:
                    System.err.println(ShopConfig.CHOICE_FALSE);
            }
        }
    }
}
