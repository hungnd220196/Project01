package ra.projectMD2.presentation.admin;

import ra.projectMD2.business.designImp.SingerServiceImplement;
import ra.projectMD2.business.entity.Singer;
import ra.projectMD2.business.utils.InputMethods;
import ra.projectMD2.business.utils.ShopConfig;

import static ra.projectMD2.business.designImp.SingerServiceImplement.singerList;

public class SingerManagement {
    static SingerServiceImplement singerService = new SingerServiceImplement();

    public static void SingerMenu() {
        while (true) {
            System.out.println(" Quản lý ca sỹ ");
            System.out.println(" 1. Hiển thị danh sách ca sĩ ");
            System.out.println(" 2. Thêm mới ca sĩ ");
            System.out.println(" 3. Sửa thông tin ca sĩ ");
            System.out.println(" 4. Xoá ca sĩ   ");
            System.out.println(" 5. Tìm kiếm ca sĩ theo id  ");
            System.out.println(" 6. Tìm kiếm ca sĩ theo tên  ");
            System.out.println(" 7. Quay lại ");
            System.out.println(" Chọn một tùy chọn:");

            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    singerService.displayAll();
                    break;
                case 2:
                    singerService.addNew();
                    break;
                case 3:
                    singerService.edit();
                    break;
                case 4:
                    System.out.println("Nhập id danh mục cần xoá");
                    int idDetete = InputMethods.getInteger();
                    singerService.deleteById(idDetete);
                    break;
                case 5:
                    singerService.findSingerById();
                    break;
                case 6:
                    singerService.findSingerByName();
                    break;
                case 7:
                    return;
                default:
                    System.err.println(ShopConfig.CHOICE_FALSE);
            }
        }
    }

}
