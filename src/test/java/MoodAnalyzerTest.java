import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest
{
    @Test
    public void giveMessage_WhenSadOrHappy_ShouldReturnSadOrHappy()
    {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String mood = moodAnalyzer.analyzeMood("I am in a Sad Mood");
        Assert.assertEquals("SAD", mood);
    }
}
