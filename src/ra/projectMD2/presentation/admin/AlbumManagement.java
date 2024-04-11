package ra.projectMD2.presentation.admin;

import ra.projectMD2.business.design.IAlbumDesign;
import ra.projectMD2.business.designImp.AlbumServiceImplement;
import ra.projectMD2.business.designImp.SingerServiceImplement;
import ra.projectMD2.business.utils.InputMethods;
import ra.projectMD2.business.utils.ShopConfig;

public class AlbumManagement {
    static AlbumServiceImplement albumServiceImplement = new AlbumServiceImplement();

    public static void AlbumMenu() {
        while (true) {
            System.out.println(" =========Quản lý album========= ");
            System.out.println(" 1. Hiển thị danh sách album ");
            System.out.println(" 2. Thêm mới album ");
            System.out.println(" 3. Sửa album");
            System.out.println(" 4. Xoá album");
            System.out.println(" 5. Tìm kiếm album");
            System.out.println(" 6. Quay lại ");
            System.out.println(" Chọn một tùy chọn:");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    albumServiceImplement.displayAll();
                    break;
                case 2:
                    albumServiceImplement.addNew();
                    break;
                case 3:
                    albumServiceImplement.edit();
                    break;
                case 4:
                    System.out.println("Mời bạn nhập id album cần xóa");
                    int idAlbumDelete = InputMethods.getInteger();
                    albumServiceImplement.deleteById(idAlbumDelete);
                    break;
                case 5:
                    albumServiceImplement.searchAlbum();
                    break;
                case 6:
                    return;
                default:
                    System.err.println(ShopConfig.CHOICE_FALSE);
                    break;

            }

        }
    }
}
