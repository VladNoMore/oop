public class ProgramFile extends FileBase {
    private int lineCount;
    private int classCount;
    private int methodCount;

    public void info() {
        super.info();
        System.out.println("Line count: " + lineCount + ", Class count: " + classCount + ", Method count: " + methodCount);
    }
}
