import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest
{
    //UseCase One Should Return Happy Or Sad Mood
    @Test
    public void giveMessage_WhenSadOrHappy_ShouldReturnSadOrHappy()
    {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String mood = moodAnalyzer.analyzeMood("I am in a Sad Mood");
        Assert.assertEquals("SAD", mood);
    }

    //UseCase One Should Return Sad Mood
    @Test
    public void giveMessage_WhenSad_ShouldReturnSad()
    {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer();
        String mood=moodAnalyzer.analyzeMood("I am in a Sad Mood");
        Assert.assertEquals("SAD",mood);
    }

    //UseCase One Should Return Happy Mood
    @Test
    public void giveMessageAny__ShouldReturnHappy()
    {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer();
        String mood=moodAnalyzer.analyzeMood("I am in a Any Mood");
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void giveMessage_whenProper_ShouldReturnHappy()
    {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer();
        String mood=moodAnalyzer.analyzeMood();
        Assert.assertEquals("Happy",mood);
    }
}
