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

    public String analyzeMood(String message)
    {
        this.message=message;
        return analyzeMood();
    }
    public String analyzeMood()
    {
        if (message.contains("Sad"))
             return "SAD";
        else
            return "HAPPY";
    }
}
