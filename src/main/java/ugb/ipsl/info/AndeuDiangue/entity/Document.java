package ugb.ipsl.info.AndeuDiangue.entity;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Document {

    private int id;
    private String title;
    private String DriverLink;

    public Document(String title, String driverLink) {
        this.title = title;
        this.DriverLink = driverLink;
    }
}
