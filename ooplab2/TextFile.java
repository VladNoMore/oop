public class TextFile extends FileBase {
    private int lineCount;
    private int wordCount;
    private int charCount;

    public void info() {
        super.info();
        System.out.println("Line count: " + lineCount + ", Word count: " + wordCount + ", Character count: " + charCount);
    }
}
