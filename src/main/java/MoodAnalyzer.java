public class MoodAnalyzer
{
    private  String message;
    public MoodAnalyzer()
    {
    }

    public  MoodAnalyzer(String message)
    {
        this.message=message;
    }

    public String analyzeMood(String message) throws MoodAnalysisException
    {
        this.message=message;
        return analyzeMood();
    }
    public String analyzeMood() throws MoodAnalysisException
    {
        try
        {
            if (message.contains("Sad"))
                return "SAD";
            return "Happy";
        }
        catch(NullPointerException e)
        {
            return "HAPPY";
        }
    }

    public boolean equals(MoodAnalyzer another)
    {
        if(this.message.equals(((MoodAnalyzer)another).message))
            return true;
        return false;
    }
}
