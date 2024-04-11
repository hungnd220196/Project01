package ra.projectMD2.business.designImp;

import ra.projectMD2.business.design.IAlbumDesign;
import ra.projectMD2.business.entity.Album;
import ra.projectMD2.business.entity.Singer;
import ra.projectMD2.business.entity.Song;
import ra.projectMD2.business.utils.IOFile;
import ra.projectMD2.business.utils.InputMethods;

import java.util.List;
import java.util.stream.Collectors;

public class AlbumServiceImplement implements IAlbumDesign {
    public static List<Album> albumList = IOFile.readFromFile(IOFile.ALBUM_PATH);

    public AlbumServiceImplement() {

    }


    @Override
    public void displayAll() {

        if (albumList.isEmpty()) {
            System.err.println("Danh sách rỗng");
            return;
        }
        for (Album album : albumList) {
            album.displayAlbum();
        }
    }

    @Override
    public Album findById(Integer id) {
        return albumList.stream().filter(e -> e.getId() == id).findFirst().orElse(null);

    }

    @Override
    public void addNew() {
        System.out.println("Số lượng album cần thêm");
        byte quantity = InputMethods.getByte();
        for (int i = 1; i <= quantity; i++) {
            System.out.println("Nhập thông tin album thứ " + i);
            Album album = new Album();
            album.setId(getNewId());
            album.inputData();
            albumList.add(album);
            IOFile.writeToFile(IOFile.ALBUM_PATH, albumList);
        }
        System.out.println("Đã thêm mới " + quantity + " album");
    }

    @Override
    public void edit() {

        System.out.println("Nhập id album cần sửa");
        int idAlbum = InputMethods.getInteger();
        Album editAlbum = findById(idAlbum);
        if (editAlbum == null) {
            System.err.println("Không tồn tại id");
            return;
        }
        System.out.println("Thông tin ca sĩ cần sửa");
        editAlbum.displayAlbum();
        System.out.println("Nhập thông tin mới");
        editAlbum.setId(idAlbum);
        editAlbum.inputData();
        albumList.add(editAlbum);
        IOFile.writeToFile(IOFile.ALBUM_PATH, albumList);
        System.out.println("Cập nhật thành công");
    }


    @Override
    public void deleteById(Integer id) {
        albumList.remove(findById(id));
    }

    public int getNewId() {
        int maxId = 0;
        for (Album album : albumList) {
            if (album.getId() > maxId) {
                maxId = album.getId();
            }
        }
        return maxId + 1;
    }

    public List<Album> findByName(String albumName) {
        return albumList.stream().filter(u -> u.getName().contains(albumName)).collect(Collectors.toList());
    }

    public void searchAlbum() {
        System.out.println("Nhập tên album cần tìm kiếm");
        String albumNameInput = InputMethods.getString();
        if (findByName(albumNameInput) == null) {
            System.err.println("không tồn tại id");
        }
        findByName(albumNameInput).forEach(Album::displayAlbum);
    }
}
