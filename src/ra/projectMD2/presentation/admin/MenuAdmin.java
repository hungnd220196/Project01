package ra.projectMD2.presentation.admin;

import ra.projectMD2.business.utils.InputMethods;
import ra.projectMD2.business.utils.ShopConfig;

public class MenuAdmin {
    private static MenuAdmin menuAdmin = new MenuAdmin();

    // Singleton
    public static MenuAdmin getInstance() {
        return menuAdmin;
    }

    private MenuAdmin() {

    }

    public void displayMenuAdmin() {
        while (true) {
            System.out.println("Chào mừng đến với trang quản trị");
            System.out.println(" 1. Quản lý người dùng");
            System.out.println(" 2. Quản lý ca sĩ");
            System.out.println(" 3. Quản lý Album");
            System.out.println(" 4. Quản lý bài hát");
            System.out.println(" 5. Quản lý danh mục");
            System.out.println(" 6. Thống kê đơn hàng");
            System.out.println(" 7. Đăng xuất ");
            System.out.println(" Chọn một tùy chọn:");

            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    UserManagement.UserMenu();
                    break;
                case 2:
                    SingerManagement.SingerMenu();
                    break;
                case 3:
                    AlbumManagement.AlbumMenu();
                    break;
                case 4:
                    SongManagement.songMenu();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    return;
                default:
                    System.err.println(ShopConfig.CHOICE_FALSE);
            }
        }
    }
}
