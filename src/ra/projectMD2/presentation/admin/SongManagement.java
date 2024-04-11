package ra.projectMD2.presentation.admin;

import ra.projectMD2.business.design.ISongDesign;
import ra.projectMD2.business.designImp.SongServiceImplement;
import ra.projectMD2.business.utils.InputMethods;
import ra.projectMD2.business.utils.ShopConfig;

public class SongManagement {
    static SongServiceImplement songServiceImplement = new SongServiceImplement();

    public static void songMenu() {
        while (true) {
            System.out.println(" =========Quản lý bài hát========= ");
            System.out.println(" 1. Hiển thị danh sách bài hát ");
            System.out.println(" 2. Thêm mới bài hát ");
            System.out.println(" 3. Sửa bài hát");
            System.out.println(" 4. Xoá bài hát");
            System.out.println(" 5. Tìm kiếm bài hát");
            System.out.println(" 6. Quay lại ");
            System.out.println(" Chọn một tùy chọn:");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    songServiceImplement.displayAll();
                    break;
                case 2:
                    songServiceImplement.addNew();
                    break;
                case 3:
                    songServiceImplement.edit();
                    break;
                case 4:
                    System.out.println("Mời bạn nhập id bài hát cần xóa");
                    int idDelete = InputMethods.getInteger();
                    songServiceImplement.deleteById(idDelete);
                    break;
                case 5:
                    songServiceImplement.findSongByName();
                    break;
                case 6:
                    break;
                default:
                    System.err.println(ShopConfig.CHOICE_FALSE);
            }

        }
    }
}
