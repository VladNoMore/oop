import java.util.Scanner;

public class FileMonitor {
    public static void main(String[] args) {
        FolderMonitor folderMonitor = new FolderMonitor();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a command (commit/add/info/status/quit): ");
            String[] command = scanner.nextLine().trim().split(" ");

            if (command[0].equals("commit")) {
                folderMonitor.commit();
                System.out.println("Snapshot has been updated.");
            } else if (command[0].equals("info")) {
                if (command.length == 2) {
                    folderMonitor.info(command[1]);
                } else {
                    System.out.println("Invalid 'info' command. Usage: info <filename>");
                }
            } else if (command[0].equals("status")) {
                folderMonitor.status();
            } else if (command[0].equals("add")) {
                if (command.length == 2) {
                    folderMonitor.addFile(command[1]);
                    System.out.println("File '" + command[1] + "' added to the monitored folder.");
                } else {
                    System.out.println("Invalid 'add' command. Usage: add <filename>");
                }
            } else if (command[0].equals("quit")) {
                break;
            } else {
                System.out.println("Invalid command. Available commands: commit, add, info, status, quit");
            }
        }

        scanner.close();
    }
}