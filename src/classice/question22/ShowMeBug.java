package classice.question22;

import java.util.*;

/**
 * 现在程序中有一组学生成绩数据（getScoreList()返回结果），每条数据为某个学生的某科成绩。学生成绩可能不是4科都有，可能有缺科。要求对这组数据进行数据转换和计算处理，转换成学生记录列表，每条记录里面有4科成绩和总成绩，并在此基础上计算全班的平均成绩。最后用控制台输出即可，要求表格按总成绩从高到低排序。计算平均成绩时，缺课也算人次，结果保留三位小数，输出格式如下。
 * 需要注意的是，最终完成代码的代码质量（逻辑是否清晰，变量/方法命名是否合理等），将作为考察标准的一部分
 * 姓名		数学		语文		英语		物理		总成绩
 * 张三		 		  65	   84	     89	      316
 * 李四		 89		  76				 76		  313
 * …
 * 平均成绩    83.5	 70.5	  78	    82.5	314.5
 */

public class ShowMeBug {
    private double chineseScoreSum;
    private double englishScoreSum;
    private double mathScoreSum;
    private double physicalScoreSum;

    public static void main(String[] args) {
        List<ScoreVo> scoreList = getScoreList();
        ShowMeBug showMeBug = new ShowMeBug();
        HashMap<String, StudentVo> studentMap = generatetudentMap(showMeBug, scoreList);
        printByCountScore(showMeBug, studentMap);
    }

    private static HashMap<String, StudentVo> generatetudentMap(ShowMeBug showMeBug, List<ScoreVo> scoreList) {
        HashMap<String, StudentVo> studentMap = new HashMap<>();
        for (ScoreVo scoreVo : scoreList) {
            if (studentMap.containsKey(scoreVo.studentName)) {
                StudentVo studentVo = studentMap.get(scoreVo.studentName);
                addCourse(showMeBug, scoreVo, studentVo);
            } else {
                StudentVo studentVo = showMeBug.new StudentVo();
                studentVo.setName(scoreVo.studentName);
                addCourse(showMeBug, scoreVo, studentVo);
                studentMap.put(scoreVo.studentName, studentVo);
            }
        }
        return studentMap;
    }

    private static void printByCountScore(ShowMeBug showMeBug, HashMap<String, StudentVo> studentMap) {
        System.out.println("性名\t数学\t语文\t英语\t物理\t总成绩");
        TreeMap<Double, StudentVo> studentWithSortMap = new TreeMap<>(Collections.reverseOrder());
        Double totalScoreSum = 0.0;
        for (String name : studentMap.keySet()) {
            StudentVo studentVo = studentMap.get(name);
            double totalScore = studentVo.getTotalScore();
            totalScoreSum += totalScore;
            studentWithSortMap.put(totalScore, studentVo);
        }

        for (Double totalScore : studentWithSortMap.keySet()) {
            System.out.println(studentWithSortMap.get(totalScore));
        }

        int size = studentMap.size();
        System.out.println("平均成绩\t" + String.format("%.3f", showMeBug.mathScoreSum / size) + "\t" + String.format("%.3f", showMeBug.chineseScoreSum / size) + "\t" +
                String.format("%.3f", showMeBug.englishScoreSum / size )+ "\t" + String.format("%.3f", showMeBug.physicalScoreSum / size) + "\t" +
                String.format("%.3f", totalScoreSum / size));
    }

    private static void addCourse(ShowMeBug showMeBug, ScoreVo scoreVo, StudentVo studentVo) {

        if ("语文".equals(scoreVo.courseName)) {
            studentVo.setChineseScore(scoreVo.score);
            showMeBug.chineseScoreSum += scoreVo.score;
        } else if ("数学".equals(scoreVo.courseName)) {
            studentVo.setMathScore(scoreVo.score);
            showMeBug.mathScoreSum += scoreVo.score;
        } else if ("英语".equals(scoreVo.courseName)) {
            studentVo.setEnglishScore(scoreVo.score);
            showMeBug.englishScoreSum += scoreVo.score;
        } else if ("物理".equals(scoreVo.courseName)) {
            studentVo.setPhysicalScore(scoreVo.score);
            showMeBug.physicalScoreSum += scoreVo.score;
        }
        double totalScore = studentVo.getTotalScore();
        totalScore += scoreVo.score;
        studentVo.setTotalScore(totalScore);
    }

