package game;

import java.util.*;

public class QuestionsBank {
    public static List<Question[]> questions() {
        // level 1 questions
        int scoreLevel1 = 2;
        // 1st question
        String question_1 = "What is the capital of Germany?";
        Answer [] answers_1 = new Answer [4];
        answers_1[0] = new Answer("Bonn", false, 24);
        answers_1[1] = new Answer("Bremen", false, 22);
        answers_1[2] = new Answer("Berlin", true, 36);
        answers_1[3] = new Answer("Oslo", false, 18);
        // 2nd question
        String question_2 = "In which country is Amsterdam situated?";
        Answer [] answers_2 = new Answer [4];
        answers_2[0] = new Answer("The Netherlands", true, 35);
        answers_2[1] = new Answer("Norway", false, 25);
        answers_2[2] = new Answer("France", false, 21);
        answers_2[3] = new Answer("Sweden", false, 19);
        // 3rd question
        String question_3 = "What is the capital of England?";
        Answer [] answers_3 = new Answer [4];
        answers_3[0] = new Answer("London", true, 37);
        answers_3[1] = new Answer("New York", false, 20);
        answers_3[2] = new Answer("Edinburgh", false, 24);
        answers_3[3] = new Answer("Stockholm", false, 19);
        // creating level 1 questions
        Question q1L1 = new Question(question_1, answers_1, scoreLevel1);
        Question q2L1 = new Question(question_2, answers_2, scoreLevel1);
        Question q3L1 = new Question(question_3, answers_3, scoreLevel1);
        // array of level 1 questions
        Question [] questionsLevel1 = new Question [3];
        questionsLevel1[0] = q1L1;
        questionsLevel1[1] = q2L1;
        questionsLevel1[2] = q3L1;

        // level 2 questions
        int scoreLevel2 = 4;
        // 1st question
        String question_4 = "How many official languages does Switzerland have?";
        Answer [] answers_4 = new Answer [4];
        answers_4[0] = new Answer("1", false, 19);
        answers_4[1] = new Answer("3", false, 25);
        answers_4[2] = new Answer("4", true, 36);
        answers_4[3] = new Answer("2", false, 20);
        // 2nd question
        String question_5 = "In which year did WW2 end?";
        Answer [] answers_5 = new Answer [4];
        answers_5[0] = new Answer("1944", false, 24);
        answers_5[1] = new Answer("1945", true, 37);
        answers_5[2] = new Answer("1946", false, 20);
        answers_5[3] = new Answer("1947", false, 19);
        // 3rd question
        String question_6 = "In which year did WW2 start?";
        Answer [] answers_6 = new Answer [4];
        answers_6[0] = new Answer("1939", true, 36);
        answers_6[1] = new Answer("1940", false, 26);
        answers_6[2] = new Answer("1938", false, 18);
        answers_6[3] = new Answer("1941", false, 20);
        // creating level 2 questions
        Question q1L2 = new Question(question_4, answers_4, scoreLevel2);
        Question q2L2 = new Question(question_5, answers_5, scoreLevel2);
        Question q3L2 = new Question(question_6, answers_6, scoreLevel2);
        // array of level 2 questions
        Question [] questionsLevel2 = new Question [3];
        questionsLevel2[0] = q1L2;
        questionsLevel2[1] = q2L2;
        questionsLevel2[2] = q3L2;

        // level 3 questions
        int scoreLevel3 = 6;
        // 1st question
        String question_7 = "In which year did WW1 start?";
        Answer [] answers_7 = new Answer [4];
        answers_7[0] = new Answer("1912", false, 25);
        answers_7[1] = new Answer("1913", false, 21);
        answers_7[2] = new Answer("1915", false, 18);
        answers_7[3] = new Answer("1914", true, 36);
        // 2nd question
        String question_8 = "In which year did WW1 end?";
        Answer [] answers_8 = new Answer [4];
        answers_8[0] = new Answer("1917", false, 26);
        answers_8[1] = new Answer("1918", true, 35);
        answers_8[2] = new Answer("1920", false, 20);
        answers_8[3] = new Answer("1919", false, 19);
        // 3rd question
        String question_9 = "In which year did America gain independence?";
        Answer [] answers_9 = new Answer [4];
        answers_9[0] = new Answer("1775", false, 25);
        answers_9[1] = new Answer("1778", false, 20);
        answers_9[2] = new Answer("1776", true, 36);
        answers_9[3] = new Answer("1774", false, 19);
        // creating level 3 questions
        Question q1L3 = new Question(question_7, answers_7, scoreLevel3);
        Question q2L3 = new Question(question_8, answers_8, scoreLevel3);
        Question q3L3 = new Question(question_9, answers_9, scoreLevel3);
        // array of level 3 questions
        Question [] questionsLevel3 = new Question [3];
        questionsLevel3[0] = q1L3;
        questionsLevel3[1] = q2L3;
        questionsLevel3[2] = q3L3;

        // level 4 questions
        int scoreLevel4 = 8;
        // 1st question
        String question_10 = "In which year did Ireland gain independence?";
        Answer [] answers_10 = new Answer [4];
        answers_10[0] = new Answer("1921", true, 35);
        answers_10[1] = new Answer("1920", false, 26);
        answers_10[2] = new Answer("1922", false, 19);
        answers_10[3] = new Answer("1919", false, 20);
        // 2nd question
        String question_11 = "Which of the following languages is not of the Indo-european origin?";
        Answer [] answers_11 = new Answer [4];
        answers_11[0] = new Answer("English", false, 20);
        answers_11[1] = new Answer("Italian", false, 25);
        answers_11[2] = new Answer("German", false, 19);
        answers_11[3] = new Answer("Hungarian", true, 36);
        // 3rd question
        String question_12 = "In which year was Beethoven born?";
        Answer [] answers_12 = new Answer [4];
        answers_12[0] = new Answer("1771", false, 25);
        answers_12[1] = new Answer("1770", true, 36);
        answers_12[2] = new Answer("1773", false, 19);
        answers_12[3] = new Answer("1772", false, 20);
        // creating level 4 questions
        Question q1L4 = new Question(question_10, answers_10, scoreLevel4);
        Question q2L4 = new Question(question_11, answers_11, scoreLevel4);
        Question q3L4 = new Question(question_12, answers_12, scoreLevel4);
        // array of level 4 questions
        Question [] questionsLevel4 = new Question [3];
        questionsLevel4[0] = q1L4;
        questionsLevel4[1] = q2L4;
        questionsLevel4[2] = q3L4;

        // level 5 questions
        int scoreLevel5 = 10;
        // 1st question
        String question_13 = "Which city is the capital of Lichtenstein?";
        Answer [] answers_13 = new Answer [4];
        answers_13[0] = new Answer("Bern", false, 20);
        answers_13[1] = new Answer("Salzburg", false, 19);
        answers_13[2] = new Answer("Vaduz", true, 35);
        answers_13[3] = new Answer("Triesen", false, 26);
        // 2nd question
        String question_14 = "In which year Edward VII became king of UK?";
        Answer [] answers_14 = new Answer [4];
        answers_14[0] = new  Answer("1900", false, 25);
        answers_14[1] = new Answer("1901", true, 36);
        answers_14[2] = new Answer("1903", false, 19);
        answers_14[3] = new Answer("1902", false, 20);
        // 3rd question
        String question_15 = "In which year Harald V became king of Norway?";
        Answer [] answers_15 = new Answer [4];
        answers_15[0] = new Answer("1992", false, 25);
        answers_15[1] = new Answer("1990", false, 20);
        answers_15[2] = new Answer("1991", true, 36);
        answers_15[3] = new Answer("1989", false, 19);
        // creating level 5 questions
        Question q1L5 = new Question(question_13, answers_13, scoreLevel5);
        Question q2L5 = new Question(question_14, answers_14, scoreLevel5);
        Question q3L5 = new Question(question_15, answers_15, scoreLevel5);
        // array of level 5 questions
        Question [] questionsLevel5 = new Question [3];
        questionsLevel5[0] = q1L5;
        questionsLevel5[1] = q2L5;
        questionsLevel5[2] = q3L5;

        // list of questions arrays
        List <Question[]> list = new ArrayList<Question[]>();
        list.add(questionsLevel1);
        list.add(questionsLevel2);
        list.add(questionsLevel3);
        list.add(questionsLevel4);
        list.add(questionsLevel5);

        return list;
    }
}
