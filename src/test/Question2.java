package test;

import java.io.*;
import java.util.*;

/**
 * 有文本文件text.txt，文件中每一行代表一行文本内容，现需要统计某词列表keyword.lst中的词的命中次数（即一行文本中包含该词），除此之外，需对每个词所命中的文本进行保存，命中次数大于100的保留100条，对命中次数小于100的保留全部文本。（25）
 * 示例：
 * <p>
 * 输入：
 * text.txt：
 * hello world, Java
 * Have a good day
 * Nice to meet you
 * hello world, C++
 * <p>
 * keyword.lst：
 * hello
 * world
 * day
 * <p>
 * <p>
 * 输出：
 * <p>
 * 统计：
 * hello: 2
 * world: 2
 * day: 1
 * <p>
 * 文本详情：
 * hello:
 * hello world, Java
 * hello world, C++
 * world:
 * hello world, Java
 * hello world, C++
 * day:
 * Have a good day
 */
public class Question2 {

    public static void main(String[] args) throws IOException {

        List<String> words = readWords("F:/text.txt");
        List<String> keyword = Arrays.asList("hello", "world", "day");
        Map<String, HashSet<String>> map = countAWord(words, keyword);
        writeWords("F:/hit.txt", map);
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + ": " + map.get(key).size());
        }
    }

    private static void writeWords(String path, Map<String, HashSet<String>> map) throws IOException {

        ArrayList<String> words = new ArrayList<>();

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(path))));
        String line = null;
        Set<String> keys = map.keySet();
        for (String key : keys) {
            writer.write(key);
            writer.newLine();
            HashSet<String> sets = map.get(key);
            int i = 0;
            for (String set : sets) {
                writer.write(set);
                writer.newLine();
                i++;
                if(i == 100){
                    break;
                }
            }
            writer.flush();
        }
        writer.close();
    }

    public static List<String> readWords(String path) throws IOException {

        File file = new File(path);
        ArrayList<String> words = new ArrayList<>();
        if (file.isFile() && file.exists()) {

            BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line = null;
            while ((line = read.readLine()) != null) {
                words.add(line.toString());
            }
            read.close();
        }
        return words;
    }


    public static Map<String, HashSet<String>> countAWord(List<String> words, List<String> keywords) {
        Map<String, HashSet<String>> map = new HashMap();
        for (String keyword : keywords) {
            HashSet<String> list = new HashSet<>();
            for (String word : words) {
                String[] str = word.replace(",", "").split(" ");
                for (int i = 0; i < str.length; i++) {
                    if (keyword.equals(str[i])) {
                        list.add(word);
                    }
                }
            }
            map.put(keyword, list);
        }

        return map;
    }

}
