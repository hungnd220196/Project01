package ra.projectMD2.business.entity;

import ra.projectMD2.business.utils.InputMethods;

import java.io.Serializable;
import java.util.List;

public class Singer implements Serializable {

    private int singerId;
    private String singerName, description;
    private boolean status = true;

    public Singer() {
    }

    public Singer(int singerId, String singerName, String description, boolean status) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.description = description;
        this.status = status;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public void displaySinger() {
        System.out.println("Singer[" +
                "singerId : " + singerId +
                ", singerName : '" + singerName + '\'' +
                ", description : '" + description + '\'' +
                ", status : " + (status ? "Đang hoạt động" : "Không hoạt động") +
                ']');
        ;
    }

    public void inputData() {
        while (true) {
            System.out.println("Nhập tên ca sĩ");
            this.singerName = InputMethods.getString();
            if (!(this.singerName).isBlank()) {
                break;
            } else {
                System.err.println("Họ và tên không được để trống");
            }
        }
        System.out.println("Nhập mô tả ca sĩ");
        this.description = InputMethods.getString();

    }
}
