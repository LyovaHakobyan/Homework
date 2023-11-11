package homeworks.fileutil;

import java.io.*;
import java.util.Scanner;

public class FileUtil {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - path թե որ ֆոլդերում ենք փնտրելու
    // 2 - fileName - ֆայլի անունը, որը փնտրում ենք։
    //Որպես արդյունք պտի ծրագիրը տպի true եթե կա էդ ֆայլը էդ պապկի մեջ, false եթե չկա։
    static void fileSearch() {
        System.out.println("Folder path...");
        String path = scanner.nextLine();
        System.out.println("File name...");
        String fileName = scanner.nextLine();
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File value : files) {
                    if (value.getName().equals(fileName)) {
                        System.out.println("true");
                        return;
                    }
                }
                System.out.println("false");
                return;
            }
        }
        System.out.println("Wrong path of directory");
    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - path թե որ ֆոլդերում ենք փնտրելու
    // 2 - keyword - ինչ որ բառ
    // Մեթոդը պետք է նշված path-ում գտնի բոլոր .txt ֆայլերը, և իրենց մեջ փնտրի
    // մեր տված keyword-ը, եթե գտնի, պետք է տպի տվյալ ֆայլի անունը։

    // --WITH RECURSION--
//    static void contentSearch(String path, String keyword) {
//        File file = new File(path);
//        File[] files = file.listFiles();
//        if (files != null) {
//            for (File value : files) {
//                if (value.isDirectory()) {
//                    contentSearch(value.getAbsolutePath(), keyword);
//                } else {
//                    if (value.canRead() && value.getName().endsWith(".txt")) {
//                        try (BufferedReader br = new BufferedReader(new FileReader(value))) {
//                            String line;
//                            do {
//                                line = br.readLine();
//                                if (line != null && line.contains(keyword)) {
//                                    System.out.println(value.getName());
//                                }
//                            } while (line != null);
//                        } catch (IOException e) {
//                            System.out.println("Exception " + e);
//                        }
//                    }
//                }
//            }
//        }
//    }

    // --WITHOUT RECURSION--
    static void contentSearch() {
        System.out.println("Folder path...");
        String path = scanner.nextLine();
        System.out.println("Keyword...");
        String keyword = scanner.nextLine();
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File value : files) {
                    if (value.getName().endsWith(".txt")) {
                        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(value))) {
                            String text;
                            do {
                                text = bufferedReader.readLine();
                                if (text != null && text.contains(keyword)) {
                                    System.out.println(value.getName());
                                }
                            } while (text != null);
                        } catch (IOException e) {
                            System.out.println("Exception " + e);
                        }
                    }
                }
            }
        } else {
            System.out.println("Wrong path of directory");
        }
    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - txtPath txt ֆայլի փաթը
    // 2 - keyword - ինչ որ բառ
    // տալու ենք txt ֆայլի տեղը, ու ինչ որ բառ, ինքը տպելու է էն տողերը, որտեղ գտնի էդ բառը։
    static void findLines() {
        System.out.println("txtFilePath...");
        String txtPath = scanner.nextLine();
        System.out.println("Keyword...");
        String keyword = scanner.nextLine();
        File file = new File(txtPath);
        if (file.isFile() && file.getName().endsWith(".txt")) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String line;
                int lineNumber = 0;
                do {
                    lineNumber++;
                    line = bufferedReader.readLine();
                    if (line != null && line.contains(keyword)) {
                        System.out.println("The lines having '" + keyword + "' are " + lineNumber);
                    }
                } while (line != null);
            } catch (IOException e) {
                System.out.println("Exception " + e);
            }
        } else {
            System.out.println("Wrong path of file");
        }

    }

    //այս մեթոդը պետք է սքաններով վերցնի մեկ string.
    // 1 - path թե որ ֆոլդերի չափն ենք ուզում հաշվել
    // ֆոլդերի բոլոր ֆայլերի չափսերը գումարում ենք իրար, ու տպում
    static void printSizeOfPackage() {
        System.out.println("Folder path...");
        String path = scanner.nextLine();
        File file = new File(path);
        double size = 0;
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File value : files) {
                    size += value.length();
                }
            }
            if (size == 0) {
                System.out.println("There is not any files in this folder");
            } else {
                System.out.println("The size is " + size + " bytes");
            }
        } else {
            System.out.println("Wrong path of directory");
        }
    }

    //այս մեթոդը պետք է սքաններով վերցնի երեք string.
    // 1 - path պապկի տեղը, թե որտեղ է սարքելու նոր ֆայլը
    // 2 - fileName ֆայլի անունը, թե ինչ անունով ֆայլ է սարքելու
    // 3 - content ֆայլի պարունակությունը։ Այսինքն ստեղծված ֆայլի մեջ ինչ է գրելու
    // որպես արդյունք պապկի մեջ սարքելու է նոր ֆայլ, իրա մեջ էլ լինելու է content-ով տվածը
    static void createFileWithContent() {
        System.out.println("Folder path...");
        String path = scanner.nextLine();
        System.out.println("File name...");
        String fileName = scanner.nextLine();
        System.out.println("Content...");
        String content = scanner.nextLine();
        boolean mkdirs = new File(path).mkdirs();
        File file = new File(path + File.separator + fileName);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(content);
        } catch (IOException e) {
            System.out.println("Exception " + e);
        }
    }

}
