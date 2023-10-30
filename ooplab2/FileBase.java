import java.util.Date;

public class FileBase {
    protected String filename;
    protected Date createdTime;
    protected Date updatedTime;

    public void updateSnapshot() {
        updatedTime = new Date();
    }

    public void info() {
        System.out.println(filename + ": Created at " + createdTime + ", Last updated at " + updatedTime);
    }
}
