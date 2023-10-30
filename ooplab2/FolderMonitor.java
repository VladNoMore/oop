import java.util.Date;
import java.util.HashMap;

public class FolderMonitor {
    private Date snapshotTime;
    private HashMap<String, FileBase> files;

    public FolderMonitor() {
        snapshotTime = null;
        files = new HashMap<>();
    }

    public void commit() {
        snapshotTime = new Date();
        for (FileBase file : files.values()) {
            file.updateSnapshot();
        }
    }

    public void addFile(String filename) {
        String extension = filename.substring(filename.lastIndexOf("."));
        switch (extension) {
            case ".txt":
                files.put(filename, new TextFile());
                break;
            case ".png":
            case ".jpg":
                files.put(filename, new ImageFile());
                break;
            case ".py":
            case ".java":
                files.put(filename, new ProgramFile());
                break;
            default:
                files.put(filename, new FileBase());
                break;
        }
        files.get(filename).createdTime = new Date();
    }

    public void status() {
        if (snapshotTime == null) {
            System.out.println("No snapshot taken yet.");
            return;
        }

        System.out.println("Snapshot taken at: " + snapshotTime);
        for (String filename : files.keySet()) {
            FileBase file = files.get(filename);
            String status;
            if (file.updatedTime == null) {
                status = "No Change";
            } else if (file.createdTime.compareTo(file.updatedTime) <= 0
                    && file.updatedTime.compareTo(snapshotTime) <= 0) {
                status = "No Change";
            } else {
                status = "Changed";
            }
            System.out.println(filename + " - " + status);
        }
    }

    public void info(String filename) {
        FileBase file = files.get(filename);
        if (file != null) {
            file.info();
        } else {
            System.out.println("File '" + filename + "' not found in the monitored folder.");
        }
    }
}
