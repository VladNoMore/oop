public class ImageFile extends FileBase {
    private String imageSize;

    public void info() {
        super.info();
        System.out.println("Image size: " + imageSize);
    }
}