    public static List<ScoreVo> getScoreList() {
        List<ScoreVo> scoreList = new ArrayList<ScoreVo>();
        ShowMeBug showMeBug = new ShowMeBug();
        scoreList.add(showMeBug.new ScoreVo("张三", "语文", 80));
        scoreList.add(showMeBug.new ScoreVo("张三", "物理", 76));
        scoreList.add(showMeBug.new ScoreVo("李四", "语文", 78));
        scoreList.add(showMeBug.new ScoreVo("茅十八", "英语", 65));
        scoreList.add(showMeBug.new ScoreVo("李四", "数学", 88));
        scoreList.add(showMeBug.new ScoreVo("李四", "物理", 87));
        scoreList.add(showMeBug.new ScoreVo("王五", "语文", 67));
        scoreList.add(showMeBug.new ScoreVo("张三", "数学", 76));
        scoreList.add(showMeBug.new ScoreVo("李四", "英语", 89));
        scoreList.add(showMeBug.new ScoreVo("王五", "数学", 65));
        scoreList.add(showMeBug.new ScoreVo("赵六", "物理", 95));
        scoreList.add(showMeBug.new ScoreVo("王五", "英语", 78));
        scoreList.add(showMeBug.new ScoreVo("王五", "物理", 65));
        scoreList.add(showMeBug.new ScoreVo("赵六", "语文", 89));
        scoreList.add(showMeBug.new ScoreVo("赵六", "英语", 87));
        scoreList.add(showMeBug.new ScoreVo("黄七", "语文", 78));
        scoreList.add(showMeBug.new ScoreVo("黄七", "数学", 65));
        scoreList.add(showMeBug.new ScoreVo("刘八", "英语", 87));
        scoreList.add(showMeBug.new ScoreVo("张三", "英语", 56));
        scoreList.add(showMeBug.new ScoreVo("黄七", "物理", 76));
        scoreList.add(showMeBug.new ScoreVo("刘八", "数学", 89));
        scoreList.add(showMeBug.new ScoreVo("黄七", "英语", 98));
        scoreList.add(showMeBug.new ScoreVo("刘八", "语文", 56));
        scoreList.add(showMeBug.new ScoreVo("刘八", "物理", 76));
        scoreList.add(showMeBug.new ScoreVo("钱九", "语文", 88));
        scoreList.add(showMeBug.new ScoreVo("钱九", "数学", 67));
        scoreList.add(showMeBug.new ScoreVo("茅十八", "数学", 43));
        scoreList.add(showMeBug.new ScoreVo("钱九", "英语", 75));
        scoreList.add(showMeBug.new ScoreVo("茅十八", "语文", 45));
        scoreList.add(showMeBug.new ScoreVo("茅十八", "物理", 56));

        return scoreList;

    }

    private class ScoreVo {
        public String studentName;
        public String courseName;
        public double score;

        public ScoreVo(String studentName, String courseName, double score) {
            this.studentName = studentName;
            this.courseName = courseName;
            this.score = score;
        }

        public String toString() {
            return this.studentName + "\t" + this.courseName + "\t" + this.score;
        }
    }

    private class StudentVo {
        private String name;
        private double chineseScore;
        private double mathScore;
        private double englishScore;
        private double physicalScore;
        private double totalScore;

        public StudentVo() {

        }

        @Override
        public String toString() {
            return this.name + "\t" + this.mathScore + "\t" + this.chineseScore + "\t"
                    + this.englishScore + "\t" + this.physicalScore + "\t" + this.totalScore;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getChineseScore() {
            return chineseScore;
        }

        public void setChineseScore(double chineseScore) {
            this.chineseScore = chineseScore;
        }

        public double getMathScore() {
            return mathScore;
        }

        public void setMathScore(double mathScore) {
            this.mathScore = mathScore;
        }

        public double getEnglishScore() {
            return englishScore;
        }

        public void setEnglishScore(double englishScore) {
            this.englishScore = englishScore;
        }

        public double getPhysicalScore() {
            return physicalScore;
        }

        public void setPhysicalScore(double physicalScore) {
            this.physicalScore = physicalScore;
        }

        public double getTotalScore() {
            return totalScore;
        }

        public void setTotalScore(double totalScore) {
            this.totalScore = totalScore;
        }
    }
}
