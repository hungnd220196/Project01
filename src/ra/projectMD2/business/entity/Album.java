package ra.projectMD2.business.entity;

import ra.projectMD2.business.designImp.AlbumServiceImplement;
import ra.projectMD2.business.utils.IOFile;
import ra.projectMD2.business.utils.InputMethods;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ra.projectMD2.business.designImp.AlbumServiceImplement.albumList;
import static ra.projectMD2.business.designImp.SingerServiceImplement.singerList;

public class Album implements Serializable {

    private int id;
    private String name, description, image;
    private int singerId;

    private double albumPrice;

    public Album() {
    }

    public Album(int id, String name, String description, String image, int singerId, List<Song> song, double albumPrice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.singerId = singerId;
        this.albumPrice = albumPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        if (name == null) {
            name = "null";
        }
        return name;
    }

    public double getAlbumPrice() {
        return albumPrice;
    }

    public void setAlbumPrice(double albumPrice) {
        this.albumPrice = albumPrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }


    public void displayAlbum() {
        System.out.println("Album{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", singerId=" + this.singerId +
                ", albumPrice=" + albumPrice +
                '}');
    }

    public void inputData() {
        while (true) {
            System.out.println("Nhập tên Album");
            String newNameAlbum = InputMethods.getString();
            if ((!newNameAlbum.isBlank())) {
                boolean flag = true;
                for (Album album : albumList) {
                    if (album.getName().equals(newNameAlbum)) {
                        System.err.println("Tên Album đã tồn tại");
                        flag = false;
                    }
                }
                if (flag) {
                    this.name = newNameAlbum;
                    break;
                }
            } else {
                System.err.println("Tên Album không được để trống");
            }
        }

        System.out.println("Nhập mô tả Album");
        this.description = InputMethods.getString();
        System.out.println("Nhập ảnh Album");
        this.image = InputMethods.getString();

        this.singerId = getIdSinger();

    }

    public int getIdSinger() {
        List<Singer> singerList = IOFile.readFromFile(IOFile.SINGERS_PATH);
        // hiển thị danh sách ca sĩ
        System.out.println("Danh sách ca sĩ");
        for (int i = 0; i < singerList.size(); i++) {
            System.out.printf("| STT : %d | Tên ca sĩ : %-15s |\n", i + 1, singerList.get(i).getSingerName());
        }
        while (true) {
            System.out.println("Nhập vào vị trí ca sĩ (theo STT)");
            int index = InputMethods.getInteger();
            if (index >= 1 && index <= singerList.size()) {
                Singer singer1 = singerList.get(index - 1);
                return singer1.getSingerId();
            }
            System.err.println("Vị trí không hợp lệ, vui lòng chọn lại");
        }
    }
}
