package game;

import java.util.*;

public class QuestionsBank {
    public static List<Question[]> questions() {
        // level 1 questions
        int scoreLevel1 = 2;
        int level1 = 1;
        // 1st question
        String question1 = "What is the capital of Germany?";
        Answer [] answers1 = new Answer [4];
        answers1[0] = new Answer("Bonn", false, 24);
        answers1[1] = new Answer("Bremen", false, 22);
        answers1[2] = new Answer("Berlin", true, 36);
        answers1[3] = new Answer("Oslo", false, 18);
        // 2nd question
        String question2 = "In which country is Amsterdam situated?";
        Answer [] answers2 = new Answer [4];
        answers2[0] = new Answer("The Netherlands", true, 35);
        answers2[1] = new Answer("Norway", false, 25);
        answers2[2] = new Answer("France", false, 21);
        answers2[3] = new Answer("Sweden", false, 19);
        // 3rd question
        String question3 = "What is the capital of England?";
        Answer [] answers3 = new Answer [4];
        answers3[0] = new Answer("London", true, 37);
        answers3[1] = new Answer("New York", false, 20);
        answers3[2] = new Answer("Edinburgh", false, 24);
        answers3[3] = new Answer("Stockholm", false, 19);
        // creating level 1 questions
        Question q1L1 = new Question(question1, answers1, scoreLevel1, level1);
        Question q2L1 = new Question(question2, answers2, scoreLevel1, level1);
        Question q3L1 = new Question(question3, answers3, scoreLevel1, level1);
        // array of level 1 questions
        Question [] questionsLevel1 = new Question [3];
        questionsLevel1[0] = q1L1;
        questionsLevel1[1] = q2L1;
        questionsLevel1[2] = q3L1;

        // level 2 questions
        int scoreLevel2 = 4;
        int level2 = 2;
        // 1st question
        String question4 = "How many official languages does Switzerland have?";
        Answer [] answers4 = new Answer [4];
        answers4[0] = new Answer("1", false, 19);
        answers4[1] = new Answer("3", false, 25);
        answers4[2] = new Answer("4", true, 36);
        answers4[3] = new Answer("2", false, 20);
        // 2nd question
        String question5 = "In which year did WW2 end?";
        Answer [] answers5 = new Answer [4];
        answers5[0] = new Answer("1944", false, 24);
        answers5[1] = new Answer("1945", true, 37);
        answers5[2] = new Answer("1946", false, 20);
        answers5[3] = new Answer("1947", false, 19);
        // 3rd question
        String question6 = "In which year did WW2 start?";
        Answer [] answers6 = new Answer [4];
        answers6[0] = new Answer("1939", true, 36);
        answers6[1] = new Answer("1940", false, 26);
        answers6[2] = new Answer("1938", false, 18);
        answers6[3] = new Answer("1941", false, 20);
        // creating level 2 questions
        Question q1L2 = new Question(question4, answers4, scoreLevel2, level2);
        Question q2L2 = new Question(question5, answers5, scoreLevel2, level2);
        Question q3L2 = new Question(question6, answers6, scoreLevel2, level2);
        // array of level 2 questions
        Question [] questionsLevel2 = new Question [3];
        questionsLevel2[0] = q1L2;
        questionsLevel2[1] = q2L2;
        questionsLevel2[2] = q3L2;

        // level 3 questions
        int scoreLevel3 = 6;
        int level3 = 3;
        // 1st question
        String question7 = "In which year did WW1 start?";
        Answer [] answers7 = new Answer [4];
        answers7[0] = new Answer("1912", false, 25);
        answers7[1] = new Answer("1913", false, 21);
        answers7[2] = new Answer("1915", false, 18);
        answers7[3] = new Answer("1914", true, 36);
        // 2nd question
        String question8 = "In which year did WW1 end?";
        Answer [] answers8 = new Answer [4];
        answers8[0] = new Answer("1917", false, 26);
        answers8[1] = new Answer("1918", true, 35);
        answers8[2] = new Answer("1920", false, 20);
        answers8[3] = new Answer("1919", false, 19);
        // 3rd question
        String question9 = "In which year did America gain independence?";
        Answer [] answers9 = new Answer [4];
        answers9[0] = new Answer("1775", false, 25);
        answers9[1] = new Answer("1778", false, 20);
        answers9[2] = new Answer("1776", true, 36);
        answers9[3] = new Answer("1774", false, 19);
        // creating level 3 questions
        Question q1L3 = new Question(question7, answers7, scoreLevel3, level3);
        Question q2L3 = new Question(question8, answers8, scoreLevel3, level3);
        Question q3L3 = new Question(question9, answers9, scoreLevel3, level3);
        // array of level 3 questions
        Question [] questionsLevel3 = new Question [3];
        questionsLevel3[0] = q1L3;
        questionsLevel3[1] = q2L3;
        questionsLevel3[2] = q3L3;

        // level 4 questions
        int scoreLevel4 = 8;
        int level4 = 4;
        // 1st question
        String question10 = "In which year did Ireland gain independence?";
        Answer [] answers10 = new Answer [4];
        answers10[0] = new Answer("1921", true, 35);
        answers10[1] = new Answer("1920", false, 26);
        answers10[2] = new Answer("1922", false, 19);
        answers10[3] = new Answer("1919", false, 20);
        // 2nd question
        String question11 = "Which of the following languages is not of the Indo-european origin?";
        Answer [] answers11 = new Answer [4];
        answers11[0] = new Answer("English", false, 20);
        answers11[1] = new Answer("Italian", false, 25);
        answers11[2] = new Answer("German", false, 19);
        answers11[3] = new Answer("Hungarian", true, 36);
        // 3rd question
        String question12 = "In which year was Beethoven born?";
        Answer [] answers12 = new Answer [4];
        answers12[0] = new Answer("1771", false, 25);
        answers12[1] = new Answer("1770", true, 36);
        answers12[2] = new Answer("1773", false, 19);
        answers12[3] = new Answer("1772", false, 20);
        // creating level 4 questions
        Question q1L4 = new Question(question10, answers10, scoreLevel4, level4);
        Question q2L4 = new Question(question11, answers11, scoreLevel4, level4);
        Question q3L4 = new Question(question12, answers12, scoreLevel4, level4);
        // array of level 4 questions
        Question [] questionsLevel4 = new Question [3];
        questionsLevel4[0] = q1L4;
        questionsLevel4[1] = q2L4;
        questionsLevel4[2] = q3L4;

        // level 5 questions
        int scoreLevel5 = 10;
        int level5 = 5;
        // 1st question
        String question13 = "Which city is the capital of Liechtenstein?";
        Answer [] answers13 = new Answer [4];
        answers13[0] = new Answer("Bern", false, 20);
        answers13[1] = new Answer("Salzburg", false, 19);
        answers13[2] = new Answer("Vaduz", true, 35);
        answers13[3] = new Answer("Triesen", false, 26);
        // 2nd question
        String question14 = "In which year Edward VII became king of UK?";
        Answer [] answers14 = new Answer [4];
        answers14[0] = new  Answer("1900", false, 25);
        answers14[1] = new Answer("1901", true, 36);
        answers14[2] = new Answer("1903", false, 19);
        answers14[3] = new Answer("1902", false, 20);
        // 3rd question
        String question15 = "In which year Harald V became king of Norway?";
        Answer [] answers15 = new Answer [4];
        answers15[0] = new Answer("1992", false, 25);
        answers15[1] = new Answer("1990", false, 20);
        answers15[2] = new Answer("1991", true, 36);
        answers15[3] = new Answer("1989", false, 19);
        // creating level 5 questions
        Question q1L5 = new Question(question13, answers13, scoreLevel5, level5);
        Question q2L5 = new Question(question14, answers14, scoreLevel5, level5);
        Question q3L5 = new Question(question15, answers15, scoreLevel5, level5);
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
