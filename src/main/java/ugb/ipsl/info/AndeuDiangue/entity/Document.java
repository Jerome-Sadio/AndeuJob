package ugb.ipsl.info.AndeuDiangue.entity;

public class Document {
    String DriverLink;

    public Document(String driverLink) {
        DriverLink = driverLink;
    }

    public String getDriverLink() {
        return DriverLink;
    }

    public void setDriverLink(String driverLink) {
        DriverLink = driverLink;
    }

    @Override
    public String toString() {
        return "Document{" +
                "DriverLink='" + DriverLink + '\'' +
                '}';
    }
}
