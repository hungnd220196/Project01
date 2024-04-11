package ra.projectMD2.presentation.user;

import ra.projectMD2.business.entity.Album;
import ra.projectMD2.business.entity.Singer;
import ra.projectMD2.business.entity.Song;
import ra.projectMD2.business.utils.InputMethods;
import ra.projectMD2.business.utils.ShopConfig;

import java.util.List;
import java.util.stream.Collectors;

import static ra.projectMD2.business.designImp.AlbumServiceImplement.albumList;
import static ra.projectMD2.business.designImp.SingerServiceImplement.singerList;
import static ra.projectMD2.business.designImp.SongServiceImplement.songList;

public class SearchMenu {
    public static void MenuSearch() {
        while (true) {
            System.out.println("=======MenuSearch=======");
            System.out.println("1. Search song\n" +
                    "2. Search singer\n" +
                    "3. Search album\n" +
                    "4. Mua bài hát\n" +
                    "5. Thêm vào yêu thích\n" +
                    "6. Quay lại");
            System.out.println("mời bạn nhập lựa chọn");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    System.out.println("mời bạn nhập bài hát cần tìm kiếm");
                    String searchSongInput = InputMethods.getString();
                    if (findSongByName(searchSongInput) == null) {
                        System.err.println("không tồn tại bài hát");
                    }
                    findSongByName(searchSongInput).forEach(Song::displaySong);
                    break;
                case 2:
                    System.out.println("mời bạn nhập tên ca sĩ cần tìm kiếm");
                    String searchSingerInput = InputMethods.getString();
                    if (findSingerByName(searchSingerInput) == null) {
                        System.err.println("không tồn tại ca sĩ");
                    }
                    findSingerByName(searchSingerInput).forEach(Singer::displaySinger);
                    break;
                case 3:
                    System.out.println("mời bạn nhập tên album cần tìm kiếm");
                    String searchAlbumInput = InputMethods.getString();
                    if (findAlbumByName(searchAlbumInput) == null) {
                        System.err.println("không tồn tại album");
                    }
                    findAlbumByName(searchAlbumInput).forEach(Album::displayAlbum);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    return;
                default:
                    System.err.println(ShopConfig.CHOICE_FALSE);
            }
        }
    }

    public static List<Song> findSongByName(String songName) {
        return songList.stream().filter(t -> t.getSongName().contains(songName)).collect(Collectors.toList());
    }

    public static List<Singer> findSingerByName(String singerName) {
        return singerList.stream().filter(t -> t.getSingerName().contains(singerName)).collect(Collectors.toList());
    }

    public static List<Album> findAlbumByName(String albumName) {
        return albumList.stream().filter(t -> t.getName().contains(albumName)).collect(Collectors.toList());
    }
}
