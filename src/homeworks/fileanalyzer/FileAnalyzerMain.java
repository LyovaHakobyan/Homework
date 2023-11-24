package homeworks.fileanalyzer;


public class FileAnalyzerMain {
    public static void main(String[] args) {
        System.out.println(FileAnalyzer.wordMap("C:\\Users\\Dell\\IdeaProjects\\Homework\\src\\homeworks\\fileanalyzer\\file.txt"));
        System.out.println(FileAnalyzer.totalWordCount("C:\\Users\\Dell\\IdeaProjects\\Homework\\src\\homeworks\\fileanalyzer\\file.txt"));
        System.out.println(FileAnalyzer.uniqueWordCount("C:\\Users\\Dell\\IdeaProjects\\Homework\\src\\homeworks\\fileanalyzer\\file.txt"));
        System.out.println(FileAnalyzer.topFrequentWords("C:\\Users\\Dell\\IdeaProjects\\Homework\\src\\homeworks\\fileanalyzer\\file.txt", 3));
        System.out.println(FileAnalyzer.countWordOccurrences("C:\\Users\\Dell\\IdeaProjects\\Homework\\src\\homeworks\\fileanalyzer\\file.txt", "Ipsum"));
    }
}
