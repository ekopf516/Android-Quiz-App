package com.example.emmakopf.android_mini_app_magneton;

/**
 * Created by EmmaKopf on 9/16/16. Code from Sherriff's github.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyersBriggsQuiz implements Quiz{
    // Types for each question
    private static final int TYPE_EI = 0;
    private static final int TYPE_SN = 1;
    private static final int TYPE_TF = 2;
    private static final int TYPE_JP = 3;

    private int currQuestion;

    // Categories for each answer
    private static final int CATEGORY_A = 0;
    private static final int CATEGORY_B = 1;

    // List containing 70 Myers-Briggs questions
    public List<QuizQuestion> questionList;
    public List<QuizQuestion> getQuestions() {
        return this.questionList;
    }

    public static class Question implements QuizQuestion {
        String questionText;
        Answer answers[];
        int type;

        public Question(String questionText, Answer answers[], int type) {
            this.questionText = questionText;
            this.answers = answers;
            this.type = type;
        }

        public QuizEntity[] getAnswers() {
            return answers;
        }

        public String getText() {
            return questionText;
        }
    }

    public static class Answer implements QuizEntity{
        String answerText;
        int category;

        public Answer(String answerText, int category) {
            this.answerText = answerText;
            this.category = category;
        }

        public String getText() {
            return answerText;
        }
    }

    // Array for tracking quiz results
    private int[] results;

    public MyersBriggsQuiz(int currQuestion) {
        this.currQuestion = currQuestion;
        resetResults();

        // Init list of questions in the C constructor
        questionList = new ArrayList<QuizQuestion>(Arrays.asList(
                new Question(
                        "At a party do you:",
                        new Answer[]{
                                new Answer("Interact with many, including strangers", CATEGORY_A),
                                new Answer("Interact with a few, known to you", CATEGORY_B)
                        },
                        TYPE_EI
                ),
                new Question(
                        "Are you more:",
                        new Answer[]{
                                new Answer("Realistic than speculative", CATEGORY_A),
                                new Answer("Speculative than realistic", CATEGORY_B)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Is it worse to:",
                        new Answer[]{
                                new Answer("Have your \"head in the clouds\"", CATEGORY_A),
                                new Answer("Be \"in a rut\"", CATEGORY_B)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Are you more impressed by:",
                        new Answer[]{
                                new Answer("Principles", CATEGORY_A),
                                new Answer("Emotions", CATEGORY_B)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Are more drawn toward the:",
                        new Answer[]{
                                new Answer("Convincing", CATEGORY_A),
                                new Answer("Touching", CATEGORY_B)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Do you prefer to work:",
                        new Answer[]{
                                new Answer("To deadlines", CATEGORY_A),
                                new Answer("Just \"whenever\"", CATEGORY_B)
                        },
                        TYPE_JP
                ),
                new Question(
                        "Do you tend to choose:",
                        new Answer[]{
                                new Answer("Rather carefully", CATEGORY_A),
                                new Answer("Somewhat impulsively", CATEGORY_B)
                        },
                        TYPE_JP
                ),
                new Question(
                        "At parties do you:",
                        new Answer[]{
                                new Answer("Stay late, with increasing energy", CATEGORY_A),
                                new Answer("Leave early with decreased energy", CATEGORY_B)
                        },
                        TYPE_EI
                ),
                new Question(
                        "Are you more attracted to:",
                        new Answer[]{
                                new Answer("Sensible people", CATEGORY_A),
                                new Answer("Imaginative people", CATEGORY_B)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Are you more interested in:",
                        new Answer[]{
                                new Answer("What is actual", CATEGORY_A),
                                new Answer("What is possible", CATEGORY_B)
                        },
                        TYPE_SN
                ),
                new Question(
                        "In judging others are you more swayed by:",
                        new Answer[]{
                                new Answer("Laws than circumstances", CATEGORY_A),
                                new Answer("Circumstances than laws", CATEGORY_B)
                        },
                        TYPE_TF
                ),
                new Question(
                        "In approaching others is your inclination to be somewhat:",
                        new Answer[]{
                                new Answer("Objective", CATEGORY_A),
                                new Answer("Personal", CATEGORY_B)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Are you more:",
                        new Answer[]{
                                new Answer("Punctual", CATEGORY_A),
                                new Answer("Leisurely", CATEGORY_B)
                        },
                        TYPE_JP
                ),
                new Question(
                        "Does it bother you more having things:",
                        new Answer[]{
                                new Answer("Incomplete", CATEGORY_A),
                                new Answer("Completed", CATEGORY_B)
                        },
                        TYPE_JP
                ),
                new Question(
                        "In your social groups do you:",
                        new Answer[]{
                                new Answer("Keep abreast of others' happenings", CATEGORY_A),
                                new Answer("Get behind on the news", CATEGORY_B)
                        },
                        TYPE_EI
                ),
                new Question(
                        "In doing ordinary things are you more likely to:",
                        new Answer[]{
                                new Answer("Do it the usual way", CATEGORY_A),
                                new Answer("Do it your own way", CATEGORY_B)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Writers should:",
                        new Answer[]{
                                new Answer("\"Say what they mean and mean what they say\"", CATEGORY_A),
                                new Answer("Express things more by use of analogy", CATEGORY_B)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Which appeals to you more:",
                        new Answer[]{
                                new Answer("Consistency of thought", CATEGORY_A),
                                new Answer("Harmonious human relationships", CATEGORY_B)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Are you more comfortable in making:",
                        new Answer[]{
                                new Answer("Logical judgments", CATEGORY_A),
                                new Answer("Value judgments", CATEGORY_B)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Do you want things:",
                        new Answer[]{
                                new Answer("Settled and decided", CATEGORY_A),
                                new Answer("Unsettled and undecided", CATEGORY_B)
                        },
                        TYPE_JP
                ),
                new Question(
                        "Would you say you are more:",
                        new Answer[]{
                                new Answer("Serious and determined", CATEGORY_A),
                                new Answer("Easy-going", CATEGORY_B)
                        },
                        TYPE_JP
                ),
                new Question(
                        "In phoning do you:",
                        new Answer[]{
                                new Answer("Rarely question that it will all be said", CATEGORY_A),
                                new Answer("Rehearse what you'll say", CATEGORY_B)
                        },
                        TYPE_EI
                ),
                new Question(
                        "Facts:",
                        new Answer[]{
                                new Answer("\"Speak for themselves\"", CATEGORY_A),
                                new Answer("Illustrate principles", CATEGORY_B)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Are visionaries:",
                        new Answer[]{
                                new Answer("somewhat annoying", CATEGORY_A),
                                new Answer("rather fascinating", CATEGORY_B)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Are you more often:",
                        new Answer[]{
                                new Answer("a cool-headed person", CATEGORY_A),
                                new Answer("a warm-hearted person", CATEGORY_B)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Is it worse to be:",
                        new Answer[]{
                                new Answer("unjust", CATEGORY_A),
                                new Answer("merciless ", CATEGORY_B)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Should one usually let events occur:",
                        new Answer[]{
                                new Answer("by careful selection and choice", CATEGORY_A),
                                new Answer("randomly and by chance", CATEGORY_B)
                        },
                        TYPE_JP
                ),
                new Question(
                        "Do you feel better about:",
                        new Answer[]{
                                new Answer("having purchased", CATEGORY_A),
                                new Answer("having the option to buy", CATEGORY_B)
                        },
                        TYPE_JP
                ),
                new Question(
                        "In company do you:",
                        new Answer[]{
                                new Answer("initiate conversation", CATEGORY_A),
                                new Answer("wait to be approached", CATEGORY_B)
                        },
                        TYPE_EI
                ),
                new Question(
                        "Common sense is:",
                        new Answer[]{
                                new Answer("rarely questionable", CATEGORY_A),
                                new Answer("frequently questionable", CATEGORY_B)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Children often do not:",
                        new Answer[]{
                                new Answer("make themselves useful enough", CATEGORY_A),
                                new Answer("exercise their fantasy enough", CATEGORY_B)
                        },
                        TYPE_SN
                ),
                new Question(
                        "In making decisions do you feel more comfortable with:",
                        new Answer[]{
                                new Answer("standards", CATEGORY_A),
                                new Answer("feelings", CATEGORY_B)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Are you more:",
                        new Answer[]{
                                new Answer("firm than gentle", CATEGORY_A),
                                new Answer("gentle than firm", CATEGORY_B)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Which is more admirable:",
                        new Answer[]{
                                new Answer("the ability to organize and be methodical", CATEGORY_A),
                                new Answer("the ability to adapt and make do", CATEGORY_B)
                        },
                        TYPE_JP
                ),
                new Question(
                        "Do you put more value on:",
                        new Answer[]{
                                new Answer("infinite", CATEGORY_A),
                                new Answer("open-minded", CATEGORY_B)
                        },
                        TYPE_JP
                ),
                new Question(
                        "Does new and non-routine interaction with others:",
                        new Answer[]{
                                new Answer("stimulate and energize you", CATEGORY_A),
                                new Answer("tax your reserves", CATEGORY_B)
                        },
                        TYPE_EI
                ),
                new Question(
                        "Are you more frequently:",
                        new Answer[]{
                                new Answer("a practical sort of person", CATEGORY_A),
                                new Answer("a fanciful sort of person", CATEGORY_B)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Are you more likely to:",
                        new Answer[]{
                                new Answer("see how others are useful", CATEGORY_A),
                                new Answer("see how others see", CATEGORY_B)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Which is more satisfying:",
                        new Answer[]{
                                new Answer("to discuss an issue thoroughly", CATEGORY_A),
                                new Answer("to arrive at agreement on an issue", CATEGORY_B)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Which rules you more:",
                        new Answer[]{
                                new Answer("your head", CATEGORY_A),
                                new Answer("your heart", CATEGORY_B)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Are you more comfortable with work that is:",
                        new Answer[]{
                                new Answer("contracted", CATEGORY_A),
                                new Answer("done on a casual basis", CATEGORY_B)
                        },
                        TYPE_JP
                ),
                new Question(
                        "Do you tend to look for:",
                        new Answer[]{
                                new Answer("the orderly", CATEGORY_A),
                                new Answer("whatever turns up", CATEGORY_B)
                        },
                        TYPE_JP
                ),
                new Question(
                        "Do you prefer:",
                        new Answer[]{
                                new Answer("many friends with brief contact", CATEGORY_A),
                                new Answer("a few friends with more lengthy contact", CATEGORY_B)
                        },
                        TYPE_EI
                ),
                new Question(
                        "Do you go more by:",
                        new Answer[]{
                                new Answer("facts", CATEGORY_A),
                                new Answer("principles", CATEGORY_B)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Are you more interested in:",
                        new Answer[]{
                                new Answer("production and distribution", CATEGORY_A),
                                new Answer("design and research", CATEGORY_B)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Which is more of a compliment:",
                        new Answer[]{
                                new Answer("\"There is a very logical person.\"", CATEGORY_A),
                                new Answer("\"There is a very sentimental person.\"", CATEGORY_B)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Do you value in yourself more that you are:",
                        new Answer[]{
                                new Answer("unwavering", CATEGORY_A),
                                new Answer("devoted", CATEGORY_B)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Do you more often prefer the",
                        new Answer[]{
                                new Answer("final and unalterable statement", CATEGORY_A),
                                new Answer("tentative and preliminary statement", CATEGORY_B)
                        },
                        TYPE_JP
                ),
                new Question(
                        "Are you more comfortable:",
                        new Answer[]{
                                new Answer("after a decision", CATEGORY_A),
                                new Answer("before a decision", CATEGORY_B)
                        },
                        TYPE_JP
                ),
                new Question(
                        "Do you:",
                        new Answer[]{
                                new Answer("speak easily and at length with strangers", CATEGORY_A),
                                new Answer("find little to say to strangers", CATEGORY_B)
                        },
                        TYPE_EI
                ),
                new Question(
                        "Are you more likely to trust your:",
                        new Answer[]{
                                new Answer("experience", CATEGORY_A),
                                new Answer("hunch", CATEGORY_B)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Do you feel:",
                        new Answer[]{
                                new Answer("more practical than ingenious", CATEGORY_A),
                                new Answer("more ingenious than practical", CATEGORY_B)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Which person is more to be complimented, one of:",
                        new Answer[]{
                                new Answer("clear reason", CATEGORY_A),
                                new Answer("strong feeling ", CATEGORY_B)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Are you inclined more to be:",
                        new Answer[]{
                                new Answer("fair-minded", CATEGORY_A),
                                new Answer("sympathetic", CATEGORY_B)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Is it preferable mostly to:",
                        new Answer[]{
                                new Answer("make sure things are arranged", CATEGORY_A),
                                new Answer("just let things happen", CATEGORY_B)
                        },
                        TYPE_JP
                ),
                new Question(
                        "In relationships should most things be:",
                        new Answer[]{
                                new Answer("re-negotiable", CATEGORY_A),
                                new Answer("random and circumstantial", CATEGORY_B)
                        },
                        TYPE_JP
                ),
                new Question(
                        "When the phone rings do you:",
                        new Answer[]{
                                new Answer("hasten to get to it first", CATEGORY_A),
                                new Answer("hope someone else will answer", CATEGORY_B)
                        },
                        TYPE_EI
                ),
                new Question(
                        "Do you prize more in yourself:",
                        new Answer[]{
                                new Answer("a strong sense of reality", CATEGORY_A),
                                new Answer("a vivid imagination", CATEGORY_B)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Are you drawn more to:",
                        new Answer[]{
                                new Answer("fundamentals", CATEGORY_A),
                                new Answer("overtones", CATEGORY_B)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Which seems the greater error:",
                        new Answer[]{
                                new Answer("to be too passionate", CATEGORY_A),
                                new Answer("to be too objective", CATEGORY_B)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Do you see yourself as basically:",
                        new Answer[]{
                                new Answer("hard-headed", CATEGORY_A),
                                new Answer("soft-hearted", CATEGORY_B)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Which situation appeals to you more:",
                        new Answer[]{
                                new Answer("the structured and scheduled", CATEGORY_A),
                                new Answer("the unstructured and unscheduled", CATEGORY_B)
                        },
                        TYPE_JP
                ),
                new Question(
                        "Are you a person that is more:",
                        new Answer[]{
                                new Answer("routinized than whimsical", CATEGORY_A),
                                new Answer("whimsical than routinized", CATEGORY_B)
                        },
                        TYPE_JP
                ),
                new Question(
                        "Are you more inclined to be:",
                        new Answer[]{
                                new Answer("easy to approach", CATEGORY_A),
                                new Answer("somewhat reserved", CATEGORY_B)
                        },
                        TYPE_EI
                ),
                new Question(
                        "In writings do you prefer:",
                        new Answer[]{
                                new Answer("the more literal", CATEGORY_A),
                                new Answer("the more figurative", CATEGORY_B)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Is it harder for you to:",
                        new Answer[]{
                                new Answer("identify with others", CATEGORY_A),
                                new Answer("utilize others", CATEGORY_B)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Which do you wish more for yourself:",
                        new Answer[]{
                                new Answer("clarity of reason", CATEGORY_A),
                                new Answer("strength of compassion", CATEGORY_B)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Which is the greater fault:",
                        new Answer[]{
                                new Answer("being indiscriminate", CATEGORY_A),
                                new Answer("being critical", CATEGORY_B)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Do you prefer the:",
                        new Answer[]{
                                new Answer("planned event", CATEGORY_A),
                                new Answer("unplanned event", CATEGORY_B)
                        },
                        TYPE_JP
                ),
                new Question(
                        "Do you tend to be more:",
                        new Answer[]{
                                new Answer("deliberate than spontaneous", CATEGORY_A),
                                new Answer("spontaneous than deliberate ", CATEGORY_B)
                        },
                        TYPE_JP
                )
        ));
    }

    public String getName() {
        return "MyersBriggsQuiz";
    }

    public String getResult()
    {
        int idxE = MyersBriggsQuiz.CATEGORY_A * 4 + MyersBriggsQuiz.TYPE_EI;
        int idxI = MyersBriggsQuiz.CATEGORY_B * 4 + MyersBriggsQuiz.TYPE_EI;
        int idxS = MyersBriggsQuiz.CATEGORY_A * 4 + MyersBriggsQuiz.TYPE_SN;
        int idxN = MyersBriggsQuiz.CATEGORY_B * 4 + MyersBriggsQuiz.TYPE_SN;
        int idxT = MyersBriggsQuiz.CATEGORY_A * 4 + MyersBriggsQuiz.TYPE_TF;
        int idxF = MyersBriggsQuiz.CATEGORY_B * 4 + MyersBriggsQuiz.TYPE_TF;
        int idxJ = MyersBriggsQuiz.CATEGORY_A * 4 + MyersBriggsQuiz.TYPE_JP;
        int idxP = MyersBriggsQuiz.CATEGORY_B * 4 + MyersBriggsQuiz.TYPE_JP;

        StringBuilder sb = new StringBuilder()
                .append(results[idxE] > results[idxI] ? "E" : "I")
                .append(results[idxS] > results[idxN] ? "S" : "N")
                .append(results[idxT] > results[idxF] ? "T" : "F")
                .append(results[idxJ] > results[idxP] ? "J" : "P");

        return sb.toString();
    }

    public void recordResponse(QuizQuestion q, QuizEntity a)
    {
        Question question = (Question)q;
        Answer answer = (Answer)a;
        results[answer.category * 4 + question.type] += 1;
    }

    public void resetResults()
    {
        // Reset the results to 0
        results = new int[2 * 4];
        for (int i = 0; i < results.length; i++) {
            results[i] = 0;
        }
    }

    public Question getQuestion() {
        return (MyersBriggsQuiz.Question) questionList.get(currQuestion);
    }

    public int getCurrQuestion() {
        return currQuestion + 1;
    }

    public void nextQuestion(){
        currQuestion++;
    }

}
