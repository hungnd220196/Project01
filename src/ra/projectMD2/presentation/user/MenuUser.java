package ra.projectMD2.presentation.user;


import ra.projectMD2.business.designImp.HistoryServiceImplement;
import ra.projectMD2.business.designImp.SongServiceImplement;
import ra.projectMD2.business.designImp.UserServiceImplement;
import ra.projectMD2.business.entity.Album;
import ra.projectMD2.business.entity.History;
import ra.projectMD2.business.entity.Song;
import ra.projectMD2.business.entity.User;
import ra.projectMD2.business.utils.IOFile;
import ra.projectMD2.business.utils.InputMethods;

import java.util.*;
import java.util.stream.Collectors;

public class MenuUser {
    public static List<History> historyList = IOFile.readFromFile(IOFile.HISTORY_PATH);
    public static List<Album> albumList = IOFile.readFromFile(IOFile.ALBUM_PATH);
    public static List<Song> songList = IOFile.readFromFile(IOFile.SONGS_PATH);
    public static User userLogin = IOFile.readUserLoginFromFile(IOFile.USERLOGIN_PATH);
    public static UserServiceImplement userService = new UserServiceImplement();

//    public static SongCatagoryImplementService songCatagoryService = new SongCatagoryImplementService();

    public static HistoryServiceImplement historyService = new HistoryServiceImplement();


//    public static List<SongCatagory> songCatagoryList = IOFile.readFromFile(IOFile.SONGCATEGORY_PATH);

    public static void displayMenuUser() {
        User userLogin = IOFile.readUserLoginFromFile(IOFile.USERLOGIN_PATH);
        SongServiceImplement songService = new SongServiceImplement();

        while (true) {
            System.out.println(" 1. Tìm kiếm bài hát/ca sĩ/album ");
            System.out.println(" 2. Hiển thị bài hát  ");
            System.out.println(" 3. Hiển thị bài hát trending  ");
            System.out.println(" 4. Hiển thị ca sĩ trending   ");
            System.out.println(" 5. Hiển thị album trending  ");
            System.out.println(" 6. Danh sách các bài hát đã mua ");
            System.out.println(" 7. Hiển thị bài hát theo danh mục ");
            System.out.println("8. Mua bài hát  ");
            System.out.println(" 9. Thêm vào yêu thích ");
            System.out.println(" 11. Quản lý thông tin cá nhân");
            System.out.println("12. Đăng xuất ");
            System.out.println(" Chọn một tùy chọn:");


            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    SearchMenu.MenuSearch();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:

                    break;
                case 11:
                    UserInfomation.InformationManagement();
                    break;
                case 12:
                    return;

                default:
                    System.out.println("Mời nhập lại tuỳ chọn");
            }
        }
    }
}






