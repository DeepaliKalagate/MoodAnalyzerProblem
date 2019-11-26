import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoodAnalyzerTest
{
    //UseCase One Should Return Happy Or Sad Mood
    @Test
    public void giveMessage_WhenSadOrHappy_ShouldReturnSadOrHappy()
    {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String mood = null;
        try
        {
            mood = moodAnalyzer.analyzeMood("I am in a Sad Mood");
        }
        catch (MoodAnalysisException e)
        {
            e.printStackTrace();
        }
        Assert.assertEquals("SAD", mood);
    }

    //UseCase One Should Return Sad Mood
    @Test
    public void giveMessage_WhenSad_ShouldReturnSad()
    {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer();
        String mood= null;
        try
        {
            mood = moodAnalyzer.analyzeMood("I am in a Sad Mood");
        }
        catch (MoodAnalysisException e)
        {
            e.printStackTrace();
        }
        Assert.assertEquals("SAD",mood);
    }

    //UseCase One Should Return Happy Mood
    @Test
    public void giveMessageAny__ShouldReturnHappy()
    {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer();
        String mood= null;
        try
        {
            mood = moodAnalyzer.analyzeMood("I am in a Any Mood");
        }
        catch (MoodAnalysisException e)
        {
            e.printStackTrace();
        }
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void giveMessage_whenProper_ShouldReturnHappy()
    {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer();
        String mood= null;
        try
        {
            mood = moodAnalyzer.analyzeMood();
        }
        catch (MoodAnalysisException e)
        {
            e.printStackTrace();
        }
        Assert.assertEquals("Happy",mood);
    }

    //Constructor Should Return Sad Mood
    @Test
    public void givenMessage_WhenSad_ShouldReturnSad()
    {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Sad Mood");
        String mood = null;
        try
        {
            mood = moodAnalyzer.analyzeMood();
        }
        catch (MoodAnalysisException e)
        {
            e.printStackTrace();
        }
        Assert.assertEquals("SAD", mood);
    }

    //Constructor Should Return Sad Mood
    @Test
    public void givenMessageHappy_ShouldReturnSad()
    {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer("I am in a Happy Mood");
        String mood= null;
        try
        {
            mood = moodAnalyzer.analyzeMood();
        }
        catch (MoodAnalysisException e)
        {
            e.printStackTrace();
        }
        Assert.assertEquals("SAD",mood);
    }

    //Handling Mood Analysis Exception
    @Test
    public void moodAnalyzer_MoodException()
    {
        MoodAnalyzer moodAnalyzer= null;
        moodAnalyzer = new MoodAnalyzer();
        String mood= null;
        try
        {
            ExpectedException exceptionRule=ExpectedException.none();
            exceptionRule.expect(MoodAnalysisException.class);
            mood = moodAnalyzer.analyzeMood(null);
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals("Please enter proper message",e.getMessage());
        }
    }

    //Using Enum Should Return  Exception Message
    @Test
    public void givenEmptyMood_ShouldThrowException()
    {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer();
        try
        {
            moodAnalyzer.analyzeMood();
        }
        catch(MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_EMPTY,e.type);
        }
    }

    @Test
    public void givenNullMood_ShouldThrowException()
    {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer(null);
        try
        {
            moodAnalyzer.analyzeMood(null);
        }
        catch(MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_NULL,e.type);
        }
    }

    //Created Object of MoodAnalyzer Using MoodAnalyzerFactory
    @Test
    public void givenMoodAnalyzerClass_WhenProper_ShouldReturnObjectEquals()
    {
        try
        {
            MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer("I am in a Happy Mood");
            boolean res = moodAnalyzer.equals(moodAnalyzer);
            Assert.assertTrue(res);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
