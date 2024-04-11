package ra.projectMD2.business.entity;

import ra.projectMD2.business.utils.IOFile;
import ra.projectMD2.business.utils.InputMethods;
import ra.projectMD2.business.utils.ShopConfig;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static ra.projectMD2.business.designImp.SingerServiceImplement.singerList;
import static ra.projectMD2.business.designImp.AlbumServiceImplement.albumList;
import static ra.projectMD2.business.designImp.SongServiceImplement.songList;

public class Song implements Serializable {

    private int songId;
    private int singerId;
    private String songName;
    private String description;
    private String sourceSong;
    private Double price;
    private int albumId;
    private String image;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private List<Song> favouriteSong, myAlbum;
    private int playingCount = 0;

    public Song() {
    }

    public Song(int songId, int singerId, String songName, String description, String sourceSong, Double price, int albumId, String image, LocalDate createdAt, LocalDate updatedAt, List<Song> favouriteSong, List<Song> myAlbum, int playingCount) {
        this.songId = songId;
        this.singerId = singerId;
        this.songName = songName;
        this.description = description;
        this.sourceSong = sourceSong;
        this.price = price;
        this.albumId = albumId;
        this.image = image;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.favouriteSong = favouriteSong;
        this.myAlbum = myAlbum;
        this.playingCount = playingCount;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSourceSong() {
        return sourceSong;
    }

    public void setSourceSong(String sourceSong) {
        this.sourceSong = sourceSong;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Song> getFavouriteSong() {
        return favouriteSong;
    }

    public void setFavouriteSong(List<Song> favouriteSong) {
        this.favouriteSong = favouriteSong;
    }

    public List<Song> getMyAlbum() {
        return myAlbum;
    }

    public void setMyAlbum(List<Song> myAlbum) {
        this.myAlbum = myAlbum;
    }

    public int getPlayingCount() {
        return playingCount;
    }

    public void setPlayingCount(int playingCount) {
        this.playingCount = playingCount;
    }

    public void inputSong() {
        this.singerId = getIdSinger();
        System.out.println("Mời bạn nhập tên bài hát");
        while (true) {
            this.songName = InputMethods.getString();
            if (songList.stream().noneMatch(t -> t.songName.equals(this.songName))) {
                break;
            } else {
                System.err.println("bài hát đã tồn tại");
            }
        }
        System.out.println("Mời bạn nhập mô tả bài hát");
        this.description = InputMethods.getString();
        System.out.println("Mời bạn nhập source bài hát");
        this.sourceSong = InputMethods.getString();
        System.out.println("Mời bạn nhập giá bài hát");
        this.price = InputMethods.getDouble();
        System.out.println("Mời bạn nhập mã album bài hát");
        this.albumId = getIdAlbum();
        System.out.println("Mời bạn nhập hình ảnh bài hát");
        this.image = InputMethods.getString();
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }

    public int getIdSinger() {
//        singerList = IOFile.readFromFile(IOFile.SINGERS_PATH);

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

    public int getIdAlbum() {
        albumList = IOFile.readFromFile(IOFile.ALBUM_PATH);
        // hiển thị danh sách album
        System.out.println("Danh sách album");
        for (int i = 0; i < albumList.size(); i++) {
            System.out.printf("| STT : %d | Tên album: %-15s |\n", i + 1, albumList.get(i).getName());
        }
        while (true) {
            System.out.println("Nhập vào vị trí album (theo STT)");
            int index = InputMethods.getInteger();
            if (index >= 1 && index <= albumList.size()) {
                Album album1 = albumList.get(index - 1);
                return album1.getId();
            }
            System.err.println("Vị trí không hợp lệ, vui lòng chọn lại");
        }
    }

    public void displaySong() {
        System.out.println("Song{" +
                "songId=" + songId +
                ", singerId=" + singerId +
                ", songName='" + songName + '\'' +
                ", description='" + description + '\'' +
                ", sourceSong='" + sourceSong + '\'' +
                ", price=" + price +
                ", albumId=" + albumId +
                ", image='" + image + '\'' +
                ", createdAt='" + createdAt.format(ShopConfig.DTF) + '\'' +
                ", updatedAt='" + updatedAt.format(ShopConfig.DTF) + '\'' +
                ", playingCount=" + playingCount +
                '}');
    }
}
