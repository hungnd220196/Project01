package ra.projectMD2.business.designImp;

import ra.projectMD2.business.design.ISongDesign;
import ra.projectMD2.business.entity.Singer;
import ra.projectMD2.business.entity.Song;
import ra.projectMD2.business.entity.User;
import ra.projectMD2.business.utils.IOFile;
import ra.projectMD2.business.utils.InputMethods;
import ra.projectMD2.business.utils.ShopConfig;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SongServiceImplement implements ISongDesign {
    public static List<Song> songList = IOFile.readFromFile(IOFile.SONGS_PATH);

    public SongServiceImplement() {

    }

    @Override
    public void displayAll() {
        if (songList.isEmpty()) {
            System.err.println(ShopConfig.EMPTY_LIST);
        }
        songList.forEach(Song::displaySong);
    }

    @Override
    public Song findById(Integer id) {
        return songList.stream().filter(e -> e.getSongId() == id).findFirst().orElse(null);
    }

    public int getNewId() {

        int max = songList.stream().map(Song::getSongId).max(Comparator.naturalOrder()).orElse(0);
        return max + 1;
    }


    @Override
    public void addNew() {
        System.out.println("Số lượng bài hát cần thêm");
        byte quantity = InputMethods.getByte();
        for (int i = 1; i <= quantity; i++) {
            System.out.println("Nhập thông tin bài hát thứ " + i);
            Song newSong = new Song();
            newSong.setSongId(getNewId());
            newSong.inputSong();
            songList.add(newSong);
            IOFile.writeToFile(IOFile.SONGS_PATH, songList);
        }
    }

    @Override
    public void edit() {

        System.out.println("Nhập id bài hát cần sửa");
        int idSongEdit = InputMethods.getInteger();
        Song editSong = findById(idSongEdit);
        if (editSong == null) {
            System.err.println("Không tồn tại id");
            return;
        }
        System.out.println("Thông tin bài hát cần sửa");
        editSong.displaySong();
        System.out.println("Nhập thông tin mới");
        editSong.setSingerId(idSongEdit);
        editSong.inputSong();
        songList.add(editSong);
        IOFile.writeToFile(IOFile.SONGS_PATH, songList);
        System.out.println("Cập nhật thành công");

    }

    @Override
    public void deleteById(Integer id) {
        Song deleteSong = findById(id);
        if (deleteSong == null) {
            System.out.println("Không tồn tại id");
            return;
        }
        songList.remove(findById(id));
        System.out.println("Xoá thành công");
        IOFile.writeToFile(IOFile.SONGS_PATH, songList);
    }

    public void findSongByName() {
        System.out.println("Nhập tên bài hát cần tìm kiếm");
        String songNameInput = InputMethods.getString();
        if (findByName(songNameInput) == null) {
            System.err.println("không tồn tại tên bài hát");
        }
        findByName(songNameInput).forEach(Song::displaySong);
    }

    public List<Song> findByName(String songName) {
        return songList.stream().filter(t -> t.getSongName().contains(songName)).collect(Collectors.toList());
    }
}
