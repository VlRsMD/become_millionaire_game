package game;

public class all_questions {
    public static Question [] game_questions() {
        // 1st question
        String question_1 = "What is the capital of Germany?";
        String [] answers_1 = new String [4];
        answers_1[0] = "Bonn";
        answers_1[1] = "Bremen";
        answers_1[2] = "Berlin";
        answers_1[3] = "Oslo";
        int rightOptionInd_1 = 3;
        // 2nd question
        String question_2 = "In which country is Amsterdam situated?";
        String [] answers_2 = new String [4];
        answers_2[0] = "The Netherlands";
        answers_2[1] = "Norway";
        answers_2[2] = "France";
        answers_2[3] = "Sweden";
        int rightOptionInd_2 = 1;
        // 3rd question
        String question_3 = "How many official languages does Switzerland have?";
        String [] answers_3 = new String [4];
        answers_3[0] = "3";
        answers_3[1] = "2";
        answers_3[2] = "1";
        answers_3[3] = "4";
        int rightOptionInd_3 = 4;
        // 4th question
        String question_4 = "In which year the WWI ended?";
        String [] answers_4 = new String [4];
        answers_4[0] = "1916";
        answers_4[1] = "1918";
        answers_4[2] = "1917";
        answers_4[3] = "1919";
        int rightOptionInd_4 = 2;
        // 5th question
        String question_5 = "In which year did WW2 start?";
        String [] answers_5 = new String [4];
        answers_5[0] = "1938";
        answers_5[1] = "1940";
        answers_5[2] = "1939";
        answers_5[3] = "1941";
        int rightOptionInd_5 = 3;
        // 6th question
        String question_6 = "What is the capital of England?";
        String [] answers_6 = new String [4];
        answers_6[0] = "London";
        answers_6[1] = "New York";
        answers_6[2] = "Edinburgh";
        answers_6[3] = "Stockholm";
        int rightOptionInd_6 = 1;
        // 7th question
        String question_7 = "Which language is not of the Indo-european origin?";
        String [] answers_7 = new String [4];
        answers_7[0] = "English";
        answers_7[1] = "German";
        answers_7[2] = "Italian";
        answers_7[3] = "Hungarian";
        int rightOptionInd_7 = 4;
        // 8th question
        String question_8 = "When did WW2 end?";
        String [] answers_8 = new String [4];
        answers_8[0] = "1944";
        answers_8[1] = "1946";
        answers_8[2] = "1947";
        answers_8[3] = "1945";
        int rightOptionInd_8 = 4;
        // 9th question
        String question_9 = "When did Berlin Wall fall?";
        String [] answers_9 = new String [4];
        answers_9[0] = "1990";
        answers_9[1] = "1989";
        answers_9[2] = "1991";
        answers_9[3] = "1992";
        int rightOptionInd_9 = 2;
        // 10th question
        String question_10 = "When did Ireland gain independence?";
        String [] answers_10 = new String [4];
        answers_10[0] = "1921";
        answers_10[1] = "1922";
        answers_10[2] = "1919";
        answers_10[3] = "1920";
        int rightOptionInd_10 = 1;
        // creating questions
        Question q1 = new Question(1, question_1, answers_1, rightOptionInd_1);
        Question q2 = new Question(2, question_2, answers_2, rightOptionInd_2);
        Question q3 = new Question(3, question_3, answers_3, rightOptionInd_3);
        Question q4 = new Question(4, question_4, answers_4, rightOptionInd_4);
        Question q5 = new Question(5, question_5, answers_5, rightOptionInd_5);
        Question q6 = new Question(6, question_6, answers_6, rightOptionInd_6);
        Question q7 = new Question(7, question_7, answers_7, rightOptionInd_7);
        Question q8 = new Question(8, question_8, answers_8, rightOptionInd_8);
        Question q9 = new Question(9, question_9, answers_9, rightOptionInd_9);
        Question q10 = new Question(10, question_10, answers_10, rightOptionInd_10);
        // array of questions
        Question [] questions = new Question [10];
        questions[0] = q1;
        questions[1] = q2;
        questions[2] = q3;
        questions[3] = q4;
        questions[4] = q5;
        questions[5] = q6;
        questions[6] = q7;
        questions[7] = q8;
        questions[8] = q9;
        questions[9] = q10;
        return questions;
    }
}
