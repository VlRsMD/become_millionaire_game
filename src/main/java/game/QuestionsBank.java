package game;

import java.util.*;

public class QuestionsBank {
    public List<Question> createQuestions() {
        // level 1 questions
        int scoreLevel1 = 2;
        int level1 = 1;
        // 1st question
        String question1 = "What is the capital of Germany?";
        Answer [] answers1 = new Answer [4];
        answers1[0] = new Answer("Bonn", false);
        answers1[1] = new Answer("Bremen", false);
        answers1[2] = new Answer("Berlin", true);
        answers1[3] = new Answer("Oslo", false);
        // 2nd question
        String question2 = "In which country is Amsterdam situated?";
        Answer [] answers2 = new Answer [4];
        answers2[0] = new Answer("The Netherlands", true);
        answers2[1] = new Answer("Norway", false);
        answers2[2] = new Answer("France", false);
        answers2[3] = new Answer("Sweden", false);
        // 3rd question
        String question3 = "What is the capital of England?";
        Answer [] answers3 = new Answer [4];
        answers3[0] = new Answer("London", true);
        answers3[1] = new Answer("New York", false);
        answers3[2] = new Answer("Edinburgh", false);
        answers3[3] = new Answer("Stockholm", false);
        // creating level 1 questions
        Question q1L1 = new Question(question1, answers1, scoreLevel1, level1);
        Question q2L1 = new Question(question2, answers2, scoreLevel1, level1);
        Question q3L1 = new Question(question3, answers3, scoreLevel1, level1);

        // level 2 questions
        int scoreLevel2 = 4;
        int level2 = 2;
        // 1st question
        String question4 = "How many official languages does Switzerland have?";
        Answer [] answers4 = new Answer [4];
        answers4[0] = new Answer("1", false);
        answers4[1] = new Answer("3", false);
        answers4[2] = new Answer("4", true);
        answers4[3] = new Answer("2", false);
        // 2nd question
        String question5 = "In which year did WW2 end?";
        Answer [] answers5 = new Answer [4];
        answers5[0] = new Answer("1944", false);
        answers5[1] = new Answer("1945", true);
        answers5[2] = new Answer("1946", false);
        answers5[3] = new Answer("1947", false);
        // 3rd question
        String question6 = "In which year did WW2 start?";
        Answer [] answers6 = new Answer [4];
        answers6[0] = new Answer("1939", true);
        answers6[1] = new Answer("1940", false);
        answers6[2] = new Answer("1938", false);
        answers6[3] = new Answer("1941", false);
        // creating level 2 questions
        Question q1L2 = new Question(question4, answers4, scoreLevel2, level2);
        Question q2L2 = new Question(question5, answers5, scoreLevel2, level2);
        Question q3L2 = new Question(question6, answers6, scoreLevel2, level2);

        // level 3 questions
        int scoreLevel3 = 6;
        int level3 = 3;
        // 1st question
        String question7 = "In which year did WW1 start?";
        Answer [] answers7 = new Answer [4];
        answers7[0] = new Answer("1912", false);
        answers7[1] = new Answer("1913", false);
        answers7[2] = new Answer("1915", false);
        answers7[3] = new Answer("1914", true);
        // 2nd question
        String question8 = "In which year did WW1 end?";
        Answer [] answers8 = new Answer [4];
        answers8[0] = new Answer("1917", false);
        answers8[1] = new Answer("1918", true);
        answers8[2] = new Answer("1920", false);
        answers8[3] = new Answer("1919", false);
        // 3rd question
        String question9 = "In which year did America gain independence?";
        Answer [] answers9 = new Answer [4];
        answers9[0] = new Answer("1775", false);
        answers9[1] = new Answer("1778", false);
        answers9[2] = new Answer("1776", true);
        answers9[3] = new Answer("1774", false);
        // creating level 3 questions
        Question q1L3 = new Question(question7, answers7, scoreLevel3, level3);
        Question q2L3 = new Question(question8, answers8, scoreLevel3, level3);
        Question q3L3 = new Question(question9, answers9, scoreLevel3, level3);

        // level 4 questions
        int scoreLevel4 = 8;
        int level4 = 4;
        // 1st question
        String question10 = "In which year did Ireland gain independence?";
        Answer [] answers10 = new Answer [4];
        answers10[0] = new Answer("1921", true);
        answers10[1] = new Answer("1920", false);
        answers10[2] = new Answer("1922", false);
        answers10[3] = new Answer("1919", false);
        // 2nd question
        String question11 = "Which of the following languages is not of the Indo-european origin?";
        Answer [] answers11 = new Answer [4];
        answers11[0] = new Answer("English", false);
        answers11[1] = new Answer("Italian", false);
        answers11[2] = new Answer("German", false);
        answers11[3] = new Answer("Hungarian", true);
        // 3rd question
        String question12 = "In which year was Beethoven born?";
        Answer [] answers12 = new Answer [4];
        answers12[0] = new Answer("1771", false);
        answers12[1] = new Answer("1770", true);
        answers12[2] = new Answer("1773", false);
        answers12[3] = new Answer("1772", false);
        // creating level 4 questions
        Question q1L4 = new Question(question10, answers10, scoreLevel4, level4);
        Question q2L4 = new Question(question11, answers11, scoreLevel4, level4);
        Question q3L4 = new Question(question12, answers12, scoreLevel4, level4);

        // level 5 questions
        int scoreLevel5 = 10;
        int level5 = 5;
        // 1st question
        String question13 = "Which city is the capital of Liechtenstein?";
        Answer [] answers13 = new Answer [4];
        answers13[0] = new Answer("Bern", false);
        answers13[1] = new Answer("Salzburg", false);
        answers13[2] = new Answer("Vaduz", true);
        answers13[3] = new Answer("Triesen", false);
        // 2nd question
        String question14 = "In which year Edward VII became king of UK?";
        Answer [] answers14 = new Answer [4];
        answers14[0] = new  Answer("1900", false);
        answers14[1] = new Answer("1901", true);
        answers14[2] = new Answer("1903", false);
        answers14[3] = new Answer("1902", false);
        // 3rd question
        String question15 = "In which year Harald V became king of Norway?";
        Answer [] answers15 = new Answer [4];
        answers15[0] = new Answer("1992", false);
        answers15[1] = new Answer("1990", false);
        answers15[2] = new Answer("1991", true);
        answers15[3] = new Answer("1989", false);
        // creating level 5 createQuestions
        Question q1L5 = new Question(question13, answers13, scoreLevel5, level5);
        Question q2L5 = new Question(question14, answers14, scoreLevel5, level5);
        Question q3L5 = new Question(question15, answers15, scoreLevel5, level5);
        // array of level 5 questions
        Question [] questionsLevel5 = new Question [3];
        questionsLevel5[0] = q1L5;
        questionsLevel5[1] = q2L5;
        questionsLevel5[2] = q3L5;

        // adding all the questions to the list
        List<Question> list = new ArrayList<Question>();
        list.add(q1L1);
        list.add(q2L1);
        list.add(q3L1);
        list.add(q1L2);
        list.add(q2L2);
        list.add(q3L2);
        list.add(q1L3);
        list.add(q2L3);
        list.add(q3L3);
        list.add(q1L4);
        list.add(q2L4);
        list.add(q3L4);
        list.add(q1L5);
        list.add(q2L5);
        list.add(q3L5);


        return list;
    }

    public int getNumberOfLevels() {
        return 5;
    }
}
