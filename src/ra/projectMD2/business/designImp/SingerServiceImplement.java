package ra.projectMD2.business.designImp;


import ra.projectMD2.business.design.ISingerDesign;
import ra.projectMD2.business.entity.Singer;
import ra.projectMD2.business.entity.Song;
import ra.projectMD2.business.utils.IOFile;
import ra.projectMD2.business.utils.InputMethods;
import ra.projectMD2.business.utils.ShopConfig;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static ra.projectMD2.business.designImp.SongServiceImplement.songList;

public class SingerServiceImplement implements ISingerDesign {

    public static List<Singer> singerList= IOFile.readFromFile(IOFile.SINGERS_PATH);

    public SingerServiceImplement() {

    }


    @Override
    public void displayAll() {

        if (singerList.isEmpty()) {
            System.err.println(ShopConfig.EMPTY_LIST);
        }
        singerList.forEach(Singer::displaySinger);
    }

    @Override
    public Singer findById(Integer id) {
        return singerList.stream().filter(e -> e.getSingerId() == id).findFirst().orElse(null);

    }

    @Override
    public void addNew() {
        System.out.println("Số lượng ca sĩ cần thêm");
        byte quantity = InputMethods.getByte();
        for (int i = 1; i <= quantity; i++) {
            System.out.println("Nhập thông tin ca sĩ thứ " + i);
            Singer newSinger = new Singer();
            newSinger.setSingerId(getNewId());
            newSinger.inputData();
            singerList.add(newSinger);
            IOFile.writeToFile(IOFile.SINGERS_PATH, singerList);
        }
        System.out.println("Đã thêm mới " + quantity + " ca sĩ");
    }

    @Override
    public void edit() {

        System.out.println("Nhập id danh muc cần sửa");
        int idSinger = InputMethods.getInteger();
        Singer editSinger = findById(idSinger);
        if (editSinger == null) {
            System.err.println("Không tồn tại id");
            return;
        }
        System.out.println("Thông tin ca sĩ cần sửa");
        editSinger.displaySinger();
        System.out.println("Nhập thông tin mới");
        editSinger.setSingerId(idSinger);
        editSinger.inputData();
        singerList.add(editSinger);
        IOFile.writeToFile(IOFile.SINGERS_PATH, singerList);
        System.out.println("Cập nhật thành công");
    }

    @Override
    public void deleteById(Integer id) {
        Singer deleteSinger = findById(id);
        if (deleteSinger == null) {
            System.out.println("Không tồn tại id");
            return;
        }
        // kiểm  tra xem ca sĩ có bài hát hay không
        if (songList.stream().anyMatch(e -> e.getSingerId() == id)) {
            // có bài hát
            System.err.println("Ca sĩ này có bài hát, ko thể xóa");
            return;
        }
        singerList.remove(findById(id));
        System.out.println("Xoá thành công");
        IOFile.writeToFile(IOFile.SINGERS_PATH, singerList);
    }

    public int getNewId() {

        int max = singerList.stream().map(Singer::getSingerId).max(Comparator.naturalOrder()).orElse(0);
        return max + 1;
    }

    public void findSingerById() {
        System.out.println("Nhập id ca sĩ cần tìm");
        int idSinger = InputMethods.getInteger();
        Singer findSinger = findById(idSinger);
        if (findSinger == null) {
            System.err.println("Không tồn tại id");
            return;
        }
        findSinger.displaySinger();
    }

    public void findSingerByName() {
        System.out.println("Nhập tên ca sĩ cần tìm kiếm");
        String singerName = InputMethods.getString();
        if (findByName(singerName) == null) {
            System.err.println("không tồn tại id");
        }
        findByName(singerName).forEach(Singer::displaySinger);
    }

    public List<Singer> findByName(String singerName) {
        return singerList.stream().filter(u -> u.getSingerName().contains(singerName)).collect(Collectors.toList());
    }
}
