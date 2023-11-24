package homeworks.fileanalyzer;

import java.io.*;
import java.util.*;

public class FileAnalyzer {
    // Читаем файл, составляем мапу слово-количество и возвращаем ее
    public static Map<String, Integer> wordMap(String path) {
        Map<String, Integer> wordCount = new HashMap<>();
        File file = new File(path);
        if (file.isFile()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String line;
                String[] words;
                while ((line = bufferedReader.readLine()) != null) {
                    words = line.split(" ");
                    for (String word : words) {
                        word = word.replaceAll("[^a-zA-Zа-яА-Я]", "");
                        Integer integer = wordCount.get(word);
                        int count;
                        if (integer == null) {
                            count = 1;
                        } else {
                            count = integer + 1;
                        }
                        wordCount.put(word, count);
                    }
                }
                return wordCount;
            } catch (IOException e) {
                System.out.println("Exception " + e);
            }
        }
        return null;
    }

    // Читаем файл, подсчитываем общее количество слов
    public static int totalWordCount(String path) {
        File file = new File(path);
        int wordCount = 0;
        if (file.isFile()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String line;
                String[] words;
                while ((line = bufferedReader.readLine()) != null) {
                    words = line.split(" ");
                    wordCount += words.length;
                }
                return wordCount;
            } catch (IOException e) {
                System.out.println("Exception " + e);
            }
        }
        return 0;
    }

    // Читаем файл, подсчитываем количество уникальных слов
    public static int uniqueWordCount(String path) {
        File file = new File(path);
        List<String> allWords = new ArrayList<>();
        int uniqueWordCount = 0;
        if (file.isFile()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String line;
                String[] words;
                while ((line = bufferedReader.readLine()) != null) {
                    words = line.split(" ");
                    for (String word : words) {
                        word = word.replaceAll("[^a-zA-Zа-яА-Я]", "");
                        allWords.add(word);
                    }
                }
                for (String word : allWords) {
                    if (allWords.indexOf(word) == allWords.lastIndexOf(word)) {
                        uniqueWordCount++;
                    }
                }
                return uniqueWordCount;
            } catch (IOException e) {
                System.out.println("Exception " + e);
            }
        }
        return 0;
    }

    // Читаем файл, находим топ-N часто встречающихся слов
    public static Map<String, Integer> topFrequentWords(String path, int n) {
        Map<String, Integer> wordsWithCount = new LinkedHashMap<>();
        File file = new File(path);
        if (file.isFile()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String line;
                String[] words;
                int wordCount;
                while ((line = bufferedReader.readLine()) != null) {
                    words = line.split(" ");
                    for (String word : words) {
                        word = word.replaceAll("[^a-zA-Zа-яА-Я]", "");
                        Integer count = wordsWithCount.get(word);
                        if (count == null) {
                            wordCount = 1;
                        } else {
                            wordCount = count + 1;
                        }
                        wordsWithCount.put(word, wordCount);
                    }
                }
                List<Map.Entry<String, Integer>> allWords = new ArrayList<>(wordsWithCount.entrySet());
                allWords.sort(new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        return o2.getValue() - o1.getValue();
                    }
                });
                wordsWithCount.clear();
                for (int i = 0; i < n; i++) {
                    wordsWithCount.put(allWords.get(i).getKey(), allWords.get(i).getValue());
                }
                return wordsWithCount;
            } catch (IOException e) {
                System.out.println("Exception " + e);
            }
        }
        return null;
    }

    // Читаем файл, находим количество вхождений слова и возвращаем это число
    public static int countWordOccurrences(String path, String word) {
        File file = new File(path);
        int occurrenceCount = 0;
        if (file.isFile()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String line;
                String[] words;
                while ((line = bufferedReader.readLine()) != null) {
                    words = line.split(" ");
                    for (String s : words) {
                        s = s.replaceAll("[^a-zA-Zа-яА-Я]", "");
                        if (s.equals(word)) {
                            occurrenceCount++;
                        }
                    }
                }
                return occurrenceCount;
            } catch (IOException e) {
                System.out.println("Exception " + e);
            }
        }
        return 0;
    }
}
